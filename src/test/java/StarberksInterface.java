import java.util.Scanner;

/**
 * @author Syed Hafizudin
 */
public class StarberksInterface {

    static Scanner keyboard = new Scanner(System.in);
    static Product product = new Product();
    Store Store = new Store();
    boolean exit;
    //after adding a product, numberOfProducts + 1. when this var reaches 3,
    // inventory is full and user can't add any more products
    int numberOfProducts = 0;
    String Inventory = "";

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


    public void choice1() {

        //get the information from the user
        System.out.println("Enter the name of the product you would like to add :");
        String name = keyboard.next();
        // checking if name entered by user is => 3 and <= 10 characters long and if
        if (name.length() < 3 || name.length() > 10) {
            errorMessage();
        }
        if (Inventory.indexOf(name) != -1) {
            // means product exists
        }

	/* if (checkForErrors(name) == true){
			if(productExists(name) == false){
		*/
        if (numberOfProducts == 0) {
            Product product1 = new Product();
            name = name.toLowerCase();
            product1.setName(name);
            System.out.println("Name of product is : " + name);

            System.out.println("Enter the demand per week :");
            int demand = keyboard.nextInt();
            // checking if number entered by user is positive
            if (numberIsPositive(demand) == true) {
                product1.setDemandRate(demand);
                System.out.println("Demand per week is : " + demand);
            } else {
                numberIsPositive(demand);
            }


            System.out.println("Enter the setup cost :");
            double setup = keyboard.nextDouble();
            // checking if double enter by user is positive
            if (doubleIsPositive(setup) == true) {
                product1.setSetupCost(setup);
                System.out.println("Setup cost is : " + setup);
            }


            System.out.println("Enter unit cost :");
            double unit = keyboard.nextDouble();
            if (doubleIsPositive(unit) == true) {
                product1.setUnitCost(unit);
                System.out.println("Unit cost is : " + unit);
            }


            System.out.println("Enter inventory cost :");
            double inv = keyboard.nextDouble();
            if (doubleIsPositive(inv) == true) {
                product1.setInvtCost(inv);
                System.out.println("Inventory cost is : " + inv);
            }


            System.out.println("Enter selling price :");
            double price = keyboard.nextDouble();
            if (doubleIsPositive(price) == true) {
                product1.setPrice(price);
                System.out.println("Selling price is : " + price);
            }


            // once all values typed in are ok, product count will increase by 1
            numberOfProducts++;
            // product name will be added to String inventory
            Inventory += product1.getName();
            System.out.println(product1.getName() + " has been added to the inventory");
            showMenu();


        } else if (numberOfProducts == 1) {
            Product product2 = new Product();
            name = name.toLowerCase();
            product2.setName(name);
            System.out.println("Name of product is : " + product2.getName());

            System.out.println("Enter the demand per week :");
            int demand = keyboard.nextInt();
            // checking if number entered by user is positive
            if (numberIsPositive(demand) == true) {
                product2.setDemandRate(demand);
                System.out.println("Demand per week is : " + demand);
            }


            System.out.println("Enter the setup cost :");
            double setup = keyboard.nextDouble();
            // checking if double enter by user is positive
            if (doubleIsPositive(setup) == true) {
                product2.setSetupCost(setup);
                System.out.println("Setup cost is : " + setup);
            }


            System.out.println("Enter unit cost :");
            double unit = keyboard.nextDouble();
            if (doubleIsPositive(unit) == true) {
                product2.setUnitCost(unit);
                System.out.println("Unit cost is : " + unit);
            }


            System.out.println("Enter inventory cost :");
            double inv = keyboard.nextDouble();
            if (doubleIsPositive(inv) == true) {
                product2.setInvtCost(inv);
                System.out.println("Inventory cost is : " + inv);
            }


            System.out.println("Enter selling price :");
            double price = keyboard.nextDouble();
            if (doubleIsPositive(price) == true) {
                product2.setPrice(price);
                System.out.println("Selling price is : " + price);
            }


            // once all values typed in are ok, product count will increase by 1
            numberOfProducts++;
            // product name will be added to String inventory
            Inventory += product2.getName();
            System.out.println(product2.getName() + " has been added to the inventory");
            showMenu();


        } else {
            Product product3 = new Product();
            name = name.toLowerCase();
            product3.setName(name);
            System.out.println("Name of product is : " + product3.getName());

            System.out.println("Enter the demand per week :");
            int demand = keyboard.nextInt();
            // checking if number entered by user is positive
            if (numberIsPositive(demand) == true) {
                product3.setDemandRate(demand);
                System.out.println("Demand per week is : " + demand);
            }


            System.out.println("Enter the setup cost :");
            double setup = keyboard.nextDouble();
            // checking if double enter by user is positive
            if (doubleIsPositive(setup) == true) {
                product3.setSetupCost(setup);
                System.out.println("Setup cost is : " + setup);
            }


            System.out.println("Enter unit cost :");
            double unit = keyboard.nextDouble();
            if (doubleIsPositive(unit) == true) {
                product3.setUnitCost(unit);
                System.out.println("Unit cost is : " + unit);
            }


            System.out.println("Enter inventory cost :");
            double inv = keyboard.nextDouble();
            if (doubleIsPositive(inv) == true) {
                product3.setInvtCost(inv);
                System.out.println("Inventory cost is : " + inv);
            }


            System.out.println("Enter selling price :");
            double price = keyboard.nextDouble();
            if (doubleIsPositive(price) == true) {
                product3.setPrice(price);
                System.out.println("Selling price is : " + price);
            }


            // once all values typed in are ok, product count will increase by 1
            numberOfProducts++;
            // product name will be added to String inventory
            Inventory += product3.getName();
            System.out.println(product3.getName() + " has been added to the inventory");
            run();

        }
    }


    public void choice2() {
        if (numberOfProducts == 0) {
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
                    Store.showProductDetails(product);
                    run();
                }

            }
        }

    }

    public void choice3() {

        // if there is no product data, noProductData method will be called
        if (numberOfProducts == 0) {
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
                Store.showReplenishmentStrategy(product, week);
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
        System.out.println("");
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
        int i = Inventory.indexOf(nm);
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
        while (n < 0) {
            System.out.println("Value cannot be a negative number");
            System.out.println("Please enter a positive number :");
            n = keyboard.nextInt();
            numberIsPositive(n);
        }
        boolean positiveNumber = true;
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
            System.out.println("Error found");
            //errorMessage();
        } else {
            if (numberOfProducts == 3) {
                System.out.println("Inventory is full");
                removeProduct();
                noError = true;
            }
        }
        noError = true;
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
            int pos = Inventory.indexOf(name);
            Inventory = Inventory.substring(0, pos);
            // what if product is stored at the front of the string?
            numberOfProducts--;
            System.out.println(name + " has been removed from the inventory. ");
            //	Product(productName, demandRate, setupCost, unitCost, inventoryCost, sellingPrice);
        } else if (response == 2) {
            showMenu();
        } else {
            System.out.println("Invalid input. Press 1 for yes, 2 for no.");
            removeProduct();
        }
    }


    private void run() {
        //This method should control the flow of the program
        System.out.println("HELLO");
        showHeader();
        int choice;
        do {
            showMenu();
            System.out.println("Please enter an option between 1 to 4");
            choice = keyboard.nextInt();


            switch (choice) {
                case (1):
                    choice1();
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


