<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
            <li><a href="<s:url action='BookReservationForm' namespace="/member"/>">Reserveer boek</a></li>
            <%--<li><a href="<s:url action='CancelReservationForm' namespace="/member"/>">Annuleer reservering</a></li>--%>
            <li><a href="<s:url action='MyBookList' namespace="/member"/>">Alle gereserveerde en geleende boeken</a></li>
            <li><a href="<s:url action='ChangePasswordForm' namespace="/member"/>">Wijzig wachtwoord</a></li>
            <li><a href="<s:url action='Logout' namespace="/member"/>">Log uit</a></li>	
