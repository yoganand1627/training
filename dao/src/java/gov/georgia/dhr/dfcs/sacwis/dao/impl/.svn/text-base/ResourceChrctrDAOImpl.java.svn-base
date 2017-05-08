package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceChrctrDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceChrctr;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

public class ResourceChrctrDAOImpl extends BaseDAOImpl implements ResourceChrctrDAO {
  public ResourceChrctr findResourceChrctrByIdResourceChrctr(int idRsrcChrctr) {
    Query query = getSession().createQuery(" from ResourceChrctr r " +
                                           "where r.idRsrcChrctr = :idRsrcChrctr");
    query.setInteger("idRsrcChrctr", idRsrcChrctr);
    return (ResourceChrctr) query.uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public List<Map> findResourceChrctrByIdResource(int idResource) {
    Query query = getSession().createQuery("select distinct new map(r.cdRsrcCharChrctr as cdRsrcCharChrctr, " +
                                           "                        r.dtRsrcCharDtAdded as dtRsrcCharDtAdded) " +
                                           "  from ResourceChrctr r " +
                                           " where r.capsResource.idResource = :idResource");
    query.setInteger("idResource", idResource);
    return (List<Map>) query.list();
  }
  
  @SuppressWarnings({"unchecked"})
  public List<Map> findResourceChrctrByIdResourceAndCdRsrcCharChrct(int idResource, List<String> cdRsrcCharChrctrList) {
    Query query = getSession().createQuery(" select distinct new map(r.cdRsrcCharChrctr as cdRsrcCharChrctr) " +
                                           " from ResourceChrctr r " +
                                           " where r.capsResource.idResource = :idResource " +
                                           " and r.cdRsrcCharChrctr in (:cdRsrcCharChrctrList)");
    query.setInteger("idResource", idResource);
    query.setParameterList("cdRsrcCharChrctrList", cdRsrcCharChrctrList);
    return (List<Map>) query.list();
  }
  
  

  @SuppressWarnings({"unchecked"})
  public PaginatedHibernateList<ResourceChrctr> findResourceChrctrByIdResourceService(int idResourceService,
                                                                                      int pageNbr, int pageSize) {
    Query query = getSession().createQuery("    from ResourceChrctr r " +
                                           "   where r.resourceService.idResourceService = :idResourceService " +
                                           "order by r.cdRsrcCharChrctr asc, " +
                                           "         r.cdRsrcCharSex asc");
    query.setInteger("idResourceService", idResourceService);
    return (PaginatedHibernateList<ResourceChrctr>) paginatedList(pageNbr, pageSize, query);
  }

  public int insertResourceChrctr(int idResourceService, String cdRsrcCharChrctr, String cdRsrcCharSex,
                                  int nbrRsrcCharMinMAge, int nbrRsrcCharMaxMAge, int nbrRsrcCharMinFAge,
                                  int nbrRsrcCharMaxFAge) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO RESOURCE_CHRCTR (ID_RSRC_CHRCTR, " +
                                                 "                             ID_RESOURCE_SERVICE, " +
                                                 "                             CD_RSRC_CHAR_CHRCTR, " +
                                                 "                             CD_RSRC_CHAR_SEX, " +
                                                 "                             NBR_RSRC_CHAR_MIN_M_AGE, " +
                                                 "                             NBR_RSRC_CHAR_MAX_M_AGE, " +
                                                 "                             NBR_RSRC_CHAR_MIN_F_AGE, " +
                                                 "                             NBR_RSRC_CHAR_MAX_F_AGE ) " +
                                                 "      VALUES(SEQ_RESOURCE_CHRCTR.NEXTVAL, " +
                                                 "             :idResourceService, " +
                                                 "             :cdRsrcCharChrctr, " +
                                                 "             :cdRsrcCharSex, " +
                                                 "             :nbrRsrcCharMinMAge, " +
                                                 "             :nbrRsrcCharMaxMAge, " +
                                                 "             :nbrRsrcCharMinFAge, " +
                                                 "             :nbrRsrcCharMaxFAge)");
    query.setInteger("idResourceService", idResourceService);
    query.setString("cdRsrcCharChrctr", cdRsrcCharChrctr);
    query.setString("cdRsrcCharSex", cdRsrcCharSex);
    query.setInteger("nbrRsrcCharMinMAge", nbrRsrcCharMinMAge);
    query.setInteger("nbrRsrcCharMaxMAge", nbrRsrcCharMaxMAge);
    query.setInteger("nbrRsrcCharMinFAge", nbrRsrcCharMinFAge);
    query.setInteger("nbrRsrcCharMaxFAge", nbrRsrcCharMaxFAge);
    return query.executeUpdate();
  }

