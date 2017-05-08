package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CheckForCpsHistorySI;


public interface CheckForCpsHistory {

  /**
   * Checks for Cps History 
   *
   * @param checkForCpsHistorySI bean
   * @return
   * @author Courtney Wells
   * @throws ServiceException
   */
   Boolean checkForCpsHistory(CheckForCpsHistorySI checkForCpsHistorySI);
}