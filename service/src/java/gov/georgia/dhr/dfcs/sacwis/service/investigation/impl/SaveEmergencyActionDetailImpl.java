package gov.georgia.dhr.dfcs.sacwis.service.investigation.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsInvstDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmergencyAssistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CpsInvstDetail;
import gov.georgia.dhr.dfcs.sacwis.db.EmergencyAssist;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.SaveEmergencyActionDetail;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV12SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV12SO;

public class SaveEmergencyActionDetailImpl extends BaseServiceImpl implements SaveEmergencyActionDetail {
  private CheckStageEventStatus checkStageEventStatus = null;
  private InvalidateApproval invalidateApproval = null;
  private PostEvent postEvent = null;
  private EventDAO eventDAO = null;
  private TodoDAO todoDAO = null;
  private EmergencyAssistDAO emergencyAssistDAO = null;
  private CpsInvstDetailDAO cpsInvstDetailDAO = null;

  public void setEmergencyAssistDAO(EmergencyAssistDAO emergencyAssistDAO) {
    this.emergencyAssistDAO = emergencyAssistDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setCpsInvstDetailDAO(CpsInvstDetailDAO cpsInvstDetailDAO) {
    this.cpsInvstDetailDAO = cpsInvstDetailDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public CINV12SO saveEmergencyActionDetail(CINV12SI cinv12si) throws ServiceException {
    CINV12SO cinv12so = new CINV12SO();
//    ROWCCMN01UIG00 rowccmn01uig00 = cinv12si.getROWCCMN01UIG00();
//    int rowccmn01uig00IdEvent = rowccmn01uig00.getUlIdEvent();
    ArchInputStruct archInputStruct = cinv12si.getArchInputStruct();
//    if (0 == rowccmn01uig00IdEvent) {
//      rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
//      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
//    } else {
//      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
//      cinv12so.setUlIdEvent(rowccmn01uig00IdEvent);
//    }
    // Call CheckStageEventStatus
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(archInputStruct);
    ccmn06ui.setUlIdStage(cinv12si.getUlIdStage());
    ccmn06ui.setSzCdTask("2330");
    checkStageEventStatus.status(ccmn06ui);
    // Call PostEvent
//    int cinv12soIdEvent = callPostEvent(rowccmn01uig00, archInputStruct,
//                                        cinv12so.getUlIdEvent(), rowccmn01uig00IdEvent);
//    cinv12so.setUlIdEvent(cinv12soIdEvent);
    // If Event ID for Conclusion window is passed in, the event status is
    // pending, so demote event status for Conclusion and all other related
    // windows in Investigation. Don't demote the events if in "Approver mode"
    int cinv12siIdEvent = cinv12si.getUlIdEvent();
    String cReqFuncCd = archInputStruct.getCReqFuncCd();
    if (ArchitectureConstants.N.equals(archInputStruct.getUlSysNbrReserved1())) {
      if (0 != cinv12siIdEvent) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ccmn05ui.setArchInputStruct(archInputStruct);
//        if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
//          ccmn05ui.setUlIdEvent(rowccmn01uig00IdEvent);
//        } else {
//          // Call CCMN62D; to update the status of the given idEvent
        updateEvent(cinv12siIdEvent);
        ccmn05ui.setUlIdEvent(cinv12siIdEvent);
//        }
        // Call the InvalidateApproval
        invalidateApproval.invalidateApproval(ccmn05ui);
      }
//      if ((0 != rowccmn01uig00IdEvent) && CodesTables.CEVTSTAT_COMP.equals(rowccmn01uig00.getSzCdEventStatus())) {
//        // Calling cinv43d to update status on the Todo table
//        todoDAO.updateTodoByIdEvent(rowccmn01uig00IdEvent);
//      }
    }
    ROWCINV12SIG00_ARRAY rowcinv12sig00_array = cinv12si.getROWCINV12SIG00_ARRAY();
    // Call CINV16D Adds/Updates information for the Emergency Assistance Window.
    //saveEmergencyAssist(rowcinv12sig00_array, cReqFuncCd, cinv12si.getUlIdStage(), cinv12soIdEvent);
    // Call CINV12D Adds/Updates a row of the CPS Invst Detail window
    saveCpsInvstDetail(cinv12si.getROWCINV12SIG01(), rowcinv12sig00_array);
    return cinv12so;
  }

  private int callPostEvent(ROWCCMN01UIG00 rowccmn01uig00, ArchInputStruct archInputStruct,
                            int idEvent, int rowccmn01uig00IdEvent) throws ServiceException {
    int resultIdEvent = idEvent;
    ROWCCMN01UIG00 PostEventInputRec = new ROWCCMN01UIG00();
    PostEventInputRec.setUlIdEvent(rowccmn01uig00IdEvent);
    PostEventInputRec.setUlIdStage(rowccmn01uig00.getUlIdStage());
    PostEventInputRec.setUlIdPerson(rowccmn01uig00.getUlIdPerson());
    PostEventInputRec.setSzCdTask(rowccmn01uig00.getSzCdTask());
    PostEventInputRec.setSzCdEventType(rowccmn01uig00.getSzCdEventType());
    PostEventInputRec.setDtDtEventOccurred(rowccmn01uig00.getDtDtEventOccurred());
    PostEventInputRec.setTsLastUpdate(rowccmn01uig00.getTsLastUpdate());
    PostEventInputRec.setSzTxtEventDescr(rowccmn01uig00.getSzTxtEventDescr());
    PostEventInputRec.setSzCdEventStatus(rowccmn01uig00.getSzCdEventStatus());
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(PostEventInputRec);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    if (0 == resultIdEvent) {
      resultIdEvent = ccmn01uo.getUlIdEvent();
    }
    return resultIdEvent;
  }

  private void updateEvent(int idEvent) throws ServiceException {
    // Calling ccmn62d
    int rows = eventDAO.updateEventByIdEvent(idEvent, CodesTables.CEVTSTAT_COMP);
    if (rows == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
  }

  private void saveEmergencyAssist(ROWCINV12SIG00_ARRAY rowcinv12sig00_array,
                                   String cReqFuncCd, int cinv12siIdStage, int IdEvent) {

    for (Enumeration rowcinv12sigooEnum = rowcinv12sig00_array.enumerateROWCINV12SIG00();
         rowcinv12sigooEnum.hasMoreElements();) {
      ROWCINV12SIG00 rowcinv12sigoo = (ROWCINV12SIG00) rowcinv12sigooEnum.nextElement();
      String cdScrDataAction = rowcinv12sigoo.getSzCdScrDataAction();

      if ((ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) && (0 != cinv12siIdStage)) {
        cdScrDataAction = ServiceConstants.REQ_FUNC_CD_ADD;
      }
      //String cdEaQuestion = rowcinv12sigoo.getSzCdEaQuestion();
      int idEmergencyAssist = 0;
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        idEmergencyAssist = rowcinv12sigoo.getUlIdEmergencyAssist();
      }
      // String indEaResponse = rowcinv12sigoo.getBIndEaResponse();
      int idEvent = IdEvent;
      Date dtLastUpdate = rowcinv12sigoo.getTsLastUpdate();
      EmergencyAssist emergencyAssist = new EmergencyAssist();
      // emergencyAssist.setCdEaQuestion(cdEaQuestion);
      emergencyAssist.setIdEmergencyAssist(idEmergencyAssist);
      // emergencyAssist.setIndEaResponse(indEaResponse);
      Event event = (Event) getPersistentObject(Event.class, idEvent);
      emergencyAssist.setEvent(event);
      emergencyAssist.setDtLastUpdate(dtLastUpdate);
      // Calling cinv16d
      if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cdScrDataAction) ||
          ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cdScrDataAction)) {
        emergencyAssistDAO.saveEmergencyAssist(emergencyAssist);
      } else if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdScrDataAction)) {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
  }

  private void saveCpsInvstDetail(ROWCINV12SIG01 rowcinv12sig01, ROWCINV12SIG00_ARRAY rowcinv12sig00_array) {
    CpsInvstDetail cpsInvstDetail = new CpsInvstDetail();
    cpsInvstDetail.setCdCpsInvstDtlFamIncm(rowcinv12sig01.getSzCdCpsInvstDtlFamIncm());
    cpsInvstDetail.setCdCpsInvstDtlOvrllDisptn(rowcinv12sig01.getCdCpsOverallDisptn());
    cpsInvstDetail.setDtCpsInvstDtlAssigned(DateHelper.toJavaDate(rowcinv12sig01.getDtDtCPSInvstDtlAssigned()));
    cpsInvstDetail.setDtCpsInvstDtlBegun(DateHelper.toJavaDate(rowcinv12sig01.getDtDtCPSInvstDtlBegun()));
    //STGAP00009063 - removed Castor date cast b/c intake date element is now dateTime type
    cpsInvstDetail.setDtCpsInvstDtlIntake(rowcinv12sig01.getDtDtCPSInvstDtlIntake());
    cpsInvstDetail.setDtCpsInvstDtlComplt(DateHelper.toJavaDate(rowcinv12sig01.getDtDtCpsInvstDtlComplt()));

    int idEvent = rowcinv12sig01.getUlIdEvent();
    Event event = (Event) getPersistentObject(Event.class, idEvent);
    cpsInvstDetail.setEvent(event);

    Stage stage = (Stage) getPersistentObject(Stage.class, rowcinv12sig01.getUlIdStage());
    cpsInvstDetail.setStage(stage);

    cpsInvstDetail.setIndCpsInvstSafetyPln(rowcinv12sig01.getBIndCpsInvstSafetyPln());
    cpsInvstDetail.setIndCpsInvstDtlRaNa(rowcinv12sig01.getCIndCpsInvstDtlRaNa());
    // Logic to determine whether or not the family is eligible for Emergency Assistance
    String indCpsInvstEaConcl = ArchitectureConstants.Y;
    // All EA Eligibility questions must be answered 'Yes' for
    // the family to be eligible for Emergency Assistance.
    for (Enumeration rowcinv12sigooEnum = rowcinv12sig00_array.enumerateROWCINV12SIG00();
         rowcinv12sigooEnum.hasMoreElements();) {
      ROWCINV12SIG00 rowcinv12sigoo = (ROWCINV12SIG00) rowcinv12sigooEnum.nextElement();
      if (!ArchitectureConstants.Y.equals(rowcinv12sigoo.getBIndEaResponse())) {
        indCpsInvstEaConcl = ArchitectureConstants.N;
        break;
      }
    }
    // The Annual Family Income must be less than $63,000 (I5)
    // for the family to be eligible for Emergency Assistance.
    if (CodesTables.CEAFINCM_I5.equals(rowcinv12sig01.getSzCdCpsInvstDtlFamIncm())) {
      indCpsInvstEaConcl = ArchitectureConstants.N;
    }
    cpsInvstDetail.setIndCpsInvstDtlEaConcl(indCpsInvstEaConcl);
    cpsInvstDetail.setIndCpsInvstDtlAbbrv(rowcinv12sig01.getCIndCpsInvstAbbrv());
    cpsInvstDetail.setDtLastUpdate(rowcinv12sig01.getTsLastUpdate());
    cpsInvstDetail.setIdEvent(idEvent);
    // Calling cinv12
    cpsInvstDetailDAO.saveCpsInvstDetail(cpsInvstDetail);
  }
}
