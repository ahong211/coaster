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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CustomDrinkFragment extends Fragment implements View.OnClickListener {

    private String albumName = "drink_files";
    private static final String LOG_TAG = "MAC_TAG";
    // TODO: 5/31/2017 convert saved text file to pojo then build recycler view
    // TODO: 5/30/2017 create recyclerview with list of custom drinks read from external storage


    EditText nameEditText;
    EditText ingredientEditText;
    EditText instructionEditText;
    Button saveCustomDrink;

    public CustomDrinkFragment() {
        // Required empty public constructor
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
            // appDirectory.mkdirs();
            if (!getDrinkFileStorageDir(getContext()).mkdirs()) {
                Log.e(LOG_TAG, "Directory not created");
            }
            //Create a File for the output file data
            File saveDrinkFilePath = new File(appDirectory, createNewFile());
            try {
                String newline = "\r\n";
                FileOutputStream fileOutputStream = new FileOutputStream(saveDrinkFilePath);
                OutputStreamWriter OutDataWriter = new OutputStreamWriter(fileOutputStream);
                OutDataWriter.write(nameEditText.getText() + newline);
                OutDataWriter.write(ingredientEditText.getText() + newline);
                OutDataWriter.write(instructionEditText.getText() + newline);
                OutDataWriter.close();
                fileOutputStream.flush();
                fileOutputStream.close();

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
