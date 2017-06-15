package com.coaster.android.coaster;

import android.content.Intent;
import android.net.Uri;
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
import android.widget.Toast;

import com.coaster.android.coaster.component.CategoryFragmentComponent;
import com.coaster.android.coaster.component.DaggerCategoryFragmentComponent;
import com.coaster.android.coaster.component.DaggerDrinkListInfoFragmentComponent;
import com.coaster.android.coaster.component.DaggerDrinksFragmentComponent;
import com.coaster.android.coaster.component.DaggerFriendsListFragmentComponent;
import com.coaster.android.coaster.component.DrinkListInfoFragmentComponent;
import com.coaster.android.coaster.component.DrinksFragmentComponent;
import com.coaster.android.coaster.component.FriendsListFragmentComponent;
import com.coaster.android.coaster.model.DataModel;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.appinvite.AppInviteInvitation;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ButtonPress, DrinkInfo {
    private static final int INVITE_REQUEST_CODE = 101;
    //          CustomDrinkFragment mCustomDrinkFragment;
//        private DrawerLayout mDrawerLayout;
//    private ActionBarDrawerToggle mToggle;
    FragmentManager manager = getSupportFragmentManager();
    Toolbar toolbar;
    android.support.v7.app.ActionBarDrawerToggle mDrawerToggle;

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.left_drawer)
    ListView mDrawerList;

    private CategoryFragment mCategoryFragment;
    private DrinksFragment mDrinksFragment;
    private DrinkListInfoFragment mDrinkListInfoFragment;
    private String[] mNavigationDrawerItemTitles;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();

        CategoryFragmentComponent categoryComponent = DaggerCategoryFragmentComponent.create();
        DrinksFragmentComponent drinksComponent = DaggerDrinksFragmentComponent.create();
        DrinkListInfoFragmentComponent drinkListInfoComponent =
                DaggerDrinkListInfoFragmentComponent.create();

        mCategoryFragment = categoryComponent.getCategoryFragment();
        mDrinksFragment = drinksComponent.getDrinksFragment();
        mDrinkListInfoFragment = drinkListInfoComponent.getDrinkListInfoFragment();

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.fragment_container, mCategoryFragment);
        transaction.commit();

        mTitle = mDrawerTitle = getTitle();
        mNavigationDrawerItemTitles = getResources().getStringArray(R.array
                .navigation_drawer_items_array);

//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
//        mDrawerList = (ListView) findViewById(R.id.left_drawer);

        setupToolbar();

        // FIXME: Use Dagger instead of instantiating new objects of DataModel.
        DataModel[] drawerItem = new DataModel[8];
        drawerItem[0] = new DataModel(R.drawable.coaster_nav_image);
        drawerItem[1] = new DataModel("Account");
        drawerItem[2] = new DataModel("Settings");
        drawerItem[3] = new DataModel("Maps");
        drawerItem[4] = new DataModel("Friends List");
        drawerItem[5] = new DataModel("Invite a friend");
        drawerItem[6] = new DataModel("Bar Code Scanner");
        drawerItem[7] = new DataModel("Sign Out");

        //noinspection ConstantConditions
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        getSupportActionBar().setHomeButtonEnabled(true);

        DrawerItemCustomAdaptor adapter = new DrawerItemCustomAdaptor(this,
                R.layout.list_view_item_row, drawerItem);
        mDrawerList.setAdapter(adapter);
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
        //mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
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

    @Override
    public void drinkButtonPress() {
        FragmentTransaction drinkTransaction = manager.beginTransaction();
        drinkTransaction.replace(R.id.fragment_container, mDrinksFragment);
        drinkTransaction.addToBackStack(null);
        drinkTransaction.commit();
    }

    @Override
    public void customDrinksListButtonPress() {
        Intent customListIntent = new Intent(this, CustomDrinkListActivity.class);
        startActivity(customListIntent);

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
    public void setDrinkNameNode(String nameNode) {
        mDrinkListInfoFragment.drinkName = nameNode;
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

    private void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                //Do nothing. Navigation drawer Coaster Icon clicked
                break;

            case 1:
                //accountFragment();
                //noinspection ConstantConditions
                String name = auth.getCurrentUser().getDisplayName();
                Toast.makeText(this, "Hi, " + name, Toast.LENGTH_SHORT).show();

                break;

            case 2:
                //settingsFragment();
                Toast.makeText(this, "Settings Clicked", Toast.LENGTH_SHORT).show();
                break;

            case 3:
                Intent mapsIntent = new Intent(this, MapsActivity.class);
                startActivity(mapsIntent);
                break;

            case 4:
                FriendsListFragmentComponent friendsListFragmentComponent =
                        DaggerFriendsListFragmentComponent.create();
                fragment = friendsListFragmentComponent.getFriendsListFragment();
                break;

            case 5:
                sendInvite();
                break;

            case 6:
                Intent scannerIntent = new Intent(this, ScannerActivity.class);
                startActivity(scannerIntent);
                break;

            case 7:
                signOutUser();
                break;

            default:
                throw new RuntimeException("Navigation Drawer position invalid: " + position);
        }

        if (fragment != null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container,
                    fragment).addToBackStack(null).commit();

            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(mNavigationDrawerItemTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);

        } else {
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    private void sendInvite() {
        Intent intent = new AppInviteInvitation.IntentBuilder(getString(R.string.invitation_title))
                .setMessage(getString(R.string.invitation_message))
                .setDeepLink(Uri.parse(getString(R.string.invitation_deep_link)))
//                .setCustomImage(Uri.parse(getString(R.string.invitation_custom_image)))
                .setCallToActionText(getString(R.string.invitation_call_to_action))
                .build();
        startActivityForResult(intent, INVITE_REQUEST_CODE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (mDrawerToggle.onOptionsItemSelected(item)) {

            /*
            * TODO: simplify if statement
            * return mDrawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
            */

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    // ****************************************** NAV DRAWER ***************************************

    @Override
    public void setTitle(CharSequence title) {
        mTitle = title;

        //noinspection ConstantConditions
        getSupportActionBar().setTitle(mTitle);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDrawerToggle.syncState();
    }

    void setupToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //noinspection ConstantConditions
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    void setupDrawerToggle() {
        mDrawerToggle = new android.support.v7.app.ActionBarDrawerToggle(this, mDrawerLayout,
                toolbar, R.string.app_name, R.string.app_name);

        //This is necessary to change the icon of the Drawer Toggle upon state change.
        mDrawerToggle.syncState();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //    signOutUser();
    }

    private void signOutUser() {
        AuthUI.getInstance().signOut(this);
        finish();
    }


    // *********************************************************************************************

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
    }
}