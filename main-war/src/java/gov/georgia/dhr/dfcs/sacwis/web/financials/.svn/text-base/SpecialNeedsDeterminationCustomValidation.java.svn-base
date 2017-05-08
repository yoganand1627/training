package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

/**
 * SpecialNeedsDetermination.jsp Custom validation class
 * 
 * @author Vishala Devarakonda
 * @version 1.0
 * 
 * Date           User           Description
 * ----------     -------------  --------------------------------
 * 10/1/2008      swroberts      STGAP00010462 - Updated for R3.0 (Adoption Release)
 * 02/06/2009     mchillman      STGAP00012185 - Added validation for new recurring section
 * 05/26/2009     mchillman      STGAP00013902: Added validation for Special Needs Approval Type STGAP00013910: Limit validation to only respite special service type
 * 06/05/2009     bgehlot        STGAP00013970: Checking indRsnSpcNeedsReq with Empty String also.
 * 06/08/2009     bgehlot        STGAP00012194: The first Application with None Applicable Special needs is allowed but when another Application is added 
 *                               after that it should give is message asking to add an application with Special Needs other than None Applicable.
 * 07/06/2009     bgehlot        STGAP00014563: Adding validations for Basic Rate Type and Custom Amount
 * 08/28/2009     bgehlot        STGAP00014491: If none Applicable is selected then approval is required only for the first application not the
 *                               subsequent ones.
 * 02/01/2010     bgehlot        SMS#44783: MR-60 Changes, Pre Post radio buttons added, Special Needs Type and Approval Type
 *                                          radio buttons changed to the drop down, new types added.
 * 03/09/2011     htvo           SMS#97845 MR-074-2 AFCARS: require incident status determined in order to approve     
 * 05/25/2011     htvo           SMS#109403 MR-082: new validations for non-recurring only application    
 *                               - Special needs request must be specified on the non-recurring only application
 *                               - Date Approved required to approve the non-recurring only application  
 *                               - Non-recurring only application can only be approved for non-incident children                             
 * 06/07/2011     htvo           SMS#109403: correct SMS code from 10943 to 109403
 * 02/07/2012	  vcollooru		 STGAP00017878: (Break-fix defect for 5.1) Following are the changes done as part of the fix -
 *   								i) Added validation to shall enforce approvers to select Agreement Type before pressing the Approval Status button.

 */
@SuppressWarnings("serial")
public class SpecialNeedsDeterminationCustomValidation extends FormValidation {
  public static final String TRACE_TAG = "SpecialNeedsDeterminationCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    boolean result = true;

