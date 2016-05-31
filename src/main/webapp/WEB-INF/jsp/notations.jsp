<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>

    <jsp:include page="fragments/title.jsp"/>

    <link rel="stylesheet" href="webjars/datatables/1.10.11/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>

    <script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>

    <%--todo: add update table by ajax (json)--%>
    <script type="text/javascript">

        var dataTableApi;

        $(document).ready(function () {
            dataTableApi = $('#dataTable').dataTable();
        });

    </script>

</head>

<body>

<header>
    <jsp:include page="fragments/common-header.jsp"/>
</header>

<form method="post" action="notations/filter">

    <dl>
        <dt>start date:</dt>
        <dd>
            <label>
                <input type="date" value="${startDate}" name="startDate">
            </label>
        </dd>

        <dt>start time:</dt>
        <dd>
            <label>
                <input type="time" value="${startTime}" name="startTime">
            </label>
        </dd>

    </dl>

    <dl>
        <dt>end date:</dt>
        <dd>
            <label>
                <input type="date" value="${endDate}" name="endDate">
            </label>
        </dd>

        <dt>end time:</dt>
        <dd>
            <label>
                <input type="time" value="${endTime}" name="endTime">
            </label>
        </dd>

    </dl>

    <%--todo: add correct filter
        <button type="submit"><fmt:message key="button.filter"/></button>
        <button type="reset">reset</button>
    --%>
</form>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">

            <table class="table table-view" id="dataTable">

                <a href="notations/create"><fmt:message key="button.create"/></a>
                <thead>
                <tr>
                    <th><fmt:message key="table.notations.name"/></th>
                    <th><fmt:message key="table.notations.url"/></th>
                    <th><fmt:message key="table.notations.description"/></th>
                    <th><fmt:message key="table.notations.hours"/></th>
                    <th><fmt:message key="table.notations.created"/></th>
                    <th></th>
                    <th></th>
                </tr>
                </thead>

                <c:forEach items="${notations}" var="notation">

                    <jsp:useBean id="notation" scope="page" type="ua.teachme.dto.NotationTO"/>
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
