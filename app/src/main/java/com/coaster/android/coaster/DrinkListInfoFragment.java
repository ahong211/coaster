package com.coaster.android.coaster;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DrinkListInfoFragment extends Fragment {

    private static final String TAG = DrinkListInfoFragment.class.getSimpleName() + "_TAG";
    String drinkName;
    TextView drinkNameTextView;
    TextView drinkDescTextView;
    TextView ingred1TextView;
    TextView ingred2TextView;
    TextView ingred3TextView;
    TextView ingred4TextView;
    TextView ingred5TextView;
    TextView prepTextView;
    DatabaseReference drinkRef;
    List<Cocktail> drinkCocktail = new ArrayList<>();
    String topNode;

    public DrinkListInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drink_list_info, container, false);

        drinkNameTextView = (TextView) view.findViewById(R.id.drinkName_TextView);
        drinkDescTextView = (TextView) view.findViewById(R.id.drinkDesc_TextView);

        ingred1TextView = (TextView) view.findViewById(R.id.ingred1_TextView);
        ingred2TextView = (TextView) view.findViewById(R.id.ingred2_TextView);
        ingred3TextView = (TextView) view.findViewById(R.id.ingred3_TextView);
        ingred4TextView = (TextView) view.findViewById(R.id.ingred4_TextView);
        ingred5TextView = (TextView) view.findViewById(R.id.ingred5_TextView);
        prepTextView = (TextView) view.findViewById(R.id.preparation_TextView);

        drinkRef = FirebaseDatabase.getInstance().getReference(topNode);
        Query searchDrinkName = drinkRef.orderByChild("name").equalTo(drinkName);

        callDrinkQuery(searchDrinkName);

        return view;
    }

    private void callDrinkQuery(final Query drink) {
        drink.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    Cocktail value = dataSnap.getValue(Cocktail.class);
                    Log.d(TAG, "onDataChange: " + value.getName());

                    drinkCocktail.add(value);

                }

                drinkNameTextView.setText(drinkCocktail.get(0).getName());
                drinkDescTextView.setText(drinkCocktail.get(0).getDescription());
                ingred1TextView.setText(drinkCocktail.get(0).getMeasure1() + drinkCocktail.get(0).getIngred1());
                ingred2TextView.setText(drinkCocktail.get(0).getMeasure2() + drinkCocktail.get(0).getIngred2());
                ingred3TextView.setText(drinkCocktail.get(0).getMeasure3() + drinkCocktail.get(0).getIngred3());
                ingred4TextView.setText(drinkCocktail.get(0).getMeasure4() + drinkCocktail.get(0).getIngred4());
                ingred5TextView.setText(drinkCocktail.get(0).getMeasure5() + drinkCocktail.get(0).getIngred5());
                prepTextView.setText(drinkCocktail.get(0).getPrep());

                drinkCocktail.clear();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}