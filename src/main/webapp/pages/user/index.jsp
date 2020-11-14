<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<div class='container-md mt-4'>
			<h1>Users page</h1>

			<form method="POST" action="/user">
				<input type="text" name="group" class="form-control" value='<%= request.getParameter("group") == null ? "" : request.getParameter("group") %>' placeholder="Group">
				<input type="text" name="major" class="form-control" value='<%= request.getParameter("major") == null ? "" : request.getParameter("major") %>' placeholder="Major">
				<input type="number" name="year" class="form-control" value='<%= request.getParameter("year") == null ? "" : request.getParameter("year") %>' placeholder="Year">
				<input type="submit" class="btn btn-primary" value="search">
			</form>

			<hr>

			<div class="card-group text-center">
				<c:forEach var="user" items="${ requestScope.users }">
					<div class="card pt-3 border-0">
						<img class="rounded-circle mx-auto d-block" width=150 height=150 src="https://via.placeholder.com/150x150" alt="Image">
						<div class="card-body">
							<h5 class="card-title">${ user.getName() } ${ user.getSurname() }<br><small class="text-secondary">${ user.getUsername() }</small></h5>
							<p class="card-text">
								Major: ${ user.getMajor() }<br>
								Group: ${ user.getUGroup() }
							</p>
							<a href="#" class="">Delete</a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

		<%@ include file='../../includes/footer.jsp' %>
	</body>
</html>
