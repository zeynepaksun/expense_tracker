package tracker.service;

import tracker.model.User;
import java.util.HashMap;
import java.util.Map;

public class AuthServ {
    private static Map<String, String> users = new HashMap<>();
    //For testing purposes, add an example of a user.
    static {
        users.put("admin", "admin123");
    }

    public static boolean auth(String username, String password) {
        return users.containsKey(username) && users.get(username).equals(password);
    }

    public static void signup(String username, String password) {
        users.put(username, password);
    }
}
