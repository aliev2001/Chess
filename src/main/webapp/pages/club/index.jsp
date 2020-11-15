<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
	<body>
		<%@ include file='../../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<h1>Clubs page</h1>

			<div class="card-group">
				<c:forEach var="club" items="${ requestScope.clubs }">
					<div class="card pt-3 border-0">
						<div class="card-body">
							<h5 class="card-title">${ club.getTitle() }</h5>
							<p class="card-text">${ club.getDescription() }</p>
							<a href="#" class="">Delete</a>
						</div>
					</div>
				</c:forEach>
			</div>

		</div>

		<%@ include file='../../includes/footer.jsp' %>
	<script>
	</script>
	</body>
</html>
