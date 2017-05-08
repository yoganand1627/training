/**
 * Created on Mar 25, 2006 at 2:17:36 PM by Michael K. Werle
 *
 * <pre>
 *  Change History:
 *  Date               User      Description
 *  ----------        --------  --------------------------------------------------
 *  09/29/2009         arege    STGAP00015281: Added method findContactNarrativeByIdEvent() to find Narrative by idEvent.
 */

package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.dao.ContactNarrativeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactNarrative;
import org.hibernate.Query;

public class ContactNarrativeDAOImpl extends BaseDAOImpl implements ContactNarrativeDAO {
  public int deleteContactNarative(int idStage) {
    Query query = getSession().createQuery("delete from ContactNarrative cn " +
                                           "       where cn.idEvent in (select e.idEvent " +
                                           "                          from Event e " +
                                           "                         where e.stage.idStage = :idStage) ");
    query.setInteger("idStage", idStage);

    return query.executeUpdate();
  }
  
  @SuppressWarnings({"unchecked"})
  public ContactNarrative findContactNarrativeByIdEvent(int idEvent) {
    Query query = getSession().createQuery(" from  ContactNarrative where event.idEvent = :idEvent order By idEvent ");

    query.setInteger("idEvent", idEvent);
    return (ContactNarrative) query.uniqueResult();
  }
  
  public List<Map> findAllContactNarratives() {
    Query query = getSession().createQuery(" select new map (cn.idEvent as idEvent, " 
                                           + " dtt.nmDocument as nmDocument, cn.dtLastUpdate as dtLastUpdate)" 
                                           + " from ContactNarrative cn, DocumentTemplate dt, DocumentTemplateType dtt" 
                                           + " where cn.documentTemplate.idDocumentTemplate = dt.idDocumentTemplate" 
                                           + " and dt.documentTemplateType.idDocumentTemplateType = dtt.idDocumentTemplateType" 
                                           + " and dtt.nmDocument in ('spwbnarr', 'cvisitn')");
    query.setMaxResults(1000);
    return query.list();
  }
  
  public List<Integer> findAllIdEventsForContactNarratives() {
    Query query = getSession().createQuery(" select cn.idEvent from ContactNarrative cn ");
    query.setMaxResults(1000);
    return query.list();
  }
}
