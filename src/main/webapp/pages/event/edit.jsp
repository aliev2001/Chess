<%--
Created by IntelliJ IDEA.
User: Zangar
Date: 15.11.2020
Time: 14:07
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<%@ include file='../../includes/header.jsp' %>

		<div class="container-md mt-4">
			<h1>Event edit</h1>
			<form method="POST" action="/event/edit">
				<%@ include file='../../includes/message.jsp' %>
				<input type="text" name="id" value="${ requestScope.event.getId() }" hidden>
				<div class="form-group">
					<input type="text" name="title" placeholder="Title" value="${ requestScope.event.getTitle() }" class="form-control">
				</div>
				<div class="form-group">
					<input type="date" name="date" placeholder="Date" value="${ requestScope.event.getDate() }" class="form-control">
				</div>
				<div class="form-group">
					<textarea name="text" placeholder="Text" class="form-control">${ requestScope.event.getText() }</textarea>
				</div>
				<input type="submit" class="btn btn-primary" value="Edit">
			</form>
		</div>

		<%@ include file='../../includes/footer.jsp' %>
	</body>
</html>
