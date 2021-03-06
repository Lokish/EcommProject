<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@include file="header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<br/><br/>
<form:form action="InsertProduct" modelAttribute="product" method="post">
<table align="center" class="table-bordered">
<tr>
     <td colspan="2"><h2>Product Info </h2></td>
</tr>
<tr>
    <td>Product Name</td>
    <td><form:input path="productName"/></td>
</tr>
<tr>
    <td>Price</td>
    <td><form:input path="price"/></td>
</tr>
<tr>
    <td>Stock</td>
    <td><form:input path="stock"/></td>
</tr>
<tr>
    <td>Category</td>
    <td>
    <form:select path="categoryId">
    <form:option value="0" label="--Select List--"/>
    <form:options items="${categoryList}"/>
    </form:select>
    </td>
</tr>
<tr>
    <td>SupplierID</td>
    <td><form:input path="supplierId"/></td>
</tr>
<tr>
    <td>Product Desc</td>
    <td><form:input path="productDesc"/></td>
</tr>
<tr>
    <td colspan="2"><center><input type="submit" value="SaveProduct"/></center></td>
</tr>

<table align="center" border="2">
				<tr>
					<td>Product Id</td>
					<td> Product Name</td>
					<td>Product Desc</td>
					
					<td> CategoryId</td>
					<td>Price</td>
					<td>Stock</td>
					<td>SuplierId</td>
					<td>Operation</td>
				</tr>
				<c:forEach items="${productList}" var="product">
					<tr>
						<td>${product.productid}</td>
						
						<td>${product.productName}</td>
						<td>${product.productDesc}</td>
						<td>${product.categoryId}</td>
						<td>${product.price}</td>
						<td>${product.stock}</td>
						<td>${product.supplierId }</td>
					<td>
						
						
						<a href="<c:url value="/editProduct/${product.productid}"/>"> Edit</a>
							<a href="<c:url value="/deleteProduct/${product.productid}"/>"> Delete</a>
						</td>
					</tr>
				</c:forEach>
	
			</table>
			
			</form>

</table>
</form:form>
</body>
</html>