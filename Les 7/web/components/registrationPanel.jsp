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
      <input class="loginItem" type="text" name="username" id="username" placeholder="Vul gebruikersnaam in" value="${param.username}"/>
    </div>
    <c:if test="${not empty usernameerror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${usernameerror}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="realname" id="realname" placeholder="Vul naam in" value="${param.realname}"/>
    </div>
    <c:if test="${not empty realnameerror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${realnameerror}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
    </div>
    <c:if test="${not empty passworderror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${passworderror}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name="passwordRepeat" id="passwordRepeat" placeholder="Herhaal wachtwoord"/>
    </div>
    <c:if test="${not empty passwordrepeaterror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${passwordrepeaterror}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="email" name="email" id="email" placeholder="Vul emailadres in" value="${param.email}"/>
    </div>
    <c:if test="${not empty emailerror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${emailerror}

        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="emailRepeat" id="emailRepeat" placeholder="Herhaal email" value="${param.emailRepeat}"/>
    </div>
    <c:if test="${not empty emailrepeaterror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${emailrepeaterror}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="address" id="address" placeholder="Vul adres in" value="${param.address}"/>
    </div>
    <c:if test="${not empty addresserror}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${addresserror}
        </div>
      </div>
    </c:if>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="country" id="country" placeholder="Vul land in" value="${param.country}"/>
    </div>
    <c:if test="${not empty countryerror}}">
      <div class="notificationBox">
        <div class="notificationMessage notificationError">
            ${countryerror}
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
