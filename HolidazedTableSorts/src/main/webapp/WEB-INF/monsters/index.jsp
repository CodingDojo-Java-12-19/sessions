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
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class="container">
		<h1>Holidazed 2020</h1>
		<nav>
			<h2>Sup ${ user.firstName }</h2>
			<a href="/monsters/new">Create a New Monster</a>
		</nav>
		<h2>My Monsters!</h2>
		<form action="/monsters/search">
			<input type="text" name="search" id="" placeholder="Search For Monster:" />
			<button>Search</button>
		</form>
		<a href="/monsters/order">Order By Most Powerful</a>
		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Name <a href="/monsters/sort/name">^</a></th>
					<th>Location <a href="/monsters/sort/location">^</a></th>
					<th>Likes <a href="/monsters/sort/likes">^</a></th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${ monsters }" var="monster">
				<tr>
					<td><a href="/monsters/${ monster.id }">${ monster.name }</a></td>
					<td>${ monster.location }</td>
					<td>${ monster.userLikes.size() }</td>
					<td>
						<c:choose>
							<c:when test="${ monster.userLikes.contains(user) }">
								<a class="btn btn-danger" href="/monsters/dislike/${ monster.id }">Dislike It</a>
							
							</c:when>
							<c:otherwise>
								<a class="btn btn-primary" href="/monsters/like/${ monster.id }">Like It</a>
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