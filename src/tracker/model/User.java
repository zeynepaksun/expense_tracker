package tracker.model;

public class User {
    private String username;
    private String password;

    //constructor
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    //get-set password
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    //get-set username
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
}
