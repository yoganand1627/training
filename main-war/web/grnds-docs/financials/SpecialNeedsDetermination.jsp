<%--
JSP Name:     Special Needs Determination
Created by:   Vishala Devarakonda
Date Created: 05/04/2007

Description:
This JSP serves as a source of clean code that can be used to build other JSPs.

Change History:
Date        User                        Description
--------    --------------------        --------------------------------------------------
08/18/2008   Vishala Devarakonda        STGAP00010002: Added Forms and Reports Section 
10/1/2008    Stephen Roberts            STGAP00010455: Updated for R3.0 (Adoption Release)
10/27/2009   Michael Chillman			STGAP00010838: Added the forms and reports section to launch the Special Services Adoption Assistance Agreement form
10/27/2009   Michael Chillman			STGAP00010839: Changed Application Status so that if any of the requests have been approved, then page will show 'approved' as the status.
01/26/2009   Joel Cochran				STGAP00012104: Changed several labels that were incomplete or incorrect
02/03/2009   Joel Cochran				STGAP00012104: Modified labels in the approval section to match those of the application
										section. Also cleaned up some markup that is used in the approval section.
04/14/2009   Sriram Subramaniam			STGAP00012952: Disable Special Service Request section until the question
                                        Is a Special Service being requested for this child? is answered Yes.		
05/25/2009   Michael Chillman			STGAP00012139: MR-050 updates    
06/05/2009   bgehlot                    STGAP00014035: SAU requested title bar in Special Needs approval section is reworded to read Special Needs Determination approval
06/05/2009   bgehlot                    STGAP00013919: Disable Special Needs Determination Approval Section when non-recurring only checkbox is checked 
06/05/2009   bgehlot                    STGAP00014044: Remove the Save and Submit button from the Adoption Assistance Application page when in as the Approver
07/01/2009   bgehlot                    STGAP00014563: Enabling the non - recurring amount field 		
07/13/2009   bgehlot                    STGAP00014681: disable custom and county addon 
07/13/2009   bgehlot                    STGAP00014679: Selecting a Basic Rate Type radio button populates the Total Monthly Amount
07/13/2009   bgehlot                    STGAP00015138: Changed the value to 'T' for member of sibling group of three or more in the Approval section 
							  			for special needs
09/28/2009   arege    		            STGAP00015047: Adopt Asst App- Custom BR Type field is populated with an amount even though the Pre BR Type is selected
01/13/2010   arege                      SMS#43557: Removed Payment Method field from the Special Services section
02/01/2010   bgehlot               		SMS#44783: MR-60 Changes, Pre Post radio buttons added, Special Needs Type and Approval Type
                                                    radio buttons changed to the drop down, new types added.
02/18/2010   bgehlot               		SMS#45767: Label Changes for Basic Rate Type and Specialized Rate Approved Amount                                                 
02/18/2010   hjbaptiste                 SMS#44783: MR-60 Calling submitValidateFormNoBypass() to make IsDirty() work in submitFormOnSpecialNeedsTypePostPreSelection()
03/04/2011   arege                      SMS#77296: Modified the condition for displaying Pre-Post Special needs type 
03/09/2011   htvo                       SMS#97845 MR-074-2 AFCARS: added new section for Incident/Non-Incident Status and display logic
04/18/2011   hanguyen                   SMS#105978: Set Approval section approved amounts default value to blank when value is 0,
                                        to prevent dirty page navigation popup alert when user did not make any changes to page. This is
                                        caused by onload javascript function that turn 0 value to blank if corresponding radio buttons
                                        is not 'Y'. Also bypass isDirty popup when clicking help ? hyperlink.
05/20/2011   arege                      SMS#109420 None Applicable should be removed from drop down for new applications, but it should continue to display for 
                                        existing approved applications 
06/01/2011   htvo                       SMS#109403 MR-082: updates: 
                                        - Move Date Approved up below the Special Needs request approved question
                                        - When Non-Recurring Only checkbox is ticked
                                           - Clear and disable Funding Type 
                                           - Enable Special Needs Request and Approval sections
                                           - Disable Basic Rate - Type selection
                                           - Automate Non-recurring request by Non-Recurring Only checkbox selection
                                           and use hidden fied to send value to server.
06/06/2011   schoi                      SMS #109403: MR-082 Added the following condition to launch a new form Non-Recurring Only Adoption Assistance Agreement;
										The stage must be PAD, the Adoption Assistance Application event must be in APRV status, 
										the Special Needs Determination must be approved (not denied or deferred), 
										the Non-Recurring - Approval section must be completed and the application status is approved
06/07/2011   htvo						SMS#109403: corrected setHdnNonRecReq to set value to the hidden field; corrected SMS code (109430to 109403)				 
06/09/2011   schoi                      SMS #109403: MR-082 Added condition to check IndNonRecOnly to launch 
										Non-Recurring Only Adoption Assistance Agreement form	
06/14/2011	 htvo						SMS#111617: fixed non-recurring request being clear on non-recurring only app after failing custom validation
06/16/2011   arege                      SMS#109420 None Applicable should be removed from Sp Needs request drop down and not from the drop down in approval section 
02/08/2012	 vcollooru					STGAP00017878: (Break-fix defect for 5.1) Following are the changes done as part of the fix -
 	  										 i) Added the new radio buttons for Agreement Type Selection.
 	 										ii) Enabled the non-recurring request and approvals sections for new applications even though
 	     										one approved in prior application.
							    
                                         
--%>
<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="java.util.Enumeration"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Date"%>
<%@ page import="java.util.List"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.SerializationHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.output.SpecialNeedsDeterminationRetrieveSO"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.structs.input.SpecialNeedsDeterminationBean"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page
	import="gov.georgia.dhr.dfcs.sacwis.web.workload.ApprovalStatusConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.financials.SpecialNeedsDeterminationConversation"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper"%>

<%
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

