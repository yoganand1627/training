package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.FormValidation;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceChildRetrieveSO;
import javax.servlet.http.HttpServletRequest;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This class is the custom validation class for Safety Resource Detail.  Only check
 * is that the list of existing safety resource placements is empty before allowing
 * delete
 * 
 * @author Joshua Dorsey
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  Patrick Coogan    Updated comments for final checkin of Safety Resource
 *                             enhancement.
 * 06/23/09  bgehlot           STGAP00014329: MR-20 changes
 * 09/28/11  arege             STGAP00017055: Date of Home Visit and Date Request Received fields are required only on Save and Submit.
 * </pre>
 * 
 */
public class SafetyResourceCustomValidation extends FormValidation {

  public static final String TRACE_TAG = "SafetyResourceCustomValidation";

  /**
  * This method performs custom form validation to verify that all child placements
  * are deleted before deleting the overall record.
  * 
  * @return boolean of form validation
  * 
  */
  @SuppressWarnings( { "unchecked" })
  protected boolean validateForm() {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".validationForm()");
    performanceTrace.enterScope();
    HttpServletRequest request = super.getRequest();
    BaseSessionStateManager state = super.getState();
    boolean isValid = true;

    //List is placed in state to determine if empty.  If validation passes, removed from state.
    List<SafetyResourceChildRetrieveSO> savedPlacementsList = 
           (List<SafetyResourceChildRetrieveSO>) state.getAttribute("savedPlacementsList", request);
    
    if (super.isButtonPressed("btnDelete"))
    {
        if (!savedPlacementsList.isEmpty()){
          isValid = false;
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SRP_DELETE));
        }
        else{   
          isValid = true;
          state.removeAttribute("savedPlacementsList", request);  
        }
    }else{
      state.removeAttribute("savedPlacementsList", request);
    }

    if (super.isButtonPressed("btnSave") || super.isButtonPressed("btnSaveSubmit")) {
      String szPrimaryId = ContextHelper.getStringSafe(request, "selPrimaryResource");
      String szSecondaryId = ContextHelper.getStringSafe(request, "selSecondaryResource");

      if (szPrimaryId.equals(szSecondaryId)) {
        isValid = false;
        setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SRP_PRIM_SEC_MATCH));
      }
      // SMS #113917- Only requiring this check if the Save and Submit button is pressed
      if (!super.isButtonPressed("btnSave")) {

        String recommendation = ContextHelper.getStringSafe(request, "indRecommendation");
        if (recommendation == null || StringHelper.EMPTY_STRING.equals(recommendation)) {
          isValid = false;
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SFTY_RSRC_PLCMT_REC_REQ));
        } else if (ArchitectureConstants.N.equals(recommendation)
                   && ((StringHelper.EMPTY_STRING.equals(ContextHelper.getStringSafe(request, "selDenialReason"))) || StringHelper.EMPTY_STRING
                                                                                                                                               .equals(ContextHelper
                                                                                                                                                                    .getStringSafe(
                                                                                                                                                                                   request,                                                                                                                                                                                  "txtComments")))) {
          isValid = false;
          setErrorMessage(MessageLookup.getMessageByNumber(Messages.MSG_SFTY_RSRC_RSN_DNL_REQ));
        }
       // STGAP00017055: Date of Home Visit and Date Request Received fields are required only on Save and Submit.
        String dtHomeVisit = ContextHelper.getStringSafe(request, "dtHomeVisit");
        String dtRequestReceived = ContextHelper.getStringSafe(request, "dtRequestReceived");
        if (!StringHelper.isValid(dtHomeVisit)){
          setErrorMessage("Date of Home Visit: - Field is required. Please enter a value.");
        }
        if(!StringHelper.isValid(dtRequestReceived)){
          setErrorMessage("Date Request Received: - Field is required. Please enter a value.");

        }
      }

    }
    
    performanceTrace.exitScope();
    return isValid;
  }
}