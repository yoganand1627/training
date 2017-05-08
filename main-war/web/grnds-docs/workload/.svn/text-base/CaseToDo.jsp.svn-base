<%--
/*
 * JSP Name:     CaseToDo.jsp
 * Created by:   Michael K. Werle
 * Date Created: 01/08/03
 *
 * Description:
 * This page shows a case's To-Do List and allows the user to navigate to the
 * items they have to do.
 * <pre>
 * Date        User              Description
 * --------    ----------------  ----------------------------------------------------------------------------------
 * 09/27/2005  cooganpj          SIR 23986 - Hide the manual case to-do section when a stage is checked out to MPS.
 * </pre>
*/
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN42DO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>

<%
  String pageMode = PageMode.getPageMode( request );

  int tabIndex = 1;

  int toDoStateInfoId = Integer.parseInt( (String)request.getAttribute( ToDoConversation.TODO_STATE_ID_KEY ) );
  ToDoHelper.ToDoStateInfo toDoStateInfo = ToDoHelper.getToDoStateInformation( request, toDoStateInfoId );

  String fromDate = FormattingHelper.formatDate( toDoStateInfo.getFromDate() );
  String toDate = FormattingHelper.formatDate( toDoStateInfo.getToDate() );

  // get the row array
  BaseSessionStateManager state
          = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  List rowccmn42doList = (List)state.getAttribute( ToDoConversation.ROWCCMN42DO_LIST_KEY, request );

  // Get the toDoIterator so we can check to see if we have results
  boolean toDoExists = true;
  Iterator toDoIterator = rowccmn42doList != null ? rowccmn42doList.iterator() : null;
  if ( toDoIterator == null || !toDoIterator.hasNext() )
  {
    toDoExists = false;
  }

  // get the session id to support showing which links have been visited
  String sessionId = session.getId();

  // get the list of open stages for the current case
  int ulIdCase = GlobalData.getUlIdCase( request );
  String idCase = String.valueOf( ulIdCase );
  List stageList = idCase != null ? CaseUtility.getOpenStages( idCase ) : null;
  boolean openStageExists = stageList != null && stageList.size() > 0;

  //SIR 23986 - Determine if APS and pending approval

  String INV_CONCL_TASK_CODE = "2120";
  String SVC_CONCL_TASK_CODE = "6010";
  String AOC_CONCL_TASK_CODE = "5090";

  String conclTaskCode = SVC_CONCL_TASK_CODE;
  if( CodesTables.CSTAGES_INV.equals( GlobalData.getSzCdStage( request ) ) )
  {
     conclTaskCode = INV_CONCL_TASK_CODE;
  }
  else if( CodesTables.CSTAGES_AOC.equals( GlobalData.getSzCdStage( request ) ) )
  {
     conclTaskCode = AOC_CONCL_TASK_CODE;
  }

  CaseUtility.Event apsCnclEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
                                                        conclTaskCode);

  boolean pendStageProg = (apsCnclEvent.getCdEventStatus() != null &&
          CodesTables.CEVTSTAT_PEND.equals( apsCnclEvent.getCdEventStatus()));

%>

<script type="text/javascript" language="Javascript">
  function navigate( index, sessionId )
  {
    frmCaseToDoResults.hdnIdTodo.value = index;
    disableValidation( "frmCaseToDoResults" );
    submitValidateForm( "frmCaseToDoResults", "/workload/ToDo/displayCaseToDoActionPage" );
  }

  function newUsing()
  {
    if( <%=toDoExists%> )
    {
      var idTodo = getSelectedRadioValue( frmCaseToDoResults.rbIdToDo );
      if( idTodo == "" || idTodo == null )
      {
        alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_NO_ROW_SELECTED_CONTINUE )%>' );
        return false;
      }
      var isTask = eval( "frmCaseToDoResults.isTask_" + idTodo ).value;
      if( isTask != "true" )
      {
        alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_NEW_USING_REQUIRES_TASK_TODO )%>" );
        return false;
      }
      var isApproval = eval( "frmCaseToDoResults.isApproval_" + idTodo ).value;
      if( isApproval == "true" )
      {
        alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_CMN_ADDL_APPRV )%>" );
        return false;
      }
      frmCaseToDoResults.hdnIdTodo.value = idTodo;
      disableValidation( "frmCaseToDoResults" );
      return true;
    }
    else
    {
      alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_NO_NEW_USING_TO_DO )%>" );
      return false;
    }
  }

  function addToDo()
  {
    if( <%=openStageExists%> )
    {
      var idStage = getSelectedRadioValue( frmCaseToDoResults.rbIdStage );
      if( idStage == "" || idStage == null )
      {
        alert( '<%=MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE )%>' );
        return false;
      }
      frmCaseToDoResults.hdnIdStage.value = idStage;
      frmCaseToDoResults.hdnCdStage.value = eval( "frmCaseToDoResults.dspCdStage_" + idStage ).value;
      frmCaseToDoResults.hdnCdStageProgram.value = eval( "frmCaseToDoResults.hdnCdStageProgram_" + idStage ).value;
      disableValidation( "frmCaseToDoResults" );
      return true;
    }
    else
    {
      alert( "<%=MessageLookup.getMessageByNumber( Messages.MSG_ADD_TO_DO_NO_STAGES )%>" );
      return false;
    }
  }

  function display( index, sessionId )
  {
    frmCaseToDoResults.hdnIdTodo.value = index;
    disableValidation( "frmCaseToDoResults" );
    submitValidateForm( "frmCaseToDoResults", "/workload/ToDo/displayCaseToDoDetail" );
  }

