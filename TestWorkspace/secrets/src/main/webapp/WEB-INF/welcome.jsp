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
		<h1 id="head">Hello ${user.firstName}!</h1>
		<form:form id="inputForm" action="/secrets/new" method="post" modelAttribute="secret">
		        <form:hidden value="${user.id}" path="user"/>
		        <form:errors class="validation" path="secretContent"/>
			<div class="formGroup">
		        <form:input class="formInput" path="secretContent" value="Your Secret Here"/>
		    </div>
	    	<input id="button" type="submit" value="Tell Secret"/>
			</form:form>
		<div id="secretsTable">
			<h2 class="subHead">Recent Secrets...</h2>
			<table>
			<tbody>
			<c:forEach items="${recent}" var="secret">
				<tr>
				<td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${secret.createdAt}" /></td>
				<td class="tData">${secret.secretContent}</td>
				<td class="tData">${secret.usersWhoLike.size()} likes </td>
				<c:choose>
					<c:when test="${user.id == secret.user.id}">
						<td><a class="tLink" href="/secrets/${secret.id}/delete">Delete</a> | </td>
						<c:choose>
						<c:when test="${secret.usersWhoLike.contains(user)}">
						<td><a class="tLink" href="/secrets/${secret.id}/unLike">UnLike</a></td>
						</c:when>
						<c:otherwise>
						<td><a class="tLink" href="/secrets/${secret.id}/like">Like</a></td>
						</c:otherwise>
					</c:choose>
					</c:when>	
					<c:otherwise>
					<c:choose>
						<c:when test="${secret.usersWhoLike.contains(user)}">
						<td><a class="tLink" href="/secrets/${secret.id}/unLike">UnLike</a></td>
						</c:when>
						<c:otherwise>
						<td><a class="tLink" href="/secrets/${secret.id}/like">Like</a></td>
						</c:otherwise>
					</c:choose>
					</c:otherwise>		
				</c:choose>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</t:wrapper>
</body>
</html>