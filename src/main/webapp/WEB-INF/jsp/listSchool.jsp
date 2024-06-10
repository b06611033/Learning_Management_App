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
			</tr>
		</thead>
		<tbody>		
			<tr>
				<td>${school.name}</td>
				<td>${school.location}</td>
				<td><a href="delete-school" class="btn btn-warning">DELETE</a></td>
			</tr>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf" %>