package com.stock.rahat.stock.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.stock.rahat.stock.Adapter.ProductAdapter;
import com.stock.rahat.stock.Entity.Product;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.ProductManager;

import java.util.ArrayList;

public class ProductListActivity extends BaseActivity {

    ListView productListView;
   Button createProductBtn;
    ArrayList<Product>allProducts;

    ProductAdapter productAdapter;
    ProductManager productManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        productListView = (ListView) findViewById(R.id.productListLV);
        createProductBtn = (Button) findViewById(R.id.insertProductBtn);
        // get Shared preference data
     //   SharedPreferences saveUserData = getSharedPreferences("UserInfo",MODE_PRIVATE );

        productManager = new ProductManager(this);
        allProducts = productManager.getAllProducts();
        productAdapter = new ProductAdapter(this,allProducts);
        productListView.setAdapter(productAdapter);

        productListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                int productId = allProducts.get(position).getId();

//                Toast.makeText(ProductListActivity.this,String.valueOf(position), Toast.LENGTH_SHORT).show();

                Intent updateIntent = new Intent(ProductListActivity.this,ProductListActivity.class);
                updateIntent.putExtra("id",productId);
                startActivity(updateIntent);
            }
        });

        createProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent insertProduct = new Intent(ProductListActivity.this,ProductInsertActivity.class);
                startActivity(insertProduct);

            }
        });

    }

}
