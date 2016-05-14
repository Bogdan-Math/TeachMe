<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/title.jsp"/>

<body>
    <header>
        <jsp:include page="fragments/header.jsp"/>
    </header>

<section>
    <table border="1" cellpadding="8" cellspacing="0">
        <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Roles</th>
            <th>Registered Date</th>
        </tr>
        </thead>
        <c:forEach items="${users}" var="user">
            <jsp:useBean id="user" scope="page" type="ua.teachme.model.User"/>
            <tr>
                <td><c:out value="${user.name}"/></td>
                <td><a href="mailto:${user.email}">${user.email}</a></td>
                <td>${user.roles}</td>
                <td>${user.registeredDateAndTime} </td>
            </tr>
        </c:forEach>
    </table>
</section>
<jsp:include page="fragments/footer.jsp"/>
</body>
</html>
