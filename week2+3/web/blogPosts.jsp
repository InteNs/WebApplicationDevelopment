<%@ page import="java.util.ArrayList" %>
<%@ page import="model.BlogPost" %>
<%@ page import="model.User" %>
<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.LocalTime" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    if (request.getServletContext().getAttribute("usersList") != null)
        for (User user : (ArrayList<User>) request.getServletContext().getAttribute("usersList"))
            for (BlogPost blogPost : user.getBlogPosts())
                out.print(blogPost);
%>
