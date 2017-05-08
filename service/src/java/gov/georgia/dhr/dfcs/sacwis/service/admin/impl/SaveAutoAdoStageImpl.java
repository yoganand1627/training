package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;
/** Change History:
 **  Date        User              Description
 **  --------    ----------------  ----------------------------------------------------------------------------------------------------
 *   09/22/2008  ssubram           STGAP00010231 - Added code for Adoption enhancement
 *   10/17/2008  ssubram           STGAP00010718 - Fixed Exchange child event is getting created more than once
 *   11/03/2008  ssubram           STGAP00010780 - Adding Alerts for Legal Action (Adoption Enhancements)
 *   02/02/2009  hjbaptiste        STGAP00012166 - Removed Permanent custody to DHR, Perm Custody to Specified Relative for Adoption
 *                                                 and Perm Custody to a 3rd Party as required selected Outcomes to open ADO when TPR is selected
 *                                                 as the Hearing Type. As long as Deceased Parents - Permanent Custody to DHR is selected,
 *                                                 the ADO stage will be created regardless of the Action and Hearing Type
 *   02/26/2009  bgehlot           STGAP00012197 - Removed the dissolution logic in the PAD stage which checks to see if all 
 *                                                 people marked as Adoptive Parent (per Person Detail) have had any combination 
 *                                                 of the legal actions on them.
 *                                                 The system will update the new childs Person Characteristics page to 
 *                                                 indicate there has been an adoption dissolution and the date of the 
 *                                                 dissolution regardless of Adoptive Parents.
 *   02/27/2009  bgehlot           STGAP00012482 - Changed code at three places for the Alerts. Comments included below. 
 *   03/02/2009  arege             STGAP00012641 - Modified conditions for saving the following alerts 
 *                                                 DFCS obtained TPR or Voluntary Surrender for <Person Name> and
 *                                                 A Legal Action has been saved with an outcome for <Child Name> that has had TPR-Granted.
 *   03/05/2009  bgehlot           STGAP00012482 - Added the condition != 0 otherwise the alerts were being created for non TPR/VS Types also.
 *   03/11/2009  mxpatel           STGAP00012641 - added condition to make sure that " DFCS obtained TPR or Voluntary Surrender for" is only displayed 
 *   											  for the first TPR/VS legal action.  
 *   03/23/2009  mxpatel           STGAP00012762 - added code to make sure that alerts are only created for the first TPR/VS for the case.
 *   03/30/2009  mxpatel           STGAP00013045 - added code to find an existing ADO stage's id and populate it to create the EXC event.
 *   07/24/2009  hjbaptiste        STGAP00014781 - Send the Appeal to TPR filed for Case alert only to the Regional Adoption Exchange Consultants
 *                                                 and RACs. 
 *                                               - Send TPR has been updated alert only to the Regional Adoption Exchange Consultants.
 *                                               - Removed alert sent if any LegalAction with TPG completed or approved 
 *                                               - Send the Adoption Dissolution alert to the Regional Adoption Exchange Consultants
 *                                                 and RACs.  
 *                                               - Removed the Adoption Finalized for Case alert  
 *                                               - Removed the Permanent custody to a relative for purpose of adoption alert
 *   09/02/2009  cwells            STGAP00012762 - Corrected the logic to create TPR/VS alerts for initial TPR/VS legal action  
 *   02/28/2011  schoi             SMS #97845: MR-074-2 - Added logic to include the VS/TPR Putative Father to the ADO stage opening and alerts 
 *   03/10/2011  schoi             SMS #97845: MR-074-2 - Per code peer review, added missing TPR-Putative Father (CLHECOT_TPP) to the courtOrderIsTPR method
 *   04/11/2011  hnguyen           SMS#103401: MR-074-2 Corrected TPR/VS query count that causes alerts to not properly generate.                                            
 *   04/12/2011  hnguyen           SMS#103401: MR-074-2 Corrected condition to generated alert for RAC and Regional Adoption Exchange.                                            
 *                                                
 *                                        
 *                                        
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ExchangeChildDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.LegalActionOutcomeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SiblingGroupDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.LegalAction;
import gov.georgia.dhr.dfcs.sacwis.db.LegalActionOutcome;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SiblingGroup;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAutoAdoStage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStageProgression;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN88SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN35SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN88SO;

public class SaveAutoAdoStageImpl extends BaseServiceImpl implements SaveAutoAdoStage {
  
  private static final String EXCHANGE_CHILD_TASK_CD = "9530";
  
  private CapsCaseDAO capsCaseDAO = null;
  
  private EventDAO eventDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private LegalActionDAO legalActionDAO = null;
  
  private LegalActionOutcomeDAO legalActionOutcomeDAO = null;
    
  private PersonDAO personDAO = null;

  private SiblingDAO siblingDAO = null;

  private SiblingGroupDAO siblingGroupDAO = null;
  
  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;
  
  private SaveStageProgression saveStageProgression = null;

  private TodoDAO todoDAO = null;
  
  private UnitEmpLinkDAO unitEmpLinkDAO = null;
  
  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }  

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setLegalActionDAO(LegalActionDAO legalActionDAO) {
    this.legalActionDAO = legalActionDAO;
  }

  public void setLegalActionOutcomeDAO(LegalActionOutcomeDAO legalActionOutcomeDAO) {
    this.legalActionOutcomeDAO = legalActionOutcomeDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setSiblingDAO(SiblingDAO siblingDAO) {
    this.siblingDAO = siblingDAO;
  }

  public void setSiblingGroupDAO(SiblingGroupDAO siblingGroupDAO) {
    this.siblingGroupDAO = siblingGroupDAO;
  }
  
  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  
  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }
  
  public void setSaveStageProgression(SaveStageProgression saveStageProgression) {
    this.saveStageProgression = saveStageProgression;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  /**
   * STGAP00010231 - Adoption Enhancement: Create an ADO stage for certain legal actions for a child that has an
   * FCC Stage. If the legal action is either a voluntary surrender or parental rights (VS) or a 
   * termination of parental rights (TPR) then an ADO stage will be automatically created.
   * If the ADO stage has already been manually opened, then an ADO stage should not be automatically
   * created. 
   */
  public CCMN35SO saveAutoAdoStage(CCMN35SI ccmn35si) throws ServiceException{
    CCMN35SO ccmn35so = new CCMN35SO();
    boolean adoStagePresent = false;
    Integer idEvent = ccmn35si.getUlIdEvent();
    Integer idCase = ccmn35si.getUlIdCase();
    Integer idStage = ccmn35si.getUlIdStage();
    //Get the Primary Child Person ID
    Integer idPerson = stagePersonLinkDAO.findIdPersonForChildByIdStage(idStage);
    Integer idCaseManager = stagePersonLinkDAO.findIdPersonForCaseManagerByIdStage(idStage);
    Integer idUser = ccmn35si.getUlIdCntrctWkr();
    String cdStage = ccmn35si.getSzCdStage();
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    Stage stage = stageDAO.findStageByIdStage(idStage);
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);  
    Integer adoIdStage = 0;
    //Find the legal action for the event ID
    LegalAction legalAction = legalActionDAO.findLegalActionByIdLegalActEvent(idEvent);
    //Get the legal action code
    String action = legalAction.getCdLegalActAction();
    String htco = legalAction.getCdHrTypCrtOrd();
    //Get the Update to Previous Action check box value
    String indUpPrevAct = legalAction.getIndUpPrevAct();
    //Get the Court Order Date
    Date dtCrtAct= legalAction.getDtCrtActDate();
    //Get all the legal action outcome records
    List<LegalActionOutcome> legalActionOutcomeList = legalActionOutcomeDAO.findLegalActionOutcomeList(idEvent);
    List<String> outcomes = new ArrayList<String>();
    Iterator<LegalActionOutcome> legalActItr = legalActionOutcomeList.iterator();
    //Get the outcomes
    while (legalActItr.hasNext()){
      LegalActionOutcome legalActionOutcome = legalActItr.next();
      outcomes.add(legalActionOutcome.getCdOutcome());
    }
    //Do the auto save for ADO and FCC stage
    if ((CodesTables.CSTAGES_ADO.equals(cdStage) || CodesTables.CSTAGES_SUB.equals(cdStage))){
      //Check for an existing ADO stage for the case
      long adoStageCount = stageDAO.countOpenAdoStageByIdPersonIdCase(idPerson, idCase);
      if (adoStageCount > 0){
        adoStagePresent = true;
        //mxpatel wrote this for defect #STGAP00013045 to find the idStage of the existing ADO stage.
        adoIdStage = stageDAO.findIdStageForOpenAdoStageByIdPersonIdCase(idPerson, idCase);
      }

      // SMS #97845: MR-074-2 
      // Added Voluntary Surrender-Putative Father (CLEGCPS_VPF) 
      // and TPR-Putative Father (CLHECOT_TPP) to the condition 
      if ((CodesTables.CLEGCPS_VLM.equals(action)   || CodesTables.CLEGCPS_VAM.equals(action) 
           || CodesTables.CLEGCPS_VAF.equals(action) || CodesTables.CLEGCPS_VSF.equals(action)
           || CodesTables.CLEGCPS_VLS.equals(action) || CodesTables.CLEGCPS_VBF.equals(action)
           || CodesTables.CLEGCPS_VPF.equals(action)) 
          ||((CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco) 
              || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
              || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco)
              || CodesTables.CLHECOT_TPP.equals(htco)) 
              && outcomes.contains(CodesTables.CLEGLOUT_TPG))
          || outcomes.contains(CodesTables.CLEGLOUT_DPC)) {
  
        //If no ADO stage present, create a new ADO stage
        if(!adoStagePresent){
          CCMN88SI ccmn88si = populateCCMN88SI_StageProgress(ccmn35si, idPerson, idCaseManager);
          CCMN88SO ccmn88so = saveStageProgression.saveStageProgression(ccmn88si);
          //New ADO Stage ID created in the save stage progression process
          adoIdStage = ccmn88so.getUlIdStage();
          ccmn35so.setUlIdStage(adoIdStage);
          adoStagePresent = true;
        }
        
        //update # of children available for adoption
        updateSiblingGroupNumberAvailableForAdoption(ccmn35si,idPerson);
      }
      //Create the Exchange Child Detail event for an ADO stage and make sure there is no 
      //Exchange Child detail event present.
      if (adoStagePresent){
        //Check whether there is an Exchange child detail event for the given stage id.
        //STGAP00010718 - Fixed Exchange child event is getting created more than once
        long countExchangeChildEvent = eventPersonLinkDAO.countEventPersonLinkByIdPersonIdCaseForExchangeChild(idPerson, idCase);
        if (countExchangeChildEvent <= 0){
          //Add an Exchange Child Event. No need for adding an Exchange child detail record
          //as it will be loaded and saved at the time when the user opens the event and saves the
          //Exchange Child detail record
          Event event = new Event();
          populate_SaveEvent(event, adoIdStage, idCase, idUser, idPerson);
          //Save Event
          int exchangeChildIdEvent = eventDAO.saveEventReturnsEventId(event);
          EventPersonLink eventPersonLink = populate_SaveEventPersonLink(idPerson, exchangeChildIdEvent, adoIdStage);
          //Save Event Person Link
          eventPersonLinkDAO.saveEventPersonLink(eventPersonLink);
          //TODO 2. Add alerts for SAU and allow access to the Exchange Child page
        }
      }
    }else if (CodesTables.CSTAGES_PAD.equals(cdStage)){
      //STGAP00012197 - Removed the dissolution logic in the PAD stage which checks to see if all people marked as 
      //Adoptive Parent (per Person Detail) have had any combination of the legal actions on them.
      //The system will update the new childs Person Characteristics page to indicate there has been an adoption dissolution and the date of the dissolution 
      //regardless of Adoptive Parents.
      
      //Get the legal actions on the PAD stage to determine whether an adoption dissolution required
      List<String> cdStages = new ArrayList<String>();
      cdStages.add(CodesTables.CSTAGES_PAD);
      List<LegalAction> legalActionsOnPADStage = legalActionDAO.findLegalActionListForAdoptionDissolution(idCase, idPerson, cdStages);
      if ((null != legalActionsOnPADStage) && (legalActionsOnPADStage.size() > 0)){
        //Find the person object and update it.
        Person person = personDAO.findPersonByIdPerson(idPerson);
        //Find the latest Legal Action date
        Date latestActionDt = DateHelper.MIN_JAVA_DATE;
        Iterator<LegalAction> legalActionItr = legalActionsOnPADStage.iterator();
        while (legalActionItr.hasNext()){
          legalAction = legalActionItr.next();
          if(DateHelper.isAfter(legalAction.getDtCrtActDate(),latestActionDt)){ 
            latestActionDt = legalAction.getDtCrtActDate();
          }
        }
        //Set the Dissolution Indicator and Dissolution Date
        person.setIndAdoptDisluton(ArchitectureConstants.Y);
        person.setDtDissolution(latestActionDt);
        //Update Person Table
        personDAO.savePerson(person);

        //Send dissolution alert
        String personName = personDAO.findNmFullByIdPerson(idPerson); 
        String todoDesc = "Adoption Dissolution for "+personName;
        String cdCounty = capsCase.getCdCaseCounty();
        if(cdCounty != null){
          if(cdCounty.length() == 1 ){
            cdCounty = "00" + cdCounty;
          } else if (cdCounty.length() == 2){
            cdCounty = "0" + cdCounty;
          }
        }
        //Get the region of the county
        String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
        //Find Regional Adoption Coordinators
        List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
        if (listIsValid(adoExchangeConsultants)) {
          Iterator<Integer> itrAdoExchangeConsultants = adoExchangeConsultants.iterator();
          while (itrAdoExchangeConsultants.hasNext()) {
            int idAssigned = (Integer) itrAdoExchangeConsultants.next();
            todoSaveHelper(todoDesc, null, idAssigned, dtToday, capsCase, stage);
          }
        }
      }
    }
    //STGAP00010780 - Adding Alerts for Legal Action (Adoption Enhancements)
    //Get the legal actions on the Selected stage to determine whether an adoption dissolution required
    Person person = personDAO.findPersonByIdPerson(idPerson);
 
    List<String> cdStages = new ArrayList<String>();
    cdStages.add(cdStage);
    //TODO: remove TPR Father and add the rest of the six
    // SMS #97845: MR-074-2 
    // Added Voluntary Surrender-Putative Father (CLEGCPS_VPF) and TPR-Putative Father (CLHECOT_TPP) to the DAO  method
    List<LegalAction> legalActionsOnSelectedStage = legalActionDAO.findLegalActionListForAllVSTpr(idCase, idPerson,
                                                                                                  cdStages);
    //STGAP00012482: Added the condition != 0 otherwise the alerts were being created for non TPR/VS Types also.
    if (legalActionsOnSelectedStage.size() != 0 && legalActionsOnSelectedStage.size() == 1){
      String cdEventStatus = null;
      cdEventStatus = legalActionsOnSelectedStage.get(0).getEvent().getCdEventStatus();
      //Send alerts only on the first time when the event status is either null or PEND
      //Used reverse logic to avoid Null Pointer Exception.
      if (!(cdEventStatus != null && CodesTables.CEVTSTAT_APRV.equals(cdEventStatus))){
        //Get the Primary Case Worker
        Integer idPrimaryCaseWorker = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,
                                                                                                 CodesTables.CROLEALL_PR);
        //****ALERT*****It has been 6 months since <Person Name> has had TPR/VS********************

        //STGAP00012482: Changed todays date to first TPR/VS Court Action Date. So now alert s due date would be 
        //               6 Months after the first TPR/VS Court Action Date.         
        Date sixMonthsFromCrtActDate = DateHelper.addToDate(dtCrtAct, 0, 6, 0);
        String todoDesc = "It has been 6 months since "+person.getNmPersonFull()+" has had TPR/VS.";
        String todoLongDesc = "It has been 6 months since "+person.getNmPersonFull()+" has had TPR/VS.";
        todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, sixMonthsFromCrtActDate, capsCase, stage);
      }
    }
    
    //****ALERT*****DFCS obtained TPR or Voluntary Surrender for <Person Name>********************
    // mxpatel changed this If statement to only create these alerts for TPR/VS legal actions for defect #STGAP00012762
    // SMS #97845: MR-074-2 
    // Added Voluntary Surrender-Putative Father (CLEGCPS_VPF) 
    // and TPR-Putative Father (CLHECOT_TPP) to the condition 
    if ((CodesTables.CLEGCPS_VLM.equals(action) || CodesTables.CLEGCPS_VAM.equals(action)
         || CodesTables.CLEGCPS_VAF.equals(action) || CodesTables.CLEGCPS_VSF.equals(action)
         || CodesTables.CLEGCPS_VLS.equals(action) || CodesTables.CLEGCPS_VBF.equals(action) || CodesTables.CLEGCPS_VPF
                                                                                                                       .equals(action))
        || ((CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco)
             || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
             || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco) || CodesTables.CLHECOT_TPP
                                                                                                                       .equals(htco)) && outcomes
                                                                                                                                                 .contains(CodesTables.CLEGLOUT_TPG))
        || outcomes.contains(CodesTables.CLEGLOUT_DPC)) {
      // STGAP00012641 Added following condition to check if the Legal action was being updated,
      // if yes do not create this alert as this has already been created once.
      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      // Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      // Find Regional Adoption Coordinators
      List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
      // Find Regional Adoption Exchange Consultants
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

      //list of VS legal Actions
      List<String> cdVsLegalActions = new ArrayList<String>();
      // SMS #97845: MR-074-2
      cdVsLegalActions.addAll(ServiceConstants.LA_VOLUNTARY_SURRENDER_MOTHER_TYPES);
      cdVsLegalActions.addAll(ServiceConstants.LA_VOLUNTARY_SURRENDER_FATHER_TYPES);
      
      //Legal Action 
      String cdEventType = CodesTables.CEVNTTYP_LEG;
      //outcomes
      String cdOutComeTypeTpg = CodesTables.CLEGLOUT_TPG;
      String cdOutComeTypeDpc = CodesTables.CLEGLOUT_DPC;
      //list of TPR hearing types
      List<String> cdHrTypCrtOrds = new ArrayList<String>();
      // SMS #97845: MR-074-2
      cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_MOTHER_TYPES);
      cdHrTypCrtOrds.addAll(ServiceConstants.LA_TPR_FATHER_TYPES);
      
      List<String> cdOutComeTypes = new ArrayList<String>();
      cdOutComeTypes.add(cdOutComeTypeTpg);
      cdOutComeTypes.add(cdOutComeTypeDpc);

      // STGAP00012762 Current Legal Action has been saved to the database already so if we only 
      // get back 1 TPR/VS legal action it is considered the initial one and the alert must be sent. 
      long cntTPRVSLegalAction = legalActionDAO.countTprVsLegalActionByIdCase(idCase, cdVsLegalActions, cdHrTypCrtOrds, cdEventType, cdOutComeTypeTpg, cdOutComeTypeDpc, idPerson);
      
      if (cntTPRVSLegalAction < 2) {
        List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
        if (listIsValid(racList)) {
          racAndAuthorizedSauList.addAll(racList);
        }
        if (listIsValid(adoExchangeList)) {
          racAndAuthorizedSauList.addAll(adoExchangeList);
        }
        // Send alert to Regional Adoption Exchange Consultants and RACs
        if (listIsValid(racAndAuthorizedSauList)) {
          Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
          while (itrRacAndAuthorizedSauList.hasNext()) {
            int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
            String todoDesc = "DFCS obtained TPR or Voluntary Surrender for " + person.getNmPersonFull();
            String todoLongDesc = "DFCS obtained TPR or Voluntary Surrender for " + person.getNmPersonFull();
            todoSaveHelper(todoDesc, todoLongDesc, idAssigned, dtToday, capsCase, stage);
          }
        }
       
        Integer idPrimaryCaseWorker = stagePersonLinkDAO
                                                        .findIdPersonByIdStageAndCdStagePersRole(
                                                                                                 idStage,
                                                                                                 CodesTables.CROLEALL_PR);

        // ****ALERT*****Child Life History is due in 60 days********************
        String todoDesc = "Child Life History is due in 60 days.";
        String todoLongDesc = "Child Life History is due in 60 days.";
        todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, dtToday, capsCase, stage);

        // ****ALERT*****You must conduct staffing with the Foster Parents of <Person Name> within 30 days*****
        todoDesc = "You must conduct staffing with the Foster Parents within 30 days.";
        todoLongDesc = "You must conduct staffing with the Foster Parents of " + person.getNmPersonFull()
                       + " within 30 days.";
        todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, dtToday, capsCase, stage);
      }
    }
    //****ALERT*****Appeal to TPR filed the Case <Case Name>********************
    // SMS #97845: MR-074-2 
    // Added TPR-Putative Father (CLHECOT_TPP) to the condition
    if ((CodesTables.CLEGCPS_APL.equals(action)   && 
                    ((CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco) 
                    || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
                    || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco)
                    || CodesTables.CLHECOT_TPP.equals(htco))))) {
      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      //Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      // Find Regional Adoption Coordinators
      List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
      // Find Regional Adoption Exchange Consultants
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

      List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
      if (listIsValid(racList)) {
        racAndAuthorizedSauList.addAll(racList);
      }
      if (listIsValid(adoExchangeList)) {
        racAndAuthorizedSauList.addAll(adoExchangeList);
      }
      // Send alert to Regional Adoption Exchange Consultants and RACs
      if (listIsValid(racAndAuthorizedSauList)) {
        Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
        while (itrRacAndAuthorizedSauList.hasNext()) {
          int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
          String todoDesc = "Appeal to TPR filed the Case "+capsCase.getNmCase();
          String todoLongDesc = "Appeal to TPR filed the Case "+capsCase.getNmCase();
          todoSaveHelper(todoDesc, todoLongDesc, idAssigned, dtToday, capsCase, stage);
        }
      }
    }
    
    //****ALERT*****Provides child foster parents with Notification to Foster Parents of Intent******** 
    //**************to Petition for Termination of Parental Rights********************
    // SMS #97845: MR-074-2 
    // Added TPR-Putative Father (CLHECOT_TPP) to the condition
    if (CodesTables.CLEGCPS_LAR.equals(action) && 
                    ((CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco) 
                    || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
                    || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco)
                    || CodesTables.CLHECOT_TPP.equals(htco)))) {
      Date fiveDaysFromToday = DateHelper.addToDate(dtToday, 0, 0, 5);
      //Get the Primary Case Worker
      Integer idPrimaryCaseWorker = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,
                                                                                               CodesTables.CROLEALL_PR);
      //STGAP00012482: Changed the description to match the Design Document.  
      String todoDesc = "Notify foster parents of Intent to Petition for Termination of Parental Rights";
      String todoLongDesc = "Provides child foster parents with Notification to Foster Parents of Intent "+
                            "to Petition for Termination of Parental Rights";
      todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, fiveDaysFromToday, capsCase, stage);
    }

    //****ALERT*****A Legal Action of TPR has been updated******
    // SMS #97845: MR-074-2 
    // Added TPR-Putative Father (CLHECOT_TPP) to the condition
    if (indUpPrevAct != null && ArchitectureConstants.Y.equals(indUpPrevAct) && 
                    (CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco) 
                     || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
                     || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco)
                     || CodesTables.CLHECOT_TPP.equals(htco))) {
      String cdCounty = capsCase.getCdCaseCounty();
      if(cdCounty != null){
        if(cdCounty.length() == 1 ){
          cdCounty = "00" + cdCounty;
        } else if (cdCounty.length() == 2){
          cdCounty = "0" + cdCounty;
        }
      }
      //Get the region of the county
      String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
      List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
      // Find Regional Adoption Exchange Consultants
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);

      List<Integer> racAndAuthorizedSauList = new ArrayList<Integer>();
      if (listIsValid(racList)) {
        racAndAuthorizedSauList.addAll(racList);
      }
      if (listIsValid(adoExchangeList)) {
        racAndAuthorizedSauList.addAll(adoExchangeList);
      }
      // Send alert to Regional Adoption Exchange Consultants and RACs
      if (listIsValid(racAndAuthorizedSauList)) {
        Iterator<Integer> itrRacAndAuthorizedSauList = racAndAuthorizedSauList.iterator();
        while (itrRacAndAuthorizedSauList.hasNext()) {
          int idAssigned = (Integer) itrRacAndAuthorizedSauList.next();
          String todoDesc = "A Legal Action of TPR has been updated.";
          String todoLongDesc = "A Legal Action of TPR has been updated.";
          todoSaveHelper(todoDesc, todoLongDesc, idAssigned, dtToday, capsCase, stage);
        }
      }
    }
    
    // ****ALERT*****It has been 35 days since <Child Name> TPR has been created.********
    //**************Please check the case for Appeals********************
    
    //STGAP00012482: Changed todays date to the Court Action Date. So now alerts due date would be 
    //               35 days after the Court Action Date. Also updated the condition by checking for 
    //               Court Order Filed as an Action.
    
    // SMS #97845: MR-074-2 
    // Added TPR-Putative Father (CLHECOT_TPP) to the condition
    if (CodesTables.CLEGCPS_COF.equals(action) && 
                    (CodesTables.CLHECOT_TPM.equals(htco) || CodesTables.CLHECOT_TFL.equals(htco) 
                    || CodesTables.CLHECOT_TFF.equals(htco) || CodesTables.CLHECOT_TFB.equals(htco)
                    || CodesTables.CLHECOT_TPA.equals(htco) || CodesTables.CLHECOT_TFA.equals(htco)
                    || CodesTables.CLHECOT_TPP.equals(htco))) {
      Date thirtyFiveDaysFromCrtActDate = DateHelper.addToDate(dtCrtAct, 0, 0, 35);
      //Get the Primary Case Worker
      Integer idPrimaryCaseWorker = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,
                                                                                               CodesTables.CROLEALL_PR);
      String todoDesc = "It has been 35 days since TPR has been created.";
      String todoLongDesc = "It has been 35 days since "+person.getNmPersonFull()+" TPR has been created. "+
                            "Please check the case for Appeals.";
      todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, thirtyFiveDaysFromCrtActDate, capsCase, stage);
    }    
    return ccmn35so;
  }
  
  /**
   * This method will set the inputs into the CCMN88S service to stage progress.
   *
   * @param context data to pass to the save service
   */
  private CCMN88SI populateCCMN88SI_StageProgress(CCMN35SI ccmn35si, int idPerson, int idCaseManager) {
    CCMN88SI ccmn88si = new CCMN88SI();
    ArchInputStruct input = new ArchInputStruct();
    String setSzCdStageOpen = CodesTables.CSTAGES_ADO;
    input.setSzUserId(ccmn35si.getArchInputStruct().getSzUserId());
    ccmn88si.setArchInputStruct(input);
    ccmn88si.setUlIdStage(ccmn35si.getUlIdStage());
    ccmn88si.setUlIdPerson(idCaseManager);
    ccmn88si.setSzCdStage(CodesTables.CSTAGES_SUB);
    ccmn88si.setSzCdStageOpen(setSzCdStageOpen);
    ccmn88si.setSzCdStageReasonClosed(CodesTables.CSTAGES_SUB);
    ccmn88si.setSzCdStageProgram(CodesTables.CPGRMS_CPS);
    Person person = personDAO.findPersonByIdPerson(idPerson);
    ccmn88si.setSzNmPersonFull(person.getNmPersonFull());
    ccmn88si.setUlScrIdPrimChild(idPerson);
    ccmn88si.setCSysIndSStgOpenOnly(ArchitectureConstants.Y);

    return ccmn88si;
  }

  private void populate_SaveEvent(Event event, int idStage, int idCase, int idUser, int idPerson) {
    String desc = personDAO.findPersonByIdPerson(idPerson).getNmPersonFull() + "-" 
                    + idPerson + " has been registered with the exchange";
    Stage stage = stageDAO.findStageAndCapsCase(idStage);
    event.setStage(stage);
    event.setCapsCase(stage.getCapsCase());
    event.setPerson(personDAO.findPersonByIdPerson(idUser));
    event.setCdEventStatus(CodesTables.CEVTSTAT_NEW);
    event.setCdEventType(CodesTables.CEVNTTYP_EXC);
    event.setDtEventOccurred(new Date());
    event.setDtLastUpdate(null);
    event.setTxtEventDescr(desc);
    event.setCdTask(EXCHANGE_CHILD_TASK_CD);
  }
  
  private EventPersonLink populate_SaveEventPersonLink(int idPerson, int idEvent, int idCase){
    EventPersonLink eventPersonLink = new EventPersonLink();
    eventPersonLink.setPerson(personDAO.findPersonByIdPerson(idPerson));
    eventPersonLink.setEvent(eventDAO.findEventByIdEvent(idEvent));
    eventPersonLink.setCapsCase(capsCaseDAO.findCapsCaseByIdCase(idCase));
    return eventPersonLink;
  }

  
  private void updateSiblingGroupNumberAvailableForAdoption(CCMN35SI ccmn35si, int idPerson) {
    Integer idCase = ccmn35si.getUlIdCase();

    Integer idSiblingGroupInteger = siblingDAO.findSiblingGroupIdByIdPerson(idPerson);

    if (idSiblingGroupInteger != null && idSiblingGroupInteger.intValue() != 0) {// child is in a sibling group
      if (childLegalActionShowsAvailableForAdoption(idCase, idPerson)) {
        // do Nothing because the # should have been updated already
      } else {
        // update the number in group
        SiblingGroup siblingGroup = getPersistentObject(SiblingGroup.class, idSiblingGroupInteger);
        Integer numAvailable = siblingGroup.getNbrAvail();
        numAvailable = numAvailable + 1;
        siblingGroup.setNbrAvail(numAvailable);
        siblingGroupDAO.saveSiblingGroup(siblingGroup);
      }
    }
  }

  private boolean childLegalActionShowsAvailableForAdoption(int idCase, int idPerson) {
    List<LegalAction> legalActionList = retrieveLegalActionTPRAchieved(idCase, idPerson);
    return (legalActionList != null && !legalActionList.isEmpty());
  }

  private List<LegalAction> retrieveLegalActionTPRAchieved(int idCase, int idPerson) {
    List<String> cdLegalActActions = new ArrayList<String>();
    cdLegalActActions.add(CodesTables.CLEGCPS_VLM); // Voluntary Surrrender-Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAM); // Voluntary Surrender by Adoptive Mother
    cdLegalActActions.add(CodesTables.CLEGCPS_VAF); // Voluntary Surrender by Adoptive Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VSF); // Voluntary Surrender Legal/Biological Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VLS); // Voluntary Surrender Legal Father
    cdLegalActActions.add(CodesTables.CLEGCPS_VBF); // Voluntary Surrender Biological Father
    // SMS #97845: MR-074-2 
    cdLegalActActions.add(CodesTables.CLEGCPS_VPF); // Voluntary Surrender Putative Father

    String[] cdOutcomes = new String[4];
    cdOutcomes[0] = CodesTables.CLEGLOUT_TPC; // Perm Custody to DHR
    cdOutcomes[1] = CodesTables.CLEGLOUT_TPS; // Perm Custody to Specified Relative for Adoption
    cdOutcomes[2] = CodesTables.CLEGLOUT_TPT; // Perm Custody to a 3rd Party
    cdOutcomes[3] = CodesTables.CLEGLOUT_DPC; // Deceased Parents perm custody to dhr

    List<String> cdHrTypCrtOrds = new ArrayList<String>();
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFL);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPM);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPA);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFA);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFB);
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TFF);
    // SMS #97845: MR-074-2 
    cdHrTypCrtOrds.add(CodesTables.CLHECOT_TPP); // TPR-Putative Father
    
    List<LegalAction> legalActionsQueriedList = legalActionDAO
                                                              .findLegalActionListByIdStageByIdPersonBycdActionsByCdOutcomes(
                                                                                                                             idCase,
                                                                                                                             idPerson,
                                                                                                                             cdLegalActActions,
                                                                                                                             cdOutcomes,
                                                                                                                             cdHrTypCrtOrds);

    List<LegalAction> filteredLegalActionList = new ArrayList<LegalAction>();
    if (legalActionsQueriedList != null && !legalActionsQueriedList.isEmpty()) {
      Iterator allIterator = legalActionsQueriedList.iterator();

      while (allIterator.hasNext()) {
        LegalAction la = (LegalAction) allIterator.next();

        if (courtOrderIsTPR(la.getCdHrTypCrtOrd())) {
          // ensure that TPR was granted before returning this legal action
          // Get all the legal action outcome records for this event
          List<String> cdOutcomeList = legalActionOutcomeDAO.findCdOutcomeListByIdEvent(la.getIdLegalActEvent());
          if (cdOutcomeList.contains(CodesTables.CLEGLOUT_TPG) || cdOutcomeList.contains(CodesTables.CLEGLOUT_DPC)) {
            filteredLegalActionList.add(la);
          }
        } else {
          filteredLegalActionList.add(la);
        }
      }
    }

    return filteredLegalActionList;
  }

  private boolean courtOrderIsTPR(String cdHrTypCrtOrd) {
    if (StringHelper.isValid(cdHrTypCrtOrd)) {

      // SMS #97845: MR-074-2 
      // Added TPR-Putative Father (CLHECOT_TPP) to the condition 
      // Also, added missing TPR values to the condition, too
      return (cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPF) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPM)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPA) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFA)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFL) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFF)
              || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TFB) || cdHrTypCrtOrd.equals(CodesTables.CLHECOT_TPP));
    }
    return false;
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }
  
  private void todoSaveHelper(String todoDesc, String todoLongDesc, Integer idPerson, Date dueDate,
                              CapsCase capsCase, Stage stage){
    Todo todo = new Todo();
    String cdTask = "";
    Date dtToday = DateHelper.toJavaDate(DateHelper.getTodayCastorDate());
    todo.setPersonByIdTodoPersAssigned(personDAO.findPersonByIdPerson(idPerson));
    todo.setTxtTodoDesc(todoDesc);
    todo.setTxtTodoLongDesc(todoLongDesc);
    todo.setCdTodoTask(cdTask);
    todo.setDtTodoDue(dueDate);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setCapsCase(capsCase);
    todo.setDtTodoCreated(dtToday);
    todo.setStage(stage);
    todoDAO.saveTodo(todo);
  }

}
