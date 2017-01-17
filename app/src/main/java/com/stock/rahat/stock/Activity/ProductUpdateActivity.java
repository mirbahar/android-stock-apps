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

public class ProductUpdateActivity extends AppCompatActivity {

    EditText productNameET;
    EditText productTypeET;
    EditText productQtyET;
    EditText productBrandET;
    Button productSaveBtn;
    ProductManager productManager;
    Product product;
    Validation validation = new Validation();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_update);


        productManager  = new ProductManager(this);

        productNameET  = (EditText) findViewById(R.id.productNameET);
        productTypeET  = (EditText) findViewById(R.id.productTypeET);
        productQtyET   = (EditText) findViewById(R.id.productQtyET);
        productBrandET = (EditText) findViewById(R.id.productBrandET);
        productSaveBtn = (Button) findViewById(R.id.productSaveBtn);

        product = (Product) getIntent().getSerializableExtra("products");
        Toast.makeText(this, String.valueOf(product.getId()), Toast.LENGTH_SHORT).show();

        productNameET.setText(product.getProductName());
        productTypeET.setText(product.getProductType());
        productQtyET.setText(product.getProductQty());
        productBrandET.setText(product.getProductBrand());
    }

    public void updateProduct(View view) {

        String pName = productNameET.getText().toString();
        String pType = productTypeET.getText().toString();
        String pQty = productQtyET.getText().toString();
        String pBrand = productBrandET.getText().toString();

        Product updateProductInfo = new Product(product.getId(),pName,pType,pQty,pBrand);

        if  (
                (!validation.pName(pName)) ||
                 (!validation.pType(pType))||
                 (!validation.pQty(pQty)) ||
                 (!validation.pBrand(pBrand))
                )
        {
            if((!validation.pName(pName))){
                productNameET.setError("Product Name Should not be blank");
            }
            if ((!validation.pType(pType))){
                productTypeET.setError("should not be blank name");
            }
            if ((!validation.pQty(pQty))){
                productQtyET.setError("Quantity not  blank");
            }
            if ((!validation.pBrand(pBrand))){
                productBrandET.setError("Brand not be blank");
            }
        } else {

            long updateResult = productManager.updateProduct(updateProductInfo);

            if( updateResult > 0){
                Toast.makeText(this,String.valueOf(updateResult), Toast.LENGTH_SHORT).show();
            }
            Intent intent = new Intent(ProductUpdateActivity.this,ProductListActivity.class);
            startActivity(intent);
        }

    }
}
