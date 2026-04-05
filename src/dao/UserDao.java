package dao;

import domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();
    User getUser(String id);
    void createUser(User user);
    String searchEmail(String email);
    void updateUser(User user);
    void removeUser(User user);
}
