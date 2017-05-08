<%//*  JSP Name:     Child Plan Detail JSP
      //*  Created by:   Jacob Vaidyan
      //*  Date Created: 1/8/2007
      //*
      //*  Description:This Page is for the ChildPlan Detail for SUB stage.
      //*
      //** Change History:
      //**  Date      User              Description
      //**  --------  ----------------  --------------------------------------------------
      //**  8/1/08    charden		     STGAP00006668 - added isFormChanged() function to btnAddEdu button to alert
      //**							     user to save page before navigating away from page
      //**  10/29/08  mxpatel           STGAP00010684 - added "==true" to the savePageAdd() function and replaced the return false
      //**                              with "return true" in the else.
      //**  12/19/08  mxpatel           STGAP00007158 - added IF statement to print "__________" instead of null, when displaying 
      //**                              rsource without name in the education section. (Making it consistent with person detail page).
      //**
      //**%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact" %>


<%@ page import="java.util.List"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Iterator"%>
<%@ page import="java.util.Collection"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.Calendar"%>
<%@ page import="org.exolab.castor.types.Date"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailList"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean"%>
<%@ page import="java.util.Enumeration"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY" %>

<%
  //*--------------------------------------------------------------------------------
  //*  JSP Name:     Child Plan
  //*
  //*  Description:
  //*  This JSP displays the Child Plan details.
  //*--------------------------------------------------------------------------------
%>



