package com.coaster.android.coaster;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

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

public class CustomDrinkListActivity extends AppCompatActivity {

    // TODO: 6/11/2017 create dynamic link of drinks list
    // TODO: 6/11/2017 add share methods to button
    // TODO: 6/11/2017 link list to current user

    private static final String MAC_TAG = "MAC_TAG";
    private static final int REQUEST_INVITE = 747;
    CustomDrinkFragment mCustomDrinkFragment;
    FragmentManager manager = getSupportFragmentManager();
    CustomDrinksAdapter customDrinksAdapter;
    DatabaseReference customDrinkListReference;
    LinearLayoutManager mLayoutManager;
    List<CustomDrinkRecipe> customDrinksDataList;

    @BindView(R.id.share_drink_list)
    FloatingActionButton shareCustomDrinkListButton;

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
        customDrinksAdapter = new CustomDrinksAdapter(customDrinksDataList);
        Log.d(MAC_TAG, "onCreate: " + customDrinksDataList);

    }

    @OnClick(R.id.add_new_drink)
    public void onNewDrinkButtonClicked(View v) {
        mCustomDrinkFragment = new CustomDrinkFragment();
        FragmentTransaction customDrinkTransaction = manager.beginTransaction();
        customDrinkTransaction.replace(R.id.custom_drink_frag_container, mCustomDrinkFragment);
        customDrinkTransaction.addToBackStack(null);
        customDrinkTransaction.commit();

        addCustomDrinkActionButton.setVisibility(View.INVISIBLE);
        shareCustomDrinkListButton.setVisibility(View.INVISIBLE);
        customDrinkListRecyclerView.setVisibility(View.INVISIBLE);
    }

    @OnClick(R.id.share_drink_list)
    public void onShareButtonClicked(View v) {
        Intent sendIntent = new Intent();
//        Intent sendIntent = new AppInviteInvitation.IntentBuilder(getString(R.string.customDrink_invitation_title))
//                .setMessage(getString(R.string.customDrink_message))
//                .setDeepLink(Uri.parse(getString(R.string.customDrink_invitation_deep_link)))
//                .build();
        Uri myDynamicLink = Uri.parse(getString(R.string.customDrink_invitation_deep_link));
        String message = getString(R.string.customDrink_message) + myDynamicLink.toString();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, message);
        sendIntent.setType("text/plain");
        startActivity(sendIntent);
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        Log.d(MAC_TAG, "onActivityResult: requestCode=" + requestCode + ", resultCode=" + resultCode);
//        if (requestCode == REQUEST_INVITE) {
//            if (resultCode == RESULT_OK) {
//                // Get the invitation IDs of all sent messages
//                String[] ids = AppInviteInvitation.getInvitationIds(resultCode, data);
//                for (String id : ids) {
//                    Log.d(MAC_TAG, "onActivityResult: sent invitation " + id);
//                }
//            } else {
//                Toast.makeText(this, "Sending Failed!", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        addCustomDrinkActionButton.setVisibility(View.VISIBLE);
        shareCustomDrinkListButton.setVisibility(View.VISIBLE);
        customDrinkListRecyclerView.setVisibility(View.VISIBLE);
    }

    private void callQuery(DatabaseReference reference) {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    CustomDrinkRecipe value = dataSnap.getValue(CustomDrinkRecipe.class);
                    Log.d(MAC_TAG, "onDataChange: " + value.getDrinkId());
                    Log.d(MAC_TAG, "onDataChange: " + value.getDrinkName());
                    Log.d(MAC_TAG, "onDataChange: " + value.getIngredient());
                    Log.d(MAC_TAG, "onDataChange: " + value.getInstruction());

                    customDrinksDataList.add(value);
                }

                mLayoutManager = new LinearLayoutManager(getApplicationContext());
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
