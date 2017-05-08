<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN45SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45SOG00_ARRAY" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<% /* Import State Management classes - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<% /* Import PageMode and other utilities used on the page - Should be on every page */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper" %>
<%/* Import needed for Messages */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%/* Import needed for Form Launch */ %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility" %>
<%@ page import="java.util.Enumeration" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>

<%
  /* Set the page mode - This code should stay in the page. ...You can change it to PageMode.EDIT
     to see how the page functions, but it should always be initialized to view mode.
     String pageMode = PageMode.VIEW;  */
  String pageMode = PageModeConstants.EDIT;
  //If the mode was set in the activity method, get it
  if( request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = (String)request.getAttribute( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  } else if( request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME ) != null )
  {
    pageMode = request.getParameter( PageMode.PAGE_MODE_ATTRIBUTE_NAME );
  }
  /* Everything above this point should be in EVERY PAGE. *****************************************************************/
  /* Assign tab-index */
  int tabIndex = 1;
%>
<script type="text/javascript">
function populateForm ( stageID, taskCD )
{
  frmTaskList.txtUlIdStage.value = stageID;
  frmTaskList.txtSzCdTask.value = taskCD;
}
</script>
<impact:validateForm name="frmTaskList"
  method="post"
  action="/template/DetailTemplate/save"
  pageMode="<%= pageMode %>"
  schema="/WEB-INF/Constraints.xsd">
<div align="center"><font size="1" color="#800080" ><blink>Stephan's Task List Placeholder Page
- Soon to be known as the Navigational Metaphor</blink></font></div>

 <br><!--- GlobalData.getSzCdStage( request ) ====  --->
<% // GlobalData.getSzCdStage( request ) %>
<!--- ccmn45so ==== --->
<%
CCMN45SO ccmn45so = (CCMN45SO) request.getAttribute("CCMN45SO");
if ( ccmn45so != null )
{
  // out.println( ccmn45so );
}
else
{
        ccmn45so = new CCMN45SO();
  out.println( "ccmn45so == null" );
}
%><br>

<%

ROWCCMN45SOG00_ARRAY rowArray = null;

 if ( ccmn45so.getROWCCMN45SOG00_ARRAY() != null )
  {
    rowArray = ccmn45so.getROWCCMN45SOG00_ARRAY();
  }
 else
  {
    rowArray = new ROWCCMN45SOG00_ARRAY();
  }

%><br><br>
<table align="center" width="100%" bgcolor="#808080" >
<tr>
  <td width="50%">
<table align="center" width="100%" border="1" bgcolor="#c0c0c0" bordercolor="#808080" cellpadding="5">
<tr>
  <td bgcolor="#0000ff"><font color="#FFFFFF"><strong>Task Name</strong></font></td>
</tr>
<%
//Declare the loop counter
 int loopCount = 1;
 ROWCCMN45SOG00 row = null;
//Declare the enumeration and call the enumerateXXX() method on the array object you initialized in Step 10.
 Enumeration taskEnumeration = rowArray.enumerateROWCCMN45SOG00();

                   if ( !taskEnumeration.hasMoreElements() )
                  {
%>
<tr>
  <td valign="top" bgcolor="#ffffff"><%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %></td>
</tr>
<%
                  }
                    else
                  {
                  while ( taskEnumeration.hasMoreElements() )
                    {
                      row = (ROWCCMN45SOG00) taskEnumeration.nextElement();
%>

<tr>
  <td bgcolor="#ffffff"><a href="javascript: populateForm( '<%= GlobalData.getUlIdStage( request ) %>', '<%= row.getSzCdTask() %>' )"><%= row.getSzTxtTaskDecode() %></a></td>
</tr>
<%
                     loopCount++;
                    } // end while
                  }
%>
</table>
</td>
<td>
<table border="1" bordercolor="#c0c0c0" bgcolor="#ffffff" height="100%" width="100%" border="0" cellpadding="7" cellspacing="0">
  <tr>
    <td >Task Code:&nbsp;</td>
    <td><input type="text" size="25" name="txtSzCdTask" value=""></td>
  </tr>
  <tr>
    <td >Stage ID:&nbsp;</td>
    <td><input type="text" size="20" name="txtUlIdStage" value=""></td>
  </tr>
  <tr>
    <td colspan="2"><br><br><br><br><br><br><br><br><br><br>
  <div align="right"><impact:ButtonTag name="btnSubmit" editableMode="<%= EditableMode.EDIT %>" img="btnSubmit" align="right" form="frmTaskList" action="/common/TaskList/navigateTask" tabIndex="<%= tabIndex++ %>"/></div>
  </td>
  </tr>
</table>

</td>
</table>
<br><br>
<table border="1" bgcolor="#c0c0c0" bordercolor="#808080" cellpadding="5">
<tr>
  <td colspan="2"><strong>ccmn45so</strong></td>
</tr>
<tr>
  <td bgcolor="#ffffff">ccmn45so.getDtDtStageClose()</td>
  <td bgcolor="#ffffff"><%= FormattingHelper.formatDate( ccmn45so.getDtDtStageClose() ) %></td>
</tr>
<tr>
  <td bgcolor="#ffffff">ccmn45so.getArchOutputStruct()</td>
  <td bgcolor="#ffffff"><%= ccmn45so.getArchOutputStruct() %></td>
</tr>
<tr>
  <td valign="top" bgcolor="#ffffff">ccmn45so.getROWCCMN45SOG00_ARRAY()</td>
  <td bgcolor="#ffffff"><%// ccmn45so.getROWCCMN45SOG00_ARRAY() %></td>
</tr>
<%
                   taskEnumeration = rowArray.enumerateROWCCMN45SOG00();
                   if ( !taskEnumeration.hasMoreElements() )
                  {
%>
<tr>
  <td colspan="2" valign="top" bgcolor="#ffffff"><%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %></td>
</tr>
<%
                  }
                    else
                  {
                  while ( taskEnumeration.hasMoreElements() )
                    {
                      row = (ROWCCMN45SOG00) taskEnumeration.nextElement();
%>

<tr>
  <td valign="top" bgcolor="yellow">row.getSzTxtTaskDecode()<%= loopCount %></td>
  <td bgcolor="yellow"><%= row.getSzTxtTaskDecode() %></td>
</tr>
<tr>
  <td valign="top" bgcolor="#ffffff">row.getUlIdEvent()<%= loopCount %></td>
  <td bgcolor="#ffffff"><%= row.getUlIdEvent() %></td>
</tr>
<tr>
  <td valign="top" bgcolor="#ffffff">row.getSzCdTask()<%= loopCount %></td>
  <td bgcolor="#ffffff"><%= row.getSzCdTask() %></td>
</tr>
<tr>
  <td valign="top" bgcolor="#ffffff">row.getSzCdEventType()<%= loopCount %></td>
  <td bgcolor="#ffffff"><%= row.getSzCdEventType() %></td>
</tr>
<tr>
  <td valign="top" bgcolor="#ffffff">row.getSzCdEventStatus()<%= loopCount %></td>
  <td bgcolor="#ffffff"><%= row.getSzCdEventStatus() %></td>
</tr>
<tr>
  <td valign="top" bgcolor="#ffffff">row.getSzCdTaskPrior()<%= loopCount %></td>
  <td bgcolor="#ffffff"><%= row.getSzCdTaskPrior() %></td>
</tr>
<%
                     loopCount++;
                    } // end for
                  }
%>


</table>

<% /*  Always include this hidden field in your form */ %>
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">

</impact:validateForm>