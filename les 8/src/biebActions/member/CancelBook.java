package biebActions.member;

import biebDomain.BookStatus;
import biebDomain.User;
import biebService.IBiebService;
import biebService.ServiceProvider;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Created by Jorrit Meulenbeld on 9-6-2015.
 */
public class CancelBook extends ActionSupport {
    private int bookid;
    private IBiebService ibs = ServiceProvider.getBiebService();

    public String execute() throws Exception {
        ((User) ActionContext.getContext().getSession().get("user")).getBooks().remove(ibs.getBookById(bookid));
        ibs.getBookById(bookid).setStatus(BookStatus.AVAILABLE);
        return ActionSupport.SUCCESS;
    }
    public void validate() {
        System.out.println(bookid);
        if (ibs.getBookById(bookid) == null) {
            addFieldError("bookid", "Boek met id '" + bookid + "' bestaat niet.");
        }

    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
