<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:if test="${ sessionScope.user == null }">
	<c:redirect url="/login" />
</c:if>

<html>
	<%@ include file='../includes/head.jsp' %>
	<body>

	</body>
</html>
