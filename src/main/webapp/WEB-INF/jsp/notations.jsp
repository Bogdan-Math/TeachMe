<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <jsp:include page="fragments/title.jsp"/>

<body>
    <header>
        <jsp:include page="fragments/header.jsp"/>
    </header>

<form method="post" action="notations/filter">

    <dl>
        <dt>start date</dt>
        <dd>
            <label>
            <input type="date" value="${startDate}" name="startDate">
            </label>
        </dd>
    </dl>

    <dl>
        <dt>start time</dt>
        <dd>
            <label>
            <input type="time" value="${startTime}" name="startTime">
            </label>
        </dd>

    </dl>

    <dl>
        <dt>end date</dt>
        <dd>
            <label>
            <input type="date" value="${endDate}" name="endDate">
            </label>
        </dd>
    </dl>

    <dl>
        <dt>end time</dt>
        <dd>
            <label>
            <input type="time" value="${endTime}" name="endTime">
            </label>
        </dd>
    </dl>

    <button type="submit">filter</button>
<%--
    <button type="reset">reset</button>
--%>
</form>

<table border="1">
<a href="notations/add">add notation</a>
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

        <jsp:useBean id="notation" scope="page" type="ua.teachme.dto.NotationExceed"/>
        <tr class="${notation.exceed ? 'exceed' : 'normal'}">
            <%--
            <td>${notation.id}</td>
            --%>
            <td>${notation.name}</td>
            <td>${notation.url}</td>
            <td>${notation.description}</td>
            <td>${notation.hours}</td>
            <td>${notation.date} : ${notation.time}</td>
            <td><a href="notations/update?id=${notation.id}">update</a></td>
            <td><a href="notations/delete?id=${notation.id}">delete</a></td>
        </tr>

    </c:forEach>
</table>

    <footer>
        <jsp:include page="fragments/footer.jsp"/>
    </footer>
</body>
</html>
