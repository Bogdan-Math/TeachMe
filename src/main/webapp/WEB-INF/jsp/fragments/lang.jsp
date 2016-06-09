<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<div class="navbar-nav">
    <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">
            <%--${pageContext.response.locale}--%>
            <fmt:message key="Language"/>
            <b class="caret"></b>
        </a>
        <ul class="dropdown-menu">
            <li><a onclick="show('en')">English</a></li>
            <li><a onclick="show('uk')">Українська</a></li>
        </ul>
    </li>
</div>
<script type="text/javascript">
    function show(lang) {
        window.location.href = window.location.href.split('?')[0] + '?lang=' + lang;
    }
</script>