<%
  //*******************************
  //*** DECLARE LOCAL VARIABLES ***
  //*******************************
  
  String NO_NAME_STRING = "____________";
  
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  CCFC17SO ccfc17so = (CCFC17SO) state.getAttribute("CCFC17SO", request);
  ROWCCFC17SOG00_ARRAY educationArray = null;
  int tabIndex = 1;
  int loopCounter = 0;
  int loopCount1 = 0;

  String editableMode = PageModeConstants.EDIT;
  if (PageMode.getPageMode(request) != null) {
    editableMode = PageMode.getPageMode(request);
  }
  String fieldsToBeSpellChecked = ("szTxtSvcOffProvidedDesc,szTxtExpChildAdjInCare,szTxtParentalRightsCmnts,szTxtfinalPermPlacementSteps,szTxtadditionalInfo,szTxtImmunizationCmnts, "
                                   + " szTxtImmunizationFileComments,szTxtMedPsychProblemsCmnts,szTxtMedRecFileCmnts,szTxtPsychRecFileCmnts,szTxtMedPsychDocRecordCmnts, "
                                   + " szTxtOtherMedPsychDocRecordCmnts");
  String EMPTY_STRING = "";
  String compDate = EMPTY_STRING;
  String asfaLastUpdateDate = EMPTY_STRING;
  String parLastUpdateDate = EMPTY_STRING;
  String nruLastUpdateDate = EMPTY_STRING;
  String eduLastUpdateDate = EMPTY_STRING;
  String filePetitionDate = EMPTY_STRING;
  String szSvcOffProvidedDesc = EMPTY_STRING;
  String isChAdjCare = EMPTY_STRING;
  String szExpChildAdjInCare = EMPTY_STRING;
  String comments1 = EMPTY_STRING;
  String childAdjusting_Yes = "false";
  String childAdjusting_No = "false";
  String isdilSrchComp = EMPTY_STRING;
  String isAdd = EMPTY_STRING;
  String szParentalRightsCmnts = EMPTY_STRING;
  String permPlan = EMPTY_STRING;
  String diligentSearchCompletion_Yes = "false";
  String diligentSearchCompletion_No = "false";
  String filePetition_Yes = "false";
  String filePetition_No = "false";
  String immunizationUptodate_Yes = "false";
  String immunizationUptodate_No = "false";
  String immunizationOnFile_Yes = "false";
  String immunizationOnFile_No = "false";
  String medPsychProblems_Yes = "false";
  String medPsychProblems_No = "false";
  String medRecFile_Yes = "false";
  String medRecFile_No = "false";
  String psychRecFile_Yes = "false";
  String psychRecFile_No = "false";
  String medPsychTrmnt_Yes = "false";
  String medPsychTrmnt_No = "false";
  String medPsychDocRecord_Yes = "false";
  String medPsychDocRecord_No = "false";
  Date todayDate = DateHelper.getTodayCastorDate();
  List checkedASFAExstConds = new ArrayList();
  List checkedParentalRtsTerms = new ArrayList();
  List checkednonReunificConditions = new ArrayList();
  String szfilePetitionCmnts = EMPTY_STRING;
  String szfinalPermPlacementSteps = EMPTY_STRING;
  String szadditionalInfo = EMPTY_STRING;
  String szImmunizationCmnts = EMPTY_STRING;
  String szImmunizationFileComments = EMPTY_STRING;
  String szMedPsychProblemsCmnts = EMPTY_STRING;
  String szMedRecFileCmnts = EMPTY_STRING;
  String szPsychRecFileCmnts = EMPTY_STRING;
  String szMedPsychDocRecordCmnts = EMPTY_STRING;
  String szOtherMedPsychDocRecordCmnts = EMPTY_STRING;
  String isIndFilePetition = EMPTY_STRING;
  String isIndImmunization = EMPTY_STRING;
  String isIndImmunizationOnFile = EMPTY_STRING;
  String isIndMedPsychProblems = EMPTY_STRING;
  String isIndMedRecFile = EMPTY_STRING;
  String isIndPsychRecFile = EMPTY_STRING;
  String isIndMedPsychTrmnt = EMPTY_STRING;
  String isIndMedPsychDocRecord = EMPTY_STRING;
  String withdrawnDate = EMPTY_STRING;
  String compInd = "false";
  int size = 0;
  int UIdEvent = 0;
  int arrayIndex = 0;
  List<ChildPlanDetailList> childplanDetail = new ArrayList();
  ChildPlanDetailRetrieveSO childplanret = (ChildPlanDetailRetrieveSO) state
                                                                            .getAttribute(
                                                                                          "ChildPlanDetailRetrieveSO",
                                                                                          request);
  int loopCount = 0;
  //ASFA Exisiting Conditions
  Collection asfaexistingconds = Lookup.getCategoryCollection(CodesTables.CCPTASF1);
  List asfaexstngcondsList = new ArrayList(asfaexistingconds);
  //ASFA Parental rights
  Collection parentalrtsterms = Lookup.getCategoryCollection(CodesTables.CCPTASF2);
  List parentalrtsList = new ArrayList(parentalrtsterms);
  // NRU
  Collection nonreunexistingconds = Lookup.getCategoryCollection(CodesTables.CCPTNRUN);
  List nonreunexstngcondsList = new ArrayList(nonreunexistingconds);
  String pageMode = PageMode.getPageMode(request);
  if ((childplanret.getCdEventStatus() != null) && (childplanret.getCdEventStatus().equals("COMP"))
      && (!PageModeConstants.NEW.equals(pageMode)) && (!PageModeConstants.NEW_USING.equals(pageMode))) {
    compInd = "true";
    editableMode = PageModeConstants.VIEW;
  }

  if (childplanret.getcpdBean() != null) {

    if (childplanret.getcpdBean().getLdTxtExpChildAdjInCare() != null) {
      szExpChildAdjInCare = childplanret.getcpdBean().getLdTxtExpChildAdjInCare();
    }
    if (childplanret.getcpdBean().getLdTxtSvcOffProvidedDesc() != null) {
      szSvcOffProvidedDesc = childplanret.getcpdBean().getLdTxtSvcOffProvidedDesc();
    }
    if (childplanret.getcpdBean().getLdIndChildAdjInCare() != null) {
      isChAdjCare = childplanret.getcpdBean().getLdIndChildAdjInCare();
    }
    if (childplanret.getcpdBean().getLdInddilSearchComp() != null) {
      isdilSrchComp = childplanret.getcpdBean().getLdInddilSearchComp();
    }
    if (childplanret.getcpdBean().getLdDtCompDate() != null) {
      compDate = FormattingHelper.formatDate(childplanret.getcpdBean().getLdDtCompDate());
    }
    if (childplanret.getcpdBean().getLdDtfilePetitionDate() != null) {
      filePetitionDate = FormattingHelper.formatDate(childplanret.getcpdBean().getLdDtfilePetitionDate());
    }
    if (childplanret.getcpdBean().getLdIndFilePetition() != null) {
      isIndFilePetition = childplanret.getcpdBean().getLdIndFilePetition();
    }
    if (childplanret.getcpdBean().getLdIndImmunization() != null) {
      isIndImmunization = childplanret.getcpdBean().getLdIndImmunization();
    }
    if (childplanret.getcpdBean().getLdIndImmunizationOnFile() != null) {
      isIndImmunizationOnFile = childplanret.getcpdBean().getLdIndImmunizationOnFile();
    }
    if (childplanret.getcpdBean().getLdIndMedPsychProblems() != null) {
      isIndMedPsychProblems = childplanret.getcpdBean().getLdIndMedPsychProblems();
    }
    if (childplanret.getcpdBean().getLdIndMedRecFile() != null) {
      isIndMedRecFile = childplanret.getcpdBean().getLdIndMedRecFile();
    }
    if (childplanret.getcpdBean().getLdIndPsychRecFile() != null) {
      isIndPsychRecFile = childplanret.getcpdBean().getLdIndPsychRecFile();
    }

    if (childplanret.getcpdBean().getLdIndMedPsychTrmnt() != null) {
      isIndMedPsychTrmnt = childplanret.getcpdBean().getLdIndMedPsychTrmnt();
    }
    if (childplanret.getcpdBean().getLdIndMedPsychDocRecord() != null) {
      isIndMedPsychDocRecord = childplanret.getcpdBean().getLdIndMedPsychDocRecord();
    }
    if (childplanret.getDtCbxAsfaLastUpdate() != null) {
      asfaLastUpdateDate = FormattingHelper.formatDate(childplanret.getDtCbxAsfaLastUpdate());
    }
    if (childplanret.getDtCbxParLastUpdate() != null) {
      parLastUpdateDate = FormattingHelper.formatDate(childplanret.getDtCbxParLastUpdate());
    }
    if (childplanret.getDtCbxNruLastUpdate() != null) {
      nruLastUpdateDate = FormattingHelper.formatDate(childplanret.getDtCbxNruLastUpdate());
    }

    if (isdilSrchComp.equals(ArchitectureConstants.Y)) {
      diligentSearchCompletion_Yes = "true";
      diligentSearchCompletion_No = "false";
    } else if (isdilSrchComp.equals(ArchitectureConstants.N)) {
      diligentSearchCompletion_Yes = "false";
      diligentSearchCompletion_No = "true";
    } else {
      diligentSearchCompletion_Yes = "false";
      diligentSearchCompletion_No = "false";
    }

    if (isChAdjCare == null) {
      isChAdjCare = "";
    }
    if (isChAdjCare.equals(ArchitectureConstants.Y)) {
      childAdjusting_Yes = "true";
      childAdjusting_No = "false";
    } else if (isChAdjCare.equals(ArchitectureConstants.N)) {
      childAdjusting_Yes = "false";
      childAdjusting_No = "true";
    } else {
      childAdjusting_Yes = "false";
      childAdjusting_No = "false";
    }

    if (isIndFilePetition == null) {
      isIndFilePetition = "";
    }
    if (isIndFilePetition.equals(ArchitectureConstants.Y)) {
      filePetition_Yes = "true";
      filePetition_No = "false";
    } else if (isIndFilePetition.equals(ArchitectureConstants.N)) {
      filePetition_Yes = "false";
      filePetition_No = "true";
    } else {
      filePetition_Yes = "false";
      filePetition_No = "false";
    }
    if (isIndImmunization == null) {
      isIndImmunization = "";
    }
    if (isIndImmunization.equals(ArchitectureConstants.Y)) {
      immunizationUptodate_Yes = "true";
      immunizationUptodate_No = "false";
    } else if (isIndImmunization.equals(ArchitectureConstants.N)) {
      immunizationUptodate_Yes = "false";
      immunizationUptodate_No = "true";
    } else {
      immunizationUptodate_Yes = "false";
      immunizationUptodate_No = "false";
    }
    if (isIndImmunizationOnFile == null) {
      isIndImmunizationOnFile = "";
    }
    if (isIndImmunizationOnFile.equals(ArchitectureConstants.Y)) {
      immunizationOnFile_Yes = "true";
      immunizationOnFile_No = "false";
    } else if (isIndImmunizationOnFile.equals(ArchitectureConstants.N)) {
      immunizationOnFile_Yes = "false";
      immunizationOnFile_No = "true";
    } else {
      immunizationOnFile_Yes = "false";
      immunizationOnFile_No = "false";
    }
    if (isIndMedPsychProblems == null) {
      isIndMedPsychProblems = "";
    }
    if (isIndMedPsychProblems.equals(ArchitectureConstants.Y)) {
      medPsychProblems_Yes = "true";
      medPsychProblems_No = "false";
    } else if (isIndMedPsychProblems.equals(ArchitectureConstants.N)) {
      medPsychProblems_Yes = "false";
      medPsychProblems_No = "true";
    } else {
      medPsychProblems_Yes = "false";
      medPsychProblems_No = "false";
    }
    if (isIndMedRecFile == null) {
      isIndMedRecFile = "";
    }
    if (isIndMedRecFile.equals(ArchitectureConstants.Y)) {
      medRecFile_Yes = "true";
      medRecFile_No = "false";
    } else if (isIndMedRecFile.equals(ArchitectureConstants.N)) {
      medRecFile_Yes = "false";
      medRecFile_No = "true";
    } else {
      medRecFile_Yes = "false";
      medRecFile_No = "false";
    }
    if (isIndPsychRecFile == null) {
      isIndPsychRecFile = "";
    }
    if (isIndPsychRecFile.equals(ArchitectureConstants.Y)) {
      psychRecFile_Yes = "true";
      psychRecFile_No = "false";
    } else if (isIndPsychRecFile.equals(ArchitectureConstants.N)) {
      psychRecFile_Yes = "false";
      psychRecFile_No = "true";
    } else {
      psychRecFile_Yes = "false";
      psychRecFile_No = "false";
    }
    if (isIndMedPsychTrmnt == null) {
      isIndMedPsychTrmnt = "";
    }
    if (isIndMedPsychTrmnt.equals(ArchitectureConstants.Y)) {
      medPsychTrmnt_Yes = "true";
      medPsychTrmnt_No = "false";
    } else if (isIndMedPsychTrmnt.equals(ArchitectureConstants.N)) {
      medPsychTrmnt_Yes = "false";
      medPsychTrmnt_No = "true";
    } else {
      medPsychTrmnt_Yes = "false";
      medPsychTrmnt_No = "false";
    }
    if (isIndMedPsychDocRecord == null) {
      isIndMedPsychDocRecord = "";
    }
    if (isIndMedPsychDocRecord.equals(ArchitectureConstants.Y)) {
      medPsychDocRecord_Yes = "true";
      medPsychDocRecord_No = "false";
    } else if (isIndMedPsychDocRecord.equals(ArchitectureConstants.N)) {
      medPsychDocRecord_Yes = "false";
      medPsychDocRecord_No = "true";
    } else {
      medPsychDocRecord_Yes = "false";
      medPsychDocRecord_No = "false";
    }
    if (childplanret.getcpdBean().getasfaExistingConditions() != null) {
      String[] checkedAsfa = null;
      checkedAsfa = childplanret.getcpdBean().getasfaExistingConditions();
      for (int i = 0; i < checkedAsfa.length; i++) {
        checkedASFAExstConds.add(checkedAsfa[i]);
      }
    }
    if (childplanret.getcpdBean().getparentalRtsTerm() != null) {
      String[] checkedParTerms = null;
      checkedParTerms = childplanret.getcpdBean().getparentalRtsTerm();
      for (int i = 0; i < checkedParTerms.length; i++) {
        checkedParentalRtsTerms.add(checkedParTerms[i]);
      }
    }
    if (childplanret.getcpdBean().getnonReunificConditions() != null) {
      String[] checkednonReunificConds = null;
      checkednonReunificConds = childplanret.getcpdBean().getnonReunificConditions();
      for (int i = 0; i < checkednonReunificConds.length; i++) {
        checkednonReunificConditions.add(checkednonReunificConds[i]);
      }
    }

    if (childplanret.getcpdBean().getLdTxtparentalRightsCmnts() != null) {
      szParentalRightsCmnts = childplanret.getcpdBean().getLdTxtparentalRightsCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtfilePetitionCmnts() != null) {
      szfilePetitionCmnts = childplanret.getcpdBean().getLdTxtfilePetitionCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtfinalPermPlacementSteps() != null) {
      szfinalPermPlacementSteps = childplanret.getcpdBean().getLdTxtfinalPermPlacementSteps();
    }
    if (childplanret.getcpdBean().getLdIndPermPlan() != null) {
      permPlan = childplanret.getcpdBean().getLdIndPermPlan();
    }
    if (childplanret.getcpdBean().getLdTxtadditionalInfo() != null) {
      szadditionalInfo = childplanret.getcpdBean().getLdTxtadditionalInfo();
    }

    if (childplanret.getcpdBean().getLdTxtImmunizationCmnts() != null) {
      szImmunizationCmnts = childplanret.getcpdBean().getLdTxtImmunizationCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtImmunizationFileComments() != null) {
      szImmunizationFileComments = childplanret.getcpdBean().getLdTxtImmunizationFileComments();
    }

    if (childplanret.getcpdBean().getLdTxtMedPsychProblemsCmnts() != null) {
      szMedPsychProblemsCmnts = childplanret.getcpdBean().getLdTxtMedPsychProblemsCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtMedRecFileCmnts() != null) {
      szMedRecFileCmnts = childplanret.getcpdBean().getLdTxtMedRecFileCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtPsychRecFileCmnts() != null) {
      szPsychRecFileCmnts = childplanret.getcpdBean().getLdTxtPsychRecFileCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtMedPsychDocRecordCmnts() != null) {
      szMedPsychDocRecordCmnts = childplanret.getcpdBean().getLdTxtMedPsychDocRecordCmnts();
    }

    if (childplanret.getcpdBean().getLdTxtOtherMedPsychDocRecordCmnts() != null) {
      szOtherMedPsychDocRecordCmnts = childplanret.getcpdBean().getLdTxtOtherMedPsychDocRecordCmnts();
    }

  }
  if (ccfc17so == null) {
    ccfc17so = new CCFC17SO();
  }
  if (ccfc17so.getROWCCFC17SOG00_ARRAY() == null) {
    educationArray = new ROWCCFC17SOG00_ARRAY();
  } else {
    educationArray = ccfc17so.getROWCCFC17SOG00_ARRAY();
  }
