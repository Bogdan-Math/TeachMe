<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:useBean id="loggedUserMainGoal" scope="request" type="ua.teachme.model.MainGoal"/>
<div class="navbar-form navbar-right">

    <a class="btn main-goal-btn" type="submit" id="mainGoal">
        <b><fmt:message key="user.main_goal"/></b>
        <div class="in-line personal-main-goal">${loggedUserMainGoal.name}</div>
    </a>

</div>

<%--
<script>
    var div = document.getElementById("mainGoal");
    div.onmouseover = function(){
        div.setAttribute("style","color:lightgreen;");
    };
    div.onmouseout = function(){
        div.setAttribute("style","color:lightgreen;");
    };
    div.onclick = function(){
        div.setAttribute("style","color:lightgreen;");
    };
</script>--%>
