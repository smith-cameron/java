<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/css/indexStyle.css">
</head>
<body>
    <div id="wrapper">
		<h1>Login</h1>
		<h3>or</h3>
		<h3><a href="/register">Register</a></h3>
		<c:if test="${logoutMessage != null}">
	    	<c:out value="${logoutMessage}"></c:out>
		</c:if>
		<c:if test="${errorMessage != null}">
		    <c:out value="${errorMessage}"></c:out>
		</c:if>
	<div id="loginDiv">
		<h2 class="subHead">Login</h2>
		<form action="/login" method="post">
			<div class="formGroup">
				<label>Email:</label>
				<input class="formInput" type="email" name="userName"/>
			</div>
			<div class="formGroup">
				<label>Password:</label>
				<input class="formInput" type="password" name="password"/>
			</div>
		    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<input class="button" type="submit" value="Login">
		</form>
	</div>
	</div>
</body>
</html>