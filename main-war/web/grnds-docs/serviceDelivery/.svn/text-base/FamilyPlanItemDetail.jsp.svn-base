<%//--------------------------------------------------------------------------------
      //  JSP Name:     Family Plan Item Detail
      //  Created by:   Jason Rios
      //  Date Created: 02/05/03
      //
      //  Description:
      //  This JSP displays the Family Plan Item Details.
      //
      //  Change History:
      //  Date      User         Description
      //  --------  ------------ -------------------------------------------------------
      //  02/27/04  RIOSJA       SIR 22574 - Added validateDateCreated() JavaScript to
      //                         warn the user if the Date Created is invalid. User must
      //                         fix the date before continuing. This validation is needed
      //                         because all validation is disabled if the Current Level
      //                         of Concern is 'None' or 'Very Little' (see
      //                         disableValidationIfNotNeeded() JavaScript function), and
      //                         invalid dates were causing problems.
      //
      //  11/04/04  thompswa     SIR 22813 - Change maxLength txtGoals, txtTask,
      //                         txtEval to "1000".
      //  02/09/07  vdevarak     Georgia Shines changes: 
      //                         1.Changed the Initial Level Of Concern and Current Level 
      //                         Of Concern fields which were drop down boxes previously to 
      //                         display only fields. 
      //                         2. Replaced Task Completed Checkbox by date field to capture
      //                         the actual date completed for GA SACWIS.
      //                         3. Add Progress Text box, Date of Court Action and Court 
      //                         Mandated Step fields are added.  
      //  10/20/08  charden      wrote code to determine new tasks created on updated family plan item detail 
      //                         so that delete button will displayed for these new tasks
      //--------------------------------------------------------------------------------%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.Sets"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalItemValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanEvalValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanItemValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanTaskValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.dao.servicedelivery.FamilyPlanValueBean" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanConversation" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Map" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.service.casemgmt.FamilyPlanBean" %>

<%
  //*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
  int loopCounter = 0;
  int tabIndex = 1;
  FamilyPlanValueBean familyPlanBean = null;
  FamilyPlanItemValueBean familyPlanItemBean = null;
  Collection familyPlanEvaluations = null;
  Collection evaluationItems = null;
  FamilyPlanEvalValueBean mostRecentEval = null;
  FamilyPlanEvalItemValueBean mostRecentEvalItem = null;
  Iterator iter = null;
  String fieldName = null;
  String fieldValue = null;
  String isChecked = null;
  String dateAsString = null;
  String compDate = null;
  String editableMode = ArchitectureConstants.FALSE;
  String taskEditableMode = ArchitectureConstants.FALSE;
  String btnVisible = ArchitectureConstants.FALSE;
  String disableProgress = ArchitectureConstants.FALSE;
  String dateCompVisible = ArchitectureConstants.TRUE;
  String provideBlankValue = null;
  String currentLOCFieldIsRequired = "";
  String fieldIsDisabled = null;
  String fieldsToBeSpellChecked = "txtGoals";
  int taskCompletedEditableMode = 0;
  String initialConcernLevel = "";
  String currentConcernLevel = "";
  String set = "";
  String pageMode = "";

  //**************************
  //*** RETRIEVE PAGE DATA ***
  //**************************
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  familyPlanBean = (FamilyPlanValueBean) state.getAttribute("familyPlanBean", request);
  familyPlanItemBean = (FamilyPlanItemValueBean) state.getAttribute("familyPlanItemBean", request);
  iter = familyPlanBean.getFamilyPlanItemList().iterator();
  //Get the Initial and Current level of concern values from the family plan bean for the selected area of concern
  while (iter.hasNext()) {
    FamilyPlanItemValueBean itemBean = (FamilyPlanItemValueBean) iter.next();
    if (familyPlanBean.getFamilyPlanId() != 0) {
      if (itemBean.getAreaOfConcernCode().equals(familyPlanItemBean.getAreaOfConcernCode())) {
        initialConcernLevel = Lookup.simpleDecodeSafe("CRISKSOC", itemBean.getInitialLevelOfConcernScale());
        currentConcernLevel = Lookup.simpleDecodeSafe("CRISKSOC", itemBean.getCurrentLevelOfConcernScale());
        break;
      }
    }
  }
  Date mostRecentApprovalDate = null;
  if (CodesTables.CEVTSTAT_APRV.equals(familyPlanBean.getFamilyPlanEvent().getEventStatusCode())) {
    mostRecentApprovalDate = familyPlanBean.getFamilyPlanEvent().getDateLastUpdate();
  }
  //*********************
  //*** SET PAGE MODE ***
  //*********************
  set = Sets.getPageSet(request);
  if (familyPlanItemBean.getGoals() == null || "".equals(familyPlanItemBean.getGoals())) {
    set = "A";
  }
  if (familyPlanBean.isCopiedPlan()) {
    set = "N";
  }
  if (familyPlanBean.isUpdatedPlan()) {
    set = "E";
  }

  if (PageMode.getPageMode(request) != null) {
    pageMode = PageMode.getPageMode(request);
  }

  if (CodesTables.CEVTSTAT_APRV.equals(familyPlanBean.getFamilyPlanEvent().getEventStatusCode())) {
    if (!"N".equals(set) && !"E".equals(set)) {

      pageMode = PageModeConstants.VIEW;
    }
  }
  if ("E".equals(set) || "A".equals(set)) {
    btnVisible = ArchitectureConstants.TRUE;
  }
  if ("E".equals(set)) {
    dateCompVisible = ArchitectureConstants.FALSE;
  }
  if (PageModeConstants.VIEW.equals(pageMode)) {
    editableMode = ArchitectureConstants.TRUE;
    dateCompVisible = ArchitectureConstants.TRUE;
    disableProgress = ArchitectureConstants.TRUE;

  }