%>
<%-- Needed for Form Launch Custom tag --%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/document/document.js"></script>
<script type="text/javascript" language="JavaScript1.2">

  /*
   This function is called before the page unloads. It creates the
   "Are you sure you want to navigate away from this page..." pop-up message.
  */
  window.onbeforeunload = function ()
  {
    IsDirty();
  };
  function setIndValidate(indValidate)
  {
   if(indValidate){
      disableValidation('frmSpecialNeedsDetermination');
   }
  }
  
  /*
  This function fires every time the page is loaded to disable certain sections
  of the page.  It is also used on click events for the Basic Rate Yes/No question.
  */
  function disableSpecialRatesAndServices()
  {
    
    /* Test to see if we are in the correct page mode (modifiable). If not exit the
       function */
    var basicRateToggle = document.getElementsByName('rbBasicRateReq');
    if (basicRateToggle.length == 1) {
      return;
    }

    if (basicRateToggle.length > 1 && frmSpecialNeedsDetermination.rbBasicRateReq[0].checked) {
      val = true;
    } else {
      val = false;
    }
    
    /*STGAP00012952: Disable Special Service Request section until the question
      Is a Special Service being requested for this child? is answered Yes.*/
    var spcSrvRequested = document.getElementsByName('rbSpecServiceReq');
    if (spcSrvRequested.length > 1){
	    if (frmSpecialNeedsDetermination.rbSpecServiceReq[0].checked) {
	      spcSrvReqDisable = false;
	    } else { 
	      /*Disable and clear the request section */
	      spcSrvReqDisable = true;
	      frmSpecialNeedsDetermination.rbSpecServiceReq[0].checked = false;
	      frmSpecialNeedsDetermination.rbSpecServiceReq[1].checked = false;
		  frmSpecialNeedsDetermination.rbIndDocAttached[0].checked = false;
	      frmSpecialNeedsDetermination.rbIndDocAttached[1].checked = false;
		  frmSpecialNeedsDetermination.rbIndDocAttached[0].disabled = true;
	      frmSpecialNeedsDetermination.rbIndDocAttached[1].disabled = true;
	      frmSpecialNeedsDetermination.txtSzReqAmt.value = '';
	      frmSpecialNeedsDetermination.txtSzReqAmt.disabled = true;
	      frmSpecialNeedsDetermination.selSzCdSpecServType.value = '';
	      frmSpecialNeedsDetermination.selSzCdSpecServType.disabled = true;
	      frmSpecialNeedsDetermination.txtPlSpecify.value = '';
	      frmSpecialNeedsDetermination.txtPlSpecify.disabled = true;
	      frmSpecialNeedsDetermination.txtSzNumSPNChildReq.value = '';
	      frmSpecialNeedsDetermination.txtSzNumSPNChildReq.disabled = true;
	    }
	    if (spcSrvReqDisable){
	      var spcSrvReqAprv = document.getElementsByName('rbSpecServReqAprv');
	      if (spcSrvReqAprv.length > 1){
	        /*Disable and clear the approval section */
	      	frmSpecialNeedsDetermination.rbSpecServReqAprv[0].checked = false;
	      	frmSpecialNeedsDetermination.rbSpecServReqAprv[1].checked = false;
	      	frmSpecialNeedsDetermination.rbSpecServReqAprv[0].disabled = true;
	      	frmSpecialNeedsDetermination.rbSpecServReqAprv[1].disabled = true;
	      	frmSpecialNeedsDetermination.selSzCdSpServFundingType.value = '';
	      	frmSpecialNeedsDetermination.selSzCdSpServFundingType.disabled = true;
	      	frmSpecialNeedsDetermination.txtSzAprvAmt.value = '';
	      	frmSpecialNeedsDetermination.txtSzAprvAmt.disabled = true;
			frmSpecialNeedsDetermination.txtDtDtAprvDate.value = '';
			frmSpecialNeedsDetermination.txtDtDtAprvDate.disabled = true;
			frmSpecialNeedsDetermination.txtDtDtExpDate.value = '';
			frmSpecialNeedsDetermination.txtDtDtExpDate.disabled = true;
			frmSpecialNeedsDetermination.txtSzTxtSpcServAprvCmmts.value = '';
			frmSpecialNeedsDetermination.txtSzTxtSpcServAprvCmmts.disabled = true;
	      }
	    }
    }
    
    var testWidget = document.getElementsByName('rbSpecRateReq');
    if (testWidget.length > 0) {
      if (frmSpecialNeedsDetermination.rbSpecRateReq[0].checked) {
       valSepcRate = true;
      } else {
       valSepcRate = false;
      }
      
      var approvalWidget = document.getElementsByName('rbSpecRateAprv');
      if (valSepcRate == true && approvalWidget.length > 0 && approvalWidget[0].type != 'hidden') {
        frmSpecialNeedsDetermination.rbSpecRateAprv[0].disabled = false;
        frmSpecialNeedsDetermination.rbSpecRateAprv[1].disabled = false;
        if(frmSpecialNeedsDetermination.rbSpecRateAprv[0].checked == false){
         frmSpecialNeedsDetermination.txtSzTotalAprvAmt.value = '';
        }
        
      } else if (approvalWidget.length > 0) {
      	frmSpecialNeedsDetermination.rbSpecRateAprv[0].checked = false;
        frmSpecialNeedsDetermination.rbSpecRateAprv[1].checked = false;
        frmSpecialNeedsDetermination.rbSpecRateAprv[0].disabled = true;
        frmSpecialNeedsDetermination.rbSpecRateAprv[1].disabled = true;
        frmSpecialNeedsDetermination.txtSzTotalAprvAmt.value = '';
        frmSpecialNeedsDetermination.txtSzTotalAprvAmt.disabled = true;
      }    
    } 
        
    var nonRecReqWidget = document.getElementsByName('rbNonRecReq'); 
    if (nonRecReqWidget.length > 1) {
	   	 if (frmSpecialNeedsDetermination.rbNonRecReq[0].checked) {
	   	 	var nonNonRecReqAprvWidget = document.getElementsByName('rbNonRecReqAprv');
	   	 	if(nonNonRecReqAprvWidget.length > 1) {
	   	 		frmSpecialNeedsDetermination.rbNonRecReqAprv.disabled = false;     	 		
	   	 		if (frmSpecialNeedsDetermination.rbNonRecReqAprv[0].checked == false) {
	   	 			frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '';
	   	 		}
	   	 		frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = false;
	   	 	}
	   	 } else {
	   	 	frmSpecialNeedsDetermination.txtNonRecAmtReq.value = '';
	   	 	frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;
	   	 	var nonNonRecReqAprvWidget = document.getElementsByName('rbNonRecReqAprv');
	   	 	if(nonNonRecReqAprvWidget.length > 0) {
	   	 		frmSpecialNeedsDetermination.rbNonRecReqAprv[0].disabled = true;
	   	 		frmSpecialNeedsDetermination.rbNonRecReqAprv[1].disabled = true;
	   	 		frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '';
	   	 		frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = false;
	   	 	}
	   	 }
	   	 frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;
    } 
    
    if(frmSpecialNeedsDetermination.cbxNonRecOnly.checked) {
    	enabledisableSpecialNeedsBaseRateRequest();
    }     
  }  
     /* STGAP00012952: Disable Special Service Request section until the question
      Is a Special Service being requested for this child? is answered Yes. */
  function enableSpcSrvReq(){
    /*Enable the request section */
    var x = document.frmSpecialNeedsDetermination;
	x.rbIndDocAttached[0].disabled = false;
	x.rbIndDocAttached[1].disabled = false; 
	x.txtSzReqAmt.disabled = false;
	x.selSzCdSpecServType.disabled = false;
	x.txtPlSpecify.disabled = false;
	x.txtSzNumSPNChildReq.disabled = false;
	var spcSrvReqAprv = document.getElementsByName('rbSpecServReqAprv');
    if (spcSrvReqAprv.length > 1){
	  x.rbSpecServReqAprv[0].disabled = false;
	  x.rbSpecServReqAprv[1].disabled = false;
	}
  }  
  function disableSpcSrvReq(){
    /*Disable the request and Approval section */
    var x = document.frmSpecialNeedsDetermination;
	x.rbIndDocAttached[0].checked = false;
	x.rbIndDocAttached[1].checked = false;
	x.rbIndDocAttached[0].disabled = true;
	x.rbIndDocAttached[1].disabled = true;
	x.txtSzReqAmt.value = '';
	x.txtSzReqAmt.disabled = true;
	x.selSzCdSpecServType.value = '';
	x.selSzCdSpecServType.disabled = true;
	x.txtPlSpecify.value = '';
	x.txtPlSpecify.disabled = true;
	x.txtSzNumSPNChildReq.value = '';
	x.txtSzNumSPNChildReq.disabled = true;
	var spcSrvReqAprv = document.getElementsByName('rbSpecServReqAprv');
    if (spcSrvReqAprv.length > 1){
     	x.rbSpecServReqAprv[0].checked = false;
     	x.rbSpecServReqAprv[1].checked = false;
     	x.rbSpecServReqAprv[0].disabled = true;
     	x.rbSpecServReqAprv[1].disabled = true;
     	x.selSzCdSpServFundingType.value = '';
     	x.selSzCdSpServFundingType.disabled = true;
     	x.txtSzAprvAmt.value = '';
     	x.txtSzAprvAmt.disabled = true;
		x.txtDtDtAprvDate.value = '';
		x.txtDtDtAprvDate.disabled = true;
		x.txtDtDtExpDate.value = '';
		x.txtDtDtExpDate.disabled = true;
		x.txtSzTxtSpcServAprvCmmts.value = '';
		x.txtSzTxtSpcServAprvCmmts.disabled = true;
    }
  }
  function enableSpcSrvReqAprv(){
      /*Enable the approval section only*/
	  var x = document.frmSpecialNeedsDetermination;
	  x.selSzCdSpServFundingType.disabled = false;
	  x.txtSzAprvAmt.disabled = false;
	  x.txtDtDtAprvDate.disabled = false;
	  x.txtDtDtExpDate.disabled = false;
	  x.txtSzTxtSpcServAprvCmmts.disabled = false;
	  x.selSzCdSpServFundingType.value = x.selSzCdSpecServType.value; 
      x.txtSzAprvAmt.value = x.txtSzReqAmt.value;
  }  

  function disableSpcSrvReqAprv(){
      /*Disable the approval section only*/
	  var x = document.frmSpecialNeedsDetermination;
	  x.selSzCdSpServFundingType.value = '';
	  x.selSzCdSpServFundingType.disabled = true;
	  x.txtSzAprvAmt.value = '';
	  x.txtSzAprvAmt.disabled = true;
	  x.txtDtDtAprvDate.value = '';
	  x.txtDtDtAprvDate.disabled = true;
	  x.txtDtDtExpDate.value = '';
	  x.txtDtDtExpDate.disabled = true;
	  x.txtSzTxtSpcServAprvCmmts.value = '';
	  x.txtSzTxtSpcServAprvCmmts.disabled = true;
  }   
    
  function enableNonRec() {
  	 frmSpecialNeedsDetermination.txtNonRecAmtReq.value = '<%= nonRecLimit %>';
  	 frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;
  }
  
  function disableNonRec() {
  	 frmSpecialNeedsDetermination.txtNonRecAmtReq.value = '';
     frmSpecialNeedsDetermination.txtNonRecAmtReq.disabled = true;
  }
  
  
  function enableApvrNonRec() {
  	 frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '<%= nonRecLimit %>';
     frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = false; /*STGAP00014563: Non Recurring Approval amount field will now be modifiable for the SAU */
  }
  
  function disableAprvNonRec() {
  	 frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.value = '';
     frmSpecialNeedsDetermination.txtSzNonRecReqTotalAprvAmt.disabled = true;
  }
  
  function clearTotalAprvAmt() {
  	frmSpecialNeedsDetermination.txtSzTotalAprvAmt.value = '';
  	frmSpecialNeedsDetermination.txtSzTotalAprvAmt.disabled = true;
  }
  
  function enableTotalAprvAmt() {
  	frmSpecialNeedsDetermination.txtSzTotalAprvAmt.disabled = false;
  }
  
  function enabledisableSpecialNeedsBaseRateRequest() {
   	var x = document.frmSpecialNeedsDetermination;
   	if(x.cbxNonRecOnly.checked)  {
      val = true;
      disableSpcSrvReq();
      x.rbSpecServiceReq[0].checked = false;
	  x.rbSpecServiceReq[1].checked = false;
	  /* SMS#109403: if non-recurring only is checked,
	  disable non-recurring request. The $ amount field should be controlled by the non-recurring request field.	  
	  */
	  <% if (!GlobalData.isApprovalMode(request)) { %>
	  /* SMS#111617: manually set request = yes on page reload to fix the auto-populated radio not retained  
	  because the field was disabled when failed custom validation. Value already set in hdn field when 
	  non-recurring only cbx ticked. Amount field disabled by java calculation, only need to set amount here */
	  x.rbNonRecReq[0].checked = true;
	  x.txtNonRecAmtReq.value = '<%= nonRecLimit %>';
	  x.rbNonRecReq[0].disabled = true;
	  x.rbNonRecReq[1].disabled = true;  
	  <% } %>
    } else {
      val = false;
    }   
    x.rbSpecServiceReq[0].disabled = val; 
    x.rbSpecServiceReq[1].disabled = val; 
    //MR-60 radio button to dropdown change  
  	/*SMS#109403: reverting MR-060: enable special needs request fields
	*/
	x.rbBasicRateReq[0].disabled = val;
	x.rbBasicRateReq[1].disabled = val;
	
	x.rbSpecRateReq[0].disabled = val;
    x.rbSpecRateReq[1].disabled = val;
    x.rbSFCorRBWO[0].disabled = val;
    x.rbSFCorRBWO[1].disabled = val;   
    x.cbxPsychological.disabled = val;
    x.cbxDevAssmtEval.disabled = val;   
    x.cbxTrtmntPrvdr.disabled = val;  
    x.cbxMedAssmnt.disabled = val; 
    x.cbxSSI.disabled = val;    
    
    /*STGAP00013919: Disable Special Needs Determination Approval Section when non-recurring only checkbox is checked*/
    /*SMS#109403: enable special needs determination approval for non-recurring only application
    disable Funding Type and Basic Rate
    Check for appropriate mode before calling these widgets to avoid script error because these fields only show in approval mode
    */
	<% if (GlobalData.isApprovalMode(request)) { %>
	   x.selSzCdFundingType.disabled = val;    
	   x.cdBasicRateType[0].disabled = val;
	   x.cdBasicRateType[1].disabled = val;
	   x.cdBasicRateType[2].disabled = val;
	   x.txtNbrCountyAddonAmt.disabled = val;
	   x.txtNbrCustomAmt.disabled = val;
    
    <% } %>
    
    //Mr-60 change
    // SMS#109403: reverting MR-060: removed MR-060 code to enable approval type for SND
  }
  /* SMS#109403: this is called by onClick of Non-Recurring Only cbx to set value of Non-recurring request
  and invoke actions that would be called by an onClick of Non-recurring request.
  This should not be part of onload because we don't want to blindly clear the non-recurring request on page load, 
  for example, monthly app can have non-recurring request and should not be clear by this script
   */
  function setNonRecReq() {
    var x = document.frmSpecialNeedsDetermination;
   	if(x.cbxNonRecOnly.checked)  {
      val = true;
      enableNonRec(); // set $ and disable amount field
      x.hdnNonRecReq.value = 'Y';
    } else {
      val = false;
      disableNonRec(); // clear $ and disable amount field
      x.hdnNonRecReq.value = '';
    }
    <% if (!GlobalData.isApprovalMode(request)) { %>
    x.rbNonRecReq[0].disabled = val;
    x.rbNonRecReq[1].disabled = val;
    <% } %>	
    x.rbNonRecReq[0].checked = val; 
  }
  /* SMS#109403: this is called by onClick of Non-Recurring Request radio button
  to set the hidden field value used by server code
  */
  function setHdnNonRecReq(value) {
    var x = document.frmSpecialNeedsDetermination;
    x.hdnNonRecReq.value = value;
  }
    
  /*STGAP00014563  This function disables county addon and custom*/
  function emptyCountyAddOnCustom(){
    var x = document.frmSpecialNeedsDetermination;
    x.txtNbrCountyAddonAmt.value = '$0.00';
    x.txtNbrCountyAddonAmt.disabled = true;
    x.txtNbrCustomAmt.value = '$0.00';
    x.txtNbrCustomAmt.disabled = true;
  }
  
    /*STGAP00014563  This function disables custom*/
  function emptyCustom(){
    var x = document.frmSpecialNeedsDetermination;
    x.txtNbrCustomAmt.value = '$0.00';
    x.txtNbrCustomAmt.disabled = true;   
  }
  
    /*STGAP00014563  This function disables county add on*/
  function emptyCountyAddon(){
    var x = document.frmSpecialNeedsDetermination;
    x.txtNbrCountyAddonAmt.value = '$0.00';
    x.txtNbrCountyAddonAmt.disabled = true; 
  }
  
    /*STGAP00014563  This function enables custom*/
  function enableCustom(){
    var x = document.frmSpecialNeedsDetermination;
    x.txtNbrCustomAmt.disabled = false;
  }
  
    /*STGAP00014563  This function enables county add on*/
  function enableCountyAddOn(){
    var x = document.frmSpecialNeedsDetermination;
    x.txtNbrCountyAddonAmt.disabled = false;
  }
  
  /*STGAP00014563  Adding this function to enable and disable basic rate section when basic rate request is yes or no*/
  function enableDisableBasicRateType(){
   <% if(CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && canModifyApprovalSections){ %>
    var x = document.frmSpecialNeedsDetermination;
    if(x.rbBasicRateReq[1].checked == true){
        x.cdBasicRateType[0].disabled = true;
        x.cdBasicRateType[0].checked = false;
        
        x.cdBasicRateType[1].disabled = true;
        x.cdBasicRateType[1].checked = false;
        
        x.cdBasicRateType[2].disabled = true;
        x.cdBasicRateType[2].checked = false;
        emptyCustom();
        emptyCountyAddon();
        
        updateDisplayOnlyField("frmSpecialNeedsDetermination", "dspTotalMonthlyAmt", "$0.00");
        
    }else if(x.rbBasicRateReq[0].checked == true){
        x.cdBasicRateType[0].disabled = false;
        x.cdBasicRateType[1].disabled = false;
        x.cdBasicRateType[2].disabled = false;
        enableCustom();
        enableCountyAddOn();
    }
   <%}%>
  }
  
  /*STGAP00014563  Adding this function to enable the date approved when special needs is requested*/
  function enableDateSpcNeedsAprvd(){
    <% if(CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && canModifyApprovalSections){ %>
     var x = document.frmSpecialNeedsDetermination;
     x.txtDtSpecialNeedsApprvd.disabled = false;
     <%}%>
  }
  
  /*STGAP00014563  Adding this function to call when page loads*/
  function disableCountyAddOnCustom(){
    <% if(CodesTables.CEVTSTAT_PEND.equals(spNdsDetRetSO.getCdEventStatus()) && canModifyApprovalSections){ %>
      var x = document.frmSpecialNeedsDetermination;
      if(x.cdBasicRateType[0].checked == true){
        emptyCustom();
        emptyCountyAddon();
      }else if(x.cdBasicRateType[1].checked == true){
        emptyCustom();
      }else if(x.cdBasicRateType[2].checked == true){
        emptyCountyAddon();
      }
      if(x.rbBasicRateReq[1].checked == true){
        enableDisableBasicRateType();
      }
      //MR-60 radio button to drop down change
      if(x.rbCIndRsnSpcNeedsReq.value == null || x.rbCIndRsnSpcNeedsReq.value == "")
      {
         x.txtDtSpecialNeedsApprvd.disabled = true;
      }
   <% } %>
  }
  
  /*STGAP00014563  Adding this function to populate the total monthly amount when basic rate type is selected*/
  function populateTotalMonthly(){
    var x = document.frmSpecialNeedsDetermination;
    if(x.cdBasicRateType[0].checked == true){
      updateDisplayOnlyField("frmSpecialNeedsDetermination", "dspTotalMonthlyAmt", x.dspNbrPostBasicAmt.value);
    }else if(x.cdBasicRateType[1].checked == true){
      var a = x.txtNbrCountyAddonAmt.value.substring(1) * 365 / 12;
      var sum = parseFloat(x.dspNbrPreBasicAmt.value.substring(1)) + roundNumber(a, 2);
      updateDisplayOnlyField("frmSpecialNeedsDetermination", "dspTotalMonthlyAmt", "$"+sum);
    }else if(x.cdBasicRateType[2].checked == true){
      updateDisplayOnlyField("frmSpecialNeedsDetermination", "dspTotalMonthlyAmt", x.txtNbrCustomAmt.value);
    }else{
      updateDisplayOnlyField("frmSpecialNeedsDetermination", "dspTotalMonthlyAmt", "$0.00");
    }
  }
  
  /*STGAP00014563  This function rounds up to two decimals*/
  function roundNumber(num, dec) {
	var result = Math.round(num*Math.pow(10,dec))/Math.pow(10,dec);
	return result;
  }
  
  window.onload = function ()
  {
    disableCountyAddOnCustom();
    enableDisableSpecialNeedsTypeDropDown();
    enableDisableApprovalTypeDropDown();
    goToApprovalSection();
  }
  
