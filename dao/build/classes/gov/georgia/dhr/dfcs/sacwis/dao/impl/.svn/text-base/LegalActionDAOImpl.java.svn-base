package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.SQLQuery;

/*Change History:
 Date      	User            Description
 --------  --------------  --------------------------------------------------

 08/20/08  	mxpatel          STGAP00009839: added the following logic to display the tpr/vs achieved date:
 								 Choose the most recent of the two dates below for legal actions in COMP or APRV status.
 								 1) Court/Action Date
 								 Select the Court/Action Date where the Action Type equals any of the following list of values: "Voluntary Surrender by Adoptive Mother", "Voluntary Surrender by Adoptive Father", "Voluntary Surrender - Mother",  "Voluntary Surrender - Father".
 								 2) Court Order Date
 								 Select the Court Order Date where the Hearing Type/Court Order values are either "TPR-Father" or "TPR-Mother" and one of the Outcomes below are selected: "TPR Granted - Perm Custody to DHR", "TPR Granted - Perm Custody to Specified Relative for Adoption", "TPR Granted - Perm Custody to a 3rd Party"
 								 Wrote the method "findTprVsAchievedDate(idCase, idPerson))" in legalActionDAOImpl.java to satisfy the above logic.
 03/04/2009 	bgehlot          STGAP00012197: Removed the condition which checks for 'TPC', 'TPS', 'TPT' in method findLegalActionListForAdoptionDissolution.
 03/20/2009   	mxpatel          STGAP00012935: added new method findFirstTprVsLegalActionByIdCaseIdPerson to retrieves the first TPR/VS legal action for a case.
 03/23/2009	mxpatel          STGAP00012762: added new method - 	countTprVsLegalActionByIdCaseto find number of TPR/VS legal actions for the case.
 
 03/31/2009     bgehlot          STGAP00012833: Added the method findLegalActionBycdHrTypCrtOrd, findLegalActionBycdHrTypCrtOrdAndcdOutcomes
 06/30/2009     bgehlot          STGAP00014329: Added the method findLegalActionBycdLegalActAction, findLegalActionBycdHrTypCrtOrd
 07/29/2009     hjbaptiste       findInitialTprVsLegalActionsForCase     
 10/4/2009      cwells           STGAP00014143: findInitialTprVsLegalActionsForCase was causing a performance issue. Corrected the performance problem.   
 11/12/2009     arege            SMS#37448 : Wrote new method findLegalActionListByIdCaseByIdPersonByCdActionsByCdHrTypCrtOrds that will find legal action for
                                 given person in a given case where cdLegalActActions (Action drop down on page) is one of the VS (Voluntary Surrender) OR
                                 cdHrTypCrtOrds (Hearing Type/Court Order ) is one of the TPR's with cdOutcome of TPG OR
                                 legal action with outcome of DPC            
 11/30/2009     mchillman        SMS#37430: SMS40964Changed code findLegalActionByIdStageByIdPersonBycdActionsByCdOutcomes to find most recent by date updated
 01/03/2010     mxpatel          SMS# 37248: added method findIdLegalActionEventForParentalRights to find an appropriate legal action event id for populating the 
                                 status of parental rights.     
 01/06/2010     pcoogan          Added new method findInitialTprVsLegalActionsListForCase to return full list of legal actions for TPR to ensure that we find the one
                                 that actually has the court order.           
 02/14/2010     mxpatel          SMS #37248:modified method findIdLegalActionEventForParentalRights to only retrieve TPR date for record with TPR Granted  
 11/30/2010     arege            SMS#82989/65873: Added method findLegalActionByIdCaseByIdPerson 
 12/12/2010     hjbaptiste       SMS#81144: MR-053 Eligibility changes. Added findFirstBestIntestLegalActionsForCaseForFCE, 
                                 findFirstRemovalEffortsLegalActionsForCaseForFCE, findCustodyGrantedLegalActionForCaseForFCE
 12/12/2010     hnguyen          SMS#81144: MR-053 Added method findLegalActionsByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds 
                                 to retrieve legal actions in a given case for a given person by legal action type and 
                                 hearing type/court order
 02/11/2011     hnguyen          SMS#95590: Added new method findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson.
 02/17/2011     Hai Nguyen       SMS#95590: Updated findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson query to fix the way hibernate query sort null value as high value.                                                                                                                                                                                                        
 02/21/2011     htvo             SMS#97845 MR-072-2: added method findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson                                      
 02/28/2011     schoi            SMS #97845: MR-074-2 Added Voluntary Surrender-Putative Father (CLEGCPS_VPF) 
                                 and TPR-Putative Father (CLHECOT_TPP) to the condition in the new findLegalActionListForAllVSTpr method
 03/07/2011     schoi            SMS #97845: MR-074-2 Added new method findLegalActionBycdHrTypCrtOrdOrderByDtCrtActDate 
 03/08/2011     schoi            SMS #97845: MR-074-2 Added new method findTheMostRecentTprVsLegalActionsDateForCase
 03/10/2011     schoi            SMS #97845: MR-074-2 Replaced the method findLegalActionBycdHrTypCrtOrdOrderByDtCrtActDate 
                                 to a new method findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds for better re-usability
                                 and added the condition to perform the null check for the Court Order Date 
                                 (currently non-required field) for the existing method findLegalActionsByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds 
                                 per request from Hai Nguyen
 03/15/2011     schoi            SMS #97845: MR-074-2 Updated the comment section and the signature of a DAO method
                                 findTheMostRecentTprVsLegalActionsDateForCase per code peer review     
 03/17/2011     schoi            SMS #97845: MR-074-2 Added new method findTheMostRecentDateTprAchievedLegalActionsDateForCase
                                 for finding the Date of TPR/VS Achieved in FCCP Form and CPRS Interface  
 03/17/2011     schoi            SMS #97845: MR-074-2 Updated the method findTheMostRecentTprVsLegalActionsDateForCase   
                                 to retrieve legal action event of approved or completed status  
 03/31/2011     htvo             SMS #97845: MR-074-2 Modified findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds to order by action date                                                                              
 04/11/2011     hnguyen          SMS#103401: MR-074-2 Removed findLegalActionByIdStageByIdPersonBycdActionsByCdOutcomes method due to inaccuracy and redundancy.
 04/14/2011     htvo             SMS#105671: fixed Cartesian join in countTprVsLegalActionByIdCase.
 08/24/2011     hnguyen          STGAP00017008: Fix Initial and Amended FCEA judicial determination to look at specific primary child legal actions
                                 and not look at the legal actions across the AU.
 08/31/2011     hnguyen          STGAP00017008: Corrected Reasonable effort issue and custody granted outcome to look from removal date and onward.


*/

public class LegalActionDAOImpl extends BaseDAOImpl implements LegalActionDAO {

  public LegalAction findLegalActionByIdLegalActEvent(int idLegalActEvent){
    Query query = getSession().createQuery(
                                           " from LegalAction la where la.idLegalActEvent = :idLegalActEvent ");

    query.setInteger("idLegalActEvent", idLegalActEvent);
    return (LegalAction) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public LegalAction findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrd(int idCase, int idPerson,
                                                                                String cdLegalActAction,
                                                                                String cdHrTypCrtOrd) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action check box selected

    Query query = getSession().createQuery(
                                           " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.cdLegalActAction = :cdLegalActAction "
                                                           + " and la.cdHrTypCrtOrd = :cdHrTypCrtOrd "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " order by la.dtCrtOrdDate desc");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdLegalActAction", cdLegalActAction);
    query.setString("cdHrTypCrtOrd", cdHrTypCrtOrd);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    return (LegalAction) firstResult(query);
  }

