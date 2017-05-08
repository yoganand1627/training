package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.CIntake;

import java.util.List;

public interface CintakeDAO {
  /**
   * Retrieves a list of ORS Complaints/Intakes objects based on ORS Facility ID
   * 
   * @param facId
   * @return List<AdverseAction>
   */
  List<CIntake> findORSComplaintsByFacilityId(String facId);
  
  /**
   * Retrieves a ORS complaints/Intakes object based on Adverse Action ID (EVENTID)
   * 
   * @param facId
   * @return AdverseAction
   */
  CIntake findORSComplaintsByEventId(String complId);
  

  // mxpatel added this for defect #10438
  PaginatedHibernateList<CIntake> findORSComplaintsByFacilityId(String facId, int pageNbr, int pageSize);
}
