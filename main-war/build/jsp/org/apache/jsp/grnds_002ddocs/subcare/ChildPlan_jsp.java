package org.apache.jsp.grnds_002ddocs.subcare;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Collection;
import java.util.Collections;
import java.util.Calendar;
import org.exolab.castor.types.Date;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB36SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildPlanDetailList;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import java.util.Enumeration;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonDetailConversation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildPlanDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC17SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC17SOG00_ARRAY;

public final class ChildPlan_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static java.util.Vector _jspx_dependants;

  static {
    _jspx_dependants = new java.util.Vector(1);
    _jspx_dependants.add("/WEB-INF/impact.tld");
  }

  public java.util.List getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    JspFactory _jspxFactory = null;
    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;


    try {
      _jspxFactory = JspFactory.getDefaultFactory();
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

//*  JSP Name:     Child Plan Detail JSP
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
      //**
      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  //*--------------------------------------------------------------------------------
  //*  JSP Name:     Child Plan
  //*
  //*  Description:
  //*  This JSP displays the Child Plan details.
  //*--------------------------------------------------------------------------------

      out.write("\r\n\r\n\r\n\r\n");

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

      out.write("\r\n\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"> </script>\r\n<script language=\"Javascript1.2\">\r\nfunction cancelValidation ()\r\n{\r\n  disableValidation('frmChildPlan');\r\n}\r\nfunction setEduParms( tsEduLastUpdate, ulIdEdhist, loopCount )\r\n{\r\n  document.frmChildPlan.hdnTsEduLastUpdate.value = tsEduLastUpdate;\r\n  document.frmChildPlan.hdnUlIdEdhist.value = ulIdEdhist;\r\n  document.frmChildPlan.hdnEduLoopCount.value = loopCount;\r\n  document.frmChildPlan.hdnIndChildPage.value = \"Y\";\r\n  document.frmChildPlan.pageName.value = \"ChildPlan\";\r\n}\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n\r\nfunction savePageAdd()\r\n{\r\n         if (isFormChanged( document.frmChildPlan ))\r\n         {\r\n          if (confirm('");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_CONFIRM_ON_EXIT));
      out.write("') == true){\r\n           return true;\r\n           }\r\n         }\r\n         else\r\n         {\r\n           cancelValidation();\r\n           return true;\r\n         }\r\n}\r\n</script>\r\n\r\n");
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmChildPlan");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/subcare/ChildPlan/displayFccpChild");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.subcare.ChildPlanCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(editableMode);
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\">\r\n");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_0.setType("hidden");
          _jspx_th_impact_validateInput_0.setName("FccpChildPlanIndex");
          _jspx_th_impact_validateInput_0.setValue(FormattingHelper.formatInt(arrayIndex));
          int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
          if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("isAddChildPlan");
          _jspx_th_impact_validateInput_1.setValue(isAdd);
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_2(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_3(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_4(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_5(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_6(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\r\n\r\n  \r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n       <td align=\"right\">\r\n          <a tabindex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n          <a tabindex=\"");
          out.print(tabIndex++);
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n        </td>\r\n    </tr>\r\n  </table>\r\n\r\n\r\n<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"4\">Foster Care Case Plan Child Detail</th>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n              <span class=\"formCondRequiredText\">&#8225;</span>Describe DFCS reasonable efforts to prevent removal(services offered and provided):\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("szTxtSvcOffProvidedDesc");
          _jspx_th_impact_validateTextArea_0.setCols("92");
          _jspx_th_impact_validateTextArea_0.setRows("3");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n        ");
              out.print(szSvcOffProvidedDesc);
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  <tr>\r\n      <td >\r\n                Diligent Search Completed in 30 days:\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setLabel("Yes");
          _jspx_th_impact_validateInput_7.setId("diligentSearchCompletion_Yes");
          _jspx_th_impact_validateInput_7.setName("rbInddilSearchComp");
          _jspx_th_impact_validateInput_7.setValue("Y");
          _jspx_th_impact_validateInput_7.setChecked(diligentSearchCompletion_Yes);
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setLabel("No");
          _jspx_th_impact_validateInput_8.setId("diligentSearchCompletion_No");
          _jspx_th_impact_validateInput_8.setName("rbInddilSearchComp");
          _jspx_th_impact_validateInput_8.setValue("N");
          _jspx_th_impact_validateInput_8.setChecked(diligentSearchCompletion_No);
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \r\n       </td>\r\n       <td>\r\n          <span class=\"formCondRequiredText\">&#8225;</span>\r\n          ");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Completion Date");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setValue(compDate);
          _jspx_th_impact_validateDate_0.setName("szDtCompDate");
          _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateDate_0.setCssClass("formInput");
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      </td>\r\n     </tr>\r\n     <tr>\r\n      <td colspan=\"3\">\r\n       \t<span class=\"formInstruct\">[Updated 3-18-2012.  Child Plans completed prior to that date reflect response to original statement: 'Diligent Search Completed in 60 days'.]<br/><br/></span>\r\n      </td>\r\n     </tr>\r\n  <tr>\r\n      <td >\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Is the child adjusting in care ? :\r\n      </td>\r\n      <td>\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setLabel("Yes");
          _jspx_th_impact_validateInput_9.setId("childAdjusting_Yes");
          _jspx_th_impact_validateInput_9.setName("rbIndChildAdjInCare");
          _jspx_th_impact_validateInput_9.setValue("Y");
          _jspx_th_impact_validateInput_9.setChecked(childAdjusting_Yes);
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setLabel("No");
          _jspx_th_impact_validateInput_10.setId("childAdjusting_No");
          _jspx_th_impact_validateInput_10.setName("rbIndChildAdjInCare");
          _jspx_th_impact_validateInput_10.setValue("N");
          _jspx_th_impact_validateInput_10.setChecked(childAdjusting_No);
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write(" \r\n      </td> \r\n     </tr>\r\n\r\n    <tr>\r\n      <td colspan=\"2\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If no, explain:\r\n      </td>\r\n    </tr>\r\n  <tr>\r\n    <td colspan=\"2\">\r\n      ");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("szTxtExpChildAdjInCare");
          _jspx_th_impact_validateTextArea_1.setCols("92");
          _jspx_th_impact_validateTextArea_1.setRows("3");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setMaxLength(500);
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph500");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write(' ');
              out.print(szExpChildAdjInCare);
              out.write("\r\n      ");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    </tr>\r\n </table>\r\n<br>\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n  <tr><td>\r\n    ");
          //  impact:include
          gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag _jspx_th_impact_include_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag();
          _jspx_th_impact_include_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_include_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_include_0.setPage("/submodule/FCGSSubmoduleConversation/displayGoals");
          _jspx_th_impact_include_0.setCallingPage("/subcare/ChildPlan/displayFccpChild");
          _jspx_th_impact_include_0.setTabIndex(tabIndex++);
          _jspx_th_impact_include_0.setIncludingForm("frmChildPlan");
          int _jspx_eval_impact_include_0 = _jspx_th_impact_include_0.doStartTag();
          if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_include_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_include_0.doInitBody();
            }
            do {
              out.write("  \r\n      ");
              //  impact:attribute
              gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag _jspx_th_impact_attribute_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.decorator.AttributeTag();
              _jspx_th_impact_attribute_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_attribute_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_include_0);
              _jspx_th_impact_attribute_0.setName("FCGSSubmoduleConversation.PAGE_MODE_KEY");
              _jspx_th_impact_attribute_0.setValue(editableMode);
              int _jspx_eval_impact_attribute_0 = _jspx_th_impact_attribute_0.doStartTag();
              if (_jspx_th_impact_attribute_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("    \r\n    ");
              int evalDoAfterBody = _jspx_th_impact_include_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_include_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_include_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    <br>\r\n    \r\n");

      //-------------------------------------------------------------
        //--- Display the Child Plan Guide Topics 
        //-------------------------------------------------------------
        //if ( GlobalData.getUlIdEvent( request ) > 0 &&
        //  !PageMode.getPageMode( request ).equals( PageModeConstants.NEW_USING ) &&
        //!CodesTables.CEVTSTAT_NEW.equals( szCdEventStatus ) )
        //{
    
          out.write("\r\n  ");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("ChildPlanGuideSection");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Child Case Plan Topics");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_1.setName("ChildPlanASFAReg");
              _jspx_th_impact_ExpandableSectionTag_1.setLabel("ASFA Regs");
              _jspx_th_impact_ExpandableSectionTag_1.setRightLabel("Last Updated:" + asfaLastUpdateDate);
              _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\r\n              <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" bgcolor=\"white\">\r\n                <tr>\r\n                <td valign=\"top\" colspan=\"1\">\r\n                    <font color=\"Red\"><b><i>If any of the following conditions exist, this is a red flag case.Please contact your SAAG. </i></b></font>\r\n                  <br>\r\n                    <b>Indicate if any of the following conditions exist:</b> </td>\r\n                </tr>\r\n             <tr class=\"even\">\r\n             <td>\r\n              ");
                  //  impact:castorCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
                  _jspx_th_impact_castorCheckbox_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_castorCheckbox_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
                  _jspx_th_impact_castorCheckbox_0.setCastorEnum(Collections.enumeration(asfaexstngcondsList));
                  _jspx_th_impact_castorCheckbox_0.setName("chkAsfaExistingConditions");
                  _jspx_th_impact_castorCheckbox_0.setLabelPropertyName("Code");
                  _jspx_th_impact_castorCheckbox_0.setValuePropertyName("Decode");
                  _jspx_th_impact_castorCheckbox_0.setCheckedValues(checkedASFAExstConds);
                  _jspx_th_impact_castorCheckbox_0.setColumns(1);
                  _jspx_th_impact_castorCheckbox_0.setIsRuled(false);
                  _jspx_th_impact_castorCheckbox_0.setIsHorizontal(false);
                  _jspx_th_impact_castorCheckbox_0.setTabIndex(tabIndex++);
                  _jspx_th_impact_castorCheckbox_0.setOnClick("");
                  int _jspx_eval_impact_castorCheckbox_0 = _jspx_th_impact_castorCheckbox_0.doStartTag();
                  if (_jspx_th_impact_castorCheckbox_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n            </td>\r\n          </tr>\r\n          \r\n          <tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                    <b>If any of the above were indicated Georgia law requires that DFCS file a petition to terminate parental rights unless:</b>\r\n                  </td>\r\n                </tr>\r\n                <tr class=\"even\">\r\n            <td>\r\n              ");
                  //  impact:castorCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
                  _jspx_th_impact_castorCheckbox_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_castorCheckbox_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
                  _jspx_th_impact_castorCheckbox_1.setCastorEnum(Collections.enumeration(parentalrtsList));
                  _jspx_th_impact_castorCheckbox_1.setName("chkParentalRtsTerms");
                  _jspx_th_impact_castorCheckbox_1.setLabelPropertyName("Code");
                  _jspx_th_impact_castorCheckbox_1.setValuePropertyName("Decode");
                  _jspx_th_impact_castorCheckbox_1.setCheckedValues(checkedParentalRtsTerms);
                  _jspx_th_impact_castorCheckbox_1.setColumns(1);
                  _jspx_th_impact_castorCheckbox_1.setIsRuled(false);
                  _jspx_th_impact_castorCheckbox_1.setIsHorizontal(false);
                  _jspx_th_impact_castorCheckbox_1.setTabIndex(tabIndex++);
                  _jspx_th_impact_castorCheckbox_1.setOnClick("");
                  int _jspx_eval_impact_castorCheckbox_1 = _jspx_th_impact_castorCheckbox_1.doStartTag();
                  if (_jspx_th_impact_castorCheckbox_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n            </td>\r\n          </tr>\r\n               <tr>\r\n                  <td valign=\"top\" colspan=\"2\">\r\n                    <b>If any of the conditions at the top were indicated, details are required:</b>\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td colspan=\"2\">\r\n                    ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
                  _jspx_th_impact_validateTextArea_2.setName("szTxtParentalRightsCmnts");
                  _jspx_th_impact_validateTextArea_2.setCols("92");
                  _jspx_th_impact_validateTextArea_2.setRows("3");
                  _jspx_th_impact_validateTextArea_2.setMaxLength(1000);
                  _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph1000");
                  _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_2.doInitBody();
                    }
                    do {
                      out.print(szParentalRightsCmnts);
                      out.write("\r\n                    ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n               \r\n                  </td>\r\n                </tr>\r\n\r\n              </table>\r\n            ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n    </table>\r\n\r\n   <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_2.setName("ChildPlanNonReunification");
              _jspx_th_impact_ExpandableSectionTag_2.setLabel("Non Reunification");
              _jspx_th_impact_ExpandableSectionTag_2.setRightLabel("Last Updated:" + nruLastUpdateDate);
              _jspx_th_impact_ExpandableSectionTag_2.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\r\n              <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" bgcolor=\"white\">\r\n                <tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                    <b>Do any of the following conditions exist? </b><font color=\"Red\"><b>Check all those that apply: </b></font> </td>\r\n                </tr>\r\n             <tr class=\"even\">\r\n             <td>\r\n              ");
                  //  impact:castorCheckbox
                  gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag _jspx_th_impact_castorCheckbox_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CastorCheckboxesTag();
                  _jspx_th_impact_castorCheckbox_2.setPageContext(_jspx_page_context);
                  _jspx_th_impact_castorCheckbox_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_castorCheckbox_2.setCastorEnum(Collections.enumeration(nonreunexstngcondsList));
                  _jspx_th_impact_castorCheckbox_2.setName("chknonReunificConditions");
                  _jspx_th_impact_castorCheckbox_2.setLabelPropertyName("Code");
                  _jspx_th_impact_castorCheckbox_2.setValuePropertyName("Decode");
                  _jspx_th_impact_castorCheckbox_2.setCheckedValues(checkednonReunificConditions);
                  _jspx_th_impact_castorCheckbox_2.setColumns(1);
                  _jspx_th_impact_castorCheckbox_2.setIsRuled(false);
                  _jspx_th_impact_castorCheckbox_2.setIsHorizontal(false);
                  _jspx_th_impact_castorCheckbox_2.setTabIndex(tabIndex++);
                  _jspx_th_impact_castorCheckbox_2.setOnClick("");
                  int _jspx_eval_impact_castorCheckbox_2 = _jspx_th_impact_castorCheckbox_2.doStartTag();
                  if (_jspx_th_impact_castorCheckbox_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n            </td>\r\n          </tr>\r\n          \r\n     <tr>\r\n     <td >\r\n                <span class=\"formCondRequiredText\">&#8225;</span><b>Will DFCS file a petition to terminate parental rights ? :</b>\r\n      </td>\r\n      </tr>\r\n      <tr>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateInput_11.setType("radio");
                  _jspx_th_impact_validateInput_11.setLabel("Yes");
                  _jspx_th_impact_validateInput_11.setId("filePetition_Yes");
                  _jspx_th_impact_validateInput_11.setName("rbIndFilePetition");
                  _jspx_th_impact_validateInput_11.setValue("Y");
                  _jspx_th_impact_validateInput_11.setChecked(filePetition_Yes);
                  _jspx_th_impact_validateInput_11.setCssClass("formInput");
                  _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
                  if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateInput_12.setType("radio");
                  _jspx_th_impact_validateInput_12.setLabel("No");
                  _jspx_th_impact_validateInput_12.setId("filePetition_No");
                  _jspx_th_impact_validateInput_12.setName("rbIndFilePetition");
                  _jspx_th_impact_validateInput_12.setValue("N");
                  _jspx_th_impact_validateInput_12.setChecked(filePetition_No);
                  _jspx_th_impact_validateInput_12.setCssClass("formInput");
                  _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
                  if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n        <span class=\"formCondRequiredText\">&#8225;</span>If yes,enter date\r\n          ");
                  //  impact:validateDate
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
                  _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateDate_1.setLabel("");
                  _jspx_th_impact_validateDate_1.setType("text");
                  _jspx_th_impact_validateDate_1.setSize("10");
                  _jspx_th_impact_validateDate_1.setValue(filePetitionDate);
                  _jspx_th_impact_validateDate_1.setName("szDtfilePetitionDate");
                  _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateDate_1.setCssClass("formInput");
                  _jspx_th_impact_validateDate_1.setConstraint("Date");
                  int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
                  if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n      </td> \r\n      </tr>\r\n     <tr>\r\n                  <td>\r\n                           <span class=\"formCondRequiredText\">&#8225;</span>  If no,explain below:\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td colspan=\"2\">\r\n                    ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateTextArea_3.setName("szTxtfilePetitionCmnts");
                  _jspx_th_impact_validateTextArea_3.setCols("92");
                  _jspx_th_impact_validateTextArea_3.setRows("3");
                  _jspx_th_impact_validateTextArea_3.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph500");
                  _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_3.doInitBody();
                    }
                    do {
                      out.print(szfilePetitionCmnts);
                      out.write("\r\n                    ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                  </td>\r\n                </tr>\r\n         <tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                           <span class=\"formCondRequiredText\">&#8225;</span><b>Document the steps taken to finalize the adoptive or other permanency placement since the child cannot return home:</b>\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td colspan=\"2\">\r\n                    ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateTextArea_4.setName("szTxtfinalPermPlacementSteps");
                  _jspx_th_impact_validateTextArea_4.setCols("92");
                  _jspx_th_impact_validateTextArea_4.setRows("3");
                  _jspx_th_impact_validateTextArea_4.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph500");
                  _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_4.doInitBody();
                    }
                    do {
                      out.print(szfinalPermPlacementSteps);
                      out.write("\r\n                    ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td>\r\n                      ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateInput_13.setType("checkbox");
                  _jspx_th_impact_validateInput_13.setCssClass("formInput");
                  _jspx_th_impact_validateInput_13.setLabel("Indicate if Permenancy Plan requires a foster home conversion");
                  _jspx_th_impact_validateInput_13.setChecked((("".equals(permPlan)) || ("N".equals(permPlan))) ? "false" : "true");
                  _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_13.setValue("Y");
                  _jspx_th_impact_validateInput_13.setName("chkIndPermPlan");
                  _jspx_th_impact_validateInput_13.setCssClass("formInput");
                  int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
                  if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                  </td>\r\n                </tr>\r\n    <tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                      <b>Additional Information:</b>\r\n                  </td>\r\n                </tr>\r\n                <tr>\r\n                  <td colspan=\"2\">\r\n                    ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_2);
                  _jspx_th_impact_validateTextArea_5.setName("szTxtadditionalInfo");
                  _jspx_th_impact_validateTextArea_5.setCols("92");
                  _jspx_th_impact_validateTextArea_5.setRows("3");
                  _jspx_th_impact_validateTextArea_5.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_5.setConstraint("Paragraph500");
                  _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_5.doInitBody();
                    }
                    do {
                      out.print(szadditionalInfo);
                      out.write("\r\n                    ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n                  </td>\r\n                </tr>\r\n\r\n              </table>\r\n            ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n          </td>\r\n        </tr>\r\n    </table>\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_3.setName("ChildPlanHealthStatusReg");
              _jspx_th_impact_ExpandableSectionTag_3.setLabel("Health Status");
              _jspx_th_impact_ExpandableSectionTag_3.setRightLabel("Last Updated:");
              _jspx_th_impact_ExpandableSectionTag_3.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" bgcolor=\"white\">\r\n <tr>\r\n    <td valign=\"top\" colspan=\"1\"> <b>Health Care Status </b>\r\n           <table cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" bgcolor=\"white\">\r\n   <tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Immunization up to date :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_14.setType("radio");
                  _jspx_th_impact_validateInput_14.setLabel("Yes");
                  _jspx_th_impact_validateInput_14.setId("immunizationUptodate_Yes");
                  _jspx_th_impact_validateInput_14.setName("rbIndImmunization");
                  _jspx_th_impact_validateInput_14.setValue("Y");
                  _jspx_th_impact_validateInput_14.setChecked(immunizationUptodate_Yes);
                  _jspx_th_impact_validateInput_14.setCssClass("formInput");
                  _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
                  if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_15.setType("radio");
                  _jspx_th_impact_validateInput_15.setLabel("No");
                  _jspx_th_impact_validateInput_15.setId("immunizationUptodate_No");
                  _jspx_th_impact_validateInput_15.setName("rbIndImmunization");
                  _jspx_th_impact_validateInput_15.setValue("N");
                  _jspx_th_impact_validateInput_15.setChecked(immunizationUptodate_No);
                  _jspx_th_impact_validateInput_15.setCssClass("formInput");
                  _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
                  if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n     </tr>\r\n<tr>\r\n      <td valign=\"top\" colspan=\"1\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If no, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_6.setName("szTxtImmunizationCmnts");
                  _jspx_th_impact_validateTextArea_6.setCols("92");
                  _jspx_th_impact_validateTextArea_6.setRows("3");
                  _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_6.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_6.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_6.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szImmunizationCmnts);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n    </td>\r\n    </tr>\r\n<tr class=\"even\">\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Immunization record on file :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_16.setType("radio");
                  _jspx_th_impact_validateInput_16.setLabel("Yes");
                  _jspx_th_impact_validateInput_16.setId("immunizationOnFile_Yes");
                  _jspx_th_impact_validateInput_16.setName("rbIndImmunizationOnFile");
                  _jspx_th_impact_validateInput_16.setValue("Y");
                  _jspx_th_impact_validateInput_16.setChecked(immunizationOnFile_Yes);
                  _jspx_th_impact_validateInput_16.setCssClass("formInput");
                  _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
                  if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_17.setType("radio");
                  _jspx_th_impact_validateInput_17.setLabel("No");
                  _jspx_th_impact_validateInput_17.setId("immunizationOnFile_No");
                  _jspx_th_impact_validateInput_17.setName("rbIndImmunizationOnFile");
                  _jspx_th_impact_validateInput_17.setValue("N");
                  _jspx_th_impact_validateInput_17.setChecked(immunizationOnFile_No);
                  _jspx_th_impact_validateInput_17.setCssClass("formInput");
                  _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
                  if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n     </tr>\r\n<tr class=\"even\">\r\n                  <td valign=\"top\" colspan=\"1\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If no, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_7.setName("szTxtImmunizationFileComments");
                  _jspx_th_impact_validateTextArea_7.setCols("92");
                  _jspx_th_impact_validateTextArea_7.setRows("3");
                  _jspx_th_impact_validateTextArea_7.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_7.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_7.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_7.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szImmunizationFileComments);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n    </td>\r\n    </tr>\r\n<tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Ongoing Medical or Psychological problems :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_18.setType("radio");
                  _jspx_th_impact_validateInput_18.setLabel("Yes");
                  _jspx_th_impact_validateInput_18.setId("medPsychProblems_Yes");
                  _jspx_th_impact_validateInput_18.setName("rbIndMedPsychProblems");
                  _jspx_th_impact_validateInput_18.setValue("Y");
                  _jspx_th_impact_validateInput_18.setChecked(medPsychProblems_Yes);
                  _jspx_th_impact_validateInput_18.setCssClass("formInput");
                  _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
                  if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_19.setType("radio");
                  _jspx_th_impact_validateInput_19.setLabel("No");
                  _jspx_th_impact_validateInput_19.setId("medPsychProblems_No");
                  _jspx_th_impact_validateInput_19.setName("rbIndMedPsychProblems");
                  _jspx_th_impact_validateInput_19.setValue("N");
                  _jspx_th_impact_validateInput_19.setChecked(medPsychProblems_No);
                  _jspx_th_impact_validateInput_19.setCssClass("formInput");
                  _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
                  if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n     </tr>\r\n<tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If yes, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_8.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_8.setName("szTxtMedPsychProblemsCmnts");
                  _jspx_th_impact_validateTextArea_8.setCols("92");
                  _jspx_th_impact_validateTextArea_8.setRows("3");
                  _jspx_th_impact_validateTextArea_8.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_8.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_8.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_8 = _jspx_th_impact_validateTextArea_8.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_8.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_8.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szMedPsychProblemsCmnts);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_8.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_8 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n    </td>\r\n    </tr>\r\n<tr class=\"even\">\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Medical Records on file :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_20.setType("radio");
                  _jspx_th_impact_validateInput_20.setLabel("Yes");
                  _jspx_th_impact_validateInput_20.setId("medRecFile_Yes");
                  _jspx_th_impact_validateInput_20.setName("rbIndMedRecFile");
                  _jspx_th_impact_validateInput_20.setValue("Y");
                  _jspx_th_impact_validateInput_20.setChecked(medRecFile_Yes);
                  _jspx_th_impact_validateInput_20.setCssClass("formInput");
                  _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
                  if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_21.setType("radio");
                  _jspx_th_impact_validateInput_21.setLabel("No");
                  _jspx_th_impact_validateInput_21.setId("medRecFile_No");
                  _jspx_th_impact_validateInput_21.setName("rbIndMedRecFile");
                  _jspx_th_impact_validateInput_21.setValue("N");
                  _jspx_th_impact_validateInput_21.setChecked(medRecFile_No);
                  _jspx_th_impact_validateInput_21.setCssClass("formInput");
                  _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
                  if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n     </tr>\r\n<tr class=\"even\">\r\n                  <td valign=\"top\" colspan=\"1\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If no, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_9.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_9.setName("szTxtMedRecFileCmnts");
                  _jspx_th_impact_validateTextArea_9.setCols("92");
                  _jspx_th_impact_validateTextArea_9.setRows("3");
                  _jspx_th_impact_validateTextArea_9.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_9.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_9.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_9 = _jspx_th_impact_validateTextArea_9.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_9.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_9.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szMedRecFileCmnts);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_9.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_9 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n    </td>\r\n    </tr>\r\n<tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Psychological Records on file :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_22.setType("radio");
                  _jspx_th_impact_validateInput_22.setLabel("Yes");
                  _jspx_th_impact_validateInput_22.setId("psychRecFile_Yes");
                  _jspx_th_impact_validateInput_22.setName("rbIndPsychRecFile");
                  _jspx_th_impact_validateInput_22.setValue("Y");
                  _jspx_th_impact_validateInput_22.setChecked(psychRecFile_Yes);
                  _jspx_th_impact_validateInput_22.setCssClass("formInput");
                  _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
                  if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_23.setType("radio");
                  _jspx_th_impact_validateInput_23.setLabel("No");
                  _jspx_th_impact_validateInput_23.setId("psychRecFile_No");
                  _jspx_th_impact_validateInput_23.setName("rbIndPsychRecFile");
                  _jspx_th_impact_validateInput_23.setValue("N");
                  _jspx_th_impact_validateInput_23.setChecked(psychRecFile_No);
                  _jspx_th_impact_validateInput_23.setCssClass("formInput");
                  _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
                  if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n     </tr>\r\n<tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n               <span class=\"formCondRequiredText\">&#8225;</span>If no, explain:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_10.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_10.setName("szTxtPsychRecFileCmnts");
                  _jspx_th_impact_validateTextArea_10.setCols("92");
                  _jspx_th_impact_validateTextArea_10.setRows("3");
                  _jspx_th_impact_validateTextArea_10.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_10.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_10.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_10 = _jspx_th_impact_validateTextArea_10.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_10.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_10.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szPsychRecFileCmnts);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_10.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_10 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n    </td>\r\n    </tr>\r\n    <tr class=\"even\">\r\n      <td >\r\n                <span class=\"formCondRequiredText\">&#8225;</span>Is Child receiving ongoing Medical or Psychological treatment :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_24.setType("radio");
                  _jspx_th_impact_validateInput_24.setLabel("Yes");
                  _jspx_th_impact_validateInput_24.setId("medPsychTrmnt_Yes");
                  _jspx_th_impact_validateInput_24.setName("rbIndMedPsychTrmnt");
                  _jspx_th_impact_validateInput_24.setValue("Y");
                  _jspx_th_impact_validateInput_24.setChecked(medPsychTrmnt_Yes);
                  _jspx_th_impact_validateInput_24.setCssClass("formInput");
                  _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
                  if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_25.setType("radio");
                  _jspx_th_impact_validateInput_25.setLabel("No");
                  _jspx_th_impact_validateInput_25.setId("medPsychTrmnt_No");
                  _jspx_th_impact_validateInput_25.setName("rbIndMedPsychTrmnt");
                  _jspx_th_impact_validateInput_25.setValue("N");
                  _jspx_th_impact_validateInput_25.setChecked(medPsychTrmnt_No);
                  _jspx_th_impact_validateInput_25.setCssClass("formInput");
                  _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
                  if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n     </tr>\r\n    <tr class=\"even\">\r\n      <td >\r\n                <span class=\"formCondRequiredText\">&#8225;</span>If yes, is it documented in the record :\r\n      </td>\r\n      <td>\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_26.setType("radio");
                  _jspx_th_impact_validateInput_26.setLabel("Yes");
                  _jspx_th_impact_validateInput_26.setId("medPsychDocRecord_Yes");
                  _jspx_th_impact_validateInput_26.setName("rbIndMedPsychDocRecord");
                  _jspx_th_impact_validateInput_26.setValue("Y");
                  _jspx_th_impact_validateInput_26.setChecked(medPsychDocRecord_Yes);
                  _jspx_th_impact_validateInput_26.setCssClass("formInput");
                  _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
                  if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n        ");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateInput_27.setType("radio");
                  _jspx_th_impact_validateInput_27.setLabel("No");
                  _jspx_th_impact_validateInput_27.setId("medPsychDocRecord_No");
                  _jspx_th_impact_validateInput_27.setName("rbIndMedPsychDocRecord");
                  _jspx_th_impact_validateInput_27.setValue("N");
                  _jspx_th_impact_validateInput_27.setChecked(medPsychDocRecord_No);
                  _jspx_th_impact_validateInput_27.setCssClass("formInput");
                  _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
                  if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write(" \r\n      </td> \r\n    </tr>\r\n<tr>\r\n                  <td valign=\"top\" colspan=\"1\">\r\n              If any evaluation dates are not in the Health Log, note why:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_11.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_11.setName("szTxtMedPsychDocRecordCmnts");
                  _jspx_th_impact_validateTextArea_11.setCols("92");
                  _jspx_th_impact_validateTextArea_11.setRows("3");
                  _jspx_th_impact_validateTextArea_11.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_11.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_11.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_11 = _jspx_th_impact_validateTextArea_11.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_11.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_11.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szMedPsychDocRecordCmnts);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_11.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_11 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n    </td>\r\n    </tr>\r\n<tr class=\"even\">\r\n                  <td valign=\"top\" colspan=\"1\">\r\n              Other relevant Medical or Psychological information:\r\n      </td>\r\n    <td colspan=\"2\">\r\n      ");
                  //  impact:validateTextArea
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
                  _jspx_th_impact_validateTextArea_12.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateTextArea_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
                  _jspx_th_impact_validateTextArea_12.setName("szTxtOtherMedPsychDocRecordCmnts");
                  _jspx_th_impact_validateTextArea_12.setCols("92");
                  _jspx_th_impact_validateTextArea_12.setRows("3");
                  _jspx_th_impact_validateTextArea_12.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateTextArea_12.setMaxLength(500);
                  _jspx_th_impact_validateTextArea_12.setConstraint("Paragraph500");
                  int _jspx_eval_impact_validateTextArea_12 = _jspx_th_impact_validateTextArea_12.doStartTag();
                  if (_jspx_eval_impact_validateTextArea_12 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                    if (_jspx_eval_impact_validateTextArea_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                      out = _jspx_page_context.pushBody();
                      _jspx_th_impact_validateTextArea_12.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                      _jspx_th_impact_validateTextArea_12.doInitBody();
                    }
                    do {
                      out.write(' ');
                      out.print(szOtherMedPsychDocRecordCmnts);
                      out.write("\r\n      ");
                      int evalDoAfterBody = _jspx_th_impact_validateTextArea_12.doAfterBody();
                      if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                        break;
                    } while (true);
                    if (_jspx_eval_impact_validateTextArea_12 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                      out = _jspx_page_context.popBody();
                  }
                  if (_jspx_th_impact_validateTextArea_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("\r\n      </td>\r\n      </tr>\r\n      </table>\r\n      </td>\r\n      </tr>\r\n      </table>\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n     </td>\r\n      </tr>\r\n      </table>\r\n ");

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
 
              out.write("\r\n    <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" border=\"0\" width=\"100%\">\r\n        <tr>\r\n          <td>\r\n            ");
              //  impact:ExpandableSectionTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
              _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_ExpandableSectionTag_4.setName("education");
              _jspx_th_impact_ExpandableSectionTag_4.setLabel("Education");
              _jspx_th_impact_ExpandableSectionTag_4.setRightLabel("Last Updated:" + eduLastUpdateDate);
              _jspx_th_impact_ExpandableSectionTag_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
              if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                do {
                  out.write("\r\n\r\n              <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\" bgcolor=\"white\">\r\n      <tr>\r\n      <td class=\"tableBG\">\r\n      <DIV id=\"scrollBar2\" style=\"height:155px;width:100%;overflow:auto\" class=\"tableborderList\">\r\n                 <TABLE width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n                           <TR>\r\n                           <TH class=\"thList\"></TH>\r\n                           <TH class=\"thList\">School Name</TH>\r\n                           <TH class=\"thList\">Enrolled</TH>\r\n                           <TH class=\"thList\">Grade</TH>\r\n                           <TH class=\"thList\">Withdrawn</TH>\r\n                           <TH class=\"thList\">Grade</TH></TR>\r\n                           \r\n                           ");

                                                        if (!educationEnumeration.hasMoreElements()) {
                                                                withdrawnDate = "ssss";
                                                      
                  out.write("\r\n                      <tr class=\"odd\">\r\n                        <td colspan=\"10\">\r\n                           ");
                  out.print(MessageLookup.getMessageByNumber(Messages.SSM_NO_ROWS_RETURNED));
                  out.write("\r\n                        </td>\r\n                      </tr>\r\n");

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

                  out.write("\r\n                              <tr class=\"");
                  out.print(FormattingHelper.getRowCss(loopCount + 1));
                  out.write("\" valign=\"top\">\r\n                        ");

                          /* EduOnClick used to submit the row's parameters to hidden fields */
                        
                  out.write("\r\n                        ");

                          String EduOnClick = "setEduParms( '" + educationRow.getTsLastUpdate() + "', '"
                                                        + educationRow.getUlIdEdhist() + "', '" + loopCount + "' )";
                        
                  out.write("\r\n                            <td>");
                  //  impact:validateInput
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
                  _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
                  _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
                  _jspx_th_impact_validateInput_28.setId("eduRadio" + loopCount);
                  _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
                  _jspx_th_impact_validateInput_28.setValue("loopCount");
                  _jspx_th_impact_validateInput_28.setType("radio");
                  _jspx_th_impact_validateInput_28.setName("eduSelect_CLEAN");
                  _jspx_th_impact_validateInput_28.setEditableMode(EditableMode.EDIT + EditableMode.NEW);
                  _jspx_th_impact_validateInput_28.setOnClick(EduOnClick);
                  int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
                  if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</td>\r\n                            <td><a tabIndex=\"");
                  out.print(tabIndex++);
                  out.write("\"\r\n                              href=\"javascript: ");
                  out.print(EduOnClick);
                  out.write("; cancelValidation(); submitValidateForm( 'frmChildPlan', '/person/PersonDetail/displayEducation' )\">");
                  out.print(schoolName);
                  out.write("</a></td>  \r\n                            <td>");
                  out.print(FormattingHelper.formatDate(educationRow.getDtDtEdhistEnrollDate()));
                  out.write("</td>\r\n                            <td>");
                  out.print(Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistEnrollGrade()));
                  out.write("</td>\r\n                            <td>");
                  out.print(FormattingHelper.formatDate(educationRow.getDtDtEdhistWithdrawnDate()));
                  out.write("</td>\r\n                            <td>");
                  out.print(Lookup.simpleDecodeSafe("CSCHGRAD", educationRow.getSzCdEdhistWithdrawnGrade()));
                  out.write("</td>\r\n                        </tr>\r\n                           \r\n                           ");

                                                        loopCount++;
                                                                } // end for
                                                              }
                                                      
                  out.write("\r\n                           \r\n                           </TABLE></DIV>\r\n                              </td>\r\n      </tr>\r\n      </table>\r\n      <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n      <tr>\r\n      ");

        // Pilot R2: to reduce confusion and avoid this scenrio: that user able to add Education items from a new 
              // Child Detail; navigate away from Child Detail without saving it, thinking a Child Detail has been created

              if (!PageModeConstants.NEW.equals(pageMode) && !PageModeConstants.NEW_USING.equals(pageMode)) {
      
                  out.write("\r\n      <td>\r\n      <div class=\"alignRight\">");
                  //  impact:ButtonTag
                  gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
                  _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
                  _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
                  _jspx_th_impact_ButtonTag_0.setName("btnAddEdu");
                  _jspx_th_impact_ButtonTag_0.setImg("btnAdd");
                  _jspx_th_impact_ButtonTag_0.setNavAwayCk(false);
                  _jspx_th_impact_ButtonTag_0.setFunction("return savePageAdd();");
                  _jspx_th_impact_ButtonTag_0.setForm("frmChildPlan");
                  _jspx_th_impact_ButtonTag_0.setAction("/person/PersonDetail/addEducation");
                  _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex++);
                  int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
                  if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                    return;
                  out.write("</div>\r\n                              \r\n             </td>  \r\n      ");

          }
        
                  out.write("                      \r\n         </tr>\r\n      </table>\r\n\r\n       ");
                  int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
              }
              if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n         </td>\r\n         </tr>\r\n        </table>\r\n  ");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n \r\n <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n  <tr>\r\n     <td width=\"100%\" align=\"right\">\r\n        ");
          //  impact:spellCheck
          gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag _jspx_th_impact_spellCheck_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.SpellCheckTag();
          _jspx_th_impact_spellCheck_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_spellCheck_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_spellCheck_0.setFormToSpellCheck("frmChildPlan");
          _jspx_th_impact_spellCheck_0.setFieldsToSpellCheck(fieldsToBeSpellChecked);
          _jspx_th_impact_spellCheck_0.setTabIndex(tabIndex++);
          int _jspx_eval_impact_spellCheck_0 = _jspx_th_impact_spellCheck_0.doStartTag();
          if (_jspx_th_impact_spellCheck_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnCompleteQ");
          _jspx_th_impact_ButtonTag_1.setImg("btnCompleteQ");
          _jspx_th_impact_ButtonTag_1.setForm("frmChildPlan");
          _jspx_th_impact_ButtonTag_1.setFunction("");
          _jspx_th_impact_ButtonTag_1.setAction("/subcare/ChildPlan/completeFccpChild");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_1.setDisabled("false");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n     <td align=\"right\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setForm("frmChildPlan");
          _jspx_th_impact_ButtonTag_2.setAction("/subcare/ChildPlan/saveFccpChild");
          _jspx_th_impact_ButtonTag_2.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setDisabled("false");
          _jspx_th_impact_ButtonTag_2.setFunction("");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n  </tr>\r\n  </table>\r\n  <br>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
      }
    } finally {
      if (_jspxFactory != null) _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }

  private boolean _jspx_meth_impact_validateErrors_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateErrors
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag _jspx_th_impact_validateErrors_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormErrorTag();
    _jspx_th_impact_validateErrors_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateErrors_0.setParent(null);
    int _jspx_eval_impact_validateErrors_0 = _jspx_th_impact_validateErrors_0.doStartTag();
    if (_jspx_th_impact_validateErrors_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_2(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_2.setType("hidden");
    _jspx_th_impact_validateInput_2.setName("pageName");
    _jspx_th_impact_validateInput_2.setValue("ChildPlan");
    int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
    if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_3(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_3.setType("hidden");
    _jspx_th_impact_validateInput_3.setName("hdnTsEduLastUpdate");
    _jspx_th_impact_validateInput_3.setValue("");
    int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
    if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_4(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_4.setType("hidden");
    _jspx_th_impact_validateInput_4.setName("hdnUlIdEdhist");
    _jspx_th_impact_validateInput_4.setValue("");
    int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
    if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_5(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_5.setType("hidden");
    _jspx_th_impact_validateInput_5.setName("hdnEduLoopCount");
    _jspx_th_impact_validateInput_5.setValue("");
    int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
    if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_6(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_6.setType("hidden");
    _jspx_th_impact_validateInput_6.setName("hdnIndChildPage");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
