package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static String correctEmail 	= "dude.bro@hetnet.nl";
	private static String correctPass	= "123456789";

	protected void doPost( HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		boolean succes = false;
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		if(!email.equals(correctEmail)&& !password.equals(correctPass)){
			req.setAttribute("succes","<div class=\"alert alert-danger\" role=\"alert\" style=\"margin-top:20px;\">Verkeerd emailadres en/of wachtwoord.</div>");
			succes = false;
		}
		else {
			req.setAttribute("succes","<div class=\"alert alert-success\" role=\"alert\" style=\"margin-top:20px;\">Login succesvol.</div>");
			succes = true;
		}
		RequestDispatcher rd = null;
		
//		if (succes) rd = req.getRequestDispatcher("LoginServlet.do");
//		else die andere rd
		rd = req.getRequestDispatcher("index.jsp");
		rd.forward(req, resp);	
	}

}
