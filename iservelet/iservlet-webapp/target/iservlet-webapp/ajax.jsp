<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
function getStatesData(){
	var countryCode = document.getElementById('countryCode').value;
	//alert(countryCode);
 	var xmlHttp = new XMLHttpRequest();
 	
	xmlHttp.onreadystatechange=function() {
 		
		if (xmlHttp.readyState==4 && xmlHttp.status==200) {
			alert(xmlHttp.responseText);
		}
	}
	
	//alert(countryCode);
 	
 	xmlHttp.open("GET","/iservlet-webapp/ajaxRequest?countryCode="+countryCode,true);
 	xmlHttp.send();
}
</script>
</head>
<body>
	<table>
		<tr>
			<td>Country:</td>
			<td><input type="text" name="countryCode" id="countryCode" onblur="getStatesData()"/></td>
			<td><input type="button" value="Get Data" onclick="getStatesData()"/></td>
		</tr>
	</table>
</body>
</html>