  public int insertResourceChrctrNoServices(String cdRsrcCharChrctr) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO RESOURCE_CHRCTR (ID_RSRC_CHRCTR, " +
                                                 "                             CD_RSRC_CHAR_CHRCTR) " +
                                                 "      VALUES(SEQ_RESOURCE_CHRCTR.NEXTVAL, " +
                                                 "             :cdRsrcCharChrctr)");
    query.setString("cdRsrcCharChrctr", cdRsrcCharChrctr);
    return query.executeUpdate();
  }
  
  public int updateResourceChrctr(int nbrRsrcCharMinMAge, int nbrRsrcCharMaxMAge, int nbrRsrcCharMinFAge,
                                  int nbrRsrcCharMaxFAge, String cdRsrcCharSex, int idResource) {
    Query query = getSession().createQuery("update ResourceChrctr r " +
                                           "   set r.nbrRsrcCharMinMAge = :nbrRsrcCharMinMAge, " +
                                           "       r.nbrRsrcCharMaxMAge = :nbrRsrcCharMaxMAge, " +
                                           "       r.nbrRsrcCharMinFAge = :nbrRsrcCharMinFAge, " +
                                           "       r.nbrRsrcCharMaxFAge = :nbrRsrcCharMaxFAge, " +
                                           "       r.cdRsrcCharSex = :cdRsrcCharSex " +
                                           " where r.capsResource.idResource = :idResource");
    query.setInteger("nbrRsrcCharMinMAge", nbrRsrcCharMinMAge);
    query.setInteger("nbrRsrcCharMaxMAge", nbrRsrcCharMaxMAge);
    query.setInteger("nbrRsrcCharMinFAge", nbrRsrcCharMinFAge);
    query.setInteger("nbrRsrcCharMaxFAge", nbrRsrcCharMaxFAge);
    query.setString("cdRsrcCharSex", cdRsrcCharSex);
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }

  public int updateResourceChrctr(int idResource, String cdRsrcCharChrctr, String cdRsrcCharSex,
                                  int nbrRsrcCharMinMAge, int nbrRsrcCharMaxMAge, int nbrRsrcCharMinFAge,
                                  int nbrRsrcCharMaxFAge, String cdRsrcCharService, String cdRsrcCharRegion,
                                  int nbrRsrcCharMinMO, int nbrRsrcCharMaxMO, int nbrRsrcCharMinFO,
                                  int nbrRsrcCharMaxFO, String cdRsrcCharChrOld) {
    Query query = getSession().createQuery("update ResourceChrctr " +
                                           "   set cdRsrcCharChrctr = :cdRsrcCharChrctr, " +
                                           "       cdRsrcCharSex = :cdRsrcCharSex, " +
                                           "       nbrRsrcCharMinMAge = :nbrRsrcCharMinMAge, " +
                                           "       nbrRsrcCharMaxMAge = :nbrRsrcCharMaxMAge, " +
                                           "       nbrRsrcCharMinFAge = :nbrRsrcCharMinFAge, " +
                                           "       nbrRsrcCharMaxFAge = :nbrRsrcCharMaxFAge " +
                                           " where capsResource.idResource = :idResource " +
                                           "   and cdRsrcCharService = :cdRsrcCharService " +
                                           "   and cdRsrcCharRegion = :cdRsrcCharRegion " +
                                           "   and nbrRsrcCharMinMAge = :nbrRsrcCharMinMO " +
                                           "   and nbrRsrcCharMaxMAge = :nbrRsrcCharMaxMO " +
                                           "   and nbrRsrcCharMinFAge = :nbrRsrcCharMinFO " +
                                           "   and nbrRsrcCharMaxFAge = :nbrRsrcCharMaxFO " +
                                           "   and (cdRsrcCharChrctr = :cdRsrcCharChrOld or cdRsrcCharChrctr is null )");
    query.setString("cdRsrcCharChrctr", cdRsrcCharChrctr);
    query.setInteger("nbrRsrcCharMinMAge", nbrRsrcCharMinMAge);
    query.setInteger("nbrRsrcCharMaxMAge", nbrRsrcCharMaxMAge);
    query.setInteger("nbrRsrcCharMinFAge", nbrRsrcCharMinFAge);
    query.setInteger("nbrRsrcCharMaxFAge", nbrRsrcCharMaxFAge);
    query.setString("cdRsrcCharSex", cdRsrcCharSex);
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcCharService", cdRsrcCharService);
    query.setString("cdRsrcCharRegion", cdRsrcCharRegion);
    query.setInteger("nbrRsrcCharMinMO", nbrRsrcCharMinMO);
    query.setInteger("nbrRsrcCharMaxMO", nbrRsrcCharMaxMO);
    query.setInteger("nbrRsrcCharMinFO", nbrRsrcCharMinFO);
    query.setInteger("nbrRsrcCharMaxFO", nbrRsrcCharMaxFO);
    query.setString("cdRsrcCharChrOld", cdRsrcCharChrOld);
    return query.executeUpdate();
  }

  public void saveOrUpdateResourceChrctr(ResourceChrctr resourceChrctr) {
    getSession().saveOrUpdate(resourceChrctr);
  }

  public void deleteResourceChrctr(ResourceChrctr resourceChrctr) {
    getSession().delete(resourceChrctr);
  }

  public int deleteResourceChrctrByIdResource(int idResource) {
    Query query = getSession().createQuery("delete ResourceChrctr " +
                                           " where capsResource = :idResource");
    query.setInteger("idResource", idResource);
    return query.executeUpdate();
  }

  public int deleteResourceChrctrByIdResourceService(int idResource, String cdRsrcSvcState, String cdRsrcSvcService) {
    Query query = getSession().createQuery("delete from ResourceChrctr " +
                                           "       where resourceService.idResourceService in " +
                                           "             (select idResourceService " +
                                           "                from ResourceService " +
                                           "               where capsResource.idResource = :idResource " +
                                           "                 and cdRsrcSvcService = :cdRsrcSvcService " +
                                           "                 and cdRsrcSvcState = :cdRsrcSvcState )");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcState", cdRsrcSvcState);
    return query.executeUpdate();
  }

  public int deleteResourceChrctrByCdRsrcSvcRegion(int idResource, String cdRsrcSvcRegion, String cdRsrcSvcService,
                                                   String cdRsrcSvcServiceType) {
    Query query = getSession().createQuery("delete from ResourceChrctr " +
                                           "       where resourceService.idResourceService in " +
                                           "             (select idResourceService " +
                                           "                from ResourceService " +
                                           "               where capsResource.idResource = :idResource " +
                                           "                 and cdRsrcSvcService = :cdRsrcSvcService " +
                                           "                 and cdRsrcSvcServiceType = :cdRsrcSvcServiceType " +
                                           "                 and cdRsrcSvcRegion = :cdRsrcSvcRegion )");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("cdRsrcSvcServiceType", cdRsrcSvcServiceType);
    query.setString("cdRsrcSvcRegion", cdRsrcSvcRegion);
    return query.executeUpdate();
  }

  public int deleteResourceChrctrByCdRsrcSvcCnty(int idResource, String cdRsrcSvcService, String scrRsrcSvcCntyCode,
                                                 String cdRsrcSvcServiceType) {
    Query query = getSession().createQuery("delete from ResourceChrctr " +
                                           "      where resourceService.idResourceService in " +
                                           "            (select idResourceService " +
                                           "               from ResourceService " +
                                           "              where capsResource.idResource = :idResource " +
                                           "                and cdRsrcSvcService = :cdRsrcSvcService " +
                                           "                and cdRsrcSvcCnty = :scrRsrcSvcCntyCode)");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcSvcService", cdRsrcSvcService);
    query.setString("scrRsrcSvcCntyCode", scrRsrcSvcCntyCode);
    return query.executeUpdate();

  }

  public int deleteResourceChrctrByIdResource(int idResource, String cdRsrcCharService, String cdRsrcCharRegion,
                                              int scrNbrRsrcCharMinMO, int scrNbrRsrcCharMaxMO,
                                              int scrNbrRsrcCharMinFO, int scrNbrRsrcCharMaxFO,
                                              String scrCdRsrcCharChrOld) {
    Query query = getSession().createQuery("delete from ResourceChrctr " +
                                           "       where capsResource.idResource = :idResource " +
                                           "         and cdRsrcCharService = :cdRsrcCharService " +
                                           "         and cdRsrcCharRegion = :cdRsrcCharRegion " +
                                           "         and nbrRsrcCharMinMAge = :scrNbrRsrcCharMinMO " +
                                           "         and nbrRsrcCharMaxMAge = :scrNbrRsrcCharMaxMO " +
                                           "         and nbrRsrcCharMinFAge = :scrNbrRsrcCharMinFO " +
                                           "         and nbrRsrcCharMaxFAge = :scrNbrRsrcCharMaxFO " +
                                           "         and (cdRsrcCharChrctr = :scrCdRsrcCharChrOld " +
                                           "              or cdRsrcCharChrctr is null)");
    query.setInteger("idResource", idResource);
    query.setString("cdRsrcCharService", cdRsrcCharService);
    query.setString("cdRsrcCharRegion", cdRsrcCharRegion);
    query.setInteger("scrNbrRsrcCharMinMO", scrNbrRsrcCharMinMO);
    query.setInteger("scrNbrRsrcCharMaxMO", scrNbrRsrcCharMaxMO);
    query.setInteger("scrNbrRsrcCharMinFO", scrNbrRsrcCharMinFO);
    query.setInteger("scrNbrRsrcCharMaxFO", scrNbrRsrcCharMaxFO);
    query.setString("scrCdRsrcCharChrOld", scrCdRsrcCharChrOld);
    return query.executeUpdate();
  }
}
