package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.stock.rahat.stock.R;

/**
 * Created by rahat on 2/1/2017.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    public boolean onCreateOptionsMenu(android.view.Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.my_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.home_menu:
                // go to home page
                Intent homePageIntent = new Intent(BaseActivity.this,ProductListActivity.class);
                startActivity(homePageIntent);
                break;
            case R.id.account_setting_menu:
                // got account setting page;
                Toast.makeText(this, "account setting menu", Toast.LENGTH_SHORT).show();
                break;
            case R.id.logout_menu:

                SharedPreferences saveUserData = getSharedPreferences("UserInfo",MODE_PRIVATE );

                SharedPreferences.Editor editor = saveUserData.edit();
                int userId = saveUserData.getInt("userId",0);
                String username = saveUserData.getString("username","");
                editor.remove("userId");
                editor.remove("username");
                editor.apply();
                editor.commit();
                Intent intent = new Intent(BaseActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