%>

<%
  //******************
  //*** JAVASCRIPT ***
  //******************
%>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/javascript" language="JavaScript1.2">
window.onbeforeunload = function ()
{
  IsDirty();
};

function confirmDeleteThisSection()
{
  var bUserResponse = confirm( "<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>" );
  if ( bUserResponse == true )
  {
    disableValidation("frmFamilyPlanItem");
  }
  return bUserResponse;
}

function confirmDeleteThisTask( indexOfTask )
{
  var bUserResponse = confirm( "<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_DELETE)%>" );
  if ( bUserResponse == true )
  {
    document.frmFamilyPlanItem.indexOfTaskToDelete.value = indexOfTask;
  }
  return bUserResponse;
}

function disableValidationIfNotNeeded()
{
  <%
    // If 'Current Level of Concern' is 'None' or 'Very Little',
    // user should not be forced to enter Goals or Tasks.
    if(currentConcernLevel.equals("None") || currentConcernLevel.equals("Very Little") )
    {%>
      disableValidation("frmFamilyPlanItem");
      
  <%}
  %>
  
}

// SIR 22574 - Warns the user if the Date Created is invalid. User
// must fix the date before continuing. This validation is needed
// because all validation is disabled if the Current Level of Concern
// is 'None' or 'Very Little' (see disableValidationIfNotNeeded()
// JavaScript function above), and invalid dates were causing problems.
function validateDateCreated( oDate )
{
  if( oDate.value != "" )
  {
    if( validateDateString( oDate.value ) == "INVALID" )
    {
      alert('<%=MessageLookup.getMessageByNumber(Messages.MSG_ARC_CONSTR_DATE)%>');
      oDate.focus();
    }
  }
}
</script>

<%
  //*************************
  //*** VALIDATION ERRORS ***
  //*************************
%>
<%
  /* Include custom tag for displaying errors on the page */
%>
<impact:validateErrors/>

<%
  //****************************************************
  //**** FORM (FAMILY PLAN ITEM DETAIL) STARTS HERE ****
  //****************************************************
%>
<impact:validateForm
  name="frmFamilyPlanItem"
  method="post"
  action="/serviceDelivery/FamilyPlan/displayFamilyPlanItem"
  validationClass="gov.georgia.dhr.dfcs.sacwis.web.servicedelivery.FamilyPlanCustomValidation"
  pageMode="<%=pageMode%>"
  schema="/WEB-INF/Constraints.xsd">

<impact:validateInput
  type="hidden"
  name="hdnFamilyPlanEventId"
  value="<%=FormattingHelper.formatInt(familyPlanItemBean.getFamilyPlanEventId())%>"/>

<impact:validateInput
  type="hidden"
  name="hdnFamilyPlanItemId"
  value="<%=FormattingHelper.formatInt(familyPlanItemBean.getFamilyPlanItemId())%>"/>

