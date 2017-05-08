package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.ContactForDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContactFor;

/**
 * <pre>
 * Change History:
 * Date      User                     Description
 * --------  ----------------         ----------------------------------------------
 * 02/18/10  Bhavna Gehlot            Initial creation
 * 02/21/10  hjbaptiste               Added deleteContactFor()
 * 
 * </pre>
 *
 * @author Bhavna Gehlot, Februrary 18, 2010
 */

public class ContactForDAOImpl extends BaseDAOImpl implements ContactForDAO {
  
  /**
   * Retrieves the Contact For from the db for the given idContactRule. <p/>
   * 
   * @param idContactRule
   * @return
   */
  @SuppressWarnings("unchecked")
  public List<ContactFor> findContactForByIdContactRule(int idContactRule) {
    Query query = getSession().createQuery("     from ContactFor cf "
                                                           + " where cf.id.contactRule = :idContactRule ");
    query.setInteger("idContactRule", idContactRule);
    return (List<ContactFor>) query.list();
  }
  
  public ContactFor findContactForByIdContactRuleIdChild(int idContactRule, int idChild) {
    Query query = getSession().createQuery("     from ContactFor cf "
                                                           + " where cf.id.contactRule = :idContactRule "
                                                           + " and cf.id.personChild = :idChild ");
    query.setInteger("idContactRule", idContactRule);
    query.setInteger("idChild", idChild);
    return (ContactFor) query.uniqueResult();
  }
  
  @SuppressWarnings("unchecked")
  public List<Integer> findCheckedContactForByIdContactRuleIdChild(int idContactRule) {
    Query query = getSession().createQuery("  select cf.id.personChild   from ContactFor cf "
                                                           + " where cf.id.contactRule = :idContactRule "
                                                           + " and cf.indContactFor = :indContactFor ");
    query.setInteger("idContactRule", idContactRule);
    query.setString("indContactFor", ServiceConstants.FND_YES);
    return (List<Integer>) query.list();
  }

  // Added method to compare when doing person merges as a validation
  public long countByIdPersonIdNewPerson(int idPerson, int idNewPerson) {
    Query query = getSession().createQuery(
                                           "select count(*) from ContactRule cr, ContactFor cf1, "
                                                           + "   ContactFor cf2, Event e, "
                                                           + "   Stage s "
                                                           + " where cf1.personChild.idPerson = :idPerson "
                                                           + "   and cf2.personChild.idPerson = :idNewPerson "
                                                           + "   and cf1.contactRule.idContactRule = cf2.contactRule.idContactRule "
                                                           + "   and cf1.contactRule.idContactRule = cr.idContactRule "
                                                           + "   and cr.event.idEvent = e.idEvent "
                                                           + "   and e.stage.idStage = s.idStage "
                                                           + "   and ( s.dtStageClose is null "
                                                           + "          or s.dtStageClose = :maxDate ) ");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idNewPerson", idNewPerson);
    query.setTimestamp("maxDate", DateHelper.MAX_JAVA_DATE);
    return (Long) query.uniqueResult();
  }  
  
  public int updateContactFor(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery(
                                           "update ContactFor set personChild.idPerson = :idPersMergeForward "
                                                           + " where personChild.idPerson =  :idPersMergeClosed "
                                                           + " and contactRule.idContactRule in "
                                                           + " (select idContactRule "
                                                           + "  from ContactRule where event.idEvent = :idEvent) ");
    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }  
  
  /**
   * Saves in CONTACT_FOR table
   */
  public void saveContactFor(ContactFor contactFor) {
    getSession().saveOrUpdate(contactFor);
  }

  public int deleteAllContactForsByIdContactRule(int idContactRule) {
    Query query = getSession().createQuery("delete from ContactFor " + 
                                           "      where id.contactRule = :idContactRule ");
    query.setInteger("idContactRule", idContactRule);
    return query.executeUpdate();
  }
  
  public int deleteAllContactForsByListContactRules(List<Integer> idContactRules) {
    Query query = getSession().createQuery("delete from ContactFor " + 
                                           "      where id.contactRule in (:idContactRules) ");
    query.setParameterList("idContactRules", idContactRules);
    return query.executeUpdate();
  }
  
  public void deleteContactFor(ContactFor contactFor) {
    getSession().delete(contactFor);
  }


}
