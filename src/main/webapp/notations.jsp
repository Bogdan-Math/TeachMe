<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
    <title>Notations</title>
    <style>
        .exceed {
            color: red;
        }

        .normal {
            color: green;
        }
    </style>
</head>
<body>
<h2><a href="index.html">Home</a></h2>

<table border="1">

    <thead>
    <tr>
        <th>name</th>
        <th>url</th>
        <th>description</th>
        <th>hours</th>
        <th>time</th>
    </tr>
    </thead>

    <c:forEach items="${notations}" var="notation">
        <jsp:useBean id="notation" scope="page" type="ua.teachme.model.NotationExceed"/>
        <tr class="${notation.exceed ? 'exceed' : 'normal'}">
            <td>${notation.name}</td>
            <td>${notation.url}</td>
            <td>${notation.description}</td>
            <td>${notation.hours}</td>
            <td>${notation.date} : ${notation.time}</td>
        </tr>

    </c:forEach>
</table>

</body>
</html>
