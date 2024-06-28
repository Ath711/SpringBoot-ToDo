<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <h1 class="my-4">Enter Todo Details</h1>
    <hr>
    <div class="card mb-3">
        <div class="card-body">
            <form:form method="post" modelAttribute="toDo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required" class="form-control"></form:input>
                    <form:errors path="description" cssClass="text-warning"></form:errors>
                </fieldset>
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="date" path="targetDate" required="required" class="form-control"></form:input>
                    <form:errors path="targetDate" cssClass="text-warning"></form:errors>
                </fieldset>
                <button type="submit" class="btn btn-success"><i class="fas fa-save"></i> Save</button>
            </form:form>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
