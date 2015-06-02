<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.BlogPost" %>
<%@ page import="domain.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--HTML--%>
<!DOCTYPE html>
<head>
    <%--CSS imports--%>
    <link rel="stylesheet" href="../../css/blogPostPanel.css"/>
</head>
<body class="inline">
<div class="containerBlogPostPanel">

    <div class="blogPostPanelBox">
        <h2>Blogs</h2>
    </div>
<%
    if (request.getServletContext().getAttribute("usersList") != null)
        for (User user : (ArrayList<User>) request.getServletContext().getAttribute("usersList"))
            for (BlogPost message : user.getBlogPosts()){
                System.out.println(message.getBlogPost());
%>
    <div class="blogPostPanelBox">
    <div class="message">
        <div><h4>Blogbericht:</h4></div>
            <%=message.getBlogPost()%>
        <div class="blogPostFooter">
        Geschreven door: <%message.getUserName();%>
            <br/>
        Gepost op: <%=message.getDate()%> om <%=message.getTime()%>.
            <br/>
        </div>
    </div>
    </div>
<%}%>
</div>
</body>
