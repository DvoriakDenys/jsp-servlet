<%@include file="components/client_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="ctg" uri="customtags" %>

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
                                 <fmt:message key="report.submit" bundle="${bundle}"/></button>
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
