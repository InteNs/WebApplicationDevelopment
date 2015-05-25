package login;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;

public class LogoutServlet extends HttpServlet {

    protected void doPost( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd;
        ServletContext servletContext = req.getServletContext();

        if (req.getSession().getAttribute("loggedInUser") != null) {
            ((ArrayList<User>) servletContext.getAttribute("loggedInUsers")).remove(req.getSession().getAttribute("loggedInUser"));
            req.setAttribute("message", "<div style=\"color: green;\">Succesvol uitgelogged.</div>");
        }

        rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}

