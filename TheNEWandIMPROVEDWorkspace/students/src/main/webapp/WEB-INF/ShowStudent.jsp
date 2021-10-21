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
	<a class="link" href="/contacts/new">New Contact</a>
	<a class="link" href="/students">Home</a>
	<h1 id="head">${student.firstName} ${student.lastName}'s Info</h1>
	<table id="displayTable">
		<thead>
			<tr>
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
		<form id="inputForm" action="/stack/${student.id}/add" method="post">
			<select class="formInput" name="dorm">
     		<c:forEach items="${allDorms}" var="dorm">
     		<c:choose>
     		<c:when test="${student.dorm.id != dorm.id }">
					<option value="${dorm.id}">${dorm.name}</option>
		    </c:when>
		    </c:choose>
		    </c:forEach>
			</select>
			<input id="submitButton" type="submit" value="Submit"/>
		</form>
	</div>
	<div id="dormTable">
	<h2>Your Schedule</h2>
		<table>
			<tbody>
				<c:forEach items="${stacks}" var="stack">
				<tr>
					<td class="tData"><a class="tLink" href="/stack/${stack.id}">${stack.name}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>