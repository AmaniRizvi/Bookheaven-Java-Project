package Controller;


import Model.Product;
import Model.BookDAO;
import java.util.List;

public class BookController {

    private BookDAO dao = new BookDAO();

    public void addProduct(int id, String name, int quantity,double price) {
        Product s = new Product(id, name, quantity,price);
        dao.addProduct(s);
    }

    public List<Product> getProducts() {
        return dao.getAllbooks();
    }

    public List<Product> searchProducts(String name) {
        return dao.searchBooks(name);
    }

   public void deleteProduct(int id) {
        dao.deleteBook(id);
    }

    
}
