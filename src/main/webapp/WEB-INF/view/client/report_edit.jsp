<%@include file="../components/client_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="ctg" uri="customtags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div class="container mt-5 mb-5">
        <div class="alert alert-info mt-2">

            <h2 > <fmt:message key="report.editReport" bundle="${bundle}"/> </h2> <br>

            <form action="/" method="post" >

                <h4><fmt:message key="front.topic" bundle="${bundle}"/></h4>

                <input type="text" name="name_of_report" placeholder="Write the topic of the report" class="form-control"><br>

                <h4><fmt:message key="front.report" bundle="${bundle}"/></h4>

                <textarea name="report" placeholder="Write your report here" class="form-control" rows="5" cols="33">
                    ${report.comment}
                </textarea><br>

                <input name="command" value="update_client_report" type="hidden"/>
                <input name="reportId" value="${report.id}" type="hidden"/>

                    <button type="submit" class="btn btn-success">
                        <fmt:message key="report.editReport" bundle="${bundle}"/>
                    </button>

            </form>

        </div>
    </div>
</body>
</html>
