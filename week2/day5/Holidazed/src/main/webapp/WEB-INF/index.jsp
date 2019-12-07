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
	<h1>Holidazed</h1>
	<h2>My Monsters!</h2>
	<ul>
	<c:forEach items="${ monsters }" var="monster">
		<li>${ monster.name }</li>
	</c:forEach>
	</ul>
</body>
</html>