<%--
//*  JSP Name: PaymentOfCare.jsp
//*  Created by:   Steven Thrasher
//*  Date Created: 3/6/2007
//*
//*  Description:
//*
//*
//* Change History:
//*  Date      User              Description
//*  --------  ----------------  --------------------------------------------------
//*	 9/4/07		vvo		         STGAP00005190 - added onChange for Terminate Date (cannot be greater than End Date)
//*  03/25/08   vdevarak         STGAP00006420 - Modified code to check the indicator if the user has special
//*                                              access to modify Approved Placements and enable the fields accordingly.
//*  11/14/08   arege            STGAP00010758 - Modified code so that the SaveAndSubmit button is not displayed for the 
//*                                              Supervisor in approval mode.
//*  12/30/08   arege            STGAP00007592 - Added constraint="Double" attribute to  txtFcRbwoWaiver tag to resolve
//*                                              a Stack Trace.
//*  04/21/09   arege            STGAP00013397 - Added changes for MR- 033 Relative Care Invoicing Changes.
//*  05/08/09   arege            STGAP00013397 - Added changes for MR- 033 Relative Care Invoicing Changes.
//*  06/08/09   arege            STGAP00014111 - New waiver options fields need radio buttons not check boxes.
//*  06/09/09   arege            STGAP00014111 - Disabled the Custom Waiver option and the Waiver Amount field 
//*                                              for release 3.1, these fields may be used in the future releases.
//*  07/01/09   hjbaptiste       STGAP00014561 - Added the navAwayCk attribute to the Approval Status button to check to see 
//*                                              if the page is dirty when the button is pressed. Added a null check in the 
//*                                              javascript function setWaiverAmountMode() to prevent script error when the 
//*                                              waiver options radio buttons are disabled.
//*  07/02/09   arege            STGAP00014315 - Added code to include Enhanced Relative Care Subsidy to include the same 
//*                                              dynamic behavior as the enhanced subsidized guardianship
//*                                              and enhanced non-relative subsidized guardianship
//*  07/29/09   arege            STGAP00014315 - Disable the functionality added with defect STGAP00014315 
//*  09/11/09   arege            STGAP00015311 - MR-036 Need to enable the custom waiver feature
//*  08/10/10   wjcochran        SMS #64906: Enable Custom and 100% waiver on payment of care
//*  05/21/11   hnguyen          SMS#109407: MR-087 Added new checkbox for child turns 18 for RCS and ERCS. Added help text link.
//*                              Changed Court Review Date to Court Review Due By. Added client-side script to clear court
//*                              review due by date if child turn 18 checkbox is selected. Turned on client-side validation.
//*                              Also added new display only Resource id field.
//*  06/13/11   hnguyen          SMS#109407: MR-087 Removed Name30 constraint for read-only Placement Resource name field.
//*  06/17/11   hnguyen          SMS#109407: MR-087 Corrected onload function calls order. Also to not display or call js functions if approved.
//*
--%>

<%@ taglib uri="/WEB-INF/impact.tld" prefix="impact"%>

