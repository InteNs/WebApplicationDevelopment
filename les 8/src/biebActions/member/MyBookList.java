package biebActions.member;

import biebDomain.Book;
import biebDomain.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import java.util.List;

public class MyBookList extends ActionSupport {

    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }

    public List<Book> getUserBooks() {
        return ((User) ActionContext.getContext().getSession().get("user")).getBooks();
    }
}