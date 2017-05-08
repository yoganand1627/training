package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.service.common.DetermineWhichApprover;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveApprovers;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ApproversRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.Approver;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ApproversRetrieveSO;

import java.util.List;

/**
 * @author Herve Jean-Baptiste  June 08, 2011
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------           
 *   
 * </pre>
 * 
 */
public class DetermineWhichApproverImpl extends BaseServiceImpl implements DetermineWhichApprover {

  private static final String SUPERVISOR = "Supervisor";
  private static final String COUNTY_DIRECTOR = "County Director";
  private static final String POLICY_UNIT = "Policy Unit";
  private static final String DEPUTY_DIRECTOR = "Deputy Director";
  private static final String SPECIAL_INVESTIGATION = "Special Investigation";
  private static final String SAFETY_RESOURCE = "Safety Resource";
  private static final int ZERO = 0;
  private static final int ONE = 1;
  private static final int TWO = 2;
  private static final int THREE = 3;
 
  
  private RetrieveApprovers retrieveApprovers;
  
  public void setRetrieveApprovers(RetrieveApprovers retrieveApprovers) {
    this.retrieveApprovers = retrieveApprovers;
  }



  public String determineWhichApprover(int idApproval, String approvalType) throws ServiceException{
    int numOfApprovers = 0;
    String whichApprover = "";
    // Use the approval id because when additional approvers are added for the event, the newly added
    // approver record will contain the same approval id as the current approver. This ensures that we're
    // counting approvers for the same approval.  If an approver had rejected the approval, resubmitting
    // the event will produce a different approval record tied to the event. Therefore we do not want to
    // find the approvers based on the event id but rather, the approval id.
    if (idApproval == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    } else {
      ApproversRetrieveSI si = new ApproversRetrieveSI(ApproversRetrieveSI.APPROVAL, idApproval);
      ApproversRetrieveSO so = retrieveApprovers.retrieveApprovers(si);
      // If there are historical approvers for this approval, they've already approved the event.
      // Determine which approver is the current one based on the number of historical approvers.
      // If the current user is the only approver record found then this current approver 
      // is the SUPERVISOR.
      if (so.hasHistoricalApprovers() && so.hasCurrentActiveApprover()) {
        numOfApprovers = so.getHistoricalApprovers().size();
        // If there are pending approvers statuses in the historical list, subtract the number of approved
        // approvers
        List<Approver> approvers  = so.getHistoricalApprovers();
        for (Approver a : approvers) {
          if (CodesTables.CEVTSTAT_PEND.equals(a.getCdStatus())) {
            numOfApprovers--;
          }
        }
      } else if (so.hasCurrentActiveApprover()) {
        numOfApprovers = ZERO;
      }
      
      if (SPECIAL_INVESTIGATION.equals(approvalType)) {
        switch (numOfApprovers) {
        case THREE:
          whichApprover = DEPUTY_DIRECTOR;
          break;
        case TWO:
          whichApprover = POLICY_UNIT;
          break;
        case ONE:
          whichApprover = COUNTY_DIRECTOR;
          break;
        case ZERO:
          whichApprover = SUPERVISOR;
          break;
        default:
          whichApprover = SUPERVISOR;
        }
      } else if (SAFETY_RESOURCE.equals(approvalType)) {
        switch (numOfApprovers) {
        case ONE:
          whichApprover = COUNTY_DIRECTOR;
          break;
        case ZERO:
          whichApprover = SUPERVISOR;
          break;
        default:
          whichApprover = SUPERVISOR;
        }
      }
    }
    return whichApprover; 
  }

}
