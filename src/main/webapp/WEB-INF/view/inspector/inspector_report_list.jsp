<%@page pageEncoding="UTF-8" %>
<%@include file="../components/inspector_header.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Reports</title>
</head>

<div class="container mt-5">
        <h1><fmt:message key="front.listOfReports" bundle="${bundle}"/> </h1> <br>

    <c:forEach var="report" items="${reports}">
        <div class="alert alert-info mt-2">
            <table>
                <p><b>Name:</b> <span>${report.nameOfReport}</span></p>

                <p><b>Date:</b> <span>${report.createdDate}</span></p>

<%--                <div>--%>
<%--                    <div th:if="${report.status.name == 'ACCEPT'}">--%>
<%--                        <p align="right" style="color:Green"><b>Accept</b></p>--%>
<%--                    </div>--%>
<%--                    <div th:if="${el.status.name == 'VERIFY'}">--%>
<%--                        <p align="right" style="color:Orange"><b th:text="#{client.verify}"></b></p>--%>
<%--                    </div>--%>
<%--                    <div th:if="${el.status.name == 'REFUSE'}">--%>
<%--                        <p align="right" style="color:Red"><b th:text="#{client.refuse}"></b></p>--%>
<%--                    </div>--%>
<%--                </div>--%>

                <a class="btn btn-warning" href="/cabinet?command=inspector_report_view&reportId=${report.id}"> <span>View</span></a>

        </table>
        </div>
    </c:forEach>
</div>

