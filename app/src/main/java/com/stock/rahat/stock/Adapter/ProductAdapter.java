package com.stock.rahat.stock.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.stock.rahat.stock.Activity.ProductAddQtyActivity;
import com.stock.rahat.stock.Activity.ProductListActivity;
import com.stock.rahat.stock.Activity.ProductUpdateActivity;
import com.stock.rahat.stock.Entity.Product;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.ProductManager;

import java.util.ArrayList;

/**
 * Created by rahat on 1/17/17.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    ArrayList<Product>products;

    Context context;
    ProductManager productManager;

    public ProductAdapter(Context context, ArrayList<Product> productLists) {

        super(context, R.layout.user_row, productLists);
        products = productLists;
        this.context = context;


    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Product product = products.get(position);

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.product_row,parent,false);

        productManager  = new ProductManager(context);

        productManager = productManager.open();

        TextView productNameTV = (TextView) convertView.findViewById(R.id.productNameTV);
        TextView productQtyTV = (TextView) convertView.findViewById(R.id.productQtyTV);

        productNameTV.setText(product.getProductName());
        productQtyTV.setText(  product.getProductQty());

        Button updateProduct = (Button) convertView.findViewById(R.id.ProductEditBtn);
        Button deleteProduct = (Button) convertView.findViewById(R.id.ProductDeleteBtn);
        Button addQtyProduct = (Button) convertView.findViewById(R.id.ProductAddQtyBtn);

        updateProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(context.getApplicationContext(), ProductUpdateActivity.class);
                intent.putExtra("products", product);
                context.startActivity(intent);
            }
        });

        deleteProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                productManager.deleteProduct(product);
                Toast.makeText(context, "Product Delete Successfully", Toast.LENGTH_SHORT).show();
                Intent productDelete = new Intent(context.getApplicationContext(), ProductListActivity.class);
                context.startActivity(productDelete);
            }
        });

        addQtyProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(context.getApplicationContext(), ProductAddQtyActivity.class);
                intent.putExtra("products", product);
                context.startActivity(intent);

            }
        });

        return convertView;
    }

}
