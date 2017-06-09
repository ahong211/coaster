package com.coaster.android.coaster;

import android.app.Activity;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDrinkFragment extends Fragment implements View.OnClickListener {

    // TODO: 6/8/2017 Convert CustomDrinksListFragment to regular activity
    // todo create interface to communicate from fragment to fragment - create it inside fragment with data to pass
    // TODO: 6/8/2017 Connect form to firebase
    // TODO: 6/8/2017 Load firebase data to card view
    // TODO: 6/8/2017 Database calls on service
    // TODO: 6/8/2017 populate recyclerview in CustomDrinkListFragment with cardviews
    // TODO: 6/8/2017 Add share functionality

    FirebaseDatabase customDatabase;
    String topNode = "custom_drinks";
    DatabaseReference customDrinkReference;
    CustomDrinkRecipe customDrinkRecipe = new CustomDrinkRecipe();
    private static final String LOG_TAG = "MAC_TAG";

    @BindView(R.id.name_edit_text) EditText nameEditText;
    @BindView(R.id.ingredient_edit_text) EditText ingredientEditText;
    @BindView(R.id.instruction_edit_text) EditText instructionEditText;
    @BindView(R.id.save_custom_drink) Button saveCustomDrink;

    public CustomDrinkFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_drink, container, false);
        ButterKnife.bind(this, view);

        return view;
    }

    @OnClick(R.id.save_custom_drink)
    @Override
    public void onClick(View v) {
        customDatabase = FirebaseDatabase.getInstance();
        customDrinkReference = customDatabase.getReference(topNode);
        String mKey = customDrinkReference.push().getKey();
        customDrinkRecipe.setDrinkId(mKey);
        customDrinkRecipe.setDrinkName(nameEditText.getText().toString());
        customDrinkRecipe.setIngredient(ingredientEditText.getText().toString());
        customDrinkRecipe.setInstruction(instructionEditText.getText().toString());
        customDrinkReference.child(mKey).setValue(customDrinkRecipe);

    }
}


//    public ArrayList<String> getCustomDrinksDataList() {
//        return customDrinksDataList;
//    }
// private String albumName = "drink_files";
// File saveDrinkFilePath;
// ArrayList<String> customDrinksDataList;
// String dataString = "Custom Drink Recipe: ";
// Need to check if media is still available because it could have been moved or deleted by user
//    public boolean isExternalStorageReadable() {
//        String state = Environment.getExternalStorageState();
//        return Environment.MEDIA_MOUNTED.equals(state) ||
//                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state);
//    }
//
//    // Method for creating new file names
//    private String createNewFile() {
//        return nameEditText.getText().toString() + ".txt";
//    }
//
//    // method to get path to drink files
//    public File getDrinkFileStorageDir(Context context) {
//        // get path to external files directory
//        return context.getExternalFilesDir(Environment.DIRECTORY_DOCUMENTS);
//    }
// if (isExternalStorageReadable()) {
//            //to this path add a new directory path and create new App dir in /documents Dir
//
//            File appDirectory = new File(getDrinkFileStorageDir(getContext()).getAbsolutePath() + albumName);
//
//            if (!getDrinkFileStorageDir(getContext()).mkdirs()) {
//                Log.e(LOG_TAG, "Directory not created");
//            }
//            //Create a File for the output file data
//            saveDrinkFilePath = new File(appDirectory, createNewFile());
//            try {
//                String newline = "\r\n";
//                FileOutputStream fileOutputStream = new FileOutputStream(saveDrinkFilePath);
//                OutputStreamWriter OutDataWriter = new OutputStreamWriter(fileOutputStream);
//                OutDataWriter.write(nameEditText.getText().toString() + newline);
//                OutDataWriter.write(ingredientEditText.getText().toString() + newline);
//                OutDataWriter.write(instructionEditText.getText().toString() + newline);
//                OutDataWriter.close();
//                fileOutputStream.flush();
//                fileOutputStream.close();
//                Toast.makeText(getContext(), "Custom drink saved", Toast.LENGTH_SHORT).show();
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            if (saveDrinkFilePath != null) {
//                try {
//                    FileInputStream fileInputStream = new FileInputStream(saveDrinkFilePath);
//                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
//                    BufferedReader bufferReader = new BufferedReader(new InputStreamReader(dataInputStream));
//                    String readLine;
//                    customDrinksDataList = new ArrayList<>();
//                    while ((readLine = bufferReader.readLine()) != null) {
//                        dataString = dataString + " " + readLine;
//                    }
//                    customDrinksDataList.add(dataString);
//                    Log.e(LOG_TAG, "onClick: " + customDrinksDataList);
//                    dataInputStream.close();
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        passData = new CustomDrinksListFragment();
