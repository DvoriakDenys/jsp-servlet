<%@page pageEncoding="UTF-8" %>
<%@include file="../components/inspector_header.jsp" %>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <title>Reports</title>
</head>

<div class="container mt-5">
        <h1><fmt:message key="front.listOfReports" bundle="${bundle}"/> </h1> <br>

    <a class="btn btn-warning"
       href="/cabinet?command=sort_and_pagination_report&sorting=report">
        <b>Sort by report</b></a>

    <a class="btn btn-warning"
       href="/cabinet?command=sort_and_pagination_report&sorting=created_date">
        <b>Sort by created_date</b></a>

    <c:forEach var="report" items="${reports}">
        <div class="alert alert-info mt-2">
            <table>
                <p><b>Name:</b> <span>${report.nameOfReport}</span></p>

                <p><b>Date:</b> <span>${report.createdDate}</span></p>

                <div>
                    <c:if test="${report.status.id == 1}">
                        <p align="right" style="color:Green">
                        <b><fmt:message key="client.accept" bundle="${bundle}"/></b></p>
                    </c:if>
                    <c:if test="${report.status.id == 2}">
                        <p align="right" style="color:Orange">
                            <b><fmt:message key="client.verify" bundle="${bundle}"/></b></p>
                    </c:if>
                    <c:if test="${report.status.id == 3}">
                        <p align="right" style="color:Red">
                            <b><fmt:message key="client.refuse" bundle="${bundle}"/></b></p>
                    </c:if>
                </div>

                <a class="btn btn-warning" href="/cabinet?command=inspector_report_view&reportId=${report.id}"> <span>View</span></a>

        </table>
        </div>
    </c:forEach>

    <c:choose>
        <c:when test="${currentPage < quantityPage}">
            <a class="btn btn-warning"
               href="/cabinet?command=sort_and_pagination_report&currentPage=${currentPage + 1}">
                <b><fmt:message key="front.nextPage" bundle="${bundle}"/></b></a>
        </c:when>
        <c:otherwise>
            <b><fmt:message key="front.nextPage" bundle="${bundle}"/></b>
        </c:otherwise>
    </c:choose>

    <c:choose>
        <c:when test="${currentPage > 1 && currentPage <= quantityPage }">
            <a class="btn btn-warning"
               href="/cabinet?command=sort_and_pagination_report&currentPage=${currentPage - 1}">
                <b><fmt:message key="front.lastPage" bundle="${bundle}"/></b></a>
        </c:when>
        <c:otherwise>
            <b><fmt:message key="front.lastPage" bundle="${bundle}"/></b></a>
        </c:otherwise>
    </c:choose>

</div>

