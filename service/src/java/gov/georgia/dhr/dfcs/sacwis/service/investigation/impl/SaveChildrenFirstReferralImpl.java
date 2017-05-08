
package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ChildrenFirstReferralDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.ChildrenFirstReferral;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveChildrenFirstReferral;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralSaveSO;

import java.util.Date;

/**
 * 
 * This class provides the service that saves the Children First Referral.
 *
 * @author ashwini.rege
 * 
 * Change History:
 **  Date        User              Description
 **  --------    ----------------  ----------------------------------------------------------------
 *   02/08/2010   arege            STGAP00015749: Added code for the new field Release on File.
 *   02/20/2010   arege            STGAP00015749: Event Description for COMP events should include date referral sent.
 *   02/23/2020   arege            SMS#46062: Date Generated on Children 1st Referral page does not display 
 *   03/04/2010   arege            SMS#46940: Child First Referral - Error message displays after clicking the Save button
 *   03/11/2010   arege            SMS#47644: Changed the from generic error message to MSG_CFR_COMP_NOT_SAVED 
 *   03/26/2010   arege            SMS#48857: Added stage name to the event description
 */

public class SaveChildrenFirstReferralImpl extends BaseServiceImpl implements SaveChildrenFirstReferral{
  
  private CheckStageEventStatus checkStageEventStatus = null;

  private ChildrenFirstReferralDAO  childrenFirstReferralDAO = null;
  
  private EventDAO eventDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private PostEvent postEvent = null;
  
