<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
	<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<div class="container">
		<h1>${ monster.name }</h1>
		<blockquote>${ monster.description }</blockquote>
		<h3>Location: ${ monster.location }</h3>
		<ul>
			<c:forEach items="${ monster.abilities }" var="ability">
			<li>${ ability.name }</li>
			</c:forEach>
		</ul>
		<h4>Users that liked this Monster:</h4>
		<ul>
			<c:forEach items="${ monster.userLikes }" var="user">
				<li>${ user.firstName }</li>
			</c:forEach>
		</ul>
		<hr />
		<form action="/${monster.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input class="btn btn-danger" type="submit" value="Delete">
		</form>
	</div>
</body>
</html>