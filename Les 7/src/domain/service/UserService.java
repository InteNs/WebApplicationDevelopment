package domain.service;

import domain.User;
import persistance.UserDAO;

public class UserService {
        private UserDAO userDAO = new UserDAO();

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
}
