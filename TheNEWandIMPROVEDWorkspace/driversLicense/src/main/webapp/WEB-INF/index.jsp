<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DMV</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<!-- <a id="link" href="/license/new">New License</a> -->
	<h1 id="head">Welcome to the DMV</h1>
	<div id="formDiv">
	<h2 class="subHead">Add a Person</h2>
		<form:form action="/person" method="post" modelAttribute="person" >
			<div class="formGroup">
				<form:label path="firstName">First Name:</form:label>
				<form:errors class="validations" path="firstName"/>
				<form:input class="formInput" path="firstName"/>
			</div>
				<form:errors class="validations" path="lastName"/>
			<div class="formGroup">
				<form:label path="lastName">Last Name:</form:label>
				<form:input class="formInput" path="lastName"/>
			</div>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
	<div id="formDiv">
	<h2 class="subHead">License a Person</h2>
		<form:form action="/license" method="post" modelAttribute="license" >
			<div class="formGroup">
				<form:label class="formLabel" path="person">Person:</form:label>
				<form:select class="formInput" path="person">
				<c:forEach items="${allPeople}" var="person">
					<c:choose>
					<c:when test="${person.license == null }">
						<form:option value="${person.id}">${person.firstName} ${person.lastName}</form:option>
					</c:when>
					</c:choose>
				</c:forEach>
				</form:select>
				<form:errors class="validation" path="person"></form:errors>
			</div>
			<div class="formGroup">
				<form:label class="formLabel" path="expirationDate">Exp. Date:</form:label>
				<form:input type="date" class="formInput" path="expirationDate"/>
				<form:errors class="validation" path="expirationDate"></form:errors>
			</div>
			<div class="formGroup">
				<form:label class="formLabel" path="state">State:</form:label>
				<form:input class="formInput" path="state"/>
				<form:errors class="validation" path="state"></form:errors>
			</div>
			<input type="submit" value="Submit"/>
		</form:form>
	</div>
	<div id="infoTable">
		<table>
		<thead>
		<tr>
		<th>First Name</th>
		<th>Last Name</th>
		<th>License #</th>
		</tr>
		<c:forEach items="${allPeople }" var="person">
		<tr>
		<td>${person.firstName}</td>
		<td>${person.lastName}</td>
		<td>${person.license.licenseNumber}</td>
		</tr>
		</c:forEach>
		</thead>
		</table>
	</div>
</div>
</body>
</html>