  public CheckStageEventStatus getCheckStageEventStatus() {
    return checkStageEventStatus;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public ChildrenFirstReferralDAO getChildrenFirstReferralDAO() {
    return childrenFirstReferralDAO;
  }

  public void setChildrenFirstReferralDAO(ChildrenFirstReferralDAO childrenFirstReferralDAO) {
    this.childrenFirstReferralDAO = childrenFirstReferralDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public PostEvent getPostEvent() {
    return postEvent;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public ChildrenFirstReferralSaveSO saveChildrenFirstReferral(ChildrenFirstReferralSaveSI childrenFirstReferralSaveSI)
                                                                                                                       throws ServiceException {

    ChildrenFirstReferralSaveSO childrenFirstReferralSaveSO = new ChildrenFirstReferralSaveSO();
    ROWCCMN01UIG00 cfrEvent = childrenFirstReferralSaveSI.getRowccmn01uig00();

    int idEvent = cfrEvent.getUlIdEvent();
    int idUser = childrenFirstReferralSaveSI.getIdCaseWorker();
    int idChildRefered = childrenFirstReferralSaveSI.getIdChildReferred();
    String cdTask = childrenFirstReferralSaveSI.getCdTask();

    Event event = null;
    cfrEvent.setUlIdPerson(idUser);

    String actionCode = ServiceConstants.REQ_FUNC_CD_ADD;
    if (idEvent != 0) {
      actionCode = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }
    // CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(idStage, idUser,
    // childrenFirstReferralSaveSI.getCdTask(), actionCode);
    // checkStageEventStatus.status(ccmn06ui);

    ChildrenFirstReferral cfr = new ChildrenFirstReferral();
    if (idEvent != 0) {
      cfr = (ChildrenFirstReferral) getPersistentObject(ChildrenFirstReferral.class, idEvent);
      event = (Event) getPersistentObject(Event.class, idEvent);
      cfr.setEventByIdEvent(event);
    }

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(childrenFirstReferralSaveSI.getCdReqFuncCd())) {
      int idEventToDelete = childrenFirstReferralSaveSI.getIdEvent();

      EventPersonLink epl = eventPersonLinkDAO.findEventPersonLinkByIdEventAndIdPerson(idEvent, idChildRefered);
      if (epl != null) {
        eventPersonLinkDAO.deleteEventPersonLink(idEvent, idChildRefered, epl.getDtLastUpdate());
      }
      childrenFirstReferralDAO.deleteCFR(idEventToDelete);
      if (childrenFirstReferralSaveSI.getIdGenerationEvent() != 0) {
        Event cfgEvent = eventDAO.findEventByIdEvent(childrenFirstReferralSaveSI.getIdGenerationEvent());
        if (cfgEvent != null) {
          eventDAO.deleteEvent(cfgEvent);
        }
      }
      callPostEvent(childrenFirstReferralSaveSI, childrenFirstReferralSaveSI.getCdReqFuncCd());
    } else {
      cfr = populate_ChildFirstRef_SaveSI(childrenFirstReferralSaveSI, cfr);

      CCMN01UO ccmn01uo = callPostEvent(childrenFirstReferralSaveSI, actionCode);
      if (ccmn01uo != null) {
        idEvent = ccmn01uo.getUlIdEvent();
        event = (Event) getPersistentObject(Event.class, idEvent);
      }
      cfr.setEventByIdEvent(event);
      cfr.setIdEvent(idEvent);
      
      //SMS#46940: Child First Referral - Error message displays after clicking the Save button
      //SMS#47644: Changed the error message from generic to MSG_CFR_COMP_NOT_SAVED 
      if(ArchitectureConstants.Y.equals(cfr.getIndComplete()) && cfr.getDtGeneration() == null){
        throw new ServiceException(Messages.MSG_CFR_COMP_NOT_SAVED);
      }

      childrenFirstReferralDAO.saveChildrenFirstReferral(cfr);
      childrenFirstReferralSaveSO.setIdEvent(idEvent);
      childrenFirstReferralSaveSO.setCdTask(cdTask);
    }
    return childrenFirstReferralSaveSO;
}
  
  /**
   * Populates the bean necessary to run the CheckStageEventStatus service
   * 
   * @param idStage
   * @param idUser
   * @param cdTask
   * @param actionCode
   * @return Populated CheckStageEventStatus Bean
   */
  private CCMN06UI populateCCMN06UI_CheckStageEventStatus(int idStage, int idUser, String cdTask, String actionCode) {

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();

    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);

    input.setSzUserId(String.valueOf(idUser));
    input.setCReqFuncCd(actionCode);

    ccmn06ui.setArchInputStruct(input);

    return ccmn06ui;
  }
  
  private ChildrenFirstReferral populate_ChildFirstRef_SaveSI(ChildrenFirstReferralSaveSI childrenFirstReferralSaveSI, ChildrenFirstReferral childFirRefDB) {
    childFirRefDB.setDtReferralSent(childrenFirstReferralSaveSI.getDtDtReferralSent());
    childFirRefDB.setIndParentalRelease(childrenFirstReferralSaveSI.getIndParentalRelease());
    childFirRefDB.setRelOnFile(childrenFirstReferralSaveSI.getRelOnFile());
    childFirRefDB.setIndComplete(childrenFirstReferralSaveSI.getIndComplete());
    childFirRefDB.setDtAcknowledge(childrenFirstReferralSaveSI.getDtDtAcknowledge());
    childFirRefDB.setDtPhySummary(childrenFirstReferralSaveSI.getDtPhySummary());
    if(childrenFirstReferralSaveSI.getDtPhySummary() != null){
    childFirRefDB.setIndFurtherAssmt(childrenFirstReferralSaveSI.getIndFurtherAssmt());
    }else{
    childFirRefDB.setIndFurtherAssmt("");
    }
    childFirRefDB.setDtIfsp(childrenFirstReferralSaveSI.getDtIFSP());
    childFirRefDB.setTxtComments(childrenFirstReferralSaveSI.getTxtComments());
    childFirRefDB.setIdChildReferred(childrenFirstReferralSaveSI.getIdChildReferred());
    CapsCase capsCase = getPersistentObject(CapsCase.class, childrenFirstReferralSaveSI.getIdCase());
    childFirRefDB.setCapsCase(capsCase);   
    return childFirRefDB;
  }
  
  /**
   * Creates/updates the event for Children 1st Referral
   * 
   * @param childrenFirstReferralSaveSI
   * @param actionCode
   * @return Post Event Output Bean
   */
  private CCMN01UO callPostEvent(ChildrenFirstReferralSaveSI childrenFirstReferralSaveSI, String actionCode) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    String desc = StringHelper.EMPTY_STRING;
    int idEvent = childrenFirstReferralSaveSI.getIdEvent();
    int idPerson = childrenFirstReferralSaveSI.getIdChildReferred();
    Person child =  getPersistentObject(Person.class, idPerson);
    String eventStatus = CodesTables.CEVTSTAT_PROC;
    desc = "Children 1st Referral - " + child.getNmPersonFull();
    
    if (idEvent != 0){
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(childrenFirstReferralSaveSI.getDtEventLastUpdate());
      eventStatus = childrenFirstReferralSaveSI.getROWCCMN01UIG00().getSzCdEventStatus();
      rowccmn01uig00.setSzCdEventStatus(eventStatus);
      if(CodesTables.CEVTSTAT_COMP.equals(eventStatus)){
        desc = desc + " - sent " + DateHelper.toString(childrenFirstReferralSaveSI.getDtDtReferralSent(), DateHelper.SLASH_FORMAT);
      }        
    }
    if (desc.length() > 100) {
      desc = desc.substring(0, 99);
    }
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CFR);
    rowccmn01uig00.setSzTxtEventDescr(desc);
    rowccmn01uig00.setSzCdTask(childrenFirstReferralSaveSI.getCdTask());
    rowccmn01uig00.setUlIdPerson(childrenFirstReferralSaveSI.getIdCaseWorker());
    rowccmn01uig00.setUlIdStage(childrenFirstReferralSaveSI.getIdStage());
    if (!DateHelper.isNull(childrenFirstReferralSaveSI.getDtEventOccurred()) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(childrenFirstReferralSaveSI.getDtEventOccurred()));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));

    }
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (idPerson != 0) {
      rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idPerson);
      rowccmn01uig01.setSzCdScrDataAction(actionCode);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
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
}
