<%@ page import="model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
request.setAttribute("title", "Profile page");
User user = (User) request.getSession().getAttribute("user");
%>
<html>
	<%@ include file='../includes/head.jsp' %>
	<body>
		<div class='container mt-4'>
			<h1>Profile page</h1>
		</div>		
		<%@ include file='../includes/footer.jsp' %>
	</body>
</html>
