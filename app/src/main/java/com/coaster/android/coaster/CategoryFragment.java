package com.coaster.android.coaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.storage.StorageReference;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CategoryFragment extends Fragment {

    private static final String TAG = CategoryFragment.class.getSimpleName() + "_TAG";

    @BindView(R.id.gin_button)
    ImageView ginButton;

    @BindView(R.id.rum_button)
    ImageView rumButton;

    @BindView(R.id.tequila_button)
    ImageView tequilaButton;

    @BindView(R.id.vodka_button)
    ImageView vodkaButton;

    @BindView(R.id.whiskey_button)
    ImageView whiskeyButton;

    @BindView(R.id.mixed_button)
    ImageView mixedButton;

    @BindView(R.id.custom_drinks_button)
    Button customDrinksButton;

    FragmentManager manager = getFragmentManager();
    DrinksFragment drinksFrag = new DrinksFragment();
    private StorageReference storageReference;

    @Inject
    public CategoryFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_category, container, false);

//        ginButton = (ImageView) view.findViewById(R.id.gin_button);
//        rumButton = (ImageView) view.findViewById(R.id.rum_button);
//        tequilaButton = (ImageView) view.findViewById(R.id.tequila_button);
//        vodkaButton = (ImageView) view.findViewById(R.id.vodka_button);
//        whiskeyButton = (ImageView) view.findViewById(R.id.whiskey_button);
//        mixedButton = (ImageView) view.findViewById(R.id.mixed_button);
//        customDrinksButton = (Button) view.findViewById(R.id.custom_drinks_button);

        ButterKnife.bind(this, view);

        //storageReference = FirebaseStorage.getInstance().getReference();
        //StorageReference imageReference = storageReference.child("Images");

        /* This is for saving images to firebase storage.
            saveImageToStorage(imageReference, image_button);
        */

//        customDrinksButton.setOnClickListener(this);
//        ginButton.setOnClickListener(this);
//        rumButton.setOnClickListener(this);
//        tequilaButton.setOnClickListener(this);
//        vodkaButton.setOnClickListener(this);
//        whiskeyButton.setOnClickListener(this);
//        mixedButton.setOnClickListener(this);

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

    @OnClick({R.id.vodka_button, R.id.whiskey_button, R.id.tequila_button, R.id.rum_button,
            R.id.gin_button, R.id.mixed_button, R.id.custom_drinks_button})
    public void onDrinksCategoryButtonClicked(View v) {

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

            case R.id.tequila_button:

                ButtonPress tequilaPress = (ButtonPress) getActivity();
                tequilaPress.drinkButtonPress();
                tequilaPress.tequilaStringKey();

                break;

            case R.id.rum_button:

                ButtonPress rumPress = (ButtonPress) getActivity();
                rumPress.drinkButtonPress();
                rumPress.rumStringKey();

                break;

            case R.id.gin_button:

                ButtonPress ginPress = (ButtonPress) getActivity();
                ginPress.drinkButtonPress();
                ginPress.ginStringKey();

                break;

            case R.id.mixed_button:

                ButtonPress mixedDrinkPress = (ButtonPress) getActivity();
                mixedDrinkPress.drinkButtonPress();
                mixedDrinkPress.mixedDrinkStringKey();

                break;

            case R.id.custom_drinks_button:

                Intent loadCustomList = new Intent(getContext(), CustomDrinkListActivity.class);
                startActivity(loadCustomList);

                break;
        }
    }
}