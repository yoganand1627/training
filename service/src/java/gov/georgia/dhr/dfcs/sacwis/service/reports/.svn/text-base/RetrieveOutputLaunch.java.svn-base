package gov.georgia.dhr.dfcs.sacwis.service.reports;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;

public interface RetrieveOutputLaunch {
  /**
   * This service will receive Id Event and invoke perform a full-row retrieval of the Event Table.Using CdEventType
   * retrieved from the query, service will query one of the Document/Narrative tables to retrieve a timestamp.
   *
   * @param csub59si{@link CSUB59SI}
   * @return {@link CSUB59SO}
   */
  public CSUB59SO retrieveOutputLaunch(CSUB59SI csub59si);
  
  /**
   * 
   * @param cdnfRetrieveSI
   * @return
   */
  public CDNFRetrieveSO retrieveOutputLaunch(CDNFRetrieveSI cdnfRetrieveSI);
}
