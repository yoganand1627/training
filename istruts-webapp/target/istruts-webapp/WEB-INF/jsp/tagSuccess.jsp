<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<font color="red">
<html:errors/>
</font>
<html:form action="/tag" method="post">
	<table border="2" width="100%" height="100%">
		<tr>
			<td>
				<logic:empty name="logicEmpty">
					This is Empty
				</logic:empty>
			</td>
		</tr>
		<tr>
			<td>
				<logic:notEmpty name="listMsg0">
					List is not empty
					<logic:iterate name="listMsg0" id="listid">
						<bean:write name="listid"/>
					</logic:iterate>
				</logic:notEmpty>
			</td>
		</tr>

		<tr>
			<td>
<logic:greaterThan name="number" value="99">
	<h3>Number 100 > 99 = true</h3>
</logic:greaterThan>
 
<h2>Struts - &lt;logic:greaterEqual&gt;</h2>
 
<logic:greaterEqual name="number" value="100">
	<h3>Number 100 >= 100 = true</h3>
</logic:greaterEqual>
 
<h2>Struts - &lt;logic:lessThan&gt;</h2>
 
<logic:lessThan name="number" value="101">
	<h3>Number 100 < 101 = true</h3>
</logic:lessThan>
 
<h2>Struts - &lt;logic:lessEqual&gt;</h2>
 
<logic:lessEqual name="number" value="100">
	<h3>Number 100 <= 100 = true</h3>
</logic:lessEqual>			
			</td>
		</tr>
		
		<tr>
			<td>
<logic:iterate name="listMsg0" id="listMsgId">
<p>
	List Messages <bean:write name="listMsgId"/>
</p>
</logic:iterate>
			</td>
		</tr>
		
		<tr>
			<td>
				<logic:equal name="tagForm" property="emailId" value="google@gmail.com">
	<h3>user's email is equal</h3>
</logic:equal>
 
<h2>Struts - Test &lt;logic:notEqual&gt;</h2>
 
<logic:notEqual name="tagForm" property="emailId" value="google123@gmail.com">
	<h3>user's email is not equal</h3>
</logic:notEqual>
			</td>
		</tr>
		
		<tr>
			<td>
<logic:present name="tagForm" property="url">
	User object, url property is exists.
</logic:present>
<logic:notPresent name="tagForm" property="url">
	User object, url property does not exists.
</logic:notPresent>			
			</td>
		</tr>
		
		<tr>
			<td>
<logic:match name="tagForm" property="emailId" value="google">
	true
</logic:match>
<logic:notMatch name="tagForm" property="emailId" value="google">
	false
</logic:notMatch>			
			</td>
		</tr>
	</table>
</html:form>
</body>
</html>