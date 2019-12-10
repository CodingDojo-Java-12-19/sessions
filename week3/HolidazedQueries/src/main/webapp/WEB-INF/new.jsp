<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
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
		<h1>Create a new Monster!</h1>
		<form:form action="/" method="post" modelAttribute="monster">
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
		    <input type="submit" value="Submit"/>
		</form:form> 
	</div>
</body>
</html>