<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
com.naveltech.iservlet.model.User user = (com.naveltech.iservlet.model.User)request.getAttribute("userObject");
pageContext.setAttribute("userObject", user);
%>
<body>
	Successfully Logged in. What you what to do now????
	<c:out value="${userObject.firstName}"/>
	<%=user.getFirstName() %>
</body>
</html>