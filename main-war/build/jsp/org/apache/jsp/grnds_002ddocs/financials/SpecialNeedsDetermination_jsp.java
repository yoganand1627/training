package org.apache.jsp.grnds_002ddocs.financials;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation;
import gov.georgia.dhr.dfcs.sacwis.web.financials.SpecialNeedsDeterminationConversation;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

public final class SpecialNeedsDetermination_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");

  int tabIndex = 1;
  BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                   .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
  String pageMode = PageModeConstants.EDIT;
  UserProfile user = UserProfileHelper.getUserProfile(request);

  SpecialNeedsDeterminationRetrieveSO spNdsDetRetSO = new SpecialNeedsDeterminationRetrieveSO();
  spNdsDetRetSO = (SpecialNeedsDeterminationRetrieveSO) state.getAttribute("specialNeedsDeterminationRetrieveSO",
                                                                           request);
  SpecialNeedsDeterminationBean spNdsBean = new SpecialNeedsDeterminationBean();
  
  String staffPersRole = "";
  String eventStatus = "";
  String disabled = ArchitectureConstants.TRUE;
  String editableMode = ArchitectureConstants.TRUE;
  String homeCnty = "";
  String boardingCnty = "";
  String indBtnSave = ArchitectureConstants.TRUE;
  String indBtnSaveSubmit = ArchitectureConstants.TRUE;
  String applicationStatus = "";
  String nonRecLimit = "$" + Lookup.simpleDecodeSafe(CodesTables.CNONREC, CodesTables.CNONREC_LMT) + ".00";
  String totalNonRecLable = "Total Amount Requested (not to exceed " + nonRecLimit + ")";
  boolean canModifyApprovalSections = false;
  String cdStage = GlobalData.getSzCdStage(request); // SMS#97845 MR-074-2 AFCARS
  Date PREMARCH012010 = null;
  PREMARCH012010 = DateHelper.toJavaDateSafe("03/01/2010");
  boolean indCancelVal = false;
  if (spNdsDetRetSO != null) {
    spNdsBean = spNdsDetRetSO.getSpNdsDetBean();
    eventStatus = spNdsDetRetSO.getCdEventStatus();
    staffPersRole = spNdsDetRetSO.getStaffPersRole();
    homeCnty = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, spNdsDetRetSO.getPersonHomeCnty());
    boardingCnty = Lookup.simpleDecodeSafe(CodesTables.CCOUNT, spNdsDetRetSO.getPersonBoardCnty());
  }
  if ((GlobalData.hasStageAccess(request))
      && ((CodesTables.CEVTSTAT_NEW.equals(eventStatus) || CodesTables.CEVTSTAT_PROC.equals(eventStatus) ||
      CodesTables.CEVTSTAT_PEND.equals(eventStatus) || CodesTables.CEVTSTAT_COMP.equals(eventStatus)))) {
    editableMode = ArchitectureConstants.FALSE;
    indBtnSave = ArchitectureConstants.FALSE;
    indBtnSaveSubmit = ArchitectureConstants.FALSE;
  }
  if ((user.hasRight(UserProfile.SEC_ADOPT_ASSIST_SPEC) || 
      user.hasRight(UserProfile.SEC_SAU_EXCHANGE)) && CodesTables.CEVTSTAT_PEND.equals(eventStatus)
      && GlobalData.isApprovalMode(request)) {
    disabled = ArchitectureConstants.FALSE;
    editableMode = ArchitectureConstants.FALSE;
    indBtnSave = ArchitectureConstants.FALSE;
    canModifyApprovalSections = true;
  }


  // STGAP00010839 Set the application status based on various flags if the EVENT is approved. if any of the requests have been approved, 
  // then page will show 'approved' as the status.
  if (CodesTables.CEVTSTAT_APRV.equals(spNdsDetRetSO.getCdEventStatus())) {
    if (CodesTables.CAPPSTS_Y.equals(spNdsBean.getIndSpcNeedsApproved())
        || CodesTables.CAPPSTS_Y.equals(spNdsBean.getIndSpclRateAdoAppr())
        || CodesTables.CAPPSTS_Y.equals(spNdsBean.getIndSpclReqApproved())  || CodesTables.CAPPSTS_Y.equals(spNdsBean.getIndNonRecApproved())) {
      applicationStatus = Lookup.simpleDecodeSafe(CodesTables.CAPPSTS, CodesTables.CAPPSTS_Y);
    } else if (CodesTables.CAPPSTS_D.equals(spNdsBean.getIndSpcNeedsApproved())) {
      applicationStatus = Lookup.simpleDecodeSafe(CodesTables.CAPPSTS, CodesTables.CAPPSTS_D);
    } else if (CodesTables.CAPPSTS_N.equals(spNdsBean.getIndSpcNeedsApproved())
               || CodesTables.CAPPSTS_N.equals(spNdsBean.getIndSpclRateAdoAppr())
               || CodesTables.CAPPSTS_N.equals(spNdsBean.getIndSpclReqApproved())
               || CodesTables.CAPPSTS_N.equals(spNdsBean.getIndNonRecApproved())) {
      applicationStatus = Lookup.simpleDecodeSafe(CodesTables.CAPPSTS, CodesTables.CAPPSTS_N);
    }
  }

  String indSpNdsReq = FormattingHelper.formatString(spNdsBean.getIndReasonSpecialRequest());
  String indSpNdsAppr = FormattingHelper.formatString(spNdsBean.getIndAprType());
  String indApprovalType = FormattingHelper.formatString(spNdsBean.getIndAprType());
  FormattingHelper.formatString(spNdsDetRetSO.getPersonFirst());
  
  String fundingType = spNdsBean.getCdFundingType();
  // SMS#109403: do not set funding type for Non-Recurring Only application
  if ((fundingType == null || fundingType.length() == 0) && StringHelper.isEmptyOrNull(spNdsBean.getIndNonRecOnly())) {
    String personIVEEligibility = spNdsDetRetSO.getPersonIVEEligibility();
    if("YES".equals(personIVEEligibility)) {
    	fundingType = CodesTables.CAAFDTYP_IVE;
    } else if ("NO".equals(personIVEEligibility)) {
    	fundingType = CodesTables.CAAFDTYP_PST;
    }
  }
  
  
  String disableNonRecurring = (ArchitectureConstants.TRUE.equals(editableMode)) ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE;
  String disableNonRecurringAprv = (("Y".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecRequested())) == false) || ArchitectureConstants.TRUE.equals(disabled)) ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE;
  // SMS#109403: update indDisablecbxNonRecOnly logic as follows:
  // disable the checkbox if incident (this now can include converted PAD)
  // enable the checkbox if non-incident or not-yet-determined status. (not-yet-determined status means the status has yet been recorded in SHINES for PAD)
  String indDisablecbxNonRecOnly = (spNdsDetRetSO.isBIncidentChild() || ArchitectureConstants.TRUE.equals(editableMode) || ArchitectureConstants.TRUE.equals(disableNonRecurring)) ? ArchitectureConstants.TRUE : ArchitectureConstants.FALSE;
  
  String reason = "";
  boolean specialNeedsNotReq = false;
  if(spNdsDetRetSO.getPriorAprvSpecialNeedsDeterNA() != null){
    reason = (String) spNdsDetRetSO.getPriorAprvSpecialNeedsDeterNA().get("reason");
    specialNeedsNotReq = (Boolean) spNdsDetRetSO.getPriorAprvSpecialNeedsDeterNA().get("specialNeedsNotReq");
  }
  
  List excludeOption = new ArrayList();
  excludeOption.add(CodesTables.CAAFDTYP_NRC);
  
  boolean cusSelected = CodesTables.CBRTYPE_CUS.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType()));
  
  //MR-60 changes  
        
  String indSpcNdsPrePost = FormattingHelper.formatString(spNdsBean.getCdSpcNdsPrePosReq());
  String indSpcNdsPrePostAppr = FormattingHelper.formatString(spNdsBean.getCdSpcNdsPrePosApr());  
  
  //If the event status is NEW that is when a new Application is added, the Post March 1st, 2010 radio button would be
  // selected by default
  if ((indSpcNdsPrePost == null || "".equals(indSpcNdsPrePost)) && CodesTables.CEVTSTAT_NEW.equals(eventStatus)){
    indSpcNdsPrePost = CodesTables.CPLCYCHG_POS;
  }  
  
  //SMS#77296: Modified the condition for displaying Pre-Post Special needs type 
  //If the event status is PROC or PEND then select appropriate radio button depending on the Special Needs Type.
  if ((indSpcNdsPrePost == null || "".equals(indSpcNdsPrePost)) && (CodesTables.CEVTSTAT_PROC.equals(eventStatus) || CodesTables.CEVTSTAT_PEND.equals(eventStatus) ||
   CodesTables.CEVTSTAT_APRV.equals(eventStatus))){
    if (indSpNdsReq != null && !"".equals(indSpNdsReq)) {
      if (CodesTables.CSPCLTYP_R.equals(indSpNdsReq) || CodesTables.CSPCLTYP_A.equals(indSpNdsReq) || CodesTables.CSPCLTYP_S.equals(indSpNdsReq)
       || CodesTables.CSPCLTYP_T.equals(indSpNdsReq) || CodesTables.CSPCLTYP_M.equals(indSpNdsReq)) {
        indSpcNdsPrePost = CodesTables.CPLCYCHG_PRE;
      } else {
        if (spNdsDetRetSO.getDtEventApproved().before(PREMARCH012010)
            && (CodesTables.CSPCLTYP_N.equals(indSpNdsReq) || "O".equals(indSpNdsReq))) {
          indSpcNdsPrePost = CodesTables.CPLCYCHG_PRE;
        } else {
          indSpcNdsPrePost = CodesTables.CPLCYCHG_POS;
        }
      }
    }
  }
 
