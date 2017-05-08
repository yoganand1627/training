/**
 * Created on Mar 25, 2006 at 3:06:20 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;

/**Change History:
 * 
 * Date           User            Description
 * --------       --------------  --------------------------------------------------
 * 03/31/2009     bgehlot         STGAP00012833: Added the method findLegalActionBycdHrTypCrtOrd,
 *                                findLegalActionBycdHrTypCrtOrdAndcdOutcomes
 * 06/30/2009     bgehlot         STGAP00014329: Added the method findLegalActionBycdLegalActAction, findLegalActionBycdHrTypCrtOrd
 * 07/29/2009     hjbaptiste      STGAP00014895: Added findInitialTprVsLegalActionsForCase()
 * 11/12/2009     arege           SMS#37448 : Wrote new method findLegalActionListByIdCaseByIdPersonByCdActionsByCdHrTypCrtOrds that will find legal action for
 *                                given person in a given case where cdLegalActActions (Action drop down on page) is one of the VS (Voluntary Surrender) OR
 *                                cdHrTypCrtOrds (Hearing Type/Court Order ) is one of the TPR's with cdOutcome of TPG OR
 *                                legal action with outcome of DPC   
 * 01/06/2010     pcoogan         Added new method findInitialTprVsLegalActionsListForCase to get the TPR events 
 *                                in a list form    
 * 11/30/2010     arege           SMS#82989/65873: Added method findLegalActionByIdCaseByIdPerson 
 * 12/12/2010     hjbaptiste      SMS#81144: MR-053 Eligibility changes. Added findFirstBestIntestLegalActionsForCaseForFCE, 
 *                                findFirstRemovalEffortsLegalActionsForCaseForFCE, findCustodyGrantedLegalActionForCaseForFCE
 * 12/12/2010      hnguyen        SMS#81144: MR-053 Added method findLegalActionsByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds 
 *                                to retrieve legal actions in a given case for a given person by legal action type and 
 *                                hearing type/court order
 * 02/11/2011     hnguyen          SMS#95590: Added new method findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson.
 * 02/21/2011     htvo            SMS#97845 MR-072-2: added method findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson                
 * 02/28/2011     schoi           SMS #97845: MR-074-2 Added Voluntary Surrender-Putative Father (CLEGCPS_VPF) 
 *                                and TPR-Putative Father (CLHECOT_TPP) to the condition in the new findLegalActionListForAllVSTpr method
 * 03/07/2011     schoi           SMS #97845: MR-074-2 Added new method findLegalActionBycdHrTypCrtOrdOrderByDtCrtActDate 
 * 03/08/2011     schoi           SMS #97845: MR-074-2 Added new method findTheMostRecentTprVsLegalActionsDateForCase
 * 03/10/2011     schoi           SMS #97845: MR-074-2 Replaced the method findLegalActionBycdHrTypCrtOrdOrderByDtCrtActDate 
 *                                to a new method findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds for better re-usability
 * 03/17/2011     schoi           SMS #97845: MR-074-2 Added new method findTheMostRecentDateTprAchievedLegalActionsDateForCase
 *                                 for finding the Date of TPR/VS Achieved in FCCP Form and CPRS Interface                                
 * 03/31/2011     htvo            SMS #97845: MR-074-2 Removed outcome parameter from findTheMostRecentDateTprAchievedLegalActionsDateForCase
 * 04/11/2011     hnguyen         SMS#103401: MR-074-2 Removed findLegalActionByIdStageByIdPersonBycdActionsByCdOutcomes method due to inaccuracy and redundancy.
 * 08/24/2011     hnguyen         STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
 *                                and not look at the legal actions across the AU.
 * 08/31/2011     hnguyen         STGAP00017008: Corrected Reasonable effort issue and custody granted outcome to look from removal date and onward.
 * 
*/

public interface LegalActionDAO {
  /**
   * The following constants are to be used as the keys to a Map which contains the data for updating a legal action.
   * Instead of populating a LegalAction object and passing that to the DAO for updating, populate a Map using these
   * constants as keys and pass the Map to the DAO for updating a legal action.
   */
  public static final String KEY_ID_PERSON = "idPerson";

  public static final String KEY_CD_LEGAL_ACT_ACTION = "cdLegalAction";

  public static final String KEY_CD_LEGAL_ACT_ACTN_SUBTYPE = "cdSubtype";

