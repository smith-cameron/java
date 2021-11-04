<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dorm.name}</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
<a class="link" href="/dorms">Dormitories</a>
	<a class="link" href="/students">Home</a>
	<h1 id="head">${dorm.name} Dormitory</h1>
	<h2 class="subHead">Students:</h2>
	<c:choose>
	<c:when test="${dorm.students.isEmpty()}">
		<h3 class="alert">No Students in ${dorm.name} Dormitory.</h3>
	</c:when>
	<c:otherwise>
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
		<c:choose>
		<c:when test="${student.dorm.id == dorm.id}">
			<tr>
				<td class="tData"><a class="tLink" href="/students/${student.id}/show" >${student.firstName} ${student.lastName}</a></td>
				<td class="tData">${student.age}</td>
				<td class="tData">${student.contact.address}</td>
				<td class="tData">${student.contact.city}</td>
				<td class="tData">${student.contact.state}</td>
				<td class="tData">${student.dorm.name}</td>
				<td class="tData"><a class="tLink" href="/${dorm.id}/${student.id}/remove">Remove</a></td>
			</tr>
		</c:when>
		</c:choose>
		</c:forEach>
		</tbody>
	</table>
	</c:otherwise>
	</c:choose>
	 <%-- <div id="inputForm">
		<form id="inputForm" action="/dorms/${dorm.id}/add" method="post" >
		<div class="formGroup">
			<label>Student:</label>
			<select class="formInput" name="dorm">
	     		<c:forEach items="${students}" var="student">
						<option value="${student.id}">${student.firstName} ${student.lastName}</option>
			    </c:forEach>
			</select>
		</div>
    	<input id="button" type="submit" value="Submit"/>
		</form>
	</div>  --%>
</div>
</body>
</html>