package domain.service;

import domain.User;
import persistance.UserDAO;

import java.util.List;

public class UserService {
        private UserDAO userDAO = new UserDAO();

    public List<User> getAllUsers() {
        return userDAO.selectAllUsers();
    }

    public User getLoginUser(String userName, String password) {
        try {
            return userDAO.selectSingleUser(userName, password).get(0);
        } catch (Exception e){
            return null;
        }
    }
    public boolean isLoginValid(String userName, String password) {
        if (userDAO.selectSingleUser(userName, password).isEmpty()) return false;
        else return true;
    }
    public void addUser(String username, String email, String password, String realname, String address, String country){
        userDAO.addUser(username,email,password,realname,address,country);
    }
}
