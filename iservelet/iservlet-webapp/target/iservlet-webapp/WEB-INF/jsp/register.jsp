<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/iservlet-webapp/registrationPage" method="post">
	<table border="1" align="center">
		<tr><td><%= request.getAttribute("errorMessage") != null ?  request.getAttribute("errorMessage") : "" %></td></tr>
		<tr>
			<td>First Name</td>
			<td><input type="text" name="firstName" /></td>
		</tr>
		<tr>
			<td>Last Name</td>
			<td><input type="text" name="lastName" /></td>
		</tr>
		<tr>
			<td>Email</td>
			<td><input type="text" name="emailId" /></td>
		</tr>
		<tr>
			<td>Date Of Birth</td>
			<td><input type="date" name="doBirth" /></td>
		</tr>
		<tr>
			<td>Gender</td>
			<td><input type="text" name="gender" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" name="password" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" name="Register" value="Register"/></td>
		</tr>
	</table>
</form>
</body>
</html>