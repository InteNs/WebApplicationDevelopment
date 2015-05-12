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
        <link href="custom.css" rel="stylesheet">
    </head>
    <body>
    <!-- CAROUSEL -->

    <div id="carousel-example-generic" class="carousel slide carou" data-ride="carousel">
        <!-- Indicators -->
        <ol class="carousel-indicators">
            <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
            <li data-target="#carousel-example-generic" data-slide-to="1"></li>
            <li data-target="#carousel-example-generic" data-slide-to="2"></li>
        </ol>

        <!-- Wrapper for slides -->
        <div class="carousel-inner" role="listbox">
            <div class="item active">
                <img src="http://car-logos.org/wp-content/uploads/2011/09/marchedrs.png" alt="wijze lul" class="carou-img">
                <div class="carousel-caption">
                    ...
                </div>
            </div>
            <div class="item">
                <img src="http://car-logos.50webs.com/logo/bmw/bmw2.gif" class="carou-img">
                <div class="carousel-caption">

                </div>
            </div>
        </div>

        <!-- Controls -->
        <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
            <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
        </a>
        <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
            <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
        </a>
    </div>

    <!-- Jumbotron -->
    <div class="jumbotron">
        <div class="container">
            <h1>Welcome,<%=realName%></h1></h1>
            <p>Geef alsjeblieft veel geld uit bij ons bedrijf!</p>

            <div class="container-fluid">
                <!-- row kanker blokken =D -->
                <div class="row row-centered">
                    <div class="col-md-3 col-centered">
                        <span class="glyphicon glyphicon-calendar blok" style="font-size: 10.8em;"></span>

                    </div>
                    <div class="col-md-3 col-centered">
                        <span class="glyphicon glyphicon-euro blok" style="font-size: 10.8em;"></span>
                    </div>
                    <div class="col-md-3 col-centered">
                        <span class="glyphicon glyphicon-user blok" style="font-size: 10.8em;"></span>
                    </div>
                    <div class="col-md-3 col-centered">
                        <span class="glyphicon glyphicon-off blok" style="font-size: 10.8em;"></span>
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
<br>
</body>
</html>
