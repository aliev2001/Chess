
<c:if test="${ sessionScope.message != null }">
	<div class='alert alert-info'>
		<c:out value="${ sessionScope.message }" />
		<% request.getSession().removeAttribute("message"); %>
	</div>
</c:if>
