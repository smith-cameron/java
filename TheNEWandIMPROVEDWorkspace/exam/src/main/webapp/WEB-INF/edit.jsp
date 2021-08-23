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
	<t:wrapper>
		<h1 id="head">${idea.ideaContent}</h1>
		
		<form:form id="inputForm" action="/idea/${idea.id}/edit" method="post" modelAttribute="idea">
		        <form:hidden value="${idea.ideaCreator.id}" path="ideaCreator"/>
		        <form:errors class="validation" path="ideaContent"/>
			<div class="formGroup">
		        <form:input class="formInput" path="ideaContent" value="${idea.ideaContent}"/>
		    </div>
	    	<input id="button" type="submit" value="Submit"/>
			</form:form>
			<a id="deleteLink" href="/idea/${idea.id}/delete">Delete</a>
	</t:wrapper>
</body>
</html>