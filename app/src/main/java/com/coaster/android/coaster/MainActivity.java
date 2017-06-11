package com.coaster.android.coaster;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.firebase.ui.auth.AuthUI;



public class MainActivity extends AppCompatActivity implements ButtonPress, DrinkInfo {
    CategoryFragment mCategoryFragment;
    DrinksFragment mDrinksFragment;
    CustomDrinksListFragment mCustomDrinksListFragment;
    DrinkListInfoFragment mDrinkListInfoFragment;
    CustomDrinkFragment mCustomDrinkFragment;
    FragmentManager manager = getSupportFragmentManager();

//    private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;

    //Kevins Nav Bar Section

    private String[] mNavigationDrawerItemTitles;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    Toolbar toolbar;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

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


        // Kevin's new Side Bar

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        DataModel[] drawerItem = new DataModel[7];
        drawerItem[0] = new DataModel(R.drawable.coaster_nav_image);
        drawerItem[1] = new DataModel("Account");
        drawerItem[2] = new DataModel("Settings");
        drawerItem[3] = new DataModel("Maps");
        drawerItem[4] = new DataModel("Invite a friend");
        drawerItem[5] = new DataModel("Bar Code Scanner");
        drawerItem[6] = new DataModel("Sign Out");

        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdaptor adapter = new DrawerItemCustomAdaptor(this, R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        setupDrawerToggle();


//        // Side view menu
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
//
//        mDrawerLayout.addDrawerListener((mToggle));
//        mToggle.syncState();

//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }





//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }

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

//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (mToggle.onOptionsItemSelected(item)) {
//            return true;
//        }
//
//        switch (id) {
//            case R.id.menu_grey:
//                if (item.isChecked()) {
//                    item.setCheckable(false);
//                } else item.setChecked(true);
//                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#757575")));
//                return true;
//
//            case R.id.menu_blue:
//                if (item.isChecked()) {
//                    item.setCheckable(false);
//                } else item.setChecked(true);
//                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5aa9e9")));
//                return true;
//
//            case R.id.menu_pink:
//                if (item.isChecked()) {
//                    item.setCheckable(false);
//                } else item.setChecked(true);
//                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#f78ff9")));
//                return true;
//
//            case R.id.menu_original:
//                if (item.isChecked()) {
//                    item.setCheckable(false);
//                } else item.setChecked(true);
//                getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffc042")));
//                return true;
//
//            case R.id.menu_signout:
//                AuthUI.getInstance().signOut(this);
//                finish();
//
//            default:
//                return super.onOptionsItemSelected(item);
//        }
//    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }

    }

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
//            case 0:
//                Intent i = new Intent(this, MapsActivity.class);
//                startActivity(i);
//                break;
//            case 1:
//                fragment = new FixturesFragment();
//                break;
//            case 2:
//                fragment = new TableFragment();
//                break;
            case 3:
                Intent i = new Intent(this, MapsActivity.class);
                startActivity(i);
                break;
//            case 4:
//                fragment = new TableFragment();
//                break;
//            case 5:
//                fragment = new TableFragment();
//                break;
//            case 6:
//                fragment = new TableFragment();
//                break;

            default:
                break;
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, fragment).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    // ****************************************** NAV DRAWER ***************************************

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar(){
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle(){
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this,mDrawerLayout,toolbar,R.string.app_name, R.string.app_name);
        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    // *********************************************************************************************

    @Override
    protected void onDestroy() {
        super.onDestroy();
        AuthUI.getInstance().signOut(this);
        finish();
    }
}