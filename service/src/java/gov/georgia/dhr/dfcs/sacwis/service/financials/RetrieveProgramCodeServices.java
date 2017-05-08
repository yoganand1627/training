package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveProgramCodeServicesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveProgramCodeServicesSO;

/**
 * RetrieveProgramCodeServicesSO 
 * Author: Corey Harden
 * Date: 10/03/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 *
 *
 *
 *
*/

public interface RetrieveProgramCodeServices {
 /**
  * This method retrieves program codes and services for the contract services detail page
  * @param retrieveProgramCodeServicesSI - the input object
  * @return the output object
  */
  public RetrieveProgramCodeServicesSO retrieveProgramCodeServices (RetrieveProgramCodeServicesSI retrieveProgramCodeServicesSI);
}
