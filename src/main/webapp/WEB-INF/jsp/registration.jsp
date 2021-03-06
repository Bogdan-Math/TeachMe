<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>

<head>
    <jsp:include page="fragments/title.jsp"/>
</head>

<body>
<%--todo: add validation by js and ajax (json)--%>
<script type="text/javascript" src="webjars/noty/2.3.8/js/noty/packaged/jquery.noty.packaged.min.js"></script>
<script>

    $(document).ready(function () {

        $('#sign-in').on('click', function () {
            var form = $('#registration');
            $.ajax({
                type: 'POST',
                url: 'rest/registration',
                data: form.serialize(),
                success: function () {
                    noty({
                        text: '!!!',
                        type: 'success',
                        theme: 'defaultTheme'
                    });
                },
                error: function(jqXHR, textStatus, errorThrown){
                    //alert(jqXHR.responseText);
                    noty({
                        text: '!!!',
                        type: 'error',
                        theme: 'defaultTheme'
                    });
                }
            });
        });

    });

</script>

<header>
    <jsp:include page="fragments/registration-header.jsp"/>
</header>

<div class="row">

    <div class="col-md-4"></div>

    <div class="col-md-4">
        <form:form cssClass="form" method="post" action="registration" id="registration" accept-charset="UTF-8">

            <div class="form-group">
                <input type="text"
                       class="form-control validation"
                       id="name"
                       name="name"
                       placeholder="<fmt:message key="table.users.name"/>"
                       required
                       autofocus
                >
            </div>

            <div class="form-group">
                <input
                        type="email"
                        class="form-control validation"
                        id="email"
                        name="email"
                        placeholder="<fmt:message key="table.users.email"/>"
                        required
                >
                <c:if test="${duplicateEmailError}">
                    <div class="reg-error">
                            ${email}
                        <fmt:message key="app.error.duplicate.email"/>
                    </div>
                </c:if>
            </div>

            <div class="form-group">
                <input
                        type="password"
                        class="form-control validation"
                        id="password"
                        name="password"
                        placeholder="<fmt:message key="table.users.password"/>"
                        pattern="[A-Za-z/_/./0-9]{6,25}"
                        title="<fmt:message key="user.password.hint"/>"
                        required
                >
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-block registration-btn"><fmt:message key="app.sign_in"/></button>
                <button type="button" class="btn btn-block btn-default" id="sign-in"><fmt:message
                        key="app.sign_in"/></button>

            </div>

        </form:form>
    </div>

    <div class="col-md-4"></div>

</div>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
