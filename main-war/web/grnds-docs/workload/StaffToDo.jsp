<%
/**
 * JSP Name:     StaffToDo.jsp
 * Created by:   Michael K. Werle
 * Date Created: 01/08/03
 *
 * Description:
 * This page shows a worker's To-Do List and allows them to navigate to the
 * items they have to do.
 *
 * 6/1/04     Hadjimh  SIR#22902   added a report dropdown list box to the page
 * 7/7/05     Fraserkr SIR23559   Allow report dropdown from the StaffToDoSummary
 *                              page also.
 * 10/2/2008  arege    STGAP00009233 Modified an if condition that will not allow 
 *                                   deletion of any Task from the Staff To-Do list.
 *
 * 12/4/2009  wjcochran  SMS #37449: Add Select/Deselect All buttons
 * 01/6/2010  wjcochran  SMS #37449: Modified Select All to select only Alerts
 * 
 * 
**/
%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN17DO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper" %>

<%
  int tabIndex = 1;

  String formName = "frmStaffToDo";
  String formNameResults = "frmStaffToDoResults";
  
  int toDoStateInfoId = Integer.parseInt( (String)request.getAttribute( ToDoConversation.TODO_STATE_ID_KEY ) );
  ToDoHelper.ToDoStateInfo toDoStateInfo = ToDoHelper.getToDoStateInformation( request, toDoStateInfoId );

  String fromDate = FormattingHelper.formatDate( toDoStateInfo.getFromDate() );
  String toDate = FormattingHelper.formatDate( toDoStateInfo.getToDate() );

  // get the row array
  BaseSessionStateManager state
          = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  List rowccmn17doList = (List)state.getAttribute( ToDoConversation.ROWCCMN17DO_LIST_KEY, request );

  // get the session id to support showing which links have been visited
  String sessionId = session.getId();

  // get the current display uri so we can display both as staff to-do and summary to-do
  String currentDisplayURI = ToDoHelper.getReturnToToDoListURI( request );

  // Begin SIR#22902
  // because StaffToDo page is the same as StaffToDoSummary, we need to make sure the
  // report section displays only on StaffToDo page
  // SIR23559 - commented out next two lines of code, no longer needed
  //boolean bStaffToDo = false;
  //bStaffToDo = currentDisplayURI.compareToIgnoreCase("/workload/ToDo/displayStaffToDo") == 0;
  // note by fraserkr:  user is needed for report list to set personId
  UserProfile user = UserProfileHelper.getUserProfile( request );
  // End SIR#22902

  // SIR23559 report section can display for both StaffToDo and StaffToDoSummary pages
  //  leaving boolean value to drive report conditional in case useful for future maintenance
  boolean bStaffToDo = true;

  boolean missingResults = false;

  Iterator toDoIterator = rowccmn17doList != null ? rowccmn17doList.iterator() : null;
  if ( toDoIterator == null || !toDoIterator.hasNext() )
  {
    missingResults = true;
  }
  String searchDefaultButton = "" + missingResults;
%>

