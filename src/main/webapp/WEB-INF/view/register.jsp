<%--<%@include file="components/_header.jsp"%>--%>
<!doctype html>
<%--<%@page contentType="text/html" pageEncoding="UTF-8" %>--%>
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
    <title>
        Tax
    </title>
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

<div class="container form-register wrapper" >
    <form action="/" method="post">

        <div class="container">
            <form class="form-signing">
                <img class="mb-4" src="https://tax.gov.ua/images/logo_sfs_og.jpg" alt="" width="102" height="102">

                <h1 class="h3 mb-3 font-weight-normal">
                    <fmt:message key="front.registration" bundle="${bundle}"/>
                </h1><br>
                <div class="row justify-content-center">
                    <div class="col-4">
                    <span class="d-inline-block text-truncate">
                        <fmt:message key="payer.lastName" bundle="${bundle}"/>
                    </span>
                        <label>
                            <input type="text" name="lastName" class="form-control">
                        </label><br>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-4">
                    <span class="d-inline-block text-truncate">
                        <fmt:message key="payer.firstName" bundle="${bundle}"/>
                    </span>
                        <label>
                            <input type="text" name="firstName" class="form-control">
                        </label><br>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-4">
                    <span class="d-inline-block text-truncate">
                        <fmt:message key="payer.middleName" bundle="${bundle}"/>
                    </span>
                        <s:form action="middleName" method="post">
                        <label>
                            <input type="text" name="middleName" class="form-control">
                        </label><br>
                        </s:form>
                    </div>
                </div>


                <div class="row justify-content-center">
                    <div class="col-4">
                    <span class="d-inline-block text-truncate">
                        <fmt:message key="payer.email" bundle="${bundle}"/>
                    </span>
                        <div class="form-group">
                            <label>
                                <input type="text" class="form-control" name="email">
                            </label>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-4">
                    <span class="d-inline-block text-truncate">
                        <fmt:message key="front.password" bundle="${bundle}"/>
                    </span>
                        <div>
                            <label>
                                <input type="password" class="form-control" name="password" size="135">
                            </label>
                        </div>
                    </div>
                </div>

                <div class="row justify-content-center">
                    <div class="col-2">
                        <input name="command" value="registration" type="hidden">
                        <button class="btn btn-lg btn-primary btn-block" type="submit">
                            <fmt:message key="front.confirm" bundle="${bundle}"/>
<%--                            Approve--%>
                        </button>
                    </div>
                </div>
                <p class="mt-5 mb-3 text-muted">© 2019-2020</p>
            </form>
        </div>
    </form>
</div>
</body>
</html>