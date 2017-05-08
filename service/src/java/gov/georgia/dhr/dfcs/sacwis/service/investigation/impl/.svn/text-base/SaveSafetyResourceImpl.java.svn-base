package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SafetyResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrChildrenConsideredPlacementDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SrHouseholdMembersDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RecordsCheck;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResource;
import gov.georgia.dhr.dfcs.sacwis.db.SafetyResourceChild;
import gov.georgia.dhr.dfcs.sacwis.db.SrChildConsiderPlcmnt;
import gov.georgia.dhr.dfcs.sacwis.db.SrHouseholdMembers;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveSafetyResource;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SafetyResourceSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FormDataGroup;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PreFillData;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SafetyResourceSaveSO;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 *This class implements the saveSafetyResource service to save information to the
 *SAFETY_RESOURCE, EVENT, EVENT_PERSON_LINK, and SR_HOUSEHOLD_MEMBERS tables for
 *new or updated Safety Resource Detail records.
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  --------------------------------------------------
 * 06/17/08  PCOOGAN           Creation per Safety Resource enhancement MR-008.
 * 06/21/2009  bgehlot         STGAP00014329: MR-20 updates   
 * 09/08/2010  bgehlot         SMS 69955 Records Check Code has changed
 * 06/21/2011  schoi           SMS #112550 Added three new fields for the initial save
 * 06/22/2011  schoi           SMS #112163 Updated the name of the message from MSG_MISSING_REC_CHECK_OVER_18 
 *                             to MSG_MISSING_REC_CHECK_OVER_17 to be in sync with the message text and name change per policy change
 * </pre>
 */


public class SaveSafetyResourceImpl extends BaseServiceImpl implements SaveSafetyResource {

  private PostEvent postEvent = null;

  private CommonDAO commonDAO = null;
  
  private EventDAO eventDAO = null;
  
  private SafetyResourceDAO safetyResourceDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private StageDAO stageDAO = null;
  
  private SrHouseholdMembersDAO srHouseholdMembersDAO = null;
  
  private SrChildrenConsideredPlacementDAO srChildrenConsideredPlacementDAO = null;  
  
  private RecordsCheckDAO recordsCheckDAO = null; 
  
