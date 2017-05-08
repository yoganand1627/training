//Declare the class package
package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is used to perform the custom validation on CPS Investigation Conclusiom when the user chooses to Save and
 * Save and Submit.
 * 
 * @author Narasimha Rao L 11/05/2002 ** Change History: Date User Description -------- -----------
 *         ---------------------------------------------- 10/15/03 dickmaec SIR 19857 -- ContextHelper.get... replaces
 *         getInputValue(); <p/> 10/15/03 dickmaec As part of SIR 19857, all messages where shorted from
 *         MessageLookup.getMessageByNumber( Messages.SSM_FAD_MIN_LESS_MAX) to Messages.SSM_FAD_MIN_LESS_MAX. <p/>
 *         04/15/04 dickmaec SIR 22729 and SIR 22726 - Added the MSG_RISK_FINDING_SUB, if the user clicks the save and
 *         submit push button, the message will be thrown under the following conditions: 1. there is event removing the
 *         child from the home, 2. and if risk finding is equal to risk indicated and recommend action is not a -close
 *         field 3. or the Risk Assessment is not equal Risk Assessment. NO_LEGAL, FAMILY_MOVED and WORKLOAD_CONSTAINTS
 *         are close fields on the jsp. The recommend action checkbox will be hidden when the incidator is N and in
 *         browse mode displayed if the incidator is Y. 06/18/04 dejuanr SIR 22936 - Added code to validate
 *         selBIndCpsInvstCpsLeJointContact, selSzCdCpsInvstCpsLeJointContact, and txtSzTxtCpsInvstCpsLeJointContact. If
 *         selBIndCpsInvstCpsLeJointContact is N or no joint investigation was done, then provide a reason. If the
 *         reason is Other, add comments. 01/13/04 dejuanr SIR 22986 - Add victim taped fields 06/02/05 RANAS SIR 23536 -
 *         Check PHAB/SXAB allegation to determine if victim taped fields should be validated
 *         
 */
/**
 * <pre>
 *  Change History:
 *  Date      User          Description
 *  --------  --------      --------------------------------------------------
 *  09/12/08  VVO           STGAP00009662 - Maltreamement Finding required on Save Submit   
 *  
 *  04/11/09  bgehlot       STGAP00012542: Added condition to display the message when Level of Risk drop down is enabled and
 *                          User or Supervisor has not entered any value for Level of Risk and clicked save and submit 
 *  05/24/10  bgehlot       SMS#51977 MR-066 Changes
 *  06/14/10  bgehlot       SMS#51977 New Requirement: Special Need Investigation Question made required.
 *  06/24/10  bgehlot       SMS#59296: MSG_FACILITY_SEARCH displays only when user does not enter the Provider Name
 *  06/30/10  bgehlot       SMS 60427 do not show Required fiels messages when Search button is clicked.
 *  07/06/10  hjbaptiste    SMS#61205: Checking rbInvMaltreatInCare ('Is this Maltreatment in Care?' instead of 'Is this a Special
 *                          Investigation?') to display message MSG_INV_PLACEMENT_REQ
 *  06/22/11  charden       Capta 4.3 - adding new validations for Capta 4.3 release
 *  07/08/11  charden       SMS#114352 - checking for resource id and name so that page can be submitted for approval even though
 *                          resource has no id
 *  01/26/12  habraham      STGAP00017829 - MR-097 - Modified the code to change the conditions(to add UnsubstantiatedMICindicator)
 *                          for MSG_PLCMNT_PROV_REQ and MSG_INV_SPCL_NOTIFICATION messages. Also added a new message MSG_INV_NOTIFICATION_COMMENT_REQ
 *  03/09/12  vcollooru     STGAP00017941: Modified to perform the following actions -
 *                               i) Added required field validation on the new comment field on click of Save & Submit or Approve Status.
 *                              ii) Removed the validation on the existing comment field which is done on click of Approval Status button.  
 *                          
 *                          
 *
 *                      
 * </pre>
 */

public class CPSInvCnclsnValidation extends FormValidation {
  // static constants
  public static final String TRACE_TAG = "CPSInvCnclsnValidation";

  public static final String CODE_NON_FAMILY_INVST = "86";

  public static final String CODE_ONLY_CHILD_DIED = "88";

  public static final String RA_NA = "04";

  // SIR 22726 and 22729 new static constants
  public static final String NO_LEGAL = "80";

  public static final String FAMILY_MOVED = "82";

  public static final String WORKLOAD_CONSTAINTS = "84";

