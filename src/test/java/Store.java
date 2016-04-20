public class Store {

    double quantity;
    double inventoryCostPerUnitPerWeek;


    int demandPerWeek;
    int setupCost;
    int inventory;

    int timesSetup = 1;

    private Product product1; // e.g new Product("coffee", 7, 0.6,0.6,0.6,0.6);
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

    public boolean addProduct(Product product) {
        if (product1 == null) {
            product1 = product;
            return true;
        }
        if (product2 == null) {
            product2 = product;
            return true;
        }
        if (product3 == null) {
            product3 = product;
            return true;
        }
        return false;
    }

    public void removeOneProduct() {
        product1 = null;
    }

    public void showReplenishmentStrategy(Product product, int week) {
        int q = (int) Math.round(
            Math.sqrt(2 * product.getSetupCost() * product.getDemandRate() / product.getInvtCost()));
        int quantityOrder = q;
        int inventory = quantityOrder;

        printHeader();

        for (int i = 1; i <= week; i++) {
            if (inventory < product.getDemandRate()) {
                quantityOrder = calculateBestReplenishmentQuantity(q, product.getDemandRate(), inventory, week - i + 1);
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

    int calculateBestReplenishmentQuantity(int q, int demandRate, int inventory, int remainingWeeks) {
        return Math.min(q, remainingWeeks * demandRate) - inventory;
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


    private void calculateProfit() {
        double cost1 = 0;
        double cost2 = 0;
        double cost3 = 0;

        double purchase = (setupCost * timesSetup) + quantity;
        double profit1 = product1.getDemandRate() * product1.demandRate * product1.getPrice() - cost1;
        double profit2 = product2.getDemandRate() * product2.demandRate * product2.getPrice() - cost2;
        double profit3 = product3.getDemandRate() * product3.demandRate * product3.getPrice() - cost3;

        if (profit1 > profit2 && profit1 > profit3) {
            String name = product1.getName();
            double biggestProfit = profit1;
            if (profit2 > profit1 && profit2 > profit3) {
                name = product2.getName();
                biggestProfit = profit2;
            } else {
                name = product3.getName();
                biggestProfit = profit3;
            }

            System.out.println("Product : " + name);
            System.out.println("Profit : $ " + biggestProfit);
        }
    }


    // this method shows the demand rate, setup cost, unit cost, inventory cost and selling price of whatever
    // product is inserted into the parameter
    public void showProductDetails(Product p) {
        System.out.println(p.getName());
        System.out.println(p.getDemandRate());
        System.out.println(p.getSetupCost());
        System.out.println(p.getUnitCost());
        System.out.println(p.getInvtCost());
        System.out.println(p.getPrice());
    }


    private void manageResponse() {
        int response = 0;
        switch (response) {
            case 1:

                break;
            case 2:

                break;
            default:
                System.out.println("Please enter 1 for yes, 2 for no.");
                // EOQ( double setup, double demandPerWeek, double inventoryCostPerUnitPerWeek);
                break;
        }
    }


    public boolean isEmpty() {
        return product1 == null && product2 == null && product3 == null;
    }

    public boolean isFull() {
        return product1 != null && product2 != null && product3 != null;
    }

    public boolean containsProduct(String name) {
        return false;
    }

    public Product getProduct(String name) {
        if (product1 != null && product1.getName()
            .equalsIgnoreCase(name)) {
            return product1;
        }
        if (product2 != null && product2.getName()
            .equalsIgnoreCase(name)) {
            return product2;
        }
        if (product3 != null && product3.getName()
            .equalsIgnoreCase(name)) {
            return product3;
        }
        return null;
    }
}

