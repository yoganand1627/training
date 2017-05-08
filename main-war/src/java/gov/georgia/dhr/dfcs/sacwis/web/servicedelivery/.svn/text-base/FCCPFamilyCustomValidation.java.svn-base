package gov.georgia.dhr.dfcs.sacwis.web.servicedelivery;

/**

* <pre>
*                        Change History:
*                        Date      User              Description
*                        --------  ----------------  --------------------------------------------------
* </pre>                 6/16/2008 mchillman         STGAP00006921: FCCP Family Detail: Current Review Date: needs to allow future date.
*                                                    Removed validation
*                        01/25/10  bgehlot           44337 MR-057 Concurrent Permanency Plan Type validation needs to allow court ordered selections                             
* 
*/

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

public class FCCPFamilyCustomValidation extends FormValidation {
  
  
  // static constants
  public static final String TRACE_TAG = "FCCPFamilyCustomValidation";
  


  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    boolean isValid = true;
    String errorMessage;
    String[] checkedPrincipals = CheckboxHelper.getCheckedValues(request, "cbxPrincipalsOnPlan");

    // Foster care case plan mode
    Date dtOrgSub = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnDtOrgSub"));
    Date dtCurReview = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "dtCurReview"));
    Date dtNextReview = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "hdnDtNextReview"));
    Date dtProjPerm = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "dtProjPerm"));
    Date dtHearReqSub = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "dtHearReq"));
    String nmAssgnJudge = ContextHelper.getStringSafe(request, "txtAssnJudge");
    String cdPermPlanType = ContextHelper.getStringSafe(request, "selCrtPlanType");
    if (!StringHelper.isValid(cdPermPlanType)) {
      cdPermPlanType = request.getParameter("hdnCasePlanMode");
    }
    String cdPermPlan = ContextHelper.getStringSafe(request, "selPPP");
    String txtPermPlanRsn = ContextHelper.getStringSafe(request, "txtPPPRsns");
    String cdConcurPermPlan = ContextHelper.getStringSafe(request, "selSPP");
    String txtConcurPermPlanRsn = ContextHelper.getStringSafe(request, "txtSPPRsns");
    String txtRsnsChildNotHome = ContextHelper.getStringSafe(request, "txtRsnsChildNotHome");
    String txtHarmChildLeftHome = ContextHelper.getStringSafe(request, "txtHarmChildLeftHome");
    String rbParPart = ContextHelper.getStringSafe(request, "rbParentPart");
    String rbChildPart = ContextHelper.getStringSafe(request, "rbChildPart");
    String txtNoParentPart = ContextHelper.getStringSafe(request, "txtNoParentPart");
    String txtNoChildPart = ContextHelper.getStringSafe(request, "txtNoChildPart");
    String rbHearReqSub = ContextHelper.getStringSafe(request, "rbHearReqSub");
    
    // Aftercare case plan mode
    Date dtBeginAft = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "dtBeginAft"));
    Date dtEndAft = DateHelper.toJavaDateSafe(ContextHelper.getStringSafe(request, "dtEndAft"));
    String txtRsnDischg = ContextHelper.getStringSafe(request, "txtRsnDischg");
    
    // disable validation when page is on Initial load (page loads with Permanency Type and Save button only)
    if (PageModeConstants.NEW.equals(PageMode.getPageMode(request)) && StringHelper.isValid(cdPermPlanType)) {
      return isValid;
    }

    // *******************************
    // *** SAVE OR SAVE AND SUBMIT ***
    // *******************************
    if (super.isButtonPressed("SaveFCCPFamilyDetail") || super.isButtonPressed("SaveSubmitFCCPFamilyDetail")) {

       
      if (!CodesTables.CCTPLNTY_AFC.equals(cdPermPlanType)) {
        // At least one principal must be selected.
        if (checkedPrincipals.length == 0) {
          isValid = false;
          setErrorMessage(Messages.MSG_SVC_NEED_PRINCIPALS);
        }

        // The 'Date Origianl Plan submitted' date cannot be after today.
        if (!DateHelper.isNull(dtOrgSub)) {
          if (DateHelper.isAfterToday(dtOrgSub)) {
            isValid = false;
            setErrorMessage("dtOrgSub", Messages.MSG_FP_DATE_BEFORE_SAME_CURR);
          }
        }
        if (!StringHelper.isValid(cdPermPlan)) {
          isValid = false;
          errorMessage = "Permanency Plan - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
          setErrorMessage(errorMessage);
        } else { // only need for option other than 2, 3, or 6
          if (!StringHelper.isValid(txtPermPlanRsn)
              && !(CodesTables.CPERMPLN_RUI.equals(cdPermPlan) || CodesTables.CPERMPLN_LLR.equals(cdPermPlan) || CodesTables.CPERMPLN_ADA.equals(cdPermPlan) || CodesTables.CPERMPLN_GDS
                                                                                                                                        .equals(cdPermPlan))) {
            isValid = false;
            setErrorMessage("txtPPPRsns", Messages.SSM_COMPLETE_REQUIRED);
          }
        }

      } else { // AFC validation
        if (afcDuration(dtBeginAft, dtEndAft) > 12) {
          isValid = false;
          setErrorMessage(Messages.MSG_AFTERCARE_DUR);
        }
        /*if ( afcDuration(dtBeginAft, dtEndAft) == 0 && !DateHelper.isNull(dtBeginAft) && !DateHelper.isNull(dtEndAft) ) {
          isValid = false;
          errorMessage = "Begin and end dates are the same";
          setErrorMessage(errorMessage);
        }*/
        if (DateHelper.isAfter(dtBeginAft, dtEndAft) || (!DateHelper.isNull(dtBeginAft) && !DateHelper.isNull(dtEndAft) && dtBeginAft.equals(dtEndAft))) {
          isValid = false;
          setErrorMessage(Messages.SSM_CON_BEG_BEFORE_END);
        }

      }
    }
    if (super.isButtonPressed("SaveSubmitFCCPFamilyDetail")) { 
      if (!CodesTables.CCTPLNTY_AFC.equals(cdPermPlanType)) {
        /**
         * Date validation
         */ 
        if (DateHelper.isNull(dtOrgSub)) {
          isValid = false;
          setErrorMessage("dtOrgSub", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if (DateHelper.isNull(dtCurReview)) {
          isValid = false;
          setErrorMessage("dtCurReview", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if (DateHelper.isNull(dtNextReview)) {
          isValid = false;
          setErrorMessage("dtNextReview", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if ( DateHelper.isNull(dtProjPerm) ) {
          isValid = false;
          setErrorMessage("dtProjPerm", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        /**
         * Dropdown validation
         */ 
        if (CodesTables.CCTPLNTY_CON.equals(cdPermPlanType)) {
          if (!StringHelper.isValid(cdConcurPermPlan)) {
            isValid = false;
            errorMessage = "Concurrent Permanency Plan - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
            setErrorMessage(errorMessage);
          }
        }
        // Plan type is not Concurrent but there are concurrent plan data entered
        if (!CodesTables.CCTPLNTY_CON.equals(cdPermPlanType) && (StringHelper.isValid(cdConcurPermPlan) || StringHelper.isValid(txtConcurPermPlanRsn))) {
          isValid = false;
          setErrorMessage(Messages.MSG_SEC_PERM_CON_REQ);
        }
        if (StringHelper.isValid(cdConcurPermPlan)) { // only need for option other than 2, 3, or 6
          if (!StringHelper.isValid(txtConcurPermPlanRsn)
              && !(CodesTables.CPERMPLN_LLR.equals(cdConcurPermPlan)
                  || CodesTables.CPERMPLN_ADA.equals(cdConcurPermPlan) || CodesTables.CPERMPLN_GDS
                                                                                                  .equals(cdConcurPermPlan))) {
            isValid = false;
            setErrorMessage("txtSPPRsns", Messages.SSM_COMPLETE_REQUIRED);
          }
        }
        
        /**
         * Other fields validation
         */
        if (!StringHelper.isValid(nmAssgnJudge)) {
          isValid = false;
          setErrorMessage("txtAssnJudge", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if (!StringHelper.isValid(txtRsnsChildNotHome)) {
          isValid = false;
          setErrorMessage("txtRsnsChildNotHome", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if (!StringHelper.isValid(txtHarmChildLeftHome)) {
          isValid = false;
          setErrorMessage("txtHarmChildLeftHome", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if (!StringHelper.isValid(rbParPart)) { 
          isValid = false;
          setErrorMessage("Parent participated - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT));
        }
        else {
          if ( ArchitectureConstants.N.equals(rbParPart) && !StringHelper.isValid(txtNoParentPart) ) {
            isValid = false;
            setErrorMessage("txtNoParentPart", Messages.MSG_NO_PAR_PART_EXPL);
          }
        }
        if (!StringHelper.isValid(rbChildPart)) { 
          isValid = false;
          setErrorMessage("Child participated - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT));
        }
        else {
          if ( ArchitectureConstants.N.equals(rbChildPart) && !StringHelper.isValid(txtNoChildPart) ) {
            isValid = false;
            setErrorMessage("txtNoChildPart", Messages.MSG_NO_CHILD_PART_EXPL);
          }
        }
        if (!StringHelper.isValid(rbHearReqSub)) { 
          isValid = false;
          setErrorMessage("Hearing request submitted - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT));
        }
        else {
          if ( ArchitectureConstants.Y.equals(rbHearReqSub) && DateHelper.isNull(dtHearReqSub) ) {
            isValid = false;
            setErrorMessage(Messages.MSG_HEAR_DATE_REQ);
          }
        }
        
        //44337 MR-057 APPLA changes
        // The same value can not be chosen for both the Permanency Plan and the Concurrent Permanency Plan fields.
        if(StringHelper.isValid(cdPermPlan) && StringHelper.isValid(cdConcurPermPlan) && cdPermPlan.equals(cdConcurPermPlan)){
          isValid = false;
          setErrorMessage(Messages.MSG_FCCP_PPP_SPP_DIFFERENT);
        }
        
      } else { // AFC validation 
        if (!StringHelper.isValid(txtRsnDischg)) { 
          isValid = false;
          setErrorMessage("txtRsnDischg", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if ( DateHelper.isNull(dtBeginAft) ) {
          isValid = false;
          setErrorMessage("dtBeginAft", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
        if ( DateHelper.isNull(dtEndAft) ) {
          isValid = false;
          setErrorMessage("dtEndAft", Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        }
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return isValid;
  }
  private int afcDuration(Date dtFrom, Date dtTo) {
    return DateUtility.getAgeInMonths(dtFrom, dtTo);
  }
}
