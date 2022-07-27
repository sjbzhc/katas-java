package leetcode;

import java.util.HashMap;
import java.util.Map;

public class SignInAPI {


    Map<String, Boolean> sessions = new HashMap<>();
    Map<String, String> users = new HashMap<>();
    public String register(String user, String password) {
        if (users.containsKey(user)) return "Username already exists";
        users.put(user, password);
        return "Registered Successfully";
    }

    public String login(String user, String password) {
        if (!users.containsKey(user)
                || !users.get(user).equals(password)
                || sessions.getOrDefault(user, false)
        ) return "Login Unsuccessful";
        sessions.put(user, true);
        return "Logged In Successfully";
    }

    public String logout(String user) {
        if (!sessions.containsKey(user)) return "Logout Unsuccessful";
        sessions.remove(user);
        return "Logged Out Successfully";
    }
}
