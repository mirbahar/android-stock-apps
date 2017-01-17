package com.stock.rahat.stock.Activity;

import android.content.Intent;
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

public class UserUpdateActivity extends AppCompatActivity {


    EditText fullNameET;
    EditText userNameET;
    EditText emailET;
    Button button;
    UserManager userManager;
    UserRegistration userRegistration;

    Validation validation = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_update);

        userManager  = new UserManager(this);

        fullNameET = (EditText) findViewById(R.id.fullNameET);
        userNameET = (EditText) findViewById(R.id.usernameET);
        emailET = (EditText) findViewById(R.id.emailET);
        button = (Button) findViewById(R.id.registrationBtn);

        userRegistration = (UserRegistration) getIntent().getSerializableExtra("user");

            fullNameET.setText(userRegistration.getFullName());
            userNameET.setText(userRegistration.getUsername());
            emailET.setText(userRegistration.getEmail());
    }

    public void update(View view) {

        String fullName = fullNameET.getText().toString();
        String userName = userNameET.getText().toString();
        String email = emailET.getText().toString();

        UserRegistration updateUserInfo = new UserRegistration(userRegistration.getId(),fullName,userName,email);

        if  ( (!validation.isValidEmail(email)) || (!validation.isFullName(fullName))|| (!validation.isUserName(userName))
                )
        {
            if((!validation.isValidEmail(email))){
                emailET.setError("Invalid Email");
            }
            if ((!validation.isFullName(fullName))){
                fullNameET.setError("should not be blank name");
            }
            if ((!validation.isUserName(userName))){
                userNameET.setError("username not be blank");
            }
        } else {
                long updateResult = userManager.updateUser(updateUserInfo);

                if( updateResult > 0){
                    Toast.makeText(this,String.valueOf(updateResult), Toast.LENGTH_SHORT).show();
                }
            Intent intent = new Intent(UserUpdateActivity.this,UserListActivity.class);
            startActivity(intent);
        }

    }
}
