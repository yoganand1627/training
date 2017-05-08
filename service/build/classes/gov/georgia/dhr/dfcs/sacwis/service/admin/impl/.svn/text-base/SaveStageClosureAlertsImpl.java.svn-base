package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoptionSubsidyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoptionSubsidy;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveStageClosureAlerts;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSpecializedUnitPersonnel;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN35SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SpecializedUnitPersonalBean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * This is the Service that performs the creation of alerts, setting of the Write History indicator and the AFCARS
 * indicator in the placement table on approval of a placement. <p/> <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User         Description
 *   --------  --------     --------------------------------------------------
 *   12/15/08  wjcochran    STGAP00011603 - Truncated Todo Description string length to 80 characters
 *                          for ADO stage closures to prevent a JDBC Exception.
 *   07/23/09  hjbaptiste   STGAP00014781 - Modified sendAlertsToSauUsers() to take in parameters that indicate 
 *                          whether to send the alert to the Regional Adoption Assistance Consultants, Regional 
 *                          Adoption Exchange Consultants and RACs 
 *                          - No longer sending alert when ADO stage is being closed with reason Adoption disruption 
 *   07/29/09  hjbaptiste   STGAP00014898 - Send stage closed due to any reason other than Adoption Finalized alert  
 *   08/28/09  cwells       STGAP00014383 - removing null pointer when trying to create TODO with caps resource information but 
 *                          child was in custody of relative.    
 *   09/16/09  cwells       STGAP00015363 - Only send the adoption finalized Home Alert and permanent retention todo/alert 
 *                          when closure reason is adoption finalized.   
 *   11/11/09  mxpatel      39371: modified code to retrieve capsResource.getStage() instead of getPersistentObject                                                     
 *
 *   11/13/09  cwells       37378 - Checking to see if the resource has an stage/case associated with it.  If it does not 
 *                          then we know this is a Non Incident Adoptive Home
 *   08/17/10  wjcochran    SMS #37399: Add a check for an open FCC Stage and check to see if the reason closed is
 *                          'Voluntary Surrender Revoked'. If an open FCC stage is not found and the Reason closed is
 *                          anything but 'Voluntary Surrender Revoked', then send the alert.
 *   12/12/10  htvo         SMS#81140 MR-074 AFCARS: if closure reason is ICPC - Adoption, send Alerts to PR (ICPC unit) and SE
 *                          and PR's supervisor (head of ICPC unit)      
 *   01/05/11  htvo         SMS#89239: exclude ICPC - Adoption from alert 'all Medicaid benefits should be discontinued' to MES
 *                          because for GA child adoption, benefits can continue in PAD stage, for ICPC, there is no PAD stage, and 
 *                          if they have Medicaid, it should continue. ICPC will not have Adoption Agreement.  
 *                          Fixed NPE on finding MES as secondary worker for the stage while making update for ICPC - Adoption  
 *                          SMS#88837: send alert to SE's supervisor too                  	                   
 *   07/26/11  cwells       SMS #116335: ECEM 5.0 Updated size of the MAX_NUM_ATTRIBUTES from 100(hardcoded) 
 *                          to ArchitectureConstants.MAX_NUM_ATTRIBUTES (200) to accommodate database field update 
 *                          and to respond better for future size increase
 * </pre>
 */

public class SaveStageClosureAlertsImpl extends BaseServiceImpl implements SaveStageClosureAlerts {
  // SMS #116335: ECEM 5.0 Updated hardcoded 100 to the constant variable
  public static final int MAX_NUM_ATTRIBUTES = ArchitectureConstants.MAX_NUM_ATTRIBUTES;

  private static final String PRIMARY_CHILD = CodesTables.CROLES_PC;

  private static final String TASK_CLOSE_ADO_STAGE = "8910";
  
  private static final String TASK_CLOSE_SUB_STAGE = "3420";
  
  private static final String TASK_CLOSE_PAD_STAGE = "9400";
  
  public static final String SEC_REG_FAM_INDP_STF = "76";
  
  public static final String SEC_REG_FAM_INDP_MGMNT_STF = "77";

  private StageDAO stageDAO = null;

