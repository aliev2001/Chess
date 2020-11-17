<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<%@ include file='../../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<h1>Add student</h1>
			<form method="POST" action="/user/create">

				<div class="form-group">
					<input type="text" name="name" placeholder="Name" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" name="surname" placeholder="Surname" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" name="username" placeholder="Username" class="form-control">
				</div>
				<div class="form-group">
					<input type="password" name="password" placeholder="Password" class="form-control">
				</div>
				<div class="form-group">
					<input type="number" name="year" placeholder="Year" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" name="major" placeholder="Major" class="form-control">
				</div>
				<div class="form-group">
					<input type="text" name="group" placeholder="Group" class="form-control">
				</div>
				<input type="submit" class="btn btn-primary" value="Create">
			</form>
		</div>

		<%@ include file='../../includes/footer.jsp' %>
	</body>
</html>