  public static final String KEY_CD_LEGAL_ACT_OUTCOME = "cdOutcome";

  public static final String KEY_DT_LEGAL_ACT_DATE_FILED = "dtDateFiled";

  public static final String KEY_DT_LEGAL_ACT_OUTCOME_DT = "dtOutcomeDt";

  public static final String KEY_IND_LEGAL_ACT_DOCS_N_CASE = "indDocsNCase";

  public static final String KEY_TXT_LEGAL_ACT_COMMENT = "txtComment";

  public static final String KEY_NBR_CRT_FILE = "nbrCrtFile";

  public static final String KEY_CD_CRT_TYPE = "cdCrtType";

  public static final String KEY_DT_NXT_HEAR_DATE = "dtNxtHearDate";

  public static final String KEY_DT_CONTIN_DATE = "dtContinDate";

  public static final String KEY_DT_CRT_ORD_DATE = "dtCrtOrdDate";

  public static final String KEY_DT_PUB_DATE = "dtPubDate";

  public static final String KEY_CD_COUNTY = "cdCounty";

  public static final String KEY_DT_CRT_ACT_DATE = "dtCrtActDate";

  public static final String KEY_CD_HR_TYP_CRT_ORD = "cdHrTypCrtOrd";

  public static final String KEY_CRT_CASE_NBR = "txtCrtCaseNbr";

  public static final String KEY_IND_UP_PREV_ACT = "indUpPrevAct";

  public static final String KEY_IND_COMPLETE = "indComplete";

  /**
   * Select the LegalAction by passing the primary key
   * 
   * @param idLegalActEvent
   * @return LegalAction
   */
  public LegalAction findLegalActionByIdLegalActEvent(int idLegalActEvent);

  /**
   * Select the latest LegalAction withing a case for an idPerson, a specific cdLegalActAction and a cdHrTypCrtOrd
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActAction
   * @param cdHrTypCrtOrd
   * @return LegalAction
   */
  public LegalAction findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrd(int idCase, int idPerson,
                                                                                String cdLegalActAction,
                                                                                String cdHrTypCrtOrd);

  /**
   * Select the latest Approved or completed LegalAction within a case for an idPerson, a legal action and a list of
   * cdHrTypCrtOrd
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActAction
   * @param cdHrTypCrtOrds
   * @return LegalAction
   */
  LegalAction findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(int idCase, int idPerson,
                                                                                String cdLegalActAction,
                                                                                Collection<String> cdHrTypCrtOrds,
                                                                                String orderBy);

  /**
   *  Selects all completed or Approved Legal Actions within a case for an id person and a list outcomes
   * @param idCase
   * @param idPerson
   * @param cdOutcomes
   * @return List<LegalAction>
   */
  public List<LegalAction> findLegalActionListByIdCaseByidPersonBycdOutcomes(int idCase, int idPerson, String[] cdOutcomes);
  
