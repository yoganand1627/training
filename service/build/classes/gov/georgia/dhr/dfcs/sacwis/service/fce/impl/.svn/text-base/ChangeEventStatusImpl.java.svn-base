package gov.georgia.dhr.dfcs.sacwis.service.fce.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.fce.ChangeEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;

public class ChangeEventStatusImpl extends BaseServiceImpl implements ChangeEventStatus {
  
  public static final String PENDING_EVENT = CodesTables.CEVTSTAT_PEND;
  public static final String PROCESS_EVENT = CodesTables.CEVTSTAT_PROC;
  
  private EventDAO eventDAO = null;
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  
  private PostEvent postEvent = null;
  
  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public boolean changeEventStatus(int idEvent) {
    boolean isSuccessful = false;
    Event event = new Event();
    event = eventDAO.findEventByIdEvent(idEvent);
    changeEventStatus(event, PROCESS_EVENT, PENDING_EVENT);
    isSuccessful = true;
    return isSuccessful;
  }
  
  private void changeEventStatus(Event event, String eventStatusWas,
                                 String eventStatusWillBe) {
    String eventDescr = "Foster Care Redetermination has been submitted to the Eligibility Specialist.";
    String currentEventStatus = event.getCdEventStatus();
    if (eventStatusWas.contains(currentEventStatus) == false) {
      return;
    }
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn01ui.setArchInputStruct(archInputStruct);
    archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    rowccmn01uig00.setUlIdEvent((int) event.getIdEvent());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setUlIdStage((int) event.getStage().getIdStage());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    if(event.getPerson() != null){
      rowccmn01uig00.setUlIdPerson((int) event.getPerson().getIdPerson());
    }else{
      rowccmn01uig00.setUlIdPerson(0);
    }
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setSzTxtEventDescr(eventDescr);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new java.util.Date()));
    rowccmn01uig00.setSzCdEventStatus(eventStatusWillBe);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
}
}