<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper" %>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.message.Messages"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper"%>
<%@ page import="gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode"%>
<%@ page import="java.util.Collections"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.Arrays" %>
<%@ page import="java.util.List"%>
<%//*******************************
      //*** DECLARE LOCAL VARIABLES ***
      //*******************************
      boolean approvalStatus = false;
      BaseSessionStateManager state = (BaseSessionStateManager) request
                                                                       .getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
      UserProfile user = UserProfileHelper.getUserProfile(request);
      String pocType = FormattingHelper.formatString("");
      String hdnPersonId = FormattingHelper.formatString("");
      int tabIndex = 1;
      String indRbwoType = FormattingHelper.formatString("");
      String disablePocType = "false";
      String txtStartDate = "";
      String txtEndDate = "";
      String displayEndDate = "";
      String txtTermDate = "";
      String txtPerDiem = "";
      String txtTotalPerDiem = "";
      String txtSpecialRate = "";
      String cbxConcPerDiem = "";
      String txtReasonConcPerDiem = "";
      String txtReasonSpecPerDiem = "";
      String txtEnhancedRelativeRate = "";
      String txtPacketComp = "";
      boolean displayContinue = true;
      String txtRelative = "";
      String idRelative = "";
      String levelPocType = "false";
      String rbwoTypeInitial = ArchitectureConstants.FALSE;
      String rbwoTypeReview = ArchitectureConstants.FALSE;
      String rbwoTypeEmergency = ArchitectureConstants.FALSE;
      String txtPersComp = "";
      String idPersComp = "";
      String persCompTitle = "";
      String txtPackEmergAppr = "";
      String txtSuprvApprv = "";
      String suprvsrApprvTitle = "";
      String idSuprvApprv = "";
      String txtStaffComp = "";
      String txtPacketSent = "";
      String txtSOResponse = "";
      String txtSOStaffApprv = "";
      String soStaffApprvTitle = "";
      String idSOStaffApprv = "";
      String rbwoStaffApprvTitle = "";
      String txtRBWOStaffApprv = "";
      String txtRBWOReview = "";
      String idRBWOStaffApprv = "";
      String txtFcRbwoWaiver = "";
      String indRcsType = "";
      String rcsTypeInitial = ArchitectureConstants.FALSE;
      String rcsTypeRenewal = ArchitectureConstants.FALSE;
      String txtCourtReviewDate = "";
      String txtRenewalDate = "";
      String displayRenewalDate = "";
      String txtEffPayDate = "";
      String txtAnnualReviewDate = "";
      String txtAgreeDate = "";
      String monthlySubsidy = "";
      // MR-087 Added Child turns 18 checkbox
      String cbx18ByNextCrtRvw = "";
      String cbxFamIncLess = "";
      String cbxSuspend = "";
      String cbxTerminate = "";
      String txtReasonSuspTerm = "";
      String txtReasonSpecWaiver = "";
      String reasonSpecAddOnDisabled = "false";
      String terminateDateDisabled = "false";
      String specialAddOnRateDisabled = "false";
      String endDateDisabled = "false";
      String startDateDisabled = "false";
      String ulIdStage = "";
      String cdTask = GlobalData.getSzCdTask(request);
      String indProgramType = "";
      String rbwoProgramType = "";
      String rbwoProgramTypeCodesTable = "";
      
      //STGAP00013397
      String notEsgOrNeg = ArchitectureConstants.TRUE;
      String txtWaiverReason = StringHelper.EMPTY_STRING;
      String txtWavierAmount = StringHelper.EMPTY_STRING;
                   
      //STGAP00006420:Added the if check to see if the user has special access to modify
      // an approved Payment of Care.
      boolean modifyApproveAccess = false;
      if(user.hasRight(UserProfile.SEC_MODIFY_APPRV_PLCMT) && GlobalData.hasStageAccess(request)){
           modifyApproveAccess = true;
      }
      
      boolean saveAndSubmit = true;
      if(GlobalData.isApprovalMode(request)){
      saveAndSubmit = false;
      }
      
      //**************************
      //*** RETRIEVE PAGE DATA ***
      //**************************
      PaymentOfCareRetrieveSO paymentOfCareRetrieve = null;

      paymentOfCareRetrieve = (PaymentOfCareRetrieveSO) state.getAttribute("pocRetrieve", request);

      String hdnIdEvent = String.valueOf(GlobalData.getUlIdEvent(request));

      String pageMode = PageMode.getPageMode(request);

      if (paymentOfCareRetrieve != null) {
        if (paymentOfCareRetrieve.isApprovalStatus() && (paymentOfCareRetrieve.getUlIdEvent() != 0)) {
          approvalStatus = true;
        }
        pocType = paymentOfCareRetrieve.getPocType();
        txtStartDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getStartDate());
        txtEndDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getEndDate());
        txtTermDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtTerminate());

        if (paymentOfCareRetrieve.getSpecialRate() != 0) {
          txtSpecialRate = FormattingHelper.formatDouble(paymentOfCareRetrieve.getSpecialRate(),2);
        } else {
          txtSpecialRate = "";
        }        
        //STGAP00013397 MR-033
        if (paymentOfCareRetrieve.getWaiverAmount() != 0) {
          txtWavierAmount = FormattingHelper.formatDouble(paymentOfCareRetrieve.getWaiverAmount(),2);
        } else {
          txtWavierAmount = StringHelper.EMPTY_STRING;
        }      
        txtWaiverReason =  paymentOfCareRetrieve.getTxtWaiverReason();
          //END STGAP00013397 MR-033
        cbxConcPerDiem = paymentOfCareRetrieve.getIndConcurrentPerDiem();
        indRbwoType = paymentOfCareRetrieve.getIndRbwoType();
        txtReasonConcPerDiem = paymentOfCareRetrieve.getTxtReasonConcurrentPD();
        txtReasonSpecPerDiem = paymentOfCareRetrieve.getTxtReasonSpecializedPD();

        monthlySubsidy = FormattingHelper.formatDouble(paymentOfCareRetrieve.getSubsidyPerDiem(),2);

        if (paymentOfCareRetrieve.getPerDiemRate() == 0) {
          txtPerDiem = "";
        } else {
          txtPerDiem = FormattingHelper.formatDouble(paymentOfCareRetrieve.getPerDiemRate(),2);
        }

        if (paymentOfCareRetrieve.getEnhancedRelRate() == 0) {
          txtEnhancedRelativeRate = "";
        } else {
          txtEnhancedRelativeRate = FormattingHelper.formatDouble(paymentOfCareRetrieve.getEnhancedRelRate(),2);
        }

        if (paymentOfCareRetrieve.getTotalPerDiemRate() == 0) {
          txtTotalPerDiem = "";
        } else {
          txtTotalPerDiem = FormattingHelper.formatDouble(paymentOfCareRetrieve.getTotalPerDiemRate(),2);
        }

        if (paymentOfCareRetrieve.getSubsidyPerDiem() == 0) {
          monthlySubsidy = "";
        } else {
          monthlySubsidy = FormattingHelper.formatDouble(paymentOfCareRetrieve.getSubsidyPerDiem(),2);
        }

        txtRelative = paymentOfCareRetrieve.getNmRelative();
        idRelative = FormattingHelper.formatInt(paymentOfCareRetrieve.getIdRelative());
        txtSuprvApprv = paymentOfCareRetrieve.getNmSuprvsrApprv();
        idSuprvApprv = FormattingHelper.formatInt(paymentOfCareRetrieve.getIdSuprvsrApprv());
        txtPersComp = paymentOfCareRetrieve.getNmPersonCompleting();
        txtStaffComp = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtStaffingComplete());
        txtPacketSent = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtPacketSent());
        txtPacketComp = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtPacketComplete());
        txtPackEmergAppr = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtEmergSupApprv());
        idPersComp = FormattingHelper.formatInt(paymentOfCareRetrieve.getIdPersonCompleting());
        idSOStaffApprv = FormattingHelper.formatInt(paymentOfCareRetrieve.getIdSOStaffApprv());
        txtSOResponse = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtStateOfficeResponse());
        txtSOStaffApprv = paymentOfCareRetrieve.getNmSOStaffApprv();
        txtRBWOStaffApprv = paymentOfCareRetrieve.getNmRBWOStaffApprv();
        txtRBWOReview = FormattingHelper.formatDate(paymentOfCareRetrieve.getDtRBWOReview());
        idRBWOStaffApprv = FormattingHelper.formatInt(paymentOfCareRetrieve.getIdRBWOStaffApprv());
        if (paymentOfCareRetrieve.getSpecFcRbwoWaiver() != 0){
          txtFcRbwoWaiver = FormattingHelper.formatDouble(paymentOfCareRetrieve.getSpecFcRbwoWaiver(),2);
        } else {
          txtFcRbwoWaiver = "";
        }
        indRcsType = paymentOfCareRetrieve.getIndRcsType();
        txtCourtReviewDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getCourtRevDate());
        //txtEndDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getEndDate());
        displayEndDate = txtEndDate;
        txtRenewalDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getRenewDate());
        displayRenewalDate = txtRenewalDate;
        txtEffPayDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getEffPaymentDate());
        txtAnnualReviewDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getAnnualRevDate());
        txtAgreeDate = FormattingHelper.formatDate(paymentOfCareRetrieve.getAgreeDate());
        // MR-087 Added Child turns 18 checkbox
        cbx18ByNextCrtRvw = paymentOfCareRetrieve.getInd18ByNextCrtRvw();
        cbxFamIncLess = paymentOfCareRetrieve.getIndFamIncomeLess();
        cbxSuspend = paymentOfCareRetrieve.getIndSuspend();
        cbxTerminate = paymentOfCareRetrieve.getIndTerminate();
        txtReasonSuspTerm = paymentOfCareRetrieve.getTxtReasonTerm();
        txtReasonSpecWaiver = paymentOfCareRetrieve.getTxtReasonSpecWaiver();
 
        if (paymentOfCareRetrieve.getRbwoStaffApprvTitle() != ""
            && paymentOfCareRetrieve.getRbwoStaffApprvTitle() != null) {
          rbwoStaffApprvTitle = paymentOfCareRetrieve.getRbwoStaffApprvTitle();
        } else {
          rbwoStaffApprvTitle = "";
        }

        if (paymentOfCareRetrieve.getSoStaffApprvTitle() != "" && paymentOfCareRetrieve.getSoStaffApprvTitle() != null) {
          soStaffApprvTitle = paymentOfCareRetrieve.getSoStaffApprvTitle();
        } else {
          soStaffApprvTitle = "";
        }

        if (paymentOfCareRetrieve.getSuprvsrApprvTitle() != "" && paymentOfCareRetrieve.getSuprvsrApprvTitle() != null) {
          suprvsrApprvTitle = paymentOfCareRetrieve.getSuprvsrApprvTitle();
        } else {
          suprvsrApprvTitle = "";
        }

        if (paymentOfCareRetrieve.getPersCompTitle() != "" && paymentOfCareRetrieve.getPersCompTitle() != null) {
          persCompTitle = paymentOfCareRetrieve.getPersCompTitle();
        } else {
          persCompTitle = "";
        }
        if (indRbwoType != null) {
          if ("I".equals(indRbwoType)) {
            rbwoTypeInitial = ArchitectureConstants.TRUE;
            rbwoTypeReview = ArchitectureConstants.FALSE;
            rbwoTypeEmergency = ArchitectureConstants.FALSE;
          } else if ("R".equals(indRbwoType)) {
            rbwoTypeInitial = ArchitectureConstants.FALSE;
            rbwoTypeReview = ArchitectureConstants.TRUE;
            rbwoTypeEmergency = ArchitectureConstants.FALSE;
          } else if ("E".equals(indRbwoType)) {
            rbwoTypeInitial = ArchitectureConstants.FALSE;
            rbwoTypeReview = ArchitectureConstants.FALSE;
            rbwoTypeEmergency = ArchitectureConstants.TRUE;
          }
        }

        if (indRcsType != null) {
          if ("I".equals(indRcsType)) {
            rcsTypeInitial = ArchitectureConstants.TRUE;
            rcsTypeRenewal = ArchitectureConstants.FALSE;
          } else if ("R".equals(indRcsType)) {
            rcsTypeInitial = ArchitectureConstants.FALSE;
            rcsTypeRenewal = ArchitectureConstants.TRUE;
          }
        }
        // STGAP00004406 - van - defauted value exists
        if (StringHelper.isValid(paymentOfCareRetrieve.getIndProgramType())) {
          indProgramType = paymentOfCareRetrieve.getIndProgramType();
          if (ArchitectureConstants.Y.equals(indProgramType)) {
            rbwoProgramTypeCodesTable = CodesTables.CRBPROGI;
          } else if (ArchitectureConstants.N.equals(indProgramType)) { // do not set if by mistake or when page is NEW, indicator is neither Y or N
              rbwoProgramTypeCodesTable = CodesTables.CRBPROGA;
          }
        }
        if (StringHelper.isValid(paymentOfCareRetrieve.getRbwoProgramType())) {
          rbwoProgramType = paymentOfCareRetrieve.getRbwoProgramType();
        }
        // end STGAP00004406
        }
        
      //STGAP00013397 MR-033
      //Per Diem check boxes    
      String checkedPerDiem = StringHelper.EMPTY_STRING;
      if(paymentOfCareRetrieve.getIndCustomWaiver()!= null && ArchitectureConstants.Y.equals(paymentOfCareRetrieve.getIndCustomWaiver())) { 
      checkedPerDiem  = CodesTables.CPERDIEM_W3;
      }else if (paymentOfCareRetrieve.getInd100PerDiem()!= null && ArchitectureConstants.Y.equals(paymentOfCareRetrieve.getInd100PerDiem())) { 
      checkedPerDiem  = CodesTables.CPERDIEM_W2;
      }else{
      checkedPerDiem  = CodesTables.CPERDIEM_W1;
      }   
        
      //END STGAP00013397 MR-033
      
         if ("".equals(pocType) || pocType == null) {
        displayContinue = true;
      } else {
        displayContinue = false;
      }

      if (!("".equals(pocType)) && (pocType != null)) {
        disablePocType = "true";
      }

      ulIdStage = FormattingHelper.formatInt(GlobalData.getUlIdStage(request));
      
      if(CodesTables.CPOCTYPE_ESG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType)
        || CodesTables.CPOCTYPE_ERS.equals(pocType) || CodesTables.CPOCTYPE_ERR.equals(pocType)
        || CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_NSG.equals(pocType)
        || CodesTables.CPOCTYPE_SUG.equals(pocType)
      ){
      notEsgOrNeg = "false";
      } 

      if ((CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType)) && !PageModeConstants.APPROVE.equals(pageMode)) {
        terminateDateDisabled = "true";
        if (CodesTables.CPOCTYPE_RWW.equals(pocType)) {
          specialAddOnRateDisabled = "true";
          //txtTotalPerDiem = txtPerDiem; // STGAP00003321
        }
      }

      if ((CodesTables.CPOCTYPE_RFD.equals(pocType) || CodesTables.CPOCTYPE_LOC.equals(pocType)) && !PageModeConstants.APPROVE.equals(pageMode)) {
        reasonSpecAddOnDisabled = "true";
        terminateDateDisabled = "true";
        specialAddOnRateDisabled = "true";
        // STGAP00004549 - keep the end date modifiabel for pilot R2 per defect manager's notes
        //endDateDisabled = "true";
        // end STGAP00004549
        if (CodesTables.CPOCTYPE_LOC.equals(pocType)) {
          //txtTotalPerDiem = ""; // STGAP00003321
        }
      } else if (CodesTables.CPOCTYPE_A3.equals(pocType) || CodesTables.CPOCTYPE_L1.equals(pocType) || CodesTables.CPOCTYPE_L2.equals(pocType) 
                 || CodesTables.CPOCTYPE_L3.equals(pocType) || CodesTables.CPOCTYPE_L4.equals(pocType) 
                 || CodesTables.CPOCTYPE_L5.equals(pocType) || CodesTables.CPOCTYPE_L6.equals(pocType)) {
        levelPocType = "true";
        reasonSpecAddOnDisabled = "true";
        specialAddOnRateDisabled = "true";
      } else if ((CodesTables.CPOCTYPE_RFD.equals(pocType) || CodesTables.CPOCTYPE_LOC.equals(pocType)) && PageModeConstants.APPROVE.equals(pageMode)) {
        startDateDisabled = "true";
        // endDateDisabled = "true"; STGAP00004549 - keep the end date modifiabel for pilot R2 per defect manager's notes
        levelPocType = "true";
        reasonSpecAddOnDisabled = "true";
        specialAddOnRateDisabled = "true";
        terminateDateDisabled = "false";
      } else if (CodesTables.CPOCTYPE_ERR.equals(pocType)) {
        terminateDateDisabled = "true";
      }
      // STGAP00002379 - when terminating a APRV status stays APRV instead of going to COMP as was originally designed
      // chose not to modify the existing display logic above due to the complexity of page display, only override terminate date's logic here 
      int terminateDateEditableMode = EditableMode.getPageModeAsInt(pageMode);
      boolean isStatusAprv = CodesTables.CEVTSTAT_APRV.equals(paymentOfCareRetrieve.getCdEventStatus());
      boolean pocTerminated = !DateHelper.isNull(paymentOfCareRetrieve.getDtTerminate());
      // commented out to leave room for back payment adjustment, code might be reconsidered later
      //boolean pocEnded = !DateHelper.isNull(paymentOfCareRetrieve.getEndDate()) && DateHelper.isBeforeToday(paymentOfCareRetrieve.getEndDate());
      //if (isStatusAprv && !pocTerminated && !pocEnded) {
      if (isStatusAprv && GlobalData.hasStageAccess(request)) {
        endDateDisabled = "true";
        terminateDateDisabled = "false";
        terminateDateEditableMode = EditableMode.ALL;
      }
      // added per BA's note, applied to Terminate and Suspend checkboxes too
      // terminate fields need to be disabled if POC in PEND or PROC 
      else {
        terminateDateDisabled = "true";
      }
      
      // end STGAP00002379
      
      //****************** 
      //*** JAVASCRIPT ***
      //******************

