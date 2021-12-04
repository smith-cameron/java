<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Water BnB</title>
<link rel="stylesheet" href="/css/tagStyle.css">
</head>
<body>
	<div id=wrapper>
	<c:choose>
	<c:when test="${currentUserId == 0}">
		<nav id="nav">
		<a class="navLink" href="/login">Sign In</a> | <a class="navLink" href="/register">Sign Up</a>
		</nav>
	</c:when>
	<c:otherwise>
		<nav id="nav">
		<a class="navLink" href="/logOutUser">Logout</a> | <a class="navLink" href="/dash">Home</a>
		</nav>
	</c:otherwise>
	</c:choose>
	<jsp:doBody/>
	</div>
</body>
</html>