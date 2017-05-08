package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CRES05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES05SO;

public interface RetrieveAreaServed {
  /**
   * This is the retrieval service for the Area Served window in order to populate the Area Served list in the
   * predisplay. Rows will only be returned if the show indicator is set to yes. In addition, it will be determined if
   * the service is contracted and stored in the contracted indicator for each row returned.
   *
   * @param CRES05SI
   * @return A populated {@link CRES05SO} object.
   */
  CRES05SO retrieveAreaServed(CRES05SI cres05si);
}
