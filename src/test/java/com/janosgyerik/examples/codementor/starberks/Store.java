package com.janosgyerik.examples.codementor.starberks;

public class Store {

    double quantity;
    double inventoryCostPerUnitPerWeek;


    int demandPerWeek;
    int setupCost;
    int inventory;

    int timesSetup = 1;

    private Product product1; // = new Product("coffee", 7, 0.6,0.6,0.6,0.6);
    private Product product2;
    private Product product3;

    private int numberOfProducts = 0;

    private void EOQ(int setupCost, int demandPerWeek, double inventoryCostPerUnitPerWeek) {
        double temp = (2 * setupCost * demandPerWeek) / inventoryCostPerUnitPerWeek;
        quantity = Math.sqrt(temp);
        Math.round(quantity);
        System.out.println("The EOQ for this product is : " + quantity);
        System.out.println("Would you like to calculate the replenishment strategy for another product?");
        // call manageResponse();

    }

    public boolean addProduct(Product product) {
        if (product1 == null) {
            product1 = product;
            numberOfProducts++;
            return true;
        }
        if (product2 == null) {
            product2 = product;
            numberOfProducts++;
            return true;
        }
        if (product3 == null) {
            product3 = product;
            numberOfProducts++;
            return true;
        }
        return false;
    }

    public void removeOneProduct() {
        product1 = null;
        numberOfProducts--;
    }

    public void showReplenishmentStrategy(Product product, int week) {
        int quantityOrder =
                (int) Math.round(Math.sqrt(2 * product.getSetupCost() * product.getDemandRate() / product.getInvtCost()));

        int inventory = quantityOrder;
        printHeader();
        for (int i = 1; i <= week; i++) {
            if (inventory < product.getDemandRate()) {
                quantityOrder = calculateBestReplenishmentQuantity(product.getDemandRate(), inventory, week - i + 1);
                inventory += quantityOrder;
            }
            inventory -= product.getDemandRate();

            // 1, 141, 45, 141 - 45 = 96
            // 2,   0, 45, 96 - 45 = 51
            // 3,   0, 45, 51 - 45 = 6
            // 4, 129, 45, 129 + 6 - 45 = 90
            printColumns(i, quantityOrder, product.getDemandRate(), inventory);

            quantityOrder = 0;
        }
    }

    int calculateBestReplenishmentQuantity(int demandRate, int inventory, int remainingWeeks) {
        // TODO figure out formula to return 129 for product with demand rate 45, inventory 6, remaining weeks 3
        // TODO figure out formula to return  84 for product with demand rate 45, inventory 6, remaining weeks 2
        // TODO figure out formula for larger remainingWeeks
        return remainingWeeks * demandRate - inventory;
    }

    private void printColumns(int week, int quantityOrder, int demandRate, int inventory) {
        // TODO
    }

    private void printHeader() {
        // TODO
    }

    public void showBestReplenishmentStrategy() {

        // // have product data, program will output the best replenishment strategy
        // which will be the product with the highest profit. You do not
        // need to print the replenishment strategy, just the name of the product and its profit.
    }

    private void printReplenishmentStrategy(int n, int week, int quantityOrder, int demand, int inventory) {

        week = n;
        inventory = quantityOrder - demand;

        System.out.println("Week " + "Quantity Order " + "Demand " + "Inventory ");

        while (week != n) {

            System.out.println(week + quantity + demandPerWeek + inventory);
            inventory = inventory - demand;
            timesSetup++;
            week++;

        }
    }

    private void calculateProfit() {
        double purchase = (setupCost * timesSetup) + quantity;
//        double inventory = inventory * inventoryCostPerUnitPerWeek;
//        double totalCost = purchase + inventory;
//
//        double profit = (demand * week * sellingPrice) - totalCost;
    }


    public void showProductDetails(String t) {
//        System.out.println("Product Name : $" + productName);
//        System.out.println("Demand Rate : $" + demandRate);
//        System.out.println("Steup Cost : $" + setupCost);
//        System.out.println("Unit Cost : $" + unitCost);
//        System.out.println("Inventory Cost : $" + inventoryCost);
//        System.out.println("Selling Price : $" + sellingPrice);
    }


    public void showBestReplacementStrategy(Product p) {

    }

    public void showProfit() {
        // show product with highest profit. just print name and profit
    }


    // if (inventory < demand),
    // quantityOrdered = quantity

    // if week == n,
    // quantity = quantityOrder - inventory



/*
 *
 *  	do {
			System.out.println("Type 1 for yes, 2 for no.");
		} while (!keyboard.hasNextInt());
		{
			System.out.println("Please type in 1 for yes, 2 for no.");
			keyboard.next();
			// restart method
			}
		int response = keyboard.nextInt();
 *
 *
 *
 *
	do {
        System.out.println("Please enter a positive number!");
        while (!sc.hasNextInt()) {
            System.out.println("That's not a number!");
            sc.next(); // this is important!
        }
        number = sc.nextInt();
    } while (number <= 0);
    System.out.println("Thank you! Got " + number);
    }
*/

    private void manageResponse() {
        int response = 0;
        switch (response) {
            case 1:

                break;
            case 2:

                break;
            default:
                System.out.println("Please enter 1 for yes, 2 for no.");
//                EOQ( double setup, double demandPerWeek, double inventoryCostPerUnitPerWeek);
                break;
        }
    }


    public boolean isEmpty() {
        return numberOfProducts == 0;
    }

    public boolean containsProduct(String name) {
        return false;
    }

    public Product getProduct(String name) {
        if (product1 != null && product1.getName().equalsIgnoreCase(name)) {
            return product1;
        }
        // TODO same for product2 and 3
        return null;
    }
}

