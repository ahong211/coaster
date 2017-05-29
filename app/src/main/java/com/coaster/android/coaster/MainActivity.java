package com.coaster.android.coaster;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ButtonPress {
    CategoryFragment mCategoryFragment;
    DrinksFragment mDrinksFragment;
    FragmentManager manager = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCategoryFragment = new CategoryFragment();
        mDrinksFragment = new DrinksFragment();


        FragmentTransaction transaction = manager.beginTransaction();

        transaction.add(R.id.fragment_container, mCategoryFragment);
        transaction.commit();
    }

    @Override
    public void drinkButtonPress() {
        FragmentTransaction drinkTransaction = manager.beginTransaction();
        drinkTransaction.replace(R.id.fragment_container, mDrinksFragment);
        drinkTransaction.addToBackStack(null);
        drinkTransaction.commit();
    }


    @Override
    public void vodkaStringKey() {
        mDrinksFragment.topNode = "vodka";
    }

    @Override
    public void whiskeyStringKey() {
        mDrinksFragment.topNode = "whiskey";
    }

}