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

public class LoginActivity extends AppCompatActivity {

    EditText usernameET ;
    EditText passwordET;
    Button loginBtn;
    UserManager userManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        usernameET = (EditText) findViewById(R.id.usernameET);
        passwordET = (EditText) findViewById(R.id.passwordET);
        loginBtn = (Button) findViewById(R.id.loginBtn);


    }


    public void onClick(View view) {

        Intent intentRegistrationPage = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intentRegistrationPage);
    }

    public void login(View view){


        if(usernameET.getText().toString().equals("admin") && passwordET.getText().toString().equals("admin")){

            //correcct password
            Toast.makeText(this,String.valueOf("success"), Toast.LENGTH_SHORT).show();
        }else{
            //wrong password
            Toast.makeText(this,String.valueOf("wrong"), Toast.LENGTH_SHORT).show();
        }
    }


}
