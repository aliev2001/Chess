<%@ page import="model.User" %>
<%@ page import="service.ClubService" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setAttribute("title", "Profile page");
User user = (User) request.getSession().getAttribute("user");
%>
<html>
	<%@ include file='../includes/head.jsp' %>
<style>
	.card-groups {
		display: grid;
		grid-template-columns: 25% 25% 25% 25%;
	}
</style>
	<body>
		<%@ include file='../includes/header.jsp' %>
		<div class='container mt-4'>
			<h1>Profile page</h1><div class=" mb-4">
                    <div class="" style="padding-left: 30px !important;">


                        <c:if test="${ sessionScope.user != null }">
												<h4 class= "card-text">${ user.getName() } ${ user.getSurname() } <small>${ user.getUsername() }</small></h4>
												<p>Graduation year: ${ user.getYear() }<br>
												Major: ${ user.getMajor() }<br>
                            Group: ${ user.getUGroup() }</p>
                        </c:if>
                    </div>
                </div>

			<hr>
			<h3>Clubs:</h3>
			<%
			ClubService cc = new ClubService();
			request.setAttribute("_clubs",cc.getUserClubs(user.getId()));
			%>

			<div class="card-groups">
				<c:forEach var="club" items="${requestScope._clubs}">
				<div class="card" style="margin: 10px !important">
					<img class="card-img-top" src="${ club.getImage() }" alt="">
					<div class="card-body">
						<h5 class="card-title"><strong>${ club.getTitle() }</strong></h5>
						<p class="card-text">${ club.getDescription() }</p>
						<a class="join text-danger" href="#" data-id="${ club.getId() }">Left</a>
					</div>
				</div>
				</c:forEach>
			</div>
		</div>
		</div>		
		<%@ include file='../includes/footer.jsp' %>
		<script>
			 $('a.join').click(function(event){
				 event.preventDefault();
				 $.ajax({
					 method: 'POST',
					 url: '<%=request.getContextPath()%>/api/club/removeMember/${ sessionScope.user.getId() }/' + event.target.dataset.id
				 });
			 })
		</script>
	</body>
</html>
