package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.AdoptionInformationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AdoptionInformationRetrieveSO;

public interface RetrievePrivateAgencyName {

  /**
   * This Service calls the  rsrcLinkDAO to retrieve Private Agency Name
   * 
   * @param IdResource
   *          
   * @return Private Agency Name as String.
   */

 
  public String retrievePrivateAgencyName(int IdResource);


}
