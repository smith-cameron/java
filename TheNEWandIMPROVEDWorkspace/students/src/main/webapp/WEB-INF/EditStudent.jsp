<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit ${student.firstName} ${student.lastName}</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<a class="link" href="/students">Home</a>
	<h1 id="head">Edit ${student.firstName} ${student.lastName}</h1>
	<div id="inputForm">
		<form:form id="inputForm" action="/student/${student.id}/edit" method="post" modelAttribute="studentform">
		        <form:errors class="validation" path="firstName"/>
			<div class="formGroup">
		        <form:label class="formLabel" path="firstName">First Name:</form:label>
		        <form:input class="formInput" path="firstName" value="${student.firstName }"/>
		    </div>
		        <form:errors class="validation" path="lastName"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="lastName">Last Name:</form:label>
		        <form:input class="formInput" path="lastName" value="${student.lastName }"/>
		    </div>
		        <form:errors class="validation" path="age"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="age">Age:</form:label>
		        <form:input class="formInput" path="age" value="${student.age}"/>
		    </div>
		    <c:choose>
				<c:when test="${student.dorm != null}">
					<form:hidden path="dorm" value="${student.dorm.id }"/>
				</c:when>		    
		    </c:choose>
	    	<input id="button" type="submit" value="Submit"/>
			</form:form>
	</div>
</div>
</body>
</html>