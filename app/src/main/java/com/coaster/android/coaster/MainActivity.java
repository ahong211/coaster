package com.coaster.android.coaster;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;

public class MainActivity extends AppCompatActivity implements ButtonPress{
    CategoryFragment mCategoryFragment;
    DrinksFragment mDrinksFragment;
    DrinkDetails mDrinkDetails;
    FragmentManager manager = getSupportFragmentManager();
    public static String sharedString = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mCategoryFragment = new CategoryFragment();
        mDrinksFragment = new DrinksFragment();
        mDrinkDetails = new DrinkDetails();


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


//    public void drinkDetailsFragmentMethod(View v) {
//
//
//
//        if(mDrinkDetails == null){
//            mDrinkDetails = new DrinkDetails();
//        }
//
//        FragmentTransaction drinkTransaction = manager.beginTransaction();
//        drinkTransaction.replace(R.id.fragment_container, mDrinkDetails);
//        drinkTransaction.addToBackStack(null);
//        drinkTransaction.commit();
//
//    }


}