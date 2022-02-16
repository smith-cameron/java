<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Registration</title>
<link rel="stylesheet" href="/css/loginRegStyle.css">
</head>
<body>
	<div id=wrapper>
		<h1 id="head">Login or Register</h1>
		<div id="regDiv">
			<h2 class="subHead">Register</h2>
			<form:form action="/register"  method="post" modelAttribute="newUser">
				<form:errors class="validations" path="userName"/>
				<div class="formGroup">
					<form:label path="userName">User Name:</form:label>
					<form:input class="formInput" path="userName"/>
				</div>
				<form:errors class="validations" path="email"/>
				<div class="formGroup">
					<form:label path="email">Email:</form:label>
					<form:input class="formInput" path="email"/>
				</div>
				<form:errors class="validations" path="password"/>
				<div class="formGroup">
					<form:label path="password">Password:</form:label>
					<form:input class="formInput" id="password" type="password" path="password"/>
				</div>
				<form:errors class="validations" path="confirmPassword"/>
				<div class="formGroup">
					<form:label path="confirmPassword">Confirm Password:</form:label>
					<form:input class="formInput" type="password" path="confirmPassword"/>
				</div>
				<input class="button" type="submit" value="Register">
			</form:form>
		</div>
		<div id="loginDiv">
			<h2 class="subHead">Login</h2>
			<form:form action="/login" method="post" modelAttribute="newLogin">
				<form:errors class="validations" path="email"/>
				<div class="formGroup">
					<form:label path="email">Email:</form:label>
					<form:input class="formInput" path="email"/>
				</div>
				<form:errors class="validations" path="password"/>
				<div class="formGroup">
					<form:label path="password">Password:</form:label>
					<form:input class="formInput" id="password" type="password" path="password"/>
				</div>
				<input class="button" type="submit" value="Login">
			</form:form>
		</div>
	</div>
</body>
</html>