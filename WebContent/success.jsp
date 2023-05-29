<%@page import="com.wileyedge.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Success!</title>
</head>
<body>
	<% Student s = (Student) request.getAttribute("student");%>

	<h1>Registration Successful</h1>
	<p>
		Your details are:<br> Name:
		<%= s.getName()%><br> Age:
		<%= s.getAge()%><br> Mobile Number:
		<%= s.getMobile()%><br> Address:
		<%= s.getAddress()%></p>

</body>
</html>