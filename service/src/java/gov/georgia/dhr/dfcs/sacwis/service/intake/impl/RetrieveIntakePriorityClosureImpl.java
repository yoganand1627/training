package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.RetrieveIntakePriorityClosure;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT99SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT99SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.StageRow;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;

/**
 * This class is used to retrieve Stage, Incoming Detail and Event information for Intake Priority Closure page.
 *
 * @author John Ramspott April 29, 2008
 *         <p/>
 *         Date      User         Description --------  -----------  ----------------------------------------------
 *         04/29/08  jramspott     Re-write for use in Georgia SHINES  Created for STGAP00008086
 */

public class RetrieveIntakePriorityClosureImpl extends BaseServiceImpl implements RetrieveIntakePriorityClosure {

  private EventDAO eventDAO = null;
  private StageDAO stageDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public CINT99SO retrieveIntakePriorityClosure(CINT99SI cint99si) throws ServiceException {
    CINT99SO cint99so = new CINT99SO();
    int idStage = cint99si.getUlIdStage();

    // cint40d
    Stage stage = findStage(idStage);
    cint99so.setStageRow(findStageRow(stage));
    if (cint99so.getStageRow() != null) {
      
      // Now get the Incoming Detail record for this stage
      IncomingDetail incomingDetail = stage.getIncomingDetail();
      if (incomingDetail != null) {
        cint99so.setSzCdIncomingDisposition(incomingDetail.getCdIncomingDisposition());
        cint99so.setSzCdNonRsdntReqType(incomingDetail.getCdNonRsdntReqType());
      }
      
      cint99so.setDtSysDtGenericSysdate(DateHelper.getTodayCastorDate());
      // Get the event status for the CAL event, which is the initial CALL event.
      // The intake closure page is only editable for Intakes that have been approved.
      // Therefore, we are retrieving the status of this event so the conversation
      // can check if it is 'APRV' or not.
      String calEventStatus = getApprovalStatus(idStage);
      cint99so.setSzCdEventStatus(calEventStatus);
      
      // Checking to see if the INC (Intake Change event) is already there.
      // If so, retrieve the event id for the conversation.
      // This can happen if a case manager makes a change and submits it,
      // the supervisor rejects it, and case manager comes back to 
      // fix it.
      Event incEvent = getExisitingIncEvent(idStage);
      int incEventId = 0;
      if (incEvent != null) {
        incEventId=incEvent.getIdEvent();
      }
      cint99so.setUlIdEvent(incEventId);
      
    } else {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    return cint99so;
  }
  
  private Stage findStage(int idStage) {
    Stage stage = stageDAO.findStageByIdStage(idStage);
    return stage;
  }
  
  // Find an Existing INC event for this stage
  private Event getExisitingIncEvent(int idStage) {
    Event event = null;
    List<Event> events = eventDAO.findEventByIdStageAndCdEventType(idStage, CodesTables.CEVNTTYP_INC);
    if (events != null && events.isEmpty()==false) {
      event = events.get(0);
    }
    return event;
  }
  
  // Retrieve the status for the intake call event
  private String getApprovalStatus(int idStage) {
    String status = "";
    List<Event> events = eventDAO.findEventByIdStageAndCdEventType(idStage, CodesTables.CEVNTTYP_CAL);
    if (events != null && events.isEmpty()==false) {
      Event event = events.get(0);
      if (event != null) {
        status = event.getCdEventStatus();
      }
    }
    return status;
  }

  private StageRow findStageRow(Stage stage) {
    // cint40d
    StageRow srow = new StageRow();

    if (stage != null) {

      srow.setUlIdStage(stage.getIdStage() != null ? stage.getIdStage() : 0);
      srow.setUlIdSituation(stage.getSituation().getIdSituation() != null ? stage.getSituation().getIdSituation() : 0);
      srow.setUlIdCase(stage.getCapsCase().getIdCase() != null ? stage.getCapsCase().getIdCase() : 0);
      srow.setBIndStageClose(stage.getIndStageClose());
      srow.setUlIdUnit(stage.getUnit().getIdUnit() != null ? stage.getUnit().getIdUnit() : 0);
      srow.setSzCdStage(stage.getCdStage());
      srow.setSzCdStageClassification(stage.getCdStageClassification());
      srow.setSzCdStageCnty(stage.getCdStageCnty());
      srow.setSzCdStageProgram(stage.getCdStageProgram());
      srow.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());
      srow.setSzCdStageRegion(stage.getCdStageRegion());

      srow.setSzCdStageRsnPriorityChgd(stage.getCdStageRsnPriorityChgd());
      srow.setSzCdStageType(stage.getCdStageType());
      srow.setSzCdStageCurrPriority(stage.getCdStageCurrPriority());
      srow.setSzCdStageInitialPriority(stage.getCdStageInitialPriority());
      srow.setSzTxtStagePriorityCmnts(stage.getTxtStagePriorityCmnts());
      srow.setSzTxtStageClosureCmnts(stage.getTxtStageClosureCmnts());
      srow.setSzNmStage(stage.getNmStage());

      srow.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
      srow.setDtDtStageStart(DateHelper.toCastorDate(stage.getDtStageStart()));
      srow.setTsLastUpdate(stage.getDtLastUpdate());
      srow.setTmSysTmStageClose(FormattingHelper.formatTime(stage.getDtStageClose()));
      srow.setTmSysTmStageStart(FormattingHelper.formatTime(stage.getDtStageStart()));
      
      srow.setSzCdStageScroutReason(stage.getCdStageScroutReason());
      
    }

    return srow;
  }

}