  private UnitEmpLinkDAO unitEmpLinkDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private WorkloadDAO workloadDAO = null;

  private TodoDAO todoDAO = null;

  private AdoptionSubsidyDAO adoptionSubsidyDAO = null;

  private PersonDAO personDAO = null;
  
  private CapsResourceDAO capsResourceDAO = null;

  private PlacementDAO placementDAO = null;
  
  private EventDAO eventDAO = null;

  private RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel = null;
  
  private CheckIfUserHasRight checkIfUserHasRight = null;
  
  public void setCheckIfUserHasRight(CheckIfUserHasRight checkIfUserHasRight) {
    this.checkIfUserHasRight = checkIfUserHasRight;
  }
  
  public void setAdoptionSubsidyDAO(AdoptionSubsidyDAO adoptionSubsidyDAO) {
    this.adoptionSubsidyDAO = adoptionSubsidyDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public void setPlacementDAO(PlacementDAO placementDAO) {
	  this.placementDAO = placementDAO;
  }
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
	  this.capsResourceDAO = capsResourceDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
	  this.eventDAO = eventDAO;
  }
  
  public void setRetrieveSpecializedUnitPersonnel(RetrieveSpecializedUnitPersonnel retrieveSpecializedUnitPersonnel) {
    this.retrieveSpecializedUnitPersonnel = retrieveSpecializedUnitPersonnel;
  }
  
