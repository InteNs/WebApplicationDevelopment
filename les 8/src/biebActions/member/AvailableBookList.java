package biebActions.member;

import biebDomain.Book;
import biebDomain.BookStatus;
import biebService.IBiebService;
import biebService.ServiceProvider;
import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by InteNs on 09.jun.2015.
 */
public class AvailableBookList extends ActionSupport {
    private IBiebService ibs = ServiceProvider.getBiebService();

    public String execute() throws Exception {
        return ActionSupport.SUCCESS;
    }

    public List<Book> getAvailableBooks() {
        ArrayList<Book> result = new ArrayList<>();
        ibs.getBooks().stream()
                .filter(book -> book.getStatus().equals(BookStatus.AVAILABLE))
                .forEach(result::add);
        return result;
    }
}

