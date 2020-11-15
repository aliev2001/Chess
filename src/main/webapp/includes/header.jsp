<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
	<a class="navbar-brand" href="/">AITU <small>shit</small></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">

			<c:choose>
				<c:when test="${ sessionScope.user == null }">
				  <li class="nav-item">
     	 	    <a class="nav-link" href="/login">Login</a>
     	 	  </li>
				</c:when>
				<c:otherwise>
				  <li class="nav-item">
     	 	    <a class="nav-link" href="/">Home</a>
     	 	  </li>
				  <li class="nav-item">
     	 	    <a class="nav-link" href="/profile">Profile</a>
     	 	  </li>
					<c:if test="${ sessionScope.user.getIsAdmin() }">
						<li class="nav-item">
							<a class="nav-link" href="/user">Students</a>
						</li>
						<li class="nav-item">
							<a class="nav-link" href="/club">Clubs</a>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
								Add
							</a>
							<div class="dropdown-menu" aria-labelledby="navbarDropdown">
								<a class="nav-link" href="/user/create">Student</a>
								<a class="nav-link" href="/news/create">News</a>
								<a class="nav-link" href="/event/create">Event</a>
								<a class="nav-link" href="/club/create">Club</a>
							</div>
						</li>
					</c:if>
				</c:otherwise>
			</c:choose>
    </ul>
		<ul class="navbar-nav">
				<c:if test="${ sessionScope.user != null }">
				  <li class="nav-item">
     	 	    <a class="nav-link" href="/logout">Logout</a>
     	 	  </li>
				</c:if>
		</ul>
  </div>
</nav>
