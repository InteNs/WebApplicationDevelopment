<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title></title>
  </head>
  <body>
    <form action="action" method="post">
      <input type="submit" value="Get Cities"/>
    </form>
  <%
    ArrayList cities = (ArrayList) request.getAttribute("cities");
    if (cities != null)
      for(Object city : cities){
        out.print(city);
  %>
    <br/>
  <%
    }
  %>
  </body>
</html>
