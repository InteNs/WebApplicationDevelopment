<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="<c:url value="/components/loginPanel.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/components/userFeedback.css"/>"/>
</head>
<body>
<div class="containerLoginPanel">
    <div class="loginPanelBox">
        <h2>Welkom ${loggedInUser.getRealName()}, </h2>
    </div>
    <div class="loginPanelBox">
        <p>U kunt nu beginnen met blogposts plaatsten.</p>
        <p>Als u klaar bent kunt u weer uitloggen.</p>
    </div>
    <div class="loginPanelBox">
        <form action="logout" method="post">
            <input type="submit" value="Uitloggen"/>
        </form>
    </div>
</div>
</body>
