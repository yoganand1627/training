/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingGroupDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Sibling;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

/**
 * The SiblingGroupDAO is used to perform database operations on the sibling table
 * 
 * 
 * @author Ronnie Phelps, October 7, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by                Description
 * ---------   ------------              -------------------------------------
 * 
 * </PRE>
 */
public class SiblingGroupDAOImpl extends BaseDAOImpl implements SiblingGroupDAO {

  /**
   * Find all Sibling Groups for a specfied case
   * 
   * @param idCase
   * @return List<SiblingGroup>
   */
  @SuppressWarnings( { "unchecked" })
  public List<SiblingGroup> findSiblingGroupByIdCase(int idCase) {
    Query query = getSession().createQuery(" from SiblingGroup where capsCase.idCase = :idCase");
    query.setInteger("idCase", idCase);
	
    return (List<SiblingGroup>) query.list();
  }
  
  /**
   * find all sibling group ids for the given case.
   * 
   * @param idCase
   * @return List<Integer>
   */
  @SuppressWarnings( { "unchecked" })
  public List<Integer> findSiblingGroupIdsByIdCase(int idCase) {
    Query query = getSession().createQuery(
                                           " select idSiblingGroup from SiblingGroup "
                                                           + " where capsCase.idCase = :idCase ");

    query.setInteger("idCase", idCase);
    return (List<Integer>) query.list();
  }

  /**
   * Save the siblingGroup record to the database
   * 
   * @param SiblingGroup
   */
  public void saveSiblingGroup(SiblingGroup siblingGroup) {
    getSession().saveOrUpdate(siblingGroup);
  }

  /**
   * find siblingGroup record by idSiblingGroup
   * 
   * @param idSiblingGroup
   * @param SiblingGroup
   */
  public SiblingGroup findSiblingGroupByIdSiblingGroup(int idSiblingGroup) {
    Query query = getSession().createQuery(
                                           "  from SiblingGroup "
                                                           + " where idSiblingGroup = :idSiblingGroup ");

    query.setInteger("idSiblingGroup", idSiblingGroup);
    return (SiblingGroup) query.uniqueResult();
  }
  
  /**
   * update the number available for adoption and number of children in group fields for the 
   * given idSiblingGroup.
   * 
   * @param idSiblingGroup
   * @param nbrInGroup
   * @param nbrAvail
   * 
   * @return int
   */
  public int updateNumberValuesByIdSiblingGroup(int idSiblingGroup, int nbrInGroup,int nbrAvail){
	    Query query = getSession()
        .createQuery(
                     "update SiblingGroup sg "
                                     + "   set " 
                                     + " sg.nbrInGroup = :nbrInGroup, "
                                     + " sg.nbrAvail = :nbrAvail "
                                     + " where sg.idSiblingGroup = :idSiblingGroup");
	    query.setInteger("nbrInGroup", nbrInGroup);
	    query.setInteger("nbrAvail", nbrAvail);
	    query.setInteger("idSiblingGroup", idSiblingGroup);
	    return query.executeUpdate();
  }
  
  /**
   * delete the given sibling group record.
   * 
   * @param siblingGroup
   */
  public void deleteSiblingGroup(SiblingGroup siblingGroup) {
	  getSession().delete(siblingGroup);
  }

}
