package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

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

        userLV.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int userId = allUsers.get(position).getId();
                Toast.makeText(UserListActivity.this,String.valueOf(userId), Toast.LENGTH_SHORT).show();
                Intent updateIntent = new Intent(UserListActivity.this,RegistrationActivity.class);
                updateIntent.putExtra("id",userId);
                startActivity(updateIntent);
            }
        });

    }

}
