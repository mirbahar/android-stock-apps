package com.stock.rahat.stock.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.stock.rahat.stock.Entity.UserRegistration;
import com.stock.rahat.stock.R;

import java.util.ArrayList;

/**
 * Created by rahat on 1/13/2017.
 */

public class UserAdapter extends ArrayAdapter<UserRegistration> {

    ArrayList<UserRegistration> userRegistrations;
    Context context;
    public UserAdapter(Context context, ArrayList<UserRegistration> users) {

        super(context, R.layout.user_row, users);
        userRegistrations = users;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        UserRegistration userRegistration = userRegistrations.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.user_row,parent,false);

//        TextView fullNameTV = (TextView) convertView.findViewById(R.id.fullNameTV);
        TextView idTv = (TextView) convertView.findViewById(R.id.usernameListTV);
   //     TextView emailTV = (TextView) convertView.findViewById(R.id.emailTV);

//        fullNameTV.setText(userRegistration.getFullName());
        idTv.setText(userRegistration.getUsername());
   //     emailTV.setText(userRegistration.getEmail());

        return convertView;
    }
}
