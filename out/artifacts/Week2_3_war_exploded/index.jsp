<!DOCTYPE html>
<head>
	<title>A.T.D. Terminal</title>
</head>
<body>
<!-- Login form -->
<div>
<form action="login" method="post">
	<!-- Username -->
	<input type="text" name="username" id="username" placeholder="Vul gebruikersnaam in"
		   value="<% 	Cookie[] cookies = request.getCookies();
							if (cookies != null)
								for (Cookie c : cookies)
									if(c.getName().equals("cookieUserName")) out.print(c.getValue());
   				  %>">
	<!-- Password -->
	<input type="password" name='password' id="password" placeholder="Vul wachtwoord in">
	<!-- Remember username -->
	<input type="checkbox" name="rememberUserName" id="rememberUserName"> Mij onthouden.
	<!-- Submit button -->
	<button type="submit">Aanmelden</button>
	<!-- Registration -->
	<button type="button" onclick="location.href='registration.jsp'">Registreren</button>
	<!-- Messages -->
	<%
		Object succes = request.getAttribute("message");
		if (succes != null) {
			out.println(succes);
		}
	%>
</form>
</div>

<div>
	<!-- blogPosts -->
	<jsp:include page="blogPosts.jsp" />
</div>
</body>
</html>