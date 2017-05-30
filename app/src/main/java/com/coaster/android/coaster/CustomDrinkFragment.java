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

public class CustomDrinkFragment extends Fragment implements View.OnClickListener {

    private static final String LOG_TAG = "MAC_TAG";
    // TODO: 5/30/2017 convert input from edit text to text file
    // TODO: 5/30/2017 create recyclerview with list of custom drinks read from external storage
    // TODO: 5/30/2017 connect cust drink frag to main act
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

    //    FileWriter openFileWriter(String fileName, int mode) throws IOException {
//
//        return new FileWriter(fileName);
//    }


    public File getDrinkFileStorageDir(Context context, String albumName) {

        File file = new File(context.getExternalFilesDir(
                Environment.DIRECTORY_DOCUMENTS), albumName);
        if (!file.mkdirs()) {
            Log.e(LOG_TAG, "Directory not created");
        }
        return file;
    }

    @Override
    public void onClick(View v) {

        if (isExternalStorageReadable() == true) {

            getDrinkFileStorageDir(getContext(), "drink_files");
            // TODO: 5/30/2017 save Strings from custom drink to text file

        }

    }
}
