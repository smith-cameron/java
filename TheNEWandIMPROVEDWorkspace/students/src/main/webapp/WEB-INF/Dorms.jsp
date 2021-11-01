<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dormitories</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<a class="link" href="/students">Home</a>
	
	<div id="dormTable">
	<h2>All Dormitories</h2>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th></th>
				</tr>
			<tbody>
				<c:forEach items="${dorms}" var="dorm">
				<tr>
					<td class="tData"><a class="tLink" href="/dorms/${dorm.id}">${dorm.name}</a></td>
					<td class="tData"><a class="tLink" href="/dorm/${dorm.id}">Delete</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>