//SMS#77296: Modified the condition for displaying Pre-Post Special needs type 
//If the event status is PEND then select appropriate radio button depending on the Approval Type.
  if ((indSpcNdsPrePostAppr == null || "".equals(indSpcNdsPrePostAppr))
      && (CodesTables.CEVTSTAT_PEND.equals(eventStatus) || CodesTables.CEVTSTAT_APRV.equals(eventStatus))) {
    if (indSpNdsAppr != null && !"".equals(indSpNdsAppr)) {
      if (CodesTables.CSPCLTYP_R.equals(indSpNdsAppr) || CodesTables.CSPCLTYP_A.equals(indSpNdsAppr)
          || CodesTables.CSPCLTYP_S.equals(indSpNdsAppr) || CodesTables.CSPCLTYP_T.equals(indSpNdsAppr)
          || CodesTables.CSPCLTYP_M.equals(indSpNdsAppr)) {
        indSpcNdsPrePostAppr = CodesTables.CPLCYCHG_PRE;
      } else {
        if (spNdsDetRetSO.getDtEventApproved().before(PREMARCH012010)
            && (CodesTables.CSPCLTYP_N.equals(indSpNdsAppr) || "O".equals(indSpNdsAppr))) {
          indSpcNdsPrePostAppr = CodesTables.CPLCYCHG_PRE;
        } else {
          indSpcNdsPrePostAppr = CodesTables.CPLCYCHG_POS;
        }
      }
    } else if (indSpNdsReq != null && !"".equals(indSpNdsReq)) {
      indSpcNdsPrePostAppr = indSpcNdsPrePost;
      indSpNdsAppr = indSpNdsReq;
    }
  }

  List<String> excludeSpecialNeedsTypeList = new ArrayList<String>();
  //SMS#109420 Removed 'None Applicable' option for new applications
	if(request.getAttribute("excludeSpecialNeedsTypeList") != null && CodesTables.CEVTSTAT_APRV.equals(eventStatus)){
	   excludeSpecialNeedsTypeList = (List<String>)request.getAttribute("excludeSpecialNeedsTypeList");
	} else{
	   
	  if (CodesTables.CPLCYCHG_POS.equals(indSpcNdsPrePost)) {
		excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_R);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_A);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_S);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_T);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_M);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_N);
        
      }else if(CodesTables.CPLCYCHG_PRE.equals(indSpcNdsPrePost)){ 
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_C);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_U);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_V);
        excludeSpecialNeedsTypeList.add(CodesTables.CSPCLTYP_N);
      }
    }
    
    List<String> excludeSpecialNeedsTypeApprList = new ArrayList<String>();
	if(request.getAttribute("excludeSpecialNeedsTypeApprList") != null){
	   excludeSpecialNeedsTypeApprList = (List<String>)request.getAttribute("excludeSpecialNeedsTypeApprList");
	} else{
	  if (CodesTables.CPLCYCHG_POS.equals(indSpcNdsPrePostAppr)) {
		excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_R);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_A);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_S);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_T);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_M);
      }else if(CodesTables.CPLCYCHG_PRE.equals(indSpcNdsPrePostAppr)){ 
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_C);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_U);
        excludeSpecialNeedsTypeApprList.add(CodesTables.CSPCLTYP_V);
      }
    }

    String location = (String)request.getAttribute("anchor");
    request.removeAttribute("anchor");

	// SMS#97845 MR-074-2 AFCARS: set disable attr for Incident/Non-Incident Status section
	String disableIncidentStatus;
	boolean bD = ArchitectureConstants.TRUE.equals(disabled);
	// order is important
	// APROV - follow page mode
	// PEND - use radio mode
	bD = bD || spNdsDetRetSO.isBDisableIncidentStatus();
	if (bD)
		disableIncidentStatus = ArchitectureConstants.TRUE;
	else
		disableIncidentStatus = ArchitectureConstants.FALSE;


      out.write('\r');
      out.write('\n');
      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\n  /*\r\n   This function is called before the page unloads. It creates the\r\n   \"Are you sure you want to navigate away from this page...\" pop-up message.\r\n  */\r\n  window.onbeforeunload = function ()\r\n  {\r\n    IsDirty();\r\n  };\r\n  function setIndValidate(indValidate)\r\n  {\r\n   if(indValidate){\r\n      disableValidation('frmSpecialNeedsDetermination');\r\n   }\r\n  }\r\n  \r\n  /*\r\n  This function fires every time the page is loaded to disable certain sections\r\n  of the page.  It is also used on click events for the Basic Rate Yes/No question.\r\n  */\r\n  function disableSpecialRatesAndServices()\r\n  {\r\n    \r\n    /* Test to see if we are in the correct page mode (modifiable). If not exit the\r\n       function */\r\n    var basicRateToggle = document.getElementsByName('rbBasicRateReq');\r\n    if (basicRateToggle.length == 1) {\r\n");
      out.write("      return;\r\n    }\r\n\r\n    if (basicRateToggle.length > 1 && frmSpecialNeedsDetermination.rbBasicRateReq[0].checked) {\r\n      val = true;\r\n    } else {\r\n      val = false;\r\n    }\r\n    \r\n    /*STGAP00012952: Disable Special Service Request section until the question\r\n      Is a Special Service being requested for this child? is answered Yes.*/\r\n    var spcSrvRequested = document.getElementsByName('rbSpecServiceReq');\r\n    if (spcSrvRequested.length > 1){\r\n\t    if (frmSpecialNeedsDetermination.rbSpecServiceReq[0].checked) {\r\n\t      spcSrvReqDisable = false;\r\n\t    } else { \r\n\t      /*Disable and clear the request section */\r\n\t      spcSrvReqDisable = true;\r\n\t      frmSpecialNeedsDetermination.rbSpecServiceReq[0].checked = false;\r\n\t      frmSpecialNeedsDetermination.rbSpecServiceReq[1].checked = false;\r\n\t\t  frmSpecialNeedsDetermination.rbIndDocAttached[0].checked = false;\r\n\t      frmSpecialNeedsDetermination.rbIndDocAttached[1].checked = false;\r\n\t\t  frmSpecialNeedsDetermination.rbIndDocAttached[0].disabled = true;\r\n");
      out.write("\t      frmSpecialNeedsDetermination.rbIndDocAttached[1].disabled = true;\r\n\t      frmSpecialNeedsDetermination.txtSzReqAmt.value = '';\r\n\t      frmSpecialNeedsDetermination.txtSzReqAmt.disabled = true;\r\n\t      frmSpecialNeedsDetermination.selSzCdSpecServType.value = '';\r\n\t      frmSpecialNeedsDetermination.selSzCdSpecServType.disabled = true;\r\n\t      frmSpecialNeedsDetermination.txtPlSpecify.value = '';\r\n\t      frmSpecialNeedsDetermination.txtPlSpecify.disabled = true;\r\n\t      frmSpecialNeedsDetermination.txtSzNumSPNChildReq.value = '';\r\n\t      frmSpecialNeedsDetermination.txtSzNumSPNChildReq.disabled = true;\r\n\t    }\r\n\t    if (spcSrvReqDisable){\r\n\t      var spcSrvReqAprv = document.getElementsByName('rbSpecServReqAprv');\r\n\t      if (spcSrvReqAprv.length > 1){\r\n\t        /*Disable and clear the approval section */\r\n\t      \tfrmSpecialNeedsDetermination.rbSpecServReqAprv[0].checked = false;\r\n\t      \tfrmSpecialNeedsDetermination.rbSpecServReqAprv[1].checked = false;\r\n\t      \tfrmSpecialNeedsDetermination.rbSpecServReqAprv[0].disabled = true;\r\n");
      out.write("\t      \tfrmSpecialNeedsDetermination.rbSpecServReqAprv[1].disabled = true;\r\n\t      \tfrmSpecialNeedsDetermination.selSzCdSpServFundingType.value = '';\r\n\t      \tfrmSpecialNeedsDetermination.selSzCdSpServFundingType.disabled = true;\r\n\t      \tfrmSpecialNeedsDetermination.txtSzAprvAmt.value = '';\r\n\t      \tfrmSpecialNeedsDetermination.txtSzAprvAmt.disabled = true;\r\n\t\t\tfrmSpecialNeedsDetermination.txtDtDtAprvDate.value = '';\r\n\t\t\tfrmSpecialNeedsDetermination.txtDtDtAprvDate.disabled = true;\r\n\t\t\tfrmSpecialNeedsDetermination.txtDtDtExpDate.value = '';\r\n\t\t\tfrmSpecialNeedsDetermination.txtDtDtExpDate.disabled = true;\r\n\t\t\tfrmSpecialNeedsDetermination.txtSzTxtSpcServAprvCmmts.value = '';\r\n\t\t\tfrmSpecialNeedsDetermination.txtSzTxtSpcServAprvCmmts.disabled = true;\r\n\t      }\r\n\t    }\r\n    }\r\n    \r\n    var testWidget = document.getElementsByName('rbSpecRateReq');\r\n    if (testWidget.length > 0) {\r\n      if (frmSpecialNeedsDetermination.rbSpecRateReq[0].checked) {\r\n       valSepcRate = true;\r\n      } else {\r\n       valSepcRate = false;\r\n");
      out.write("      }\r\n      \r\n      var approvalWidget = document.getElementsByName('rbSpecRateAprv');\r\n      if (valSepcRate == true && approvalWidget.length > 0 && approvalWidget[0].type != 'hidden') {\r\n        frmSpecialNeedsDetermination.rbSpecRateAprv[0].disabled = false;\r\n        frmSpecialNeedsDetermination.rbSpecRateAprv[1].disabled = false;\r\n        if(frmSpecialNeedsDetermination.rbSpecRateAprv[0].checked == false){\r\n         frmSpecialNeedsDetermination.txtSzTotalAprvAmt.value = '';\r\n        }\r\n        \r\n      } else if (approvalWidget.length > 0) {\r\n      \tfrmSpecialNeedsDetermination.rbSpecRateAprv[0].checked = false;\r\n        frmSpecialNeedsDetermination.rbSpecRateAprv[1].checked = false;\r\n        frmSpecialNeedsDetermination.rbSpecRateAprv[0].disabled = true;\r\n        frmSpecialNeedsDetermination.rbSpecRateAprv[1].disabled = true;\r\n        frmSpecialNeedsDetermination.txtSzTotalAprvAmt.value = '';\r\n        frmSpecialNeedsDetermination.txtSzTotalAprvAmt.disabled = true;\r\n      }    \r\n    } \r\n        \r\n    var nonRecReqWidget = document.getElementsByName('rbNonRecReq'); \r\n");
      out.write("    if (nonRecReqWidget.length > 1) {\r\n\t   \t if (frmSpecialNeedsDetermination.rbNonRecReq[0].checked) {\r\n\t   \t \tvar nonNonRecReqAprvWidget = document.getElementsByName('rbNonRecReqAprv');\r\n\t   \t \tif(nonNonRecReqAprvWidget.length > 1) {\r\n\t   \t \t\tfrmSpecialNeedsDetermination.rbNonRecReqAprv.disabled = false;     \t \t\t\r\n\t   \t \t\tif (frmSpecialNeedsDetermination.rbNonRecReqAprv[0].checked == false) {\r\n\t   \t \t\t\tfrmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '';\r\n\t   \t \t\t}\r\n\t   \t \t\tfrmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = false;\r\n\t   \t \t}\r\n\t   \t } else {\r\n\t   \t \tfrmSpecialNeedsDetermination.txtNonRecAmtReq.value = '';\r\n\t   \t \tfrmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;\r\n\t   \t \tvar nonNonRecReqAprvWidget = document.getElementsByName('rbNonRecReqAprv');\r\n\t   \t \tif(nonNonRecReqAprvWidget.length > 0) {\r\n\t   \t \t\tfrmSpecialNeedsDetermination.rbNonRecReqAprv[0].disabled = true;\r\n\t   \t \t\tfrmSpecialNeedsDetermination.rbNonRecReqAprv[1].disabled = true;\r\n\t   \t \t\tfrmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '';\r\n");
      out.write("\t   \t \t\tfrmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = false;\r\n\t   \t \t}\r\n\t   \t }\r\n\t   \t frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;\r\n    } \r\n    \r\n    if(frmSpecialNeedsDetermination.cbxNonRecOnly.checked) {\r\n    \tenabledisableSpecialNeedsBaseRateRequest();\r\n    }     \r\n  }  \r\n     /* STGAP00012952: Disable Special Service Request section until the question\r\n      Is a Special Service being requested for this child? is answered Yes. */\r\n  function enableSpcSrvReq(){\r\n    /*Enable the request section */\r\n    var x = document.frmSpecialNeedsDetermination;\r\n\tx.rbIndDocAttached[0].disabled = false;\r\n\tx.rbIndDocAttached[1].disabled = false; \r\n\tx.txtSzReqAmt.disabled = false;\r\n\tx.selSzCdSpecServType.disabled = false;\r\n\tx.txtPlSpecify.disabled = false;\r\n\tx.txtSzNumSPNChildReq.disabled = false;\r\n\tvar spcSrvReqAprv = document.getElementsByName('rbSpecServReqAprv');\r\n    if (spcSrvReqAprv.length > 1){\r\n\t  x.rbSpecServReqAprv[0].disabled = false;\r\n\t  x.rbSpecServReqAprv[1].disabled = false;\r\n");
      out.write("\t}\r\n  }  \r\n  function disableSpcSrvReq(){\r\n    /*Disable the request and Approval section */\r\n    var x = document.frmSpecialNeedsDetermination;\r\n\tx.rbIndDocAttached[0].checked = false;\r\n\tx.rbIndDocAttached[1].checked = false;\r\n\tx.rbIndDocAttached[0].disabled = true;\r\n\tx.rbIndDocAttached[1].disabled = true;\r\n\tx.txtSzReqAmt.value = '';\r\n\tx.txtSzReqAmt.disabled = true;\r\n\tx.selSzCdSpecServType.value = '';\r\n\tx.selSzCdSpecServType.disabled = true;\r\n\tx.txtPlSpecify.value = '';\r\n\tx.txtPlSpecify.disabled = true;\r\n\tx.txtSzNumSPNChildReq.value = '';\r\n\tx.txtSzNumSPNChildReq.disabled = true;\r\n\tvar spcSrvReqAprv = document.getElementsByName('rbSpecServReqAprv');\r\n    if (spcSrvReqAprv.length > 1){\r\n     \tx.rbSpecServReqAprv[0].checked = false;\r\n     \tx.rbSpecServReqAprv[1].checked = false;\r\n     \tx.rbSpecServReqAprv[0].disabled = true;\r\n     \tx.rbSpecServReqAprv[1].disabled = true;\r\n     \tx.selSzCdSpServFundingType.value = '';\r\n     \tx.selSzCdSpServFundingType.disabled = true;\r\n     \tx.txtSzAprvAmt.value = '';\r\n     \tx.txtSzAprvAmt.disabled = true;\r\n");
      out.write("\t\tx.txtDtDtAprvDate.value = '';\r\n\t\tx.txtDtDtAprvDate.disabled = true;\r\n\t\tx.txtDtDtExpDate.value = '';\r\n\t\tx.txtDtDtExpDate.disabled = true;\r\n\t\tx.txtSzTxtSpcServAprvCmmts.value = '';\r\n\t\tx.txtSzTxtSpcServAprvCmmts.disabled = true;\r\n    }\r\n  }\r\n  function enableSpcSrvReqAprv(){\r\n      /*Enable the approval section only*/\r\n\t  var x = document.frmSpecialNeedsDetermination;\r\n\t  x.selSzCdSpServFundingType.disabled = false;\r\n\t  x.txtSzAprvAmt.disabled = false;\r\n\t  x.txtDtDtAprvDate.disabled = false;\r\n\t  x.txtDtDtExpDate.disabled = false;\r\n\t  x.txtSzTxtSpcServAprvCmmts.disabled = false;\r\n\t  x.selSzCdSpServFundingType.value = x.selSzCdSpecServType.value; \r\n      x.txtSzAprvAmt.value = x.txtSzReqAmt.value;\r\n  }  \r\n\r\n  function disableSpcSrvReqAprv(){\r\n      /*Disable the approval section only*/\r\n\t  var x = document.frmSpecialNeedsDetermination;\r\n\t  x.selSzCdSpServFundingType.value = '';\r\n\t  x.selSzCdSpServFundingType.disabled = true;\r\n\t  x.txtSzAprvAmt.value = '';\r\n\t  x.txtSzAprvAmt.disabled = true;\r\n\t  x.txtDtDtAprvDate.value = '';\r\n");
      out.write("\t  x.txtDtDtAprvDate.disabled = true;\r\n\t  x.txtDtDtExpDate.value = '';\r\n\t  x.txtDtDtExpDate.disabled = true;\r\n\t  x.txtSzTxtSpcServAprvCmmts.value = '';\r\n\t  x.txtSzTxtSpcServAprvCmmts.disabled = true;\r\n  }   \r\n    \r\n  function enableNonRec() {\r\n  \t frmSpecialNeedsDetermination.txtNonRecAmtReq.value = '");
      out.print( nonRecLimit );
      out.write("';\r\n  \t frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;\r\n  }\r\n  \r\n  function disableNonRec() {\r\n  \t frmSpecialNeedsDetermination.txtNonRecAmtReq.value = '';\r\n     frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;\r\n  }\r\n  \r\n  \r\n  function enableApvrNonRec() {\r\n  \t frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '");
      out.print( nonRecLimit );
      out.write("';\r\n     frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = false; /*STGAP00014563: Non Recurring Approval amount field will now be modifiable for the SAU */\r\n  }\r\n  \r\n  function disableAprvNonRec() {\r\n  \t frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '';\r\n     frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = true;\r\n  }\r\n  \r\n  function clearTotalAprvAmt() {\r\n  \tfrmSpecialNeedsDetermination.txtSzTotalAprvAmt.value = '';\r\n  \tfrmSpecialNeedsDetermination.txtSzTotalAprvAmt.disabled = true;\r\n  }\r\n  \r\n  function enableTotalAprvAmt() {\r\n  \tfrmSpecialNeedsDetermination.txtSzTotalAprvAmt.disabled = false;\r\n  }\r\n  \r\n  function enabledisableSpecialNeedsBaseRateRequest() {\r\n   \tvar x = document.frmSpecialNeedsDetermination;\r\n   \tif(x.cbxNonRecOnly.checked)  {\r\n      val = true;\r\n      disableSpcSrvReq();\r\n      x.rbSpecServiceReq[0].checked = false;\r\n\t  x.rbSpecServiceReq[1].checked = false;\r\n\t  /* SMS#109403: if non-recurring only is checked,\r\n\t  disable non-recurring request. The $ amount field should be controlled by the non-recurring request field.\t  \r\n");
      out.write("\t  */\r\n\t  ");
 if (!GlobalData.isApprovalMode(request)) { 
      out.write("\r\n\t  /* SMS#111617: manually set request = yes on page reload to fix the auto-populated radio not retained  \r\n\t  because the field was disabled when failed custom validation. Value already set in hdn field when \r\n\t  non-recurring only cbx ticked. Amount field disabled by java calculation, only need to set amount here */\r\n\t  x.rbNonRecReq[0].checked = true;\r\n\t  x.txtNonRecAmtReq.value = '");
      out.print( nonRecLimit );
      out.write("';\r\n\t  x.rbNonRecReq[0].disabled = true;\r\n\t  x.rbNonRecReq[1].disabled = true;  \r\n\t  ");
 } 
      out.write("\r\n    } else {\r\n      val = false;\r\n    }   \r\n    x.rbSpecServiceReq[0].disabled = val; \r\n    x.rbSpecServiceReq[1].disabled = val; \r\n    //MR-60 radio button to dropdown change  \r\n  \t/*SMS#109403: reverting MR-060: enable special needs request fields\r\n\t*/\r\n\tx.rbBasicRateReq[0].disabled = val;\r\n\tx.rbBasicRateReq[1].disabled = val;\r\n\t\r\n\tx.rbSpecRateReq[0].disabled = val;\r\n    x.rbSpecRateReq[1].disabled = val;\r\n    x.rbSFCorRBWO[0].disabled = val;\r\n    x.rbSFCorRBWO[1].disabled = val;   \r\n    x.cbxPsychological.disabled = val;\r\n    x.cbxDevAssmtEval.disabled = val;   \r\n    x.cbxTrtmntPrvdr.disabled = val;  \r\n    x.cbxMedAssmnt.disabled = val; \r\n    x.cbxSSI.disabled = val;    \r\n    \r\n    /*STGAP00013919: Disable Special Needs Determination Approval Section when non-recurring only checkbox is checked*/\r\n    /*SMS#109403: enable special needs determination approval for non-recurring only application\r\n    disable Funding Type and Basic Rate\r\n    Check for appropriate mode before calling these widgets to avoid script error because these fields only show in approval mode\r\n");
      out.write("    */\r\n\t");
 if (GlobalData.isApprovalMode(request)) { 
      out.write("\r\n\t   x.selSzCdFundingType.disabled = val;    \r\n\t   x.cdBasicRateType[0].disabled = val;\r\n\t   x.cdBasicRateType[1].disabled = val;\r\n\t   x.cdBasicRateType[2].disabled = val;\r\n\t   x.txtNbrCountyAddonAmt.disabled = val;\r\n\t   x.txtNbrCustomAmt.disabled = val;\r\n    \r\n    ");
 } 
      out.write("\r\n    \r\n    //Mr-60 change\r\n    // SMS#109403: reverting MR-060: removed MR-060 code to enable approval type for SND\r\n  }\r\n  /* SMS#109403: this is called by onClick of Non-Recurring Only cbx to set value of Non-recurring request\r\n  and invoke actions that would be called by an onClick of Non-recurring request.\r\n  This should not be part of onload because we don't want to blindly clear the non-recurring request on page load, \r\n  for example, monthly app can have non-recurring request and should not be clear by this script\r\n   */\r\n  function setNonRecReq() {\r\n    var x = document.frmSpecialNeedsDetermination;\r\n   \tif(x.cbxNonRecOnly.checked)  {\r\n      val = true;\r\n      enableNonRec(); // set $ and disable amount field\r\n      x.hdnNonRecReq.value = 'Y';\r\n    } else {\r\n      val = false;\r\n      disableNonRec(); // clear $ and disable amount field\r\n      x.hdnNonRecReq.value = '';\r\n    }\r\n    ");
 if (!GlobalData.isApprovalMode(request)) { 
      out.write("\r\n    x.rbNonRecReq[0].disabled = val;\r\n    x.rbNonRecReq[1].disabled = val;\r\n    ");
 } 
      out.write("\t\r\n    x.rbNonRecReq[0].checked = val; \r\n  }\r\n  /* SMS#109403: this is called by onClick of Non-Recurring Request radio button\r\n  to set the hidden field value used by server code\r\n  */\r\n  function setHdnNonRecReq(value) {\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    x.hdnNonRecReq.value = value;\r\n  }\r\n    \r\n  /*STGAP00014563  This function disables county addon and custom*/\r\n  function emptyCountyAddOnCustom(){\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    x.txtNbrCountyAddonAmt.value = '$0.00';\r\n    x.txtNbrCountyAddonAmt.disabled = true;\r\n    x.txtNbrCustomAmt.value = '$0.00';\r\n    x.txtNbrCustomAmt.disabled = true;\r\n  }\r\n  \r\n    /*STGAP00014563  This function disables custom*/\r\n  function emptyCustom(){\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    x.txtNbrCustomAmt.value = '$0.00';\r\n    x.txtNbrCustomAmt.disabled = true;   \r\n  }\r\n  \r\n    /*STGAP00014563  This function disables county add on*/\r\n  function emptyCountyAddon(){\r\n    var x = document.frmSpecialNeedsDetermination;\r\n");
      out.write("    x.txtNbrCountyAddonAmt.value = '$0.00';\r\n    x.txtNbrCountyAddonAmt.disabled = true; \r\n  }\r\n  \r\n    /*STGAP00014563  This function enables custom*/\r\n  function enableCustom(){\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    x.txtNbrCustomAmt.disabled = false;\r\n  }\r\n  \r\n    /*STGAP00014563  This function enables county add on*/\r\n  function enableCountyAddOn(){\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    x.txtNbrCountyAddonAmt.disabled = false;\r\n  }\r\n  \r\n  /*STGAP00014563  Adding this function to enable and disable basic rate section when basic rate request is yes or no*/\r\n  function enableDisableBasicRateType(){\r\n   ");
 if(CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && canModifyApprovalSections){ 
      out.write("\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    if(x.rbBasicRateReq[1].checked == true){\r\n        x.cdBasicRateType[0].disabled = true;\r\n        x.cdBasicRateType[0].checked = false;\r\n        \r\n        x.cdBasicRateType[1].disabled = true;\r\n        x.cdBasicRateType[1].checked = false;\r\n        \r\n        x.cdBasicRateType[2].disabled = true;\r\n        x.cdBasicRateType[2].checked = false;\r\n        emptyCustom();\r\n        emptyCountyAddon();\r\n        \r\n        updateDisplayOnlyField(\"frmSpecialNeedsDetermination\", \"dspTotalMonthlyAmt\", \"$0.00\");\r\n        \r\n    }else if(x.rbBasicRateReq[0].checked == true){\r\n        x.cdBasicRateType[0].disabled = false;\r\n        x.cdBasicRateType[1].disabled = false;\r\n        x.cdBasicRateType[2].disabled = false;\r\n        enableCustom();\r\n        enableCountyAddOn();\r\n    }\r\n   ");
}
      out.write("\r\n  }\r\n  \r\n  /*STGAP00014563  Adding this function to enable the date approved when special needs is requested*/\r\n  function enableDateSpcNeedsAprvd(){\r\n    ");
 if(CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && canModifyApprovalSections){ 
      out.write("\r\n     var x = document.frmSpecialNeedsDetermination;\r\n     x.txtDtSpecialNeedsApprvd.disabled = false;\r\n     ");
}
      out.write("\r\n  }\r\n  \r\n  /*STGAP00014563  Adding this function to call when page loads*/\r\n  function disableCountyAddOnCustom(){\r\n    ");
 if(CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && canModifyApprovalSections){ 
      out.write("\r\n      var x = document.frmSpecialNeedsDetermination;\r\n      if(x.cdBasicRateType[0].checked == true){\r\n        emptyCustom();\r\n        emptyCountyAddon();\r\n      }else if(x.cdBasicRateType[1].checked == true){\r\n        emptyCustom();\r\n      }else if(x.cdBasicRateType[2].checked == true){\r\n        emptyCountyAddon();\r\n      }\r\n      if(x.rbBasicRateReq[1].checked == true){\r\n        enableDisableBasicRateType();\r\n      }\r\n      //MR-60 radio button to drop down change\r\n      if(x.rbCIndRsnSpcNeedsReq.value == null || x.rbCIndRsnSpcNeedsReq.value == \"\")\r\n      {\r\n         x.txtDtSpecialNeedsApprvd.disabled = true;\r\n      }\r\n   ");
 } 
      out.write("\r\n  }\r\n  \r\n  /*STGAP00014563  Adding this function to populate the total monthly amount when basic rate type is selected*/\r\n  function populateTotalMonthly(){\r\n    var x = document.frmSpecialNeedsDetermination;\r\n    if(x.cdBasicRateType[0].checked == true){\r\n      updateDisplayOnlyField(\"frmSpecialNeedsDetermination\", \"dspTotalMonthlyAmt\", x.dspNbrPostBasicAmt.value);\r\n    }else if(x.cdBasicRateType[1].checked == true){\r\n      var a = x.txtNbrCountyAddonAmt.value.substring(1) * 365 / 12;\r\n      var sum = parseFloat(x.dspNbrPreBasicAmt.value.substring(1)) + roundNumber(a, 2);\r\n      updateDisplayOnlyField(\"frmSpecialNeedsDetermination\", \"dspTotalMonthlyAmt\", \"$\"+sum);\r\n    }else if(x.cdBasicRateType[2].checked == true){\r\n      updateDisplayOnlyField(\"frmSpecialNeedsDetermination\", \"dspTotalMonthlyAmt\", x.txtNbrCustomAmt.value);\r\n    }else{\r\n      updateDisplayOnlyField(\"frmSpecialNeedsDetermination\", \"dspTotalMonthlyAmt\", \"$0.00\");\r\n    }\r\n  }\r\n  \r\n  /*STGAP00014563  This function rounds up to two decimals*/\r\n  function roundNumber(num, dec) {\r\n");
      out.write("\tvar result = Math.round(num*Math.pow(10,dec))/Math.pow(10,dec);\r\n\treturn result;\r\n  }\r\n  \r\n  window.onload = function ()\r\n  {\r\n    disableCountyAddOnCustom();\r\n    enableDisableSpecialNeedsTypeDropDown();\r\n    enableDisableApprovalTypeDropDown();\r\n    goToApprovalSection();\r\n  }\r\n  \r\n/* MR-060 This function sets the hidden variable to true so that it can be used in conversation for creating exclude lists*/\r\nfunction submitFormOnSpecialNeedsTypePostPreSelection(){\r\n  disableValidation(\"frmSpecialNeedsDetermination\");\r\n  document.frmSpecialNeedsDetermination.hdnBSpecialNeedsTypeChange.value = 'true';\r\n  submitValidateFormNoBypass( \"frmSpecialNeedsDetermination\", \"/financials/SpecialNeedsDetermination/displaySpecialNeedsDetermination\" );\r\n}\r\n\r\n/*MR-60 This function enables and disables the Special Needs Type drop down*/\r\nfunction enableDisableSpecialNeedsTypeDropDown(){\r\n   var x = document.frmSpecialNeedsDetermination;\r\n   var checkForNull = document.getElementsByName('rbCdSpcNeedsPrePost');\r\n   if(checkForNull.length > 1 ){\r\n");
      out.write("     if(x.rbCdSpcNeedsPrePost[0].checked == true || x.rbCdSpcNeedsPrePost[1].checked == true){\r\n       x.rbCIndRsnSpcNeedsReq.disabled = false;\r\n     }else{\r\n       x.rbCIndRsnSpcNeedsReq.disabled = true;\r\n     }  \r\n   }\r\n}\r\n\r\n/*MR-60 This function enables and disables the Approval Type drop down*/\r\nfunction enableDisableApprovalTypeDropDown(){\r\n   var x = document.frmSpecialNeedsDetermination;\r\n   var checkForNull = document.getElementsByName('rbCdSpcNeedsPrePostAppr');\r\n   if(checkForNull.length > 1){\r\n     if(x.rbCdSpcNeedsPrePostAppr[0].checked == true || x.rbCdSpcNeedsPrePostAppr[1].checked == true){\r\n       x.rbApprovalType.disabled = false;\r\n     }else{\r\n       x.rbApprovalType.disabled = true;\r\n     }  \r\n   }\r\n}\r\n\r\n/*This function takes to the Approval section when page reloads after slecting Pre or Post radio buttons in Approval section*/\r\nfunction goToApprovalSection(){\r\n ");
if(location != null && !"".equals(location)){
      out.write("\r\n  location.href=\"");
      out.print( location );
      out.write("\";\r\n ");
}
      out.write("\r\n }\r\n/* SMS#97845 MR-074-2 AFCARS: open new window when user clicks on the question mark in the Incident/Non-Incident Status section of the Approval expandable section */ \r\nfunction stayHere() {\r\n\r\n  var vertScroll = document.body.scrollTop\r\n  document.body.scrollTop = vertScroll;\r\n}\r\nfunction displayIncidentStatusHelpText(txt, winName) {\r\n\r\n  frmIncidentStatusHelp.");
      out.print(ArchitectureConstants.SIMPLE_HELP_TEXT_DISPLAY );
      out.write(".value=txt;\r\n  frmIncidentStatusHelp.");
      out.print(ArchitectureConstants.SIMPLE_HELP_TEXT_WIN_NAME );
      out.write(".value=winName;\r\n  var txtDispl = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=yes,resizable=yes,width=600,height=350');\r\n  frmIncidentStatusHelp.target = \"txtWin\";\r\n  if( window.focus ) {\r\n    txtDispl.focus();\r\n  }\r\n  frmIncidentStatusHelp.submit();\r\n } \r\n\r\n</script>\r\n");
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmSpecialNeedsDetermination");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/financials/SpecialNeedsDetermination/saveSpecialNeedsDetermination");
      _jspx_th_impact_validateForm_0.setPageMode(pageMode);
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.financials.SpecialNeedsDeterminationCustomValidation");
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\r\n\t");
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          out.write('\r');
          out.write('\n');
          out.write('	');

	  if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
	      String action = ApprovalStatusConversation.DISPLAY_URI;
	      if (GlobalData.isApprovalMode(request)) {
	        action = "/financials/SpecialNeedsDetermination/submitApproval";
	      }

	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatusFinal");
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setForm("frmSpecialNeedsDetermination");
          _jspx_th_impact_ButtonTag_0.setAction(action);
          _jspx_th_impact_ButtonTag_0.setDisabled("false");
          _jspx_th_impact_ButtonTag_0.setTabIndex(tabIndex);
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	  }
	
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td align=\"right\">\r\n\t\t\t\t<a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" onClick=\"hrefDirtyBypass=true;\"\r\n\t\t\t\t\thref=\"javascript:expandAll()\">Expand All</a>&nbsp;\r\n\t\t\t\t<a tabIndex=\"");
          out.print(tabIndex++);
          out.write("\" onClick=\"hrefDirtyBypass=true;\"\r\n\t\t\t\t\thref=\"javascript:collapseAll()\">Collapse All</a>&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tChild Basic Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setName("dspSzNmFirst");
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("First");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue(FormattingHelper.formatString(spNdsDetRetSO.getPersonFirst()));
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setName("dspSzNmMiddle");
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Middle");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue(FormattingHelper.formatString(spNdsDetRetSO.getPersonMiddle()));
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setName("dspSzNmLast");
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Last");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue(FormattingHelper.formatString(spNdsDetRetSO.getPersonLast()));
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setName("dspSzDtBirth");
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("DOB");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue(FormattingHelper.formatDate(spNdsDetRetSO.getPersonDOB()));
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setName("dspSzAge");
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Age");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue(FormattingHelper.formatInt(spNdsDetRetSO.getPersonAge()));
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setName("dspSzGender");
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Gender");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue(Lookup.simpleDecodeSafe(CodesTables.CSEX, spNdsDetRetSO.getPersonGender()));
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setName("dspSzRace");
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Race");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue(FormattingHelper.formatString(spNdsDetRetSO.getPersonRace()));
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setName("dspSzEthnicity");
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Ethnicity");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue(FormattingHelper.formatString(spNdsDetRetSO.getPersonEthnicity()));
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setName("dspSzHomeCounty");
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("HomeCounty");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue(FormattingHelper.formatString(homeCnty));
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setName("dspSzBoardingCounty");
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("BoardingCounty");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue(FormattingHelper.formatString(boardingCnty));
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setName("dspIndIveEligibility");
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("IV-E Eligibility");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue(FormattingHelper.formatString(spNdsDetRetSO.getPersonIVEEligibility()));
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setName("dspDtLstEntryFosterCare");
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Last Entry into Foster Care");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue("".equals(FormattingHelper.formatDate(spNdsDetRetSO.getPersonLstEntryFCare())) ? "N/A" : FormattingHelper.formatDate(spNdsDetRetSO.getPersonLstEntryFCare()));
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setName("dspSzFCPerDiem");
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("FC Per Diem Amt");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue(FormattingHelper.formatMoney(spNdsDetRetSO.getPerDiemRate()));
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_13.setName("dspSzApplicationStatus");
          _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Application Status");
          _jspx_th_impact_validateDisplayOnlyField_13.setValue(applicationStatus);
          int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setName("cbxNonRecOnly");
          _jspx_th_impact_validateInput_1.setLabel("Non-Recurring Only");
          _jspx_th_impact_validateInput_1.setCssClass("formInput");
          _jspx_th_impact_validateInput_1.setType("checkbox");
          _jspx_th_impact_validateInput_1.setDisabled(indDisablecbxNonRecOnly );
          _jspx_th_impact_validateInput_1.setOnClick("enabledisableSpecialNeedsBaseRateRequest(); setNonRecReq();");
          _jspx_th_impact_validateInput_1.setChecked(ArchitectureConstants.Y.equals(FormattingHelper.formatString(spNdsBean.getIndNonRecOnly())) ? "true" : "false" );
          _jspx_th_impact_validateInput_1.setValue( ArchitectureConstants.Y );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t");
 Date dtApproved = spNdsDetRetSO.getDtEventApproved();
			   if(spNdsBean.getDtSpecialNeedsApproved() != null){
			     dtApproved = spNdsBean.getDtSpecialNeedsApproved();
			   }
			   
			 
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_14.setName("dspDtApplicationApproved");
          _jspx_th_impact_validateDisplayOnlyField_14.setLabel("Date Approved");
          _jspx_th_impact_validateDisplayOnlyField_14.setValue(FormattingHelper.formatDate(dtApproved));
          int _jspx_eval_impact_validateDisplayOnlyField_14 = _jspx_th_impact_validateDisplayOnlyField_14.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t&nbsp;\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t");
          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tSpecial Needs Request\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"4\">\r\n\t\t\t\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\tSpecial Needs Type?\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t<td width=\"25%\" colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setChecked(CodesTables.CPLCYCHG_POS.equals(indSpcNdsPrePost) ? "true" : "false");
          _jspx_th_impact_validateInput_2.setDisabled(editableMode);
          _jspx_th_impact_validateInput_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_2.setValue("POS");
          _jspx_th_impact_validateInput_2.setType("radio");
          _jspx_th_impact_validateInput_2.setName("rbCdSpcNeedsPrePost");
          _jspx_th_impact_validateInput_2.setLabel("Post March 1, 2010");
          _jspx_th_impact_validateInput_2.setCssClass("formInput");
          _jspx_th_impact_validateInput_2.setOnClick("submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableSpecialNeedsTypeDropDown()");
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setChecked(CodesTables.CPLCYCHG_PRE.equals(indSpcNdsPrePost) ? "true" : "false");
          _jspx_th_impact_validateInput_3.setDisabled(editableMode);
          _jspx_th_impact_validateInput_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_3.setValue("PRE");
          _jspx_th_impact_validateInput_3.setType("radio");
          _jspx_th_impact_validateInput_3.setName("rbCdSpcNeedsPrePost");
          _jspx_th_impact_validateInput_3.setLabel("Pre March 1, 2010");
          _jspx_th_impact_validateInput_3.setCssClass("formInput");
          _jspx_th_impact_validateInput_3.setOnClick("submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableSpecialNeedsTypeDropDown()");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("");
          _jspx_th_impact_validateSelect_0.setName("rbCIndRsnSpcNeedsReq");
          _jspx_th_impact_validateSelect_0.setValue(indSpNdsReq);
          _jspx_th_impact_validateSelect_0.setDisabled(editableMode);
          _jspx_th_impact_validateSelect_0.setOrderBy("decode");
          _jspx_th_impact_validateSelect_0.setCodesTable("CSPCLTYP");
          _jspx_th_impact_validateSelect_0.setOnChange("enableDateSpcNeedsAprvd();");
          _jspx_th_impact_validateSelect_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateSelect_0.setExcludeOptions(excludeSpecialNeedsTypeList);
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs the child diagnosed Mentally Retarded?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setLabel("Yes");
          _jspx_th_impact_validateInput_4.setId("mentRet_Yes");
          _jspx_th_impact_validateInput_4.setDisabled(editableMode);
          _jspx_th_impact_validateInput_4.setName("rbMentRet");
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildMntRetarded())) ? "true" : "false");
          _jspx_th_impact_validateInput_4.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setLabel("No");
          _jspx_th_impact_validateInput_5.setId("mentRet_No");
          _jspx_th_impact_validateInput_5.setName("rbMentRet");
          _jspx_th_impact_validateInput_5.setDisabled(editableMode);
          _jspx_th_impact_validateInput_5.setValue("N");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndChildMntRetarded())) ? "true" : "false");
          _jspx_th_impact_validateInput_5.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtMentRetDiag");
          _jspx_th_impact_validateTextArea_0.setLabel("If yes, state diagnoses and attach documentation");
          _jspx_th_impact_validateTextArea_0.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_0.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_0.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_0.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          _jspx_th_impact_validateTextArea_0.setColspan("2");
          _jspx_th_impact_validateTextArea_0.setCols("60");
          _jspx_th_impact_validateTextArea_0.setRows("5");
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getTxtCmntsMntRetarded()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs the child diagnosed Visually or Hearing Impaired?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setType("radio");
          _jspx_th_impact_validateInput_6.setLabel("Yes");
          _jspx_th_impact_validateInput_6.setId("vHImpaired_Yes");
          _jspx_th_impact_validateInput_6.setName("rbVHImpaired");
          _jspx_th_impact_validateInput_6.setDisabled(editableMode);
          _jspx_th_impact_validateInput_6.setValue("Y");
          _jspx_th_impact_validateInput_6.setCssClass("formInput");
          _jspx_th_impact_validateInput_6.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildVisHearingImpaired())) ? "true"
                                                                                                           : "false");
          _jspx_th_impact_validateInput_6.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("radio");
          _jspx_th_impact_validateInput_7.setLabel("No");
          _jspx_th_impact_validateInput_7.setId("vHImpaired_No");
          _jspx_th_impact_validateInput_7.setName("rbVHImpaired");
          _jspx_th_impact_validateInput_7.setValue("N");
          _jspx_th_impact_validateInput_7.setDisabled(editableMode);
          _jspx_th_impact_validateInput_7.setCssClass("formInput");
          _jspx_th_impact_validateInput_7.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndChildVisHearingImpaired())) ? "true"
                                                                                                           : "false");
          _jspx_th_impact_validateInput_7.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtVHImpairedDiag");
          _jspx_th_impact_validateTextArea_1.setLabel("If yes, state diagnoses and attach documentation");
          _jspx_th_impact_validateTextArea_1.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_1.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_1.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_1.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          _jspx_th_impact_validateTextArea_1.setColspan("2");
          _jspx_th_impact_validateTextArea_1.setCols("60");
          _jspx_th_impact_validateTextArea_1.setRows("5");
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getTxtCmntsVisHearingImpaired()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs the child Physically Disabled?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("radio");
          _jspx_th_impact_validateInput_8.setLabel("Yes");
          _jspx_th_impact_validateInput_8.setId("phyDisabled_Yes");
          _jspx_th_impact_validateInput_8.setName("rbPhyDisabled");
          _jspx_th_impact_validateInput_8.setValue("Y");
          _jspx_th_impact_validateInput_8.setDisabled(editableMode);
          _jspx_th_impact_validateInput_8.setCssClass("formInput");
          _jspx_th_impact_validateInput_8.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildPhysicallyDisabled())) ? "true"
                                                                                                           : "false");
          _jspx_th_impact_validateInput_8.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("radio");
          _jspx_th_impact_validateInput_9.setLabel("No");
          _jspx_th_impact_validateInput_9.setId("phyDisabled_No");
          _jspx_th_impact_validateInput_9.setName("rbPhyDisabled");
          _jspx_th_impact_validateInput_9.setDisabled(editableMode);
          _jspx_th_impact_validateInput_9.setValue("N");
          _jspx_th_impact_validateInput_9.setCssClass("formInput");
          _jspx_th_impact_validateInput_9.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndChildPhysicallyDisabled())) ? "true"
                                                                                                           : "false");
          _jspx_th_impact_validateInput_9.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtPhyDisabledDiag");
          _jspx_th_impact_validateTextArea_2.setLabel("If yes, state diagnoses and attach documentation");
          _jspx_th_impact_validateTextArea_2.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_2.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_2.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_2.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          _jspx_th_impact_validateTextArea_2.setColspan("2");
          _jspx_th_impact_validateTextArea_2.setCols("60");
          _jspx_th_impact_validateTextArea_2.setRows("5");
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getTxtCmntsPhysicallyDisabled()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_2.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs the child diagnosed Emotionally Disturbed?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("radio");
          _jspx_th_impact_validateInput_10.setLabel("Yes");
          _jspx_th_impact_validateInput_10.setId("emDisturbed_Yes");
          _jspx_th_impact_validateInput_10.setName("rbEmDisturbed");
          _jspx_th_impact_validateInput_10.setDisabled(editableMode);
          _jspx_th_impact_validateInput_10.setValue("Y");
          _jspx_th_impact_validateInput_10.setCssClass("formInput");
          _jspx_th_impact_validateInput_10.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildEmotionallyDisabled())) ? "true"
                                                                                                            : "false");
          _jspx_th_impact_validateInput_10.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("radio");
          _jspx_th_impact_validateInput_11.setLabel("No");
          _jspx_th_impact_validateInput_11.setId("emDisturbed_No");
          _jspx_th_impact_validateInput_11.setName("rbEmDisturbed");
          _jspx_th_impact_validateInput_11.setDisabled(editableMode);
          _jspx_th_impact_validateInput_11.setValue("N");
          _jspx_th_impact_validateInput_11.setCssClass("formInput");
          _jspx_th_impact_validateInput_11.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndChildEmotionallyDisabled())) ? "true"
                                                                                                            : "false");
          _jspx_th_impact_validateInput_11.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtEmDisturbedDiag");
          _jspx_th_impact_validateTextArea_3.setLabel("If yes, state diagnoses and attach documentation");
          _jspx_th_impact_validateTextArea_3.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_3.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_3.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_3.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_3.setMaxLength(300);
          _jspx_th_impact_validateTextArea_3.setColspan("2");
          _jspx_th_impact_validateTextArea_3.setCols("60");
          _jspx_th_impact_validateTextArea_3.setRows("5");
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getTxtCmntsEmotionallyDisabled()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs the child diagnosed with other Medical condition(s)?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("radio");
          _jspx_th_impact_validateInput_12.setLabel("Yes");
          _jspx_th_impact_validateInput_12.setId("othMedCondition_Yes");
          _jspx_th_impact_validateInput_12.setName("rbOthMedCondition");
          _jspx_th_impact_validateInput_12.setDisabled(editableMode);
          _jspx_th_impact_validateInput_12.setValue("Y");
          _jspx_th_impact_validateInput_12.setCssClass("formInput");
          _jspx_th_impact_validateInput_12.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildOtherMedical())) ? "true"
                                                                                                     : "false");
          _jspx_th_impact_validateInput_12.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("No");
          _jspx_th_impact_validateInput_13.setId("othMedCondition_No");
          _jspx_th_impact_validateInput_13.setName("rbOthMedCondition");
          _jspx_th_impact_validateInput_13.setDisabled(editableMode);
          _jspx_th_impact_validateInput_13.setValue("N");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndChildOtherMedical())) ? "true"
                                                                                                     : "false");
          _jspx_th_impact_validateInput_13.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName("txtOthMedCondition");
          _jspx_th_impact_validateTextArea_4.setLabel("If yes, state diagnoses and attach documentation");
          _jspx_th_impact_validateTextArea_4.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_4.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_4.setConstraint("Paragraph300");
          _jspx_th_impact_validateTextArea_4.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_4.setMaxLength(300);
          _jspx_th_impact_validateTextArea_4.setColspan("2");
          _jspx_th_impact_validateTextArea_4.setCols("60");
          _jspx_th_impact_validateTextArea_4.setRows("5");
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getTxtCmntsOtherMedical()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setName("txtAdditionalComments");
          _jspx_th_impact_validateTextArea_5.setLabel("Additional Comments");
          _jspx_th_impact_validateTextArea_5.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_5.setConstraint("Paragraph1000");
          _jspx_th_impact_validateTextArea_5.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_5.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_5.setColspan("2");
          _jspx_th_impact_validateTextArea_5.setCols("60");
          _jspx_th_impact_validateTextArea_5.setRows("5");
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getAddComments()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tBasic Rate Request\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs a Basic Adoption Assistance Rate being requested for this child?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("Yes");
          _jspx_th_impact_validateInput_14.setId("specRateReq_Yes");
          _jspx_th_impact_validateInput_14.setName("rbBasicRateReq");
          _jspx_th_impact_validateInput_14.setDisabled(editableMode);
          _jspx_th_impact_validateInput_14.setValue("Y");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndBasicRateReq())) ? "true" : "false");
          _jspx_th_impact_validateInput_14.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_14.setOnClick("disableSpecialRatesAndServices(); enableDisableBasicRateType(); ");
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setLabel("No");
          _jspx_th_impact_validateInput_15.setId("specRateReq_No");
          _jspx_th_impact_validateInput_15.setName("rbBasicRateReq");
          _jspx_th_impact_validateInput_15.setDisabled(editableMode);
          _jspx_th_impact_validateInput_15.setValue("N");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndBasicRateReq())) ? "true" : "false");
          _jspx_th_impact_validateInput_15.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_15.setOnClick("disableSpecialRatesAndServices(); enableDisableBasicRateType(); ");
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

		          // If in a pending or approved status, show the approval section
		        
          out.write('\r');
          out.write('\n');
          out.write('	');

	          if ((CodesTables.CEVTSTAT_PEND.equals(eventStatus) && canModifyApprovalSections) || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
	        
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_0.setName("approval_basic");
          _jspx_th_impact_ExpandableSectionTag_0.setLabel("Approval");
          _jspx_th_impact_ExpandableSectionTag_0.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_0.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_0 = _jspx_th_impact_ExpandableSectionTag_0.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t");

	          if (CodesTables.CSTAGES_PAD.equals(cdStage)) { // SMS#97845 MR-074-2 AFCARS: add incident status selection for application in PAD only
	        
              out.write("\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\tIncident/Non-Incident Status\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_16.setType("radio");
              _jspx_th_impact_validateInput_16.setLabel("Non-Incident Child");
              _jspx_th_impact_validateInput_16.setId("nonIncChild");
              _jspx_th_impact_validateInput_16.setName("rbIncNonIncStatus");
              _jspx_th_impact_validateInput_16.setDisabled(disableIncidentStatus);
              _jspx_th_impact_validateInput_16.setValue("N");
              _jspx_th_impact_validateInput_16.setCssClass("formInput");
              _jspx_th_impact_validateInput_16.setChecked("N".equals(FormattingHelper.formatString(spNdsDetRetSO.getIndIncidentChild())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_16.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
              if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp;\r\n\t\t\t\t\t<a href=\"javaScript:stayHere()\"\r\n\t\t\t\t\t\tonClick=\"hrefDirtyBypass=true;displayIncidentStatusHelpText('At the time of adoption finalization, the child is NOT in the custody of the State/DHS.','Non-Incident Child');\">?</a>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_17.setType("radio");
              _jspx_th_impact_validateInput_17.setLabel("Incident/DFCS Child");
              _jspx_th_impact_validateInput_17.setId("incDFCSChild");
              _jspx_th_impact_validateInput_17.setName("rbIncNonIncStatus");
              _jspx_th_impact_validateInput_17.setValue("Y");
              _jspx_th_impact_validateInput_17.setDisabled(disableIncidentStatus);
              _jspx_th_impact_validateInput_17.setCssClass("formInput");
              _jspx_th_impact_validateInput_17.setChecked("Y".equals(FormattingHelper.formatString(spNdsDetRetSO.getIndIncidentChild())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_17.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
              if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp;\r\n\t\t\t\t\t<a href=\"javaScript:stayHere()\"\r\n\t\t\t\t\t\tonClick=\"hrefDirtyBypass=true;displayIncidentStatusHelpText('At the time of adoption finalization, the child is in the custody of the State/DHS.','Incident/DFCS Child');\">?</a>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t");

	          }
	        
              out.write("\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"5\">\r\n\t\t\t\t\t<a NAME=\"gohere\"> Special Needs Determination - Approval </a>\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\tIs the Special Needs Determination request approved?\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_18.setType("radio");
              _jspx_th_impact_validateInput_18.setLabel("Yes");
              _jspx_th_impact_validateInput_18.setId("spNdDetReqApprv_Yes");
              _jspx_th_impact_validateInput_18.setName("rbSpNdDetReqApprv");
              _jspx_th_impact_validateInput_18.setDisabled(disabled);
              _jspx_th_impact_validateInput_18.setValue("Y");
              _jspx_th_impact_validateInput_18.setCssClass("formInput");
              _jspx_th_impact_validateInput_18.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpcNeedsApproved())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_18.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
              if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_19.setType("radio");
              _jspx_th_impact_validateInput_19.setLabel("No");
              _jspx_th_impact_validateInput_19.setId("spNdDetReqApprv_No");
              _jspx_th_impact_validateInput_19.setName("rbSpNdDetReqApprv");
              _jspx_th_impact_validateInput_19.setValue("N");
              _jspx_th_impact_validateInput_19.setDisabled(disabled);
              _jspx_th_impact_validateInput_19.setCssClass("formInput");
              _jspx_th_impact_validateInput_19.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndSpcNeedsApproved())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_19.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
              if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_20.setType("radio");
              _jspx_th_impact_validateInput_20.setLabel("Defer");
              _jspx_th_impact_validateInput_20.setId("spNdDetReqApprv_Defer");
              _jspx_th_impact_validateInput_20.setName("rbSpNdDetReqApprv");
              _jspx_th_impact_validateInput_20.setValue("D");
              _jspx_th_impact_validateInput_20.setDisabled(disabled);
              _jspx_th_impact_validateInput_20.setCssClass("formInput");
              _jspx_th_impact_validateInput_20.setChecked("D".equals(FormattingHelper.formatString(spNdsBean.getIndSpcNeedsApproved())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_20.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
              if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\tAgreement Type:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_21.setType("radio");
              _jspx_th_impact_validateInput_21.setLabel("Initial");
              _jspx_th_impact_validateInput_21.setId("agrmtType_Initial");
              _jspx_th_impact_validateInput_21.setName("rbAgrmtType");
              _jspx_th_impact_validateInput_21.setDisabled(disabled);
              _jspx_th_impact_validateInput_21.setCssClass("formInput");
              _jspx_th_impact_validateInput_21.setValue(SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_INITIAL);
              _jspx_th_impact_validateInput_21.setChecked(SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_INITIAL.equals(
													FormattingHelper.formatString(spNdsBean.getIndAgrmtType())) ? "true" : "false");
              _jspx_th_impact_validateInput_21.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
              if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_22.setType("radio");
              _jspx_th_impact_validateInput_22.setLabel("Amended");
              _jspx_th_impact_validateInput_22.setId("agrmtType_Amended");
              _jspx_th_impact_validateInput_22.setName("rbAgrmtType");
              _jspx_th_impact_validateInput_22.setValue(SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_AMENDED);
              _jspx_th_impact_validateInput_22.setDisabled(disabled);
              _jspx_th_impact_validateInput_22.setCssClass("formInput");
              _jspx_th_impact_validateInput_22.setChecked(SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_AMENDED.equals(
													FormattingHelper.formatString(spNdsBean.getIndAgrmtType())) ? "true" : "false");
              _jspx_th_impact_validateInput_22.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
              if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<!-- SMS#109403: moved Date Approved field from bottom of the section to emphasize this field applies to the entire Approval section -->\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDate_0.setName("txtDtSpecialNeedsApprvd");
              _jspx_th_impact_validateDate_0.setLabel("Date Approved");
              _jspx_th_impact_validateDate_0.setConstraint("Date");
              _jspx_th_impact_validateDate_0.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_0.setValue(FormattingHelper.formatDate(spNdsBean.getDtSpecialNeedsApproved()));
              _jspx_th_impact_validateDate_0.setDisabled(disabled);
              int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
              if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_1.setStyle("WIDTH: 380px");
              _jspx_th_impact_validateSelect_1.setLabel("Funding Type");
              _jspx_th_impact_validateSelect_1.setName("selSzCdFundingType");
              _jspx_th_impact_validateSelect_1.setValue(FormattingHelper.formatString(fundingType));
              _jspx_th_impact_validateSelect_1.setDisabled(disabled);
              _jspx_th_impact_validateSelect_1.setCodesTable("CAAFDTYP");
              _jspx_th_impact_validateSelect_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_1.setExcludeOptions(excludeOption);
              int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
              if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#8225;</span>Approval Type:\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\"></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\" width=\"25%\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_23.setChecked(CodesTables.CPLCYCHG_POS.equals(indSpcNdsPrePostAppr) ? "true" : "false");
              _jspx_th_impact_validateInput_23.setDisabled(disabled);
              _jspx_th_impact_validateInput_23.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_23.setValue("POS");
              _jspx_th_impact_validateInput_23.setType("radio");
              _jspx_th_impact_validateInput_23.setName("rbCdSpcNeedsPrePostAppr");
              _jspx_th_impact_validateInput_23.setLabel("Post March 1, 2010");
              _jspx_th_impact_validateInput_23.setCssClass("formInput");
              _jspx_th_impact_validateInput_23.setOnClick("submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableApprovalTypeDropDown()");
              int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
              if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_24.setChecked(CodesTables.CPLCYCHG_PRE.equals(indSpcNdsPrePostAppr) ? "true" : "false");
              _jspx_th_impact_validateInput_24.setDisabled(disabled);
              _jspx_th_impact_validateInput_24.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_24.setValue("PRE");
              _jspx_th_impact_validateInput_24.setType("radio");
              _jspx_th_impact_validateInput_24.setName("rbCdSpcNeedsPrePostAppr");
              _jspx_th_impact_validateInput_24.setLabel("Pre March 1, 2010");
              _jspx_th_impact_validateInput_24.setCssClass("formInput");
              _jspx_th_impact_validateInput_24.setOnClick("submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableApprovalTypeDropDown()");
              int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
              if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateSelect_2.setLabel("");
              _jspx_th_impact_validateSelect_2.setName("rbApprovalType");
              _jspx_th_impact_validateSelect_2.setValue(indSpNdsAppr);
              _jspx_th_impact_validateSelect_2.setDisabled(disabled);
              _jspx_th_impact_validateSelect_2.setOrderBy("decode");
              _jspx_th_impact_validateSelect_2.setCodesTable("CSPCLTYP");
              _jspx_th_impact_validateSelect_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateSelect_2.setExcludeOptions(excludeSpecialNeedsTypeApprList);
              int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
              if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_25.setLabel("Mentally Retarded");
              _jspx_th_impact_validateInput_25.setName("cbxMentRetarded");
              _jspx_th_impact_validateInput_25.setType("checkbox");
              _jspx_th_impact_validateInput_25.setValue("Y");
              _jspx_th_impact_validateInput_25.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvMntRetarded())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_25.setDisabled(disabled);
              _jspx_th_impact_validateInput_25.setCssClass("formInput");
              _jspx_th_impact_validateInput_25.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
              if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_26.setLabel("Visually or Hearing Impaired");
              _jspx_th_impact_validateInput_26.setName("cbxVHImpaired");
              _jspx_th_impact_validateInput_26.setType("checkbox");
              _jspx_th_impact_validateInput_26.setValue("Y");
              _jspx_th_impact_validateInput_26.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvHearingImpaired())) ? "true"
                                                                                                            : "false");
              _jspx_th_impact_validateInput_26.setDisabled(disabled);
              _jspx_th_impact_validateInput_26.setCssClass("formInput");
              _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
              if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_27.setLabel("Physically Disabled");
              _jspx_th_impact_validateInput_27.setName("cbxPhysDisabled");
              _jspx_th_impact_validateInput_27.setType("checkbox");
              _jspx_th_impact_validateInput_27.setValue("Y");
              _jspx_th_impact_validateInput_27.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvPhysicallyDisabled())) ? "true"
                                                                                                               : "false");
              _jspx_th_impact_validateInput_27.setDisabled(disabled);
              _jspx_th_impact_validateInput_27.setCssClass("formInput");
              _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
              if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_28.setLabel("Emotionally Disturbed");
              _jspx_th_impact_validateInput_28.setName("cbxEmDisturbed");
              _jspx_th_impact_validateInput_28.setType("checkbox");
              _jspx_th_impact_validateInput_28.setValue("Y");
              _jspx_th_impact_validateInput_28.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvEmotionalDist())) ? "true"
                                                                                                          : "false");
              _jspx_th_impact_validateInput_28.setDisabled(disabled);
              _jspx_th_impact_validateInput_28.setCssClass("formInput");
              _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
              if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_29.setLabel("Other Medical Conditions");
              _jspx_th_impact_validateInput_29.setName("cbxOthMedCond");
              _jspx_th_impact_validateInput_29.setType("checkbox");
              _jspx_th_impact_validateInput_29.setValue("Y");
              _jspx_th_impact_validateInput_29.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvOther())) ? "true" : "false");
              _jspx_th_impact_validateInput_29.setDisabled(disabled);
              _jspx_th_impact_validateInput_29.setCssClass("formInput");
              _jspx_th_impact_validateInput_29.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
              if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t<b> Basic Rate - Type </b>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"5\">\r\n\t\t\t\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\" border=\"0\">\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td width=\"35%\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_30.setType("radio");
              _jspx_th_impact_validateInput_30.setLabel("Negotiated Post July 1, 2009 Rate");
              _jspx_th_impact_validateInput_30.setId("cdBasicRateType_Pos");
              _jspx_th_impact_validateInput_30.setName("cdBasicRateType");
              _jspx_th_impact_validateInput_30.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_30.setDisabled(disabled);
              _jspx_th_impact_validateInput_30.setValue("POS");
              _jspx_th_impact_validateInput_30.setCssClass("formInput");
              _jspx_th_impact_validateInput_30.setChecked(CodesTables.CBRTYPE_POS.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType())) ? "true"
                                                                                                        : "false");
              _jspx_th_impact_validateInput_30.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_30.setOnClick("emptyCountyAddOnCustom(); populateTotalMonthly();");
              int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
              if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_15.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_15.setName("dspNbrPostBasicAmt");
              _jspx_th_impact_validateDisplayOnlyField_15.setLabel("");
              _jspx_th_impact_validateDisplayOnlyField_15.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrPostBasicAmt()));
              int _jspx_eval_impact_validateDisplayOnlyField_15 = _jspx_th_impact_validateDisplayOnlyField_15.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td width=\"35%\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_31.setType("radio");
              _jspx_th_impact_validateInput_31.setLabel("Negotiated Pre July 1, 2009 Rate");
              _jspx_th_impact_validateInput_31.setId("cdBasicRateType_Pre");
              _jspx_th_impact_validateInput_31.setName("cdBasicRateType");
              _jspx_th_impact_validateInput_31.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_31.setValue("PRE");
              _jspx_th_impact_validateInput_31.setDisabled(disabled);
              _jspx_th_impact_validateInput_31.setCssClass("formInput");
              _jspx_th_impact_validateInput_31.setChecked(CodesTables.CBRTYPE_PRE.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_31.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_31.setOnClick("emptyCustom(); populateTotalMonthly(); enableCountyAddOn();");
              int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
              if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_16.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_16.setName("dspNbrPreBasicAmt");
              _jspx_th_impact_validateDisplayOnlyField_16.setLabel("");
              _jspx_th_impact_validateDisplayOnlyField_16.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrPreBasicAmt()));
              int _jspx_eval_impact_validateDisplayOnlyField_16 = _jspx_th_impact_validateDisplayOnlyField_16.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td width=\"35%\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_32.setType("text");
              _jspx_th_impact_validateInput_32.setLabel("County Add On(Daily)");
              _jspx_th_impact_validateInput_32.setConstraint("Money");
              _jspx_th_impact_validateInput_32.setName("txtNbrCountyAddonAmt");
              _jspx_th_impact_validateInput_32.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_32.setCssClass("formInput");
              _jspx_th_impact_validateInput_32.setDisabled(disabled);
              _jspx_th_impact_validateInput_32.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrCountyAddonAmt()));
              _jspx_th_impact_validateInput_32.setSize("10");
              _jspx_th_impact_validateInput_32.setMaxLength("10");
              _jspx_th_impact_validateInput_32.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_32.setOnChange("populateTotalMonthly();");
              int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
              if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td width=\"35%\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_33.setType("radio");
              _jspx_th_impact_validateInput_33.setLabel("Negotiated Custom Rate");
              _jspx_th_impact_validateInput_33.setId("cdBasicRateType_Cus");
              _jspx_th_impact_validateInput_33.setName("cdBasicRateType");
              _jspx_th_impact_validateInput_33.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_33.setValue("CUS");
              _jspx_th_impact_validateInput_33.setDisabled(disabled);
              _jspx_th_impact_validateInput_33.setCssClass("formInput");
              _jspx_th_impact_validateInput_33.setChecked(CodesTables.CBRTYPE_CUS.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType())) ? "true"
                                                                                                : "false");
              _jspx_th_impact_validateInput_33.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_33.setOnClick("emptyCountyAddon(); populateTotalMonthly(); enableCustom();");
              int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
              if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t");
