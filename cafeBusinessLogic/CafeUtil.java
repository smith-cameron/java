import java.util.ArrayList;
import java.util.Arrays;

public class CafeUtil{
    public int getStreakGoal(){
        int sum = 0;
        for(int i = 1; i <= 10; i++) {
            sum+= i;
        }
        return sum;
    }

    public double getOrderTotal(double[] prices){
        double total = 0;
        for (double price: prices) {
            total+= price;
        }
        return total;
    }

    public void displayMenu(ArrayList<String> menuItems){
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.printf("%s %s \n", i, menuItems.get(i));
        }
    }

    public void addCustomer(ArrayList<String> customers){
        System.out.println("Please enter your name:");
        String userName = System.console().readLine();
        System.out.printf("Hello, %s! ", userName);
        System.out.printf("There are %s people ahead of you.\n", customers.size());
        customers.add(userName);
        System.out.println(customers);
    }

    public void printPriceChart(String product, double price, int max){
        System.out.printf("%s\n", product);
        for(int i = 1; i <= max; i++) {
            if(i > 1){
                System.out.printf("%s - $%.2f\n", i, (i * price)-(.5*(i-1)));
            }
            else{
                System.out.printf("%s - $%.2f\n", i, i * price);
            }
        }
    }
    public boolean displayMenu(ArrayList<String> menuItems, ArrayList<Double> prices){
        if(menuItems.size() != prices.size()) {
            return false;
        }
        for (int id = 0; id < menuItems.size(); id++) {
            System.out.printf("%s %s -- $%.2f \n", id, menuItems.get(id), prices.get(id));
        }
        return true;
    }

    public Boolean addCustomer2(ArrayList<String> customers){
        boolean finished = false;
        String input;
        while (!finished) {
            System.out.println("Please enter a customer name or press Q to quit:");
            input = System.console().readLine();
            if (input.equals("Q")) {
                finished = true;
                return finished;
            }
            customers.add(input);
            System.out.printf("%s was added to the list.", input);
            System.out.println(customers);
        }
        return finished;
    }
}
