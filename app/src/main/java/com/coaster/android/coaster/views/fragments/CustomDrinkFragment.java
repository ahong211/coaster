package com.coaster.android.coaster.views.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coaster.android.coaster.R;
import com.coaster.android.coaster.components.CustomDrinkRecipeComponent;
import com.coaster.android.coaster.components.DaggerCustomDrinkRecipeComponent;
import com.coaster.android.coaster.models.CustomDrinkRecipe;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDrinkFragment extends Fragment {

    // TODO: 6/11/2017 Add delete button 
    // TODO: 6/11/2017 add image capture 
    // TODO: 6/8/2017 Database calls on service
    // TODO: 6/8/2017 Add share functionality

    private static final String LOG_TAG = "MAC_TAG";
    public FirebaseDatabase customDatabase;
    public String topNode = "custom_drinks";
    public DatabaseReference customDrinkReference;
    public CustomDrinkRecipe customDrinkRecipe;

    @BindView(R.id.name_edit_text)
    EditText nameEditText;

    @BindView(R.id.ingredient_edit_text)
    EditText ingredientEditText;

    @BindView(R.id.instruction_edit_text)
    EditText instructionEditText;

    @BindView(R.id.save_custom_drink)
    Button saveCustomDrink;

    @Inject
    public CustomDrinkFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_custom_drink, container, false);
        ButterKnife.bind(this, view);

        CustomDrinkRecipeComponent recipeComponent = DaggerCustomDrinkRecipeComponent.create();
        customDrinkRecipe = recipeComponent.getCustomDrinkRecipe();

        return view;
    }

    @OnClick(R.id.save_custom_drink)
    public void onSaveCustomDrinkClick(View v) {
        customDatabase = FirebaseDatabase.getInstance();
        customDrinkReference = customDatabase.getReference(topNode);
        String mKey = customDrinkReference.push().getKey();

        customDrinkRecipe.setDrinkId(mKey);
        customDrinkRecipe.setDrinkName(nameEditText.getText().toString());
        customDrinkRecipe.setIngredient(ingredientEditText.getText().toString());
        customDrinkRecipe.setInstruction(instructionEditText.getText().toString());

        customDrinkReference.child(mKey).setValue(customDrinkRecipe);

        Toast.makeText(v.getContext(), "Drink Saved!", Toast.LENGTH_SHORT).show();
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getDrinkId());
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getDrinkName());
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getInstruction());
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getIngredient());
    }
}
