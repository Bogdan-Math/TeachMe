<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>

    <jsp:include page="fragments/title.jsp"/>

    <link rel="stylesheet" href="webjars/datatables/1.10.11/css/jquery.dataTables.min.css">
    <script type="text/javascript" src="webjars/datatables/1.10.11/js/jquery.dataTables.min.js"></script>

    <script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>

    <%--todo: add update table by ajax (json)--%>
    <script type="text/javascript" src="<c:url value="/resources/js/UsersDataTable.js"/> "></script>
    <script type="text/javascript" src="<c:url value="/resources/js/UsersNoty.js"/> "></script>

</head>

<body>

<header>
    <jsp:include page="fragments/common-header.jsp"/>
</header>

<div class="jumbotron">
    <div class="container">
        <div class="shadow">

            <div class="in-center">
                <a class="btn btn-primary" data-toggle="modal" data-target="#createUserModalWindow">
                    <fmt:message key="table.users.create"/>
                </a>
            </div>


            <table class="table table-hover" id="dataTable">

                <thead>
                <tr>
                    <th><fmt:message key="table.users.name"/></th>
                    <th><fmt:message key="table.users.email"/></th>
                    <%--
                        <th><fmt:message key="table.users.roles"/></th>
                    --%>
                    <th><fmt:message key="table.users.reg"/></th>
                    <%--
                        Don't delete this <th>. Need to correct use DataTable js
                    --%>
                    <th></th>
                    <th></th>

                </tr>
                </thead>

                <c:forEach items="${users}" var="user">
                    <jsp:useBean id="user" scope="page" type="ua.teachme.model.User"/>
                    <tr>
                        <td><c:out value="${user.name}"/></td>
                        <td><a href="mailto:${user.email}">${user.email}</a></td>
                            <%--
                                                        <td>${user.roles}</td>
                            --%>
                        <td>${user.registeredDateAndTime} </td>
                        <td><a class="btn btn-warning" href="users/update?id=${user.id}"><fmt:message
                                key="table.users.edit"/></a></td>
                        <td><a class="btn btn-danger" href="users/delete?id=${user.id}"><fmt:message
                                key="table.users.delete"/></a></td>
                    </tr>
                </c:forEach>

            </table>

        </div>
    </div>
</div>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

<div class="modal fade" id="createUserModalWindow">

    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">

                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title"><fmt:message key="table.users.create"/></h4>

            </div>

            <div class="modal-body">
                <form:form cssClass="form-horizontal" method="post" id="createUserDetails">

                    <div class="form-group">
                        <label for="name" class="control-label col-xs-3">Name</label>
                        <div class="col-xs-9">
                            <input type="text" class="form-control" id="name" name="name" placeholder="name">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="email" class="control-label col-xs-3">Email</label>
                        <div class="col-xs-9">
                            <input type="email" class="form-control" id="email" name="email" placeholder="email">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="password" class="control-label col-xs-3">Password</label>
                        <div class="col-xs-9">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="password">
                        </div>
                    </div>

                    <div class="modal-footer">
                        <div class="form-group">
                            <div class="col-xs-offset-3">
                                <button type="button" class="btn btn-primary" id="createUser"><fmt:message
                                        key="button.save"/></button>
                                <button type="button" class="btn btn-danger" data-dismiss="modal"><fmt:message
                                        key="button.cancel"/></button>
                            </div>
                        </div>
                    </div>

                </form:form>
            </div>

        </div>
    </div>
</div>

</body>
</html>