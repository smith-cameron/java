public class CafeJava {
    public static void main(String[] args) {
        // APP VARIABLES
        String generalGreeting = "Welcome to Cafe Java, ";
        String pendingMessage = ". Your order will be ready shortly.";
        String readyMessage = ", your order is ready";
        String displayTotalMessage = "Your total is $";
        
        // Menu variables
        double mocha = 3.5;
        double americano = 2.5;
        double latte = 3.75;
        double cappuccino = 2.75;
    
        // Customer name variables
        String customer1 = "Cindhuri";
        String customer2 = "Sam";
        String customer3 = "Jimmy";
        String customer4 = "Noah";
    
        // Order completions
        boolean isReadyOrder1 = false;
        boolean isReadyOrder2 = false;
        boolean isReadyOrder3 = false;
        boolean isReadyOrder4 = false;
    
        // APP INTERACTION SIMULATION
        // System.out.println(generalGreeting + customer1); // Displays "Welcome to Cafe Java, Cindhuri"

        // #1) Cindhuri ordered a latte. 
        //     show her the status message.
        System.out.println(generalGreeting + customer1+"!"); //generalGreeting
        System.out.println("Chinuri: May I have a latte?"); //order
        System.out.println(String.format("Thank you, %s%s", customer1, pendingMessage)); //pendingMessage
        // System.out.println(customer1+readyMessage+"!"); //readyMessage
        // System.out.println(String.format("%s%f",displayTotalMessage, latte)); //displayTotalMessage without decimal boundaary
        // System.out.println(String.format("%s%.2f",displayTotalMessage, latte)); //displayTotalMessage with decimal boundary

        // #2) Noah ordered a cappucino
        //     Check the status of his order and let him know. If it is ready, also tell him his total.
        System.out.println(generalGreeting + customer4);
        System.out.println("Noah: May I have a cappuccinos please?"); 
        isReadyOrder4 = true;
        if(isReadyOrder4){
            System.out.println(customer4+readyMessage+"!");
            System.out.println(String.format("Thank you, %s. %s%.2f%n", customer4, displayTotalMessage, cappuccino)); //pendingMessage and new line
        }
        else{
            System.out.println(customer4+pendingMessage);
        }

        // #3) Sam ordered 2 americanos, and would like to know the total up front. 
        //      Also tell them their order status.
        System.out.println(generalGreeting + customer2);
        System.out.println("Sam: May I have two americano's please?"); 
        System.out.printf("Of course %s! %s%.2f", customer2, displayTotalMessage, americano*2); //two variables 
        // isReadyOrder2 = true;
        if(isReadyOrder2){
            System.out.println(customer2+readyMessage+"!");
        }
        else{
            System.out.println(String.format("Thank you, %s%s", customer2, pendingMessage + String.format("...I'd say about %d minutes.", 5))); //nested String.format()
        }
        // #4)  Jimmy just realized he was charged for a mocha but had ordered a latte.
        //     Tell him his new total to make up the difference.
        System.out.println(generalGreeting + customer2);
        System.out.println("Jimmy: Excuse me, i ordered a latte but i was charged for a mocha..."); 
        System.out.printf("Im so sorry %s! %s%.2f", customer2, displayTotalMessage, latte - mocha);
    }
}
