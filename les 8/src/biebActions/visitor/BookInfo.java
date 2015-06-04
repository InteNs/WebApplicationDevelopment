package biebActions.visitor;

import java.util.List;

import biebDomain.Book;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookInfo extends ActionSupport {
    private IBiebService ibs = ServiceProvider.getBiebService();
    private Book book;
    private int bookid;

    public String execute() throws Exception {
        book = ibs.getBookById(bookid);
        return ActionSupport.SUCCESS;
    }

    public void validate() {
        if(ibs.getBookById(bookid) == null) {
            addFieldError("bookid", "Boek met id '" +bookid+ "' bestaat niet.");
        }
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getBookid() {
        return bookid;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }
}
