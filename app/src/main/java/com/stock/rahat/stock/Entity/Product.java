package com.stock.rahat.stock.Entity;

import java.io.Serializable;

/**
 * Created by rahat on 1/17/17.
 */

public class Product implements Serializable {

    public int getId() {
        return this.id;
    }
    private int id;
    private String productName;
    private String productType;
    private String productQty;
    private String productBrand;

    public Product(int id, String productName, String productType, String productQty, String productBrand) {


        this.productName = productName;
        this.productType = productType;
        this.productQty = productQty;
        this.productBrand = productBrand;
    }
    public Product(String productName, String productType, String productQty, String productBrand) {

        this.productName = productName;
        this.productType = productType;
        this.productQty = productQty;
        this.productBrand = productBrand;
    }
    public Product(int id, String productQty) {

        this.id = id;
        this.productQty = productQty;

    }



    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public String getProductQty() {
        return productQty;
    }

    public String getProductBrand() {
        return productBrand;
    }
}
