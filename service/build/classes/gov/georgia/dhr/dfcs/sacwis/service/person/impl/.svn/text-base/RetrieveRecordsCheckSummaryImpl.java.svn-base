package gov.georgia.dhr.dfcs.sacwis.service.person.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.codestables.Cchktype;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckBean;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RecordsCheckPersonBean;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveRecordsCheckSummary;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RecordsCheckSummarySI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RecordsCheckSummarySO;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Retrieve Records Check Service
 * Author: Corey Harden
 * Date: 06/03/2011
 * 
 *                                        Change History
 *
 *   Date          User                                         Description
 * --------  ----------------  --------------------------------------------------
 * 07/07/11  hnguyen           SMS#114348: Updated Requested By person name to populate full name.
 * 07/08/11  hnguyen           SMS#114495: Corrected NPE when Records Check does not have stage id.
 *
 *
 *
 *
*/


public class RetrieveRecordsCheckSummaryImpl extends BaseServiceImpl implements RetrieveRecordsCheckSummary {

  public static String LT_SEVENTEEN = "ltSeventeenTypesList";
  public static String GT_SEVENTEEN = "gtSeventeenTypesList";
  public static String MISSING_TYPES_LIST = "missingTypesList";
  public static String MISSING_TYPES_TO_PERSON = "missingTypesMap";
  public static String PERSON_ID_LIST = "personIdList";
  public static String PERSON_LIST = "personList";
  public static String TRANSPORT_MAP = "transportMap";
  public static String FILTER_LISTS_MAP = "filterListsMap";
  public static String ADD_BY_SEARCH_TYPE = "addBySearchType";
  public static String ADD_BY_PERSON = "addByPerson";
  public static String HOME_APPROVAL_TASK = "8020";
  private static String LEG_TYPES = "legTypesList";
  private static String NONLEG_TYPES = "nonLegTypesList";
  private static String SEX_OFFEND_SITE = "http://services.georgia.gov/gbi/gbisor/SORSearch.jsp";
  private static String PARDONS_N_PAROLE_SITE = "http://www.pap.state.ga.us/opencms/opencms/home/parolee_datbase";
  private static String DEPT_CORRECT_OFFEND_SITE = "http://www.dcor.state.ga.us/GDC/OffenderQuery/jsp/OffQryForm.jsp";
  private StagePersonLinkDAO stagePersonLinkDAO;
  private RecordsCheckDAO recordsCheckDAO;
  private PlacementDAO placementDAO;
  private CapsResourceDAO capsResourceDAO;
  private StageDAO stageDAO;

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }

  public void setPlacementDAO(PlacementDAO placementDAO) {
    this.placementDAO = placementDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }
  

  /**
   * This method accepts retrieves records check summary information for all principals on a stage and returns the
   * information within a service out (SO) transport object
   * @param rcSummarySI - the service in (SI) transport object shuttling information from the page to the service
   * @return - returns all necessary data for the records check summary page within a transport layer object
   */
  @SuppressWarnings("unchecked")
  public RecordsCheckSummarySO retrieveRecordsCheckSummary(RecordsCheckSummarySI rcSummarySI) {

    // create Service Out (SO) transport object
    RecordsCheckSummarySO recordsCheckSummarySO = new RecordsCheckSummarySO();
    
    //create map to hold list of Records Check types for under 17 and over 16
    Map<String, List<String>> ageTypeMap = createAgeTypeLists();
    
    //create map to hold lists of legacy and non-legacy Records Check types
    Map<String, List<String>> legacyTypeMap = createLegTypeLists();
    
    // create lists to hold legacy Records Check and non-Legacy Records Check records
    List<RecordsCheck> nonLegRecordsCheckList = new ArrayList<RecordsCheck>();
    List<RecordsCheck> legRecordsCheckList = new ArrayList<RecordsCheck>();
    
    // create list to hold id's of person's in fad home
    List<Integer> fadPlacementsList = new ArrayList<Integer>();
    
    // create map of id person to legacy Records Check
    Map<Integer, Map<String, Boolean>> historyMap = new HashMap<Integer, Map<String, Boolean>>();
    
    // create list to hold stage principals and household members
    List<StagePersonLink> stagePrincipleList = new ArrayList<StagePersonLink>();
    
    // get list of principals and/or household members on the current stage
    if(rcSummarySI.getIdStage() != null && rcSummarySI.getIdStage() != 0){
      stagePrincipleList = stagePersonLinkDAO.findStagePersonLinkByIdStageRoleHousehold(rcSummarySI.getIdStage());
    }
    
    // make sure there is a stage
    if(!stagePrincipleList.isEmpty()){
      // get the stage person link for stage info
      StagePersonLink spl = stagePrincipleList.get(0);
      //check to see if stage is a FAD
      if(CodesTables.CSTAGES_FAD.equals(spl.getStage().getCdStage())){
        CapsResource resource = capsResourceDAO.findCapsResourceByIdStage(spl.getStage().getIdStage());
        // get the idResource of the home
        int idResource = resource != null ? resource.getIdResource() : 0;
        // make sure idResource is present
       /* if(idResource != 0){
          // find all current placements for the home
          fadPlacementsList = placementDAO.findApprovedCompIdPlcmtChildByIdRsrcFacil(new Date(), idResource);
          // if there are placements, add them to the main list (stagePrincipleList)
          if(!fadPlacementsList.isEmpty()){
            // find stagePersonLink records for all placements in the home
            List<StagePersonLink> placementSplList = stagePersonLinkDAO.findStagePersonLinkByidPersons(fadPlacementsList);
            // merge lists
            this.addAll(stagePrincipleList, placementSplList);
          }
        }*/
      }
    }

    // get list of person id's and list of person objects from stagePrincipleList returned within a map
    Map<String, List> personMap = !stagePrincipleList.isEmpty() ? populatePersonLists(stagePrincipleList) : new HashMap<String, List>();

    // there's no need to grab records check info if we did not pull back any principals or household members for the stage
    if (personMap.containsKey(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST)) {
      // create stage object
      Stage stage = null;
      // if there is no case, then we are presently in an intake that does not have a case
      if(rcSummarySI.getIdCase() != 0){
        // find date the intake
        List<Stage> stageList = stageDAO.findStageByIdCaseAndCdStage(rcSummarySI.getIdCase(), CodesTables.CSTAGES_INT);
        // get the stage object
        if(!stageList.isEmpty()){
          // get the stage object
          stage = stageList.get(0);
        }else{
          // since we're pulling records checks based on intake date now, add logic for all stages and possible scenarios
          // where there is no intake to allow a way of knowing how to determine whether records checks need to be done
          stage = stageDAO.findStageByIdStage(rcSummarySI.getIdStage());
        }
      }else{
        stage = stageDAO.findStageByIdStage(rcSummarySI.getIdStage());
      }
      
      
      // make sure list is not empty so that date can be passed to dao from stage object
      if(stage != null){
        // get records check data
        nonLegRecordsCheckList = recordsCheckDAO.findRecordsChecksByDtStageStartPersonsType(stage.getDtStageStart(), personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST), legacyTypeMap.get(RetrieveRecordsCheckSummaryImpl.NONLEG_TYPES));
        legRecordsCheckList = recordsCheckDAO.findRecordsChecksByIdPersonsType(personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST), legacyTypeMap.get(RetrieveRecordsCheckSummaryImpl.LEG_TYPES));
      }
      
      // get map of id person to legacy Records Check
      historyMap = createHistoryMap(legRecordsCheckList, personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST));
    }

    // populate SO object with records checks if any exist
    if (!stagePrincipleList.isEmpty()) {
      //filter lists of Records Checks into a map of Records Checks Beans for easy retrieval in jsp
      Map<String, Map> temp = filterRcLists(nonLegRecordsCheckList, legRecordsCheckList, personMap, stagePrincipleList);
      
      //populate the Service Out (SO) transport object
      populateSO(recordsCheckSummarySO, personMap, temp, ageTypeMap, historyMap);
      
      // check to see if all Records Checks have been completed
      checkForMissingChecks(recordsCheckSummarySO, rcSummarySI, createPersonMap(stagePrincipleList));
    }

    return recordsCheckSummarySO;
  }
  
  
  /**
   * This method turns a list of legacy records into a map accessible by person id and legacy record type
   * @param legRecordsCheckList - list of legacy records
   * @param personIdList - list of person id's 
   * @return - returns a map of person id's to a map with key legacy type to Boolean 
   */
  private Map<Integer, Map<String, Boolean>> createHistoryMap(List<RecordsCheck> legRecordsCheckList, List<Integer> personIdList){
    
    // create map to hold indicators of person history
    Map<Integer, Map<String, Boolean>> historyMap = new HashMap<Integer, Map<String, Boolean>>();
    
    // create temporary map
    Map<String, Boolean> temp = new HashMap<String, Boolean>();
    
    // loop thru list of persons
    for(Integer idPerson : personIdList){
      // create temporary map
      temp = new HashMap<String, Boolean>();
      // loop thru list of legacy records checks
      for(RecordsCheck rc : legRecordsCheckList){
        if(idPerson.equals(rc.getPersonByIdRecCheckPerson().getIdPerson())){
          temp.put(rc.getCdRecCheckCheckType(), true);
        }   
      }
      // add temp to history
      historyMap.put(idPerson, temp);
    }
    
    return historyMap;
  }
  
  
  /**
   * This method filters a list of Records Checks so that only the most recent Records Check
   * for each type is kept and stored in a map whose key/index is the id of the person who the
   * record belongs to
   * @param nonLegRecordsCheckList - list of non-legacy Records Checks
   * @param legRecordsCheckList - list of legacy Records Checks
   * @param personIdList - list of principals on the stage
   * @return - returns a map of person id's to a map of Records Check types to Records Checks
   */
  @SuppressWarnings("unchecked")
  private Map<String, Map> filterRcLists(List<RecordsCheck> nonLegRecordsCheckList, List<RecordsCheck> legRecordsCheckList, Map<String, List> personMap, List<StagePersonLink> stagePrincipleList){
    //create map to hold objects to be returned
    Map<String, Map> temp = new HashMap<String, Map>();
    
    //create map to hold filtered list of Records Checks
    Map<Integer, Map<String, RecordsCheckBean>>  filterListsMap = new HashMap<Integer, Map<String, RecordsCheckBean>>();
    List<RecordsCheckBean> rcBeanList = new ArrayList<RecordsCheckBean>();
    
    // create list to hold combined legacy and non-legacy lists
    List<RecordsCheck> combinedList = new ArrayList<RecordsCheck>();
    
    // determine which list is larger so that we can combine the lists (this is necessary in case one list doesn't hold any records)
    if(nonLegRecordsCheckList.size() >= legRecordsCheckList.size()){
       // add legacy records to non-legacy list
      nonLegRecordsCheckList.addAll(legRecordsCheckList);
      // point combined list to list with records combined
      combinedList = nonLegRecordsCheckList;
    }else{
      // add non-legacy records to legacy list
      legRecordsCheckList.addAll(nonLegRecordsCheckList);
      // point combined list to list with records combined
      combinedList = legRecordsCheckList;
    }
    
    //convert Records Check records to bean objects for easy shuttle to page
    convertRecordsChecks(rcBeanList, combinedList);
    
    //filter the lists
    filter(filterListsMap, rcBeanList, personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST));
    
    //determine which types are missing
    Map transportMap = determineMissingTypes(personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_LIST), filterListsMap, stagePrincipleList);
    
    //add maps to transport object to be returned
    temp.put(RetrieveRecordsCheckSummaryImpl.TRANSPORT_MAP, transportMap);
    temp.put(RetrieveRecordsCheckSummaryImpl.FILTER_LISTS_MAP, filterListsMap);
    
    //return the filtered map
    return temp;
  }
  
  
  /**
   * This method finds the types that are missing on the case and which persons are missing those types
   * and returns them as a list and a map respectively
   * @param personList - list of stage principals
   * @param filterListsMap - filtered map of person to types to Records Check objects
   * @return - returns a map
   */
  @SuppressWarnings("unchecked")
  private Map determineMissingTypes(List<RecordsCheckPersonBean> personList, Map<Integer, Map<String, RecordsCheckBean>> filterListsMap, List<StagePersonLink> stagePrincipleList){
    // create map to hold list of missing types and map of missing types to persons
    Map transportMap = new HashMap();
    
    // create map of missing types to persons
    Map<String, Map<Integer, RecordsCheckBean>> missingTypesMap = new HashMap<String, Map<Integer, RecordsCheckBean>>();
    
    //create map of person to Records Check
    Map<Integer, RecordsCheckBean> missingRcBeanMap;
    
    // create list to hold missing Records Check types
    List<String> missingTypesList = new ArrayList<String>();
    
    // get required types by age
    Map<String, List<String>> ageTypeMap = createAgeTypeLists();
    
    // get lists of Records Check types for each age group (Less than 17 and 17 and over)
    List<String> gtSeventeenList = ageTypeMap.get(RetrieveRecordsCheckSummaryImpl.GT_SEVENTEEN);
    List<String> ltSeventeenList = ageTypeMap.get(RetrieveRecordsCheckSummaryImpl.LT_SEVENTEEN);
    
    // get stage and case
    Stage stage = stagePrincipleList.get(0).getStage();
    CapsCase capsCase = stagePrincipleList.get(0).getCapsCase();
    
    // loop thru list to find missing types
    for(String type : gtSeventeenList){
      //create new bean map
      missingRcBeanMap = new HashMap<Integer, RecordsCheckBean>();
      // loop thru person list to pull out person
      for(RecordsCheckPersonBean person : personList){
        // check person's age
        if(person.getAge() < 17 && person.getDateOfBirth() != null){
          // check to make sure type is required for child
          if(ltSeventeenList.contains(type)){
            // if type is required, check to see if child has a completed RecordsCheck of that type
            Map<String, RecordsCheckBean> rcBeanMap = filterListsMap.get(person.getPersonId());
            // check if type is missing
            if(rcBeanMap.containsKey(type)){
              // get Records Check record
              RecordsCheckBean rc = rcBeanMap.get(type);
              // check if Records Check is completed
              if(rc.getDtRecCheckCompleted() == null){
                //add status of update to bean
                rc.setStatus(ServiceConstants.REQ_FUNC_CD_UPDATE);  
                // mark Records Check type as missing
                missingRcBeanMap.put(person.getPersonId(), rc);
                // check to see if type has already been added to the list 
                if(!missingTypesList.contains(type)){
                  // add type to the list of missing types
                  missingTypesList.add(type);
                }
              }
            }else{
              // create and populate new Records Check
              RecordsCheckBean rcB = new RecordsCheckBean();
              rcB.setIdRecCheck(0);
              rcB.setCdRecCheckCheckType(type);
              rcB.setCapsCase(capsCase);
              rcB.setStage(stage);
              rcB.setStatus(ServiceConstants.REQ_FUNC_CD_ADD);
              rcB.setPersonByIdRecCheckPerson(person.getPersonId());
              // add empty record to map to represent missing record
              missingRcBeanMap.put(person.getPersonId(), rcB);
              // check to see if type has already been added to the list 
              if(!missingTypesList.contains(type)){
                // add type to the list of missing types
                missingTypesList.add(type);
              }
            }
          }
        }else{
          // if type is required, check to see if person has a completed RecordsCheck of that type
          Map<String, RecordsCheckBean> rcBeanMap = filterListsMap.get(person.getPersonId());
          // check if type is missing
          if(rcBeanMap.containsKey(type)){
            // get Records Check record
            RecordsCheckBean rc = rcBeanMap.get(type);
            // check if Records Check is completed
            if(rc.getDtRecCheckCompleted() == null){
              //add status of update to bean
              rc.setStatus(ServiceConstants.REQ_FUNC_CD_UPDATE);
              // mark Records Check type as missing
              missingRcBeanMap.put(person.getPersonId(), rc);
              // check to see if type has already been added to the list 
              if(!missingTypesList.contains(type)){
                // add type to the list of missing types
                missingTypesList.add(type);
              }
            }
          }else{
            // create and populate new Records Check
            RecordsCheckBean rcB = new RecordsCheckBean();
            rcB.setIdRecCheck(0);
            rcB.setCdRecCheckCheckType(type);
            rcB.setCapsCase(capsCase);
            rcB.setStage(stage);
            rcB.setStatus(ServiceConstants.REQ_FUNC_CD_ADD);
            rcB.setPersonByIdRecCheckPerson(person.getPersonId());
            // add empty record to map to represent missing record
            missingRcBeanMap.put(person.getPersonId(), rcB);
            // check to see if type has already been added to the list 
            if(!missingTypesList.contains(type)){
              // add type to the list of missing types
              missingTypesList.add(type);
            }
          }
        }
      }
      // add missing map to type map
      missingTypesMap.put(type, missingRcBeanMap);
    }
    
    //add list of missing types and map of missing types to transport map
    transportMap.put(RetrieveRecordsCheckSummaryImpl.MISSING_TYPES_LIST, missingTypesList);
    transportMap.put(RetrieveRecordsCheckSummaryImpl.MISSING_TYPES_TO_PERSON, missingTypesMap);
    
    return transportMap;
  }
  
  
  /**
   * This method converts Records Checks to Records Check Beans
   * @param rcBeanList - list of Records Checks beans
   * @param recordsCheckList - list of Records Checks
   */
  private void convertRecordsChecks(List<RecordsCheckBean> rcBeanList, List<RecordsCheck> recordsCheckList){

    //add Records Check records to bean
    for(RecordsCheck rc : recordsCheckList){
      //create bean
      RecordsCheckBean rcBean = new RecordsCheckBean();
      
      //add values to bean
      rcBean.setCdRecCheckCheckType(rc.getCdRecCheckCheckType());
      rcBean.setCdRecCheckEmpType(rc.getCdRecCheckEmpType());
      rcBean.setDtRecCheckCompleted(rc.getDtRecCheckCompleted());
      rcBean.setDtRecCheckRequest(rc.getDtRecCheckRequest());
      rcBean.setIdCase(rc.getCapsCase() != null ? rc.getCapsCase().getIdCase() : 0);
      rcBean.setIdRecCheck(rc.getIdRecCheck());
      rcBean.setIdStage(rc.getStage() != null ? rc.getStage().getIdStage() : 0);
      rcBean.setIndReccheckHistory(rc.getIndReccheckHistory());
      rcBean.setPersonByIdRecCheckPerson(rc.getPersonByIdRecCheckPerson().getIdPerson());
      rcBean.setPersonByIdRecCheckRequestor(rc.getPersonByIdRecCheckRequestor().getIdPerson());
      rcBean.setTxtRecCheckComments(rc.getTxtRecCheckComments());
      rcBean.setRequestByFullName(FormattingHelper.formatFullName(rc.getPersonByIdRecCheckRequestor().getNmPersonFirst(),
                                                               rc.getPersonByIdRecCheckRequestor().getNmPersonMiddle(),
                                                               rc.getPersonByIdRecCheckRequestor().getNmPersonLast()));
      
      //add bean to list
      rcBeanList.add(rcBean);
    }
  }
  
  
  /**
   * This method performs the actual filtering for filterRcLists method
   * @param filterListsMap - map to store the filtered lists
   * @param recordsCheckList - list of Records Check records to be filtered
   * @param personIdList - list of principals and/or household members on the stage
   */
  private void filter(Map<Integer, Map<String, RecordsCheckBean>>  filterListsMap, List<RecordsCheckBean> recordsCheckList, List<Integer> personIdList) {

    // create temporary map to hold Records Checks for comparison
    Map<String, RecordsCheckBean> tempRcMap = new HashMap<String, RecordsCheckBean>();

    // loop thru list to arrange list by most recent Records Check for each type per person
    for (Integer idPerson : personIdList) {
      // clear the map for the next person
      tempRcMap = new HashMap<String, RecordsCheckBean>();
      
      // loop thru list of Records Checks
      for (RecordsCheckBean rc : recordsCheckList) {
        // compare persons
        if (idPerson.equals(rc.getPersonByIdRecCheckPerson())) {
          // check map to see if type already exists
          if (tempRcMap.containsKey(rc.getCdRecCheckCheckType())) {
            // compare the dates so that we can be sure to keep the most recent record
            if (tempRcMap.get(rc.getCdRecCheckCheckType()).getDtRecCheckCompleted() != null
                && DateHelper.isAfter(rc.getDtRecCheckCompleted(), tempRcMap.get(rc.getCdRecCheckCheckType()).getDtRecCheckCompleted())) {
              // remove the currently stored Records Check and add the more recent record
              tempRcMap.remove(rc.getCdRecCheckCheckType());
              tempRcMap.put(rc.getCdRecCheckCheckType(), rc);
            }
          } else {
            // add Records Check to temporary map
            tempRcMap.put(rc.getCdRecCheckCheckType(), rc);
          }
        }
      }
      // add map of types -> Records Checks to person map
      filterListsMap.put(idPerson, tempRcMap);
    }
  }
  
  
  /**
   * This method determines whether all Records Checks have completed and sets a boolean value
   * in the Service Out transport object to be used as an indicator on the page
   * @param recordsCheckSummarySO - the Service Out transport object
   * @param rcSummarySI - the Service In transport object
   * @param personMap - a map of person records for each principle on the stage
   */
  @SuppressWarnings("unchecked")
  private void checkForMissingChecks(RecordsCheckSummarySO recordsCheckSummarySO, RecordsCheckSummarySI rcSummarySI, Map<Integer, Person> personMap){
    
    // create boolean
    boolean isComplete = true;
    
    // get transport map
    Map transportMap = recordsCheckSummarySO.getMissingTypesMap();
    
    // get list of missing types
    List<String> missingTypesList = (List<String>) transportMap.get(RetrieveRecordsCheckSummaryImpl.MISSING_TYPES_LIST);
    
    // get map of missing types per person
    Map<String, Map<Integer, RecordsCheckBean>> missingTypesMap = (Map<String, Map<Integer, RecordsCheckBean>>) transportMap.get(RetrieveRecordsCheckSummaryImpl.MISSING_TYPES_TO_PERSON);
    
    // check type so we can know how to determine if any Records Checks are missing
    if(RetrieveRecordsCheckSummaryImpl.ADD_BY_PERSON.equals(rcSummarySI.getAddByType())){
      // get map of list of required types by age
      Map<String, List<String>> ageTypeMap = recordsCheckSummarySO.getAgeTypeMap();
      
      // get the person 
      Person person = personMap.get(rcSummarySI.getIdPerson());
      
      // get the required Records Check types for the person based on their age
      List<String> requiredTypes = DateHelper.getAge(person.getDtPersonBirth()) < 17 ? ageTypeMap.get(RetrieveRecordsCheckSummaryImpl.LT_SEVENTEEN) : ageTypeMap.get(RetrieveRecordsCheckSummaryImpl.GT_SEVENTEEN);
      
      // check each type to see if the type is missing for the person
      for(String type : requiredTypes){
        // get map of person id's to Records Checks for the current type
        Map<Integer, RecordsCheckBean> rcPersonMap = missingTypesMap.get(type);
        
        // if there is a Records Check in the missing map then there is a missing Records Check for this type
        if(rcPersonMap.get(person.getIdPerson()) != null){
          // set boolean to false
          isComplete = false;
          
          // Records Checks have not been completed
          recordsCheckSummarySO.setIsComplete(isComplete);
          break;
        }
      }   
    }else if(RetrieveRecordsCheckSummaryImpl.ADD_BY_SEARCH_TYPE.equals(rcSummarySI.getAddByType())){
      // check list of missing types to determine if any types are missing
       if((missingTypesList == null) || missingTypesList.isEmpty()){
         // all Records Checks have been completed
         recordsCheckSummarySO.setIsComplete(isComplete);
       }else{
         // set boolean to false
         isComplete = false;
         
         // Records Checks have not been completed
         recordsCheckSummarySO.setIsComplete(isComplete);
       }
    }   
  }
  

  /**
   * This method populates the service out object with person and records check data to be returned to the page
   * @param recordsCheckList - a list of records checks for all principals on the stage
   * @param recordsCheckSummarySO - the service out transport object
   * @param personMap - a map containing a list of persons and a list of person id's
   */
  @SuppressWarnings("unchecked")
  private void populateSO(RecordsCheckSummarySO recordsCheckSummarySO, Map<String, List> personMap, Map<String, Map> temp, Map<String, List<String>> ageTypeMap, Map<Integer, Map<String, Boolean>> historyMap) {

    //get filtered list map
    Map filteredListsMap = temp.get(RetrieveRecordsCheckSummaryImpl.FILTER_LISTS_MAP);
    
    //get the transport map
    Map transportMap = temp.get(RetrieveRecordsCheckSummaryImpl.TRANSPORT_MAP);
    
    // add typeMap to SO object
    recordsCheckSummarySO.setFilteredListsMap(filteredListsMap);
    
    // add history map to SO object
    recordsCheckSummarySO.setHistoryMap(historyMap);
    
    // add missing types map to SO object
    recordsCheckSummarySO.setMissingTypesMap(transportMap);

    // add list of persons to SO object
    recordsCheckSummarySO.setPersonList(personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_LIST));

    // add list of person id's to SO object
    recordsCheckSummarySO.setPersonIdList(personMap.get(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST));
    
    //add map of age type lists to SO object
    recordsCheckSummarySO.setAgeTypeMap(ageTypeMap);
    
    //add map of Records Check url's to SO object
    recordsCheckSummarySO.setRcSiteMap(createRcSiteMap());
    
    //add static values to SO object
    recordsCheckSummarySO.setGtSeventeen(RetrieveRecordsCheckSummaryImpl.GT_SEVENTEEN);
    recordsCheckSummarySO.setLtSeventeen(RetrieveRecordsCheckSummaryImpl.LT_SEVENTEEN);
    recordsCheckSummarySO.setLegTypes(RetrieveRecordsCheckSummaryImpl.LEG_TYPES);
    recordsCheckSummarySO.setNonLegTypes(RetrieveRecordsCheckSummaryImpl.NONLEG_TYPES);
    recordsCheckSummarySO.setMissingTypesList(RetrieveRecordsCheckSummaryImpl.MISSING_TYPES_LIST);
    recordsCheckSummarySO.setMissingTypesToPerson(RetrieveRecordsCheckSummaryImpl.MISSING_TYPES_TO_PERSON);
  }

  
  /**
   * This method pulls the person objects and the person id's from the passed-in list of stage
   * person links and returns them within a map as a list of person id's and a list of Person transport
   * structures
   * @param stagePrincipleList - a list of principles for the current stage
   * @return - returns a map containing a list of stage principals and/or household members and a list of their person id's
   */
  @SuppressWarnings("unchecked")
  private Map<String, List> populatePersonLists(List<StagePersonLink> stagePrincipleList) {

    // create map to hold person lists
    Map<String, List> personMap = new HashMap<String, List>();

    // create list to hold persons
    List<RecordsCheckPersonBean> personList = new ArrayList<RecordsCheckPersonBean>();
    
    // create list of person id's to represent indices of person-based maps
    List<Integer> personIdList = new ArrayList<Integer>();

    // loop thru stage person links to retrieve the persons and their id's
    for (StagePersonLink spl : stagePrincipleList) {
      //create bean to hold person values
      RecordsCheckPersonBean recordsCheckPersonBean = new RecordsCheckPersonBean();
      // retrieve person object from stage person link
      Person person = spl.getPerson();
      
      //set person values in bean
      recordsCheckPersonBean.setCdStagePersonRole(spl.getCdStagePersRole());
      recordsCheckPersonBean.setCdStagePersonType(spl.getCdStagePersType());
      recordsCheckPersonBean.setCdStagePersRelInt(spl.getCdStagePersRelInt());
      recordsCheckPersonBean.setDateOfBirth(person.getDtPersonBirth());
      recordsCheckPersonBean.setAge(DateHelper.getAge(person.getDtPersonBirth()));
      recordsCheckPersonBean.setDisplayNameFull(person.getNmPersonLast() + ", " + person.getNmPersonFirst());
      recordsCheckPersonBean.setFirstName(person.getNmPersonFirst());
      recordsCheckPersonBean.setLastName(person.getNmPersonLast());
      recordsCheckPersonBean.setMiddleName(person.getNmPersonMiddle());
      recordsCheckPersonBean.setPersonId(person.getIdPerson());

      // add person and personId to their respective lists
      personList.add(recordsCheckPersonBean);
      personIdList.add(person.getIdPerson());
    }

    // add lists to person map and return the map
    personMap.put(RetrieveRecordsCheckSummaryImpl.PERSON_LIST, personList);
    personMap.put(RetrieveRecordsCheckSummaryImpl.PERSON_ID_LIST, personIdList);

    return personMap;
  }
  
  
  /**
   * This method creates a map containing a list of types for each age range (age > 17 >= age)
   * @return - returns map containing a list of types for each age range (age > 17 >= age)
   */
  private Map<String, List<String>> createAgeTypeLists(){
    
    //create map to hold the lists
    Map<String, List<String>> ageTypeMap = new HashMap<String, List<String>>(); 
    
    //create lists to hold the Records Check types based on age
    List<String> ltSeventeenTypesList = new ArrayList<String>();
    List<String> gtSeventeenTypesList = new ArrayList<String>();
    
    //populate list of types for ages under 17
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_CF);
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_GS);
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_PS);
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_IM);
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_IC);
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_SC);
    ltSeventeenTypesList.add(Cchktype.CCHKTYPE_GH);
    
    //populate list of types for ages 17 and over
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_CF);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_GS);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_PS);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_IM);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_IC);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_SC);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_GH);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_SR);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_DC);
    gtSeventeenTypesList.add(Cchktype.CCHKTYPE_BP);
    
    //add lists to map and return map
    ageTypeMap.put(RetrieveRecordsCheckSummaryImpl.LT_SEVENTEEN, ltSeventeenTypesList);
    ageTypeMap.put(RetrieveRecordsCheckSummaryImpl.GT_SEVENTEEN, gtSeventeenTypesList);
    
    return ageTypeMap;
  }
  
  
  /**
   * This method creates a map containing the legacy Records Check type list and non-legacy 
   * Records Check type lists
   * @return - map containing 2 lists: one of legacy and one of non-legacy Records Check types
   */
  private Map<String, List<String>> createLegTypeLists(){
    
    //create map to hold lists
    Map<String, List<String>> legacyTypeMap = new HashMap<String, List<String>>();
    
    // create lists to hold legacy Records Check and non-Legacy Records Check records
    List<String> nonLegTypesList = new ArrayList<String>();
    List<String> legTypesList = new ArrayList<String>();
    
    //populate list of legacy types
    legTypesList.add(Cchktype.CCHKTYPE_GS);
    legTypesList.add(Cchktype.CCHKTYPE_PS);
    legTypesList.add(Cchktype.CCHKTYPE_IM);
    legTypesList.add(Cchktype.CCHKTYPE_IC);
    
    //populate list of non-legacy types
    nonLegTypesList.add(Cchktype.CCHKTYPE_SC);
    nonLegTypesList.add(Cchktype.CCHKTYPE_CF);
    nonLegTypesList.add(Cchktype.CCHKTYPE_GH);
    nonLegTypesList.add(Cchktype.CCHKTYPE_SR);
    nonLegTypesList.add(Cchktype.CCHKTYPE_DC);
    nonLegTypesList.add(Cchktype.CCHKTYPE_BP);
    
    //add lists to map and return map
    legacyTypeMap.put(RetrieveRecordsCheckSummaryImpl.LEG_TYPES, legTypesList);
    legacyTypeMap.put(RetrieveRecordsCheckSummaryImpl.NONLEG_TYPES, nonLegTypesList);
    
    return legacyTypeMap;
  }
  
  
  /**
   * This method maps Records Check types to their respective website url's
   * @return - returns a map of Records check types to url's
   */
  private Map<String, String> createRcSiteMap(){
    //create map to hold website url's
    Map<String, String> rcSiteMap = new HashMap<String, String>(); 
    
    //add url's to map
    rcSiteMap.put(Cchktype.CCHKTYPE_SR, RetrieveRecordsCheckSummaryImpl.SEX_OFFEND_SITE);
    rcSiteMap.put(Cchktype.CCHKTYPE_BP, RetrieveRecordsCheckSummaryImpl.PARDONS_N_PAROLE_SITE);
    rcSiteMap.put(Cchktype.CCHKTYPE_DC, RetrieveRecordsCheckSummaryImpl.DEPT_CORRECT_OFFEND_SITE);
    
    return rcSiteMap;
  }
  
  
  /**
   * This method takes a list of stage person links and converts it into a map of persons
   * @param splList - a list of stage person links
   * @return - returns a map of persons
   */
  private Map<Integer, Person> createPersonMap(List<StagePersonLink> splList){
    //create map to hold persons
    Map<Integer, Person> personMap = new HashMap<Integer, Person>();
    
    // add persons to map
    for(StagePersonLink spl : splList){
      // get the person
      Person person = spl.getPerson();
      // add person to map
      personMap.put(person.getIdPerson(), person);
    }
    
    return personMap;
  }
  
  
  /**
   * This method adds all objects in the addFrom list to the addToList
   * @param addTo - the list to add objects to
   * @param addFrom - the list to add objects from
   */
  @SuppressWarnings("unchecked")
  private void addAll(List addTo, List addFrom){
    // make sure lists aren't null
    if(addTo != null && addFrom != null){
      // loop thru list
      for(Object obj : addFrom){
        // add objects to list
        addTo.add(obj);
      }
    }
  }
}
