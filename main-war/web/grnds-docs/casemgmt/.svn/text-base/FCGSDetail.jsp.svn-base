<%--
//*-----------------------------------------------------------------------------
//* JSP Name:     FCGS Detail
//* Created by:   Vishala Devarakonda
//* Date Created: 12/19/2006
//*
//* Description:
//* The FCGS Detail page, accessed through the sub-module, will provide a
//* facility for users to capture and document information associated with a Foster Care Case Plan's
//* Goals and Steps.  The FCGS Detail page
//* will add or contain the Goals and steps information.
//*
//* Change History:
//* Date        User              Description
//* --------    ----------------  --------------------------------------------------
//* 05/28/2008  arege             STGAP00007922: Reset button should work both before and after                    
//*                               save on the plan. If the plan is not been approved yet the reset 
//*                               button should reset the Step text to its Default value.
//* 03/01/2007  abgoode           Removed usage of HttpSession, replaced with BaseSessionStateManager.
//*                               Please see comments at line 92
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.Mapping"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.GoalsBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.StepBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FCGSSubmoduleConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>

<!--Start Main Content-->
<%BaseSessionStateManager state =
      //(BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      FCGSSubmoduleConversation.getSessionStateManager(request);

      %>

<impact:validateErrors />

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" language="Javascript1.2">
  // Check for changes before navigating off
  window.onbeforeunload = function ()
  {
    IsDirty();
  };