%>


<impact:validateErrors/>

<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"> </script>
<script language="Javascript1.2">
function cancelValidation ()
{
  disableValidation('frmChildPlan');
}
function setEduParms( tsEduLastUpdate, ulIdEdhist, loopCount )
{
  document.frmChildPlan.hdnTsEduLastUpdate.value = tsEduLastUpdate;
  document.frmChildPlan.hdnUlIdEdhist.value = ulIdEdhist;
  document.frmChildPlan.hdnEduLoopCount.value = loopCount;
  document.frmChildPlan.hdnIndChildPage.value = "Y";
  document.frmChildPlan.pageName.value = "ChildPlan";
}
window.onbeforeunload = function ()
{
  IsDirty();
};

function savePageAdd()
{
         if (isFormChanged( document.frmChildPlan ))
         {
          if (confirm('<%=MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_EXIT)%>') == true){
           return true;
           }
         }
         else
         {
           cancelValidation();
           return true;
         }
}
</script>

<impact:validateForm
   name="frmChildPlan"
   method="post"
   action="/subcare/ChildPlan/displayFccpChild"
   schema="/WEB-INF/Constraints.xsd"
   validationClass="gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanCustomValidation"
   pageMode='<%=editableMode%>' >
<input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>">
<impact:validateInput type="hidden" name="FccpChildPlanIndex" value="<%=FormattingHelper.formatInt(arrayIndex)%>" />
<impact:validateInput type="hidden" name="isAddChildPlan" value="<%=isAdd%>" />
<impact:validateInput type="hidden" name="pageName" value="ChildPlan" />
<impact:validateInput type="hidden" name="hdnTsEduLastUpdate" value=""/>
<impact:validateInput type="hidden" name="hdnUlIdEdhist" value=""/>
<impact:validateInput type="hidden" name="hdnEduLoopCount" value=""/>
<impact:validateInput type="hidden" name="hdnIndChildPage" value=""/>


  
  <table border="0" cellspacing="0" cellpadding="3" width="100%">
    <tr>
       <td align="right">
          <a tabindex="<%=tabIndex++%>" href="#" onClick="expandAll()">Expand All</a>&nbsp;
          <a tabindex="<%=tabIndex++%>" href="#" onClick="collapseAll()">Collapse All</a>&nbsp;
        </td>
    </tr>
  </table>


