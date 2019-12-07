<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
</head>
<body>
	<h1>${ monster.name }</h1>
	<blockquote>${ monster.description }</blockquote>
	<h3>Location: ${ monster.location }</h3>
	<ul>
		<c:forEach items="${ monster.abilities }" var="ability">
		<li>${ ability.name }</li>
		</c:forEach>
	</ul>
</body>
</html>