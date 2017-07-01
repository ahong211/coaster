package com.coaster.android.coaster.views.fragments;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.coaster.android.coaster.views.adapters.FriendsListAdapter;
import com.coaster.android.coaster.R;
import com.coaster.android.coaster.models.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class FriendsListFragment extends Fragment {

    private static final String TAG = FriendsListFragment.class.getSimpleName() + "_TAG";
    public DatabaseReference databaseReference;
    public DatabaseReference searchDatabaseReference;
    public User value;
    public FirebaseDatabase database = FirebaseDatabase.getInstance();
    public String databaseEmail = "";
    public ArrayList<User> friendsList = new ArrayList<>();
    public LinearLayoutManager layoutManager;
    public String friendsNode = "friends";
    public String usersNode = "users";

    @BindView(R.id.friends_list_recyclerView)
    RecyclerView friendsRecyclerView;

    @BindView(R.id.addFriendsButton)
    Button addFriendsButton;

    @BindView(R.id.friendslist_email)
    EditText friendsListEmail;

    private FirebaseAuth auth;
    private ProgressDialog progressDialog;

    @Inject
    public FriendsListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_friends_list, container, false);

        ButterKnife.bind(this, view);

        progressDialog = new ProgressDialog(view.getContext());

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference(usersNode + "/"
                + auth.getCurrentUser().getUid() + "/" + friendsNode);
        displayFriendsList(databaseReference);

        return view;
    }

    @OnClick(R.id.addFriendsButton)
    public void onAddFriendsButtonClick(View v) {
        switch (v.getId()) {
            case R.id.addFriendsButton:

                searchDatabaseReference = database.getReference(usersNode);
                Query searchFriends = searchDatabaseReference.orderByChild("email")
                        .equalTo(friendsListEmail.getText().toString());

                callQuery(searchFriends);

                break;
        }
    }

    private void displayFriendsList(DatabaseReference friends) {
        progressDialog.setCanceledOnTouchOutside(false);
        progressDialog.setMessage("Grabbing drinking buddies...");
        progressDialog.show();

        friends.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    User value = dataSnap.getValue(User.class);
                    Log.d(TAG, "onDataChange: " + value.getName());

                    friendsList.add(value);
                }

                layoutManager = new LinearLayoutManager(getContext());

                friendsRecyclerView.setLayoutManager(layoutManager);
                FriendsListAdapter friendsAdapter = new FriendsListAdapter(friendsList);
                friendsRecyclerView.setAdapter(friendsAdapter);

                progressDialog.dismiss();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void callQuery(Query friendEmail) {
        friendEmail.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    value = dataSnap.getValue(User.class);
                    Log.d(TAG, "onDataChange: " + value.getId());
                    databaseEmail = (String) dataSnap.child("email").getValue();

                    if (value != null) {
                        friendsList.clear();
                        databaseReference = database.getReference(usersNode + "/"
                                + auth.getCurrentUser().getUid() + "/" + friendsNode + "/"
                                + value.getId());
                        databaseReference.setValue(value);
                        Toast.makeText(getContext(), R.string.friend_added, Toast.LENGTH_SHORT).show();
                    }
                }

                if (!databaseEmail.equals(friendsListEmail.getText().toString())) {
                    Toast.makeText(getContext(), R.string.invalid_email, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
