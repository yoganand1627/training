package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;

/**
 * <p>This Service is responsible for applying the Fostering Connections criteria for the 
 * pupose of Adoption. It performs the calculations for each criterion and checks to see
 * if that criterion is met. If met, additional processing may not be necessary for the child
 * to be considered IV-E AA Funding. If the user has chosen to "save", "validate" the Adoption 
 * Assistance Summary, or the child has no Foster Care history in the system, The funding type 
 * is determined using the information in the {@link AAFundingSummarySO} object.</p>
 * <p>If the event status is NEW or PROC, the child has Foster Care history and the AA Funding Summary page 
 * is being displayed, The funding type is determined using information gathered from throughout the system 
 * if exists.</p>
 * 
 * 
 * @author Herve Jean-Baptiste September 11, 2011 
 */
public interface AAFundingReasonEligible {

  /**
   * Determines the funding type while applying the Fostering Connections criteria
   * 
   * @param aAFundingSummarySO {@link AAFundingSummarySO} object
   * @throws {@link ServiceException} object
   */
  public void determineAAFundingType(AAFundingSummarySO aAFundingSummarySO) throws ServiceException;
}
