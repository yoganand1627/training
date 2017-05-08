package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility.ToDo;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvHmeWaiverChildHistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvStateConcurDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SpclInvestigationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHist;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvHmeWaiverChildHistId;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvStateConcur;
import gov.georgia.dhr.dfcs.sacwis.db.SpclInvestigation;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveSpclInvestigation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvHmeWaiverChildHistBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SpclInvestigationSaveSO;

import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * @author Herve Jean-Baptiste  May 22, 2011
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------           
 *   06/21/2011   hjbaptiste               SMS112430: Removed the call to CheckStageEventStatus as that was preventing
 *                                         save for a closed stage
 *   10/31/2011   arege                    STGAP00016924: Delete the "2270" Task Todo created for CaseManager after he Saves and Submits the Spcl Inv
 * </pre>
 * 
 */

public class SaveSpclInvestigationImpl extends BaseServiceImpl implements SaveSpclInvestigation {

  private SpclInvestigationDAO spclInvestigationDAO = null; 
  private SpclInvHmeWaiverChildHistDAO spclInvHmeWaiverChildHistDAO = null;
  private SpclInvStateConcurDAO spclInvStateConcurDAO = null;
  private EventDAO eventDAO = null;
  private PostEvent postEvent = null;
  private TodoDAO todoDAO = null;
  
  public void setSpclInvestigationDAO(SpclInvestigationDAO spclInvestigationDAO) {
    this.spclInvestigationDAO = spclInvestigationDAO;
  }

  public void setSpclInvHmeWaiverChildHistDAO(SpclInvHmeWaiverChildHistDAO spclInvHmeWaiverChildHistDAO) {
    this.spclInvHmeWaiverChildHistDAO = spclInvHmeWaiverChildHistDAO;
  }

