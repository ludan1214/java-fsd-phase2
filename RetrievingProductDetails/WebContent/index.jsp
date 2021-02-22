<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>
Retrieving the Product Details Using the Product ID</title>
</head>
<body>
		<form action="searchProduct" method="post">
    		Enter the Product ID to search: <input type="text" name="productID" size="20">
    		<input type="submit" value="Call Servlet" />
		</form>
</body>
</html>