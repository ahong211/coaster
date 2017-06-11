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

    // TODO: 6/8/2017 Load firebase data to card view
    // TODO: 6/8/2017 Database calls on service
    // TODO: 6/8/2017 populate recyclerview in CustomDrinkListFragment with cardviews
    // TODO: 6/8/2017 Add share functionality

    FirebaseDatabase customDatabase;
    String topNode = "custom_drinks";
    DatabaseReference customDrinkReference;
    CustomDrinkRecipe customDrinkRecipe = new CustomDrinkRecipe();
    private static final String LOG_TAG = "MAC_TAG";

    @BindView(R.id.name_edit_text)
    EditText nameEditText;
    @BindView(R.id.ingredient_edit_text)
    EditText ingredientEditText;
    @BindView(R.id.instruction_edit_text)
    EditText instructionEditText;

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
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getDrinkId());
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getDrinkName());
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getInstruction());
        Log.d(LOG_TAG, "onClick: " + customDrinkRecipe.getIngredient());

    }
}
