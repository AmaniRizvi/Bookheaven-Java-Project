
package Model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public Product(int id, String name,  int quantity,double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price=price;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getQuan() { return quantity; }
    public double getPrice() { return price; }

    public Object getQuantity() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
