package com.janosgyerik.examples.codementor.starberks;

import com.janosgyerik.examples.codementor.starberks.Product;
import org.junit.Test;

import java.util.Scanner;

/**
 * @author Syed Hafizudin
 */
public class StarberksInterface {

    private static final Scanner keyboard = new Scanner(System.in);
    private static final Store Store = new Store();
    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;

    //after adding a product, numberOfProducts + 1. when this var reaches 3,
    // inventory is full and user can't add any more products
    int numberOfProducts = 0;

    // TODO delete
    Product product;

    private static void showHeader() {
        System.out.println("--------------------------------------");
        System.out.println("WELCOME TO STARBERKS INTERFACE");
        System.out.println("--------------------------------------");
    }

    private static void showMenu() {
        System.out.println("1. Input data for one product ");
        System.out.println("2. Show data from one product");
        System.out.println("3. Show the replenishment strategy for a product");
        System.out.println("4. Exit Program");
    }

    protected String readValidName(Scanner scanner) {
        while (true) {
            System.out.println("Enter the name of the product you would like to add :");
            String name = scanner.nextLine();
            if (isValidName(name)) {
                return name;
            }
            System.out.println("Invalid name: " + name);
        }
    }

    protected boolean isValidName(String name) {
        int length = name.length();
        return MIN_NAME_LENGTH <= length && length <= MAX_NAME_LENGTH;
    }

    public void inputProduct() {
        //get the information from the user

        System.out.println("Enter the name of the product you would like to add :");
        String name = keyboard.nextLine();
        // checking if name entered by user is => 3 and <= 10 characters long and if
        if (isValidName(name)) {
            if (productExists(name) == false) {
                if (numberOfProducts == 0) {
                    Product product1 = new Product();
                    name = name.toLowerCase();
                    product1.setName(name);
                    System.out.println("Name of product is : " + product1.getName());
                } else if (numberOfProducts == 1) {
                    Product product2 = new Product();
                    name = name.toLowerCase();
                    product2.setName(name);
                    System.out.println("Name of product is : " + product2.getName());
                } else {
                    Product product3 = new Product();
                    name = name.toLowerCase();
                    product3.setName(name);
                    System.out.println("Name of product is : " + product3.getName());
                }
            }
        }


        System.out.println("Enter the demand per week :");
        int demand = keyboard.nextInt();
        // checking if number entered by user is positive
        if (numberIsPositive(demand) == true) {
            product.setDemandRate(demand);
            System.out.println("Demand per week is : " + demand);
        }


        System.out.println("Enter the setup cost :");
        double setup = keyboard.nextDouble();
        // checking if double enter by user is positive
        if (doubleIsPositive(setup) == true) {
            product.setSetupCost(setup);
            System.out.println("Setup cost is : " + setup);
        }


        System.out.println("Enter unit cost :");
        double unit = keyboard.nextDouble();
        if (doubleIsPositive(unit) == true) {
            product.setUnitCost(unit);
            System.out.println("Unit cost is : " + unit);
        }


        System.out.println("Enter inventory cost :");
        double inv = keyboard.nextDouble();
        if (doubleIsPositive(inv) == true) {
            product.setInvtCost(inv);
            System.out.println("Inventory cost is : " + inv);
        }


        System.out.println("Enter selling price :");
        double price = keyboard.nextDouble();
        if (doubleIsPositive(price) == true) {
            product.setPrice(price);
            System.out.println("Selling price is : " + price);
        }


        // once all values typed in are ok, product count will increase by 1
        numberOfProducts++;
        // product name will be added to String inventory
        product.Inventory += name;
        showMenu();

    }

    public void choice2() {
        if (product.numOfProducts == 0) {
            noProductData();
        } else {
            // wrap this in do while loop?
            System.out.println("Enter the name of the product: ");
            String temp = keyboard.nextLine();
            checkForErrors(temp);
            if (checkForErrors(temp) == false) {
                String productName2 = temp.toLowerCase();
                if (productExists(productName2) == false) {
                    System.out.println("Product does not exist. ");
                    showMenu();
                } else {
                    product.showProductDetails(productName2);
                    run();
                }

            }
        }

    }