<script language="Javascript">

  function navigate( idTodo, sessionId )
  {
    frmStaffToDoResults.hdnIdTodo.value = idTodo;
    disableValidation( "frmStaffToDoResults" );
    submitValidateForm( "frmStaffToDoResults", "/workload/ToDo/displayStaffToDoActionPage" );
  }

  function newToDoUsing()
  {
    if( frmStaffToDo.hdnMissingResults != "true" )
    {
      var todoCount = 0;
      var idTodo = -1;
      for( var i = 0; i < <%=ToDoConversation.RESULTS_PER_PAGE%>; i++ )
      {
        var cb = eval( "frmStaffToDoResults.cbIdToDo_" + i );
        if( cb == null )
        {
          break;
        }
        if( cb.checked )
        {
          todoCount++;
          idTodo = cb.value;
        }
      }
      // New Using requires that exactly 1 item be selected.
      if( todoCount < 1 )
      {
        alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_NO_ROW_SELECTED_CONTINUE )%>' );
        return false;
      }
      if( todoCount > 1 )
      {
        alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_ONLY_ONE_ROW_NEW_USING )%>' );
        return false;
      }
      var isTask = eval( "frmStaffToDoResults.isTask_" + idTodo ).value;
      if( isTask != "true" )
      {
        alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_NEW_USING_REQUIRES_TASK_TODO )%>" );
        return false;
      }
      var isApproval = eval( "frmStaffToDoResults.isApproval_" + idTodo ).value;
      if( isApproval == "true" )
      {
        alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_CMN_ADDL_APPRV )%>" );
        return false;
      }
      frmStaffToDoResults.hdnIdTodo.value = idTodo;
      disableValidation( "frmStaffToDoResults" );
      return true;
    }
    else
    {
      alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_NO_NEW_USING_TO_DO )%>" );
      return false;
    }
  }

  function display( idTodo, sessionId )
  {
    frmStaffToDoResults.hdnIdTodo.value = idTodo;
    disableValidation( "frmStaffToDoResults" );
    submitValidateForm( "frmStaffToDoResults", "/workload/ToDo/displayStaffToDoDetail" );
  }

  function deleteToDo()
  {
    var selectedCount = 0;
    for( var i = 0; i < <%=ToDoConversation.RESULTS_PER_PAGE%>; i++ )
    {
      var cb = eval( "frmStaffToDoResults.cbIdToDo_" + i );
      if( cb == null )
      {
        // there was not a full page; just break
        break;
      }
      if( cb.checked )
      {
        selectedCount++;
        var canBeDeleted = eval( "frmStaffToDoResults.hdnCanBeDeletedName_" + i ).value;
        if( canBeDeleted != "true" )
        {
          alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_CHG_INVALID_TODO )%>' );
          return false;
        }
      }
    }
    if( selectedCount < 1 )
    {
      alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_NO_ROW_SELECTED_CONTINUE )%>' );
      return false;
    }
    if( selectedCount > <%=ToDoConversation.MAX_DELETE%> )
    {
      alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_TO_DO_MAX_DELETE )%>' );
      return false;
    }
    if( confirm( '<%=MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE )%>' ) )
    {
      disableValidation( "frmStaffToDoResults" );
      return true;
    }
    else
    {
      return false;
    }
  }

/*
 * SMS #37449: Add Select/Deselect All functionality
 */
function selectAll()
{
  for( var i = 0; i < <%=ToDoConversation.RESULTS_PER_PAGE%>; i++ )
  {
    var cb = eval( "frmStaffToDoResults.cbIdToDo_" + i );
    var canBeDel = eval( "frmStaffToDoResults.hdnCanBeDeletedName_" + i);
    if( cb == null )
    {
      // there was not a full page; just break
      break;
    }
    if (canBeDel.value == "true")
    {
	  cb.checked = true;
    }
    
  }
  return false;
}


function deselectAll()
{
  for( var i = 0; i < <%=ToDoConversation.RESULTS_PER_PAGE%>; i++ )
  {
    var cb = eval( "frmStaffToDoResults.cbIdToDo_" + i );
    if( cb == null )
    {
      // there was not a full page; just break
      break;
    }
    cb.checked = false;
  }
  return false;
}
</script>

<impact:validateErrors />
<impact:validateForm name="<%=formName%>"
                     method="post"
                     action="<%=currentDisplayURI%>"
                     pageMode="<%=PageModeConstants.EDIT%>"
                     schema="/WEB-INF/Constraints.xsd"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoCustomValidation"
                     defaultButton='<%= searchDefaultButton %>'>
  <impact:validateInput type="hidden" name="hdnIdTodo" />
  <impact:validateInput type="hidden" name="hdnCurrentDisplayURI" value="<%=currentDisplayURI%>" />
  <table cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="4">Search Criteria</th>
    </tr>
    <tr>
      <td>
        <impact:validateDate name="dtFrom" value="<%=fromDate%>" tabIndex="<%=tabIndex++%>" label="From" />
      </td>
      <td>
        <impact:validateDate name="dtTo" value="<%=toDate%>" tabIndex="<%=tabIndex++%>" label="To" />
      </td>
    </tr>
  </table>
  <table cellspacing="0" cellpadding="3" width="100%">
    <tr>
      <td colspan="4" align="right">
        <impact:ButtonTag name="btnSearchFinal"
                          img="btnSearch"
                          tabIndex="<%=tabIndex++%>"
                          form="frmStaffToDo"
                          action="<%=currentDisplayURI%>" />
      </td>
    </tr>
  </table>
  <br>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<impact:validateForm name="<%=formNameResults%>"
                     method="post"
                     action="<%=currentDisplayURI%>"
                     pageMode="<%=PageModeConstants.EDIT%>"
                     schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden" name="hdnIdTodo" />
  <impact:validateInput type="hidden" name="hdnCurrentDisplayURI" value="<%=currentDisplayURI%>" />
