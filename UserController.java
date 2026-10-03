package Controller;

import Model.BookDAO;
import Model.User;
import Model.UserDAO;
import java.util.List;
import Model.Product;

public class UserController {

    private UserDAO userDao = new UserDAO();
    private BookDAO productDao = new BookDAO();

    // ===== USER METHODS =====
    public void addUser(int id, String name, String role, String status) {
        User user = new User(id, name, role, status);
        userDao.addUser(user);
    }

    public List<User> getUsers() {
        return userDao.getAllUsers();
    }

    public List<User> searchUsers(String name) {
        return userDao.searchUsers(name);
    }
    
    public void deleteuser(int id){
    userDao.deleteuser(id);
    }

    // ===== PRODUCT METHODS =====
    // Delete product by ID
    public void deleteProduct(int id) {
        productDao.deleteProduct(id);
    }

    // Search products by keyword
    public List<Product> searchProducts(String keyword) {
        return productDao.searchBooks(keyword);
    }

}
