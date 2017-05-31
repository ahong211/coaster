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
    TextView ingrediantsTextView;
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

        ingrediantsTextView = (TextView) view.findViewById(R.id.ingred1_TextView);
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

                String result = "";
                StringBuilder sb = new StringBuilder();
                sb.append(drinkCocktail.get(0).getMeasure1() + drinkCocktail.get(0).getIngred1() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure2() + drinkCocktail.get(0).getIngred2() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure3() + drinkCocktail.get(0).getIngred3() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure4() + drinkCocktail.get(0).getIngred4() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure5() + drinkCocktail.get(0).getIngred5() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure6() + drinkCocktail.get(0).getIngred6() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure7() + drinkCocktail.get(0).getIngred7() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure8() + drinkCocktail.get(0).getIngred8() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure9() + drinkCocktail.get(0).getIngred9() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure10() + drinkCocktail.get(0).getIngred10() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure11() + drinkCocktail.get(0).getIngred11() + "\n");
                sb.append(drinkCocktail.get(0).getMeasure12() + drinkCocktail.get(0).getIngred12());
                result = sb.toString().trim();
                ingrediantsTextView.setText(result);

                prepTextView.setText(drinkCocktail.get(0).getPrep());
                drinkCocktail.clear();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
