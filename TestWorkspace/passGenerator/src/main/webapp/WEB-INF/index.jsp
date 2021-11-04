<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Password</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<h1 id="head">Generate Random Password</h1>
	<form id ="inputForm" action="/create" method="post" >
		<div class="formGroup">
			<!-- <input type ="hidden" class="formInput" name="passWord"/> -->
			<%-- <form:input class="formInput" path="passWord"/> --%>
			<input class="button" type="submit" value="Generate">
		</div>	
	</form>
	<%-- <form:form id ="inputForm" action="/create" method="post" modelAttribute="password">
		<div class="formGroup">
			<form:hidden class="formInput" path="passWord"/>
			<form:input class="formInput" path="passWord"/>
			<input class="button" type="submit" value="Generate">
		</div>	
	</form:form> --%>
</div>
</body>
</html>