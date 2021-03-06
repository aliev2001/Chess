<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<%@ include file='../includes/head.jsp' %>
	<body>
		<%@ include file='../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<div class="row">
				<div class="col-md-3">
				<h1>Login page</h1>
				<form action='<%=request.getContextPath()%>/login' method='post'>

					<%@ include file='../includes/message.jsp' %>

					<div class='form-group'>
						<input type='text' name='username' class='form-control' placeholder='Username'>
					</div>
					<div class='form-group'>
						<input type='password' name='password' class='form-control' placeholder='Password'>
					</div>
					<input type='submit' class='btn btn-primary' value='Login'>
				</form>
			</div>
		</div>

		<%@ include file='../includes/footer.jsp' %>
	</body>
</html>
