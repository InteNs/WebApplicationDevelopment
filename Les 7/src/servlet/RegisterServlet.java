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
import domain.service.EmailService;
import domain.service.ServiceProvider;
import domain.service.UserService;
import domain.service.ValidateService;

public class RegisterServlet extends HttpServlet {
	private ArrayList<User> users = null;
    private static final String MAIL_TITLE = "Uw account is geregistreerd";
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");

        ValidateService validateService = ServiceProvider.getValidateService();
        UserService userService = ServiceProvider.getUserService();
		EmailService emailService = ServiceProvider.getEmailService();

        String 	userName 	  = req.getParameter("username"),
				email 	  	  = req.getParameter("email"),
				emailRepeat	  = req.getParameter("emailRepeat"),
				password 	  = req.getParameter("password"),
				passwordRepeat=	req.getParameter("passwordRepeat"),
				realName      = req.getParameter("realname"),
				address 	  = req.getParameter("address"),
				country 	  = req.getParameter("country"),
				button		  = req.getParameter("button");

		switch (button) {
			case "Registreren":
				if (!validateService.validateAllFields(userName, email, emailRepeat, password, passwordRepeat, realName, address, country)) {
                    //validation failed, do error handling
                    req.setAttribute("register", "register");

                    HashMap<String, String> errorFields = validateService.getErrorFields();
                    for(Map.Entry<String, String> entry : errorFields.entrySet())
                        req.setAttribute(entry.getKey(),entry.getValue());
				} else {
                    //validation succesful
                    userService.addUser(userName, email, password, realName, address, country);
                    String MAIL_MSG = "Beste "+realName+",\n\n"
                                    +"Bedankt voor uw registratie.\n\n"
                                    +"Om toegang te krijgen tot uw account, moet u zich aanmelden met de onderstaande gebruikersnaam. \n"
                                    + "Uw gebruikersnaam is: "+userName;
                    try {emailService.sendMail(email,MAIL_TITLE,MAIL_MSG);
                    } catch (Exception e) {System.err.println("mail could not be send: "+e.getMessage());}
                    req.setAttribute("registrationSuccess", "Registratie gelukt");
                }
				break;
			case "Loginscherm":
				break;
		}
		requestDispatcher.forward(req, resp);
	}
}
