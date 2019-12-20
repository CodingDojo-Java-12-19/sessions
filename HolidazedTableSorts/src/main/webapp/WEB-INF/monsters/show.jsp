<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Holidazed 2020</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
		rel="stylesheet" 
		integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
		crossorigin="anonymous">
	<link href="https://fonts.googleapis.com/css?family=Sunshiney&display=swap" rel="stylesheet"> 
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class="container">
		<h1>${ monster.name }</h1>
		<blockquote>${ monster.description }</blockquote>
		<h3>Location: ${ monster.location }</h3>
		<ul>
			<c:forEach items="${ monster.abilities }" var="ability">
			<li>${ ability.name } (${ ability.powerLevel } Powers)</li>
			</c:forEach>
		</ul>
		<hr />
		<h2>Add Ability</h2>
		<form:form action="/monsters/abilities" method="post" modelAttribute="ability">
		    <form:input type="hidden" path="monster" value="${ monster.id }"/>
		    <div class="form-group">
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="powerLevel">Power Level</form:label>
		        <form:errors path="powerLevel"/>
		        <form:input class="form-control" path="powerLevel"/>
		    </div>
		    <div class="form-group">
		        <form:label path="isFatal">Can it KILL YOU?</form:label>
		        <form:errors path="isFatal"/>
		        <form:select class="form-control" path="isFatal">
		        	<option value="${ true }">Yes, it will DECIMATE YOU</option>
		        	<option value="${ false }">Nah, ur good.</option>
		        </form:select>
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea class="form-control" path="description"></form:textarea>
		    </div>
		    <input class="btn btn-warning" type="submit" value="Add"/>
		</form:form> 
		<h4>Users that liked this Monster:</h4>
		<ul>
			<c:forEach items="${ monster.userLikes }" var="user">
				<li>${ user.firstName }</li>
			</c:forEach>
		</ul>
		<hr />
		<h3>Update the Monster</h3>
		<form:form action="/monsters/${ monster.id }" method="post" modelAttribute="monster">
		    <input type="hidden" name="_method" value="put">
		    <div class="form-group">
		        <form:label path="name">Name</form:label>
		        <form:errors path="name"/>
		        <form:input class="form-control" path="name"/>
		    </div>
		    <div class="form-group">
		        <form:label path="location">Location</form:label>
		        <form:errors path="location"/>
		        <form:input class="form-control" path="location"/>
		    </div>
		    <div class="form-group">
		        <form:label path="description">Description</form:label>
		        <form:errors path="description"/>
		        <form:textarea class="form-control" path="description"></form:textarea>
		    </div>
		    <input class="btn btn-warning" type="submit" value="Update"/>
		</form:form> 
		<form action="/monsters/${monster.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input class="btn btn-danger" type="submit" value="Delete">
		</form>
	</div>
</body>
</html>