<%--JSP imports--%>
<%@ page import="model.User" %>
<%@ page import="listener.SessionCounterListener" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--JSP Servlets--%>
<%--loggedUser load--%>
<%  User loggedInUser =((User)request.getSession().getAttribute("loggedInUser")); %>
<%  String realName = loggedInUser.getRealName(); %>
<%
  try { loggedInUser.getRealName(); }
  catch(Exception exeption){ pageContext.forward("index.jsp"); }
%>
<%--SessionCount--%>
<%  String sessionCount = "Aantal bezoekers website: " + SessionCounterListener.getTotalActiveSession(); %>
<%--Messages--%>
<%  Object welcomeMessage = request.getAttribute("welcomeMessage");
  String welcome = "Default welcome text.";
  if (welcomeMessage != null) { welcome = (String) welcomeMessage;} %>
<%--HTML--%>
<!DOCTYPE html>
<head>
  <%--CSS imports--%>
  <link rel="stylesheet" href="../../css/loginPanel.css"/>
</head>
<body class="inline">
<%--Main container--%>
<div class="containerLoginPanel">
    <%--Item containers--%>
    <div class="loginPanelBox">
      <h2>Welkom <%=loggedInUser%>, </h2>
    </div>
    <div class="loginPanelBox">
      <%=welcome%>
    </div>
    <div class="loginPanelBox">
      <%--Logout--%>
      <form action="logout" method="post">
        <input type="submit" value="Uitloggen"/>
      </form>
    </div>
</div>
</body>
</html>