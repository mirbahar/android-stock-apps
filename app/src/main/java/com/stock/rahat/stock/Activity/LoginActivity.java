package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.UserManager;
import com.stock.rahat.stock.libraries.Validation;

public class LoginActivity extends AppCompatActivity {

    EditText usernameET ;
    EditText passwordET;
    Button loginBtn;
    UserManager userManager;
    Validation validation = new Validation();

    public int logInTryCount = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        userManager = new UserManager(this);

        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        loginBtn = (Button) findViewById(R.id.loginBtn);


    }

    public void onClick(View view) {
        Intent intentRegistrationPage = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intentRegistrationPage);
    }

    public void login(View view){

             String username = usernameET.getText().toString();
             String password = passwordET.getText().toString();

        if  ((!validation.isUserName(username))|| (!validation.isValidPassword(password))) {
            if ((!validation.isValidPassword(password))){
                passwordET.setError("password minimum 6 digit");
            }
            if ((!validation.isUserName(username))){
                usernameET.setError("username not be blank");
            }
        } else {


            if (userManager.userLogin(username,password))
            {
                Toast.makeText(this,String.valueOf("login Successfully"), Toast.LENGTH_SHORT).show();

                Intent homePageActivity = new Intent(LoginActivity.this,HomeActivity.class);
                startActivity(homePageActivity);

            } else {
                 logInTryCount = logInTryCount+1;
                Toast.makeText(this,String.valueOf(logInTryCount), Toast.LENGTH_SHORT).show();

                if (logInTryCount< 3){
                    passwordET.setError("password dose not match");
                } else {
                    passwordET.setError("already try to 3 times ");

                }

            }
        }

    }


}
