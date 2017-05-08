package org.apache.jsp.grnds_002ddocs.casemgmt;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.HiddenFieldSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PaymentOfCareRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.EditableMode;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PaymentOfCare_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n");
//*******************************
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


      out.write("\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/dirtyForm.js\"></script>\r\n<script src=\"/grnds-docs/js/document/document.js\"></script>\r\n<script type=\"text/JavaScript\" src=\"/grnds-docs/js/shared/impact.js\"></script>\r\n<script type=\"text/javascript\" language=\"JavaScript1.2\">\r\n\r\nwindow.onbeforeunload = function ()\r\n{\r\n  IsDirty();\r\n};\r\n//STGAP00006420: Added the onload and checkGap functions to display Gap messages.\r\nwindow.onload = function()\r\n{\r\n  setWaiverAmountMode();\r\n");

// Only include function call if payment care type is Relative Care Subsidy type and is not approved
if((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType))
    && !isStatusAprv){

      out.write("\r\n  // MR-087 Make sure to disable court review date field if checkbox was selected.\r\n  onClickOfChildTurns18();\r\n");
}
      out.write("\r\n\r\n// this needs to be called last since it redirect the page before any page modification is set\r\n  checkGap();\r\n}\r\n\r\n//STGAP00013397  MR-033\r\n//This function will set proper mode for the Waiver Amount field and Waiver Reason field depending on the waiveroptions checkbox.\r\n//STGAP00015311: Modified function to enable custom waiver option.\r\nfunction setWaiverAmountMode(){ \r\n //Set the Waiver Reason text box disabled if 80% Waiver Amount is checked.\r\n var rbWaiverOptions = document.getElementsByName('rbCWaiverOptions');\r\n  if (rbWaiverOptions.length > 1){\r\n   if(document.frmPOC.rbCWaiverOptions[0].checked)\r\n      {\r\n      document.frmPOC.txtWavierAmount.value = \"\";\r\n      document.frmPOC.txtWavierAmount.disabled = true;\r\n      document.frmPOC.txtWaiverReason.value = \"\";\r\n      document.frmPOC.txtWaiverReason.disabled = true;   \r\n    }else if(document.frmPOC.rbCWaiverOptions[1].checked){\r\n      document.frmPOC.txtWavierAmount.disabled = true;      \r\n      document.frmPOC.txtWaiverReason.disabled = false;\r\n    }else if(document.frmPOC.rbCWaiverOptions[2].checked){\r\n");
      out.write("      document.frmPOC.txtWavierAmount.disabled = false;      \r\n      document.frmPOC.txtWaiverReason.disabled = false;\r\n    }\r\n   } \r\n}\r\n\r\n// This will display the gap error message if the errorCode is set to one of the\r\n// gap errors.  \r\nfunction checkGap()\r\n{\r\n   var errorCode = '");
      out.print( (Integer) request.getAttribute("errorCode")== null ? 0:(Integer) request.getAttribute("errorCode") );
      out.write("';\r\n  ");
 String bSaveIsPressed = (String) request.getAttribute("bSaveIsPressed")== null? "false": (String) request.getAttribute("bSaveIsPressed");
     boolean isSavePressed = bSaveIsPressed.equals("false")? false:true;
  
      out.write("\r\n  if (errorCode == '");
      out.print( Messages.MSG_SUB_GAP_EXISTS_1 );
      out.write("')\r\n  {\r\n    if (confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_1) );
      out.write("'))\r\n    {\r\n      document.frmPOC.hdnBSysIndPrfrmValidation.value = 'N';\r\n      var savePressed = ");
      out.print( isSavePressed );
      out.write(";\r\n      if(savePressed){\r\n      submitValidateForm(\"frmPOC\", \"/casemgmt/PaymentOfCare/savePOC\");\r\n      }else{\r\n      submitValidateForm(\"frmPOC\", \"/casemgmt/PaymentOfCare/saveAndSubmitPOC\");\r\n      }\r\n    }\r\n  }\r\n  if (errorCode == '");
      out.print( Messages.MSG_SUB_GAP_EXISTS_2 );
      out.write("')\r\n  {\r\n    if (confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_2) );
      out.write("'))\r\n    {\r\n      document.frmPOC.hdnBSysIndPrfrmValidation.value = 'N';\r\n      var savePressed = ");
      out.print( isSavePressed );
      out.write(";\r\n      if(savePressed){\r\n      submitValidateForm(\"frmPOC\", \"/casemgmt/PaymentOfCare/savePOC\");\r\n      }else{\r\n      submitValidateForm(\"frmPOC\", \"/casemgmt/PaymentOfCare/saveAndSubmitPOC\");\r\n      }\r\n    }\r\n  }\r\n  if (errorCode == '");
      out.print( Messages.MSG_SUB_GAP_EXISTS_3 );
      out.write("')\r\n  {\r\n    if (confirm('");
      out.print( MessageLookup.getMessageByNumber(Messages.MSG_SUB_GAP_EXISTS_3) );
      out.write("'))\r\n    {\r\n      document.frmPOC.hdnBSysIndPrfrmValidation.value = 'N';\r\n      var savePressed = ");
      out.print( isSavePressed );
      out.write(";\r\n      if(savePressed){\r\n      submitValidateForm(\"frmPOC\", \"/casemgmt/PaymentOfCare/savePOC\");\r\n      }else{\r\n      submitValidateForm(\"frmPOC\", \"/casemgmt/PaymentOfCare/saveAndSubmitPOC\");\r\n      }\r\n    }\r\n  }\r\n}\r\nfunction autofillEndDate(field ) \r\n{\r\n  var startingDateAsString = validateDateString( field.value );\r\n  var startingDateInMilliseconds = Date.parse( startingDateAsString );\r\n  var endDate = new Date( startingDateInMilliseconds );\r\n  var today = new Date();\r\n    \r\n  endDate.setYear( endDate.getYear() + 1 );\r\n  var sp = document.getElementById(\"displayEndDate_id\");\r\n  sp.innerText = (endDate.getMonth()+1) + \"/\" +endDate.getDate() + \"/\" +endDate.getYear();\r\n  document.frmPOC.txtEndDate.value = (endDate.getMonth()+1) + \"/\" +endDate.getDate() + \"/\" +endDate.getYear();\r\n}\r\n\r\nfunction autofillRenewDate(field )\r\n{\r\n  var startingDateAsString = validateDateString( field.value );\r\n  var startingDateInMilliseconds = Date.parse( startingDateAsString );\r\n  var endDate = new Date( startingDateInMilliseconds );\r\n");
      out.write("  var today = new Date();\r\n    \r\n  endDate.setYear( endDate.getYear() + 1 );\r\n  var sp = document.getElementById(\"displayRenewalDate_id\");\r\n  sp.innerText = (endDate.getMonth()+1) + \"/\" +endDate.getDate() + \"/\" +endDate.getYear();\r\n  document.frmPOC.txtRenewalDate.value = (endDate.getMonth()+1) + \"/\" +endDate.getDate() + \"/\" +endDate.getYear();\r\n}\r\n\r\nfunction resourceNoValidation()\r\n{\r\n  disableValidation(\"frmPOC\");\r\n}\r\n\r\nfunction confirmDelete()\r\n{\r\n  return confirm( \"");
      out.print( MessageLookup.getMessageByNumber( Messages.MSG_CONFIRM_ON_DELETE ) );
      out.write("\" );\r\n}\r\n\r\n");

String cciCodesString = CodesTables.CRBPROGI;
String cpaCodesString = CodesTables.CRBPROGA;

      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_0.setParent(null);
      _jspx_th_impact_codeArray_0.setCodeName(cciCodesString);
      _jspx_th_impact_codeArray_0.setArrayName("cciCodes");
      _jspx_th_impact_codeArray_0.setBlankValue("true");
      int _jspx_eval_impact_codeArray_0 = _jspx_th_impact_codeArray_0.doStartTag();
      if (_jspx_th_impact_codeArray_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write('\r');
      out.write('\n');
      //  impact:codeArray
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag _jspx_th_impact_codeArray_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.CodeArrayTag();
      _jspx_th_impact_codeArray_1.setPageContext(_jspx_page_context);
      _jspx_th_impact_codeArray_1.setParent(null);
      _jspx_th_impact_codeArray_1.setCodeName(cpaCodesString);
      _jspx_th_impact_codeArray_1.setArrayName("cpaCodes");
      _jspx_th_impact_codeArray_1.setBlankValue("true");
      int _jspx_eval_impact_codeArray_1 = _jspx_th_impact_codeArray_1.doStartTag();
      if (_jspx_th_impact_codeArray_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\r\nfunction updateType() \r\n {\r\n   var buttonGroup = document.frmPOC.scrIndProgramType;    \r\n   var radioValue = getSelectedRadioValue( buttonGroup );\r\n   \r\n   if ( radioValue == \"Y\" )\r\n   { \r\n     populateDropdown( document.frmPOC.selRbwoProgramType , document.frmPOC.selRbwoProgramType.value , cciCodes );\r\n   }\r\n   else if ( radioValue == \"N\" )\r\n   {\r\n     populateDropdown( document.frmPOC.selRbwoProgramType , document.frmPOC.selRbwoProgramType.value, cpaCodes );\r\n   }\r\n   else {\r\n     clearDropdown( document.frmPOC.selRbwoProgramType );\r\n   }\r\n }\r\n\r\n");

//Per STGAP00013397 MR-033 
//waiverOptionChange function is called on Change of waiver option check boxes.
//This will disable the Waiver Amount field if the Check box is changed from Custom Waiver to 
//either 80% Per-diem or 100% Per-diem With Waiver
//This function will also disable the Waiver Reason field if the check box of 80% Per-diem is selected.
//Deleted the javascript function waiverOptionChange as this will not be used for release 3.1 change.
//In case it is required in future you can find it in version 100209

      out.write(" \r\n  \r\nfunction onClickOf80()\r\n {\r\n  document.frmPOC.txtWavierAmount.value = \"\";\r\n  document.frmPOC.txtWavierAmount.disabled = true;\r\n  document.frmPOC.txtWaiverReason.value = \"\";\r\n  document.frmPOC.txtWaiverReason.disabled = true;\r\n  }\r\n       \r\nfunction onClickOf100()\r\n {\r\n  document.frmPOC.txtWavierAmount.value = \"\";\r\n  document.frmPOC.txtWavierAmount.disabled = true;\r\n  document.frmPOC.txtWaiverReason.value = \"\";\r\n  document.frmPOC.txtWaiverReason.disabled = false;\r\n }\r\n       \r\n\r\nfunction onClickOfCustomWaiver()\r\n {\r\n  document.frmPOC.txtWavierAmount.value = \"\";\r\n  document.frmPOC.txtWavierAmount.disabled = false;\r\n  document.frmPOC.txtWaiverReason.value = \"\";\r\n  document.frmPOC.txtWaiverReason.disabled = false;\r\n }\r\n  \r\nfunction checkTerminateDateInvalid(terminate, end) { \r\n  var endDateId = \"\" + end + \"_Id\";\r\n  var endDate = eval(document.getElementById(endDateId));\r\n  if ( terminate.value != \"\" && endDate.value != \"\")\r\n  { \r\n    var terminateDateAsString = validateDateString( terminate.value );\r\n    var endDateAsString = validateDateString( endDate.value );\r\n");
      out.write("    var fieldName = \"document.frmPOC.\"+terminate.name;\r\n    var validValue = \"document.frmPOC.\"+fieldName+\".value = \"+\"terminateDateAsString;\";\r\n    var refocus = \"document.frmPOC.\"+fieldName+\".blur();\";\r\n    var reselect = \"document.frmPOC.\"+fieldName+\".select();\";\r\n    // If input is invalid, pop message, put cursor back in field.\r\n    if ( terminateDateAsString == \"INVALID\" || endDateAsString == \"INVALID\" ||\r\n       (new Date( Date.parse(terminateDateAsString) ) > new Date( Date.parse(endDateAsString) ) ) )\r\n    {\r\n      alert(\"");
      out.print(MessageLookup.getMessageByNumber( Messages.SSM_CON_TERM_AFTER_END));
      out.write("\");\r\n      eval(refocus); eval(reselect);\r\n    } else {\r\n      eval(validValue);\r\n    }\r\n\r\n  }\r\n} \r\n\r\n");

// Only include function if payment care type is Relative Care Subsidy type and is not approved
if((CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType))
    && !isStatusAprv){

      out.write("\r\n// MR-087 Added Child turns 18 checkbox\r\nfunction onClickOfChildTurns18()\r\n{\r\n\tif(document.frmPOC.cbx18ByNextCrtRvw.checked == true){\r\n        document.frmPOC.txtCourtReviewDate.value = \"\";\r\n        disableDateField(document.frmPOC, document.frmPOC.txtCourtReviewDate);\r\n\t}else{\r\n        enableDateField(document.frmPOC, document.frmPOC.txtCourtReviewDate);\r\n\t}\r\n}\r\n");
}
      out.write("       \r\n\r\n</script>\r\n");
//*************************
      //*** VALIDATION ERRORS ***
      //*************************

      out.write('\r');
      out.write('\n');
      if (_jspx_meth_impact_validateErrors_0(_jspx_page_context))
        return;
      out.write('\r');
      out.write('\n');

      //********************************************
      //**** FORM (Payment of Care) STARTS HERE ****
      //********************************************

      
      out.write(' ');
      out.write('\r');
      out.write('\n');
      //  impact:validateForm
      gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag _jspx_th_impact_validateForm_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.FormTag();
      _jspx_th_impact_validateForm_0.setPageContext(_jspx_page_context);
      _jspx_th_impact_validateForm_0.setParent(null);
      _jspx_th_impact_validateForm_0.setName("frmPOC");
      _jspx_th_impact_validateForm_0.setMethod("post");
      _jspx_th_impact_validateForm_0.setAction("/casemgmt/PaymentOfCare/displayPOC");
      _jspx_th_impact_validateForm_0.setValidationClass("gov.georgia.dhr.dfcs.sacwis.web.casemgmt.PaymentOfCareCustomValidation");
      _jspx_th_impact_validateForm_0.setPageMode( pageMode );
      _jspx_th_impact_validateForm_0.setSchema("/WEB-INF/Constraints.xsd");
      _jspx_th_impact_validateForm_0.setClientValidation("true");
      int _jspx_eval_impact_validateForm_0 = _jspx_th_impact_validateForm_0.doStartTag();
      if (_jspx_eval_impact_validateForm_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
        do {
          out.write('\r');
          out.write('\n');
          out.write('	');
          if (_jspx_meth_impact_validateInput_0(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
if (approvalStatus) {

          out.write("\r\n\t<table border=\"0\" cellspacing=\"0\" cellpadding=\"3\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_0.setName("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_ButtonTag_0.setImg("btnApprovalStatus");
          _jspx_th_impact_ButtonTag_0.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_0.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_0.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_0.setAction("/workload/ApprovalStatus/displayStatus");
          int _jspx_eval_impact_ButtonTag_0 = _jspx_th_impact_ButtonTag_0.doStartTag();
          if (_jspx_th_impact_ButtonTag_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
}
     
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th>\r\n\t\t\t\tPayment of Care Type\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t\t\t<tr>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_0.setLabel("Payment of Care Type");
          _jspx_th_impact_validateSelect_0.setName("pocType");
          _jspx_th_impact_validateSelect_0.setCodesTable( CodesTables.CPOCTYPE );
          _jspx_th_impact_validateSelect_0.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_0.setValue(pocType);
          _jspx_th_impact_validateSelect_0.setDisabled(disablePocType);
          _jspx_th_impact_validateSelect_0.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_0 = _jspx_th_impact_validateSelect_0.doStartTag();
          if (_jspx_th_impact_validateSelect_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t\t<td>\r\n\t\t\t\t\t\t\t&nbsp;\r\n\t\t\t\t\t\t</td>\r\n\t\t\t\t\t</tr>\r\n\t\t\t\t</table>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
if (displayContinue) {
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_1.setName("btnContinue");
          _jspx_th_impact_ButtonTag_1.setImg("btnContinue");
          _jspx_th_impact_ButtonTag_1.setAlign("right");
          _jspx_th_impact_ButtonTag_1.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_1.setAction("/casemgmt/PaymentOfCare/reloadPOC");
          _jspx_th_impact_ButtonTag_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_1 = _jspx_th_impact_ButtonTag_1.doStartTag();
          if (_jspx_th_impact_ButtonTag_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
}//end continue button
          out.write('\r');
          out.write('\n');
          out.write('	');
if (!("".equals(pocType))) {
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_1.setType("hidden");
          _jspx_th_impact_validateInput_1.setName("hdnIdEvent");
          _jspx_th_impact_validateInput_1.setValue( hdnIdEvent );
          int _jspx_eval_impact_validateInput_1 = _jspx_th_impact_validateInput_1.doStartTag();
          if (_jspx_th_impact_validateInput_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_2.setType("hidden");
          _jspx_th_impact_validateInput_2.setName("ulIdStage");
          _jspx_th_impact_validateInput_2.setValue( ulIdStage );
          int _jspx_eval_impact_validateInput_2 = _jspx_th_impact_validateInput_2.doStartTag();
          if (_jspx_th_impact_validateInput_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t<input type=\"hidden\" name=\"szCdTask\" value=\"");
          out.print(cdTask);
          out.write("\">\r\n\t<br>\r\n\t");
if (CodesTables.CPOCTYPE_RFD.equals(pocType) || CodesTables.CPOCTYPE_EFD.equals(pocType) 
	        || CodesTables.CPOCTYPE_LOC.equals(pocType) || ArchitectureConstants.TRUE.equals(levelPocType)) {

          
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"6\">\r\n\t\t\t\tPayment of Care Detail\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_0.setLabel("Start Date");
          _jspx_th_impact_validateDate_0.setName("txtStartDate");
          _jspx_th_impact_validateDate_0.setType("text");
          _jspx_th_impact_validateDate_0.setValue( txtStartDate );
          _jspx_th_impact_validateDate_0.setSize("10");
          _jspx_th_impact_validateDate_0.setDisabled( startDateDisabled);
          _jspx_th_impact_validateDate_0.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_0.setConstraint("Date");
          int _jspx_eval_impact_validateDate_0 = _jspx_th_impact_validateDate_0.doStartTag();
          if (_jspx_th_impact_validateDate_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_1.setLabel("End Date");
          _jspx_th_impact_validateDate_1.setName("txtEndDate");
          _jspx_th_impact_validateDate_1.setType("text");
          _jspx_th_impact_validateDate_1.setValue( txtEndDate );
          _jspx_th_impact_validateDate_1.setSize("10");
          _jspx_th_impact_validateDate_1.setDisabled( endDateDisabled);
          _jspx_th_impact_validateDate_1.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateDate_1.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_1.setConstraint("Date");
          int _jspx_eval_impact_validateDate_1 = _jspx_th_impact_validateDate_1.doStartTag();
          if (_jspx_th_impact_validateDate_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_2.setLabel("Terminate Date");
          _jspx_th_impact_validateDate_2.setName("txtTermDate");
          _jspx_th_impact_validateDate_2.setType("text");
          _jspx_th_impact_validateDate_2.setValue( txtTermDate );
          _jspx_th_impact_validateDate_2.setDisabled( terminateDateDisabled);
          _jspx_th_impact_validateDate_2.setEditableMode( terminateDateEditableMode );
          _jspx_th_impact_validateDate_2.setOnChange("checkTerminateDateInvalid(this, 'txtEndDate')");
          _jspx_th_impact_validateDate_2.setSize("10");
          _jspx_th_impact_validateDate_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_2.setConstraint("Date");
          int _jspx_eval_impact_validateDate_2 = _jspx_th_impact_validateDate_2.doStartTag();
          if (_jspx_th_impact_validateDate_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_0.setLabel("Base Per Diem Rate");
          _jspx_th_impact_validateDisplayOnlyField_0.setName("txtPerDiem");
          _jspx_th_impact_validateDisplayOnlyField_0.setValue( txtPerDiem );
          int _jspx_eval_impact_validateDisplayOnlyField_0 = _jspx_th_impact_validateDisplayOnlyField_0.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_3.setType("text");
          _jspx_th_impact_validateInput_3.setLabel("Special Add On Rate (FC Only)");
          _jspx_th_impact_validateInput_3.setName("txtSpecialRate");
          _jspx_th_impact_validateInput_3.setValue( txtSpecialRate );
          _jspx_th_impact_validateInput_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_3.setDisabled(specialAddOnRateDisabled);
          _jspx_th_impact_validateInput_3.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_3.setSize("6");
          _jspx_th_impact_validateInput_3.setMaxLength("4");
          int _jspx_eval_impact_validateInput_3 = _jspx_th_impact_validateInput_3.doStartTag();
          if (_jspx_th_impact_validateInput_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_1.setLabel("Total Per Diem Rate");
          _jspx_th_impact_validateDisplayOnlyField_1.setName("txtTotalPerDiem");
          _jspx_th_impact_validateDisplayOnlyField_1.setValue( txtTotalPerDiem );
          int _jspx_eval_impact_validateDisplayOnlyField_1 = _jspx_th_impact_validateDisplayOnlyField_1.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t<td>\r\n\t\t</tr>\r\n\t\t");
 // STGAP00004406 - new fields added 
          out.write("\r\n\t\t");
 if (CodesTables.CPOCTYPE_LOC.equals(pocType)) { 
          out.write(" \r\n\t\t<tr>\r\n\t\t    <td>\r\n\t\t        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_2.setLabel("Program Type");
          _jspx_th_impact_validateDisplayOnlyField_2.setName("txtProgramType");
          _jspx_th_impact_validateDisplayOnlyField_2.setValue("");
          _jspx_th_impact_validateDisplayOnlyField_2.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDisplayOnlyField_2.setWidth("20%");
          int _jspx_eval_impact_validateDisplayOnlyField_2 = _jspx_th_impact_validateDisplayOnlyField_2.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    \r\n\t\t    \r\n\t\t        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_4.setType("radio");
          _jspx_th_impact_validateInput_4.setLabel("CCI");
          _jspx_th_impact_validateInput_4.setId("Program_Type_CCI");
          _jspx_th_impact_validateInput_4.setName("scrIndProgramType");
          _jspx_th_impact_validateInput_4.setValue("Y");
          _jspx_th_impact_validateInput_4.setCssClass("formInput");
          _jspx_th_impact_validateInput_4.setChecked( ""+ArchitectureConstants.Y.equals(indProgramType) );
          _jspx_th_impact_validateInput_4.setOnClick("updateType();");
          _jspx_th_impact_validateInput_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_4 = _jspx_th_impact_validateInput_4.doStartTag();
          if (_jspx_th_impact_validateInput_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_5.setType("radio");
          _jspx_th_impact_validateInput_5.setLabel("CPA");
          _jspx_th_impact_validateInput_5.setId("Program_Type_CPA");
          _jspx_th_impact_validateInput_5.setName("scrIndProgramType");
          _jspx_th_impact_validateInput_5.setValue("N");
          _jspx_th_impact_validateInput_5.setCssClass("formInput");
          _jspx_th_impact_validateInput_5.setChecked( ""+ArchitectureConstants.N.equals(indProgramType) );
          _jspx_th_impact_validateInput_5.setOnClick("updateType();");
          _jspx_th_impact_validateInput_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_5 = _jspx_th_impact_validateInput_5.doStartTag();
          if (_jspx_th_impact_validateInput_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t    <td>\r\n\t\t        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_1.setLabel("RBWO Program");
          _jspx_th_impact_validateSelect_1.setName("selRbwoProgramType");
          _jspx_th_impact_validateSelect_1.setCodesTable( rbwoProgramTypeCodesTable );
          _jspx_th_impact_validateSelect_1.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_1.setValue( rbwoProgramType );
          _jspx_th_impact_validateSelect_1.setDisabled( ""+isStatusAprv  );
          _jspx_th_impact_validateSelect_1.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_1 = _jspx_th_impact_validateSelect_1.doStartTag();
          if (_jspx_th_impact_validateSelect_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t</tr>\r\n\t\t");
 } 
          out.write("\r\n\t\t");
 // end STGAP00004406 - new fields added 
          out.write("\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_6.setLabel("Concurrent Per Diem");
          _jspx_th_impact_validateInput_6.setName("cbxConcPerDiem");
          _jspx_th_impact_validateInput_6.setType("checkbox");
          _jspx_th_impact_validateInput_6.setDisabled(levelPocType);
          _jspx_th_impact_validateInput_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_6.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_6.setChecked(FormattingHelper.formatString(cbxConcPerDiem));
          int _jspx_eval_impact_validateInput_6 = _jspx_th_impact_validateInput_6.doStartTag();
          if (_jspx_th_impact_validateInput_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span> Reason For Concurrent Per Diem Type:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_0 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_0.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_0.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_0.setName("txtReasonConcPerDiem");
          _jspx_th_impact_validateTextArea_0.setCols("110");
          _jspx_th_impact_validateTextArea_0.setRows("4");
          _jspx_th_impact_validateTextArea_0.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_0.setDisabled(levelPocType);
          _jspx_th_impact_validateTextArea_0.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_0 = _jspx_th_impact_validateTextArea_0.doStartTag();
          if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_0 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_0.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_0.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(txtReasonConcPerDiem));
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
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"2\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span> Reason For Special Add-On Rate:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_1 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_1.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_1.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_1.setName("txtReasonSpecPerDiem");
          _jspx_th_impact_validateTextArea_1.setCols("110");
          _jspx_th_impact_validateTextArea_1.setRows("4");
          _jspx_th_impact_validateTextArea_1.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_1.setDisabled(reasonSpecAddOnDisabled);
          _jspx_th_impact_validateTextArea_1.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_1 = _jspx_th_impact_validateTextArea_1.doStartTag();
          if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_1 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_1.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_1.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(txtReasonSpecPerDiem));
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
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t");
} else if (CodesTables.CPOCTYPE_SFD.equals(pocType) || CodesTables.CPOCTYPE_RWW.equals(pocType)) { 
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_7.setType("hidden");
          _jspx_th_impact_validateInput_7.setName("idPersComp");
          _jspx_th_impact_validateInput_7.setValue( idPersComp );
          int _jspx_eval_impact_validateInput_7 = _jspx_th_impact_validateInput_7.doStartTag();
          if (_jspx_th_impact_validateInput_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_8.setType("hidden");
          _jspx_th_impact_validateInput_8.setName("idSuprvApprv");
          _jspx_th_impact_validateInput_8.setValue( idSuprvApprv );
          int _jspx_eval_impact_validateInput_8 = _jspx_th_impact_validateInput_8.doStartTag();
          if (_jspx_th_impact_validateInput_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_9.setType("hidden");
          _jspx_th_impact_validateInput_9.setName("idSOStaffApprv");
          _jspx_th_impact_validateInput_9.setValue( idSOStaffApprv );
          int _jspx_eval_impact_validateInput_9 = _jspx_th_impact_validateInput_9.doStartTag();
          if (_jspx_th_impact_validateInput_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write('\r');
          out.write('\n');
          out.write('	');
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_10.setType("hidden");
          _jspx_th_impact_validateInput_10.setName("idRBWOStaffApprv");
          _jspx_th_impact_validateInput_10.setValue( idRBWOStaffApprv );
          int _jspx_eval_impact_validateInput_10 = _jspx_th_impact_validateInput_10.doStartTag();
          if (_jspx_th_impact_validateInput_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\r\n\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"12\">\r\n\t\t\t\tPayment of Care Detail\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_3.setLabel("Start Date");
          _jspx_th_impact_validateDate_3.setName("txtStartDate");
          _jspx_th_impact_validateDate_3.setType("text");
          _jspx_th_impact_validateDate_3.setValue( txtStartDate );
          _jspx_th_impact_validateDate_3.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_3.setConstraint("Date");
          int _jspx_eval_impact_validateDate_3 = _jspx_th_impact_validateDate_3.doStartTag();
          if (_jspx_th_impact_validateDate_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_4.setLabel("End Date");
          _jspx_th_impact_validateDate_4.setName("txtEndDate");
          _jspx_th_impact_validateDate_4.setType("text");
          _jspx_th_impact_validateDate_4.setValue( txtEndDate );
          _jspx_th_impact_validateDate_4.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_4.setDisabled( endDateDisabled);
          _jspx_th_impact_validateDate_4.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_validateDate_4.setConstraint("Date");
          int _jspx_eval_impact_validateDate_4 = _jspx_th_impact_validateDate_4.doStartTag();
          if (_jspx_th_impact_validateDate_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_5.setLabel("Terminate Date");
          _jspx_th_impact_validateDate_5.setName("txtTermDate");
          _jspx_th_impact_validateDate_5.setType("text");
          _jspx_th_impact_validateDate_5.setValue( txtTermDate );
          _jspx_th_impact_validateDate_5.setDisabled( terminateDateDisabled);
          _jspx_th_impact_validateDate_5.setEditableMode( terminateDateEditableMode );
          _jspx_th_impact_validateDate_5.setOnChange("checkTerminateDateInvalid(this, 'txtEndDate')");
          _jspx_th_impact_validateDate_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_5.setConstraint("Date");
          int _jspx_eval_impact_validateDate_5 = _jspx_th_impact_validateDate_5.doStartTag();
          if (_jspx_th_impact_validateDate_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_3.setLabel("Base Per Diem Rate");
          _jspx_th_impact_validateDisplayOnlyField_3.setName("txtPerDiem");
          _jspx_th_impact_validateDisplayOnlyField_3.setValue( txtPerDiem );
          _jspx_th_impact_validateDisplayOnlyField_3.setWidth("20%");
          int _jspx_eval_impact_validateDisplayOnlyField_3 = _jspx_th_impact_validateDisplayOnlyField_3.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_11.setType("text");
          _jspx_th_impact_validateInput_11.setLabel("Special Add On Rate (FC Only)");
          _jspx_th_impact_validateInput_11.setName("txtSpecialRate");
          _jspx_th_impact_validateInput_11.setValue( txtSpecialRate );
          _jspx_th_impact_validateInput_11.setDisabled(specialAddOnRateDisabled);
          _jspx_th_impact_validateInput_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_11.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_11.setMaxLength("4");
          _jspx_th_impact_validateInput_11.setSize("6");
          _jspx_th_impact_validateInput_11.setWidth("20%");
          int _jspx_eval_impact_validateInput_11 = _jspx_th_impact_validateInput_11.doStartTag();
          if (_jspx_th_impact_validateInput_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_12.setType("text");
          _jspx_th_impact_validateInput_12.setLabel("Specialized FC/RBWO Waiver");
          _jspx_th_impact_validateInput_12.setName("txtFcRbwoWaiver");
          _jspx_th_impact_validateInput_12.setValue( txtFcRbwoWaiver );
          _jspx_th_impact_validateInput_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_12.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_12.setConstraint("Double");
          _jspx_th_impact_validateInput_12.setMaxLength("7");
          _jspx_th_impact_validateInput_12.setSize("8");
          _jspx_th_impact_validateInput_12.setWidth("20%");
          int _jspx_eval_impact_validateInput_12 = _jspx_th_impact_validateInput_12.doStartTag();
          if (_jspx_th_impact_validateInput_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_4.setLabel("Total Per Diem Rate");
          _jspx_th_impact_validateDisplayOnlyField_4.setName("txtPerDiem");
          _jspx_th_impact_validateDisplayOnlyField_4.setValue( txtTotalPerDiem );
          int _jspx_eval_impact_validateDisplayOnlyField_4 = _jspx_th_impact_validateDisplayOnlyField_4.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t");
 // STGAP00004406 - new fields added 
          out.write("\r\n\t\t");
 if (CodesTables.CPOCTYPE_RWW.equals(pocType)) { 
          out.write("\r\n\t\t<tr>\r\n\t\t    <td>\r\n\t\t        ");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_5.setLabel("Program Type");
          _jspx_th_impact_validateDisplayOnlyField_5.setName("txtProgramType");
          _jspx_th_impact_validateDisplayOnlyField_5.setValue("");
          _jspx_th_impact_validateDisplayOnlyField_5.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDisplayOnlyField_5.setWidth("20%");
          int _jspx_eval_impact_validateDisplayOnlyField_5 = _jspx_th_impact_validateDisplayOnlyField_5.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t        ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_13.setType("radio");
          _jspx_th_impact_validateInput_13.setLabel("CCI");
          _jspx_th_impact_validateInput_13.setId("Program_Type_CCI");
          _jspx_th_impact_validateInput_13.setName("scrIndProgramType");
          _jspx_th_impact_validateInput_13.setValue("Y");
          _jspx_th_impact_validateInput_13.setCssClass("formInput");
          _jspx_th_impact_validateInput_13.setChecked( ""+ArchitectureConstants.Y.equals(indProgramType) );
          _jspx_th_impact_validateInput_13.setOnClick("updateType();");
          _jspx_th_impact_validateInput_13.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_13 = _jspx_th_impact_validateInput_13.doStartTag();
          if (_jspx_th_impact_validateInput_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t  ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_14.setType("radio");
          _jspx_th_impact_validateInput_14.setLabel("CPA");
          _jspx_th_impact_validateInput_14.setId("Program_Type_CPA");
          _jspx_th_impact_validateInput_14.setName("scrIndProgramType");
          _jspx_th_impact_validateInput_14.setValue("N");
          _jspx_th_impact_validateInput_14.setCssClass("formInput");
          _jspx_th_impact_validateInput_14.setChecked( ""+ArchitectureConstants.N.equals(indProgramType) );
          _jspx_th_impact_validateInput_14.setOnClick("updateType();");
          _jspx_th_impact_validateInput_14.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_14 = _jspx_th_impact_validateInput_14.doStartTag();
          if (_jspx_th_impact_validateInput_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t    <td>\r\n\t\t        ");
          //  impact:validateSelect
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag _jspx_th_impact_validateSelect_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.SelectTag();
          _jspx_th_impact_validateSelect_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateSelect_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateSelect_2.setLabel("RBWO Program");
          _jspx_th_impact_validateSelect_2.setName("selRbwoProgramType");
          _jspx_th_impact_validateSelect_2.setCodesTable( rbwoProgramTypeCodesTable );
          _jspx_th_impact_validateSelect_2.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateSelect_2.setValue(  rbwoProgramType );
          _jspx_th_impact_validateSelect_2.setDisabled( ""+isStatusAprv  );
          _jspx_th_impact_validateSelect_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateSelect_2 = _jspx_th_impact_validateSelect_2.doStartTag();
          if (_jspx_th_impact_validateSelect_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t    </td>\r\n\t\t</tr>\r\n\t\t");
 } 
          out.write("\r\n\t\t");
 // end  STGAP00004406 - new fields added 
          out.write("\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"12\">\r\n\t\t\t\tApproval Information\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_6.setLabel("Packet Complete");
          _jspx_th_impact_validateDate_6.setName("txtPacketComp");
          _jspx_th_impact_validateDate_6.setType("text");
          _jspx_th_impact_validateDate_6.setValue( txtPacketComp );
          _jspx_th_impact_validateDate_6.setSize("10");
          _jspx_th_impact_validateDate_6.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_6.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_6.setConstraint("Date");
          int _jspx_eval_impact_validateDate_6 = _jspx_th_impact_validateDate_6.doStartTag();
          if (_jspx_th_impact_validateDate_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_15.setType("radio");
          _jspx_th_impact_validateInput_15.setLabel("Initial");
          _jspx_th_impact_validateInput_15.setId("RBWO_Type_Init");
          _jspx_th_impact_validateInput_15.setName("scrIndRbwoType");
          _jspx_th_impact_validateInput_15.setValue("I");
          _jspx_th_impact_validateInput_15.setCssClass("formInput");
          _jspx_th_impact_validateInput_15.setChecked( rbwoTypeInitial );
          _jspx_th_impact_validateInput_15.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_15 = _jspx_th_impact_validateInput_15.doStartTag();
          if (_jspx_th_impact_validateInput_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"left\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_16.setType("radio");
          _jspx_th_impact_validateInput_16.setLabel("Review Change");
          _jspx_th_impact_validateInput_16.setId("RBWO_Type_RC");
          _jspx_th_impact_validateInput_16.setName("scrIndRbwoType");
          _jspx_th_impact_validateInput_16.setValue("R");
          _jspx_th_impact_validateInput_16.setCssClass("\r\n				  formInput");
          _jspx_th_impact_validateInput_16.setChecked( rbwoTypeReview );
          _jspx_th_impact_validateInput_16.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_16 = _jspx_th_impact_validateInput_16.doStartTag();
          if (_jspx_th_impact_validateInput_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td align=\"left\">\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_17.setType("radio");
          _jspx_th_impact_validateInput_17.setLabel("Emergency");
          _jspx_th_impact_validateInput_17.setId("RBWO_Type_Emer");
          _jspx_th_impact_validateInput_17.setName("scrIndRbwoType");
          _jspx_th_impact_validateInput_17.setValue("E");
          _jspx_th_impact_validateInput_17.setCssClass("formInput");
          _jspx_th_impact_validateInput_17.setChecked( rbwoTypeEmergency );
          _jspx_th_impact_validateInput_17.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_17 = _jspx_th_impact_validateInput_17.doStartTag();
          if (_jspx_th_impact_validateInput_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr bgcolor=\"E0E0E0\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_18.setType("text");
          _jspx_th_impact_validateInput_18.setLabel("Person Completing");
          _jspx_th_impact_validateInput_18.setName("txtPersComp");
          _jspx_th_impact_validateInput_18.setValue( txtPersComp );
          _jspx_th_impact_validateInput_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_18.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_18.setReadOnly("true");
          _jspx_th_impact_validateInput_18.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_18 = _jspx_th_impact_validateInput_18.doStartTag();
          if (_jspx_th_impact_validateInput_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_6.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_6.setName("persCompTitle");
          _jspx_th_impact_validateDisplayOnlyField_6.setConditionallyRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_6.setValue( persCompTitle );
          int _jspx_eval_impact_validateDisplayOnlyField_6 = _jspx_th_impact_validateDisplayOnlyField_6.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_2.setName("btnSelectStaffPerComp");
          _jspx_th_impact_ButtonTag_2.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_2.setAlign("left");
          _jspx_th_impact_ButtonTag_2.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_2.setAction("/casemgmt/PaymentOfCare/performStaffSearch");
          _jspx_th_impact_ButtonTag_2.setFunction("disableValidation('frmPOC')");
          _jspx_th_impact_ButtonTag_2.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_2 = _jspx_th_impact_ButtonTag_2.doStartTag();
          if (_jspx_th_impact_ButtonTag_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_7.setLabel("Packet/Emergency Supv. Approval");
          _jspx_th_impact_validateDate_7.setName("txtPackEmergAppr");
          _jspx_th_impact_validateDate_7.setType("text");
          _jspx_th_impact_validateDate_7.setValue( txtPackEmergAppr );
          _jspx_th_impact_validateDate_7.setSize("10");
          _jspx_th_impact_validateDate_7.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_7.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_7.setConstraint("Date");
          int _jspx_eval_impact_validateDate_7 = _jspx_th_impact_validateDate_7.doStartTag();
          if (_jspx_th_impact_validateDate_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_19 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_19.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_19.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_19.setType("text");
          _jspx_th_impact_validateInput_19.setLabel("Supervisor Approving");
          _jspx_th_impact_validateInput_19.setName("txtSuprvApprv");
          _jspx_th_impact_validateInput_19.setValue( txtSuprvApprv );
          _jspx_th_impact_validateInput_19.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_19.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_19.setReadOnly("true");
          _jspx_th_impact_validateInput_19.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_19 = _jspx_th_impact_validateInput_19.doStartTag();
          if (_jspx_th_impact_validateInput_19.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_7.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_7.setName("suprvsrApprvTitle");
          _jspx_th_impact_validateDisplayOnlyField_7.setConditionallyRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_7.setValue( suprvsrApprvTitle );
          int _jspx_eval_impact_validateDisplayOnlyField_7 = _jspx_th_impact_validateDisplayOnlyField_7.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_3.setName("btnSelectStaffSuprvApprv");
          _jspx_th_impact_ButtonTag_3.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_3.setAlign("left");
          _jspx_th_impact_ButtonTag_3.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_3.setAction("/casemgmt/PaymentOfCare/performStaffSearch");
          _jspx_th_impact_ButtonTag_3.setFunction("disableValidation('frmPOC')");
          _jspx_th_impact_ButtonTag_3.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_3 = _jspx_th_impact_ButtonTag_3.doStartTag();
          if (_jspx_th_impact_ButtonTag_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr bgcolor=\"E0E0E0\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_8.setLabel("Packet Sent");
          _jspx_th_impact_validateDate_8.setName("txtPacketSent");
          _jspx_th_impact_validateDate_8.setType("text");
          _jspx_th_impact_validateDate_8.setValue( txtPacketSent );
          _jspx_th_impact_validateDate_8.setSize("10");
          _jspx_th_impact_validateDate_8.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_8.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_8.setConstraint("Date");
          int _jspx_eval_impact_validateDate_8 = _jspx_th_impact_validateDate_8.doStartTag();
          if (_jspx_th_impact_validateDate_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr bgcolor=\"E0E0E0\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_9.setLabel("Staffing Complete");
          _jspx_th_impact_validateDate_9.setName("txtStaffComp");
          _jspx_th_impact_validateDate_9.setType("text");
          _jspx_th_impact_validateDate_9.setValue( txtStaffComp );
          _jspx_th_impact_validateDate_9.setSize("10");
          _jspx_th_impact_validateDate_9.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_9.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_9.setConstraint("Date");
          int _jspx_eval_impact_validateDate_9 = _jspx_th_impact_validateDate_9.doStartTag();
          if (_jspx_th_impact_validateDate_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_10.setLabel("State Office Response");
          _jspx_th_impact_validateDate_10.setName("txtSOResponse");
          _jspx_th_impact_validateDate_10.setType("text");
          _jspx_th_impact_validateDate_10.setValue( txtSOResponse );
          _jspx_th_impact_validateDate_10.setSize("10");
          _jspx_th_impact_validateDate_10.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_10.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_10.setConstraint("Date");
          int _jspx_eval_impact_validateDate_10 = _jspx_th_impact_validateDate_10.doStartTag();
          if (_jspx_th_impact_validateDate_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_20 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_20.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_20.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_20.setType("text");
          _jspx_th_impact_validateInput_20.setLabel("Staff Approving");
          _jspx_th_impact_validateInput_20.setName("txtSOStaffApprv");
          _jspx_th_impact_validateInput_20.setValue( txtSOStaffApprv );
          _jspx_th_impact_validateInput_20.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_20.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_20.setReadOnly("true");
          _jspx_th_impact_validateInput_20.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_20 = _jspx_th_impact_validateInput_20.doStartTag();
          if (_jspx_th_impact_validateInput_20.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_8.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_8.setName("soStaffApprvTitle");
          _jspx_th_impact_validateDisplayOnlyField_8.setConditionallyRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_8.setValue( soStaffApprvTitle );
          int _jspx_eval_impact_validateDisplayOnlyField_8 = _jspx_th_impact_validateDisplayOnlyField_8.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_4.setName("btnSelectStaffSOApprv");
          _jspx_th_impact_ButtonTag_4.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_4.setAlign("left");
          _jspx_th_impact_ButtonTag_4.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_4.setAction("/casemgmt/PaymentOfCare/performStaffSearch");
          _jspx_th_impact_ButtonTag_4.setFunction("disableValidation('frmPOC')");
          _jspx_th_impact_ButtonTag_4.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_4 = _jspx_th_impact_ButtonTag_4.doStartTag();
          if (_jspx_th_impact_ButtonTag_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr bgcolor=\"E0E0E0\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_11.setLabel("RBWO Review");
          _jspx_th_impact_validateDate_11.setName("txtRBWOReview");
          _jspx_th_impact_validateDate_11.setType("text");
          _jspx_th_impact_validateDate_11.setValue( txtRBWOReview );
          _jspx_th_impact_validateDate_11.setSize("10");
          _jspx_th_impact_validateDate_11.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_11.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_11.setConstraint("Date");
          int _jspx_eval_impact_validateDate_11 = _jspx_th_impact_validateDate_11.doStartTag();
          if (_jspx_th_impact_validateDate_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\t\t<tr bgcolor=\"E0E0E0\">\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_21 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_21.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_21.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_21.setType("text");
          _jspx_th_impact_validateInput_21.setLabel("Staff Approving");
          _jspx_th_impact_validateInput_21.setName("txtRBWOStaffApprv");
          _jspx_th_impact_validateInput_21.setValue( txtRBWOStaffApprv );
          _jspx_th_impact_validateInput_21.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_21.setConditionallyRequired("true");
          _jspx_th_impact_validateInput_21.setReadOnly("true");
          _jspx_th_impact_validateInput_21.setConstraint("Name25");
          int _jspx_eval_impact_validateInput_21 = _jspx_th_impact_validateInput_21.doStartTag();
          if (_jspx_th_impact_validateInput_21.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_9.setLabel("Title");
          _jspx_th_impact_validateDisplayOnlyField_9.setName("rbwoStaffApprvTitle");
          _jspx_th_impact_validateDisplayOnlyField_9.setConditionallyRequired("true");
          _jspx_th_impact_validateDisplayOnlyField_9.setValue( rbwoStaffApprvTitle );
          int _jspx_eval_impact_validateDisplayOnlyField_9 = _jspx_th_impact_validateDisplayOnlyField_9.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_5.setName("btnSelectStaffRBWOApprv");
          _jspx_th_impact_ButtonTag_5.setImg("btnSelectStaff");
          _jspx_th_impact_ButtonTag_5.setAlign("left");
          _jspx_th_impact_ButtonTag_5.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_5.setAction("/casemgmt/PaymentOfCare/performStaffSearch");
          _jspx_th_impact_ButtonTag_5.setFunction("disableValidation('frmPOC')");
          _jspx_th_impact_ButtonTag_5.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_5 = _jspx_th_impact_ButtonTag_5.doStartTag();
          if (_jspx_th_impact_ButtonTag_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td></td>\r\n\t\t\t<td></td>\r\n\t\t</tr>\r\n\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"3\">\r\n\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span> Reason For Specialized FC/RBWO Waiver:\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td colspan=\"5\">\r\n\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_2 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_2.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_2.setName("txtReasonSpecWaiver");
          _jspx_th_impact_validateTextArea_2.setCols("110");
          _jspx_th_impact_validateTextArea_2.setRows("4");
          _jspx_th_impact_validateTextArea_2.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_2.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_2 = _jspx_th_impact_validateTextArea_2.doStartTag();
          if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_2 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_2.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_2.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(txtReasonSpecWaiver));
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
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\r\n\t</table>\r\n\r\n\r\n\t");
} else if (CodesTables.CPOCTYPE_ERR.equals(pocType)) { 
          out.write("\r\n\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t<tr>\r\n\t\t\t<th colspan=\"7\">\r\n\t\t\t\tPayment of Care Detail\r\n\t\t\t</th>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_12.setLabel("Start Date");
          _jspx_th_impact_validateDate_12.setName("txtStartDate");
          _jspx_th_impact_validateDate_12.setType("text");
          _jspx_th_impact_validateDate_12.setValue( txtStartDate );
          _jspx_th_impact_validateDate_12.setSize("10");
          _jspx_th_impact_validateDate_12.setRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateDate_12.setOnChange("autofillEndDate(this)");
          _jspx_th_impact_validateDate_12.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_12.setConstraint("Date");
          int _jspx_eval_impact_validateDate_12 = _jspx_th_impact_validateDate_12.doStartTag();
          if (_jspx_th_impact_validateDate_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_22 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_22.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_22.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_22.setType("hidden");
          _jspx_th_impact_validateInput_22.setName("txtEndDate");
          _jspx_th_impact_validateInput_22.setValue( txtEndDate );
          int _jspx_eval_impact_validateInput_22 = _jspx_th_impact_validateInput_22.doStartTag();
          if (_jspx_th_impact_validateInput_22.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_10.setLabel("End Date");
          _jspx_th_impact_validateDisplayOnlyField_10.setName("displayEndDate");
          _jspx_th_impact_validateDisplayOnlyField_10.setValue( displayEndDate );
          int _jspx_eval_impact_validateDisplayOnlyField_10 = _jspx_th_impact_validateDisplayOnlyField_10.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_13.setLabel("Terminate Date");
          _jspx_th_impact_validateDate_13.setName("txtTermDate");
          _jspx_th_impact_validateDate_13.setType("text");
          _jspx_th_impact_validateDate_13.setValue( txtTermDate );
          _jspx_th_impact_validateDate_13.setDisabled( terminateDateDisabled);
          _jspx_th_impact_validateDate_13.setEditableMode( terminateDateEditableMode );
          _jspx_th_impact_validateDate_13.setOnChange("checkTerminateDateInvalid(this, 'displayEndDate')");
          _jspx_th_impact_validateDate_13.setSize("10");
          _jspx_th_impact_validateDate_13.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_13.setConstraint("Date");
          int _jspx_eval_impact_validateDate_13 = _jspx_th_impact_validateDate_13.doStartTag();
          if (_jspx_th_impact_validateDate_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_23 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_23.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_23.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_23.setType("text");
          _jspx_th_impact_validateInput_23.setLabel("Relative");
          _jspx_th_impact_validateInput_23.setName("txtRelative");
          _jspx_th_impact_validateInput_23.setValue( txtRelative );
          _jspx_th_impact_validateInput_23.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_23.setRequired("true");
          _jspx_th_impact_validateInput_23.setReadOnly("true");
          int _jspx_eval_impact_validateInput_23 = _jspx_th_impact_validateInput_23.doStartTag();
          if (_jspx_th_impact_validateInput_23.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n            <td>\r\n                ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_24 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_24.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_24.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_24.setType("text");
          _jspx_th_impact_validateInput_24.setLabel("Resource ID");
          _jspx_th_impact_validateInput_24.setName("txtRelativeId");
          _jspx_th_impact_validateInput_24.setValue( String.valueOf(idRelative) );
          _jspx_th_impact_validateInput_24.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_24.setRequired("true");
          _jspx_th_impact_validateInput_24.setReadOnly("true");
          int _jspx_eval_impact_validateInput_24 = _jspx_th_impact_validateInput_24.doStartTag();
          if (_jspx_th_impact_validateInput_24.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n            </td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_6 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_6.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_6.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_6.setName("btnResource");
          _jspx_th_impact_ButtonTag_6.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_6.setAlign("left");
          _jspx_th_impact_ButtonTag_6.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_6.setAction("/casemgmt/PaymentOfCare/getResource");
          _jspx_th_impact_ButtonTag_6.setFunction("resourceNoValidation()");
          _jspx_th_impact_ButtonTag_6.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_6 = _jspx_th_impact_ButtonTag_6.doStartTag();
          if (_jspx_th_impact_ButtonTag_6.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_25 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_25.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_25.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_25.setType("hidden");
          _jspx_th_impact_validateInput_25.setName("idRelative");
          _jspx_th_impact_validateInput_25.setValue( idRelative );
          int _jspx_eval_impact_validateInput_25 = _jspx_th_impact_validateInput_25.doStartTag();
          if (_jspx_th_impact_validateInput_25.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t       <td colspan=\"8\">\t\t\r\n                  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t <tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_26 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_26.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_26.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_26.setChecked( CodesTables.CPERDIEM_W1.equals(checkedPerDiem) ? "true" : "false");
          _jspx_th_impact_validateInput_26.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_26.setValue(CodesTables.CPERDIEM_W1 );
          _jspx_th_impact_validateInput_26.setType("radio");
          _jspx_th_impact_validateInput_26.setName("rbCWaiverOptions");
          _jspx_th_impact_validateInput_26.setLabel("80% Per Diem");
          _jspx_th_impact_validateInput_26.setCssClass("formInput");
          _jspx_th_impact_validateInput_26.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_26.setOnClick("onClickOf80()");
          int _jspx_eval_impact_validateInput_26 = _jspx_th_impact_validateInput_26.doStartTag();
          if (_jspx_th_impact_validateInput_26.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_27 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_27.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_27.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_27.setChecked( CodesTables.CPERDIEM_W2.equals(checkedPerDiem) ? "true" : "false");
          _jspx_th_impact_validateInput_27.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_27.setValue(CodesTables.CPERDIEM_W2 );
          _jspx_th_impact_validateInput_27.setType("radio");
          _jspx_th_impact_validateInput_27.setName("rbCWaiverOptions");
          _jspx_th_impact_validateInput_27.setLabel("100% Per Diem");
          _jspx_th_impact_validateInput_27.setCssClass("formInput");
          _jspx_th_impact_validateInput_27.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_27.setOnClick("onClickOf100()");
          int _jspx_eval_impact_validateInput_27 = _jspx_th_impact_validateInput_27.doStartTag();
          if (_jspx_th_impact_validateInput_27.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_28 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_28.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_28.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_28.setChecked( CodesTables.CPERDIEM_W3.equals(checkedPerDiem) ? "true" : "false");
          _jspx_th_impact_validateInput_28.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_28.setValue(CodesTables.CPERDIEM_W3 );
          _jspx_th_impact_validateInput_28.setType("radio");
          _jspx_th_impact_validateInput_28.setName("rbCWaiverOptions");
          _jspx_th_impact_validateInput_28.setLabel("Custom Waiver");
          _jspx_th_impact_validateInput_28.setCssClass("formInput");
          _jspx_th_impact_validateInput_28.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_28.setOnClick("onClickOfCustomWaiver()");
          int _jspx_eval_impact_validateInput_28 = _jspx_th_impact_validateInput_28.doStartTag();
          if (_jspx_th_impact_validateInput_28.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n                  \r\n                 </table>\r\n\t\t   \t  </td>\t\t\t\r\n\t\t   </tr>\r\n\t\t\t<tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_11.setLabel("Enhanced Relative Rate");
          _jspx_th_impact_validateDisplayOnlyField_11.setName("txtEnhancedRelativeRate");
          _jspx_th_impact_validateDisplayOnlyField_11.setValue( txtEnhancedRelativeRate );
          int _jspx_eval_impact_validateDisplayOnlyField_11 = _jspx_th_impact_validateDisplayOnlyField_11.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_29 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_29.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_29.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_29.setLabel("Waiver Amount");
          _jspx_th_impact_validateInput_29.setName("txtWavierAmount");
          _jspx_th_impact_validateInput_29.setType("text");
          _jspx_th_impact_validateInput_29.setValue( txtWavierAmount );
          _jspx_th_impact_validateInput_29.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_29.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_29.setSize("10");
          _jspx_th_impact_validateInput_29.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_29.setConstraint("Double");
          _jspx_th_impact_validateInput_29.setWidth("20%");
          int _jspx_eval_impact_validateInput_29 = _jspx_th_impact_validateInput_29.doStartTag();
          if (_jspx_th_impact_validateInput_29.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_30 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_30.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_30.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_30.setType("hidden");
          _jspx_th_impact_validateInput_30.setName("hdnWavierAmount");
          _jspx_th_impact_validateInput_30.setValue( txtWavierAmount );
          int _jspx_eval_impact_validateInput_30 = _jspx_th_impact_validateInput_30.doStartTag();
          if (_jspx_th_impact_validateInput_30.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span> Waiver Reason:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_3 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_3.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_3.setName("txtWaiverReason");
          _jspx_th_impact_validateTextArea_3.setCols("100");
          _jspx_th_impact_validateTextArea_3.setRows("4");
          _jspx_th_impact_validateTextArea_3.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateTextArea_3.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_3.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_3 = _jspx_th_impact_validateTextArea_3.doStartTag();
          if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_3.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_3.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(txtWaiverReason));
              out.write("\r\n\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_3.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_3 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t");
} else if (CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType) || CodesTables.CPOCTYPE_SUG.equals(pocType) 
		      || CodesTables.CPOCTYPE_ESG.equals(pocType) || CodesTables.CPOCTYPE_NSG.equals(pocType) || CodesTables.CPOCTYPE_NEG.equals(pocType)) { 
          out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" class=\"tableBorder\">\r\n\t\t\t<tr>\r\n\t\t\t\t<th colspan=\"12\">\r\n\t\t\t\t\tPayment of Care Detail\r\n\t\t\t\t</th>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t<span class=\"formRequiredText\">*</span>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_31 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_31.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_31.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_31.setType("radio");
          _jspx_th_impact_validateInput_31.setLabel("Initial");
          _jspx_th_impact_validateInput_31.setId("RCS_Type_Init");
          _jspx_th_impact_validateInput_31.setName("scrIndRcsType");
          _jspx_th_impact_validateInput_31.setValue("I");
          _jspx_th_impact_validateInput_31.setCssClass("formInput");
          _jspx_th_impact_validateInput_31.setChecked( rcsTypeInitial );
          _jspx_th_impact_validateInput_31.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_31 = _jspx_th_impact_validateInput_31.doStartTag();
          if (_jspx_th_impact_validateInput_31.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td align=\"left\">\r\n\t\t\t\t<span class=\"formRequiredText\">*</span>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_32 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_32.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_32.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_32.setType("radio");
          _jspx_th_impact_validateInput_32.setLabel("Renewal");
          _jspx_th_impact_validateInput_32.setId("RCS_Type_Renewal");
          _jspx_th_impact_validateInput_32.setName("scrIndRcsType");
          _jspx_th_impact_validateInput_32.setValue("R");
          _jspx_th_impact_validateInput_32.setCssClass("formInput");
          _jspx_th_impact_validateInput_32.setChecked( rcsTypeRenewal );
          _jspx_th_impact_validateInput_32.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_validateInput_32 = _jspx_th_impact_validateInput_32.doStartTag();
          if (_jspx_th_impact_validateInput_32.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_14 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_14.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_14.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_14.setLabel("Agreement Date");
          _jspx_th_impact_validateDate_14.setName("txtAgreeDate");
          _jspx_th_impact_validateDate_14.setType("text");
          _jspx_th_impact_validateDate_14.setValue( txtAgreeDate );
          _jspx_th_impact_validateDate_14.setSize("10");
          _jspx_th_impact_validateDate_14.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_14.setConstraint("Date");
          int _jspx_eval_impact_validateDate_14 = _jspx_th_impact_validateDate_14.doStartTag();
          if (_jspx_th_impact_validateDate_14.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_15 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_15.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_15.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_15.setLabel("Annual Review Date");
          _jspx_th_impact_validateDate_15.setName("txtAnnualReviewDate");
          _jspx_th_impact_validateDate_15.setType("text");
          _jspx_th_impact_validateDate_15.setValue( txtAnnualReviewDate );
          _jspx_th_impact_validateDate_15.setSize("10");
          _jspx_th_impact_validateDate_15.setRequired("true");
          _jspx_th_impact_validateDate_15.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_15.setConstraint("Date");
          int _jspx_eval_impact_validateDate_15 = _jspx_th_impact_validateDate_15.doStartTag();
          if (_jspx_th_impact_validateDate_15.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_16 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_16.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_16.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_16.setLabel("Effective Payment Date");
          _jspx_th_impact_validateDate_16.setName("txtEffPayDate");
          _jspx_th_impact_validateDate_16.setType("text");
          _jspx_th_impact_validateDate_16.setValue( txtEffPayDate );
          _jspx_th_impact_validateDate_16.setSize("10");
          _jspx_th_impact_validateDate_16.setRequired("true");
          _jspx_th_impact_validateDate_16.setOnChange("autofillRenewDate(this)");
          _jspx_th_impact_validateDate_16.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_16.setConstraint("Date");
          int _jspx_eval_impact_validateDate_16 = _jspx_th_impact_validateDate_16.doStartTag();
          if (_jspx_th_impact_validateDate_16.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_33 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_33.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_33.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_33.setType("hidden");
          _jspx_th_impact_validateInput_33.setName("txtRenewalDate");
          _jspx_th_impact_validateInput_33.setValue( txtRenewalDate );
          int _jspx_eval_impact_validateInput_33 = _jspx_th_impact_validateInput_33.doStartTag();
          if (_jspx_th_impact_validateInput_33.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_12 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_12.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_12.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_12.setLabel("Renewal Date");
          _jspx_th_impact_validateDisplayOnlyField_12.setName("displayRenewalDate");
          _jspx_th_impact_validateDisplayOnlyField_12.setValue( displayRenewalDate );
          int _jspx_eval_impact_validateDisplayOnlyField_12 = _jspx_th_impact_validateDisplayOnlyField_12.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_12.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n            ");
 // MR-087 Only display for one of the Relative care subsidies type
             if(CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)){ 
          out.write("\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_17 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_17.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_17.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_17.setLabel("Court Review Due By");
          _jspx_th_impact_validateDate_17.setName("txtCourtReviewDate");
          _jspx_th_impact_validateDate_17.setType("text");
          _jspx_th_impact_validateDate_17.setValue( txtCourtReviewDate );
          _jspx_th_impact_validateDate_17.setConditionallyRequired( String.valueOf(CodesTables.CPOCTYPE_RCS.equals(pocType) || CodesTables.CPOCTYPE_ERS.equals(pocType)));
          _jspx_th_impact_validateDate_17.setDisabled( String.valueOf(!CodesTables.CPOCTYPE_RCS.equals(pocType) && !CodesTables.CPOCTYPE_ERS.equals(pocType)));
          _jspx_th_impact_validateDate_17.setSize("10");
          _jspx_th_impact_validateDate_17.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_17.setConstraint("Date");
          int _jspx_eval_impact_validateDate_17 = _jspx_th_impact_validateDate_17.doStartTag();
          if (_jspx_th_impact_validateDate_17.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t    &nbsp;&nbsp;&nbsp;&nbsp;<span ><a href=\"javascript:void window.open ('/document/DocumentConversation/displayPaymentOfCareHelp', 'newwindow', config='height='+(screen.height*2)/3+', width='+screen.width/3+', toolbar=no, menubar=no, scrollbars=yes, resizable=yes,location=no, directories=no, status=no, left='+screen.width/1.52+' top=0')\" onClick=\"hrefDirtyBypass=true;\">?</a></span>\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n                    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_34 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_34.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_34.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_34.setLabel("Child turns 18 prior to next Court Review");
          _jspx_th_impact_validateInput_34.setName("cbx18ByNextCrtRvw");
          _jspx_th_impact_validateInput_34.setType("checkbox");
          _jspx_th_impact_validateInput_34.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_34.setValue("Y");
          _jspx_th_impact_validateInput_34.setReadOnly( String.valueOf(!CodesTables.CPOCTYPE_RCS.equals(pocType) && !CodesTables.CPOCTYPE_ERS.equals(pocType)));
          _jspx_th_impact_validateInput_34.setOnClick("onClickOfChildTurns18()");
          _jspx_th_impact_validateInput_34.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_34.setChecked(FormattingHelper.formatString(cbx18ByNextCrtRvw));
          int _jspx_eval_impact_validateInput_34 = _jspx_th_impact_validateInput_34.doStartTag();
          if (_jspx_th_impact_validateInput_34.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n            ");
 } 
          out.write("\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_35 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_35.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_35.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_35.setType("text");
          _jspx_th_impact_validateInput_35.setLabel("Placement Resource");
          _jspx_th_impact_validateInput_35.setName("txtRelative");
          _jspx_th_impact_validateInput_35.setValue( txtRelative );
          _jspx_th_impact_validateInput_35.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_35.setRequired("true");
          _jspx_th_impact_validateInput_35.setReadOnly("true");
          int _jspx_eval_impact_validateInput_35 = _jspx_th_impact_validateInput_35.doStartTag();
          if (_jspx_th_impact_validateInput_35.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n                <td>\r\n                    ");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_36 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_36.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_36.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_36.setType("text");
          _jspx_th_impact_validateInput_36.setLabel("Resource ID");
          _jspx_th_impact_validateInput_36.setName("txtRelativeId");
          _jspx_th_impact_validateInput_36.setValue( String.valueOf(idRelative) );
          _jspx_th_impact_validateInput_36.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_36.setRequired("true");
          _jspx_th_impact_validateInput_36.setReadOnly("true");
          int _jspx_eval_impact_validateInput_36 = _jspx_th_impact_validateInput_36.doStartTag();
          if (_jspx_th_impact_validateInput_36.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n                </td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_7 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_7.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_7.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_7.setName("btnResource");
          _jspx_th_impact_ButtonTag_7.setImg("btnSelectResource");
          _jspx_th_impact_ButtonTag_7.setAlign("left");
          _jspx_th_impact_ButtonTag_7.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_7.setAction("/casemgmt/PaymentOfCare/getResource");
          _jspx_th_impact_ButtonTag_7.setFunction("resourceNoValidation()");
          _jspx_th_impact_ButtonTag_7.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_7 = _jspx_th_impact_ButtonTag_7.doStartTag();
          if (_jspx_th_impact_ButtonTag_7.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_37 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_37.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_37.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_37.setType("hidden");
          _jspx_th_impact_validateInput_37.setName("idRelative");
          _jspx_th_impact_validateInput_37.setValue( idRelative );
          int _jspx_eval_impact_validateInput_37 = _jspx_th_impact_validateInput_37.doStartTag();
          if (_jspx_th_impact_validateInput_37.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_38 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_38.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_38.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_38.setLabel("Family Income Less Than $150,000");
          _jspx_th_impact_validateInput_38.setName("cbxFamIncLess");
          _jspx_th_impact_validateInput_38.setType("checkbox");
          _jspx_th_impact_validateInput_38.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_38.setValue("Y");
          _jspx_th_impact_validateInput_38.setEditableMode( EditableMode.EDIT + EditableMode.NEW );
          _jspx_th_impact_validateInput_38.setChecked(FormattingHelper.formatString(cbxFamIncLess));
          int _jspx_eval_impact_validateInput_38 = _jspx_th_impact_validateInput_38.doStartTag();
          if (_jspx_th_impact_validateInput_38.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t       <td colspan=\"8\">\t\t\r\n                  <table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t <tr>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_39 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_39.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_39.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_39.setChecked( CodesTables.CPERDIEM_W1.equals(checkedPerDiem) ? "true" : "false");
          _jspx_th_impact_validateInput_39.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_39.setValue(CodesTables.CPERDIEM_W1 );
          _jspx_th_impact_validateInput_39.setType("radio");
          _jspx_th_impact_validateInput_39.setName("rbCWaiverOptions");
          _jspx_th_impact_validateInput_39.setLabel("80% Per Diem");
          _jspx_th_impact_validateInput_39.setCssClass("formInput");
          _jspx_th_impact_validateInput_39.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_39.setOnClick("onClickOf80()");
          int _jspx_eval_impact_validateInput_39 = _jspx_th_impact_validateInput_39.doStartTag();
          if (_jspx_th_impact_validateInput_39.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_40 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_40.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_40.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_40.setChecked( CodesTables.CPERDIEM_W2.equals(checkedPerDiem) ? "true" : "false");
          _jspx_th_impact_validateInput_40.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_40.setValue(CodesTables.CPERDIEM_W2 );
          _jspx_th_impact_validateInput_40.setType("radio");
          _jspx_th_impact_validateInput_40.setName("rbCWaiverOptions");
          _jspx_th_impact_validateInput_40.setLabel("100% Per Diem");
          _jspx_th_impact_validateInput_40.setCssClass("formInput");
          _jspx_th_impact_validateInput_40.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_40.setOnClick("onClickOf100()");
          int _jspx_eval_impact_validateInput_40 = _jspx_th_impact_validateInput_40.doStartTag();
          if (_jspx_th_impact_validateInput_40.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t\t<td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_41 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_41.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_41.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_41.setChecked( CodesTables.CPERDIEM_W3.equals(checkedPerDiem) ? "true" : "false");
          _jspx_th_impact_validateInput_41.setTabIndex(tabIndex++);
          _jspx_th_impact_validateInput_41.setValue(CodesTables.CPERDIEM_W3 );
          _jspx_th_impact_validateInput_41.setType("radio");
          _jspx_th_impact_validateInput_41.setName("rbCWaiverOptions");
          _jspx_th_impact_validateInput_41.setLabel("Custom Waiver");
          _jspx_th_impact_validateInput_41.setCssClass("formInput");
          _jspx_th_impact_validateInput_41.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_41.setOnClick("onClickOfCustomWaiver()");
          int _jspx_eval_impact_validateInput_41 = _jspx_th_impact_validateInput_41.doStartTag();
          if (_jspx_th_impact_validateInput_41.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</td>\r\n\t\t</tr>\r\n                  \r\n                 </table>\r\n\t\t   \t  </td>\t\t\t\r\n\t\t   </tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDisplayOnlyField
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag _jspx_th_impact_validateDisplayOnlyField_13 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DisplayOnlyInputTag();
          _jspx_th_impact_validateDisplayOnlyField_13.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDisplayOnlyField_13.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDisplayOnlyField_13.setLabel("Monthly Subsidy");
          _jspx_th_impact_validateDisplayOnlyField_13.setName("monthlySubsidy");
          _jspx_th_impact_validateDisplayOnlyField_13.setValue( monthlySubsidy );
          int _jspx_eval_impact_validateDisplayOnlyField_13 = _jspx_th_impact_validateDisplayOnlyField_13.doStartTag();
          if (_jspx_th_impact_validateDisplayOnlyField_13.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_42 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_42.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_42.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_42.setLabel("Waiver Amount");
          _jspx_th_impact_validateInput_42.setName("txtWavierAmount");
          _jspx_th_impact_validateInput_42.setType("text");
          _jspx_th_impact_validateInput_42.setValue( txtWavierAmount );
          _jspx_th_impact_validateInput_42.setConditionallyRequired( ArchitectureConstants.TRUE );
          _jspx_th_impact_validateInput_42.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateInput_42.setSize("10");
          _jspx_th_impact_validateInput_42.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_42.setConstraint("Double");
          _jspx_th_impact_validateInput_42.setWidth("20%");
          int _jspx_eval_impact_validateInput_42 = _jspx_th_impact_validateInput_42.doStartTag();
          if (_jspx_th_impact_validateInput_42.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_43 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_43.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_43.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_43.setType("hidden");
          _jspx_th_impact_validateInput_43.setName("hdnWavierAmount");
          _jspx_th_impact_validateInput_43.setValue( txtWavierAmount );
          int _jspx_eval_impact_validateInput_43 = _jspx_th_impact_validateInput_43.doStartTag();
          if (_jspx_th_impact_validateInput_43.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span> Waiver Reason:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_4 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_4.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_4.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_4.setName("txtWaiverReason");
          _jspx_th_impact_validateTextArea_4.setCols("110");
          _jspx_th_impact_validateTextArea_4.setRows("4");
          _jspx_th_impact_validateTextArea_4.setDisabled( notEsgOrNeg );
          _jspx_th_impact_validateTextArea_4.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_4.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_4 = _jspx_th_impact_validateTextArea_4.doStartTag();
          if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_4.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_4.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(txtWaiverReason));
              out.write("\r\n\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_4.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_4 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_4.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_44 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_44.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_44.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_44.setLabel("Terminate");
          _jspx_th_impact_validateInput_44.setName("cbxTerminate");
          _jspx_th_impact_validateInput_44.setType("checkbox");
          _jspx_th_impact_validateInput_44.setChecked( FormattingHelper.formatString(cbxTerminate) );
          _jspx_th_impact_validateInput_44.setValue("Y");
          _jspx_th_impact_validateInput_44.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_44.setEditableMode( StringHelper.isTrue(terminateDateDisabled) ? EditableMode.NONE : EditableMode.ALL );
          int _jspx_eval_impact_validateInput_44 = _jspx_th_impact_validateInput_44.doStartTag();
          if (_jspx_th_impact_validateInput_44.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateInput
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_45 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
          _jspx_th_impact_validateInput_45.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateInput_45.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateInput_45.setLabel("Suspend");
          _jspx_th_impact_validateInput_45.setName("cbxSuspend");
          _jspx_th_impact_validateInput_45.setType("checkbox");
          _jspx_th_impact_validateInput_45.setChecked( FormattingHelper.formatString(cbxSuspend) );
          _jspx_th_impact_validateInput_45.setValue("Y");
          _jspx_th_impact_validateInput_45.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateInput_45.setEditableMode( StringHelper.isTrue(terminateDateDisabled) ? EditableMode.NONE : EditableMode.ALL );
          int _jspx_eval_impact_validateInput_45 = _jspx_th_impact_validateInput_45.doStartTag();
          if (_jspx_th_impact_validateInput_45.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td>\r\n\t\t\t\t\t");
          //  impact:validateDate
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag _jspx_th_impact_validateDate_18 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.DateTag();
          _jspx_th_impact_validateDate_18.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateDate_18.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateDate_18.setLabel("Susp./Term Date");
          _jspx_th_impact_validateDate_18.setName("txtTermDate");
          _jspx_th_impact_validateDate_18.setType("text");
          _jspx_th_impact_validateDate_18.setValue( txtTermDate );
          _jspx_th_impact_validateDate_18.setDisabled( terminateDateDisabled);
          _jspx_th_impact_validateDate_18.setEditableMode( terminateDateEditableMode );
          _jspx_th_impact_validateDate_18.setConditionallyRequired("true");
          _jspx_th_impact_validateDate_18.setSize("10");
          _jspx_th_impact_validateDate_18.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateDate_18.setConstraint("Date");
          int _jspx_eval_impact_validateDate_18 = _jspx_th_impact_validateDate_18.doStartTag();
          if (_jspx_th_impact_validateDate_18.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t<td></td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"2\">\r\n\t\t\t\t\t<span class=\"formCondRequiredText\">&#135;</span> Reason for Suspension/Termination:\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t\t<tr>\r\n\t\t\t\t<td colspan=\"4\">\r\n\t\t\t\t\t");
          //  impact:validateTextArea
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag _jspx_th_impact_validateTextArea_5 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.TextAreaTag();
          _jspx_th_impact_validateTextArea_5.setPageContext(_jspx_page_context);
          _jspx_th_impact_validateTextArea_5.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_validateTextArea_5.setName("txtReasonSuspTerm");
          _jspx_th_impact_validateTextArea_5.setCols("110");
          _jspx_th_impact_validateTextArea_5.setRows("4");
          _jspx_th_impact_validateTextArea_5.setDisabled( terminateDateDisabled);
          _jspx_th_impact_validateTextArea_5.setEditableMode( EditableMode.VIEW );
          _jspx_th_impact_validateTextArea_5.setTabIndex( tabIndex++ );
          _jspx_th_impact_validateTextArea_5.setMaxLength(300);
          int _jspx_eval_impact_validateTextArea_5 = _jspx_th_impact_validateTextArea_5.doStartTag();
          if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE) {
              out = _jspx_page_context.pushBody();
              _jspx_th_impact_validateTextArea_5.setBodyContent((javax.servlet.jsp.tagext.BodyContent) out);
              _jspx_th_impact_validateTextArea_5.doInitBody();
            }
            do {
              out.print(FormattingHelper.formatString(txtReasonSuspTerm));
              out.write("\r\n\t\t\t\t\t");
              int evalDoAfterBody = _jspx_th_impact_validateTextArea_5.doAfterBody();
              if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
                break;
            } while (true);
            if (_jspx_eval_impact_validateTextArea_5 != javax.servlet.jsp.tagext.Tag.EVAL_BODY_INCLUDE)
              out = _jspx_page_context.popBody();
          }
          if (_jspx_th_impact_validateTextArea_5.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\t\t</table>\r\n\t\t");
}//end types of payment of care
          out.write("\r\n\r\n\t\t");
}//end if pocType is not null

          out.write("\r\n\r\n\t\t");

      //*****************
      //**** BUTTONS ****
      //*****************

      if (!displayContinue) {

        
          out.write("\r\n\t\t<table border=\"0\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\">\r\n\t\t\t<tr>\r\n\t\t\t");
if(isStatusAprv && modifyApproveAccess){
          out.write("\r\n\t\t\t    <td class=\"alignLeft\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_8 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_8.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_8.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_8.setName("btnDelete");
          _jspx_th_impact_ButtonTag_8.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_8.setAlign("left");
          _jspx_th_impact_ButtonTag_8.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_8.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_8.setAction("/casemgmt/PaymentOfCare/deletePOC");
          _jspx_th_impact_ButtonTag_8.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_8.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_8.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_8 = _jspx_th_impact_ButtonTag_8.doStartTag();
          if (_jspx_th_impact_ButtonTag_8.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t");
 } else { 
          out.write("\r\n\t\t\t\t<td></td>\r\n\t\t\t\t");
 }
            if (!PageModeConstants.APPROVE.equals(pageMode)) {
               if (!("0".equals(hdnIdEvent))) {

            
          out.write("\r\n\t\t\t\t<td class=\"alignLeft\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_9 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_9.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_9.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_9.setName("btnDelete");
          _jspx_th_impact_ButtonTag_9.setImg("btnDelete");
          _jspx_th_impact_ButtonTag_9.setAlign("left");
          _jspx_th_impact_ButtonTag_9.setNavAwayCk(true);
          _jspx_th_impact_ButtonTag_9.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_9.setAction("/casemgmt/PaymentOfCare/deletePOC");
          _jspx_th_impact_ButtonTag_9.setFunction("return confirmDelete()");
          _jspx_th_impact_ButtonTag_9.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_9 = _jspx_th_impact_ButtonTag_9.doStartTag();
          if (_jspx_th_impact_ButtonTag_9.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");
} else {
          out.write("\r\n\t\t\t\t<td></td>\r\n\t\t\t\t");
}//end delete button
          out.write("\r\n\t\t\t\t");
if(saveAndSubmit){ 
          out.write("\r\n\t\t\t\t<td width=\"85%\" class=\"alignRight\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_10 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_10.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_10.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_10.setName("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_10.setImg("btnSaveAndSubmit");
          _jspx_th_impact_ButtonTag_10.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_10.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_10.setAction("/casemgmt/PaymentOfCare/saveAndSubmitPOC");
          _jspx_th_impact_ButtonTag_10.setAlign("right");
          _jspx_th_impact_ButtonTag_10.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_10 = _jspx_th_impact_ButtonTag_10.doStartTag();
          if (_jspx_th_impact_ButtonTag_10.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t\t");

				 }
				 
          out.write("\r\n\t\t\t\t");
}//end if not in approve status
          out.write("\r\n\t\t\t\r\n\t\t\t<!-- Save button displays in all cases even approved Payment of Care since assigned case manager or supervisor\r\n\t\t\t     might need to modify Terminate Date as necessary \r\n\t\t\t     Disabled/hidden once payment terminated or it is already approved and person viewing has no stage access -->\r\n\t\t\t\t<td class=\"alignRight\">\r\n\t\t\t\t\t");
          //  impact:ButtonTag
          gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag _jspx_th_impact_ButtonTag_11 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.ButtonTag();
          _jspx_th_impact_ButtonTag_11.setPageContext(_jspx_page_context);
          _jspx_th_impact_ButtonTag_11.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
          _jspx_th_impact_ButtonTag_11.setName("btnSave");
          _jspx_th_impact_ButtonTag_11.setImg("btnSave");
          _jspx_th_impact_ButtonTag_11.setAlign("right");
          _jspx_th_impact_ButtonTag_11.setRestrictRepost(true);
          _jspx_th_impact_ButtonTag_11.setForm("frmPOC");
          _jspx_th_impact_ButtonTag_11.setAction("/casemgmt/PaymentOfCare/savePOC");
          _jspx_th_impact_ButtonTag_11.setDisabled( String.valueOf(!GlobalData.hasStageAccess(request)) );
          _jspx_th_impact_ButtonTag_11.setEditableMode( EditableMode.ALL );
          _jspx_th_impact_ButtonTag_11.setPreventDoubleClick(true);
          _jspx_th_impact_ButtonTag_11.setTabIndex( tabIndex++ );
          int _jspx_eval_impact_ButtonTag_11 = _jspx_th_impact_ButtonTag_11.doStartTag();
          if (_jspx_th_impact_ButtonTag_11.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
            return;
          out.write("\r\n\t\t\t\t</td>\r\n\t\t\t</tr>\r\n\r\n\t\t</table>\r\n\t\t");
}//display save submit and delete buttons
          out.write("\r\n\t    ");
          if (_jspx_meth_impact_validateInput_46(_jspx_th_impact_validateForm_0, _jspx_page_context))
            return;
          out.write("\r\n\t    <input type=\"hidden\" name=\"");
          out.print(HiddenFieldSessionStateManager.HIDDEN_FIELD_KEY);
          out.write("\"/>\r\n\t\t");
          int evalDoAfterBody = _jspx_th_impact_validateForm_0.doAfterBody();
          if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
            break;
        } while (true);
      }
      if (_jspx_th_impact_validateForm_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
        return;
      out.write("\r\n\t\t\r\n");
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
    _jspx_th_impact_validateInput_0.setName("hdnBSysIndPrfrmValidation");
    _jspx_th_impact_validateInput_0.setValue("Y");
    int _jspx_eval_impact_validateInput_0 = _jspx_th_impact_validateInput_0.doStartTag();
    if (_jspx_th_impact_validateInput_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }

  private boolean _jspx_meth_impact_validateInput_46(javax.servlet.jsp.tagext.JspTag _jspx_th_impact_validateForm_0, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  impact:validateInput
    gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag _jspx_th_impact_validateInput_46 = new gov.georgia.dhr.dfcs.sacwis.web.core.validation.taglib.InputTag();
    _jspx_th_impact_validateInput_46.setPageContext(_jspx_page_context);
    _jspx_th_impact_validateInput_46.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_impact_validateForm_0);
    _jspx_th_impact_validateInput_46.setType("hidden");
    _jspx_th_impact_validateInput_46.setName("destinationUrl");
    _jspx_th_impact_validateInput_46.setValue("/casemgmt/PaymentOfCare/setPocResource");
    int _jspx_eval_impact_validateInput_46 = _jspx_th_impact_validateInput_46.doStartTag();
    if (_jspx_th_impact_validateInput_46.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE)
      return true;
    return false;
  }
}
