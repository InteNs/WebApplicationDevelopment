package biebActions.visitor;

import java.util.List;

import biebDomain.Book;
import biebService.IBiebService;
import biebService.ServiceProvider;

import com.opensymphony.xwork2.ActionSupport;

@SuppressWarnings("serial")
public class BookList extends ActionSupport {
	private IBiebService ibs = ServiceProvider.getBiebService();
	
	public String execute() throws Exception {
		return ActionSupport.SUCCESS;
	}
	
	public List<Book> getBooks() {
		return ibs.getBooks();
	}
}
