<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="text/html; charset=UTF-8 width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">

    <style>
        <%@include file="../../../resources/css/style.css"%>
    </style>

</head>
<body>

<c:set var="lang" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.lang ? 'en' : sessionScope.lang}"/>
<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>

<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">

    <h5 class="my-0 mr-md-auto font-weight-normal" >front.tax</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="/client" >front.main</a>
        <a class="p-2 text-dark" href="/client/reports?command" > front.report</a>
        <a class="p-2 text-dark" href="/client/report/add" >report.newReport</a>
    </nav>
    <a class="btn btn-outline-primary" href="/logout"><span>front.signOut</span></a>

</div>
</body>
</html>