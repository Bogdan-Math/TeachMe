<%--suppress HtmlFormInputWithoutLabel --%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<jsp:useBean id="loggedUser" scope="request" type="ua.teachme.model.User"/>
<div class="navbar-form navbar-right">

    <a class="btn main-goal-btn"
       type="submit"
       id="mainGoal"
       data-toggle="modal"
       data-target="#setMainGoal"
    >
        <b><fmt:message key="user.main_goal"/></b>
        <div class="in-line personal-main-goal">${loggedUser.mainGoal.name}</div>
    </a>

</div>

<div class="modal fade" id="setMainGoal">
    <div class="modal-dialog">
        <div class="modal-content">

            <div class="modal-header">
                <div class="in-center personal-main-goal">
                    <fmt:message key="user.main_goal.cheer"/>
                </div>
            </div>

            <div class="modal-body">
                <form:form cssClass="form-horizontal" method="post" action="profile/mainGoal">

                <div class="form-group">
                    <div class="col-sm-4">
                        <label class="control-label"><fmt:message key="user.main_goal.name"/></label>
                    </div>
                    <div class="col-sm-8">
                        <input type="text"
                               class="form-control validation"
                               name="name"
                               value="${loggedUser.mainGoal.name}"
                        >
                    </div>
                </div>

                <div class="form-group">
                    <div class="col-sm-4">
                        <label class="control-label"><fmt:message key="user.main_goal.description"/></label>
                    </div>
                    <div class="col-sm-8">
                        <textarea
                               class="form-control validation"
                               name="description"
                        >${loggedUser.mainGoal.description}</textarea>
                    </div>
                </div>

            </div>

            <div class="modal-footer">
                <div class="col-xs-offset-3">
                    <button type="submit" class="btn btn-primary"><fmt:message key="user.password.confirm"/></button>
                    <button type="button" class="btn btn-danger" data-dismiss="modal"><fmt:message
                            key="button.cancel"/></button>
                    </form:form>
                </div>
            </div>

        </div>
    </div>
</div>