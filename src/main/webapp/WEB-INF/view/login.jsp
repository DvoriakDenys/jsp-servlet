<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        <%@include file="../../resources/css/style.css"%>
    </style>
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
    </nav>

</div>

<div class="container-fluid">
    <div class="row justify-content-center">
        <div class="col-3">
            <div class="form-login">
                <form action="/" method="post">
                    <h4><fmt:message key="welcome" bundle="${bundle}"/></h4>
                    <input type="text" name="email" class="form-control input-sm chat-input"
                           placeholder="<fmt:message key="front.password" bundle="${bundle}"/>"/>
                    </br>
                    <input type="password" name="password" class="form-control input-sm chat-input"
                           placeholder="<fmt:message key="front.password" bundle="${bundle}"/>"/>
                    </br>
                    <div class="wrapper">
                        <input name="command" value="login" type="hidden">
                        <span class="group-btn">
                             <button type="submit" class="btn btn-success">
                                 <fmt:message key="front.signIn" bundle="${bundle}"/></button>
                        </span>
                    </div>
                </form>
            </div>
            <c:if test="${error == 'true'}">
                <h5 style="color: red; text-align: center"><fmt:message key="welcome" bundle="${bundle}"/></h5>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>