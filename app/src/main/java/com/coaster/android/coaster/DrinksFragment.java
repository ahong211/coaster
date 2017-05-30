package com.coaster.android.coaster;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
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

    private static final String TAG = CategoryFragment.class.getSimpleName() + "_TAG";

    List<Cocktail> mCocktailList = new ArrayList<>();
    DatabaseReference myRef;
    RecyclerView mRecyclerView;
    String drinkKey;
    String topNode;
    boolean activateCrossFade = false;
    Cocktail cocktail = new Cocktail();
    private int mShortAnimationDuration;
    private View mRecyclerDrinkView;
    private View mLoadingView;

    public DrinksFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_drinks, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);

        myRef = FirebaseDatabase.getInstance().getReference(topNode);

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

        mRecyclerDrinkView = view.findViewById(R.id.recyclerView);
        mLoadingView = view.findViewById(R.id.loading_spinner);

        mRecyclerDrinkView.setVisibility(View.GONE);

        mShortAnimationDuration = getResources().getInteger(android.R.integer.config_longAnimTime);

        crossFadeRecyclerView();

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
                RecyclerViewAdapter adapter = new RecyclerViewAdapter(mCocktailList);
                mRecyclerView.setAdapter(adapter);

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void crossFadeRecyclerView() {
        mRecyclerDrinkView.setAlpha(0f);
        mRecyclerDrinkView.setVisibility(View.VISIBLE);

        mRecyclerDrinkView.animate()
                .alpha(1f)
                .setDuration(mShortAnimationDuration)
                .setListener(null);

        if (!activateCrossFade) {
            crossFadeLoadingSpinner();
            activateCrossFade = true;
        } else {
            mLoadingView.setVisibility(View.INVISIBLE);
        }
    }

    private void crossFadeLoadingSpinner() {
        mLoadingView.animate()
                .alpha(0f)
                .setDuration(2000)
                .setListener(new AnimatorListenerAdapter() {
                    @Override
                    public void onAnimationEnd(Animator animation) {
                        mLoadingView.setVisibility(View.GONE);
                    }
                });
        activateCrossFade = true;
    }
}