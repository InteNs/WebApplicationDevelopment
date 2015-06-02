<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<head>
  <link rel="stylesheet" href="<c:url value="/components/loginPanel.css"/>"/>
  <link rel="stylesheet" href="<c:url value="/components/userFeedback.css"/>"/>
</head>
<body>
<div class="containerLoginPanel">
  <form action="register" id="registrationForm" method="post">
    <div class="loginPanelBox">
      <h2>Registreren</h2>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="username" id="username" placeholder="Vul gebruikersnaam in"/>
    </div>
    <c:if test="${not empty userNameNull} or ${not empty userNameExists}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${userNameNull}
            ${userNameExists}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="realname" id="realname" placeholder="Vul naam in"/>
    </div>
    <c:if test="${not empty nameNull}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${nameNull}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
    </div>
    <c:if test="${not empty passwordNull}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${passwordNull}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name="passwordRepeat" id="passwordRepeat" placeholder="Herhaal wachtwoord"/>
    </div>
    <c:if test="${not empty passwordEqual}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${passwordEqual}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="email" name="email" id="email" placeholder="Vul emailadres in"/>
    </div>
    <c:if test="${not empty emailNull} or ${not empty emailExists}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${emailNull}
            ${emailExists}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="emailRepeat" id="emailRepeat" placeholder="Herhaal email"/>
    </div>
    <c:if test="${not empty emailEqual}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${emailEqual}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="address" id="address" placeholder="Vul adres in"/>
    </div>
    <c:if test="${not empty addressNull}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${addressNull}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="country" id="country" placeholder="Vul land in"/>
    </div>
    <c:if test="${not empty countryNull}}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${countryNull}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="submit" value="Registreren" name="button"/>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="submit" value="Loginscherm" name="button"/>
    </div>
  </form>
</div>
</body>