<table width="100%" cellspacing="0" cellpadding="3" border="0" class="tableBorder">
  <tr>
    <th colspan="4">Foster Care Case Plan Child Detail</th>
  </tr>
  <tr>
    <td colspan="2">
              <span class="formCondRequiredText">&#8225;</span>Describe DFCS reasonable efforts to prevent removal(services offered and provided):
    </td>
  </tr>
  <tr>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtSvcOffProvidedDesc"
        cols="92"
        rows="3" 
        tabIndex="<%=tabIndex++%>"
        maxLength="1000"
        constraint="Paragraph1000">
        <%=szSvcOffProvidedDesc%>
      </impact:validateTextArea>
    </td>
  </tr>
  <tr>
      <td >
                Diligent Search Completed in 30 days:
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="diligentSearchCompletion_Yes" name="rbInddilSearchComp" value="Y" checked="<%=diligentSearchCompletion_Yes%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="diligentSearchCompletion_No"  name="rbInddilSearchComp" value="N" checked="<%=diligentSearchCompletion_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
       </td>
       <td>
          <span class="formCondRequiredText">&#8225;</span>
          <impact:validateDate
           label="Completion Date"
           type="text"
           size="10"
           value="<%=compDate%>"
           name="szDtCompDate"
           tabIndex="<%=tabIndex++%>"
           cssClass="formInput"
           constraint="Date"/>
      </td>
     </tr>
     <tr>
      <td colspan="3">
       	<span class="formInstruct">[Updated 3-18-2012.  Child Plans completed prior to that date reflect response to original statement: 'Diligent Search Completed in 60 days'.]<br/><br/></span>
      </td>
     </tr>
  <tr>
      <td >
                <span class="formCondRequiredText">&#8225;</span>Is the child adjusting in care ? :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="childAdjusting_Yes" name="rbIndChildAdjInCare" value="Y" checked="<%=childAdjusting_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="childAdjusting_No"  name="rbIndChildAdjInCare" value="N" checked="<%=childAdjusting_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>

    <tr>
      <td colspan="2">
               <span class="formCondRequiredText">&#8225;</span>If no, explain:
      </td>
    </tr>
  <tr>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtExpChildAdjInCare"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szExpChildAdjInCare%>
      </impact:validateTextArea>
    </td>
    </tr>
 </table>
