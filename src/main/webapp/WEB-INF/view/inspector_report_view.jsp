<%@page pageEncoding="UTF-8" %>
<%@include file="components/inspector_header.jsp" %>


<div>
    <div class="container mt-5">
        <div class="alert alert-info mt-2">
            <form action="/" method="post">
            <h2 >
                <fmt:message key="client.report" bundle="${bundle}"/>
            </h2>

                <textarea disabled name="comment"
                          placeholder="The inspector has not left any comments yet" class="form-control" rows="5" cols="10">
                    ${report.report}
                </textarea><br>

            <h4>
                <fmt:message key="front.commentFromInspector" bundle="${bundle}"/>

            </h4>


            <textarea name="comment"
                      placeholder="The inspector has not left any comments yet" class="form-control" rows="5" cols="33">
                ${report.comment}
            </textarea><br>


            <input name="command" value="add_comment_and_status" type="hidden"/>
            <input name="reportId" value="${report.id}" type="hidden"/>
            <button type="submit" class="btn btn-success">
                <span> <fmt:message key="report.submit" bundle="${bundle}"/> </span>
            </button>
        </form>
    </div>
</div>
</div>