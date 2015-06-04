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
    <th>attribuut</th>
    <th>waarde</th>
  </tr>
    <tr class="tdcolor">
      <td>id</td>
      <td><s:property value="book.id" /><s:fielderror/></td>
    </tr>
  <tr class="tdcolor">
    <td>titel</td>
    <td><s:property value="book.titel" /></td>
  </tr>
  <tr class="tdcolor">
    <td>auteur</td>
    <td><s:property value="book.auteur" /></td>
  </tr>
  <tr class="tdcolor">
    <td>isbn</td>
    <td><s:property value="book.isbn" /></td>
  </tr>
  <tr class="tdcolor">
    <td>pages</td>
    <td><s:property value="book.pages" /></td>
  </tr>
  <tr class="tdcolor">
    <td>status</td>
    <td><s:property value="book.status" /></td>
  </tr>
</table>

<hr />

<a href="<s:url action='BookList' namespace="/visitor" />">Terug naar de boekenlijst</a>
</body>
</html>