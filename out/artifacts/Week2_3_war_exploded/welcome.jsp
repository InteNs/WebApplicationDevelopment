<%@ page import="model.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <%
        User loggedInUser =((User)request.getSession().getAttribute("loggedInUser"));
    %>
    <title>Mijn account: <%=loggedInUser.getRealName()%></title>
</head>
<body>
<h1>Welkom <%=loggedInUser.getRealName()%>,</h1>
<p>Je bent nu ingelogged.</p>
<form action="logout" method="post">
    <button type="submit">Uitloggen</button>
</form>
</body>
</html>
