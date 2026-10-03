
package Model;

import Database.DBConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    public void addUser(User s) {
        try (Connection con = DBConnection.getConnection()) {
            String sql = "INSERT INTO users (id, name, role,status) VALUES (?, ?, ?,?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, s.getUId());
            pst.setString(2, s.getUName());
            pst.setString(3, s.getURole());
            pst.setString(4, s.getUStatus());
            pst.executeUpdate();
        } catch (Exception e) { e.printStackTrace(); }
    }

    public List<User> getAllUsers() {
        List<User> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }

    public List<User> searchUsers(String name) {
        List<User> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection()) {
            String sql = "SELECT * FROM users WHERE name LIKE ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, "%" + name + "%");
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                list.add(new User(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getString("status")
                ));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return list;
    }
public void deleteuser(int id) {
    try (Connection con = DBConnection.getConnection()) {
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, id);
        pst.executeUpdate();
    } catch (Exception e) {
        e.printStackTrace();
    }
    
}
}