<%
  if( !missingResults )
  {
%>
  <table width="100%" cellspacing="0" cellpadding="3">
    <tr>
      <td>
      <impact:ButtonTag name="SelectAll"
                        tabIndex='<%= tabIndex++ %>'
                        function='return selectAll();'
                        action='/not/a/real/path'
                        form='<%= formName %>'
                        img="btnSelectAll" />

      <impact:ButtonTag name="DeselectAll"
                        tabIndex='<%= tabIndex++ %>'
                        function='return deselectAll();'
                        action='/not/a/real/path'
                        form='<%= formName %>'
                        img="btnDeselectAll" />
      </td>
    </tr>
  </table>
<%
  }
%>
  <impact:pagination submitUrl="<%=currentDisplayURI%>" saveState="false">
    <div id="noScrollResults" style="height:100%; width:100%; overflow:auto" class="tableborderList">
      <table width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList" style="white-space: nowrap;">&nbsp;</th>
          <th class="thList" style="white-space: nowrap;">Type</th>
          <th class="thList" style="white-space: nowrap;">
             Due Date
            <impact:sortableColumnHeader orderBy="<%=ToDoConversation.STAFF_TODO_SORT_BY_DATE%>" />
          </th>
          <th class="thList" style="white-space: nowrap;">
            Stage Name
            <impact:sortableColumnHeader orderBy="<%=ToDoConversation.STAFF_TODO_SORT_BY_CASE%>" />
          </th>
          <th class="thList" style="white-space: nowrap;">
            Created By
            <impact:sortableColumnHeader orderBy="<%=ToDoConversation.STAFF_TODO_SORT_BY_CREATOR%>" />
          </th>
          <th class="thList" style="white-space: nowrap;">
          Description
          <impact:sortableColumnHeader orderBy="<%=ToDoConversation.STAFF_TODO_SORT_BY_DESCRIPTION%>" />
          </th>
        </tr>
<%
  if (missingResults)
  {
%>
        <tr class="odd">
          <td colspan="6">
            <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
          </td>
        </tr>
<%
  }
  else
  {
    int loopCount = 0;
    while( toDoIterator.hasNext() )
    {
      ROWCCMN17DO rowccmn17do = (ROWCCMN17DO)toDoIterator.next();
      String cbName = "cbIdToDo_" + loopCount;
      String canBeDeletedName = "hdnCanBeDeletedName_" + loopCount;
      String toDoTypeCode = rowccmn17do.getSzCdTodoType();
      String toDoCreator = FormattingHelper.formatString( rowccmn17do.getSzScrTodoCreated() );
      String taskCode = rowccmn17do.getSzCdTask();
      // A to-do can be deleted if it satisfies any of the following:
      // 1) a non-task to-do
      // 2) a system to-do with no task code
      String canBeDeleted = !CodesTables.CTODOTYP_T.equals( toDoTypeCode )
             // Per STGAP00009233 arege Commented out the following line 
             // ( !toDoCreator.equals( ToDoConversation.CREATED_NAME_SYSTEM )
              || !StringHelper.isValid( taskCode )
              ? "true" : "false";
      String toDoTypeDecode = StringHelper.isValid( toDoTypeCode )
              ? Lookup.simpleDecode( CodesTables.CTODOTYP, toDoTypeCode ) : "";
      String idTodo = String.valueOf( rowccmn17do.getLdIdTodo() );
      // Only Task To-Do's that are not approvals can be used for New Using
      String isTaskName = "isTask_" + idTodo;
      String isApprovalName = "isApproval_" + idTodo;
      // Need to use TaskInit to figure out if we have an approval todo
      String todoTaskType = null;
      try
      {
        todoTaskType = StringHelper.isValid( taskCode )
                    ? TaskInit.getTaskColumnString( taskCode, TaskInit.CD_TASK_EVENT_TYPE )
                    : null;
      }
      catch( IllegalStateException e )
      {
        todoTaskType = null; // redundant, but just to be clear
      }
      String isApproval
              = StringHelper.isValid( taskCode ) && CodesTables.CEVNTTYP_APP.equals( todoTaskType ) ? "true" : "false";
%>
        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
          <td>
            <impact:validateInput type="checkbox" name="<%=cbName%>" tabIndex="<%=tabIndex++%>" value="<%=idTodo%>" />
          </td>
          <td>
            <impact:validateInput type="hidden" name="<%=canBeDeletedName%>" value="<%=canBeDeleted%>"/>
            <impact:validateInput type="hidden" name="<%=isApprovalName%>" value="<%=isApproval%>"/>
<%
      if( toDoTypeCode.equals( CodesTables.CTODOTYP_T ) && todoTaskType != null )
      {
        // include both the idTodo and the session id to make sure that the link is only marked
        //   as visited when the user navigates to that todo detail
%>
            <%-- Only Valid Task To-Do's that are not approvals can be used for New Using --%>
            <impact:validateInput type="hidden" name="<%=isTaskName%>" value="true"/>
            <a href="javascript:navigate( '<%=idTodo%>', '<%=sessionId%>' );" tabIndex="<%=tabIndex++%>">
              <%=FormattingHelper.formatString( toDoTypeDecode )%>
            </a>
<%
      }
      else
      {
%>
            <%-- Only Valid Task To-Do's can be used for New Using --%>
            <impact:validateInput type="hidden" name="<%=isTaskName%>" value="false"/>
            <%=FormattingHelper.formatString( toDoTypeDecode )%>
<%
      }
%>
          </td>
          <td>
            <%=FormattingHelper.formatDate( rowccmn17do.getDtDtTodoDue() )%>
          </td>
          <td>
            <%=FormattingHelper.formatString( rowccmn17do.getSzNmStage() )%>
          </td>
          <td>
            <%=toDoCreator%>
          </td>
          <td>
            <div>
              <%--
                include both the idTodo and the session id to make sure that the link is only marked
                  as visited when the user navigates to that todo detail
              --%>
              <a href="javascript:display( '<%=idTodo%>', '<%=sessionId%>' );" tabIndex="<%=tabIndex++%>">
                <%=FormattingHelper.formatString( rowccmn17do.getSzTxtTodoDesc() )%>
              </a>
            </div>
          </td>
        </tr>
<%
      loopCount++;
    }
  }
