<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link rel="stylesheet" href="/css/loginStyle.css">
</head>
<body>
	<div id=wrapper>
		<h1 id="head">Login or Register</h1>
		<div id="regDiv">
			<h2 class="subHead">Register</h2>
			<form:form method="POST" action="/register" modelAttribute="user">
					<form:errors class="validations" path="firstName"/>
				<div class="formGroup">
					<form:label path="firstName">First Name:</form:label>
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
					<form:input class="formInput" id="password" type="password" path="password"/>
					<ul id=passReq>
						<li id=listHead>Password Must Contain:</li>
						<li>at least 8 characters and at most 20 characters</li>
						<li>at least one number</li>
						<li>at least one upper case letter</li>
						<li>at least one lower case letter</li>
						<li>at least one special character which includes !@#$%&*()-+=^</li>
						<li>and no spaces</li>
					</ul>
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
			<h3 class="validations">${loginError}</h3>
			<form action="/login" method="post">
				<div class="formGroup">
					<label>Email:</label>
					<input class="formInput" type="email" name="loginEmail"/>
				</div>
				<div class="formGroup">
					<label>Password:</label>
					<input class="formInput" type="password" name="loginPassword"/>
				</div>
				<input class="button" type="submit" value="Login">
			</form>
		</div>
	</div>
	
</body>
</html>