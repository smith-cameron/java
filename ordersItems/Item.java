public class Item {
    // --------- Attributes ---------
    private String name;
    private double price;
    // --------- Constructors ---------
    public Item(){
    }
    public Item(String nameInput, double priceInput){
        this.name = nameInput;
        this.price = priceInput;
    }
    // --------- Getters & Setters ---------
    public String getName(){
        return this.name;
    }
    public void setName(String nameInput){
        this.name = nameInput;
    }
    public double getPrice(){
        return this.price;
    }
    public void setPrice(double priceInput){
        this.price = priceInput;
    }
}
