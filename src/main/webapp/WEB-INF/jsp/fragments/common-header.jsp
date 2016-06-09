<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse <%--navbar-fixed-top--%>">

    <div class="container">

        <sec:authorize access="isAuthenticated()">

            <a href="index">
                <div class="navbar-brand"><fmt:message key="app.title"/></div>
            </a>

            <%--@elvariable id="loggedUser" type="java.lang.String"--%>
            <a href="profile">
                <div class="navbar-brand"><fmt:message key="app.profile"/> ${loggedUser}</div>
            </a>

            <a href="notations">
                <div class="navbar-brand"><fmt:message key="app.notations"/></div>
            </a>

            <sec:authorize access="hasAuthority('ADMIN')">
                <a href="users">
                    <div class="navbar-brand"><fmt:message key="app.users"/></div>
                </a>
            </sec:authorize>

            <jsp:include page="language.jsp"/>

            <form:form cssClass="navbar-form navbar-right" action="logout" method="post">
                <button class="btn btn-success" type="submit"><fmt:message key="app.logout"/></button>
            </form:form>

        </sec:authorize>
    </div>

</div>