  protected boolean validateForm() {
    // Instantiate a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace("CPSInvestigationValidation", "validateForm");
    performanceTrace.enterScope();
    GrndsTrace.enterScope(TRACE_TAG + ".validateForm");
    boolean isValid = true;
    HttpServletRequest request = super.getRequest();
    
    String selSzCdOverrideOverllFind = ContextHelper.getStringSafe(request, "selSzCdOverrideOverllFind");
    String selSzCdOverrideRiskLvl = ContextHelper.getStringSafe(request, "selSzCdOverrideRiskLvl");

    
    // SIR 22986 End
    // Call the saveSubmitCustomValidation if the user clicked Save and Submit
    // HD 6/11/2003 -- Call this method also if user clicked the Approval Status button
    if (super.isButtonPressed("btnSaveAndSubmit") || this.isButtonPressed("btnApprovalStatus")) {
      boolean isValid2 = saveSubmitValidation();
      isValid = isValid && isValid2;
    }
    
    //STGAP00012542: Added this condition to display the message when Level of Risk drop down is enabled and
    // Supervisor who can override the decision  has not entered any value for Level of Risk and clicked save and submit 
    if (!StringHelper.isEmptyOrNull(selSzCdOverrideOverllFind))
    {
      if((CodesTables.CCRSKFND_05.equals(selSzCdOverrideOverllFind) ||  CodesTables.CCRSKFND_01.equals(selSzCdOverrideOverllFind)) &&
                      StringHelper.isEmptyOrNull(selSzCdOverrideRiskLvl)){ 
        setErrorMessage(Messages.MSG_INV_LEVEL_RISK_REQ);
        isValid = false;
      }
    }
    
    //SMS#51977 SMS 59296 
    // Condition: The user is attempting to perform a Facility Search without
    // first entering a facility name or selecting a facility type
    // to search on.
    boolean bFacilitySearch = super.isButtonPressed("btnFacilitySearch");
    if ((bFacilitySearch)
        && ("".equals(ContextHelper.getStringSafe(request, "txtResourceId"))) &&("".equals(ContextHelper.getStringSafe(request, "txtNmResourceSearch")))) {
      setErrorMessage(Messages.MSG_FACILITY_SEARCH);
      isValid = false;
    }
    
    if (super.isButtonPressed("btnSaveAndSubmit") || this.isButtonPressed("btnApprovalStatus") || this.isButtonPressed("btnSave")) {
      //MR-066
      String rbSpeInv = ContextHelper.getStringSafe(request, "rbSpeInv");
      if((StringHelper.EMPTY_STRING).equals(rbSpeInv)){
        String errorMessage = "Is this a Special Investigation? - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
        setErrorMessage(errorMessage);
        isValid = false;
      }
      
      String txtDtCpsInvstDtlComplt = ContextHelper.getStringSafe(request, "dtDtCpsInvstDtlComplt");
      if((StringHelper.EMPTY_STRING).equals(txtDtCpsInvstDtlComplt)){
        String errorMessage = "Date Completed - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED);
        setErrorMessage(errorMessage);
        isValid = false;
      }
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return isValid;
  }

  /**
   * This method contains custom validation that is checked when the user tries to Save and Submit the CPS Investigation
   * Conclusion page.
   * 
   * @return result - Returns false if the data fails validation. Returns true if the data passes validation.
   */
  private boolean saveSubmitValidation() {

    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveSubmitValidation()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();

    boolean isValid = true;
    // boolean bSaveAndSubmit = this.isButtonPressed("btnSaveAndSubmit");

    String IntAssigned = ContextHelper.getStringSafe(request, "IntAssigned");

    // String txtDtCpsInvstDtlComplt = ContextHelper.getStringSafe(request, "dtDtCpsInvstDtlComplt");

    
    org.exolab.castor.types.Date InvstBegun = ContextHelper.getCastorDateSafe(request, "InvInitiated");
    String maltreatmentFinding = ContextHelper.getStringSafe(request, "txtCdCpsOverallDisptn");
    String overallRiskLvl = ContextHelper.getStringSafe(request, "selSzCdStageLvlOfRisk");
    String riskAssessmentFinding = ContextHelper.getStringSafe(request, "selSzCdStageRiskFinding");
    
    String strFostPrnt = ContextHelper.getStringSafe(request, "rbFostPrnt");
    String strStOffNotified = ContextHelper.getStringSafe(request, "rbStOffNotified");
    //SMS# 51977 MR-066 
    
    String idResource = ContextHelper.getStringSafe(request, "idResource");
    //String hdnCIndTrialHomeVisit = ContextHelper.getStringSafe(request, "hdnCIndTrialHomeVisit");
    
    String strSpeInv = ContextHelper.getStringSafe(request, "rbSpeInv"); // Is this a special investigation?
    String rbInvMaltreatInCare = ContextHelper.getStringSafe(request, "rbInvMaltreatInCare"); // Is this maltreatment in care?
    String hdnIndUnSubMIC = ContextHelper.getStringSafe(request, "hdnIndUnSubMIC");
    String policyViolation = ContextHelper.getStringSafe(request, "rbIndPolicyViolation"); // Is this a policy violation?
    org.exolab.castor.types.Date dtDetermLetterSent = ContextHelper.getCastorDateSafe(request, "dtDetermLetterSent"); // Date Determination Letter Sent
    org.exolab.castor.types.Date InvstDtlComplt = ContextHelper.getCastorDateSafe(request, "dtDtCpsInvstDtlComplt"); // Date completed
    org.exolab.castor.types.Date dtStageInvStart = ContextHelper.getCastorDateSafe(request, "dtStageInvStart");
    
    
    // if date completed or date determination letter is sent is empty, give error message
    if(dtDetermLetterSent == null || InvstDtlComplt == null){
      setErrorMessage(Messages.MSG_DT_DET_LETTER_REQ);
      isValid = false;
    }
    
    // if date determination letter sent is a future date or before the INV stage opened, give error message
    if(DateHelper.isAfterToday(dtDetermLetterSent) || (dtStageInvStart != null && DateHelper.isBefore(dtDetermLetterSent, dtStageInvStart))){
      setErrorMessage(Messages.MSG_DT_DET_LETTER_INVAL);
      isValid = false;
    }
    
    // if this is a special investigation but not maltreatment in care, user must answer "Is This a Policy Violation?"
    if(ArchitectureConstants.Y.equals(strSpeInv) && ArchitectureConstants.N.equals(rbInvMaltreatInCare) && policyViolation == null){
      setErrorMessage(Messages.MSG_INV_POLICY_VIOL_REQ);
      isValid = false;
    }        

    // if this is a maltreatment in care or policy violation or the disposition is UnsubstantiatedMIC but resource information is empty, give error message
    // changes for MR-097
    if((ArchitectureConstants.Y.equals(policyViolation) || ArchitectureConstants.Y.equals(rbInvMaltreatInCare) || ArchitectureConstants.Y.equals(hdnIndUnSubMIC)) && "".equals(idResource) && StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "txtNmResource"))){
      setErrorMessage(Messages.MSG_PLCMNT_PROV_REQ);
      isValid = false;
    }
    
