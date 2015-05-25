package login;
import model.User;
import java.io.*;
import java.util.ArrayList;
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
        // Create default user and user Attribute
        User user = new User(getServletConfig().getInitParameter("userName"), null, getServletConfig().getInitParameter("password"), "admin", null, null);
        ArrayList users = (ArrayList) servletContext.getAttribute("usersList");
        if(users == null) {
            users = new ArrayList();
        }
        users.add(user);
        servletContext.setAttribute("usersList", users);


        // User credentials
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Logged in users attribute
        ArrayList loggedInUsers = (ArrayList) servletContext.getAttribute("loggedInUsers");

        // Login attempt
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
            // Dispatched to welcome page
            rd = req.getRequestDispatcher("welcome.jsp");
            // Adds user to session
            req.getSession().setAttribute("loggedInUser", user);
            // Add logged in users
            if(loggedInUsers == null)
                loggedInUsers = new ArrayList();
            loggedInUsers.add(user);
            servletContext.setAttribute("loggedInUsers", loggedInUsers);

            if (req.getParameter("rememberUserName") != null) {
                // Creates cookie with username
                Cookie c = new Cookie("cookieUserName", user.getUserName());
                // Sets cookie age
                c.setMaxAge(2000);
                // Adds cookie
                resp.addCookie(c);
            }

        // Login attempt failed
        } else {
            req.setAttribute("message","<div style=\"color: red;\">Verkeerde username en/of verkeerd wachtwoord.</div>");
            rd = req.getRequestDispatcher("index.jsp");
        }

        // Kill servlet and follow request dispatcher
        rd.forward(req, resp);
	}
}
