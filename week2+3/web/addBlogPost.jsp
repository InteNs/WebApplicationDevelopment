<%--JSP Imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Module create blogpost--%>
<div class="right container">
  <form action="createPost" method="post">
    <textarea rows="4" cols="50" placeholder="Typ hier uw bericht." name="blogPost" id="blogPost" style="resize: none;"></textarea>
    <input type="reset"   value="Reset"/>
    <input type="submit"  value="Verstuur">
  </form>
</div>
