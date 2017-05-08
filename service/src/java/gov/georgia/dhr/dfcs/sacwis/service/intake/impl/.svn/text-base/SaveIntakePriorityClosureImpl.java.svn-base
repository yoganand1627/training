package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveIntakePriorityClosure;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINT21SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.StageRow;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN02UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINT21SO;

/**
 * This class is used to save Stage, Incoming Detail and Event information for Intake Priority Closure page.
 *
 * @author John Ramspott April 29, 2008
 *         <p/>
 *         Date      User         Description --------  -----------  ----------------------------------------------
 *         04/29/08  jramspott     Re-write for use in Georgia SHINES  Created for STGAP00008086
 *         07/15/08  arege         STGAP00009014 Changed method used to update stage table. 
 *                                 Used updateStageByIdStageAndDtLastUpdateAndResTimeCmnts() 
 *                                 
 */

public class SaveIntakePriorityClosureImpl extends BaseServiceImpl implements SaveIntakePriorityClosure {

  public static final String REQ_FUNC_CD_PRIORITY_CHANGE = "P";
  public static final String PRIORITY_UPDATE_EVENT_CODE = "PRT";
  public static final String DISPOSITION_UPDATE_EVENT_CODE = "IDC";
  public static final String EVENT_STATUS_COMP = "COMP";
  public static final String EVENT_STATUS_PEND = "PEND";
  
  public static final String SUB_INC_TASK="1090";
  

