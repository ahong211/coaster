package com.coaster.android.coaster;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class CustomDrinkFragment extends Fragment implements View.OnClickListener {

    private String albumName = "drink_files";
    private static final String LOG_TAG = "MAC_TAG";

    File saveDrinkFilePath;
    ArrayList<String> customDrinksDataList;
    String dataString = "Custom Drink Recipe: ";

    CustomDrinksListFragment passData;

    EditText nameEditText;
    EditText ingredientEditText;
    EditText instructionEditText;
    Button saveCustomDrink;

    public CustomDrinkFragment() {
        // Required empty public constructor
    }

    public ArrayList<String> getCustomDrinksDataList() {
        return customDrinksDataList;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_drink, container, false);

        nameEditText = (EditText) view.findViewById(R.id.name_edit_text);
        ingredientEditText = (EditText) view.findViewById(R.id.ingredient_edit_text);
        instructionEditText = (EditText) view.findViewById(R.id.instruction_edit_text);
        saveCustomDrink = (Button) view.findViewById(R.id.save_custom_drink);

        saveCustomDrink.setOnClickListener(this);

        return view;
    }

    // Need to check if media is still available because it could have been moved or deleted by user
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }

        return false;
    }

    // Method for creating new file names
    private String createNewFile() {
        StringBuilder nameBuilder = new StringBuilder();

        nameBuilder.append(nameEditText.getText().toString());
        nameBuilder.append(".txt");

        String drinkFileName = nameBuilder.toString();

        return drinkFileName;
    }

    // method to get path to drink files
    public File getDrinkFileStorageDir(Context context) {
        // get path to external files directory
        File pathToExternalFilesDir = context.getExternalFilesDir(
                Environment.DIRECTORY_DOCUMENTS);
        return pathToExternalFilesDir;
    }

    @Override
    public void onClick(View v) {

        if (isExternalStorageReadable() == true) {
            //to this path add a new directory path and create new App dir in /documents Dir
            File appDirectory = new File(getDrinkFileStorageDir(getContext()).getAbsolutePath() + albumName);

            if (!getDrinkFileStorageDir(getContext()).mkdirs()) {
                Log.e(LOG_TAG, "Directory not created");
            }
            //Create a File for the output file data
            saveDrinkFilePath = new File(appDirectory, createNewFile());
            try {
                String newline = "\r\n";
                FileOutputStream fileOutputStream = new FileOutputStream(saveDrinkFilePath);
                OutputStreamWriter OutDataWriter = new OutputStreamWriter(fileOutputStream);
                OutDataWriter.write(nameEditText.getText().toString() + newline);
                OutDataWriter.write(ingredientEditText.getText().toString() + newline);
                OutDataWriter.write(instructionEditText.getText().toString() + newline);
                OutDataWriter.close();
                fileOutputStream.flush();
                fileOutputStream.close();
                Toast.makeText(getContext(), "Custom drink saved", Toast.LENGTH_SHORT).show();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (saveDrinkFilePath != null) {
                try {
                    FileInputStream fileInputStream = new FileInputStream(saveDrinkFilePath);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    BufferedReader bufferReader = new BufferedReader(new InputStreamReader(dataInputStream));
                    String readLine;
                    customDrinksDataList = new ArrayList<>();
                    while ((readLine = bufferReader.readLine()) != null) {
                        dataString = dataString + " " + readLine;
                    }
                    customDrinksDataList.add(dataString);
                    Log.e(LOG_TAG, "onClick: " + customDrinksDataList);
                    dataInputStream.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        passData = new CustomDrinksListFragment();
    }
}
