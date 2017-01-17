package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.stock.rahat.stock.Entity.Product;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.ProductManager;
import com.stock.rahat.stock.libraries.Validation;

public class ProductInsertActivity extends AppCompatActivity {

    EditText productNameET;
    EditText productTypeET;
    EditText productQtyET;
    EditText productBrandET;
    Button productSaveBtn;
    ProductManager productManager;
    Validation validation = new Validation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_insert);

        productManager  = new ProductManager(this);

        productNameET  = (EditText) findViewById(R.id.productNameET);
        productTypeET  = (EditText) findViewById(R.id.productTypeET);
        productQtyET   = (EditText) findViewById(R.id.productQtyET);
        productBrandET = (EditText) findViewById(R.id.productBrandET);
        productSaveBtn = (Button) findViewById(R.id.productSaveBtn);

    }

    public void saveProduct(View view) {

        String pName = productNameET.getText().toString();
        String pType = productTypeET.getText().toString();
        String pQty = productQtyET.getText().toString();
        String pBrand = productBrandET.getText().toString();

        Product product = new Product(pName,pType,pQty,pBrand);

        if  ( (!validation.pName(pName))
                || (!validation.pType(pType))
                || (!validation.pBrand(pBrand))
                || (!validation.pQty(String.valueOf(pQty)))
                )
        {
            if((!validation.pName(pName))){
                productTypeET.setError("Product Name Should Not be Blank");
            }
            if ((!validation.pType(pType))){
                productTypeET.setError("Product Name Should Not be Blank");
            }
            if ((!validation.pQty(String.valueOf(pQty)))){
                productQtyET.setError("Product Name Should Not be Blank");
            }
            if ((!validation.pBrand(pBrand))){
                productBrandET.setError("Product Name Should Not be Blank");
            }
        } else {
            long insertedResult = productManager.addProduct(product);

            if(insertedResult > 0){
                Toast.makeText(ProductInsertActivity.this,String.valueOf(insertedResult), Toast.LENGTH_SHORT).show();
            }
            Intent intentProduct = new Intent(ProductInsertActivity.this,ProductListActivity.class);
            startActivity(intentProduct);
        }



    }
}
