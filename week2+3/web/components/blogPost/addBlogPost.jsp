<%--JSP Imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Module create blogpost--%>
<div class="blogPostPanelBox">
  <h2>Blogs</h2>
</div>
<div class="blogPostPanelBox">
  <form action="createPost" method="post">
    <textarea rows="4" cols="50" placeholder="Typ hier uw bericht." name="blogPost" id="blogPost" style="resize: none;"></textarea>
    <input class="loginItem" type="reset"   value="Reset"/>
    <input class="loginItem" type="submit"  value="Verstuur"/>
  </form>
</div>

