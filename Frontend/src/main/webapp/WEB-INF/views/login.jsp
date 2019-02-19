<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@include file="header.jsp"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>

	<br/><br/><br/><br/><br/><br/>
	<form action="LoginCheck" method="post">
	<table align="center" width="40%">
		<tr bgcolor="black">
			<td colspan="2"><font color="white">Sign In Here</font> </td>
		</tr>
		<tr bgcolor="gray">
		<td>Login</td><td><input type="text" name="loginname"/></td>
		</tr>
		<tr bgcolor="gray">
		<td>Password</td><td><input type="password" name="passwd"/></td>
		</tr>
		<tr bgcolor="gray">
		<td colspan="2">
		<input type="submit" value="Login"/><input type="reset" value="Reset"/>
		</td>
		</tr>
	</table>
	</form>


</body>
</html>