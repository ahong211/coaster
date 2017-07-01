package com.coaster.android.coaster;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.coaster.android.coaster.model.Cocktail;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DrinkListInfoFragment extends Fragment {

    private static final String TAG = DrinkListInfoFragment.class.getSimpleName() + "_TAG";
    String drinkName;

    @BindView(R.id.drinkInfoLayout)
    View drinkInfoLayout;

    @BindView(R.id.drinkName_TextView)
    TextView drinkNameTextView;

    @BindView(R.id.drinkDesc_TextView)
    TextView drinkDescTextView;

    @BindView(R.id.ingred1_TextView)
    TextView ingrediantsTextView;

    @BindView(R.id.preparation_TextView)
    TextView prepTextView;

    DatabaseReference drinkRef;
    List<Cocktail> drinkCocktail = new ArrayList<>();
    String topNode;
    int mLongAnimationDuration;

    @Inject
    public DrinkListInfoFragment() {
        // Required empty constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drink_list_info, container, false);

        ButterKnife.bind(this, view);

        drinkRef = FirebaseDatabase.getInstance().getReference(topNode);
        Query searchDrinkName = drinkRef.orderByChild("name").equalTo(drinkName);

        mLongAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);

        crossFadeDrinkInfo();
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

                String result;
                StringBuilder sb = new StringBuilder();

                sb.append(drinkCocktail.get(0).getMeasure1()).append(drinkCocktail.get(0)
                        .getIngred1()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure2()).append(drinkCocktail.get(0)
                        .getIngred2()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure3()).append(drinkCocktail.get(0)
                        .getIngred3()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure4()).append(drinkCocktail.get(0)
                        .getIngred4()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure5()).append(drinkCocktail.get(0)
                        .getIngred5()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure6()).append(drinkCocktail.get(0)
                        .getIngred6()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure7()).append(drinkCocktail.get(0)
                        .getIngred7()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure8()).append(drinkCocktail.get(0)
                        .getIngred8()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure9()).append(drinkCocktail.get(0)
                        .getIngred9()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure10()).append(drinkCocktail.get(0)
                        .getIngred10()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure11()).append(drinkCocktail.get(0)
                        .getIngred11()).append("\n");
                sb.append(drinkCocktail.get(0).getMeasure12()).append(drinkCocktail.get(0)
                        .getIngred12());

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

    private void crossFadeDrinkInfo() {
        drinkInfoLayout.setAlpha(0f);
        drinkInfoLayout.setVisibility(View.VISIBLE);

        drinkInfoLayout.animate()
                .alpha(1f)
                .setDuration(800)
                .setListener(null);
    }
}