</script>
<%List<StepBean> stepBeanList = new ArrayList<StepBean>();
      List<StepBean> savedStepBeanList = new ArrayList<StepBean>();
      List<StepBean> newStepBeanList = new ArrayList<StepBean>();
      List<StepBean> remStepBeanList = new ArrayList<StepBean>();
      String editableMode = ArchitectureConstants.TRUE;
      String stepCodesTable = "";
      String cgCodesTable = "";
      String fieldsToBeSpellChecked = "txtGoals";
      String goalText = "";
      String goalId = "";
      String other = "";
      int arrayIndex = ContextHelper.getIntSafe(request, "fcgsIndex");
      int loopCounter = 0;
      int numSteps = 0;
      int tabIndex = 1;
      boolean displayReset = true;
      boolean displayDelete = false;

      // Get the page mode that was passed to the FCGS submodule by the including JSP.
      String pageMode = (String) state.getAttribute(FCGSSubmoduleConversation.PAGE_MODE_KEY, request);
      if (pageMode == null) {
        pageMode = PageModeConstants.MODIFY;
      }

      if (pageMode.equals(PageModeConstants.MODIFY)) {
        editableMode = ArchitectureConstants.FALSE;
        displayDelete = true;
      }
      //addStepIndicator indicates if the user wishes to add a new step (which is not predefined)
      String addStepIndicator = (String) state.getAttribute("addStepIndicator", request);
      String deleteStepIndicator = (String) state.getAttribute("deleteStepIndicator", request);
      GoalsBean selectedGoal = (GoalsBean) state.getAttribute("GoalsBean", request);
      String isAdd = (String) state.getAttribute("isAddFCGS", request);
      //The or condition in the if statement is added to accomodate the scenario where the goaltext is changed 
      //in add mode and the add a step button is clicked with out saving

      if (!ArchitectureConstants.TRUE.equals(isAdd) || ArchitectureConstants.Y.equals(addStepIndicator)) {
        goalText = FormattingHelper.formatString(selectedGoal.getLdTxtGoal());
        goalId = Integer.toString(selectedGoal.getIdGoal());
        other = FormattingHelper.formatString(selectedGoal.getLdTxtOth());
        savedStepBeanList = selectedGoal.getStepBeanList();
      }

      String goalReason = FormattingHelper.formatString(selectedGoal.getCdGoalRsn());
      String goalType = FormattingHelper.formatString(selectedGoal.getCdGoalTyp());
      String goalTypeDecoded = "";
      String fgcsTsLastUpdate = DateHelper.toISOString(selectedGoal.getDtLastUpdate());
      String codesTableRsn = "";
      if ("REU".equals(goalType)) {
        codesTableRsn = "CRURSN";
        goalTypeDecoded = "Reunification";
      } else if ("NRE".equals(goalType)) {
        codesTableRsn = "CNRRSN";
        goalTypeDecoded = "Nonreunification";
      } else if ("WTL".equals(goalType)) {
        codesTableRsn = "CWTLPGLS";
        goalTypeDecoded = "WTLP";
      } else if ("DFC".equals(goalType)) { // subsection DFCS in Child Plans does not have Goal reason so no code table
        codesTableRsn = "";
        goalTypeDecoded = "DFCS";
      } else if ("AFC".equals(goalType)) {
        codesTableRsn = "";
        goalTypeDecoded = "Aftercare";
      }
      String goalReasonDecoded = Lookup.simpleDecodeSafe(codesTableRsn, goalReason);

      //Setting the appropriate codes tables for the different goal type and goal reason combinations.
      if ("DFC".equals(goalType)) {
        cgCodesTable = "CCGDFCS";
        stepCodesTable = "CDFCSSG";
      } else if ("REU".equals(goalType)) {
        cgCodesTable = "CCGRU";
        if ("PHY".equals(goalReason)) {
          stepCodesTable = "CRUPA";
        } else if ("SXA".equals(goalReason)) {
          stepCodesTable = "CRUSA";
        } else if ("EMO".equals(goalReason)) {
          stepCodesTable = "CRUEA";
        } else if ("NEG".equals(goalReason)) {
          stepCodesTable = "CRUN";
        } else if ("MED".equals(goalReason)) {
          stepCodesTable = "CRUMN";
        } else if ("EDU".equals(goalReason)) {
          stepCodesTable = "CRUEDN";
        } else if ("ABA".equals(goalReason)) {
          stepCodesTable = "CRUA";
        } else if ("SUA".equals(goalReason)) {
          stepCodesTable = "CRUSAP";
        } else if ("MPP".equals(goalReason)) {
          stepCodesTable = "CRUMPIP";
        } else if ("OTH".equals(goalReason)) {
          stepCodesTable = "";
        }
      } else if ("NRE".equals(goalType)) {
        cgCodesTable = "CCGNRUN";
        if ("GUA".equals(goalReason)) {
          stepCodesTable = "CNRG";
        } else if ("LTF".equals(goalReason)) {
          stepCodesTable = "CNRPPLFC";
        } else if ("EMA".equals(goalReason)) {
          stepCodesTable = "CNRPPLE";
        } else if ("FWR".equals(goalReason)) {
          stepCodesTable = "CNRULFLR";
        } else if ("ADO".equals(goalReason)) {
          stepCodesTable = "CNRA";
        } else if ("XXX".equals(goalReason)) {
          stepCodesTable = "";
        }
      } else if ("AFC".equals(goalType)) {
        cgCodesTable = "";
        stepCodesTable = "";
      } else if ("WTL".equals(goalType)) {
        cgCodesTable = "CCGWTLP";
        if ("LSA".equals(goalReason)) {
          stepCodesTable = "CWLSSO";
        } else if ("WES".equals(goalReason)) {
          stepCodesTable = "CWWEJS";
        } else if ("WEE".equals(goalReason)) {
          stepCodesTable = "CWWEE";
        } else if ("HIS".equals(goalReason)) {
          stepCodesTable = "CWHSSO";
        } else if ("GED".equals(goalReason)) {
          stepCodesTable = "CWSO";
        } else if ("MHS".equals(goalReason)) {
          stepCodesTable = "CWMHSFF";
        } else if ("LSK".equals(goalReason)) {
          stepCodesTable = "CWLSFF";
        } else if ("PSP".equals(goalReason)) {
          stepCodesTable = "CWPSEP";
        } else if ("PSA".equals(goalReason)) {
          stepCodesTable = "CWPSEA";
        } else if ("OTH".equals(goalReason)) {
          stepCodesTable = "";
        }
      }
      //Getting the default goal text for the selected Goal Type from the codes 
      //table while adding a new Goal. 
      if (ArchitectureConstants.TRUE.equals(isAdd) && !ArchitectureConstants.Y.equals(addStepIndicator)) {
        displayDelete = false;
        if (cgCodesTable != null && !"".equals(cgCodesTable)) {
          Iterator cgCodeIterator = Lookup.getCategoryCollectionSortedByDecode(cgCodesTable).iterator();
          while (cgCodeIterator.hasNext()) {
            Mapping cgColumns = (Mapping) cgCodeIterator.next();
            String cgDecode = cgColumns.getValue();
            String cgCode = cgColumns.getKey();
            if ("DFC".equals(goalType)) {
              goalText = cgDecode;
              break;
            }
            if (cgCode.equals(goalReason)) {
              goalText = cgDecode;
              break;
            }
          }

        }
      }
      //Getting all the predefined steps from the codes table for the selected Type Reason combination and replacing
      //default values for each step with the saved values if any.
      int numOfAddedSteps = 0;
      if (request.getAttribute("numOfAddedSteps") != null) {
        numOfAddedSteps = (Integer) request.getAttribute("numOfAddedSteps");
      }
      if (!ArchitectureConstants.Y.equals(addStepIndicator) && !ArchitectureConstants.Y.equals(deleteStepIndicator)) {
       //STGAP00008108: Here we remove all the steps that are not predefined, but added and saved by the user from the 
       //savedStepBeanList and save them in the newStepBeanList.In the end this newStepBeanList will be appended to the
       //step list that will be displayed on the page.This is to make sure the added steps are displayed at the bottom 
       //of the list after all the predefined steps.
       //Begin
        if (savedStepBeanList != null) {
          Iterator it = savedStepBeanList.iterator();
          while (it.hasNext()) {
            StepBean savedStep = (StepBean) it.next();
            if (!StringHelper.isValid(savedStep.getLdCdStepCode())) {
              newStepBeanList.add(savedStep);
              remStepBeanList.add(savedStep);
            }
          }
          if (!remStepBeanList.isEmpty()) {
            for (int i = 0; i < remStepBeanList.size(); i++) {
              savedStepBeanList.remove(remStepBeanList.get(i));
            }
          }
        }
        //End
        if (stepCodesTable != null && !"".equals(stepCodesTable)) {
        //Here all the predefined steps are accessed as the codeIterator collection from the codes table
        //and looped through.The inner while loop loops through the savedStepBeanList and checks if any
        //of the saved step code matches with the predefined step code. If it does than the saved step is 
        //assigned to the StepBean and the StepBean is saved to the stepBeanList.We are doing this because
        //even if only some of the predefined steps are selected and saved on the page, when the page is 
        //displayed all the predefined steps should be displayed in the same order with the saved steps
        //having the updated information.
          Iterator codeIterator = Lookup.getCategoryCollectionSortedByDecode(stepCodesTable).iterator();
          while (codeIterator.hasNext()) {
            Mapping columns = (Mapping) codeIterator.next();
            String decode = columns.getValue();
            String code = columns.getKey();
            StepBean stepBean = new StepBean();
            stepBean.setLdCdStepCode(code);
            stepBean.setLdTxtStep(decode);
            if (savedStepBeanList != null) {
              Iterator it = savedStepBeanList.iterator();
              while (it.hasNext()) {
                StepBean savedStep = (StepBean) it.next();
                if (code.equals(savedStep.getLdCdStepCode())) {
                  stepBean = savedStep;
                  break;
                }
              }
            }
            stepBeanList.add(stepBean);
          }
        } else if (("AFC".equals(goalType) || "XXX".equals(goalReason) || "OTH".equals(goalReason))
                   && !ArchitectureConstants.TRUE.equals(isAdd)) {
          stepBeanList = selectedGoal.getStepBeanList();
        }
        if (numOfAddedSteps > 0) {

          for (int i = 0; i < numOfAddedSteps; i++) {
            StepBean newStepBean = new StepBean();
            stepBeanList.add(newStepBean);
          }
        }
        //Here newStepBeanList which contains all the steps that are not predefined but added and saved by the user
        //is added to the list so that all the added steps can be displayed at the end after the predefined steps.
        if (newStepBeanList != null) {
          for (Iterator it = newStepBeanList.iterator(); it.hasNext();) {
            StepBean newStep = (StepBean) it.next();
            stepBeanList.add(newStep);
          }
        }
      } else {
        stepBeanList = selectedGoal.getStepBeanList();
      }

      //After displaying the added step need to set the indicator to null.
      if (ArchitectureConstants.Y.equals(addStepIndicator)) {
        state.setAttribute("addStepIndicator", null, request);
      }
      selectedGoal.setStepBeanList(stepBeanList);

      state.setAttribute("GoalsBean", selectedGoal, request);

      %>
