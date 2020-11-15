<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<%@ include file='../../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<h1>Users page</h1>

			<form method="POST" action="/user">
				<div class="row">
				<div class="col">
				<input type="text" name="group" class="form-control" value='<%= request.getParameter("group") == null ? "" : request.getParameter("group") %>' placeholder="Group">
				</div>
				<div class="col">
				<input type="text" name="major" class="form-control" value='<%= request.getParameter("major") == null ? "" : request.getParameter("major") %>' placeholder="Major">
				</div>

				<div class="col">
				<input type="number" name="year" class="form-control" value='<%= request.getParameter("year") == null ? "" : request.getParameter("year") %>' placeholder="Year">
				</div>
				</div>
				<input type="submit" class="btn btn-primary btn-block mt-3" value="search">
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
							<a class="text-danger delete" href="" data-id="${ user.getId() }">Delete</a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

		<%@ include file='../../includes/footer.jsp' %>
	<script>
																						$('a.delete').click(function(event){
																						event.preventDefault();
																						$.ajax({
																										method: 'GET',
																										url: '/user/delete?id=' + event.target.dataset.id
																						});
																						})
	</script>
	</body>
</html>
