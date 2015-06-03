package servlet;

import domain.BlogPost;
import domain.User;
import domain.service.ServiceProvider;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class BlogPostServlet extends HttpServlet{
    private static final long serialVersionUID = 1l;

    protected void doPost( HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        // Get blogpost info.
        User user = (User) req.getSession().getAttribute("loggedInUser");
        String blogText = req.getParameter("message");
        //insert blogpost into database
        ServiceProvider.getBlogPostService().addBlogPost(blogText,user, LocalDateTime.now());
        //refresh the blogpost list in the servletcontext
        req.getServletContext().setAttribute("blogposts",ServiceProvider.getBlogPostService().getAllBlogPosts());
        // Kill servlet and follow request dispatcher
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/secure/welcome.jsp");
        requestDispatcher.forward(req, resp);
    }
}
