/**
 * Created on Mar 25, 2006 at 3:26:06 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr;

public interface ResourceChrctrDAO {
  
  /**
   * Retrieves a {@link gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr} object 
   * @param idResourceChrctr
   * @return
   */
  ResourceChrctr findResourceChrctrByIdResourceChrctr(int idResourceChrctr);
  
  /**
   * Retrieves a distinct set of Cd Rsrc Char Characteristics & Dt Rsrc Char Date Added from the ResourceChrct object
   * 
   * @param idResource
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findResourceChrctrByIdResource(int idResource);
  
  /**
   * Retrieves a distinct set of Cd Rsrc Char Characteristics from the ResourceChrct object based on idResouce and cdRsrcCharChrctr
   * 
   * @param idResource
   * @param List<String> cdRsrcCharChrctrList
   * @return List<ResourceChrctr>
   */
  @SuppressWarnings({"unchecked"})
  List<Map> findResourceChrctrByIdResourceAndCdRsrcCharChrct(int idResource, List<String> cdRsrcCharChrctrList);

  /**
   * Retrieves the population characteristics for a service based on the ID resource service.
   * 
   * @param idResourceService
   * @return
   */
  @SuppressWarnings({"unchecked"})
  PaginatedHibernateList<ResourceChrctr> findResourceChrctrByIdResourceService(int idResourceService, int pageNbr,
                                                                               int pageSize);

  /**
   * Insert an entry into the ResourceChrctr table with the supplied collumn values.<p/> <p/> Note that, this is done
   * in straight sql.

   * @param cdRsrcCharChrctr
   * @return Integer
   */
  public int insertResourceChrctrNoServices(String cdRsrcCharChrctr);
  
  /**
   * Insert an entry into the ResourceChrctr table with the supplied collumn values.<p/> <p/> Note that, this is done
   * in straight sql.
   * 
   * @param idResourceService
   * @param cdRsrcCharChrctr
   * @param cdRsrcCharSex
   * @param nbrRsrcCharMinMAge
   * @param nbrRsrcCharMaxMAge
   * @param nbrRsrcCharMinFAge
   * @param nbrRsrcCharMaxFAge
   * @return Integer
   */
  int insertResourceChrctr(int idResourceService, String cdRsrcCharChrctr, String cdRsrcCharSex, int nbrRsrcCharMinMAge,
                           int nbrRsrcCharMaxMAge, int nbrRsrcCharMinFAge, int nbrRsrcCharMaxFAge);

  /**
   * Will update the resource_chrctr table using id_resource
   * 
   * @param nbrRsrcCharMinMAge
   * @param nbrRsrcCharMaxMAge
   * @param nbrRsrcCharMinFAge
   * @param nbrRsrcCharMaxFAge
   * @param cdRsrcCharSex
   * @param idResource
   * @return
   */
  int updateResourceChrctr(int nbrRsrcCharMinMAge, int nbrRsrcCharMaxMAge, int nbrRsrcCharMinFAge,
                           int nbrRsrcCharMaxFAge, String cdRsrcCharSex, int idResource);
  
  /**
   * Updates the resource_chrctr table using the specified fields (collumn values).
   * </p>
   * 
   * @param idResource
   * @param cdRsrcCharChrctr
   * @param cdRsrcCharSex
   * @param nbrRsrcCharMinMAge
   * @param nbrRsrcCharMaxMAge
   * @param nbrRsrcCharMinFAge
   * @param nbrRsrcCharMaxFAge
   * @param cdRsrcCharService
   * @param cdRsrcCharRegion
   * @param nbrRsrcCharMinMO
   * @param nbrRsrcCharMaxMO
   * @param nbrRsrcCharMinFO
   * @param nbrRsrcCharMaxFO
   * @param cdRsrcCharChrOld
   * @return Integer representing the number of rows affected
   */
  int updateResourceChrctr(int idResource, String cdRsrcCharChrctr, String cdRsrcCharSex, int nbrRsrcCharMinMAge,
                           int nbrRsrcCharMaxMAge, int nbrRsrcCharMinFAge, int nbrRsrcCharMaxFAge,
                           String cdRsrcCharService, String cdRsrcCharRegion, int nbrRsrcCharMinMO,
                           int nbrRsrcCharMaxMO, int nbrRsrcCharMinFO, int nbrRsrcCharMaxFO,
                           String cdRsrcCharChrOld);

  /**
   * Saves or updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr} object.
   * @param resourceChrctr
   */
  void saveOrUpdateResourceChrctr(ResourceChrctr resourceChrctr);
  
  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr} object.
   * 
   * @param resourceChrctr
   */
  void deleteResourceChrctr(ResourceChrctr resourceChrctr);

  /**
   * Deletes a ResourceChrctr record w/o checking date last update.
   * 
   * @param idResource
   * @return
   */
  int deleteResourceChrctrByIdResource(int idResource);

  /**
   * Delete rows from RESOURCE_CHRCTR based on ID_RESOURCE_SERVICE
   * 
   * @param idResource
   * @param cdRsrcSvcState
   * @param cdRsrcSvcService
   * @return
   */
  int deleteResourceChrctrByIdResourceService(int idResource, String cdRsrcSvcState, String cdRsrcSvcService);

  /**
   * Delete rows from RESOURCE_CHRCTR based on ID_RESOURCE_SERVICE
   * 
   * @param idResource
   * @param cdRsrcSvcRegion
   * @param cdRsrcSvcService
   * @param cdRsrcSvcServiceType
   * @return
   */
  int deleteResourceChrctrByCdRsrcSvcRegion(int idResource, String cdRsrcSvcRegion, String cdRsrcSvcService, String cdRsrcSvcServiceType);

  /**
   * Delete rows from RESOURCE_CHRCTR based on ID_RESOURCE_SERVICE
   * 
   * @param idResource
   * @param cdRsrcSvcService
   * @param scrRsrcSvcCntyCode
   * @param cdRsrcSvcServiceType
   * @return
   */
  int deleteResourceChrctrByCdRsrcSvcCnty(int idResource, String cdRsrcSvcService, String scrRsrcSvcCntyCode, String cdRsrcSvcServiceType);

  /**
   * Delete rows from RESOURCE_CHRCTR table based on ID_RESOURCE
   * 
   * @param idResource
   * @param cdRsrcCharService
   * @param cdRsrcCharRegion
   * @param scrNbrRsrcCharMinMO
   * @param scrNbrRsrcCharMaxMO
   * @param scrNbrRsrcCharMinFO
   * @param scrNbrRsrcCharMaxFO
   * @param scrCdRsrcCharChrOld
   * @return
   */
  int deleteResourceChrctrByIdResource(int idResource, String cdRsrcCharService, String cdRsrcCharRegion,
                                       int scrNbrRsrcCharMinMO, int scrNbrRsrcCharMaxMO, int scrNbrRsrcCharMinFO,
                                       int scrNbrRsrcCharMaxFO, String scrCdRsrcCharChrOld);
}
