<%--suppress HtmlFormInputWithoutLabel --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<jsp:include page="fragments/title.jsp"/>

<body>

<header>
    <jsp:include page="fragments/common-header.jsp"/>
</header>


<jsp:useBean id="notation" scope="request" type="ua.teachme.model.Notation"/>
<form:form cssClass="form-horizontal" action="notations" method="post">

<div class="row">

    <div class="col-md-4"></div>

    <div class="col-md-4">
        <input type="hidden" value="${notation.id}" name="id">

        <div class="form-group">
            <div class="col-sm-3">
                <label class="control-label"><fmt:message key="notation.name"/></label>
            </div>
            <div class="col-sm-9">
                <input type="text"
                       class="form-control validation"
                       value="${notation.name}"
                       name="name"
                       required
                >
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-3">
                <label class="control-label"><fmt:message key="notation.url"/></label>
            </div>
            <div class="col-sm-9">
                <input type="text"
                       class="form-control validation"
                       value="${notation.url}"
                       name="url"
                       required
                >
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-3">
                <label class="control-label"><fmt:message key="notation.description"/></label>
            </div>
            <div class="col-sm-9">
                <input type="text"
                       class="form-control validation"
                       value="${notation.description}"
                       name="description"
                       required
                >
            </div>
        </div>

        <div class="form-group">
            <div class="col-sm-3">
                <label class="control-label"><fmt:message key="notation.hours"/></label>
            </div>
            <div class="col-sm-9">
                <input type="text"
                       class="form-control validation"
                       value="${notation.hours}"
                       name="hours"
                       required
                >
            </div>
        </div>

        <input type="hidden" <%--type="datetime-local"--%> value="${notation.createdDateAndTime}" name="createdDateAndTime">

        <button type="submit" class="btn btn-primary" ><fmt:message key="button.save"/></button>
        <button type="button" class="btn btn-default" onclick="window.history.back()"><fmt:message key="button.close"/></button>

    </div>

    <div class="col-md-4"></div>

</div>

</form:form>

<footer>
    <jsp:include page="fragments/footer.jsp"/>
</footer>

</body>
</html>
