package com.stock.rahat.stock.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

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
    UserManager userManager;
    UserRegistration userRegistration;

    public UserManager(Context context) {

        databaseHelper=new DatabaseHelper(context);
        this.context = context;
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

    public UserManager open() throws SQLException {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        return this;
    }

    public boolean userLogin(String username, String password){

        sqLiteDatabase = databaseHelper.getReadableDatabase();

        Cursor cursor = databaseHelper.getReadableDatabase().rawQuery(
                "SELECT * FROM " + DatabaseHelper.USER_TABLE + " WHERE "
                        + DatabaseHelper.USER_COLUMN_USERNAME + "='" + username +"'AND "+DatabaseHelper.USER_COLUMN_PASSWORD+"='"+password+"'" ,  null);
        if (cursor.getCount() > 0)
            return true;
        return false;
    }

    public ArrayList<UserRegistration> getAllUsers(){

        ArrayList<UserRegistration>allUsers=new ArrayList<>();

        String selectQuery="select * from "+DatabaseHelper.USER_TABLE;

        sqLiteDatabase=databaseHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_ID));
                String fullName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_FULL_NAME));
                String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_USERNAME));
                String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_FULL_EMAIL));
                UserRegistration userRegistration = new UserRegistration(id,fullName,username,email);
                allUsers.add(userRegistration);

            }while (cursor.moveToNext());
        }
        return allUsers;
    }

    public UserRegistration getSingleUserByID(int id){

        sqLiteDatabase = databaseHelper.getReadableDatabase();
        String selectQuery="select * from "+DatabaseHelper.USER_TABLE+" where "+DatabaseHelper.USER_COLUMN_ID+" = "+id;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            String fullName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_FULL_NAME));
            String username = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_USERNAME));
            String email = cursor.getString(cursor.getColumnIndex(DatabaseHelper.USER_COLUMN_FULL_EMAIL));
            userRegistration = new UserRegistration(id,fullName,username,email);
        }
        return userRegistration;
    }

    public long updateUser(UserRegistration userRegistration) {

        sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.USER_COLUMN_FULL_EMAIL,userRegistration.getFullName());
        contentValues.put(DatabaseHelper.USER_COLUMN_USERNAME,userRegistration.getUsername());
        contentValues.put(DatabaseHelper.USER_COLUMN_FULL_EMAIL,userRegistration.getEmail());

        long updateRow = sqLiteDatabase.update(DatabaseHelper.USER_TABLE,contentValues,DatabaseHelper.USER_COLUMN_ID+" =? ",
                        new String[]{String.valueOf(userRegistration.getId())});
        sqLiteDatabase.close();
        return updateRow;
    }
    public void deleteUser(UserRegistration userRegistration){

         sqLiteDatabase = databaseHelper.getWritableDatabase();
         sqLiteDatabase.delete(DatabaseHelper.USER_TABLE, DatabaseHelper.USER_COLUMN_ID+"=?", new String[]{String.valueOf(userRegistration.getId())});
         sqLiteDatabase.close();
    }

}
