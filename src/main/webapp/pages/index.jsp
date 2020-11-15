<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<%@ include file='../includes/head.jsp' %>
	<body>
		<%@ include file='../includes/header.jsp' %>
		<div class='container-md mt-4'>

			<div class="row">
				<div class="col-8">
					<h3>News</h3>
					<c:forEach var="news" items="${ requestScope.news }">
						<div class="card mb-4">
							<div class="card-body">
								<h5 class="card-title">${ news.getTitle() }</h5>
								<p class="card-text">${ news.getText() }</p>

								<c:if test="${ sessionScope.user != null && sessionScope.user.getIsAdmin() }">
									<a class="delete-news text-danger" href="#" data-id="${ news.getId() }">Delete</a>
									<a href="/news/edit?id=${ news.getId() }">Edit</a>
								</c:if>

							</div>
						</div>
					</c:forEach>
				</div>

				<div class="col-4">
					<h3>Events</h3>
					<c:forEach var="event" items="${ requestScope.event }">
						<div class="card bg-light mb-3">
							<div class="card-header">${ event.getTitle() }</div>
							<div class="card-body">
								<p class="card-text">${ event.getText() } <br>
									<small>${ event.getDate() }</small>
								</p>

								<c:if test="${ sessionScope.user != null && sessionScope.user.getIsAdmin() }">
									<a class="delete-event text-danger" href="#" data-id="${ event.getId() }">Delete</a> | 
									<a href="/event/edit?id=${ event.getId() }">Edit</a>
								</c:if>

							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

		<form id="lol"></form>

		<%@ include file='../includes/footer.jsp' %>

		<script>
		  $('a.delete-event').click(function(event){
				event.preventDefault();
				$.ajax({
					method: 'GET',
					url: 'event/delete?id=' + event.target.dataset.id,
					success: function(resp){
					}
				});
			})
		  $('a.delete-news').click(function(event){
				event.preventDefault();
				$.ajax({
					method: 'GET',
					url: 'news/delete?id=' + event.target.dataset.id,
					success: function(resp){
					}
				});
			})
		</script>
	</body>
</html>
