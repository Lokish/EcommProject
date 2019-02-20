<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@include file="header.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<head>
<meta charset="ISO-8859-1">
</head>
<body>
	<h2 algin="center">Product Page</h2>
	
	<form action="<c:url value ='/UpdateProduct'/>"  method="post">
		<table align="center">
			<tr>
				<td colspan="2">ProductInfo</td>
			</tr>
			<tr>
				<td>ProductID</td>
				<td><input type="text" name="proId"
					value="${product.productid}" /></td>
			</tr>
			<tr>
				<td>ProductName</td>
				<td><input type="text" name="proName"
					value="${product.productName}" /></td>
			</tr>
			<tr>
				<td>ProductDesc</td>
				<td><input type="text" name="proDesc"
					value="${product.productDesc}" /></td>
			</tr>

			<tr>
						<input type="submit" value="Save product" /></td>
				</center>
				</form>
		</table>


	
</body>
</html>
</body>
</html>