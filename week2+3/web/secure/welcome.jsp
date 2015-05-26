<%--HTML--%>
<!DOCTYPE html>
<html>
<head>
    <title>BlogSite, Welkom: <%=loggedInUser%></title>
    <%--Load CSS--%>
    <link rel="stylesheet" type="text/css" href="../css/main.css"/>
</head>
<body class="inline">
<%--Navigationbar--%>
<div class="navBar">
    <div class="left">
        <h4><%=loggedInUserString%></h4>
    </div>
    <div class="right">
        <%--Logout--%>
        <form action="logout" method="post">
            <input type="submit" value="Uitloggen"/>
        </form>
        <%--SessionCounter--%>
        <%=sessionCount%>
    </div>
</div>
<jsp:include page="../components/loginPanel/loginPanel.jsp" />
<jsp:include page="../components/blogPost/blogPosts.jsp" />
<jsp:include page="../components/userFeedback/userFeedback.jsp" />
</body>
</html>
