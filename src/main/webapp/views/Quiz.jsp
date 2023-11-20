<%@page import="java.util.List"%>
<%@page import="com.project.model.Questions"%>
<%@page import="org.springframework.ui.Model"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
Quiz questions


<!--  <form action="validateAns">  -->

<% List<Questions> qsn = (List<Questions>)request.getAttribute("quizQuestions");
	boolean isCompleted = (boolean)request.getAttribute("completed");
	for(int i=0;i<qsn.size();i++){
		String ans = qsn.get(i).getAnswer();
		%> 
	<br>
		<% out.print(qsn.get(i).getQuestion());%><br>
		<input type="radio"id="option1" value="<% qsn.get(i).getOption1();%>" name="answer">
		<% out.print(qsn.get(i).getOption1());%><br>
		<input type="radio"id="option2" value="<% qsn.get(i).getOption1();%>" name="answer">
		<% out.print(qsn.get(i).getOption2());%> <br>
		<input type="radio"id="option3" value="<% qsn.get(i).getOption1();%>" name="answer">
		<% out.print(qsn.get(i).getOption3());%> <br>
		<input type="radio" id="option4" value="<% qsn.get(i).getOption1();%>" name="answer">
		<% out.print(qsn.get(i).getOption4());%> <br>
		<input type="button" value="show answer" onclick="showAnswer()">
		<p id="showAns"></p>
		

	<%}
%>
<input type="submit" value="submit">


<!--  </form>   -->

	
</body>
</html>