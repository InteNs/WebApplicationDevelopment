<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
  <title>Wachtwoord gewijzigd</title>
  <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
</head>

<body>
<h4>Wachtwoord gewijzigd.</h4>

<hr />

Beste <s:property value="username"/>!<br>
Je wachtwoord is gewijzigd.

<hr />

<a href="<s:url action='Menu' namespace="/" />">Terug naar het startmenu</a>
</body>
</html>