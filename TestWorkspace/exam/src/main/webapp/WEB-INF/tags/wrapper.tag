<%@ tag language="java" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java Exam</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
	<nav>
	<a id="logoutLink" href="/logOutUser">Logout</a> | <a class="pageLink" href="/idea/new">New Idea</a> | <a class="pageLink" href="/welcome">Home</a>
	</nav>
	<jsp:doBody/>
	</div>
</body>
</html>