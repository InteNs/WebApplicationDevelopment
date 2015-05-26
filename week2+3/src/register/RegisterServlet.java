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
		String notificationInit = "<div class=\"notificationBox\"><div class=\"notificationMessage notificationError";
		String notificationNullErrorUsername = notificationInit+"\">Gebruiker is een verplicht veld.</div></div>";
		String notificationNullErrorEmail = notificationInit+"\">Email is een verplicht veld.</div></div>";
		String notificationNullErrorPassword = notificationInit+"\">Wachtwoord is een verplicht veld.</div></div>";
		String notificationNullErrorRealname = notificationInit+"\">Naam is een verplicht veld.</div></div>";
		String notificationNullErrorAddress = notificationInit+"\">Adres is een verplicht veld.</div></div>";
		String notificationNullErrorCountry = notificationInit+"\">Land is een verplicht veld.</div></div>";
		String notificationRepeatErrorEmail = notificationInit+"\">De velden van email komen niet overeen</div></div>";
		String notificationRepeatErrorPassword = notificationInit+"\">De velden van wachtwoord komen niet overeen</div></div>";

		// User attributes
		User user;
		String userName = req.getParameter("username");
		String email 	= req.getParameter("email");
		String password = req.getParameter("password");
		String realName = req.getParameter("realname");
		String address 	= req.getParameter("address");
		String country 	= req.getParameter("country");
		// nullcheck
		if(!Objects.equals(userName, "")
				&& !Objects.equals(email, "")
				&& email.equals(req.getParameter("emailRepeat"))
				&& !Objects.equals(password, "")
				&& password.equals(req.getParameter("passwordRepeat"))
				&& !Objects.equals(realName, "")
				&& !Objects.equals(address, "")
				&& !Objects.equals(country, "")){
			// create user
			user = new User(userName, email, password, realName, address, country);
			// add user to arraylist in servletContext
			ArrayList users = (ArrayList) servletContext.getAttribute("usersList");
			if(users == null)
				users = new ArrayList();
			users.add(user);
			servletContext.setAttribute("usersList", users);
			// dispatch to login with message
			req.setAttribute("registrationSuccess", "Registratie geslaagd.");
			rd = req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
		} else {
			// Null errors
			if (Objects.equals(userName, "")) 	req.setAttribute("userNameNull", 	notificationNullErrorUsername);
			if (Objects.equals(email, "")) 		req.setAttribute("emailNull", 		notificationNullErrorEmail);
			if (Objects.equals(password, "")) 	req.setAttribute("passwordNull", 	notificationNullErrorPassword);
			if (Objects.equals(realName, "")) 	req.setAttribute("realNameNull", 	notificationNullErrorRealname);
			if (Objects.equals(address, "")) 	req.setAttribute("addressNull", 	notificationNullErrorAddress);
			if (Objects.equals(country, "")) 	req.setAttribute("countryNull", 	notificationNullErrorCountry);
			// Repeat errors
			if (!password.equals(req.getParameter("emailRepeat")))
				req.setAttribute("emailRepeatError", 	"Email"+notificationRepeatErrorEmail);
			if (!password.equals(req.getParameter("passwordRepeat")))
				req.setAttribute("passwordRepeatError", "Wachtwoord"+notificationRepeatErrorPassword);
			// Main error message
				req.setAttribute("errorMessage", "Registratie mislukt.");
			// disppatch to registration form with error messages
			rd = req.getRequestDispatcher("registration.jsp");
			rd.forward(req, resp);
		}
	}
}