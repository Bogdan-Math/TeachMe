<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setBundle basename="strings.app"/>

<html>
<head>
    <title><fmt:message key="app.title"/></title>
</head>
<body>
<h2>
    <fmt:message key="app.title"/>
    <a href="https://github.com/Bogdan-Math/TeachMe" target="_blank">on github</a>
</h2>

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

<a href="notations">notations</a>

</body>
</html>