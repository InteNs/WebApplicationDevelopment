package domain.service;

import domain.User;
import persistance.UserDAO;

import java.util.List;

public class UserService {
    private UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }
    public User getUser(String userName) {
        return userDAO.selectSingleUser(userName);
    }
    public boolean isLoginValid(String userName,String password) {
        return userDAO.selectSingleUser(userName).getPassword().equals(password);
    }
    public void addUser(String username, String email, String password, String realname, String address, String country){
        userDAO.insertUsers(username,email,password,realname,address,country);
    }
}
