
package Model;

import Database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

    public void addProduct(Product s) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO books (id, name, quantity,price) VALUES (?, ?, ?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, s.getId());
            pst.setString(2, s.getName());
            pst.setInt(3, s.getQuan());
            pst.setDouble(4, s.getPrice());
            pst.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<Product> getAllbooks() {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<Product> searchBooks(String name) {
        List<Product> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM books WHERE name LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

public void deleteBook(int id) {
    try (Connection con = DBConnection.getConnection()) {
        String sql = "DELETE FROM books WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

    public void deleteProduct(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
