package com.stock.rahat.stock.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.stock.rahat.stock.Database.DatabaseHelper;
import com.stock.rahat.stock.Entity.UserRegistration;

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
        contentValues.put(DatabaseHelper.USER_COLUMN_FULL_EMAIL,userRegistration.getEmail());

        long insertedRow = sqLiteDatabase.insert(DatabaseHelper.USER_TABLE,null,contentValues);

        sqLiteDatabase.close();

        return insertedRow;
    }

}
