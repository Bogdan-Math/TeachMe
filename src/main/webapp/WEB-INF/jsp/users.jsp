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

            $('#createUser').on('click', function(){
               create();
            });

        });

        function notyReloadPage(layout){
            var n = noty({
                layout: layout,
                text: 'Good work!!! Please, reload page to look at changes. Reload NOW???',
                type: 'success',
                theme: 'defaultTheme',
                buttons: [
                    {
                        addClass: 'btn btn-primary',
                        text: 'ok',
                        onClick: function($noty){
                            $noty.close();
                            location.reload();
                        }
                    },
                    {
                        addClass: 'btn btn-danger',
                        text: 'cancel',
                        onClick: function($noty){
                            $noty.close();
                        }
                    }
                ]
            });
        }

        function create() {
            var form = $('#createUserDetails');
            $.ajax({
                type: 'POST',
                url: 'users/create',
                data: form.serialize(),
                success: function(html){
                    $('#createUserModalWindow').modal('hide');
                    notyReloadPage('topRight')
                },
                error: function(){
                    notyError();
                }
            });

        }

        function notyError(){
            var n = noty({
                text: 'Ooops!!! Something go wrong!!! Try again!!!',
                type: 'error',
                layout: 'bottomRight',
                timeout: 3000
            });
        }

    </script>

</head>

<body>

<header>
    <jsp:include page="fragments/header.jsp"/>
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
                        <th><fmt:message key="table.users.roles"/></th>
                        <th><fmt:message key="table.users.reg"/></th>
                        <%--
                        MOTHER_FUCKING FIX !!!
                        (Don't delete this two <th>. Need to correct use DataTable js
                        )--%>
                        <th></th>
                        <th></th>

                    </tr>
                    </thead>

                    <c:forEach items="${users}" var="user">
                        <jsp:useBean id="user" scope="page" type="ua.teachme.model.User"/>
                        <tr>
                            <td><c:out value="${user.name}"/></td>
                            <td><a href="mailto:${user.email}">${user.email}</a></td>
                            <td>${user.roles}</td>
                            <td>${user.registeredDateAndTime} </td>

                            <td><a class="btn btn-success" href="users/update?id=${user.id}"><fmt:message
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
                <form class="form-horizontal" method="post" id="createUserDetails">

<%--
                    <input type="text" hidden="hidden" id="id" name="id" value="0">
--%>

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
                            <div class="col-xs-offset-3 col-xs-9">
                                <button type="button" class="btn btn-primary" id="createUser"><fmt:message key="button.save"/></button>
                                <button type="button" class="btn btn-default" data-dismiss="modal"><fmt:message key="button.close"/></button>
                            </div>
                        </div>
                    </div>

                </form>
            </div>

        </div><!-- /.modal-content -->
    </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

</body>
</html>