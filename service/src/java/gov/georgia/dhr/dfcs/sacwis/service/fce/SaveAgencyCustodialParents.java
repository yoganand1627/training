/**
 * Created on May 7, 2007 at 2:23:24 PM by Kapil Aggarwal - SACWIS Atlanta
 */
package gov.georgia.dhr.dfcs.sacwis.service.fce;

import gov.georgia.dhr.dfcs.sacwis.structs.input.AgencyCustodialParentsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgencyCustodialParentsSO;

public interface SaveAgencyCustodialParents {

  public AgencyCustodialParentsSO saveAgencyCustodialParents(AgencyCustodialParentsSI agencyCustodialParentsSI);
  
}
