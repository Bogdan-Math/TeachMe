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

        <dt>end time</dt>
        <dd>
            <label>
                <input type="time" value="${endTime}" name="endTime">
            </label>
        </dd>

    </dl>

    <button type="submit"><fmt:message key="button.filter"/></button>
    <%--
        <button type="reset">reset</button>
    --%>
</form>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">

            <table class="table table-view">

                <a href="notations/create"><fmt:message key="button.create"/></a>
                <thead>
                <tr>
                    <th><fmt:message key="table.notation.name"/></th>
                    <th><fmt:message key="table.notation.url"/></th>
                    <th><fmt:message key="table.notation.description"/></th>
                    <th><fmt:message key="table.notation.hours"/></th>
                    <th><fmt:message key="table.notation.created"/></th>
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
                        <td><a href="notations/update?id=${notation.id}"><fmt:message key="button.update"/></a></td>
                        <td><a href="notations/delete?id=${notation.id}"><fmt:message key="button.delete"/></a></td>
                    </tr>

                </c:forEach>
            </table>

        </div>
    </div>
</div>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
