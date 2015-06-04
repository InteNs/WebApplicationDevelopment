<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>

<head>
  <title>Wachtwoord wijzigen</title>
  <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
</head>

<body>
<h4>Wachtwoord wijzigen.</h4>

<hr />

<s:form action="ChangePassword" namespace="/member">
  <s:textfield name="currentpassword" label="Huidig wachtwoord"/>
  <s:password name="newpassword" label="Nieuw wachtwoord"/>
  <s:submit value="Wijzig wachtwoord" />
</s:form>

<hr />

<a href="<s:url action='Menu' namespace="/" />">Terug naar het startmenu</a>
</body>
</html>