package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stock.rahat.stock.R;

public class LoginActivity extends AppCompatActivity {

    Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = (Button) findViewById(R.id.loginBtn);
    }


    public void onClick(View view) {

        Intent intentRegistrationPage = new Intent(LoginActivity.this,RegistrationActivity.class);
        startActivity(intentRegistrationPage);
    }
}