if (cusSelected) {
              out.write("\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_34.setType("text");
              _jspx_th_impact_validateInput_34.setLabel("");
              _jspx_th_impact_validateInput_34.setConstraint("Money");
              _jspx_th_impact_validateInput_34.setName("txtNbrCustomAmt");
              _jspx_th_impact_validateInput_34.setCssClass("formInput");
              _jspx_th_impact_validateInput_34.setDisabled(disabled);
              _jspx_th_impact_validateInput_34.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrBasicAmt()));
              _jspx_th_impact_validateInput_34.setSize("10");
              _jspx_th_impact_validateInput_34.setMaxLength("10");
              _jspx_th_impact_validateInput_34.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_34.setOnChange("populateTotalMonthly();");
              int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
              if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t");
}else { 
              out.write("\r\n\t\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateInput_35.setType("text");
              _jspx_th_impact_validateInput_35.setLabel("");
              _jspx_th_impact_validateInput_35.setConstraint("Money");
              _jspx_th_impact_validateInput_35.setName("txtNbrCustomAmt");
              _jspx_th_impact_validateInput_35.setCssClass("formInput");
              _jspx_th_impact_validateInput_35.setDisabled(disabled);
              _jspx_th_impact_validateInput_35.setValue(FormattingHelper.formatMoney(0));
              _jspx_th_impact_validateInput_35.setSize("10");
              _jspx_th_impact_validateInput_35.setMaxLength("10");
              _jspx_th_impact_validateInput_35.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_35.setOnChange("populateTotalMonthly();");
              int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
              if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t");
} 
              out.write("\r\n\t\t\t\t\t\t</tr>\r\n\r\n\t\t\t\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t\t\t\t<td width=\"35%\">\r\n\t\t\t\t\t\t\t\t");
              //  impact:validateDisplayOnlyField
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
              _jspx_th_impact_validateDisplayOnlyField_17.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDisplayOnlyField_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_0);
              _jspx_th_impact_validateDisplayOnlyField_17.setName("dspTotalMonthlyAmt");
              _jspx_th_impact_validateDisplayOnlyField_17.setLabel("Total Monthly Amount");
              _jspx_th_impact_validateDisplayOnlyField_17.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrMonthlyAmt()));
              int _jspx_eval_impact_validateDisplayOnlyField_17 = _jspx_th_impact_validateDisplayOnlyField_17.doStartTag();
              if (_jspx_th_impact_validateDisplayOnlyField_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t\t<td></td>\r\n\t\t\t\t\t\t</tr>\r\n\t\t\t\t\t</table>\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

	       } // End Basic Approval Section
	     
          out.write("\r\n\r\n\r\n\t<br>\r\n\t<!-- -Specialized Rate Adoption Assistance Requests -->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tSpecialized Rate Request\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs a Specialized Rate being requested for this child?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("radio");
          _jspx_th_impact_validateInput_36.setLabel("Yes");
          _jspx_th_impact_validateInput_36.setId("specRateReq_Yes");
          _jspx_th_impact_validateInput_36.setName("rbSpecRateReq");
          _jspx_th_impact_validateInput_36.setDisabled(editableMode);
          _jspx_th_impact_validateInput_36.setValue("Y");
          _jspx_th_impact_validateInput_36.setCssClass("formInput");
          _jspx_th_impact_validateInput_36.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpecializedRateReq())) ? "true"
                                                                                                      : "false");
          _jspx_th_impact_validateInput_36.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("radio");
          _jspx_th_impact_validateInput_37.setLabel("No");
          _jspx_th_impact_validateInput_37.setId("specRateReq_No");
          _jspx_th_impact_validateInput_37.setName("rbSpecRateReq");
          _jspx_th_impact_validateInput_37.setDisabled(editableMode);
          _jspx_th_impact_validateInput_37.setValue("N");
          _jspx_th_impact_validateInput_37.setCssClass("formInput");
          _jspx_th_impact_validateInput_37.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndSpecializedRateReq())) ? "true"
                                                                                                      : "false");
          _jspx_th_impact_validateInput_37.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs the child receiving Specialized Foster Care (SFC) Per Diem, RBWO\r\n\t\t\t\trate (Child Caring Institution) or RBWO Waiver rate (Child Placing\r\n\t\t\t\tAgency)?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setType("radio");
          _jspx_th_impact_validateInput_38.setLabel("Yes");
          _jspx_th_impact_validateInput_38.setId("rbSFCorRBWO_Yes");
          _jspx_th_impact_validateInput_38.setName("rbSFCorRBWO");
          _jspx_th_impact_validateInput_38.setDisabled(editableMode);
          _jspx_th_impact_validateInput_38.setValue("Y");
          _jspx_th_impact_validateInput_38.setCssClass("formInput");
          _jspx_th_impact_validateInput_38.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndSFCorRBWO())) ? "true" : "false");
          _jspx_th_impact_validateInput_38.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setType("radio");
          _jspx_th_impact_validateInput_39.setLabel("No");
          _jspx_th_impact_validateInput_39.setId("rbSFCorRBWO_No");
          _jspx_th_impact_validateInput_39.setName("rbSFCorRBWO");
          _jspx_th_impact_validateInput_39.setDisabled(editableMode);
          _jspx_th_impact_validateInput_39.setValue("N");
          _jspx_th_impact_validateInput_39.setCssClass("formInput");
          _jspx_th_impact_validateInput_39.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndSFCorRBWO())) ? "true" : "false");
          _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span>Check all\r\n\t\t\t\tdocumentation being attached:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setLabel("Psychological Evaluation (within last 2 years)");
          _jspx_th_impact_validateInput_40.setName("cbxPsychological");
          _jspx_th_impact_validateInput_40.setType("checkbox");
          _jspx_th_impact_validateInput_40.setDisabled(editableMode);
          _jspx_th_impact_validateInput_40.setValue("Y");
          _jspx_th_impact_validateInput_40.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocPsychological())) ? "true" : "false");
          _jspx_th_impact_validateInput_40.setCssClass("formInput");
          _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setLabel("Developmental Assessment/Evaluation(within last year)");
          _jspx_th_impact_validateInput_41.setName("cbxDevAssmtEval");
          _jspx_th_impact_validateInput_41.setType("checkbox");
          _jspx_th_impact_validateInput_41.setValue("Y");
          _jspx_th_impact_validateInput_41.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocDevelopmentalAssmt())) ? "true"
                                                                                                         : "false");
          _jspx_th_impact_validateInput_41.setDisabled(editableMode);
          _jspx_th_impact_validateInput_41.setCssClass("formInput");
          _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setLabel("Documentation from Treatment provider(within last 90 days)");
          _jspx_th_impact_validateInput_42.setName("cbxTrtmntPrvdr");
          _jspx_th_impact_validateInput_42.setType("checkbox");
          _jspx_th_impact_validateInput_42.setValue("Y");
          _jspx_th_impact_validateInput_42.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocTrtmntPrvdr())) ? "true" : "false");
          _jspx_th_impact_validateInput_42.setDisabled(editableMode);
          _jspx_th_impact_validateInput_42.setCssClass("formInput");
          _jspx_th_impact_validateInput_42.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setLabel("Medical Assessment(within last 90 days)");
          _jspx_th_impact_validateInput_43.setName("cbxMedAssmnt");
          _jspx_th_impact_validateInput_43.setType("checkbox");
          _jspx_th_impact_validateInput_43.setValue("Y");
          _jspx_th_impact_validateInput_43.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocMentalAssmt())) ? "true" : "false");
          _jspx_th_impact_validateInput_43.setDisabled(editableMode);
          _jspx_th_impact_validateInput_43.setCssClass("formInput");
          _jspx_th_impact_validateInput_43.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td></td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setLabel("SSI Documentation");
          _jspx_th_impact_validateInput_44.setName("cbxSSI");
          _jspx_th_impact_validateInput_44.setType("checkbox");
          _jspx_th_impact_validateInput_44.setValue("Y");
          _jspx_th_impact_validateInput_44.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocSSI())) ? "true" : "false");
          _jspx_th_impact_validateInput_44.setDisabled(editableMode);
          _jspx_th_impact_validateInput_44.setCssClass("formInput");
          _jspx_th_impact_validateInput_44.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t</table>\r\n\t<br>\r\n\r\n\t<!-- Non-Recurring Request-->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tNon-Recurring Request\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\tIs a Non-Recurring/510 Funding Type being requested for this child?\r\n\t\t\t</td>\r\n\t\t\t<td colspan=\"1\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setType("radio");
          _jspx_th_impact_validateInput_45.setLabel("Yes");
          _jspx_th_impact_validateInput_45.setId("nonRecReq_Yes");
          _jspx_th_impact_validateInput_45.setName("rbNonRecReq");
          _jspx_th_impact_validateInput_45.setDisabled(disableNonRecurring);
          _jspx_th_impact_validateInput_45.setValue("Y");
          _jspx_th_impact_validateInput_45.setCssClass("formInput");
          _jspx_th_impact_validateInput_45.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecRequested())) ? "true" : "false");
          _jspx_th_impact_validateInput_45.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_45.setOnClick("enableNonRec(); setHdnNonRecReq('Y');");
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_46.setType("radio");
          _jspx_th_impact_validateInput_46.setLabel("No");
          _jspx_th_impact_validateInput_46.setId("nonRecReq_No");
          _jspx_th_impact_validateInput_46.setName("rbNonRecReq");
          _jspx_th_impact_validateInput_46.setDisabled(disableNonRecurring);
          _jspx_th_impact_validateInput_46.setValue("N");
          _jspx_th_impact_validateInput_46.setCssClass("formInput");
          _jspx_th_impact_validateInput_46.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecRequested())) ? "true" : "false");
          _jspx_th_impact_validateInput_46.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_46.setOnClick("disableNonRec(); setHdnNonRecReq('N');");
          int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
          if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_47 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_47.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_47.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_47.setType("hidden");
          _jspx_th_impact_validateInput_47.setName("hdnNonRecReq");
          _jspx_th_impact_validateInput_47.setValue(FormattingHelper.formatString(spNdsBean.getIndNonRecRequested()) );
          int _jspx_eval_impact_validateInput_47 = _jspx_th_impact_validateInput_47.doStartTag();
          if (_jspx_th_impact_validateInput_47.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</tr>\r\n\t\t<tr class=\"subDetail\">\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_48 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_48.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_48.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_48.setType("text");
          _jspx_th_impact_validateInput_48.setLabel( totalNonRecLable );
          _jspx_th_impact_validateInput_48.setConstraint("Money");
          _jspx_th_impact_validateInput_48.setName("txtNonRecAmtReq");
          _jspx_th_impact_validateInput_48.setCssClass("formInput");
          _jspx_th_impact_validateInput_48.setDisabled(disableNonRecurring);
          _jspx_th_impact_validateInput_48.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrNonRecAmt()));
          _jspx_th_impact_validateInput_48.setSize("10");
          _jspx_th_impact_validateInput_48.setMaxLength("10");
          _jspx_th_impact_validateInput_48.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_48 = _jspx_th_impact_validateInput_48.doStartTag();
          if (_jspx_th_impact_validateInput_48.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\r\n\t<!-- Special Services Request -->\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\t\tclass=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"4\">\r\n\t\t\t\tSpecial Services Request\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tIs a Special Service being requested for this child?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_49 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_49.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_49.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_49.setType("radio");
          _jspx_th_impact_validateInput_49.setLabel("Yes");
          _jspx_th_impact_validateInput_49.setId("specServiceReq_Yes");
          _jspx_th_impact_validateInput_49.setName("rbSpecServiceReq");
          _jspx_th_impact_validateInput_49.setDisabled(editableMode);
          _jspx_th_impact_validateInput_49.setValue("Y");
          _jspx_th_impact_validateInput_49.setCssClass("formInput");
          _jspx_th_impact_validateInput_49.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpclServiceReq())) ? "true" : "false");
          _jspx_th_impact_validateInput_49.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_49.setOnClick("enableSpcSrvReq()");
          int _jspx_eval_impact_validateInput_49 = _jspx_th_impact_validateInput_49.doStartTag();
          if (_jspx_th_impact_validateInput_49.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_50 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_50.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_50.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_50.setType("radio");
          _jspx_th_impact_validateInput_50.setLabel("No");
          _jspx_th_impact_validateInput_50.setId("specServiceReq_No");
          _jspx_th_impact_validateInput_50.setName("rbSpecServiceReq");
          _jspx_th_impact_validateInput_50.setDisabled(editableMode);
          _jspx_th_impact_validateInput_50.setValue("N");
          _jspx_th_impact_validateInput_50.setCssClass("formInput");
          _jspx_th_impact_validateInput_50.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndSpclServiceReq())) ? "true" : "false");
          _jspx_th_impact_validateInput_50.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_50.setOnClick("disableSpcSrvReq()");
          int _jspx_eval_impact_validateInput_50 = _jspx_th_impact_validateInput_50.doStartTag();
          if (_jspx_th_impact_validateInput_50.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\tHas all required documentation been attached?\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_51 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_51.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_51.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_51.setType("radio");
          _jspx_th_impact_validateInput_51.setLabel("Yes");
          _jspx_th_impact_validateInput_51.setId("indDocAttached_Yes");
          _jspx_th_impact_validateInput_51.setName("rbIndDocAttached");
          _jspx_th_impact_validateInput_51.setDisabled(editableMode);
          _jspx_th_impact_validateInput_51.setValue("Y");
          _jspx_th_impact_validateInput_51.setCssClass("formInput");
          _jspx_th_impact_validateInput_51.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndAllSpecialDocAttached())) ? "true"
                                                                                                         : "false");
          _jspx_th_impact_validateInput_51.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_51 = _jspx_th_impact_validateInput_51.doStartTag();
          if (_jspx_th_impact_validateInput_51.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_52 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_52.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_52.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_52.setType("radio");
          _jspx_th_impact_validateInput_52.setLabel("No");
          _jspx_th_impact_validateInput_52.setId("indDocAttached_No");
          _jspx_th_impact_validateInput_52.setName("rbIndDocAttached");
          _jspx_th_impact_validateInput_52.setDisabled(editableMode);
          _jspx_th_impact_validateInput_52.setValue("N");
          _jspx_th_impact_validateInput_52.setCssClass("formInput");
          _jspx_th_impact_validateInput_52.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndAllSpecialDocAttached())) ? "true"
                                                                                                         : "false");
          _jspx_th_impact_validateInput_52.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_52 = _jspx_th_impact_validateInput_52.doStartTag();
          if (_jspx_th_impact_validateInput_52.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_53 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_53.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_53.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_53.setType("text");
          _jspx_th_impact_validateInput_53.setLabel("Requested Amount");
          _jspx_th_impact_validateInput_53.setConstraint("Money");
          _jspx_th_impact_validateInput_53.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_53.setName("txtSzReqAmt");
          _jspx_th_impact_validateInput_53.setCssClass("formInput");
          _jspx_th_impact_validateInput_53.setDisabled(editableMode);
          _jspx_th_impact_validateInput_53.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrReqAmt()));
          _jspx_th_impact_validateInput_53.setSize("10");
          _jspx_th_impact_validateInput_53.setMaxLength("10");
          _jspx_th_impact_validateInput_53.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_53 = _jspx_th_impact_validateInput_53.doStartTag();
          if (_jspx_th_impact_validateInput_53.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_3.setStyle("WIDTH: 320px");
          _jspx_th_impact_validateSelect_3.setLabel("Special Service Type");
          _jspx_th_impact_validateSelect_3.setName("selSzCdSpecServType");
          _jspx_th_impact_validateSelect_3.setConditionallyRequired("true");
          _jspx_th_impact_validateSelect_3.setValue(FormattingHelper.formatString(spNdsBean.getCdSpclSerType()));
          _jspx_th_impact_validateSelect_3.setDisabled(editableMode);
          _jspx_th_impact_validateSelect_3.setCodesTable("CSPLSERV");
          _jspx_th_impact_validateSelect_3.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateSelect_3 = _jspx_th_impact_validateSelect_3.doStartTag();
          if (_jspx_th_impact_validateSelect_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_6.setColspan("2");
          _jspx_th_impact_validateTextArea_6.setName("txtPlSpecify");
          _jspx_th_impact_validateTextArea_6.setLabel("Please Specify");
          _jspx_th_impact_validateTextArea_6.setRows("5");
          _jspx_th_impact_validateTextArea_6.setMaxLength(1000);
          _jspx_th_impact_validateTextArea_6.setCols("60");
          _jspx_th_impact_validateTextArea_6.setDisabled("false");
          _jspx_th_impact_validateTextArea_6.setConditionallyRequired("true");
          _jspx_th_impact_validateTextArea_6.setDisabled(editableMode);
          _jspx_th_impact_validateTextArea_6.setTabIndex(tabIndex++);
          _jspx_th_impact_validateTextArea_6.setConstraint("Paragraph1000");
          int _jspx_eval_impact_validateTextArea_6 = _jspx_th_impact_validateTextArea_6.doStartTag();
          if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_6.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_6.doInitBody();
            }
            do {
              out.write("\r\n\t\t\t\t\t");
              out.print(FormattingHelper.formatString(spNdsBean.getTxtPleaseSpecify()));
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_6.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_6 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_54 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_54.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_54.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_54.setType("text");
          _jspx_th_impact_validateInput_54.setLabel("Number of Special Needs children included in the Respite Request");
          _jspx_th_impact_validateInput_54.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_54.setName("txtSzNumSPNChildReq");
          _jspx_th_impact_validateInput_54.setCssClass("formInput");
          _jspx_th_impact_validateInput_54.setDisabled(editableMode);
          _jspx_th_impact_validateInput_54.setValue(spNdsBean.getNbrSpNeedsChildrenRequest() != null ? FormattingHelper.formatInt(spNdsBean.getNbrSpNeedsChildrenRequest()) : "" );
          _jspx_th_impact_validateInput_54.setSize("2");
          _jspx_th_impact_validateInput_54.setMaxLength("2");
          _jspx_th_impact_validateInput_54.setTabIndex(tabIndex++);
          int _jspx_eval_impact_validateInput_54 = _jspx_th_impact_validateInput_54.doStartTag();
          if (_jspx_th_impact_validateInput_54.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<br>\r\n\r\n\t");

		  // If in a pending or approved status, show the approval section
		
          out.write('\r');
          out.write('\n');
          out.write('	');

	  if ((CodesTables.CEVTSTAT_PEND.equals(eventStatus) && canModifyApprovalSections) || CodesTables.CEVTSTAT_APRV.equals(eventStatus))  {
	
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:ExpandableSectionTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag _jspx_th_impact_ExpandableSectionTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ExpandableSectionTag();
          _jspx_th_impact_ExpandableSectionTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ExpandableSectionTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ExpandableSectionTag_1.setName("approval_special");
          _jspx_th_impact_ExpandableSectionTag_1.setLabel("Approval");
          _jspx_th_impact_ExpandableSectionTag_1.setTabIndex(tabIndex++);
          _jspx_th_impact_ExpandableSectionTag_1.setId("");
          int _jspx_eval_impact_ExpandableSectionTag_1 = _jspx_th_impact_ExpandableSectionTag_1.doStartTag();
          if (_jspx_eval_impact_ExpandableSectionTag_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tSpecialized Rate - Approval\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\tIs the Specialized Rate for Adoption Assistance approved?\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_55 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_55.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_55.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_55.setType("radio");
              _jspx_th_impact_validateInput_55.setLabel("Yes");
              _jspx_th_impact_validateInput_55.setId("specRateAprv_Yes");
              _jspx_th_impact_validateInput_55.setName("rbSpecRateAprv");
              _jspx_th_impact_validateInput_55.setValue("Y");
              _jspx_th_impact_validateInput_55.setDisabled(disabled);
              _jspx_th_impact_validateInput_55.setCssClass("formInput");
              _jspx_th_impact_validateInput_55.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpclRateAdoAppr())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_55.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_55.setOnClick("enableTotalAprvAmt()");
              int _jspx_eval_impact_validateInput_55 = _jspx_th_impact_validateInput_55.doStartTag();
              if (_jspx_th_impact_validateInput_55.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_56 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_56.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_56.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_56.setType("radio");
              _jspx_th_impact_validateInput_56.setLabel("No");
              _jspx_th_impact_validateInput_56.setId("specRateAprv_No");
              _jspx_th_impact_validateInput_56.setName("rbSpecRateAprv");
              _jspx_th_impact_validateInput_56.setDisabled(disabled);
              _jspx_th_impact_validateInput_56.setValue("N");
              _jspx_th_impact_validateInput_56.setCssClass("formInput");
              _jspx_th_impact_validateInput_56.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndSpclRateAdoAppr())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_56.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_56.setOnClick("clearTotalAprvAmt()");
              int _jspx_eval_impact_validateInput_56 = _jspx_th_impact_validateInput_56.doStartTag();
              if (_jspx_th_impact_validateInput_56.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t&nbsp;\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_57 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_57.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_57.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_57.setType("text");
              _jspx_th_impact_validateInput_57.setLabel("Approved Negotiated Amount");
              _jspx_th_impact_validateInput_57.setConstraint("Money");
              _jspx_th_impact_validateInput_57.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_57.setName("txtSzTotalAprvAmt");
              _jspx_th_impact_validateInput_57.setCssClass("formInput");
              _jspx_th_impact_validateInput_57.setValue((((spNdsBean.getNbrTotalIveIvbAmt() != null) && (spNdsBean.getNbrTotalIveIvbAmt() > 0)) ? FormattingHelper.formatMoney(spNdsBean.getNbrTotalIveIvbAmt()) : ""));
              _jspx_th_impact_validateInput_57.setDisabled(disabled);
              _jspx_th_impact_validateInput_57.setSize("10");
              _jspx_th_impact_validateInput_57.setMaxLength("10");
              _jspx_th_impact_validateInput_57.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_57 = _jspx_th_impact_validateInput_57.doStartTag();
              if (_jspx_th_impact_validateInput_57.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t*This is the total monthly amount.\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tNon-Recurring - Approval\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\tIs the Non-Recurring/510 Funding Type for Adoption Assistance\r\n\t\t\t\t\tapproved?\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_58 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_58.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_58.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_58.setType("radio");
              _jspx_th_impact_validateInput_58.setLabel("Yes");
              _jspx_th_impact_validateInput_58.setId("nonRecReqAprv_Yes");
              _jspx_th_impact_validateInput_58.setName("rbNonRecReqAprv");
              _jspx_th_impact_validateInput_58.setValue("Y");
              _jspx_th_impact_validateInput_58.setDisabled(disableNonRecurringAprv);
              _jspx_th_impact_validateInput_58.setCssClass("formInput");
              _jspx_th_impact_validateInput_58.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecApproved())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_58.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_58.setOnClick("enableApvrNonRec()");
              int _jspx_eval_impact_validateInput_58 = _jspx_th_impact_validateInput_58.doStartTag();
              if (_jspx_th_impact_validateInput_58.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_59 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_59.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_59.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_59.setType("radio");
              _jspx_th_impact_validateInput_59.setLabel("No");
              _jspx_th_impact_validateInput_59.setId("nonRecReqAprv_No");
              _jspx_th_impact_validateInput_59.setName("rbNonRecReqAprv");
              _jspx_th_impact_validateInput_59.setDisabled(disableNonRecurringAprv);
              _jspx_th_impact_validateInput_59.setValue("N");
              _jspx_th_impact_validateInput_59.setCssClass("formInput");
              _jspx_th_impact_validateInput_59.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecApproved())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_59.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_59.setOnClick("disableAprvNonRec()");
              int _jspx_eval_impact_validateInput_59 = _jspx_th_impact_validateInput_59.doStartTag();
              if (_jspx_th_impact_validateInput_59.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"3\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_60 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_60.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_60.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_60.setType("text");
              _jspx_th_impact_validateInput_60.setLabel("Total Approved Amount");
              _jspx_th_impact_validateInput_60.setConstraint("Money");
              _jspx_th_impact_validateInput_60.setName("txtSzNonRecReqTotalAprvAmt");
              _jspx_th_impact_validateInput_60.setCssClass("formInput");
              _jspx_th_impact_validateInput_60.setValue((((spNdsBean.getNbrNonRecAprvAmt() != null) && (spNdsBean.getNbrNonRecAprvAmt() > 0)) ? FormattingHelper.formatMoney(spNdsBean.getNbrNonRecAprvAmt()) : ""));
              _jspx_th_impact_validateInput_60.setDisabled(disableNonRecurringAprv);
              _jspx_th_impact_validateInput_60.setSize("10");
              _jspx_th_impact_validateInput_60.setMaxLength("10");
              _jspx_th_impact_validateInput_60.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_60 = _jspx_th_impact_validateInput_60.doStartTag();
              if (_jspx_th_impact_validateInput_60.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\r\n\t\t<table width=\"100%\" cellspacing=\"0\" cellpadding=\"3\">\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<th colspan=\"4\">\r\n\t\t\t\t\tSpecial Service - Approval\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\tIs the Special Service Request approved?\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_61 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_61.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_61.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_61.setType("radio");
              _jspx_th_impact_validateInput_61.setLabel("Yes");
              _jspx_th_impact_validateInput_61.setId("specServReqAprv_Yes");
              _jspx_th_impact_validateInput_61.setName("rbSpecServReqAprv");
              _jspx_th_impact_validateInput_61.setValue("Y");
              _jspx_th_impact_validateInput_61.setDisabled(disabled);
              _jspx_th_impact_validateInput_61.setCssClass("formInput");
              _jspx_th_impact_validateInput_61.setChecked("Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpclReqApproved())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_61.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_61.setOnClick("enableSpcSrvReqAprv()");
              int _jspx_eval_impact_validateInput_61 = _jspx_th_impact_validateInput_61.doStartTag();
              if (_jspx_th_impact_validateInput_61.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_62 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_62.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_62.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_62.setType("radio");
              _jspx_th_impact_validateInput_62.setLabel("No");
              _jspx_th_impact_validateInput_62.setId("specServReqAprv_No");
              _jspx_th_impact_validateInput_62.setName("rbSpecServReqAprv");
              _jspx_th_impact_validateInput_62.setValue("N");
              _jspx_th_impact_validateInput_62.setDisabled(disabled);
              _jspx_th_impact_validateInput_62.setCssClass("formInput");
              _jspx_th_impact_validateInput_62.setChecked("N".equals(FormattingHelper.formatString(spNdsBean.getIndSpclReqApproved())) ? "true"
                                                                                                       : "false");
              _jspx_th_impact_validateInput_62.setTabIndex(tabIndex++);
              _jspx_th_impact_validateInput_62.setOnClick("disableSpcSrvReqAprv()");
              int _jspx_eval_impact_validateInput_62 = _jspx_th_impact_validateInput_62.doStartTag();
              if (_jspx_th_impact_validateInput_62.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateSelect
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
              _jspx_th_impact_validateSelect_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateSelect_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateSelect_4.setStyle("WIDTH: 320px");
              _jspx_th_impact_validateSelect_4.setLabel("Special Service Type and Funding");
              _jspx_th_impact_validateSelect_4.setName("selSzCdSpServFundingType");
              _jspx_th_impact_validateSelect_4.setValue(FormattingHelper.formatString(spNdsBean.getCdApprvSpclTypeFunding()));
              _jspx_th_impact_validateSelect_4.setDisabled(disabled);
              _jspx_th_impact_validateSelect_4.setCodesTable("CSPLSERV");
              _jspx_th_impact_validateSelect_4.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateSelect_4 = _jspx_th_impact_validateSelect_4.doStartTag();
              if (_jspx_th_impact_validateSelect_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateInput
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_63 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
              _jspx_th_impact_validateInput_63.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateInput_63.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateInput_63.setType("text");
              _jspx_th_impact_validateInput_63.setLabel("Approved Amount");
              _jspx_th_impact_validateInput_63.setConstraint("Money");
              _jspx_th_impact_validateInput_63.setConditionallyRequired("true");
              _jspx_th_impact_validateInput_63.setName("txtSzAprvAmt");
              _jspx_th_impact_validateInput_63.setCssClass("formInput");
              _jspx_th_impact_validateInput_63.setValue(FormattingHelper.formatMoney(spNdsBean.getNbrApprvAmt()));
              _jspx_th_impact_validateInput_63.setSize("10");
              _jspx_th_impact_validateInput_63.setMaxLength("10");
              _jspx_th_impact_validateInput_63.setDisabled(disabled);
              _jspx_th_impact_validateInput_63.setTabIndex(tabIndex++);
              int _jspx_eval_impact_validateInput_63 = _jspx_th_impact_validateInput_63.doStartTag();
              if (_jspx_th_impact_validateInput_63.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDate_1.setName("txtDtDtAprvDate");
              _jspx_th_impact_validateDate_1.setLabel("Approval Date");
              _jspx_th_impact_validateDate_1.setConstraint("Date");
              _jspx_th_impact_validateDate_1.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_1.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_1.setValue(FormattingHelper.formatDate(spNdsBean.getDtApprvDate()));
              _jspx_th_impact_validateDate_1.setDisabled(disabled);
              int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
              if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateDate
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
              _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateDate_2.setName("txtDtDtExpDate");
              _jspx_th_impact_validateDate_2.setLabel("Expiration Date");
              _jspx_th_impact_validateDate_2.setConstraint("Date");
              _jspx_th_impact_validateDate_2.setConditionallyRequired("true");
              _jspx_th_impact_validateDate_2.setTabIndex(tabIndex++);
              _jspx_th_impact_validateDate_2.setValue(FormattingHelper.formatDate(spNdsBean.getDtExpirationDate()));
              _jspx_th_impact_validateDate_2.setDisabled(disabled);
              int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
              if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr class=\"subDetail\">\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
              //  impact:validateTextArea
              gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
              _jspx_th_impact_validateTextArea_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_validateTextArea_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_ExpandableSectionTag_1);
              _jspx_th_impact_validateTextArea_7.setColspan("2");
              _jspx_th_impact_validateTextArea_7.setName("txtSzTxtSpcServAprvCmmts");
              _jspx_th_impact_validateTextArea_7.setLabel("Comments");
              _jspx_th_impact_validateTextArea_7.setRows("5");
              _jspx_th_impact_validateTextArea_7.setMaxLength(300);
              _jspx_th_impact_validateTextArea_7.setCols("60");
              _jspx_th_impact_validateTextArea_7.setDisabled("false");
              _jspx_th_impact_validateTextArea_7.setDisabled(disabled);
              _jspx_th_impact_validateTextArea_7.setTabIndex(tabIndex++);
              _jspx_th_impact_validateTextArea_7.setConstraint("Paragraph300");
              int _jspx_eval_impact_validateTextArea_7 = _jspx_th_impact_validateTextArea_7.doStartTag();
              if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
                  out = _jspx_page_context.pushBody();
                  _jspx_th_impact_validateTextArea_7.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
                  _jspx_th_impact_validateTextArea_7.doInitBody();
                }
                do {
                  out.write("\r\n\t\t\t\t\t\t");
                  out.print(FormattingHelper.formatString(spNdsBean.getTxtComments()));
                  out.write("\r\n\t\t\t\t\t");
                  int evalDoAfterBody = _jspx_th_impact_validateTextArea_7.doAfterBody();
                  if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                    break;
                } while (true);
                if (_jspx_eval_impact_validateTextArea_7 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
                  out = _jspx_page_context.popBody();
              }
              if (_jspx_th_impact_validateTextArea_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t");
              int evalDoAfterBody = _jspx_th_impact_ExpandableSectionTag_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_ExpandableSectionTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');

            } //End Specialized Approval Section
          
          out.write("\r\n\t<br />\r\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\"\r\n\t\tcellspacing=\"0\">\r\n\t\t<tr>\r\n\t\t\t");
//STGAP00014044: Do not show this button for the Approver
				    if ((CodesTables.CEVTSTAT_PEND.equals(eventStatus) && canModifyApprovalSections) || CodesTables.CEVTSTAT_APRV.equals(eventStatus))  {
				   
          out.write("\r\n\t\t\t<td></td>\r\n\t\t\t");
}else{
          out.write("\r\n\t\t\t<td width=\"95%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnSaveSubmit");
          _jspx_th_impact_ButtonTag_1.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_1.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmSpecialNeedsDetermination");
          _jspx_th_impact_ButtonTag_1.setDisabled(indBtnSaveSubmit);
          _jspx_th_impact_ButtonTag_1.setAction("/financials/SpecialNeedsDetermination/saveSpecialNeedsDetermination");
          _jspx_th_impact_ButtonTag_1.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
} 
          out.write("\r\n\t\t\t<td width=\"5%\">\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSave");
          _jspx_th_impact_ButtonTag_2.setImg("btnSave");
          _jspx_th_impact_ButtonTag_2.setAlign("right");
          _jspx_th_impact_ButtonTag_2.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_2.setForm("frmSpecialNeedsDetermination");
          _jspx_th_impact_ButtonTag_2.setDisabled(indBtnSave);
          _jspx_th_impact_ButtonTag_2.setAction("/financials/SpecialNeedsDetermination/saveSpecialNeedsDetermination");
          _jspx_th_impact_ButtonTag_2.setTabIndex(tabIndex++);
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");

			  /*  Always include this hidden field in your form */
			
          out.write("\r\n\r\n\t<input type=\"hidden\" name=\"hdnHasCurrentEligibility\"\r\n\t\tvalue=\"");
          out.print(spNdsDetRetSO.hasCurrentEligibility() );
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"hdnEventStatus\"\r\n\t\tvalue=\"");
          out.print(spNdsDetRetSO.getCdEventStatus() );
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"hdnFirstApplication\"\r\n\t\tvalue=\"");
          out.print(spNdsDetRetSO.isBFirstApplication() );
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"hdnPriorAprvSpecialNeedsDeter\"\r\n\t\tvalue=\"");
          out.print(spNdsDetRetSO.isBPriorAprvSpecialNeedsDeter() );
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"specialNeedsNotReq\"\r\n\t\tvalue=\"");
          out.print(specialNeedsNotReq);
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"reason\" value=\"");
          out.print(reason);
          out.write("\" />\r\n\t<input type=\"hidden\" name=\"hdnApprover\"\r\n\t\tvalue=\"");
          out.print(canModifyApprovalSections );
          out.write("\" />\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\" />\r\n\t");

			  /* Close Validate Form Custom Tag */
			
          out.write('\r');
          out.write('\n');
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n<!-- SMS#97845 MR-074-2 AFCARS: define help text window form -->\r\n<form name=\"frmIncidentStatusHelp\" method=\"post\"\r\n\taction=\"/financials/SpecialNeedsDetermination/displayIncidentStatusHelpText\">\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
      out.print(ArchitectureConstants.SIMPLE_HELP_TEXT_DISPLAY );
      out.write("\" value=\"\" />\r\n\t<input type=\"hidden\"\r\n\t\tname=\"");
      out.print(ArchitectureConstants.SIMPLE_HELP_TEXT_WIN_NAME );
      out.write("\" value=\"\" />\r\n</form>\r\n");

        //STGAP00010838: Added the forms and reports section to launch the Special Services Adoption Assistance Agreement form
        // SMS #109403: MR-082 Updated this condition to display the Form display; the Form section will be displayed
        // as a blank dropdown (such as Adoption Assistance Agreement page) when the condition to launch the form(s) does not meet 
        if (spNdsDetRetSO != null) {
      
      out.write("\r\n<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\"\r\n\tclass=\"tableBorder\">\r\n\t<tr>\r\n\t\t<th colspan=\"4\">\r\n\t\t\tForm Launch\r\n\t\t</th>\r\n\t</tr>\r\n\t<tr>\r\n\t\t<td>\r\n\t\t\t");
      //  impact:documentList
      gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag _jspx_th_impact_documentList_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentListTag();
      _jspx_th_impact_documentList_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_documentList_0.setParent(null);
      _jspx_th_impact_documentList_0.setPageMode(pageMode);
      _jspx_th_impact_documentList_0.setTabIndex(tabIndex++);
      int _jspx_eval_impact_documentList_0 = _jspx_th_impact_documentList_0.doStartTag();
      if (_jspx_eval_impact_documentList_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write("\r\n\t\t\t\t");

				  if (ArchitectureConstants.Y.equals(spNdsBean.getIndSpclServiceReq())) {
				        String documentFormName = "ado01O00" + String.valueOf(spNdsDetRetSO.getUlIdChild());
				
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_0.setDisplayName("Special Services Adoption Assistance Agreement");
          _jspx_th_impact_document_0.setProtectDocument(true);
          _jspx_th_impact_document_0.setCheckForNewMode(false);
          _jspx_th_impact_document_0.setDocType("ado01O00");
          _jspx_th_impact_document_0.setDocExists(true);
          int _jspx_eval_impact_document_0 = _jspx_th_impact_document_0.doStartTag();
          if (_jspx_eval_impact_document_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_0 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_0.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_0.setName("pCase");
              _jspx_th_impact_documentParameter_0.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_0 = _jspx_th_impact_documentParameter_0.doStartTag();
              if (_jspx_th_impact_documentParameter_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_1.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_1.setName("pStage");
              _jspx_th_impact_documentParameter_1.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_1 = _jspx_th_impact_documentParameter_1.doStartTag();
              if (_jspx_th_impact_documentParameter_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_2 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_2.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_2.setName("pEvent");
              _jspx_th_impact_documentParameter_2.setValue(String.valueOf(spNdsDetRetSO.getUlIdEvent()));
              int _jspx_eval_impact_documentParameter_2 = _jspx_th_impact_documentParameter_2.doStartTag();
              if (_jspx_th_impact_documentParameter_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_3 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_3.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_0);
              _jspx_th_impact_documentParameter_3.setName("pPerson");
              _jspx_th_impact_documentParameter_3.setValue(String.valueOf(spNdsDetRetSO.getUlIdChild()));
              int _jspx_eval_impact_documentParameter_3 = _jspx_th_impact_documentParameter_3.doStartTag();
              if (_jspx_th_impact_documentParameter_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_0.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  } else if (spNdsDetRetSO != null && CodesTables.CSTAGES_PAD.equals(cdStage) 
				  && ArchitectureConstants.Y.equals(spNdsBean.getIndSpcNeedsApproved())
				  && ArchitectureConstants.Y.equals(spNdsBean.getIndNonRecOnly())
				  && ArchitectureConstants.Y.equals(spNdsBean.getIndNonRecApproved()) 
				  && CodesTables.CEVTSTAT_APRV.equals(eventStatus))	{
				
          out.write("\r\n\t\t\t\t");
          //  impact:document
          gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag _jspx_th_impact_document_1 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentTag();
          _jspx_th_impact_document_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_document_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_documentList_0);
          _jspx_th_impact_document_1.setDisplayName("Non-Recurring Only Adoption Assistance Agreement");
          _jspx_th_impact_document_1.setProtectDocument(true);
          _jspx_th_impact_document_1.setDocType("nonrecuronlyaaagrmnt");
          _jspx_th_impact_document_1.setPreFillAlways(true);
          _jspx_th_impact_document_1.setDocExists(true);
          int _jspx_eval_impact_document_1 = _jspx_th_impact_document_1.doStartTag();
          if (_jspx_eval_impact_document_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            do {
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_4 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_4.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_4.setName("pPerson");
              _jspx_th_impact_documentParameter_4.setValue(String.valueOf(spNdsDetRetSO.getUlIdChild()));
              int _jspx_eval_impact_documentParameter_4 = _jspx_th_impact_documentParameter_4.doStartTag();
              if (_jspx_th_impact_documentParameter_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_5 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_5.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_5.setName("pStage");
              _jspx_th_impact_documentParameter_5.setValue(String.valueOf(GlobalData.getUlIdStage(request)));
              int _jspx_eval_impact_documentParameter_5 = _jspx_th_impact_documentParameter_5.doStartTag();
              if (_jspx_th_impact_documentParameter_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_6 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_6.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_6.setName("pCase");
              _jspx_th_impact_documentParameter_6.setValue(String.valueOf(GlobalData.getUlIdCase(request)));
              int _jspx_eval_impact_documentParameter_6 = _jspx_th_impact_documentParameter_6.doStartTag();
              if (_jspx_th_impact_documentParameter_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t\t");
              //  impact:documentParameter
              gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag _jspx_th_impact_documentParameter_7 = new gov.georgia.dhr.dfcs.sacwis.web.document.DocumentParameterTag();
              _jspx_th_impact_documentParameter_7.setPageContext(_jspx_page_context);
              _jspx_th_impact_documentParameter_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_document_1);
              _jspx_th_impact_documentParameter_7.setName("pEvent");
              _jspx_th_impact_documentParameter_7.setValue(String.valueOf(spNdsDetRetSO.getUlIdEvent()));
              int _jspx_eval_impact_documentParameter_7 = _jspx_th_impact_documentParameter_7.doStartTag();
              if (_jspx_th_impact_documentParameter_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
                return;
              out.write("\r\n\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_document_1.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
          }
          if (_jspx_th_impact_document_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t");

				  }
				
          out.write("\r\n\t\t\t");
          int evalDoAfterBody = _jspx_th_impact_documentList_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_documentList_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t</td>\r\n\t</tr>\r\n</table>\r\n");

	  }
	
      out.write("\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n      window.attachEvent('onload', disableSpecialRatesAndServices);\r\n    </script>");
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

  private boolean _jspx_meth_impact_validateInput_0(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_0.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_0.setType("hidden");
    _jspx_th_impact_validateInput_0.setName("hdnBSpecialNeedsTypeChange");
    _jspx_th_impact_validateInput_0.setValue("");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
