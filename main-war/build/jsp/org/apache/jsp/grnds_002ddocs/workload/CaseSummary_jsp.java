package org.apache.jsp.grnds_002ddocs.workload;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.List;
import java.util.Iterator;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.workload.CFMgmntValueBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC21SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN37SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN81SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCFC39SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN37SOG02_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST;
import gov.georgia.dhr.dfcs.sacwis.structs.output.STFFASSGNMTHIST_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecHD;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryConversation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseErrorsSO;
import gov.georgia.dhr.dfcs.sacwis.structs.casewatch.CaseWarningsSO;

public final class CaseSummary_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
 /*SIR 23572 - MPS Online IMPACT Enhancements - Import Case Utility*/ 
      out.write('\r');
      out.write('\n');

  int loopCount = 0;
  int selectedIndex = -1;
  String pageMode = PageModeConstants.MODIFY;
  int selectedStageId = 0;
  String selectedStageCode = null;
  org.exolab.castor.types.Date selectedStageDateClosed = null;
  //Error Warning Variables
  int caseErrorCount = 0;
  int caseWarningCount = 0;
  List<String> caseErrors = null;
  List<String> caseWarnings = null;
   //MR-072 
  List<String> customizedErrors = null;
//SIR 23714 Case Merge expandable section should be hidden for all C-REG and C-GUA stages types.
  String globalSzStageType = GlobalData.getSzCdStageType(request);

  UserProfile user = UserProfileHelper.getUserProfile(request);

  int tabIndex = 1;
  BaseSessionStateManager state =
          (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);

  List cfmLocationInfoList = null;
  String sLocatingInfo = "";
  if (state.getAttribute("LocatingInformation", request) != null) {
    cfmLocationInfoList = (List) (state.getAttribute("LocatingInformation", request));
  }

  CFMgmntValueBean cfmLocationInfoRow;
  if (cfmLocationInfoList != null) {
    for (int iLoopCounter = 0; iLoopCounter < cfmLocationInfoList.size(); iLoopCounter++) {
      cfmLocationInfoRow = (CFMgmntValueBean) cfmLocationInfoList.get(iLoopCounter);
      String locatingInformation = cfmLocationInfoRow.getLocatingInformation();
      if (locatingInformation == null || locatingInformation.trim().length() == 0) {
        sLocatingInfo = FormattingHelper.formatString(sLocatingInfo);
      } else {
        int mCount = iLoopCounter + 1;
        String sConcat = "(" + mCount + ")";
        sLocatingInfo = FormattingHelper.formatString(sLocatingInfo) + sConcat;
        sLocatingInfo = sLocatingInfo + cfmLocationInfoRow.getCaseId() + "_";
        sLocatingInfo = sLocatingInfo + FormattingHelper.formatString(locatingInformation) + " ";
      }
    }
  }
  sLocatingInfo = FormattingHelper.formatString(sLocatingInfo);
  // Get the output object from the request for Case Summary
  CCMN37SO ccmn37so = (CCMN37SO) state.getAttribute("CCMN37SO", request);
  // Get the output object from the request for Special Handling
  CCMN81SO ccmn81so = (CCMN81SO) state.getAttribute("CCMN81SO", request);
  // Get the output object from the request for Case File Management
  CCFC21SO ccfc21so = (CCFC21SO) state.getAttribute("CCFC21SO", request);
  // Get the output object from the request for Records Retention
  CCFC19SO ccfc19so = (CCFC19SO) state.getAttribute("CCFC19SO", request);

  // Get the Warnings and Errors Output objects
  CaseErrorsSO caseErrorsSO = (CaseErrorsSO) state.getAttribute("CaseErrorsSO", request);
  CaseWarningsSO caseWarningsSO = (CaseWarningsSO) state.getAttribute("CaseWarningsSO", request);
  
  if (caseErrorsSO != null ) {
    
    caseErrorCount = caseErrorsSO.getErrorCount();
    caseErrors = caseErrorsSO.getErrorCodes();
     //MR-072 customized errors
    customizedErrors = caseErrorsSO.getCustomizedErrors();
  }
  if (caseWarningsSO != null ) {
    
    caseWarningCount = caseWarningsSO.getWarningCount();
    caseWarnings = caseWarningsSO.getWarningCodes();
  }
  // Null catch for Case Summary objects, if null set to blank
  if (ccmn37so == null) {
    ccmn37so = new CCMN37SO();
  }
  if (ccmn81so == null) {
    ccmn81so = new CCMN81SO();
  }

  //Get Case Summary object
  ROWCCMN37SOG01 caseSummary;
  if (ccmn37so.getROWCCMN37SOG01() != null) {
    caseSummary = ccmn37so.getROWCCMN37SOG01();
  } else {
    caseSummary = new ROWCCMN37SOG01();
  }

  //Get Case Summary Array of stages
  ROWCCMN37SOG02_ARRAY caseSummaryArray;
  if (ccmn37so.getROWCCMN37SOG02_ARRAY() != null) {
    caseSummaryArray = ccmn37so.getROWCCMN37SOG02_ARRAY();
  } else {
    caseSummaryArray = new ROWCCMN37SOG02_ARRAY();
  }

  // Null catch for Special Handling, if null set to blank
  if (ccmn81so == null) {
    ccmn81so = new CCMN81SO();
  }
  SpecHD specialHandling;
  if (ccmn81so.getSpecHD() != null) {
    specialHandling = ccmn81so.getSpecHD();
  } else {
    specialHandling = new SpecHD();
  }

  ROWCCFC39SOG00_ARRAY caseMergeSplitArray = (ROWCCFC39SOG00_ARRAY) request.getAttribute("caseMergeArray");
  if (caseMergeSplitArray == null) {
    caseMergeSplitArray = new ROWCCFC39SOG00_ARRAY();
  }

// Null catch for Case File Management, if null set to blank
  if (ccfc21so == null) {
    ccfc21so = new CCFC21SO();
  }

