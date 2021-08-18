<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<a class="link" href="/contacts/new">New Contact</a>
	<a id="homelink" href="/students">Home</a>
	<h1 id="head">New Student</h1>
	<div id="inputForm">
		<form:form id="inputForm" action="/students/new" method="post" modelAttribute="student">
		        <form:errors class="validation" path="firstName"/>
			<div class="formGroup">
		        <form:label class="formLabel" path="firstName">First Name:</form:label>
		        <form:input class="formInput" path="firstName"/>
		    </div>
		        <form:errors class="validation" path="lastName"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="lastName">Last Name:</form:label>
		        <form:input class="formInput" path="lastName"/>
		    </div>
		        <form:errors class="validation" path="age"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="age">Age:</form:label>
		        <form:input class="formInput" path="age"/>
		    </div>
	    	<input id="button" type="submit" value="Submit"/>
			</form:form>
	</div>
</div>
</body>
</html>