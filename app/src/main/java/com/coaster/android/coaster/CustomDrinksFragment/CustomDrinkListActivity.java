package com.coaster.android.coaster.CustomDrinksFragment;

import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.coaster.android.coaster.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class CustomDrinkListActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String MAC_TAG = "MAC_TAG";
    com.coaster.android.coaster.CustomDrinkFragment.CustomDrinkFragment mCustomDrinkFragment;
    FragmentManager manager = getSupportFragmentManager();
    com.coaster.android.coaster.CustomDrinkFragment.CustomDrinksAdapter customDrinksAdapter;
    DatabaseReference customDrinkListReference;
    LinearLayoutManager mLayoutManager;
    List<com.coaster.android.coaster.CustomDrinkFragment.CustomDrinkRecipe> customDrinksDataList;

    @BindView(R.id.add_new_drink)
    FloatingActionButton addCustomDrinkActionButton;
    @BindView(R.id.a_recycler_view)
    RecyclerView customDrinkListRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_drink_list);
        ButterKnife.bind(this);
        customDrinkListReference = FirebaseDatabase.getInstance().getReference("custom_drinks");
        callQuery(customDrinkListReference);
        customDrinksDataList = new ArrayList<>();
        customDrinksAdapter = new com.coaster.android.coaster.CustomDrinkFragment.CustomDrinksAdapter(customDrinksDataList);
        Log.d(MAC_TAG, "onCreate: " + customDrinksDataList);

    }

    @OnClick(R.id.add_new_drink)
    @Override
    public void onClick(View v) {
        mCustomDrinkFragment = new com.coaster.android.coaster.CustomDrinkFragment.CustomDrinkFragment();
        FragmentTransaction customDrinkTransaction = manager.beginTransaction();
        customDrinkTransaction.replace(R.id.custom_drink_frag_container, mCustomDrinkFragment);
        customDrinkTransaction.addToBackStack(null);
        customDrinkTransaction.commit();
        addCustomDrinkActionButton.setVisibility(View.INVISIBLE);
        customDrinkListRecyclerView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        addCustomDrinkActionButton.setVisibility(View.VISIBLE);
        customDrinkListRecyclerView.setVisibility(View.VISIBLE);
    }

    private void callQuery(DatabaseReference reference) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    com.coaster.android.coaster.CustomDrinkFragment.CustomDrinkRecipe value = dataSnap.getValue(com.coaster.android.coaster.CustomDrinkFragment.CustomDrinkRecipe.class);
                    Log.d(MAC_TAG, "onDataChange: " + value.getDrinkId());
                    Log.d(MAC_TAG, "onDataChange: " + value.getDrinkName());
                    Log.d(MAC_TAG, "onDataChange: " + value.getIngredient());
                    Log.d(MAC_TAG, "onDataChange: " + value.getInstruction());

                    customDrinksDataList.add(value);
                }

                mLayoutManager = new LinearLayoutManager(getBaseContext());
                customDrinkListRecyclerView.setLayoutManager(mLayoutManager);
                customDrinkListRecyclerView.setAdapter(customDrinksAdapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e(MAC_TAG, "Failed to read value.", databaseError.toException());
            }
        });
    }
}
