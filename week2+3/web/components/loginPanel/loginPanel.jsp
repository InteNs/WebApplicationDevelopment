<%--userFeedback should be imported in the root of the html--%>
<%--JSP imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--JSP Script--%>
<%--HTML--%>
<!DOCTYPE html>
<head>
  <%--CSS imports--%>
  <link rel="stylesheet" href="../../css/loginPanel.css"/>
</head>
<body class="inline">
<%--Main container--%>
<div class="containerLoginPanel">
  <!-- Login form -->
  <form class="form" id="loginForm" action="login" method="post">
    <%--Item containers--%>
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
      <span class="loginItem"><input type="checkbox" name="rememberUserName" id="rememberUserName" title="Gebruikersnaam onthouden"/></span>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="submit" value="Aanmelden"/>
    </div>
    <div class="loginPanelBox">
      <span class="loginItem">Nog geen gebruikers account?</span>
    </div>
    <div class="loginPanelBox">
      <input class="loginItem" type="button" value="Registreer nu!" onclick="location.href='../../registration.jsp'"/>
    </div>
    <%-- ^^ Place new form-items here ^^ --%>
  </form>
</div>
</body>