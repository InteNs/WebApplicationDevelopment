<%--JSP imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--HTML--%>
<!DOCTYPE html>
<head>
  <%--CSS imports--%>
  <link rel="stylesheet" href="../../css/loginPanel.css"/>
</head>
<body class="inline">
<%--Main container--%>
<div class="containerLoginPanel">
  <!-- Registration form -->
  <form action="register" id="registrationForm" method="post">
    <%--Item containers--%>
    <div class="loginPanelBox">
      <h2>Registreren</h2>
    </div>
    <%--Username--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="username" id="username" placeholder="Vul gebruikersnaam in"/>
    </div>
    <%--Realname--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="realname" id="realname" placeholder="Vul naam in"/>
    </div>
    <%--Password--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="password" name="passwordRepeat" id="passwordRepeat" placeholder="Herhaal wachtwoord"/>
    </div>
    <%--Email--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="email" name="email" id="email" placeholder="Vul emailadres in"/>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="emailRepeat" id="emailRepeat" placeholder="Herhaal email"/>
    </div>
    <%--Address--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="address" id="address" placeholder="Vul adres in"/>
    </div>
    <%--Country--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="text" name="country" id="country" placeholder="Vul land in"/>
    </div>
    <%--Buttons--%>
    <div class="loginPanelBox">
      <input class="loginItem" type="submit" value="Registreren"/>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="button" value="Loginscherm" onclick="location.href='index.jsp'"/>
    </div>
    <%-- ^^ Place new form-items here ^^ --%>
  </form>
</div>
</body>
