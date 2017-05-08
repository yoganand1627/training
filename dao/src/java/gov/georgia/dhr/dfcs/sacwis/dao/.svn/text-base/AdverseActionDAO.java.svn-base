package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.AdverseAction;

import java.util.List;

public interface AdverseActionDAO {
  /**
   * Retrieves a list of Adverse Action objects based on Facility ID
   * 
   * @param facId
   * @return List<AdverseAction>
   */
  List<AdverseAction> findAdverseActionsByFacilityId(String facId);
  
  /**
   * Retrieves an Adverse Action object based on Adverse Action ID (EVENTID)
   * 
   * @param facId
   * @return AdverseAction
   */
  AdverseAction findAdverseActionByEventId(String eventId);
}
