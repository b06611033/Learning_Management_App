<%@ include file="common/header.jspf" %>
	<div class="container">
		<h1>Register</h1>
		<form:form method="post" modelAttribute="user">
			<fieldset class="mb-3">
				<form:label path="username">Username: </form:label>
				<form:input type="text" path="username" required="required"/>
			</fieldset>
			<fieldset class="mb-3">
				<form:label path="password">Password: </form:label>
				<form:input type="text" path="password" required="required"/>
			</fieldset>
			<form:input type="hidden" path="id"/>
			<input type="submit" class="btn btn-success"/>
		</form:form>
		<a href="login"> Already Registered? Login here!</a>
	</div>
<%@ include file="common/footer.jspf" %>