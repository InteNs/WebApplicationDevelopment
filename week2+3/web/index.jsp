<!DOCTYPE html>
<head>
	<title>A.T.D. Terminal</title>
</head>
<body>
<h1>Login</h1>
<br/>
<!-- Login form -->
<form action="login" method="post">
	<!-- Username -->
	<div>
		<input type="text" name="username" id="username" placeholder="Vul gebruikersnaam in"
			   value="<% 	Cookie[] cookies = request.getCookies();
								if (cookies != null)
									for (Cookie c : cookies)
										if(c.getName().equals("cookieUserName")) out.print(c.getValue());
    				  %>">
		<label for="username">Gebruikersnaam</label>
	</div>
	<!-- Password -->
	<div>
		<input type="password" name='password' id="password" placeholder="Vul wachtwoord in">
		<label for="password">Wachtwoord</label>
	</div>
	<!-- Remember username -->
	<div>
		<input type="checkbox" name="rememberUserName" id="rememberUserName">
		<label>Onthoud gebruikersnaam</label>
	</div>

	<br/>
	<!-- Submit button -->
	<button type="submit">Aanmelden</button>
	<br/>
</form>
<!-- Registration -->
<h1>Registreren</h1>
<br/>
<button type="button" onclick="location.href='registration.jsp'">Registreren</button>
<!-- Messages -->
<%
	Object succes = request.getAttribute("message");
	if (succes != null) {
		out.println(succes);
	}
%>
</body>
</html>