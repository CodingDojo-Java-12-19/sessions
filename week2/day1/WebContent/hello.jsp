<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello</title>
</head>
<body>
	<section>
		<h1>Hello <c:out value="${ name }" /></h1>
		
		<ul>
			<c:forEach var="person" items="${ people }">
				<li><c:out value="${ person }" /></li>
			</c:forEach>
		</ul>
	
	</section>
	
<%! 
	// functions go here 
	
	public int add(int a, int b) {
		return a + b;
	}
%>

<% 
// variables go here

int i = 234;
int j = 345;
%>

<section>
	<h3><%= add(i, j) %></h3>
</section>
</body>
</html>