<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos & Ninjas</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1 id="title">Dojos & Ninjas</h1>
		<h3 id="subTitle">One to Many Relationships</h3>
		<a class="pageLink" href="/dojo/new">Create Dojo</a>
		<a class="pageLink" href="/ninja/new">Create Ninja</a>
		<div id="inputForm">
			<form action="/" method="post">
			<p id="searchHead">Find Dojo by ID</p>
			<c:choose>
			<input type="number" name="id">
			<input id="searchButton" type="submit" value="Search"/>
			</c:choose>
			</form>
		</div>
	</div>
</body>
</html>