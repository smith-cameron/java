<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix = "t" tagdir = "/WEB-INF/tags" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Water BnB</title>
<link rel="stylesheet" href="/css/tagStyle.css">
</head>
<body>
	<div id=wrapper>
	<nav>
	<a class="pageLink" href="/logout">Logout</a>
	</nav>
	<jsp:doBody/>
	</div>
</body>
</html>