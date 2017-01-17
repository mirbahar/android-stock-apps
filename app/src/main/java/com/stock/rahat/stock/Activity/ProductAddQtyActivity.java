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

public class ProductAddQtyActivity extends AppCompatActivity {

    EditText addQtyET;
    Button addQtyBtn;
    ProductManager productManager;
    Product product;
    Validation validation = new Validation();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_add_qty);

        addQtyET = (EditText) findViewById(R.id.addQtyET);

        addQtyBtn = (Button) findViewById(R.id.addQtysaveBtn);

        productManager  = new ProductManager(this);


        product = (Product) getIntent().getSerializableExtra("products");
    }

    public void AddQuantity(View view) {

        String pQty = addQtyET.getText().toString();
        if(validation.pQty(pQty)){
            addQtyET.setError("Add Qty");
        }

        product = productManager.getSingleProductByID(product.getId());
        double fromDb = Double.parseDouble( product.getProductQty());
        double AddQty = Double.parseDouble( pQty);

        String totalProductQty = String.valueOf(fromDb + AddQty);

        Product updateProductInfo = new Product(product.getId(),totalProductQty);

        long updateResult = productManager.updateProduct(updateProductInfo);


        if( updateResult > 0){
            Toast.makeText(this,String.valueOf(updateResult), Toast.LENGTH_SHORT).show();
        }
        Intent intent = new Intent(ProductAddQtyActivity.this,ProductListActivity.class);
        startActivity(intent);

    }
}
