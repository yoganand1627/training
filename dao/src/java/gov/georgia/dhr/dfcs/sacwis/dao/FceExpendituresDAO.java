package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.FceExpenditures;

public interface FceExpendituresDAO {

  /**
   * Updates FceExpenditures by IdPerson
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   * @return
   */
  int updateFceExpendituresIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage);
  
  /**
   * Saves FceExpenditures
   */
  void saveFceExpenditures(FceExpenditures fceExpenditures);
  
  /**
   * Retrieves FceExpenditures by idFceExpenditures
   * @param idFceExpenditures
   * @return FceExpenditures
   */
  public FceExpenditures findFceExpendituresByIdFceExpenditures(long idFceExpenditures);
  
  /**
   * Retrieves FceExpenditures by idFceExpenditures, idFcePerson, idPerson
   * @param idFceExpenditures, idFcePerson, idPerson
   * @return FceExpenditures
   */  
  public FceExpenditures findFceExpendituresByIdFceEligibilityByIdFcePersonByIdPerson(long idFceExpenditures,
                                                                                      long idFcePerson,
                                                                                      long idPerson);
  
  /**
   * Deletes FceExpenditures by idFceEligibility
   * @param idFceEligibility
   * @return FceExpenditures
   */ 
  public void deleteFceExpenditures(long idFceEligibility);
  
  /**
   * Finds all expenditures for an FCE Application
   * @param idFceEligibility
   * @return List<FceExpendituresDB>
   */
  public List<FceExpenditures>  findAllFceExpenditures(long idFceEligibility);
}
