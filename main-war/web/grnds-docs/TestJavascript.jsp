<%@ page import="java.util.Enumeration"%>
<!DOCTYPE HTML PUBLIC "-//IETF//DTD HTML//EN">
<html>
<head>
<title>Test Javascript</title>
</head>

<body>
<h1>Test Browser's Javascript support</h1>

<script language="javascript">
function testWindowOpen()
{
  window.open("http://www.google.com/");
}


function testAlert()
{
  alert("you just tested alert");
}


function testConfirm()
{
  confirm("testing confirm; click Ok or Cancel");
}


function testOnUnload()
{
  window.onbeforeunload = testWindowOpen;
  location.href = "TestJavascript.jsp";
}
</script>

<pre>
<%
Enumeration enumeration = request.getHeaderNames();
while (enumeration.hasMoreElements())
{
  String name = (String) enumeration.nextElement();
  out.println(name + ": " + request.getHeader(name));
}
%>

<a href="javascript:testWindowOpen();">Click to Test pop-up window</a>

<a href="javascript:testAlert();">Click to Test alert</a>

<a href="javascript:testConfirm();">Click to Test confirm</a>

<a href="javascript:testOnUnload();">Click to Test onBeforeUnload</a>
</pre>


<hr>
<address></address>
<!-- hhmts start -->
<!-- hhmts end -->
</body> </html>
