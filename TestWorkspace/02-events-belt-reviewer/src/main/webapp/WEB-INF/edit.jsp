<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${thisEvent.eventName}</title>
<link rel="stylesheet" href="/css/editStyle.css">
</head>
<body>
	<div id=wrapper>
	<a id="wallLink" href="/events">All Events</a>
		<h1 id="head">${thisEvent.eventName}</h1>
		<form:form id="inputForm" action="/events/${thisEvent.id}/edit" method="post" modelAttribute="event">
		        <form:hidden value="${currentUser.id}" path="host"/>
		        <form:errors class="validation" path="eventName"/>
			<div class="formGroup">
		        <form:label class="formLabel" path="eventName">Name:</form:label>
		        <form:input class="formInput" path="eventName" value="${thisEvent.eventName}"/>
		    </div>
		        <form:errors class="validation" path="eventLocation"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="eventLocation">Location:</form:label>
		        <form:input class="formInput" path="eventLocation" value="${thisEvent.eventLocation}"/>
		    </div>
		        <form:errors class="validation" path="eventDate"/>
		    <div class="formGroup">
		        <form:label class="formLabel" path="eventDate">Date:</form:label>
		        <form:input type="date" path="eventDate" value="${thisEvent.eventDate}"/>
		    </div>
		    <form:errors class="validation" path="eventState"/>
				<div class="formGroup">
					<form:label path="eventState">State:</form:label>
					<form:select class="formInput" path="eventState">
						<form:option value="${thisEvent.eventState}" selected="True">${thisEvent.eventState}</form:option>
						<form:option value="NUll" disabled="True">-- Change State --</form:option>
						<c:forEach items="${theStates}" var="state">
							<form:option value="${state}">${state}</form:option>
						</c:forEach>
					</form:select>
				</div>
	    	<input id="button" type="submit" value="UpDate Event"/>
			</form:form>
	</div>
</body>
</html>