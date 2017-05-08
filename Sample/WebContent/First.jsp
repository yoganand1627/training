<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<H1> asdASDAS</H1>

<%! int i = 10;
    int j = 20;
    
    String getName() {
    	return "Sunil";
    }
    	%>    
    	
    <% session.setAttribute("Name", "Suneel");
    
    System.out.println("asdASDasdasd"); %>
    <%=session.getAttribute("Name") %>
   
    
Value of x:<%=(i+j) %>
Value of NAme:<%=getName() %>
</body>
</html>