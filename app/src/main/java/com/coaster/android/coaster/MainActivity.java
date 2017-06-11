package com.coaster.android.coaster;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity implements ButtonPress, DrinkInfo {
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    CategoryFragment mCategoryFragment;
    DrinksFragment mDrinksFragment;
    DrinkListInfoFragment mDrinkListInfoFragment;
    //CustomDrinkFragment mCustomDrinkFragment;
    FragmentManager manager = getSupportFragmentManager();

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

        // Side view menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.fragment_container);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open , R.string.close);

        mDrawerLayout.addDrawerListener((mToggle));
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
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
        Intent loadCustomList = new Intent(this, CustomDrinkListActivity.class);
        startActivity(loadCustomList);

//        mCustomDrinksListFragment = new CustomDrinksListFragment();
//        FragmentTransaction customDrinksListTransaction = manager.beginTransaction();
//        customDrinksListTransaction.replace(R.id.fragment_container, mCustomDrinksListFragment);
//        customDrinksListTransaction.addToBackStack(null);
//        customDrinksListTransaction.commit();
    }

    @Override
    public void addCustomDrinkButtonPress() {
//        mCustomDrinkFragment = new CustomDrinkFragment();
//        FragmentTransaction customDrinkTransaction = manager.beginTransaction();
//        customDrinkTransaction.replace(R.id.fragment_container, mCustomDrinkFragment);
//        customDrinkTransaction.addToBackStack(null);
//        customDrinkTransaction.commit();
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
    public void tequilaStringKey() {
        mDrinksFragment.positionIndex = -1;
        mDrinksFragment.topNode = "tequila";
    }

    @Override
    public void rumStringKey() {
        mDrinksFragment.positionIndex = -1;
        mDrinksFragment.topNode = "rum";
    }

    @Override
    public void ginStringKey() {
        mDrinksFragment.positionIndex = -1;
        mDrinksFragment.topNode = "gin";
    }

    @Override
    public void mixedDrinkStringKey() {
        mDrinksFragment.positionIndex = -1;
        mDrinksFragment.topNode = "mixed_drink";
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


    // Action bar added and side drawer

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (mToggle.onOptionsItemSelected(item)){
            return true;
        }

        switch (id) {
            case R.id.menu_grey:
                if(item.isChecked()) {
                    item.setCheckable(false);
                }

                else item.setChecked(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
                return true;

            case R.id.menu_blue:
                if(item.isChecked()) {
                    item.setCheckable(false);
                }
                else item.setChecked(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5aa9e9")));
                return true;

            case R.id.menu_pink:
                if(item.isChecked()) {
                    item.setCheckable(false);
                }
                else item.setChecked(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f78ff9")));
                return true;

            case R.id.menu_original:
                if(item.isChecked()) {
                    item.setCheckable(false);
                }
                else item.setChecked(true);
                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc042")));
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}