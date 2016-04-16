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

    private void EOQ(int setupCost, int demandPerWeek, double inventoryCostPerUnitPerWeek) {
        double temp = (2 * setupCost * demandPerWeek) / inventoryCostPerUnitPerWeek;
        quantity = Math.sqrt(temp);
        Math.round(quantity);
        System.out.println("The EOQ for this product is : " + quantity);
        System.out.println("Would you like to calculate the replenishment strategy for another product?");
        // call manageResponse();

    }

    public void addProduct(Product product) {

    }

    public void showReplenishmentStrategy(int week) {


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


}

