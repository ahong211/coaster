package com.coaster.android.coaster;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.ByteArrayOutputStream;

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

        storageReference = FirebaseStorage.getInstance().getReference();
        StorageReference imageReference = storageReference.child("Images");

        ginButton = (ImageView) view.findViewById(R.id.gin_button);
        rumButton = (ImageView) view.findViewById(R.id.rum_button);
        tequilaButton = (ImageView) view.findViewById(R.id.tequila_button);
        vodkaButton = (ImageView) view.findViewById(R.id.vodka_button);
        whiskeyButton = (ImageView) view.findViewById(R.id.whiskey_button);
        customDrinksButton = (Button) view.findViewById(R.id.custom_drinks_button);

        saveGinImageToStorage(imageReference, ginButton);
        saveRumImageToStorage(imageReference, rumButton);
        saveTequilaImageToStorage(imageReference, tequilaButton);
        saveVodkaImageToStorage(imageReference, vodkaButton);
        saveWhiskeyImageToStorage(imageReference, whiskeyButton);

        // TODO: Add mixed drink image to Firebase Storage.

        customDrinksButton.setOnClickListener(this);
        ginButton.setOnClickListener(this);
        rumButton.setOnClickListener(this);
        tequilaButton.setOnClickListener(this);
        vodkaButton.setOnClickListener(this);
        whiskeyButton.setOnClickListener(this);

        return view;
    }

    private void saveGinImageToStorage(StorageReference imageReference, ImageView gin) {
        StorageReference ginReference = imageReference.child("gin.png");
        byte[] data = convertImageToBytes(gin);
        uploadImageToStorage(ginReference, data);
    }

    private void saveRumImageToStorage(StorageReference imageReference, ImageView rum) {
        StorageReference rumReference = imageReference.child("rum.png");
        byte[] data = convertImageToBytes(rum);
        uploadImageToStorage(rumReference, data);
    }

    private void saveTequilaImageToStorage(StorageReference imageReference, ImageView tequila) {
        StorageReference tequilaReference = imageReference.child("tequila.png");
        byte[] data = convertImageToBytes(tequila);
        uploadImageToStorage(tequilaReference, data);
    }

    private void saveVodkaImageToStorage(StorageReference imageReference, ImageView vodka) {
        StorageReference vodkaReference = imageReference.child("vodkatransparent.png");
        byte[] data = convertImageToBytes(vodka);
        uploadImageToStorage(vodkaReference, data);
    }

    private void saveWhiskeyImageToStorage(StorageReference imageReference, ImageView whiskey) {
        StorageReference whiskeyReference = imageReference.child("whiskey.png");
        byte[] data = convertImageToBytes(whiskey);
        uploadImageToStorage(whiskeyReference, data);
    }

    private byte[] convertImageToBytes(ImageView img) {
        int qualityOfImage = 100;
        img.setDrawingCacheEnabled(true);
        img.buildDrawingCache();

        Bitmap bitmap = ((BitmapDrawable) img.getDrawable()).getBitmap();
        ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, qualityOfImage, arrayOutputStream);

        return arrayOutputStream.toByteArray();
    }

    private void uploadImageToStorage(StorageReference reference, byte[] data) {
        UploadTask task = reference.putBytes(data);
        task.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                // Handle unsuccessful uploads.
            }

        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // Handle successful uploads.
            }

        });
    }

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
}