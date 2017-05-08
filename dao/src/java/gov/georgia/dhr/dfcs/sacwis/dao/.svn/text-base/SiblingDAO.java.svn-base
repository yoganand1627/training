package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;

import java.util.Map;

import org.hibernate.Query;

import gov.georgia.dhr.dfcs.sacwis.db.Sibling;

/**
 * The SiblingDAO is used to perform database operations on the sibling table
 * 
 * 
 * @author Ronnie Phelps, October 7, 2008
 * 
 * <PRE>
 * 
 * Date        Updated by      Description
 * ---------   ------------    -------------------------------------
 * 05/15/09    hjbaptiste      STGAP00013455: Added findSiblingsByIdSiblingGroup() method to retrieve the person ids 
 *                             of all children in a sibling group  
 * 09/20/11    hnguyen         STGAP00017011: MR-092 added findSiblingByIdPersonByIdCase        
 * </PRE>
 */
public interface SiblingDAO {
	
	
   /**
    * Find the sibling group id for the given idPerson
    * 
    * @param idPerson
    * @return
    */	
  Integer findSiblingGroupIdByIdPerson(int idPerson);
  
  
  /**
   * Find sibling with the specfied person id
   * 
   * @param idPerson 
   * @return Sibling
   */
   Sibling findSiblingByIdPerson(int idPerson);
   
   
   /**
    * Find all siblings in a sibling group with the specified sibling group id
    * 
    * @param idSiblingGroup
    * @return list of person id of all of the siblings in the group
    */
   List<Integer> findSiblingsByIdSiblingGroup(int idSiblingGroup);

   
   /**
    * Delete sibling with the specified sibling Id
    * @param idSiblingGroup
    * @return int
    */
   int deleteSiblingsByIdSiblingGroupsList(Collection idSiblingGroups); 

   
   /**
    * Save Sibling record
    * 
    * @param sibling
    */
   void saveSibling(Sibling sibling);

   /**
    * Find sibling with the specfied person id and case
    * 
    * @param idPerson
    * @param idCase
    * @return Sibling
    */
   Sibling findSiblingByIdPersonByIdCase(int idPerson, int idCase);
}