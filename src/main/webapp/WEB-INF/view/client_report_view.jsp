<%@page pageEncoding="UTF-8" %>
<%@include file="components/inspector_header.jsp" %>


<div>
        <div class="container mt-5">
            <div class="alert alert-info mt-2">

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


                <textarea disabled name="comment"
                          placeholder="The inspector has not left any comments yet" class="form-control" rows="5" cols="10">
                    ${report.comment}
                </textarea><br>

            </div>

        </div>
</div>

