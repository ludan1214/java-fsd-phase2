<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link href="style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Adding Product Details</title>
</head>
<body>
	<p><strong>Enter Product Details to Add to the Database</strong></p>
	<form action="/AddingNewProduct/addProduct" method="POST">
		<div style="color: #FF0000;">${errorMessage}</div>
		Product Name: <input type="text" name="product_name"> <br />
		Product Details: <input type="text" name="product_details" /> <br> <input type="submit"
			value="Submit" />
	</form>
</body>
</html>