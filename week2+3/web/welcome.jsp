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
            .getAttribute("loggedInRealName");
    String loggedIn = (String) request.getSession().getAttribute(
            "loggedInRealName");
  %>
<title>My account: <%=realName%></title>
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>A.T.D. Terminal</title>
        <link href="bootstrap-3.3.4-dist/css/bootstrap.min.css" rel="stylesheet">
        <link href="base.css" rel="stylesheet">
    </head>
    <body></body>
    <!-- Jumbotron -->
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome,<%=realName%></h1></h1>
            <p>Geef alsjeblieft veel geld uit bij ons bedrijf!</p>

            <div class="container-fluid">
                <!-- row kanker blokken =D -->
                <div class="row row-centered">
                    <div class="col-md-3 col-centered">
                        <button type="button" onclick="alert('werkzaam');" class="btn"><span class="glyphicon glyphicon-off blok" style="font-size: 8.0em;"></span></br><span style="font-size:2.0em;">Uitloggen</span></button>
                    </div>
                </div>
            </div>

        </div>
    </div>

    </body>

    <script
            src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="bootstrap-3.3.4-dist/js/bootstrap.min.js"></script>
</html>
