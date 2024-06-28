<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <h1>Enter Todo Details</h1>
    <hr>
    <form:form method="post" modelAttribute="toDo">
        <fieldset class="mb-3">
            <form:label path="description">Description</form:label>
            <form:input type="text" path="description" required="required"></form:input>
            <form:errors path="description" cssClass="text-warning"></form:errors>
        </fieldset>
        <fieldset class="mb-3">
            <form:label path="targetDate">Target Date: </form:label>
            <form:input type="date" path="targetDate" required="required"></form:input>
            <form:errors path="targetDate" cssClass="text-warning"></form:errors>
        </fieldset>
        <input type="submit" class="btn btn-success">
    </form:form>


    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</div>
<%@ include file="common/footer.jsp" %>