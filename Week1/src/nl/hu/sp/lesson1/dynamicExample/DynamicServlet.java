package nl.hu.sp.lesson1.dynamicExample;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DynamicServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		int n1 = Integer.parseInt(req.getParameter("number1"));
		int n2 = Integer.parseInt(req.getParameter("number2"));
		String operator = req.getParameter("button");
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");

		out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
		out.println("<html xmlns=\"http://www.w3.org/1999/xhtml\">");
		out.println(" <head>");
		out.println(" <meta http-equiv=\"content-type\" content=\"text/html;charset=iso-8859-1\" />");
		out.println(" <title>Dynamic Example</title>");
		out.println(" </head>");
		out.println(" <body>");
		switch (operator) {
		case "-": 
			out.println(n1 - n2);
			break;
		case "+": 
			out.println(n1 + n2);
			break;
		case "*": 
			out.println(n1 * n2);
			break;
		case "/": 
			out.println(n1 / n2);
			break;
		default: out.println("KAAAAAS");
		}
		
		out.println(" </body>");
		out.println("</html>");
	}
}