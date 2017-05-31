package com.coaster.android.coaster;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ButtonPress, DrinkInfo {
    CategoryFragment mCategoryFragment;
    DrinksFragment mDrinksFragment;
    CustomDrinksListFragment mCustomDrinksListFragment;
    DrinkListInfoFragment mDrinkListInfoFragment;
    CustomDrinkFragment mCustomDrinkFragment;
    FragmentManager manager = getSupportFragmentManager();

    // TODO: 5/29/2017 Link custom drink fragment to custom drink list fragment

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCategoryFragment = new CategoryFragment();
        mDrinksFragment = new DrinksFragment();
        mDrinkListInfoFragment = new DrinkListInfoFragment();

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
    public void customDrinksListButtonPress() {
        mCustomDrinksListFragment = new CustomDrinksListFragment();
        FragmentTransaction customDrinksListTransaction = manager.beginTransaction();
        customDrinksListTransaction.replace(R.id.fragment_container, mCustomDrinksListFragment);
        customDrinksListTransaction.addToBackStack(null);
        customDrinksListTransaction.commit();
    }

    @Override
    public void addCustomDrinkButtonPress() {
        mCustomDrinkFragment = new CustomDrinkFragment();
        FragmentTransaction customDrinkTransaction = manager.beginTransaction();
        customDrinkTransaction.replace(R.id.fragment_container, mCustomDrinkFragment);
        customDrinkTransaction.addToBackStack(null);
        customDrinkTransaction.commit();
    }

    @Override
    public void vodkaStringKey() {
        mDrinksFragment.positionIndex = -1;
        mDrinksFragment.topNode = "vodka";
    }

    @Override
    public void whiskeyStringKey() {
        mDrinksFragment.positionIndex = -1;
        mDrinksFragment.topNode = "whiskey";
    }

    @Override
    public void goToDrinkListFragment() {
        FragmentTransaction drinkTransaction = manager.beginTransaction();
        drinkTransaction.replace(R.id.fragment_container, mDrinkListInfoFragment);
        drinkTransaction.addToBackStack(null);
        drinkTransaction.commit();
    }

    @Override
    public void setDrinkNameNode(String s) {
        mDrinkListInfoFragment.drinkName = s;
        mDrinkListInfoFragment.topNode = mDrinksFragment.topNode;
    }

}