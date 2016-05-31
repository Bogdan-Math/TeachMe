<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="navbar navbar-inverse <%--navbar-fixed-top--%>">

    <div class="container">

        <a href="index">
            <div class="navbar-brand"><fmt:message key="app.title"/></div>
        </a>

        <a href="notations">
            <div class="navbar-brand"><fmt:message key="app.notations"/></div>
        </a>

        <a href="users">
            <div class="navbar-brand"><fmt:message key="app.users"/></div>
        </a>

        <form class="navbar-form navbar-right">
            <a class="btn btn-success" role="button" href="logout"><fmt:message key="app.logout"/></a>
        </form>

    </div>

</div>