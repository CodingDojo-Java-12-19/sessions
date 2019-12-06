<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Books</title>
</head>
<body>
<nav>
	<ul>
		<li><a href='/books'>Books</a></li>
		<li><a href='/books/new'>Create Book</a></li>
	</ul>
</nav>

	<h1>Books</h1>
	
	
	<section>
	
		<table>
			<thead>
				<tr>
					<th>Title</th>
					<th>Pages</th>
					<th>Publisher</th>
					<th>Cover Art</th>
					<th>Actions</th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var='book' items='${ books }'>
					<tr>
						<td><a href="/books/${ book.id }">${ book.title }</a></td>
						<td>${ book.pages }</td>
						<td>${ book.publisher }</td>
						<td>${ book.cover.description }</td>
						<td>Future Actions</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
		<h2>Add A Book Cover!</h2>
		<form:form 
			action="/books/cover" 
			method="post" 
			modelAttribute="newCover" 
			autocomplete='off'>
			<div>
		        <form:label path="description">Description</form:label>
		        <form:input path="description"/>
		        <form:errors path="description"/>
	    	</div>
	    	<div>
		        <form:label path="color">Color</form:label>
		        <form:input path="color"/>
		        <form:errors path="color"/>
	    	</div>
	    	<div>
		        <form:label path="book">Book</form:label>
		        <form:select path="book">
		        <c:forEach var='book' items='${ books }'>
					<option value="${ book.id }">${ book.title }</option>
				</c:forEach>
		        </form:select>
		        <form:errors path="book"/>
	    	</div>
	    	<button>Create Cover!</button>
		</form:form>
	</section>
</body>
</html>