<!DOCTYPE html>
<head>
    <title>A.T.D. Terminal</title>
</head>
<body>
<h4>Registreren</h4>
<br/>
<!-- Error messages -->
<%
    Object message = request.getAttribute("message");
    if (message != null) {
        out.print(message + "<br/>");
    }
%>
<!-- Register form -->
<form action="register" method="post">
    <!-- Username -->
    <div>
        <input type="text" name="username" id="username" placeholder="Vul gebruikersnaam in">
        <label for="username">Username <%
            Object userNameNull = request.getAttribute("userNameNull");
            if (userNameNull != null) {
                out.print(userNameNull);
            }
        %></label>
    </div>
    <!-- Realname -->
    <div>
        <input type="text" name="realname" id="realname" placeholder="Vul naam in">
        <label for="realname">Naam <%
            Object realNameNull = request.getAttribute("realNameNull");
            if (realNameNull != null) {
                out.print(realNameNull);
            }
        %></label>
    </div>
    <!-- Password -->
    <div>
        <input type="password" name="password" id="password" placeholder="Vul wachtwoord in">
        <label for="password">Wachtwoord <%
            Object passwordNull = request.getAttribute("passwordNull");
            if (passwordNull != null) {
                out.print(passwordNull);
            }
        %></label>
    </div>
    <!-- Password repeat -->
    <div>
        <input type="password" name="passwordRepeat" id="passwordRepeat" placeholder="Herhaal wachtwoord">
        <label for="passwordRepeat">Herhaal wachtwoord <%
            Object passwordRepeatError = request.getAttribute("passwordRepeatError");
            if (passwordRepeatError != null) {
                out.print(passwordRepeatError);
            }
        %></label>
    </div>
    <!-- Email -->
    <div>
        <input type="text" name="email" id="email" placeholder="Vul email in">
        <label for="email">Emailadres <%
            Object emailNull = request.getAttribute("emailNull");
            if (emailNull != null) {
                out.print(emailNull);
            }
        %></label>
    </div>
    <!-- Email repeat -->
    <div>
        <input type="text" name="emailRepeat" id="emailRepeat" placeholder="Herhaal email">
        <label for="emailRepeat">Herhaal emailadres <%
            Object emailRepeatError = request.getAttribute("emailRepeatError");
            if (emailRepeatError != null) {
                out.print(emailRepeatError);
            }
        %></label>
    </div>
    <!-- Address -->
    <div>
        <input type="text" name="address" id="address" placeholder="Vul adres in">
        <label for="address">Adres <%
            Object addressNull = request.getAttribute("addressNull");
            if (addressNull != null) {
                out.print(addressNull);
            }
        %></label>
    </div>
    <!-- Country -->
    <div>
        <input type="text" name="country" id="country" placeholder="Vul land in">
        <label for="country">Land <%
            Object countryNull = request.getAttribute("countryNull");
            if (countryNull != null) {
                out.print(countryNull);
            }
        %></label>
    </div>

    <br/>
    <!-- Buttons -->
        <button type="submit">Registreren</button>
        <br/>
        <button type="button" onclick="location.href='index.jsp'">Naar inloggen</button>
    </div>
</form>
</body>
</html>
