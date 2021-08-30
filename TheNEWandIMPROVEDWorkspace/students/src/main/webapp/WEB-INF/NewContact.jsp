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
	<a class="link" href="/dorms">Dormitories</a>
	<a class="link" href="/students/new">New Student</a>
	<a class="link" href="/students">Home</a>
	<h1 id="head">Contact Info</h1>
	<div id="inputForm">
		<form:form id="inputForm" action="/contacts/new" method="post" modelAttribute="contact">
		     <form:errors class="validation" path="student"/>
			<div class="formGroup">
				<form:label path="student">Student:</form:label>
				<form:select class="formInput" path="student">
		     		<c:forEach items="${students}" var="student">
		     		<c:choose>
			     		<c:when test="${student.contact == null }">
	 						<form:option value="${student.id}">${student.firstName} ${student.lastName}</form:option>
					    </c:when>
				    </c:choose>
				    </c:forEach>
				</form:select>
			</div>
		        <form:errors class="validation" path="address"/>
			<div class="formGroup">
		        <form:label class="formLabel" path="address">Address:</form:label>
		        <form:input class="formInput" path="address"/>
		    </div>
		        <form:errors class="validation" path="city"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="city">City:</form:label>
		        <form:input class="formInput" path="city"/>
		    </div>
		        <form:errors class="validation" path="state"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="state">State:</form:label>
		        <form:input class="formInput" path="state"/>
		    </div>
	    	<input id="button" type="submit" value="Submit"/>
			</form:form>
	</div>
</div>
</body>
</html>