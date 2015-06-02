package login;
import listener.SessionCounterListener;
import model.User;
import java.io.*;
import java.util.ArrayList;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {

    protected void doPost( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Request dispatcher handles request.
        RequestDispatcher rd;
        // Initialize servlet context
        ServletContext servletContext = req.getServletContext();
        // Error messages
        String notificationInit = "<div class=\"notificationBox\"><div class=\"notificationMessage notificationError";
        String notificationLoginFailed = notificationInit+"\">Gebruikersnaam en/of wachtwoord incorrect.</div></div>";
        // Initialize user
        User user = null;
        // Create default user and user Attribute
        boolean exists = false;
        for(User savedUser : (ArrayList<User>)req.getServletContext().getAttribute("usersList")){
            if (savedUser.getUserName().equals("admin")) exists = true;
        } if (!exists) {
            user = new User(getServletConfig().getInitParameter("userName"), null, getServletConfig().getInitParameter("password"), "admin", null, null);
            ArrayList<User> users = (ArrayList) servletContext.getAttribute("usersList");
            users.add(user);
            servletContext.setAttribute("usersList", users);
        }
        // User credentials
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        // Logged in users attribute
        ArrayList loggedInUsers = (ArrayList) servletContext.getAttribute("loggedInUsers");
        // Boolean login attempt
        boolean success = false;
        // Checks all users for match
        for(User savedUser : (ArrayList<User>)req.getServletContext().getAttribute("usersList")){
            if (savedUser.getUserName().equals(username)&& savedUser.getPassword().equals(password)){
                success = true;
                user = savedUser;
            }
        }
        // Login attempt successful
        if (success) {
            // Log user login's
            Logger.getLogger("listener.SessionCounterListener").info(
                    "User "+user.getUserName()+" login!\nAmount of online users: "+SessionCounterListener.getTotalActiveSession()+".");
            // Adds user to session
            req.getSession().setAttribute("loggedInUser", user);
            // Add logged in users
            if(loggedInUsers == null)
                loggedInUsers = new ArrayList();
            loggedInUsers.add(user);
            servletContext.setAttribute("loggedInUsers", loggedInUsers);
            // Cookie username
            if (req.getParameter("rememberUserName") != null) {
                // Creates cookie with username
                Cookie c = new Cookie("cookieUserName", user.getUserName());
                // Sets cookie age
                c.setMaxAge(2000);
                // Adds cookie
                resp.addCookie(c);
            }
            // Dispatched to welcome page
            req.setAttribute("welcomeMessage", "U bent succesvol ingelogd en kan nu beginnen met bloggen.");
            rd = req.getRequestDispatcher("/secure/welcome.jsp");
          // Login attempt failed
        } else {
            // Log login attempt fails
            Logger.getLogger("listener.SessionCounterListerer").warning("Login failed for "+username+"!");
            req.setAttribute("loginMessage", notificationLoginFailed);
            rd = req.getRequestDispatcher("/index.jsp");
        }
        // Kill servlet and follow request dispatcher
        rd.forward(req, resp);
    }
}
