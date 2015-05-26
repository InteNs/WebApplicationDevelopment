<%--JSP imports--%>
<%@ page import="model.User" %>
<%@ page import="listener.SessionCounterListener" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSP Servlets--%>
    <%--loggedUser load--%>
<%  User loggedInUser =((User)request.getSession().getAttribute("loggedInUser")); %>
<%  String realName = loggedInUser.getRealName(); %>
<%  String loggedInUserString = "Ingelogd met: "+loggedInUser; %>
<%--loggedUser check--%>
<%  try { out.print(loggedInUser.getRealName()); }
catch(Exception exeption){ pageContext.forward("index.jsp"); } %>
    <%--SessionCount--%>
<%  String sessionCount = "Aantal bezoekers website: " + SessionCounterListener.getTotalActiveSession(); %>
    <%--Messages--%>
<%  Object welcomeMessage = request.getAttribute("welcomeMessage");
        String welcome = "Default welcome text.";
        if (welcomeMessage != null) { welcome = (String) welcomeMessage;} %>
<%--HTML--%>
<!DOCTYPE html>
<html>
<head>
    <title>BlogSite, Welkom: <%=loggedInUser%></title>
    <%--Load CSS--%>
    <link rel="stylesheet" type="text/css" href="../basic.css"/>
</head>
<body class="inline">
<%--Navigationbar--%>
<div class="navBar">
    <div class="left">
        <h4><%=loggedInUserString%></h4>
    </div>
    <div class="right">
        <%--Logout--%>
        <form action="logout" method="post">
            <input type="submit" value="Uitloggen"/>
        </form>
        <%--SessionCounter--%>
        <%=sessionCount%>
    </div>
</div>
<%--UI container--%>
<div class="containerRight">
    <h2>Welkom <%=realName%>,</h2>
    <p><%=welcome%></p>
    <!-- add blogPosts -->
    <jsp:include page="../addBlogPost.jsp" />
</div>
<%--Blog container--%>
<div class="containerLeft blogs">
    <!-- blogPosts -->
    <jsp:include page="../blogPosts.jsp" />
</div>
</body>
</html>
