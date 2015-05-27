package register;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Properties;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.mail.imap.IMAPStore;
import com.sun.mail.smtp.SMTPTransport;
import mail.OAuth2Authenticator;
import model.User;

public class RegisterServlet extends HttpServlet {
	ArrayList<User> users = null;
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
		String notificationEmailInUseError = notificationInit+"\">Email bestaad al.</div></div>";
		String notificationUserNameInUseError = notificationInit+"\">Gebruikersnaam bestaad al.</div></div>";

		// User attributes
		User user;

		users = (ArrayList<User>) servletContext.getAttribute("usersList");
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
				&& !Objects.equals(country, "")
				&& !doesExist(email)
				&& !doesExist(userName)){
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
			try {
				sendEmail();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
			if (doesExist(email))req.setAttribute("emailUsed", notificationEmailInUseError);
			if (doesExist(userName))req.setAttribute("userNameUsed",notificationUserNameInUseError);
			// Main error message
				req.setAttribute("errorMessage", "Registratie mislukt.");
			// disppatch to registration form with error messages
			rd = req.getRequestDispatcher("registration.jsp");

			rd.forward(req, resp);
		}
	}
	private boolean doesExist(String attribute){
		return users.stream()
				.anyMatch(user -> attribute.equals(user.getUserName())||attribute.equals(user.getEmail()));
	}
	private void sendEmail() throws Exception {
		String email = "mark.havekes@gmail.com";
		String oauthToken = "-----BEGIN PRIVATE KEY-----\nMIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJgFp46pFR0pgJeI\nzVDDUMrVTST4yXAIyPB/HgKQY72dzRexboxTxc9ZminxEvty+cOTH3V4T1KlzUeZ\n2+9B1LOvoXIhHtIz3nRMqF6Ed4T+SyNb2dx6KE45Y/ShzLgOql6L6pwnHVwI0LjL\nXCP0QPTqVxmxG+11xX6v1qrR69rBAgMBAAECgYAMMlfxICurfUrt3XHriuAOhfJ8\nhuFSdcH5WZmExyTZb7GmtvuRkp8KNbwipU7KkbzsLf+WIyLqFJdVqUh196gi6spu\nzEYclj7R0Z/Hd6Rmsi3ROcEFnT9477EQqF+FYeolvQWqVPMobkrsuW13xlejscRJ\nfURhtN6olMxHxodLSQJBAMbCxZtPG63oNmJmrQTgQEalymAUC/FJPEEm6ivep60K\nUbWvIxAvTL7xci++hOz3Yee0GVFZI2lfSnBJJ7ctEnMCQQDDzSqW57kJpHGAn7Ry\npXgBh2KMEjAL+7CJnrD//+VFga+XdEY6yfat6HoaMcSf5zkpZJ66bHebnudAMUUJ\ndSz7AkAlvLc+DKAJvcwNlMcG5PjvMO0insvBrRD2ocfWOnkFfq8S2sTCfuiIXFk8\nvWSJhVKeZnBkJJN3nzMH7KvQuIsHAkEAiC1NDZ8j5jzkY9yvF31VtVp/g4OyvuLR\nqSUhXSqQPoMvqFpJ7eFBGzqwkT9DzSJ3cv50FpwRo74kf1TE+wrvuQJADZCt8TCc\n72HMNpOWfhpGuXM23rrAnNcG+REc0jBWdHNuXAELNRu1amAgL78jJR4ZNUKu8GN7\nZXF0+Dqbd/S9sw\u003d\u003d\n-----END PRIVATE KEY-----\n";
		OAuth2Authenticator.initialize();

		IMAPStore imapStore = OAuth2Authenticator.connectToImap("imap.gmail.com",
				993,
				email,
				oauthToken,
				true);
		System.out.println("Successfully authenticated to IMAP.\n");
		SMTPTransport smtpTransport = OAuth2Authenticator.connectToSmtp("smtp.gmail.com",
				587,
				email,
				oauthToken,
				true);
		System.out.println("Successfully authenticated to SMTP.");

	}
//	private void sendEmail() {
//		// Recipient's email ID needs to be mentioned.
//		String to = "mark.havekes@student.hu.nl";
//
//		// Sender's email ID needs to be mentioned
//		String from = "mark.havekes@yahoo.com";
//
//		// Assuming you are sending email from localhost
//		String host = "smtp.att.yahoo.com";
//
//		// Get system properties
//		Properties properties = System.getProperties();
//
//		// Setup mail server
//		properties.setProperty("mail.smtp.host", host);
//		properties.setProperty("mail.smtp.port","587");
//
//		//setup auth
//		//properties.setProperty("mail.smtp.auth", "true");
//		Authenticator auth = new SMTPAuthenticator();
//		// Get the default Session object.
//		Session session = Session.getDefaultInstance(properties);
//
//		try {
//			// Create a default MimeMessage object.
//			MimeMessage message = new MimeMessage(session);
//
//			// Set From: header field of the header.
//			message.setFrom(new InternetAddress(from));
//
//			// Set To: header field of the header.
//			message.addRecipient(Message.RecipientType.TO,
//					new InternetAddress(to));
//
//			// Set Subject: header field
//			message.setSubject("yoooooooo");
//
//			// Now set the actual message
//			message.setText("verstuurd door middel van web-dev app :DDDD");
//
//			// Send message
//
//			Transport.send(message,"mark.havekes@yahoo.com","jIvWNo02pBndyjdZjL6D");
//			System.out.println("Sent message successfully....");
//		} catch (Exception mex) {
//			mex.printStackTrace();
//		}
//
//	}
	private class SMTPAuthenticator extends javax.mail.Authenticator {
		public PasswordAuthentication getPasswordAuthentication() {
			String username = "mark.havekes@yahoo.com";
			String password = "jIvWNo02pBndyjdZjL6D";
			return new PasswordAuthentication(username, password);
		}
	}
}