<impact:validateInput
  type="hidden"
  name="hdnFamilyPlanItemDateLastUpdate"
  value="<%=DateHelper.toISOString(familyPlanItemBean.getFamilyPlanItemDateLastUpdate())%>"/>

<%
  // Date Initially Addressed should default to today's date.
    dateAsString = DateHelper.toISOString(new Date());
    if (familyPlanItemBean.getDateInitiallyAddressed() != null) {
      dateAsString = DateHelper.toISOString(familyPlanItemBean.getDateInitiallyAddressed());
    }
    if (familyPlanItemBean.getDateGoalsCompleted() != null) {
      compDate = DateHelper.toISOString(familyPlanItemBean.getDateGoalsCompleted());
    } else {
      compDate = "";
    }
%>
<impact:validateInput
  type="hidden"
  name="hdnDateInitiallyAddressed"
  value="<%=dateAsString%>"/>

<impact:validateInput
  type="hidden"
  name="hdnCaseId"
  value="<%=String.valueOf(familyPlanBean.getCaseId())%>"/>

<impact:validateInput
  type="hidden"
  name="indexOfTaskToDelete"
  value=""/>
  
<%
    //************************************
      //**** DELETE THIS SECTION BUTTON ****
      //************************************
      // The 'Delete this Section' button should be displayed only if: 1) this
      // item has been addressed, and 2) this item was not imported from the risk
      // assessment, and 3) this item has not been approved (meaning the 'Date
      // Initially Addressed' is after the most recent approval date, if it exists).
      if (familyPlanItemBean.getDateInitiallyAddressed() != null
          && !familyPlanItemBean.isIdentifiedInRiskAssessment()
          && (mostRecentApprovalDate == null || familyPlanItemBean.getDateInitiallyAddressed()
                                                                  .after(mostRecentApprovalDate))) {
  %>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tr>
      <td>
        <impact:ButtonTag
          name="<%=FamilyPlanConversation.DELETE_THIS_SECTION_BUTTON%>"
          img="btnDeletethisSection"
          form="frmFamilyPlanItem"
          align="right"
          disabled="<%=btnVisible%>"
          action="/serviceDelivery/FamilyPlan/deleteFamilyPlanItem"
          function="return confirmDeleteThisSection()"
          tabIndex="<%=tabIndex++%>"/>
      </td>
    </tr>
  </table>
<%
  }
%>

<%
  //*********************************
    //**** FAMILY PLAN ITEM DETAIL ****
    //*********************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><th colspan="3">Family Plan Item Detail</th></tr>
  <tr>
    <td width="30%">Area of Concern:</td>
    <td width="40%">
      <impact:validateDisplayOnlyField
        name="txtAreaOfConcern"
        label=""
        value="<%=familyPlanItemBean.getAreaOfConcernText()%>" />
      <impact:validateInput
        type="hidden"
        name="hdnAreaOfConcernText"
        value="<%=FormattingHelper.formatString(familyPlanItemBean.getAreaOfConcernText())%>"/>
      <impact:validateInput
        type="hidden"
        name="hdnAreaOfConcernCode"
        value="<%=FormattingHelper.formatString(familyPlanItemBean.getAreaOfConcernCode())%>"/>
    </td>
  </tr>
  <tr>
    <td>
      <%
        //-------------
          //--- Goals ---
          //-------------
      %>
      <impact:validateTextArea
        label="Goals"
        name="txtGoals"
        required="true"
        colspan="1"
        rows="4"
        cols="103"
        tabIndex="<%=tabIndex++%>"
        disabled="<%=editableMode%>"
        onBlur="if(this.value.length>1000){alert('Please enter no more than 1000 characters of text in the Goals textbox.');}"
        maxLength="1000"
        constraint="Paragraph1000">
      <%=FormattingHelper.formatString(familyPlanItemBean.getGoals())%>
      </impact:validateTextArea>
    </td>
  </tr>
  <tr>
  <td>
  <impact:validateDate
                label="Date Goals Completed"
                name="txtDtGoalComp"
                type="text"
                value="<%=compDate%>"
                size="10"
                width="40%"
                conditionallyRequired="true"
                disabled="<%=dateCompVisible%>"
                onBlur="javascript:validateDateCreated(this);"
                tabIndex="<%=tabIndex++%>"
                constraint="Date"/>
            </td>
     <td width = "20%">
      <impact:ButtonTag
        name="btnGoals"
        img="btnGoals"
        form="frmFamilyPlanItem"
        align="right"
        disabled="<%=editableMode%>"
        action="/serviceDelivery/FamilyPlan/displayFamilyPlanGoals"
        function="disableValidation('frmFamilyPlanItem')"
        tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <table width=100% cellspacing="0" cellpadding="0" border="0">
        <tr>
         <td width="30%">
            <impact:validateDisplayOnlyField
              name="txtInitialLevelOfConcern"
              label="Initial Level of Concern"
              value="<%=initialConcernLevel%>"/>
             </td>
          <td width="40%">
            <impact:validateDisplayOnlyField
              name="txtCurrentLevelOfConcern"
              label="Current Level of Concern"
              value="<%=currentConcernLevel%>"/>
           </td>
        </tr>
      </table>
    </td>
  </tr>