    public void choice3() {

        // if there is no product data, noProductData method will be called
        if (product.numOfProducts == 0) {
            noProductData();
        } else {
            System.out.println("Enter the name of the product:");
            String text = keyboard.nextLine();
            checkForErrors(text);
            if (checkForErrors(text) == false) {
                String productName = text.toLowerCase();
                if (productExists(productName) == false) {
                    // print error message and ask for input again
                    noProductData();
                }
            } else {
                // product exists
                System.out.println("Enter number of weeks:");
                int week = keyboard.nextInt();
                // print product replenishment strategy
                Store.showReplenishmentStrategy(week);
                // program will return to main menu
                run();
            }

        }

    }

    public void choice4() {

        if (numberOfProducts == 0) {
            System.out.println("Thank you and have a nice day!");
            System.exit(0);
        } else {
            //output highest profit method
            System.out.println("Product with highest profit is shown below : ");
            System.out.println("Product : ");  // + productname
            System.out.println("Profit : $ ");  // + profit
        }
    }

    // this method will be called when number of products is 0, i.e no product data
    // it will print an error message and go back to the main menu
    private void noProductData() {
        System.out.println("There is no product data to be shown");
        run();
    }

    private void errorMessage() {
        System.out.println("Please input a name between 3 and 10 characters :");
        String n = keyboard.nextLine();
        checkForErrors(n);
    }

    // this method checks if a product is already in the inventory
    // returns false if product does not exist
    // returns true if product exists in inventory
    boolean productExists(String nm) {
        int i = product.Inventory.indexOf(nm);
        boolean exists = true;
        if (i != -1) {
            // -1 means not found
            // not found means dont exist
            // dont exist, means productexists = false
            exists = false;
            return exists;
        } else {
            System.out.println("Product already exists. Would you like to edit this product? ");
            System.out.println("Type in 1 for yes, 2 for no.");
            int choice = 0;
            switch (choice) {
                case 1:
                    // call edit product function
                    break;
                case 2:
                    showMenu();
                    break;
                default:
                    System.out.println("Enter either 1 or 2");
                    productExists(nm);
                    break;
            }
        }

        return exists;

    }

    public boolean numberIsPositive(int n) {
        boolean positiveNumber = true;
        if (n < 0) {
            System.out.println("Value cannot be a negative number");
            numberIsPositive(n);
        }
        return positiveNumber;

    }

    public boolean doubleIsPositive(double d) {
        boolean positiveDouble = true;
        if (d < 0) {
            System.out.println("Value cannot be a negative number");
            doubleIsPositive(d);
        }
        return positiveDouble;
    }

    /* this method checks for errors when user types in product name, and also
    checks if inventory is full or not
    */
    boolean checkForErrors(String n) {
        boolean noError = false;
        if (n.length() < 3 || n.length() > 10) {
            errorMessage();
            if (numberOfProducts == 3) {
                System.out.println("Inventory is full");
                removeProduct();
                noError = true;
            }
        }

        return noError;
    }


    public void removeProduct() {
        // code to remove product
        System.out.println("Do you want to remove a product?");
        System.out.println("Press 1 for yes, 2 for no.");
        int response = keyboard.nextInt();
        if (response == 1) {
            System.out.println("Type in the name of the product you want to remove :");
            String name = keyboard.nextLine();
            int pos = product.Inventory.indexOf(name);
            product.Inventory = product.Inventory.substring(0, pos);
            // what if product is stored at the front of the string?
            product.numOfProducts--;
            System.out.println(name + " has been removed from the inventory. ");
            //addProduct(productName, demandRate, setupCost, unitCost, inventoryCost, sellingPrice);
        } else if (response == 2) {
            showMenu();
        } else {
            System.out.println("Invalid input. Press 1 for yes, 2 for no.");
            removeProduct();
        }
    }


    private void run() {
        //This method should control the flow of the program
        System.out.println("hello");
        showHeader();
        int choice;
        do {
            showMenu();
            System.out.println("please enter an option");
            choice = keyboard.nextInt();


            switch (choice) {
                case (1):
                    inputProduct();
                    break;
                case (2):
                    choice2();
                    break;
                case (3):
                    choice3();
                    break;
                case (4):
                    choice4();
                    break;
            }
            //end of switch

        } while (choice != 4);

    }

    public static void main(String[] args) {


        // TODO Auto-generated method stub
        StarberksInterface intFace = new StarberksInterface();
        intFace.run();

    }
}


