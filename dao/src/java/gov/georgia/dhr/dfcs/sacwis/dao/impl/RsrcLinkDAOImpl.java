package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;

import java.util.List;

import org.hibernate.Query;

public class RsrcLinkDAOImpl extends BaseDAOImpl implements RsrcLinkDAO {
  @SuppressWarnings({"unchecked"})
  public List<RsrcLink> findRsrcLinkSubcontractorsByIdRsrcLinkParent(int idRsrcLinkParent) {
    Query query = getSession().createQuery("      from RsrcLink l " +
                                           "join fetch l.capsResourceByIdRsrcLinkChild c " +
                                           "     where l.capsResourceByIdRsrcLinkParent.idResource = :idRsrcLinkParent " +
                                           "  order by c.nmResource");
    query.setInteger("idRsrcLinkParent", idRsrcLinkParent);
    return (List<RsrcLink>) query.list();
  }
  
  //STGAP000012937 Added for pagination 
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<RsrcLink> findRsrcLinkSubcontractorsByIdRsrcLinkParent(int idRsrcLinkParent, int pageNbr, int pageSize) {
    Query query = getSession().createQuery("  from RsrcLink l "+ 
                                           "join fetch l.capsResourceByIdRsrcLinkChild c " +
                                           "     where l.capsResourceByIdRsrcLinkParent.idResource = :idRsrcLinkParent " +
                                           "  order by c.nmResource");                                          
    query.setInteger("idRsrcLinkParent", idRsrcLinkParent);
    return (PaginatedHibernateList<RsrcLink>) this.paginatedList(pageNbr, pageSize, query);
  }

  public Integer findIdRsrcLinkByIdRsrcLinkChildAndCdRsrcPrimeSubLink(int idRsrcLinkChild) {
    Query query = getSession().createQuery("select idRsrcLink " +
                                           "  from RsrcLink " +
                                           " where capsResourceByIdRsrcLinkChild.idResource = :idRsrcLinkChild " +
                                           "   and cdRsrcLinkType = :cdRsrcPrimeSubLink)");
    query.setInteger("idRsrcLinkChild", idRsrcLinkChild);
    query.setString("cdRsrcPrimeSubLink", CodesTables.CRSCLINK_01);
    return (Integer) firstResult(query);
  }

  public Integer findIdRsrcLinkByIdRsrcLinkParentCdRsrcPrimeSubLink(int idRsrcLinkParent) {
    Query query = getSession().createQuery("select r.idRsrcLink " +
                                           "  from RsrcLink r " +
                                           " where r.capsResourceByIdRsrcLinkParent.idResource = :idRsrcLinkParent " +
                                           "   and r.cdRsrcLinkType = :cdRsrcPrimeSubLink ");
    query.setInteger("idRsrcLinkParent", idRsrcLinkParent);
    query.setString("cdRsrcPrimeSubLink", CodesTables.CRSCLINK_01);
    return (Integer) firstResult(query);
  }

  public RsrcLink findCapsResourceAndRsrcLink(int idRsrcLinkChild, String cdRsrcLinkType) {
    Query query = getSession().createQuery("      from RsrcLink r  " +
                                           "join fetch r.capsResourceByIdRsrcLinkChild c " +
                                           "     where r.capsResourceByIdRsrcLinkChild.idResource = :idRsrcLinkChild " +
                                           "       and r.cdRsrcLinkType = :cdRsrcLinkType ");
    query.setInteger("idRsrcLinkChild", idRsrcLinkChild);
    query.setString("cdRsrcLinkType", cdRsrcLinkType);
    return (RsrcLink) firstResult(query);
  }

  public void saveRsrcLink(RsrcLink rsrcLink) {
    getSession().saveOrUpdate(rsrcLink);
  }

  public void deleteRsrcLink(RsrcLink rsrcLink) {
    getSession().delete(rsrcLink);
  }
  
  public Integer findCapsResourceParentIdRsrcLink(int idRsrcLinkChild) {
    Query query = getSession().createQuery("      select r.capsResourceByIdRsrcLinkParent.idResource from RsrcLink r  " +
    "     where r.capsResourceByIdRsrcLinkChild.idResource = :idRsrcLinkChild ");
    query.setInteger("idRsrcLinkChild", idRsrcLinkChild);
    return (Integer) firstResult(query);
    }

}
