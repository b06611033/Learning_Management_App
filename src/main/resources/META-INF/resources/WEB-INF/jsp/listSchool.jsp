<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome to your University page ${name}!</div>
	<hr>
	<table class="table">
		<thead>
			<tr>
				<th>University</th>
				<th>Location</th>
				<th>Is Done?</th>
			</tr>
		</thead>
		<tbody>		
			<tr>
				<td>${school.name}</td>
				<td>${school.location}</td>
				<td><a href="update-todo?id=${school.id}" class="btn btn-success">UPDATE</a></td>
				<td><a href="delete-todo?id=${school.id}" class="btn btn-warning">DELETE</a></td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf" %>