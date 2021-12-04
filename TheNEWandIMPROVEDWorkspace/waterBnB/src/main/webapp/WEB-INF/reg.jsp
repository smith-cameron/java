 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link rel="stylesheet" href="/css/loginRegStyle.css">
</head>
<body>
	<div id=wrapper>
	<div id=nav>
		<a class="navLink" href="/login">Sign In</a> |
		<a class="navLink" href="/">Search</a>
	</div>
		<div id="regDiv">
			<h2 class="subHead">Register</h2>
			<form:form action="/registering" method="post" modelAttribute="user">
				<div class="formGroup">
					<form:label path="firstName">First Name:</form:label>
					<form:errors class="validations" path="firstName"/>
					<form:input class="formInput" path="firstName"/>
				</div>
					<form:errors class="validations" path="lastName"/>
				<div class="formGroup">
					<form:label path="lastName">Last Name:</form:label>
					<form:input class="formInput" path="lastName"/>
				</div>
					<form:errors class="validations" path="email"/>
				<div class="formGroup">
					<form:label path="email">Email:</form:label>
					<form:input class="formInput" path="email"/>
				</div>
					<form:errors class="validations" path="password"/>
				<div class="formGroup">
					<form:label path="password">Password:</form:label>
					<form:input class="formInput" type="password" path="password"/>
				</div>
					<form:errors class="validations" path="confirmPassword"/>
				<div class="formGroup">
					<form:label path="confirmPassword">Confirm Password:</form:label>
					<form:input class="formInput" type="password" path="confirmPassword"/>
				</div>
				<input class="button" type="submit" value="Register">
			</form:form>
		</div>
	</div>
</body>
</html>