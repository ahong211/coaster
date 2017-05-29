package com.coaster.android.coaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class DrinksFragment extends Fragment {

    private static final String TAG = CategoryFragment.class.getSimpleName() + "_TAG";

    List<Cocktail> mCocktailList = new ArrayList<>();
    DatabaseReference myRef;
    RecyclerView mRecyclerView;
    String drinkKey;
    String topNode;

    Cocktail cocktail = new Cocktail();

    public DrinksFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);


        myRef = FirebaseDatabase.getInstance().getReference(topNode);

//        Query searchVodka = myRef.orderByChild("category").equalTo("Vodka");
//        Query searchWhiskey = myRef.orderByChild("category").equalTo("Whiskey");


        if (topNode == "whiskey") {
            mCocktailList.clear();
            callQuery(myRef);
        }
        if (topNode == "vodka") {
            mCocktailList.clear();
            callQuery(myRef);
        }

        return view;
    }

    private void callQuery(DatabaseReference drinkType) {
        drinkType.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    Cocktail value = dataSnap.getValue(Cocktail.class);
                    Log.d(TAG, "onDataChange: " + value.getName());

                    mCocktailList.add(value);

                }

                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                CategoryAdapter adapter = new CategoryAdapter(mCocktailList);
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
