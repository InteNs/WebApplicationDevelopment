package biebActions.visitor;

import java.util.List;

import biebDomain.Book;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookInfo extends ActionSupport {
    private IBiebService ibs = ServiceProvider.getBiebService();

    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }

    public Book getBook(int bookId) {
        return ibs.getBookById(bookId);
    }
}
