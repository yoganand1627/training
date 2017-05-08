package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.service.common.Common;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.util.StringHelper;

/**
 * ParentContactStandards.jsp Custom validation class
 * 
 * @author Herve Jean-Baptiste May 16, 2011
 * @version 1.0
 * 
 * <pre>
 * Change History:
 * Date           User                Description
 * ----------     ---------------     ------------------------------------------------------
 * 06/22/2011     hjbaptiste          SMS#112945: Set message requiring user to provide a synopsis when having to
 *                                    review records checks is not applicable (N/A)  
 * 06/23/2011     hjbaptiste          SMS#113092: Fixed validation for Concurrence section                                   
 * </pre>
 */
@SuppressWarnings("serial")

public class SpecialInvestigationCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "SpecialInvestigationCustomValidation";

  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "validationForm");
    performanceTrace.enterScope();

    HttpServletRequest request = getRequest();
    BaseSessionStateManager state = getState();
    boolean result = true;
    
    if (super.isButtonPressed("btnSaveAndSubmit") || (GlobalData.isApprovalMode(request) && super.isButtonPressed("btnApprovalStatusFinal"))){
      // if there has been no value selected in response to 'The recommended plan for the placement resource/adoptive home is:'
      if (!ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxPlcmntRsrcClosed")) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxChildrenRemoved")) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxActionPlanDvlpd")) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxNoChangeStatus")) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxCpaCpiNotUsed")) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxWaiverAttached")) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxRcmndOther"))) {
        setErrorMessage(Messages.MSG_CR_PLAN_REQ);
        result = false;
      }
      
      // if a value of 'Other' has been selected in response to 'The recommended plan for the placement resource/adoptive home is:'
      // and comments was not entered
      if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxRcmndOther")) &&
                      (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "txtCountyRecOtherComments")))) {
        setErrorMessage(Messages.MSG_CR_PLAN_COMMENTS_REQ);
        result = false;
      }
      
      // if there is no response to the 'Have Records Checks been reviewed?' field
      if (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "rbRecChkReviewed"))) {
        setErrorMessage(Messages.MSG_CR_RC_REVIEW_REQ);
        result = false;
      }
      // if the response to the 'Have Records Checks been reviewed?' field is 'Yes' or 'No', but no value 
      // has been entered in the 'Synopsis of records reviewed and how it impacts allegations' field
      else if (!(ArchitectureConstants.X.equals(ContextHelper.getStringSafe(request, "rbRecChkReviewed")))){
        if (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "txtSynopsisRecReviewed"))) {
          setErrorMessage(Messages.MSG_CR_RC_REVIEW_SYNOP_REQ);
          result = false;
        }
      }
      
      // if no comments have been entered in the 'Results of the 48 Hour Case Staffing' field
      if (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "txtResultsCaseStaffing"))) {
        setErrorMessage(Messages.MSG_CR_CASE_STAFF_RESULTS_REQ);
        result = false;
      }
      
      // if no comments have been entered in the 'Names and Agencies Represented at the Case Staffing' field 
      if (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "txtNamesAgenciesRepCaseStaffing"))) {
        setErrorMessage(Messages.MSG_CR_CASE_STAFF_NAMES_AGENC_REQ);
        result = false;
      }
      
      // if value of 'A policy waiver or other request on behalf of a child in DHR/DFCS custody is 
      // attached to this memorandum' has been selected in the County Recommendation section, and 
      // the 'Justification for the DFCS home to remain open' field is empty
      if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxWaiverAttached")) &&
                      (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "txtJustHmeRemainOpen")))) {
        setErrorMessage(Messages.MSG_HR_OPN_HM_JUSTIF_REQ);
        result = false;
      }
      
      // if value of 'A policy waiver or other request on behalf of a child in DHR/DFCS custody is 
      // attached to this memorandum' has been selected in the County Recommendation section, and 
      // the 'Justification for the DFCS home to remain open' field is empty
      if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxWaiverAttached")) &&
                      (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "txtStepsToAssureSafetyOfChildren")))) {
        setErrorMessage(Messages.MSG_HR_OPN_HM_SAFET_STEPS_REQ);
        result = false;
      }
      
      String[] checkedValues = CheckboxHelper.getCheckedValues( request, "cbxWaiverChildHist_" );
      
      // if value of 'A policy waiver or other request on behalf of a child in DHR/DFCS custody is 
      // attached to this memorandum' has been selected in the County Recommendation section, but 
      // no children have been selected to indicate whom the home waiver is for
      if (ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxWaiverAttached"))) {
        
        if (checkedValues == null || checkedValues.length < 1) {
          setErrorMessage(Messages.MSG_HR_OPN_HM_CHILD_REMAIN_REQ);
          result = false;
        }
      }
      
      // if a value has been entered for either the 'justification for the DFCS home to remain open', 
      // 'What steps will be taken to assure the safety of the foster children placed in the home'
      // or a child's name has been checked in the Home Waiver section, but a value of 'A policy waiver 
      // or other request on behalf of a child in DHR/DFCS custody is attached to this memorandum' 
      // has NOT been selected in the County Recommendation section
      if ((StringHelper.isNotEmpty(ContextHelper.getStringSafe(request, "txtJustHmeRemainOpen")) ||
                      StringHelper.isNotEmpty(ContextHelper.getStringSafe(request, "txtStepsToAssureSafetyOfChildren")) ||
                      (checkedValues != null && checkedValues.length > 0)) &&
                      !ArchitectureConstants.Y.equals(CheckboxHelper.getCheckboxValue(request, "cbxWaiverAttached"))) {
        setErrorMessage(Messages.MSG_CR_POL_WVR_REQ);
        result = false;
      }
    }
    
    if (GlobalData.isApprovalMode(request) && super.isButtonPressed("btnApprovalStatusFinal")){
      String whichSpclInvApprover = getEjb(Common.class).determineWhichApprover(GlobalData.getUlIdApproval(request), SpecialInvestigationConversation.SPECIAL_INVESTIGATION);
      if (SpecialInvestigationConversation.POLICY_UNIT.equals(whichSpclInvApprover)) {
        if (StringHelper.isEmpty(ContextHelper.getStringSafe(request, "rbStateOfficeConcurDisp")) || StringHelper.isEmpty(ContextHelper.getStringSafe(request, "rbStateOfficeConcurCountyRecAction"))) {
          setErrorMessage(Messages.MSG_SO_CONCURR_REQ);
          result = false;
        }
      }
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return result;
  }
}
