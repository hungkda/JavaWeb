<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.Random,java.text.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Sử dụng Random</h1>
	<hr/>
	<%
		Random random = new Random();
		int randomInt = random.nextInt();
		if (randomInt == 0) {
	%>
		<h1>Random value =<%=randomInt%></h1>
	<%
		} else if (randomInt == 1) {
	%>
		<h2>Random value =<%= randomInt%></h2>
	<%
	} else {
	%>
		<h3>Random value =<%= randomInt%></h3>
	<%
		}
	%>
	<a href="<%= request.getRequestURI() %>">Try Again</a>
</body>
</html>