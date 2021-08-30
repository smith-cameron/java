<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<a class="link" href="/dorms">Dormitories</a>
	<a class="link" href="/students/new">New Student</a>
	<a class="link" href="/contacts/new">New Contact</a>
	<a class="link" href="/stack/new">New Stack</a>
	<h1 id="head">All Students</h1>
	<table id="displayTable">
		<thead>
			<tr>
				<th class="tHead">Name</th>
				<th class="tHead">Age</th>
				<th class="tHead">Address</th>
				<th class="tHead">City</th>
				<th class="tHead">State</th>
				<th class="tHead">Dormitory</th>
				<th class="tHead"></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${students}" var="student">
			<tr>
				<td class="tData"><a class="tLink" href="/students/${student.id}">${student.firstName} ${student.lastName}</a></td>
				<td class="tData">${student.age}</td>
				<td class="tData">${student.contact.address}</td>
				<td class="tData">${student.contact.city}</td>
				<td class="tData">${student.contact.state}</td>
				<td class="tData">${student.dorm.name}</td>
				<td class="tData">
				<c:choose>
				<c:when test="${student.dorm != null}">
				<div class="formGroup">
					<form action="/dorms/${student.id}/remove" method="post">
						<input type="submit" value="Remove"/>
					</form>
				</div>
				</c:when>
				<c:otherwise>
				<div class="formGroup">
					<form id="inputForm" action="/dorms/${student.id}/add" method="post">
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
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>