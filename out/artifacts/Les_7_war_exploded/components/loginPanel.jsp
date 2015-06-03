<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<c:url value="/components/loginPanel.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/components/userFeedback.css"/>"/>
</head>
<body>
<div class="containerLoginPanel">
  <form class="form" id="loginForm" action="login" method="post">
    <div class="loginPanelBox">
      <h2>Inloggen</h2>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="username" id="username" placeholder="Vul gebruikersnaam in" value="${cookie.cookieUserName.value}"/>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name='password' id="password" placeholder="Vul wachtwoord in"/>
    </div>
    <div class="loginPanelBox">
      <span class="loginItem"><input type="checkbox" name="rememberUserName" id="rememberUserName" title="Gebruikersnaam onthouden"/>Gebruikersnaam onthouden</span>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="submit" value="Inloggen" name="button"/>
    </div>
    <c:if test="${not empty loginError}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${loginError}
        </div>
      </div>
    </c:if>
    <c:if test="${not empty logoutInfo}">
      <div class="notificationBox">
        <div class="notificationMessage notificationInfo">
            ${logoutInfo}
        </div>
      </div>
    </c:if>
    <c:if test="${not empty registrationSuccess}">
      <div class="notificationBox">
        <div class="notificationMessage notificationSuccess">
            ${registrationSuccess}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <span class="loginItem">Nog geen gebruikers account?</span>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="submit" value="Registreren" name="button"/>
    </div>
  </form>
</div>
</body>