<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="errormessage" type="java.lang.String" scope="request" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Change password</title>
<link rel="stylesheet" href="styles/loginpagestyles.css" type="text/css" />
</head>

<body>
	<c:if test="${not empty errormessage}">
		<div class="loginError">${errormessage}</div>
	</c:if>
	
	<form:form action="changePassword" method="POST" modelAttribute="userModel"
		autocomplete="on">
		<p>
			<label>Old Password:</label>
			<form:password path="oldPassword" maxlength="30" required="required" />
		</p>

		<p>
			<label>New Password:</label>
			<form:password path="newPassword" maxlength="30" required="required" />
		</p>
		<p>
			<label>Confirm New Password:</label>
			<form:password path="confirmNewPassword" maxlength="30"
				required="required" />
		</p>

		<div>
			<button type="submit">Submit</button>
		</div>

	</form:form>

</body>
</html>