<script type="text/JavaScript" language="Javascript">

  
  //This function enables or disables the step fields for all steps dynamically
  //depending on the checked or unchecked status of the Selected check box.
  function enableStepFields(f0, f1, f2, f3, f4, f5, f8, f9, f10, f11, f12)
  {
    var cbxfield = eval("document.getElementById(\"" + f0 + "_Id\")");
    var field1 = eval("document.getElementById(\"" + f1 + "_Id\")");
    var field2 = eval("document.getElementById(\"" + f2 + "_Id\")");
    var field3 = eval("document.getElementById(\"" + f3 + "_Id\")");
    var field4 = eval("document.getElementById(\"" + f4 + "_Id\")");
    var field5 = eval("document.getElementById(\"" + f5 + "_Id\")");
    var field8 = eval("document.getElementById(f8)");
    var field9 = eval("document.getElementById(f9)");
    var field11 = eval("document.getElementById(\"" + f11 + "_Id\")");
    var field12 = eval("document.getElementById(\"" + f12 + "_Id\")");
    var disabled = cbxfield.checked;
    if (disabled) {
      field1.disabled = false;
      field2.disabled = false;
      field3.disabled = false;
      field4.disabled = false;
      field5.disabled = false;
      field11.disabled = false;
      field12.disabled = false;
      if (f10 == 'true') {
        field8.style.display = '';
        field9.style.display = 'none';
      } else {
        field9.style.display = '';
        field8.style.display = 'none';
      }
    } else {
      field1.disabled = true;
      field2.disabled = true;
      field3.disabled = true;
      field4.disabled = true;
      field5.disabled = true;
      field11.disabled = true;      
      field12.disabled = true;
      field11.value="";
      field12.value="";
      if (f10 == 'true') {
        field8.style.display = 'none';

      } else {
        field9.style.display = 'none';

      }

    }

  }
  function confirmDeleteThisSection()
  {
    var bUserResponse = confirm("<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>");
    if (bUserResponse)
    {
      disableValidation("frmFCGSDetail");
    }
    return bUserResponse;
  }
  function confirmDeleteThisStep(indexOfTask)
  {
    var bUserResponse = confirm("<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>");
    if (bUserResponse)
    {
      document.frmFCGSDetail.hdnDelIndex.value = indexOfTask;
      disableValidation("frmFCGSDetail");
    }
    return bUserResponse;
  }
  //This function resets the step text when the reset button is clicked.
  function setStepText(stName, hOriStepTxt)
  {
    var tfName = eval("document.getElementById(\"" + stName + "_Id\")");
    var hfOriStepTxt = eval("document.getElementById(\"" + hOriStepTxt + "_Id\")"); 
    var oriStepTxt = hfOriStepTxt.value;
    tfName.value = oriStepTxt;
    return false;
  }
  //This function enables or disables the date fields on load based on if the checkbox selected is checked for that step
  
  function disableDateFields()
  {
    var loop = eval("document.getElementById(\"" + "numOfSteps_Id\")");
  	
    for (var q = 0; q < loop.value; q++) {    
      var cbxName = eval("document.getElementById(\"" + "cbxSelected" + q + "_Id\")");      
      var dateAnt = eval("document.getElementById(\"" + "txtDtAntComp" + q + "_Id\")");
      var dateAct = eval("document.getElementById(\"" + "txtDtActComp" + q + "_Id\")");
      var checked = cbxName.checked;
      if (!checked) {            
        dateAnt.disabled = true;
        dateAct.disabled = true;
      } else {
        dateAnt.disabled = false;
        dateAct.disabled = false;
      }
    }
    return false;
  }
  
  window.attachEvent('onload', disableDateFields);
  //This function sets the hidden step id value when the delete button for the
  //step is clicked.
  function setDeleteParams(fnStepId) {
    var stepId = eval("document.getElementById(\"" + fnStepId + "_Id\")");
    document.frmFCGSDetail.hdnDelStepId.value = stepId.value;
  }

