<%--userFeedback should be imported in the root of the html--%>
<%--JSP imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String  errorMessage        =   (String) request.getAttribute("errorMessage"),
          userNameNull        =   (String) request.getAttribute("userNameNull"),
          realNameNull        =   (String) request.getAttribute("realNameNull"),
          emailNull           =   (String) request.getAttribute("emailNull"),
          emailRepeatError    =   (String) request.getAttribute("emailRepeatError"),
          passwordNull        =   (String) request.getAttribute("passwordNull"),
          passwordRepeatError =   (String) request.getAttribute("passwordRepeatError"),
          addressNull         =   (String) request.getAttribute("addressNull"),
          countryNull         =   (String) request.getAttribute("countryNull");
%>
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
    <div class="loginPanelBox">
      <%=userNameNull%>
      <%=realNameNull%>
      <%=passwordNull%>
      <%=passwordRepeatError%>
      <%=emailNull%>
      <%=emailRepeatError%>
      <%=addressNull%>
      <%=countryNull%>
    </div>
    <%-- ^^ Place new form-items here ^^ --%>
  </form>
</div>
</body>
</html>