  public LegalAction findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                       int idCase,
                                                                                       int idPerson,
                                                                                       String cdLegalActAction,
                                                                                       Collection<String> cdHrTypCrtOrds,
                                                                                       String orderBy) {

    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action check box selected
    String orderByClause = null;
    if (orderBy.equals("F")) { // sorting by File Motion
      orderByClause = " order by la.dtLegalActDateFiled desc";
    } else if (orderBy.equals("A")) { // sorting by Date Appealed
      orderByClause = " order by la.dtCrtActDate desc";
    } else {
      orderByClause = " order by la.event.dtLastUpdate desc";
    }

    Query query = getSession().createQuery(
                                           " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.cdLegalActAction = :cdLegalActAction "
                                                           + " and la.cdHrTypCrtOrd in ( :cdHrTypCrtOrds )"
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + orderByClause);

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdLegalActAction", cdLegalActAction);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    return (LegalAction) firstResult(query);
  }

  public LegalAction findLatestLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                       int idCase,
                                                                                       int idPerson,
                                                                                       Collection<String> cdLegalActActions,
                                                                                       Collection<String> cdHrTypCrtOrds,
                                                                                       String orderBy) {

    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action check box selected
    String orderByClause = null;
    if (orderBy.equals("F")) { // sorting by File Motion
      orderByClause = " order by la.dtLegalActDateFiled desc";
    } else if (orderBy.equals("A")) { // sorting by Date Appealed
      orderByClause = " order by la.dtCrtActDate desc";
    } else {
      orderByClause = " order by la.event.dtLastUpdate desc";
    }

    Query query = getSession().createQuery(
                                           " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.cdLegalActAction in ( :cdLegalActActions ) "
                                                           + " and la.cdHrTypCrtOrd in ( :cdHrTypCrtOrds ) "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + orderByClause);

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    return (LegalAction) firstResult(query);
  }
  
  public LegalAction findLatestLegalActionByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                     int idCase,
                                                                                     int idPerson,
                                                                                     Collection<String> cdLegalActActions,
                                                                                     String[] cdOutcomes) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = "LEG";
    String indComplete = "Y"; // legal action check box selected

    Query query = getSession()
                              .createQuery(
                                           " select la "
                                                           + " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and (la.cdLegalActAction in (:cdLegalActActions) "
                                                           + "   or la.idLegalActEvent in ( "
                                                           + "          select lao.legalAction.idLegalActEvent "
                                                           + "          from LegalActionOutcome lao "
                                                           + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                           + "          and lao.legalAction.person.idPerson = :idPerson "
                                                           + "          and lao.cdOutcome in (:cdOutcomes))) "
                                                           + " order by la.dtCrtOrdDate desc ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdOutcomes", cdOutcomes);
    return (LegalAction) firstResult(query);
  }
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionListByIdCaseByidPersonBycdOutcomes(int idCase, int idPerson, String[] cdOutcomes){
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = "LEG";
    String indComplete = "Y"; // legal action check box selected

    Query query = getSession()
                              .createQuery(
                                           " select la "
                                                           + " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.idLegalActEvent in ( "
                                                           + "          select lao.legalAction.idLegalActEvent "
                                                           + "          from LegalActionOutcome lao "
                                                           + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                           + "          and lao.legalAction.person.idPerson = :idPerson "
                                                           + "          and lao.cdOutcome in (:cdOutcomes)))); "
                                                           + " order by la.dtCrtActDate desc ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdOutcomes", cdOutcomes);
 
    return (List<LegalAction>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                         int idCase,
                                                                                         int idPerson,
                                                                                         Collection<String> cdLegalActActions,
                                                                                         String[] cdOutcomes,
                                                                                         Collection<String> cdHrTypCrtOrds) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = "LEG";
    String indComplete = "Y"; // legal action check box selected

    Query query = getSession()
                              .createQuery(
                                           " select la "
                                                           + " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and (la.cdLegalActAction in (:cdLegalActActions) "
                                                           + "   or (la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.idLegalActEvent in ( "
                                                           + "          select lao.legalAction.idLegalActEvent "
                                                           + "          from LegalActionOutcome lao "
                                                           + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                           + "          and lao.legalAction.person.idPerson = :idPerson "
                                                           + "          and lao.cdOutcome in (:cdOutcomes)))) "
                                                           + " order by la.dtCrtActDate desc ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdOutcomes", cdOutcomes);
    return (List<LegalAction>) query.list();
  }

  
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomesBeforeDate(
                                                                                         int idCase,
                                                                                         int idPerson,
                                                                                         Collection<String> cdLegalActActions,
                                                                                         String[] cdOutcomes,
                                                                                         Collection<String> cdHrTypCrtOrds,
                                                                                         Date dtEventOccurred) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = "LEG";
    String indComplete = "Y"; // legal action check box selected

    Query query = getSession()
                              .createQuery(
                                           " select la "
                                                           + " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and (la.cdLegalActAction in (:cdLegalActActions) "
                                                           + "   or (la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.idLegalActEvent in ( "
                                                           + "          select lao.legalAction.idLegalActEvent "
                                                           + "          from LegalActionOutcome lao "
                                                           + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                           + "          and lao.legalAction.person.idPerson = :idPerson "
                                                           + "          and lao.cdOutcome in (:cdOutcomes)))) "
                                                           + " and la.event.dtEventOccurred < :dtEventOccurred 		    										  "		
                                                           + " order by la.dtCrtActDate desc ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setDate("dtEventOccurred", dtEventOccurred);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdOutcomes", cdOutcomes);
    return (List<LegalAction>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionListForAdoptionDissolution(int idCase, int idPerson, Collection<String> cdStages) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV + "," + CodesTables.CEVTSTAT_COMP + "," +CodesTables.CEVTSTAT_PEND;
    String cdEventType = "LEG";
    String indComplete = "Y"; // legal action check box selected
    
    Query query = getSession()
                              .createQuery(
                                            " select la " 
                                            + " from LegalAction la join fetch la.event"
                                            + " where la.event.capsCase.idCase = :idCase "
                                            + " and la.event.cdEventType = :cdEventType "
                                            + " and la.event.stage.cdStage in ( :cdStages ) "
                                            + " and ( la.event.cdEventStatus in (:cdEventStatus) "
                                            + "      or la.indComplete = :indComplete ) "
                                            + " and la.person.idPerson = :idPerson "
                                            + " and (la.cdLegalActAction in ('VLM', 'VAM', 'VAF', 'VSF', 'VLS', 'VBF') "
                                            + "   or (la.cdHrTypCrtOrd in ('TPM', 'TFL', 'TFF', 'TFB', 'TPA', 'TFA') "
                                            + " and la.idLegalActEvent in ( "
                                            + "          select lao.legalAction.idLegalActEvent "
                                            + "          from LegalActionOutcome lao"
                                            + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                            + "          and lao.legalAction.person.idPerson = :idPerson "
                                            + "          and ( lao.cdOutcome = 'TPG'  "
                                            + "                    or lao.cdOutcome = 'DPC')))) "
                                            + " order by la.dtCrtActDate desc ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdStages", cdStages);
    query.setString("indComplete", indComplete);
    return (List<LegalAction>) query.list();
  }

  // SMS #97845: MR-074-2 
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionListForAllVSTpr(int idCase, int idPerson, Collection<String> cdStages) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV + "," + CodesTables.CEVTSTAT_COMP + "," +CodesTables.CEVTSTAT_PEND;
    String cdEventType = "LEG";
    String indComplete = "Y"; // legal action check box selected
    
    Query query = getSession()
                              .createQuery(
                                            " select la " 
                                            + " from LegalAction la join fetch la.event"
                                            + " where la.event.capsCase.idCase = :idCase "
                                            + " and la.event.cdEventType = :cdEventType "
                                            + " and la.event.stage.cdStage in ( :cdStages ) "
                                            + " and ( la.event.cdEventStatus in (:cdEventStatus) "
                                            + "      or la.indComplete = :indComplete ) "
                                            + " and la.person.idPerson = :idPerson "
                                            + " and (la.cdLegalActAction in ('VLM', 'VAM', 'VAF', 'VSF', 'VLS', 'VBF', 'VPF') "
                                            + "   or (la.cdHrTypCrtOrd in ('TPM', 'TFL', 'TFF', 'TFB', 'TPA', 'TFA', 'TPP') "
                                            + " and la.idLegalActEvent in ( "
                                            + "          select lao.legalAction.idLegalActEvent "
                                            + "          from LegalActionOutcome lao"
                                            + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                            + "          and lao.legalAction.person.idPerson = :idPerson "
                                            + "          and ( lao.cdOutcome = 'TPG'  "
                                            + "                    or lao.cdOutcome = 'DPC')))) "
                                            + " order by la.dtCrtActDate desc ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdStages", cdStages);
    query.setString("indComplete", indComplete);
    return (List<LegalAction>) query.list();
  }
      
  @SuppressWarnings("unchecked")
  public LegalAction findLegalActionByIdCaseByIdPersonByCdOutcome(int idCase, int idPerson, String cdOutcome) {
    Query query = getSession()
                              .createQuery(
                                           " from LegalAction la "
                                                           + " where la.idLegalActEvent = ( select lao1.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao1 "
                                                           + " where lao1.idLaOutcome = (select max(lao2.idLaOutcome) "
                                                           + " from LegalActionOutcome lao2 "
                                                           + " where lao2.legalAction.idLegalActEvent = la.idLegalActEvent "
                                                           + " and lao2.legalAction.capsCase.idCase = :idCase "
                                                           + " and lao2.legalAction.person.idPerson = :idPerson "
                                                           + " and cdOutcome = :cdOutcome))");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdOutcome", cdOutcome);

    return (LegalAction) firstResult(query);
  }

  @SuppressWarnings("unchecked")
  public Map findLegalActionLatestByIdCaseByIdPersonByCdOutcome(int idCase, int idPerson, String cdOutcome) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    Query query = getSession()
                              .createQuery(
                                           " select new map(la.cdLegalActAction as cdLegalActAction, "
                                                           + " la.cdLegalActActnSubtype as cdLegalActActnSubtype, "
                                                           + " la.dtLegalActDateFiled as dtLegalActDateFiled, "
                                                           + " la.dtLegalActOutcomeDt as dtLegalActOutcomeDt, "
                                                           + " la.cdCrtType as cdCrtType, la.dtNxtHearDate as dtNxtHearDate, "
                                                           + " la.dtContinDate as dtContinDate, la.dtCrtOrdDate as dtCrtOrdDate, "
                                                           + " la.dtPubDate as dtPubDate, la.cdCounty as cdCounty, "
                                                           + " la.dtCrtActDate as dtCrtActDate, la.cdHrTypCrtOrd as cdHrTypCrtOrd, "
                                                           + " la.dtShelterCareAuth as dtShelterCareAuth, lao.cdOutcome as cdOutcome) "
                                                           + " from LegalAction la, LegalActionOutcome lao "
                                                           + " where la.idLegalActEvent = lao.legalAction.idLegalActEvent "
                                                           + " and la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and lao.cdOutcome = :cdOutcome "
                                                           + " order by la.dtCrtOrdDate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setString("cdEventType", cdEventType);
    query.setString("cdOutcome", cdOutcome);

    return (Map) firstResult(query);
  }

  @SuppressWarnings("unchecked")
  public List<Map> findLegalActionLatestByIdCaseByIdPersonByCdOutcomes(int idCase, int idPerson,
                                                                       Collection<String> cdOutcomes) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    Query query = getSession()
                              .createQuery(
                                           " select new map(la.cdLegalActAction as cdLegalActAction, "
                                                           + " la.cdLegalActActnSubtype as cdLegalActActnSubtype, "
                                                           + " la.dtLegalActDateFiled as dtLegalActDateFiled, "
                                                           + " la.dtLegalActOutcomeDt as dtLegalActOutcomeDt, "
                                                           + " la.cdCrtType as cdCrtType, la.dtNxtHearDate as dtNxtHearDate, "
                                                           + " la.dtContinDate as dtContinDate, la.dtCrtOrdDate as dtCrtOrdDate, "
                                                           + " la.dtPubDate as dtPubDate, la.cdCounty as cdCounty, "
                                                           + " la.dtCrtActDate as dtCrtActDate, la.cdHrTypCrtOrd as cdHrTypCrtOrd, "
                                                           + " la.dtShelterCareAuth as dtShelterCareAuth, lao.cdOutcome as cdOutcome) "
                                                           + " from LegalAction la, LegalActionOutcome lao "
                                                           + " where la.idLegalActEvent = lao.legalAction.idLegalActEvent "
                                                           + " and la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and lao.cdOutcome in ( :cdOutcomes ) "
                                                           + " order by la.dtCrtOrdDate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdOutcomes", cdOutcomes);

    return (List<Map>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionLatestObjectsByIdCaseByIdPersonByCdOutcomes(int idCase, int idPerson,
                                                                                      Collection<String> cdOutcomes) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    Query query = getSession()
                              .createQuery(
                                           " select la "
                                                           + " from LegalAction la, LegalActionOutcome lao "
                                                           + " where la.idLegalActEvent = lao.legalAction.idLegalActEvent "
                                                           + " and la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and lao.cdOutcome in ( :cdOutcomes ) "
                                                           + " order by la.dtCrtOrdDate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdOutcomes", cdOutcomes);

    return (List<LegalAction>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionLatestObjectsByIdPersonByCdOutcomes(int idPerson,Collection<String> cdOutcomes) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    Query query = getSession()
                              .createQuery(
                                           " select la "
                                                           + " from LegalAction la, LegalActionOutcome lao "
                                                           + " where la.idLegalActEvent = lao.legalAction.idLegalActEvent "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and lao.cdOutcome in ( :cdOutcomes ) "
                                                           + " order by la.dtCrtOrdDate desc");
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setString("cdEventType", cdEventType);
    query.setParameterList("cdOutcomes", cdOutcomes);

    return (List<LegalAction>) query.list();
  }

  // mxpatel wrote this method to return the TprVsAchieved date
  public Date findTprVsAchievedDate(int idCase, int idPerson) {

    Query query = getSession()
                              .createSQLQuery(
                                              "select max(dt) "
                                                              + "from ( "
                                                              + "select la.DT_CRT_ORD_DATE dt "
                                                              + "from legal_action la, event e, caps_case cc, person p,legal_action_outcome lao "
                                                              + "where la.ID_LEGAL_ACT_EVENT = e.ID_EVENT "
                                                              + "and la.ID_LEGAL_ACT_EVENT = lao.ID_LEGAL_ACT_EVENT "
                                                              + "and e.id_case = cc.ID_CASE "
                                                              + "and la.ID_PERSON = p.ID_PERSON "
                                                              + "and cc.ID_CASE = :idCase "
                                                              + "and e.CD_EVENT_TYPE = 'LEG' "
                                                              + "and p.ID_PERSON = :idPerson "
                                                              + "and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                              + "and la.CD_HR_TYP_CRT_ORD in ('TPM', 'TPF')  "
                                                              + "and lao.CD_OUTCOME in ('TPC', 'TPS', 'TPT') "
                                                              + "union all "
                                                              + "select la.DT_CRT_ACT_DATE dt "
                                                              + "from legal_action la, event e, caps_case cc, person p "
                                                              + "where la.ID_LEGAL_ACT_EVENT = e.ID_EVENT "
                                                              + "and e.id_case = cc.ID_CASE "
                                                              + "and la.ID_PERSON = p.ID_PERSON "
                                                              + "and cc.ID_CASE = :idCase "
                                                              + "and e.CD_EVENT_TYPE = 'LEG' "
                                                              + "and p.ID_PERSON = :idPerson "
                                                              + "and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                              + "and la.CD_LEGAL_ACT_ACTION in ('VLM', 'VAM', 'VLF', 'VAF') "
                                                              + ")");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);

    return (Date) query.uniqueResult();
  }

  public LegalAction findLegalActionByIdCaseByIdPersonByCdHrTypCrtOrd(int idCase, int idPerson, String cdHrTypCrtOrd) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;

    Query query = getSession().createQuery(
                                           "  from LegalAction la " + "  where la.event.capsCase.idCase = :idCase "
                                                           + "  and la.event.cdEventType = :cdEventType "
                                                           + "  and la.person.idPerson = :idPerson "
                                                           + "  and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "     or la.indComplete = :indComplete )"
                                                           + "  and la.cdHrTypCrtOrd = :cdHrTypCrtOrd "
                                                           + "  order by la.event.dtLastUpdate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setString("cdHrTypCrtOrd", cdHrTypCrtOrd);

    return (LegalAction) firstResult(query);
  }

  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionByIdCaseByIdPersonByCdHrTypCrtOrds(int idCase, int idPerson,
                                                                             Collection<String> cdHrTypCrtOrds) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;

    Query query = getSession().createQuery(
                                           "  from LegalAction la " + "  where la.event.capsCase.idCase = :idCase "
                                                           + "  and la.event.cdEventType = :cdEventType "
                                                           + "  and la.person.idPerson = :idPerson "
                                                           + "  and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "     or la.indComplete = :indComplete )"
                                                           + "  and la.cdHrTypCrtOrd in ( :cdHrTypCrtOrds ) "
                                                           + "  order by la.event.dtLastUpdate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);

    return (List<LegalAction>) query.list();
  }

  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionByIdPersonAndIdCase(int idPerson, int idCase) {
    Query query = getSession().createQuery(
                                           "  from LegalAction la " + " where person.idPerson = :idPerson "
                                                           + " and capsCase.idCase = :idCase "
                                                           + " order by la.dtNxtHearDate desc");

    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);

    return (List<LegalAction>) query.list();
  }

  public int findIdLegalActionByTPROutcomesPersonEvent(int idCase, Collection<Integer> principalsForEvent) {
    Query query = getSession()
                              .createQuery(
                                           "select la.idLegalActEvent from LegalActionOutcome lao, LegalAction la, StagePersonLink spl  "
                                                           + " where la.event.idEvent = lao.legalAction.idLegalActEvent  "
                                                           + " and la.capsCase.idCase = :idCase "
                                                           + " and spl.capsCase.idCase = :idCase "
                                                           + " and lao.cdOutcome in ('TPC', 'TPS', 'TPT') "
                                                           + " and la.person.idPerson = spl.person.idPerson "
                                                           + " and la.person.idPerson in ( :principalsForEvent ) "
                                                           + " and (spl.stage.cdStage = :cdStageADO or spl.stage.cdStage = :cdStageSUB) "
                                                           + " and spl.cdStagePersRole = :cdStagePersRole ");

    query.setInteger("idCase", idCase);
    query.setString("cdStageADO", CodesTables.CSTAGES_ADO);
    query.setString("cdStageSUB", CodesTables.CSTAGES_SUB);
    query.setString("cdStagePersRole", CodesTables.CROLEALL_PC);
    query.setParameterList("principalsForEvent", principalsForEvent);

    Integer result = (Integer) firstResult(query);
    if (result == null) {
      return 0;
    }

    return result;
  }

  public void saveLegalAction(LegalAction legalAction) {
    getSession().saveOrUpdate(legalAction);
  }

  public void deleteLegalAction(LegalAction legalAction) {
    getSession().delete(legalAction);
  }

  public int updateLegalActionIdPerson(int idPersMergeForward, int idPersMergeClosed, int idEvent) {
    Query query = getSession().createQuery(
                                           " update LegalAction" + "    set person.idPerson = :idPersMergeForward"
                                                           + "  where person.idPerson = :idPersMergeClosed"
                                                           + "    and idLegalActEvent = :idEvent");

    query.setInteger("idPersMergeForward", idPersMergeForward);
    query.setInteger("idPersMergeClosed", idPersMergeClosed);
    query.setInteger("idEvent", idEvent);
    return query.executeUpdate();
  }
  
  //STGAP00012015: This sql retrieves the earliest date the legal action was  approved or complete with 
  //an action of voluntary surrender of parental rights(VS), or a court order hearing
  //type of termination of parental rights(TPR) and the outcome as one of the options in the
  //collection passed for a given person in a given case.
  public Date findLegalActionDateByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                         int idCase,
                                                                                         int idPerson,
                                                                                         Collection<String> cdLegalActActions,
                                                                                         Collection<String> cdOutcomes,
                                                                                         Collection<String> cdHrTypCrtOrds) {
    Query query = getSession()
                              .createQuery(
                                           " select la.event.dtLastUpdate "
                                                           + " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and (la.cdLegalActAction in (:cdLegalActActions) "
                                                           + "   or (la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.idLegalActEvent in ( "
                                                           + "          select lao.legalAction.idLegalActEvent "
                                                           + "          from LegalActionOutcome lao "
                                                           + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                           + "          and lao.legalAction.person.idPerson = :idPerson "
                                                           + "          and lao.cdOutcome in (:cdOutcomes))" 
                                                           + "          and la.idLegalActEvent in ( "
                                                           + "          select lao.legalAction.idLegalActEvent "
                                                           + "          from LegalActionOutcome lao "
                                                           + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                           + "          and lao.legalAction.person.idPerson = :idPerson "
                                                           + "          and lao.cdOutcome = :cdOutCome ))) "
                                                           + " order by la.event.dtLastUpdate asc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    query.setString("cdOutCome", CodesTables.CLEGLOUT_TPG);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdOutcomes", cdOutcomes);
    return (Date) firstResult(query);
  }
  
  //STGAP00011633 added method to find court action date for latest updated action of a given
  //set of actions, outcomes and court order types
  public Date findLastedUdatedLegalActionDateByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                            int idCase,
                                                                            int idPerson,
                                                                            Collection<String> cdLegalActActions,
                                                                            Collection<String> cdOutcomes,
                                                                            Collection<String> cdHrTypCrtOrds) {
    Query query = getSession()
    .createQuery(
                 " select la.dtCrtActDate "
                                 + " from LegalAction la "
                                 + " where la.event.capsCase.idCase = :idCase "
                                 + " and la.event.cdEventType = :cdEventType "
                                 + " and ( la.event.cdEventStatus = :cdEventStatus "
                                 + "      or la.indComplete = :indComplete ) "
                                 + " and la.person.idPerson = :idPerson "
                                 + " and la.indUpPrevAct = :idUpdate "
                                 + " and (la.cdLegalActAction in (:cdLegalActActions) "
                                 + "   or (la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                 + " and la.idLegalActEvent in ( "
                                 + "          select lao.legalAction.idLegalActEvent "
                                 + "          from LegalActionOutcome lao "
                                 + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                 + "          and lao.legalAction.person.idPerson = :idPerson "
                                 + "          and lao.cdOutcome in (:cdOutcomes))" 
                                 + "          and la.idLegalActEvent in ( "
                                 + "          select lao.legalAction.idLegalActEvent "
                                 + "          from LegalActionOutcome lao "
                                 + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                 + "          and lao.legalAction.person.idPerson = :idPerson "
                                 + "          and lao.cdOutcome = :cdOutCome ))) "
                                 + " order by la.event.dtLastUpdate desc ");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    query.setString("indComplete", ArchitectureConstants.Y);
    query.setString("cdOutCome", CodesTables.CLEGLOUT_TPG);
    query.setString("idUpdate", ArchitectureConstants.Y);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdOutcomes", cdOutcomes);
    return (Date) firstResult(query);
  }

  //STGAP00010006: Retrieves Legal action date on an approved or complete, first legal action record, 
  //with a court order hearing type of termination of parental rights(TPR) and with the court type as 
  //Juvenile for a given person in a given case.
  public Date findDtCrtActByHearingTypeByCrtType(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds){
    Query query = getSession().createQuery(
                                                 " select la.dtCrtActDate "
                                                           + " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson " 
                                                           + " and la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.cdCrtType = :cdCrtType "
                                                           + " order by la.event.dtLastUpdate asc ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdCrtType", CodesTables.CCRTTYPE_JUV);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indComplete", ArchitectureConstants.Y);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    
    return (Date)firstResult(query);
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<LegalAction> findFirstBestIntestLegalActionsForCaseForFCE(int idCase, int idChild, Collection<String> cdLegalActActions, 
                                                                        String crtOrderLang){
    Query query = getSession().createQuery( " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and la.cdLegalActAction in (:cdLegalActActions) "
                                                           + " and la.event.idEvent in ( "
                                                           + " select lacl.legalAction.idLegalActEvent "
                                                           + " from LegalActionCrtLang lacl "
                                                           + " where lacl.legalAction.capsCase.idCase = :idCase "
                                                           + " and lacl.cdCrtLang = :crtOrderLang) "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.dtCrtOrdDate is not null " 
                                                           + " and la.person.idPerson = :idChild "
                                                           + " order by la.event.dtLastUpdate asc ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idChild", idChild);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indComplete", ArchitectureConstants.Y);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    query.setString("crtOrderLang", crtOrderLang);
    
    return (List<LegalAction>) query.list();
  }
  
  @SuppressWarnings( { "unchecked" })
  public List<LegalAction> findFirstRemovalEffortsLegalActionsForCaseForFCE(int idCase, int idChild, Collection<String> cdLegalActActions, 
                                                                        Collection<String> crtOrderLangs, Date removalDate){
   Query query = getSession().createQuery( " from LegalAction la "
                                                          + " where la.event.capsCase.idCase = :idCase "
                                                          + " and la.event.cdEventType = :cdEventType "
                                                          + " and la.cdLegalActAction in (:cdLegalActActions) "
                                                          + " and la.event.idEvent in ( "
                                                          + " select lacl.legalAction.idLegalActEvent "
                                                          + " from LegalActionCrtLang lacl "
                                                          + " where lacl.legalAction.capsCase.idCase = :idCase "
                                                          + " and lacl.cdCrtLang in (:crtOrderLangs)) "
                                                          + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                          + "      or la.indComplete = :indComplete ) "
                                                          + " and la.person.idPerson = :idChild "
                                                          + " and la.dtCrtOrdDate >= :removalDate "
                                                          + " and la.dtCrtOrdDate <= :within60DaysOfRemoval " 
                                                          + " order by la.event.dtLastUpdate asc ");
   
   query.setInteger("idCase", idCase);
   query.setInteger("idChild", idChild);
   query.setParameterList("cdLegalActActions", cdLegalActActions);
   query.setParameterList("crtOrderLangs", crtOrderLangs);
   query.setDate("removalDate", removalDate);
   query.setDate("within60DaysOfRemoval", DateHelper.addToDate(removalDate, 0, 0, 60));
   query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
   query.setString("indComplete", ArchitectureConstants.Y);
   query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
   
   return (List<LegalAction>) query.list();
  }
  
  @SuppressWarnings("unchecked")
  public List<LegalAction> findCustodyGrantedLegalActionForCaseForFCE(int idCase, int idChild, Collection<String> cdOutcomes, Date removalDate) {
    Query query = getSession()
                              .createQuery( " select la from LegalAction la, LegalActionOutcome lao "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and la.idLegalActEvent = lao.legalAction.idLegalActEvent "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idChild "
                                                           + " and lao.cdOutcome in ( :cdOutcomes ) "
                                                           + " and la.dtCrtOrdDate is not null " 
                                                           + " and la.dtCrtOrdDate >= :removalDate "
                                                           + " order by la.dtCrtOrdDate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idChild", idChild);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indComplete", ArchitectureConstants.Y);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    query.setDate("removalDate", removalDate);
    query.setParameterList("cdOutcomes", cdOutcomes);

    return (List<LegalAction>) query.list();
  }
  
  // SMS# 37248: this method returns an appropriate legal action event id for populating the status of parental rights
  // section as per logic below:
  // 1. find any Voluntary Surrender legal actions - consider the earliest event
  // 2.if there are any update to previous legal actions present use the latest updated event
  // 3. find any TPR legal actions - consider the earliest event
  // 4. if there are any update to previous legal actions present use the latest updated event
  // all of this is done in the legalActionDAO.findParentalRights query
  public Integer findIdLegalActionEventForParentalRights(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                        Collection<String> cdHrTypCrtOrds, Collection<String> cdOutcomes) {

    SQLQuery query = getSession()
                                 .createSQLQuery(
                                                 " select legal.ID_LEGAL_ACT_EVENT "
                                                                 + " from "
                                                                 + " (select 1 as N, la.*, row_number() over (partition by la.ind_up_prev_act order by e.dt_event_occurred DESC) rn "
                                                                 + " from legal_action la, event e "
                                                                 + " where e.id_event = la.id_legal_act_event "
                                                                 + " and (e.cd_event_status = :cdEventStatus"
                                                                 + " or la.ind_complete = :indCompleteYes) "
                                                                 + " and e.cd_event_type = :cdEventType "
                                                                 + " and la.id_case = :idCase  "
                                                                 + " and la.id_person = :idPerson "
                                                                 + " and la.cd_legal_act_action in (:cdLegalActActions) "
                                                                 + " and la.ind_up_prev_act = :indCompleteYes "
                                                                 + " union all "
                                                                 + " select 2 as N, la.*, row_number() over (partition by la.ind_up_prev_act order by e.dt_event_occurred ASC) rn "
                                                                 + " from legal_action la, event e "
                                                                 + " where e.id_event = la.id_legal_act_event "
                                                                 + " and (e.cd_event_status = :cdEventStatus or la.ind_complete = :indCompleteYes) "
                                                                 + " and e.cd_event_type = :cdEventType "
                                                                 + " and la.id_case = :idCase   "
                                                                 + " and la.id_person = :idPerson "
                                                                 + " and la.cd_legal_act_action in (:cdLegalActActions) "
                                                                 + " and la.ind_up_prev_act <> :indCompleteYes "
                                                                 + " union all "
                                                                 + " select 3 as N, la.* , row_number() over (partition by la.ind_up_prev_act order by e.dt_event_occurred DESC) rn "
                                                                 + " from legal_action la, event e,legal_action_outcome lao "
                                                                 + " where e.id_event = la.id_legal_act_event "
                                                                 + " and la.id_legal_act_event = lao.id_legal_act_event"
                                                                 + " and (e.cd_event_status = :cdEventStatus or la.ind_complete = :indCompleteYes) "
                                                                 + " and e.cd_event_type = :cdEventType "
                                                                 + " and la.id_case = :idCase   "
                                                                 + " and la.id_person = :idPerson "
                                                                 + " and la.cd_hr_typ_crt_ord in (:cdHrTypCrtOrds) "
                                                                 + " and lao.cd_outcome = 'TPG'"
                                                                 + " and la.ind_up_prev_act = :indCompleteYes "
                                                                 + " union all "
                                                                 + " select 4 as N, la.* , row_number() over (partition by la.ind_up_prev_act order by e.dt_event_occurred ASC) rn "
                                                                 + " from legal_action la, event e,legal_action_outcome lao "
                                                                 + " where e.id_event = la.id_legal_act_event "
                                                                 + " and la.id_legal_act_event = lao.id_legal_act_event"
                                                                 + " and (e.cd_event_status = :cdEventStatus or la.ind_complete = :indCompleteYes) "
                                                                 + " and e.cd_event_type = :cdEventType "
                                                                 + " and la.id_case = :idCase   "
                                                                 + " and la.id_person = :idPerson "
                                                                 + " and la.cd_hr_typ_crt_ord in (:cdHrTypCrtOrds) "
                                                                 + " and lao.cd_outcome = 'TPG'"
                                                                 + " and la.ind_up_prev_act <> :indCompleteYes "
                                                                 + " UNION all "
                                                                 + " select 5 as N, la.*, row_number() over (partition by la.ind_up_prev_act order by e.dt_event_occurred DESC) rn "
                                                                 + " from legal_action la, event e "
                                                                 + " where e.id_event = la.id_legal_act_event "
                                                                 + " and (e.cd_event_status = :cdEventStatus or la.ind_complete = :indCompleteYes) "
                                                                 + " and la.id_legal_act_event in (select lao.id_legal_act_event from legal_action la, legal_action_outcome lao "
                                                                 + " where la.id_legal_act_event = lao.id_legal_act_event "
                                                                 + " and la.id_case = :idCase   "
                                                                 + " and la.id_person = :idPerson "
                                                                 + " and lao.cd_outcome in (:cdOutcomes) ) "
                                                                 + " and la.ind_up_prev_act = :indCompleteYes "
                                                                 + " UNION all "
                                                                 + " select 6 as N, la.*, row_number() over (partition by la.ind_up_prev_act order by e.dt_event_occurred ASC) rn "
                                                                 + " from legal_action la, event e "
                                                                 + " where e.id_event = la.id_legal_act_event "
                                                                 + " and (e.cd_event_status = :cdEventStatus or la.ind_complete = :indCompleteYes) "
                                                                 + " and la.id_legal_act_event in (select lao.id_legal_act_event from legal_action la, legal_action_outcome lao "
                                                                 + " where la.id_legal_act_event = lao.id_legal_act_event "
                                                                 + " and la.id_case = :idCase   "
                                                                 + " and la.id_person = :idPerson "
                                                                 + " and lao.cd_outcome in (:cdOutcomes) ) "
                                                                 + " and la.ind_up_prev_act <> :indCompleteYes "
                                                                 + " ) legal, " + " event e "
                                                                 + " where e.id_event = legal.id_legal_act_event "
                                                                 + " and rn = 1 " + " order by legal.N ASC ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    query.setString("indCompleteYes", ArchitectureConstants.Y);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdOutcomes", cdOutcomes);
    query.addScalar("ID_LEGAL_ACT_EVENT", Hibernate.INTEGER);
    return (Integer) firstResult(query);

  }
  //STGAP00012021: Modified the return type to get the whole legal action record instead of date
  public LegalAction findDtCrtActByHearingTypeByActionType(int idCase, int idPerson, List<String> cdHrTypCrtOrds, String cdLegalActAction){
    Query query = getSession().createQuery(
                                                 " from LegalAction la "
                                                           + " where la.event.capsCase.idCase = :idCase "
                                                           + " and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + " and la.person.idPerson = :idPerson " 
                                                           + " and la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.cdLegalActAction = :cdLegalActAction "
                                                           + " order by la.event.dtLastUpdate desc ");
    
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdLegalActAction", cdLegalActAction);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indComplete", ArchitectureConstants.Y);
    query.setString("cdEventType", CodesTables.CEVNTTYP_LEG);
    
    return (LegalAction)firstResult(query);
  }
  
  // mxpatel wrote this method for defect #STGAP00012935
  // this method finds the first tpr/vs legal action for the case.
  public Date findFirstTprVsLegalActionByIdCaseIdPerson(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                        Collection<String> cdHrTypCrtOrds, String cdEventType,
                                                        String cdOutComeTypeTpg, String cdOutComeTypeDpc) {

    Query query = getSession().createSQLQuery(" select DT_EVENT_OCCURRED " +
                                               " from LEGAL_ACTION la, EVENT ev " +
                                               " where la.ID_CASE=:idCase " +
                                               " and la.ID_PERSON=:idPerson " +
                                               " and la.ID_LEGAL_ACT_EVENT = ev.ID_EVENT " +
                                               " and (la.CD_LEGAL_ACT_ACTION in (:cdLegalActActions) or " +
                                               " (la.CD_HR_TYP_CRT_ORD in (:cdHrTypCrtOrds) and " +
                                               "        la.ID_LEGAL_ACT_EVENT in ( " +
                                               "                            select " +
                                               "                                lao.ID_LEGAL_ACT_EVENT " +
                                               "                            from " +
                                               "                                LEGAL_ACTION_OUTCOME lao " +
                                               "                            where " +
                                               "                                lao.ID_LEGAL_ACT_EVENT=la.ID_LEGAL_ACT_EVENT " +
                                               "                                and lao.CD_OUTCOME=:cdOutComeTypeTpg " +
                                               "                        ) " +
                                               "      ) or " +
                                               "       (la.ID_LEGAL_ACT_EVENT in ( " +
                                               "                            select " +
                                               "                                lao.ID_LEGAL_ACT_EVENT " +
                                               "                            from " +
                                               "                                LEGAL_ACTION_OUTCOME lao " +
                                               "                            where " +
                                               "                                lao.ID_LEGAL_ACT_EVENT=la.ID_LEGAL_ACT_EVENT " +
                                               "                                and lao.CD_OUTCOME=:cdOutComeTypeDpc " +
                                               "                        ) " +
                                               "      ) " +
                                               "    ) " +
                                               " and (ev.CD_EVENT_STATUS=:cdEventStatus or la.IND_COMPLETE=:indComplete) " +
                                               " order by ev.DT_EVENT_OCCURRED asc ");
                                               
    query.setInteger("idPerson", idPerson);
    query.setInteger("idCase", idCase);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeTpg);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indComplete", ArchitectureConstants.Y);

    return (Date) firstResult(query);
  }

  // mxpatel created this method for defect #STGAP00012762 and #STGAP00012641
  public long countTprVsLegalActionByIdCase(int idCase, Collection<String> cdLegalActActions,
                                            Collection<String> cdHrTypCrtOrds, String cdEventType, String cdOutComeTypeTpg, String cdOutComeTypeDpc, int idPerson) {
    Query query = getSession().createQuery(
                                          " select count(*) from LegalAction la "
                                          + " where la.capsCase.idCase = :idCase "
                                          + " and la.event.cdEventType = :cdEventType "
                                          + " and  la.person.idPerson = :idPerson "
                                          + " and (la.cdLegalActAction in (:cdLegalActActions) "
                                          + " or( la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                          + " and la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                          + " from LegalActionOutcome lao "
                                          + " where lao.legalAction.capsCase.idCase =  :idCase "
                                          + " and lao.legalAction.event.cdEventType = :cdEventType "
                                          + " and lao.cdOutcome = :cdOutComeTypeTpg))"
                                          + " or la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                          + " from LegalActionOutcome lao "
                                          + " where lao.legalAction.capsCase.idCase = :idCase "
                                          + " and lao.legalAction.event.cdEventType = :cdEventType "
                                          + " and lao.cdOutcome = :cdOutComeTypeDpc))");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds); 

    return (Long) query.uniqueResult();
  }

  //STGAP00012833: Retrieves the List of Approved or complete Legal Action for the idPerson and idCase for 
  //               cdHrTypCrtOrd
  @SuppressWarnings("unchecked")        
  public List<LegalAction> findLegalActionBycdHrTypCrtOrd(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds, String cdLegalActAction) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action complete check box selected
    Query query = getSession().createQuery(
                                            " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                 + " and la.person.idPerson = :idPerson "
                                                 + " and la.cdLegalActAction = :cdLegalActAction "
                                                 + " and la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                 + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                 + "      or la.indComplete = :indComplete ) "
                                                 + " order by la.dtCrtOrdDate desc");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdLegalActAction", cdLegalActAction);
    return (List<LegalAction>) query.list();
  }
  
  //STGAP00012833: Retrieves the List of Approved or complete Legal Action for the idPerson and idCase for 
  //               cdHrTypCrtOrd and cdOutcomes
  @SuppressWarnings("unchecked")        
  public List<LegalAction> findLegalActionBycdHrTypCrtOrdAndcdOutcomes(int idCase, int idPerson, Collection<String> cdHrTypCrtOrds, Collection<String> cdOutcomes) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action complete check box selected
    Query query = getSession().createQuery(
                                            " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                 + " and la.person.idPerson = :idPerson "
                                                 + " and la.cdLegalActAction = :cdLegalActAction "
                                                 + " and la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                 + " and la.event.idEvent not in ( "
                                                 + " select lao.legalAction.idLegalActEvent "
                                                 + " from LegalActionOutcome lao "
                                                 + " where lao.legalAction.capsCase.idCase = :idCase "
                                                 + " and lao.cdOutcome in (:cdOutcomes)) "
                                                 + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                 + "      or la.indComplete = :indComplete ) "
                                                 + " order by la.dtCrtOrdDate desc");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setString("cdLegalActAction", CodesTables.CLEGCPS_APL);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdOutcomes", cdOutcomes);
    return (List<LegalAction>) query.list();
  }

  
  //STGAP00014329: Retrieves the List of Approved or complete Legal Action for the idPerson and stage for 
  //                cdLegalActAction      
  public LegalAction findLegalActionBycdLegalActAction(int idCase, int idPerson, Collection<String> cdLegalActAction) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action complete check box selected
    Query query = getSession().createQuery(
                                            " select la from LegalAction la, EventPersonLink epl  " 
                                                 + " where la.idLegalActEvent = epl.event.idEvent "
                                                 + " and la.capsCase.idCase = :idCase "
                                                 + " and epl.person.idPerson = :idPerson "
                                                 + " and la.cdLegalActAction in (:cdLegalActAction) "
                                                 + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                 + "      or la.indComplete = :indComplete ) "
                                                 + " order by la.dtCrtActDate desc");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdLegalActAction", cdLegalActAction);
    return (LegalAction) firstResult(query);
  }
  
  //STGAP00014329: Retrieves the List of Approved or complete Legal Action for the idPerson and stage for 
  //                cdHrTypCrtOrds     
  public LegalAction findLegalActionBycdHrTypCrtOrd(int idCase, int idPerson, Collection<String> cdHrTypCrtOrd) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action complete check box selected
    Query query = getSession().createQuery(
                                            " select la from LegalAction la, EventPersonLink epl " 
                                                 + " where la.idLegalActEvent = epl.event.idEvent "
                                                 + " and la.capsCase.idCase = :idCase "
                                                 + " and epl.person.idPerson = :idPerson "
                                                 + " and la.cdHrTypCrtOrd in (:cdHrTypCrtOrd) "
                                                 + " and la.idLegalActEvent in ( "
                                                 + "          select lao.legalAction.idLegalActEvent "
                                                 + "          from LegalActionOutcome lao "
                                                 + "          where lao.legalAction.event.capsCase.idCase = :idCase "
                                                 + "          and epl.person.idPerson = :idPerson "
                                                 + "          and lao.cdOutcome = :cdOutCome) " 
                                                 + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                 + "      or la.indComplete = :indComplete ) "
                                                 + " order by nvl(la.dtCrtOrdDate, :minDate) desc");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdHrTypCrtOrd", cdHrTypCrtOrd);
    query.setString("cdOutCome", CodesTables.CLEGLOUT_TPG);
    query.setTimestamp("minDate", DateHelper.MIN_JAVA_DATE);
    return (LegalAction) firstResult(query);
  }
  
  public LegalAction findInitialTprVsLegalActionsForCase(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                         Collection<String> cdHrTypCrtOrds, String cdEventType, 
                                                         String cdOutComeTypeTpg, String cdOutComeTypeDpc) {
    Query query = getSession().createQuery(
                                            " select la from LegalAction la "
                                                           + "  where la.capsCase.idCase = :idCase "
                                                           + "      and la.event.cdEventType = 'LEG' "
                                                           + "     and  la.person.idPerson = :idPerson "
                                                           + "   and( la.cdLegalActAction in (:cdLegalActActions) "
                                                           + " or( la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao "
                                                           + " where lao.legalAction.capsCase.idCase =   la.capsCase.idCase "
                                                           + " and lao.legalAction.event.cdEventType = :cdEventType "
                                                           + " and lao.cdOutcome = :cdOutComeTypeTpg)) "
                                                           + " or la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao "
                                                           + " where lao.legalAction.capsCase.idCase =  la.capsCase.idCase "
                                                           + " and lao.legalAction.event.cdEventType = :cdEventType "
                                                           + " and lao.cdOutcome = :cdOutComeTypeDpc))"
                                                           + " order by la.dtCrtActDate asc) ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds); 
    return (LegalAction) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<LegalAction> findInitialTprVsLegalActionsListForCase(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                         Collection<String> cdHrTypCrtOrds, String cdEventType, 
                                                         String cdOutComeTypeTpg, String cdOutComeTypeDpc) {
    Query query = getSession().createQuery(
                                            " select la from LegalAction la "
                                                           + "  where la.capsCase.idCase = :idCase "
                                                           + "      and la.event.cdEventType = 'LEG' "
                                                           + "     and  la.person.idPerson = :idPerson "
                                                           + "   and( la.cdLegalActAction in (:cdLegalActActions) "
                                                           + " or( la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao "
                                                           + " where lao.legalAction.capsCase.idCase =   la.capsCase.idCase "
                                                           + " and lao.legalAction.event.cdEventType = :cdEventType "
                                                           + " and lao.cdOutcome = :cdOutComeTypeTpg)) "
                                                           + " or la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao "
                                                           + " where lao.legalAction.capsCase.idCase =  la.capsCase.idCase "
                                                           + " and lao.legalAction.event.cdEventType = :cdEventType "
                                                           + " and lao.cdOutcome = :cdOutComeTypeDpc))"
                                                           + " order by la.dtCrtActDate asc) ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds); 
    return (List<LegalAction>) query.list();
  }

  // SMS #97845: MR-074-2 
  // Find the most recent Court Action/Court Order Date among the following
  // (The event status of Legal Action should be approved or completed):
  // 1. The most recent Court Action Date for a Legal Action Type of cdLegalActActions
  // 2. The most recent Court Order Date for a Legal Action where the Hearing/Court Order Type of cdHrTypCrtOrds 
  //    and the Outcome is 'TPR Granted (CLEGLOUT_TPG)'
  // 3. The most recent Court Order Date for a Legal Action where the Outcome is 
  //    'Deceased Parents – Permanent Custody to DHR (CLEGLOUT_DPC)'
  @SuppressWarnings("unchecked")
  public Date findTheMostRecentTprVsLegalActionsDateForCase(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                         Collection<String> cdHrTypCrtOrds, 
                                                         String cdOutComeTypeTpg, String cdOutComeTypeDpc) {
    Query query = getSession().createSQLQuery(
                                            " select max(dt) "
                                                           + " from ( "
                                                           + " select la.DT_CRT_ACT_DATE dt "
                                                           + " from LEGAL_ACTION la, EVENT e "
                                                           + " where la.ID_CASE = :idCase "
                                                           + " and la.ID_PERSON = :idPerson "
                                                           + " and la.ID_LEGAL_ACT_EVENT = e.ID_EVENT "  
                                                           + " and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                           + " and la.CD_LEGAL_ACT_ACTION in (:cdLegalActActions) "
                                                           + " union all "
                                                           + " select la.DT_CRT_ORD_DATE dt "
                                                           + " from LEGAL_ACTION la, EVENT e "
                                                           + " where la.ID_CASE = :idCase "
                                                           + " and la.ID_PERSON = :idPerson "
                                                           + " and la.CD_HR_TYP_CRT_ORD in (:cdHrTypCrtOrds) "
                                                           + " and la.ID_LEGAL_ACT_EVENT = e.ID_EVENT "
                                                           + " and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                           + " and la.DT_CRT_ORD_DATE is not null "
                                                           + " and la.ID_LEGAL_ACT_EVENT in (select lao.ID_LEGAL_ACT_EVENT "
                                                           + " from LEGAL_ACTION_OUTCOME lao "
                                                           + " where lao.CD_OUTCOME = :cdOutComeTypeTpg) "
                                                           + " union all "
                                                           + " select la.DT_CRT_ORD_DATE dt "
                                                           + " from LEGAL_ACTION la, EVENT e "
                                                           + " where la.ID_CASE = :idCase "
                                                           + " and la.ID_PERSON = :idPerson "
                                                           + " and la.ID_LEGAL_ACT_EVENT = e.ID_EVENT " 
                                                           + " and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                           + " and la.DT_CRT_ORD_DATE is not null "
                                                           + " and la.ID_LEGAL_ACT_EVENT in (select lao.ID_LEGAL_ACT_EVENT "
                                                           + " from LEGAL_ACTION_OUTCOME lao "
                                                           + " where lao.CD_OUTCOME = :cdOutComeTypeDpc)"
                                                           + " ) ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds); 
    return (Date) query.uniqueResult();
  }

  // SMS #97845: MR-074-2 
  // Find the most recent date from Items #1, #2 and #3 (The event status of Legal Action should be approved or completed) :
  // 1. Most recent Court Action Date for the Legal Action with Action type of any Voluntary Surrender 
  //    (VLM - VS Biological Mother, VAM - VS Adoptive Mother, VBF - VS Biological Father, VSF - VS Biological and Legal Father, 
  //    VLS - VS Legal Father, VAF - VS Adoptive Father, VPF - VS Putative Father)
  // 2. Most recent Court Order Date for the Legal Action with Hearing/Court Order Type of any TPR value 
  //    (TFA – TPR Adoptive Father, TPA – TPR Adoptive Mother, TFB – TPR Biological Father, TFF – TPR Legal Father, 
  //    TFL – TPR Biological and Legal Father, TPM – TPR Biological Mother, TPP – TPR Putative Father) 
  //    if the Action Type is either ‘Hearing’ or ‘Received Court Order’, 
  //    and the Outcome is ‘TPR Granted (CLEGLOUT_TPG)’ AND either 'Perm Custody to Specified Relative for Adoption', 
  //    'Perm Custody to a 3rd Party' or 'Perm Custody to DHR'
  // 3. Most recent Court Order Date for Legal Action if the Action Type is either ‘Hearing’ or ‘Received Court Order’ 
  //    and the Outcome is 'Deceased Parents - Permanent Custody to DHR (CLEGLOUT_DPC)'
  @SuppressWarnings("unchecked")
  public Date findTheMostRecentDateTprAchievedLegalActionsDateForCase(int idCase, int idPerson,
                                                                      Collection<String> cdLegalActActions,
                                                                      Collection<String> cdLegalActActionsOth,
                                                                      Collection<String> cdHrTypCrtOrds,
                                                                      String cdOutComeTypeTpg, String cdOutComeTypeDpc) {
    Query query = getSession().createSQLQuery(
                                            " select max(dt) "
                                                           + " from ( "
                                                           + " select la.DT_CRT_ACT_DATE dt "
                                                           + " from LEGAL_ACTION la, EVENT e "
                                                           + " where la.ID_CASE = :idCase "                                                                                                                  
                                                           + " and la.ID_PERSON = :idPerson "
                                                           + " and la.ID_LEGAL_ACT_EVENT = e.ID_EVENT " 
                                                           + " and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                           + " and la.CD_LEGAL_ACT_ACTION in (:cdLegalActActions) "
                                                           + " union all "
                                                           + " select la.DT_CRT_ORD_DATE dt "
                                                           + " from LEGAL_ACTION la, EVENT e, LEGAL_ACTION_OUTCOME lao "
                                                           + " where la.ID_CASE = :idCase "
                                                           + " and la.ID_PERSON = :idPerson "
                                                           + " and la.ID_LEGAL_ACT_EVENT = e.ID_EVENT "
                                                           + " and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                           + " and la.CD_HR_TYP_CRT_ORD in (:cdHrTypCrtOrds) "
                                                           + " and la.CD_LEGAL_ACT_ACTION in (:cdLegalActActionsOth) "
                                                           + " and la.DT_CRT_ORD_DATE is not null "
                                                           + " and la.ID_LEGAL_ACT_EVENT = lao.ID_LEGAL_ACT_EVENT " +
                                                           		" and lao.CD_OUTCOME = :cdOutComeTypeTpg " 
                                                           + " union all "
                                                           + " select la.DT_CRT_ORD_DATE dt "
                                                           + " from LEGAL_ACTION la, EVENT e "
                                                           + " where la.ID_CASE = :idCase "
                                                           + " and la.ID_PERSON = :idPerson "
                                                           + " and la.ID_LEGAL_ACT_EVENT = e.ID_EVENT " 
                                                           + " and (e.CD_EVENT_STATUS = 'APRV' or la.IND_COMPLETE = 'Y') "
                                                           + " and la.CD_LEGAL_ACT_ACTION in (:cdLegalActActionsOth) "                                                           
                                                           + " and la.DT_CRT_ORD_DATE is not null "
                                                           + " and la.ID_LEGAL_ACT_EVENT in (select lao.ID_LEGAL_ACT_EVENT "
                                                           + " from LEGAL_ACTION_OUTCOME lao "
                                                           + " where lao.CD_OUTCOME = :cdOutComeTypeDpc)"
                                                           + " ) ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdLegalActActionsOth", cdLegalActActionsOth); 
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds); 
    return (Date) query.uniqueResult();
  }
  
  // SMS#37448 : Wrote new method findLegalActionListByIdCaseByIdPersonByCdActionsByCdHrTypCrtOrds that will find legal
  // action for
  // given person in a given case where cdLegalActActions (Action drop down on page) is one of the VS (Voluntary
  // Surrender) OR
  // cdHrTypCrtOrds (Hearing Type/Court Order ) is one of the TPR's with cdOutcome of TPG OR
  // legal action with outcome of DPC
  @SuppressWarnings("unchecked")
  public LegalAction findLegalActionListByIdCaseByIdPersonByCdActionsByCdHrTypCrtOrds(
                                                                                      int idCase,
                                                                                      int idPerson,
                                                                                      Collection<String> cdLegalActActions,
                                                                                      Collection<String> cdHrTypCrtOrds,
                                                                                      String cdOutComeTypeTpg,
                                                                                      String cdOutComeTypeDpc) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String cdEventType = CodesTables.CEVNTTYP_LEG;
    String indComplete = "Y";
    Query query = getSession()
                              .createQuery(
                                           " select la from LegalAction la "
                                                           + "  where la.capsCase.idCase = :idCase "
                                                           + "      and la.event.cdEventType = :cdEventType "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + "     and  la.person.idPerson = :idPerson "
                                                           + "   and( la.cdLegalActAction in (:cdLegalActActions) "
                                                           + " or( la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao "
                                                           + " where lao.legalAction.capsCase.idCase =   la.capsCase.idCase "
                                                           + " and lao.legalAction.event.cdEventType = :cdEventType "
                                                           + " and lao.cdOutcome = :cdOutComeTypeTpg)) "
                                                           + " or la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " from LegalActionOutcome lao "
                                                           + " where lao.legalAction.capsCase.idCase =  la.capsCase.idCase "
                                                           + " and lao.legalAction.event.cdEventType = :cdEventType "
                                                           + " and lao.cdOutcome = :cdOutComeTypeDpc))"
                                                           + " order by la.dtCrtActDate asc) ");

    query.setInteger("idCase", idCase);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    return (LegalAction) firstResult(query);
  }
  
  //SMS#82989/65873:  Added method to find all legal actions in a given case for a given person
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionByIdCaseByIdPerson(int idCase, int idPerson) {
    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y";
    String cdEventType = CodesTables.CEVNTTYP_LEG;

    Query query = getSession().createQuery(
                                           "  from LegalAction la " + "  where la.event.capsCase.idCase = :idCase "
                                                           + "  and la.event.cdEventType = :cdEventType "
                                                           + "  and la.person.idPerson = :idPerson "
                                                           + "  and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "     or la.indComplete = :indComplete )"
                                                           + "  order by la.event.dtLastUpdate desc");
    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventType", cdEventType);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    return (List<LegalAction>) query.list();
  }
  
  // SMS#81144: MR-053 Added method to retrieve legal actions in a given case 
  // for a given person by legal action type and hearing type/court order
  @SuppressWarnings("unchecked")
  public List<LegalAction> findLegalActionsByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(
                                                                                       int idCase,
                                                                                       int idPerson,
                                                                                       Collection<String> cdLegalActActions,
                                                                                       Collection<String> cdHrTypCrtOrds,
                                                                                       String orderBy) {

    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action check box selected
    String orderByClause = null;
    if (orderBy.equals("F")) { // sorting by File Motion
      orderByClause = " order by nvl(la.dtLegalActDateFiled, :minDate) desc";
    } else if (orderBy.equals("A")) { // sorting by Date Appealed
      orderByClause = " order by nvl(la.dtCrtActDate, :minDate) desc";
    } else if (orderBy.equals("O")) { // sorting by Court Order Date
      orderByClause = " order by nvl(la.dtCrtOrdDate, :minDate) desc"; // If dtCrtOrdDate is null then use the MIN_JAVA_DATE to push to the end
    } else {
      orderByClause = " order by nvl(la.event.dtLastUpdate, :minDate) desc";
    }

    Query query = getSession().createQuery(
                                           " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.cdLegalActAction in ( :cdLegalActActions ) "
                                                           + " and la.cdHrTypCrtOrd in ( :cdHrTypCrtOrds ) "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + orderByClause);

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    return (List<LegalAction>) query.list();
  }

  // SMS #97845: MR-074-2 
  // Added method to retrieve legal actions in a given case 
  // for a given person by legal action type and hearing type/court order
  @SuppressWarnings("unchecked")
  public LegalAction findLegalActionByIdCaseByIdPersonBycdActionByCdHrTypCrtOrds(int idCase, int idPerson,
                                                                                 Collection<String> cdHrTypCrtOrds,
                                                                                 String cdLegalActAction, String orderBy) {

    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action Complete check box selected
    String orderByClause = null;
    if (orderBy.equals("F")) { // sorting by File Motion
      orderByClause = " order by nvl(la.dtLegalActDateFiled, :minDate) desc";
    } else if (orderBy.equals("A")) { // sorting by Court Action Date
      orderByClause = " order by nvl(la.dtCrtActDate, :minDate) desc";
    } else if (orderBy.equals("O")) { // sorting by Court Order Date
      orderByClause = " order by nvl(la.dtCrtOrdDate, :minDate) desc"; // If dtCrtOrdDate is null then use the MIN_JAVA_DATE to push to the end
    } else {
      orderByClause = " order by nvl(la.event.dtLastUpdate, :minDate) desc";
    }

    Query query = getSession().createQuery(
                                           " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.cdLegalActAction = :cdLegalActAction "
                                                           + " and la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) "
                                                           + orderByClause);

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setString("cdLegalActAction", cdLegalActAction);
    query.setTimestamp("minDate", DateHelper.MIN_JAVA_DATE);
    return (LegalAction) firstResult(query);
  }
  
  
  // SMS#95590: MR-053 Retrieve latest Permanency Hearing with
  // court languange for reasonable efforts to finalize permanency plan
  // ordered by court order date descending.
  @SuppressWarnings("unchecked")
  public LegalAction findLatestPrmncyHrgWithReasonbleEffByIdCaseByIdPerson(
                                                                                       int idCase,
                                                                                       int idPerson) {

    String cdEventStatus = CodesTables.CEVTSTAT_APRV;
    String indComplete = "Y"; // legal action check box selected

    List<String> cdLegalActActions = new ArrayList<String>();
    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    List<String> cdLegalActionCrtLangs = new ArrayList<String>();
    
    //check for permanency hearing
    // set legal action type to search by
    cdLegalActActions.add(CodesTables.CLEGCPS_HRG); // Hearing
    cdLegalActActions.add(CodesTables.CLEGCPS_RCO); // Receive Court Order
    // set legal action hearing type/court order to search by
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_PRM); // Permanency
    // set court language
    cdLegalActionCrtLangs.add(CodesTables.CCRTLANG_RFP); // Reasonable effort to finalize permanency plan

    Query query = getSession().createQuery(
                                           " from LegalAction la " + " where la.capsCase.idCase = :idCase "
                                                           + " and la.person.idPerson = :idPerson "
                                                           + " and la.cdLegalActAction in ( :cdLegalActActions ) "
                                                           + " and la.cdHrTypCrtOrd in ( :cdHrTypCrtOrds ) "
                                                           + " and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "      or la.indComplete = :indComplete ) " 
                                                           + " and exists ( select 'x' "
                                                           + "              from LegalActionCrtLang cl "
                                                           + "              where cl.legalAction.event.idEvent = la.event.idEvent "
                                                           + "              and cl.cdCrtLang in ( :cdLegalActionCrtLangs ) ) "
                                                           + " order by nvl(la.dtCrtOrdDate, :minDate) desc " );

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds);
    query.setParameterList("cdLegalActionCrtLangs", cdLegalActionCrtLangs);
    query.setString("cdEventStatus", cdEventStatus);
    query.setString("indComplete", indComplete);
    query.setTimestamp("minDate", DateHelper.MIN_JAVA_DATE);
    return (LegalAction) firstResult(query);
  }
  
  @SuppressWarnings("unchecked")
  public List<LegalAction> findTprVsLegalActionsByIdCaseIdPerson(int idCase, int idPerson, Collection<String> cdLegalActActions,
                                                         Collection<String> cdHrTypCrtOrds, 
                                                         String cdOutComeTypeTpg, String cdOutComeTypeDpc) {
    Query query = getSession().createQuery(
                                            " select la from LegalAction la "
                                                           + "  where la.capsCase.idCase = :idCase "
                                                           + "  and ( la.event.cdEventStatus = :cdEventStatus "
                                                           + "        or la.indComplete = :indComplete ) "
                                                           + "  and  la.person.idPerson = :idPerson "
                                                           + "  and( la.cdLegalActAction in (:cdLegalActActions) "
                                                           + "      or( la.cdHrTypCrtOrd in (:cdHrTypCrtOrds) "
                                                           + " 			and la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " 									from LegalActionOutcome lao "
                                                           + "	 								where lao.legalAction.capsCase.idCase =   la.capsCase.idCase "
                                                           + " 									and lao.cdOutcome = :cdOutComeTypeTpg)) "
                                                           + " 		or la.event.idEvent in (select lao.legalAction.idLegalActEvent "
                                                           + " 		from LegalActionOutcome lao "
                                                           + " 		where lao.legalAction.capsCase.idCase =  la.capsCase.idCase "
                                                           + " 		and lao.cdOutcome = :cdOutComeTypeDpc))"
                                                           + " order by la.event.dtEventOccurred desc) ");

    query.setInteger("idCase", idCase);
    query.setInteger("idPerson", idPerson);
    query.setString("cdOutComeTypeTpg", cdOutComeTypeTpg);
    query.setString("cdOutComeTypeDpc", cdOutComeTypeDpc);
    query.setParameterList("cdLegalActActions", cdLegalActActions);
    query.setParameterList("cdHrTypCrtOrds", cdHrTypCrtOrds); 
    query.setString("cdEventStatus", CodesTables.CEVTSTAT_APRV);
    query.setString("indComplete", ArchitectureConstants.Y);
    return (List<LegalAction>) query.list();
  }
}