/* MR-060 This function sets the hidden variable to true so that it can be used in conversation for creating exclude lists*/
function submitFormOnSpecialNeedsTypePostPreSelection(){
  disableValidation("frmSpecialNeedsDetermination");
  document.frmSpecialNeedsDetermination.hdnBSpecialNeedsTypeChange.value = 'true';
  submitValidateFormNoBypass( "frmSpecialNeedsDetermination", "/financials/SpecialNeedsDetermination/displaySpecialNeedsDetermination" );
}

/*MR-60 This function enables and disables the Special Needs Type drop down*/
function enableDisableSpecialNeedsTypeDropDown(){
   var x = document.frmSpecialNeedsDetermination;
   var checkForNull = document.getElementsByName('rbCdSpcNeedsPrePost');
   if(checkForNull.length > 1 ){
     if(x.rbCdSpcNeedsPrePost[0].checked == true || x.rbCdSpcNeedsPrePost[1].checked == true){
       x.rbCIndRsnSpcNeedsReq.disabled = false;
     }else{
       x.rbCIndRsnSpcNeedsReq.disabled = true;
     }  
   }
}

/*MR-60 This function enables and disables the Approval Type drop down*/
function enableDisableApprovalTypeDropDown(){
   var x = document.frmSpecialNeedsDetermination;
   var checkForNull = document.getElementsByName('rbCdSpcNeedsPrePostAppr');
   if(checkForNull.length > 1){
     if(x.rbCdSpcNeedsPrePostAppr[0].checked == true || x.rbCdSpcNeedsPrePostAppr[1].checked == true){
       x.rbApprovalType.disabled = false;
     }else{
       x.rbApprovalType.disabled = true;
     }  
   }
}

