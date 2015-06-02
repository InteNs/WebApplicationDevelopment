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
        RequestDispatcher requestDispatcher;
        String userName = req.getParameter("username");
        String password = req.getParameter("password");

        if(userService.isLoginValid(userName, password)){
            req.getSession().setAttribute("loggedInUser", userService.getLoginUser(userName, password));
            if (req.getParameter("rememberUserName") != null) {
                Cookie c = new Cookie("cookieUserName", userName);
                c.setMaxAge(2000);
                resp.addCookie(c);
            }
            req.setAttribute("loginDenied", null);
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
            requestDispatcher.forward(req, resp);
        }
        else{
            req.setAttribute("loginDenied", "Inloggen mislukt");
            requestDispatcher = req.getRequestDispatcher("/index.jsp");
        }
        requestDispatcher.forward(req, resp);
    }
}