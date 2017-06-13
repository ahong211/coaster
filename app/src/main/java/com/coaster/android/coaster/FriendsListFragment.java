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
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class FriendsListFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = FriendsListFragment.class.getSimpleName() + "_TAG";
    EditText friendsListEmail;
    Button addFriendsButton;
    private FirebaseAuth auth;
    DatabaseReference databaseReference;
    DatabaseReference searchDatabaseReference;
    User value;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    String databaseEmail = "";
    ArrayList<User> friendsList = new ArrayList<>();
    RecyclerView friendsRecyclerView;
    LinearLayoutManager layoutManager;
    private ProgressDialog progressDialog;

    String friendsNode = "friends";
    String usersNode = "users";

    public FriendsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends_list, container, false);

        friendsRecyclerView = (RecyclerView) view.findViewById(R.id.friends_list_recyclerView);
        friendsListEmail = (EditText) view.findViewById(R.id.friendslist_email);
        addFriendsButton = (Button) view.findViewById(R.id.addFriendsButton);
        addFriendsButton.setOnClickListener(this);
        progressDialog = new ProgressDialog(getContext());

        auth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference(usersNode + "/" + auth.getCurrentUser().getUid()
                + "/" + friendsNode);
        displayFriendsList(databaseReference);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addFriendsButton:

                searchDatabaseReference = database.getReference(usersNode);
                Query searchFriends = searchDatabaseReference.orderByChild("email").equalTo(friendsListEmail.getText().toString());

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
                                + auth.getCurrentUser().getUid() + "/" + friendsNode + "/" + value.getId());
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