</script>
<impact:validateForm name="frmFCGSDetail" method="post" action="/casemgmt/FCGSDetail/saveFCGSDetail" pageMode="<%= pageMode %>" validationClass="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.FCGSCustomValidation" schema="/WEB-INF/Constraints.xsd">
	<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<impact:validateInput type="hidden" name="isAddFCGS" value="<%= isAdd %>" />
	<impact:validateInput type="hidden" name="fcgsIndex" value="<%= FormattingHelper.formatInt(arrayIndex) %>" />
	<impact:validateInput type="hidden" name="hdnGoalId" value="<%= goalId %>" />
	<impact:validateInput type="hidden" name="hdnGoalType" value="<%= goalType %>" />
	<impact:validateInput type="hidden" name="hdnCDGoalRsn" value="<%= goalReason %>" />
	<impact:validateInput type="hidden" name="hdnDelStepId" value="" />
	<impact:validateInput type="hidden" name="hdnDelIndex" value="" />
	<impact:validateInput type="hidden" name="fgcsTsLastUpdate" value="<%= fgcsTsLastUpdate %>" />

	<%//*********************************
      //**** FCGS DETAIL ****
      //*********************************

      %>

	<%if (!pageMode.equals(PageModeConstants.VIEW) && !ArchitectureConstants.TRUE.equals(isAdd)) {
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
				<impact:ButtonTag name="btnDeletethisSection" img="btnDeletethisSection" form="frmFCGSDetail" function="disableValidation('frmFCGSDetail')" editableMode="<%= displayDelete ? EditableMode.ALL : EditableMode.NONE %>" align="right"
					action="/casemgmt/FCGSDetail/deleteGoal" function="return confirmDeleteThisSection()" tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	</table>
	<%}
