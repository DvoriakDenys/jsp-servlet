<%@include file="components/_header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>



<div class="container form-register wrapper" >
    <form action="/" method="post">
        <div class="input-gr register-wrapper">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.fname" bundle="${bundle}"/></span>
                <input type="text" name="firstName" class="form-control"
                       placeholder="<fmt:message key="client.firstName.hint" bundle="${bundle}"/>"
                value="${requestScope.tmp_user.firstName}"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.lname" bundle="${bundle}"/></span>
                <input type="text" name="lastName" class="form-control"
                       placeholder="<fmt:message key="client.lastName.hint" bundle="${bundle}"/>"
                       value="${requestScope.tmp_user.lastName}"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.login" bundle="${bundle}"/></span>
                <input type="text" name="login" class="form-control" autocomplete="on"
                       placeholder="<fmt:message key="client.login.hint" bundle="${bundle}"/>"
                       value="${requestScope.tmp_user.login}"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.password" bundle="${bundle}"/></span>
                <input type="text" name="password" autocomplete="on" class="form-control"
                       placeholder="<fmt:message key="client.password.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon" ><fmt:message key="client.email" bundle="${bundle}"/></span>
                <input type="text" name="email" class="form-control"
                       placeholder="<fmt:message key="client.email.hint" bundle="${bundle}"/>"
                       value="${requestScope.tmp_user.email}"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.phone" bundle="${bundle}"/></span>
                <input type="text" name="phone" class="form-control"
                       placeholder="<fmt:message key="client.phone.hint" bundle="${bundle}"/>"
                       value="${requestScope.tmp_user.phone}"/>
            </div>
            <br>

            <input name="command" value="register" type="hidden"/>
            <div>
                <c:if test="${!empty requestScope.exception}">
                    <span style="color: red; font-size: 13px"><fmt:message key="${requestScope.exception}" bundle="${bundle}"/></span>
                </c:if>
            </div>
            <button type="submit" class="btn btn-success"><fmt:message key="front.register" bundle="${bundle}"/></button>

        </div>
    </form>
</div>
