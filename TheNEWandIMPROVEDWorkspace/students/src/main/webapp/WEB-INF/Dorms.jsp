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
	<a class="link" href="/contacts/new">New Contact</a>
	<a class="link" href="/students/new">New Student</a>
	<a class="link" href="/students">Home</a>
	<h1 id="head">Dormitories</h1>
	<div id="dormForm">
		<h2>New Dormitory</h2>
		<form:form id="inputForm" action="/dorms/new" method="post" modelAttribute="dorm">
        <form:errors class="validation" path="name"/>
		<div class="formGroup">
	        <form:label class="formLabel" path="name">Name:</form:label>
	        <form:input class="formInput" path="name"/>
	    </div>
    	<input id="button" type="submit" value="Create Dormitory"/>
		</form:form>
	</div>
	<div id="dormTable">
	<h2>All Dormitories</h2>
		<table>
			<tbody>
				<c:forEach items="${dorms}" var="dorm">
				<tr>
					<td class="tData"><a class="tLink" href="/dorms/${dorm.id}">${dorm.name}</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</div>
</body>
</html>