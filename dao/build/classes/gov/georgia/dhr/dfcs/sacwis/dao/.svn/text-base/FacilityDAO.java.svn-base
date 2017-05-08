package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.Facility;


public interface FacilityDAO {
  
  /**
   * Retrieves the  ORS Facility object based on Facility ID
   * 
   * @param facId
   * @return Facility
   */
  
  @SuppressWarnings({"unchecked"})
  Facility findFacilityByFacilityId(String facId);
  
  /**
   * Update the Facility shines resource id
   * 
   * @param facId
   * @return shines resource id
   */
  
  @SuppressWarnings({"unchecked"})  
  int updateFacilityResourceId(String facId, int resourceid);
  
  
  /**
   * Retrieves the list of ORS Facilities Associated to a Shines Resource  
   * 
   * @param resourceid
   * @return Facility
   */
   List<Facility> findFacilitiesByResourceId(int resourceid);
}
