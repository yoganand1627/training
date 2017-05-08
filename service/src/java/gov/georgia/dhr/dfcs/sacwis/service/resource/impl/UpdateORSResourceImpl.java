package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.FacilityDAO;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.UpdateORSResource;

public class UpdateORSResourceImpl extends BaseServiceImpl implements UpdateORSResource {
  
  private FacilityDAO facilityDAO = null;

  public void setFacilityDAO(FacilityDAO facilityDAO) {
    this.facilityDAO = facilityDAO;
  }

  public int updateFacilityResourceId(String facId, int resourceid) {
    return facilityDAO.updateFacilityResourceId(facId, resourceid);
  }
}
