package login;
import listener.SessionCounterListener;
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
import java.util.logging.Logger;

public class LogoutServlet extends HttpServlet {

    protected void doPost( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher rd;
        ServletContext servletContext = req.getServletContext();

        if (req.getSession().getAttribute("loggedInUser") != null) {
            ((ArrayList<User>) servletContext.getAttribute("loggedInUsers")).remove(req.getSession().getAttribute("loggedInUser"));
            req.getSession().invalidate();
            req.setAttribute("message", "<div style=\"color: green;\">Succesvol uitgelogged.</div>");

            User user = (User) req.getSession().getAttribute("loggedInUser");
            Logger.getLogger("listener.SessionCounterListener").info("User "
                    + user.getUserName()
                    + " logout!\nAmount of online users: "
                    + SessionCounterListener.getTotalActiveSession()
                    + ".");
        }

        rd = req.getRequestDispatcher("index.jsp");
        rd.forward(req, resp);
    }
}

