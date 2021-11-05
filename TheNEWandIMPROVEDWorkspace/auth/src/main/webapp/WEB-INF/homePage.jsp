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
	<h1>Welcome</h1>
    <table>
    <tbody>
    	<tr>
    	<td><h2>ID: </h2></td>
    	<td><h2>${currentUser.id}</h2></td>
    	</tr>
    	<tr>
    	<td><h2>Username: </h2></td>
    	<td><h2>${currentUser.username}</h2></td>
    	</tr>
    	<tr>
    	<td><h2>Initialized: </h2></td>
    	<td><h2>${currentUser.createdAt}</h2></td>
    	</tr>
    </tbody>
    </table>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Logout!" />
    </form>
</body>
</html>