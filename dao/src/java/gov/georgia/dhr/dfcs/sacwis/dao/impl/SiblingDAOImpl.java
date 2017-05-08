package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Collection;
import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;

import gov.georgia.dhr.dfcs.sacwis.db.Sibling;

/**
 * This is the DAO that contains the SQL to save and retrieve Sibling records to and from the Database. <p/>
 * <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User             Description
 *   --------  ------------     --------------------------------------------------
 *  09/15/08   vdevarak         Initial Implementation
 *  05/15/09   hjbaptiste       STGAP00013455: Added findSiblingsByIdSiblingGroup() method to retrieve the person ids 
 *                              of all children in a sibling group
 *  09/20/11   hnguyen          STGAP00017011: MR-092 added findSiblingByIdPersonByIdCase        
 * </pre>
 */
public class SiblingDAOImpl extends BaseDAOImpl implements SiblingDAO {
	/**
         * Find the sibling group id for the given idPerson
         * 
         * @param idPerson
         * @return
         */
  public Integer findSiblingGroupIdByIdPerson(int idPerson) {
    Query query = getSession().createQuery(
                                           " select s.id.siblingGroup.idSiblingGroup " + " from Sibling s "
                                                           + " where s.id.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);
    return (Integer) firstResult(query);
  }

  /**
   * Find sibling with the specfied person id
   * 
   * @param idPerson
   * @return Sibling
   */
  @SuppressWarnings( { "unchecked" })
  public Sibling findSiblingByIdPerson(int idPerson) {
    Query query = getSession().createQuery(" from Sibling where id.person.idPerson = :idPerson");
    query.setInteger("idPerson", idPerson);

    return (Sibling) firstResult(query);
  }

  @SuppressWarnings ({"unchecked"})
  public List<Integer> findSiblingsByIdSiblingGroup(int idSiblingGroup) {
    Query query = getSession().createQuery(" select id.person.idPerson from Sibling where id.siblingGroup.idSiblingGroup = :idSiblingGroup");
    query.setInteger("idSiblingGroup", idSiblingGroup);

    return (List<Integer>) query.list();

  }

  /**
   * Delete sibling with the specified sibling Id
   * 
   * @param idSiblingGroup
   * @return int
   */
  public int deleteSiblingsByIdSiblingGroup(int idSiblingGroup) {
    Query query = getSession().createQuery("delete Sibling s " + " where s.id.siblingGroup.idSiblingGroup = idSiblingGroup");

    query.setInteger("idSiblingGroup", idSiblingGroup);
    return query.executeUpdate();
  }

  /**
   * Delete sibling with the specified sibling Id
   * 
   * @param idSiblingGroup
   * @return int
   */
  public int deleteSiblingsByIdSiblingGroupsList(Collection idSiblingGroups) {
    Query query = getSession().createQuery("delete Sibling s " + " where s.id.siblingGroup.idSiblingGroup in (:idSiblingGroups)");

    query.setParameterList("idSiblingGroups", idSiblingGroups);
    return query.executeUpdate();
  }

  /**
   * Save Sibling record
   * 
   * @param sibling
   */
  public void saveSibling(Sibling sibling) {
    getSession().saveOrUpdate(sibling);
  }

  /**
   * Find sibling with the specfied person id and case
   * 
   * @param idPerson
   * @param idCase
   * @return Sibling
   */
  @SuppressWarnings( { "unchecked" })
  public Sibling findSiblingByIdPersonByIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery(" from Sibling " +
    		" where id.person.idPerson = :idPerson " +
    		" and id.siblingGroup.capsCase.idCase = :idCase ");
    
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);

    return (Sibling) query.uniqueResult();
  }

}