package com.stock.rahat.stock.Repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.stock.rahat.stock.Database.DatabaseHelper;
import com.stock.rahat.stock.Entity.Product;

import java.util.ArrayList;

/**
 * Created by rahat on 1/12/17.
 */

public class ProductManager {

    Context context;
    DatabaseHelper databaseHelper;
    SQLiteDatabase sqLiteDatabase;
    Product product;

    public ProductManager(Context context) {

        databaseHelper=new DatabaseHelper(context);
        this.context = context;
    }

    public long addProduct(Product product){

        sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_NAME,product.getProductName());
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_TYPE,product.getProductType());
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_QUANTITY,product.getProductQty());
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_BRAND,product.getProductBrand());

        long insertedRow = sqLiteDatabase.insert(DatabaseHelper.PRODUCT_TABLE,null,contentValues);

        sqLiteDatabase.close();

        return insertedRow;
    }

    public ProductManager open() throws SQLException {
        sqLiteDatabase = databaseHelper.getWritableDatabase();
        return this;
    }

    public ArrayList<Product> getAllProducts(){

        ArrayList<Product>allProducts = new ArrayList<>();

        String selectQuery="select * from "+DatabaseHelper.PRODUCT_TABLE;

        sqLiteDatabase=databaseHelper.getReadableDatabase();
        Cursor cursor=sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_ID));
                String pName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_NAME));
                String pType = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_TYPE));
                String pQty = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_QUANTITY));
                String pBrand = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_BRAND));

                Product product = new Product(id,pName,pType, pQty,pBrand);
                allProducts.add(product);

            }while (cursor.moveToNext());
        }
        return allProducts;
    }

    public Product getSingleProductByID(int id){

        sqLiteDatabase = databaseHelper.getReadableDatabase();
        String selectQuery="select * from "+DatabaseHelper.PRODUCT_TABLE+" where "+DatabaseHelper.PRODUCT_COLUMN_ID+" = "+id;

        Cursor cursor = sqLiteDatabase.rawQuery(selectQuery,null);
        if(cursor.moveToFirst()){
            String pName = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_NAME));
            String pType = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_TYPE));
            String pQty = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_QUANTITY));
            String pBrand = cursor.getString(cursor.getColumnIndex(DatabaseHelper.PRODUCT_COLUMN_BRAND));


            product = new Product(pName,pType,pQty,pBrand);
        }
        return product;
    }

    public long updateProduct(Product product) {

        sqLiteDatabase = databaseHelper.getWritableDatabase();

        ContentValues contentValues = new ContentValues();

        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_NAME,product.getProductName());
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_TYPE,product.getProductType());
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_QUANTITY,product.getProductQty());
        contentValues.put(DatabaseHelper.PRODUCT_COLUMN_BRAND,product.getProductBrand());

        long updateRow = sqLiteDatabase.update(DatabaseHelper.PRODUCT_TABLE,contentValues,DatabaseHelper.PRODUCT_COLUMN_ID+" =? ",
                        new String[]{String.valueOf(product.getId())});
        sqLiteDatabase.close();
        return updateRow;
    }
    public void deleteProduct(Product product){

         sqLiteDatabase = databaseHelper.getWritableDatabase();
         sqLiteDatabase.delete(DatabaseHelper.PRODUCT_TABLE, DatabaseHelper.PRODUCT_COLUMN_ID+"=?", new String[]{String.valueOf(product.getId())});
         sqLiteDatabase.close();
    }

}
