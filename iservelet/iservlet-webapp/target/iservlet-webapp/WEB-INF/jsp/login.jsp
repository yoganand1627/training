<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/iservlet-webapp/homePage" method="post">
	<table border="1" align="center">
		<tr><td><%= request.getAttribute("errorMessage") != null ?  request.getAttribute("errorMessage") : "" %></td></tr>
		<tr>
			<td>Email Id:</td>
			<td><input type="text" name="emailIdField" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="passwordField" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="Login" value="Log In"/></td>
		</tr>
		<tr>
			<td colspan="2"><a href="/iservlet-webapp/registrationPage">Register?</a></td>
		</tr>
	</table>
</form>
</body>
</html>