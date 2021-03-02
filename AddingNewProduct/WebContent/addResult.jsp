<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@page language="java" import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="style.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Post Results</title>
</head>
<body>

<p><strong>Enter Product Details to Add to the Database</strong></p>
<form action="/AddingNewProduct/addProduct" method="POST">
		Product Name: <input type="text" name="product_name"> <br />
		Product Details: <input type="text" name="product_details" /> <br><input type="submit"
			value="Submit" />
</form>

<table id = "product_table">
	<tr>
  	 	<th>Id</th>
  	 	<th>Name</th>
   	 	<th>Details</th>
	</tr>
	<c:forEach items="${products}" var="product">
    <tr>
      <td><c:out value="${product.id}" /></td>
      <td><c:out value="${product.name}" /></td>
      <td><c:out value="${product.details}" /></td>
    </tr>
  </c:forEach>
</table>

</body>
</html>