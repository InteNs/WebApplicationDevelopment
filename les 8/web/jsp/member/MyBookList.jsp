<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
  <title>Mijn gereserveerde boeken</title>
  <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
</head>

<body>
<h4>Mijn gereserveerde boeken.</h4>

<hr />

<table>
  <tr class="thcolor">
    <th>id</th>
    <th>titel</th>
    <th>status</th>
  </tr>
  <s:iterator value="userBooks">
    <tr class="tdcolor">
      <td><s:property value="id" /></td>
      <td><s:property value="titel" /></td>
      <td><s:property value="status" /></td>
      <s:if test="status.toString() == 'RESERVED'">
        <td><a href="<s:url action="CancelReservation" namespace="/member" />?bookid=<s:property value="id" />">annuleer reservering</a></td>
      </s:if>
    </tr>
  </s:iterator>
</table>

<hr />

<a href="<s:url action='Menu' namespace="/" />">Terug naar het startmenu</a>
</body>
</html>