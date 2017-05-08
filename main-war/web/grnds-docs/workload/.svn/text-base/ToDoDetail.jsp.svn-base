<%--
//*  JSP Name:     To-Do Detail
//*  Created by:   Michael Werle
//*  Date Created: 01/08/2003
//*
//*  Description:
//*  This JSP is used to create, edit, and view To-Do's
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  03/08/04  CORLEYAN          SIR 22512 Added preventDoubleClick to Save push buttons.
//**
//**  08/12/05  marallh           SIR 19783 Task to-do not deleting from list..
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailCustomValidation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Map"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>

<%
  BaseSessionStateManager state = (BaseSessionStateManager)request.getAttribute( BaseSessionStateManager.STATE_MANAGER_KEY );
  ToDoDetailDB toDoDetailDB = ToDoConversation.getToDoDetailDB( request, state );
  
  String pageMode = PageMode.getPageMode( request );

  int tabIndex = 1;
  String ToDoType;
  String initials = toDoDetailDB.getInitialsPersonCreator();
  String descriptionPrefix = initials != null && !"".equals(initials) ? initials + ToDoConversation.DASH_STRING : "";
  // SIR 19783 - set the variable to hide or show the select staff button
  boolean hidebtnSelectStaff = "true".equalsIgnoreCase(Sets.isInSetStr( ToDoConversation.DISABLE_STAFF_SERACH_BUTTON_SET, request ));
%>
<script language="Javascript">
  // SIR 19783 - Added the JS funtion to disable the button, once Save button is clicked. So that
  //             they can't change the Assigned To person, once save button is clicked.
  function disableStaffFinal()
  {
    <impact:ifThen test="<%= !hidebtnSelectStaff %>">
      disableButton('btnSelectStaff');
    </impact:ifThen>
  }

  function disableButton(buttonName)
  {
    eval("document.frmToDoDetail." + buttonName + "IsEnabled.value='false';");
    eval("toggleVisibility('" + buttonName + "_EnableClick_Id', 'none');");
    eval("toggleVisibility('" + buttonName + "_DisableClick_Id', 'block');");
  }

  function updateShortDesc()
  {
    var index = frmToDoDetail.selSzCdTask.selectedIndex;
    var options = frmToDoDetail.selSzCdTask.options;
    var option = options[index];
    frmToDoDetail.txtSzTxtTodoDesc.value = "<%=descriptionPrefix%>" + option.innerText;
  }

  function saveToDoDetail()
  {
<%
  Map taskNewIndMap = toDoDetailDB.getTaskNewIndMap();
  // we only need to create this javascript in new using mode because taskNewIndMap is only populated on new using
  if( taskNewIndMap != null )
  {
%>
    var code = frmToDoDetail.selSzCdTask.value;
    var cSysIndTaskNew = false;
    var bLinkEvent = false;
<%
  // Create if conditions for each key of taskNewIndMap whose value indicates that we should prompt
  //The out.println's are generating javascript which runs on save
  out.println("    if (false) ");
  out.println("    {");
  //placeholder to make generating if code below easier
  out.println("    }");

  boolean firstLoop = true;
  Iterator taskNewIndMapIterator = taskNewIndMap.keySet().iterator();
  while( taskNewIndMapIterator.hasNext() )
  {
    String szCdTask = (String)taskNewIndMapIterator.next();
    String taskNewInd = (String)taskNewIndMap.get( szCdTask );
    String linkMessage = MessageLookup.getMessageByNumber( Messages.MSG_CMN_TASK_LIST_TODO );
    linkMessage = MessageLookup.addMessageParameter( linkMessage, "event" );

    //distilled from ccmn63w.win;
    //  makes sense when read in conjunction with ToDoConversation.getTaskNewIndMap()

    if( ToDoConversation.IND_TASK_NEW_TRUE.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      cSysIndTaskNew = true;");
      out.println("    }");
    }
    else if( ToDoConversation.IND_TASK_NEW_FALSE.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      cSysIndTaskNew = false;");
      out.println("    }");
    }
    else if( ToDoConversation.IND_TASK_MUST_LINK.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      cSysIndTaskNew = false;");
      out.println("      bLinkEvent = true;");
      out.println("    }");
    }
    else if( ToDoConversation.IND_TASK_NEW_PROMPT.equals(taskNewInd) )
    {
      out.println("    else if( code == '" + szCdTask + "' )");
      out.println("    {");
      out.println("      bLinkEvent = confirm( '" + linkMessage + "' );");
      out.println("      cSysIndTaskNew = !bLinkEvent;");
      out.println("    }");
    }
   }
%>
    if( cSysIndTaskNew )
    {
      frmToDoDetail.hdnCSysIndTaskNew.value = "<%=ToDoConversation.IND_TASK_NEW_TRUE%>";
    }
    else
    {
      frmToDoDetail.hdnCSysIndTaskNew.value = "<%=ToDoConversation.IND_TASK_NEW_FALSE%>";
    }
    frmToDoDetail.bLinkEvent.value = bLinkEvent;
<%
  }
 %>
    return true;
  }

