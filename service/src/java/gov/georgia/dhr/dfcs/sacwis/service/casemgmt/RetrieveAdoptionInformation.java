package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;

public interface RetrieveAdoptionInformation {

  /**
   * This Service retrieves Adoption Information details
   * 
   * @param AdoptionInformationRetrieveSI
   *          object
   * @return {@link AdoptionInformationRetrieveSO} object
   */

  public AdoptionInformationRetrieveSO retrieveAdoptionInformation(AdoptionInformationRetrieveSI adoretsi);

}
