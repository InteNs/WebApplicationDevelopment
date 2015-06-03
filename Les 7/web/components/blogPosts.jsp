<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<hmtl>
    <head>
        <link rel="stylesheet" href="<c:url value="/components/blogPostPanel.css"/>"/>
    </head>
    <body>
    <div class="containerBlogPostPanel">
        <c:if test="${not empty loggedInUser}">
            <jsp:include page="/components/addBlogPost.jsp" />
        </c:if>
        <div class="blogPostTitle">
            <h2>Blogs</h2>
        </div>
        <c:forEach var="currentpost" items="${blogposts}">

            <div class="blogPost">
                <div class="message">
                    <div><h4>Blogbericht:</h4></div>
                        ${currentpost.message}
                    <div class="blogPostFooter">
                        <div>Geschreven door: ${currentpost.user.userName}.</div>
                        <div>Gepost op: <fmt:formatDate value="${currentpost.timeStamp}"
                                                        type="both" dateStyle="full" timeStyle="short" />.</div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
    </body>
</hmtl>