%>
<script type="text/JavaScript" src="/grnds-docs/js/shared/dirtyForm.js"></script>
<script src="/grnds-docs/js/document/document.js"></script>
<script type="text/JavaScript" src="/grnds-docs/js/shared/impact.js"></script>
<script type="text/javascript" language="JavaScript1.2">

window.onbeforeunload = function ()
{
  IsDirty();
};
//STGAP00006420: Added the onload and checkGap functions to display Gap messages.
window.onload = function()
{
  setWaiverAmountMode();
<%
// Only include function call if payment care type is Relative Care Subsidy type and is not approved
if((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType))
    && !isStatusAprv){
%>
  // MR-087 Make sure to disable court review date field if checkbox was selected.
  onClickOfChildTurns18();
<%}%>

// this needs to be called last since it redirect the page before any page modification is set
  checkGap();
}

//STGAP00013397  MR-033
//This function will set proper mode for the Waiver Amount field and Waiver Reason field depending on the waiveroptions checkbox.
//STGAP00015311: Modified function to enable custom waiver option.
function setWaiverAmountMode(){ 
 //Set the Waiver Reason text box disabled if 80% Waiver Amount is checked.
 var rbWaiverOptions = document.getElementsByName('rbCWaiverOptions');
  if (rbWaiverOptions.length > 1){
   if(document.frmPOC.rbCWaiverOptions[0].checked)
      {
      document.frmPOC.txtWavierAmount.value = "";
      document.frmPOC.txtWavierAmount.disabled = true;
      document.frmPOC.txtWaiverReason.value = "";
      document.frmPOC.txtWaiverReason.disabled = true;   
    }else if(document.frmPOC.rbCWaiverOptions[1].checked){
      document.frmPOC.txtWavierAmount.disabled = true;      
      document.frmPOC.txtWaiverReason.disabled = false;
    }else if(document.frmPOC.rbCWaiverOptions[2].checked){
      document.frmPOC.txtWavierAmount.disabled = false;      
      document.frmPOC.txtWaiverReason.disabled = false;
    }
   } 
}

