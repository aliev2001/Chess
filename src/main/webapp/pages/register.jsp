<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<%@ include file='../includes/head.jsp' %>
	<body>
		<%@ include file='../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<h1>Register page</h1>
			<form action='register' method='post'>

				<%@ include file='../includes/message.jsp' %>

				<div class='form-group'>
					<input type='text' name='name' class='form-control' placeholder='Name'>
				</div>
				<div class='form-group'>
					<input type='text' name='surname' class='form-control' placeholder='Surname'>
				</div>
				<div class='form-group'>
					<input type='text' name='username' class='form-control' placeholder='Username'>
				</div>
				<div class='form-group'>
					<input type='password' name='password' class='form-control' placeholder='Password'>
				</div>
				<div class='form-group'>
					<input type='number' name='year' class='form-control' placeholder='Year'>
				</div>
				<div class='form-group'>
					<input type='text' name='major' class='form-control' placeholder='Major'>
				</div>
				<div class='form-group'>
					<input type='text' name='uGroup' class='form-control' placeholder='Group'>
				</div>
				<input type='submit' class='btn btn-primary' value='Register'>
				<a href='login'>Login</a>
			</form>
		</div>

		<%@ include file='../includes/footer.jsp' %>
	</body>
</html>
