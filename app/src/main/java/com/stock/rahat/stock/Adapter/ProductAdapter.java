package com.stock.rahat.stock.Adapter;

import android.content.Context;
import android.widget.ArrayAdapter;

import com.stock.rahat.stock.Database.DatabaseHelper;
import com.stock.rahat.stock.Entity.Product;
import com.stock.rahat.stock.Entity.UserRegistration;
import com.stock.rahat.stock.R;
import com.stock.rahat.stock.Repository.UserManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahat on 1/17/17.
 */

public class ProductAdapter extends ArrayAdapter<Product> {

    ArrayList<Product> products;

    Context context;
    DatabaseHelper databsehelper;

    public ProductAdapter(Context context, List<Product> productLists) {

        super(context, R.layout.user_row, productLists);

    }

}
