<%--HTML--%>
<!DOCTYPE html>
<head>
	<title>BlogSite</title>
	<%--Import CSS--%>
	<link rel="stylesheet" type="text/css" href="css/main.css"/>
</head>
<body>
<jsp:include page="components/loginPanel/loginPanel.jsp" />
<jsp:include page="components/message/blogPosts.jsp" />
<jsp:include page="components/userFeedback/userFeedback.jsp" />
</body>