  /**
   * Select the latest approved or completed LegalAction withing a case for an idPerson, a list of cdLegalActActions or
   * a list of cdOutcomes. Avoid duplicates
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdOutcomes
   * @return LegalAction
   */
  public LegalAction findLatestLegalActionByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                     int idCase,
                                                                                     int idPerson,
                                                                                     Collection<String> cdLegalActActions,
                                                                                     String[] cdOutcomes);
  
  
  
  /**
   * Selects the latest approved or completed LegalAction without the case constraint for an idPerson, and list of cdOutcomes.
   * @param idPerson
   * @param cdOutcomes
   * @return List<LegalAction>
   */
  public List<LegalAction> findLegalActionLatestObjectsByIdPersonByCdOutcomes(int idPerson,Collection<String> cdOutcomes);

  /**
   * Select the latest approved or completed LegalAction withing a case for an idPerson, a list of cdLegalActActions or
   * a list of cdOutcomes. Avoid duplicates
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdOutcomes
   * @return LegalAction List
   */
  public List<LegalAction> findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                         int idCase,
                                                                                         int idPerson,
                                                                                         Collection<String> cdLegalActActions,
                                                                                         String[] cdOutcomes,
                                                                                         Collection<String> cdHrTypCrtOrds);

  /**
   * Select the latest LegalAction withing a case for an idPerson and a cdOutcome
   * 
   * @param idCase
   * @param idPerson
   * @param cdOutcome
   * @return LegalAction
   */
  LegalAction findLegalActionByIdCaseByIdPersonByCdOutcome(int idCase, int idPerson, String cdOutcome);

  /**
   * Select the latest Approved or completed LegalAction within a case for an idPerson and a cdOutcome
   * 
   * @param idCase
   * @param idPerson
   * @param cdOutcome
   * @return Map
   */
  Map findLegalActionLatestByIdCaseByIdPersonByCdOutcome(int idCase, int idPerson, String cdOutcome);

  /**
   * Select the latest Approved or completed LegalAction within a case for an idPerson and a list of cdOutcome
   * 
   * @param idCase
   * @param idPerson
   * @param cdOutcomes
   * @return Map
   */
  List<Map> findLegalActionLatestByIdCaseByIdPersonByCdOutcomes(int idCase, int idPerson, Collection<String> cdOutcomes);

  /**
   * Select the latest Approved or completed LegalAction Objects within a case for an idPerson and a list of cdOutcome
   * 
   * @param idCase
   * @param idPerson
   * @param cdOutcomes
   * @return List
   */
  List<LegalAction> findLegalActionLatestObjectsByIdCaseByIdPersonByCdOutcomes(int idCase, int idPerson,
                                                                               Collection<String> cdOutcomes);

  /**
   * Select the latest Approved or completed LegalAction within a case for an idPerson and a cdHrTypCrtOrd
   * 
   * @param idCase
   * @param idPerson
   * @param cdHrTypCrtOrd
   * @return LegalAction
   */
  LegalAction findLegalActionByIdCaseByIdPersonByCdHrTypCrtOrd(int idCase, int idPerson, String cdHrTypCrtOrd);

  /**
   * Select the latest Approved or completed LegalAction within a case for an idPerson and a list of cdHrTypCrtOrd
   * 
   * @param idCase
   * @param idPerson
   * @param cdHrTypCrtOrds
   * @return LegalAction
   */
  public List<LegalAction> findLegalActionByIdCaseByIdPersonByCdHrTypCrtOrds(int idCase, int idPerson,
                                                                             Collection<String> cdHrTypCrtOrds);

  /**
   * Select a row by LegalAction by idPerson and idCase
   * 
   * @param idPerson
   * @param idCase
   * @return Integer
   */
  List<LegalAction> findLegalActionByIdPersonAndIdCase(int idPerson, int idCase);

  /**
   * It is a count method but its true purpose is to find out whether any legal action bound to a primary child in
   * SUB/ADO stage that has TPRs outcome Applies to Family Plan pages (FCCPFamily): Event_Person_Link tables stores
   * persons on a plan
   * 
   * @param idCase
   * @param idEvent
   * @return
   */
  int findIdLegalActionByTPROutcomesPersonEvent(int idCase, Collection<Integer> principalsForEvent);

  /**
   * This is an update/insert for LegalAction info.
   * 
   * @param legalAction
   */

  void saveLegalAction(LegalAction legalAction);

  /**
   * Delete a {@link gov.georgia.dhr.dfcs.sacwis.db.LegalAction} object.
   * 
   * @param legalAction
   */
  void deleteLegalAction(LegalAction legalAction);

  /**
   * Updates table LegalAction, field idPerson given idPersMergeClosed and idEvent.<p/>
   * 
   * @param idPersMergeForward
   * @param idPersMergeClosed
   * @param idEvent
   */
  int updateLegalActionIdPerson(int idPersMergeForward, int idPersMergeClosed, int idEvent);

  Date findTprVsAchievedDate(int idCase, int idPerson); // mxpatel added this

  /**
   * Retrieve Legal action date on an approved or complete, most recent legal action record, 
   * with an action of voluntary surrender of parental rights(VS), or with a court order hearing 
   * type of termination of parental rights(TPR) and the outcome as one of the options in the
   * collection passed for a given person in a given case.<p/>
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdHrTypCrtOrds
   * @return Date
   */
  public Date findLegalActionDateByIdStageByIdPersonBycdActionsByCdOutcomes(int idCase, int idPerson,
                                                                Collection<String> cdLegalActActions,
                                                                Collection<String> cdOutcomes,
                                                                Collection<String> cdHrTypCrtOrds);
  
  /**
   * Retrieve Legal action date on an approved or complete, most recent legal action record, 
   * with a court order hearing type of termination of parental rights(TPR) and with the court  
   * type as Juvenile for a given person in a given case.<p/>
   * 
   * @param idCase
   * @param idPerson
   * @param cdHrTypCrtOrds
   * @return Date
   */
  public Date findDtCrtActByHearingTypeByCrtType(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds);
  
  /**
   * Finds the first or updated Legal Action that has the 'Contrary to Welfare' or 'Best Interest' Language
   * 
   * @param idCase
   * @param idChild
   * @param cdLegalActActions
   * @param crtOrderLang
   * @return List<LegalAction>
   */
  public List<LegalAction> findFirstBestIntestLegalActionsForCaseForFCE(int idCase, int idChild, Collection<String> cdLegalActActions, 
                                                                        String crtOrderLang);

  /**
   * Finds the first or updated Legal Action that has the 'Reasonable Efforts made' and has an outcome
   * of Custody granted
   * 
   * @param idCase
   * @param idChild
   * @param cdLegalActA
   * @param crtOrderLangs
   * @param within60DaysOfRemoval
   * @return List<LegalAction>
   */
  public List<LegalAction> findFirstRemovalEffortsLegalActionsForCaseForFCE(int idCase, int idChild, Collection<String> cdLegalActActions, 
                                                                            Collection<String> crtOrderLangs, Date removalDate);
  
  /**
   * Finds any Legal Action with an outcome of Custody Granted
   * 
   * @param idCase
   * @param idChild
   * @param cdOutcomes
   * @return
   */
  public List<LegalAction> findCustodyGrantedLegalActionForCaseForFCE(int idCase, int idChild, Collection<String> cdOutcomes, Date removalDate);
  
  /**
   * Retrieve Legal action date on an approved or complete, most recent updated legal action record, 
   * with a court order hearing type of termination of parental rights(TPR) and with the court  
   * type as Juvenile for a given person in a given case.<p/>
   * 
   * @param idCase
   * @param idPerson
   * @param cdHrTypCrtOrds
   * @return Date
   */
  public Date findLastedUdatedLegalActionDateByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                            int idCase,
                                                                            int idPerson,
                                                                            Collection<String> cdLegalActActions,
                                                                            Collection<String> cdOutcomes,
                                                                            Collection<String> cdHrTypCrtOrds);


  /**
   * Select the latest approved or completed LegalAction withing a case for an idPerson, a list of cdLegalActActions or
   * a list of cdOutcomes. Avoid duplicates and only bring back legal actions that were completed before the specified 
   * date(dtEventOccured)
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdOutcomes
   * @param dtEventOccured
   * @return LegalAction List
   */
  public List<LegalAction> findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomesBeforeDate(
          int idCase,
          int idPerson,
          Collection<String> cdLegalActActions,
          String[] cdOutcomes,
          Collection<String> cdHrTypCrtOrds,
          Date dtEventOccured);
  /**
   * Retrieves the Legal Action list for check if Adoption Dissolution is required when a legal action
   * is saved in PAD stage. See {@SaveAutoAdoStage}
   * @param idCase
   * @param idPerson
   * @param Collection<String> cdStage
   * @return List<LegalAction>
   */
  List<LegalAction> findLegalActionListForAdoptionDissolution(int idCase, int idPerson, Collection<String> cdStages);

  //SMS #97845: MR-074-2 
  /**
   * Retrieves the Legal Action list for check all Voluntary surrender and TPR Legal Actions
   * including the new Voluntary Surrender-Putative Father (CLEGCPS_VPF) 
   * and TPR-Putative Father (CLHECOT_TPP) See {@SaveAutoAdoStage}
   * @param idCase
   * @param idPerson
   * @param Collection<String> cdStage
   * @return List<LegalAction>
   */
  List<LegalAction> findLegalActionListForAllVSTpr(int idCase, int idPerson, Collection<String> cdStages);
    
  /**
   * Retrieves the Legal Action record
   * @param idCase
   * @param idPerson
   * @param cdHrTypCrtOrds
   * @return cdLegalActAction
   */
  LegalAction findDtCrtActByHearingTypeByActionType(int idCase, int idPerson,  List<String> cdHrTypCrtOrds, String cdLegalActAction);
  