    String indMentRet = ContextHelper.getStringSafe(request, "rbMentRet");
    String txtMentRet = ContextHelper.getStringSafe(request, "txtMentRetDiag");
    String indVHImp = ContextHelper.getStringSafe(request, "rbVHImpaired");
    String txtVHImpairedDiag = ContextHelper.getStringSafe(request, "txtVHImpairedDiag");
    String rbPhyDisabled = ContextHelper.getStringSafe(request, "rbPhyDisabled");
    String txtPhyDisabledDiag = ContextHelper.getStringSafe(request, "txtPhyDisabledDiag");
    String rbEmDisturbed = ContextHelper.getStringSafe(request, "rbEmDisturbed");
    String txtEmDisturbedDiag = ContextHelper.getStringSafe(request, "txtEmDisturbedDiag");
    String rbOthMedCondition = ContextHelper.getStringSafe(request, "rbOthMedCondition");
    String txtOthMedCondition = ContextHelper.getStringSafe(request, "txtOthMedCondition");
    String rbBasicRateReq = ContextHelper.getStringSafe(request, "rbBasicRateReq");
    String rbSpNdDetReqApprv = ContextHelper.getStringSafe(request, "rbSpNdDetReqApprv");
    String rbSpecRateReq = ContextHelper.getStringSafe(request, "rbSpecRateReq");
    String cbxPsychological = CheckboxHelper.getCheckboxValue(request, "cbxPsychological");
    String cbxDevAssmtEval = CheckboxHelper.getCheckboxValue(request, "cbxDevAssmtEval");
    String cbxTrtmntPrvdr = CheckboxHelper.getCheckboxValue(request, "cbxTrtmntPrvdr");
    String cbxMedAssmnt = CheckboxHelper.getCheckboxValue(request, "cbxMedAssmnt");
    String cbxSSI = CheckboxHelper.getCheckboxValue(request, "cbxSSI");
    String rbSpecServiceReq = ContextHelper.getStringSafe(request, "rbSpecServiceReq");
    Double txtSzReqAmt = ContextHelper.getMoneyAsDoubleSafe(request, "txtSzReqAmt");
    String selSzCdSpecServType = ContextHelper.getStringSafe(request, "selSzCdSpecServType");
    String txtPlSpecify = ContextHelper.getStringSafe(request, "txtPlSpecify");
    String rbApprovalType = ContextHelper.getStringSafe(request, "rbApprovalType");
    String cbxMentRetarded = CheckboxHelper.getCheckboxValue(request, "cbxMentRetarded");
    String cbxVHImpaired = CheckboxHelper.getCheckboxValue(request, "cbxVHImpaired");
    String cbxPhysDisabled = CheckboxHelper.getCheckboxValue(request, "cbxPhysDisabled");
    String cbxEmDisturbed = CheckboxHelper.getCheckboxValue(request, "cbxEmDisturbed");
    String cbxOthMedCond = CheckboxHelper.getCheckboxValue(request, "cbxOthMedCond");
    String rbSpecRateAprv = ContextHelper.getStringSafe(request, "rbSpecRateAprv");
    Double txtSzTotalAprvAmt = ContextHelper.getMoneyAsDoubleSafe(request, "txtSzTotalAprvAmt");
    String rbSpecServReqAprv = ContextHelper.getStringSafe(request, "rbSpecServReqAprv");
    Double txtSzAprvAmt = ContextHelper.getMoneyAsDoubleSafe(request, "txtSzAprvAmt");
    Date txtDtDtAprvDate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtAprvDate"));
    Date txtDtDtExpDate = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "txtDtDtExpDate"));
    String hdnHasCurrentEligibility = ContextHelper.getString(request, "hdnHasCurrentEligibility");
    // SMS#109403: use hidden field to get value when field is disabled
    String rbNonRecReq = ContextHelper.getStringSafe(request, "hdnNonRecReq");
    String rbNonRecReqAprv = ContextHelper.getStringSafe(request, "rbNonRecReqAprv");
    int intNumSPNChildReq = ContextHelper.getIntSafe(request, "txtSzNumSPNChildReq");
    boolean isFirstApplication = ContextHelper.getBooleanSafe(request, "hdnFirstApplication");
    String indRsnSpcNeedsReq = ContextHelper.getStringSafe(request, "rbCIndRsnSpcNeedsReq");
    boolean priorAprvSpecialNeedsDeter = ContextHelper.getBooleanSafe(request, "hdnPriorAprvSpecialNeedsDeter");
    String cbxNonRecOnly = CheckboxHelper.getCheckboxValue(request, "cbxNonRecOnly");
    String indRsnSpcNeedsAprv = ContextHelper.getStringSafe(request, "rbApprovalType");
    boolean specialNeedsNotReq = ContextHelper.getBooleanSafe(request, "specialNeedsNotReq");
    String reason = ContextHelper.getStringSafe(request, "reason");
    // STGAP00014563: Get the Basic Rate Type
    String cdBasicRateType = ContextHelper.getStringSafe(request, "cdBasicRateType");
    Double txtNbrCustomAmt = ContextHelper.getMoneyAsDoubleSafe(request, "txtNbrCustomAmt");
    Double txtNbrCountyAddonAmt = ContextHelper.getMoneyAsDoubleSafe(request, "txtNbrCountyAddonAmt");
    String agrmtType = ContextHelper.getString(request, "rbAgrmtType");

    // SMS#97845 MR-074-2 AFCARS:
    String rbIncNonIncStatus = ContextHelper.getStringSafe(request, "rbIncNonIncStatus");
    String rbIncNonIncStatus_Disabled = ContextHelper.getStringSafe(request, "rbIncNonIncStatus_Disabled"); 
    
    Date txtDtSpecialNeedsApprvd = ContextHelper.getJavaDateSafe(request, "txtDtSpecialNeedsApprvd");

    if ((ArchitectureConstants.Y.equals(indMentRet) && "".equals(txtMentRet))) {
      setErrorMessage("txtMentRetDiag", Messages.MSG_ADO_SPC_DIAGNOSES_REQD);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(indVHImp) && "".equals(txtVHImpairedDiag)) {
      setErrorMessage("txtVHImpairedDiag", Messages.MSG_ADO_SPC_DIAGNOSES_REQD);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(rbPhyDisabled) && "".equals(txtPhyDisabledDiag)) {
      setErrorMessage("txtPhyDisabledDiag", Messages.MSG_ADO_SPC_DIAGNOSES_REQD);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(rbEmDisturbed) && "".equals(txtEmDisturbedDiag)) {
      setErrorMessage("txtEmDisturbedDiag", Messages.MSG_ADO_SPC_DIAGNOSES_REQD);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(rbOthMedCondition) && "".equals(txtOthMedCondition)) {
      setErrorMessage("txtOthMedCondition", Messages.MSG_ADO_SPC_DIAGNOSES_REQD);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(rbSpecRateReq) && !ArchitectureConstants.Y.equals(cbxPsychological)
        && !ArchitectureConstants.Y.equals(cbxDevAssmtEval) && !ArchitectureConstants.Y.equals(cbxTrtmntPrvdr)
        && !ArchitectureConstants.Y.equals(cbxMedAssmnt) && !ArchitectureConstants.Y.equals(cbxSSI)) {
      setErrorMessage(Messages.MSG_ADO_SPC_RATE_DOC);
      result = false;
    }

    // MR-60 Added new approval type "V"(Child with Physical , Mental, or Emotional Disability, as certified by a
    // licensed physician or psychologist) in the condition
    if ((CodesTables.CSPCLTYP_M.equals(rbApprovalType) || CodesTables.CSPCLTYP_V.equals(rbApprovalType))
        && !ArchitectureConstants.Y.equals(cbxMentRetarded) && !ArchitectureConstants.Y.equals(cbxVHImpaired)
        && !ArchitectureConstants.Y.equals(cbxPhysDisabled) && !ArchitectureConstants.Y.equals(cbxEmDisturbed)
        && !ArchitectureConstants.Y.equals(cbxOthMedCond)) {
      setErrorMessage(Messages.MSG_ADO_SPC_DISA_TYPE);
      result = false;
    }

    if (ArchitectureConstants.Y.equals(rbSpecServiceReq) && txtSzReqAmt == 0.0) {
      setErrorMessage("txtSzReqAmt", Messages.MSG_ADO_SPC_SVC_RQST_AMT);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(rbSpecServiceReq) && "".equals(selSzCdSpecServType)) {
      setErrorMessage("selSzCdSpecServType", Messages.MSG_ADO_SPC_SVC_RQST_TYPE);
      result = false;
    }
    if (ArchitectureConstants.Y.equals(rbSpecServiceReq) && "".equals(txtPlSpecify)) {
      setErrorMessage("txtPlSpecify", Messages.MSG_ADO_SPC_SVC_RQST_SPEC);
      result = false;
    }

    if (ArchitectureConstants.Y.equals(rbSpecServiceReq) && CodesTables.CSPLSERV_RES.equals(selSzCdSpecServType)
        && intNumSPNChildReq == 0) {
      setErrorMessage("txtSzNumSPNChildReq", Messages.MSG_ADO_APP_SNC_SS);
      result = false;
    }

    if (ArchitectureConstants.Y.equals(rbSpecServiceReq) && priorAprvSpecialNeedsDeter == false) {
      setErrorMessage(Messages.MSG_ADO_APP_APRV_SPN_REQ);
      result = false;
    }

    if (super.isButtonPressed("btnSaveSubmit") && ArchitectureConstants.Y.equals(cbxNonRecOnly) == false) {

      if (!"true".equals(hdnHasCurrentEligibility)) {
        setErrorMessage(Messages.MSG_NO_IVE_ON_SAVE);
        result = false;
      }

      // STGAP00012194: If none Applicable is selected still should get that error message asking for SND
      if (isFirstApplication == true) {
        if (indRsnSpcNeedsReq == null
            || indRsnSpcNeedsReq.length() == 0
            || (CodesTables.CSPCLTYP_N.equals(indRsnSpcNeedsReq) && (ArchitectureConstants.Y.equals(rbBasicRateReq)
                                                                     || ArchitectureConstants.Y.equals(rbSpecRateReq) || ArchitectureConstants.Y
                                                                                                                                                .equals(rbNonRecReq)))) {
          setErrorMessage(Messages.MSG_ADO_APP_SND_REQ_INIT);
          result = false;
        }
      }

      // STGAP00012194: The first Application with None Applicable Special needs is allowed but when another Application
      // is added
      // after that it should give is message asking to add an application with Special Needs other than None
      // Applicable.
      if (specialNeedsNotReq) {
        if (indRsnSpcNeedsReq == null || indRsnSpcNeedsReq.length() == 0
            || CodesTables.CSPCLTYP_N.equals(indRsnSpcNeedsReq)) {
          if (CodesTables.CSPCLTYP_N.equals(reason)) {
            setErrorMessage(Messages.MSG_ADO_APP_SND_REQ_INIT);
            result = false;
          }
        }
      }
    }
    // SMS#109403: require special needs request on the non-recurring only application
    if (super.isButtonPressed("btnSaveSubmit")) {
      if (ArchitectureConstants.Y.equals(cbxNonRecOnly)) {
        if (StringHelper.isEmptyOrNull(indRsnSpcNeedsReq)) {
          setErrorMessage(Messages.MSG_ADO_APP_SND_REQ_NON_REC);
          result = false;
        }
      }
    }

    // do not perform approval validation if in PEND or COMP status
    String eventStatus = request.getParameter("hdnEventStatus");
    boolean isApprover = ContextHelper.getBooleanSafe(request, "hdnApprover");
    boolean performValidation = (CodesTables.CEVTSTAT_PROC.equals(eventStatus) || CodesTables.CEVTSTAT_COMP
                                                                                                           .equals(eventStatus)) ? false
                                                                                                                                : true;
    // Only show the error messages if the Approval Status button is clicked
    if (super.isButtonPressed("btnApprovalStatusFinal") && performValidation && isApprover) {

      if (!StringHelper.isValid(agrmtType)) {
    	setErrorMessage(Messages.MSG_ADO_INIT_AMND_AGRMT_TYPE);
    	result = false;
      }

      if (ArchitectureConstants.Y.equals(rbBasicRateReq) && "".equals(rbSpNdDetReqApprv)) {
        setErrorMessage(Messages.MSG_AA_APP_APROVE);
        result = false;
      }

      if (ArchitectureConstants.Y.equals(rbSpNdDetReqApprv)) {
        if (indRsnSpcNeedsAprv == null || indRsnSpcNeedsAprv.length() == 0) {
          setErrorMessage(Messages.MSG_ADO_SPC_DISA_TYPE);
          result = false;
        }
      }

      if (ArchitectureConstants.Y.equals(rbSpecRateReq) && "".equals(rbSpecRateAprv)) {
        setErrorMessage(Messages.MSG_AA_APP_APROVE);
        result = false;
      }

      // STGAP00013970: Checking inRsnSpcNeedsReq with Empty String also.
      // STGAP00012194: Approval required for None Applicable also.
      // STGAP00014491: Added none applicable check back
      if (((indRsnSpcNeedsReq != null && !StringHelper.EMPTY_STRING.equals(indRsnSpcNeedsReq))
           && indRsnSpcNeedsReq.length() >= 0 && (CodesTables.CSPCLTYP_N.equals(indRsnSpcNeedsReq) == false))
          && "".equals(rbSpNdDetReqApprv)) {
        setErrorMessage(Messages.MSG_AA_APP_APROVE);
        result = false;
      }

      // STGAP00014491: If none Applicable is selected then approval is required only for the first application not the
      // subsequent ones.
      if (isFirstApplication == true) {
        if ((CodesTables.CSPCLTYP_N.equals(indRsnSpcNeedsReq) == true) && "".equals(rbSpNdDetReqApprv)) {
          setErrorMessage(Messages.MSG_AA_APP_APROVE);
          result = false;
        }
      }

      if (ArchitectureConstants.Y.equals(rbSpecServiceReq) && "".equals(rbSpecServReqAprv)) {
        setErrorMessage(Messages.MSG_AA_APP_APROVE);
        result = false;
      }

      if (ArchitectureConstants.Y.equals(rbSpecRateAprv) && txtSzTotalAprvAmt == 0.0) {
        setErrorMessage("txtSzTotalAprvAmt", Messages.MSG_ADO_SPC_RATE_AMT);
        result = false;
      }
      if (ArchitectureConstants.Y.equals(rbSpecServReqAprv) && txtSzAprvAmt == 0.0) {
        setErrorMessage("txtSzAprvAmt", Messages.MSG_ADO_SPC_SVCS_AMT);
        result = false;
      }
      if (ArchitectureConstants.Y.equals(rbSpecServReqAprv) && DateHelper.isNull(txtDtDtAprvDate)) {
        setErrorMessage("txtDtDtAprvDate", Messages.MSG_ADO_SPC_SVCS_AMT);
        result = false;
      }
      if (ArchitectureConstants.Y.equals(rbSpecServReqAprv) && DateHelper.isNull(txtDtDtExpDate)) {
        setErrorMessage("txtDtDtExpDate", Messages.MSG_ADO_SPC_SVCS_AMT);
        result = false;
      }

      if (ArchitectureConstants.Y.equals(rbNonRecReq) && "".equals(rbNonRecReqAprv)) {
        setErrorMessage(Messages.MSG_AA_APP_APROVE);
        result = false;
      }

      // STGAP00014563: Approval Status button is clicked to approve application Basic Rate request is selected
      // and Yes is selected for Is the Special Need determination request approved, but Post July 1, 2009
      // or Pre July 1, 2009 or Custom Rate has not been selected

      if (ArchitectureConstants.Y.equals(rbBasicRateReq) && ArchitectureConstants.Y.equals(rbSpNdDetReqApprv)
          && "".equals(cdBasicRateType)) {
        setErrorMessage(Messages.MSG_ADO_BASIC_RATE_REQ);
        result = false;
      }

      // STGAP00014563: Approval Status button is clicked to approve application Custom Rate has been selected but
      // no amount has been entered in Custom Amount field
      if (CodesTables.CBRTYPE_CUS.equals(cdBasicRateType) && txtNbrCustomAmt == 0.0) {
        setErrorMessage(Messages.MSG_ADO_CUSTOM_AMT_REQ);
        result = false;
      }

      // STGAP00014563: County Add On can not be greater than 1.75
      if (txtNbrCountyAddonAmt > 1.75) {
        setErrorMessage("txtNbrCountyAddonAmt", Messages.MSG_ADO_COUNTY_ADD_ON);
        result = false;
      }

      // SMS#97845 MR-074-2 AFCARS: incident status only available in PEND and can be in disabled mode
      // however, a value must exists when approver clicks Approval Status button in approval mode
      if (CodesTables.CSTAGES_PAD.equals(GlobalData.getSzCdStage(request)) &&  
                      CodesTables.CEVTSTAT_PEND.equals(eventStatus) &&
                      (!StringHelper.isValid(rbIncNonIncStatus) && !StringHelper.isValid(rbIncNonIncStatus_Disabled))) {
        setErrorMessage(Messages.MSG_ADO_INC_NONINC_STATUS);
        result = false;
      }
      // SMS#109403: validations for approver in approval mode
      if (ArchitectureConstants.Y.equals(cbxNonRecOnly)) {
        // Date Approved required to approve the non-recurring only application
        if (DateHelper.isNull(txtDtSpecialNeedsApprvd)) {
          setErrorMessage("txtDtSpecialNeedsApprvd", Messages.SSM_COMPLETE_REQUIRED);
          result = false;
        }
        // non-recurring only application can only be approved for non-incident children
        if (ArchitectureConstants.Y.equals(rbIncNonIncStatus)) {
          setErrorMessage(Messages.MSG_INCIDENT_NON_REC_ONLY_MISMATCH);
          result = false;
        }
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }

}
