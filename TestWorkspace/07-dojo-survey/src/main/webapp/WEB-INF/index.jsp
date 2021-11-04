<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey</title>
<link rel="stylesheet" href="/css/style.css">
</head>
<body>
	<div id=wrapper>
		<h1>Dojo Survey</h1>
		<div id=formInput>
			<form action="/submit" method="post">
				<p>Your Name: <input id=nameInput name="username" type="text"></p>
	            <p>Dojo Location: <select name="locationInput" id="locationInput">
	                <c:forEach items="${locations }" var="loc">
		                <option>${loc}</option>
	                </c:forEach>
	            </select></p>
	            <p>Favorite Language: <select name="languageInput" id="languageInput">
	                <c:forEach items="${languages }" var="lang">
		                <option>${lang}</option>
	                </c:forEach>
	            </select></p>
	            <p id=comment>Comment (Optional): </p>
	            <textarea id=commentInput name="commentInput" rows=7 cols=40 ></textarea>
	            <button id=button>Submit</button>
        	</form>	
		</div>
	</div>
</body>
</html>