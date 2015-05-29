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
<jsp:include page="../../components/blogPost/addBlogPost.jsp" />
  <div class="blogPostPanelBox">
    <h2>Blogs</h2>
  </div>
  <%
    if (request.getServletContext().getAttribute("usersList") != null)
      for (User user : (ArrayList<User>) request.getServletContext().getAttribute("usersList"))
        for (BlogPost blogPost : user.getBlogPosts())
          out.print(blogPost);
  %>
</div>
</body>
