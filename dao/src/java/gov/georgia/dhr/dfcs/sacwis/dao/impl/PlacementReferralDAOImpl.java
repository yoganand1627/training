/**
 * Created on 14th Feb, 2007 for Release 2, by Lata Lokhande.
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.PlacementReferral;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
/**
 * This DAO is for Placement_Referral table, used in Placement Referral Log and
 * Placement Referral Detail Page.
 * @author lata.p.lokhande, Created on 2/14/2007.
 * 
 *
 */

public class PlacementReferralDAOImpl extends BaseDAOImpl implements PlacementReferralDAO {
  
  /**
   * Retrieves the records from Placement_referral table, order by ascending status
   * and then ascending Begin Date,used in Placement Referral Log and Placement Referral Detail Page.
   * 
   */
  @SuppressWarnings( { "unchecked" })
  public PaginatedHibernateList<Map> findPlacementReferralByIdResource(int idResource, int pageNbr, int pageSize) {
    Query query = getSession().createQuery(
                                           "select new map(pr.idPlacementReferral as idPlacementReferral,"
                                         + "pr.dtLastUpdate as dtLastUpdate,"
                                         + "pr.person.idPerson as idPerson,"
                                         + "pr.employee.idPerson as idEmployee,"
                                         + "pr.dtBegin as dtBegin,"
                                         + "pr.dtExpiration as dtExpiration,"
                                         + "pr.cdStatus as cdStatus,"
                                         + "pr.cdPlacementType as cdPlacementType)"
                                         + "from PlacementReferral pr "
                                         + "where pr.capsResource.idResource = :idResource "
                                         + "order by cdStatus, dtBegin ");
    query.setInteger("idResource", idResource);
    return (PaginatedHibernateList<Map>) paginatedList(pageNbr, pageSize, query);
  }
  
  /**
   * 
   * @param idPlacementReferral
   * @return PlacementReferral
   */
  public PlacementReferral findPlacementReferralByIdPlacementReferral(int idPlacementReferral) {
    Session session = getSession();
    Query query = session.createQuery("from PlacementReferral pr " + "where pr.idPlacementReferral = :idPlacementReferral");
    query.setInteger("idPlacementReferral", idPlacementReferral);
    return (PlacementReferral) firstResult(query);
  }
  
  public void savePlacementReferral(PlacementReferral placementReferral) {
    getSession().saveOrUpdate(placementReferral);
  }
  
 }
  
    
    
    
    
    
    
    
    
    
    
    
  
