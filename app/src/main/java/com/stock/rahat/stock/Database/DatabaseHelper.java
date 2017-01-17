package com.stock.rahat.stock.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rahat on 1/12/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Stock_db";
    private static final int DATABASE_VERSION =4;

    public static final String USER_TABLE="users";
    public static final String PRODUCT_TABLE="products";

    public static final String  USER_COLUMN_ID = "userId";
    public static final String USER_COLUMN_FULL_NAME = "fullName";
    public static final String USER_COLUMN_USERNAME ="username";
    public static final String USER_COLUMN_PASSWORD ="password";
    public static final String USER_COLUMN_FULL_EMAIL = "email";


    public static final String PRODUCT_COLUMN_ID = "productId";
    public static final String PRODUCT_COLUMN_NAME = "name";
    public static final String PRODUCT_COLUMN_TYPE ="type";
    public static final String PRODUCT_COLUMN_QUANTITY ="quantity";
    public static final String PRODUCT_COLUMN_BRAND = "brand";

    // user table
    private static final String CREATE_TABLE_USER = "create table "+USER_TABLE+"("+
            USER_COLUMN_ID+" integer primary key autoincrement,"+
            USER_COLUMN_FULL_NAME + " text,"+
            USER_COLUMN_USERNAME + " text,"+
            USER_COLUMN_PASSWORD + " text,"+
            USER_COLUMN_FULL_EMAIL + " text);";

    // product table

    private static final String CREATE_TABLE_PRODUCT = "create table "+PRODUCT_TABLE+"("+
            PRODUCT_COLUMN_ID+" integer primary key autoincrement,"+
            PRODUCT_COLUMN_NAME + " text,"+
            PRODUCT_COLUMN_TYPE + " text,"+
            PRODUCT_COLUMN_QUANTITY + " text,"+
            PRODUCT_COLUMN_BRAND + " text);";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    db.execSQL(CREATE_TABLE_USER);
    db.execSQL(CREATE_TABLE_PRODUCT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (newVersion > oldVersion) {

            db.execSQL("drop table  if exists "+USER_TABLE);

            db.execSQL("drop table  if exists "+PRODUCT_TABLE);

            onCreate(db);
        }

    }
}
