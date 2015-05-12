package login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final String correctEmail 	= "dude.bro@hetnet.nl";
	private static final String correctPass	= "123456789";

	protected void doPost( HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		boolean succes;
        System.out.println("HOI");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
        if (email.equals(correctEmail) && password.equals(correctPass)) {
            req.setAttribute("succes","<div class=\"alert alert-success\" role=\"alert\" style=\"margin-top:20px;\">Login succesvol.</div>");
            succes = true;
        } else {
            req.setAttribute("succes","<div class=\"alert alert-danger\" role=\"alert\" style=\"margin-top:20px;\">Verkeerd emailadres en/of wachtwoord.</div>");
            succes = false;
        }
        RequestDispatcher rd;
		
		if (succes){
            System.out.println("succes");
			rd = req.getRequestDispatcher("welcome.jsp");
            req.getSession().setAttribute("loggedInUserName", email);
            Cookie c = new Cookie("cUsername", email);
            c.setMaxAge(2000);
            resp.addCookie(c);
        }
		else{
            System.out.println("failure");
            rd = req.getRequestDispatcher("");

        }
        rd.forward(req, resp);

	}

}