// Null catch for Records Retention, if null set to blank
  if (ccfc19so == null) {
    ccfc19so = new CCFC19SO();
  }

  // These boolean values find out from the conversation if the section should be in modify mode or browse by checking
  //  security and workload status. If the attributes are true, they disable various widgets in the expandable sections.
  boolean pageSetEDisabled = request.getAttribute(CaseSummaryConversation.PAGE_E) != null;
  // SIR#23645. changed != to == in the following statement. PAGE_F attribute is set to Boolean.TRUE
  //   if user has SEC_MERGE_CASE security attribute or stage access. Otherwise  it's set to null
  boolean pageSetFDisabled = request.getAttribute(CaseSummaryConversation.PAGE_F) == null;
  boolean pageSetGDisabled = request.getAttribute(CaseSummaryConversation.PAGE_G) != null;
  boolean pageSetHDisabled = request.getAttribute(CaseSummaryConversation.PAGE_H) != null;
  boolean hasCaseAccess = request.getAttribute("hasCaseAccess") != null;
  // This boolean is used to allow closed cases to be saved when they have been converted and
  // therefore do not have a records retention section - SIR 22406
  boolean bIndHasRecordsRet = true;

  if (("N").equals(request.getAttribute(CaseSummaryConversation.HAS_REC_RET))) {
    bIndHasRecordsRet = false;
  }

  String cdCounty = StringHelper.EMPTY_STRING;
  
  if (request.getParameter("selSzCdCounty") == null) {
        cdCounty = FormattingHelper.formatString(ccfc21so.getSzCdCounty());
  }else{
        cdCounty = request.getParameter("selSzCdCounty");
  }
  
  String cdRegion = ccfc21so.getSzCdOfficeRegion();
  
  if (("").equals(cdRegion) || cdRegion == null) {
       cdRegion = request.getParameter("selSzCdOfficeRegion");
  }

      out.write("\r\n\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\nfunction changeSpecHandlingComment(commentField, checkBox) {\r\n  checkBox.checked = commentField.value != \"\";\r\n}\r\n\r\nfunction changeCaseMgmtField(prs, source) {\r\n  if (source.value != \"\") {\r\n    frmCaseSummary.rbPrs[0].checked = prs;\r\n    frmCaseSummary.rbPrs[1].checked = !prs;\r\n    frmCaseSummary.rbPrs.value = prs ? \"P\" : \"N\";\r\n  }\r\n  else if (frmCaseSummary.selSzCdOfficeRegion.value == \"\" &&\r\n           frmCaseSummary.txtSzNbrUnit.value == \"\" &&\r\n           frmCaseSummary.txtSzNmCaseFileOffice.value == \"\" &&\r\n           frmCaseSummary.txtSzAddrCaseFileStLn1.value == \"\" &&\r\n           frmCaseSummary.txtSzAddrCaseFileStLn2.value == \"\" &&\r\n           frmCaseSummary.txtSzAddrCaseFileCity.value == \"\") {\r\n    frmCaseSummary.rbPrs[0].checked = false;\r\n    frmCaseSummary.rbPrs[1].checked = false;\r\n    frmCaseSummary.rbPrs.value = null;\r\n  }\r\n}\r\n\r\n// this function stores the row information for the particular stage the user has selected\r\n");
      out.write("// with the radio button for any of the case summary pushbuttons\r\nfunction selectStage(index) {\r\n  var form = document.all[\"frmCaseSummary\"];\r\n  form.hdnCScrIndStageMerged.value = stageArray[index].cScrIndStageMerged;\r\n  form.hdnSzNmStage.value = stageArray[index].szNmStage;\r\n  form.hdnSzCdStage.value = stageArray[index].szCdStage;\r\n  form.hdnSzCdStageType.value = stageArray[index].szCdStageType;\r\n  form.hdnSzCdStageLevel.value = stageArray[index].szCdStageLevel;\r\n  form.hdnDtDtStageStart.value = stageArray[index].dtDtStageStart;\r\n  form.hdnDtDtStageClose.value = stageArray[index].dtDtStageClose;\r\n  form.hdnSzNmPersonFull.value = stageArray[index].szNmPersonFull;\r\n  form.hdnSzCdStageRegion.value = stageArray[index].szCdStageRegion;\r\n  form.hdnSzCdStageCounty.value = stageArray[index].szCdStageCounty;\r\n  form.hdnUlIdStage.value = stageArray[index].ulIdStage;\r\n  form.hdnUlIdAdoCase.value = stageArray[index].ulIdCase;\r\n}\r\n\r\n// This function is called when the user clicks a hyperlink in the list for merged/split cases.\r\n");
      out.write("// It takes the user to the CaseMergeSplitDetail page.\r\nfunction caseMergeSplitHyperlink(index, pendStatus, staffNameMerge, staffNameSplit, idCaseMerge) {\r\n  frmCaseSummary.arrayIndex.value = index;\r\n  frmCaseSummary.pendStatus.value = pendStatus;\r\n  frmCaseSummary.staffNameMerge.value = staffNameMerge;\r\n  frmCaseSummary.staffNameSplit.value = staffNameSplit;\r\n  frmCaseSummary.idCaseMerge.value = idCaseMerge;\r\n  disableValidation('frmCaseSummary');\r\n  submitValidateForm('frmCaseSummary', '/workload/CaseSummary/displayCaseMergeSplitDetail');\r\n}\r\n\r\n//This functions checks to make sure the selected stage can be reopened. Only FSU, SUB,\r\n//FRE, and PAD stages can be reopened, and they must be closed.\r\nfunction reopenStage(rowCount) {\r\n  var form = document.all[\"frmCaseSummary\"];\r\n  // SIR 22985 - Call isRadioChecked to determine if a stage has been selected\r\n  // by the user.\r\n  if (!isRadioChecked(rowCount)) {\r\n    return false;\r\n  }\r\n  if (form.hdnDtDtStageClose.value == \"null\" || form.hdnDtDtStageClose.value == \"3500-12-31\" || form.hdnDtDtStageClose.value == \"4712-12-31\") {\r\n");
      out.write("    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_ROP_CLOSED_STAGE) );
      out.write("');\r\n    return false;\r\n  }\r\n  if (form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.SUB_STAGE );
      out.write("' &&\r\n      form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.FSU_STAGE );
      out.write("' &&\r\n      form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.ADO_STAGE );
      out.write("' &&\r\n      form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.PAD_STAGE );
      out.write("' &&\r\n      form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.DIV_STAGE );
      out.write("' &&\r\n      form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.FPR_STAGE );
      out.write("' &&\r\n      form.hdnSzCdStage.value != '");
      out.print( CaseSummaryConversation.PFC_STAGE );
      out.write("' ) {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_ROP_TYPE) );
      out.write("');\r\n    return false;\r\n  }\r\n  return true;\r\n}\r\n\r\nfunction caseFilePrint() {\r\n  disableValidation('frmCaseSummary');\r\n  return true;\r\n}\r\n\r\n//This function checks to see that the chosen stage can perform an admin review. Closed\r\n//INV stages can create a review as well as closed ARI/ARF or open/closed FAD stages.\r\n//This button submits to callAdminCommand, which uses form.hdnAdminCommand to determine\r\n//what command to execute.\r\nfunction adminReview(rowCount) {\r\n  var form = document.all[\"frmCaseSummary\"];\r\n  // SIR 22985 - Call isRadioChecked to determine if a stage has been selected\r\n  // by the user.12\r\n  if (!isRadioChecked(rowCount)) {\r\n    return false;\r\n  }\r\n  //User cannot create admin reviews for cases that are closed to merge\r\n  if (form.hdnCScrIndStageMerged.value == \"Y\") {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CASE_CLOSED_TO_MERGE) );
      out.write("');\r\n    return false;\r\n  }\r\n  //Prompts user to created stage, INV stage must be closed\r\n  if (form.hdnSzCdStage.value == '");
      out.print( CaseSummaryConversation.INV_STAGE );
      out.write("' &&\r\n      (form.hdnDtDtStageClose.value != \"null\" && form.hdnDtDtStageClose.value != \"3500-12-31\" && form.hdnDtDtStageClose.value != \"4712-12-31\" )) {\r\n    goOn = confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ACTION_CREATE_AR));
      out.write("\");\r\n    if (!goOn) {\r\n      return false;\r\n    }\r\n    disableValidation('frmCaseSummary');\r\n    form.hdnAdminCommand.value = \"/workload/CaseSummary/createAdmnReview_CheckPersonList\";\r\n    return true;\r\n  }\r\n   //Prompts user to created stage, FAD stage can be open or closed\r\n   //Per STGAP00006539 In Shines, we do not create Admin Review stage of ARF \r\n  if (form.hdnSzCdStage.value == '");
      out.print( CaseSummaryConversation.FAD_STAGE );
      out.write("') {\r\n   // goOn = confirm(\"");
      out.print(MessageLookup.getMessageByNumber(Messages.MSG_ACTION_CREATE_AR));
      out.write("\");\r\n   //if (!goOn) {\r\n   // return false;\r\n   // }\r\n   //disableValidation('frmCaseSummary');\r\n   //form.hdnAdminCommand.value = \"/workload/CaseSummary/createAdmnReview_CallCCFC42S\";\r\n   alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NOT_ADMIN_STAGE) );
      out.write("');\r\n   return false;\r\n  }\r\n  //ARI/ARF stages must be closed, no prompt to create stage, only can view Admin Review\r\n  else if (( form.hdnSzCdStage.value == '");
      out.print( CaseSummaryConversation.ARI_STAGE );
      out.write("' ||\r\n             form.hdnSzCdStage.value == '");
      out.print( CaseSummaryConversation.ARF_STAGE );
      out.write("') &&\r\n           (form.hdnDtDtStageClose.value != \"null\" && form.hdnDtDtStageClose.value != \"3500-12-31\" && form.hdnDtDtStageClose.value != \"4712-12-31\")) {\r\n    disableValidation('frmCaseSummary');\r\n    form.hdnAdminCommand.value = \"/workload/CaseSummary/callAdmnReview\";\r\n    return true;\r\n  }\r\n  else {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_NOT_ADMIN_STAGE) );
      out.write("');\r\n    return false;\r\n  }\r\n}\r\n\r\n");

org.exolab.castor.types.Date closedDate = ccfc19so.getDtDtCaseClosed();
org.exolab.castor.types.Date destroyDate = ccfc19so.getDtDtRecRtnDstryElig();

if (!DateHelper.isNull(closedDate)) {
      out.write("\r\n// break the incoming date from the CCFC19S service into M/D/Y parts\r\nvar iCYear = ");
      out.print( (100 * closedDate.getCentury()) + closedDate.getYear());
      out.write(";\r\nvar iCMonth = ");
      out.print(closedDate.getMonth());
      out.write(";\r\nvar iCDay = ");
      out.print(closedDate.getDay());
      out.write(";\r\n\r\nvar iDYear = ");
      out.print( (100 * destroyDate.getCentury()) + destroyDate.getYear());
      out.write(";\r\nvar iDMonth = ");
      out.print( destroyDate.getMonth());
      out.write(";\r\nvar iDDay = ");
      out.print( destroyDate.getDay());
      out.write(";\r\n\r\n// called when we change the Destruction Date to confirm user intentions if time > 20 yr\r\nfunction validateDestructionDate() {\r\n  // get the date from the date control, and parse it into M/D/Y parts\r\n  var sRemovalDate = frmCaseSummary.txtDtDtRecRtnDstryActual.value;\r\n\r\n  var valid = validateDate(sRemovalDate);\r\n  if (!valid) {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_INVALID_DATE) );
      out.write("');\r\n    frmCaseSummary.txtDtDtRecRtnDstryActual.value =\r\n    \"");
      out.print( FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual()));
      out.write("\";\r\n    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = false;\r\n    return;\r\n  }\r\n\r\n  var pos = sRemovalDate.search('/');\r\n  var iMonth = parseInt(sRemovalDate.substring(0, pos));\r\n  sRemovalDate = sRemovalDate.substring(pos + 1, sRemovalDate.length);\r\n  pos = sRemovalDate.search('/');\r\n  var iDay = parseInt(sRemovalDate.substring(0, pos));\r\n  var iYear = parseInt(sRemovalDate.substring(pos + 1, sRemovalDate.length));\r\n\r\n  // compute the number of full months between the two dates\r\n  var months = (iYear - iCYear) * 12 + (iMonth - iCMonth);\r\n  if (iDay < iCDay) {\r\n    months--;\r\n  }\r\n\r\n  // if the time is greater than 20 yr, and the user does not confirm, clear the control\r\n  if ((months > 240 || (months == 240 && iDay > iCDay)) &&\r\n      !confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_CFC_REC_RETN_EXTENSION) );
      out.write("')) {\r\n    frmCaseSummary.txtDtDtRecRtnDstryActual.value =\r\n    \"");
      out.print( FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual()) );
      out.write("\";\r\n    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = false;\r\n  }\r\n  else {\r\n    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = true;\r\n  }\r\n\r\n  // if the date in the date control is less than the date that was returned by the database, post a message\r\n  if (isBefore(iDay, iMonth, iYear, iDDay, iDMonth, iDYear)) {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber(Messages.SSM_DEST_AFTER_SAME_CALC) );
      out.write("');\r\n    frmCaseSummary.txtDtDtRecRtnDstryActual.value =\r\n    \"");
      out.print( FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual()) );
      out.write("\";\r\n    frmCaseSummary.cbxScrIndDestrctnDateChng.checked = false;\r\n  }\r\n}\r\n");

} // end if (closedDate != null)

      out.write("\r\n\r\n//returns true if the date represented by day1, month1, year1 is before  the date represented by day2, month2, year2\r\nfunction isBefore(day1, month1, year1, day2, month2, year2) {\r\n  if (year1 < year2) {\r\n    return true;\r\n  } else if (year1 > year2) {\r\n    return false;\r\n  }\r\n  if (month1 < month2) {\r\n    return true;\r\n  } else if (month1 > month2) {\r\n    return false;\r\n  }\r\n  return day1 < day2;\r\n}\r\n\r\n//calls the method to pass in data for the new stage so the 2nd level tabs can update accordingly\r\nfunction selectNewStage(rowCount) {\r\n  // SIR 22985 - Call isRadioChecked to determine if a stage has been selected\r\n  // by the user.\r\n  if (!isRadioChecked(rowCount)) {\r\n    return false;\r\n  }\r\n  else {\r\n    disableValidation('frmCaseSummary');\r\n    return true;\r\n  }\r\n}\r\n\r\n// SIR 22985 - Added isRadioChecked to insure that a Radio button\r\n// is selected, if it isn't display a message.\r\nfunction isRadioChecked(arrayLength) {\r\n  var bRadio = false;\r\n  var listRb = document.getElementsByName(\"radioIndex_CLEAN\");\r\n");
      out.write("  for (var i = 0; i < arrayLength; i++) {\r\n    bRadio = listRb[i].checked;\r\n    if (bRadio) {\r\n      break;\r\n    }\r\n  }\r\n  if (!bRadio) {\r\n    alert('");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_SELECT_STAGE ) );
      out.write("');\r\n  }\r\n  return bRadio;\r\n}\r\n\r\nwindow.onbeforeunload = function () {\r\n  IsDirty();\r\n}\r\n\r\nwindow.attachEvent(\"onload\", initializePage);\r\n\r\nfunction initializePage(){\r\n updateCountyCodes();\r\n}\r\n\r\n// STGAP00004864 \r\n\r\n// 04/11/2012 vcollooru STGAP00018067: Modified to remove the coded referring to regions 16 and 17\r\n// NOTE: This part of code is no longer being used as the counties are not getting filtered based on region.\r\n// Hence this cannot be tested in the application.\r\nvar codes001 = new Array();\r\ncodes001[0]= \"|\"; \r\ncodes001[1]= \"047\"+\"|\"+\"047 CATOOSA\";\r\ncodes001[2]= \"055\"+\"|\"+\"055 CHATTOOGA\";\r\ncodes001[3]= \"083\"+\"|\"+\"083 DADE\";\r\ncodes001[4]= \"111\"+\"|\"+\"111 FANNIN\";\r\ncodes001[5]= \"123\"+\"|\"+\"123 GILMER\";\r\ncodes001[6]= \"129\"+\"|\"+\"129 GORDON\";\r\ncodes001[7]= \"213\"+\"|\"+\"213 MURRAY\";\r\ncodes001[8]= \"227\"+\"|\"+\"227 PICKENS\";\r\ncodes001[9]= \"295\"+\"|\"+\"295 CATOOSA\";\r\ncodes001[10]= \"313\"+\"|\"+\"313 WHITFIELD\";\r\n\r\nvar codes002 = new Array();\r\ncodes002[0]= \"|\"; \r\ncodes002[1]= \"011\"+\"|\"+\"011 BANKS\";\r\ncodes002[2]= \"085\"+\"|\"+\"085 DAWSON\";\r\n");
      out.write("codes002[3]= \"117\"+\"|\"+\"117 FORSYTH\";\r\ncodes002[4]= \"119\"+\"|\"+\"119 FRANKLIN\";\r\ncodes002[5]= \"137\"+\"|\"+\"137 HABERSHAM\";\r\ncodes002[6]= \"139\"+\"|\"+\"139 HALL\";\r\ncodes002[7]= \"147\"+\"|\"+\"147 HART\";\r\ncodes002[8]= \"187\"+\"|\"+\"187 LUMPKIN\";\r\ncodes002[9]= \"241\"+\"|\"+\"241 RABUN\";\r\ncodes002[10]= \"257\"+\"|\"+\"257 STEPHENS\";\r\ncodes002[11]= \"281\"+\"|\"+\"281 TOWNS\";\r\ncodes002[12]= \"291\"+\"|\"+\"291 UNION\";\r\ncodes002[13]= \"311\"+\"|\"+\"311 WHITE\";\r\n\r\n\r\n\r\nvar codes003 = new Array();\r\ncodes003[0]= \"|\"; \r\ncodes003[1]= \"015\"+\"|\"+\"015 BARTOW\";\r\ncodes003[2]= \"057\"+\"|\"+\"057 CHEROKEE\";\r\ncodes003[3]= \"097\"+\"|\"+\"097 DOUGLAS\";\r\ncodes003[4]= \"115\"+\"|\"+\"115 FLOYD\";\r\ncodes003[5]= \"143\"+\"|\"+\"143 HARALSON\";\r\ncodes003[6]= \"223\"+\"|\"+\"223 PAULDING\";\r\ncodes003[7]= \"233\"+\"|\"+\"233 POLK\";\r\n\r\nvar codes004 = new Array();\r\ncodes004[0]= \"|\"; \r\ncodes004[1]= \"035\"+\"|\"+\"035 BUTTS\";\r\ncodes004[2]= \"045\"+\"|\"+\"045 CARROLL\";\r\ncodes004[3]= \"077\"+\"|\"+\"077 COWETA\";\r\ncodes004[4]= \"113\"+\"|\"+\"113 FAYETTE\";\r\ncodes004[5]= \"149\"+\"|\"+\"149 HEARD\";\r\ncodes004[6]= \"171\"+\"|\"+\"171 LAMAR\";\r\n");
      out.write("codes004[7]= \"199\"+\"|\"+\"199 MERIWETHER\";\r\ncodes004[8]= \"231\"+\"|\"+\"231 PIKE\";\r\ncodes004[9]= \"255\"+\"|\"+\"255 SPALDING\";\r\ncodes004[10]= \"285\"+\"|\"+\"285 TROUP\";\r\ncodes004[11]= \"293\"+\"|\"+\"293 UPSON\";\r\n\r\nvar codes005 = new Array();\r\ncodes005[0]= \"|\"; \r\ncodes005[1]= \"013\"+\"|\"+\"013 BARROW\";\r\ncodes005[2]= \"059\"+\"|\"+\"059 CLARKE\";\r\ncodes005[3]= \"105\"+\"|\"+\"105 ELBERT\";\r\ncodes005[4]= \"133\"+\"|\"+\"133 GREENE\";\r\ncodes005[5]= \"157\"+\"|\"+\"157 JACKSON\";\r\ncodes005[6]= \"159\"+\"|\"+\"159 JASPER\";\r\ncodes005[7]= \"195\"+\"|\"+\"195 MADISON\";\r\ncodes005[8]= \"211\"+\"|\"+\"211 MORGAN\";\r\ncodes005[9]= \"217\"+\"|\"+\"217 NEWTON\";\r\ncodes005[10]= \"219\"+\"|\"+\"219 OCONEE\";\r\ncodes005[11]= \"221\"+\"|\"+\"221 OGLETHORPE\";\r\ncodes005[12]= \"297\"+\"|\"+\"297 WALTON\";\r\n\r\nvar codes006 = new Array();\r\ncodes006[0]= \"|\"; \r\ncodes006[1]= \"009\"+\"|\"+\"009 BALDWIN\";\r\ncodes006[2]= \"021\"+\"|\"+\"021 BIBB\";\r\ncodes006[3]= \"079\"+\"|\"+\"079 CRAWFORD\";\r\ncodes006[4]= \"153\"+\"|\"+\"153 HOUSTON\";\r\ncodes006[5]= \"169\"+\"|\"+\"169 JONES\";\r\ncodes006[6]= \"207\"+\"|\"+\"207 MONROE\";\r\ncodes006[7]= \"225\"+\"|\"+\"225 PEACH\";\r\n");
      out.write("codes006[8]= \"237\"+\"|\"+\"237 PUTNAM\";\r\ncodes006[9]= \"289\"+\"|\"+\"289 TWIGGS\";\r\ncodes006[10]= \"319\"+\"|\"+\"319 WILKINSON\";\r\n\r\nvar codes007 = new Array();\r\ncodes007[0]= \"|\"; \r\ncodes007[1]= \"033\"+\"|\"+\"033 BURKE\";\r\ncodes007[2]= \"073\"+\"|\"+\"073 COLUMBIA\";\r\ncodes007[3]= \"125\"+\"|\"+\"125 GLASCOCK\";\r\ncodes007[4]= \"141\"+\"|\"+\"141 HANCOCK\";\r\ncodes007[5]= \"163\"+\"|\"+\"163 JEFFERSON\";\r\ncodes007[6]= \"165\"+\"|\"+\"165 JENKINS\";\r\ncodes007[7]= \"181\"+\"|\"+\"181 LINCOLN\";\r\ncodes007[8]= \"189\"+\"|\"+\"189 MCDUFFIE\";\r\ncodes007[9]= \"245\"+\"|\"+\"245 RICHMOND\";\r\ncodes007[10]= \"251\"+\"|\"+\"251 SCREVEN\";\r\ncodes007[11]= \"265\"+\"|\"+\"265 TALIAFERRO\";\r\ncodes007[12]= \"301\"+\"|\"+\"301 WARREN\";\r\ncodes007[13]= \"303\"+\"|\"+\"303 WASHINGTON\";\r\ncodes007[14]= \"317\"+\"|\"+\"317 WILKES\";\r\n\r\nvar codes008 = new Array();\r\ncodes008[0]= \"|\"; \r\ncodes008[1]= \"053\"+\"|\"+\"053 CHATTAHOOCHEE\";\r\ncodes008[2]= \"061\"+\"|\"+\"061 CLAY\";\r\ncodes008[3]= \"081\"+\"|\"+\"081 CRISP\";\r\ncodes008[4]= \"093\"+\"|\"+\"093 DOOLY\";\r\ncodes008[5]= \"145\"+\"|\"+\"145 HARRIS\";\r\ncodes008[6]= \"193\"+\"|\"+\"193 MACON\";\r\ncodes008[7]= \"197\"+\"|\"+\"197 MARION\";\r\n");
      out.write("codes008[8]= \"215\"+\"|\"+\"215 MUSCOGEE\";\r\ncodes008[9]= \"239\"+\"|\"+\"239 QUITMAN\";\r\ncodes008[10]= \"243\"+\"|\"+\"243 RANDOLPH\";\r\ncodes008[11]= \"249\"+\"|\"+\"249 SCHLEY\";\r\ncodes008[12]= \"259\"+\"|\"+\"259 STEWART\";\r\ncodes008[13]= \"261\"+\"|\"+\"261 SUMTER\";\r\ncodes008[14]= \"263\"+\"|\"+\"263 TALBOT\";\r\ncodes008[15]= \"269\"+\"|\"+\"269 TAYLOR\";\r\ncodes008[16]= \"307\"+\"|\"+\"307 WEBSTER\";\r\n\r\nvar codes009 = new Array();\r\ncodes009[0]= \"|\"; \r\ncodes009[1]= \"001\"+\"|\"+\"001 APPLING\";\r\ncodes009[2]= \"023\"+\"|\"+\"023 BLECKLEY\";\r\ncodes009[3]= \"043\"+\"|\"+\"043 CANDLER\";\r\ncodes009[4]= \"091\"+\"|\"+\"091 DODGE\";\r\ncodes009[5]= \"107\"+\"|\"+\"107 EMANUEL\";\r\ncodes009[6]= \"109\"+\"|\"+\"109 EVANS\";\r\ncodes009[7]= \"161\"+\"|\"+\"161 JEFF DAVIS\";\r\ncodes009[8]= \"167\"+\"|\"+\"167 JOHNSON\";\r\ncodes009[9]= \"175\"+\"|\"+\"175 LAURENS\";\r\ncodes009[10]= \"209\"+\"|\"+\"209 MONTGOMERY\";\r\ncodes009[11]= \"235\"+\"|\"+\"235 PULASKI\";\r\ncodes009[12]= \"267\"+\"|\"+\"267 TATTNALL\";\r\ncodes009[13]= \"271\"+\"|\"+\"271 TELFAIR\";\r\ncodes009[14]= \"279\"+\"|\"+\"279 TOOMBS\";\r\ncodes009[15]= \"283\"+\"|\"+\"283 TREUTLEN\";\r\ncodes009[16]= \"305\"+\"|\"+\"305 WAYNE\";\r\n");
      out.write("codes009[17]= \"309\"+\"|\"+\"309 WHEELER\";\r\ncodes009[18]= \"315\"+\"|\"+\"315 WILCOX\";\r\n\r\nvar codes010 = new Array();\r\ncodes010[0]= \"|\"; \r\ncodes010[1]= \"007\"+\"|\"+\"007 BAKER\";\r\ncodes010[2]= \"037\"+\"|\"+\"037 CALHOUN\";\r\ncodes010[3]= \"071\"+\"|\"+\"071 COLQUITT\";\r\ncodes010[4]= \"087\"+\"|\"+\"087 DECATUR\";\r\ncodes010[5]= \"095\"+\"|\"+\"095 DOUGHERTY\";\r\ncodes010[6]= \"099\"+\"|\"+\"099 EARLY\";\r\ncodes010[7]= \"131\"+\"|\"+\"131 GRADY\";\r\ncodes010[8]= \"177\"+\"|\"+\"177 LEE\";\r\ncodes010[9]= \"201\"+\"|\"+\"201 MILLER\";\r\ncodes010[10]= \"205\"+\"|\"+\"205 MITCHELL\";\r\ncodes010[11]= \"253\"+\"|\"+\"253 SEMINOLE\";\r\ncodes010[12]= \"273\"+\"|\"+\"273 TERRELL\";\r\ncodes010[13]= \"275\"+\"|\"+\"275 THOMAS\";\r\ncodes010[14]= \"321\"+\"|\"+\"321 WORTH\";\r\n\r\nvar codes011 = new Array();\r\ncodes011[0]= \"|\"; \r\ncodes011[1]= \"003\"+\"|\"+\"003 ATKINSON\";\r\ncodes011[2]= \"005\"+\"|\"+\"005 BACON\";\r\ncodes011[3]= \"017\"+\"|\"+\"017 BEN HILL\";\r\ncodes011[4]= \"019\"+\"|\"+\"019 BERRIEN\";\r\ncodes011[5]= \"025\"+\"|\"+\"025 BRANTLEY\";\r\ncodes011[6]= \"027\"+\"|\"+\"027 BROOKS\";\r\ncodes011[7]= \"049\"+\"|\"+\"049 CHARLTON\";\r\ncodes011[8]= \"065\"+\"|\"+\"065 CLINCH\";\r\n");
      out.write("codes011[9]= \"069\"+\"|\"+\"069 COFFEE\";\r\ncodes011[10]= \"075\"+\"|\"+\"075 COOK\";\r\ncodes011[11]= \"101\"+\"|\"+\"101 ECHOLS\";\r\ncodes011[12]= \"155\"+\"|\"+\"155 IRWIN\";\r\ncodes011[13]= \"173\"+\"|\"+\"173 LANIER\";\r\ncodes011[14]= \"185\"+\"|\"+\"185 LOWNDES\";\r\ncodes011[15]= \"229\"+\"|\"+\"229 PIERCE\";\r\ncodes011[16]= \"277\"+\"|\"+\"277 TIFT\";\r\ncodes011[17]= \"287\"+\"|\"+\"287 TURNER\";\r\ncodes011[18]= \"299\"+\"|\"+\"299 WARE\";\r\n\r\nvar codes012 = new Array();\r\ncodes012[0]= \"|\"; \r\ncodes012[1]= \"029\"+\"|\"+\"029 BRYAN\";\r\ncodes012[2]= \"031\"+\"|\"+\"031 BULLOCH\";\r\ncodes012[3]= \"039\"+\"|\"+\"039 CAMDEN\";\r\ncodes012[4]= \"051\"+\"|\"+\"051 CHATHAM\";\r\ncodes012[5]= \"103\"+\"|\"+\"103 EFFINGHAM\";\r\ncodes012[6]= \"127\"+\"|\"+\"127 GLYNN\";\r\ncodes012[7]= \"179\"+\"|\"+\"179 LIBERTY\";\r\ncodes012[8]= \"183\"+\"|\"+\"183 LONG\";\r\ncodes012[9]= \"191\"+\"|\"+\"191 MCINTOSH\";\r\n\r\nvar codes013 = new Array();\r\ncodes013[0]= \"|\"; \r\ncodes013[1]= \"063\"+\"|\"+\"063 CLAYTON\";\r\ncodes013[2]= \"151\"+\"|\"+\"151 HENRY\";\r\ncodes013[3]= \"247\"+\"|\"+\"247 ROCKDALE\";\r\n\r\nvar codes014 = new Array();\r\ncodes014[0]= \"|\"; \r\ncodes014[1]= \"089\"+\"|\"+\"089 DEKALB\";\r\n");
      out.write("codes014[2]= \"121\"+\"|\"+\"121 FULTON\";\r\n\r\nvar codes015 = new Array();\r\ncodes015[0]= \"|\"; \r\ncodes015[1]= \"067\"+\"|\"+\"067 COBB\";\r\ncodes015[2]= \"135\"+\"|\"+\"135 GWINNETT\";\r\n\r\nvar codes097 = new Array();\r\ncodes097[0]= \"|\"; \r\ncodes097[1]= \"999\"+\"|\"+\"999 OUT OF STATE\";\r\n\r\nvar codes099 = new Array();\r\ncodes099[0]= \"|\"; \r\ncodes099[1]= \"XXX\"+\"|\"+\"XXX -None-\";\r\n\r\n");
      if (_jspx_meth_impact_codeArray_0(_jspx_page_context))
        return;
      out.write("\r\n\r\nfunction updateCountyCodes()\r\n{\r\n\tvar category = frmCaseSummary.selSzCdOfficeRegion.value;\r\n\tvar county = frmCaseSummary.selSzCdCounty.value;\r\n\tvar options = frmCaseSummary.selSzCdCounty.options;\r\n\r\n\tif(category==\"\"||category){\r\n\t  populateDropdown( frmCaseSummary.selSzCdCounty , \"\", countyCodes );\r\n\t}else{\r\n\t  var codeArray = eval(\"codes\" + category);\r\n\t  if(options){\r\n\t\r\n\t  }else{\r\n\t     populateDropdown( frmCaseSummary.selSzCdCounty , \"\", codeArray );\r\n\t  }\r\n\t}\r\n\tdocument.frmCaseSummary.selSzCdCounty.value=county;\r\n}\r\n// end STGAP00002833\r\n\r\n</script>\r\n\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmCaseSummary");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/workload/CaseSummary/displayCaseSummary");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.workload.CaseSummaryCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_1(_jspx_th_impact_validateForm_0, _jspx_page_context))
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
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_7(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_8(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_9(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_10(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_11(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_12(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_13(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_14(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_15(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_16(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_17(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_18(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_19(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_20(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_21(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("hdnSelectedStageCode");
          _jspx_th_impact_validateInput_22.setValue(selectedStageCode);
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("hidden");
          _jspx_th_impact_validateInput_23.setName("hdnSelectedStageId");
          _jspx_th_impact_validateInput_23.setValue(FormattingHelper.formatInt(selectedStageId) );
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("hidden");
          _jspx_th_impact_validateInput_24.setName("hdnSelectedStageDateClosed");
          _jspx_th_impact_validateInput_24.setValue(FormattingHelper.formatDate(selectedStageDateClosed));
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
 // SIR 22406 - If no Records Retention Section set indicator
  if (bIndHasRecordsRet) { 
          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_25(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');

} else {

          out.write('\r');
          out.write('\n');
          if (_jspx_meth_impact_validateInput_26(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td align=\"right\">\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"expandAll()\">Expand All</a>&nbsp;\r\n      <a tabIndex=\"");
          out.print( tabIndex++ );
          out.write("\" href=\"#\" onClick=\"collapseAll()\">Collapse All</a>&nbsp;\r\n    </td>\r\n  </tr>\r\n</table>\r\n\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableBorder\">\r\n  <tr>\r\n    <th colspan=\"6\">Case Information</th>\r\n  </tr>\r\n  <tr>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Case ID");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("hdnUlIdCase");
          _jspx_th_impact_validateDisplayOnlyField_0.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( String.valueOf( GlobalData.getUlIdCase( request ) ) );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"35%\">&nbsp;</td>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("County");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtSzCdCaseCounty");
          _jspx_th_impact_validateDisplayOnlyField_1.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( FormattingHelper.initCapsName( Lookup.simpleDecodeSafe( CodesTables.CCOUNT, caseSummary.getSzCdCaseCounty() )) );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td width=\"10%\">&nbsp;</td>\r\n  </tr>\r\n  <tr>\r\n    ");
 String caseStatus = (String) request.getAttribute("caseStatus");
          out.write("\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Status");
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtCaseStatus");
          _jspx_th_impact_validateDisplayOnlyField_2.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue( FormattingHelper.formatString( caseStatus ) );
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n    <td>\r\n      ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Start Date of Case");
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtDtDtCaseOpened");
          _jspx_th_impact_validateDisplayOnlyField_3.setColspan("1");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( FormattingHelper.formatDate ( caseSummary.getDtDtCaseOpened() ) );
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    <td>&nbsp;</td>\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n<br/>\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_0.setTest((!((caseErrors== null)||(caseErrors.isEmpty())) || !((customizedErrors== null)||(customizedErrors.isEmpty()))));
          int _jspx_eval_impact_ifThen_0 = _jspx_th_impact_ifThen_0.doStartTag();
          if (_jspx_eval_impact_ifThen_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t  <th class=\"thList\">Case Errors:&nbsp;<span style=\"color:red\">");
              out.print( caseErrorCount);
              out.write("</span></th>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t  <td width=\"100%\" class=\"formlabel\">\r\n\t\t    <div id=\"errors\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n\t\t      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t        \r\n\t\t");

		int errorLoopCount = 0;
		if (((caseErrors== null)||(caseErrors.isEmpty())) && ((customizedErrors== null)||(customizedErrors.isEmpty()))) {
		
              out.write("        \r\n\t\t        <tr class=\"odd\">\r\n\t\t            <td>\r\n\t\t              ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n\t\t            </td>\r\n\t\t        </tr>\r\n\t\t");
}
		        
		  if(caseErrors != null && !caseErrors.isEmpty()) {
		          Iterator<String> iterator = caseErrors.iterator();
		          while (iterator.hasNext()) {
		            String errorCode = iterator.next();
		            if(!CodesTables.CCASEERR_CUS.equals(errorCode)){
		
              out.write("\r\n\t\t\r\n\t               <tr class=\"");
              out.print( FormattingHelper.getRowCss( errorLoopCount + 1 ) );
              out.write("\">\r\n                      <td class = \"error\">\r\n                      \t<span style=\"color:red\">\r\n\t                      ");
              out.print( FormattingHelper.formatString(
	                      Lookup.simpleDecodeSafe( "CCASEERR", errorCode ) ));
              out.write("\r\n\t                    </span>\r\n                      </td>\r\n\t               </tr>\r\n\t\t");
			errorLoopCount++;
		            }
		          }
		        }
         //MR-072 Customized Errors
         if(customizedErrors != null && !customizedErrors.isEmpty()){
          Iterator<String> iterator = customizedErrors.iterator();
          while (iterator.hasNext()) {
            String customizedError = iterator.next();

              out.write("\r\n            <tr class=\"");
              out.print( FormattingHelper.getRowCss( errorLoopCount + 1 ) );
              out.write("\">\r\n                        <td class=\"error\">\r\n                         <span style=\"color:red\">\r\n                           ");
              out.print( FormattingHelper.formatString(customizedError));
              out.write("\r\n                        </span>\r\n                        </td>\r\n            </tr>\r\n");
      
          errorLoopCount++;
          }
        }

              out.write("\r\n\t\t        \r\n\t\t      </table>\r\n\t\t    </div>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:ifThen
          gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag _jspx_th_impact_ifThen_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.state.IfThenTag();
          _jspx_th_impact_ifThen_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ifThen_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ifThen_1.setTest(!((caseWarnings== null)||(caseWarnings.isEmpty())));
          int _jspx_eval_impact_ifThen_1 = _jspx_th_impact_ifThen_1.doStartTag();
          if (_jspx_eval_impact_ifThen_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t  <th class=\"thList\">Case Warnings:&nbsp;<span style=\"color:blue\">");
              out.print( caseWarningCount);
              out.write("</span></th>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t  <td width=\"100%\" class=\"formlabel\">\r\n\t\t    <div id=\"warnings\" style=\"width:100%; height:100px; overflow:auto\" class=\"tableBorder\">\r\n\t\t      <table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t        \r\n\t\t");

		int warningLoopCount = 0;
		if ((caseWarnings== null)||(caseWarnings.isEmpty())) {
		
              out.write("        \r\n\t\t        <tr class=\"odd\">\r\n\t\t            <td>\r\n\t\t              ");
              out.print( MessageLookup.getMessageByNumber( Messages.SSM_NO_ROWS_RETURNED ) );
              out.write("\r\n\t\t            </td>\r\n\t\t        </tr>\r\n\t\t");
}
		        
		        else {
		          Iterator<String> iterator = caseWarnings.iterator();
		          while (iterator.hasNext()) {
		            String warningCode = iterator.next();
		
              out.write("\r\n\t\t\r\n\t               <tr class=\"");
              out.print( FormattingHelper.getRowCss( warningLoopCount + 1 ) );
              out.write("\">\r\n                      <td class = \"warning\">\r\n                      \t<span style=\"color:blue\">\r\n\t                      ");
              out.print( FormattingHelper.formatString(
	                      Lookup.simpleDecodeSafe( "CCASEWAR", warningCode ) ));
              out.write("\r\n\t                    </span>\r\n                      </td>\r\n\t               </tr>\r\n\t\t");
			warningLoopCount++;
		          }
		        }
		
              out.write("\r\n\t\t        \r\n\t\t      </table>\r\n\t\t    </div>\r\n\t\t  </td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ifThen_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ifThen_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:pagination
          gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag _jspx_th_impact_pagination_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.pagination.ResultsPaginationTag();
          _jspx_th_impact_pagination_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_pagination_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_pagination_0.setSubmitUrl("/workload/CaseSummary/displayCaseSummary");
          _jspx_th_impact_pagination_0.setSaveState("false");
          int _jspx_eval_impact_pagination_0 = _jspx_th_impact_pagination_0.doStartTag();
          if (_jspx_eval_impact_pagination_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <div id=\"scrollBar\" style=\"height:173px;width:767px;overflow:auto\" class=\"tableborderList\">\r\n    <table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n      <tr>\r\n        <th class=\"thList\">&nbsp;</th>\r\n        <th class=\"thList\">Mrg</th>\r\n        <th class=\"thList\">Stage Name</th>\r\n        <th class=\"thList\">Stage</th>\r\n        <th class=\"thList\">Case Flag</th>\r\n        <th class=\"thList\">Level</th>\r\n        <th class=\"thList\">Opened</th>\r\n        <th class=\"thList\">Closed</th>\r\n        <th class=\"thList\">Case Manager</th>\r\n        <th class=\"thList\">County</th>\r\n        <th class=\"thList\">Stage ID</th>\r\n      </tr>\r\n      ");

        // Get the stage id for the selected stage.
        selectedStageId = GlobalData.getUlIdStage(request);
        if (request.getParameter("radioIndex_CLEAN") != null) {
          selectedStageId = ContextHelper.getIntSafe(request, "hdnUlIdStage");
        }

        Enumeration caseSummaryEnumeration2 = caseSummaryArray.enumerateROWCCMN37SOG02();
        if (!caseSummaryEnumeration2.hasMoreElements()) {
              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"11\">\r\n          ");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

      } else {
        while (caseSummaryEnumeration2.hasMoreElements()) {
          ROWCCMN37SOG02 caseSummaryRow = (ROWCCMN37SOG02) caseSummaryEnumeration2.nextElement();
      
              out.write("\r\n      <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount + 1 ));
              out.write("\" valign=\"top\">\r\n        ");

          String radioId = "rbStageIndex1_" + loopCount;
          String stageRedFlagCbxName = "cbStageRedFlag_" + loopCount;
          String onClick = "javascript:selectStage(" + loopCount + ")";

          // Determine whether or not the current stage is the selected stage. If it is the selected stage,
          //   get the stage id, stage code and closure date.
          int currentRowStageId = caseSummaryRow.getUlIdStage();
          if (selectedStageId == currentRowStageId) {
            selectedIndex = loopCount;
            selectedStageId = caseSummaryRow.getUlIdStage();
            selectedStageCode = caseSummaryRow.getSzCdStage();
            selectedStageDateClosed = caseSummaryRow.getDtDtStageClose();
          }
        
              out.write("\r\n        <td>\r\n          ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_27.setType("radio");
              _jspx_th_impact_validateInput_27.setId( radioId );
              _jspx_th_impact_validateInput_27.setOnClick( onClick );
              _jspx_th_impact_validateInput_27.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_27.setName("radioIndex_CLEAN");
              _jspx_th_impact_validateInput_27.setValue( String.valueOf( loopCount ) );
              _jspx_th_impact_validateInput_27.setChecked( String.valueOf( selectedStageId == currentRowStageId ) );
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td align=\"center\">\r\n          ");

            if ("Y".equalsIgnoreCase(caseSummaryRow.getCScrIndStageMerged())) {
              out.write("\r\n          <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n          ");

          } else {
              out.write("\r\n          &nbsp;\r\n          ");

            }
          
              out.write("\r\n        </td>\r\n        <td>\r\n          <NOBR>");
              out.print( caseSummaryRow.getSzNmStage() );
              out.write("\r\n          </NOBR>\r\n        </td>\r\n        <td>");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, caseSummaryRow.getSzCdStage()) );
              out.write("\r\n        </td>\r\n        <td>");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_pagination_0);
              _jspx_th_impact_validateInput_28.setType("checkbox");
              _jspx_th_impact_validateInput_28.setChecked( String.valueOf("Y".equalsIgnoreCase(caseSummaryRow.getBIndRedFlag())));
              _jspx_th_impact_validateInput_28.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_28.setName( stageRedFlagCbxName );
              _jspx_th_impact_validateInput_28.setValue( String.valueOf( loopCount ) );
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n        </td>\r\n        <td>");
              out.print( caseSummaryRow.getSzCdStageLevel() != null ? caseSummaryRow.getSzCdStageLevel() : " " );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( FormattingHelper.formatDate(caseSummaryRow.getDtDtStageStart()));
              out.write("\r\n        </td>\r\n        <td>");
              out.print( FormattingHelper.formatDate(caseSummaryRow.getDtDtStageClose()));
              out.write("\r\n        </td>\r\n        <td>\r\n          <NOBR>");
              out.print( caseSummaryRow.getSzNmPersonFull() );
              out.write("\r\n          </NOBR>\r\n        </td>\r\n        <td>");
              out.print( FormattingHelper.initCapsName(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                      caseSummaryRow.getSzCdStageCounty())));
              out.write("\r\n        </td>\r\n        <td>");
              out.print( caseSummaryRow.getUlIdStage() );
              out.write("\r\n        </td>\r\n      </tr>\r\n      <div style=\"display:none\">");
              out.print( "SituationID:" + caseSummaryRow.getUlIdSituation() );
              out.write("\r\n      </div>\r\n      ");

            loopCount++;
          }
        }
      
              out.write("\r\n    </table>\r\n  </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_pagination_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_pagination_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n  ");

    ROWCCMN37SOG02[] rowccmn37sog02array = caseSummaryArray.getROWCCMN37SOG02();
  
          out.write("\r\n  var stageArray = new Array(");
          out.print( rowccmn37sog02array.length );
          out.write(");\r\n  ");

    for (int i = 0; i < rowccmn37sog02array.length; i++) {
  
          out.write("\r\n  stageArray[");
          out.print( i );
          out.write("] = new Object();\r\n  stageArray[");
          out.print( i );
          out.write("].cScrIndStageMerged = \"");
          out.print( rowccmn37sog02array[i].getCScrIndStageMerged() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].szNmStage =\r\n  \"");
          out.print( FormattingHelper.formatStringSpecialChars(rowccmn37sog02array[i].getSzNmStage(), "\\\"") );
          out.write("\"\r\n  stageArray[");
          out.print( i );
          out.write("].szCdStage = \"");
          out.print( rowccmn37sog02array[i].getSzCdStage() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].bIndEcsVer = \"");
          out.print( rowccmn37sog02array[i].getBIndEcsVer() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].szCdStageLevel = \"");
          out.print( rowccmn37sog02array[i].getSzCdStageLevel() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].dtDtStageStart = \"");
          out.print( rowccmn37sog02array[i].getDtDtStageStart() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].dtDtStageClose = \"");
          out.print( rowccmn37sog02array[i].getDtDtStageClose() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].szNmPersonFull =\r\n  \"");
          out.print( FormattingHelper.formatStringSpecialChars(rowccmn37sog02array[i].getSzNmPersonFull(), "\\\"") );
          out.write("\"\r\n  stageArray[");
          out.print( i );
          out.write("].szCdStageCounty = \"");
          out.print( rowccmn37sog02array[i].getSzCdStageCounty() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].ulIdStage = \"");
          out.print( rowccmn37sog02array[i].getUlIdStage() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].ulIdCase = \"");
          out.print( rowccmn37sog02array[i].getUlIdCase() );
          out.write("\";\r\n  stageArray[");
          out.print( i );
          out.write("].bIndRedFlag = \"");
          out.print( rowccmn37sog02array[i].getBIndRedFlag() );
          out.write("\";\r\n  ");

  }
  
          out.write("\r\n</script>\r\n\r\n");

  boolean bDisableReopenStage = true;

  // STGAP00014341: If the user has the 'Stage Reopen' attibute, they are allowed to reopen any stages.
  //   Enable the Reopen Stage button.
  if (user.hasRight(UserProfile.SEC_STAGE_REOPEN)) {
    bDisableReopenStage = false;
  }

          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignLeft\">\r\n      ");

        // The user must have the SEC_ADMIN_REVIEW security attribute, the stage must be a closed INV, closed ARI/ARF,
        //   or open/closed FAD. This button's function handles submission internally and always returns false,
        //   so action="" is valid here. If the function ever returned true, the architecture would throw an exception
        //   because the form action would be "".
        if (user.hasRight(UserProfile.SEC_ADMIN_REVIEW) &&
            !user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
          String functionString = "return adminReview( " + loopCount + ");";
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setImg("btnAdminReviewAppeal");
          _jspx_th_impact_ButtonTag_0.setName("btnAdminReviewAppeal");
          _jspx_th_impact_ButtonTag_0.setForm("frmCaseSummary");
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setAction("/workload/CaseSummary/callAdminCommand");
          _jspx_th_impact_ButtonTag_0.setFunction(functionString);
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");

        }
        // Display the Reopen Stage button, if appropriate.
        if (!bDisableReopenStage) {
        String functionString = "return isRadioChecked( " + loopCount + ");";
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setImg("btnReopenStage");
          _jspx_th_impact_ButtonTag_1.setName("btnReopenStage");
          _jspx_th_impact_ButtonTag_1.setForm("frmCaseSummary");
          _jspx_th_impact_ButtonTag_1.setAction("/workload/CaseSummary/reopenStage");
          _jspx_th_impact_ButtonTag_1.setFunction(functionString);
          _jspx_th_impact_ButtonTag_1.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");

        }
      
          out.write("\r\n    </td>\r\n    <td class=\"alignRight\">\r\n      ");

        if (hasCaseAccess || !user.hasRight(UserProfile.SEC_RESTRICT_CASE_EVENT)) {
          String functionString = "return selectNewStage( " + loopCount + ");";
          out.write("\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectStage");
          _jspx_th_impact_ButtonTag_2.setName("btnSelectStage");
          _jspx_th_impact_ButtonTag_2.setForm("frmCaseSummary");
          _jspx_th_impact_ButtonTag_2.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_2.setAction("/workload/CaseSummary/selectStage");
          _jspx_th_impact_ButtonTag_2.setFunction(functionString);
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n      ");

      } else {
      
          out.write("\r\n      &nbsp;\r\n      ");

        }
      
          out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n<br/>\r\n\r\n\r\n");
          out.write('\r');
          out.write('\n');

  String specHandling = request.getParameter("selSzCdCaseSpeclHndlg");
  String workerCbx = request.getParameter("cbxBIndCaseWorkerSafety");
  String workerComments = request.getParameter("txtSzTxtCaseWorkerSafety");
  String safetyCbx = request.getParameter("cbxBIndCaseSensitive");
  String safetyComments = request.getParameter("txtSzTxtCaseSensitiveCmnts");
  if (specHandling == null) {
    specHandling = specialHandling.getSzCdCaseSpeclHndlg();
  }
  if (workerCbx == null || "".equals(workerCbx)) {
    workerCbx = specialHandling.getBIndCaseWorkerSafety();
  }
  if (workerComments == null) {
    workerComments = specialHandling.getSzTxtCaseWorkerSafety();
  }
  if (safetyCbx == null || "".equals(safetyCbx)) {
    safetyCbx = specialHandling.getBIndCaseSensitive();
  }
  if (safetyComments == null) {
    safetyComments = specialHandling.getSzTxtCaseSensitiveCmnts();
  }

          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Special Handling");
          _jspx_th_impact_ExpandableSectionTag_0.setName("SpecialHandling");
          _jspx_th_impact_ExpandableSectionTag_0.setId("Special_Handling");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <table border=\"0\" width=\"100%\" cellSpacing=\"0\" cellPadding=\"3\" class=\"tableBorder\">\r\n    <tr class=\"subDetail\">\r\n      <td width=\"22%\">\r\n        ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_0.setLabel("Special Handling");
              _jspx_th_impact_validateSelect_0.setId("Special_Handling");
              _jspx_th_impact_validateSelect_0.setColspan("4");
              _jspx_th_impact_validateSelect_0.setName("selSzCdCaseSpeclHndlg");
              _jspx_th_impact_validateSelect_0.setValue( specHandling );
              _jspx_th_impact_validateSelect_0.setDisabled( String.valueOf( pageSetEDisabled ) );
              _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_0.setCodesTable("CSPECHND");
              int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
              if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_29.setLabel("Worker Safety Issues");
              _jspx_th_impact_validateInput_29.setName("cbxBIndCaseWorkerSafety");
              _jspx_th_impact_validateInput_29.setType("checkbox");
              _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_29.setWidth("15%");
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setValue("on");
              _jspx_th_impact_validateInput_29.setChecked( String.valueOf( workerCbx ) );
              _jspx_th_impact_validateInput_29.setDisabled( String.valueOf( pageSetEDisabled ));
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_0.setLabel("Comments");
              _jspx_th_impact_validateTextArea_0.setName("txtSzTxtCaseWorkerSafety");
              _jspx_th_impact_validateTextArea_0.setColspan("3");
              _jspx_th_impact_validateTextArea_0.setRows("3");
              _jspx_th_impact_validateTextArea_0.setCols("70");
              _jspx_th_impact_validateTextArea_0.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_0.setMaxLength(300);
              _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
              _jspx_th_impact_validateTextArea_0.setDisabled( String.valueOf( pageSetEDisabled ));
              _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_0.setOnChange("changeSpecHandlingComment(frmCaseSummary.txtSzTxtCaseWorkerSafety, frmCaseSummary.cbxBIndCaseWorkerSafety);");
              int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
              if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_0.doInitBody();
                }
                do {
                  out.write("\r\n          ");
                  out.print( FormattingHelper.formatString(workerComments) );
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_30.setLabel("Sensitive Case");
              _jspx_th_impact_validateInput_30.setName("cbxBIndCaseSensitive");
              _jspx_th_impact_validateInput_30.setType("checkbox");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setValue("on");
              _jspx_th_impact_validateInput_30.setChecked( String.valueOf( safetyCbx ) );
              _jspx_th_impact_validateInput_30.setDisabled( String.valueOf( pageSetEDisabled ));
              _jspx_th_impact_validateInput_30.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>\r\n        ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateTextArea_1.setLabel("Comments");
              _jspx_th_impact_validateTextArea_1.setName("txtSzTxtCaseSensitiveCmnts");
              _jspx_th_impact_validateTextArea_1.setColspan("3");
              _jspx_th_impact_validateTextArea_1.setRows("3");
              _jspx_th_impact_validateTextArea_1.setCols("70");
              _jspx_th_impact_validateTextArea_1.setMaxLength(300);
              _jspx_th_impact_validateTextArea_1.setConstraint("Comments");
              _jspx_th_impact_validateTextArea_1.setConditionallyRequired("true");
              _jspx_th_impact_validateTextArea_1.setDisabled( String.valueOf( pageSetEDisabled ));
              _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_1.setOnChange("changeSpecHandlingComment(frmCaseSummary.txtSzTxtCaseSensitiveCmnts, frmCaseSummary.cbxBIndCaseSensitive);");
              int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
              if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_1.doInitBody();
                }
                do {
                  out.write("\r\n          ");
                  out.print( FormattingHelper.formatString(safetyComments) );
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n\r\n");
          out.write('\r');
          out.write('\n');
          out.write('\r');
          out.write('\n');
 if (!"C-GUA".equals(globalSzStageType) && !"C-REG".equals(globalSzStageType)) { 
          out.write("\r\n<br>\r\n");
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Case Merge/Split");
          _jspx_th_impact_ExpandableSectionTag_1.setName("CaseMergeSplit");
          _jspx_th_impact_ExpandableSectionTag_1.setId("Case_Merge_Split");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<div id=\"scrollBar\" style=\"height:155px;width:767px;overflow:auto\" class=\"tableborderList\">\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n    <tr>\r\n      <th class=\"thList\">PEND</th>\r\n      <th class=\"thList\">Case To</th>\r\n      <th class=\"thList\">ID To</th>\r\n      <th class=\"thList\">To Status</th>\r\n      <th class=\"thList\">Case From</th>\r\n      <th class=\"thList\">ID From</th>\r\n      <th class=\"thList\">From Status</th>\r\n      <th class=\"thList\">Requester</th>\r\n      <th class=\"thList\">Date Merge</th>\r\n      <th class=\"thList\">Staff Split</th>\r\n      <th class=\"thList\">Date Split</th>\r\n    </tr>\r\n    ");

      //Declare the loop counter
      int loopCount2 = 0;
      //Declare the enumeration
      Enumeration caseMergeSplitEnumeration = caseMergeSplitArray.enumerateROWCCFC39SOG00();

      //Check to make sure the rowccmn37sog02array is not empty and display a message if it is.
      if (!caseMergeSplitEnumeration.hasMoreElements()) {
    
              out.write("\r\n    <tr class=\"odd\">\r\n      <td colspan=\"11\">");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n      </td>\r\n    </tr>\r\n    ");

    } else {
      while (caseMergeSplitEnumeration.hasMoreElements()) {
        ROWCCFC39SOG00 caseMergeSplitRow = (ROWCCFC39SOG00) caseMergeSplitEnumeration.nextElement(); 
              out.write("\r\n    <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount2 + 1 ));
              out.write("\" valign=\"top\">\r\n      <td align=\"center\">\r\n        ");

          String pendStatus;
          if ("S".equalsIgnoreCase(caseMergeSplitRow.getCIndCaseMergePending()) ||
              "M".equalsIgnoreCase(caseMergeSplitRow.getCIndCaseMergePending())) {
            pendStatus = "Y";
        
              out.write("\r\n        <img alt=\"checkmark\" src=\"/grnds-docs/images/shared/checkMark.gif\">\r\n        ");

          } else {
            pendStatus = "N";
          }
        
              out.write("\r\n      </td>\r\n      ");

        String caseMergeSplitHyperlink =
                "javascript: caseMergeSplitHyperlink( '" + loopCount2 + "', '" + pendStatus + "', '" + caseMergeSplitRow.getSzScrMergeWorker() + "', '" + caseMergeSplitRow.getSzScrNmSplitWorker() + "', '" + caseMergeSplitRow.getUlIdCaseMerge() + "')";
      
              out.write("\r\n      <td>\r\n        <NOBR>");

          if (!pageSetFDisabled) {
            /* SIR# 23125: if the case merge indicator is set to Y, then split should
         not happen  */
            if ("Y".equalsIgnoreCase(caseMergeSplitRow.getCIndCaseMergeInv()) &&
                "N".equalsIgnoreCase(pendStatus)) {
        
              out.write("\r\n          ");
              out.print( caseMergeSplitRow.getSzScrNmCaseMrgTo() );
              out.write("\r\n          ");

          } else {
          
              out.write("\r\n          <a href=\"");
              out.print(caseMergeSplitHyperlink);
              out.write("\" id=\"Case_Merge_Split\"\r\n             tabIndex=\"");
              out.print( tabIndex++ );
              out.write('"');
              out.write('>');
              out.print( caseMergeSplitRow.getSzScrNmCaseMrgTo() );
              out.write("\r\n          </a>\r\n          ");

            }
          
              out.write("\r\n          ");

          } else {
          
              out.write("\r\n          ");
              out.print( caseMergeSplitRow.getSzScrNmCaseMrgTo() );
              out.write("\r\n          ");

            }
          
              out.write("</NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( caseMergeSplitRow.getUlIdCaseMergeTo() );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( FormattingHelper.formatString(caseMergeSplitRow.getSzCaseMrgToStatus()) );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( caseMergeSplitRow.getSzScrNmCaseMrgFrom() );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( caseMergeSplitRow.getUlIdCaseMergeFrom() );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( FormattingHelper.formatString(caseMergeSplitRow.getSzCaseMrgFromStatus()) );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( caseMergeSplitRow.getSzScrMergeWorker() );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( FormattingHelper.formatDate(caseMergeSplitRow.getDtDtCaseMerge()));
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( caseMergeSplitRow.getSzScrNmSplitWorker() );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n      <td>\r\n        <NOBR>");
              out.print( FormattingHelper.formatDate(caseMergeSplitRow.getDtCaseMergeSplit()) );
              out.write("\r\n        </NOBR>\r\n      </td>\r\n    </tr>\r\n    ");

          loopCount2++;
        }
      }
              out.write("\r\n  </table>\r\n</div>\r\n");

  if (user.hasRight(UserProfile.SEC_MERGE_CASES) && GlobalData.hasStageAccess(request)) {

              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    <td class=\"alignRight\">\r\n      ");
              //  impact:ButtonTag
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
              _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_ButtonTag_3.setImg("btnAdd");
              _jspx_th_impact_ButtonTag_3.setName("btnAdd");
              _jspx_th_impact_ButtonTag_3.setForm("frmCaseSummary");
              _jspx_th_impact_ButtonTag_3.setAction("/workload/CaseSummary/addCaseMergeDetail");
              _jspx_th_impact_ButtonTag_3.setNavAwayCk(true);
              _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
              _jspx_th_impact_ButtonTag_3.setDisabled( String.valueOf( pageSetFDisabled ) );
              int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
              if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    </td>\r\n  </tr>\r\n</table>\r\n");

  }

              out.write('\r');
              out.write('\n');
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');

  }

          out.write('\r');
          out.write('\n');
          out.write("\r\n<br/>\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_2.setLabel("Staff Assignment History");
          _jspx_th_impact_ExpandableSectionTag_2.setName("StaffAssignmentHistory");
          _jspx_th_impact_ExpandableSectionTag_2.setId("Staff_Assgnmt_History");
          _jspx_th_impact_ExpandableSectionTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_2 = _jspx_th_impact_ExpandableSectionTag_2.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  <div id=\"scrollBar\" style=\"height:155px;width:767px;overflow:auto\" class=\"tableborderList\">\r\n    <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n      <tr>\r\n        <th class=\"thList\">From</th>\r\n        <th class=\"thList\">To</th>\r\n        <th class=\"thList\">Date&nbsp;</th>\r\n        <th class=\"thList\">From County</th>\r\n        <th class=\"thList\">To County</th>\r\n        <th class=\"thList\">Entered By</th>\r\n        <th class=\"thList\">Stage</th>\r\n        <th class=\"thList\">Stage ID</th>\r\n      </tr>\r\n      ");

        //Declare loop counter and row object
        int loopCount3 = 0;

        //get Staff Assignment History rowccmn37sog02array
        STFFASSGNMTHIST_ARRAY stffAssgnmtHistArray = ccmn37so.getSTFFASSGNMTHIST_ARRAY();
        if (stffAssgnmtHistArray == null || stffAssgnmtHistArray.getSTFFASSGNMTHISTCount() == 0) {
      
              out.write("\r\n      <tr class=\"odd\">\r\n        <td colspan=\"8\">");
              out.print( MessageLookup.getMessageByName("SSM_NO_ROWS_RETURNED") );
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");

      } else {
        Enumeration stffAssgnmtHistEnumeration = stffAssgnmtHistArray.enumerateSTFFASSGNMTHIST();
        while (stffAssgnmtHistEnumeration.hasMoreElements()) {
          STFFASSGNMTHIST stffAssgnmtHistRow = (STFFASSGNMTHIST) stffAssgnmtHistEnumeration.nextElement();
      
              out.write("\r\n      <tr class=\"");
              out.print(FormattingHelper.getRowCss( loopCount3 += 1 ));
              out.write("\" valign=\"top\">\r\n        <td>");
              out.print( stffAssgnmtHistRow.getSzNmFromPerson() );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( stffAssgnmtHistRow.getSzNmToPerson() );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( stffAssgnmtHistRow.getDtDtLastUpdate() );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( FormattingHelper.initCapsName(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                      stffAssgnmtHistRow.getSzCdFromCounty())));
              out.write("\r\n        </td>\r\n        <td>");
              out.print( FormattingHelper.initCapsName(Lookup.simpleDecodeSafe(CodesTables.CCOUNT,
                                                                      stffAssgnmtHistRow.getSzCdToCounty())));
              out.write("\r\n        </td>\r\n        <td>");
              out.print( stffAssgnmtHistRow.getSzNmEnteredByPerson() );
              out.write("\r\n        </td>\r\n        <td>");
              out.print( stffAssgnmtHistRow.getUlIdStage() );
              out.write("\r\n        </td>\r\n        <td>&nbsp;");
              out.print( Lookup.simpleDecodeSafe(CodesTables.CTXTOGA, stffAssgnmtHistRow.getSzCdStage()) );
              out.write("\r\n        </td>\r\n      </tr>\r\n      ");


          }

        }
      
              out.write("\r\n    </table>\r\n  </div>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n<br/>\r\n");
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_3.setLabel("Case File Management");
          _jspx_th_impact_ExpandableSectionTag_3.setName("CaseFileManagment");
          _jspx_th_impact_ExpandableSectionTag_3.setId("Case_File_Mgmnt");
          _jspx_th_impact_ExpandableSectionTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_3 = _jspx_th_impact_ExpandableSectionTag_3.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n<tr>\r\n  <th colspan=\"16\">Case Information</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td colspan=\"2\">\r\n    ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Case&nbsp;Closure&nbsp;Date");
              _jspx_th_impact_validateDisplayOnlyField_4.setName("txtDtDtCaseClosed");
              _jspx_th_impact_validateDisplayOnlyField_4.setColspan("14");
              _jspx_th_impact_validateDisplayOnlyField_4.setValue( FormattingHelper.formatDate( ccfc21so.getDtDtCaseClosed() ) );
              int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <th colspan=\"16\">Storage Location</th>\r\n</tr>\r\n");

  String rbPrs = (ccfc21so.getSzCdCaseFileOfficeType());
  Boolean isPrs = rbPrs == null ? null : "P".equals(rbPrs);

              out.write("\r\n<tr class=\"subDetail\">\r\n  <td colspan=\"16\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_31.setLabel("DFCS");
              _jspx_th_impact_validateInput_31.setName("rbPrs");
              _jspx_th_impact_validateInput_31.setValue("P");
              _jspx_th_impact_validateInput_31.setType("radio");
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_31.setChecked(String.valueOf(isPrs!=null && isPrs));
              _jspx_th_impact_validateInput_31.setDisabled( String.valueOf( pageSetGDisabled ) );
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n    &nbsp;&nbsp;&nbsp;\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_32.setLabel("Non-DFCS");
              _jspx_th_impact_validateInput_32.setId("Case_File_Mgmnt");
              _jspx_th_impact_validateInput_32.setName("rbPrs");
              _jspx_th_impact_validateInput_32.setValue("N");
              _jspx_th_impact_validateInput_32.setType("radio");
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setChecked(String.valueOf(isPrs != null && !isPrs));
              _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_32.setDisabled( String.valueOf( pageSetGDisabled ) );
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <th colspan=\"16\">DFCS Office Location</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Program");
              _jspx_th_impact_validateDisplayOnlyField_5.setName("txtSzCdCaseProgram");
              _jspx_th_impact_validateDisplayOnlyField_5.setValue( FormattingHelper.formatString( ccfc21so.getSzCdCaseProgram() ));
              int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n  <td>\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_1.setLabel("Reg/Div");
              _jspx_th_impact_validateSelect_1.setName("selSzCdOfficeRegion");
              _jspx_th_impact_validateSelect_1.setValue( cdRegion );
              _jspx_th_impact_validateSelect_1.setCodesTable("CREGDIV");
              _jspx_th_impact_validateSelect_1.setContentType(SelectTag.CODES_DECODES);
              _jspx_th_impact_validateSelect_1.setConditionallyRequired("true");
              _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_1.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateSelect_1.setOnChange("changeCaseMgmtField(true, frmCaseSummary.selSzCdOfficeRegion); updateCountyCodes();");
              _jspx_th_impact_validateSelect_1.setColspan("13");
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_33.setLabel("Unit");
              _jspx_th_impact_validateInput_33.setName("txtSzNbrUnit");
              _jspx_th_impact_validateInput_33.setValue( FormattingHelper.formatString( ccfc21so.getSzNbrUnit() ) );
              _jspx_th_impact_validateInput_33.setType("text");
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setSize("3");
              _jspx_th_impact_validateInput_33.setMaxLength("2");
              _jspx_th_impact_validateInput_33.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_33.setConstraint("AlphaNumeric");
              _jspx_th_impact_validateInput_33.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_33.setDisabled( String.valueOf( pageSetGDisabled ) );
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n  <td>\r\n    ");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateSelect_2.setLabel("County");
              _jspx_th_impact_validateSelect_2.setName("selSzCdCounty");
              _jspx_th_impact_validateSelect_2.setBlankValue("true");
              _jspx_th_impact_validateSelect_2.setValue(FormattingHelper.formatString( cdCounty ) );
              _jspx_th_impact_validateSelect_2.setCodesTable("CCOUNT");
              _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateSelect_2.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateSelect_2.setColspan("13");
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <th colspan=\"16\">Location</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_34.setLabel("Name");
              _jspx_th_impact_validateInput_34.setName("txtSzNmCaseFileOffice");
              _jspx_th_impact_validateInput_34.setValue( FormattingHelper.formatString( ccfc21so.getSzNmCaseFileOffice() ) );
              _jspx_th_impact_validateInput_34.setType("text");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setSize("21");
              _jspx_th_impact_validateInput_34.setMaxLength("20");
              _jspx_th_impact_validateInput_34.setConstraint("Name");
              _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_34.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateInput_34.setOnChange("changeCaseMgmtField(false, frmCaseSummary.txtSzNmCaseFileOffice);");
              _jspx_th_impact_validateInput_34.setColspan("15");
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_35.setLabel("Street");
              _jspx_th_impact_validateInput_35.setName("txtSzAddrCaseFileStLn1");
              _jspx_th_impact_validateInput_35.setValue( FormattingHelper.formatString( ccfc21so.getSzAddrCaseFileStLn1() ) );
              _jspx_th_impact_validateInput_35.setType("text");
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              _jspx_th_impact_validateInput_35.setSize("31");
              _jspx_th_impact_validateInput_35.setMaxLength("30");
              _jspx_th_impact_validateInput_35.setConstraint("Address");
              _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_35.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateInput_35.setOnChange("changeCaseMgmtField(false, frmCaseSummary.txtSzAddrCaseFileStLn1);");
              _jspx_th_impact_validateInput_35.setColspan("15");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>&nbsp;</td>\r\n  <td colspan=\"15\">\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_36.setLabel("");
              _jspx_th_impact_validateInput_36.setName("txtSzAddrCaseFileStLn2");
              _jspx_th_impact_validateInput_36.setValue( FormattingHelper.formatString( ccfc21so.getSzAddrCaseFileStLn2() ) );
              _jspx_th_impact_validateInput_36.setType("text");
              _jspx_th_impact_validateInput_36.setCssClass("formInput");
              _jspx_th_impact_validateInput_36.setSize("31");
              _jspx_th_impact_validateInput_36.setMaxLength("30");
              _jspx_th_impact_validateInput_36.setConstraint("Address");
              _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_36.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateInput_36.setOnChange("changeCaseMgmtField(false, frmCaseSummary.txtSzAddrCaseFileStLn2);");
              int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
              if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateInput_37.setLabel("City");
              _jspx_th_impact_validateInput_37.setName("txtSzAddrCaseFileCity");
              _jspx_th_impact_validateInput_37.setValue( FormattingHelper.formatString( ccfc21so.getSzAddrCaseFileCity() ) );
              _jspx_th_impact_validateInput_37.setType("text");
              _jspx_th_impact_validateInput_37.setCssClass("formInput");
              _jspx_th_impact_validateInput_37.setSize("30");
              _jspx_th_impact_validateInput_37.setMaxLength("31");
              _jspx_th_impact_validateInput_37.setConstraint("City");
              _jspx_th_impact_validateInput_37.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateInput_37.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateInput_37.setOnChange("changeCaseMgmtField(false, frmCaseSummary.txtSzAddrCaseFileCity);");
              _jspx_th_impact_validateInput_37.setColspan("15");
              int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
              if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <th colspan=\"16\">Locating Information</th>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_2.setLabel("Current");
              _jspx_th_impact_validateTextArea_2.setName("txtSztxtCaseFileLocateInfo");
              _jspx_th_impact_validateTextArea_2.setRows("4");
              _jspx_th_impact_validateTextArea_2.setCols("55");
              _jspx_th_impact_validateTextArea_2.setMaxLength(300);
              _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph");
              _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateTextArea_2.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateTextArea_2.setColspan("7");
              int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
              if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_2.doInitBody();
                }
                do {
                  out.write("\r\n      ");
                  out.print( FormattingHelper.formatString(ccfc21so.getSztxtCaseFileLocateInfo()) );
                  out.write("\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n\r\n  <td align=\"right\">\r\n    ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateTextArea_3.setLabel("Prior");
              _jspx_th_impact_validateTextArea_3.setName("szTxtPriorCmnts");
              _jspx_th_impact_validateTextArea_3.setRows("4");
              _jspx_th_impact_validateTextArea_3.setCols("55");
              _jspx_th_impact_validateTextArea_3.setMaxLength(300);
              _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph");
              _jspx_th_impact_validateTextArea_3.setDisabled( String.valueOf( pageSetGDisabled ) );
              _jspx_th_impact_validateTextArea_3.setColspan("7");
              int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
              if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_3.doInitBody();
                }
                do {
                  out.write("\r\n      ");
                  out.print( FormattingHelper.formatString(ccfc21so.getSzTxtPriorCmnts()));
                  out.write("\r\n    ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n<tr class=\"subDetail\">\r\n  <th colspan=\"16\">Archive Dates</th>\r\n</tr>\r\n");
              out.write("\r\n<tr class=\"subDetail\">\r\n  <td>\r\n    ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_0.setLabel("Eligible");
              _jspx_th_impact_validateDate_0.setName("txtDtDtCaseFileArchElig");
              _jspx_th_impact_validateDate_0.setValue( FormattingHelper.formatDate( ccfc21so.getDtDtCaseFileArchElig() ) );
              _jspx_th_impact_validateDate_0.setSize("10");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_0.setDisabled( String.valueOf( pageSetGDisabled  ));
              _jspx_th_impact_validateDate_0.setColspan("7");
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n  <td>\r\n    ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_3);
              _jspx_th_impact_validateDate_1.setLabel("Complete");
              _jspx_th_impact_validateDate_1.setName("txtDtDtCaseFileArchCompl");
              _jspx_th_impact_validateDate_1.setValue( FormattingHelper.formatDate( ccfc21so.getDtDtCaseFileArchCompl() ) );
              _jspx_th_impact_validateDate_1.setSize("10");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_1.setDisabled( String.valueOf( pageSetGDisabled  ));
              _jspx_th_impact_validateDate_1.setColspan("7");
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n  </td>\r\n</tr>\r\n</table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n<br/>\r\n\r\n");
          out.write('\r');
          out.write('\n');

  if (!DateHelper.isNull(caseSummary.getDtDtCaseClosed()) && ccfc19so != null && ccfc19so.getSzCdRecRtnRetenType() != null) {
          out.write('\r');
          out.write('\n');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_4.setLabel("Records Retention");
          _jspx_th_impact_ExpandableSectionTag_4.setName("RecordsRetention");
          _jspx_th_impact_ExpandableSectionTag_4.setId("Records_Retention");
          _jspx_th_impact_ExpandableSectionTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ExpandableSectionTag_4 = _jspx_th_impact_ExpandableSectionTag_4.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n  ");

    //noinspection UnhandledExceptionInJSP
    String type = StringHelper.isValid(ccfc19so.getSzCdRecRtnRetenType()) ?
                  Lookup.simpleDecode(CodesTables.CRECRETN, ccfc19so.getSzCdRecRtnRetenType()) : "";

    // Block 1
    //If the destruction date is null, then it is actually set to 12/31/4712 which is the indefinate date
    //String formattedDate = FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual());

    //boolean disableRecords = ((ccfc19so.getDtDtRecRtnDstryActual() != null && "".equals(
    //        formattedDate)) || pageSetHDisabled);
    //if (ccfc19so.getDtDtRecRtnDstryActual() != null && "".equals(formattedDate)) {
    //  formattedDate = "12/31/4712";
    // End block 1
    
    // Only re-translate block 1 to cover all 3 possible null date values using DateHelper
    String formattedDate;
    boolean isNullDate = DateHelper.isNull(ccfc19so.getDtDtRecRtnDstryActual());
    boolean disableRecords = isNullDate || pageSetHDisabled;
    if (isNullDate) {
      formattedDate = "12/31/4712";
    } else {
      formattedDate = FormattingHelper.formatDate(ccfc19so.getDtDtRecRtnDstryActual());
    }
    
  
              out.write("\r\n  <table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" class=\"tableborder\">\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Class Type");
              _jspx_th_impact_validateDisplayOnlyField_6.setName("txtSzCdRecRtnRetenType");
              _jspx_th_impact_validateDisplayOnlyField_6.setValue( type );
              int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDate_2.setLabel("Destruction Date");
              _jspx_th_impact_validateDate_2.setName("txtDtDtRecRtnDstryActual");
              _jspx_th_impact_validateDate_2.setValue( formattedDate );
              _jspx_th_impact_validateDate_2.setSize("10");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setRequired("true");
              _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
              _jspx_th_impact_validateDate_2.setDisabled(String.valueOf( disableRecords ));
              _jspx_th_impact_validateDate_2.setOnChange("validateDestructionDate()");
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td><input name=\"cbxScrIndDestrctnDateChng\" type=\"checkbox\" class=\"formInput\"\r\n                 tabIndex=\"");
              out.print( tabIndex++ );
              out.write("\" disabled=\"true\"/>Destruction Date Override\r\n      </td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Case Closure Date");
              _jspx_th_impact_validateDisplayOnlyField_7.setName("txtDtDtCaseClosed");
              _jspx_th_impact_validateDisplayOnlyField_7.setValue( FormattingHelper.formatDate( ccfc19so.getDtDtCaseClosed() ) );
              int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n    <tr class=\"subDetail\">\r\n      <td>\r\n        ");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_4);
              _jspx_th_impact_validateTextArea_4.setLabel("Date Extention Reason");
              _jspx_th_impact_validateTextArea_4.setName("txtSzTxtRecRtnDstryDtRsn");
              _jspx_th_impact_validateTextArea_4.setRows("4");
              _jspx_th_impact_validateTextArea_4.setCols("40");
              _jspx_th_impact_validateTextArea_4.setMaxLength(300);
              _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph");
              _jspx_th_impact_validateTextArea_4.setConditionallyRequired("true");
              _jspx_th_impact_validateTextArea_4.setDisabled(String.valueOf( disableRecords ));
              _jspx_th_impact_validateTextArea_4.setTabIndex( tabIndex++ );
              int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
              if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_4.doInitBody();
                }
                do {
                  out.write("\r\n          ");
                  out.print( ccfc19so.getSzTxtRecRtnDstryDtRsn() );
                  out.write("\r\n        ");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n      </td>\r\n      <td>&nbsp;</td>\r\n    </tr>\r\n  </table>\r\n");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n<br/>\r\n");
 } 
          out.write('\r');
          out.write('\n');
          out.write("\r\n\r\n<hr>\r\n");
          out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n  <tr>\r\n    ");
 if (!(pageSetEDisabled && pageSetFDisabled && pageSetGDisabled && pageSetHDisabled)) {
          out.write("\r\n    <td class=\"alignRight\">\r\n      ");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setImg("btnSave");
          _jspx_th_impact_ButtonTag_4.setName("btnSave");
          _jspx_th_impact_ButtonTag_4.setForm("frmCaseSummary");
          _jspx_th_impact_ButtonTag_4.setAction("/workload/CaseSummary/saveCaseSummary");
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n    </td>\r\n    ");
}
          out.write("\r\n  </tr>\r\n</table>\r\n");
          out.write("\r\n\r\n<br/>\r\n\r\n");
          out.write("\r\n<input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\n");
      out.write('\r');
      out.write('\n');

  if (selectedIndex != -1) {

      out.write("\r\n<script type=\"text/javascript\" language=\"javascript\">\r\n  selectStage(");
      out.print( selectedIndex );
      out.write(");\r\n</script>\r\n");

  }

      out.write("\r\n\r\n\r\n");
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

  private boolean _jspx_meth_impact_codeArray_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:codeArray
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
    _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_codeArray_0.setParent(null);
    _jspx_th_impact_codeArray_0.setCodeName("CCOUNT");
    _jspx_th_impact_codeArray_0.setArrayName("countyCodes");
    _jspx_th_impact_codeArray_0.setBlankValue("true");
    _jspx_th_impact_codeArray_0.setOrderBy("decode");
    int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
    if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("pageMode");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_1(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_1.setType("hidden");
    _jspx_th_impact_validateInput_1.setName("arrayIndex");
    _jspx_th_impact_validateInput_1.setValue("");
    int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
    if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
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
    _jspx_th_impact_validateInput_2.setName("pendStatus");
    _jspx_th_impact_validateInput_2.setValue("");
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
    _jspx_th_impact_validateInput_3.setName("staffNameMerge");
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
    _jspx_th_impact_validateInput_4.setName("staffNameSplit");
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
    _jspx_th_impact_validateInput_5.setName("idCaseMerge");
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
    _jspx_th_impact_validateInput_6.setName("hdnCReqFuncCd");
    _jspx_th_impact_validateInput_6.setValue("");
    int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
    if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_7(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_7.setType("hidden");
    _jspx_th_impact_validateInput_7.setName("hdnDataAction");
    _jspx_th_impact_validateInput_7.setValue("");
    int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
    if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_8(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_8.setType("hidden");
    _jspx_th_impact_validateInput_8.setName("hdnCScrIndStageMerged");
    _jspx_th_impact_validateInput_8.setValue("");
    int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
    if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_9(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_9.setType("hidden");
    _jspx_th_impact_validateInput_9.setName("hdnSzNmStage");
    _jspx_th_impact_validateInput_9.setValue("");
    int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
    if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_10(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_10.setType("hidden");
    _jspx_th_impact_validateInput_10.setName("hdnSzCdStage");
    _jspx_th_impact_validateInput_10.setValue("");
    int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
    if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_11(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_11.setType("hidden");
    _jspx_th_impact_validateInput_11.setName("hdnSzCdStageType");
    _jspx_th_impact_validateInput_11.setValue("");
    int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
    if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_12(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_12.setType("hidden");
    _jspx_th_impact_validateInput_12.setName("hdnSzCdStageLevel");
    _jspx_th_impact_validateInput_12.setValue("");
    int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
    if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_13(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_13.setType("hidden");
    _jspx_th_impact_validateInput_13.setName("hdnDtDtStageStart");
    _jspx_th_impact_validateInput_13.setValue("");
    int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
    if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_14(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_14.setType("hidden");
    _jspx_th_impact_validateInput_14.setName("hdnDtDtStageClose");
    _jspx_th_impact_validateInput_14.setValue("");
    int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
    if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_15(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_15.setType("hidden");
    _jspx_th_impact_validateInput_15.setName("hdnSzNmPersonFull");
    _jspx_th_impact_validateInput_15.setValue("");
    int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
    if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_16(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_16.setType("hidden");
    _jspx_th_impact_validateInput_16.setName("hdnSzCdStageRegion");
    _jspx_th_impact_validateInput_16.setValue("");
    int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
    if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_17(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_17.setType("hidden");
    _jspx_th_impact_validateInput_17.setName("hdnSzCdStageCounty");
    _jspx_th_impact_validateInput_17.setValue("");
    int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
    if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_18(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_18.setType("hidden");
    _jspx_th_impact_validateInput_18.setName("hdnUlIdStage");
    _jspx_th_impact_validateInput_18.setValue("");
    int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
    if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_19(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_19.setType("hidden");
    _jspx_th_impact_validateInput_19.setName("hdnHasAccess");
    _jspx_th_impact_validateInput_19.setValue("");
    int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
    if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_20(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_20.setType("hidden");
    _jspx_th_impact_validateInput_20.setName("hdnAdminCommand");
    _jspx_th_impact_validateInput_20.setValue("");
    int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
    if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_21(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_21.setType("hidden");
    _jspx_th_impact_validateInput_21.setName("hdnUlIdAdoCase");
    _jspx_th_impact_validateInput_21.setValue("");
    int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
    if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_25(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_25.setType("hidden");
    _jspx_th_impact_validateInput_25.setName("indHasRecordsRet");
    _jspx_th_impact_validateInput_25.setValue("Y");
    int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
    if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_26(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_26.setType("hidden");
    _jspx_th_impact_validateInput_26.setName("indHasRecordsRet");
    _jspx_th_impact_validateInput_26.setValue("N");
    int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
    if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