    // STGAP00005474: Overall Risk Finding has to have a value regardless Maltreatment Finding
    if ("".equals(riskAssessmentFinding)) {
      setErrorMessage(Messages.MSG_INV_OVRALL_RSK_FINDING_REQ);
      isValid = false;
    }

    //STGAP00012542: Added this condition to display the message when Level of Risk drop down is enabled and
    // User has not entered any value for Level of Risk and clicked save and submit 
    if ((CodesTables.CCRSKFND_05.equals(riskAssessmentFinding) ||  CodesTables.CCRSKFND_01.equals(riskAssessmentFinding)) 
                    && StringHelper.isEmptyOrNull(overallRiskLvl)) 
    {
      setErrorMessage(Messages.MSG_INV_LEVEL_RISK_REQ);
      isValid = false;
    }
    

    // If the Intake Progressed to Investigation is null ,then display message
    if ((IntAssigned == null) || ("".equals(IntAssigned))) {
      performanceTrace.msg(TRACE_TAG + ".saveSubmitValidation", 7, "IntAssigned is null");
      setErrorMessage("IntAssigned", Messages.MSG_INTAKE_ASSGN_DT_REQ);
      isValid = false;
    }

    //SMS#51977 MR-066 User selects Yes to Maltreatment in care question or the indicator to 
    //UnSubstantiated MIC is Yes, but does not answer either of the two questions 
    //that involve foster parent notification of the right to have an advocate 
    //MR-097 changes on 01/26/2012
    if ((ArchitectureConstants.Y.equals(rbInvMaltreatInCare) || ArchitectureConstants.Y.equals(hdnIndUnSubMIC))
        && (StringHelper.EMPTY_STRING.equals(strFostPrnt) || StringHelper.EMPTY_STRING.equals(strStOffNotified))) {

      setErrorMessage(Messages.MSG_INV_SPCL_NOTIFICATION);
      isValid = false;
    }
    
    if(ArchitectureConstants.Y.equals(strSpeInv) && "".equals(idResource) && StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "txtNmResource"))){
        setErrorMessage(Messages.MSG_INV_PLACEMENT_REQ);
        isValid = false;
    }
    // STGAP00009662 - Maltreatment Finding required on Save and Submit to cover scenario when no allegation recorded.
    // Other scenarios have been covered by existing validation
    if (!StringHelper.isValid(maltreatmentFinding)) {
      isValid = false;
      String errorMessage = "Maltreatment Finding - " + MessageLookup.getMessageByNumber(Messages.SSM_COMPLETE_REQUIRED_SAVE_SUBMIT);
      setErrorMessage(errorMessage);
    }

    // STGAP00017941: Added a new validation on new comment field, it is required when the answer for
    // "Was the foster parent notified of the right to have an advocate present?" is 'No'
    // and Maltreatment in Care exists(Substantiated or Unsubstantiated
    if ((ArchitectureConstants.Y.equals(rbInvMaltreatInCare) || ArchitectureConstants.Y.equals(hdnIndUnSubMIC))
        && ArchitectureConstants.N.equals(strFostPrnt)
        && !StringHelper.isValid(ContextHelper.getStringSafe(request, "txtSzTxtFostPrntNotifyCmnts"))) {
      setErrorMessage(Messages.MSG_INV_NOTIFICATION_COMMENT_REQ);
      isValid = false;
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return isValid;
  }

}