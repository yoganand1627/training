package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RecordsCheckSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO;


public interface RetrieveRecordsCheckSummary {
  
  /**
   * This method accepts retrieves records check summary information for all principals on a stage
   * and returns the information within a service out (SO) transport object
   * @param rcSummarySI - the service in (SI) transport object shuttling information from the page to the service
   * @return - returns all necessary data for the records check summary page within a transport layer object
   */
  public RecordsCheckSummarySO retrieveRecordsCheckSummary(RecordsCheckSummarySI rcSummarySI);
}
