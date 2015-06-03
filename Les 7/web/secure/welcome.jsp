<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core_1_1" %>
<!DOCTYPE html>
<html>
<head>
    <title>BlogSite</title>
    <link rel="stylesheet" type="text/css" href="/global.css"/>
</head>
<body>
<jsp:include page="/components/welcomePanel.jsp" />
<jsp:include page="/components/blogPost/addBlogPost.jsp" />
<jsp:include page="/components/blogPost/blogPosts.jsp"/>
</body>
</html>
