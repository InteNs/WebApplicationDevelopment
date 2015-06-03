<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
  <title>Boek informatie</title>
  <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
</head>

<s:bean name="biebActions.visitor.BookInfo" var="book" />

<body>
<h4>Boek informatie.</h4>

<hr />


<table>
  <tr class="thcolor">
    <th>id</th>
    <th>titel</th>
    <th>status</th>
  </tr>
    <tr class="tdcolor">
      <td><s:property value="id" /></td>
      <td><s:property value="titel" /></td>
      <td><s:property value="status" /></td>
    </tr>
</table>

<hr />

<a href="<s:url action='BookList' namespace="/" />">Terug naar de boekenlijst</a>
</body>
</html>