<br>
    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
  <tr><td>
    <impact:include 
      page="/submodule/FCGSSubmoduleConversation/displayGoals" 
      callingPage="/subcare/ChildPlan/displayFccpChild" 
      tabIndex="<%=tabIndex++%>"  
      includingForm="frmChildPlan">  
      <impact:attribute 
      name="FCGSSubmoduleConversation.PAGE_MODE_KEY" 
      value="<%=editableMode%>"/>    
    </impact:include>
    <br>
    
<%
      //-------------------------------------------------------------
        //--- Display the Child Plan Guide Topics 
        //-------------------------------------------------------------
        //if ( GlobalData.getUlIdEvent( request ) > 0 &&
        //  !PageMode.getPageMode( request ).equals( PageModeConstants.NEW_USING ) &&
        //!CodesTables.CEVTSTAT_NEW.equals( szCdEventStatus ) )
        //{
    %>
  <impact:ExpandableSectionTag
    name="ChildPlanGuideSection"
    label="Child Case Plan Topics"
    tabIndex="<%=tabIndex++%>">

    <table border="0" cellpadding="3" cellspacing="0" border="0" width="100%" class="tableBorder">
        <tr>
          <td>
            <impact:ExpandableSectionTag
              name="ChildPlanASFAReg"
              label="ASFA Regs"
              rightLabel='<%="Last Updated:" + asfaLastUpdateDate%>'
              tabIndex="<%=tabIndex++%>">

              <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" bgcolor="white">
                <tr>
                <td valign="top" colspan="1">
                    <font color="Red"><b><i>If any of the following conditions exist, this is a red flag case.Please contact your SAAG. </i></b></font>
                  <br>
                    <b>Indicate if any of the following conditions exist:</b> </td>
                </tr>
             <tr class="even">
             <td>
              <impact:castorCheckbox
                castorEnum="<%=Collections.enumeration(asfaexstngcondsList)%>"
                name="chkAsfaExistingConditions"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%=checkedASFAExstConds%>"
                columns="1"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%=tabIndex++%>"
                onClick=""/>
            </td>
          </tr>
          
          <tr>
                  <td valign="top" colspan="1">
                    <b>If any of the above were indicated Georgia law requires that DFCS file a petition to terminate parental rights unless:</b>
                  </td>
                </tr>
                <tr class="even">
            <td>
              <impact:castorCheckbox
                castorEnum="<%=Collections.enumeration(parentalrtsList)%>"
                name="chkParentalRtsTerms"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%=checkedParentalRtsTerms%>"
                columns="1"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%=tabIndex++%>"
                onClick="" />
            </td>
          </tr>
               <tr>
                  <td valign="top" colspan="2">
                    <b>If any of the conditions at the top were indicated, details are required:</b>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <impact:validateTextArea
                      name="szTxtParentalRightsCmnts"
                      cols="92"
                      rows="3"
                      maxLength="1000"
                      constraint="Paragraph1000"
                      tabIndex="<%=tabIndex++%>"><%=szParentalRightsCmnts%>
                    </impact:validateTextArea>
               
                  </td>
                </tr>

              </table>
            </impact:ExpandableSectionTag>
          </td>
        </tr>
    </table>

   <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
        <tr>
          <td>
            <impact:ExpandableSectionTag
              name="ChildPlanNonReunification"
              label="Non Reunification"
              rightLabel='<%="Last Updated:" + nruLastUpdateDate%>'
              tabIndex="<%=tabIndex++%>">

              <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" bgcolor="white">
                <tr>
                  <td valign="top" colspan="1">
                    <b>Do any of the following conditions exist? </b><font color="Red"><b>Check all those that apply: </b></font> </td>
                </tr>
             <tr class="even">
             <td>
              <impact:castorCheckbox
                castorEnum="<%=Collections.enumeration(nonreunexstngcondsList)%>"
                name="chknonReunificConditions"
                labelPropertyName="Code"
                valuePropertyName="Decode"
                checkedValues="<%=checkednonReunificConditions%>"
                columns="1"
                isRuled="false"
                isHorizontal="false"
                tabIndex="<%=tabIndex++%>"
                onClick=""/>
            </td>
          </tr>
          
     <tr>
     <td >
                <span class="formCondRequiredText">&#8225;</span><b>Will DFCS file a petition to terminate parental rights ? :</b>
      </td>
      </tr>
      <tr>
      <td>
        <impact:validateInput type="radio" label="Yes" id="filePetition_Yes" name="rbIndFilePetition" value="Y"  checked="<%=filePetition_Yes%>"cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="filePetition_No"  name="rbIndFilePetition" value="N" checked="<%=filePetition_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
        <span class="formCondRequiredText">&#8225;</span>If yes,enter date
          <impact:validateDate
           label=""
           type="text"
           size="10"
           value= "<%=filePetitionDate%>"
           name="szDtfilePetitionDate"
           tabIndex="<%=tabIndex++%>"
           cssClass="formInput"
           constraint="Date"/>
      </td> 
      </tr>
     <tr>
                  <td>
                           <span class="formCondRequiredText">&#8225;</span>  If no,explain below:
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <impact:validateTextArea
                      name="szTxtfilePetitionCmnts"
                      cols="92"
                      rows="3"
                      maxLength="500"
                      constraint="Paragraph500"
                      tabIndex="<%=tabIndex++%>"><%=szfilePetitionCmnts%>
                    </impact:validateTextArea>
                  </td>
                </tr>
         <tr>
                  <td valign="top" colspan="1">
                           <span class="formCondRequiredText">&#8225;</span><b>Document the steps taken to finalize the adoptive or other permanency placement since the child cannot return home:</b>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <impact:validateTextArea
                      name="szTxtfinalPermPlacementSteps"
                      cols="92"
                      rows="3"
                      maxLength="500"
                      constraint="Paragraph500"
                      tabIndex="<%=tabIndex++%>"><%=szfinalPermPlacementSteps%>
                    </impact:validateTextArea>
                  </td>
                </tr>
                <tr>
                  <td>
                      <impact:validateInput type="checkbox" cssClass="formInput" label="Indicate if Permenancy Plan requires a foster home conversion" checked="<%=(("".equals(permPlan)) || ("N".equals(permPlan))) ? "false" : "true"%>" tabIndex="<%=tabIndex++%>" value="Y" name="chkIndPermPlan" cssClass="formInput" />
                  </td>
                </tr>
    <tr>
                  <td valign="top" colspan="1">
                      <b>Additional Information:</b>
                  </td>
                </tr>
                <tr>
                  <td colspan="2">
                    <impact:validateTextArea
                      name="szTxtadditionalInfo"
                      cols="92"
                      rows="3"
                      maxLength="500"
                      constraint="Paragraph500"
                      tabIndex="<%=tabIndex++%>"><%=szadditionalInfo%>
                    </impact:validateTextArea>
                  </td>
                </tr>

              </table>
            </impact:ExpandableSectionTag>
          </td>
        </tr>
    </table>
    <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
        <tr>
          <td>
            <impact:ExpandableSectionTag
              name="ChildPlanHealthStatusReg"
              label="Health Status"
              rightLabel="Last Updated:"
              tabIndex="<%=tabIndex++%>">
      <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" bgcolor="white">
 <tr>
    <td valign="top" colspan="1"> <b>Health Care Status </b>
           <table cellpadding="3" cellspacing="0" width="100%" class="tableBorder" bgcolor="white">
   <tr>
      <td valign="top" colspan="1">
                <span class="formCondRequiredText">&#8225;</span>Immunization up to date :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="immunizationUptodate_Yes" name="rbIndImmunization" value="Y"  checked="<%=immunizationUptodate_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="immunizationUptodate_No"  name="rbIndImmunization" value="N"  checked="<%=immunizationUptodate_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>
