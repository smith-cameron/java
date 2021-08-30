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
<title>Classes</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div id="wrapper">
	<a class="link" href="/dorms">Dormitories</a>
	<a class="link" href="/students/new">New Student</a>
	<a class="link" href="/contacts/new">New Contact</a>
	<a class="link" href="/students">Home</a>
	<h1 id="head">New Stack</h1>
	<div id="inputForm">
		<form:form id="inputForm" action="/stack/new" method="post" modelAttribute="stack">
	        <form:errors class="validation" path="name"/>
		<div class="formGroup">
	        <form:label class="formLabel" path="name">Stack Name:</form:label>
	        <form:input class="formInput" path="name"/>
	    </div>
    	<input id="button" type="submit" value="Submit"/>
		</form:form>
	</div>
	<div id="dormTable">
	<h2>All Stacks</h2>
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