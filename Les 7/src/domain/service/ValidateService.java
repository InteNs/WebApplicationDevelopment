package domain.service;

import domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;

public class ValidateService extends ServiceProvider {

    private static final String nullErr         = "Dit veld mag niet leeg zijn",
                                userExists 	    = "Gebruiker bestaat al",
                                emailExists     = "Email adres bestaat al",
                                emailEqual	    = "Email velden komen niet overeen",
                                passwordEqual   = "Wachtwoord velden komen niet overeen";
    private HashMap<String,String> errorMessages = new HashMap<>();

    public boolean validateAllFields(String username, String email, String emailrepeat, String password, String passwordrepeat, String realname, String address, String country){
        boolean succes = true;
        errorMessages.clear();
        if(doesExist(username))  {
            succes = false;
            errorMessages.put("usernameerror",userExists);
        }
        if(doesExist(email)){
            succes = false;
            errorMessages.put("emailerror",emailExists);
        }
        if (isNull(username)) {
            succes = false;
            errorMessages.put("usernameerror", nullErr);
        }
        if (isNull(email)) {
            succes = false;
            errorMessages.put("emailerror",nullErr);
        }
        if (isNull(password)) {
            succes = false;
            errorMessages.put("passworderror",nullErr);
        }
        if (isNull(realname)) {
            succes = false;
            errorMessages.put("realnameerror",nullErr);
        }
        if (isNull(address)) {
            succes = false;
            errorMessages.put("addresserror",nullErr);
        }
        if (isNull(country)) {
            succes = false;
            errorMessages.put("countryerror",nullErr);
        }
        if (!Objects.equals(email, emailrepeat)) {
            succes = false;
            errorMessages.put("emailrepeaterror",emailEqual);
        }
        if(!Objects.equals(password, passwordrepeat)){
            succes = false;
            errorMessages.put("passwordrepeaterror",passwordEqual);
        }
        return succes;

    }

    public HashMap getErrorFields(){
        return errorMessages;
    }

    public boolean isNull(String field) {
        return field == null || field.equals("");
    }

    private boolean doesExist(String attribute){
        System.out.println(ServiceProvider.getUserService().getAllUsers());
        return ServiceProvider.getUserService().getAllUsers().stream()
                .anyMatch(user -> attribute.equals(user.getUserName()) || attribute.equals(user.getEmail()));

    }
}
