package com.example.gauthierbonvarlet.nox;


import android.content.Intent;

import android.content.pm.PackageInstaller;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;


import com.example.gauthierbonvarlet.nox.SuccessLoginActivity;
import com.facebook.AccessToken;

import com.facebook.AccessTokenTracker;

import com.facebook.CallbackManager;

import com.facebook.FacebookCallback;

import com.facebook.FacebookException;

import com.facebook.FacebookSdk;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.Profile;

import com.facebook.ProfileTracker;

import com.facebook.login.LoginResult;

import com.facebook.login.widget.LoginButton;


public class MainActivity extends AppCompatActivity {

    private CallbackManager callbackManager;
    private AccessTokenTracker accessTokenTracker;
    private ProfileTracker profileTracker;
    ImageView image;
    Animation updown, downup;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LoginButton loginButton = (LoginButton) findViewById(R.id.login_button);
      //  image = (ImageView) findViewById(R.id.imageView);
        //updown = AnimationUtils.loadAnimation(this, R.anim.updown);
       // image.setAnimation(updown);
       // image = (ImageView) findViewById(R.id.imageView);
       // updown = AnimationUtils.loadAnimation(this, R.anim.updown);
        //downup = AnimationUtils.loadAnimation(this, R.anim.downup);
       // image.setAnimation(updown);
       // loginButton.setAnimation(downup);

        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
        accessTokenTracker = new AccessTokenTracker() {

            @Override
            protected void onCurrentAccessTokenChanged(AccessToken oldToken, AccessToken newToken) {
            }
        };
        profileTracker = new ProfileTracker() {

            @Override
            protected void onCurrentProfileChanged(Profile oldProfile, Profile newProfile) {
                nextActivity(newProfile);
            }
        };
        accessTokenTracker.startTracking();
        profileTracker.startTracking();

        FacebookCallback<LoginResult> callback = new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                if (Profile.getCurrentProfile() == null) {
                    profileTracker.startTracking();
                } else {
                    Profile profile = Profile.getCurrentProfile();
                    Log.v("facebook - profile", profile.getFirstName());
                    nextActivity(profile);
                }
            }


            @Override
            public void onCancel() {
            }

            @Override
            public void onError(FacebookException e) {
            }
        };

        loginButton.setReadPermissions("user_friends");
        loginButton.registerCallback(callbackManager, callback);

    }

    @Override
    protected void onResume() {
        super.onResume();
        //Facebook login
        Profile profile = Profile.getCurrentProfile();
        //nextActivity(profile);
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    protected void onStop() {
        super.onStop();
        //Facebook login
        accessTokenTracker.stopTracking();
        profileTracker.stopTracking();
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // if you don't add following block,
        // your registered `FacebookCallback` won't be called
        if (callbackManager.onActivityResult(requestCode, resultCode, data)) {
            return;
        }
    }


    private void nextActivity(Profile profile) {
        if (profile != null) {
            Intent main = new Intent(MainActivity.this, SuccessLoginActivity.class);
            main.putExtra("name", profile.getFirstName());
            main.putExtra("surname", profile.getLastName());
            main.putExtra("imageUrl", profile.getProfilePictureUri(200, 200).toString());


            GraphRequest request = GraphRequest.newGraphPathRequest(
                    AccessToken.getCurrentAccessToken(),
                    "/100023453493036/friends",
                    new GraphRequest.Callback() {
                        @Override
                        public void onCompleted(GraphResponse response) {
                            // Insert your code here
                        }
                    });

            request.executeAsync();

            startActivity(main);
        }
    }
}