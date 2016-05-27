<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="navbar navbar-inverse">

    <div class="container">
        <form class="navbar-form navbar-right" role="form" action="spring_security_check" method="post">
            <div class="form-group">
                <%--Don't change!!! Spring Security need EXXACT: name='username'--%>
                <input type="text" placeholder="Email" class="form-control" name='username'>
            </div>
            <div class="form-group">
                <%--Don't change!!! Spring Security need EXXACT: name='password'--%>
                <input type="password" placeholder="Password" class="form-control" name='password'>
            </div>
            <button type="submit" class="btn btn-success"><fmt:message key="app.login"/></button>
        </form>
    </div>

</div>