// This will display the gap error message if the errorCode is set to one of the
// gap errors.  
function checkGap()
{
   var errorCode = '<%= (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") %>';
  <% String bSaveIsPressed = (String) request.getAttribute("bSaveIsPressed")== null? "false": (String) request.getAttribute("bSaveIsPressed");
     boolean isSavePressed = bSaveIsPressed.equals("false")? false:true;
  %>
  if (errorCode == '<%= Messages.MSG_SUB_GAP_EXISTS_1 %>')
  {
    if (confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_1) %>'))
    {
      document.frmPOC.hdnBSysIndPrfrmValidation.value = 'N';
      var savePressed = <%= isSavePressed %>;
      if(savePressed){
      submitValidateForm("frmPOC", "/casemgmt/PaymentOfCare/savePOC");
      }else{
      submitValidateForm("frmPOC", "/casemgmt/PaymentOfCare/saveAndSubmitPOC");
      }
    }
  }
  if (errorCode == '<%= Messages.MSG_SUB_GAP_EXISTS_2 %>')
  {
    if (confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_2) %>'))
    {
      document.frmPOC.hdnBSysIndPrfrmValidation.value = 'N';
      var savePressed = <%= isSavePressed %>;
      if(savePressed){
      submitValidateForm("frmPOC", "/casemgmt/PaymentOfCare/savePOC");
      }else{
      submitValidateForm("frmPOC", "/casemgmt/PaymentOfCare/saveAndSubmitPOC");
      }
    }
  }
  if (errorCode == '<%= Messages.MSG_SUB_GAP_EXISTS_3 %>')
  {
    if (confirm('<%= MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_3) %>'))
    {
      document.frmPOC.hdnBSysIndPrfrmValidation.value = 'N';
      var savePressed = <%= isSavePressed %>;
      if(savePressed){
      submitValidateForm("frmPOC", "/casemgmt/PaymentOfCare/savePOC");
      }else{
      submitValidateForm("frmPOC", "/casemgmt/PaymentOfCare/saveAndSubmitPOC");
      }
    }
  }
}
function autofillEndDate(field ) 
{
  var startingDateAsString = validateDateString( field.value );
  var startingDateInMilliseconds = Date.parse( startingDateAsString );
  var endDate = new Date( startingDateInMilliseconds );
  var today = new Date();
    
  endDate.setYear( endDate.getYear() + 1 );
  var sp = document.getElementById("displayEndDate_id");
  sp.innerText = (endDate.getMonth()+1) + "/" +endDate.getDate() + "/" +endDate.getYear();
  document.frmPOC.txtEndDate.value = (endDate.getMonth()+1) + "/" +endDate.getDate() + "/" +endDate.getYear();
}

function autofillRenewDate(field )
{
  var startingDateAsString = validateDateString( field.value );
  var startingDateInMilliseconds = Date.parse( startingDateAsString );
  var endDate = new Date( startingDateInMilliseconds );
  var today = new Date();
    
  endDate.setYear( endDate.getYear() + 1 );
  var sp = document.getElementById("displayRenewalDate_id");
  sp.innerText = (endDate.getMonth()+1) + "/" +endDate.getDate() + "/" +endDate.getYear();
  document.frmPOC.txtRenewalDate.value = (endDate.getMonth()+1) + "/" +endDate.getDate() + "/" +endDate.getYear();
}

function resourceNoValidation()
{
  disableValidation("frmPOC");
}

function confirmDelete()
{
  return confirm( "<%= MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) %>" );
}

<%
String cciCodesString = CodesTables.CRBPROGI;
String cpaCodesString = CodesTables.CRBPROGA;
%>
<impact:codeArray codeName="<%=cciCodesString%>" arrayName="cciCodes" blankValue="true"/>
<impact:codeArray codeName="<%=cpaCodesString%>" arrayName="cpaCodes" blankValue="true"/>

function updateType() 
 {
   var buttonGroup = document.frmPOC.scrIndProgramType;    
   var radioValue = getSelectedRadioValue( buttonGroup );
   
   if ( radioValue == "Y" )
   { 
     populateDropdown( document.frmPOC.selRbwoProgramType , document.frmPOC.selRbwoProgramType.value , cciCodes );
   }
   else if ( radioValue == "N" )
   {
     populateDropdown( document.frmPOC.selRbwoProgramType , document.frmPOC.selRbwoProgramType.value, cpaCodes );
   }
   else {
     clearDropdown( document.frmPOC.selRbwoProgramType );
   }
 }

<%
//Per STGAP00013397 MR-033 
//waiverOptionChange function is called on Change of waiver option check boxes.
//This will disable the Waiver Amount field if the Check box is changed from Custom Waiver to 
//either 80% Per-diem or 100% Per-diem With Waiver
//This function will also disable the Waiver Reason field if the check box of 80% Per-diem is selected.
//Deleted the javascript function waiverOptionChange as this will not be used for release 3.1 change.
//In case it is required in future you can find it in version 100209
%> 
  
function onClickOf80()
 {
  document.frmPOC.txtWavierAmount.value = "";
  document.frmPOC.txtWavierAmount.disabled = true;
  document.frmPOC.txtWaiverReason.value = "";
  document.frmPOC.txtWaiverReason.disabled = true;
  }
       
function onClickOf100()
 {
  document.frmPOC.txtWavierAmount.value = "";
  document.frmPOC.txtWavierAmount.disabled = true;
  document.frmPOC.txtWaiverReason.value = "";
  document.frmPOC.txtWaiverReason.disabled = false;
 }
       

function onClickOfCustomWaiver()
 {
  document.frmPOC.txtWavierAmount.value = "";
  document.frmPOC.txtWavierAmount.disabled = false;
  document.frmPOC.txtWaiverReason.value = "";
  document.frmPOC.txtWaiverReason.disabled = false;
 }
  
function checkTerminateDateInvalid(terminate, end) { 
  var endDateId = "" + end + "_Id";
  var endDate = eval(document.getElementById(endDateId));
  if ( terminate.value != "" && endDate.value != "")
  { 
    var terminateDateAsString = validateDateString( terminate.value );
    var endDateAsString = validateDateString( endDate.value );
    var fieldName = "document.frmPOC."+terminate.name;
    var validValue = "document.frmPOC."+fieldName+".value = "+"terminateDateAsString;";
    var refocus = "document.frmPOC."+fieldName+".blur();";
    var reselect = "document.frmPOC."+fieldName+".select();";
    // If input is invalid, pop message, put cursor back in field.
    if ( terminateDateAsString == "INVALID" || endDateAsString == "INVALID" ||
       (new Date( Date.parse(terminateDateAsString) ) > new Date( Date.parse(endDateAsString) ) ) )
    {
      alert("<%=MessageLookup.getMessageByNumber( Messages.SSM_CON_TERM_AFTER_END)%>");
      eval(refocus); eval(reselect);
    } else {
      eval(validValue);
    }

  }
} 

<%
// Only include function if payment care type is Relative Care Subsidy type and is not approved
if((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType))
    && !isStatusAprv){
%>
// MR-087 Added Child turns 18 checkbox
function onClickOfChildTurns18()
{
	if(document.frmPOC.cbx18ByNextCrtRvw.checked == true){
        document.frmPOC.txtCourtReviewDate.value = "";
        disableDateField(document.frmPOC, document.frmPOC.txtCourtReviewDate);
	}else{
        enableDateField(document.frmPOC, document.frmPOC.txtCourtReviewDate);
	}
}
<%}%>       

</script>
<%//*************************
      //*** VALIDATION ERRORS ***
      //*************************
%>
<impact:validateErrors />
<%
      //********************************************
      //**** FORM (Payment of Care) STARTS HERE ****
      //********************************************

      %> 
