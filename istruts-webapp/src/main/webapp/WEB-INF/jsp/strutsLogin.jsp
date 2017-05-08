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
<html:form action="/login" method="post">
	<table>
		<html:hidden property="formAction" value="LOGIN"/>
		<tr><td><bean:message key="label.user.name"/></td><td><html:text property="firstName"/></td></tr>
		<tr><td><bean:message key="label.user.username"/></td><td><html:text property="lastName"/></td></tr>
		<tr><td><bean:message key="label.user.radio.gender"/></td></tr>
		<tr><td><bean:message key="label.user.radio.gender.male"/></td><td><html:radio property="gender" value="Male"/></td>
		<td><bean:message key="label.user.radio.gender.female"/></td><td><html:radio property="gender" value="Female"/></td></tr>
		<tr><td><bean:message key="label.login.email"/></td><td><html:text property="emailId"/></td></tr>
		<tr><td><bean:message key="label.login.password"/></td><td><html:password property="password"/></td></tr>
		<tr><td><bean:message key="label.user.pwd2"/></td><td><html:password property="password"/></td></tr>
		<tr><td colspan="2"><html:submit><bean:message key="label.login.button.submit"/></html:submit></td></tr>
	</table>
</html:form>
</body>
</html>