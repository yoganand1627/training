package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * Merge Split Custom validation class
 * <p>
 * Description: This Class verifies all of the information for the ServiceAuthHeader page
 * </p>
 * <p>
 * Copyright: Copyright (c) 2002
 * </p>
 * <p>
 * Company: Accenture
 * </p>
 * 
 * @author Anna Grimshaw
 * @version 1.0 <p/> Change History: Date User Description -------- -----------
 *          ---------------------------------------------- 10/14/03 CORLEYAN SIR 19857 -- ContextHelper.get... replaces
 *          getInputValue(), removed InputValidation.UNSPECIFIED_INPUT_FIELD removed message lookup. 04/20/05 CORLEYAN
 *          SIR 23538 - Add custom validation for new Service Auth Type Donated Community Service
 *    Change History:
 *    Date       User      Description
 *    --------   --------- ---------------------------------------------------          
 *    01/07/2010  arege    STGAP00015696 MR- 52 User attempts to save a Service Authorization for a Non Recurring Service (510s) in any stage other than the PAD stage. 
 *
 **/
 
//Defect 6430
@SuppressWarnings("serial")
public class ServiceAuthHeaderCustomValidation extends FormValidation {
  //CR14: Modifications to Contract Service Detail STGAP00006432
  public static final String TRACE_TAG = "ServiceAuthHeaderCustomValidation";
  private static final List<String> UAS_PROGRAMS_REQUIRING_PUP_INFO = Arrays.asList(CodesTables.CPRGCOD1_551, CodesTables.CPRGCOD1_521, CodesTables.CPRGCOD1_571, CodesTables.CPRGCOD1_573);
  private static final List<String> UAS_PROGRAMS_REQUIRING_EI_INFO = Arrays.asList(CodesTables.CPRGCOD1_551);
  
  protected boolean validateForm() {
    boolean result = true;
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = this.getRequest();

    // Initialize State so that Page Mode can be determined

    String indWaiver = CheckboxHelper.getCheckboxValue(request, "cbxIndWaiverReqd");
    int idWaiver = ContextHelper.getIntSafe(request, "dspUlIdWaiver");
    int idResource = ContextHelper.getIntSafe(request, "dspUlIdResource");
    org.exolab.castor.types.Date dtDtSituationOpened = ContextHelper.getCastorDateSafe(request,
                                                                                       "hdnDtDtSituationOpened");
    org.exolab.castor.types.Date dtDtSvcAuthEff = ContextHelper.getCastorDateSafe(request, "txtDtDtSvcAuthEff");
    org.exolab.castor.types.Date dtDtStageClose = ContextHelper.getCastorDateSafe(request, "hdnDtDtStageClose");
    String eiCaseType = ContextHelper.getStringSafe(request, "selSzCdSvcAuthEICaseType");
    String pupType = ContextHelper.getStringSafe(request, "rbCIndPupOutCmTyp");
    String primaryClient = ContextHelper.getStringSafe(request, "selUlIdPrimaryClient");
    String uasCode = ContextHelper.getStringSafe(request, "selSzCdSvcAuthCategory");
    String service = ContextHelper.getStringSafe(request,"selSzCdSvcAuthService");
    double minutesDifference = 0.0;
    double dayDifference = 0.0;
    java.util.Date date = new java.util.Date();    
    String cdStage = GlobalData.getSzCdStage(request);

    minutesDifference = DateHelper.minutesDifference(dtDtSvcAuthEff, DateHelper.toCastorDate(date));
    dayDifference = minutesDifference / 1440;
    if (super.isButtonPressed("btnSaveSubmit") || super.isButtonPressed("btnApprovalStatusFinal")) {
      if (UAS_PROGRAMS_REQUIRING_PUP_INFO.contains(uasCode)) {
        if ("".equals(eiCaseType) && UAS_PROGRAMS_REQUIRING_EI_INFO.contains(uasCode) ) {
          setErrorMessage("selSzCdSvcAuthEICaseType", Messages.MSG_SVC_AUTH_ERYIN_CASE_TYP_REQD);
          result = false;
        }
        if ("".equals(pupType)) {
          setErrorMessage(Messages.MSG_SVC_AUTH_PUP_OUTCM_TYP_REQD);
          result = false;
        }
      }
    }
    
   //STGAP00015696 MR- 52 User attempts to save a Service Authorization for a Non Recurring Service (510s) in any stage other than the PAD stage. 
    if(super.isButtonPressed("btnSave") && !CodesTables.CSTAGES_PAD.equals(cdStage) && CodesTables.CPRGCOD1_510.equals(uasCode)){
      setErrorMessage("selSzCdSvcAuthCategory", Messages.MSG_SVC_ADO_FINALIZED);
      result = false;
    }

    if ("".equals(primaryClient) || primaryClient == null) {
      setErrorMessage("selUlIdPrimaryClient", "Field is required. Please enter a value.");
      result = false;
    }
    // STGAP00008072 Displaying error message when only 2 digits are entered for the year
    if (DateHelper.isValidDate(dtDtSvcAuthEff.toString())) {
      setErrorMessage("txtDtDtSvcAuthEff", Messages.MSG_ARC_CONSTR_DATE);
      result = false;
    }
    
    // Verify that Effective date is not before the Situation Opened Date
    if (DateHelper.isBefore(dtDtSvcAuthEff, dtDtSituationOpened)) {
      setErrorMessage("txtDtDtSvcAuthEff", Messages.SSM_DATE_BEFORE_SITUATION);
      result = false;
    }
    // Verify that Effective date is not 30 greater than today's date
    if (dayDifference > 30) {
      setErrorMessage("txtDtDtSvcAuthEff", Messages.SSM_DATE_BEYOND_THIRTY_DAYS);
      result = false;
    }
    // Verify that Effective Date is not after Situation Closed Date
    if (DateHelper.isAfter(dtDtSvcAuthEff, dtDtStageClose)) {
      setErrorMessage("txtDtDtSvcAuthEff", Messages.SSM_SVC_AUTH_AFTER_STG_CLS);
      result = false;
    }

    if (("Y".equals(indWaiver) && idWaiver == 0) || (!"Y".equals(indWaiver) && idWaiver != 0)) {
      setErrorMessage("dspUlIdWaiver", Messages.MSG_WAIVER_REQUIRED);
      result = false;
    }

    // If the page mode is new, a resource search must be conducted -VAN testing
    if (PageMode.getPageMode(request).equals(PageModeConstants.NEW) && idResource == 0) {
      setErrorMessage(Messages.MSG_SVC_SEL_RSRC);
      result = false;
    }

    performanceTrace.msg(TRACE_TAG + ".validateForm", 7, "exiting the method!! ");
    performanceTrace.exitScope();
    return result;
  }
  
}
