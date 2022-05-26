package scripts;

public class Credentials {

    // Instance Variables
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (username.equals("Naim")) this.username = "";
        else throw new RuntimeException("Wrong Admin Username!");

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.equals("123")) this.password = "Thisisatest";
        else throw new RuntimeException("Wrong Admin Password!");
    }
}