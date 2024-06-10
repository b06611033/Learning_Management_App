<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>
<div class="container">
	<h1> Please type your diary</h1>
	<form:form method="post" modelAttribute="diary">
		<fieldset class="mb-3">
			<form:label path="content">Content: </form:label>
			<form:input type="text" path="content" required="required"/>
		</fieldset>
		<form:input type="hidden" path="updateDate"/>
		<form:input type="hidden" path="id"/>
		<input type="submit" class="btn btn-success"/>
	</form:form>
</div>
<%@ include file="common/footer.jspf" %>