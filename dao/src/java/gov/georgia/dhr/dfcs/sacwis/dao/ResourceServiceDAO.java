/**
 * Created on Mar 23, 2006 at 4:47:17 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;

/**
                                       Change History
 *
 *   Date          User                  Description
 * --------  ----------------  --------------------------------------------------
 * 10/11/11     charden         added method findCdRsrcSvcCntyCdRsrcSvcServiceByIdResourceCdRsrcSvcCategRsrc()
 * 10/19/11     htvo            STGAP00017212: added findDuplicateResourceServiceByCountyRow, findDuplicateResourceServiceByRegionWide 
 *                              validate duplicate against all existing records
 *
 */

public interface ResourceServiceDAO {
  /**
   * Returns all resource service rows with the given resource id and program code
   * @param idResource
   * @param cdRsrcSvcCategRsrc
   * @return
   */
  public List<ResourceService> findCdRsrcSvcCntyCdRsrcSvcServiceByIdResourceCdRsrcSvcCategRsrc(int idResource, String cdRsrcSvcCategRsrc);
  /**
   * Returns all rows from the RESOURCE_SERVICE table for a specified resource ID.
   * 
   * @param idResource
   * @return
   */
  PaginatedHibernateList<ResourceService> findResourceServiceByIdResource(int idResourceint, int pageNbr,
                                                                          int pageSize);

  /**
   * This selects the counties in which a resource can provide a service.
   * 
   * @param idResource
   * @param cdRsrcSvcService
   * @return
   */
  List<String> findResourceServiceCounties(int idResource, String cdRsrcSvcService);

  //SMS#79227: Added method to find resource services by new county
  /**
   * 
   * @param idResource
   * @param cdRsrcSvcCnty
   * @return
   */
  public List<String> findResourceServiceByCdCounty(int idResource, String cdRsrcSvcCnty);

  /**
   * This selects a distinct CD_RSRC_SVC_SERVICE from RESOURCE SERVICE table given an ID RESOURCE.
   * 
   * @param idResource
   * @return List of String by idResource
   */
  List<String> findDistinctCdRsrcSvcServiceByIdResource(int idResource);
  
  /**
   * Retrieves all distinct service codes from ResourceService for the given idResource and
   * cdServiceType (G=General or F=Financial)
   * 
   * @param idResource
   * @param cdServiceType
   * @return
   */
  List<String> findServiceCodeListByResourceAndType(int idResource, String cdServiceType);

  /**
   * This gets ResourceService given idResource.
   * 
   * @param idResource
   * @return List <ResourceService>
   */
  List<ResourceService> findResourceServiceAll(int idResource);

  /**
   * This DAM retrieves all of the resource service ID's from the resource service table based on a resource ID,
   * service, and region.
   * 
   * @param idResource
   * @param cdRsrcCharService
   * @param cdRsrcCharRegion
   * @return
   */
  List<Integer> findResourceServiceByIdResourceCdRsrcCharServiceCdRsrcCharRegion(int idResource,
                                                                                 String cdRsrcCharService,
                                                                                 String cdRsrcCharRegion);

  /**
   * Will update the RESOURCE_SERVICE table using a host of id_resource
   * 
   * @param cdRsrcSvcCnty
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcState
   * @param idResource
   * @return
   */
  int updateResourceServiceSetCdRsrcSvcCnty(String cdRsrcSvcCnty, String cdRsrcSvcRegion,
                                            String cdRsrcSvcState, int idResource);

  /**
   * This is an update/insert for ResourceService table.
   * 
   * @param resourceService
   */

  void saveResourceService(ResourceService resourceService);

  /**
   * Insert ResourceService
   * 
   * @param idResourceService
   * @param indRsrcSvcShowRow
   * @param cdRsrcSvcCategRsrc
   * @param scrRsrcSvcCntyCode
   * @param cdRsrcSvcProgram
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcService
   * @param cdRsrcSvcState
   * @param indRsrcSvcCntyPartial
   * @param indRsrcSvcIncomeBsed
   * @param idResource
   * @param cdRsrcSvcServiceType
   * @return
   */
  int insertResourceService(int idResourceService, String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc,
                            String scrRsrcSvcCntyCode, String cdRsrcSvcProgram, String cdRsrcSvcRegion,
                            String cdRsrcSvcService, String cdRsrcSvcState, String indRsrcSvcCntyPartial,
                            String indRsrcSvcIncomeBsed, int idResource, String cdRsrcSvcServiceType);

