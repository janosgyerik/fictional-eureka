import java.util.Scanner;

/**
 * @author Syed Hafizudin
 */
public class StarberksInterface {

    private static final int MIN_NAME_LENGTH = 3;
    private static final int MAX_NAME_LENGTH = 10;

    private final Store store = new Store();

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

    private String inputValidUniqueName(Scanner scanner) {
        System.out.println("Enter the name of the product you would like to add :");

        while (true) {
            String name = scanner.nextLine();
            if (MIN_NAME_LENGTH <= name.length() && name.length() <= MAX_NAME_LENGTH) {
                System.err.printf("Please input a name between %s and %s characters : ", MIN_NAME_LENGTH, MAX_NAME_LENGTH);
                continue;
            }

            if (store.containsProduct(name)) {
                System.err.println("A product with this name already exists!");
                continue;
            }

            return name;
        }
    }

    public void inputOneProduct(Scanner scanner) {
        Product product = inputProduct(scanner);

        if (store.isFull()) {
            System.out.println("The store is full.");
            if (!prompt(scanner, "Would you like to remove an item to make space for the new one?")) {
                return;
            }
            store.removeOneProduct();
        }

        store.addProduct(product);
    }

    private boolean prompt(Scanner scanner, String text) {
        System.out.println(text);
        return scanner.next().equalsIgnoreCase("yes");
    }

    private Product inputProduct(Scanner scanner) {
        String name = inputValidUniqueName(scanner);
        int demand = inputPositiveInt(scanner, "Enter the demand per week :");
        double setup = inputPositiveDouble(scanner, "Enter the setup cost :");
        double unit = inputPositiveDouble(scanner, "Enter unit cost :");
        double inv = inputPositiveDouble(scanner, "Enter inventory cost :");
        double price = inputPositiveDouble(scanner, "Enter selling price :");

        return new Product(name, demand, setup, unit, inv, price);
    }

    public void showProduct(Scanner scanner) {
        if (store.isEmpty()) {
            noProductData();
            return;
        }

        while (true) {
            System.out.println("Enter the name of the product: ");
            String name = scanner.nextLine();
            if (store.containsProduct(name)) {
                store.showProductDetails(store.getProduct(name));
                break;
            }
            System.err.println("Product does not exist. ");
        }
    }

    public void showReplenishmentStrategy() {
        // TODO see showProduct method for a similar example
    }

    public void exitProgram() {
        if (store.isEmpty()) {
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

    public int inputPositiveInt(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            int num = scanner.nextInt();
            if (num > 0) {
                return num;
            }
            System.err.println("Please enter a positive number :");
        }
    }

    public double inputPositiveDouble(Scanner scanner, String message) {
        System.out.println(message);
        while (true) {
            double num = scanner.nextDouble();
            if (num > 0) {
                return num;
            }
            System.err.println("Please enter a positive number :");
        }
    }

    public boolean doubleIsPositive(double d) {
        boolean positiveDouble = true;
        if (d < 0) {
            System.out.println("Value cannot be a negative number");
            doubleIsPositive(d);
        }
        return positiveDouble;
    }

    private void run() {
        System.out.println("HELLO");
        showHeader();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            showMenu();
            System.out.println("Please enter an option between 1 to 4");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    inputOneProduct(scanner);
                    break;
                case 2:
                    showProduct(scanner);
                    break;
                case 3:
                    showReplenishmentStrategy();
                    break;
                case 4:
                    exitProgram();
                    break;
            }
        }
    }

    public static void main(String[] args) {
        StarberksInterface intFace = new StarberksInterface();
        intFace.run();
    }
}
