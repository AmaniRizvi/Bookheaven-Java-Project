
package Model;

public class User {
    private int id;
    private String name;
    private String role;
    private String status;

    public User(int id, String name,  String role,String status) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.status=status;
    }

    public int getUId() { return id; }
    public String getUName() { return name; }
    public String getURole() { return role; }
    public String getUStatus() { return status; }

    public Object getUrole() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
