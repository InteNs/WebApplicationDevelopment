package register;
import java.io.*;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
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
		final String nullError 			= "Verplicht veld.";
		final String inUseError			= "Wordt al gebruikt";
		final String repeatError 		= "velden komen niet overeen.";
		// User attributes
		User   user;
		ArrayList<User> users = (ArrayList<User>) servletContext.getAttribute("usersList");
		System.out.println(users);
		if(users == null)
			users = new ArrayList<>();
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

			users.add(user);
			servletContext.setAttribute("usersList", users);
			// dispatch to login with message
			req.setAttribute("registrationSuccess", "Registratie geslaagd.");
			rd = req.getRequestDispatcher("index.jsp");
			sendEmail();
			rd.forward(req, resp);
		} else {
			// already in use errors
			for(User userI : users) {
				if (email.equals(userI.getEmail())) System.out.println("email in use");/*req.setAttribute("emailUsed", inUseError)*/;
				if (userName.equals(userI.getUserName())) System.out.println("username in use"); /*req.setAttribute("userNameUsed",inUseError)*/;
			}

			// Null errors
			if (Objects.equals(userName, "")) 	req.setAttribute("userNameNull", 	nullError);
			if (Objects.equals(email, "")) 		req.setAttribute("emailNull", 		nullError);
			if (Objects.equals(password, "")) 	req.setAttribute("passwordNull", 	nullError);
			if (Objects.equals(realName, "")) 	req.setAttribute("realNameNull", 	nullError);
			if (Objects.equals(address, "")) 	req.setAttribute("addressNull", 	nullError);
			if (Objects.equals(country, "")) 	req.setAttribute("countryNull", 	nullError);
			// Repeat errors
			if (!password.equals(req.getParameter("emailRepeat")))
				req.setAttribute("emailRepeatError", 	"Email"+repeatError);
			if (!password.equals(req.getParameter("passwordRepeat")))
				req.setAttribute("passwordRepeatError", "Wachtwoord"+repeatError);
			// Main error message
				req.setAttribute("errorMessage", "Registratie mislukt.");
			// disppatch to registration form with error messages
			rd = req.getRequestDispatcher("registration.jsp");

			rd.forward(req, resp);
		}
	}
	private void sendEmail() {
		// Recipient's email ID needs to be mentioned.
		String to = "mark.havekes@student.hu.nl";

		// Sender's email ID needs to be mentioned
		String from = "mark.havekes@yahoo.com";

		// Assuming you are sending email from localhost
		String host = "smtp.mail.yahoo.com";

		// Get system properties
		Properties properties = System.getProperties();

		// Setup mail server
		properties.setProperty("mail.smtp.host", host);

		//setup auth
		properties.setProperty("mail.user", "mark.havekes@yahoo.com");
		properties.setProperty("mail.password", "jIvWNo02pBndyjdZjL6D");

		// Get the default Session object.
		Session session = Session.getDefaultInstance(properties);

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO,
					new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("yoooooooo");

			// Now set the actual message
			message.setText("verstuurd door middel van web-dev app :DDDD");

			// Send message
			Transport.send(message);
			System.out.println("Sent message successfully....");
		} catch (Exception mex) {
			mex.printStackTrace();
		}
	}
}