/*This function takes to the Approval section when page reloads after slecting Pre or Post radio buttons in Approval section*/
function goToApprovalSection(){
 <%if(location != null && !"".equals(location)){%>
  location.href="<%= location %>";
 <%}%>
 }
/* SMS#97845 MR-074-2 AFCARS: open new window when user clicks on the question mark in the Incident/Non-Incident Status section of the Approval expandable section */ 
function stayHere() {

  var vertScroll = document.body.scrollTop
  document.body.scrollTop = vertScroll;
}
function displayIncidentStatusHelpText(txt, winName) {

  frmIncidentStatusHelp.<%=ArchitectureConstants.SIMPLE_HELP_TEXT_DISPLAY %>.value=txt;
  frmIncidentStatusHelp.<%=ArchitectureConstants.SIMPLE_HELP_TEXT_WIN_NAME %>.value=winName;
  var txtDispl = window.open('about:blank','txtWin','toolbar=no,location=no,scrollbars=yes,resizable=yes,width=600,height=350');
  frmIncidentStatusHelp.target = "txtWin";
  if( window.focus ) {
    txtDispl.focus();
  }
  frmIncidentStatusHelp.submit();
 } 

</script>
<impact:validateErrors />
<impact:validateForm name="frmSpecialNeedsDetermination" method="post"
	action="/financials/SpecialNeedsDetermination/saveSpecialNeedsDetermination"
	pageMode="<%=pageMode%>"
	validationClass="gov.georgia.dhr.dfcs.sacwis.web.financials.SpecialNeedsDeterminationCustomValidation"
	schema="/WEB-INF/Constraints.xsd">

	<impact:validateInput type="hidden" name="hdnBSpecialNeedsTypeChange"
		value="" />
	<%-- Start the HTML for the page --%>
	<%
	  if (CaseUtility.hasBeenSubmittedForApproval(GlobalData.getUlIdEvent(request))) {
	      String action = ApprovalStatusConversation.DISPLAY_URI;
	      if (GlobalData.isApprovalMode(request)) {
	        action = "/financials/SpecialNeedsDetermination/submitApproval";
	      }

	%>
	<impact:ButtonTag name="btnApprovalStatusFinal" img="btnApprovalStatus"
		form="frmSpecialNeedsDetermination" action="<%=action%>"
		disabled="false" tabIndex="<%=tabIndex%>" />
	<%
	  }
	%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td align="right">
				<a tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;"
					href="javascript:expandAll()">Expand All</a>&nbsp;
				<a tabIndex="<%=tabIndex++%>" onClick="hrefDirtyBypass=true;"
					href="javascript:collapseAll()">Collapse All</a>&nbsp;
			</td>
		</tr>
	</table>
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="6">
				Child Basic Information
			</th>
		</tr>
		<tr>

		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmFirst" label="First"
					value="<%=FormattingHelper.formatString(spNdsDetRetSO.getPersonFirst())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmMiddle" label="Middle"
					value="<%=FormattingHelper.formatString(spNdsDetRetSO.getPersonMiddle())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzNmLast" label="Last"
					value="<%=FormattingHelper.formatString(spNdsDetRetSO.getPersonLast())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspSzDtBirth" label="DOB"
					value="<%=FormattingHelper.formatDate(spNdsDetRetSO.getPersonDOB())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzAge" label="Age"
					value="<%=FormattingHelper.formatInt(spNdsDetRetSO.getPersonAge())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzGender" label="Gender"
					value="<%=Lookup.simpleDecodeSafe(CodesTables.CSEX, spNdsDetRetSO.getPersonGender())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspSzRace" label="Race"
					value="<%=FormattingHelper.formatString(spNdsDetRetSO.getPersonRace())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzEthnicity"
					label="Ethnicity"
					value="<%=FormattingHelper.formatString(spNdsDetRetSO.getPersonEthnicity())%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspSzHomeCounty"
					label="HomeCounty"
					value="<%=FormattingHelper.formatString(homeCnty)%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzBoardingCounty"
					label="BoardingCounty"
					value="<%=FormattingHelper.formatString(boardingCnty)%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspIndIveEligibility"
					label="IV-E Eligibility"
					value="<%=FormattingHelper.formatString(spNdsDetRetSO.getPersonIVEEligibility())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspDtLstEntryFosterCare"
					label="Last Entry into Foster Care"
					value='<%="".equals(FormattingHelper.formatDate(spNdsDetRetSO.getPersonLstEntryFCare())) ? "N/A" : FormattingHelper.formatDate(spNdsDetRetSO.getPersonLstEntryFCare())%>' />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField name="dspSzFCPerDiem"
					label="FC Per Diem Amt"
					value="<%=FormattingHelper.formatMoney(spNdsDetRetSO.getPerDiemRate())%>" />
			</td>
			<td>
				<impact:validateDisplayOnlyField name="dspSzApplicationStatus"
					label="Application Status" value="<%=applicationStatus%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput name="cbxNonRecOnly"
					label="Non-Recurring Only" cssClass="formInput" type="checkbox"
					disabled="<%=indDisablecbxNonRecOnly %>"
					onClick="enabledisableSpecialNeedsBaseRateRequest(); setNonRecReq();"
					checked='<%=ArchitectureConstants.Y.equals(FormattingHelper.formatString(spNdsBean.getIndNonRecOnly())) ? "true" : "false" %>'
					value="<%= ArchitectureConstants.Y %>" />
			</td>
			<td>
				&nbsp;
			</td>
			<% Date dtApproved = spNdsDetRetSO.getDtEventApproved();
			   if(spNdsBean.getDtSpecialNeedsApproved() != null){
			     dtApproved = spNdsBean.getDtSpecialNeedsApproved();
			   }
			   
			 %>
			<td>
				<impact:validateDisplayOnlyField name="dspDtApplicationApproved"
					label="Date Approved"
					value="<%=FormattingHelper.formatDate(dtApproved)%>" />
			</td>
			<td>
				&nbsp;
			</td>
			<td>
				&nbsp;
			</td>
		</tr>
	</table>

	<%-- Begin Special Needs Request --%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="4">
				Special Needs Request
			</th>
		</tr>
		<tr>
			<td colspan="4">
				<table border="0" cellspacing="0" cellpadding="3" width="100%">
					<tr>
						<td>
							Special Needs Type?
						</td>
					</tr>
					<tr class="subDetail">
						<td width="25%" colspan="2">
							<impact:validateInput
								checked='<%=CodesTables.CPLCYCHG_POS.equals(indSpcNdsPrePost) ? "true" : "false"%>'
								disabled="<%=editableMode%>" tabIndex="<%=tabIndex++%>"
								value="POS" type="radio" name="rbCdSpcNeedsPrePost"
								label="Post March 1, 2010" cssClass="formInput"
								onClick="submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableSpecialNeedsTypeDropDown()" />
						</td>
						<td colspan="2">
							<impact:validateInput
								checked='<%=CodesTables.CPLCYCHG_PRE.equals(indSpcNdsPrePost) ? "true" : "false"%>'
								disabled="<%=editableMode%>" tabIndex="<%=tabIndex++%>"
								value="PRE" type="radio" name="rbCdSpcNeedsPrePost"
								label="Pre March 1, 2010" cssClass="formInput"
								onClick="submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableSpecialNeedsTypeDropDown()" />
						</td>
					</tr>
					<tr>
						<td colspan="4">
							<impact:validateSelect label="" name="rbCIndRsnSpcNeedsReq"
								value="<%=indSpNdsReq%>" disabled="<%=editableMode%>"
								orderBy="decode" codesTable="CSPCLTYP"
								onChange="enableDateSpcNeedsAprvd();" tabIndex="<%=tabIndex++%>"
								excludeOptions="<%=excludeSpecialNeedsTypeList%>" />
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td>
				Is the child diagnosed Mentally Retarded?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="mentRet_Yes"
					disabled="<%=editableMode%>" name="rbMentRet" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildMntRetarded())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="mentRet_No"
					name="rbMentRet" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndChildMntRetarded())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtMentRetDiag"
					label="If yes, state diagnoses and attach documentation"
					disabled="<%=editableMode%>" conditionallyRequired="true"
					tabIndex="<%=tabIndex++%>" constraint="Paragraph300"
					maxLength="300" colspan="2" cols="60" rows="5">
					<%=FormattingHelper.formatString(spNdsBean.getTxtCmntsMntRetarded())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				Is the child diagnosed Visually or Hearing Impaired?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="vHImpaired_Yes"
					name="rbVHImpaired" disabled="<%=editableMode%>" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildVisHearingImpaired())) ? "true"
                                                                                                           : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="vHImpaired_No"
					name="rbVHImpaired" value="N" disabled="<%=editableMode%>"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndChildVisHearingImpaired())) ? "true"
                                                                                                           : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtVHImpairedDiag"
					label="If yes, state diagnoses and attach documentation"
					conditionallyRequired="true" tabIndex="<%=tabIndex++%>"
					disabled="<%=editableMode%>" constraint="Paragraph300"
					maxLength="300" colspan="2" cols="60" rows="5">
					<%=FormattingHelper.formatString(spNdsBean.getTxtCmntsVisHearingImpaired())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				Is the child Physically Disabled?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="phyDisabled_Yes"
					name="rbPhyDisabled" value="Y" disabled="<%=editableMode%>"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildPhysicallyDisabled())) ? "true"
                                                                                                           : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="phyDisabled_No"
					name="rbPhyDisabled" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndChildPhysicallyDisabled())) ? "true"
                                                                                                           : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtPhyDisabledDiag"
					label="If yes, state diagnoses and attach documentation"
					conditionallyRequired="true" tabIndex="<%=tabIndex++%>"
					constraint="Paragraph300" disabled="<%=editableMode%>"
					maxLength="300" colspan="2" cols="60" rows="5">
					<%=FormattingHelper.formatString(spNdsBean.getTxtCmntsPhysicallyDisabled())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				Is the child diagnosed Emotionally Disturbed?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="emDisturbed_Yes"
					name="rbEmDisturbed" disabled="<%=editableMode%>" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildEmotionallyDisabled())) ? "true"
                                                                                                            : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="emDisturbed_No"
					name="rbEmDisturbed" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndChildEmotionallyDisabled())) ? "true"
                                                                                                            : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtEmDisturbedDiag"
					label="If yes, state diagnoses and attach documentation"
					conditionallyRequired="true" tabIndex="<%=tabIndex++%>"
					constraint="Paragraph300" disabled="<%=editableMode%>"
					maxLength="300" colspan="2" cols="60" rows="5">
					<%=FormattingHelper.formatString(spNdsBean.getTxtCmntsEmotionallyDisabled())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				Is the child diagnosed with other Medical condition(s)?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes"
					id="othMedCondition_Yes" name="rbOthMedCondition"
					disabled="<%=editableMode%>" value="Y" cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndChildOtherMedical())) ? "true"
                                                                                                     : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No"
					id="othMedCondition_No" name="rbOthMedCondition"
					disabled="<%=editableMode%>" value="N" cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndChildOtherMedical())) ? "true"
                                                                                                     : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtOthMedCondition"
					label="If yes, state diagnoses and attach documentation"
					conditionallyRequired="true" tabIndex="<%=tabIndex++%>"
					constraint="Paragraph300" disabled="<%=editableMode%>"
					maxLength="300" colspan="2" cols="60" rows="5">
					<%=FormattingHelper.formatString(spNdsBean.getTxtCmntsOtherMedical())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea name="txtAdditionalComments"
					label="Additional Comments" tabIndex="<%=tabIndex++%>"
					constraint="Paragraph1000" disabled="<%=editableMode%>"
					maxLength="1000" colspan="2" cols="60" rows="5">
					<%=FormattingHelper.formatString(spNdsBean.getAddComments())%>
				</impact:validateTextArea>
			</td>
		</tr>
	</table>

	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="4">
				Basic Rate Request
			</th>
		</tr>
		<tr>
			<td>
				Is a Basic Adoption Assistance Rate being requested for this child?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="specRateReq_Yes"
					name="rbBasicRateReq" disabled="<%=editableMode%>" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndBasicRateReq())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>"
					onClick="disableSpecialRatesAndServices(); enableDisableBasicRateType(); " />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="specRateReq_No"
					name="rbBasicRateReq" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndBasicRateReq())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>"
					onClick="disableSpecialRatesAndServices(); enableDisableBasicRateType(); " />
			</td>
		</tr>
	</table>
	<%
		          // If in a pending or approved status, show the approval section
		        %>
	<%
	          if ((CodesTables.CEVTSTAT_PEND.equals(eventStatus) && canModifyApprovalSections) || CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
	        %>
	<impact:ExpandableSectionTag name="approval_basic" label="Approval"
		tabIndex="<%=tabIndex++%>" id="">
		<table width="100%" cellspacing="0" cellpadding="3">
			<%
	          if (CodesTables.CSTAGES_PAD.equals(cdStage)) { // SMS#97845 MR-074-2 AFCARS: add incident status selection for application in PAD only
	        %>
			<tr class="subDetail">
				<th colspan="5">
					Incident/Non-Incident Status
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput type="radio" label="Non-Incident Child"
						id="nonIncChild" name="rbIncNonIncStatus"
						disabled="<%=disableIncidentStatus%>" value="N"
						cssClass="formInput"
						checked='<%="N".equals(FormattingHelper.formatString(spNdsDetRetSO.getIndIncidentChild())) ? "true"
                                                                                                        : "false"%>'
						tabIndex="<%=tabIndex++%>" />
					&nbsp;&nbsp;
					<a href="javaScript:stayHere()"
						onClick="hrefDirtyBypass=true;displayIncidentStatusHelpText('At the time of adoption finalization, the child is NOT in the custody of the State/DHS.','Non-Incident Child');">?</a>
				</td>
				<td colspan="2">
					<impact:validateInput type="radio" label="Incident/DFCS Child"
						id="incDFCSChild" name="rbIncNonIncStatus" value="Y"
						disabled="<%=disableIncidentStatus%>" cssClass="formInput"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsDetRetSO.getIndIncidentChild())) ? "true"
                                                                                                        : "false"%>'
						tabIndex="<%=tabIndex++%>" />
					&nbsp;&nbsp;
					<a href="javaScript:stayHere()"
						onClick="hrefDirtyBypass=true;displayIncidentStatusHelpText('At the time of adoption finalization, the child is in the custody of the State/DHS.','Incident/DFCS Child');">?</a>
				</td>
			</tr>
			<%
	          }
	        %>
			<tr class="subDetail">
				<th colspan="5">
					<a NAME="gohere"> Special Needs Determination - Approval </a>
				</th>
			</tr>

			<tr class="subDetail">
				<td colspan="2">
					Is the Special Needs Determination request approved?
				</td>
				<td>
					<impact:validateInput type="radio" label="Yes"
						id="spNdDetReqApprv_Yes" name="rbSpNdDetReqApprv"
						disabled="<%=disabled%>" value="Y" cssClass="formInput"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpcNeedsApproved())) ? "true"
                                                                                                        : "false"%>'
						tabIndex="<%=tabIndex++%>" />
					&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" label="No"
						id="spNdDetReqApprv_No" name="rbSpNdDetReqApprv" value="N"
						disabled="<%=disabled%>" cssClass="formInput"
						checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndSpcNeedsApproved())) ? "true"
                                                                                                        : "false"%>'
						tabIndex="<%=tabIndex++%>" />
					&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" label="Defer"
						id="spNdDetReqApprv_Defer" name="rbSpNdDetReqApprv" value="D"
						disabled="<%=disabled%>" cssClass="formInput"
						checked='<%="D".equals(FormattingHelper.formatString(spNdsBean.getIndSpcNeedsApproved())) ? "true"
                                                                                                        : "false"%>'
						tabIndex="<%=tabIndex++%>" />

				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					Agreement Type:
				</td>
				<td>
					<impact:validateInput type="radio" label="Initial"
						id="agrmtType_Initial" name="rbAgrmtType"
						disabled="<%=disabled%>" cssClass="formInput"
						value="<%=SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_INITIAL%>"
						checked='<%=SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_INITIAL.equals(
													FormattingHelper.formatString(spNdsBean.getIndAgrmtType())) ? "true" : "false"%>'
						tabIndex="<%=tabIndex++%>" />
					&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" label="Amended"
						id="agrmtType_Amended" name="rbAgrmtType"
						value="<%=SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_AMENDED%>"
						disabled="<%=disabled%>" cssClass="formInput"
						checked='<%=SpecialNeedsDeterminationConversation.AGREEMENT_TYPE_AMENDED.equals(
													FormattingHelper.formatString(spNdsBean.getIndAgrmtType())) ? "true" : "false"%>'
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<!-- SMS#109403: moved Date Approved field from bottom of the section to emphasize this field applies to the entire Approval section -->
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateDate name="txtDtSpecialNeedsApprvd"
						label="Date Approved" constraint="Date" tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(spNdsBean.getDtSpecialNeedsApproved())%>"
						disabled="<%=disabled%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateSelect style="WIDTH: 380px" label="Funding Type"
						name="selSzCdFundingType"
						value="<%=FormattingHelper.formatString(fundingType)%>"
						disabled="<%=disabled%>" codesTable="CAAFDTYP"
						tabIndex="<%=tabIndex++%>" excludeOptions="<%=excludeOption%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<span class="formCondRequiredText">&#8225;</span>Approval Type:
				</td>
				<td colspan="2"></td>
			</tr>
			<tr class="subDetail">
				<td colspan="2" width="25%">
					<impact:validateInput
						checked='<%=CodesTables.CPLCYCHG_POS.equals(indSpcNdsPrePostAppr) ? "true" : "false"%>'
						disabled="<%=disabled%>" tabIndex="<%=tabIndex++%>" value="POS"
						type="radio" name="rbCdSpcNeedsPrePostAppr"
						label="Post March 1, 2010" cssClass="formInput"
						onClick="submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableApprovalTypeDropDown()" />
				</td>
				<td colspan="2">
					<impact:validateInput
						checked='<%=CodesTables.CPLCYCHG_PRE.equals(indSpcNdsPrePostAppr) ? "true" : "false"%>'
						disabled="<%=disabled%>" tabIndex="<%=tabIndex++%>" value="PRE"
						type="radio" name="rbCdSpcNeedsPrePostAppr"
						label="Pre March 1, 2010" cssClass="formInput"
						onClick="submitFormOnSpecialNeedsTypePostPreSelection(); enableDisableApprovalTypeDropDown()" />
				</td>

			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateSelect label="" name="rbApprovalType"
						value="<%=indSpNdsAppr%>" disabled="<%=disabled%>"
						orderBy="decode" codesTable="CSPCLTYP" tabIndex="<%=tabIndex++%>"
						excludeOptions="<%=excludeSpecialNeedsTypeApprList%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateInput label="Mentally Retarded"
						name="cbxMentRetarded" type="checkbox" value="Y"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvMntRetarded())) ? "true"
                                                                                                        : "false"%>'
						disabled="<%=disabled%>" cssClass="formInput"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateInput label="Visually or Hearing Impaired"
						name="cbxVHImpaired" type="checkbox" value="Y"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvHearingImpaired())) ? "true"
                                                                                                            : "false"%>'
						disabled="<%=disabled%>" cssClass="formInput"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateInput label="Physically Disabled"
						name="cbxPhysDisabled" type="checkbox" value="Y"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvPhysicallyDisabled())) ? "true"
                                                                                                               : "false"%>'
						disabled="<%=disabled%>" cssClass="formInput"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateInput label="Emotionally Disturbed"
						name="cbxEmDisturbed" type="checkbox" value="Y"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvEmotionalDist())) ? "true"
                                                                                                          : "false"%>'
						disabled="<%=disabled%>" cssClass="formInput"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="4">
					<impact:validateInput label="Other Medical Conditions"
						name="cbxOthMedCond" type="checkbox" value="Y"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndApprvOther())) ? "true" : "false"%>'
						disabled="<%=disabled%>" cssClass="formInput"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<b> Basic Rate - Type </b>
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="5">
					<table width="100%" cellspacing="0" cellpadding="3" border="0">
						<tr class="subDetail">
							<td width="35%">
								<impact:validateInput type="radio"
									label="Negotiated Post July 1, 2009 Rate"
									id="cdBasicRateType_Pos" name="cdBasicRateType"
									conditionallyRequired="true" disabled="<%=disabled%>"
									value="POS" cssClass="formInput"
									checked='<%=CodesTables.CBRTYPE_POS.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType())) ? "true"
                                                                                                        : "false"%>'
									tabIndex="<%=tabIndex++%>"
									onClick="emptyCountyAddOnCustom(); populateTotalMonthly();" />
							</td>
							<td>
								<impact:validateDisplayOnlyField name="dspNbrPostBasicAmt"
									label=""
									value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrPostBasicAmt())%>" />
							</td>
						</tr>
						<tr class="subDetail">
							<td width="35%">
								<impact:validateInput type="radio"
									label="Negotiated Pre July 1, 2009 Rate"
									id="cdBasicRateType_Pre" name="cdBasicRateType"
									conditionallyRequired="true" value="PRE"
									disabled="<%=disabled%>" cssClass="formInput"
									checked='<%=CodesTables.CBRTYPE_PRE.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType())) ? "true"
                                                                                                       : "false"%>'
									tabIndex="<%=tabIndex++%>"
									onClick="emptyCustom(); populateTotalMonthly(); enableCountyAddOn();" />
							</td>
							<td>
								<impact:validateDisplayOnlyField name="dspNbrPreBasicAmt"
									label=""
									value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrPreBasicAmt())%>" />
							</td>
						</tr>
						<tr class="subDetail">
							<td width="35%">
								<impact:validateInput type="text" label="County Add On(Daily)"
									constraint="Money" name="txtNbrCountyAddonAmt"
									conditionallyRequired="true" cssClass="formInput"
									disabled="<%=disabled%>"
									value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrCountyAddonAmt())%>"
									size="10" maxLength="10" tabIndex="<%=tabIndex++%>"
									onChange="populateTotalMonthly();" />
							</td>
							<td></td>
						</tr>
						<tr class="subDetail">
							<td width="35%">
								<impact:validateInput type="radio"
									label="Negotiated Custom Rate" id="cdBasicRateType_Cus"
									name="cdBasicRateType" conditionallyRequired="true" value="CUS"
									disabled="<%=disabled%>" cssClass="formInput"
									checked='<%=CodesTables.CBRTYPE_CUS.equals(FormattingHelper.formatString(spNdsBean.getCdBasicRateType())) ? "true"
                                                                                                : "false"%>'
									tabIndex="<%=tabIndex++%>"
									onClick="emptyCountyAddon(); populateTotalMonthly(); enableCustom();" />
							</td>
							<%if (cusSelected) {%>
							<td>
								<impact:validateInput type="text" label="" constraint="Money"
									name="txtNbrCustomAmt" cssClass="formInput"
									disabled="<%=disabled%>"
									value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrBasicAmt())%>"
									size="10" maxLength="10" tabIndex="<%=tabIndex++%>"
									onChange="populateTotalMonthly();" />
							</td>
							<%}else { %>
							<td>
								<impact:validateInput type="text" label="" constraint="Money"
									name="txtNbrCustomAmt" cssClass="formInput"
									disabled="<%=disabled%>"
									value="<%=FormattingHelper.formatMoney(0)%>" size="10"
									maxLength="10" tabIndex="<%=tabIndex++%>"
									onChange="populateTotalMonthly();" />
							</td>
							<%} %>
						</tr>

						<tr class="subDetail">
							<td width="35%">
								<impact:validateDisplayOnlyField name="dspTotalMonthlyAmt"
									label="Total Monthly Amount"
									value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrMonthlyAmt())%>" />
							</td>
							<td></td>
							<td></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%
	       } // End Basic Approval Section
	     %>


	<br>
	<!-- -Specialized Rate Adoption Assistance Requests -->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="4">
				Specialized Rate Request
			</th>
		</tr>
		<tr>
			<td>
				Is a Specialized Rate being requested for this child?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="specRateReq_Yes"
					name="rbSpecRateReq" disabled="<%=editableMode%>" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpecializedRateReq())) ? "true"
                                                                                                      : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="specRateReq_No"
					name="rbSpecRateReq" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndSpecializedRateReq())) ? "true"
                                                                                                      : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				Is the child receiving Specialized Foster Care (SFC) Per Diem, RBWO
				rate (Child Caring Institution) or RBWO Waiver rate (Child Placing
				Agency)?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes" id="rbSFCorRBWO_Yes"
					name="rbSFCorRBWO" disabled="<%=editableMode%>" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndSFCorRBWO())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="rbSFCorRBWO_No"
					name="rbSFCorRBWO" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndSFCorRBWO())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<span class="formCondRequiredText">&#135;</span>Check all
				documentation being attached:
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<impact:validateInput
					label="Psychological Evaluation (within last 2 years)"
					name="cbxPsychological" type="checkbox"
					disabled="<%=editableMode%>" value="Y"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocPsychological())) ? "true" : "false"%>'
					cssClass="formInput" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<impact:validateInput
					label="Developmental Assessment/Evaluation(within last year)"
					name="cbxDevAssmtEval" type="checkbox" value="Y"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocDevelopmentalAssmt())) ? "true"
                                                                                                         : "false"%>'
					disabled="<%=editableMode%>" cssClass="formInput"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<impact:validateInput
					label="Documentation from Treatment provider(within last 90 days)"
					name="cbxTrtmntPrvdr" type="checkbox" value="Y"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocTrtmntPrvdr())) ? "true" : "false"%>'
					disabled="<%=editableMode%>" cssClass="formInput"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<impact:validateInput
					label="Medical Assessment(within last 90 days)" name="cbxMedAssmnt"
					type="checkbox" value="Y"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocMentalAssmt())) ? "true" : "false"%>'
					disabled="<%=editableMode%>" cssClass="formInput"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td></td>
			<td>
				<impact:validateInput label="SSI Documentation" name="cbxSSI"
					type="checkbox" value="Y"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndDocSSI())) ? "true" : "false"%>'
					disabled="<%=editableMode%>" cssClass="formInput"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>

	</table>
	<br>

	<!-- Non-Recurring Request-->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr class="subDetail">
			<th colspan="4">
				Non-Recurring Request
			</th>
		</tr>
		<tr class="subDetail">
			<td colspan="2">
				Is a Non-Recurring/510 Funding Type being requested for this child?
			</td>
			<td colspan="1">
				<impact:validateInput type="radio" label="Yes" id="nonRecReq_Yes"
					name="rbNonRecReq" disabled="<%=disableNonRecurring%>" value="Y"
					cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecRequested())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" onClick="enableNonRec(); setHdnNonRecReq('Y');" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="nonRecReq_No"
					name="rbNonRecReq" disabled="<%=disableNonRecurring%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecRequested())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" onClick="disableNonRec(); setHdnNonRecReq('N');" />
			</td>
			<td></td>
			<impact:validateInput type="hidden" name="hdnNonRecReq" value="<%=FormattingHelper.formatString(spNdsBean.getIndNonRecRequested()) %>" />
		</tr>
		<tr class="subDetail">
			<td colspan="2">
				<impact:validateInput type="text" label="<%= totalNonRecLable %>"
					constraint="Money" name="txtNonRecAmtReq" cssClass="formInput"
					disabled="<%=disableNonRecurring%>"
					value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrNonRecAmt())%>"
					size="10" maxLength="10" tabIndex="<%=tabIndex++%>" />

			</td>
			<td></td>
		</tr>
	</table>
	<br>

	<!-- Special Services Request -->
	<table border="0" cellspacing="0" cellpadding="3" width="100%"
		class="tableBorder">
		<tr>
			<th colspan="4">
				Special Services Request
			</th>
		</tr>
		<tr>
			<td>
				Is a Special Service being requested for this child?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes"
					id="specServiceReq_Yes" name="rbSpecServiceReq"
					disabled="<%=editableMode%>" value="Y" cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpclServiceReq())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" onClick="enableSpcSrvReq()" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="specServiceReq_No"
					name="rbSpecServiceReq" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndSpclServiceReq())) ? "true" : "false"%>'
					tabIndex="<%=tabIndex++%>" onClick="disableSpcSrvReq()" />
			</td>
		</tr>
		<tr>
			<td>
				Has all required documentation been attached?
			</td>
			<td>
				<impact:validateInput type="radio" label="Yes"
					id="indDocAttached_Yes" name="rbIndDocAttached"
					disabled="<%=editableMode%>" value="Y" cssClass="formInput"
					checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndAllSpecialDocAttached())) ? "true"
                                                                                                         : "false"%>'
					tabIndex="<%=tabIndex++%>" />
				&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
				<impact:validateInput type="radio" label="No" id="indDocAttached_No"
					name="rbIndDocAttached" disabled="<%=editableMode%>" value="N"
					cssClass="formInput"
					checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndAllSpecialDocAttached())) ? "true"
                                                                                                         : "false"%>'
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text" label="Requested Amount"
					constraint="Money" conditionallyRequired="true" name="txtSzReqAmt"
					cssClass="formInput" disabled="<%=editableMode%>"
					value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrReqAmt())%>"
					size="10" maxLength="10" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateSelect style="WIDTH: 320px"
					label="Special Service Type" name="selSzCdSpecServType"
					conditionallyRequired="true"
					value="<%=FormattingHelper.formatString(spNdsBean.getCdSpclSerType())%>"
					disabled="<%=editableMode%>" codesTable="CSPLSERV"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateTextArea colspan="2" name="txtPlSpecify"
					label="Please Specify" rows="5" maxLength="1000" cols="60"
					disabled="false" conditionallyRequired="true"
					disabled="<%=editableMode%>" tabIndex="<%=tabIndex++%>"
					constraint="Paragraph1000">
					<%=FormattingHelper.formatString(spNdsBean.getTxtPleaseSpecify())%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput type="text"
					label="Number of Special Needs children included in the Respite Request"
					conditionallyRequired="true" name="txtSzNumSPNChildReq"
					cssClass="formInput" disabled="<%=editableMode%>"
					value='<%=spNdsBean.getNbrSpNeedsChildrenRequest() != null ? FormattingHelper.formatInt(spNdsBean.getNbrSpNeedsChildrenRequest()) : "" %>'
					size="2" maxLength="2" tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<br>

	<%
		  // If in a pending or approved status, show the approval section
		%>
	<%
	  if ((CodesTables.CEVTSTAT_PEND.equals(eventStatus) && canModifyApprovalSections) || CodesTables.CEVTSTAT_APRV.equals(eventStatus))  {
	%>
	<impact:ExpandableSectionTag name="approval_special" label="Approval"
		tabIndex="<%=tabIndex++%>" id="">
		<table width="100%" cellspacing="0" cellpadding="3">
			<tr class="subDetail">
				<th colspan="4">
					Specialized Rate - Approval
				</th>
			</tr>
			<tr class="subDetail">
				<td>
					Is the Specialized Rate for Adoption Assistance approved?
				</td>
				<td>
					<impact:validateInput type="radio" label="Yes"
						id="specRateAprv_Yes" name="rbSpecRateAprv" value="Y"
						disabled="<%=disabled%>" cssClass="formInput"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpclRateAdoAppr())) ? "true"
                                                                                                       : "false"%>'
						tabIndex="<%=tabIndex++%>" onClick="enableTotalAprvAmt()" />
					&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" label="No" id="specRateAprv_No"
						name="rbSpecRateAprv" disabled="<%=disabled%>" value="N"
						cssClass="formInput"
						checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndSpclRateAdoAppr())) ? "true"
                                                                                                       : "false"%>'
						tabIndex="<%=tabIndex++%>" onClick="clearTotalAprvAmt()" />
				</td>
				<td>
					&nbsp;
				</td>
			</tr>
			<tr class="subDetail">
				<td>
					<impact:validateInput type="text"
						label="Approved Negotiated Amount" constraint="Money"
						conditionallyRequired="true" name="txtSzTotalAprvAmt"
						cssClass="formInput"
						value='<%=(((spNdsBean.getNbrTotalIveIvbAmt() != null) && (spNdsBean.getNbrTotalIveIvbAmt() > 0)) ? FormattingHelper.formatMoney(spNdsBean.getNbrTotalIveIvbAmt()) : "")%>'
						disabled="<%=disabled%>" size="10" maxLength="10"
						tabIndex="<%=tabIndex++%>" />
				</td>
				<td>
					*This is the total monthly amount.
				</td>
			</tr>
		</table>

		<table width="100%" cellspacing="0" cellpadding="3">
			<tr class="subDetail">
				<th colspan="4">
					Non-Recurring - Approval
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					Is the Non-Recurring/510 Funding Type for Adoption Assistance
					approved?
				</td>
				<td colspan="2">
					<impact:validateInput type="radio" label="Yes"
						id="nonRecReqAprv_Yes" name="rbNonRecReqAprv" value="Y"
						disabled="<%=disableNonRecurringAprv%>" cssClass="formInput"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecApproved())) ? "true"
                                                                                                       : "false"%>'
						tabIndex="<%=tabIndex++%>" onClick="enableApvrNonRec()" />
					&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" label="No" id="nonRecReqAprv_No"
						name="rbNonRecReqAprv" disabled="<%=disableNonRecurringAprv%>"
						value="N" cssClass="formInput"
						checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndNonRecApproved())) ? "true"
                                                                                                       : "false"%>'
						tabIndex="<%=tabIndex++%>" onClick="disableAprvNonRec()" />
				</td>
				<td></td>
			</tr>
			<tr class="subDetail">
				<td colspan="3">
					<impact:validateInput type="text" label="Total Approved Amount"
						constraint="Money" name="txtSzNonRecReqTotalAprvAmt"
						cssClass="formInput"
						value='<%=(((spNdsBean.getNbrNonRecAprvAmt() != null) && (spNdsBean.getNbrNonRecAprvAmt() > 0)) ? FormattingHelper.formatMoney(spNdsBean.getNbrNonRecAprvAmt()) : "")%>'
						disabled="<%=disableNonRecurringAprv%>" size="10" maxLength="10"
						tabIndex="<%=tabIndex++%>" />
				</td>
				<td></td>
			</tr>
		</table>

		<table width="100%" cellspacing="0" cellpadding="3">
			<tr class="subDetail">
				<th colspan="4">
					Special Service - Approval
				</th>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					Is the Special Service Request approved?
				</td>
				<td>
					<impact:validateInput type="radio" label="Yes"
						id="specServReqAprv_Yes" name="rbSpecServReqAprv" value="Y"
						disabled="<%=disabled%>" cssClass="formInput"
						checked='<%="Y".equals(FormattingHelper.formatString(spNdsBean.getIndSpclReqApproved())) ? "true"
                                                                                                       : "false"%>'
						tabIndex="<%=tabIndex++%>" onClick="enableSpcSrvReqAprv()" />
					&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;
					<impact:validateInput type="radio" label="No"
						id="specServReqAprv_No" name="rbSpecServReqAprv" value="N"
						disabled="<%=disabled%>" cssClass="formInput"
						checked='<%="N".equals(FormattingHelper.formatString(spNdsBean.getIndSpclReqApproved())) ? "true"
                                                                                                       : "false"%>'
						tabIndex="<%=tabIndex++%>" onClick="disableSpcSrvReqAprv()" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateSelect style="WIDTH: 320px"
						label="Special Service Type and Funding"
						name="selSzCdSpServFundingType"
						value="<%=FormattingHelper.formatString(spNdsBean.getCdApprvSpclTypeFunding())%>"
						disabled="<%=disabled%>" codesTable="CSPLSERV"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateInput type="text" label="Approved Amount"
						constraint="Money" conditionallyRequired="true"
						name="txtSzAprvAmt" cssClass="formInput"
						value="<%=FormattingHelper.formatMoney(spNdsBean.getNbrApprvAmt())%>"
						size="10" maxLength="10" disabled="<%=disabled%>"
						tabIndex="<%=tabIndex++%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateDate name="txtDtDtAprvDate" label="Approval Date"
						constraint="Date" conditionallyRequired="true"
						tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(spNdsBean.getDtApprvDate())%>"
						disabled="<%=disabled%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateDate name="txtDtDtExpDate" label="Expiration Date"
						constraint="Date" conditionallyRequired="true"
						tabIndex="<%=tabIndex++%>"
						value="<%=FormattingHelper.formatDate(spNdsBean.getDtExpirationDate())%>"
						disabled="<%=disabled%>" />
				</td>
			</tr>
			<tr class="subDetail">
				<td colspan="2">
					<impact:validateTextArea colspan="2"
						name="txtSzTxtSpcServAprvCmmts" label="Comments" rows="5"
						maxLength="300" cols="60" disabled="false"
						disabled="<%=disabled%>" tabIndex="<%=tabIndex++%>"
						constraint="Paragraph300">
						<%=FormattingHelper.formatString(spNdsBean.getTxtComments())%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
	</impact:ExpandableSectionTag>
	<%
            } //End Specialized Approval Section
          %>
	<br />
	<table width="100%" border="0" cellspacing="0" cellpadding="3"
		cellspacing="0">
		<tr>
			<%//STGAP00014044: Do not show this button for the Approver
				    if ((CodesTables.CEVTSTAT_PEND.equals(eventStatus) && canModifyApprovalSections) || CodesTables.CEVTSTAT_APRV.equals(eventStatus))  {
				   %>
			<td></td>
			<%}else{%>
			<td width="95%">
				<impact:ButtonTag name="btnSaveSubmit" img="btnSaveAndSubmit"
					restrictRepost="true" align="right"
					form="frmSpecialNeedsDetermination"
					disabled="<%=indBtnSaveSubmit%>"
					action="/financials/SpecialNeedsDetermination/saveSpecialNeedsDetermination"
					tabIndex="<%=tabIndex++%>" />
			</td>
			<%} %>
			<td width="5%">
				<impact:ButtonTag name="btnSave" img="btnSave" align="right"
					restrictRepost="true" form="frmSpecialNeedsDetermination"
					disabled="<%=indBtnSave%>"
					action="/financials/SpecialNeedsDetermination/saveSpecialNeedsDetermination"
					tabIndex="<%=tabIndex++%>" />
			</td>
		</tr>
	</table>
	<%
			  /*  Always include this hidden field in your form */
			%>

	<input type="hidden" name="hdnHasCurrentEligibility"
		value="<%=spNdsDetRetSO.hasCurrentEligibility() %>" />
	<input type="hidden" name="hdnEventStatus"
		value="<%=spNdsDetRetSO.getCdEventStatus() %>" />
	<input type="hidden" name="hdnFirstApplication"
		value="<%=spNdsDetRetSO.isBFirstApplication() %>" />
	<input type="hidden" name="hdnPriorAprvSpecialNeedsDeter"
		value="<%=spNdsDetRetSO.isBPriorAprvSpecialNeedsDeter() %>" />
	<input type="hidden" name="specialNeedsNotReq"
		value="<%=specialNeedsNotReq%>" />
	<input type="hidden" name="reason" value="<%=reason%>" />
	<input type="hidden" name="hdnApprover"
		value="<%=canModifyApprovalSections %>" />
	<input type="hidden"
		name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>" />
	<%
			  /* Close Validate Form Custom Tag */
			%>
