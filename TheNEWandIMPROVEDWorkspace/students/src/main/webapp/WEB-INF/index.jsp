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
	<a class="link" href="/additions">Add Entities</a>
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
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>