<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--HTML--%>
<!DOCTYPE html>
<head>
    <%--CSS imports--%>
    <link rel="stylesheet" href="../blogPostPanel.css"/>
</head>
<body class="inline">
<div class="containerBlogPostPanel">

    <div class="blogPostPanelBox">
        <h2>Blogs</h2>
    </div>
    <c:forEach var="currentpost" items="${blogposts}">

        <div class="blogPostPanelBox">
            <div class="message">
                <div><h4>Blogbericht:</h4></div>
                    ${currentpost.message}<br>
                <div class="blogPostFooter">
                    Geschreven door: ${currentpost.user.userName}.
                    <br/>
                    Gepost op: ${currentpost.localDateTime}.
                    <br/>
                </div>
                <br>
                <br>
            </div>
        </div>
    </c:forEach>




    <%--<%--%>
    <%--if (request.getServletContext().getAttribute("usersList") != null)--%>
    <%--for (User user : (ArrayList<User>) request.getServletContext().getAttribute("usersList"))--%>
    <%--for (BlogPost message : user.getBlogPosts()){--%>
    <%--System.out.println(message.getMessage());--%>
    <%--%>--%>
    <%--<div class="blogPostPanelBox">--%>
    <%--<div class="message">--%>
    <%--<div><h4>Blogbericht:</h4></div>--%>
    <%--<%=message.getMessage()%>--%>
    <%--<div class="blogPostFooter">--%>
    <%--Geschreven door: <%message.getUserName();%>--%>
    <%--<br/>--%>
    <%--Gepost op: <%=message.getDate()%> om <%=message.getTime()%>.--%>
    <%--<br/>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--</div>--%>
    <%--<%}%>--%>
</div>
</body>
