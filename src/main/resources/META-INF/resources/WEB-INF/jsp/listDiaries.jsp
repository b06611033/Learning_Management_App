<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<div>Welcome to your diary list page ${name}!</div>
	<hr>
	<h1> Your diaries are</h1>
	<table class="table">
		<thead>
			<tr>
				<th>Content</th>
				<th>Update Date</th>
			</tr>
		</thead>
		<tbody>		
			<c:forEach items="${diaries}" var="diary">
				<tr>
					<td>${diary.content}</td>
					<td>${diary.updateDate}</td>
					<td><a href="update-diary?id=${diary.id}" class="btn btn-success">UPDATE</a></td>
					<td><a href="delete-diary?id=${diary.id}" class="btn btn-warning">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="add-diary" class="btn btn-success"> Add diary</a>
</div>
<%@ include file="common/footer.jspf" %>