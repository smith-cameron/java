<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEARCH</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
<t:navWrap>
	<h1 id="head">Find places to swim and sleep on Water BnB</h1>
	<div class="formGroup">
	<form action="" method="post">
		<input type="search" class="formInput" name="address" placeholder="Search Locations"/>
		<button type="submit">Search</button>
	</form>
	</div>
</t:navWrap>
</body>
</html>