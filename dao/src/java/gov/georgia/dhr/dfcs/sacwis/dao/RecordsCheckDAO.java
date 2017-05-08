/**
 * Created on Mar 25, 2006 at 3:20:18 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  06/23/09  bgehlot    STGAP00014329: Added the method findCompletedRecordsCheckByIdRecCheckPerson, 
 *                       findCompletedRecordsCheckByIdRecCheckPersonOverAge18
 *  02/28/11  hnguyen    SMS#97850: Added method findLatestCompletedRecordsCheckByIdRecCheckPersonByCdRecCheckCheckType(idPerson, cdRecCheckType).
 * </pre>
 */

public interface RecordsCheckDAO {
  public Map findRecordsChecksByIdRecChecks(Collection<Integer> idRecCheckList);
  
  public List<RecordsCheck> findRecordsChecksByDtStageStartPersonsType(Date dtStageStart, Collection<Integer> idPersonList, List<String> nonLegTypesList);
  
  public List<RecordsCheck> findRecordsChecksByIdPersonsType(Collection<Integer> idPersonList, List<String> legTypesList);
  
  /**
   * This selects rows from RecordsCheck given the personByIdRecCheckPerson.
   * <p/>
   * It has to return a list of object arrays instead of just a {@link gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck}
   * object because the nmPersonFull String is also needed.  The former is in the first element in the array, and the
   * latter is in the second element.
   *
   * @param personByIdRecCheckPerson
   * @param pageNbr
   * @param pageSize
   * @return See description.
   */
  public PaginatedHibernateList<Object[]> findRecordsCheck(int personByIdRecCheckPerson, int pageNbr, int pageSize);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck} object to the database.
   *
   * @param recordsCheck A populated {@link gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck} object.
   */
  void saveRecordsCheck(RecordsCheck recordsCheck);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck} object.
   *
   * @param idRecCheck
   */
  public int deleteRecordsCheck(int idRecCheck, Date dtLastUpdate);
  
   /**
   * Updates the Records in RecordsCheck Table. Sets the ID_STAGE column to NULL
   * for all the records corresponding to this stage, this will allow 
   * deletion of STAGE table records 
   */
  // (added for resolving  defect # STGAP00007496
  public int updateRecordsCheckIdStage(int stage);
  
  /**
   *  //STGAP00014329: Retrieve Completed records check for idPerson and idCase
   * @param personByIdRecCheckPerson
   * @return
   */
  String findCompletedRecordsCheckByIdRecCheckPerson(int personByIdRecCheckPerson);
  
  /**
   * STGAP00014329: Retrieves completed records check for idPerson who are over 18 years
   * @param personByIdRecCheckPerson
   * @return
   */
  String findCompletedRecordsCheckByIdRecCheckPersonOverAge18(int personByIdRecCheckPerson);
  
  /**
   * MR-072 Return Y if all the ten type of records check are done for person equal or over 17 years of age who is principal or
   * member of PK household
   * @param personByIdRecCheckPerson
   * @return
   */
  String findCompletedRecordsCheckByIdRecCheckPersonOverAge17(int personByIdRecCheckPerson);
  
  /**
   * MR-072 Return Y if all the ten type of records check are done for person under 17 years of age who is principal or
   * member of PK household
   * @param personByIdRecCheckPerson
   * @return
   */
  String findCompletedRecordsCheckByIdRecCheckPersonUnderAge17(int personByIdRecCheckPerson);
  
  /**
   * SMS 69955 Use new Records Check to see if records check are completed for submitting Safety REsource
   * @param personByIdRecCheckPerson
   * @return
   */
  String findCompletedRecordsCheckNewCodesByIdRecCheckPerson(int personByIdRecCheckPerson);
  
  /**
   * SMS#97850: Find latest completed record check by IdRecCheckPerson and cdRecCheckCheckType 
   * @param personByIdRecCheckPerson
   * @return
   */
  public RecordsCheck findLatestCompletedRecordsCheckByIdRecCheckPersonByCdRecCheckCheckType(int personByIdRecCheckPerson, String cdRecCheckCheckType);

}
