<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<title><fmt:message key="app.title"/></title>

<%--
<meta name="_csrf" content="${_csrf.token}"/>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
--%>

<c:set var="url">${pageContext.request.requestURL}</c:set>
<base href="${fn:substring(url, 0, fn:length(url) - fn:length(pageContext.request.requestURI))}${pageContext.request.contextPath}/"/>

<script type="text/javascript" src="webjars/jquery/2.2.3/jquery.min.js"></script>

<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet"/>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js" type="text/javascript"></script>

<link href="<c:url value="resources/images/icon.png" />" rel="icon"/>
<link href="<c:url value="resources/css/basic-style.css" />" rel="stylesheet"/>
<link href="<c:url value="resources/css/registration.css" />" rel="stylesheet"/>
<link href="<c:url value="resources/css/main-goal.css" />" rel="stylesheet"/>
<link href="<c:url value="resources/css/validation.css" />" rel="stylesheet"/>
<link href="<c:url value="resources/css/filtering.css" />" rel="stylesheet"/>
<link href="<c:url value="resources/css/updating.css" />" rel="stylesheet"/>