</script>

<impact:validateErrors />
<impact:validateForm name="frmToDoDetail"
                     method="post"
                     action="/workload/ToDo/displayToDoDetail"
                     pageMode="<%=pageMode%>"
                     schema="/WEB-INF/Constraints.xsd"
                     validationClass="gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailCustomValidation">

  <impact:validateInput type="hidden" name="hdnCSysIndTaskNew" />
  <impact:validateInput type="hidden" name="bLinkEvent" />

  <table border="0" cellspacing="0" cellpadding="3" width="100%" class="tableBorder">
    <tr>
      <th colspan="2">To-Do Data</th>
    </tr>
    <tr>
      <td colspan="2">
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr>
            <td>
              <impact:validateDate name="dtDueDate" tabIndex="<%=tabIndex%>" label="Due Date" required="true"
                                   disabled="<%=ToDoConversation.getDisableDueDate( toDoDetailDB )%>"
                                   value="<%=FormattingHelper.formatDate( toDoDetailDB.getDtDtTodoDue() )%>" />
            </td>
            <td>
              <impact:validateDate name="dtCompletedDate" tabIndex="<%=tabIndex%>" label="Completed Date"
                                   disabled="<%=ToDoConversation.getDisableCompleted( toDoDetailDB )%>"
                                   value="<%=FormattingHelper.formatDate( toDoDetailDB.getDtDtTodoCompleted() )%>" />
            </td>
          </tr>
          <tr>
            <td>
              <%-- 1 space is different from 0 spaces, so these must be on the same line --%>
              <input type="hidden" name="hdnIdPersAssigned" value="<%= toDoDetailDB.getUlIdTodoPersAssigned() %>">
              <span class="formRequiredText">*</span><impact:validateDisplayOnlyField name="dspSzScrTodoAssignedTo"
                                                      label="Assigned To"
                                                      value="<%=FormattingHelper.formatString( toDoDetailDB.getSzNmPersonFullAssigned() )%>"/>
            </td>
            <td>
<%//SIR 19783 - added preventDoubleClick and restrictRepost so that button will disable once clicked.%>
              <impact:ButtonTag name="btnSelectStaff"
                                img="btnSelectStaff"
                                tabIndex="<%=tabIndex++%>"
                                disabled='<%= "" + hidebtnSelectStaff %>'
                                function="javascript:disableValidation( 'frmToDoDetail' );"
                                form="frmToDoDetail"
                                restrictRepost="true"
                                preventDoubleClick="true"
                                action="/workload/ToDo/displayStaffSearch" />




            </td>
            <td>&nbsp;</td>
          </tr>
          <tr>
            <td>
              <impact:validateInput type="text" name="txtSzTxtTodoDesc" label="Short Description" colspan="3"
                                    size="80" maxLength="80" tabIndex="<%=tabIndex%>" required="true"
                                    value="<%=FormattingHelper.formatString( toDoDetailDB.getSzTxtTodoDesc() )%>"/>
            </td>
          </tr>
          <tr>
            <td valign="top">
              <impact:validateTextArea name="txtSzTxtTodoLongDesc"
                                       cols="80"
                                       rows="4"
                                       colspan="3"
                                       maxLength="300"
                                       constraint="Paragraph300"
                                       label="Description/Notes"
                                       tabIndex="<%=tabIndex++%>">
                <%=FormattingHelper.formatString( toDoDetailDB.getTxtTodoLongDesc() )%>
              </impact:validateTextArea>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <th colspan="2">Case Stage</th>
    </tr>
    <tr>
      <td width="50%">
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr>
            <td width="30%">
              <impact:validateDisplayOnlyField name="dspSzNmStage" label="Stage"
                                               value="<%=FormattingHelper.formatString( toDoDetailDB.getSzNmStage() )%>"/>
            </td>
          </tr>
          <tr>
            <td width="30%">
           
