package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.stock.rahat.stock.R;

public class HomeActivity extends AppCompatActivity {

    Button userListBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        userListBtn = (Button) findViewById(R.id.userListBtn);

        userListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent userListActivity = new Intent(HomeActivity.this,UserListActivity.class);
                startActivity(userListActivity);
            }
        });
    }

}
