
public class OrdersController {
    public static void main(String[] args) {
        // // ORDERS & ITEMS -------------------------
        // // Menu items
        Item item1 = new Item("mocha", 3.25);
        // System.out.println(item1.getName());
        // System.out.println(item1.getPrice());
        Item item2 = new Item("latte", 4.5);
        // System.out.println(item2.getName());
        // System.out.println(item2.getPrice());
        Item item3 = new Item("americano", 2.15);
        // System.out.println(item3.getName());
        // System.out.println(item3.getPrice());
        Item item4 = new Item("capuccino", 3.5);
        // System.out.println(item4.getName());
        // System.out.println(item4.getPrice());

        // // Order variables -- order1, order2 etc.
        Order order1 = new Order("Cindhuri");
        // System.out.println(order1.getGuestName());
        Order order2 = new Order("Jimmy");
        // System.out.println(order2.getGuestName());
        Order order3 = new Order("Noah");
        // System.out.println(order3.getGuestName());
        // Order order4 = new Order("Sam");
        // System.out.println(order4.getGuestName());

        // // Application Simulations
        // // Add the item1 to order2's item list and increment the order's total.
        // order2.addItem(item1);
        // order2.setTotal(item1.getPrice());
        // // order3 ordered a capuccino. Add the cappuccino to their order and to their tab.
        // order3.addItem(item4);
        // order3.setTotal(item4.getPrice());
        // // order4 added a latte. Update accordingly.
        // order4.addItem(item2);
        // order4.setTotal(item2.getPrice());
        // // Cindhuri’s order is now ready.  Update her status.
        // order1.setReadyStatus(true);
        // // Sam ordered more drinks -- 2 lattes. Update their order as well.
        // order4.addItem(item2);
        // order4.addItem(item2);
        // order4.setTotal(item2.getPrice()*2);
        // // Jimmy’s order is now ready. Update his status.
        // order2.setReadyStatus(true);

        // Use this example code to test various orders' updates
        // System.out.printf("Name: %s\n", order1.getGuestName());
        // System.out.printf("Total: %s\n", order1.getTotal());
        // System.out.printf("Ready: %s\n", order1.getReadyStatus());
        // System.out.printf("Name: %s\n", order2.getGuestName());
        // System.out.printf("Total: %s\n", order2.getTotal());
        // System.out.printf("Ready: %s\n", order2.getReadyStatus());
        // System.out.printf("Name: %s\n", order3.getGuestName());
        // System.out.printf("Total: %s\n", order3.getTotal());
        // System.out.printf("Ready: %s\n", order3.getReadyStatus());
        // System.out.printf("Name: %s\n", order4.getGuestName());
        // System.out.printf("Total: %s\n", order4.getTotal());
        // System.out.printf("Ready: %s\n", order4.getReadyStatus());

        // BARISTAS CHALLENGE -------------------------
        //Create 2 orders for unspecified guests (without specifying a name);
        Order order5 = new Order();
        Order order6 = new Order();
       //Create 3 orders using the overloaded constructor to give each a name for the order.
        Order order7 = new Order("Anna");
        Order order8 = new Order("Emilie");
        Order order9 = new Order("Coco");
        //Add at least 2 items to each of the orders using the addItem method you wrote, for example, to add item1 to order3 you would need to call the addItem method from the order3 instance like so: order3.addItem(item1);
        order5.addItem(item1);
        order5.addItem(item4);
        order6.addItem(item2);
        order6.addItem(item4);
        order7.addItem(item1);
        order7.addItem(item1);
        order7.addItem(item2);
        order8.addItem(item3);
        order8.addItem(item3);
        order8.addItem(item3);
        order9.addItem(item2);
        order9.addItem(item3); 
        //Implement the getStatusMessage method within the Order class
        System.out.println(order5.getStatusMessage());
        order6.setReadyStatus(true);
        System.out.println(order6.getStatusMessage());
        System.out.println(order7.getStatusMessage());
        System.out.println(order8.getStatusMessage());
        order8.setReadyStatus(true);
        System.out.println(order9.getStatusMessage());
        order5.display();
        order6.display();
        order7.display();
        order8.display();
        order9.display();

    }
}
