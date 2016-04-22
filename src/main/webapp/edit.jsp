<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2><a href="index.jsp">Home</a></h2>

<jsp:useBean id="notation" scope="request" type="ua.teachme.model.Notation"/>
<form method="post" action="notations">

    <%--
    <dl>
        <dt>id</dt>
        <dd><input type="TEXT" value="${notation.id}" name="id"></dd>
    </dl>
    --%>

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
        <dd><input type="datetime-local" value="${notation.dateTime}" name="dateTime"></dd>
    </dl>

    <button type="submit">save</button>
    <button onclick="window.history.back()">cancel</button>
</form>
</body>
</html>