<tr>
      <td valign="top" colspan="1">
               <span class="formCondRequiredText">&#8225;</span>If no, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtImmunizationCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szImmunizationCmnts%>
      </impact:validateTextArea>
    </td>
    </tr>
<tr class="even">
                  <td valign="top" colspan="1">
                <span class="formCondRequiredText">&#8225;</span>Immunization record on file :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="immunizationOnFile_Yes" name="rbIndImmunizationOnFile" value="Y"  checked="<%=immunizationOnFile_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="immunizationOnFile_No"  name="rbIndImmunizationOnFile" value="N"  checked="<%=immunizationOnFile_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>
<tr class="even">
                  <td valign="top" colspan="1">
               <span class="formCondRequiredText">&#8225;</span>If no, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtImmunizationFileComments"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szImmunizationFileComments%>
      </impact:validateTextArea>
    </td>
    </tr>
<tr>
                  <td valign="top" colspan="1">
                <span class="formCondRequiredText">&#8225;</span>Ongoing Medical or Psychological problems :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="medPsychProblems_Yes" name="rbIndMedPsychProblems" value="Y" checked="<%=medPsychProblems_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="medPsychProblems_No"  name="rbIndMedPsychProblems" value="N" checked="<%=medPsychProblems_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>
<tr>
                  <td valign="top" colspan="1">
               <span class="formCondRequiredText">&#8225;</span>If yes, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtMedPsychProblemsCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szMedPsychProblemsCmnts%>
      </impact:validateTextArea>
    </td>
    </tr>
