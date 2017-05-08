package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON18SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON18SO;

public interface RetrieveServiceAuthorization {

  /**
   * This service will perform the retrieval of Service Authorization Header information as well as some validation
   * logic.  Using ID EVENT it will retrieve from the SVC_AUTH_LINK table the ID SVC AUTH.  If the Window mode is Modify
   * or Browse then this ID will be used to retrieve Header information from the SVC AUTH table.  Also using the ID
   * EVENT, the CD EVENT STATUS will be retrieved from the EVENT table.  Using ID RESOURCE the NM RESOURCE will be
   * retrieved from the CAPS_RESOURCE table. If the mode is NEW then certain validations will have to be performed:  If
   * the user Program is APS then the ID STAGE will be used to check if there is a row on the EVENT table where CD TASK
   * is 'Client Assessment' (2080).
   *
   * @param ccon18si
   * @return {@link CCON18SO}
   */
  CCON18SO retrieveServiceAuthorization(CCON18SI ccon18si);
}
