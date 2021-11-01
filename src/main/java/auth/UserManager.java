package auth;

import java.util.ArrayList;
import java.util.List;

public class UserManager {
    private UserManager thisUserManager = new UserManager();
    private List<User> users = new ArrayList<>();
    private int numberOfUsers;

    private UserManager() {
        this.numberOfUsers = 0;
    }

    public UserManager getUserManager() {
        return thisUserManager;
    }

    public void newUser(User u) {
        users.add(u);
        this.numberOfUsers++;
    }
}
