package servlet;
import java.io.*;
import java.util.*;
import java.util.logging.Logger;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import domain.service.ServiceProvider;
import domain.service.UserService;
import domain.service.ValidateService;

public class RegisterServlet extends HttpServlet {
	private ArrayList<User> users = null;
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
		String 	userName 	  = req.getParameter("username"),
				email 	  	  = req.getParameter("email"),
				emailRepeat	  = req.getParameter("emailRepeat"),
				password 	  = req.getParameter("password"),
				passwordRepeat=	req.getParameter("passwordRepeat"),
				realName      = req.getParameter("realname"),
				address 	  = req.getParameter("address"),
				country 	  = req.getParameter("country"),
				button		  = req.getParameter("button");
        System.out.println(req.getParameterMap());
        ValidateService validateService = ServiceProvider.getValidateService();
        UserService userService = ServiceProvider.getUserService();
		switch (button) {
			case "Registreren":
				if (!validateService.validateAllFields(userName, email, emailRepeat, password, passwordRepeat, realName, address, country)) {
                    HashMap<String, String> selects = validateService.getErrorFields();
                    req.setAttribute("register", "register");
                    for(Map.Entry<String, String> entry : selects.entrySet())
                        req.setAttribute(entry.getKey(),entry.getValue());
				} else {
                    userService.addUser(userName, email, password, realName, address, country);
                    System.out.println("User added");
                    req.setAttribute("registrationSuccess", "Registratie gelukt");
                }
				break;
			case "Loginscherm":;
				break;
		}
		requestDispatcher.forward(req, resp);
	}
}

// TODO: Validate in UserService
//		if(!Objects.equals(userName, "")
//				&& !Objects.equals(email, "")
//				&& email.equals(req.getParameter("emailRepeat"))
//				&& !Objects.equals(password, "")
//				&& password.equals(req.getParameter("passwordRepeat"))
//				&& !Objects.equals(realName, "")
//				&& !Objects.equals(address, "")
//				&& !Objects.equals(country, "")
//				&& !doesExist(email)
//				&& !doesExist(userName))
//			if (Objects.equals(userName, "")) 	req.setAttribute("userNameNull", 	notificationNullErrorUsername);
//			if (Objects.equals(email, "")) 		req.setAttribute("emailNull", 		notificationNullErrorEmail);
//			if (Objects.equals(password, "")) 	req.setAttribute("passwordNull", 	notificationNullErrorPassword);
//			if (Objects.equals(realName, "")) 	req.setAttribute("realNameNull", 	notificationNullErrorRealname);
//			if (Objects.equals(address, "")) 	req.setAttribute("addressNull", 	notificationNullErrorAddress);
//			if (Objects.equals(country, "")) 	req.setAttribute("countryNull", 	notificationNullErrorCountry);
//			// Repeat errors
//			if (!password.equals(req.getParameter("emailRepeat")))
//				req.setAttribute("emailRepeatError", 	"Email"+notificationRepeatErrorEmail);
//			if (!password.equals(req.getParameter("passwordRepeat")))
//				req.setAttribute("passwordRepeatError", "Wachtwoord"+notificationRepeatErrorPassword);
//			//already exists errors
//			if (doesExist(email))req.setAttribute("emailUsed", notificationEmailInUseError);
//			if (doesExist(userName))req.setAttribute("userNameUsed",notificationUserNameInUseError);
//			// Main error message
//				req.setAttribute("errorMessage", "Registratie mislukt.");
// disppatch to registration form with error messages

//			TODO: Add User in UserService
//			user = new User(userName, email, password, realName, address, country);
//			// add user to arraylist in servletContext
//			ArrayList users = (ArrayList) servletContext.getAttribute("usersList");
//			if(users == null)
//				users = new ArrayList();
//			users.add(user);
//			servletContext.setAttribute("usersList", users);

//TODO: Registration message in MailSevice
//			try {
//				sendMail(user.getEmail(), "Registratie gelukt!",
//						"U kunt nu inloggen:http://localhost:8080/index.jsp");
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		private void sendMail(String mailAddress, String title, String message) {
//			Properties props = new Properties();
//			props.put("mail.smtp.host", "smtp.strato.com");
//			props.put("mail.smtp.port", 465);
//			props.put("mail.smtp.ssl.enable", true);
//			Session mailSession = Session.getInstance(props);
//			try {
//				MimeMessage msg = new MimeMessage(mailSession);
//				msg.setFrom(new InternetAddress("autototaaldienst@dense-code.com", "webmaster"));
//				msg.setRecipients(Message.RecipientType.TO, mailAddress);
//				msg.setSubject(title);
//				msg.setText(message);
//				msg.setSentDate(Calendar.getInstance().getTime());
//
//				//Transport.send(msg, "autototaaldienst@dense-code.nl", "password1");
//
//			} catch (Exception e) {
//				Logger.getLogger("AccountSysteem").warning(
//
//						"send failed: " + e.getMessage());
//			}
//		}