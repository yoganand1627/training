<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="java.util.Iterator,
                 java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.TempAssignment" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>

<%
  UserProfile user = UserProfileHelper.getUserProfile(request);
%>
<table border="0" cellpadding="0" cellspacing="0">
<tr>
<td valign="top">
  <table border="0" cellpadding="0" cellspacing="0">
    <tr>
      <td colspan="2">
        <h3>User Profile</h3>
      </td>
    </tr>


    <tr>
      <td>UserLogonID:
      </td>
      <td><%out.println(user.getUserLogonID());%>
      </td>
    </tr>
    <tr>
      <td>UserID:
      </td>
      <td><%out.println(String.valueOf(user.getUserID()));%>
      </td>
    </tr>
    <tr>
      <td>UserFullName:
      </td>
      <td><%out.println(user.getUserFullName());%>
      </td>
    </tr>
    <tr>
      <td>UserRegion:
      </td>
      <td><%out.println(user.getUserRegion());%>
      </td>
    </tr>
    <tr>
      <td>UserOfficeID:
      </td>
      <td><%out.println(String.valueOf(user.getUserOfficeID()));%>
      </td>
    </tr>
    <tr>
      <td>UserOfficeCity:
      </td>
      <td><%out.println(user.getUserOfficeCity());%>
      </td>
    </tr>
    <tr>
      <td>UserUnit:
      </td>
      <td><%out.println(user.getUserUnit());%>
      </td>
    </tr>
    <tr>
      <td>UserProgram:
      </td>
      <td><%out.println(user.getUserProgram());%>
      </td>
    </tr>
    <tr>
      <td>UserClass:
      </td>
      <td><%out.println(user.getUserClass());%>
      </td>
    </tr>

  </table>


  <h3>Links</h3>
  <a href="/resource/ResourceSearch/">Go to Resource Directory</a> <br>
  <a href="/common/Reports/">Go to Reports</a> <br>
  <a href="/login/Login/navigation">Go to Navigation POC</a> <br>

  <h3>Personalization</h3>
  <impact:personalizeOnRight equalTo='<%=UserProfile.SEC_MNTN_SEC + ", " + UserProfile.SEC_CHG_USER_CLASS%>'>
    Only those with 'SEC_MNTN_SEC' || 'SEC_CHG_USER_CLASS' security will see this message.
  </impact:personalizeOnRight>

</td>
<td valign="top">
  <h3>All User Rights</h3>

  <%
    int[] rights = user.getRights();
    for (int i = 0; i < rights.length; i++) {
      out.println(String.valueOf(rights[i]));
    }

  %>
  <form name="securityManager" method="post" action="/login/Login/securityManager">
    <input type="submit" name="Change Security Attributes" value="Change Security Attributes"/><br>
    <%
      //noinspection UnhandledExceptionInJSP
      Iterator it = Lookup.getCategoryListing("CSECATTR");
      int count = 0;
      while (it.hasNext()) {
        CodeAttributes ca = (CodeAttributes) it.next();
//  out.println(  ca.getDecode() + " " + rights[count] );
    %>
    <input type="checkbox" name="secAtt<%=count%>" <%=(rights[count] == 1) ? "checked" : ""%> /><%=count%>. <%=
    ca.getDecode() %><br>
    <%
        count++;
      }
    %>
    <input type="submit" name="Change Security Attributes" value="Change Security Attributes"/>
  </form>
  <!--<h3>Temporary Assignments</h3>-->
  <%
    List tempAssignments = user.getTempAssignments();

    if (tempAssignments != null) {
      Iterator tempIterator = tempAssignments.iterator();
      while (tempIterator.hasNext()) {
        TempAssignment ta = (TempAssignment) tempIterator.next();
        out.println(ta.getTempDesignatorID() + "<br>");
        out.println(ta.getTempFunction() + "<br>");
        out.println(ta.getTempSecurityClass() + "<br>");
        out.println(ta.getTempExpDate().toString() + "<br>");
        out.println("<br><br>");
      }
    }


  %>


</td>
</tr>
</table>




