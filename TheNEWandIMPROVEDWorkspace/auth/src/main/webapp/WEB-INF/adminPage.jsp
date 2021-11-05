<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE htmlPUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
<link rel="stylesheet" href="/css/editStyle.css">
</head>
<body>
	<h1>Welcome to the Admin Page <c:out value="${currentUser.username}"></c:out></h1>
	<table>
	<thead>
		<tr>
		<th>ID</th>
		<th>Username</th>
		<th>password</th>
		<th>Initialized</th>
		<th>Updated</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${allUsers}" var="user">
		<tr>
		<td>${user.id}</td>
		<td>${user.username}</td>
		<td>${user.password}</td>
		<td>${user.createdAt}</td>
		<td>${user.updatedAt}</td>
		</tr>
		</c:forEach>
	</tbody>
	</table>
	
	<form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>