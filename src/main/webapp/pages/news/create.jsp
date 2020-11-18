<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<%@ include file='../../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<h1>Create news</h1>
			<form method="POST" action="<%=request.getContextPath()%>/news/create">
				<div class="form-group">
					<input type="text" name="title" placeholder="Title" class="form-control">
				</div>
				<div class="form-group">
					<textarea name="text" class="form-control" placeholder="Text"></textarea>
				</div>
				<input type="submit" class="btn btn-primary" value="Create">
			</form>
		</div>

		<%@ include file='../../includes/footer.jsp' %>
	</body>
</html>
