<%@include file="components/client_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title> <fmt:message key="front.tax" bundle="${bundle}"/> </title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div th:insert="blocks/header-client :: header"></div>


<div class="container mt-5 mb-5">
    <h1> <fmt:message key="front.newReport" bundle="${bundle}"/> </h1><br><br>

    <form action="/" method="post">

        <h3> <fmt:message key="report.topic" bundle="${bundle}"/> </h3>
        <input type="text" name="nameOfReport" placeholder="Write the topic of the report" class="form-control"><br>

        <h3> <fmt:message key="report.create" bundle="${bundle}"/> </h3>
        <textarea name="report" placeholder="Write your report here" class="form-control" rows="5" cols="33"></textarea><br>

        <input name="command" value="create_report" type="hidden"/>

        <button type="submit" class="btn btn-success"><span>
            <fmt:message key="report.submit" bundle="${bundle}"/>
        </span></button>

    </form>
</div>
</body>
</html>