%>
      </table>
    </div>
  </impact:pagination>
<%
  if( !missingResults )
  {
%>
  <table width="100%" cellspacing="0" cellpadding="3">
    <tr>
      <td>
        <impact:ButtonTag name="btnDeleteFinal"
                          img="btnDelete"
                          form="frmStaffToDoResults"
                          action="/workload/ToDo/deleteStaffToDo"
                          tabIndex="<%=tabIndex++%>"
                          function="return deleteToDo()"
                          restrictRepost="true"/>
      </td>
      <td align="right">
        <impact:ButtonTag name="btnNewUsingFinal"
                          img="btnNewUsing"
                          form="frmStaffToDoResults"
                          action="/workload/ToDo/newUsingStaffToDo"
                          tabIndex="<%=tabIndex++%>"
                          function="return newToDoUsing()"
                          restrictRepost="true"/>
      </td>
    </tr>
  </table>
<%
  }
%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>

<% /* sir#22902. added the dropdown list box for report. Begin Forms and Reports  */ %>
<%// if (bStaffToDo)%>
<%//{%>
<%//<table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder"%>
<%//<tr>%>
    <%//<th colspan="4"> Reports </th>%>
  <%//</tr>%>
  <%//<tr>%>

  <%//<td>%>
       <%//<% String emailMessageString = ""; %>
       <%//<impact:reportList tabIndex="<%= tabIndex++ /%/>" personId="<%= user.getUserID() /%/>">%>

          <%//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Due Date" ; %>
          <%//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Due Date" emailMessage="</%/= emailMessageString /%/>" >%>
             <%//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />%>
             <%//<impact:reportParameter value='<%= String.valueOf("1") /%/>'/>%>
          <%//</impact:report>%>

          <%//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Case ID" ; %>
          <%//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Case ID" emailMessage="<%= emailMessageString /%/>" >%>
             <%//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />%>
             <%//<impact:reportParameter value='<%= String.valueOf("2") /%/>'/>%>
          <%//</impact:report>%>

          <%//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Stage Name" ; %>
          <%//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Stage Name" emailMessage="<%= emailMessageString /%/>" >%>
             <%//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />%>
             <%//<impact:reportParameter value='<%= String.valueOf("3") /%/>'/>%>
          <%//</impact:report>%>

          <%//<% emailMessageString = GlobalData.getSzNmStaff( request ) + ": Order by Creator Initials" ; /%/>%>
          <%//<impact:report useHiddenParameters="false" reportName="ccm06o00" displayName="Order By Creator Initials" emailMessage="<%= emailMessageString /%/>">%>
             <%//<impact:reportParameter value='<%= String.valueOf(GlobalData.getUlIdStaff( request )) /%/>' />%>
             <%//<impact:reportParameter value='<%= String.valueOf("4") /%/>'/>%>
          <%//</impact:report>%>

       <%//</impact:reportList>%>
    <%//</td>%>
  <%//</tr>/%/>%>
<%//</table>%>
<%//}%>