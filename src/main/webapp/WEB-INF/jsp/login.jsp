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

        <%--todo: add correct jsp:useBean--%>
        <c:if test="${loginError}">
            <%--todo: add noty error--%>
            <div class="error">
                ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
            </div>
        </c:if>

    </div>
</div>

<div class="jumbotron">
    <div class="container">

        <div class="in-right">

            <br>
            Testing ROOT's users:<br>
                    <br>
                        email = 1<br>
                     password = 1<br>
                    <br>
                        email = 2<br>
                     password = 2<br>
                    <br>
                        email = 3<br>
                     password = 3<br>
                    <br>

        </div>

    </div>
</div>

</body>

</html>
