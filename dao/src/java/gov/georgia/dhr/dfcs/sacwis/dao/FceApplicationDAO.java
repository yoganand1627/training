/**
 * Created on Mar 25, 2006 at 2:46:13 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.FceApplication;

public interface FceApplicationDAO {
  /**
   * Updates table FceApplication, field idPerson given idPersMergeClosed and idStage
   *
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idStage
   */
  int updateFceApplicationIdPerson(int idPersMergeForward, int idPersMergeClosed, int idStage);
  
  
  /**
   * 
   * @param eventList
   * @return
   */
  FceApplication findFceApplicationByEventList(Collection<Integer> eventList);
  
  /**
   * Retrieves the row from the FCE_APPLICATION table that has the most recent Date Complete
   * for a particular Stage
   * 
   * @param idStage
   * @return FceApplication
   */
  FceApplication findLatestCompleteFceApplication(long idStage);
  
  /**
   * Finds list of Fce Placements based on stage id
   *
   * @param idStage
   * @return
   */
  List<Map> findPlacementByIdStageAndIdEvent(int idStage, String cdTask);
  
  /**
   * Retrieves a row from the FCE_APPLICATION table based on the idApplicationEvent
   *
   * @param idApplicationEvent
   * @return FceApplication
   */
  FceApplication findFceApplicationByIdApplicationEvent(long idApplicationEvent);
  
  FceApplication findFceApplicationByIdFceApplication(long idFceApplication);
  
  void updateFceApplicationByIndEvalConclusion(long idFceApplication,String indEvaluationConclusion);
  
  /**
   * Updates the FCE Application to indicate if it is an Initial Application or a Notice of Change
   * @param idFceApplication
   * @param cdApplication
   * @return int representing the number of rows updated
   */
  int updateFceApplicationCdApplication(long idFceApplication,String cdApplication);
  
  /**
   * This updates a row in the FCE_APPLICATION table with NbrLivingAtHome
   * @param idFceApplication
   * @param nbrLivingAtHome
   * @return Integer indication how many rows were updated
   */
  int updateFceAppliationByNbrLivingAtHome(long idFceApplication,long nbrLivingAtHome);
  
  /**
   * This updates a row in the FCE_APPLICATION table with Removal Address Fields
   * @param idFceApplication
   * @param addrRemovalStLn1
   * @param addrRemovalStLn2
   * @param addrRemovalCity
   * @param cdRemovalAddrState
   * @param addrRemovalAddrZip
   * @param cdRemovalAddrCounty
   * @return void
   */
  void updateFceApplicationRemovalAddress(long idFceApplication, String addrRemovalStLn1, String addrRemovalStLn2,
                                          String addrRemovalCity, String cdRemovalAddrState, String addrRemovalAddrZip, String cdRemovalAddrCounty);
  
  void saveFceApplication(FceApplication fceApplication);
  
  /**
   * 
   * @param eventList
   * @return FceApplication 
   */
  public FceApplication findLatestFceApplicationInitialAmendedByEventList(Collection<Integer> eventList);
}
