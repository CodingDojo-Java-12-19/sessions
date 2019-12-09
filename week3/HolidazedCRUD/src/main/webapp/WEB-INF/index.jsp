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
		<h1>Holidazed 2020</h1>
		<nav>
			<a href="/new">Create a New Monster</a>
		</nav>
		<h2>My Monsters!</h2>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Name</th>
					<th>Location</th>
					<th>Likes</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ monsters }" var="monster">
				<tr>
					<td><a href="/${ monster.id }">${ monster.name }</a></td>
					<td>${ monster.location }</td>
					<td>${ monster.userLikes.size() }</td>
					<td>
						<c:choose>
							<c:when test="${ monster.userLikes.contains(user) }">
								<a class="btn btn-danger" href="/dislike/${ monster.id }">Dislike It</a>
							
							</c:when>
							<c:otherwise>
								<a class="btn btn-primary" href="/like/${ monster.id }">Like It</a>
							</c:otherwise>
						</c:choose>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>