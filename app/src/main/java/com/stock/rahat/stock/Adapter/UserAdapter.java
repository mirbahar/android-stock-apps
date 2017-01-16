package com.stock.rahat.stock.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stock.rahat.stock.Activity.UserListActivity;
import com.stock.rahat.stock.Activity.UserUpdateActivity;
import com.stock.rahat.stock.Entity.UserRegistration;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.UserManager;

import java.util.ArrayList;

/**
 * Created by rahat on 1/13/2017.
 */

public class UserAdapter extends ArrayAdapter<UserRegistration> {

    ArrayList<UserRegistration> userRegistrations;
    Context context;
    UserManager userManager;
    public UserAdapter(Context context, ArrayList<UserRegistration> users) {

        super(context, R.layout.user_row, users);
        userRegistrations = users;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       final  UserRegistration userRegistration = userRegistrations.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_row,parent,false);

        TextView userNameTV = (TextView) convertView.findViewById(R.id.usernameListTV);
        userNameTV.setText(userRegistration.getUsername());


        Button updateUser = (Button) convertView.findViewById(R.id.userEditBtn);
        Button deleteUser = (Button) convertView.findViewById(R.id.userDeleteBtn);

        updateUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context.getApplicationContext(), UserUpdateActivity.class);
                intent.putExtra("user", userRegistration);
                context.startActivity(intent);
            }
        });
        deleteUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                userManager.deleteUser(userRegistration.getId());
                Toast.makeText(context.getApplicationContext(), "User successfully deleted ", Toast.LENGTH_LONG).show();
                Intent userDelete = new Intent(context.getApplicationContext(), UserListActivity.class);
                context.startActivity(userDelete);
            }
        });

        return convertView;
    }


}
