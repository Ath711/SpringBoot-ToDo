<%@ include file="common/header.jsp" %>
<%@ include file="common/navigation.jsp" %>
<div class="container my-4">
    <h1>Your ToDo's</h1>
    <div class="card mb-3">
        <div class="card-body">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Description</th>
                    <th>Target Date</th>
                    <th>Status</th>
                    <th>Actions</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach items="${toDo}" var="todo">
                    <tr>
                        <td>${todo.description}</td>
                        <td>${todo.targetDate}</td>
                        <td>${todo.status}</td>
                        <td>
                            <a href="/delete-todo?id=${todo.id}" class="btn btn-danger btn-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Delete"><i class="fas fa-trash-alt"></i></a>
                            <a href="/update-todo?id=${todo.id}" class="btn btn-success btn-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Update"><i class="fas fa-edit"></i></a>
                            <a href="/complete-todo?id=${todo.id}" class="btn btn-primary btn-sm" data-bs-toggle="tooltip" data-bs-placement="top" title="Mark as Completed"><i class="fas fa-check"></i></a>
                        </td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
            <div class="text-end">
                <a href="/add-todo" class="btn btn-success"><i class="fas fa-plus"></i> Add Todo</a>
            </div>
        </div>
    </div>
</div>
<%@ include file="common/footer.jsp" %>
