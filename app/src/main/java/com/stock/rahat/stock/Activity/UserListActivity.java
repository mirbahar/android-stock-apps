package com.stock.rahat.stock.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.stock.rahat.stock.Adapter.UserAdapter;
import com.stock.rahat.stock.Entity.UserRegistration;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.UserManager;

import java.util.ArrayList;

public class UserListActivity extends AppCompatActivity {

    ListView userLV;

    ArrayList<UserRegistration>allUsers;
    UserAdapter userAdapter;
    UserManager userManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_list);

        userLV = (ListView) findViewById(R.id.userLV);

        userManager = new UserManager(this);
        allUsers = userManager.getAllUsers();
        userAdapter = new UserAdapter(this,allUsers);
        userLV.setAdapter(userAdapter);

    }
}
