<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome to the course list page ${name}!</div>
	<hr>
	<h1> Courses</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Name</th>
				<th>Instructor</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${courses}" var="course">
				<tr>
					<td>${course.coursename}</td>
					<td>${course.instructor}</td>
					<td><a href="update-course?id=${course.id}" class="btn btn-success">ADD</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
<%@ include file="common/footer.jspf" %>