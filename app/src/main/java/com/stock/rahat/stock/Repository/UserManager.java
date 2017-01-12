package com.stock.rahat.stock.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.stock.rahat.stock.Database.DatabaseHelper;
import com.stock.rahat.stock.Entity.UserRegistration;

import java.util.ArrayList;

/**
 * Created by rahat on 1/12/17.
 */

public class UserManager {

    Context context;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;


    public UserManager(Context context) {

        databaseHelper=new DatabaseHelper(context);
    }

    public long addUser(UserRegistration userRegistration){

        sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.USER_COLUMN_FULL_NAME,userRegistration.getFullName());
        contentValues.put(DatabaseHelper.USER_COLUMN_USERNAME,userRegistration.getUsername());
        contentValues.put(DatabaseHelper.USER_COLUMN_PASSWORD,userRegistration.getPassword());
        contentValues.put(DatabaseHelper.USER_COLUMN_FULL_EMAIL,userRegistration.getEmail());

        long insertedRow = sqLiteDatabase.insert(DatabaseHelper.USER_TABLE,null,contentValues);

        sqLiteDatabase.close();

        return insertedRow;
    }
    public ArrayList<String> userLogin(UserRegistration userRegistration){

        sqLiteDatabase = databaseHelper.getWritableDatabase();
        ArrayList<String>usersInfo = new ArrayList<>();


        String[] whereArgs = new String[] { String.valueOf(userRegistration.getUsername()),String.valueOf(userRegistration.getPassword()) };

        String selectQuery =("SELECT "+DatabaseHelper.USER_COLUMN_USERNAME+" , "+DatabaseHelper.USER_COLUMN_PASSWORD+" FROM " + DatabaseHelper.USER_TABLE +
                            " WHERE "+ DatabaseHelper.USER_COLUMN_USERNAME+" = ?  and "+
                            DatabaseHelper.USER_COLUMN_PASSWORD+" = ? ,"+whereArgs );


        sqLiteDatabase = databaseHelper.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);

        if(cursor.moveToFirst()){


            String userName = cursor.getString(0);
            String password = cursor.getString(1);
            usersInfo.add(userName);
            usersInfo.add(password);
            return usersInfo;

        } else {
            usersInfo.add("");
            usersInfo.add("");
           return usersInfo;
        }

    }



}
