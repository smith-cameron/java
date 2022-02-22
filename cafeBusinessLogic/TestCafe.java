import java.util.ArrayList;
import java.util.Arrays;

public class TestCafe{
    public static void main(String[] args) {
    CafeUtil appTest = new CafeUtil();
    // ============ App Test Cases ============= 
    
    // System.out.println("\n----- Streak Goal Test -----");
    // System.out.printf("Purchases needed by week 10: %s \n\n", appTest.getStreakGoal());

    // System.out.println("----- Order Total Test-----");
    // double[] lineItems = {3.5, 1.5, 4.0, 4.5};
    // System.out.printf("Order total: %s \n\n",appTest.getOrderTotal(lineItems));
    
    // System.out.println("----- Display Menu Test-----");
    
    ArrayList<String> menu = new ArrayList<String>();
    menu.add("drip coffee");
    menu.add("cappuccino");
    menu.add("latte");
    menu.add("mocha");
    // appTest.displayMenu(menu);

    // System.out.println("\n----- Add Customer Test-----");
    // ArrayList<String> customers = new ArrayList<String>();
    // // --- Test 4 times ---
    // for (int i = 0; i < 4; i++) {
    //     appTest.addCustomer(customers);
    //     System.out.println("\n");
    //     }

    // System.out.println("\n----- Price Chart Test -----");
    // appTest.printPriceChart("coffee", 2,4);

    System.out.println("\n----- Display Menu Test -----");
    ArrayList<Double> prices = new ArrayList<Double>();
    prices.add(3.5);
    prices.add(1.5);
    prices.add(4.0);
    prices.add(4.5);
    appTest.displayMenu(menu, prices);
    }

    // System.out.println("\n----- Add Customer Test 2-----");
    // ArrayList<String> customers2 = new ArrayList<String>();
    // // --- Test 4 times ---
    // if(!appTest.addCustomer2(customers2)){
    //     for (int i = 0; i < 4; i++) {
    //         appTest.addCustomer2(customers2);
    //         System.out.println("\n");
    //     }
    // }
}
