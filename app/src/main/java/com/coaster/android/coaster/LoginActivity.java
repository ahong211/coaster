package com.coaster.android.coaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.coaster.android.coaster.component.DaggerUserComponent;
import com.coaster.android.coaster.component.UserComponent;
import com.coaster.android.coaster.model.User;
import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName() + "_TAG";

    DatabaseReference searchDatabaseReference;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    private FirebaseAuth auth;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // To consume (receive) the instance of injected User object:
        //AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        UserComponent userComponent = DaggerUserComponent.create();
        user = userComponent.getUser();

        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser() == null) {
            loginOptions();
        }
    }

    private void loginOptions() {
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setProviders(Arrays.asList(
                                new AuthUI.IdpConfig.Builder(
                                        AuthUI.EMAIL_PROVIDER).build(),
                                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build()))
                        .setLogo(R.drawable.logo_black)
                        .setTheme(R.style.LoginTheme)
                        .build(), 123);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK && requestCode == 123) {
            createUserInDatabase();

            return;
        }
    }

    private void createUserInDatabase() {

        if (auth.getCurrentUser() != null) {
            user.setId(auth.getCurrentUser().getUid());
            user.setEmail(auth.getCurrentUser().getEmail());
            user.setName(auth.getCurrentUser().getDisplayName());
        }

        searchDatabaseReference = database.getReference("users");
        Query searchUsers = searchDatabaseReference.orderByChild("id").equalTo(user.getId());
        retrieveDatabaseEmail(searchUsers);

    }

    private void retrieveDatabaseEmail(Query searchUsers) {

        searchUsers.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                for (DataSnapshot dataSnap : dataSnapshot.getChildren()) {
                    User value = dataSnap.getValue(User.class);
                    Log.d(TAG, "onDataChange: " + value.getName());
                }

                if (!dataSnapshot.hasChild(user.getId())) {
                    String userNode = "users";

                    DatabaseReference databaseReference = database.getReference(userNode + "/"
                            + auth.getCurrentUser().getUid());
                    databaseReference.setValue(user);
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        //finish();
//        finishFromChild(getParent());
//    }

    @Override
    public void onBackPressed() {
        //finish();
        super.onBackPressed();
        finishFromChild(getParent());
    }
}
