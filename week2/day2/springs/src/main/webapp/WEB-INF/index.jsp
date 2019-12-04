<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!--  -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring Hello</title>
</head>
<body>
	<h1>Hello ${ personName }</h1>
	
	<section>
		<fieldset>
			<legend>Names</legend>
			
			<form action='/names' method='post' autocomplete='off'>
				<div>
					<label>Name</label>
					<input type='text' name='person_name'>
				</div>
				
				<button>Submit</button>
			</form>
		</fieldset>
	</section>
</body>
</html>