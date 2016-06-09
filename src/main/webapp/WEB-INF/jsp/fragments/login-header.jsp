<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<div class="navbar navbar-inverse">

    <div class="container">

        <a href="index">
            <div class="navbar-brand"><fmt:message key="app.title"/></div>
        </a>

        <jsp:include page="language.jsp"/>

        <form:form class="navbar-form navbar-right" action="spring_security_check" method="post">
            <div class="form-group">
                    <%--Don't change!!! Spring Security need EXACT: name='username'--%>
                <input
                        type="text"
                        placeholder="<fmt:message key="table.users.email"/>"
                        class="form-control"
                        name='username'>
            </div>
            <div class="form-group">
                    <%--Don't change!!! Spring Security need EXACT: name='password'--%>
                <input
                        type="password"
                        placeholder="<fmt:message key="table.users.password"/>"
                        class="form-control"
                        name='password'
                >
            </div>
            <button type="submit" class="btn btn-success"><fmt:message key="app.login"/></button>
        </form:form>

    </div>

</div>