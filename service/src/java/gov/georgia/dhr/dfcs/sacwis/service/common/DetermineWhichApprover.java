package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

public interface DetermineWhichApprover {

  /**
   * Attempts to determine who the current approver is in a multi-approver approval.
   * It retrieves all of the approvers for a particular approval using the RetrieveApprovers
   * service. This service returns a list of historical approvers as well as the current
   * approver. All of the approvers are counted and a determination is made depending on how 
   * many approvers records were found. The approval type indicates the type of event that is
   * being approved.
   * 
   * @param idApproval
   * @param approvalType
   * @return
   */
  public String determineWhichApprover (int idApproval, String approvalType) throws ServiceException;
}
