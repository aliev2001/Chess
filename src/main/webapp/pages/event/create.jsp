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

		<div class="container-md mt-4">
			<h1>Event create</h1>
			<form method="POST" action="/event/create">
				<%@ include file='../../includes/message.jsp' %>
				<div class="form-group">
					<input type="text" name="title" placeholder="Title" class="form-control">
				</div>
				<div class="form-group">
					<input type="date" name="date" placeholder="Date" class="form-control">
				</div>
				<div class="form-group">
					<textarea name="text" placeholder="Text" class="form-control"></textarea>
				</div>
				<input type="submit" class="btn btn-primary" value="Create">
			</form>
		</div>

		<%@ include file='../../includes/footer.jsp' %>
	</body>
</html>
