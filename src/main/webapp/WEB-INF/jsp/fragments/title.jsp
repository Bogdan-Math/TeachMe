<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<head>
    <title>
        <fmt:message key="app.title"/>
    </title>
    <c:set var="url">${pageContext.request.requestURL}</c:set>
    <base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/" />

    <link href="<c:url value="resources/css/main.css" />" rel="stylesheet" >
    <link href="<c:url value="resources/images/icon.png" />" rel="icon"/>
    <link href="<c:url value="webjars/bootstrap/3.3.6/css/bootstrap.min.css" />" rel="stylesheet"/>

</head>