<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <jsp:include page="fragments/title.jsp"/>
</head>

<body>

<header>
    <jsp:include page="fragments/registration-header.jsp"/>
</header>

<div class="row">

    <div class="col-md-4"></div>

    <div class="col-md-4">
        <form class="form" role="form" method="post" action="registration" accept-charset="UTF-8" id="login-nav">
            <div class="form-group">
<%--
                <label class="sr-only" for="name"><fmt:message key="table.users.name"/></label>
--%>
                <input type="text"
                       class="form-control"
                       id="name"
                       name="name"
                       placeholder="<fmt:message key="table.users.name"/>"
                       required
                >
            </div>
            <div class="form-group">
<%--
                <label class="sr-only" for="email">Email address</label>
--%>
                <input
                        type="email"
                        class="form-control"
                        id="email"
                        name="email"
                        placeholder="<fmt:message key="table.users.email"/>"
                        required
                >
                <c:if test="${duplicateEmailError}">
                    <div class="reg-error">
                            ${email}
                            <fmt:message key="app.error.duplicate.email"/>
                    </div>
                </c:if>
            </div>
            <div class="form-group">
<%--
                <label class="sr-only" for="password">Password</label>
--%>
                <input
                        type="password"
                        class="form-control"
                        id="password"
                        name="password"
                        placeholder="<fmt:message key="table.users.password"/>"
                        pattern="[A-Za-z/_/./0-9]{6,25}"
                        title="Can be: 'A-Z', 'a-z', '0-9', '_', '.' from 6 to 25 count of symbols"
                        required
                >
            </div>
            <div class="form-group">
                <button type="submit" class="btn btn-primary btn-block"><fmt:message key="app.sign_in"/></button>
            </div>
        </form>
    </div>

    <div class="col-md-4"></div>

</div>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
