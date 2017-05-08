/**
 * Created on Mar 25, 2006 at 2:28:44 PM by Michael K. Werle
 *
 * 
 * EmpTempAssignDAO interface
 * <p/>
 * <p/> 
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   07/24/2008  alwilliams        STGAP00008071 - Added method countPersonByIdPersonDesigneeByPersonByIdPersonEmp
 *                                 
 */ 
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;

public interface EmpTempAssignDAO {
  
  /**
   * Returns a count of all of an employee's designators (assignees of) (given ID PERSON DESIGNEE) not equal to a given ID PERSON.
   *
   * @param idPerson
   * @param idPersonDesignee
   * @return
   */
  long countPersonByIdPersonEmpByPersonByIdPersonDesignee(int idPerson, int idPersonDesignee);

  /**
   * Returns a count of all of an employee's assignees (given ID PERSON DESIGNEE) not equal to a given ID PERSON.
   *
   * @param idPerson
   * @param idPersonDesignee
   * @return
   */
  long countPersonByIdPersonDesigneeByPersonByIdPersonEmp(int idPerson, int idPersonDesignee);  
  
  /**
   * This retrieves the IDs of the current user's temporary assignments.
   * <p/>
   *
   * @param idPerson
   * @return
   */
  @SuppressWarnings({"unchecked"})
  List<EmpTempAssign> findIdsTempAssignment(int idPerson);

  /**
   * This retrieves a list of designee assignments for the given employee
   * <p/>
   *
   * @param idPerson
   * @return List of EmpTempAssign by idPerson
   */
  @SuppressWarnings({"unchecked"})
  List<EmpTempAssign> findIdsemp(int idPerson);
  
  /**
   * This retrieves a list of designee assignments for the given employee. Expired designees
   * are optionally returned.
   * <p/>
   *
   * @param idPerson
   * @param idPersonDesignee
   * @return List of EmpTempAssign by idPerson
   */
  @SuppressWarnings({"unchecked"}) 
  List<EmpTempAssign> findIdsemp(int idPerson, String bIndPersonIDInvalid);


  /**
   * This retrieves a list of all employees who the employee may act as, as well as the expiration date of the
   * assignment.
   * <p/>
   *
   * @param idPerson
   * @return List of EmpTempAssign by idPerson
   */
  @SuppressWarnings({"unchecked"})
  List<EmpTempAssign> findEmpTempAssignmentDesignatorsByIdPerson(int idPerson);

  /**
   * This retrieves a list of all empTempAssign records by primary key who the employee may act as, 
   * as well as the expiration date of the assignment.
   * <p/>
   *
   * @param idEmpTempAssign
   * @return List of EmpTempAssign by idPerson
   */  

  public void saveEmpTempAssign(EmpTempAssign empTempAssign);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign} object to the database.
   * 
   * @param dtNewExpiration
   */

  int deleteEmpTempAssignByIdPerson(int idPerson);

  /**
   * Deletes an EmpTempAssign record from the DB.
   *
   * @param idEmpTempAssign
   * @param dtLastUpdate
   */
  int deleteEmpTempAssign(int idEmpTempAssign, Date dtLastUpdate);
}
