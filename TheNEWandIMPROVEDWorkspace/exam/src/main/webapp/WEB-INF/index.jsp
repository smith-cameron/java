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
<title>Exam</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<t:wrapper>
		<h1 id="head">Hello ${currentUser.firstName}!</h1>
			<h2 class="subHead">All The Ideas...</h2>
			<div id="likesLinks">
			<a class="tLink" href="/idea/high">Best Ideas</a> | <a class="tLink" href="/idea/low">Worst Ideas</a>
			</div>
		<div id="ideasTable">
			<table>
			<thead>
			<tr>
			<td class="tData">Created At</td>
			<td class="tData">Idea</td>
			<td class="tData">Created By</td>
			<td class="tData">Likes</td>
			<td class="tData">Actions</td>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${allIdeas}" var="idea">
				<tr>
				<td><fmt:formatDate type = "both" dateStyle = "short" timeStyle = "short" value = "${idea.createdAt}" /></td>
				<td class="tData"><a class="tLink" href="/idea/${idea.id}/info"> ${idea.ideaContent}</a></td>
				<td class="tData">${idea.ideaCreator.firstName}</td>
				<td class="tData">${idea.usersWhoLike.size()}</td>
				<c:choose>
					<c:when test="${currentUser.id == idea.ideaCreator.id}">
						<td class="tData"><a class="tLink" href="/idea/${idea.id}/edit">Edit</a></td>
						<c:choose>
						<c:when test="${idea.usersWhoLike.contains(currentUser)}">
						<td class="tData"><a class="tLink" href="/idea/${idea.id}/unLike">UnLike</a></td>
						</c:when>
						<c:otherwise>
						<td class="tData"><a class="tLink" href="/idea/${idea.id}/like">Like</a></td>
						</c:otherwise>
					</c:choose>
					</c:when>	
					<c:otherwise>
					<c:choose>
						<c:when test="${idea.usersWhoLike.contains(currentUser)}">
						<td class="tData"><a class="tLink" href="/idea/${idea.id}/unLike">UnLike</a></td>
						</c:when>
						<c:otherwise>
						<td class="tData"><a class="tLink" href="/idea/${idea.id}/like">Like</a></td>
						</c:otherwise>
					</c:choose>
					</c:otherwise>		
				</c:choose>
<%-- 				<c:choose> --%>
<%-- 					<c:when test="${currentUser.id == idea.ideaCreator.id}"> --%>
<%-- 						<td class="tData"><a class="tLink" href="/idea/${idea.id}/edit">Edit</a></td> --%>
<%-- 						<c:choose> --%>
<%-- 						<c:when test="${idea.usersWhoLike.contains(currentUser)}"> --%>
<%-- 						<td class="tData"><a class="tLink" href="/idea/${idea.id}/unLike">UnLike</a></td> --%>
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 						<td class="tData"><a class="tLink" href="/idea/${idea.id}/like">Like</a></td> --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
<%-- 					</c:when>	 --%>
<%-- 					<c:otherwise> --%>
<%-- 					<c:choose> --%>
<%-- 						<c:when test="${idea.usersWhoLike.contains(currentUser)}"> --%>
<%-- 						<td class="tData"><a class="tLink" href="/idea/${idea.id}/unLike">UnLike</a></td> --%>
<%-- 						</c:when> --%>
<%-- 						<c:otherwise> --%>
<%-- 						<td class="tData"><a class="tLink" href="/idea/${idea.id}/like">Like</a></td> --%>
<%-- 						</c:otherwise> --%>
<%-- 					</c:choose> --%>
<%-- 					</c:otherwise>		 --%>
<%-- 				</c:choose> --%>
				</tr>
			</c:forEach>
			</tbody>
			</table>
		</div>
	</t:wrapper>
</body>
</html>