</impact:validateForm>
<!-- SMS#97845 MR-074-2 AFCARS: define help text window form -->
<form name="frmIncidentStatusHelp" method="post"
	action="/financials/SpecialNeedsDetermination/displayIncidentStatusHelpText">
	<input type="hidden"
		name="<%=ArchitectureConstants.SIMPLE_HELP_TEXT_DISPLAY %>" value="" />
	<input type="hidden"
		name="<%=ArchitectureConstants.SIMPLE_HELP_TEXT_WIN_NAME %>" value="" />
</form>
<%
        //STGAP00010838: Added the forms and reports section to launch the Special Services Adoption Assistance Agreement form
        // SMS #109403: MR-082 Updated this condition to display the Form display; the Form section will be displayed
        // as a blank dropdown (such as Adoption Assistance Agreement page) when the condition to launch the form(s) does not meet 
        if (spNdsDetRetSO != null) {
      %>
<table border="0" cellspacing="0" cellpadding="3" width="100%"
	class="tableBorder">
	<tr>
		<th colspan="4">
			Form Launch
		</th>
	</tr>
	<tr>
		<td>
			<impact:documentList pageMode="<%=pageMode%>"
				tabIndex="<%=tabIndex++%>">
				<%
				  if (ArchitectureConstants.Y.equals(spNdsBean.getIndSpclServiceReq())) {
				        String documentFormName = "ado01O00" + String.valueOf(spNdsDetRetSO.getUlIdChild());
				%>
				<impact:document
					displayName="Special Services Adoption Assistance Agreement"
					protectDocument="true" checkForNewMode="false" docType="ado01O00"
					docExists="true">
					<impact:documentParameter name="pCase"
						value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
					<impact:documentParameter name="pStage"
						value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
					<impact:documentParameter name="pEvent"
						value="<%=String.valueOf(spNdsDetRetSO.getUlIdEvent())%>" />
					<impact:documentParameter name="pPerson"
						value="<%=String.valueOf(spNdsDetRetSO.getUlIdChild())%>" />
				</impact:document>
				<%
				  } else if (spNdsDetRetSO != null && CodesTables.CSTAGES_PAD.equals(cdStage) 
				  && ArchitectureConstants.Y.equals(spNdsBean.getIndSpcNeedsApproved())
				  && ArchitectureConstants.Y.equals(spNdsBean.getIndNonRecOnly())
				  && ArchitectureConstants.Y.equals(spNdsBean.getIndNonRecApproved()) 
				  && CodesTables.CEVTSTAT_APRV.equals(eventStatus))	{
				%>
				<impact:document
					displayName="Non-Recurring Only Adoption Assistance Agreement"
					protectDocument="true" docType="nonrecuronlyaaagrmnt"
					preFillAlways="true" docExists="true">
					<impact:documentParameter name="pPerson"
						value="<%=String.valueOf(spNdsDetRetSO.getUlIdChild())%>" />
					<impact:documentParameter name="pStage"
						value="<%=String.valueOf(GlobalData.getUlIdStage(request))%>" />
					<impact:documentParameter name="pCase"
						value="<%=String.valueOf(GlobalData.getUlIdCase(request))%>" />
					<impact:documentParameter name="pEvent"
						value="<%=String.valueOf(spNdsDetRetSO.getUlIdEvent())%>" />
				</impact:document>
				<%
				  }
				%>
			</impact:documentList>
		</td>
	</tr>
</table>
<%
	  }
	%>
<script type="text/javascript" language="JavaScript1.2">
      window.attachEvent('onload', disableSpecialRatesAndServices);
    </script>