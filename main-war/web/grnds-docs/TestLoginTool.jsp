<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>


<html>
<head>
  <title>
    Test Login Tool
  </title>
</head>

<body>

<%
  //If a request has been submitted, try to authenticate to the specified server
  if (StringHelper.isValid(request.getParameter("username")) &&
      StringHelper.isValid(request.getParameter("password")) &&
      StringHelper.isValid(request.getParameter("authServer"))) {
    // FIXME: This needs to be written
    /*
    try
    {
      com.linar.jintegra.NTLMAuthenticate.validate(request.getParameter( "authServer" ),
          DOMAIN,
          request.getParameter( "username" ),
          request.getParameter( "password" ));
      out.println("Successful Connection to authentication server: " + request.getParameter( "authServer" ) + "<br>");
      out.println("Username and Password are valid.<br>");
    }
    //If successful connection to NT server and password is found to be invalid, throw the exception.
    catch (SecurityException se)
    {
      out.println("Successfully connected to authentication server: " + request.getParameter( "authServer" ) );
      out.println("<br>Security Exception. Invalid username or password.");

    }
    //If there was an error connecting to the NT PDC(Authentication Server), try a different server.
    catch (IOException e)
    {
      out.println("Could not connect to authentication server: " + request.getParameter( "authServer" ) );
    }
    */
  } else if (StringHelper.isValid(request.getParameter("changeAuth"))) {
    //Switch the value of the indicator
    //noinspection AssignmentToStaticFieldFromInstanceMethod
    UserProfileHelper.ACTIVE_DIRECTORY_AUTH = !UserProfileHelper.ACTIVE_DIRECTORY_AUTH;
  }

%>
<h1>
  Test Authentication
</h1>

<form action="#" method="post">
  <br>
  UserName: <input type="text" name="username"><br>
  Password: <input type="password" name="password"><br>
  <br>
  <select name="authServer">
    <%
      for (int i = 0; i < 3; i++) {
        out.println("<option value=\"" + UserProfileHelper.SUN_SERVER_IP[i] + "\">Server " +
                    (i + 1) + " IP: " + UserProfileHelper.SUN_SERVER_IP[i] + "</option>");
      }
    %>
  </select>
  <br>
  <input type="submit" name="Submit" value="Submit">
  <input type="reset" value="Reset">
</form>
<br/>

<form action="#" method="post">
  <br>
  Current Authentication: <%= UserProfileHelper.ACTIVE_DIRECTORY_AUTH ? "Active Directory" : "NTLM"  %>
  <br>
  <input type="submit" name="changeAuth" value="Change Auth"><br>
</form>

</body>
</html>
