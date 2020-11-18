<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
	<%@ include file='../../includes/head.jsp' %>
<style>
	.card-groups {
		display: grid;
		grid-template-columns: 25% 25% 25% 25%;
	}
</style>
	<body>
		<%@ include file='../../includes/header.jsp' %>
		<div class='container-md mt-4'>
			<h1>Clubs page</h1>

			<div class="card-groups">
				<c:forEach var="club" items="${ requestScope.clubs }">
					<div class="card" style="margin: 10px !important;">
						<img class="card-img-top" src="${ club.getImage() }" alt="">
						<div class="card-body">
							<h5 class="card-title"><strong>${ club.getTitle() }</strong></h5>
							<p class="card-text">${ club.getDescription() }</p>
							<c:if test="${ sessionScope.user != null && sessionScope.user.getIsAdmin() }">
								<a class="delete text-danger" href="#" data-id="${ club.getId() }">Delete</a> | 
								<a class="edit text-primary" href="<%=request.getContextPath()%>/club/edit?id=${ club.getId() }">Edit</a> |
							</c:if>
							<a class="join text-success" href="#" data-id="${ club.getId() }">Join</a>
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
																														 url: '<%=request.getContextPath()%>/club/delete?id=' + event.target.dataset.id
																														 });
																														 })
																										$('a.join').click(function(event){
																											event.preventDefault();
																										$.ajax({
																										method: 'POST',
																										url: '<%=request.getContextPath()%>/api/club/addMember/${ sessionScope.user.getId() }/' + event.target.dataset.id
																										});
																										})
		</script>
	</body>
</html>