  public void setSpclInvStateConcurDAO(SpclInvStateConcurDAO spclInvStateConcurDAO) {
    this.spclInvStateConcurDAO = spclInvStateConcurDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }  
  
  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }
  
  public SpclInvestigationSaveSO saveSpclInvestigation(SpclInvestigationRetrieveSO spclInvestigationRetrieveSO)
                                                                                                               throws ServiceException {
    SpclInvestigationSaveSO spclInvestigationSaveSO = new SpclInvestigationSaveSO();
    int idEvent = spclInvestigationRetrieveSO.getIdEvent();
    int idStage = spclInvestigationRetrieveSO.getIdStage();
    int idUser = spclInvestigationRetrieveSO.getIduser();
    String cdEventStatus = spclInvestigationRetrieveSO.getCdEventStatus();
    String cdReqAction = spclInvestigationRetrieveSO.getCdReqAction();
    String cdTask = spclInvestigationRetrieveSO.getCdTask();
    String nmResource = spclInvestigationRetrieveSO.getNmResource();
    boolean isApprover = spclInvestigationRetrieveSO.getIsApprover();

    List<EventPersonLink> eventPersonLinkList = null;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqAction)) {
      CCMN01UO ccmn01uo = new CCMN01UO();
      ccmn01uo = callPostEvent(idEvent, idUser, idStage, cdReqAction, cdTask, cdEventStatus, nmResource, isApprover, eventPersonLinkList);
      idEvent = ccmn01uo.getUlIdEvent();
      Event spclInvEvent = (Event) getPersistentObject(Event.class, ccmn01uo.getUlIdEvent());
      SpclInvestigation spclInvestigation = new SpclInvestigation();
      // Set all of the properties from the spclInvestigationRetrieveSO into SpclInvestigation
      spclInvestigation.setIndRcmndPlcmntRsrcClosed(spclInvestigationRetrieveSO.getIndRcmndPlcmntRsrcClosed());
      spclInvestigation.setIndRcmndChldrnRemoved(spclInvestigationRetrieveSO.getIndRcmndChldrnRemoved());
      spclInvestigation.setIndRcmndActionPlanDvlpd(spclInvestigationRetrieveSO.getIndRcmndActionPlanDvlpd());
      spclInvestigation.setIndRcmndNoChangeStatus(spclInvestigationRetrieveSO.getIndRcmndNoChangeStatus());
      spclInvestigation.setIndRcmndWaiverAttached(spclInvestigationRetrieveSO.getIndRcmndWaiverAttached());
      spclInvestigation.setIndRcmndCpaCciNotUsed(spclInvestigationRetrieveSO.getIndRcmndCpaCciNotUsed());
      spclInvestigation.setIndRcmndOther(spclInvestigationRetrieveSO.getIndRcmndOther());
      spclInvestigation.setIndRecordChkViewed(spclInvestigationRetrieveSO.getIndRecordChkViewed());
      spclInvestigation.setTxtRcmndOtherComments(spclInvestigationRetrieveSO.getTxtRcmndOtherComments());
      spclInvestigation.setTxtResults48hrStaffing(spclInvestigationRetrieveSO.getTxtResults48hrStaffing());
      spclInvestigation.setTxtNamesAgncyRepStaffing(spclInvestigationRetrieveSO.getTxtNamesAgncyRepStaffing());
      spclInvestigation.setTxtJustHmeRemainOpen(spclInvestigationRetrieveSO.getTxtJustHmeRemainOpen());
      spclInvestigation.setTxtSynopsisRecReviewed(spclInvestigationRetrieveSO.getTxtSynopsisRecReviewed());
      spclInvestigation.setTxtStepsAssureSafety(spclInvestigationRetrieveSO.getTxtStepsAssureSafety());
      spclInvestigation.setEvent(spclInvEvent);
      spclInvestigation.setIdSpclInvEvent(ccmn01uo.getUlIdEvent());
      spclInvestigationDAO.saveSpclInvestigation(spclInvestigation);
      
    }else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqAction)) {
      Event spclInvEvent = (Event) getPersistentObject(Event.class, idEvent);
      SpclInvestigation spclInvestigation = (SpclInvestigation) getPersistentObject(SpclInvestigation.class, idEvent);
      Person person = spclInvEvent.getPerson();
      if (person != null) {
        idUser = person.getIdPerson();
      }
      // Set all of the properties from the spclInvestigationRetrieveSO into SpclInvestigation
      // excluding the State Office Concurrence section
      spclInvestigation.setIndRcmndPlcmntRsrcClosed(spclInvestigationRetrieveSO.getIndRcmndPlcmntRsrcClosed());
      spclInvestigation.setIndRcmndChldrnRemoved(spclInvestigationRetrieveSO.getIndRcmndChldrnRemoved());
      spclInvestigation.setIndRcmndActionPlanDvlpd(spclInvestigationRetrieveSO.getIndRcmndActionPlanDvlpd());
      spclInvestigation.setIndRcmndNoChangeStatus(spclInvestigationRetrieveSO.getIndRcmndNoChangeStatus());
      spclInvestigation.setIndRcmndWaiverAttached(spclInvestigationRetrieveSO.getIndRcmndWaiverAttached());
      spclInvestigation.setIndRcmndCpaCciNotUsed(spclInvestigationRetrieveSO.getIndRcmndCpaCciNotUsed());
      spclInvestigation.setIndRcmndOther(spclInvestigationRetrieveSO.getIndRcmndOther());
      spclInvestigation.setIndRecordChkViewed(spclInvestigationRetrieveSO.getIndRecordChkViewed());
      spclInvestigation.setTxtRcmndOtherComments(spclInvestigationRetrieveSO.getTxtRcmndOtherComments());
      spclInvestigation.setTxtResults48hrStaffing(spclInvestigationRetrieveSO.getTxtResults48hrStaffing());
      spclInvestigation.setTxtNamesAgncyRepStaffing(spclInvestigationRetrieveSO.getTxtNamesAgncyRepStaffing());
      spclInvestigation.setTxtJustHmeRemainOpen(spclInvestigationRetrieveSO.getTxtJustHmeRemainOpen());
      spclInvestigation.setTxtSynopsisRecReviewed(spclInvestigationRetrieveSO.getTxtSynopsisRecReviewed());
      spclInvestigation.setTxtStepsAssureSafety(spclInvestigationRetrieveSO.getTxtStepsAssureSafety());
      
      CCMN01UO ccmn01uo = callPostEvent(idEvent, idUser, idStage, cdReqAction, cdTask, cdEventStatus, nmResource, isApprover, eventPersonLinkList);
      if (ccmn01uo != null) {
        idEvent = ccmn01uo.getUlIdEvent();
        spclInvEvent = (Event) getPersistentObject(Event.class, idEvent);
        spclInvestigationRetrieveSO.setDtEventLastUpdate(ccmn01uo.getTsLastUpdate());
      }
      spclInvestigation.setEvent(spclInvEvent);
      spclInvestigation.setIdSpclInvEvent(idEvent);
      
      // If the event status is either PEND, COMP or APRV, save the data from the 
      // State Office Concurrence section 
      if (!(CodesTables.CEVTSTAT_NEW.equals(spclInvEvent.getCdEventStatus()) || CodesTables.CEVTSTAT_PROC.equals(spclInvEvent.getCdEventStatus()))) {
        // Set the data from the section out of spclInvestigationRetrieveSO into SpclInvestigation
        spclInvestigation.setDtSpclInvApproved(spclInvestigationRetrieveSO.getDtSpclInvApproved());
        spclInvestigation.setIndConcurAssmntDisp(spclInvestigationRetrieveSO.getIndConcurAssmntDisp());
        spclInvestigation.setIndConcurActionRecmnd(spclInvestigationRetrieveSO.getIndConcurActionRecmnd());
        spclInvestigation.setTxtConcurComments(spclInvestigationRetrieveSO.getTxtConcurComments());
        
        // Don't worry about finding out what codes existed before and need to be updated
        // and what codes need to be added that didn't exist before. Instead, just delete
        // all codes for this Special Investigation and insert the ones that's been
        // checked on the page
        int numRecordsDeleted = spclInvStateConcurDAO.deleteStateConcurrence(idEvent);
        List<String> concurrenceCodes = spclInvestigationRetrieveSO.getConcurrenceCodes();
        if (concurrenceCodes != null && !concurrenceCodes.isEmpty()) {
          for (String c : concurrenceCodes) {
            SpclInvStateConcur sisc = new SpclInvStateConcur();
            sisc.setSpclInvEvent(spclInvestigation);
            sisc.setCdStateConcur(c);
            spclInvStateConcurDAO.saveStateConcurrence(sisc);
          }
        }
      }
      
      spclInvestigationDAO.saveSpclInvestigation(spclInvestigation);
    } 
    
    // Save the waiver children history records
    List<SpclInvHmeWaiverChildHistBean> waiverChildHistBeans = spclInvestigationRetrieveSO.getSpclInvHmeWaiverChildHistBeans();
    if (waiverChildHistBeans != null && !waiverChildHistBeans.isEmpty()) {
      for (SpclInvHmeWaiverChildHistBean wb : waiverChildHistBeans) {
        SpclInvHmeWaiverChildHist spclInvHmeWaiverChildHist = spclInvHmeWaiverChildHistDAO.findSpclInvHmeWaiverChildHistByIdEventIdChild(idEvent, wb.getIdChild());
        if (spclInvHmeWaiverChildHist == null) {
          spclInvHmeWaiverChildHist = new SpclInvHmeWaiverChildHist(); 
        }
        Person personChild = (Person) getPersistentObject(Person.class, wb.getIdChild());
        SpclInvHmeWaiverChildHistId id = 
          new SpclInvHmeWaiverChildHistId((Integer) personChild.getIdPerson(), (Integer) idEvent);
        spclInvHmeWaiverChildHist.setId(id);
        spclInvHmeWaiverChildHist.setCdChildPlcmntType(wb.getCdChildPlcmntType());
        spclInvHmeWaiverChildHist.setNumMonthsInPlcmnt(wb.getNumMonthsInPlcmnt());
        spclInvHmeWaiverChildHist.setNumYearInPlcmnt(wb.getNumYearInPlcmnt());
        spclInvHmeWaiverChildHist.setCdChildLegalCounty(wb.getCdChildLegalCounty());
        spclInvHmeWaiverChildHist.setCdChildLegalStatus(wb.getCdChildLegalStatus());
        spclInvHmeWaiverChildHist.setCdChildPermncyPlan(wb.getCdChildPermncyPlan());
        spclInvHmeWaiverChildHist.setCdChildConcurPlan(wb.getCdChildConcurPlan());
        spclInvHmeWaiverChildHist.setIndRemainInHome(wb.getIndRemainInHome());
        spclInvHmeWaiverChildHistDAO.saveSpclInvHmeWaiverChildHist(spclInvHmeWaiverChildHist);
      }
    }
    
    //Delete TaskToDo for CaseManager
    
    String cdTodoTask = "2270";
    String descr = "Submit the county recommendation for";
    if(spclInvestigationRetrieveSO.getIsSaveAndSubmitButton()){
    int rowsDeleted = todoDAO.deleteTodoByIdCaseManagerIdStageCdTypeAndDescr(idUser, idStage, cdTodoTask, descr);
    }
    spclInvestigationSaveSO.setIdEvent(idEvent);
    return spclInvestigationSaveSO;
  }
  
  /**
   * Updates or inserts the event for Contact Standards
   * 
   * @param 
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(int idEvent, int idPerson, int idStage, String  cdReqAction, String cdTask, 
                                 String eventStatus, String nmResource, boolean isApprover, List<EventPersonLink> eventPersonLinkList) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = StringHelper.EMPTY_STRING;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdReqAction) || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdReqAction)) {
      if (CodesTables.CEVTSTAT_NEW.equals(eventStatus) || CodesTables.CEVTSTAT_PROC.equals(eventStatus) ) {
        eventStatus = CodesTables.CEVTSTAT_PROC;
        desc = "Special Investigation has been saved but has not been submitted for Approval.";
        if((CodesTables.CEVTSTAT_PEND.equals(eventStatus) || CodesTables.CEVTSTAT_PROC.equals(eventStatus)) && isApprover){
          eventStatus = CodesTables.CEVTSTAT_PEND;
        }
      }
      if (CodesTables.CEVTSTAT_PEND.equals(eventStatus)){
        desc = "Special Investigation has been submitted for Approval.";
      }
    }

    Date dtEventOccurred = null;
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_SPI);
    rowccmn01uig00.setSzCdTask(cdTask);
    rowccmn01uig00.setUlIdPerson(idPerson);
    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setUlIdEvent(idEvent);

    if(idEvent != 0){
      Event event = eventDAO.findEventByIdEvent(idEvent);
      if(event != null){
        // Set the date last update from what is in the DB or else we can get a time stamp mismatch message
        Date dtEventLastUpdated = event.getDtLastUpdate();
        rowccmn01uig00.setTsLastUpdate(dtEventLastUpdated);
        dtEventOccurred = event.getDtEventOccurred();
        if (eventPersonLinkList != null && !eventPersonLinkList.isEmpty()) {
          Iterator<EventPersonLink> eventPersonLinkList_it = eventPersonLinkList.iterator();
          while (eventPersonLinkList_it.hasNext()) {
            EventPersonLink deleteEventPersonLink = eventPersonLinkList_it.next();
            Person person = deleteEventPersonLink.getPerson();
            ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
            rowccmn01uig01.setUlIdPerson(person.getIdPerson()); 
            rowccmn01uig01.setSzCdScrDataAction(cdReqAction);
            rowccmn01uig01.setTsLastUpdate(dtEventLastUpdated);
            rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
          }
        }
      }
    }
    if (!DateHelper.isNull(dtEventOccurred) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cdReqAction);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);

  }

}
