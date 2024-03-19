<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome to the university list page ${name}!</div>
	<hr>
	<h1> Universities</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Location</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${schools}" var="school">
				<tr>
					<td>${school.name}</td>
					<td>${school.location}</td>
					<td><a href="update-school?id=${school.id}" class="btn btn-success">ADD</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf" %>