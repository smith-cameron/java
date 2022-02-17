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
	<a class="link" href="/students">Home</a>
	<h1 id="head">${student.firstName} ${student.lastName}'s Info</h1>
	<table id="displayTable">
		<thead>
			<tr>
				<th class="tHead">ID</th>
				<th class="tHead">Name</th>
				<th class="tHead">Age</th>
				<th class="tHead">Address</th>
				<th class="tHead">City</th>
				<th class="tHead">State</th>
				<th class="tHead">Dormitory</th>
				<th class="tHead">Actions</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td class="tData">${student.id}</td>
				<td class="tData">${student.firstName} ${student.lastName}</td>
				<td class="tData">${student.age}</td>
				<td class="tData">${student.contact.address}</td>
				<td class="tData">${student.contact.city}</td>
				<td class="tData">${student.contact.state}</td>
				<td class="tData">${student.dorm.name}</td>
				<td class="tData"><a class="tLink" href="/student/${student.id}/edit">Edit</a></td>
			</tr>
		</tbody>
	</table>
	<div class="formGroup">
		<c:choose>
		<c:when test="${student.dorm != null}">
		<div class="formGroup">
			<form action="/dorms/${student.id}/remove" method="post">
				<input type="submit" value="Move Dormitories"/>
			</form>
		</div>
		</c:when>
		<c:otherwise>
		<div class="formGroup">
			<form id="inputForm" action="/dorms/${student.id}/add" method="post">
				<select class="formInput" name="dorm">
	     		<c:forEach items="${dorms}" var="dorm">
	     		<c:choose>
	     		<c:when test="${student.dorm.id != dorm.id }">
						<option value="${dorm.id}">${dorm.name}</option>
			    </c:when>
			    </c:choose>
			    </c:forEach>
				</select>
				<input id="submitButton" type="submit" value="Join"/>
			</form>
		</div>
		</c:otherwise>
		</c:choose>
	</div>
	<h1 id="head">${student.firstName}'s Contact Info</h1>
	<div class="formGroup">
		<c:choose>
		<c:when test="${myContact != null}">
		<div id="inputForm">
			<form:form id="inputForm" action="/contact/${student.id}/edit" method="post" modelAttribute="myContact">
			     <form:hidden path="student" value="${student.id}"/>
				<div class="formGroup">
					
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
		</c:when>
		<c:otherwise>
			<div id="inputForm">
			<form:form id="inputForm" action="/contact/${student.id}/new" method="post" modelAttribute="newContact">
			     <form:hidden path="student" value="${student.id}"/>
				<div class="formGroup">
					
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
		</c:otherwise>
		</c:choose>
	</div>
</div>
</body>
</html>