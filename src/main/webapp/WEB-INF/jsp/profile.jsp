<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <jsp:include page="fragments/title.jsp"/>
</head>

<body>

<header>
    <jsp:include page="fragments/common-header.jsp"/>
</header>

<jsp:useBean id="selectedUser" scope="request" type="ua.teachme.model.User"/>
<form:form cssClass="in-center" action="profile" method="post">
    <%--
    <dl>
        <dd>
            <label>
                <input type="text" value="${selectedUser.mainGoal} : ${selectedUser.mainGoal.description}" name="mainGoal">
            </label>
        </dd>
    </dl>
    --%>

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
                <input type="text" value="${selectedUser.name}" name="name" required>
            </label>
        </dd>
    </dl>

    <dl>
        <dt>password</dt>
        <dd>
            <label>
                <input type="text" class="reg-error" value="Will be possible to change in future. Work around it!!!" name="password" readonly>
            </label>
        </dd>
    </dl>

    <dl>
        <dt>email</dt>
        <dd>
            <label>
                <input type="text" value="${selectedUser.email}" name="email" required>
            </label>
        </dd>
    </dl>

    <dl>
        <dt>hours</dt>
        <dd>
            <label>
                <input type="number" value="${selectedUser.maxHoursPerDay}" name="hours" required>
            </label>
        </dd>
    </dl>

    <dl>
        <%--
            <dt>registered date</dt>
        --%>
        <dd>
            <label>
                <input type="hidden" value="${selectedUser.registeredDate}" name="registeredDate">
            </label>
        </dd>
    </dl>

    <dl>
        <dt>roles</dt>
        <dd>
            <label>
                ${selectedUser.roles}
                <input type="hidden" value="${selectedUser.roles}" name="roles">
            </label>
        </dd>
    </dl>

    <button type="submit" class="btn btn-primary" id="save"><fmt:message key="button.save"/></button>
    <button type="button" class="btn btn-default" onclick="window.history.back()"><fmt:message key="button.close"/></button>

</form:form>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
