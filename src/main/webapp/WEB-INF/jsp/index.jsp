<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<jsp:include page="fragments/title.jsp"/>

<body>

<header>
    <jsp:include page="fragments/header.jsp"/>
</header>

<div class="jumbotron">
    <div class="container">

        <form method="post" action="users/id">
            <label>
                <select name="userID">
                    <option value="1000001"><fmt:message key="user.anonymous"/></option>
                    <option value="1000002"><fmt:message key="user.common_user"/></option>
                    <option value="1000003"><fmt:message key="user.admin"/></option>
                </select>
            </label>
            <button type="submit"><fmt:message key="button.select"/></button>
        </form>

        <form method="post" action="users/email">
            <label>
                <select name="userEmail">
                    <option value="anonymous@gmail.com">anonymous@gmail.com</option>
                    <option value="user@gmail.com">user@gmail.com</option>
                    <option value="admin@gmail.com">admin@gmail.com</option>
                </select>
            </label>
            <button type="submit"><fmt:message key="button.select"/></button>
        </form>

    </div>
</div>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>