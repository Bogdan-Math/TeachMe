<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/title.jsp"/>

<body>
<header>
    <jsp:include page="fragments/header.jsp"/>
</header>

<jsp:useBean id="selectedUser" scope="request" type="ua.teachme.model.User"/>
<dl>
    <dd>
        <label>
            <input type="text" value="${selectedUser.mainGoal} : ${selectedUser.mainGoal.description}" name="mainGoal">
        </label>
    </dd>
</dl>

<dl>
    <dd>
        <label>
            <input type="hidden" value="${selectedUser.id}" name="id">
        </label>
    </dd>
</dl>

<dl>
    <dt>name</dt>
    <dd>
        <label>
            <input type="text" value="${selectedUser.name}" name="name">
        </label>
    </dd>
</dl>

<dl>
    <dt>password</dt>
    <dd>
        <label>
            <input type="text" value="${selectedUser.password}" name="password">
        </label>
    </dd>
</dl>

<dl>
    <dt>email</dt>
    <dd>
        <label>
            <input type="text" value="${selectedUser.email}" name="email">
        </label>
    </dd>
</dl>

<dl>
    <dt>hours</dt>
    <dd>
        <label>
            <input type="text" value="${selectedUser.maxHoursPerDay}" name="hours">
        </label>
    </dd>
</dl>

<dl>
    <dt>registered date</dt>
    <dd>
        <label>
            <input type="text" value="${selectedUser.registeredDate}" name="registeredDate">
        </label>
    </dd>
</dl>

<dl>
    <dt>roles</dt>
    <dd>
        <label>
            <input type="text" value="${selectedUser.roles}" name="roles">
        </label>
    </dd>
</dl>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>
</body>
</html>