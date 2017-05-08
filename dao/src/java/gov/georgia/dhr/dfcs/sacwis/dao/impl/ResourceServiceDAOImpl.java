package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCRES06SIG;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

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

public class ResourceServiceDAOImpl extends BaseDAOImpl implements ResourceServiceDAO {
  
  @SuppressWarnings({"unchecked"})
  public List<ResourceService> findCdRsrcSvcCntyCdRsrcSvcServiceByIdResourceCdRsrcSvcCategRsrc(int idResource, String cdRsrcSvcCategRsrc) {
    Query query = getSession().createQuery(" from ResourceService " +
                                           " where capsResource.idResource = :idResource " +
                                           " and cdRsrcSvcCategRsrc = :cdRsrcSvcCategRsrc ");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcCategRsrc", cdRsrcSvcCategRsrc);
    return (List<ResourceService>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<ResourceService> findResourceServiceByIdResource(int idResource,int pageNbr,
                                                               int pageSize) {
    Query query = getSession().createQuery("    from ResourceService " +
                                           "   where capsResource.idResource = :idResource " +
                                           "     and indRsrcSvcShowRow = 'Y'" +
                                           "order by cdRsrcSvcServiceType asc, " +
                                           "         cdRsrcSvcCategRsrc asc, " +
                                           "         cdRsrcSvcService asc, " +
                                           "         cdRsrcSvcState asc, " +
                                           "         cdRsrcSvcRegion asc, " +
                                           "         cdRsrcSvcCnty asc");
    query.setInteger("idResource", idResource);
    return (PaginatedHibernateList<ResourceService>) paginatedList(pageNbr, pageSize, query);
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findResourceServiceCounties(int idResource, String cdRsrcSvcService) {
    Query query = getSession().createQuery("  select cdRsrcSvcCnty " +
                                           "    from ResourceService " +
                                           "   where capsResource.idResource = :idResource " +
                                           "     and cdRsrcSvcService = :cdRsrcSvcService " +
                                           "     and cdRsrcSvcCnty is not null " +
                                           "     and cdRsrcSvcCnty <> ' ' " +
                                           "order by cdRsrcSvcCnty");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    return (List<String>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<String> findResourceServiceByCdCounty(int idResource, String cdRsrcSvcCnty) {
    Query query = getSession().createQuery("  select cdRsrcSvcService " +
                                           "    from ResourceService " +
                                           "   where capsResource.idResource = :idResource " +
                                           "     and cdRsrcSvcCnty = :cdRsrcSvcCnty " +
                                           "     and cdRsrcSvcService is not null " +
                                           "     and cdRsrcSvcService <> ' ' " +
                                           "order by cdRsrcSvcService");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcCnty", cdRsrcSvcCnty);
    return (List<String>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<String> findDistinctCdRsrcSvcServiceByIdResource(int idResource) {
    Query query = getSession().createQuery(" select distinct r.cdRsrcSvcService " +
                                           "    from ResourceService r " +
                                           "   where r.capsResource.idResource = :idResource " +
                                           "     and r.cdRsrcSvcService is not null " +
                                           "order by r.cdRsrcSvcService");
    query.setInteger("idResource", idResource);
    return (List<String>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> findServiceCodeListByResourceAndType(int idResource, String cdServiceType) {
    Query query = getSession().createQuery("  select distinct r.cdRsrcSvcService " +
                                           "    from ResourceService r " +
                                           "   where r.capsResource.idResource = :idResource " +
                                           "     and r.cdRsrcSvcServiceType = :cdServiceType " +
                                           "     and r.cdRsrcSvcService is not null " +
                                           "order by r.cdRsrcSvcService");
    query.setInteger("idResource", idResource);
    query.setString("cdServiceType", cdServiceType);
    return (List<String>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<ResourceService> findResourceServiceAll(int idResource) {

    Query query = getSession().createQuery(" from ResourceService " +
                                           "where capsResource.idResource = :idResource ");
    query.setInteger("idResource", idResource);
    return (List<ResourceService>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<Integer> findResourceServiceByIdResourceCdRsrcCharServiceCdRsrcCharRegion(int idResource,
                                                                                        String cdRsrcCharService,
                                                                                        String cdRsrcCharRegion) {
    Query query = getSession().createQuery("select r.idResourceService " +
                                           "  from ResourceService r " +
                                           " where r.capsResource.idResource = :idResource " +
                                           "   and r.cdRsrcSvcService = :cdRsrcCharService " +
                                           "   and r.cdRsrcSvcRegion = :cdRsrcCharRegion ");

    query.setInteger("idResource", idResource);
    query.setString("cdRsrcCharService", cdRsrcCharService);
    query.setString("cdRsrcCharRegion", cdRsrcCharRegion);
    return (List<Integer>) query.list();
  }

  public int updateResourceServiceSetCdRsrcSvcCnty(String cdRsrcSvcCnty, String cdRsrcSvcRegion,
                                                   String cdRsrcSvcState, int idResource) {
    Query query = getSession().createQuery("update ResourceService " +
                                           "   set cdRsrcSvcCnty = :cdRsrcSvcCnty, " +
                                           "       cdRsrcSvcRegion = :cdRsrcSvcRegion, " +
                                           "       cdRsrcSvcState = :cdRsrcSvcState " +
                                           " where capsResource.idResource = :idResource");
    query.setString("cdRsrcSvcCnty", cdRsrcSvcCnty);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    query.setString("cdRsrcSvcState", cdRsrcSvcState);
    query.setInteger("idResource", idResource);

    return query.executeUpdate();
  }

  public void saveResourceService(ResourceService resourceService) {
    getSession().saveOrUpdate(resourceService);
  }

  public int insertResourceService(int idResourceService, String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc,
                                   String scrRsrcSvcCntyCode, String cdRsrcSvcProgram, String cdRsrcSvcRegion,
                                   String cdRsrcSvcService, String cdRsrcSvcState, String indRsrcSvcCntyPartial,
                                   String indRsrcSvcIncomeBsed, int idResource, String cdRsrcSvcServiceType){
    SQLQuery query = getSession().createSQLQuery("INSERT INTO RESOURCE_SERVICE (ID_RESOURCE_SERVICE, " +
                                                 "                              IND_RSRC_SVC_SHOW_ROW, " +
                                                 "                              CD_RSRC_SVC_CATEG_RSRC, " +
                                                 "                              CD_RSRC_SVC_CNTY, " +
                                                 "                              CD_RSRC_SVC_PROGRAM, " +
                                                 "                              CD_RSRC_SVC_REGION, " +
                                                 "                              CD_RSRC_SVC_SERVICE, " +
                                                 "                              CD_RSRC_SVC_SERVICE_TYPE, " +
                                                 "                              CD_RSRC_SVC_STATE, " +
                                                 "                              IND_RSRC_SVC_CNTY_PARTIAL, " +
                                                 "                              IND_RSRC_SVC_INCOME_BSED, " +
                                                 "                              ID_RESOURCE ) " +
                                                 "     VALUES (:idResourceService, " +
                                                 "             :indRsrcSvcShowRow, " +
                                                 "             :cdRsrcSvcCategRsrc, " +
                                                 "             :scrRsrcSvcCntyCode, " +
                                                 "             :cdRsrcSvcProgram, " +
                                                 "             :cdRsrcSvcRegion, " +
                                                 "             :cdRsrcSvcService, " +
                                                 "             :cdRsrcSvcServiceType, " +
                                                 "             :cdRsrcSvcState, " +
                                                 "             :indRsrcSvcCntyPartial, " +
                                                 "             :indRsrcSvcIncomeBsed, " +
                                                 "             :idResource)");
    query.setInteger("idResourceService", idResourceService);
    query.setString("indRsrcSvcShowRow", indRsrcSvcShowRow);
    query.setString("cdRsrcSvcCategRsrc", cdRsrcSvcCategRsrc);
    query.setString("scrRsrcSvcCntyCode", scrRsrcSvcCntyCode);
    query.setString("cdRsrcSvcProgram", cdRsrcSvcProgram);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcState", cdRsrcSvcState);
    query.setString("cdRsrcSvcServiceType", cdRsrcSvcServiceType);
    query.setString("indRsrcSvcCntyPartial", indRsrcSvcCntyPartial);
    query.setString("indRsrcSvcIncomeBsed", indRsrcSvcIncomeBsed);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }

  public int updateResourceService(String indRsrcSvcShowRow, String cdRsrcSvcCategRsrc, String cdRsrcSvcCntyCode,
                                   String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService,
                                   String cdRsrcSvcState, String indRsrcSvcCntyPartial, String indRsrcSvcIncomeBsed,
                                   int idResource, int idResourceService, Date tsLastUpdate,
                                   String cdRsrcSvcServiceType) {
    Query query = getSession().createQuery("update ResourceService " +
                                           "   set indRsrcSvcShowRow = :indRsrcSvcShowRow, " +
                                           "       cdRsrcSvcCategRsrc = :cdRsrcSvcCategRsrc, " +
                                           "       cdRsrcSvcCnty = :cdRsrcSvcCntyCode, " +
                                           "       cdRsrcSvcProgram = :cdRsrcSvcProgram, " +
                                           "       cdRsrcSvcRegion = :cdRsrcSvcRegion, " +
                                           "       cdRsrcSvcService = :cdRsrcSvcService, " +
                                           "       cdRsrcSvcServiceType = :cdRsrcSvcServiceType, " +
                                           "       cdRsrcSvcState = :cdRsrcSvcState, " +
                                           "       indRsrcSvcCntyPartial = :indRsrcSvcCntyPartial, " +
                                           "       indRsrcSvcIncomeBsed = :indRsrcSvcIncomeBsed " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceService = :idResourceService " +
                                           "   and dtLastUpdate = :tsLastUpdate ");
    query.setString("indRsrcSvcShowRow", indRsrcSvcShowRow);
    query.setString("cdRsrcSvcCategRsrc", cdRsrcSvcCategRsrc);
    query.setString("cdRsrcSvcCntyCode", cdRsrcSvcCntyCode);
    query.setString("cdRsrcSvcProgram", cdRsrcSvcProgram);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcServiceType", cdRsrcSvcServiceType);
    query.setString("cdRsrcSvcState", cdRsrcSvcState);
    query.setString("indRsrcSvcCntyPartial", indRsrcSvcCntyPartial);
    query.setString("indRsrcSvcIncomeBsed", indRsrcSvcIncomeBsed);
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceService", idResourceService);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  public int updateResourceService(String cdRsrcSvcProgram, String cdRsrcSvcRegion, String cdRsrcSvcService,
                                   String cdRsrcSvcState, String indRsrcSvcCntyPartial, String indRsrcSvcIncomeBsed,
                                   int idResource, String cdRsrcSvcServiceType) {
    Query query = getSession().createQuery("update ResourceService " +
                                           "   set indRsrcSvcShowRow = 'n', " +
                                           "       cdRsrcSvcProgram = :cdRsrcSvcProgram, " +
                                           "       cdRsrcSvcRegion = :cdRsrcSvcRegion, " +
                                           "       cdRsrcSvcService = :cdRsrcSvcService, " +
                                           "       cdRsrcSvcServiceType = :cdRsrcSvcServiceType, " +
                                           "       cdRsrcSvcState = :cdRsrcSvcState, " +
                                           "       indRsrcSvcCntyPartial = :indRsrcSvcCntyPartial, " +
                                           "       indRsrcSvcIncomeBsed = :indRsrcSvcIncomeBsed " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and cdRsrcSvcService = :cdRsrcSvcService " +
                                           "   and cdRsrcSvcRegion = :cdRsrcSvcRegion ");
    query.setString("cdRsrcSvcProgram", cdRsrcSvcProgram);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcServiceType", cdRsrcSvcServiceType);
    query.setString("cdRsrcSvcState", cdRsrcSvcState);
    query.setString("indRsrcSvcCntyPartial", indRsrcSvcCntyPartial);
    query.setString("indRsrcSvcIncomeBsed", indRsrcSvcIncomeBsed);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }

  public int updateResourceServiceIndRsrcSvcShowRow(int idResource, int idResourceService) {
    Query query = getSession().createQuery("update ResourceService " +
                                           "   set indRsrcSvcShowRow = 'Y'" +
                                           " where capsResource.idResource = :idResource " +
                                           "   and idResourceService = :idResourceService ");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceService", idResourceService);
    return query.executeUpdate();
  }
  
  public int updateResourceServiceRegion(int idResource, String cdRsrcSvcRegion, String cdRsrcSvcCnty){
    Query query = getSession().createQuery("update ResourceService " +
                                           "   set cdRsrcSvcRegion = :cdRsrcSvcRegion " +
                                           " where capsResource.idResource = :idResource " +
                                           " and cdRsrcSvcCnty = :cdRsrcSvcCnty ");
    
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    query.setString("cdRsrcSvcCnty", cdRsrcSvcCnty);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }
  
  //STGAP00014037 : Added the condition cdRsrcSvcCnty is not null
  public int updateResourceServiceCounty(int idResource, String cdRsrcSvcCnty){
    Query query = getSession().createQuery("update ResourceService " +
                                           "   set cdRsrcSvcCnty = :cdRsrcSvcCnty " +
                                           " where capsResource.idResource = :idResource " +
                                           " and cdRsrcSvcCnty is not null ");
    
    query.setString("cdRsrcSvcCnty", cdRsrcSvcCnty);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }
  
  public int deleteResourceServiceByIdResource(int idResource){    
    Query query = getSession().createQuery("delete from ResourceService" +
                                           "       where capsResource.idResource = :idResource" );
    query.setInteger("idResource", idResource);;
    return query.executeUpdate();
  }
  
  public int deleteResourceServiceByIdResourceIdResourceServiceDtLastUpdate(int idResource, int idResourceService, Date tsLastUpdate) {
    Query query = getSession().createQuery("delete from ResourceService" +
                                           "       where capsResource.idResource = :idResource" +
                                           "         and idResourceService = :idResourceService" +
                                           "         and dtLastUpdate = :tsLastUpdate");
    query.setInteger("idResource", idResource);
    query.setInteger("idResourceService", idResourceService);
    query.setTimestamp("tsLastUpdate", tsLastUpdate);
    return query.executeUpdate();
  }

  public int deleteResourceServiceByCdRsrcSvcServiceCdRsrcSvcRegionIdResource(String cdRsrcSvcService, String cdRsrcSvcRegion, int idResource) {
    Query query = getSession().createQuery("delete from ResourceService" +
                                           "       where idResourceService in (select idResourceService" +
                                           "                                 from ResourceService" +
                                           "                                where capsResource.idResource = :idResource " +
                                           "                                  and cdRsrcSvcService = :cdRsrcSvcService " +
                                           "                                  and cdRsrcSvcRegion = :cdRsrcSvcRegion )");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);

    return query.executeUpdate();
  }

  public int deleteResourceServiceByIdResourceCdRsrcSvcCntyCode(String cdRsrcSvcService, String cdRsrcSvcCntyCode,
                                                                int idResource) {
    Query query = getSession().createQuery("delete from ResourceService" +
                                           "       where idResourceService in (select idResourceService" +
                                           "                                 from ResourceService" +
                                           "                                where capsResource.idResource = :idResource " +
                                           "                                  and cdRsrcSvcService = :cdRsrcSvcService" +
                                           "                                  and cdRsrcSvcCnty = :cdRsrcSvcCntyCode )");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcCntyCode", cdRsrcSvcCntyCode);

    return query.executeUpdate();
  }
  
  public ResourceService findDuplicateResourceServiceByRegionWide(String cdRsrcSvcService, String cdRsrcSvcRegion, int idResource) {
    Query query = getSession().createQuery(" from ResourceService" +
                                           " where capsResource.idResource = :idResource " +
                                           " and cdRsrcSvcService = :cdRsrcSvcService " +
                                           " and cdRsrcSvcRegion = :cdRsrcSvcRegion " +
                                           " and (cdRsrcSvcCnty is null or cdRsrcSvcCnty = ' ')");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    return (ResourceService) firstResult(query);
  }
  
  public ResourceService findDuplicateResourceServiceByCountyRow(String cdRsrcSvcService, String cdRsrcSvcRegion, String cdRsrcSvcCntyCode, int idResource) {
    Query query = getSession().createQuery(" from ResourceService" +
                                           " where capsResource.idResource = :idResource " +
                                           " and cdRsrcSvcService = :cdRsrcSvcService " +
                                           " and cdRsrcSvcCnty = :cdRsrcSvcCntyCode ");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcCntyCode", cdRsrcSvcCntyCode);
    return (ResourceService) firstResult(query);
  }

}
