<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<div class='container-md mt-4'>
			<h1>Edit news</h1>
			<form method="POST" action="/news/edit">
				<%@ include file='../../includes/message.jsp' %>
				<div class="form-group">
					<input type="text" name="title" placeholder="Title" value="${ requestScope.user.getTitle() }" class="form-control">
				</div>
				<div class="form-group">
					<textarea name="text" class="form-control" placeholder="Text">${ requestScope.user.getText() }</textarea>
				</div>
				<input type="submit" class="btn btn-primary" value="Edit">
			</form>
		</div>

		<%@ include file='../../includes/footer.jsp' %>
	</body>
</html>
