package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactStandardsDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;
import gov.georgia.dhr.dfcs.sacwis.db.ContactStandards;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/13/10  Herve Jean-Baptiste      Initial creation
 * 02/18/10  bgehlot                  Adding business logic for pre-population of Parent Contact Rules from the Person Detail.
 * 02/21/10  hjbaptiste               Added saveContactStandards(), deleteContactStandards() and deleteContactStandardsByIdEvent()
 * 02/23/10  wjcochran                MR-62 Added method findApprovedContactStandardsByCdStageByIdCase that
 *                                    returns a ContactStandard object for a particular case idCase
 *                                    in a list of stages (i.e. 'FSU', 'ONG').
 * 
 * </pre>
 *
 * @author Herve Jean-Baptiste, Februrary 13, 2010
 */

public class ContactStandardsDAOImpl extends BaseDAOImpl implements ContactStandardsDAO {

  public ContactStandards findContactStandardsByIdEvent(int idEvent) {
    Query query = getSession().createQuery("     from ContactStandards cs "
                                                           + "    where cs.event.idEvent = :idEvent ");
    query.setInteger("idEvent", idEvent);
    return (ContactStandards) query.uniqueResult();
  }
  
  /**
   * Get all approved Contact Standards
   * @param idStage
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<ContactStandards> findApprovedContactStandards(int idStage) {
    Query query = getSession().createQuery("     from ContactStandards cs "
                                                           + "    where cs.event.stage.idStage = :idStage "
                                                           + "   and cs.event.cdEventStatus = :cdEventStatus "
                                                           + "   and cs.dtEffectiveStart is not null "
                                                           + "   and cs.dtEffectiveEnd is null ");
    query.setInteger("idStage", idStage);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    return (List<ContactStandards>) query.list();
  }
  
  public ContactStandards findApprovedContactStandardsByCdStageByIdCase(Set<String> cdStageSet, int idCase) {
    Query query = getSession().createQuery(" from ContactStandards cs "
    		                            + "  where cs.event.stage.cdStage in (:cdStageSet)"
    		                            + "  and cs.event.capsCase.idCase = :idCase" 
    		                            + "  and cs.event.cdEventStatus = :cdEventStatus");
    query.setParameterList("cdStageSet", cdStageSet);
    query.setInteger("idCase", idCase);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    
    return (ContactStandards)firstResult(query);
  }

  public void saveContactStandards(ContactStandards contactStandards) {
    getSession().saveOrUpdate (contactStandards);
  }
  
  public int deleteContactStandardsByIdEvent(int idEvent) {
    Query query = getSession().createQuery("delete from ContactStandards cs "
                                           + " where cs.idContactStdsEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

  public void deleteContactStandards(ContactStandards contactStandards) {
    getSession().delete(contactStandards);
  }
}
