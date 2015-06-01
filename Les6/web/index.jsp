<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Countries!</title>
  <link rel="stylesheet" type="text/css" href="global.css"/>
</head>
<body>
<form action="action" method="post">
  <input type="submit" name="button" value="All Countries"/>
  <input type="submit" name="button" value="West European"/>
  <input type="submit" name="button" value="Largest Surface"/>
  <input type="submit" name="button" value="Republics"/>
  <input type="submit" name="button" value="10 Largest Populations"/>
  <input type="submit" name="button" value="10 Largest Cities"/>
</form>
<table>
  <c:if test="${typeTable == 'Country'}">
    <tr>
      <th>CODE</th>
      <th>Name</th>
      <th>Continent</th>
      <th>Region</th>
      <th>Surface Area</th>
      <th>Population</th>
      <th>Life Expectancy</th>
      <th>Government Form</th>
    </tr>
  </c:if>
  <c:if test="${typeTable == 'City'}">
    <tr>
      <th>Name</th>
      <th>Country Code</th>
      <th>District</th>
      <th>Population</th>
    </tr>
  </c:if>
  <c:forEach var="current" items="${list}">
    <c:if test="${typeTable == 'Country'}">
      <tr>
        <td>${current.code}</td>
        <td>${current.name}</td>
        <td>${current.continent}</td>
        <td>${current.region}</td>
        <td>${current.surfaceArea}</td>
        <td>${current.population}</td>
        <td>${current.lifeExpectancy}</td>
        <td>${current.governmentForm}</td>
      </tr>
    </c:if>
    <c:if test="${typeTable == 'City'}">
      <tr>
        <td>${current.name}</td>
        <td>${current.countryCode}</td>
        <td>${current.district}</td>
        <td>${current.population}</td>
      </tr>
    </c:if>
  </c:forEach>
</table>
</body>
</html>
