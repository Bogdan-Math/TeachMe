<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>

<head>
    <jsp:include page="fragments/title.jsp"/>

    <link rel="stylesheet" href="webjars/datatables/1.10.11/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>

    <script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>

</head>

<body>

<header>
    <jsp:include page="fragments/login-header.jsp"/>
</header>

<%--todo: add some body code--%>
<div class="jumbotron">
    <div class="container">

        <div class="in-center">
            <%--todo: add correct jsp:useBean--%>

            <c:if test="${message}">
                <div class="reg-success">
                    <fmt:message key="app.registration.success"/>
                </div>
            </c:if>

            <c:if test="${loginError}">
                <div class="login-error">
                        ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
                </div>
            </c:if>

        </div>

    </div>
</div>

<div class="jumbotron">
    <div class="container">

        <div class="in-right">

            <a class="btn btn-lg registration-btn" role="button" href="registration"><fmt:message key="app.register"/></a>

            <br>
            <br>
            Testing ROOT's users:<br>
            <br>

            <div>
                admin:<br>
                email = '<b>admin@gmail.com</b>'<br>
                password = '<b>password</b>'<br>
                <br>
            </div>

            <div>
                user:<br>
                email = '<b>user@gmail.com</b>'<br>
                password = '<b>password</b>'<br>
                <br>
            </div>

        </div>

    </div>
</div>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>

</html>
