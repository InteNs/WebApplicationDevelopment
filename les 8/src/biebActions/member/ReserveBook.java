package biebActions.member;

import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.Map;

/**
 * Created by InteNs on 09.jun.2015.
 */
public class ReserveBook extends ActionSupport {
    private int bookid;
    private Map session = ActionContext.getContext().getSession();
    private IBiebService ibs = ServiceProvider.getBiebService();

    public String execute() throws Exception {
        System.out.println("executing...");
        System.out.println(session.get("user"));
        ibs.reserveBook(((User)session.get("user")).getUsername(),bookid);
        return ActionSupport.SUCCESS;
    }
    public void validate(){
        System.out.println("validating...");
        if(ibs.getBookById(bookid) == null) {
            addFieldError("bookid", "Boek met id '" +bookid+ "' bestaat niet.");
        }

    }
    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

}
