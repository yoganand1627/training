package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AAFundingSummaryRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;

/** @author Herve Jean-Baptiste September 09, 2011 */
public interface RetrieveAAFundingSummary {
  /**
   * This Service is responsible for retrieving the information to populate the Adoption
   * Assistance Summary page.
   * 
   * @param AAFundingSummaryRetrieveSI
   *          {@link AAFundingSummaryRetrieveSI} object
   * @return {@link AAFundingSummarySO} object
   */
  public AAFundingSummarySO retrieveAAFundingSummary (AAFundingSummaryRetrieveSI aAFundingSummaryRetrieveSI) throws ServiceException;

}
