package com.stock.rahat.stock.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stock.rahat.stock.Entity.UserRegistration;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.UserManager;

public class RegistrationActivity extends AppCompatActivity {

    EditText fullNameET;
    EditText userNameET;
    EditText emailET;
    Button registrationBtn;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        userManager  = new UserManager(this);

        fullNameET = (EditText) findViewById(R.id.fullNameET);
        userNameET = (EditText) findViewById(R.id.usernameET);
        emailET = (EditText) findViewById(R.id.emailET);
        registrationBtn = (Button) findViewById(R.id.registrationBtn);
    }

    public void save(View view) {

        String fullName = fullNameET.getText().toString();
        String userName = userNameET.getText().toString();
        String email = emailET.getText().toString();

        UserRegistration userRegistration =new UserRegistration(fullName,userName,email);

        long insertedResult = userManager.addUser(userRegistration);

        if(insertedResult>0){
            Toast.makeText(this,String.valueOf(insertedResult), Toast.LENGTH_SHORT).show();
        }

    }
}
