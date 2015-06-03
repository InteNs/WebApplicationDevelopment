package servlet;
import domain.service.ServiceProvider;
import domain.service.UserService;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        UserService userService = ServiceProvider.getUserService();
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/index.jsp");
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        String button   = req.getParameter("button");

        switch(button) {
            case "Inloggen":
                if(userService.isLoginValid(userName,password)){
                    if (req.getParameter("rememberUserName") != null) {
                        Cookie c = new Cookie("cookieUserName", userName);
                        c.setMaxAge(2000);
                        resp.addCookie(c);
                    }
                    req.getSession().setAttribute("loggedInUser", userService.getUser(userName));
                    requestDispatcher = req.getRequestDispatcher("/secure/welcome.jsp");
                } else{
                    req.setAttribute("loginError", "Inloggen mislukt");
                }
                break;
            case "Registreren":
                req.setAttribute("register", "register");
        }
        requestDispatcher.forward(req, resp);
    }
}