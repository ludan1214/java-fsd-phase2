<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="phase2.server.User"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="style.css">
<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
<ul>
  <li><a href="dashboard">Dashboard</a></li>
  <li><a href="logout">Logout</a></li>
</ul>
<h1>
<% User user = (User) request.getAttribute("user");
 	out.print("Hello, " + user.getFirstname() + "!");
%>
</h1>
</body>
</html>