  public void saveStageClosureAlerts(CCMN35SI ccmn35si) {
    int idStage = ccmn35si.getUlIdStage();
    String cdTask = ccmn35si.getSzCdTask();
    String securityAttr = ccmn35si.getSzCdAttrRegSsStf();
    Stage stage = stageDAO.findStageAndCapsCase(idStage);
    CapsCase capsCase = stage.getCapsCase();
    if (stage != null && capsCase != null) {
      String todoDesc = "";
      String todoDescFinalized = "";
      String rsnClosed = stage.getCdStageReasonClosed();
      int idPrimaryChild = 0;
      Float ageInMonths = null;
      String nmStage = "";
      String nmPersonFull = "";
      Date dtToday = new Date();
      String cdCounty = capsCase.getCdCaseCounty();
      Map primaryChild = stagePersonLinkDAO.findIdChildNmStageByIdStage(idStage);
      if (primaryChild != null) {
        idPrimaryChild = (Integer) primaryChild.get("idPerson") == null ? 0 : (Integer) primaryChild.get("idPerson");
        ageInMonths = (Float) primaryChild.get("ageInMonths") == null ? 0 : (Float) primaryChild.get("ageInMonths");
        nmStage = (String) primaryChild.get("nmStage") == null ? "" : (String) primaryChild.get("nmStage");
        nmPersonFull = (String) primaryChild.get("nmPersonFull") == null ? ""
                                                                        : (String) primaryChild.get("nmPersonFull");
      }
      Integer idPrimaryCaseWorker = stagePersonLinkDAO
      .findIdPersonForCaseManagerByIdStage(idStage);
      //If PAD or ADO stage is being closed and there is no Adoption Assistance Agreement than send an alert 
      //to MES Worker
      if (TASK_CLOSE_ADO_STAGE.equals(cdTask) || TASK_CLOSE_PAD_STAGE.equals(cdTask)) {
    	  // SMS#89239: except when ADO stage is being closed with ICPC - Adoption
    	  if (!CodesTables.CCLOSADO_ICA.equals(rsnClosed)) {
	        AdoptionSubsidy adoptionSubsidy = adoptionSubsidyDAO.findAdoptionSubsidyByIdPerson(idPrimaryChild);
	        /* SMS #37399: Add a check for an open FCC Stage and check to see if the reason closed is
	         * 'Voluntary Surrender Revoked'. If an open FCC stage is not found and the Reason closed is
	         * anything but 'Voluntary Surrender Revoked', then send the alert.
	         */
	        Integer idOpenFccStage = stageDAO.findOpenFccStageByIdAdoStage(idStage);
	        if (adoptionSubsidy == null && idOpenFccStage == null && !CodesTables.CCLOSADO_VSR.equals(rsnClosed)) {
	          String todoLongDesc = nmStage + " has been closed and all Medicaid benefits should be discontinued";
	          todoDesc = StringHelper.truncate(todoLongDesc,80);
	          Date toDay = new Date();
	          List<Integer> idMESWorkerList = getMesWorkers(capsCase.getIdCase(), idStage);
	          if ((null != idMESWorkerList) && (idMESWorkerList.size() > 0)) {
	            for (int i = 0; i < idMESWorkerList.size(); i++) {
	              Integer idPerson = idMESWorkerList.get(i);
	              todoSaveHelper(todoDesc, todoLongDesc, idPerson, toDay, capsCase, stage);
	            }
	          }
	        }
    	  }
      }
     if (TASK_CLOSE_ADO_STAGE.equals(cdTask)) {
        // If ADO is being closed with any reason other than Adoption Finalized as reason closed
        // send alert to Case Manager and Regional Adoption Exchange Consultants
        if (!CodesTables.CCLOSADO_ADF.equals(rsnClosed)) {
          todoDesc = nmPersonFull + "'s ADO stage has been closed: "
                     + Lookup.simpleDecodeSafe(CodesTables.CCLOSADO, rsnClosed);
          todoDesc = StringHelper.truncate(todoDesc, 80);
          String todoLongDesc = nmPersonFull + "'s ADO stage has been closed: "
                                + Lookup.simpleDecodeSafe(CodesTables.CCLOSADO, rsnClosed);
          // MR-074 AFCARS: if closure reason is ICPC - Adoption, send Alerts to PR (ICPC unit) and SE 
     	  // and PR's supervisor (head of ICPC unit)
          if (CodesTables.CCLOSADO_ICA.equals(rsnClosed)) {
        	  sendICPCAdoptionFinalizedAlert(todoDesc, todoLongDesc, idPrimaryCaseWorker, dtToday, capsCase, stage);
          } else {
          // Send the Alert to authorized SAU Exchange Members
          sendAlertsToSauUsers(cdCounty, dtToday, capsCase, stage, todoDesc, todoLongDesc, false, true, false);
          }
        } else {
          //STGAP00015363 only send the adoption finalized Home Alert and permanent retention todo/alert 
          // when closure reason is adoption finalized. 
          // Get the Primary Case Worker
          String todoLongDescFinalized = "Submit "
                                         + nmStage
                                         + " foster care and adoption record and/or adoption assistance record to State Adoption Unit for Permanent Retention";
          todoDescFinalized = StringHelper.truncate(todoLongDescFinalized, 80);
          todoSaveHelper(todoDesc, todoDescFinalized, idPrimaryCaseWorker, dtToday, capsCase, stage);

          sendAdoptionFinalizedHomeAlert(idStage, idPrimaryCaseWorker);
        }
      }
      if (TASK_CLOSE_SUB_STAGE.equals(cdTask)) {
        //If FCC stage is being closed and the child is 14 years or older send alert to ILP - coordinator
        if (ageInMonths >= 168) {
          sendAlertToIlpCoordinator(capsCase, stage, cdCounty, securityAttr, nmStage);
        }
      //If FCC stage is being closed and the child is 18 years or older send alert to case manager
        if (ageInMonths >= 216) {
          // Get the Primary Case Worker
          String todoLongDesc = "Submit "
                                + nmStage
                                + " foster care and adoption record and/or adoption assistance record to State Adoption Unit for Permanent Retention";
          todoDesc = StringHelper.truncate(todoLongDesc, 80);
          todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, dtToday, capsCase, stage);
        }
      }
      if (TASK_CLOSE_PAD_STAGE.equals(cdTask)) {
        // If PAD stage is being closed send an alert to Case Manager
        // Get the Primary Case Worker
        
        String todoLongDesc = "Submit "
                              + nmStage
                              + " foster care and adoption record and/or adoption assistance record to State Adoption Unit for Permanent Retention";
        todoDesc = StringHelper.truncate(todoLongDesc, 80);
        todoSaveHelper(todoDesc, todoLongDesc, idPrimaryCaseWorker, dtToday, capsCase, stage);
        // If PAD stage is being closed with reason adoption dissolution send alerts to secondary case workers, 
        // Regional Adoption Assistance Consultants and Regional Adoption Exchange Consultants
        if (CodesTables.CCLOSPAD_AD.equals(rsnClosed)) {
          todoDesc = "Adoption for " + nmStage + "has been dissolved";
          String todoLongDesc3 = "Adoption for " + nmStage + "has been dissolved";
          // Getting the secondary case workers for each stage
          List<Integer> idSeCsMgrList = workloadDAO.findIdPersonsByIdStageAndCdStagePersRole(idStage,
                                                                                             CodesTables.CROLEALL_SE);
          
          int idPerson = 0;
          if (listIsValid(idSeCsMgrList)) {
            Iterator<Integer> itIdSeCsMgrList = idSeCsMgrList.iterator();
            while (itIdSeCsMgrList.hasNext()) {
              idPerson = itIdSeCsMgrList.next();
              todoSaveHelper(todoDesc, todoLongDesc3, idPerson, dtToday, capsCase, stage);
            }
          }
          sendAlertsToSauUsers(cdCounty, dtToday, capsCase, stage, todoDesc, todoLongDesc3, true, true, false);
        }
      }
    } else {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private void sendAlertsToSauUsers(String cdCounty, Date dtToday, CapsCase capsCase, Stage stage, String todoDesc, String todoLongDesc, 
                                    boolean sendToAdoptionAssistanceConsult, boolean sendToAdoptionExchangeConsult, boolean sendToRAC) {
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    // Get the region of the county
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> authorizedSauList = new ArrayList<Integer>();
    if (sendToAdoptionAssistanceConsult) {
      // Get the Regional Adoption Assistance Consultants list
      List<Integer> adoAssistanceList = unitEmpLinkDAO.findSAUAdoptionSpecSupRegionalMembersByIdRegion(cdRegion);
      if (listIsValid(adoAssistanceList)) {
        authorizedSauList.addAll(adoAssistanceList);
      }
    }
    if (sendToAdoptionExchangeConsult) {
      // Get the Regional Adoption Exchange Consultants list
      List<Integer> adoExchangeList = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
      if (listIsValid(adoExchangeList)) {
        authorizedSauList.addAll(adoExchangeList);
      }
    }
    if (sendToRAC) {
      // Get the RACs list
      List<Integer> racList = unitEmpLinkDAO.findRegionalAdoptionCoordinatorByIdRegion(cdRegion);
      if (listIsValid(racList)) {
        authorizedSauList.addAll(racList);
      }
    }
    if (listIsValid(authorizedSauList)) {
      Iterator<Integer> itAuthorizedSauList = authorizedSauList.iterator();
      while (itAuthorizedSauList.hasNext()) {
        int idAssigned = (Integer) itAuthorizedSauList.next();
        todoSaveHelper(todoDesc, todoLongDesc, idAssigned, dtToday, capsCase, stage);
      }
    }
  }

  private void sendAlertToIlpCoordinator(CapsCase capsCase, Stage stage, String cdCounty, String securityAttr,
                                         String nmStage) {
    boolean isUniqueResult = true;
    SpecializedUnitPersonalBean spUnitPsnlBean = new SpecializedUnitPersonalBean();
    spUnitPsnlBean.setIdStage(stage.getIdStage());
    spUnitPsnlBean.setCdCounty(cdCounty);
    spUnitPsnlBean.setSecurityAttribute(securityAttr);
    spUnitPsnlBean.setSpecialization(CodesTables.CSPCUNTS_ILP);
    spUnitPsnlBean.setRAC(!isUniqueResult);
    // retrieve id persons of state Independent Living unit personnel
    List<Integer> sauList1 = retrieveSpecializedUnitPersonnel.retrieveSpecializedUnitPersonnel(spUnitPsnlBean);
    int idPerson = 0;
    if (sauList1 != null && sauList1.size() > 0) {
      for (int i = 0; i < sauList1.size(); i++) {
        String todoDesc = "Foster Care Stage Closed for " + nmStage;
        Date dtToday = new Date();
        idPerson = sauList1.get(i);
        todoSaveHelper(todoDesc, todoDesc, idPerson, dtToday, capsCase, stage);
      }
    }
  }

  private void todoSaveHelper(String todoDesc, String todoLongDesc, Integer idPerson, Date dueDate, CapsCase capsCase,
                              Stage stage) {
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
  /**
   * check if a secondary MES Worker already exists for the stage. If secondary 
   * MES Worker already exists, Get all MES Workers currently 
   * assigned as a secondary. If not find all the MES Workers assigned for the
   * given region and get their list.
   * @param idCase
   * @param idStage
   * @return List<Integer> List of MES Workers
   */
  private List<Integer> getMesWorkers(int idCase, int idStage) {
    String[] secAttributesMESWorker = {SEC_REG_FAM_INDP_STF, SEC_REG_FAM_INDP_MGMNT_STF};
    List<Integer> mesWorkerAssignedAsSEList = null;
    
    // retrieve list of all secondary workers for the stage
    List<Integer> idSecondaryWorkers = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRoleAsSE(idStage);
    if (idSecondaryWorkers.size() > 0) {
      // loop thru the list of secondary workers, retrieve their security profile 
      // and see if they have the MES Worker attribute
    	mesWorkerAssignedAsSEList = new ArrayList<Integer>(); // added this to fix NPE (on .add) while working SMS#89239
      for (Iterator<Integer> it_idSecondaryWorkers = idSecondaryWorkers.iterator(); it_idSecondaryWorkers.hasNext();) {
        int idSecondaryWorker = it_idSecondaryWorkers.next();
        if((checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, secAttributesMESWorker[0])) || 
                        (checkIfUserHasRight.determineIfUserHasRight(idSecondaryWorker, secAttributesMESWorker[1]))){
          mesWorkerAssignedAsSEList.add(idSecondaryWorker);
        }
      }
    }else {
      //Since there are no secondary workers for the stage, get all the MES Worker list
      //Get the Region ID for the given stage
      String cdStageRegion = retrieveStageRegionByStageId(idStage);
      //Get the MES Workers List
      mesWorkerAssignedAsSEList = unitEmpLinkDAO.findMESWorkersByIdRegion(cdStageRegion);
    }
    return mesWorkerAssignedAsSEList;
  }
  
  private String retrieveStageRegionByStageId(int idStage){
    Stage stage = stageDAO.findStageByIdStage(idStage);
    String cdStageRegion = stage.getCdStageRegion();
    if(cdStageRegion != null){
      if(cdStageRegion.length() == 1 ){
        cdStageRegion = "00" + cdStageRegion;
      } else if (cdStageRegion.length() == 2){
        cdStageRegion = "0" + cdStageRegion;
      }
    }
    return cdStageRegion;
  }
  
  private void sendAdoptionFinalizedHomeAlert(int idStage, Integer caseManagerId) {
    // get placement event
    Event placementEvent = eventDAO.findEventByStageTypeAndStatus(idStage, CodesTables.CEVNTTYP_PLA,
                                                                  CodesTables.CEVTSTAT_APRV);

    Placement placement = placementDAO.findPlacementByIdPlcmtEvent(placementEvent.getIdEvent());

    // use event to get placement resource
    int idResource = placement.getCapsResourceByIdRsrcFacil().getIdResource();

    List<Integer> secList = new ArrayList<Integer>();

    Stage stage = getPersistentObject(Stage.class, idStage);

    String stageName = stage.getNmStage();

    if (caseManagerId != null) {
      secList.add(caseManagerId);
      Person person = retrieveUnitSupervisorByCaseManagerId(caseManagerId);
      if (person != null) {
        secList.add(person.getIdPerson());
      }
    }

    CapsResource capsResource = null;
    int idResourceStage = 0;
    if (idResource != 0) {
      capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
      if (capsResource.getStage() != null) {
        idResourceStage = capsResource.getStage().getIdStage();

        StagePersonLink rmSpl = stagePersonLinkDAO
                                                  .findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(
                                                                                                         idResourceStage,
                                                                                                         CodesTables.CROLEALL_PR,
                                                                                                         CodesTables.CPRSNALL_STF);
        if (rmSpl != null) {
          // add resource manager to secList
          secList.add(rmSpl.getPerson().getIdPerson());
        }
        for (int i = 0; i < secList.size() && secList.get(i) != null; i++) {
          int assignedUserId = secList.get(i);
          Todo todo15 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          String todoDesc = "Adoption Finalized - Please close Foster/Adopt or Adoptive Home within 30 days";
          String longToDoDesc = "Adoption Finalized (child: " + stageName + ") - Please close Foster/Adopt"
                                + " or Adoptive Home (name: " + capsResource.getNmResource() + ")within 30 days";
          todo15.setTxtTodoDesc(todoDesc);
          todo15.setTxtTodoLongDesc(longToDoDesc);
          todo15.setCdTodoTask(cdTask);
          todo15.setCdTodoType(CodesTables.CTODOTYP_A);
          todo15.setDtTodoDue(new Date());
          todo15.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, assignedUserId));
          todo15.setDtTodoCreated(dateCreated);
          todo15.setCapsCase(capsResource.getCapsCase());
          todo15.setStage(capsResource.getStage());
          todoDAO.saveTodo(todo15);
        }
      }
    }
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  private Person retrieveUnitSupervisorByCaseManagerId(int idPerson) {

    Map resultMap = unitEmpLinkDAO.findNmPersonFullAndIdPersonByIdPersonAndCdUnitMemberIn(idPerson);
    Integer idSupervisor = null;
    boolean throwError = false;
    if (resultMap != null && resultMap.size() > 0) {
      idSupervisor = (Integer) resultMap.get("idPerson");
      if (idSupervisor == null) {
        throwError = true;
      }
    } else {
      throwError = true;
    }
    if (throwError) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    return getPersistentObject(Person.class, idSupervisor);
  }
  /**
   * Send alert to ADO primary and secondary assign staff, to primary's supervisor.
   * For ICPC cases, primary is of ICPC unit.
   * @param todoDesc
   * @param todoLongDesc
   * @param caseManagerId
   * @param dueDate
   * @param capsCase
   * @param stage
   */
  private void sendICPCAdoptionFinalizedAlert(String todoDesc, String todoLongDesc, Integer caseManagerId, Date dueDate, CapsCase capsCase,
          Stage stage) {
		List<Integer> personList = new ArrayList<Integer>();
		int idStage = stage.getIdStage();
		

		if (caseManagerId != null) {
			personList.add(caseManagerId);
			Person person = retrieveUnitSupervisorByCaseManagerId(caseManagerId);
			if (person != null) {
				personList.add(person.getIdPerson());
			}
			List<Integer> seList = workloadDAO.findIdOfAllSecondaryWorkersOfStage(idStage, CodesTables.CROLEALL_SE);
			if (seList != null && seList.size() > 0) {
				// SMS#88838: send alert to SE's supervisor too
				for (Integer seId : seList) {
					if (!personList.contains(seId)) { // to avoid duplicate alert in rare cases that the PR's supervisor is also the SE on the case
						personList.add(seId);
					}
					person = retrieveUnitSupervisorByCaseManagerId(seId);
					if (person != null && !personList.contains(person.getIdPerson())) { // to avoid duplicate alert when mulitple SEs from the same unit or same unit with PR.
						personList.add(person.getIdPerson());
					}
				}
			}
		}
        for (int i = 0; i < personList.size() && personList.get(i) != null; i++) {
            int assignedUserId = personList.get(i);
            Todo todoICPC = new Todo();
            String cdTask = "";
            Date dateCreated = new Date();
            todoICPC.setTxtTodoDesc(todoDesc);
            todoICPC.setTxtTodoLongDesc(todoLongDesc);
            todoICPC.setCdTodoTask(cdTask);
            todoICPC.setCdTodoType(CodesTables.CTODOTYP_A);
            todoICPC.setDtTodoDue(dueDate);
            todoICPC.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, assignedUserId));
            todoICPC.setDtTodoCreated(dateCreated);
            todoICPC.setCapsCase(capsCase);
            todoICPC.setStage(stage);
            todoDAO.saveTodo(todoICPC);
          }

	}
}
