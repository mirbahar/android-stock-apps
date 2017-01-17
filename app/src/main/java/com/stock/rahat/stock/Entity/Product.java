package com.stock.rahat.stock.Entity;

/**
 * Created by rahat on 1/17/17.
 */

public class Product {

    private int id;
    private String productName;
    private String productType;
    private double productQty;
    private String productBrand;

    public Product(int id, String productName, String productType, double productQty, String productBrand) {


        this.productName = productName;
        this.productType = productType;
        this.productQty = productQty;
        this.productBrand = productBrand;
    }
    public Product(String productName, String productType, double productQty, String productBrand) {

        this.productName = productName;
        this.productType = productType;
        this.productQty = productQty;
        this.productBrand = productBrand;
    }
    public Product(int id, double productQty) {

        this.id = id;
        this.productQty = productQty;

    }

    public int getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductType() {
        return productType;
    }

    public double getProductQty() {
        return productQty;
    }

    public String getProductBrand() {
        return productBrand;
    }
}
