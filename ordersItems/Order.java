import java.util.ArrayList;

public class Order {
    // --------- Attributes ---------
    private String guestName;
    // private double total = 0;
    private boolean isReady;
    public ArrayList<Item> items = new ArrayList<Item>();
    // --------- Constructors ---------
    public Order(){
        this.guestName = 'guest';
        this.isReady = false;
    }
    public Order(String guestInput){
        this.guestName = guestInput;
        this.isReady = false;
    }
    // --------- Getters & Setters ---------
    public String getGuestName(){
        return this.guestName;
    }
    public void setGuestName(String nameInput){
        this.guestName = nameInput;
    }
    // public double getTotal(){
    //     return this.total;
    // }
    // public void setTotal(double totalInput){
    //     this.total = totalInput;
    // }
    public boolean getReadyStatus(){
        return this.isReady;
    }
    public void setReadyStatus(boolean statusInput){
        this.isReady = statusInput;
    }
    public ArrayList<Item> getItems(){
        return this.items;
    }
    public void setItems(ItArrayList<Item> itemList){
        this.items = itemList;
    }
    // --------- Methods --------- 
    public String getStatusMessage(){
        if(this.isReady == true) {
            return "Your order is ready.";
        } 
        else {
            return  "Thank you for waiting. Your order will be ready soon.";
        }
    }
    public void addItem(Item itemInput) {
        this.items.add(itemInput);
    }
    public double getOrderTotal(){
        double total = 0.0;
        for(Item i: this.items) {
            total += i.getPrice();
        }
        return total;
    }
    public void display(){
        System.out.printf("Customer Name: %s%n", this.guestName);
        for(Item i: this.items) {
            System.out.println(i.getName() + " - $" + i.getPrice());
        }
        System.out.printf("Total: %.2f%n", this.getOrderTotal());
    }
}
