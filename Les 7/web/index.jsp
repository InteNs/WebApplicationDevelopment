<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<!DOCTYPE html>
<html>
<head>
	<title>BlogSite</title>
	<link rel="stylesheet" type="text/css" href="global.css"/>
</head>
<body>
<c:if test="${not empty register}">
	<jsp:include page="/components/registrationPanel.jsp" />
</c:if>
<c:if test="${empty register}">
	<jsp:include page="/components/loginPanel.jsp" />
</c:if>
<jsp:include page="components/blogPosts.jsp" />
</body>
</html>
