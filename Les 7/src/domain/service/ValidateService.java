package domain.service;

import domain.User;

import java.util.List;

public class ValidateService extends ServiceProvider {

    public boolean validateAllFields(String username, String email, String emailrepeat, String password, String passwordrepeat, String realname, String address, String country){
        boolean b = false;
        if(!isNull(username)&&!isNull(email)&&!isNull(emailrepeat)&&!isNull(password)&&!isNull(passwordrepeat)&&isNull(realname)&&!isNull(address)&&!isNull(country)) b = true;
        if(!isNotEqual(email,emailrepeat)&&!isNotEqual(password, passwordrepeat)) b = true;
        if(!isNotUnique(username, username)&&!isNotUnique(email, email)) b = true;
        return b;
    }
    public boolean isNull(String field) {
        if (field == null) return true;
        else return false;
    }

    public boolean isNotEqual(String field, String compare) {
        if (!field.equals(compare)) return true;
        else return false;
    }

    public boolean isNotUnique (String field, String type) {
        List<User> users = ServiceProvider.getUserService().getAllUsers();
        switch (type) {
            case "username":for(User user : users)if(user.getUserName().equals(field)) return true;
                break;
            case "email":for(User user : users)if(user.getEmail().equals(field)) return true;
                break;
            default: break;
        }
        return false;
    }
}
