package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexResourceServiceDAO {
  /**
   * This is an AUD DAM that processes a region wide row on the RESOURCE_SERVICE table. Returns the idResource if
   * successful, or zero if it fails.
   *
   * @param indRsrcSvcShowRow
   * @param cdRsrcSvcCategRsrc
   * @param cdRsrcSvcCntyCode
   * @param cdRsrcSvcProgram
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcService
   * @param cdRsrcSvcState
   * @param indRsrcSvcCntyPartial
   * @param indRsrcSvcIncomeBsed
   * @param idResource
   * @param idResourceService
   * @param tsLastUpdate
   * @return The idResource if successful; zero if it fails.
   */
  int updateResourceServiceDAO(String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc, String cdRsrcSvcCntyCode,
                               String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService,
                               String cdRsrcSvcState, String indRsrcSvcCntyPartial, String indRsrcSvcIncomeBsed,
                               int idResource, int idResourceService, Date tsLastUpdate, String cdRsrcSvcServiceType);

  /**
   * DELETE, is called in order to delete all the necessary population and service rows for the region wide service.
   * Returns the idResource if successful, or zero if it fails.
   *
   * @param idResource
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcService
   * @param idResourceService
   * @param tsLastUpdate
   * @param cdRsrcSvcServiceType
   * @return The idResource if successful; zero if it fails.
   */
  int deleteResourceServiceDAO(int idResource, String cdRsrcSvcRegion, String cdRsrcSvcService, int idResourceService,
                               Date tsLastUpdate, String cdRsrcSvcServiceType);
}
