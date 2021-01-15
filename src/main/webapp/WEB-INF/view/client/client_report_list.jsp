<%@page pageEncoding="UTF-8" %>
<%@include file="../components/client_header.jsp" %>


<div>
        <div class="container mt-5">
            <h1><fmt:message key="front.listOfReports" bundle="${bundle}"/> </h1> <br>

            <c:forEach var="report" items="${reports}">
            <div class="alert alert-info mt-2">

                <table>
                    <p><b>Name:</b> <span>${report.nameOfReport}</span></p>

                    <p><b>Date:</b> <span>${report.createdDate}</span></p>


                <div>
                    <c:if test="${report.status.id == 1}">
                        <p align="right" style="color:Green"><b>Accept</b></p>
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

                    <a class="btn btn-warning" href="/cabinet?command=client_report_view&reportId=${report.id}"> <span>View</span></a>

                </table>
            </div>
            </c:forEach>
        </div>
</div>