</table>
<br>

<%
  //************************
    //**** TASKS/SERVICES ****
    //************************
%>
<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderList">
  <tr><td class="thList" colspan="2">Steps</td></tr>
  <%
    // Display the task/services.

      //STGAP00010574 - retrieve maps and area of concern code from state in order to get already saved tasks.
      //Will iterate through the "old" tasks and compare them against the "current" tasks to determine if the delete
      //button should be displayed for the tasks
      String selectedAreaOfConcernCode = (String) state.getAttribute("selectedAreaOfConcernCode", request);
      String beanName = selectedAreaOfConcernCode + "Bean";
      Boolean doDelete = (Boolean) state.getAttribute("doDelete", request) == null ? false : true; 
      Map<String, String> areasOfConcernMap = (Map<String, String>) state.getAttribute("areasOfConcernMap", request);
      Map<String, FamilyPlanItemValueBean> familyPlanItemBeanMap = (Map<String, FamilyPlanItemValueBean>) state.getAttribute("familyPlanItemBeanMap",request);
      FamilyPlanItemValueBean oldFamilyPlanBean = (FamilyPlanItemValueBean) familyPlanItemBeanMap.get(beanName);
      List<FamilyPlanTaskValueBean> tasksList = (List<FamilyPlanTaskValueBean>) oldFamilyPlanBean.getTasks();
      iter = familyPlanItemBean.getTasks().iterator();
      while (iter.hasNext()) {
        FamilyPlanTaskValueBean taskBean = (FamilyPlanTaskValueBean) iter.next();
        Iterator iter1 = tasksList.iterator();
        taskEditableMode = ArchitectureConstants.FALSE;
        int idTask = taskBean.getFamilyPlanTaskId();

        // Determine whether or not the task/service is editable. A task/service
        // is editable until it has been approved by the supervisor; therefore,
        // compare the most recent approval date (of either the plan or an evaluation)
        // to the Task Created date. If the most recent approval date is before or the
        // same as the Task Created date, then the task/service has been approved and
        // is no longer editable. If the task is editable, however, it should be added
        // to the list of fields to be spell-checked.
        if ("E".equals(set) && (taskBean.getTask() != null && !"".equals(taskBean.getTask()))) {
        //id update an approved family plan, iterate through the tasks each time the page is displayed to compare the tasks
        //to be displayed with the tasks that were originally pulled from the database
          if (doDelete) {
            while (iter1.hasNext()) {
              FamilyPlanTaskValueBean task1 = (FamilyPlanTaskValueBean) iter1.next();
              int idTask1 = task1.getFamilyPlanTaskId();
              if (idTask == idTask1) {
                taskEditableMode = ArchitectureConstants.TRUE;
                break;
              }
            }
          }
        }
        if (taskBean.getTask() == null || "".equals(taskBean.getTask()) || "M".equals(set)) {
          disableProgress = ArchitectureConstants.TRUE;
        }
  %>
    <tr <% if ( loopCounter%2 == 1 ) { %>class="even"<% } %>>
      <td valign="top" >
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr>
            <td>
              Step/Service:<br>
              Include Beginning and Ending Dates (and/or Frequency).&nbsp;&nbsp;&nbsp;&nbsp;
              Add Separate Step/Service/Dates for CPS or Other Service.
            </td>
          </tr>
          <br>
          <tr>
            <td>
              <%
                // Task Id hidden field.
                    fieldName = "hdnTaskId" + loopCounter;
              %>
              <impact:validateInput
                type="hidden"
                name="<%=fieldName%>"
                value="<%=FormattingHelper.formatInt(taskBean.getFamilyPlanTaskId())%>"/>
              <%
                // Task Date Last Update hidden field.
                    dateAsString = "";
                    if (taskBean.getFamilyPlanTaskDateLastUpdate() != null) {
                      dateAsString = DateHelper.toISOString(taskBean.getFamilyPlanTaskDateLastUpdate());
                    }
                    fieldName = "hdnTaskDateLastUpdate" + loopCounter;
              %>
              <impact:validateInput
                type="hidden"
                name="<%=fieldName%>"
                value="<%=dateAsString%>"/>
              <%
                //--------------------
                    //--- Task/Service ---
                    //--------------------
                    fieldName = "txtTask" + loopCounter;
                    // SPB - SIR 19789 - Added onBlur
              %>
              <impact:validateTextArea
                name="<%=fieldName%>"
                required="false"
                colspan="1"
                rows="3"
                cols="125"
                onBlur="if(this.value.length>1000){alert('Please enter no more than 1000 characters of text in the Task/Service textbox.');}"
                disabled="<%=taskEditableMode%>"
                tabIndex="<%=tabIndex++%>"
                maxLength="1000"
                constraint="Paragraph1000">
              <%=FormattingHelper.formatString(taskBean.getTask())%>
              </impact:validateTextArea>
            </td>
          </tr>
          <tr>
            <td>
              <br> Progress:<br>
            </td>
          </tr>
         <tr>
          <td >
          <%
            fieldName = "txtProgress" + loopCounter;
          %>
          <impact:validateTextArea
                name="<%=fieldName%>"
                required="false"
                colspan="1"
                rows="3"
                cols="125"
                onBlur="if(this.value.length>500){alert('Please enter no more than 500 characters of text in the Task/Service textbox.');}"
                disabled="<%=disableProgress%>"
                tabIndex="<%=tabIndex++%>"
                maxLength="500"
                constraint="Paragraph500">
              <%=FormattingHelper.formatString(taskBean.getProgress())%>
              </impact:validateTextArea>
            </td>
          </tr>
          
        </table>
      </td>
    </tr>
    <tr <% if ( loopCounter%2 == 1 ) { %>class="even"<% } %>>
      <td colspan="2" valign="top">
        <table border="0" cellpadding="0" cellspacing="0" width="100%">
          <tr>
           <td >
              <%
                //-------------------------
                    //--- Date Task Created ---
                    //-------------------------
                    dateAsString = "";
                    if (taskBean.getDateTaskCreated() != null) {
                      dateAsString = FormattingHelper.formatDate(taskBean.getDateTaskCreated());
                    }
                    fieldName = "txtDateCreated" + loopCounter;
              %>
              <impact:validateDate
                label="Date Created"
                name="<%=fieldName%>"
                type="text"
                value="<%=dateAsString%>"
                size="10"
                width="18%"
                conditionallyRequired="true"
                disabled="<%=taskEditableMode%>"
                onBlur="javascript:validateDateCreated(this);"
                tabIndex="<%=tabIndex++%>"
                constraint="Date"/>
            </td>
            <td>
            <%
              //-------------------------
                  //--- Date Task Completed ---
                  //-------------------------
                  dateAsString = "";
                  if (taskBean.getDateTaskCompleted() != null) {
                    dateAsString = FormattingHelper.formatDate(taskBean.getDateTaskCompleted());
                  }
                  fieldName = "txtDateCompleted" + loopCounter;
            %>
            <impact:validateDate
                label="Date Completed"
                name="<%=fieldName%>"
                type="text"
                value="<%=dateAsString%>"
                size="10"
                width="18%"
                conditionallyRequired="true"
                disabled="<%=editableMode%>"
                onBlur="javascript:validateDateCreated(this);"
                tabIndex="<%=tabIndex++%>"
                constraint="Date"/>
            </td>
           
            <td>
              <%
                //---------------------
                    //--- Court Ordered ---
                    //---------------------
                    isChecked = "false";
                    if (taskBean.isCourtOrderedTask()) {
                      isChecked = "true";
                    }
                    fieldName = "cbxCourtOrdered" + loopCounter;
              %>
              <impact:validateInput
                label="Court Mandated Step"
                name="<%=fieldName%>"
                type="checkbox"
                value="Y"
                checked="<%=isChecked%>"
                disabled="<%=taskEditableMode%>"
                cssClass="formInput"
                tabIndex="<%=tabIndex++%>" />
            </td>
          </tr>
          <tr>
          <td >
              <%
                //---------------------
                    //--- Delete Button ---
                    //---------------------
                    // The delete button should be displayed only if this
                    // task/service is editable.
                    String deleteFunctionString = "disableValidation('frmFamilyPlanItem');return confirmDeleteThisTask("
                                                  + loopCounter + ")";
              %>
                <impact:ButtonTag
                  name="btnDelete"
                  img="btnDelete"
                  form="frmFamilyPlanItem"
                  disabled="<%=taskEditableMode%>"
                  action="/serviceDelivery/FamilyPlan/deleteFamilyPlanTask"
                  function="<%=deleteFunctionString%>"
                  tabIndex="<%=tabIndex++%>"/>
              
            </td>
            <td></td>
          <td>
          <%
            //-------------------------
                //--- Date of Court Action ---
                //-------------------------
                dateAsString = "";
                if (taskBean.getDateCourtAction() != null) {
                  dateAsString = FormattingHelper.formatDate(taskBean.getDateCourtAction());
                }
                fieldName = "txtDateCourtAction" + loopCounter;
          %>
          <impact:validateDate
                label="Date of Court Action"
                name="<%=fieldName%>"
                type="text"
                value="<%=dateAsString%>"
                size="10"
                width="15%"
                conditionallyRequired="true"
                disabled="<%=editableMode%>"
                onBlur="javascript:validateDateCreated(this);"
                tabIndex="<%=tabIndex++%>"
                constraint="Date"/>
            </td>
            <td width="23%">
            <%
              //---------------------
                  //--- Court Mandated Closure ---
                  //---------------------
                  isChecked = "false";
                  if (taskBean.isCourtMandatedClosure()) {
                    isChecked = "true";
                  }
                  fieldName = "cbxCourtMandatedClosure" + loopCounter;
            %>
            <impact:validateInput
                label="Court Mandated Closure"
                name="<%=fieldName%>"
                type="checkbox"
                value="Y"
                checked="<%=isChecked%>"
                disabled="<%=editableMode%>"
                cssClass="formInput"
                tabIndex="<%=tabIndex++%>" />
          </td>
          </tr>
          </table>
      </td>
    </tr>
    <%
      loopCounter++;
        } // end while ( iter.hasNext() )
    %>
