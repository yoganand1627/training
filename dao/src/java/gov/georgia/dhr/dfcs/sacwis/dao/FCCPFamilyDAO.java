package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.List;

import java.util.Date;
import gov.georgia.dhr.dfcs.sacwis.db.FccpFamily;

/*** Change History:
 **  Date        User              Description
 **  --------    ----------------  --------------------------------------------------
 *   04/29/2009  bgehlot           STGAP00012833: Added the method findEarliestDtCurrRevByIdCase
 *   07/30/2009  hjbaptiste        STGAP00014954: Added method CountApprvPrimPermPlanGoalByCaseAndCdPrimPermPlan()
 *   06/20/2011  hnguyen           SMS#109631: CAPTA 4.3 Added findLatestApprovedFCCPFamilyByIdPersonForOpenFsuStage(idPerson).
 *   11/14/2011  schoi             STGAP00017578: ECEM 5.0 Added method findLatestApprovedFCCPFamilyByIdPerson 
 */

public interface FCCPFamilyDAO {
  /**
   * 
   * @param idEvent
   * @return
   */
  public FccpFamily findFCCPFamilyByIdEvent(int idEvent);

  /**
   * 
   * @param fccpFamily
   * @return
   */
  int saveFccpFamily(FccpFamily fccpFamily);

  /**
   * 
   * @param idEventCurr
   * @param idCase
   * @return
   */
  String findPrevPrimaryPermanencyPlanGoal(int idCase, Collection<Integer> principalsForEvent);
  
  /**
   * Finds a list of approved FccpFamilyDetail events by the passed in code Primary Permanency Plan
   * 
   * @param idCase
   * @param cdPrimPermPlan
   * @param principalsForEvent
   * @return
   */
  Integer CountApprvPrimPermPlanGoalByCaseAndCdPrimPermPlan(int idCase, String cdPrimPermPlan, Collection<Integer> principalsForEvent);
  
  /**
   * 
   * @param idStage
   * @return
   */
  Date findDtLastUpdate(int idStage,int idEvent);
  
  /**
   * Return the version number for the template of the form
   * @param idStage
   * @param idEvent
   * @return Integer
   */
  Integer findFCCPFormVersion(int idStage,int idEvent);
  
  /**
   * Return the form data for
   * @param idStage
   * @param idEvent
   * @return byte[]
   */
  byte[] retrieveFCCPForm(int idStage,int idEvent);
  
  /** 
   * //STGAP00012833: Gets the minimum dtCurrRev for a case
   * @param idCase
   * @return Date
   */
  Date findEarliestDtCurrRevByIdCase(int idCase, Date dtRemoval );
  
  /**
   * Retrieves all FccpFamilyPlan records for the given person in the given stage 
   * 
   * @param idPerson
   * @param idStage
   * @param cdEventType
   * @param cdEventStatuses
   * @return
   */
  public List<FccpFamily> findFCCPFamilyByIdPersonByEventStatusByIdStage(int idPerson, int idStage, String cdEventType, Collection<String> cdEventStatuses);
  
  /**
   * Retrieves latest FccpFamilyPlan record for the given person 
   * 
   * @param idPerson
   * @return FccpFamily
   */
  FccpFamily findLatestApprovedFCCPFamilyByIdPersonForOpenFsuStage(int idPerson);

  /**
   * Retrieves latest FccpFamilyPlan record for the given person 
   * 
   * @param idPerson
   * @return FccpFamily
   */
  FccpFamily findLatestApprovedFCCPFamilyByIdPerson(int idPerson);
  
  /**
   * Retrieves latest FccpFamilyPlan record for the given case
   *  
   * @param idCase
   * @return
   */
  public FccpFamily findAprvFCCPFamilyByIdCase(int idCase);
}
