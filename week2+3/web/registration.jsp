<%--JSP Imports--%>
<%@ page import="listener.SessionCounterListener"%>
<%--JSP Servlets--%>
    <%--Messages--%>
<% String   errorMessage =          (String) request.getAttribute("errorMessage"),
            userNameNull =          (String) request.getAttribute("userNameNull"),
            realNameNull =          (String) request.getAttribute("realNameNull"),
            emailNull =             (String) request.getAttribute("emailNull"),
            emailRepeatError =      (String) request.getAttribute("emailRepeatError"),
            passwordNull =          (String) request.getAttribute("passwordNull"),
            passwordRepeatError =   (String) request.getAttribute("passwordRepeatError"),
            addressNull =           (String) request.getAttribute("addressNull"),
            countryNull =           (String) request.getAttribute("countryNull");%>
<%--HTML--%>
<!DOCTYPE html>
<head>
    <title>BlogPost: Registratie</title>
    <%--Import CSS--%>
    <link rel="stylesheet" type="text/css" href="basic.css"/>
</head>
<body class="inline">
<div class="navBar">
    <div class="right">
        <%--SessionCounter--%>
        <%= "Aantal bezoekers website: " + SessionCounterListener.getTotalActiveSession() %>
    </div>
</div>
<div class="containerCenter">
    <h4>Registratie formulier</h4>
    <!-- Error messages -->
    <div class="danger">
        <%=errorMessage%>
    </div>
    <!-- Registration form -->
    <form action="register" method="post">
        <!-- Username -->
        <div>
            <div>
                <label for="username" value="Gebruikersnaam:"/>
                <input type="text" name="username" id="username" placeholder="Vul gebruikersnaam in"/>
            </div>
            <div class="danger">
                <%=userNameNull%>
            </div>
        </div>
        <!-- Realname -->
        <div>
            <div>
                <label for="realname" value="Naam: "/>
                <input type="text" name="realname" id="realname" placeholder="Vul naam in"/>
            </div>
            <div class="danger">
                <%=realNameNull%>
            </div>
        </div>
        <!-- Password -->
        <div>
            <div>
                <label for="password" value="Wachtwoord: "/>
                <input type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
            </div>
            <div class="danger">
                <%=passwordNull%>
            </div>
        </div>
        <!-- Password repeat -->
        <div>
            <div>
                <label for="passwordRepeat" value="Herhaal wachtwoord: "/>
                <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="Herhaal wachtwoord"/>
            </div>
            <div class="danger">
                <%=passwordRepeatError%>
            </div>
        </div>
        <!-- Email -->
        <div>
            <div>
                <label for="email" value="Emailadres: "/>
                <input type="email" name="email" id="email" placeholder="Vul emailadres in"/>
            </div>
            <div class="danger">
                <%=emailNull%>
            </div>
        </div>
        <!-- Email repeat -->
        <div>
            <div>
                <label for="emailRepeat" value="Herhaal email: "/>
                <input type="text" name="emailRepeat" id="emailRepeat" placeholder="Herhaal email"/>
            </div>
            <div class="danger">
                <%=emailRepeatError%>
            </div>
        </div>
        <!-- Address -->
        <div>
            <div>
                <label for="address" value="Adres: "/>
                <input type="text" name="address" id="address" placeholder="Vul adres in"/>
            </div>
            <div class="danger">
                <%=addressNull%>
            </div>
        </div>
        <!-- Country -->
        <div>
            <div>
                <label for="country" value="Land: "/>
                <input type="text" name="country" id="country" placeholder="Vul land in"/>
            </div>
            <div class="danger">
                <%=countryNull%>
            </div>
        </div>
        <!-- Buttons -->
        <div>
            <input class="left" type="button" value="Inlogscherm" onclick="location.href='index.jsp'"/>
            <input class="right" type="submit" value="Registreren"/>
        </div>
    </form>
</div>
</body>
</html>