  private CheckStageEventStatus checkStageEventStatus = null;
  private PostEvent postEvent = null;
  private StageDAO stageDAO = null;
  private IncomingDetailDAO incomingDetailDAO = null;
  private CloseStageCase closeStageCase = null;
  private EventDAO eventDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public CINT21SO saveIntakePriorityClosure(CINT21SI cint21si) throws ServiceException {
    CINT21SO cint21so = new CINT21SO();
    StageRow stageRow = cint21si.getStageRow();
    int idStage = stageRow.getUlIdStage();
    String cdStage = stageRow.getSzCdStage();
    String cdStageReasonClosed = stageRow.getSzCdStageReasonClosed();
    String cdIncomingDisposition = cint21si.getSzCdIncomingDisposition();
    String cdStageCurrPriority = stageRow.getSzCdStageCurrPriority();

    // Check that all Child Death/Near Fatality/Serious Injury report event for stage is approved, if any
    if (existsUnapprovedCNSByIdStage(idStage)) {
      throw new ServiceException(Messages.MSG_INV_CDNFSI_APRV);
    }

    
    // Check Stage/Event common function
    if (idStage != 0) {
      CCMN06UI ccmn06ui = new CCMN06UI();
      ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
      ccmn06ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
      ccmn06ui.setUlIdStage(idStage);
      ccmn06ui.setSzCdTask(null);
      // CheckStageEventStatus
      checkStageEventStatus.status(ccmn06ui);
    }

    // Save this function code.
    String reqFuncCd = cint21si.getArchInputStruct().getCReqFuncCd();

    // Update STAGE table.
    // cint41d
    if (0 == stageDAO.updateStageByIdStageAndDtLastUpdateAndResTimeCmnts(stageRow.getSzCdStageType(),
                                                          stageRow.getSzCdStageCurrPriority(),
                                                          stageRow.getSzCdStageInitialPriority(),
                                                          stageRow.getSzCdStageRsnPriorityChgd(),
                                                          cdStageReasonClosed,
                                                          stageRow.getSzTxtStageResponseTimeCmnts(),
                                                          stageRow.getSzTxtStageClosureCmnts(),
                                                          stageRow.getTsLastUpdate(), 
                                                          stageRow.getSzCdStageScroutReason(),
                                                          idStage)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // Check to post a priority event - allowed for Mode B, which is updating a normal Intake
    try {
    if (ServiceConstants.REQ_FUNC_CD_SAVE.equals(reqFuncCd) && "Y".equals(cint21si.getBIndPriorityChanged())) {
      ROWCCMN01UIG00 rowccmn01uig00 = ROWCCMN01UIG00.unmarshal(new StringReader(cint21si.getROWCCMN01UIG00().toString()));
      CCMN01UI ccmn01ui = new CCMN01UI();
      ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
      rowccmn01uig00.setSzCdEventType(PRIORITY_UPDATE_EVENT_CODE);
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowccmn01uig00.setSzTxtEventDescr("Response Time Change to " + cdStageCurrPriority);
      ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
      postEvent.postEvent(ccmn01ui);
    }
    
    // Check to post a disposition change event - disposition can change in Mode B or Mode C (Close of non-incident intake)
    if ("Y".equals(cint21si.getBIndDispositionChanged())) {
      ROWCCMN01UIG00 rowccmn01uig00 = ROWCCMN01UIG00.unmarshal(new StringReader(cint21si.getROWCCMN01UIG00().toString()));
      CCMN01UI ccmn01ui = new CCMN01UI();
      ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
      rowccmn01uig00.setSzCdEventType(DISPOSITION_UPDATE_EVENT_CODE);
      rowccmn01uig00.setSzCdEventStatus(EVENT_STATUS_COMP);
      rowccmn01uig00.setSzTxtEventDescr("Disposition Change to" + cdIncomingDisposition);
      rowccmn01uig00.setSzCdTask(null); // Not association with a Task
      ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
      postEvent.postEvent(ccmn01ui);
    }
    }
    catch (Exception ve) {
      throw new ServiceException(Messages.MSG_CMN_NOT_SUBMITTED, ve);
    }
    
    // Post the event in the incoming structure - currently the INC event.
    // Only needed for save/submit. CloseStageCase creates the appropriate event itself.
    if (ServiceConstants.REQ_FUNC_CD_SAVE.equals(reqFuncCd)) {
      ROWCCMN01UIG00 rowccmn01uig00 = cint21si.getROWCCMN01UIG00();
      rowccmn01uig00.setSzCdTask(SUB_INC_TASK); // Only the INC event has CD_TASK associated with it of ones we generate.
      CCMN01UI ccmn01ui = new CCMN01UI();
      ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();
      // Check to see if INC event is already present. If it is, we want to update the existing event
      // rather than create a new one.
      int existingIncEvent = cint21si.getUlIdEvent();
      if (existingIncEvent > 0) {
        ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        rowccmn01uig00.setUlIdEvent(existingIncEvent);
      }
      else {
        ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      }
      ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);
      ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
      CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
      cint21so.setUlIdEvent(ccmn01uo.getUlIdEvent());
    }

    // Post closure event and call stage progression logic.
    if (ServiceConstants.REQ_FUNC_CD_SAVE.equals(reqFuncCd) ||
        ServiceConstants.REQ_FUNC_CD_CLOSE.equals(reqFuncCd)) {

      if (ServiceConstants.REQ_FUNC_CD_CLOSE.equals(reqFuncCd)) {
      CCMN02UI ccmn02ui = new CCMN02UI();
      ArchInputStruct ccmn02ui_archInputStruct = new ArchInputStruct();
      ccmn02ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      ccmn02ui.setArchInputStruct(ccmn02ui_archInputStruct);

      //CCMN02UIG00 ccmn02uig00 = ccmn02ui.getCCMN02UIG00();
      CCMN02UIG00 ccmn02uig00 = new CCMN02UIG00();
      ccmn02uig00.setUlIdStage(idStage);
      ccmn02uig00.setSzCdStageProgram(stageRow.getSzCdStageProgram());
      ccmn02uig00.setSzCdStage(cdStage);
      ccmn02uig00.setSzCdStageReasonClosed(cdStageReasonClosed);
      ccmn02uig00.setSzTxtEventDescr(cint21si.getSzTxtEventDescr());
      ccmn02uig00.setUlIdPerson(cint21si.getUlIdPerson());
      ccmn02uig00.setBIndSkipStageProg("Y");
      ccmn02ui.setCCMN02UIG00(ccmn02uig00);

      
        // ccmnb8d - Directly close non-incident intake
        CCMN02UO ccmn02uo = closeStageCase.closeStageCase(ccmn02ui);
        if (ccmn02uo == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        // Closestage is SUCCESS
        cint21so.setUlIdEvent(ccmn02uo.getUlIdEvent());
      }
      
      // If the stage is non-incident direct closure, set the incmg_status to CLD
      // For save and submitting of intake update, change the incoming disposition.
      if (ServiceConstants.REQ_FUNC_CD_SAVE.equals(reqFuncCd)) {
        // cint77d
        incomingDetailDAO.updateIncomingDetailDisposition(cdIncomingDisposition, idStage, stageRow.getTsIncmgDtlLastUpdate());
      }
      else if (ServiceConstants.REQ_FUNC_CD_CLOSE.equals(reqFuncCd)) {
        incomingDetailDAO.updateIncomingDetail(CodesTables.CINCMGST_CLD, idStage, stageRow.getTsIncmgDtlLastUpdate());
      }
    }
    return cint21so;
  }

  /**
   * 
   * This method will check if there are any Child Death/Near Fatality/Serious Injury reported events that are not
   * approved
   * 
   * @param idStage
   * @return boolean
   */
  private boolean existsUnapprovedCNSByIdStage(int idStage) {
    List<String> cdEventStatuses = new ArrayList<String>();
    cdEventStatuses.add(CodesTables.CEVTSTAT_PROC);
    cdEventStatuses.add(CodesTables.CEVTSTAT_COMP);
    cdEventStatuses.add(CodesTables.CEVTSTAT_PEND);

    long nbrRows = eventDAO.countEventRowsByIdStageAndCdEventTypeAndCdEventStatuses(idStage, CodesTables.CEVNTTYP_CNS,
                                                                                    cdEventStatuses);

    if (nbrRows <= 0) {
      // all CNS events are approved or none exists
      return false;
    }

    return true;
  }
}
