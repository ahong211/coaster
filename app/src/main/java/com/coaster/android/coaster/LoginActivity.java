package com.coaster.android.coaster;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.firebase.ui.auth.AuthUI;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Arrays;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = LoginActivity.class.getSimpleName() + "_TAG";
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        auth = FirebaseAuth.getInstance();
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (auth.getCurrentUser() != null) {
            Toast.makeText(this, "Signed In", Toast.LENGTH_SHORT).show();
        } else {
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
                        .setTheme(R.style.AppTheme)
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
        User user = new User();

        if (auth.getCurrentUser() != null) {
            user.setId(auth.getCurrentUser().getUid());
            user.setEmail(auth.getCurrentUser().getEmail());
            user.setName(auth.getCurrentUser().getDisplayName());
        }

        String userNode = "users";
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference databaseReference = database.getReference(userNode + "/"
                + auth.getCurrentUser().getUid());
        databaseReference.setValue(user);
    }
}