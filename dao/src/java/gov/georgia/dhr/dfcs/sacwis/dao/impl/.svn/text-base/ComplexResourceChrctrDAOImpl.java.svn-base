package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;

public class ComplexResourceChrctrDAOImpl extends BaseDAOImpl implements ComplexResourceChrctrDAO {
  private ResourceChrctrDAO resourceChrctrDAO = null;

  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  public int deleteResourceChrctr(int idResource, String cdRsrcSvcState, String cdRsrcSvcService,
                                  String cdRsrcSvcRegion, String scrRsrcSvcCntyCode,
                                  String cdRsrcSvcServiceType) {

    // if State != Georgia, delete based on ID resource, service and state
    if (!CodesTables.CSTATE_GA.equals(cdRsrcSvcState)) {
      return resourceChrctrDAO.deleteResourceChrctrByIdResourceService(idResource, cdRsrcSvcState, cdRsrcSvcService);
    } else if (CodesTables.CREGIONS_99.equals(cdRsrcSvcRegion) ||
               CodesTables.CREGIONS_00.equals(cdRsrcSvcRegion)) {
      // if region == statewide intake or state office, delete based on ID resource, service and region
      return resourceChrctrDAO.deleteResourceChrctrByCdRsrcSvcRegion(idResource, cdRsrcSvcRegion, cdRsrcSvcService, cdRsrcSvcServiceType);
    } else {
      // else delete based on ID resource, service and county
      return resourceChrctrDAO.deleteResourceChrctrByCdRsrcSvcCnty(idResource, cdRsrcSvcService, scrRsrcSvcCntyCode,
                                                                   cdRsrcSvcServiceType);
    }
  }
}
