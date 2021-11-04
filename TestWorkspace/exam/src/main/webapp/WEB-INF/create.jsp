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
<title>New Ideas!</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<t:wrapper>
		<h1 id="head">Create a New Idea</h1>
		<form:form id="inputForm" action="/idea/new" method="post" modelAttribute="idea">
		        <form:hidden value="${currentUser.id}" path="ideaCreator"/>
		        <form:errors class="validation" path="ideaContent"/>
			<div class="formGroup">
		        <form:input class="formInput" path="ideaContent" value="Your Idea Here"/>
		    </div>
	    	<input id="button" type="submit" value="Submit"/>
			</form:form>
	</t:wrapper>
</body>
</html>