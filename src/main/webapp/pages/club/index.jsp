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
					<div class="card pt-3" style="max-width: 18rem; display: inline-block;">
						<div class="card-body">
							<h5 class="card-title">${ club.getTitle() }</h5>
							<p class="card-text">${ club.getDescription() }</p>
							<a class="delete text-danger" href="#" data-id="${ club.getId() }">Delete</a>
							<a class="join text-success" href="#" data-id="${ sessionScope.user.getId() }">Join</a>
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
																														 url: '/club/delete?id' + event.target.dataset.id
																														 method: 'get'
																														 });
																														 })
		</script>
	</body>
</html>
