package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.stock.rahat.stock.R;

public class HomeActivity extends BaseActivity implements View.OnClickListener {

    Button userListBtn;
   Button productListBtn;
    Button createNewProductBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences saveUserData = getSharedPreferences("UserInfo",MODE_PRIVATE );
        int userId = saveUserData.getInt("userId",0);
        if(userId == 0){
           Intent intent = new Intent(HomeActivity.this,LoginActivity.class);
            startActivity(intent);
        } else {
            setContentView(R.layout.activity_home);
        }


        userListBtn = (Button) findViewById(R.id.userListBtn);
        productListBtn = (Button) findViewById(R.id.productListBtn);

        userListBtn.setOnClickListener(this);
        productListBtn.setOnClickListener(this);

        userListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent userListActivity = new Intent(HomeActivity.this,UserListActivity.class);
                startActivity(userListActivity);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.productListBtn:
                Intent productListActivity = new Intent(HomeActivity.this,ProductListActivity.class);
                startActivity(productListActivity);
                break;

        }

    }
}
