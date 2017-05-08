package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC39SO;

public interface RetrieveCaseMergeList {

  /**
   * This service will retrieve all past merges for a given case, as well as case specific information for the given
   * case. If the necessary security requirements have not already been met, the service will also check if the logged
   * in user is either assigned to the given case as a primary worker or is in the unit hiearchy of a primary worker for
   * the case.
   *
   * @param ccfc39si
   * @return
   */
  public CCFC39SO findCaseMergeList(CCFC39SI ccfc39si);
}