</script>

<impact:validateErrors />
<impact:validateForm name="frmCaseToDo" method="post"
                     action="<%=ToDoConversation.DISPLAY_CASE_TODO_LIST_URI%>"
                     pageMode="<%=pageMode%>"schema="/WEB-INF/Constraints.xsd"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoCustomValidation" >
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
      <td align="right">
        <impact:ButtonTag name="btnSearchFinal" img="btnSearch" tabIndex="<%=tabIndex++%>"
                          form="frmCaseToDo" action="<%=ToDoConversation.DISPLAY_CASE_TODO_LIST_URI%>" />
      </td>
    </tr>
  </table>
  <br>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<impact:validateForm name="frmCaseToDoResults" method="post"
                     action="<%=ToDoConversation.DISPLAY_CASE_TODO_LIST_URI%>"
                     pageMode="<%=pageMode%>"schema="/WEB-INF/Constraints.xsd">
  <impact:validateInput type="hidden" name="hdnIdTodo" />
  <impact:validateInput type="hidden" name="hdnIdStage" />
  <impact:validateInput type="hidden" name="hdnCdStage" />
  <impact:validateInput type="hidden" name="hdnCdStageProgram" />
  <impact:validateInput type="hidden" name="hdnAddAlert" />
  <impact:pagination submitUrl="<%=ToDoConversation.DISPLAY_CASE_TODO_LIST_URI%>" saveState="false">
    <div id="noScrollResults" style="height:100%; width:100%; overflow:auto" class="tableborderList">
      <table width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList" style="white-space: nowrap;">&nbsp;</th>
          <th class="thList" style="white-space: nowrap;">Type</th>
          <th class="thList" style="white-space: nowrap;">
            Due Date
            <impact:sortableColumnHeader orderBy="<%=ToDoConversation.CASE_TODO_SORT_BY_DATE%>" />
          </th>
          <th class="thList" style="white-space: nowrap;">
            Assigned
            <impact:sortableColumnHeader orderBy="<%=ToDoConversation.CASE_TODO_SORT_BY_ASSIGNED%>" />
          </th>
          <th class="thList" style="white-space: nowrap;">
            Created By
            <impact:sortableColumnHeader orderBy="<%=ToDoConversation.CASE_TODO_SORT_BY_CREATOR%>" />
          </th>
          <th class="thList" style="white-space: nowrap;">Description</th>
        </tr>