  private PersonDAO personDAO = null; 

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setSafetyResourceDAO(SafetyResourceDAO safetyResourceDAO) {
    this.safetyResourceDAO = safetyResourceDAO;
  }
  
  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }
  
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }
  
    public void setSrHouseholdMembersDAO(SrHouseholdMembersDAO srHouseholdMembersDAO) {
    this.srHouseholdMembersDAO = srHouseholdMembersDAO;
  }
  
  public void setSrChildrenConsideredPlacementDAO(SrChildrenConsideredPlacementDAO srChildrenConsideredPlacementDAO) {
    this.srChildrenConsideredPlacementDAO = srChildrenConsideredPlacementDAO;
  }  
  
  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  /*Implements public method defined in interface class */

  public SafetyResourceSaveSO saveSafetyResource(SafetyResourceSaveSI safetyResourceSaveSI ) 
      throws ServiceException{

    int ulIdEvent = safetyResourceSaveSI.getUlIdEvent();
    String actionCode = "";
    SafetyResource safetyResource;
    SafetyResourceSaveSO safetyResourceSaveSO = new SafetyResourceSaveSO();
    
    // If event is not equal to 0, this is an update and no event code is needed
    if (ulIdEvent != 0) {
        
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
      
      CCMN01UO ccmn01uo = callPostEvent(safetyResourceSaveSI, actionCode);
      
      ulIdEvent = ccmn01uo.getUlIdEvent();
      
      safetyResource = safetyResourceDAO.findSafetyResourceByIdEvent(ulIdEvent);
      
      String prevDenial = safetyResource.getCdDenialReason();
      
      if(prevDenial != null && safetyResourceSaveSI.getCdDenialReason() != null && prevDenial.equals(safetyResourceSaveSI.getCdDenialReason())){
        safetyResourceSaveSO.setDenialReasonChg(ArchitectureConstants.Y);
      }else{
        safetyResourceSaveSO.setDenialReasonChg(ArchitectureConstants.N);
      }
      
      safetyResource.setIdPrimary(safetyResourceSaveSI.getUlIdPrimary());
      
      if (safetyResourceSaveSI.getUlIdSecondary()!=0){
          safetyResource.setIdSecondary(safetyResourceSaveSI.getUlIdSecondary());
      }
      
      //STGAP00014329: Added new dates on the page
      safetyResource.setDtRequestReceived(safetyResourceSaveSI.getDtRequestReceived());
      safetyResource.setDtHomeVisit(safetyResourceSaveSI.getDtHomeVisit());
      
      safetyResource.setCdDenialReason(safetyResourceSaveSI.getCdDenialReason());
      safetyResource.setTxtComments(safetyResourceSaveSI.getTxtComments());
      safetyResource.setIndRecommendation(safetyResourceSaveSI.getIndRecommendation());
      
      
    }
    else{ //this is a new safety resource and we need to add EVENT and EVENT_PERSON_LINK
    
      actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
      CCMN01UO ccmn01uo = callPostEvent(safetyResourceSaveSI, actionCode);
       
      ulIdEvent = ccmn01uo.getUlIdEvent();
      Event event = eventDAO.findEventByIdEvent(ulIdEvent); 
      
      updateEPL(ulIdEvent, safetyResourceSaveSI.getUlIdPrimary()); 
    
      safetyResource = new SafetyResource();
      safetyResource.setIdPrimary(safetyResourceSaveSI.getUlIdPrimary());
      
      if (safetyResourceSaveSI.getUlIdSecondary() != 0){
        safetyResource.setIdSecondary(safetyResourceSaveSI.getUlIdSecondary());
      }
      
      //STGAP00014329: Added new dates on the page
      safetyResource.setDtRequestReceived(safetyResourceSaveSI.getDtRequestReceived());
      safetyResource.setDtHomeVisit(safetyResourceSaveSI.getDtHomeVisit());
    
      // SMS #112550 Added three new fields for the initial save
      safetyResource.setCdDenialReason(safetyResourceSaveSI.getCdDenialReason());
      safetyResource.setTxtComments(safetyResourceSaveSI.getTxtComments());
      safetyResource.setIndRecommendation(safetyResourceSaveSI.getIndRecommendation());
      // End SMS #112550
      
      safetyResource.setIdEvent(ulIdEvent);
    
    
      safetyResource.setEvent(event);
    }   
    
    
    // Lists of persons to add to SR_HOUSEHOLD_MEMBERS
    List<Integer> addList = safetyResourceSaveSI.getAddHshldMembers();
    
    //STGAP00014329: Check to see if all the household member over 18 years and primary and secondary has
    // records check completed.
    String saveAndSubmit = safetyResourceSaveSI.getMethod();
    if(SUBMIT.equals(saveAndSubmit)){
      boolean hasRecordsCheck = checkForRecordsCheck(safetyResourceSaveSI.getUlIdPrimary(), safetyResourceSaveSI.getUlIdSecondary(), safetyResourceSaveSI.getCheckedHshldMembers());
      
      Date dtLastUpdate = commonDAO.findDtLastUpdate(SAFETY_RSRC_ASMNT_NARR, safetyResourceSaveSI.getUlIdEvent());
      
     if(dtLastUpdate == null){
       throw new ServiceException(Messages.MSG_SFTY_RSRC_ASSESS_FORM_REQ);
     }
      
     // SMS #112163
     // Updated the name of the message from MSG_MISSING_REC_CHECK_OVER_18 to MSG_MISSING_REC_CHECK_OVER_17
     // to be in sync with the message text and name change per policy change
     if(hasRecordsCheck == false){
        throw new ServiceException(Messages.MSG_MISSING_REC_CHECK_OVER_17);
      }
    }
       
    
    
    //regardless of event, at this point we can call saveOrUpdate
    safetyResourceDAO.saveOrUpdateSafetyResource(safetyResource);
     
    safetyResourceSaveSO.setUlIdEvent(ulIdEvent);

    // Lists of persons to delete from SR_HOUSEHOLD_MEMBERS
    List<Integer> deleteList = safetyResourceSaveSI.getDeleteHshldMembers();
    
    if (!addList.isEmpty()) 
    {  
      addHouseholdMembers(addList,ulIdEvent); 
    }
    
    if (!deleteList.isEmpty()) 
    {
      deleteHouseholdMembers(deleteList,ulIdEvent);
    }
    
    //STGAP00014329: Lists of persons to either add or delete from SR_CHILD_CONSIDER_PLCMNT
    List<Integer> addChildrenList = safetyResourceSaveSI.getAddChildConsidered();
    List<Integer> deleteChildrenList = safetyResourceSaveSI.getDeleteChildConsidered();
    
    if (!addChildrenList.isEmpty()) 
    {  
      addChildrenConsiderPlcmnt(addChildrenList,ulIdEvent); 
    }
    
    if (!deleteChildrenList.isEmpty()) 
    {
      deleteChildrenConsiderPlcmnt(deleteChildrenList,ulIdEvent);
    }
   
    return safetyResourceSaveSO;
  
  }
  
  /**
   * This private method calls postEvent to create a new event if this is a new Safety Resource
   *
   * @param safetyResourceSaveSI
   * @param actionCode
   * @return CCMN01UO
   * @throws ServiceException
   */
  private CCMN01UO callPostEvent(SafetyResourceSaveSI safetyResourceSaveSI, String actionCode) 
         throws ServiceException {
	
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = "Safety Resource placement with ";	

    Person person = personDAO.findPersonByIdPerson(safetyResourceSaveSI.getUlIdPrimary());
    
    desc = desc+" "+person.getNmPersonFull();
    
    int idEvent = safetyResourceSaveSI.getUlIdEvent();

    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    rowccmn01uig00.setSzCdTask(safetyResourceSaveSI.getCdTask());
    rowccmn01uig00.setSzCdEventStatus(safetyResourceSaveSI.getSzEventStatus());
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_SRP);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(safetyResourceSaveSI.getCdTask());
    rowccmn01uig00.setUlIdStage(safetyResourceSaveSI.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(safetyResourceSaveSI.getUlIdPerson());
    rowccmn01uig00.setUlIdStage(safetyResourceSaveSI.getUlIdStage());   
    rowccmn01uig00.setUlIdEvent(safetyResourceSaveSI.getUlIdEvent());
    rowccmn01uig00.setTsLastUpdate(safetyResourceSaveSI.getDtLastUpdate());

    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();   
    archInputStruct.setCReqFuncCd(actionCode);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
   
  
    return postEvent.postEvent(ccmn01ui);
  }
  
  

  
  
  
 
  
  /**
   * This private method inserts a record into EVENT_PERSON_LINK for the primary
   * safety resource if this is a new event.
   *
   * @param idEvent
   * @param idPerson
   * @return 
   * @throws ServiceException
   */
  private void updateEPL(int idEvent, int idPerson) throws ServiceException{
   
    eventPersonLinkDAO.insertEventPersonLink(idEvent, idPerson);
    
  }
  
  /**
   * This private method iterates through the add list to insert new rows to
   * SR_HOUSEHOLD_MEMBERS for principals and collaterals newly clicked
   *
   * @param idEvent
   * @param addList
   * @return 
   * @throws ServiceException
   */
  private void addHouseholdMembers (List<Integer> addList, int idEvent) throws ServiceException{

    for (Iterator <Integer> it = addList.iterator(); it.hasNext();) {
    
      int person = it.next().intValue();
      
      SafetyResource safetyResource = safetyResourceDAO.findSafetyResourceByIdEvent(idEvent);
      
      SrHouseholdMembers srHouseholdMember = new SrHouseholdMembers();
      srHouseholdMember.setIdPerson(person);
      srHouseholdMember.setSafetyResource(safetyResource);
      
      srHouseholdMembersDAO.saveOrUpdateSrHouseholdMembers(srHouseholdMember); 
    }
  }
  
  /**
   * This private method iterates through the delete list to delete rows from
   * SR_HOUSEHOLD_MEMBERS for principals and collaterals unclicked since last save
   *
   * @param idEvent
   * @param delList
   * @return 
   * @throws ServiceException
   */
  private void deleteHouseholdMembers (List<Integer> delList, int idEvent) throws ServiceException{

    for (Iterator <Integer> it = delList.iterator(); it.hasNext();) {
    
      int person = it.next().intValue();
      srHouseholdMembersDAO.deleteSrHouseholdMembersByPersonAndEvent(person, idEvent); 
    }
  }
  
  
  /**
   * This private method iterates through the add list to insert new rows to
   * SR_CHILD_CONSIDER_PLCMNT for members newly clicked
   *
   * @param idEvent
   * @param addList
   * @return 
   * @throws ServiceException
   */
  private void addChildrenConsiderPlcmnt (List<Integer> addList, int idEvent) throws ServiceException{

    for (Iterator <Integer> it = addList.iterator(); it.hasNext();) {
    
      int person = it.next().intValue();
      
      SafetyResource safetyResource = safetyResourceDAO.findSafetyResourceByIdEvent(idEvent);
      
      SrChildConsiderPlcmnt srChildConsiderPlcmnt = new SrChildConsiderPlcmnt();
      srChildConsiderPlcmnt.setIdPerson(person);
      srChildConsiderPlcmnt.setSafetyResource(safetyResource);
      
      srChildrenConsideredPlacementDAO.saveOrUpdateSrChildrenConsidered(srChildConsiderPlcmnt); 
    }
  }
  
  /**
   * This private method iterates through the delete list to delete rows from
   * SR_CHILD_CONSIDER_PLCMNT for members unclicked since last save
   *
   * @param idEvent
   * @param delList
   * @return 
   * @throws ServiceException
   */
  private void deleteChildrenConsiderPlcmnt (List<Integer> delList, int idEvent) throws ServiceException{

    for (Iterator <Integer> it = delList.iterator(); it.hasNext();) {
    
      int person = it.next().intValue();
      srChildrenConsideredPlacementDAO.deleteSrChildrenConsiderByPersonAndEvent(person, idEvent); 
    }
  }
  
  /**
   * STGAP00014329: This private method checks to see if all the household member over 18 years and primary and secondary has
   * records check completed.
   *
   * @param idPrimary
   * @param idSecondary
   * @param addList
   * @return 
   */

  private boolean checkForRecordsCheck (int idPrimary, int idSecondary, List<Integer> checkedHshldMemebers){
    boolean hasRCCompletePrimary = false;
    boolean hasRCCompleteSecondary = false;
    boolean hasRCComplete = false;
    
    //STGAP00014329: 
    //Each resource household member selected over 18 yrs. at the time of approval as well as both the Primary Safety Resource and Secondary Safety Resource (if selected) must have at least:
    // 1 completed (Date Completed entered) records check of type SUCCESS and, 
    // 1 completed (Date Completed entered) records check of type County Master File and
    // 1 completed (Date Completed entered) records check of type GBI Sex Offender Registry and 
    // 1 completed (Date Completed entered) records check of type Department of Corrections Offender Query and
    // 1 completed (Date Completed entered) records check of type Board of Pardons and Parole and 
    // 1 completed (Date Completed entered) records check of type GCIC
    String isRecordsCheckComplete = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPerson(idPrimary);
    
    //SMS 69955 Records Check Code has changed
    String isRecordsCheckCompleteNewCodes = recordsCheckDAO.findCompletedRecordsCheckNewCodesByIdRecCheckPerson(idPrimary);
    if(ArchitectureConstants.Y.equals(isRecordsCheckComplete) || ArchitectureConstants.Y.equals(isRecordsCheckCompleteNewCodes)){
      hasRCCompletePrimary = true;
    }else{
      hasRCCompletePrimary = false;
    }
    
    //Secondary Safety Resource (if selected) then check for the records check
    if(idSecondary != 0){
      isRecordsCheckComplete = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPerson(idSecondary);
      
      //SMS 69955 Records Check Code has changed
      isRecordsCheckCompleteNewCodes = recordsCheckDAO.findCompletedRecordsCheckNewCodesByIdRecCheckPerson(idPrimary);
      if(ArchitectureConstants.Y.equals(isRecordsCheckComplete) || ArchitectureConstants.Y.equals(isRecordsCheckCompleteNewCodes)){
        hasRCCompleteSecondary = true;
      }else{
        hasRCCompleteSecondary = false;
      }
    }
    
    if(idSecondary == 0){
      hasRCCompleteSecondary = true;
    }
    
    //For the House hold members selected and who are check the records 
    if (!checkedHshldMemebers.isEmpty()) 
    {  
      for (Iterator <Integer> it = checkedHshldMemebers.iterator(); it.hasNext();) {
        int idPerson = it.next().intValue();
        
        // CAPTA 4.3 Policy changed to look at children 17 and older instead of 18
        Integer idPersonObj = personDAO.findCurrentAgeOver17Person(idPerson);
        int idPErsonOver18 = idPersonObj != null ? idPersonObj : 0;
        if(idPErsonOver18 != 0){
          isRecordsCheckComplete = recordsCheckDAO.findCompletedRecordsCheckByIdRecCheckPerson(idPerson);
          
          //SMS 69955 Records Check Code has changed
          isRecordsCheckCompleteNewCodes = recordsCheckDAO.findCompletedRecordsCheckNewCodesByIdRecCheckPerson(idPrimary);
          if(ArchitectureConstants.N.equals(isRecordsCheckComplete) && ArchitectureConstants.N.equals(isRecordsCheckCompleteNewCodes)){
            hasRCComplete = false;
            break;
          }else{
            hasRCComplete = true;
          }
        }else{
          hasRCComplete = true;
        }
      }
    }else{
      hasRCComplete = true;
    }
    
    if(hasRCCompletePrimary && hasRCCompleteSecondary && hasRCComplete){
      return true;
    }else{
      return false;
    }
  }
  
}
