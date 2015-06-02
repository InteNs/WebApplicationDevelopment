package login;
import listener.SessionCounterListener;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
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
            // Error messages
            String notificationInit = "<div class=\"notificationBox\"><div class=\"notificationMessage notificationInfo";
            String notificationLogoutSuccess = notificationInit+"\">U bent nu uitgelogd.</div></div>";
            // Log logout users.
            Logger.getLogger("listener.SessionCounterListener").info("User "
                    + req.getSession().getAttribute("loggedInUser")
                    + " logout!\nAmount of online users: "
                    + SessionCounterListener.getTotalActiveSession()
                    + ".");
            ((ArrayList<User>) servletContext.getAttribute("loggedInUsers")).remove(req.getSession().getAttribute("loggedInUser"));
            req.getSession().invalidate();
            req.setAttribute("logoutMessage", notificationLogoutSuccess);
        }
        rd = req.getRequestDispatcher("/index.jsp");
        rd.forward(req, resp);
    }
}

