<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Index</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<h1>Input Your Joke</h1>
		<form id="form" method="POST" action="/addJoke">
		<p>Name:<input type="text" name="name"></p>
		<p>Joke:<input type="text" name="joke"></p>
		<button>Add Joke</button>
		</form>
	</div>
</body>
</html>