<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome to your courses ${name}!</div>
	<hr>
	<h1> Courses</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Instructor</th>
				<th>Associated with</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${courses}" var="course">
				<tr>
					<td>${course.coursename}</td>
					<td>${course.instructor}</td>
					<td>${course.school.name}</td>
					<td><a href="delete-course?id=${course.id}" class="btn btn-warning">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf" %>