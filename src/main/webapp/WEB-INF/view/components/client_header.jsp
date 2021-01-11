<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<style>
    <%@include file="../../../resources/css/style.css"%>
</style>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<c:set var="lang" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.lang ? 'en' : sessionScope.lang}"/>
<fmt:setBundle basename="/i18n/messages" var="bundle" scope="session"/>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">

    <h5 class="my-0 mr-md-auto font-weight-normal" >
        <fmt:message key="front.tax" bundle="${bundle}"/></h5>

    <nav class="my-2 my-md-0 mr-md-3">
        <a href="/?command=LANGUAGE_CHANGE&lang=ua" class="btn btn-primary btn-sm">UK</a>
        <a href="/?command=LANGUAGE_CHANGE&lang=en" class="btn btn-warning btn-sm">EN</a>

        <a class="p-2 text-dark" href="/cabinet?command=client_cabinet">
           <fmt:message key="front.main" bundle="${bundle}"/></a>

        <a class="p-2 text-dark" href="/cabinet?command=client_report_list">
            <fmt:message key="front.report" bundle="${bundle}"/></a>

        <a class="p-2 text-dark" href="/cabinet?command=report_page">
            <fmt:message key="report.newReport" bundle="${bundle}"/></a>
    </nav>
    <a class="btn btn-outline-primary" href="/logout?command=logout"><span>
        <fmt:message key="front.signOut" bundle="${bundle}"/></span></a>

</div>
<c:set var="langf" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.langf ? 'en' : sessionScope.langf}"/>
<fmt:setBundle basename="/i18n/messages" var="bundle" scope="session"/>
</body>
</html>