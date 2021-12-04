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
			<a class="navLink" href="/register">Register</a> |
			<a class="navLink" href="/">Search</a>
		</div>
		<div id="loginDiv">
			<h2 class="subHead">Login</h2>
			<h3 class="validations">${loginError}</h3>
			<form action="/logging" method="post">
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