/**
 * Created on Mar 25, 2006 at 2:13:28 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.CaseMerge;
/**
 * This is the DAO class is used for the CASE_MERGE table
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  02/09/12  htvo      STGAP00017831: MR-102 - Added method 
 *                      - findActiveIdCaseMergeFromByIdCaseMergeTo
 *                      - findIdCaseMergeFromByIdCaseCdStageCdStageReasonClosed
 *  03/14/12  htvo      STGAP00017996: Added findStageMergeFromByIdCaseMergeFrom(Collection<Integer> idCaseMergeFromList)                    
 * </pre>
 */
public interface CaseMergeDAO {
  /**
   * This selects a list of row from CaseMerge given the idCaseMergeFrom. <p/>
   *
   * @param idCaseMergeFrom
   * @return CaseMerge
   */
  List<CaseMerge> findByIdCaseMergeFrom(int idCaseMergeFrom);

  /**
   * This selects a row from CaseMerge given the idCaseMergeTo. <p/>
   *
   * @param idCaseMergeTo
   * @return CaseMerge
   */
  List<CaseMerge> findByIdCaseMergeTo(int idCaseMergeTo);
  
  /**
   * This find all id cases that have been directly merged to a case and have not been split.
   * @param idCaseMergeTo
   * @return
   */
  List<Integer> findActiveIdCaseMergeFromByIdCaseMergeTo(int idCaseMergeTo);
  
  /**
   * Find list of merge-from stage from the given merge-from case list
   * @param idCaseMergeFromList
   * @return
   */
  List<Integer> findStageMergeFromByIdCaseMergeFrom(Collection<Integer> idCaseMergeFromList);
  
  /**
   * This find case merged from id from a given set of case ids, cd stage, and stage reason closed.
   * @param idCases
   * @param cdStages
   * @param cdStageReasonClosed
   * @return
   */
  List<Integer> findIdCaseMergeFromByIdCaseCdStageCdStageReasonClosed(Collection<Integer> idCases,
                                                                             Collection<String> cdStages,
                                                                             Collection<String> cdStageReasonClosed);

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.CaseMerge} object to the database.<p/>
   *
   * @param caseMerge A populated {@link gov.georgia.dhr.dfcs.sacwis.db.CaseMerge} object.
   */
  void saveCaseMerge(CaseMerge caseMerge);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.CaseMerge} object.
   *
   * @param idCaseMerge, dtLastUpdate
   */
  int deleteCaseMergeSafe(int idCaseMerge, Date dtLastUpdate);

  /**
   * Select of all merged cases for one case (MERGED_TO cases).
   * <p/>
   *
   * @param idCase
   * @return CaseMerge
   */
  List<Object[]> findCaseMerge(int idCase);

  /**
   * Select of all merged cases for one case (MERGED_FROM cases).
   * <p/>
   *
   * @param idCase
   * @return CaseMerge
   */
  List<Object[]> findCaseMergeFrom(int idCase);
}