<impact:validateForm name="frmPOC" method="post" action="/casemgmt/PaymentOfCare/displayPOC" validationClass="gov.georgia.dhr.dfcs.sacwis.web.casemgmt.PaymentOfCareCustomValidation" pageMode="<%= pageMode %>" schema="/WEB-INF/Constraints.xsd" clientValidation="true">
	<impact:validateInput type="hidden" name="hdnBSysIndPrfrmValidation" value="Y" />
	<%if (approvalStatus) {
%>
	<table border="0" cellspacing="0" cellpadding="3" width="100%">
		<tr>
			<td>
				<impact:ButtonTag 
				  name="btnApprovalStatus" 
				  tabIndex="<%= tabIndex++ %>" 
				  img="btnApprovalStatus" 
				  editableMode="<%= EditableMode.ALL %>" 
			      form="frmPOC" 
			      navAwayCk="true"
				  action="/workload/ApprovalStatus/displayStatus" />
			</td>
		</tr>
	</table>
	<%}
     %>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th>
				Payment of Care Type
			</th>
		</tr>
		<tr>
			<td>
				<table border="0" cellpadding="3" cellspacing="0" width="100%">
					<tr>
						<td>
							<impact:validateSelect 
							  label="Payment of Care Type" 
							  name="pocType" 
							  codesTable="<%= CodesTables.CPOCTYPE %>" 
							  required="<%= ArchitectureConstants.TRUE %>" 
							  value="<%=pocType%>" 
							  disabled="<%=disablePocType%>" 
							  tabIndex="<%= tabIndex++ %>" />
						</td>
						<td>
							&nbsp;
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
	<%if (displayContinue) {%>
	<table border="0" cellpadding="3" cellspacing="0" width="100%">
		<tr>
			<td>
				<impact:ButtonTag 
				  name="btnContinue" 
				  img="btnContinue" 
				  align="right" 
				  form="frmPOC" 
				  action="/casemgmt/PaymentOfCare/reloadPOC" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
	</table>
	<%}//end continue button%>
	<%if (!("".equals(pocType))) {%>
	<impact:validateInput type="hidden" name="hdnIdEvent" value="<%= hdnIdEvent %>" />
	<impact:validateInput type="hidden" name="ulIdStage" value="<%= ulIdStage %>" />
	<input type="hidden" name="szCdTask" value="<%=cdTask%>">
	<br>
	<%if (CodesTables.CPOCTYPE_RFD.equals(pocType) || CodesTables.CPOCTYPE_EFD.equals(pocType) 
	        || CodesTables.CPOCTYPE_LOC.equals(pocType) || ArchitectureConstants.TRUE.equals(levelPocType)) {

          %>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="6">
				Payment of Care Detail
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				  label="Start Date" 
				  name="txtStartDate" 
				  type="text" 
				  value="<%= txtStartDate %>" 
				  size="10" 
				  disabled="<%= startDateDisabled%>" 
				  required="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td>
				<impact:validateDate 
				  label="End Date" 
				  name="txtEndDate" 
				  type="text" 
				  value="<%= txtEndDate %>" 
				  size="10" 
				  disabled="<%= endDateDisabled%>" 
				  editableMode = "<%= EditableMode.ALL %>"
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td>
				<impact:validateDate 
				  label="Terminate Date" 
				  name="txtTermDate" 
				  type="text" 
				  value="<%= txtTermDate %>" 
				  disabled="<%= terminateDateDisabled%>"  
				  editableMode = "<%= terminateDateEditableMode %>" 
				  onChange="checkTerminateDateInvalid(this, 'txtEndDate')" 
				  size="10" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Base Per Diem Rate" 
				  name="txtPerDiem" 
				  value="<%= txtPerDiem %>" />
			</td>
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Special Add On Rate (FC Only)" 
				  name="txtSpecialRate" 
				  value="<%= txtSpecialRate %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  disabled="<%=specialAddOnRateDisabled%>" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>"
			      size="6" 
				  maxLength="4" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Total Per Diem Rate" 
				  name="txtTotalPerDiem" 
				  value="<%= txtTotalPerDiem %>" />
			<td>
		</tr>
		<% // STGAP00004406 - new fields added %>
		<% if (CodesTables.CPOCTYPE_LOC.equals(pocType)) { %> 
		<tr>
		    <td>
		        <impact:validateDisplayOnlyField 
				  label="Program Type" 
				  name="txtProgramType" 
				  value="" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>"
				  width="20%" />
		    
		    
		        <impact:validateInput 
				  type="radio" 
				  label="CCI" 
				  id="Program_Type_CCI" 
				  name="scrIndProgramType" 
				  value="Y" 
				  cssClass="formInput" 
				  checked="<%= ""+ArchitectureConstants.Y.equals(indProgramType) %>" 
				  onClick="updateType();"
				  tabIndex="<%= tabIndex++ %>" />
				  <impact:validateInput 
				  type="radio" 
				  label="CPA" 
				  id="Program_Type_CPA" 
				  name="scrIndProgramType" 
				  value="N" 
				  cssClass="formInput" 
				  checked="<%= ""+ArchitectureConstants.N.equals(indProgramType) %>" 
				  onClick="updateType();"
				  tabIndex="<%= tabIndex++ %>" />
		    </td>
		    <td>
		        <impact:validateSelect 
							  label="RBWO Program" 
							  name="selRbwoProgramType" 
							  codesTable="<%= rbwoProgramTypeCodesTable %>" 
							  required="<%= ArchitectureConstants.TRUE %>" 
							  value="<%= rbwoProgramType %>" 
							  disabled="<%= ""+isStatusAprv  %>"
							  tabIndex="<%= tabIndex++ %>" />
		    </td>
		</tr>
		<% } %>
		<% // end STGAP00004406 - new fields added %>
		<tr>
			<td colspan="2">
				<impact:validateInput 
				  label="Concurrent Per Diem" 
				  name="cbxConcPerDiem" 
				  type="checkbox" 
				  disabled="<%=levelPocType%>" 
				  tabIndex="<%= tabIndex++ %>" 
				  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>"
				  checked="<%=FormattingHelper.formatString(cbxConcPerDiem)%>" />
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span> Reason For Concurrent Per Diem Type:
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<impact:validateTextArea 
				  name="txtReasonConcPerDiem" 
				  cols="110" 
				  rows="4" 
				  tabIndex="<%= tabIndex++ %>" 
				  disabled="<%=levelPocType%>" 
				  maxLength="300"><%=FormattingHelper.formatString(txtReasonConcPerDiem)%>
				</impact:validateTextArea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<span class="formCondRequiredText">&#135;</span> Reason For Special Add-On Rate:
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<impact:validateTextArea 
				  name="txtReasonSpecPerDiem" 
				  cols="110" 
				  rows="4" 
				  tabIndex="<%= tabIndex++ %>" 
				  disabled="<%=reasonSpecAddOnDisabled%>" 
				  maxLength="300"><%=FormattingHelper.formatString(txtReasonSpecPerDiem)%>
				</impact:validateTextArea>
			</td>
		</tr>
	</table>
	<%} else if (CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType)) { %>
	<impact:validateInput type="hidden" name="idPersComp" value="<%= idPersComp %>" />
	<impact:validateInput type="hidden" name="idSuprvApprv" value="<%= idSuprvApprv %>" />
	<impact:validateInput type="hidden" name="idSOStaffApprv" value="<%= idSOStaffApprv %>" />
	<impact:validateInput type="hidden" name="idRBWOStaffApprv" value="<%= idRBWOStaffApprv %>" />


	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="12">
				Payment of Care Detail
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				  label="Start Date" 
				  name="txtStartDate" 
				  type="text" 
				  value="<%= txtStartDate %>" 
				  required="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td>
				<impact:validateDate 
				  label="End Date" 
				  name="txtEndDate" 
				  type="text" 
				  value="<%= txtEndDate %>" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  disabled="<%= endDateDisabled%>" 
				  editableMode = "<%= EditableMode.ALL %>"
				  constraint="Date" />
			</td>

			<td>
				<impact:validateDate 
				  label="Terminate Date" 
				  name="txtTermDate" 
				  type="text" 
				  value="<%= txtTermDate %>" 
				  disabled="<%= terminateDateDisabled%>" 
				  editableMode = "<%= terminateDateEditableMode %>" 
				  onChange = "checkTerminateDateInvalid(this, 'txtEndDate')"
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Base Per Diem Rate" 
				  name="txtPerDiem" 
				  value="<%= txtPerDiem %>" 
				  width="20%" />
			</td>
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Special Add On Rate (FC Only)" 
				  name="txtSpecialRate" 
				  value="<%= txtSpecialRate %>" 
				  disabled="<%=specialAddOnRateDisabled%>"
				  tabIndex="<%= tabIndex++ %>" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  maxLength="4" 
				  size="6" 
				  width="20%" />
			</td>
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Specialized FC/RBWO Waiver" 
				  name="txtFcRbwoWaiver" 
				  value="<%= txtFcRbwoWaiver %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  constraint="Double"
				  maxLength="7" 
				  size="8" 
				  width="20%" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Total Per Diem Rate" 
				  name="txtPerDiem" 
				  value="<%= txtTotalPerDiem %>" />
			</td>
		</tr>
		<% // STGAP00004406 - new fields added %>
		<% if (CodesTables.CPOCTYPE_RWW.equals(pocType)) { %>
		<tr>
		    <td>
		        <impact:validateDisplayOnlyField 
				  label="Program Type" 
				  name="txtProgramType" 
				  value="" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>"
				  width="20%" />
		        <impact:validateInput 
				  type="radio" 
				  label="CCI" 
				  id="Program_Type_CCI" 
				  name="scrIndProgramType" 
				  value="Y" 
				  cssClass="formInput" 
				  checked="<%= ""+ArchitectureConstants.Y.equals(indProgramType) %>" 
				  onClick="updateType();"
				  tabIndex="<%= tabIndex++ %>" />
				  <impact:validateInput 
				  type="radio" 
				  label="CPA" 
				  id="Program_Type_CPA" 
				  name="scrIndProgramType" 
				  value="N" 
				  cssClass="formInput" 
				  checked="<%= ""+ArchitectureConstants.N.equals(indProgramType) %>" 
				  onClick="updateType();"
				  tabIndex="<%= tabIndex++ %>" />
		    </td>
		    <td>
		        <impact:validateSelect 
							  label="RBWO Program" 
							  name="selRbwoProgramType" 
							  codesTable="<%= rbwoProgramTypeCodesTable %>" 
							  required="<%= ArchitectureConstants.TRUE %>" 
							  value="<%=  rbwoProgramType %>" 
							  disabled="<%= ""+isStatusAprv  %>"
							  tabIndex="<%= tabIndex++ %>" />
		    </td>
		</tr>
		<% } %>
		<% // end  STGAP00004406 - new fields added %>
		<tr>
			<th colspan="12">
				Approval Information
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				  label="Packet Complete" 
				  name="txtPacketComp" 
				  type="text" 
				  value="<%= txtPacketComp %>" 
				  size="10" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td>
				<impact:validateInput 
				  type="radio" 
				  label="Initial" 
				  id="RBWO_Type_Init" 
				  name="scrIndRbwoType" 
				  value="I" 
				  cssClass="formInput" 
				  checked="<%= rbwoTypeInitial %>" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
			<td align="left">
				<impact:validateInput 
				  type="radio" 
				  label="Review Change" 
				  id="RBWO_Type_RC" 
				  name="scrIndRbwoType" 
				  value="R" 
				  cssClass="
				  formInput" 
				  checked="<%= rbwoTypeReview %>"
				  tabIndex="<%= tabIndex++ %>" />
			</td>
			<td align="left">
				<impact:validateInput 
				  type="radio" 
				  label="Emergency" 
				  id="RBWO_Type_Emer" 
				  name="scrIndRbwoType" 
				  value="E" 
				  cssClass="formInput" 
				  checked="<%= rbwoTypeEmergency %>"
				  tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr bgcolor="E0E0E0">
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Person Completing" 
				  name="txtPersComp" 
				  value="<%= txtPersComp %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  conditionallyRequired="true" 
				  readOnly="true" 
				  constraint="Name25" />
			</td>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Title" 
				  name="persCompTitle" 
				  conditionallyRequired="true" 
				  value="<%= persCompTitle %>" />
			</td>
			<td>
				<impact:ButtonTag 
				  name="btnSelectStaffPerComp" 
				  img="btnSelectStaff" 
				  align="left" 
				  form="frmPOC" 
				  action="/casemgmt/PaymentOfCare/performStaffSearch" 
				  function="disableValidation('frmPOC')" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				  label="Packet/Emergency Supv. Approval" 
				  name="txtPackEmergAppr" 
				  type="text" 
				  value="<%= txtPackEmergAppr %>" 
				  size="10" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Supervisor Approving" 
				  name="txtSuprvApprv" 
				  value="<%= txtSuprvApprv %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  conditionallyRequired="true" 
				  readOnly="true" 
				  constraint="Name25" />
			</td>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Title" 
				  name="suprvsrApprvTitle" 
				  conditionallyRequired="true" 
				  value="<%= suprvsrApprvTitle %>" />
			</td>
			<td>
				<impact:ButtonTag 
				  name="btnSelectStaffSuprvApprv" 
				  img="btnSelectStaff" 
				  align="left" 
				  form="frmPOC" 
				  action="/casemgmt/PaymentOfCare/performStaffSearch" 
				  function="disableValidation('frmPOC')" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
			<td></td>
			<td></td>
		</tr>
		<tr bgcolor="E0E0E0">
			<td>
				<impact:validateDate 
				  label="Packet Sent" 
				  name="txtPacketSent" 
				  type="text" 
				  value="<%= txtPacketSent %>" 
				  size="10" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr bgcolor="E0E0E0">
			<td>
				<impact:validateDate 
				  label="Staffing Complete" 
				  name="txtStaffComp" 
				  type="text" 
				  value="<%= txtStaffComp %>" 
				  size="10" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>

		<tr>
			<td>
				<impact:validateDate 
				  label="State Office Response" 
				  name="txtSOResponse" 
				  type="text" 
				  value="<%= txtSOResponse %>" 
				  size="10" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Staff Approving" 
				  name="txtSOStaffApprv" 
				  value="<%= txtSOStaffApprv %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  conditionallyRequired="true" 
				  readOnly="true" 
				  constraint="Name25" />
			</td>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Title" 
				  name="soStaffApprvTitle" 
				  conditionallyRequired="true" 
				  value="<%= soStaffApprvTitle %>" />
			</td>
			<td>
				<impact:ButtonTag 
				  name="btnSelectStaffSOApprv" 
				  img="btnSelectStaff" 
				  align="left" 
				  form="frmPOC" 
				  action="/casemgmt/PaymentOfCare/performStaffSearch" 
				  function="disableValidation('frmPOC')" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
		</tr>
		<tr bgcolor="E0E0E0">
			<td>
				<impact:validateDate 
				  label="RBWO Review" 
				  name="txtRBWOReview" 
				  type="text" 
				  value="<%= txtRBWOReview %>" 
				  size="10" 
				  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
			<td></td>
		</tr>
		<tr bgcolor="E0E0E0">
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Staff Approving" 
				  name="txtRBWOStaffApprv" 
				  value="<%= txtRBWOStaffApprv %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  conditionallyRequired="true" 
				  readOnly="true" 
				  constraint="Name25" />
			</td>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Title" 
				  name="rbwoStaffApprvTitle" 
				  conditionallyRequired="true" 
				  value="<%= rbwoStaffApprvTitle %>" />
			</td>
			<td>
				<impact:ButtonTag 
				  name="btnSelectStaffRBWOApprv" 
				  img="btnSelectStaff" 
				  align="left" 
				  form="frmPOC" 
				  action="/casemgmt/PaymentOfCare/performStaffSearch" 
				  function="disableValidation('frmPOC')" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
			<td></td>
			<td></td>
		</tr>

		<tr>
			<td colspan="3">
				<span class="formCondRequiredText">&#135;</span> Reason For Specialized FC/RBWO Waiver:
			</td>
		</tr>
		<tr>
			<td colspan="5">
				<impact:validateTextArea 
				  name="txtReasonSpecWaiver" 
				  cols="110" 
				  rows="4" 
				  tabIndex="<%= tabIndex++ %>" 
				  maxLength="300"><%=FormattingHelper.formatString(txtReasonSpecWaiver)%>
				</impact:validateTextArea>
			</td>
		</tr>

	</table>


	<%} else if (CodesTables.CPOCTYPE_ERR.equals(pocType)) { %>
	<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
		<tr>
			<th colspan="7">
				Payment of Care Detail
			</th>
		</tr>
		<tr>
			<td>
				<impact:validateDate 
				  label="Start Date" 
				  name="txtStartDate" 
				  type="text" 
				  value="<%= txtStartDate %>" 
				  size="10" 
				  required="<%= ArchitectureConstants.TRUE %>" 
				  onChange="autofillEndDate(this)" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
			 <impact:validateInput type="hidden" name="txtEndDate" value="<%= txtEndDate %>" />
			<td>
				<impact:validateDisplayOnlyField 
				  label="End Date" 
				  name="displayEndDate" 
				  value="<%= displayEndDate %>" />
			</td>
			<td>
				<impact:validateDate 
				  label="Terminate Date" 
				  name="txtTermDate" 
				  type="text" 
				  value="<%= txtTermDate %>" 
				  disabled="<%= terminateDateDisabled%>" 
				  editableMode = "<%= terminateDateEditableMode %>" 
				  onChange="checkTerminateDateInvalid(this, 'displayEndDate')"
				  size="10" 
				  tabIndex="<%= tabIndex++ %>" 
				  constraint="Date" />
			</td>
		</tr>
		<tr>
			<td>
				<impact:validateInput 
				  type="text" 
				  label="Relative" 
				  name="txtRelative" 
				  value="<%= txtRelative %>" 
				  tabIndex="<%= tabIndex++ %>" 
				  required="true" 
				  readOnly="true" />
			</td>
            <td>
                <impact:validateInput 
                  type="text" 
                  label="Resource ID" 
                  name="txtRelativeId" 
                  value="<%= String.valueOf(idRelative) %>" 
                  tabIndex="<%= tabIndex++ %>" 
                  required="true" 
                  readOnly="true"/>
            </td>
			<td>
				<impact:ButtonTag 
				  name="btnResource" 
				  img="btnSelectResource" 
			      align="left" 
				  form="frmPOC" 
				  action="/casemgmt/PaymentOfCare/getResource"  
				  function="resourceNoValidation()" 
				  tabIndex="<%= tabIndex++ %>" />
			</td>
			<impact:validateInput 
			  type="hidden" 
			  name="idRelative" 
			  value="<%= idRelative %>" />
		</tr>
			<tr>
		       <td colspan="8">		
                  <table border="0" cellpadding="3" cellspacing="0" width="100%">
		 <tr>
			<td>
				<impact:validateInput checked="<%= CodesTables.CPERDIEM_W1.equals(checkedPerDiem) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CPERDIEM_W1 %>" type="radio" name="rbCWaiverOptions" label="80% Per Diem" cssClass="formInput" 
				disabled = "<%= notEsgOrNeg %>" onClick="onClickOf80()"/>
			</td>
			<td>
				<impact:validateInput checked="<%= CodesTables.CPERDIEM_W2.equals(checkedPerDiem) ? "true" : "false"%>" tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CPERDIEM_W2 %>" type="radio" name="rbCWaiverOptions" label="100% Per Diem" cssClass="formInput" 
				disabled = "<%= notEsgOrNeg %>" onClick="onClickOf100()"/>
			</td>
			<td>
				<impact:validateInput checked="<%= CodesTables.CPERDIEM_W3.equals(checkedPerDiem) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CPERDIEM_W3 %>" type="radio" name="rbCWaiverOptions" label="Custom Waiver" cssClass="formInput"
				disabled = "<%= notEsgOrNeg %>" onClick="onClickOfCustomWaiver()"/>
			</td>
		</tr>
                  
                 </table>
		   	  </td>			
		   </tr>
			<tr>
			<td>
				<impact:validateDisplayOnlyField 
				  label="Enhanced Relative Rate" 
				  name="txtEnhancedRelativeRate" 
				  value="<%= txtEnhancedRelativeRate %>" />
			</td>
				<td colspan="2">
					<impact:validateInput 
					  label="Waiver Amount"  name="txtWavierAmount"   type="text" 
					  value="<%= txtWavierAmount %>" 
					  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
					  disabled = "<%= notEsgOrNeg %>"
					  size="10" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Double" 
					  width="20%"/>
				</td>
				<impact:validateInput 
				  type="hidden" 
				  name="hdnWavierAmount" 
				  value="<%= txtWavierAmount %>" />
			</tr>
			<tr>
				<td colspan="2">
					<span class="formCondRequiredText">&#135;</span> Waiver Reason:
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<impact:validateTextArea 
					  name="txtWaiverReason" 
					  cols="100" 
					  rows="4" 
					  disabled = "<%= notEsgOrNeg %>"
				      tabIndex="<%= tabIndex++ %>" 
					  maxLength="300"><%=FormattingHelper.formatString(txtWaiverReason)%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
		<%} else if (CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType) || CodesTables.CPOCTYPE_SUG.equals(pocType) 
		      || CodesTables.CPOCTYPE_ESG.equals(pocType) || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType)) { %>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" class="tableBorder">
			<tr>
				<th colspan="12">
					Payment of Care Detail
				</th>
			</tr>
			<tr>
				<td>
				<span class="formRequiredText">*</span>
					<impact:validateInput 
					  type="radio" 
					  label="Initial" 
					  id="RCS_Type_Init" 
					  name="scrIndRcsType"
					  value="I" 
					  cssClass="formInput" 
					  checked="<%= rcsTypeInitial %>" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
				<td align="left">
				<span class="formRequiredText">*</span>
					<impact:validateInput 
					  type="radio" 
					  label="Renewal" 
					  id="RCS_Type_Renewal" 
					  name="scrIndRcsType" 
					  value="R" 
					  cssClass="formInput" 
					  checked="<%= rcsTypeRenewal %>" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateDate 
					  label="Agreement Date" 
					  name="txtAgreeDate" 
					  type="text" 
					  value="<%= txtAgreeDate %>" 
					  size="10" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Date" />
				</td>
				<td>
					<impact:validateDate 
					  label="Annual Review Date" 
					  name="txtAnnualReviewDate" 
					  type="text" 
					  value="<%= txtAnnualReviewDate %>" 
					  size="10" 
					  required="true" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Date" />
				</td>
				<td></td>
			<tr>
				<td>
					<impact:validateDate 
					  label="Effective Payment Date" 
					  name="txtEffPayDate" 
					  type="text" 
					  value="<%= txtEffPayDate %>" 
					  size="10" 
					  required="true" 
					  onChange="autofillRenewDate(this)" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Date" />
				</td>
				<impact:validateInput type="hidden" name="txtRenewalDate" value="<%= txtRenewalDate %>" />
				<td>
					<impact:validateDisplayOnlyField 
					  label="Renewal Date" 
					  name="displayRenewalDate" 
					  value="<%= displayRenewalDate %>" />
				</td>
			</tr>
            <% // MR-087 Only display for one of the Relative care subsidies type
             if(CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)){ %>
			<tr>
				<td>
					<impact:validateDate 
					  label="Court Review Due By" 
					  name="txtCourtReviewDate" 
					  type="text" 
					  value="<%= txtCourtReviewDate %>"
					  conditionallyRequired="<%= String.valueOf(CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType))%>"
					  disabled="<%= String.valueOf(!CodesTables.CPOCTYPE_RCS.equals(pocType) && !CodesTables.CPOCTYPE_ERS.equals(pocType))%>"
					  size="10" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Date" />
			    &nbsp;&nbsp;&nbsp;&nbsp;<span ><a href="javascript:void window.open ('/document/DocumentConversation/displayPaymentOfCareHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')" onClick="hrefDirtyBypass=true;">?</a></span>
				</td>
				<td colspan="2">
                    <impact:validateInput 
                      label="Child turns 18 prior to next Court Review" 
                      name="cbx18ByNextCrtRvw" 
                      type="checkbox" 
                      tabIndex="<%= tabIndex++ %>" 
                      value="Y"
                      readOnly="<%= String.valueOf(!CodesTables.CPOCTYPE_RCS.equals(pocType) && !CodesTables.CPOCTYPE_ERS.equals(pocType))%>"
                      onClick="onClickOfChildTurns18()"
                      editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" 
                      checked="<%=FormattingHelper.formatString(cbx18ByNextCrtRvw)%>" />
				</td>
			</tr>
            <% } %>
			<tr>
				<td>
					<impact:validateInput 
					  type="text" 
					  label="Placement Resource" 
					  name="txtRelative" 
					  value="<%= txtRelative %>" 
					  tabIndex="<%= tabIndex++ %>" 
					  required="true" 
					  readOnly="true" />
				</td>
                <td>
                    <impact:validateInput 
                      type="text" 
                      label="Resource ID" 
                      name="txtRelativeId" 
                      value="<%= String.valueOf(idRelative) %>" 
                      tabIndex="<%= tabIndex++ %>" 
                      required="true" 
                      readOnly="true"/>
                </td>
				<td>
					<impact:ButtonTag 
					  name="btnResource" 
					  img="btnSelectResource" 
					  align="left" 
					  form="frmPOC" 
					  action="/casemgmt/PaymentOfCare/getResource"   
					  function="resourceNoValidation()" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
				<impact:validateInput 
				  type="hidden" 
				  name="idRelative" 
				  value="<%= idRelative %>" />
			</tr>
			<tr>
				<td colspan="2">
					<impact:validateInput 
					  label="Family Income Less Than $150,000" 
					  name="cbxFamIncLess" 
					  type="checkbox" 
					  tabIndex="<%= tabIndex++ %>" 
					  value="Y"
					  editableMode="<%= EditableMode.EDIT + EditableMode.NEW %>" 
					  checked="<%=FormattingHelper.formatString(cbxFamIncLess)%>" />
				</td>
			</tr>
			<tr>
		       <td colspan="8">		
                  <table border="0" cellpadding="3" cellspacing="0" width="100%">
		 <tr>
			<td>
				<impact:validateInput checked="<%= CodesTables.CPERDIEM_W1.equals(checkedPerDiem) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CPERDIEM_W1 %>" type="radio" name="rbCWaiverOptions" label="80% Per Diem" cssClass="formInput" 
				disabled = "<%= notEsgOrNeg %>" onClick="onClickOf80()"/>
			</td>
			<td>
				<impact:validateInput checked="<%= CodesTables.CPERDIEM_W2.equals(checkedPerDiem) ? "true" : "false"%>" tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CPERDIEM_W2 %>" type="radio" name="rbCWaiverOptions" label="100% Per Diem" cssClass="formInput" 
				disabled = "<%= notEsgOrNeg %>" onClick="onClickOf100()"/>
			</td>
			<td>
				<impact:validateInput checked="<%= CodesTables.CPERDIEM_W3.equals(checkedPerDiem) ? "true" : "false"%>"  tabIndex="<%=tabIndex++%>" 
				value="<%=CodesTables.CPERDIEM_W3 %>" type="radio" name="rbCWaiverOptions" label="Custom Waiver" cssClass="formInput"
				disabled = "<%= notEsgOrNeg %>" onClick="onClickOfCustomWaiver()"/>
			</td>
		</tr>
                  
                 </table>
		   	  </td>			
		   </tr>
			<tr>
				<td>
					<impact:validateDisplayOnlyField 
				  	  label="Monthly Subsidy" 
				  	  name="monthlySubsidy" 
					  value="<%= monthlySubsidy %>" />
				</td>
				<td colspan="2">
					<impact:validateInput 
					  label="Waiver Amount"  name="txtWavierAmount"   type="text" 
					  value="<%= txtWavierAmount %>" 
					  conditionallyRequired="<%= ArchitectureConstants.TRUE %>" 
					  disabled = "<%= notEsgOrNeg %>"
					  size="10" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Double" 
					  width="20%"/>
				</td>
				<impact:validateInput 
				  type="hidden" 
				  name="hdnWavierAmount" 
				  value="<%= txtWavierAmount %>" />
			</tr>
			<tr>
				<td colspan="2">
					<span class="formCondRequiredText">&#135;</span> Waiver Reason:
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<impact:validateTextArea 
					  name="txtWaiverReason" 
					  cols="110" 
					  rows="4" 
					  disabled = "<%= notEsgOrNeg %>"
				      tabIndex="<%= tabIndex++ %>" 
					  maxLength="300"><%=FormattingHelper.formatString(txtWaiverReason)%>
					</impact:validateTextArea>
				</td>
			</tr>
			<tr>
				<td>
					<impact:validateInput 
					  label="Terminate" 
					  name="cbxTerminate" 
					  type="checkbox" 
					  checked="<%= FormattingHelper.formatString(cbxTerminate) %>"
                      value="Y"
					  tabIndex="<%= tabIndex++ %>" 
					  editableMode = "<%= StringHelper.isTrue(terminateDateDisabled) ? EditableMode.NONE : EditableMode.ALL %>" />
				</td>
				<td>
					<impact:validateInput 
					  label="Suspend" 
					  name="cbxSuspend" 
					  type="checkbox" 
					  checked="<%= FormattingHelper.formatString(cbxSuspend) %>"
                      value="Y"
					  tabIndex="<%= tabIndex++ %>" 
					  editableMode = "<%= StringHelper.isTrue(terminateDateDisabled) ? EditableMode.NONE : EditableMode.ALL %>" />
				</td>
				<td>
					<impact:validateDate 
					  label="Susp./Term Date" 
					  name="txtTermDate" 
					  type="text" 
					  value="<%= txtTermDate %>" 
					  disabled="<%= terminateDateDisabled%>" 
					  editableMode = "<%= terminateDateEditableMode %>" 
					  conditionallyRequired="true" 
					  size="10" 
					  tabIndex="<%= tabIndex++ %>" 
					  constraint="Date" />
				</td>
				<td></td>
			</tr>
			<tr>
				<td colspan="2">
					<span class="formCondRequiredText">&#135;</span> Reason for Suspension/Termination:
				</td>
			</tr>
			<tr>
				<td colspan="4">
					<impact:validateTextArea 
					  name="txtReasonSuspTerm" 
					  cols="110" 
					  rows="4" 
					  disabled="<%= terminateDateDisabled%>" 
					  editableMode = "<%= EditableMode.VIEW %>"
					  tabIndex="<%= tabIndex++ %>" 
					  maxLength="300"><%=FormattingHelper.formatString(txtReasonSuspTerm)%>
					</impact:validateTextArea>
				</td>
			</tr>
		</table>
		<%}//end types of payment of care%>

		<%}//end if pocType is not null
