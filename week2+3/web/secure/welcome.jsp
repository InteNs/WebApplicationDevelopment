<%@ page import="model.User" %>
<%@ page import="listener.SessionCounterListener" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <%
        User loggedInUser =((User)request.getSession().getAttribute("loggedInUser"));
    %>
    <title>Mijn account:
        <%
            try { out.print(loggedInUser.getRealName()); }
            catch(Exception exeption){ pageContext.forward("index.jsp"); }
        %>
    </title>
    <link rel="stylesheet" type="text/css" href="../basic.css"/>
</head>
<body>
<!-- Online user counter -->
<div>
    <%= "Aantal gebruikers online: " + SessionCounterListener.getTotalActiveSession() %>
</div>
<div>
    Welkom <%=loggedInUser.getRealName()%>,
    <p>Je bent nu ingelogged en kunt beginnen met posten van blogs.</p>
    <form action="logout" method="post">
        <button type="submit">Uitloggen</button>
    </form>
</div>

<div>
    <!-- add blogPosts -->
    <jsp:include page="../addBlogPost.jsp" />
</div>

<div>
    <!-- blogPosts -->
    <jsp:include page="../blogPosts.jsp" />
</div>

</body>
</html>
