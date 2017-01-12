package com.stock.rahat.stock.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stock.rahat.stock.Entity.UserRegistration;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.UserManager;
import com.stock.rahat.stock.libraries.Validation;

public class RegistrationActivity extends AppCompatActivity {

    EditText fullNameET;
    EditText userNameET;
    EditText emailET;
    EditText passwordET;
    Button registrationBtn;
    UserManager userManager;
    Validation validation = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userManager  = new UserManager(this);

        fullNameET = (EditText) findViewById(R.id.fullNameET);
        userNameET = (EditText) findViewById(R.id.usernameET);
        emailET = (EditText) findViewById(R.id.emailET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        registrationBtn = (Button) findViewById(R.id.registrationBtn);
    }

    public void save(View view) {

        String fullName = fullNameET.getText().toString();
        String userName = userNameET.getText().toString();
        String email = emailET.getText().toString();
        String password = passwordET.getText().toString();
        UserRegistration userRegistration = new UserRegistration(fullName,userName,email,password);

        if  ( (!validation.isValidEmail(email))
                || (!validation.isValidPassword(password))
                || (!validation.isFullName(fullName))
                || (!validation.isUserName(userName))
            ) {
            if((!validation.isValidEmail(email))){
                emailET.setError("Invalid Email");
            }
            if ((!validation.isValidPassword(password))){
                passwordET.setError("password minimum 6 digit");
            }
            if ((!validation.isFullName(fullName))){
                fullNameET.setError("should not be blank name");
            }
            if ((!validation.isUserName(userName))){
                userNameET.setError("username not be blank");
            }
        } else{

            long insertedResult = userManager.addUser(userRegistration);

            if(insertedResult>0){
                Toast.makeText(this,String.valueOf(insertedResult), Toast.LENGTH_SHORT).show();
            }
        }



    }

}
