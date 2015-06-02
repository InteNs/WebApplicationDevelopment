package blog;

import domain.BlogPost;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class BlogPostServlet extends HttpServlet{

    protected void doPost( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Request dispatcher handles request.
        RequestDispatcher rd;

        // Get current user.
        User user = (User) req.getSession().getAttribute("loggedInUser");
        String blogText = req.getParameter("blogPost");

        user.getBlogPosts().add(new BlogPost(blogText, user));

        rd = req.getRequestDispatcher("/secure/welcome.jsp");

        // Kill servlet and follow request dispatcher
        rd.forward(req, resp);
    }
}
