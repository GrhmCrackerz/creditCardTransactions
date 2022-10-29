package goods;

public class Item {

    String category;
    String name;
    double price;

    public Item(String category, String name, double price) {
        this.category = category;
        this.name = name;
        this.price = price;
    }
    public String getCategory() {
        return category;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price, String personal) {
        this.price = price;
    }
    public void displayInfo(){

    }
}
