<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>


<div class="navbar navbar-inverse <%--navbar-fixed-top--%>">

    <div class="container">

        <sec:authorize access="isAuthenticated()">

            <a href="index">
                <div class="navbar-brand"><fmt:message key="app.title"/></div>
            </a>

            <%--@elvariable id="loggedUser" type="java.lang.String"--%>
            <a href="profile">
                <div class="navbar-brand">${loggedUser}</div>
            </a>

            <a href="notations">
                <div class="navbar-brand"><fmt:message key="app.notations"/></div>
            </a>

            <sec:authorize access="hasAuthority('ADMIN')">
                <a href="users">
                    <div class="navbar-brand"><fmt:message key="app.users"/></div>
                </a>
            </sec:authorize>

            <form class="navbar-form navbar-right">
                <a class="btn btn-success" role="button" href="logout"><fmt:message key="app.logout"/></a>
            </form>

        </sec:authorize>
    </div>

</div>