<%--
// SIR 19057 Hari Maralla: Set Label to "Task" if selSzCdTask code is "T" and "Alert" if the selSzCdTask is "A"
 if ("T".equals(toDoDetailDB.getSzCdTodoType())){
     ToDoType = "Task Type";
  } else {
    ToDoType = "Alert Type";
  }
  if( toDoDetailDB.getToDoMode().equals( ToDoConversation.TODO_MODE_NEW_CASE_TODO ) )
  {
--%><%--
                    <impact:validateSelect name="selSzCdTask" label="Task Type" tabIndex="<%=tabIndex++%>" required="true"
                                           onChange="javascript:updateShortDesc()"
                                           options="<%=toDoDetailDB.getValidSzCdTaskSet()%>"
                                           value="<%=toDoDetailDB.getSzCdTask()%>" />
--%><%--
  }  else  {
--%>
 <%--                   <impact:validateDisplayOnlyField name="dspSzCdTodoTask" label="<%=ToDoType%>"
                                                     value="<%=FormattingHelper.formatString( toDoDetailDB.getSzTxtTaskDecode() )%>"/>
--%<%--
  }
--%>
            </td>
          </tr>
        </table>
      </td>
      <td width="50%">
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr>
            <td width="30%">
              <impact:validateDisplayOnlyField name="dspSzNmPersonFull" label="Staff"
                                               value="<%=FormattingHelper.formatString( toDoDetailDB.getSzNmPersonFullWorker() )%>"/>
            </td>
          </tr>
          <tr>
            <td width="30%">
              <impact:validateDisplayOnlyField name="dspDtDtTaskDue" label="To-Do Due Date"
                                               value="<%=FormattingHelper.formatDate( toDoDetailDB.getDtDtTaskDue() )%>"/>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <th colspan="2">Created By</th>
    </tr>
    <tr>
      <td width="50%">
        <table border="0" cellspacing="0" cellpadding="3" width="100%">
          <tr>
            <td width="30%">
              <impact:validateDisplayOnlyField name="dspUlIdTodoPersCreator" label="Name"
                                               value="<%=FormattingHelper.formatString( toDoDetailDB.getSzNmPersonFullCreator() )%>"/>
            </td>
          </tr>
        </table>
<%
  String createdByDate = FormattingHelper.formatDate( toDoDetailDB.getDtDtTodoCreated() );
  String createdByTime = toDoDetailDB.getTmTmTodoCreated();
  if(toDoDetailDB.getLdIdTodo() == 0){
    createdByDate = "";
    createdByTime = "";
  }
%>
        <td width="50%">
          <table border="0" cellspacing="0" cellpadding="3" width="100%">
            <tr>
            <td width="30%">
              <impact:validateDisplayOnlyField name="dspDtDtTodoCreated" label="Date"
                                               value="<%= createdByDate %>"/>
            </td>
            
            
            <td width="30%">
              <impact:validateDisplayOnlyField name="timeDtDtTodoCreated" label="Time"
                                               value="<%= createdByTime %>"/>
            </td>    
            
          </tr>
        </table>
      </td>
    </tr>
  </table>
     
  <br>
  <div align="right">
  <%
    String saveAction = "/workload/ToDo/saveToDoDetail";
    String saveFunction = "disableStaffFinal();saveToDoDetail();";
    if(toDoDetailDB.isAlert()){
      saveAction = "/workload/ToDo/saveAlert";
      saveFunction = "";
    }
  %>
    <impact:ButtonTag name="btnSaveFinal"
                      img="btnSave"
                      form="frmToDoDetail"
                      action="<%= saveAction %>"
                      tabIndex="<%=tabIndex++%>"
                      function="<%= saveFunction %>"
                      restrictRepost="true"
                      preventDoubleClick="true"/>
  </div>
  <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">


  
</impact:validateForm>
<script language="Javascript">
<%--
  This has to be at the bottom, as the form must exist, or the function fails because it is pre-parsed
    before the page finishes loading.
--%>
<%
  Object assignedToClassName = request.getAttribute( ToDoDetailCustomValidation.ASSIGNED_TO_CLASS_KEY );
  if( assignedToClassName != null )
  {
%>
  window.attachEvent( 'onload', updateAssignedToLabel );
  function updateAssignedToLabel()
  {
    document.getElementById( "label_dspSzScrTodoAssignedTo_id" ).className="<%=assignedToClassName%>";
  }
<%
  }
%>
</script>