<%
  if ( !toDoExists )
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
      ROWCCMN42DO rowccmn42do = (ROWCCMN42DO)toDoIterator.next();
      String toDoTypeCode = rowccmn42do.getSzCdTodoType();
      String toDoTypeDecode = Lookup.simpleDecodeSafe( CodesTables.CTODOTYP, toDoTypeCode );
      String idTodo = String.valueOf( rowccmn42do.getLdIdTodo() );
      // Only Task To-Do's can be used for New Using
      String isTaskName = "isTask_" + idTodo;
      String isApprovalName = "isApproval_" + idTodo;
      // Need to use TaskInit to figure out if we have an approval todo
      String taskCode = rowccmn42do.getSzCdTask();
      String todoTaskType;
      try
      {
        todoTaskType = StringHelper.isValid( taskCode ) ?
                       TaskInit.getTaskColumnString( taskCode, TaskInit.CD_TASK_EVENT_TYPE ) : null;
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
            <impact:validateInput type="radio" name="rbIdToDo" tabIndex="<%=tabIndex++%>" value="<%=idTodo%>" />
            <impact:validateInput type="hidden" name="<%=isApprovalName%>" value="<%=isApproval%>"/>
          </td>
          <td>
<%
  if( toDoTypeCode.equals( CodesTables.CTODOTYP_T ) && todoTaskType != null )
  {
    // include both the idTodo and the session id to make sure that the link is only marked
    //   as visited when the user navigates to that todo detail
%>
            <%-- Only Valid Task To-Do's can be used for New Using --%>
            <impact:validateInput type="hidden" name="<%=isTaskName%>" value="true"/>
            <a href="javascript:navigate( '<%=idTodo%>', '<%=sessionId%>' );">
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
            <%=FormattingHelper.formatDate( rowccmn42do.getDtDtTodoDue() )%>
          </td>
          <td>
            <%=FormattingHelper.formatString( rowccmn42do.getSzScrTodoAssignedTo() )%>
          </td>
          <td>
            <%=FormattingHelper.formatString( rowccmn42do.getSzScrTodoCreated() )%>
          </td>
          <td>
            <div>
              <%--
                include both the idTodo and the session id to make sure that the link is only marked
                  as visited when the user navigates to that todo detail
              --%>
              <a href="javascript:display( '<%=idTodo%>', '<%=sessionId%>' );">
                <%=FormattingHelper.formatString( rowccmn42do.getSzTxtTodoDesc() )%>
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
  // SIR 23986 - Hide Add Case To-Do for checked out stages.
  if( Sets.isInSet( ToDoConversation.CASE_TODO_BUTTON_SET, request)
  && !(CaseUtility.getCaseCheckoutStatus(GlobalData.getUlIdStage(request))&&
      !( pendStageProg || CaseUtility.getAFCPendingStatus(GlobalData.getUlIdCase(request)))))
  {
%>
  <br>
  <impact:ExpandableSectionTag name="addCaseToDo" label="Add Alert" tabIndex="<%=tabIndex++%>" >
    <div id="noScrollResults" style="height:100%; width:100%; overflow:auto" class="tableborderList">
      <table width="100%" cellspacing="0" cellpadding="3">
        <tr>
          <th class="thList" style="white-space: nowrap;">&nbsp;</th>
          <th class="thList" style="white-space: nowrap;">Stage Code</th>
          <th class="thList" style="white-space: nowrap;">Stage Name</th>
          <th class="thList" style="white-space: nowrap;">Date Created</th>
        </tr>
<%
    Iterator stageIterator = stageList != null ? stageList.iterator() : null;
    if ( stageIterator == null || !stageIterator.hasNext() )
    {
      toDoExists = true;
%>
        <tr class="odd">
          <td colspan="4">
            <%= MessageLookup.getMessageByName( "SSM_NO_ROWS_RETURNED" ) %>
          </td>
        </tr>
<%
    }
    else
    {
      int loopCount = 0;
      while( stageIterator.hasNext() )
      {
        CaseUtility.Stage stage = (CaseUtility.Stage)stageIterator.next();
        String idStage = FormattingHelper.formatInt( stage.getIdStage() );
        String cdStage = Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, stage.getCdStage());
        String cdStageProgram = FormattingHelper.formatString( stage.getCdStageProgram() );
        String nmStage = FormattingHelper.formatString( stage.getNmStage() );
        String dtStart = FormattingHelper.formatDate( stage.getDtStart() );
%>
        <tr class="<%=FormattingHelper.getRowCss( loopCount + 1 )%>" valign="top">
          <td>
            <impact:validateInput type="radio" name="rbIdStage" tabIndex="<%=tabIndex++%>" value="<%=idStage%>" />
          </td>
          <td>
            <impact:validateDisplayOnlyField name='<%="dspCdStage_" + idStage %>' value="<%=cdStage%>" />
            <impact:validateInput type="hidden" name='<%="hdnCdStageProgram_" + idStage %>'
                                  value="<%=cdStageProgram%>" />
          </td>
          <td><%=nmStage%></td>
          <td><%=dtStart%></td>
        </tr>
<%
        loopCount++;
      }
    }
%>
      </table>
    </div>
    <table cellspacing="0" cellpadding="3" width="100%">
      <tr>
        <td align="right">
          <impact:ButtonTag name="btnAddFinal" img="btnAdd" form="frmCaseToDoResults"
                            action="/workload/ToDo/addCaseToDo" tabIndex="<%=tabIndex++%>"
                            function="return addToDo()"  restrictRepost="true"/>
        </td>
      </tr>
    </table>
  </impact:ExpandableSectionTag>
<%
  }
%>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
