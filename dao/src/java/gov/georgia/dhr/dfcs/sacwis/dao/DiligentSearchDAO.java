package gov.georgia.dhr.dfcs.sacwis.dao;


import java.util.List;
import gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch;

public interface DiligentSearchDAO {

  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.DiligentSearch} object to the database.
   * 
   * @param DiligentSearch
   *          A populated {@link DiligentSearch} object.
   */
  void saveDiligentSearchInfo(DiligentSearch diligentSearch);

  /**
   * Retrieves all Diligent Search info from the Diligent_Search table <p/>
   * 
   * @param idPersonSearch
   * @return List of records.
   */
  // @SuppressWarnings({"unchecked"})
  List<DiligentSearch> findDiligentSearchInfo(int idPersonSearch);

  /**
   * Retrieves all Diligent Search info from the Diligent_Search table <p/>
   * 
   * @param idCase
   * @return List of records.
   */
  // @SuppressWarnings({"unchecked"})
  List<DiligentSearch> findDiligentSearchInfoBasedOnCaseId(int idCase);

  /**
   * Retrieves all Diligent Searches made within a case on behave of a specific person being researched<p/>
   * 
   * @param idCase
   * @return List of records.
   */
  List<DiligentSearch> findDiligentSearchInfoBasedOnCaseIdByIdPersonDtl(int idCase, int idPersonSrch);
  
  /**
   * Retrieves all Diligent Searches made within a case on behave of a stage and of a specific person being researched<p/>
   * 
   * @param idCase
   * @return List of records.
   */
  List<DiligentSearch> findDiligentSearchInfoBasedOnCaseIdStageIdByIdPersonDtl(int idCase, int idStage, int idPersonSrch);
  
  /**
   * Retrieves all Diligent Search Info from the Diligent_Search table for the case and the list of children <p/>
   * 
   * @param idCase
   * @param idPersonSrch
   * @return
   */
  List<DiligentSearch> findDiligentSearchInfoBasedOnCaseIdByListOfIdPersonSearch(int idCase, List<Integer> idPersonSrch);
  
  /**
   * Retrieves all Diligent Search Info from the Diligent_Search table for the case and the list of children and the id
   * of the Contacted person. <p/>
   * 
   * @param idCase
   * @param idPersonSrch
   * @param idPersonDtl
   * @return
   */
  List<DiligentSearch> findDiligentSearchInfoByCaseIdByIdpersonSeachByIdPersonDtl(int idCase, List<Integer> idPersonSrch, int idPersonDtl);
  
  /**
   * Retrieves all Diligent Search Info from the Diligent_Search table given Diligent Search id. <p/>
   * 
   * @param idDiligentSearch
   * @return 
   */
  // @SuppressWarnings({"unchecked"})
  DiligentSearch findDiligentSearchInfoBasedOnId(int idDiligentSearch);

  /**
   * This returns the number of records already existing for child
   * 
   * @param idPersonDetail
   * @param idPersonSearch
   * @return The number of records.
   */
  long countExistingRecord(int idPersonDetail, int idPersonSearch);

}
