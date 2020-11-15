<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<%@ include file='../includes/head.jsp' %>
	<body>
		<div class='container-fluid mt-4'>

			<div class="row">
				<div class="col-2" style="background: red">
					<h3>Sidebar</h3>
				</div>
				<div class="col-7">
					<h3>News</h3>
					<c:forEach var="news" items="${ requestScope.news }">
						<div class="card">
							<div class="card-body">
								<h5 class="card-title">${ news.getTitle() }</h5>
								<p class="card-text">${ news.getText() }</p>
							</div>
						</div>
					<h3>Test</h3>
					</c:forEach>
				</div>
				<div class="col-3" style="background: green">
					<h3>Events</h3>
					<c:forEach var="event" items="${ requestScope.event }">
						<div class="card bg-light mb-3">
							<div class="card-header">${ event.getTitle() }</div>
							<div class="card-body">
								<p class="card-text">${ event.getText() }</p>
								<p class="card-text">${ event.getDate() }</p>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>

		</div>

		<%@ include file='../includes/footer.jsp' %>
	</body>
</html>
