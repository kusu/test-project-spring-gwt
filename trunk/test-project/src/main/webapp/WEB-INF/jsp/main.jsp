<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head></head>
<title>A Test Project</title>
<body>

	<div style="margin-left: 400px;">
		<h2>Hello,</h2>
		<h3>This is a test Project</h3>
		<h2>You are now logged in.</h2>
		<br />
		<h2>Click the link below to log out.</h2>
		
		<h1><a href='<c:out value="logout"></c:out>'>Logout</a></h1>
	</div>
</body>
</html>