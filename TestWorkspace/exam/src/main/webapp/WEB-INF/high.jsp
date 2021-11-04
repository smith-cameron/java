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
		<h1 id="head">All Ideas Sorted by Highest Likes First</h1>
		<div id="ideasTable">
			<table>
			<thead>
			<tr>
			<td class="tData">Created At</td>
			<td class="tData">Idea</td>
			<td class="tData">Created By</td>
			<td class="tData">Likes</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${popular}" var="idea">
				<tr>
				<td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${idea.createdAt}" /></td>
				<td class="tData"><a class="tLink" href="/idea/${idea.id}/info"> ${idea.ideaContent}</a></td>
				<td class="tData">${idea.ideaCreator.firstName}</td>
				<td class="tData">${idea.usersWhoLike.size()}</td>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</t:wrapper>
</body>
</html>