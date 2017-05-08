/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;

import java.util.List;

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
public interface SiblingGroupDAO {

  /**
   * Find all Sibling Groups for a specified case
   * 
   * @param idCase
   * @return List<SiblingGroup>
   */
  List<SiblingGroup> findSiblingGroupByIdCase(int idCase);

  /**
   * find all sibling group ids for the given case.
   * 
   * @param idCase
   * @return List<Integer>
   */
  List<Integer> findSiblingGroupIdsByIdCase(int idCase);

  /**
   * Save the siblingGroup record to the database
   * 
   * @param SiblingGroup
   */
  void saveSiblingGroup(SiblingGroup siblingGroup);

  /**
   * This method retrieves the Sibling Group record for the given sibling group Id.
   * 
   * @param idSiblingGroup
   * @return
   */
  SiblingGroup findSiblingGroupByIdSiblingGroup(int idSiblingGroup);
	 
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
  int updateNumberValuesByIdSiblingGroup(int idSiblingGroup, int nbrInGroup,int nbrAvailable);
	 
  /**
   * delete the given sibling group record.
   * 
   * @param siblingGroup
   */
  void deleteSiblingGroup(SiblingGroup sibling);
		   
}
