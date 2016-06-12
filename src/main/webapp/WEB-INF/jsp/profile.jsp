<%--suppress HtmlFormInputWithoutLabel --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <jsp:include page="fragments/title.jsp"/>
</head>

<body>

<header>
    <jsp:include page="fragments/common-header.jsp"/>
</header>

<jsp:useBean id="selectedUser" scope="request" type="ua.teachme.model.User"/>
<form:form cssClass="form-horizontal" action="profile" method="post">

    <%--
        <input type="text" value="${selectedUser.mainGoal} : ${selectedUser.mainGoal.description}" name="mainGoal">
    --%>

    <div class="row">

        <div class="col-md-4"></div>

        <div class="col-md-4">

            <input type="hidden" value="${selectedUser.id}" name="id">

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label"><fmt:message key="user.name"/></label>
                </div>
                <div class="col-sm-9">
                    <input type="text"
                           class="form-control"
                           value="${selectedUser.name}"
                           name="name"
                           required
                    >
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label"><fmt:message key="user.email"/></label>
                </div>
                <div class="col-sm-9">
                    <input type="email"
                           class="form-control"
                           value="${selectedUser.email}"
                           name="email"
                           required
                    >
                </div>
            </div>


            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label"><fmt:message key="user.password"/></label>
                </div>
                <div class="col-sm-9">
                    <button type="button"
                            class="btn btn-inverse btn-block"
                            data-toggle="modal"
                            data-target="#changePassword"
                    >
                        <fmt:message key="user.change_password"/>
                    </button>
                </div>
            </div>

                <%--
                            <input type="text" class="reg-error" value="Will be possible to change in future. Work around it!!!" name="password" readonly>
                --%>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label"><fmt:message key="user.hours"/></label>
                </div>
                <div class="col-sm-9">
                    <input type="number"
                           class="form-control"
                           value="${selectedUser.maxHoursPerDay}"
                           name="hours"
                           required
                    >
                </div>
            </div>

                <%--
                            <input type="hidden" value="${selectedUser.registeredDate}" name="registeredDate">
                --%>

            <div class="form-group">
                <div class="col-sm-3">
                    <label class="control-label"><fmt:message key="user.roles"/></label>
                </div>
                <div class="col-sm-9">
                    <input type="text"
                           class="form-control"
                           value="${selectedUser.roles}"
                           name="roles"
                           readonly
                    >
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-3"></div>
                <button type="submit" class="btn btn-primary col-sm-4" id="save"><fmt:message
                        key="button.save"/></button>
                <div class="col-sm-1"></div>
                <button type="button" class="btn btn-default col-sm-4" onclick="window.history.back()"><fmt:message
                        key="button.close"/></button>
            </div>

        </div>

        <div class="col-md-4"></div>

    </div>

</form:form>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

<div class="modal fade" id="changePassword">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">

            </div>

            <div class="modal-body">
                <form:form cssClass="form-horizontal" method="post" action="profile/password">

                    <div class="form-group">
                        <div class="col-sm-6">
                            <label class="control-label"><fmt:message key="user.old_password"/></label>
                        </div>
                        <div class="col-sm-6">
                            <input type="password"
                                   class="form-control"
                                   value="${selectedUser.roles}"
                                   name="oldPassword"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-6">
                            <label class="control-label"><fmt:message key="user.new_password"/></label>
                        </div>
                        <div class="col-sm-6">
                            <input type="password"
                                   class="form-control"
                                   value="${selectedUser.roles}"
                                   name="newPassword"
                            >
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-6">
                            <label class="control-label"><fmt:message key="user.new_password_repeat"/></label>
                        </div>
                        <div class="col-sm-6">
                            <input type="password"
                                   class="form-control"
                                   value="${selectedUser.roles}"
                                   name="newPasswordRepeat"
                            >
                        </div>
                    </div>

                    <button type="submit"><fmt:message key="user.password.confirm"/></button>
                </form:form>
            </div>

            <div class="modal-footer">

            </div>

        </div>
    </div>
</div>

</body>
</html>
