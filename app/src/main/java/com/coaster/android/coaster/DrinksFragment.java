package com.coaster.android.coaster;

import android.app.ProgressDialog;
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
import java.util.Objects;

public class DrinksFragment extends Fragment {

    private static final String TAG = MainActivity.class.getSimpleName() + "_TAG";

    List<Cocktail> mCocktailList = new ArrayList<>();
    DatabaseReference myRef;
    RecyclerView mRecyclerView;
    String topNode;
    Cocktail cocktail = new Cocktail();
    int positionIndex = -1;
    LinearLayoutManager mLayoutManager;
    int topScreenView;
    private int mShortAnimationDuration;
    private ProgressDialog progressDialog;

    public DrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        progressDialog = new ProgressDialog(getContext());

        myRef = FirebaseDatabase.getInstance().getReference(topNode);

        // FIXME: do not delete just yet.
//        Query searchVodka = myRef.orderByChild("category").equalTo("Vodka");
//        Query searchWhiskey = myRef.orderByChild("category").equalTo("Whiskey");

        if (Objects.equals(topNode, "vodka")) {
            mCocktailList.clear();
            callQuery(myRef);
        }

        if (Objects.equals(topNode, "whiskey")) {
            mCocktailList.clear();
            callQuery(myRef);
        }

        if (Objects.equals(topNode, "tequila")) {
            mCocktailList.clear();
            callQuery(myRef);
        }

        if (Objects.equals(topNode, "rum")) {
            mCocktailList.clear();
            callQuery(myRef);
        }

        if (Objects.equals(topNode, "gin")) {
            mCocktailList.clear();
            callQuery(myRef);
        }

        if (Objects.equals(topNode, "mixed_drink")) {
            mCocktailList.clear();
            callQuery(myRef);
        }

        mRecyclerView.setVisibility(View.GONE);
        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);
        crossFadeRecyclerView();

        return view;
    }

    private void callQuery(DatabaseReference drinkType) {
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Fetching Drinks...");
        progressDialog.show();

        drinkType.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    Cocktail value = dataSnap.getValue(Cocktail.class);
                    Log.d(TAG, "onDataChange: " + value.getName());

                    mCocktailList.add(value);
                }

                mLayoutManager = new LinearLayoutManager(getContext());

                mRecyclerView.setLayoutManager(mLayoutManager);
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(mCocktailList);
                mRecyclerView.setAdapter(adapter);

                progressDialog.dismiss();

                onResume();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void crossFadeRecyclerView() {
        mRecyclerView.setAlpha(0f);
        mRecyclerView.setVisibility(View.VISIBLE);
        mRecyclerView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);
    }

    @Override
    public void onPause() {
        positionIndex = mLayoutManager.findFirstVisibleItemPosition();
        View startView = mRecyclerView.getChildAt(0);
        topScreenView = (startView == null) ? 0 : (startView.getTop() - mRecyclerView.getPaddingTop());
        Log.d(TAG, "onPause: " + topScreenView);
        super.onPause();
    }

    @Override
    public void onResume() {
        if (positionIndex != -1) {
            mLayoutManager.scrollToPositionWithOffset(positionIndex, topScreenView);
        }
        Log.d(TAG, "onResume: is called");
        super.onResume();
    }
}