package com.vinay.garathanproject;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    public static final String LOGIN_SETTINGS = "login _Settings";
    public static final String LOGIN_STATUS = "loginStatus";
    ImageView imageView;
    EditText email, password;
    CheckBox remember_me;
    TextView forgot_password;
    Button login, sign_up;
    TextView error_message;

    SharedPreferences sharedPreferences;
    public static final String LOGIN_PREFS = "login_prefs";
    SharedPreferences.Editor editor;
    boolean login_Settings;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        imageView = findViewById(R.id.image);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        remember_me = findViewById(R.id.remember_me);
        forgot_password = findViewById(R.id.forgot_password);
        login = findViewById(R.id.login);
        sign_up = findViewById(R.id.sign_up);
        error_message = findViewById(R.id.error_message);
        sharedPreferences = getApplicationContext().getSharedPreferences(LOGIN_PREFS, Context.MODE_PRIVATE);
        login_Settings = sharedPreferences.getBoolean(LOGIN_SETTINGS, false);


//        remember_me.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                // EDITOR INSTANCE TO SAVE THE NAG SETTING
//                editor = sharedPreferences.edit();
//
//                // GET THE NAG SETTING CHECKBOX
//                if (remember_me.isChecked())    {
//
//                    editor.putBoolean(LOGIN_SETTINGS, true);
//                } else {
//                    editor.putBoolean(LOGIN_SETTINGS, false);
//                }
//
//                editor.apply();
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                if(email.getText().length() <= 0 || password.getText().length() <= 0) {
                    error_message.setVisibility(View.VISIBLE);
                    error_message.setText("User/Password is invalid!");
                } else {
                    if(isValidEmail(email.getText().toString())) {
                        moveToNextScreen(email.getText().toString(), password.getText().toString());
                    } else {
                        error_message.setVisibility(View.VISIBLE);
                        error_message.setText("Email is invalid!");
                    }
                }
            }
        });


    }

    private void moveToNextScreen(String emailText, String passwordText){
        if(emailText.equalsIgnoreCase("mathew.robert@fedex.com") && passwordText.equalsIgnoreCase("password")) {
            editor = sharedPreferences.edit();
            editor.putBoolean(LOGIN_STATUS, true);
            editor.commit();

            // SHOW THE LOGIN SCREEN
            Intent intent = new Intent(LoginActivity.this, RequestListActivity.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(this, "User not found", Toast.LENGTH_SHORT).show();
        }
    }

    public static boolean isValidEmail(CharSequence target){
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }


}
