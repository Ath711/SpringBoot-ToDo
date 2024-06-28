<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container">
    <h1>Your ToDo's</h1>
    <table class="table">
        <thead>
        <tr>
            <th>Description</th>
            <th>Target Date</th>
            <th>Status</th>
            <th></th>
            <th></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <C:forEach items="${toDo}" var="todo">
            <tr>
                <td>${todo.description}</td>
                <td>${todo.targetDate}</td>
                <td>${todo.status}</td>
                <td><a href="/delete-todo?id=${todo.id}" class="btn-danger">Delete</a></td>
                <td><a href="/update-todo?id=${todo.id}" class="btn-success">Update</a></td>
                <td><a href="/complete-todo?id=${todo.id}" class="btn-success">Mark as Completed</a></td>
            </tr>
        </C:forEach>
        </tbody>
    </table>
    <br>
    <a href="/add-todo" class="btn btn-success"> Add Todo </a>
    <script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
    <script src="webjars/jquery/3.6.0/jquery.min.js"></script>
</div>
<%@ include file="common/footer.jsp" %>