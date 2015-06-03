package register;
import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Logger;

import javax.mail.Message;
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

import domain.User;

public class RegisterServlet extends HttpServlet {
	private ArrayList<User> users = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher rd;
		ServletContext servletContext;
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
		synchronized (servletContext = getServletContext()) {
			users = (ArrayList<User>) servletContext.getAttribute("usersList");
		}
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
			rd = req.getRequestDispatcher("/index.jsp");
			try {
				sendMail(user.getEmail(), "Registratie gelukt!",
						"U kunt nu inloggen:http://localhost:8080/index.jsp");
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
			//already exists errors
			if (doesExist(email))req.setAttribute("emailUsed", notificationEmailInUseError);
			if (doesExist(userName))req.setAttribute("userNameUsed",notificationUserNameInUseError);
			// Main error message
				req.setAttribute("errorMessage", "Registratie mislukt.");
			// disppatch to registration form with error messages
			rd = req.getRequestDispatcher("/registration.jsp");

			rd.forward(req, resp);
		}
	}
	private boolean doesExist(String attribute){
		return users.stream()
				.anyMatch(user -> attribute.equals(user.getUserName()) || attribute.equals(user.getEmail()));

	}
	private void sendMail(String mailAddress, String title, String message) {
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.strato.com");
		props.put("mail.smtp.port", 465);
		props.put("mail.smtp.ssl.enable", true);
		Session mailSession = Session.getInstance(props);
		try {
			MimeMessage msg = new MimeMessage(mailSession);
			msg.setFrom(new InternetAddress("autototaaldienst@dense-code.com", "webmaster"));
			msg.setRecipients(Message.RecipientType.TO, mailAddress);
			msg.setSubject(title);
			msg.setText(message);
			msg.setSentDate(Calendar.getInstance().getTime());

			//fix this line: Transport.send(msg, "autototaaldienst@dense-code.nl", "password1");

		} catch (Exception e) {
			Logger.getLogger("AccountSysteem").warning(

					"send failed: " + e.getMessage());
		}
	}
}