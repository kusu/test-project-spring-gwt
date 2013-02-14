<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix='c' uri='http://java.sun.com/jstl/core_rt'%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<jsp:useBean id="msg" type="java.lang.String" scope="request" />
<jsp:useBean id="action" type="java.lang.String" scope="request" />
<jsp:useBean id="errormessage" type="java.lang.String" scope="request" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>Test Project login page</title>
<link rel="stylesheet" href="styles/loginpagestyles.css" type="text/css" />
</head>

<body>

	<form:form name="f" action="${action}" method="POST">
		<div id="wrapper">
			<div class="headerInfo">
				<label>Login...</label>
				<div class="clear"></div>
			</div>

			<div class="loginContent">
				<c:if test="${not empty errormessage}">
					<div class="loginError">Your login attempt was not
						successful, try again.</div>
				</c:if>

				<div class="username">
					<p>Username</p>
					<p>
						<input type='text' name='j_username' />
					</p>
				</div>
				<div class="password">
					<p>Password</p>
					<p>
						<input type='password' name='j_password'>
					</p>
				</div>
				
				<div >
					<input class="button" name="submit" type="submit" value="Login">
				</div>
				<div class="clear"></div>
			</div>
		</div>
	</form:form>
</body>
</html>