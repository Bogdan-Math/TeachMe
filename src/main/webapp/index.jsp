<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <jsp:include page="fragments/title.jsp"/>

<body>
    <header>
        <jsp:include page="fragments/header.jsp"/>
    </header>

<form method="post" action="user">
    <label>
        <select name="userID">
            <option value="1000001">anonymous</option>
            <option value="1000002">common user</option>
            <option value="1000003">admin</option>
        </select>
    </label>
    <button type="submit">select</button>
</form>

    <footer>
        <jsp:include page="fragments/footer.jsp"/>
    </footer>
</body>
</html>