<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--  -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>    
<!--  -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Create Book</title>
</head>
<body>
<nav>
	<ul>
		<li><a href='/books'>Books</a></li>
		<li><a href='/books/new'>Create Book</a></li>
	</ul>
</nav>

	<section>
		<fieldset>
			<legend>Create Book</legend>
			
	<form:form 
		action="/books" 
		method="post" 
		modelAttribute="book" 
		autocomplete='off'
	>
    <div>
        <form:label path="title">Title</form:label>
        <form:input path="title"/>
        <form:errors path="title"/>
    </div>
    <div>
        <form:label path="publisher">Publisher</form:label>
        <form:input path="publisher"/>
        <form:errors path="publisher"/>
    </div>

    <div>
        <form:label path="pages">Pages</form:label>
        <form:input type="number" path="pages"/>
        <form:errors path="pages"/>     
    </div>    
    <input type="submit" value="Submit"/>
</form:form>    
			
			
<!-- 			<form action='/books' method='post' autocomplete='off'>
				<div>
					<label>Title</label>
					<input type='text' name='title'>
				</div>
				<div>
					<label>Pages</label>
					<input type='number' name='pages'>
				</div>
				<div>
					<label>Publisher</label>
					<input type='text' name='publisher'>
				</div>
				<button>Submit</button>
			</form> -->
		</fieldset>
		
	</section>
</body>
</html>