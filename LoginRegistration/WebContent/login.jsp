<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="style.css">
	<meta charset="ISO-8859-1">
	<title>Login</title>
</head>
<body>
	<div class="login-form">
		<h1>Login Form</h1>
		<form action="sendLoginDetails" method="POST">
			<div style="color: #FF0000;">${errorMessage}</div>
			<div style="color: #00FF00;">${successMessage}</div>
			<input type="text" name="username" placeholder="Username" required>
			<input type="password" name="password" placeholder="Password"
				required> <input type="submit" value="Login">
		<hr>
		</form>
			<form action="register.jsp" method="GET">
			<input type="submit" value="Register">
		</form>
	</div>
</body>
</html>