</table>

<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td>
      <impact:ButtonTag
        name="btnAdd"
        img="btnAdd"
        align="right"
        form="frmFamilyPlanItem"
        disabled="<%=editableMode%>"
        action="/serviceDelivery/FamilyPlan/addFamilyPlanTask"
        function="disableValidation('frmFamilyPlanItem')"
        tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>
<br>

<%
  // The tasks counter should be the number of tasks in the
    // Collection plus 1 since the Collection is zero-based.
%>
<impact:validateInput
  type="hidden"
  name="numOfTasks"
  value="<%=String.valueOf(loopCounter)%>"/>


<%
  //*****************
    //**** BUTTONS ****
    //*****************
%>
<br>
<hr>
<table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
    <td width="90%" align="right">
      <impact:spellCheck
        formToSpellCheck="frmFamilyPlanItem"
        fieldsToSpellCheck="<%=fieldsToBeSpellChecked%>"
        tabIndex="<%=tabIndex++%>"/>
    </td>
    <td>
      <impact:ButtonTag
        name="<%=FamilyPlanConversation.SAVE_BUTTON_ON_ITEM_PAGE%>"
        img="btnSave"
        align="right"
        form="frmFamilyPlanItem"
        disabled="<%=editableMode%>"
        function="disableValidationIfNotNeeded()"
        action="/serviceDelivery/FamilyPlan/saveFamilyPlanItem"
        tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
</table>

<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
</impact:validateForm>
<%
  //**************************************************
  //**** FORM (FAMILY PLAN ITEM DETAIL) ENDS HERE ****
  //**************************************************
%>