%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="3">
				Goal
			</th>
		</tr>
		<tr>
			<td>
				Goal Type
			</td>
			<td>
				<impact:validateDisplayOnlyField name="txtGoalType" label="" value="<%= goalTypeDecoded %>" />
			</td>
		</tr>
		<%if (!"DFC".equals(goalType) && !"AFC".equals(goalType)) {
%>
		<tr>
			<td>
				Reason
			</td>
			<td>
				<impact:validateDisplayOnlyField name="txtGoalReason" label="" value="<%= goalReasonDecoded %>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput label="If other, explain" name="szTxtOther" conditionallyRequired="true" colspan="1" tabIndex="<%= tabIndex++ %>" disabled="<%= editableMode %>" type="text" size="50" maxLength="50" constraint="Paragraph80" value="<%= other %>"
					cssClass="formInput" />
			</td>
		</tr>
		<%}
%>
		<tr>
			<td>
				<impact:validateTextArea label="Change/Goal" name="szTxtGoal" required="true" colspan="1" rows="3" cols="103" tabIndex="<%= tabIndex++ %>" disabled="<%= editableMode %>" maxLength="1000" constraint="Paragraph1000">
					<%=goalText%>
				</impact:validateTextArea>
			</td>
		</tr>
		<%//************************
      //**** Steps ****
      //************************

      %>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorderList">
			<tr>
				<td class="thList" colspan="2">
					Steps
				</td>
			</tr>
			<%// Display the Steps.
      if (!stepBeanList.isEmpty()) {
        Iterator iter = stepBeanList.iterator();
        while (iter.hasNext()) {
          StepBean stepBean = (StepBean) iter.next();

          String status = "";
          if (stepBean.getLdCdStatus() != null) {
            status = stepBean.getLdCdStatus();
          }
          if (stepBean.getLdCdStepCode() == null) {
            displayReset = false;

          }
          String isChecked;
          String stepEditableMode;
          String btnResVisibility;
          String btnDelVisibility;
          if ("Y".equals(stepBean.getIndSelected())) {
            isChecked = "true";
            stepEditableMode = "false";
            if (displayReset) {
              btnResVisibility = "";
              btnDelVisibility = "none";
            } else {
              btnDelVisibility = "";
              btnResVisibility = "none";
            }

          } else {
            btnResVisibility = "none";
            btnDelVisibility = "none";
            stepEditableMode = "true";
            isChecked = "false";
          }
          String append = "";
          String index = "errorIndex" + loopCounter;
          if (request.getAttribute(index) != null) {
            String eindex = (String) (request.getAttribute(index));
            if ("true".equals(eindex)) {
              stepEditableMode = "false";
              append = "_Disabled";
              if (displayReset) {
                btnResVisibility = "";
                btnDelVisibility = "none";
              } else {
                btnDelVisibility = "";
                btnResVisibility = "none";
              }

            }
          }
%>
			<tr <%= loopCounter % 2 == 1 ? "class='even'" : "" %>>
				<td valign="top">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td>
								<%String fieldName = "cbxSelected" + loopCounter;
          String fnSel = "cbxSelected" + loopCounter;
          String fnTxtPr = "szTxtPriority" + loopCounter;
          String fnTxtRsp = "szTxtRspns" + loopCounter;
          String fnTxtStep = "txtStep" + loopCounter;
          String fnTxtScmnt = "txtStepComm" + loopCounter;
          String fnStat = "szCdStatus" + loopCounter;
          String fnBtnRes = "resSpan" + loopCounter;
          String fnBtnDel = "delSpan" + loopCounter;
          String antCompDate = "txtDtAntComp" + loopCounter;
          String actCompDate = "txtDtActComp" + loopCounter;
          String IncOnClick = "enableStepFields('" + fnSel + "', '" + fnTxtPr + "', '" + fnTxtRsp + "', '" + fnTxtStep
                              + "', '" + fnTxtScmnt + "', '" + fnStat + "', '" + fnBtnRes + "', '" + fnBtnDel + "', '"
                              + displayReset + "', '" + antCompDate + "', '" + actCompDate + "');";

          %>
								<impact:validateInput label="Selected" name="<%= fieldName %>" type="checkbox" value="Y" onClick="<%= IncOnClick %>" checked="<%= isChecked %>" disabled="<%= editableMode %>" cssClass="formInput" tabIndex="<%= tabIndex++ %>" />
							</td>

							<td>
								<%fieldName = "szTxtPriority" + loopCounter + append;

          %>
								<impact:validateInput label="Priority" name="<%= fieldName %>" required="false" tabIndex="<%= tabIndex++ %>" disabled="<%= stepEditableMode %>" type="text" size="2" maxLength="2" constraint="Paragraph30"
									value="<%= FormattingHelper.formatString( stepBean.getLdTxtPriority()) %>" cssClass="formInput" />
							</td>

							<td>
								<%fieldName = "szTxtRspns" + loopCounter + append;
          fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", " + fieldName;

          %>
								<impact:validateInput label="Responsibility" name="<%= fieldName %>" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>" disabled="<%= stepEditableMode %>" type="text" size="30" maxLength="30" constraint="Paragraph30"
									value="<%= FormattingHelper.formatString( stepBean.getLdTxtResponsibility()) %>" cssClass="formInput" />
							</td>
					</table>
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>
							<td>
								<%// Step Id hidden field.
          fieldName = "hdnStepId" + loopCounter;

          %>
								<impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= FormattingHelper.formatInt( stepBean.getIdStep()) %>" />

								<%// Step Date Last Update hidden field.
          fieldName = "stepDtLastUpdate" + loopCounter + append;

          %>
								<impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= DateHelper.toISOString( stepBean.getDtLastUpdate()) %>" />
								<%// Step Code hidden field.
          fieldName = "hdnStepCode" + loopCounter;

          %>
								<impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= FormattingHelper.formatString( stepBean.getLdCdStepCode()) %>" />
								
								<%// Original or Default step text hidden field.
          fieldName = "hdnOriStepTxt" + loopCounter;

          %>
								<impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= Lookup.simpleDecodeSafe(stepCodesTable,stepBean.getLdCdStepCode()) %>" />
								
								
								<%// Step Text hidden field.
          fieldName = "hdnStepText" + loopCounter;

          %>
								<impact:validateInput type="hidden" name="<%= fieldName %>" value="<%= FormattingHelper.formatString( stepBean.getLdTxtStep()) %>" />
								<%//--------------------
          //--- Step ---
          //--------------------

          fieldName = "txtStep" + loopCounter + append;
          fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", " + fieldName;

          %>
								<impact:validateTextArea label="Step" name="<%= fieldName %>" conditionallyRequired="true" colspan="1" rows="3" cols="125" disabled="<%= stepEditableMode %>" tabIndex="<%= tabIndex++ %>" maxLength="1000" constraint="Paragraph1000">
									<%=FormattingHelper.formatString(stepBean.getLdTxtStep())%>
								</impact:validateTextArea>

							</td>
						</tr>
						<tr>
							<td>
								<%fieldName = "txtStepComm" + loopCounter + append;
          fieldsToBeSpellChecked = fieldsToBeSpellChecked + ", " + fieldName;

          %>
								<impact:validateTextArea label="Comment" name="<%= fieldName %>" required="false" colspan="1" rows="3" cols="125" onBlur="if(this.value.length>1000){alert('Please enter no more than 300 characters of text in the Comment textbox.');}"
									disabled="<%= stepEditableMode %>" tabIndex="<%= tabIndex++ %>" maxLength="1000" constraint="Paragraph1000">
									<%=FormattingHelper.formatString(stepBean.getLdTxtStepCmnts())%>
								</impact:validateTextArea>
							</td>
						</tr>

					</table>
				</td>
			</tr>
			<tr <%= loopCounter % 2 == 1 ? "class='even'" : "" %>>
				<td colspan="2" valign="top">
					<table border="0" cellpadding="0" cellspacing="0" width="100%">
						<tr>

							<td>
								<%fieldName = "szCdStatus" + loopCounter + append;

          %>
								<impact:validateSelect tabIndex="<%= tabIndex++ %>" label="Status" disabled="<%=stepEditableMode %>" name="<%= fieldName %>" width="20%" value="<%=status%>" conditionallyRequired="true" codesTable="CSTATUS" />
							</td>

							<td width="23%">
								<%//------------------------------
          //--- Anticipated Completion ---
          //------------------------------
          String dateAsString = "";
          String cbxSelAnt = "cbxSelected" + loopCounter;
          if (stepBean.getDtAntComp() != null) {
            dateAsString = FormattingHelper.formatDate(stepBean.getDtAntComp());
          }

          fieldName = "txtDtAntComp" + loopCounter;

          %>
								<impact:validateDate label="Anticipated Completion" name="<%= fieldName %>" type="text" value="<%= dateAsString %>" size="10" width="15%" conditionallyRequired="true" tabIndex="<%= tabIndex++ %>" constraint="Date" />
							</td>

							<td width="23%">
								<%//------------------------------
          //--- Actual Completion ---
          //------------------------------
          dateAsString = "";
          String cbxSelAct = "cbxSelected" + loopCounter;
          if (stepBean.getDtActComp() != null) {
            dateAsString = FormattingHelper.formatDate(stepBean.getDtActComp());
          }
          fieldName = "txtDtActComp" + loopCounter;

          %>
								<impact:validateDate label="Actual Completion" name="<%= fieldName %>" type="text" value="<%= dateAsString %>" size="10" width="15%" tabIndex="<%= tabIndex++ %>" constraint="Date" />

							</td>

						</tr>
					</table>
					<table border="0" cellpadding="3" cellspacing="0" width="100%">
						<tr>

							<td>
								<%String fieldNameRes;
          fieldNameRes = "resSpan" + loopCounter;

          // The Reset button should be displayed only if this
          // Step is editable.
          fieldName = "btnResetStep" + loopCounter;
          String fnhStext = "hdnStepText" + loopCounter;                              
          String sTextName = "txtStep" + loopCounter;  
          String hOriStepTxt = "hdnOriStepTxt" + loopCounter;            
          String resetFunctionString = "return setStepText('" + sTextName + "','" + hOriStepTxt + "');";

          %>
								<span id="<%=fieldNameRes%>" style="display:<%= btnResVisibility %>"> <impact:ButtonTag name="<%= fieldName %>" img="btnReset" navAwayCk="true" 
								       function="<%= resetFunctionString %>" form="frmFCGSDetail"
										action="/casemgmt/FCGSDetail/displayFCGSDetail" tabIndex="<%= tabIndex++ %>" /> </span>

								<%String fieldNameDel;
          fieldNameDel = "delSpan" + loopCounter;%>
								<%fieldName = "btnDeleteStep" + loopCounter;
          String fnStepId = "hdnStepId" + loopCounter;
          String deleteFunctionString = "setDeleteParams('" + fnStepId + "');return confirmDeleteThisStep('"
                                        + loopCounter + "')";

          %>
								<span id="<%=fieldNameDel%>" style="display:<%= btnDelVisibility %>"> <impact:ButtonTag name="<%= fieldName %>" img="btnDelete" function="<%= deleteFunctionString %>" form="frmFCGSDetail" action="/casemgmt/FCGSDetail/deleteStep"
										tabIndex="<%= tabIndex++ %>" /> </span>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<%loopCounter++;
        } // end while ( iter.hasNext() )
      }//end if not empty

      %>
		</table>

		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tr>
				<td>
					<impact:ButtonTag name="btnAddStep" img="btnAdd" function="disableValidation('frmFCGSDetail')" disabled="<%= editableMode %>" align="right" form="frmFCGSDetail" action="/casemgmt/FCGSDetail/addGoalStep" tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>
		</table>
		<br>
		<%// The steps counter should be the number of steps in the
      // Collection plus 1 since the Collection is zero-based.
      numSteps = numSteps + loopCounter;
%>
		<impact:validateInput type="hidden" name="numOfSteps" value="<%= String.valueOf( loopCounter ) %>" />


		<%//*****************
      //**** BUTTONS ****
      //*****************

      %>
		<br>
		<hr>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tr>
				<%// STGAP00004865 - it makes more sense to hide Spell Check when page is uneditable
      if (ArchitectureConstants.FALSE.equals(editableMode)) {

        %>
				<td width="90%" align="right">
					<impact:spellCheck formToSpellCheck="frmFCGSDetail" fieldsToSpellCheck="<%= fieldsToBeSpellChecked %>" tabIndex="<%=tabIndex++%>" />
				</td>
				<%}

      %>
				<td align="right">
					<impact:ButtonTag name="btnFCGSSave" img="btnSave" restrictRepost="true" preventDoubleClick="true" form="frmFCGSDetail" action="/casemgmt/FCGSDetail/saveFCGSDetail" disabled="<%= editableMode %>" tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>
		</table>
		</impact:validateForm>