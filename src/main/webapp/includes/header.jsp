<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarNav">
    <ul class="navbar-nav mr-auto">

		<c:if test="${ sessionScope.user == null }">

				  <li class="nav-item">
     	 	    <a class="nav-link" href="<%=request.getContextPath()%>/login">Login</a>
				  </li>
					<li>
						<a class="nav-link" href="<%=request.getContextPath()%>/pages/register.jsp">Registration</a>
					</li>
		</c:if>
    </ul>
		<ul class="navbar-nav">
				<c:if test="${ sessionScope.user != null }">
				  <li class="nav-item">
     	 	    <a class="nav-link" href="<%=request.getContextPath()%>/logout">Logout</a>
     	 	  </li>
				</c:if>
		</ul>
  </div>
</nav>


