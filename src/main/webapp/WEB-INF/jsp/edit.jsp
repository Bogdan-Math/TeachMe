<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <jsp:include page="fragments/title.jsp"/>

<body>
    <header>
        <jsp:include page="fragments/header.jsp"/>
    </header>


<jsp:useBean id="notation" scope="request" type="ua.teachme.model.Notation"/>
<form method="post" action="notations">

    <dl>
        <dt>id</dt>
        <dd><input type="text" value="${notation.id}" name="id"></dd>
    </dl>

    <dl>
        <dt>name</dt>
        <dd><input type="text" value="${notation.name}" name="name"></dd>
    </dl>

    <dl>
        <dt>url</dt>
        <dd><input type="text" value="${notation.url}" name="url"></dd>
    </dl>

    <dl>
        <dt>description</dt>
        <dd><input type="text" value="${notation.description}" name="description"></dd>
    </dl>

    <dl>
        <dt>hours</dt>
        <dd><input type="number" value="${notation.hours}" name="hours"></dd>
    </dl>

    <dl>
        <dt>date and time:</dt>
        <dd><input type="datetime-local" value="${notation.createdDateAndTime}" name="createdDateAndTime"></dd>
    </dl>

    <button type="submit">save</button>
    <button onclick="window.history.back()">cancel</button>
</form>

    <footer>
        <jsp:include page="fragments/footer.jsp"/>
    </footer>
</body>
</html>
