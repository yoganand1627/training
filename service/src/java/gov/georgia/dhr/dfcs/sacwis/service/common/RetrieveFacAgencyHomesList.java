package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveFacAgencyHomesListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListSO;

public interface RetrieveFacAgencyHomesList {
	
/**
* Retrieval service for Retrieve FacAgencyHomesList 
*
* @param RetrieveFacAgencyHomesListSI
* @return {@link RetrieveFacAgencyHomesListSO}
*/
	RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesList(RetrieveFacAgencyHomesListSI retrieveFacAgencyHomesListSI);

}
