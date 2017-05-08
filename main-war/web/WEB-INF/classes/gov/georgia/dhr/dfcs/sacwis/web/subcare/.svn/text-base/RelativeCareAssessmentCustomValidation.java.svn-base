package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentPersonInfo;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

/**
 * This class provides the custom validation for the Relative Care Assessment conversation
 * 
 * Change History:
 *   Date        User            Description
 *   --------    --------------  --------------------------------------------------
 *   10/21/2008  mxpatel         STGAP00010651: added code to display a message to add comments when assessment approves and
 *                               caregiver refuses financial support.
 *                               Also added code to display message if non relative is chosen, 
 *                               then non-relative placements specific comments are required regarding the 
 *                               degree and nature of the relationship and bond between the child and the non-relative caregiver.
 *   12/09/2008  alwilliams      STGAP00010649: Added custom validation for Date Assessment Complete, Date Assessment Received, 
 *                               Assessment Results and Decision Date fields when the SaveSubmit PB clicked..
 *   04/15/09    cwells          STGAP00010650: Removed custom validation check for non-relative care comments from nested if statement so 
 *                               it will always be evaluated.                           
 *                               
 *                               
 */

@SuppressWarnings("serial")
public class RelativeCareAssessmentCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "RelativeCareAssessmentCustomValidation";

  public static final String VALUE_I = "I";

  public static final String VALUE_D = "D";

  public static final String VALUE_C = "C";
  
  public static final String NON_RELATIVE_CARE = "N";

  protected boolean validateForm() {
    boolean result = true;
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    String txtComments = ContextHelper.getStringSafe(request, "txtSzComments"); //mxpatel added this for defect #10651
    
    // STGAP00010649 - Moved assessment results variable to make visible to entire method
    String assmtResults = ContextHelper.getStringSafe(request, "selSzCdAsmtResults");

    if (super.isButtonPressed("btnResource")) {
      String countySelected = ContextHelper.getStringSafe(request, "selSzCdCounty");
      if (countySelected == null || "".equals(countySelected)) {
        setErrorMessage(Messages.MSG_RCA_RES_COUNT);
        setRetrieveSOInRequest(request, state);

        result = false;
        return result;
      } else {
        result = true;
        return result;
      }
    }

    if (super.isButtonPressed("btnSave") || super.isButtonPressed("btnSaveSubmit")) {
      RelativeCareAssessmentBean saveSI = (RelativeCareAssessmentBean) state
                                                                            .getAttribute(
                                                                                          RelativeCareAssessmentConversation.RETRIEVESO,
                                                                                          request);
      List<RelativeCareAssessmentPersonInfo> personInfoList = saveSI.getPersonInfoList();
      if (personInfoList == null || personInfoList.size() == 0) {
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.MSG_RCA_PERS_REQ);
        result = false;
        return result;
      }
      String assessmentType = ContextHelper.getStringSafe(request, "rbAssessmentType");
      if (assessmentType == null || "".equals(assessmentType)) {
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        result = false;
        return result;
      }
      String txtNonRelatives = ContextHelper.getStringSafe(request, "txtSzNonRelatives");
      String caregiverType = ContextHelper.getStringSafe(request, "rbCaregiverType");
      if (caregiverType == null || "".equals(caregiverType)) {
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
        result = false;
        return result;
      }   
      
      // STGAP00010650 Displaying error message when non relative care is selected with no comments 
      // in the For non-relatives,record degree of relationship and establish the existing relationship and bond: section.
      if(NON_RELATIVE_CARE.equals(caregiverType) && StringHelper.isEmptyOrNull(txtNonRelatives)){
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.MSG_RCA_NON_REL_COMNT);
        result = false;
        return result;
      }
      
      String willingTo = ContextHelper.getStringSafe(request, "cbxBIndWillingToAcceptChild");
      if (willingTo != null && !"".equals(willingTo)) {
        String initChoiceOfSupport = ContextHelper.getStringSafe(request, "selSzCdInitSup");
        if (initChoiceOfSupport == null || "".equals(initChoiceOfSupport) ) {
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_INIT_SUPP);
          result = false;
          return result;
        }
        //mxpatel added this IF statement for defect #10651
        if((CodesTables.CINITSUP_NON.equals(initChoiceOfSupport)) && (txtComments == null || "".equals(txtComments))){
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_SUPP_REFUSED_COMMENTS_REQ);
          result = false;
          return result;
        }
        // removed per STGAP00004223
        /*Date dtPlacement = ContextHelper.getJavaDateSafe(request, "txtDtPlacementAgreementSigned");
        if (dtPlacement == null) {
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_PLACE_AGR);
          result = false;
          return result;
        }*/
      }
      // STGAP00004227 - Note that Date Initiated, Date Scheduled Assessment and Referred to RD were not included in defect
      // so commented out for now
      //Date txtDtDtInitiatedReferred = ContextHelper.getJavaDateSafe(request, "txtDtDtInitiatedReferred");
      //Date txtDtDtScheduledAssessment = ContextHelper.getJavaDateSafe(request, "txtDtDtScheduledAssessment");
      Date txtDtDtActualHomeVisit = ContextHelper.getJavaDateSafe(request, "txtDtDtActualHomeVisit");
      Date txtDtDtAssessmentComplete = ContextHelper.getJavaDateSafe(request, "txtDtDtAssessmentComplete");
      Date txtDtDtAssessmentReceived = ContextHelper.getJavaDateSafe(request, "txtDtDtAssessmentReceived");
      Date txtDtDtDecision = ContextHelper.getJavaDateSafe(request, "txtDtDtDecision");
      Date txtDtDtDiscussion = ContextHelper.getJavaDateSafe(request, "txtDtDtDiscussion");
      //Date txtDtDtReferredToRD = ContextHelper.getJavaDateSafe(request, "txtDtDtReferredToRD");
      Date txtDtPlacementAgreementSigned = ContextHelper.getJavaDateSafe(request, "txtDtPlacementAgreementSigned");
      
      /*if (!DateHelper.isNull(txtDtDtInitiatedReferred) && DateHelper.isAfterToday(txtDtDtInitiatedReferred)) {
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      if (!DateHelper.isNull(txtDtDtScheduledAssessment) && DateHelper.isAfterToday(txtDtDtScheduledAssessment)) {
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }*/
      if (!DateHelper.isNull(txtDtDtActualHomeVisit) && DateHelper.isAfterToday(txtDtDtActualHomeVisit)) {
        setErrorMessage("txtDtDtActualHomeVisit", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      if (!DateHelper.isNull(txtDtDtAssessmentComplete) && DateHelper.isAfterToday(txtDtDtAssessmentComplete)) {
        setErrorMessage("txtDtDtAssessmentComplete", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      if (!DateHelper.isNull(txtDtDtAssessmentReceived) && DateHelper.isAfterToday(txtDtDtAssessmentReceived)) {
        setErrorMessage("txtDtDtAssessmentReceived", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      if (!DateHelper.isNull(txtDtDtDecision) && DateHelper.isAfterToday(txtDtDtDecision)) {
        setErrorMessage("txtDtDtDecision", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      if (!DateHelper.isNull(txtDtDtDiscussion) && DateHelper.isAfterToday(txtDtDtDiscussion)) {
        setErrorMessage("txtDtDtDiscussion", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      /*if (!DateHelper.isNull(txtDtDtReferredToRD) && DateHelper.isAfterToday(txtDtDtReferredToRD)) {
        setRetrieveSOInRequest(request, state);
        setErrorMessage(Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }*/
      if (!DateHelper.isNull(txtDtPlacementAgreementSigned) && DateHelper.isAfterToday(txtDtPlacementAgreementSigned)) {
        setErrorMessage("txtDtPlacementAgreementSigned", Messages.SSM_DATE_BEFORE_SAME_CURR);
        result = false;
      }
      if (!result) { 
        setRetrieveSOInRequest(request, state);
      }
      //  end STGAP00004227 

      if (super.isButtonPressed("btnSaveSubmit")) {
        
        // STGAP00010649 - Verify date assessment complete is selected
        if (txtDtDtAssessmentComplete == null) {
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_DATE_ASSESSMENT_COMP_REQ);
          result = false;
        }
        
        // STGAP00010649 - Verify date assessment received is selected
        if (txtDtDtAssessmentReceived == null) {
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_DATE_ASSESSMENT_RECVD_REQ);
          result = false;
        }
        
        // STGAP00010649 - Verify assessment results is selected
        if ((assmtResults == null) || ("".equals(assmtResults)) )  {
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_ASSESSMENT_RESULTS_REQ);
          result = false;
        }
        
        // STGAP00010649 - Verify assessment decision date is selected
        if (txtDtDtDecision == null) {
          setRetrieveSOInRequest(request, state);
          setErrorMessage(Messages.MSG_RCA_DECISION_DATE_REQ);
          result = false;
        }
        
        String initChoiceOfSupport = ContextHelper.getStringSafe(request, "selSzCdInitSup");
        if (CodesTables.CINITSUP_RFS.equals(initChoiceOfSupport)) {
          Date rdDate = ContextHelper.getJavaDateSafe(request, "txtDtDtReferredToRD");
          if (rdDate == null) {
            setRetrieveSOInRequest(request, state);
            setErrorMessage(Messages.MSG_RCA_REL_FOST_REF);
            result = false;
            return result;
          }
        }
        String supportOptions = ContextHelper.getStringSafe(request, "cbxBIndSupportOptions");
        if (supportOptions != null && !"".equals(supportOptions)) {
          Date ddDate = ContextHelper.getJavaDateSafe(request, "txtDtDtDiscussion");
          if (ddDate == null) {
            setRetrieveSOInRequest(request, state);
            setErrorMessage(Messages.MSG_RCA_REL_SUP_DATE);
            result = false;
            return result;
          }
        }
       
        //   String txtComments = ContextHelper.getStringSafe(request, "txtSzComments"); //mxpatel commented this out for defect #10651
        if (assmtResults != null && (CodesTables.CASMTRES_APP.equals(assmtResults)|| CodesTables.CASMTRES_AWC.equals(assmtResults) )) {
        //mxpatel added || CodesTables.CASMTRES_AWC.equals(assmtResults) for defect #10651
          //mxpater wrote this IF statement for defect #10651
          if ((supportOptions == null || "".equals(supportOptions)) && (txtComments == null || "".equals(txtComments))) {
            setRetrieveSOInRequest(request, state);
            setErrorMessage(Messages.MSG_RCA_APRV_SUP_NOT_DISC);
            result = false;
            return result;
          }
          if ((willingTo == null || "".equals(willingTo)) && (txtComments == null || "".equals(txtComments))) {
            setRetrieveSOInRequest(request, state);
            setErrorMessage(Messages.MSG_RCA_APRV_COMMENTS_REQ);
            result = false;
            return result;
          }
        }
      }
    }

    // Selection of State is required for ICPC Relative Care Assessment
    String rbFieldName = "rbPersonPerformingAssessment";
    String personPA = ContextHelper.getStringSafe(request, rbFieldName);
    if (VALUE_I.equals(personPA)) {
      String stateSelected = ContextHelper.getStringSafe(request, "selSzCdState");
      if (stateSelected == null || "".equals(stateSelected)) {
        setErrorMessage(Messages.MSG_RCA_ICPC_STATE);
        result = false;
      }
    }

    // Selection of County is required for DFCS Agency Staff Relative Care Assessment
    if (VALUE_D.equals(personPA)) {
      String countySelected = ContextHelper.getStringSafe(request, "selSzCdCounty");
      if (countySelected == null || "".equals(countySelected)) {
        setErrorMessage(Messages.MSG_RCA_DFCS_COUNT);
        result = false;
      }
    }

    // Selection of County and Resource is required for CCFA Provider Relative Care Assessment
    if (VALUE_C.equals(personPA)) {
      String countySelected = ContextHelper.getStringSafe(request, "selSzCdCounty");
      String resourceSelected = ContextHelper.getStringSafe(request, "dspNmResource");
      if (countySelected == null || resourceSelected == null || "".equals(resourceSelected)
          || "".equals(countySelected)) {
        setErrorMessage(Messages.MSG_RCA_CCFA_SEL);
        result = false;
      }
    }
    performanceTrace.exitScope();
    return result;
  }

  private void setRetrieveSOInRequest(HttpServletRequest request, BaseSessionStateManager state) {
    // STGAP00004390 - get so from request so we can preserve event data in rowccmn45do and person data
    // then update so with changes if any on the page in call to getRetrieveSOFromRequest()
    //RelativeCareAssessmentBean so = new RelativeCareAssessmentBean();
    RelativeCareAssessmentBean so = (RelativeCareAssessmentBean) state.getAttribute(RelativeCareAssessmentConversation.RETRIEVESO, request);
    // end STGAP00004390
    RelativeCareAssessmentConversation.getRetrieveSOFromRequest(so, request);
    List<RelativeCareAssessmentPersonInfo> personInfoList = new ArrayList<RelativeCareAssessmentPersonInfo>();
    so.setPersonInfoList(personInfoList);
    int index = ContextHelper.getIntSafe(request, "loopCounter");
    for (int i = 0; i < index; i++) {
      RelativeCareAssessmentPersonInfo personInfo = new RelativeCareAssessmentPersonInfo();
      int rbSelected = ContextHelper.getIntSafe(request, RelativeCareAssessmentConversation.PERSON_INFO_RB + i);
      personInfo.setIsSelected(rbSelected);
      Date dtLastUpdate = ContextHelper.getJavaDateSafe(request, "dtLastUpdate" + i);
      personInfo.setDtLastUpdate(dtLastUpdate);
      personInfo.setUlIdRcaPerson(ContextHelper.getIntSafe(request, "ulIdRcaPerson" + i));
      personInfo.setUlIdPerson(ContextHelper.getIntSafe(request, "ulIdPerson" + i));
      personInfo.setUlIdRcaEvent(ContextHelper.getIntSafe(request, "ulIdRcaEvent"));
      personInfo.setNmPersonName(ContextHelper.getStringSafe(request, "nmPerson" + i));
      personInfoList.add(personInfo);
    }
    state.setAttribute(RelativeCareAssessmentConversation.RETRIEVESO, so, request);
  }

}
