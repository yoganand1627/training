package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Date;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;

public class PortalUserVendorLinkDAOImpl extends BaseDAOImpl implements PortalUserVendorLinkDAO {
  @SuppressWarnings( { "unchecked" })
  public List<PortalUserVendorLink> findPortalUserVendorLinkbyIdUser(int idUser) {
    Query query = getSession().createQuery(
                                           " from PortalUserVendorLink puvl "
                                                           + " where puvl.portalUser.idUser = :idUser "
                                                           + " and puvl.cdStatus = 'ACT' "
                                                           + " and (puvl.dtEnd >= sysdate or puvl.dtEnd is null) "
                                                           + " and puvl.dtStart <= sysdate ");
    query.setInteger("idUser", idUser);
    return (List<PortalUserVendorLink>) query.list();
  }

  @SuppressWarnings( { "unchecked" })
  public long findCommonPortalUserVendorLinksbyIdUserAndDate(int idUser, Date dtContactDate,
                                                             List<Integer> assignedResources) {
    Query query = getSession()
                              .createQuery(
                                           " select count(*) from PortalUserVendorLink puvl "
                                                           + " where puvl.portalUser.idUser = :idUser "
                                                           + " and (puvl.dtEnd >= :dtContactDate or puvl.dtEnd is null) "
                                                           + " and puvl.dtStart <= :dtContactDate "
                                                           + " and puvl.capsResource.idResource in (:assignedResources)");
    query.setInteger("idUser", idUser);
    query.setDate("dtContactDate", dtContactDate);
    query.setParameterList("assignedResources", assignedResources);
    return (Long) query.uniqueResult();
  }

  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPortalVendorStaffList(List<Integer> idRsrcList, List<String> statuses,
                                                               List<String> types, int idUser, int pageNbr, int pageSize) {
    Query query = getSession()
                              .createQuery(
                                           "select new map(a.nmUserFull as nmUserFull,"
                                                           + "               a.idUser as idUser, "
                                                           + "               b.nmResource as nmResource, "
                                                           + "               b.idResource as idResource,"
                                                           + "               a.txtUserEmail as addrRsrcEmail,"
                                                           + "               a.nbrUserPhone as nbrRsrcContactPhn,"
                                                           + "               c.cdAccessType as cdAccessType,"
                                                           + "               c.cdStatus as cdStatus,"
                                                           + "               c.dtStart as dtStart,"
                                                           + "               c.dtEnd as dtEnd) "
                                                           + "               FROM PortalUser a,"
                                                           + "               CapsResource b,"
                                                           + "               PortalUserVendorLink c"
                                                           + "               WHERE a.idUser = c.portalUser.idUser"
                                                           + "               AND b.idResource= c.capsResource.idResource"
                                                           + "               AND ((c.capsResource.idResource IN (:idRsrcList))"
                                                           + "               OR (a.idUser = :idUser))"
                                                           + "               AND c.cdAccessType IN (:types)"
                                                           + "               AND c.cdStatus IN (:statuses)"
                                                           + "               ORDER BY c.dtEnd desc, a.nmUserFull asc");
    query.setParameterList("idRsrcList", idRsrcList);
    query.setInteger("idUser", idUser);
    query.setParameterList("types", types);
    query.setParameterList("statuses", statuses);
    
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findActiveResourceListForVendorPortal(){
    SQLQuery query = getSession().createSQLQuery(" Select distinct puvl.id_resource as idResource, " +
                                                 " cr.nm_resource as nmResource " +
                                                 " FROM portal_user_vendor_link puvl, caps_resource cr " +
                                                 " where puvl.id_resource = cr.id_resource " +
                                                 " and puvl.cd_access_type = 'PAD' " +
                                                 " and puvl.cd_status = 'ACT' ");
    query.addScalar("idResource", Hibernate.INTEGER);
    query.addScalar("nmResource", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findActiveResourceListForVendorPortal(int idUser){
    SQLQuery query = getSession().createSQLQuery(" Select distinct puvl.id_resource as idResource, " +
                                                 " cr.nm_resource as nmResource " +
                                                 " FROM portal_user_vendor_link puvl, caps_resource cr " +
                                                 " where puvl.id_resource = cr.id_resource " +
                                                 " and puvl.cd_access_type = 'PAD' " +
                                                 " and puvl.id_user = :idUser " +
                                                 " and puvl.cd_status = 'ACT' ");
    query.setInteger("idUser", idUser);
    query.addScalar("idResource", Hibernate.INTEGER);
    query.addScalar("nmResource", Hibernate.STRING);
    return (List<Object[]>) query.list();
  }
  @SuppressWarnings({"unchecked"})
  public List<Object[]> findResourceListForGivenUser(int idUser){
    SQLQuery query = getSession().createSQLQuery(" Select puvl.id_portal_user_vendor_link as idPortalUserVendorLink, " +
                                                 " puvl.id_resource as idResource, " +
                                                 " cr.nm_resource as nmResource, " +
                                                 " puvl.cd_access_type as cdAccessType, " +
                                                 " puvl.cd_status as cdStatus, " +
                                                 " puvl.dt_start as dtStart, " +
                                                 " puvl.dt_end as dtEnd "+
                                                 " FROM portal_user_vendor_link puvl, caps_resource cr " +
                                                 " where puvl.id_resource = cr.id_resource " +
                                                 " and puvl.id_user = :idUser ");
    query.setInteger("idUser", idUser);
    query.addScalar("idPortalUserVendorLink", Hibernate.INTEGER);
    query.addScalar("idResource", Hibernate.INTEGER);
    query.addScalar("nmResource", Hibernate.STRING);
    query.addScalar("cdAccessType", Hibernate.STRING);
    query.addScalar("cdStatus", Hibernate.STRING);
    query.addScalar("dtStart", Hibernate.DATE);
    query.addScalar("dtEnd", Hibernate.DATE);
    return (List<Object[]>) query.list();    
  }
  public void saveNewPortalUserVendorLink(Session session, PortalUserVendorLink portalUserVendorLink) {
    session.saveOrUpdate(portalUserVendorLink);
  }
  public PortalUserVendorLink findPortalUserVendorLinkByIdUserAndIdResource
                                                (int idUser, int idResource){
    Query query = getSession().createQuery(
                                           " from PortalUserVendorLink puvl "
                                         + " where puvl.portalUser.idUser = :idUser "
                                         + " and puvl.capsResource.idResource = :idResource ");
    query.setInteger("idUser", idUser);
    query.setInteger("idResource", idResource);
    return (PortalUserVendorLink) firstResult(query);    
  }
  public void savePortalUserVendorLink(PortalUserVendorLink portalUserVendorLink){
    getSession().saveOrUpdate(portalUserVendorLink);
  }
  public void approvePortalUserVendorLink(int idUser){
    Query query = getSession().createQuery(" update PortalUserVendorLink puvl " +
                                           " set puvl.cdStatus = 'ACT' " +
                                           " where puvl.portalUser.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    query.executeUpdate();       
  }
  public void deletePortalUserVendorLinkByIdUser(int idUser){
    Query query = getSession().createQuery(" delete PortalUserVendorLink puvl " +
                                           " where puvl.portalUser.idUser = :idUser ");
    query.setInteger("idUser", idUser);
    query.executeUpdate();       
  }
  public void deletePortalUserVendorLinkByIdPuvl(int idPuvl){
    Query query = getSession().createQuery(" delete PortalUserVendorLink puvl " +
                                           " where puvl.idPortalUserVendorLink = :idPuvl ");
    query.setInteger("idPuvl", idPuvl);
    query.executeUpdate();     
  }
}
