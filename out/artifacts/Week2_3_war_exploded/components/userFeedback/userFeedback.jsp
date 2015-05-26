<%--userFeedback should be imported in the root of the html--%>
<%--JSP imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="listener.SessionCounterListener"%>
<%--JSP scripts--%>
<%
    String  errorMessage        =   (String) request.getAttribute("errorMessage"),
            userNameNull        =   (String) request.getAttribute("userNameNull"),
            realNameNull        =   (String) request.getAttribute("realNameNull"),
            emailNull           =   (String) request.getAttribute("emailNull"),
            emailRepeatError    =   (String) request.getAttribute("emailRepeatError"),
            passwordNull        =   (String) request.getAttribute("passwordNull"),
            passwordRepeatError =   (String) request.getAttribute("passwordRepeatError"),
            addressNull         =   (String) request.getAttribute("addressNull"),
            countryNull         =   (String) request.getAttribute("countryNull"),
            logoutMessage       =   (String) request.getAttribute("logoutMessage"),
            loginMessage        =   (String) request.getAttribute("loginMessage");
    String notificationType     = "notificationSuccess";
    String notificationMessage  = "Random test bericht om de notificatie te ontwikkelen";
    String sessionCount =
            "<div class=\"notificationBox\">" +
                    "<div class=\"notificationMessage notificationInfo\">" +
                    "Aantal bezoekers op de website: " +
                    SessionCounterListener.getTotalActiveSession()+
                    "</div>" +
                    "</div>";
//    TODO: Make Arraylist with modular notifications
    if (errorMessage == null) errorMessage                  = "";
    if (userNameNull == null) userNameNull                  = "";
    if (realNameNull == null) realNameNull                  = "";
    if (emailNull == null) emailNull                        = "";
    if (emailRepeatError == null) emailRepeatError          = "";
    if (passwordNull == null) passwordNull                  = "";
    if (passwordRepeatError == null) passwordRepeatError    = "";
    if (addressNull == null) addressNull                    = "";
    if (countryNull == null) countryNull                    = "";
    if (logoutMessage == null) logoutMessage                = "";
    if (loginMessage == null) loginMessage                = "";
%>
<%--HTML--%>
<!DOCTYPE html>
<head>
    <%--CSS imports--%>
    <link rel="stylesheet" href="../../css/userFeedback.css"/>
</head>
<body class="inline">
<%--Main container--%>
<div class="containerNotifications">
    <%--Notification container--%>
    <div class="notificationBox">
        <h2>Berichten</h2>
    </div>
    <%--containerVisitorCount--%>
    <%=sessionCount%>
    <%--Errors Registration--%>
    <%=userNameNull%>
    <%=realNameNull%>
    <%=emailNull%>
    <%=emailRepeatError%>
    <%=passwordNull%>
    <%=passwordRepeatError%>
    <%=addressNull%>
    <%=countryNull%>
    <%=logoutMessage%>
    <%=loginMessage%>
</div>
</body>
</html>