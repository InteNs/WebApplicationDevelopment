<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>

<head>
    <title>reserveer</title>
    <link rel="stylesheet" type="text/css" href="../css/bieb.css" />
</head>

<body>
<h4>reserveer.</h4>

<hr />

<table>
    <tr class="thcolor">
        <th>id</th>
        <th>titel</th>
        <th>status</th>
    </tr>
    <s:iterator value="availableBooks">
        <tr class="tdcolor">
            <td><s:property value="id" /></td>
            <td><s:property value="titel" /></td>
            <td><s:property value="status" /></td>
            <td><a href="<s:url action="ReserveBook" namespace="/member" />?bookid=<s:property value="id" />">reserveer</a></td>
        </tr>
    </s:iterator>
</table>

<hr />

<a href="<s:url action='Menu' namespace="/" />">Terug naar het startmenu</a>
</body>
</html>