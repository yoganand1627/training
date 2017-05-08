package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;

public class ComplexResourceServiceDAOImpl extends BaseDAOImpl implements ComplexResourceServiceDAO {
  private ResourceServiceDAO resourceServiceDAO = null;

  private ResourceChrctrDAO resourceChrctrDAO = null;

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setResourceChrctrDAO(ResourceChrctrDAO resourceChrctrDAO) {
    this.resourceChrctrDAO = resourceChrctrDAO;
  }

  // TODO update process needs to change.
  public int updateResourceServiceDAO(String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc, String cdRsrcSvcCntyCode,
                                      String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService,
                                      String cdRsrcSvcState, String indRsrcSvcCntyPartial, String indRsrcSvcIncomeBsed,
                                      int idResource, int idResourceService, Date tsLastUpdate,
                                      String cdRsrcSvcServiceType) {
    // Update the regionwide row
    if (0 == resourceServiceDAO
                               .updateResourceService(indRsrcSvcShowRow, cdRsrcSvcCategRsrc, cdRsrcSvcCntyCode,
                                                      cdRsrcSvcProgram, cdRsrcSvcRegion, cdRsrcSvcService,
                                                      cdRsrcSvcState, indRsrcSvcCntyPartial, indRsrcSvcIncomeBsed,
                                                      idResource, idResourceService, tsLastUpdate, cdRsrcSvcServiceType)) {
      return 0;
    }
    // If successful update the individual county rows SET SHOW ROW TO N
    if (0 == resourceServiceDAO.updateResourceService(cdRsrcSvcProgram, cdRsrcSvcRegion, cdRsrcSvcService,
                                                      cdRsrcSvcState, indRsrcSvcCntyPartial, indRsrcSvcIncomeBsed,
                                                      idResource, cdRsrcSvcServiceType)) {
      return 0;
    }
    // Set all region row back to SHOW ROW = Y
    if (0 == resourceServiceDAO.updateResourceServiceIndRsrcSvcShowRow(idResource, idResourceService)) {
      return 0;
    }
    return idResource;
  }

  public int deleteResourceServiceDAO(int idResource, String cdRsrcSvcRegion, String cdRsrcSvcService,
                                      int idResourceService, Date tsLastUpdate, String cdRsrcSvcServiceType) {
    // Delete regionwide characteristics and delete the individual county's population rows
    // This can return 0 and we need to continue.
    resourceChrctrDAO.deleteResourceChrctrByCdRsrcSvcRegion(idResource, cdRsrcSvcRegion, cdRsrcSvcService,
                                                            cdRsrcSvcServiceType);
    // Delete regionwide row If successful or no rows returned, delete the individual county rows
    if (0 == resourceServiceDAO.deleteResourceServiceByIdResourceIdResourceServiceDtLastUpdate(idResource, idResourceService, tsLastUpdate)) {
      return 0;
    }
    // Delete county rows
    if (0 == resourceServiceDAO.deleteResourceServiceByCdRsrcSvcServiceCdRsrcSvcRegionIdResource(cdRsrcSvcService, cdRsrcSvcRegion, idResource)) {
      return 0;
    }
    return idResource;
  }
}