//mxpatel added this for defect #STGAP00012935
  Date findFirstTprVsLegalActionByIdCaseIdPerson(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                 Collection<String> cdHrTypCrtOrds, String cdEventType,
                                                 String cdOutComeTypeTpg, String cdOutComeTypeDpc);
  
//mxpatel added this for defect #STGAP00012762 and #STGAP00012641
  long countTprVsLegalActionByIdCase(int idCase, Collection<String> cdLegalActActions,
                                     Collection<String> cdHrTypCrtOrds, String cdEventType, String cdOutComeTypeTpg,
                                     String cdOutComeTypeDpc, int idPerson);
  
  /** STGAP00012833: Retrieves the List of Aprroved or complete Legal Action for the idPerson and idCase for 
   *                 cdHrTypCrtOrd
   * @param idCase
   * @param idPerson
   * @param cdHrTypCrtOrds
   * @param cdLegalActAction
   * @return List<LegalAction>
   */
  public List<LegalAction> findLegalActionBycdHrTypCrtOrd(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds, String cdLegalActAction);

   
  /** STGAP00012833: Retrieves the List of Aprroved or complete Legal Action for the idPerson and idCase for 
                     cdHrTypCrtOrd and cdOutcomes
   * @param idCase 
   * @param idPerson
   * @param cdHrTypCrtOrds
   * @param cdOutcomes
   * @return List<LegalAction>
   */ 
  
  public List<LegalAction> findLegalActionBycdHrTypCrtOrdAndcdOutcomes(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds, Collection<String> cdOutcomes);
  
  /** 
   * //STGAP00014329: Retrieves the List of Approved or complete Legal Action for the idPerson and stage for cdLegalActAction
   * @param idStage
   * @param idPerson
   * @param cdLegalActAction
   * @return
   */
    
  LegalAction findLegalActionBycdLegalActAction(int idStage, int idPerson, Collection<String> cdLegalActAction); 
  
  /** 
   * STGAP00014329: Retrieves the List of Approved or complete Legal Action for the idPerson and stage for cdHrTypCrtOrds 
   * @param idStage
   * @param idPerson
   * @param cdHrTypCrtOrd
   * @return
   */
  
  LegalAction findLegalActionBycdHrTypCrtOrd(int idStage, int idPerson, Collection<String> cdHrTypCrtOrd); 
  

  /**
   * Retrieve the first Approved or complete Legal Action for the idPerson and stage for cdLegalActAction
   * 
   * @param idCase
   * @param idPerson
   * @param cdVsLegalActions
   * @param cdHrTypCrtOrds
   * @param cdEventType
   * @param cdOutComeTypeTpg
   * @param cdOutComeTypeDpc
   * @return
   */
  LegalAction findInitialTprVsLegalActionsForCase(int idCase, int idPerson, Collection<String> cdVsLegalActions,
                                                  Collection<String> cdHrTypCrtOrds, String cdEventType, 
                                                  String cdOutComeTypeTpg, String cdOutComeTypeDpc);
  
  /**
   * Retrieve the list of voluntary surrender and TPR legal actions ordered by court action date.  Used to
   * allow iteration to find the one that actually has the first court order date.
   * 
   * @param idCase
   * @param idPerson
   * @param cdVsLegalActions
   * @param cdHrTypCrtOrds
   * @param cdEventType
   * @param cdOutComeTypeTpg
   * @param cdOutComeTypeDpc
   * @return
   */
  List<LegalAction> findInitialTprVsLegalActionsListForCase(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                                   Collection<String> cdHrTypCrtOrds, String cdEventType, 
                                                                   String cdOutComeTypeTpg, String cdOutComeTypeDpc);
  
  // SMS #97845: MR-074-2 
  /**
   * Find the most recent Court Action/Court Order Date among all TPR and VS in the same case
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdHrTypCrtOrds
   * @param cdOutComeTypeTpg
   * @param cdOutComeTypeDpc
   * @return
   */
  Date findTheMostRecentTprVsLegalActionsDateForCase(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                                   Collection<String> cdHrTypCrtOrds, 
                                                                   String cdOutComeTypeTpg, String cdOutComeTypeDpc);
    
  // SMS #97845: MR-074-2 
  /**
   * Find the most recent Court Action/Court Order Date among all TPR and VS in the same case
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdLegalActActionsOth
   * @param cdHrTypCrtOrds
   * @param cdOutComeTypeTpg
   * @param cdOutComeTypeDpc
   * @return
   */
  Date findTheMostRecentDateTprAchievedLegalActionsDateForCase(int idCase, int idPerson,
                                                               Collection<String> cdLegalActActions,
                                                               Collection<String> cdLegalActActionsOth,
                                                               Collection<String> cdHrTypCrtOrds,
                                                               String cdOutComeTypeTpg, String cdOutComeTypeDpc);
  
  /**
   * Find if there is a legal actions for given person in a given case where cdLegalActActions (Action drop down on
   * page) is one of the VS (Voluntary Surrender) OR cdHrTypCrtOrds (Hearing Type/Court Order ) is one of the TPR's with
   * outcome of TPG OR With outcome of DPC
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActActions
   * @param cdHrTypCrtOrds
   * @param cdOutComeTypeTpg
   * @param cdOutComeTypeDpc
   * @return
   */
  public LegalAction findLegalActionListByIdCaseByIdPersonByCdActionsByCdHrTypCrtOrds(
                                                                                      int idCase,
                                                                                      int idPerson,
                                                                                      Collection<String> cdLegalActActions,
                                                                                      Collection<String> cdHrTypCrtOrds,
                                                                                      String cdOutComeTypeTpg,
                                                                                      String cdOutComeTypeDpc);
  /**
   * Select the latest Approved or completed LegalAction within a case for an idPerson, a list of
   * legal action and a list of cdHrTypCrtOrd
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActAction
   * @param cdHrTypCrtOrds
   * @return LegalAction
   */
  public LegalAction findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                int idCase,
                                                                                int idPerson,
                                                                                Collection<String> cdLegalActActions,
                                                                                Collection<String> cdHrTypCrtOrds,
                                                                                String orderBy);  
  
  Integer findIdLegalActionEventForParentalRights(int idCase, int idPerson, Collection<String> cdLegalActActions,Collection<String> cdHrTypCrtOrds, Collection<String> cdOutcomes);
  
  //SMS#82989/65873: Added method to find all legal actions in a given case for a given person
  /**
   * 
   * @param idCase
   * @param idPerson
   * @return LegalAction list
   */
  public List<LegalAction> findLegalActionByIdCaseByIdPerson(int idCase, int idPerson);

  // SMS#81144: Added method to retrieve legal actions in a given case 
  // for a given person by legal action type and hearing type/court order
  /**
   * Retrieve the list of Approved or completed LegalAction within a case for an idPerson, a list of
   * cdLegalActAction and a list of cdHrTypCrtOrd and which date field to order list by in descending order
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActAction
   * @param cdHrTypCrtOrds
   * @param orderBy
   * @return List<LegalAction>
   */
  public List<LegalAction> findLegalActionsByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                       int idCase,
                                                                                       int idPerson,
                                                                                       Collection<String> cdLegalActActions,
                                                                                       Collection<String> cdHrTypCrtOrds,
                                                                                       String orderBy);
  
  // SMS #97845: MR-074-2
  // Added method to retrieve legal actions in a given case
  // for a given person by legal action type and hearing type/court order
  /**
   * Retrieve the list of Approved or completed LegalAction within a case for an idPerson, a cdLegalActAction
   * and a list of cdHrTypCrtOrd and which date field to order the result list by in descending order
   * 
   * @param idCase
   * @param idPerson
   * @param cdLegalActAction
   * @param cdHrTypCrtOrds
   * @param orderBy
   * @return List<LegalAction>
   */
  public LegalAction findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                       int idCase,
                                                                                       int idPerson,
                                                                                       Collection<String> cdHrTypCrtOrds,
                                                                                       String cdLegalActAction,
                                                                                       String orderBy);
  
  
  public LegalAction findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson(int idCase, int idPerson);
  
 /**
  * Find all legal action that indicates termination or voluntary surrender of parental right(s), order by most recently entered
  * Result legal actions for person (idPerson) in case (idCase): 
  * 1) cdLegalActActions OR,
  * 2) cdHrTypCrtOrds + cdOutComeTypeTpg OR,
  * 3) cdOutComeTypeDpc
  * Example: result is list of 
  * 1) Any Voluntary Surrender legal action or,
  * 2) Any TPR legal action whose outcome is TPR - Granted or,
  * 3) Any legal action whose outcome is Parent Deceased
  * For a person in a case
  * @param idCase
  * @param idPerson
  * @param cdLegalActActions
  * @param cdHrTypCrtOrds
  * @param cdOutComeTypeTpg
  * @param cdOutComeTypeDpc
  * @return
  */
  public List<LegalAction> findTprVsLegalActionsByIdCaseIdPerson(int idCase, int idPerson, Collection<String> cdLegalActActions,
          Collection<String> cdHrTypCrtOrds, 
          String cdOutComeTypeTpg, String cdOutComeTypeDpc);

}