<tr class="even">
                  <td valign="top" colspan="1">
                <span class="formCondRequiredText">&#8225;</span>Medical Records on file :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="medRecFile_Yes" name="rbIndMedRecFile" value="Y"  checked="<%=medRecFile_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="medRecFile_No"  name="rbIndMedRecFile" value="N"  checked="<%=medRecFile_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>
<tr class="even">
                  <td valign="top" colspan="1">
               <span class="formCondRequiredText">&#8225;</span>If no, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtMedRecFileCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szMedRecFileCmnts%>
      </impact:validateTextArea>
    </td>
    </tr>
<tr>
                  <td valign="top" colspan="1">
                <span class="formCondRequiredText">&#8225;</span>Psychological Records on file :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="psychRecFile_Yes" name="rbIndPsychRecFile" value="Y" checked="<%=psychRecFile_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="psychRecFile_No"  name="rbIndPsychRecFile" value="N" checked="<%=psychRecFile_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>
<tr>
                  <td valign="top" colspan="1">
               <span class="formCondRequiredText">&#8225;</span>If no, explain:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtPsychRecFileCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szPsychRecFileCmnts%>
      </impact:validateTextArea>
    </td>
    </tr>
    <tr class="even">
      <td >
                <span class="formCondRequiredText">&#8225;</span>Is Child receiving ongoing Medical or Psychological treatment :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="medPsychTrmnt_Yes" name="rbIndMedPsychTrmnt" value="Y" checked="<%=medPsychTrmnt_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="medPsychTrmnt_No"  name="rbIndMedPsychTrmnt" value="N" checked="<%=medPsychTrmnt_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
     </tr>
    <tr class="even">
      <td >
                <span class="formCondRequiredText">&#8225;</span>If yes, is it documented in the record :
      </td>
      <td>
        <impact:validateInput type="radio" label="Yes" id="medPsychDocRecord_Yes" name="rbIndMedPsychDocRecord" value="Y" checked="<%=medPsychDocRecord_Yes%>" cssClass="formInput"  tabIndex="<%=tabIndex++%>" />
        <impact:validateInput type="radio" label="No"  id="medPsychDocRecord_No"  name="rbIndMedPsychDocRecord" value="N" checked="<%=medPsychDocRecord_No%>" cssClass="formInput" tabIndex="<%=tabIndex++%>" /> 
      </td> 
    </tr>
<tr>
                  <td valign="top" colspan="1">
              If any evaluation dates are not in the Health Log, note why:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtMedPsychDocRecordCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szMedPsychDocRecordCmnts%>
      </impact:validateTextArea>
    </td>
    </tr>
<tr class="even">
                  <td valign="top" colspan="1">
              Other relevant Medical or Psychological information:
      </td>
    <td colspan="2">
      <impact:validateTextArea
        name="szTxtOtherMedPsychDocRecordCmnts"
        cols="92"
        rows="3"
        tabIndex="<%=tabIndex++%>"
        maxLength="500"
        constraint="Paragraph500"> <%=szOtherMedPsychDocRecordCmnts%>
      </impact:validateTextArea>
      </td>
      </tr>
      </table>
      </td>
      </tr>
      </table>
    </impact:ExpandableSectionTag>
     </td>
      </tr>
      </table>
 <%
   // Begin Education

       String eduTab = null;
       loopCount = 0;
       ROWCCFC17SOG00 educationRow = null;
       Enumeration educationEnumeration = educationArray.enumerateROWCCFC17SOG00();
       if (!educationEnumeration.hasMoreElements()) {
         eduTab = "btnAddEdu_Id";

       } else {
         eduTab = "eduRadio0";
         // eduLastUpdateDate = FormattingHelper.formatDate(educationRow.getTsLastUpdate());
       }
 %>
    <table border="0" cellpadding="3" cellspacing="0" border="0" width="100%">
        <tr>
          <td>
            <impact:ExpandableSectionTag
              name="education"
              label="Education"
              rightLabel='<%="Last Updated:" + eduLastUpdateDate%>'
              tabIndex="<%=tabIndex++%>">

              <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder" bgcolor="white">
      <tr>
      <td class="tableBG">
      <DIV id="scrollBar2" style="height:155px;width:100%;overflow:auto" class="tableborderList">
                 <TABLE width="100%" cellspacing="0" cellpadding="3">
                           <TR>
                           <TH class="thList"></TH>
                           <TH class="thList">School Name</TH>
                           <TH class="thList">Enrolled</TH>
                           <TH class="thList">Grade</TH>
                           <TH class="thList">Withdrawn</TH>
                           <TH class="thList">Grade</TH></TR>
                           
                           <%
                                                        if (!educationEnumeration.hasMoreElements()) {
                                                                withdrawnDate = "ssss";
                                                      %>
                      <tr class="odd">
                        <td colspan="10">
                           <%=MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED)%>
                        </td>
                      </tr>
