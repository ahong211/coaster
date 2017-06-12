package com.coaster.android.coaster;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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

    public FriendsListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_friends_list, container, false);

        friendsListEmail = (EditText) view.findViewById(R.id.friendslist_email);
        addFriendsButton = (Button) view.findViewById(R.id.addFriendsButton);
        addFriendsButton.setOnClickListener(this);

        auth = FirebaseAuth.getInstance();

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.addFriendsButton:

                searchDatabaseReference = database.getReference("users");
                Query searchFriends = searchDatabaseReference.orderByChild("email").equalTo(friendsListEmail.getText().toString());

                callQuery(searchFriends);

                break;
        }
    }

    private void callQuery(Query friendEmail) {

        final String friendsNode = "friends";
        final String usersNode = "users";


        friendEmail.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    value = dataSnap.getValue(User.class);
                    Log.d(TAG, "onDataChange: " + value.getId());
                    databaseEmail = (String) dataSnap.child("email").getValue();

                    if (value != null) {
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
