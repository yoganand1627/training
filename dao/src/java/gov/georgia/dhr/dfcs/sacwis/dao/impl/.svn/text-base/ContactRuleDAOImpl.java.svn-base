package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactRuleDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactRule;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/18/10  Bhavna Gehlot            Initial creation
 * 02/21/10  hjbaptiste               Added deleteContactRule() and deleteAllContactRules()
 * 
 * </pre>
 *
 * @author Bhavna Gehlot, Februrary 18, 2010
 */

public class ContactRuleDAOImpl extends BaseDAOImpl implements ContactRuleDAO {
  
  /**
   * Retrieves the Contact Rules from the db for the given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<ContactRule> findContactRulesByIdEventCdPersonRole(int idEvent, List<String> roles) {
    Query query = getSession().createQuery("     from ContactRule cr "
                                                           + " where cr.event.idEvent = :idEvent "
                                                           + " and cr.cdPersonRole in (:roles)"
                                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    query.setParameterList("roles", roles);
    return (List<ContactRule>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List findContactRulesPersonByIdEventCdPersonRole(int idEvent, List<String> roles) {
    Query query = getSession().createQuery(" select new map ( cr.person.idPerson as idPerson, p.nmPersonFull as nmPersonFull) "
    		                                           + " from ContactRule cr, Person p "
                                                           + " where cr.event.idEvent = :idEvent "
                                                           + " and cr.cdPersonRole in (:roles)"
                                                           + " and cr.person.idPerson = p.idPerson"
                                                           + " order by cr.indPrepopulated desc");
    query.setInteger("idEvent", idEvent);
    query.setParameterList("roles", roles);
    return (List<Map>) query.list();
  }
  
  /**
   * Retrieves the Contact Rules from the db for the given idEvent. <p/>
   * 
   * @param idEvent
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<ContactRule> findContactRuleByIdEvent(int idEvent) {
    Query query = getSession().createQuery("     from ContactRule cr "
                                                           + " where cr.event.idEvent = :idEvent" 
                                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    return (List<ContactRule>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<ContactRule> findAllContactRulesByIdEvent(int idEvent) {
    Query query = getSession().createQuery("     from ContactRule cr "
                                           + " where cr.event.idEvent = :idEvent"
                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    return (List<ContactRule>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<ContactRule> findAllParentContactRulesByIdEventIncludeNew(int idEvent, List<String> roles) {
    Query query = getSession().createQuery("     from ContactRule cr "
                                                           + " where cr.event.idEvent = :idEvent "
                                                           + " and (cr.cdPersonRole in (:roles)"
                                                           + " or cr.cdPersonRole is null)"
                                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    query.setParameterList("roles", roles);
    return (List<ContactRule>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<ContactRule> findContactRulesByIdEventRolesIndPrepopulate(int idEvent, List<String> roles, String indPrepopulated) {
    Query query = getSession().createQuery("     from ContactRule cr "
                                                           + " where cr.event.idEvent = :idEvent "
                                                           + " and cr.cdPersonRole in (:roles)"
                                                           + " and cr.indPrepopulated = :indPrepopulated"
                                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    query.setParameterList("roles", roles);
    query.setString("indPrepopulated", indPrepopulated);
    return (List<ContactRule>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<String> findContactRulesByIdEventIdChild(int idEvent, int idChild, String cdPersonrole) {
    Query query = getSession().createQuery("  select p.nmPersonFull  "
    		                                           +" from ContactRule cr join cr.person p, ContactFor cf"
                                                           + " where cr.event.idEvent = :idEvent "
                                                           + " and cr.idContactRule = cf.contactRule.idContactRule "
                                                           + " and cf.personChild.idPerson = :idChild "
                                                           + " and cr.cdPersonRole = :cdPersonrole " 
                                                           + " and cf.indContactFor = :indContactFor"
                                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    query.setInteger("idChild", idChild);
    query.setString("cdPersonrole", cdPersonrole);
    query.setString("indContactFor", ServiceConstants.FND_YES);
    return (List<String>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public String findUnknownContactRulesByIdEventIdChild(int idEvent, int idChild, String cdPersonrole) {
    Query query = getSession().createQuery("  select cr.cdUnknownParent  "
                                                           +" from ContactRule cr, ContactFor cf"
                                                           + " where cr.event.idEvent = :idEvent "
                                                           + " and cr.idContactRule = cf.contactRule.idContactRule "
                                                           + " and cf.personChild.idPerson = :idChild "
                                                           + " and cr.cdPersonRole = :cdPersonrole " 
                                                           + " and cf.indContactFor = :indContactFor"
                                                           + " and cr.person is null "
                                                           + " order by cr.indPrepopulated desc, cr.idContactRule asc");
    query.setInteger("idEvent", idEvent);
    query.setInteger("idChild", idChild);
    query.setString("cdPersonrole", cdPersonrole);
    query.setString("indContactFor", ServiceConstants.FND_YES);
    return (String) query.uniqueResult();
  }
  
  // Added method to compare when doing person merges as a validation
  public long countByIdPersonIdNewPerson(int idPerson, int idNewPerson) {
    Query query = getSession().createQuery(
                                           "select count(*) " + "  from ContactRule cr1, "
                                                           + "       ContactRule cr2, " + "       Event e, "
                                                           + "       Stage s "
                                                           + " where cr1.person.idPerson = :idPerson "
                                                           + "   and cr2.person.idPerson = :idNewPerson "
                                                           + "   and cr1.event.idEvent = cr2.event.idEvent "
                                                           + "   and cr1.event.idEvent = e.idEvent "
                                                           + "   and e.stage.idStage = s.idStage "
                                                           + "   and ( s.dtStageClose is null "
                                                           + "          or s.dtStageClose = :maxDate ) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idNewPerson", idNewPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }  
  
  public int updateContactRule(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery(
                                           "update ContactRule set person.idPerson = :idPersMergeForward "
                                                           + " where person.idPerson =  :idPersMergeClosed "
                                                           + "   and event.idEvent = :idEvent ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  /**
   * Saves in CONTACT_RULE table
   */
  public int saveContactRule(ContactRule contactRule) {
    getSession().saveOrUpdate(contactRule);
    return contactRule.getIdContactRule();
  }

  public void deleteContactRule(ContactRule contactRule) {
    getSession().delete(contactRule);
  }

  public int deleteAllContactRules(int idEvent) {
    Query query = getSession().createQuery("delete from ContactRule cr "
                                           + " where cr.event.idEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }

}
