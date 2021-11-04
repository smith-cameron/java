<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Joke</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1>This is <c:out value="${name}"/>'s Joke:</h1>
		<h2><c:out value="${joke}"/></h2>
	</div>
</body>
</html>