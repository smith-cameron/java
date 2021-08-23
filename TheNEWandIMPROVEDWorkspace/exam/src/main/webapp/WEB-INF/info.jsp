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
		<h1 id="head">${idea.ideaContent}!</h1>
		<h2 class="subHead">Created By: ${idea.ideaCreator.firstName} ${idea.ideaCreator.lastName}</h2>
		<h2 class="subHead">Users Who Like Your Idea...</h2>
		<table id="likesTable">
		<tbody>
		<c:forEach items="${likers}" var="user">
			<tr>
			<td class="tData">${user.firstName} ${user.lastName}</td>
			</tr>
		</c:forEach>
		</tbody>
		</table>
	</t:wrapper>
</body>
</html>