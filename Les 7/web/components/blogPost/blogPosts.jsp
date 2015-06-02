<%@ page import="java.util.ArrayList" %>
<%@ page import="model.BlogPost" %>
<%@ page import="model.User" %>
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
            for (BlogPost blogPost : user.getBlogPosts()){
                System.out.println(blogPost.getBlogPost());
%>
    <div class="blogPostPanelBox">
    <div class="blogPost">
        <div><h4>Blogbericht:</h4></div>
            <%=blogPost.getBlogPost()%>
        <div class="blogPostFooter">
        Geschreven door: <%blogPost.getUserName();%>
            <br/>
        Gepost op: <%=blogPost.getDate()%> om <%=blogPost.getTime()%>.
            <br/>
        </div>
    </div>
    </div>
<%}%>
</div>
</body>
