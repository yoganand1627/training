package gov.georgia.dhr.dfcs.sacwis.service.resource;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSAllegationSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ORSResourceDetailSO;

public interface RetrieveORSResourceDetail {
  /**
   * Retrieves the ORS Facility object based on Facility ID
   * 
   * @param facId
   * @return ORSResourceDetailSO
   */
  ORSResourceDetailSO retrieveORSFacilityDetail(String facilityId);
  
  /**
   * Retrieves a list of ORS Allegations object based on a Complaint Id
   * 
   * @param compliantId 
   * @return List<ORSAllegationSO>
   */
  List<ORSAllegationSO> retrieveORSAllegations(String compliantId);
  
// mxpatel added this for defect #10438
  ORSResourceDetailSO retrieveORSFacilityDetail(String facilityId, int pageNbr, int pageSize);
}
