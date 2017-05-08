<%@taglib uri="http://struts.apache.org/tags-bean" prefix="bean"%>
<%@taglib uri="http://struts.apache.org/tags-html" prefix="html"%>
<%@taglib uri="http://struts.apache.org/tags-logic" prefix="logic"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>EPOS Products</title>
<script type="text/javascript">
function formSubmit(action){
	document.forms[0].action = "/istruts-webapp/product.do?method="+action;
	document.forms[0].submit();
}
</script>
</head>
<body>
<html:form action="/product" method="post">
<table>
 		<html:hidden property="formAction" value="LOGIN"/>
		<tr><td><bean:message key="label.product.productId"/></td><td><html:text property="productId"/></td>
		<td><bean:message key="label.product.productName"/></td><td><html:text property="productName"/></td>
        <td><bean:message key="label.product.code"/></td><td><html:text property="productCode"/></td></tr>
        <tr><td><bean:message key="label.product.description"/></td><td><html:text property="description"/></td>
        <td><bean:message key="label.product.price"/></td><td><html:text property="productPrice"/></td>

		<td><html:button onclick="formSubmit('create')" property="create">Create </html:button></td>
		<td><html:button onclick="formSubmit('update')" property="update">Update</html:button></td>
		<td><html:button onclick="formSubmit('search')" property="search">Search </html:button></td>
		</tr></table>

</html:form>

</body>
</html>