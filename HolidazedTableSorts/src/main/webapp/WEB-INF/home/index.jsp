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
	<link rel="stylesheet" href="/css/main.css" />
</head>
<body>
	<div class="container">
		<h1>Holidazed 2020</h1>
		<h2>Login</h2>
		<p>${ error }</p>
		<form method="POST" action="/login">
			<div class="form-group">
		    	<label>Email:</label>
		    	<input class="form-control" type="email" name="email">
		    </div>
		    <div class="form-group">
		    	<label>Password:</label>
		    	<input class="form-control" type="password" name="password">
		    </div>
		    <button class="btn btn-danger">Login</button>
		</form>
		<h2>Register</h2>
		<form:form action="/" method="post" modelAttribute="user">
		    <div class="form-group">
		        <form:label path="firstName">First Name</form:label>
		        <form:errors path="firstName"/>
		        <form:input class="form-control" path="firstName"/>
		    </div>
		    <div class="form-group">
		        <form:label path="lastName">Last Name</form:label>
		        <form:errors path="lastName"/>
		        <form:input class="form-control" path="lastName"/>
		    </div>
		    <div class="form-group">
		        <form:label path="email">Email</form:label>
		        <form:errors path="email"/>
		       <form:input type="email" class="form-control" path="email"/>
		    </div>
		    <div class="form-group">
		        <form:label path="userPassword">Password</form:label>
		        <form:errors path="userPassword"/>
		       <form:input type="password" class="form-control" path="userPassword"/>
		    </div>
		    <div class="form-group">
		        <form:label path="passwordConfirm">Confirm Password</form:label>
		        <form:errors path="passwordConfirm"/>
		       <form:input type="password" class="form-control" path="passwordConfirm"/>
		    </div>
		    <input class="btn btn-danger" type="submit" value="Submit"/>
		</form:form> 
	</div>
</body>
</html>