<%
  } else {
  String schoolName = NO_NAME_STRING; /* mxpatel added this for defect #7158 */
          while (educationEnumeration.hasMoreElements()) {
            educationRow = (ROWCCFC17SOG00) educationEnumeration.nextElement();
            if (loopCount == 0) {
              withdrawnDate = FormattingHelper.formatDate(educationRow.getDtDtEdhistWithdrawnDate());
            }
            /* mxpatel added this IF statement for defect #7158 */
            if (StringHelper.isValid(educationRow.getSzNmEdhistSchool())) {
              schoolName = educationRow.getSzNmEdhistSchool();
            } else {
              schoolName = NO_NAME_STRING;
            }
%>
                              <tr class="<%=FormattingHelper.getRowCss(loopCount + 1)%>" valign="top">
                        <%
                          /* EduOnClick used to submit the row's parameters to hidden fields */
                        %>
                        <%
                          String EduOnClick = "setEduParms( '" + educationRow.getTsLastUpdate() + "', '"
                                                        + educationRow.getUlIdEdhist() + "', '" + loopCount + "' )";
                        %>
                            <td><impact:validateInput id='<%="eduRadio" + loopCount%>'
                              tabIndex="<%=tabIndex++%>"
                              value="loopCount"
                              type="radio"
                              name="eduSelect_CLEAN"
                              editableMode="<%=EditableMode.EDIT + EditableMode.NEW%>"
                              onClick="<%=EduOnClick%>"  /></td>
                            <td><a tabIndex="<%=tabIndex++%>"
                              href="javascript: <%=EduOnClick%>; cancelValidation(); submitValidateForm( 'frmChildPlan', '/person/PersonDetail/displayEducation' )"><%=schoolName%></a></td>  
                            <td><%=FormattingHelper.formatDate(educationRow.getDtDtEdhistEnrollDate())%></td>
                            <td><%=Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistEnrollGrade())%></td>
                            <td><%=FormattingHelper.formatDate(educationRow.getDtDtEdhistWithdrawnDate())%></td>
                            <td><%=Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistWithdrawnGrade())%></td>
                        </tr>
                           
                           <%
                                                        loopCount++;
                                                                } // end for
                                                              }
                                                      %>
                           
                           </TABLE></DIV>
                              </td>
      </tr>
      </table>
      <table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
      <tr>
      <%
        // Pilot R2: to reduce confusion and avoid this scenrio: that user able to add Education items from a new 
              // Child Detail; navigate away from Child Detail without saving it, thinking a Child Detail has been created

              if (!PageModeConstants.NEW.equals(pageMode) && !PageModeConstants.NEW_USING.equals(pageMode)) {
      %>
      <td>
      <div class="alignRight"><impact:ButtonTag
                              name="btnAddEdu"
                              img="btnAdd"
                              navAwayCk="false"
                              function="return savePageAdd();"
                              form="frmChildPlan"
                              action="/person/PersonDetail/addEducation"
                              tabIndex="<%=tabIndex++%>"/></div>
                              
             </td>  
      <%
          }
        %>                      
         </tr>
      </table>

       </impact:ExpandableSectionTag>
         </td>
         </tr>
        </table>
  </impact:ExpandableSectionTag>
 
 <table border="0" cellpadding="3" cellspacing="0" width="100%">
  <tr>
     <td width="100%" align="right">
        <impact:spellCheck
          formToSpellCheck="frmChildPlan"
          fieldsToSpellCheck="<%=fieldsToBeSpellChecked%>"
          tabIndex="<%=tabIndex++%>"/>
    </td>
    <td align="right">
      <impact:ButtonTag name="btnCompleteQ" img="btnCompleteQ" form="frmChildPlan" function="" action="/subcare/ChildPlan/completeFccpChild" restrictRepost="true" preventDoubleClick="true" disabled="false" align="right" tabIndex="<%=tabIndex++%>"/>
    </td>
     <td align="right">
      <impact:ButtonTag name="btnSave" img="btnSave" form="frmChildPlan" action="/subcare/ChildPlan/saveFccpChild" preventDoubleClick="true" restrictRepost="true" disabled="false" function="" align="right" tabIndex="<%=tabIndex++%>"/>
    </td>
  </tr>
  </table>
  <br>
</impact:validateForm>
