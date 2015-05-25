package register;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;

public class RegisterServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd;
		ServletContext servletContext = req.getServletContext();

		// Error messages
		final String errorNull = "Veld mag niet leeg zijn.";

		// User attributes
		User   user;
		String userName = req.getParameter("username");
		String email 	= req.getParameter("email");
		String password = req.getParameter("password");
		String realName = req.getParameter("realname");
		String address 	= req.getParameter("address");
		String country 	= req.getParameter("country");

		if(!Objects.equals(userName, "")
				&& !Objects.equals(email, "")
				&& email.equals(req.getParameter("emailRepeat"))
				&& !Objects.equals(password, "")
				&& password.equals(req.getParameter("passwordRepeat"))
				&& !Objects.equals(realName, "")
				&& !Objects.equals(address, "")
				&& !Objects.equals(country, "")){

			user = new User(userName, email, password, realName, address, country);

			ArrayList users = (ArrayList) servletContext.getAttribute("usersList");
			if(users == null)
				users = new ArrayList();
			users.add(user);
			servletContext.setAttribute("usersList", users);

			req.setAttribute("message", "<div style=\"color: green;\">Registratie gelukt.</div>");
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		}
		else {
			// Null errors
			if (Objects.equals(userName, "")) 	req.setAttribute("userNameNull", "<div style=\"color: red;\">"+errorNull+"</div>");
			if (Objects.equals(email, "")) 		req.setAttribute("emailNull", "<div style=\"color: red;\">"+errorNull+"</div>");
			if (Objects.equals(password, "")) 	req.setAttribute("passwordNull", "<div style=\"color: red;\">"+errorNull+"</div>");
			if (Objects.equals(realName, "")) 	req.setAttribute("realNameNull", "<div style=\"color: red;\">"+errorNull+"</div>");
			if (Objects.equals(address, "")) 	req.setAttribute("addressNull", "<div style=\"color: red;\">"+errorNull+"</div>");
			if (Objects.equals(country, "")) 	req.setAttribute("countryNull", "<div style=\"color: red;\">"+errorNull+"</div>");
			// Repeat errors
			if (!password.equals(req.getParameter("emailRepeat")))		req.setAttribute("emailRepeatError", "<div style=\"color: red;\">Invoer is niet gelijk aan email veld.</div>");
			if (!password.equals(req.getParameter("passwordRepeat")))	req.setAttribute("passwordRepeatError", "<div style=\"color: red;\">Invoer is niet gelijk aan wachtwoord veld.</div>");

			req.setAttribute("message", "<div style=\"color: red;\">Registratie mislukt.</div>");
			rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);
		}
	}
}