<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body>

	<form:form action="register" method="POST" modelAttribute="user"
		autocomplete="on">
		<p>
			<label>Username:</label>
			<form:input path="username" maxlength="30" required="required" />
		</p>

		<p>
			<label>Password:</label>
			<form:password path="password" maxlength="30" required="required" />
		</p>
		<p>
			<label>Confirm Password:</label>
			<form:password path="confirmPassword" maxlength="30"
				required="required" />
		</p>
		<p>
			<label>City:</label>
			<form:input path="city" maxlength="30" required="required" />
		</p>

		<p>
			<label>Country:</label>
			<form:input path="country" maxlength="30" required="required" />
		</p>

		<div>
			<button type="submit">Submit</button>
		</div>

	</form:form>
</body>