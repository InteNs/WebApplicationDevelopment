<%--JSP Imports--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--Module create blogpost--%>
<div class="blogPostPanelBox">
  <h2>Blogs</h2>
</div>
<div class="blogPostPanelBox">
  <form action="createPost" method="post">
    <div style="align-content: center">
    <textarea rows="5" cols="72" placeholder="Typ hier uw bericht." name="message" id="message" style="resize: none;"></textarea>
    </div>
    <input class="loginItem" type="reset"   value="Reset"/>
    <input class="loginItem" type="submit"  value="Verstuur"/>
  </form>
</div>

