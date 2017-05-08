package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;

import java.util.Date;
import java.util.List;
import java.util.Map;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   08/24/2011  hnguyen           STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
 *                                 and not look at the legal actions across the AU.
 *
 */

public interface CheckFceJudicialRequirements {
  
  
  /**
   * Retrieves all of the dates for the Requirements section on the FCE Initial Application Worksheet 
   * 
   * @param idCase
   * @param idChild
   * @param removalDAte
   * @return
   * @throws ServiceException
   */
  public Map<String, Date> checkFceJudicialRequirements (int idCase, int idChild, Date removalDAte) throws ServiceException;

}
