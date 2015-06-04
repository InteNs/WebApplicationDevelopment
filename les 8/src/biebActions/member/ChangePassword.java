package biebActions.member;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import biebDomain.User;
import biebDomain.UserRole;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class ChangePassword extends ActionSupport implements SessionAware {
    private IBiebService ibs = ServiceProvider.getBiebService();
    private User user;
    @SuppressWarnings("rawtypes")
    private Map session;
    private String currentpassword;
    private String newpassword;

    @SuppressWarnings("rawtypes")
    public void setSession(Map session) {
        this.session = session;

    }

    @Override
    public String execute() throws Exception {
        ibs.changePassword(user.getUsername(), newpassword);
        return SUCCESS;
    }

    @Override
    public void validate() {
        user = ((User) session.get("user"));
        if(!user.getPassword().equals(currentpassword)) addFieldError("currentpassword", "Verkeerd wachtwoord");
        if(newpassword.length()<8) addFieldError("newpassword", "minimaal 8 tekens");
        if(!newpassword.matches(".*[A-Z].*")) addFieldError("newpassword", "minimaal 1 hoofdletter");
        if(!newpassword.matches(".*[a-z].*")) addFieldError("newpassword", "minimaal 1 kleineletter");
        if(!newpassword.matches(".*[0-9].*")) addFieldError("newpassword", "minimaal 1 cijfer");
        if(newpassword.contains(" ")) addFieldError("newpassword", "geen spaties");
    }

    public void setCurrentpassword(String currentpassword) {
        this.currentpassword = currentpassword;
    }

    public void setNewpassword(String newpassword) {
        this.newpassword = newpassword;
    }

    //    @SuppressWarnings("unchecked")
//    public String execute(){
//        session.put( "user", user );
//        if (user.getUr().equals(UserRole.Manager))
//            return "managermenu";
//        if (user.getUr().equals(UserRole.Coworker))
//            return "coworkermenu";
//        return SUCCESS;
//    }
//
//    public void validate(){
//        password = password.trim();
//        username = username.trim();
//
//        if ( username.length() == 0 ){
//            addFieldError( "username", "naam is verplicht");
//        }
//        if ( password.length() == 0 ){
//            addFieldError( "password", "wachtwoord is verplicht" );
//        }
//
//        user = ibs.getUserByUsername(username);
//        if ((user == null) || !(user.getPassword().equals(password))){
//            addFieldError("username", "naam of wachtwoord is niet juist");
//        }
//    }
//
//    public String getUsername() {
//        return username;
//    }
//
//    public void setUsername(String username) {
//        this.username = username;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//

//
//    public User getUser() {
//        return user;
//    }

}
