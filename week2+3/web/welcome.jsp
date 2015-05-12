<%--
  Created by IntelliJ IDEA.
  User: InteNs
  Date: 12-5-2015
  Time: 19:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <%
    String realName = (String) request.getSession()
            .getAttribute("loggedInUserName");
    String loggedIn = (String) request.getSession().getAttribute(
            "loggedInUserName");
  %>
  <title>My account: <%=realName%></title>
  <style>
    .ltf {
      background-color: white;
      border-style: solid;
      border-size: 4em;
      border-color: gray;
      font-family: "Ubuntu";
      font-size: 20px;
    }

    body {
      font-family: "Ubuntu";
      font-size: 17px;
      color: purple;
    }

    .button {
      padding: 5px 15px;
      background: #ccc;
      border: 0 none;
      cursor: pointer;
      -webkit-border-radius: 5px;
      border-radius: 5px;
    }

    .input1 {
      font-family: "Ubuntu";
      font-size: 14.1059px;
      color: purple;
    }
  </style>

</head>
<body>
<h1>
  Welcome,
  <%=realName%></h1>
<br>
</body>
</html>
