<%@page pageEncoding="UTF-8" %>
<%@include file="components/inspector_header.jsp" %>


<div>
        <div class="container mt-5">

            <div class="alert alert-info mt-2">

                <h2 >
                    <fmt:message key="client.report" bundle="${bundle}"/>
                </h2>

                <h3 >
                    <fmt:message key="front.client" bundle="${bundle}"/>
                </h3>
                <p><b>Date:</b> <span>${report.createdDate}</span></p>

<%--                <input disabled type="text" th:value="${el.user.lastName} + ' ' + ${el.user.firstName} + ' ' + ${el.user.middleName}"--%>
<%--                       class="form-control"><br>--%>

<%--                <h3>--%>
<%--                    <fmt:message key="client.email" bundle="${bundle}"/>--%>
<%--                </h3>--%>
<%--                <input disabled name="email" th:value="${el.user.email}" class="form-control"><br>--%>

<%--                <h4>--%>
<%--                    <fmt:message key="front.report" bundle="${bundle}"/>--%>
<%--                </h4>--%>
<%--                <textarea disabled name="report" th:text="${el.report}" class="form-control" rows="5" cols="33">--%>
<%--            </textarea><br>--%>

<%--                <p>--%>
<%--                    <fmt:message key="report.date" bundle="${bundle}"/>--%>
<%--                </b> <span th:text="${#temporals.format(el.createdDate, 'dd-MM-yyyy HH:mm')}"></span></p>--%>

                <h4>
                    <fmt:message key="front.commentFromInspector" bundle="${bundle}"/>
                </h4>

                <textarea disabled name="comment"
                          placeholder="The inspector has not left any comments yet" class="form-control" rows="5" cols="33">
                    <span>${report.comment}</span>
                </textarea><br>


            </div>
        </div>
</div>

