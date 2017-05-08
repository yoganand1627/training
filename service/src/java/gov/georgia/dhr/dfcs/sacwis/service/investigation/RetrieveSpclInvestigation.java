package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpclInvestigationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;

/** @author Herve Jean-Baptiste, May 22, 2011 */
public interface RetrieveSpclInvestigation {

  /**
   * This class retrieves all data from the DB to display the Special Investigation
   * 
   * @param spclInvestigationRetrieveSI
   * @return
   * @throws ServiceException
   */
  public SpclInvestigationRetrieveSO retrieveSpclInvestigation (SpclInvestigationRetrieveSI spclInvestigationRetrieveSI) throws ServiceException;
}
