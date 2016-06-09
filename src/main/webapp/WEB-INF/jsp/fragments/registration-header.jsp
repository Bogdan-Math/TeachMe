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

    </div>

</div>