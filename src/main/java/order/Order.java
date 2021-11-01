package order;

import auth.User;
import internalService.InternalStatus;

import java.util.ArrayList;
import java.util.List;


public class Order {
    private List<User> users = new ArrayList<>();
    private ItemOrder io;

    public Order(ItemOrder io) {
        this.io = io;
    }

    public void addUser(User u) {
        this.users.add(u);
    }

    public boolean removeUser(User user) {
        return this.users.remove(user);
    }

    public void notifyUsers() {
        InternalStatus s = this.io.processOrder();
        notifyUsersWithStatus(s);
    }

    public void notifyUsersWithStatus(InternalStatus status) {
        for (User u : users) {
            u.update(status);
        }
    }
}
