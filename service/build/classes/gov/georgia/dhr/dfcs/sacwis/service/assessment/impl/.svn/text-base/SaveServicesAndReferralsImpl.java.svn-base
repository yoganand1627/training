package gov.georgia.dhr.dfcs.sacwis.service.assessment.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsChecklistDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.CpsChecklistItemDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklist;
import gov.georgia.dhr.dfcs.sacwis.db.CpsChecklistItem;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.SaveServicesAndReferrals;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV55SO;

public class SaveServicesAndReferralsImpl extends BaseServiceImpl implements SaveServicesAndReferrals {

  private static final String SERVICES_AND_REFERRALS_EVENT = "Services and Referrals Checklist";

  private static final String FALSE = "0";

  private CheckStageEventStatus checkStageEventStatus = null;

  private CpsChecklistDAO cpsChecklistDAO = null;

  private CpsChecklistItemDAO cpsChecklistItemDAO = null;

  private EventDAO eventDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  private TodoDAO todoDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setCpsChecklistDAO(CpsChecklistDAO cpsChecklistDAO) {
    this.cpsChecklistDAO = cpsChecklistDAO;
  }

  public void setCpsChecklistItemDAO(CpsChecklistItemDAO cpsChecklistItemDAO) {
    this.cpsChecklistItemDAO = cpsChecklistItemDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CINV55SO saveServicesAndReferralsInformation(CINV55SI cinv55si) throws ServiceException {
    CINV55SO cinv55so = new CINV55SO();
    ROWCINV55SIG01 rowcinv55sig01 = cinv55si.getROWCINV55SIG01();

    int idCase = rowcinv55sig01.getUlIdCase();
    int idStage = rowcinv55sig01.getUlIdStage();
    int idEvent = rowcinv55sig01.getUlIdEvent();
    ArchInputStruct archInputStruct = cinv55si.getArchInputStruct();
    String sysNbrReserved1 = cinv55si.getArchInputStruct().getUlSysNbrReserved1();
    String szCdScrDataAction = rowcinv55sig01.getSzCdScrDataAction();
    // Calling CheckStageEventStatus(), CCMN06U, common function
    // Preparing to call CheckStageEventStatus, populating input object
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(archInputStruct);
    ccmn06ui.getArchInputStruct().setCReqFuncCd(szCdScrDataAction);
    ccmn06ui.setUlIdStage(idStage);

    // Services and Referrals Checklist is available for all family stages
    // (FPR, FRE and FSU).
    // Three new task codes were added--one for each stage. The task code is
    // being passed into
    // this service from the calling conversation.
    ccmn06ui.setSzCdTask(rowcinv55sig01.getSzCdTask());
    checkStageEventStatus.status(ccmn06ui);
    Event event = null;
    if (0 != idEvent) {
      // Calling EventDAO CCMN45D. This retrieves an entire row from the
      // event table.
      // If an event exists, then we need some information (timestamp,
      // event status) from
      // the EVENT table for processing by the InvalidateAprvl() and
      // PostEvent() functions.
      event = eventDAO.findEventByIdEvent(idEvent);
    }

    // Don't demote events when in "Approver mode"
    if (event != null && CodesTables.CEVTSTAT_PEND.equals(event.getCdEventStatus()) && FALSE.equals(sysNbrReserved1)) {
      // Calling the InvalidateApproval common function, CCMN05U, to set
      // all of an investigation's
      // events back to PROC and invalidate the conclusion approval todo.
      // Set the input object for the Invalidate function
      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setArchInputStruct(archInputStruct);
      ccmn05ui.setUlIdEvent(idEvent);
      invalidateApproval.invalidateApproval(ccmn05ui);
    }

    // Calling PostEvent to insert or update the event table
    // 1) INSERT: it's a new checklist, therefore new event
    // 2) UPDATE: event exists, we modified it
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setArchInputStruct(archInputStruct);
    // Populate Common Function Input Structure
    // The SAR Event no longer shares the same function code flag as the
    // Checklist info,
    // so the following code has been commented out:
    ccmn01ui.getArchInputStruct().setCReqFuncCd(szCdScrDataAction);
    // Services and Referrals Checklist is now available for all family
    // stages (FPR, FRE and FSU).
    // Three new task codes were added--one for each stage. The task code is
    // being passed into
    // this service from the calling conversation.
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask(rowcinv55sig01.getSzCdTask());
    // Don't demote events when in "Approver mode"

    if (FALSE.equals(sysNbrReserved1)) {
      rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    } else {
      rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    }
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_CHK);
    // Getting System Date and Time
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rowccmn01uig00.setUlIdEvent(rowcinv55sig01.getUlIdEvent());
    rowccmn01uig00.setUlIdStage(rowcinv55sig01.getUlIdStage());
    rowccmn01uig00.setUlIdPerson(cinv55si.getUlIdPerson());
    rowccmn01uig00.setSzTxtEventDescr(SERVICES_AND_REFERRALS_EVENT);
    // copy timestamp retrieved from EventDAO (CCMN45D)
    if (event != null) {
      rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    }

    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

    // /////////////
    CpsChecklist cpsChecklist = new CpsChecklist();
    cpsChecklist.setIdCpsChecklist(rowcinv55sig01.getUlIdCpsChecklist());
    // /////////////

    // If previous DAO call was successful, then call next DAO. Calling DAO
    // if info on window is added or updated.
    if (ccmn01uo != null) {
      // Need to return the IdEvent for further processing.
      ROWCINV55SIG01 rowcinv55sig01temp = cinv55si.getROWCINV55SIG01();
      rowcinv55sig01temp.setUlIdEvent(ccmn01uo.getUlIdEvent());
      cinv55si.setROWCINV55SIG01(rowcinv55sig01temp);
      // Calling CAUDE3D to update the CPS_CHKLST table
      // Preparing to call DAO, instantiating/populating input object
      // CpsChecklist cpsChecklist = new CpsChecklist();
      int ulIdCpsChecklist = rowcinv55sig01.getUlIdCpsChecklist();
      Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
      CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
      Event eventTemp = (Event) getPersistentObject(Event.class, ccmn01uo.getUlIdEvent());
      stage.setIdStage(idStage);
      capsCase.setIdCase(idCase);
      eventTemp.setIdEvent(ccmn01uo.getUlIdEvent());
      cpsChecklist.setStage(stage);
      cpsChecklist.setCapsCase(capsCase);
      cpsChecklist.setEvent(eventTemp);
      cpsChecklist.setDtFirstReferral(DateHelper.toJavaDate(rowcinv55sig01.getDtDtFirstReferral()));
      cpsChecklist.setIndReferral(rowcinv55sig01.getCIndSvcRefChklstNoRef());
      cpsChecklist.setCdFamilyResp(rowcinv55sig01.getSzCdFamilyResponse());
      cpsChecklist.setTxtComments(rowcinv55sig01.getSzTxtChklstComments());
      cpsChecklist.setIdCpsChecklist(ulIdCpsChecklist);
      cpsChecklist.setDtLastUpdate(rowcinv55sig01.getTsLastUpdate());
      if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)
          || ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataAction)) {
        // caude3d
        cpsChecklistDAO.saveCpsChecklist(cpsChecklist);
        cinv55so.setUlIdCpsChecklist(cpsChecklist.getIdCpsChecklist());
      } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataAction)) {
        // Do nothing since there is no logic for DELETE in caude3d
      } else {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
    }
    // If the above DAO call (for 'save') does not throw any exception, next
    // DAO will be called
    // Preparing to call CpsChecklistItemDAO, CAUDE4D;Adds and deletes rows
    // to the CPS_CHKLST_ITEM table.
    // Instantiating/populating input object
    ROWCINV55SIG00_ARRAY rowcinv55sig00_array = cinv55si.getROWCINV55SIG00_ARRAY();

    if (rowcinv55sig00_array != null) {
      for (Enumeration rowcinv55sig00Enum = rowcinv55sig00_array.enumerateROWCINV55SIG00(); rowcinv55sig00Enum
              .hasMoreElements();) {
        ROWCINV55SIG00 rowcinv55sig00 = (ROWCINV55SIG00) rowcinv55sig00Enum.nextElement();
        String cdSvcReferred = rowcinv55sig00.getSzCdSvcReferred();

        Stage stage = (Stage) getPersistentObject(Stage.class, idStage);
        CapsCase capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
        Event eventTemp = (Event) getPersistentObject(Event.class, ccmn01uo.getUlIdEvent());
        capsCase.setIdCase(idCase);
        eventTemp.setIdEvent(ccmn01uo.getUlIdEvent());
        cpsChecklist.setStage(stage);
        CpsChecklistItem cpsChecklistItem = new CpsChecklistItem();
        cpsChecklistItem.setStage(stage);
        cpsChecklistItem.setCapsCase(capsCase);
        cpsChecklistItem.setEvent(eventTemp);
        cpsChecklistItem.setCpsChecklist(cpsChecklist);
        cpsChecklistItem.setIdCpsChecklistItem(cinv55so.getUlIdCpsChecklist());
        cpsChecklistItem.setCdSrvcReferred(cdSvcReferred);

        String szCdScrDataActionTemp = rowcinv55sig00.getSzCdScrDataAction();
        // Calling CpsChecklistItemDAO, CAUDE4D
        if (!ServiceConstants.REQ_FUNC_CD_NO_ACTION.equals(szCdScrDataActionTemp)) {
          if (ServiceConstants.REQ_FUNC_CD_ADD.equals(szCdScrDataActionTemp)) {
            cpsChecklistItemDAO.saveCpsChecklistItem(cpsChecklistItem);
          } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(szCdScrDataActionTemp)) {
            cpsChecklistItem.setIdCpsChecklistItem(rowcinv55sig00.getUlIdChklstItem());
            cpsChecklistItem.setDtLastUpdate(rowcinv55sig00.getTsLastUpdate());
            int nbrRowsDeleted = cpsChecklistItemDAO
                    .deleteCpsChecklistItemByCdSvcReferred(
                            rowcinv55sig00
                                    .getUlIdChklstItem(),
                            rowcinv55sig00
                                    .getTsLastUpdate(),
                            cdSvcReferred);
            if (nbrRowsDeleted == 0) {
              throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
            }
          } else if (ServiceConstants.REQ_FUNC_CD_UPDATE.equals(szCdScrDataAction)) {
            // Do nothing since there is no logic for UPDATE in
            // caude4d
          } else {
            throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
          }
        } // end !ServiceConstants.REQ_FUNC_CD_NO_ACTION
      } // end for loop
    } // end rowcinv55sig00_array != null

    // Note: The event object used below is retrieved through the call to
    // EventDAO earlier in this service

    if (0 != idEvent) {
      String cdEventStatus = "";
      if (event != null) {
        event.getCdEventStatus();
      }
      if ((CodesTables.CEVTSTAT_COMP.equals(cdEventStatus) || CodesTables.CEVTSTAT_NEW.equals(cdEventStatus))) {
        // Calling TodoDAO, CINV43D, to update status on the TODO table.
        todoDAO.updateTodoByIdEvent(idEvent);
      }
    }
    return cinv55so;
  }
}
