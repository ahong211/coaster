package com.coaster.android.coaster;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.firebase.storage.StorageReference;

public class CategoryFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = CategoryFragment.class.getSimpleName() + "_TAG";

    ImageView ginButton;
    ImageView rumButton;
    ImageView tequilaButton;
    ImageView vodkaButton;
    ImageView whiskeyButton;

    Button customDrinksButton;
    FragmentManager manager = getFragmentManager();
    DrinksFragment drinksFrag = new DrinksFragment();
    private StorageReference storageReference;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        ginButton = (ImageView) view.findViewById(R.id.gin_button);
        rumButton = (ImageView) view.findViewById(R.id.rum_button);
        tequilaButton = (ImageView) view.findViewById(R.id.tequila_button);
        vodkaButton = (ImageView) view.findViewById(R.id.vodka_button);
        whiskeyButton = (ImageView) view.findViewById(R.id.whiskey_button);
        customDrinksButton = (Button) view.findViewById(R.id.custom_drinks_button);

        //storageReference = FirebaseStorage.getInstance().getReference();
        //StorageReference imageReference = storageReference.child("Images");

        /* This is for saving images to firebase storage.
            saveImageToStorage(imageReference, image_button);
        */

        customDrinksButton.setOnClickListener(this);
        ginButton.setOnClickListener(this);
        rumButton.setOnClickListener(this);
        tequilaButton.setOnClickListener(this);
        vodkaButton.setOnClickListener(this);
        whiskeyButton.setOnClickListener(this);

        return view;
    }

//    private void saveImageToStorage(StorageReference imageReference, ImageView img) {
//        StorageReference reference = imageReference.child("gin.png");
//        byte[] data = convertImageToBytes(img);
//        uploadImageToStorage(reference, data);
//    }
//
//    private byte[] convertImageToBytes(ImageView img) {
//        int qualityOfImage = 100;
//        img.setDrawingCacheEnabled(true);
//        img.buildDrawingCache();
//
//        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
//        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, qualityOfImage, arrayOutputStream);
//
//        return arrayOutputStream.toByteArray();
//    }
//
//    private void uploadImageToStorage(StorageReference reference, byte[] data) {
//        UploadTask task = reference.putBytes(data);
//        task.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                // Handle unsuccessful uploads.
//            }
//
//        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                // Handle successful uploads.
//            }
//
//        });
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.vodka_button:

                ButtonPress vodkaPress = (ButtonPress) getActivity();
                vodkaPress.drinkButtonPress();
                vodkaPress.vodkaStringKey();

                break;

            case R.id.whiskey_button:

                ButtonPress whiskeyPress = (ButtonPress) getActivity();
                whiskeyPress.drinkButtonPress();
                whiskeyPress.whiskeyStringKey();

                break;

            case R.id.custom_drinks_button:

                ButtonPress customDrinksListPress = (ButtonPress) getActivity();
                customDrinksListPress.customDrinksListButtonPress();

                break;
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.options_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.search:

                Toast.makeText(getContext(), "Search works", Toast.LENGTH_SHORT).show();

                break;
        }

        return false;
    }
}