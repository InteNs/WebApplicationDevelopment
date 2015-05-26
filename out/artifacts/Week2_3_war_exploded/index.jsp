<%--JavaScript--%>
<script>
	function hide(para) {
		this.getElementById(para).style.display = none;
	}
</script>
<%--JSP Imports--%>
<%@ page import="listener.SessionCounterListener"%>
<%--JSP Servlets--%>
	<%--SessionCount--%>
<%  String sessionCount = "<div id=\"mes1\" class=\"info message navItems navPadding messageWidth\">Aantal bezoekers website:"
		+ SessionCounterListener.getTotalActiveSession()+"<span class=\"remove\" onclick=\"hide(mes1)\">x</span></div>";%>
	<%--Cookies--%>
<% 	Cookie[] cookies = request.getCookies();
	String cookieUserName = "";
		if (cookies != null)
			for (Cookie c : cookies)
				if(c.getName().equals("cookieUserName")) cookieUserName = c.getValue();%>
	<%--Messages--%>
<%  Object logoutMessage = request.getAttribute("logoutMessage");
		String logout = "";
			if (logoutMessage != null) { logout = "<div id=\"mes2\" class=\"info message navItems navPadding messageWidth\">"
					+(String) logoutMessage+"<span class=\"remove\" onclick=\"hide(mes2)\">x</span></div>";} %>
<%  Object registrationSuccess = request.getAttribute("registrationSuccess");
		String registration = "";
			if (registrationSuccess != null) { registration = "<div id=\"mes3\" class=\"info message navItems navPadding messageWidth\">"
					+(String) registrationSuccess+"<span class=\"remove\" onclick=\"hide(mes3)\">x</span></div>";} %>
<%  Object loginFailed = request.getAttribute("loginFailed");
		String login = "";
			if (loginFailed != null) { login = "<div id=\"mes4\" class=\"danger message navItems navPadding messageWidth\">"
					+(String) loginFailed+"<span class=\"remove\" onclick=\"hide(mes4)\">x</span></div>";} %>
<%--HTML--%>
<!DOCTYPE html>
<head>
	<title>BlogSite</title>
	<%--Import CSS--%>
	<link rel="stylesheet" type="text/css" href="basic.css"/>
</head>
<body class="inline">
<div class="navBar">
	<%--left side--%>
	<div class="left" style="width:75%;">
			<!-- Login form -->
			<form class="form" id="loginForm" action="login" method="post">
				<div class="left" style="width: 600px">
				<!-- Username -->
				<div class="navPadding">
				<input class="navItems bbox" type="text" name="username" id="username" placeholder="Vul gebruikersnaam in" value="<%=cookieUserName%>"/>
				<!-- Password -->
				<input class="navItems bbox" type="password" name='password' id="password" placeholder="Vul wachtwoord in"/>
				<%--Registratie link pt.1--%>
				<span class="message"> Nog geen gebruikers account? </span>
				</div>
				<!-- Submit/Remember username -->
				<div class="navPadding">
				<input class="navItems bbox" type="submit" value="Aanmelden"/>
				<input type="checkbox" name="rememberUserName" id="rememberUserName"/> Gebruikersnaam onthouden
				<%--Registratie link pt.2--%>
				<span style="padding-left:12px;">
					<input class="navItems bbox" type="button" value="Registreer nu!" onclick="location.href='registration.jsp'"/>
				</span>
				</div>
				</div>
				</div>
			</form>


	</div>
	<%--Right side--%>
	<div class="right" id="messagesObject" style="width: 25%">
		<%--SessionCounter--%>
		<div class="right">
			<!-- Messages -->
			<div class="message navItems navPadding messageWidth"
				 style="font-weight: 900;
				 font-size: 15px;
				 text-decoration: underline;">Meldingen:</div>
			<%=sessionCount%>
			<%=registration%>
			<%=logout%>
			<%=login%>
		</div>
	</div>
</div>

<!-- blogPosts -->
<div class="containerCenter blogs">
	<jsp:include page="blogPosts.jsp" />
</div>
</body>
</html>