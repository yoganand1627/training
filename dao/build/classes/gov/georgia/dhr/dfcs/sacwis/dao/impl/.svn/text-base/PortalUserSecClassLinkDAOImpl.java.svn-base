package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink;
import org.hibernate.Query;

public class PortalUserSecClassLinkDAOImpl extends BaseDAOImpl implements PortalUserSecClassLinkDAO {
  @SuppressWarnings({"unchecked"})
  public List<Map> findPortalUserSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idUser) {
    Query query =
            getSession().createQuery("select new map (l.portalSecurityClass.cdSecurityClassName as cdSecurityClassName, " +
                                     "                s.txtSecurityClassProfil as txtSecurityClassProfil) " +
                                     "  from PortalUserSecClassLink l, " +
                                     "       PortalSecurityClass s " +
                                     " where l.portalUser.idUser = :idUser " +
                                     "   and l.portalSecurityClass.cdSecurityClassName = s.cdSecurityClassName");
    query.setInteger("idUser", idUser);
    return (List<Map>) query.list();
  }

  @SuppressWarnings({"unchecked"})
  public List<PortalUserSecClassLink> findPortalUserSecClassLinkSecurityClassbyIdPerson(int idUser) {
    Query query = getSession().createQuery("      from PortalUserSecClassLink l " +
                                           "join fetch l.portalSecurityClass c " +
                                           "     where l.portalUser.idUser = :idUser " +
                                           "  order by l.portalSecurityClass.cdSecurityClassName");
    query.setInteger("idUser", idUser);
    return (List<PortalUserSecClassLink>) query.list();
  }
  // this is your first attempt
  @SuppressWarnings({"unchecked"})
  public Long findPortalUserSecClassLink(String cdSecurityClassName) {
    Query query = getSession().createQuery("select count(*)" +
                                           "from PortalUserSecClassLink e " +
                                           "where e.portalSecurityClass.cdSecurityClassName = :cdSecurityClassName");
  query.setString("cdSecurityClassName", cdSecurityClassName);
    return (Long) query.uniqueResult();
  }
  
  public void savePortalUserSecClassLink(PortalUserSecClassLink PortalUserSecClassLink) {
    getSession().saveOrUpdate(PortalUserSecClassLink);
  }

  public int deletePortalUserSecClassLink(int idPortalUserSecLink, Date dtLastUpdate) {
    Query query = getSession().createQuery("delete PortalUserSecClassLink " +
                                           " where idPortalUserSecLink = :idPortalUserSecLink " +
                                           "   and dtLastUpdate = :dtLastUpdate ");
    query.setInteger("idPortalUserSecLink", idPortalUserSecLink);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    return query.executeUpdate();
  }

  public int deletePortalUserSecClassLinkByIdPerson(int idUser) {
    Query query = getSession().createQuery(" delete from PortalUserSecClassLink " +
                                           "       where portalUser.idUser = :idUser");
    query.setInteger("idUser", idUser);
    return query.executeUpdate();
  }
}
