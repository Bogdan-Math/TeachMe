<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="navbar-right navbar-text">
    <div class="navbar-nav">
        <li class="dropdown">
            <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                <fmt:message key="Language"/>
                <b class="caret"></b>
            </a>
            <ul class="dropdown-menu">
                <li><a onclick="show('en')">English</a></li>
                <li><a onclick="show('uk')">Українська</a></li>
            </ul>
        </li>
    </div>
</div>

<script type="text/javascript" src="<c:url value="/resources/js/SelectLanguage.js"/>"></script>