  /**
   * Updates table ResourceService with the specified fields <p/>
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
   * @param cdRsrcSvcServiceType
   * @return
   */
  int updateResourceService(String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc, String cdRsrcSvcCntyCode,
                            String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService,
                            String cdRsrcSvcState, String indRsrcSvcCntyPartial, String indRsrcSvcIncomeBsed,
                            int idResource, int idResourceService, Date tsLastUpdate, String cdRsrcSvcServiceType);

  /**
   * Updates table ResourceService with the specified fields <p/>
   *
   * @param cdRsrcSvcProgram
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcService
   * @param cdRsrcSvcState
   * @param indRsrcSvcCntyPartial
   * @param indRsrcSvcIncomeBsed
   * @param idResource
   * @param cdRsrcSvcServiceType
   * @return
   */
  int updateResourceService(String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService,
                            String cdRsrcSvcState, String indRsrcSvcCntyPartial, String indRsrcSvcIncomeBsed,
                            int idResource, String cdRsrcSvcServiceType);

  /**
   * Updates table ResourceService field indRsrcSvcShowRow base on the idResource and idResourceService.<p/>
   * 
   * @param idResource
   * @param idResourceService
   */
  int updateResourceServiceIndRsrcSvcShowRow(int idResource, int idResourceService);
  
  /**
   * Updates table ResourceService field cdRsrcSvcRegion based on the idResource and cdRsrcSvcCnty.<p/>
   * 
   * @param idResource
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcCnty
   */
  public int updateResourceServiceRegion(int idResource, String cdRsrcSvcRegion, String cdRsrcSvcCnty);
  
  /**
   * Updates table ResourceService field cdRsrcSvcCnty based on the idResource 
   * 
   * @param idResource
   * @param cdRsrcSvcCnty
   * @return
   */
  public int updateResourceServiceCounty(int idResource, String cdRsrcSvcCnty);

  /**
   * Delete rows from RESOURCE_SERVICE based on ID_RESOURCE
   * 
   * @param idResource
   * @return
   */
  public int deleteResourceServiceByIdResource(int idResource);
  
  /**
   * Delete rows from RESOURCE_SERVICE based on ID_RESOURCE, ID_RESOURCE_SERVICE and DT_LAST_UPDATE
   * 
   * @param idResource
   * @param idResourceService
   * @param tsLastUpdate
   * @return
   */
  int deleteResourceServiceByIdResourceIdResourceServiceDtLastUpdate(int idResource, int idResourceService, Date tsLastUpdate);

  /**
   * Delete rows from RESOURCE_SERVICE based on ID_RESOURCE
   * 
   * @param cdRsrcSvcService
   * @param cdRsrcSvcRegion
   * @param idResource
   * @return
   */
  int deleteResourceServiceByCdRsrcSvcServiceCdRsrcSvcRegionIdResource(String cdRsrcSvcService, String cdRsrcSvcRegion, int idResource);

  /**
   * Delete rows from RESOURCE_SERVICE based on ID_RESOURCE
   * 
   * @param cdRsrcSvcService
   * @param cdRsrcSvcCntyCode
   * @param idResource
   * @return
   */
  int deleteResourceServiceByIdResourceCdRsrcSvcCntyCode(String cdRsrcSvcService, String cdRsrcSvcCntyCode,
                                                         int idResource);
  
  /**
   * Find existing region wide resource service; one that is valid for the entire region.
   * @param cdRsrcSvcService
   * @param cdRsrcSvcRegion
   * @param idResource
   * @return
   */
  public ResourceService findDuplicateResourceServiceByRegionWide(String cdRsrcSvcService, String cdRsrcSvcRegion, int idResource);
  
  /**
   * Find existing resource service for a county. 
   * @param cdRsrcSvcService
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcCntyCode
   * @param idResource
   * @return
   */
  public ResourceService findDuplicateResourceServiceByCountyRow(String cdRsrcSvcService, String cdRsrcSvcRegion, String cdRsrcSvcCntyCode, int idResource);

}
