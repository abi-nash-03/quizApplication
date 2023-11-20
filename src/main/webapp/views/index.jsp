<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Quiz Application</title>
</head>
<body>
	Welcome to Quiz Application
	What type of Quiz You're Intrested
	<form action="quizByType">
		<select name = "type" id = "type">
		<option value = 'Java'> Java </option>
		<option value="Python"> Python </option>
		</select>
		<input type= "submit" value="submit">	
	
	</form>
	
	
	
	<form action="addUser" method = "post">
	<!--  Enter ID : <input type="text" name="id"> <br>
	Enter name : <input type="text" name="name"> <br>
	Enter age : <input type="text" name="age"> <br>
	<input type="submit">-->
	</form>
</body>
</html>