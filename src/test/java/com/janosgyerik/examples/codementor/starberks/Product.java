package com.janosgyerik.examples.codementor.starberks;

public class Product {

    // TODO delete these
    public String Inventory;
    public int numOfProducts;
    public void showProductDetails(String productName2) { }

    private String productName;
    private int demandRate;
    private double setupCost;
    private double unitCost;
    private double inventoryCost;
    private double sellingPrice;

    public Product(String name, int demand, double setup, double unit, double inventory, double selling) {
        productName = name;
        demandRate = demand;
        setupCost = setup;
        unitCost = unit;
        inventoryCost = inventory;
        sellingPrice = selling;
    }

    public Product() {

    }


    // call this method when user adds product to inventory

    //	if (productExists) {
    //  System.out.println("Product already stored. Do you want to edit this product?");
    //	}
    // if product already exists,
    // program will show a message and the
    // user will have the option to change the name or change the data in this product.

    //accessors and mutators
    public void setName(String n) {

        productName = n;
    }

    public String getName() {

        return productName;
    }

    public void setDemandRate(int d) {

        demandRate = d;
    }

    public int getDemandRate() {

        return demandRate;
    }

    public void setSetupCost(double s) {

        setupCost = s;
    }

    public double getSetupCost() {

        return setupCost;
    }

    public void setUnitCost(double u) {

        unitCost = u;
    }

    public double getUnitCost() {

        return unitCost;
    }

    public void setInvtCost(double i) {

        inventoryCost = i;
    }

    public double getInvtCost() {

        return inventoryCost;
    }

    public void setPrice(double p) {

        sellingPrice = p;
    }

    public double getPrice() {

        return sellingPrice;
    }


    ///only methods needed in this class are the accessor and mutator methods
    //i.e; one set method and one get method for each variable.
}

