package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Gautami Rout, Dec 21, 2006 <p/>
 *         <p/>
 *         <pre>
 *            Change History:
 *      Date      User              Description
 *     --------  ----------------  -------------------------
 *     4/13/09   cwells 	   STGAP00012997 Adding code for custom validation to this file.                           
 *
 *
 */

@SuppressWarnings("serial")
public class InitialMedicaidCustomValidation extends FormValidation {
  protected static final String TRACE_TAG = "InitialMedicaidCustomValidation";
  public static final String SAVE_AND_SUBMIT_BUTTON = "btnSubmitApplicationFinal";
  public static final String SIGN_NOW_BUTTON = "btnSignNow";
  public static final String YES = "Yes";
  public static final String IND_YES = "Y";
  public static final String APPROVED_EVENT = "APRV";
  public static final String PENDING_EVENT = "PEND";
  public static final String TRUE = "true";
  

  /** all the validation logic */
  @SuppressWarnings("unchecked")
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateForm()");
    performanceTrace.enterScope();

    if (super.isButtonPressed(SAVE_AND_SUBMIT_BUTTON)) {
      validateFormForSave();
    }
    
    if (super.isButtonPressed(SIGN_NOW_BUTTON)) {
      validateFormForSignNow();
    }

    performanceTrace.exitScope();
    return getErrorMessages().isEmpty();
  }

  protected void validateFormForSave() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFormForSave()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO = new MedicaidApplicationRetrieveSO();
    medicaidApplicationRetrieveSO = (MedicaidApplicationRetrieveSO) state.getAttribute("MedicaidApplicationRetrieveSO",
                                                                                       request);

    String indCaseManagerApply = ContextHelper.getStringSafe(request, "indCaseManagerApply");
    String indChildSupportOrder = ContextHelper.getStringSafe(request, "indChildSupportOrder");
    String indChildPregnent = ContextHelper.getStringSafe(request, "indChildPregnent");
    String indMedicalAssistChild = ContextHelper.getStringSafe(request, "indMedicalAssistChild");
    String indChildCoverage = ContextHelper.getStringSafe(request, "indChildCoverage");
    String dtProcessed = ContextHelper.getStringSafe(request, "dtProcessed");
    String dtEstDeliveryDate = ContextHelper.getStringSafe(request, "dtEstDeliveryDate");
    String txtMonths = ContextHelper.getStringSafe(request, "txtMonths");
    String indIcamaIcpc = ContextHelper.getStringSafe(request, "indIcamaIcpc");
    String cdIcamaState = ContextHelper.getStringSafe(request, "cdIcamaState");
    String cdIcamaAsstType = ContextHelper.getStringSafe(request, "cdIcamaAsstType");
    String cdAdoptionType = ContextHelper.getStringSafe(request, "cdAdoptionType");
    String txtIcamaComments = ContextHelper.getStringSafe(request, "txtIcamaComments");
    String indChild = ContextHelper.getStringSafe(request, "indChild");
    
    
    String isPregnant = medicaidApplicationRetrieveSO.getChildPregnancy();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    String pageMode = PageMode.getPageMode(request);
    
    
    
 
    
    if (medicaidApplicationRetrieveSO.getDtSigned() == null) {
      setErrorMessage(Messages.MSG_FCE_SIGN_INIT_MA);
    }

    if ("".equals(indCaseManagerApply)) {
      setErrorMessage(Messages.MSG_FCE_ACK_INIT_MA);
    }
    // STGAP00012997 adding custom validation checks for required and 
    // Conditionally required fields 
    if(!StringHelper.isValid(indChildSupportOrder)){
      setErrorMessage("Has Child Support been ordered in the juvenile court? - Field is required. Please enter a value.");
    }
    if(YES.equals(isPregnant)){
      if(!StringHelper.isValid(indChildPregnent)){
      setErrorMessage("Is the child's pregnancy verified and documented? - Field is required. Please enter a value.");
      }else if(IND_YES.equals(indChildPregnent)  && !StringHelper.isValid(dtEstDeliveryDate)){
        setErrorMessage("Est. Delivery Date - Field is required. Please enter a value.");
      }
    }
    if(!StringHelper.isValid(indMedicalAssistChild)){
      setErrorMessage("Was medical assistance needed for the child prior to removal? - Field is required. Please enter a value.");
    }else if(TRUE.equals(indMedicalAssistChild) && !StringHelper.isValid(txtMonths)){
      setErrorMessage("Months: - Field is required. Please enter a value.");
    }
    if(!StringHelper.isValid(indChildCoverage)){
      setErrorMessage("Is the child covered by any health insurance other than Medicaid? - Field is required. Please enter a value.");
    }else if(TRUE.equals(indChildCoverage) && !StringHelper.isValid(indChild)){
      setErrorMessage("Is a copy of health insurance card available? - Field is required. Please enter a value.");
    }
    if(StringHelper.isValid(indIcamaIcpc)){
          if(!StringHelper.isValid(cdIcamaState)){
            setErrorMessage("State: - Field is required. Please enter a value.");
           }if(!StringHelper.isValid(cdIcamaAsstType)){
             setErrorMessage("Type of Assisstance: - Field is required. Please enter a value.");
           }if(!StringHelper.isValid(cdAdoptionType)){
             setErrorMessage("Adoption Type: - Field is required. Please enter a value.");
           }if(!StringHelper.isValid(txtIcamaComments)){
             setErrorMessage("Comments: - Field is required. Please enter a value.");
           }
    }
    
    if (((pageMode.equals(PageModeConstants.VIEW)) && (APPROVED_EVENT.equals(medicaidApplicationRetrieveSO.getCdEventStatus()))) ||
                    ((user.hasRight(UserProfile.SEC_ELIGIBILITY) && (PENDING_EVENT.equals(medicaidApplicationRetrieveSO.getCdEventStatus()))))){
                if(!StringHelper.isValid(dtProcessed)){
                  setErrorMessage("Date Proccessed - Field is required. Please enter a value.");
                }
    }
    
    
    performanceTrace.exitScope();
  }
  
  protected void validateFormForSignNow() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validateFormForSignNow()");
    performanceTrace.enterScope();

    HttpServletRequest request = super.getRequest();
    
    String indCaseManagerApply = ContextHelper.getStringSafe(request, "indCaseManagerApply");

    if ("".equals(indCaseManagerApply)) {
      setErrorMessage(Messages.MSG_FCE_ACK_INIT_MA);
    }

    performanceTrace.exitScope();
  }

}
