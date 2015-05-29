<%--JSP Imports--%>
<%@ page import="listener.SessionCounterListener"%>
<%--JSP Servlets--%>
    <%--Messages--%>
<% String   errorMessage =          (String) request.getAttribute("errorMessage"),
            userNameNull =          (String) request.getAttribute("userNameNull"),
            userNameUsed =          (String) request.getAttribute("userNameUsed"),
            realNameNull =          (String) request.getAttribute("realNameNull"),
            emailNull =             (String) request.getAttribute("emailNull"),
            emailRepeatError =      (String) request.getAttribute("emailRepeatError"),
            emailUsed =             (String) request.getAttribute("emailUsed"),
            passwordNull =          (String) request.getAttribute("paswordNull"),
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
        <%if(errorMessage != null)out.print(errorMessage);%>
    </div>
    <!-- Registration form -->
    <form action="register" method="post">
        <!-- Username -->
        <div>
            <div>
                <label for="username" value="Gebruikersnaam:"></label>
                <input type="text" name="username" id="username" placeholder="Vul gebruikersnaam in"/>
            </div>
            <div class="danger">
                <%if(userNameNull != null)out.print(userNameNull);%>
                <%if(userNameUsed != null)out.print(userNameUsed);%>
            </div>
        </div>
        <!-- Realname -->
        <div>
            <div>
                <label for="realname" value="Naam: "></label>
                <input type="text" name="realname" id="realname" placeholder="Vul naam in"/>
            </div>
            <div class="danger">
                <%if(realNameNull != null)out.print(realNameNull);%>
            </div>
        </div>
        <!-- Password -->
        <div>
            <div>
                <label for="password" value="Wachtwoord: "></label>
                <input type="password" name="password" id="password" placeholder="Vul wachtwoord in"/>
            </div>
            <div class="danger">
                <%if(passwordNull != null)out.print(passwordNull);%>
            </div>
        </div>
        <!-- Password repeat -->
        <div>
            <div>
                <label for="passwordRepeat" value="Herhaal wachtwoord: "></label>
                <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="Herhaal wachtwoord"/>
            </div>
            <div class="danger">
                <%if(passwordRepeatError != null)out.print(passwordRepeatError);%>
            </div>
        </div>
        <!-- Email -->
        <div>
            <div>
                <label for="email" value="Emailadres: "></label>
                <input type="email" name="email" id="email" placeholder="Vul emailadres in"/>
            </div>
            <div class="danger">
                <%if(emailNull != null)out.print(emailNull);%>
                <%if(emailUsed != null)out.print(emailUsed);%>
            </div>
        </div>
        <!-- Email repeat -->
        <div>
            <div>
                <label for="emailRepeat" value="Herhaal email: "></label>
                <input type="text" name="emailRepeat" id="emailRepeat" placeholder="Herhaal email"/>
            </div>
            <div class="danger">
                <%if(emailRepeatError != null)out.print(emailRepeatError);%>
            </div>
        </div>
        <!-- Address -->
        <div>
            <div>
                <label for="address" value="Adres: "></label>
                <input type="text" name="address" id="address" placeholder="Vul adres in"/>
            </div>
            <div class="danger">
                <%if(addressNull != null)out.print(addressNull);%>
            </div>
        </div>
        <!-- Country -->
        <div>
            <div>
                <label for="country" value="Land: "></label>
                <input type="text" name="country" id="country" placeholder="Vul land in"/>
            </div>
            <div class="danger">
                <%if(countryNull != null)out.print(countryNull);%>
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