%>

		<%
      //*****************
      //**** BUTTONS ****
      //*****************

      if (!displayContinue) {

        %>
		<table border="0" cellpadding="3" cellspacing="0" width="100%">
			<tr>
			<%if(isStatusAprv && modifyApproveAccess){%>
			    <td class="alignLeft">
					<impact:ButtonTag 
					  name="btnDelete" 
					  img="btnDelete" 
					  align="left" 
					  navAwayCk="true" 
					  form="frmPOC" 
					  action="/casemgmt/PaymentOfCare/deletePOC" 
					  editableMode="<%= EditableMode.ALL %>"
					  function="return confirmDelete()" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
			<% } else { %>
				<td></td>
				<% }
            if (!PageModeConstants.APPROVE.equals(pageMode)) {
               if (!("0".equals(hdnIdEvent))) {

            %>
				<td class="alignLeft">
					<impact:ButtonTag 
					  name="btnDelete" 
					  img="btnDelete" 
					  align="left" 
					  navAwayCk="true" 
					  form="frmPOC" 
					  action="/casemgmt/PaymentOfCare/deletePOC" 
					  function="return confirmDelete()" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
				<%} else {%>
				<td></td>
				<%}//end delete button%>
				<%if(saveAndSubmit){ %>
				<td width="85%" class="alignRight">
					<impact:ButtonTag 
					  name="btnSaveAndSubmit" 
					  img="btnSaveAndSubmit" 
					  form="frmPOC" 
					  restrictRepost="true" 
					  action="/casemgmt/PaymentOfCare/saveAndSubmitPOC" 
					  align="right" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
				<%
				 }
				 %>
				<%}//end if not in approve status%>
			
			<!-- Save button displays in all cases even approved Payment of Care since assigned case manager or supervisor
			     might need to modify Terminate Date as necessary 
			     Disabled/hidden once payment terminated or it is already approved and person viewing has no stage access -->
				<td class="alignRight">
					<impact:ButtonTag 
					  name="btnSave" 
					  img="btnSave"
					  align="right" 
					  restrictRepost="true" 
					  form="frmPOC" 
					  action="/casemgmt/PaymentOfCare/savePOC" 
					  disabled="<%= String.valueOf(!GlobalData.hasStageAccess(request)) %>"
					  editableMode="<%= EditableMode.ALL %>"
					  preventDoubleClick="true" 
					  tabIndex="<%= tabIndex++ %>" />
				</td>
			</tr>

		</table>
		<%}//display save submit and delete buttons%>
	    <impact:validateInput type="hidden" name="destinationUrl" value="/casemgmt/PaymentOfCare/setPocResource" />
	    <input type="hidden" name="<%=HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY%>"/>
		</impact:validateForm>
		
