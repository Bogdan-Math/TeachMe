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

    <div class="jumbotron">
        <div class="container">
            <div class="shadow">

                    <a class="btn btn-default" id="create"><fmt:message key="table.users.create"/></a>

                    <table class="table table-striped">

                        <thead>
                        <tr>
                            <th><fmt:message key="table.users.name"/></th>
                            <th><fmt:message key="table.users.email"/></th>
                            <th><fmt:message key="table.users.roles"/></th>
                            <th><fmt:message key="table.users.reg"/></th>
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

            </div>
        </div>
    </div>

</section>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
