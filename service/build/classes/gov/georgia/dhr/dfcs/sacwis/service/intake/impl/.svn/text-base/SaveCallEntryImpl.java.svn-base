package gov.georgia.dhr.dfcs.sacwis.service.intake.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContactEventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexIncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpJobHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.IncomingDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonPhoneDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RecordsCheckDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SituationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TempStagePersLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.IncomingDetail;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Situation;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StagePersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.TempStagePersLink;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CloseStageCase;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.intake.SaveCallEntry;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN02UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntryAUDInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallEntrySvcStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.UnitStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINTS025G01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallEntryAUDOutRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CreateCallOutStruct;

import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  11/11/2009 arege   SMS#37327 Save and Close of Intakes opened in Error without first SaveAndSubmit should close the stage
 *  11/11/2009 arege   SMS#37327 Modified as per code review.
 *  04/20/2010 arege   SMS#46744 Modified code to save idcase in event and eventPersonlink tables for events created before the intake
 *                     is Submitted.
 *  05/07/2010 hnguyen SMS#37187 Updated service to save intake on user workload upon click of Red Phone icon, to fix issue with 
 *                     orphan open intakes when user navigate away after clicking Red Phone icon.
 *  08/11/2010 wjcochran SMS#50402: Changed variable cdCaseCounty in saveAndSubmitAndAssign method to retrieve the value
 *                       from the call entry data and not the database to ensure that any changes are caught. 
 *  
 *  
 **/
 
public class SaveCallEntryImpl extends BaseServiceImpl implements SaveCallEntry {

  private static final String CAPS_WIN_MODE_APPRV = "A";

  private static final String INCMG_STATUS_CD_OPEN = CodesTables.CINCMGST_OPN;

  private static final String INCMG_STATUS_CD_SUBMITTED = CodesTables.CINCMGST_SBA;

  private static final String INCMG_STATUS_CD_CLOSED = CodesTables.CINCMGST_CLD;

  private static final String INCMG_STATUS_CD_MARK_DELETE = CodesTables.CINCMGST_MFD;

  private static final String EVENT_STATUS_PENDING = CodesTables.CEVTSTAT_PEND;

  private static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;

  private static final String EVENT_STATUS_COMPLETE = CodesTables.CEVTSTAT_COMP;

  private static final String EVENT_TYPE_NEW_USING = CodesTables.CEVNTTYP_STG;

  private static final String EVENT_TYPE_PRIORITY_CHANGE = CodesTables.CEVNTTYP_PRT;

  private static final String EVENT_TYPE_CALL = CodesTables.CEVNTTYP_CAL;

  private static final String EVENT_NEW_USING_IND = "N";

  private static final String EVENT_CHANGE_PRIORITY_IND = "P";

  // note that trailing "%lu." was removed; Java string concatenation will be used instead
  public static final String RECORD_CALL_EVENT_DESC = "Record Intake ";

  public static final String NEW_USING_EVENT_DESC = "New using of call ";

  private static final String PRIORITY_EVENT_DESCR_ARROW = "->";

  private static final String APS_CRSR = CodesTables.CACTSTAT_C;

  private static final String CAPS_PROG_APS = CodesTables.CSRPGTYP_APS;

  private static final String PERSON_TYPE_PRN = CodesTables.CPRSNTYP_PRN;

  private static final String PERSON_TYPE_WORKER = CodesTables.CPRSNALL_STF;

  private static final String PERSON_ROLE_CLIENT = CodesTables.CROLEALL_CL;

  private static final String PRIMARY_ROLE_STAGE_OPEN = CodesTables.CROLEALL_PR;

  private static final String STAGE_CD_INTAKE = CodesTables.CSTAGES_INT;

  private static final int CD_STAGE_RSN_PRIORITY_CHGD_LEN = 20;

  private static final int TXT_STAGE_PRIORITY_CMNTS_LEN = 81;

  private static final int CD_STAGE_CURR_PRIORITY_LEN = 3;

  private static final String RECORD_CALL_CD_TASK = "1000";

  private static final String BUSINESS_PHONE_TYPE = CodesTables.CPHNTYP_BS;

  private static final String EMP_IS_OLD = "0";

  private CapsCaseDAO capsCaseDAO = null;

  private ComplexContactEventDAO complexContactEventDAO = null;

  private ComplexIncomingDetailDAO complexIncomingDetailDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private EmpJobHistoryDAO empJobHistoryDAO = null;

  private EmployeeDAO employeeDAO = null;

  private EventDAO eventDAO = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;

  private InvalidateApproval invalidateApproval = null;

  private IncomingDetailDAO incomingDetailDAO = null;

  private PersonPhoneDAO personPhoneDAO = null;

  private PostEvent postEvent = null;

  private StageDAO stageDAO = null;

  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private SituationDAO situationDAO = null;

  private TempStagePersLinkDAO tempStagePersLinkDAO = null;

  private UnitDAO unitDAO = null;
  
  private RecordsCheckDAO recordsCheckDAO = null;
  
  private CloseStageCase closeStageCase = null;

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }

  public void setComplexContactEventDAO(ComplexContactEventDAO complexContactEventDAO) {
    this.complexContactEventDAO = complexContactEventDAO;
  }

  public void setComplexIncomingDetailDAO(ComplexIncomingDetailDAO complexIncomingDetailDAO) {
    this.complexIncomingDetailDAO = complexIncomingDetailDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setEmpJobHistoryDAO(EmpJobHistoryDAO empJobHistoryDAO) {
    this.empJobHistoryDAO = empJobHistoryDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  

  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }

  public void setIncomingDetailDAO(IncomingDetailDAO incomingDetailDAO) {
    this.incomingDetailDAO = incomingDetailDAO;
  }

  public void setPersonPhoneDAO(PersonPhoneDAO personPhoneDAO) {
    this.personPhoneDAO = personPhoneDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setStagePersonLinkDAO(StagePersonLinkDAO stagePersonLinkDAO) {
    this.stagePersonLinkDAO = stagePersonLinkDAO;
  }

  public void setSituationDAO(SituationDAO situationDAO) {
    this.situationDAO = situationDAO;
  }

  public void setTempStagePersLinkDAO(TempStagePersLinkDAO tempStagePersLinkDAO) {
    this.tempStagePersLinkDAO = tempStagePersLinkDAO;
  }

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }
  
  public void setRecordsCheckDAO(RecordsCheckDAO recordsCheckDAO) {
    this.recordsCheckDAO = recordsCheckDAO;
  } 
  
  public void setCloseStageCase(CloseStageCase closeStageCase) {
    this.closeStageCase = closeStageCase;
  }

  /**
   * This is cint12s
   * 
   * @param cint12si
   *          {@link CallEntryAUDInRec}
   * @return A populated {@link CallEntryAUDOutRec} object.
   * @throws ServiceException
   */
  public CallEntryAUDOutRec saveCallEntry(CallEntryAUDInRec cint12si) throws ServiceException {

    CallEntryAUDOutRec cint12so = new CallEntryAUDOutRec();
    CreateCallOutStruct callOut = new CreateCallOutStruct();
    cint12so.setCreateCallOutStruct(callOut);
    CINTS025G01 cintso25g01 = new CINTS025G01();
    cint12so.setCINTS025G01(cintso25g01);
    String cdEventStatus = cint12si.getSzCdEventStatus();
    UnitStruct unitStruct = cint12si.getUnitStruct();

    int idEmployeeModifiedBy = cint12si.getUlIdEmployee();

    ArchInputStruct archStruct = cint12si.getArchInputStruct();
    CallEntrySvcStruct entryStruct = cint12si.getCallEntrySvcStruct();
    int idStage = entryStruct.getUlIdStage();
    String cSysIndEventToCreate = cint12si.getCSysIndEventToCreate();
    int idCase = entryStruct.getUlIdCase();
     
    // the date the case was opened is needed in a few methods, so compute it here once
    Date dtCaseOpened = DateHelper.toJavaDateSafe(entryStruct.getDtDtIncomingCall(), entryStruct.getTmTmIncmgCall());

    // The invalidation function will be called only if:
    // 1) the window mode is NOT approval 'A'
    // 2) the intake status is open 'OPN'
    // 3) the event is pending 'PEND'
    if (!CAPS_WIN_MODE_APPRV.equals(entryStruct.getSzSysCdWinMode())
        && INCMG_STATUS_CD_OPEN.equals(entryStruct.getCdIncmgStatus())
        && EVENT_STATUS_PENDING.equals(cint12si.getSzCdEventStatus())) {

      invalidateApproval(archStruct, entryStruct.getUlIdEvent(), cdEventStatus, entryStruct, callOut);
    }

    String cReqFuncCd = archStruct.getCReqFuncCd();

    

    if (CAPS_PROG_APS.equals(entryStruct.getSzCdStageProgram())
        && APS_CRSR.equals(entryStruct.getSzCdSpclReq().substring(0, 1))
        && (ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT.equals(cReqFuncCd) || ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN
                                                                                                                           .equals(cReqFuncCd))) {

      // CallCINT79D
      long count = stagePersonLinkDAO
                                     .countStagePersonLinkByIdStageCdStagePersTypeAndCdStagePersRole(idStage,
                                                                                                     PERSON_TYPE_PRN,
                                                                                                     PERSON_ROLE_CLIENT);
      if (count != 1) {
        throw new ServiceException(Messages.MSG_INT_ROLE_CLIENT);
      }
    }

    // A check was originally used to determine if data changed
    // on the Call Entry window or not to dictate whether this dam
    // was called or not. However, the dao would always be called
    // for SaveAndAssign to set the closed date. It would also be
    // called from Save, whether data had changed or not, if the
    // Record Call dialog was called from Approval dialog and the
    // user cancelled out. The it would also have to be called
    // to change the status of the call to submitted if called
    // for SaveAndSubmit. Therefore, it made sense to simply the
    // code and always update the record. This is a possible point
    // to tune this service should the need arise.

    if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {

      updateIncomingDetail(entryStruct, unitStruct, cReqFuncCd, callOut, cintso25g01);
      updateTemporaryWorkload(cReqFuncCd, callOut.getUlIdStage(), callOut.getUlIdStage(), idEmployeeModifiedBy);
    }

    // Once the Incoming Detail information is updated successfully
    // update the call's status on the workers workload. This
    // functionality is the opposite of ModifyWorkLoad, in that
    // the call is removed from the worker's workload.

    if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_CLOSE.equals(cReqFuncCd)
        || ServiceConstants.REQ_FUNC_CD_MARK_FOR_DELETE.equals(cReqFuncCd)) {
         
      removeFromWorkload(entryStruct, cReqFuncCd, callOut.getUlIdStage());

    }

    // Place the intake on the worker's workload if the intake
    // is being saved.

    if (ServiceConstants.REQ_FUNC_CD_SAVE.equals(cReqFuncCd)) {

      modifyWorkLoad(entryStruct, cReqFuncCd, dtCaseOpened, cSysIndEventToCreate, callOut, cdEventStatus,
                     idEmployeeModifiedBy, cint12si.getSzCdStageCurrPriority());

      int idEvent = entryStruct.getUlIdEvent();
      if (idEvent != 0) {

        callPostEvent(cdEventStatus, cReqFuncCd, entryStruct, callOut, idEvent, null, null, null, null, null);
      }
    }

    // Call function to update case, situation, stage, incoming detail,
    // stage person link, and event for assign and submit.

    if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT.equals(cReqFuncCd)
        || ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN.equals(cReqFuncCd)) {

      saveAndSubmitAndAssign(entryStruct, callOut, dtCaseOpened, cReqFuncCd, cdEventStatus, cSysIndEventToCreate,
                             idEmployeeModifiedBy, cint12si.getSzCdStageCurrPriority());

      // SMS#46744 Find if there are any CONTACT (CON) events created before the Intake was Saved and Submitted, update
      // such records with the idCase that is generated after the Save and Submit of the Intake
      eventPersonLinkDAO.updateEventPersonLinkWithIdCase(entryStruct.getUlIdCase(), idStage, CodesTables.CEVNTTYP_CON);
      eventDAO.updateEventByIdStageAndCdEventType(entryStruct.getUlIdCase(), idStage, CodesTables.CEVNTTYP_CON);
    }

   
   
    // Call function for cascading deletes if the requested function is delete.

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // CallCINT74D
      incomingDetailDAO.deleteIncomingDetail(idStage);
    }
    
    // STGAP00008896 : In case of Intake Opened in Error that is already Saved and Submitted.
    // This will be done only if we have a case.
    if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_CLOSE.equals(cReqFuncCd)
        && (CodesTables.CNIRTYPE_OE.equals(entryStruct.getSzCdNonRsdntReqType()) || CodesTables.CNIRTYPE_IR
                                                                                                           .equals(entryStruct
                                                                                                                              .getSzCdNonRsdntReqType()))) {
      if (idCase != 0) {
        if (idStage != 0) {
          Stage stage = getPersistentObject(Stage.class, idStage);
          int idPerson = entryStruct.getUlIdPerson();
          CCMN02UI ccmn02ui = new CCMN02UI();
          CCMN02UIG00 ccmn02uigoo = new CCMN02UIG00();
          ccmn02ui.setCCMN02UIG00(ccmn02uigoo);
          ccmn02ui.getCCMN02UIG00().setUlIdStage(idStage);
          ccmn02ui.getCCMN02UIG00().setSzCdStage(stage.getCdStage());
          ccmn02ui.getCCMN02UIG00().setSzCdStageProgram(stage.getCdStageProgram());
          ccmn02ui.getCCMN02UIG00().setSzCdStageReasonClosed(stage.getCdStageReasonClosed());
          ccmn02ui.getCCMN02UIG00().setUlIdPerson(idPerson);
          // Call CloseStageCase
          closeStageCase.closeStageCase(ccmn02ui);
        }
      } else {
        // SMS#37327 Save and Close of Intakes opened in Error without first SaveAndSubmit should close the stage
        // and this will now allow person merge without giving the error of Person involved in open intake.
        // For IR intakes that are Save and Close , we do not have a row in Stage table hence check if it OE intake
        // SMS#37327 Modified as per code review.
        if (idStage != 0 && CodesTables.CNIRTYPE_OE.equals(entryStruct.getSzCdNonRsdntReqType())) {
          Stage stage = getPersistentObject(Stage.class, idStage);
          if(stage != null){
          Date sysdate = new Date();
          stage.setDtStageClose(sysdate);
          // stage.setCdStageReasonClosed(entryStruct.getSzCdNonRsdntReqType());
          }
        }
      }
    }

    return cint12so;
  }

  /**
   * This method calls a common function to invalidate the approval todo for an intake that has been modified.
   * 
   * @param archStruct
   * @param idEvent
   * @param cdEventStatus
   * @param entryStruct
   * @param callOut
   * @throws ServiceException
   */
  private void invalidateApproval(ArchInputStruct archStruct, int idEvent, String cdEventStatus,
                                  CallEntrySvcStruct entryStruct, CreateCallOutStruct callOut) throws ServiceException {
    // The code in ccmn05u.src was analyzed and it was determined
    // that no harm would befall this logic if it was allowed to
    // invalidate an approval that had already been rejected or
    // completed.

    // We need this functionality because the only way a user will
    // be able to modify a rejected intake will be to answer yes to
    // the prompt to modify a submitted call, and proceed as normal.
    // The service was coded to invalidate approvals if the incoming
    // status was SBA, which it will be, and reset that status
    // according to the actions of the user.

    CCMN05UI ccmn05ui = new CCMN05UI();
    ccmn05ui.setArchInputStruct(archStruct);
    ccmn05ui.setUlIdEvent(idEvent);
    invalidateApproval.invalidateApproval(ccmn05ui);

    // Set the event status for the call back to complete. This would
    // not be necessary, except that user may only save the intake back
    // to the workload of whoever created it. Otherwise an event
    // would be created.

    callPostEvent(cdEventStatus, archStruct.getCReqFuncCd(), entryStruct, callOut, idEvent, null, null, null, null,
                  null);
  }

  /**
   * This method inserts a row into the database with a date and time that it retrieves from an API call. If the
   * INCOMING ID is not null, the row is updated.
   * 
   * @param entryStruct
   * @param unitStruct
   * @param cReqFuncCd
   * @param callOut
   * @param cintso25g01
   * @throws ServiceException
   */
  private void updateIncomingDetail(CallEntrySvcStruct entryStruct, UnitStruct unitStruct, String cReqFuncCd,
                                    CreateCallOutStruct callOut, CINTS025G01 cintso25g01) throws ServiceException {
    // The idUnit value will be needed later to update the stage records successfully. The add here seemed to be the
    // best place to call this dam once for a new call (or as long as the client stays up).
    int idUnit = entryStruct.getUlIdUnit();
    Unit unit = null;
    if (idUnit == 0) {
      idUnit = retrieveIdUnitFromEmployee(entryStruct.getUlIdPerson());
      unit = unitDAO.findUnitByIdUnit(idUnit);
      callOut.setUlIdUnit(idUnit);
      entryStruct.setUlIdUnit(idUnit);
    }

    // We also need to find the user's phone, extension, etc for a new call, so that the information may be saved to
    // the incoming detail table. The method findUserInformation updates the output record.
    findUserInformation(entryStruct.getUlIdPerson(), cintso25g01);
    IncomingDetail incmgDtl;
    Date dtIncmgCall;
    String cReqFuncCd_IncomingDetail;
    String tmIncmgCall = null;
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      dtIncmgCall = new Date();
      tmIncmgCall = FormattingHelper.formatTime(dtIncmgCall);
      cReqFuncCd_IncomingDetail = ServiceConstants.REQ_FUNC_CD_ADD;
      incmgDtl = new IncomingDetail();
      entryStruct.setDtDtIncomingCall(DateHelper.toCastorDate(dtIncmgCall));
      entryStruct.setTmTmIncmgCall(tmIncmgCall);
    } else {
      // cint07dQUERYdam
      incmgDtl = incomingDetailDAO.findIncomingDetailByIdStage(entryStruct.getUlIdStage());
      if (incmgDtl == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // dtIncmgCall = incmgDtl.getDtIncomingCall();
      cReqFuncCd_IncomingDetail = ServiceConstants.REQ_FUNC_CD_UPDATE;
    }

    // Set the status of the call according to the the requested function cd. If the window mode is approval, then the
    // supervisor needs to have the ability to save the intake without the status being changed back to OPN.
    String cdIncmgStatus;
    if (!ServiceConstants.REQ_FUNC_CD_MARK_FOR_DELETE.equals(cReqFuncCd)
        && ((ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT.equals(cReqFuncCd)) || (CAPS_WIN_MODE_APPRV
                                                                                                     .equals(entryStruct
                                                                                                                        .getSzSysCdWinMode()) && !ServiceConstants.REQ_FUNC_CD_SAVE_AND_CLOSE
                                                                                                                                                                                             .equals(cReqFuncCd)))) {
      cdIncmgStatus = INCMG_STATUS_CD_SUBMITTED;
    } else if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN.equals(cReqFuncCd)
               || ServiceConstants.REQ_FUNC_CD_SAVE_AND_CLOSE.equals(cReqFuncCd)) {
      // Save And Assign and Save And Close will set the status to closed.
      cdIncmgStatus = INCMG_STATUS_CD_CLOSED;
    } else if (ServiceConstants.REQ_FUNC_CD_MARK_FOR_DELETE.equals(cReqFuncCd)) {
      // Set status so that intake will be deleted.
      cdIncmgStatus = INCMG_STATUS_CD_MARK_DELETE;
    } else {
      cdIncmgStatus = INCMG_STATUS_CD_OPEN;
    }

    // Retrieve a date closed for the intake if we are assigning, closing, or deleting. The delete is a moot point,
    // but will allow auditing of how long something has been marked for deletion.
    Date dtIncomingCallDisposed = null;
    if ( ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN.equals(cReqFuncCd)
        || ServiceConstants.REQ_FUNC_CD_MARK_FOR_DELETE.equals(cReqFuncCd)) {
      dtIncomingCallDisposed = DateHelper.toJavaDate(entryStruct.getDtIncomingCallDisposed());
    }
    
    //STGAP00008896 if SaveAndClose 
    if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_CLOSE.equals(cReqFuncCd)){
      Calendar cal = Calendar.getInstance();
      Date sysdate = cal.getTime();
      dtIncomingCallDisposed = sysdate;
         }    

    // cint02dAUDdam AUD of IncomingDetail table
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd_IncomingDetail)
        || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd_IncomingDetail)) {
      incmgDtl.setAddrIncmgStreetLn1(entryStruct.getSzAddrIncmgStreetLn1());
      incmgDtl.setAddrIncmgStreetLn2(entryStruct.getSzAddrIncmgStreetLn2());
      incmgDtl.setAddrIncmgWorkerCity(entryStruct.getSzAddrIncWkrCity());
      incmgDtl.setCdIncmgWorkerRegion(entryStruct.getSzCdIncmgWorkerRegion());
      incmgDtl.setCdIncomingWorkerCounty(entryStruct.getSzCdIncomingWorkerCounty());
      incmgDtl.setAddrIncmgZip(entryStruct.getSzAddrIncmgZip());
      incmgDtl.setCdIncmgAllegType(entryStruct.getSzCdIncmgAllegType());
      incmgDtl.setCdIncmgCallerAddrType(entryStruct.getSzCdIncmgAddrType());
      incmgDtl.setCdIncmgCallerInt(entryStruct.getSzCdIncmgCallerInt());
      incmgDtl.setCdIncmgCallerPhonType(entryStruct.getSzCdIncmgPhoneType());
      incmgDtl.setCdIncmgRegion(entryStruct.getSzCdIncmgRegion());
      incmgDtl.setCdIncmgSex(entryStruct.getSzCdIncmgSex());
      incmgDtl.setCdIncmgStatus(cdIncmgStatus);
      incmgDtl.setAddrIncomingCallerCity(entryStruct.getSzAddrIncomingCallerCity());
      incmgDtl.setCdIncomingCallerCounty(entryStruct.getSzCdIncomingCallerCounty());
      incmgDtl.setCdIncomingCallerState(entryStruct.getSzCdIncomingCallerState());
      incmgDtl.setCdIncomingCallerSuffix(entryStruct.getCdIncomingCallerSuffix());
      incmgDtl.setNbrIncomingCallerPhone(entryStruct.getSzNbrIncomingCallerPhone());
      incmgDtl.setNbrIncmgCallerPhonExt(entryStruct.getSzNbrIncmgCallerExt());
      incmgDtl.setCdIncomingCallType(entryStruct.getSzCdIncomingCallType());
      incmgDtl.setCdIncomingDisposition(entryStruct.getSzCdIncomingDisposition());
      incmgDtl.setCdIncomingProgramType(entryStruct.getCdIncomingProgramType());
      incmgDtl.setDtIncomingCall(DateHelper.toJavaDateSafe(entryStruct.getDtDtIncomingCall(),
                                                           entryStruct.getTmTmIncmgCall()));
      incmgDtl.setDtIncomingCallDisposed(dtIncomingCallDisposed);
      incmgDtl.setNbrIncmgWorkerExt(cintso25g01.getLNbrPhoneExtension());
      incmgDtl.setNbrIncmgWorkerPhone(cintso25g01.getLNbrPhone());
      incmgDtl.setNmIncmgJurisdiction(entryStruct.getSzNmJurisdiction());
      incmgDtl.setNmIncmgRegardingFirst(entryStruct.getSzNmIncmgRegardingFirst());
      incmgDtl.setNmIncmgRegardingLast(entryStruct.getSzNmIncmgRegardingLast());
      incmgDtl.setNmIncmgWorkerName(entryStruct.getSzNmIncWkrName());
      incmgDtl.setNmIncomingCallerFirst(entryStruct.getNmIncomingCallerFirst());
      incmgDtl.setNmIncomingCallerLast(entryStruct.getNmIncomingCallerLast());
      incmgDtl.setNmIncomingCallerMiddle(entryStruct.getNmIncomingCallerMiddle());
      incmgDtl.setIndCnfidntltyExplnd(entryStruct.getCIndCnfidntltyExplnd());
      if (!DateHelper.isNull(DateHelper.toJavaDate(entryStruct.getDtCnfidntltyExplntn()))) {
        incmgDtl.setDtCnfidntltyExplntn(DateHelper.toJavaDate(entryStruct.getDtCnfidntltyExplntn()));
      } else {
        incmgDtl.setDtCnfidntltyExplntn(null);
      }
      incmgDtl.setCdSpclInvstgtn(entryStruct.getSzCdSpclInvstgtn());
      incmgDtl.setCdNonRsdntReqType(entryStruct.getSzCdNonRsdntReqType());

      incmgDtl.setCdSpclCircumstances(entryStruct.getSzCdSpclCircumstances());

      Integer idSupv = 0;

      // Find Supv id
      List<Map> empJobHistoryList = empJobHistoryDAO.findEmpJobHistoryByIdPerson(entryStruct.getUlIdPerson());
      if (empJobHistoryList == null || empJobHistoryList.isEmpty()) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      // in IMPACT, there were multiple job history rows. In SHINES, there is only one.
      for (Iterator<Map> it = empJobHistoryList.iterator(); it.hasNext();) {
        Map empJobHistoryMap = it.next();
        idSupv = (empJobHistoryMap.get("personByIdJobPersSupv") != null ? (Integer) empJobHistoryMap
                                                                                                    .get("personByIdJobPersSupv")
                                                                       : 0);
      }
      //STGAP00005885 Intake Actions Page - Phone Ext Not Populating For Supervisor
      String cdSupName = null;
      String cdSupPhone = null;
      String cdSupExt = null;
      if (idSupv != 0) {
        Employee employeeSupv = employeeDAO.findEmployeeByIdPerson(idSupv);
        Person personSupv = employeeSupv.getPerson();
        cdSupName = personSupv.getNmPersonFull();
          //      find supervisor phone and extension
        Map mapPhone = personPhoneDAO.findPersonPhoneAndExtensionbyIdPersonAndTypes(BUSINESS_PHONE_TYPE, idSupv,
                ServiceConstants.FND_YES,
                ServiceConstants.FND_NO);
        if (mapPhone != null) {
          // update output record for Phone and ext.

        cdSupExt=(String) mapPhone.get("nbrPersonPhoneExtension");
        cdSupPhone = (String) mapPhone.get("nbrPersonPhone");
     }
        
      }
      incmgDtl.setNmIncmgSupName(cdSupName);
      incmgDtl.setNbrIncmgSupPhone(cdSupPhone);
      incmgDtl.setNbrIncmgSupExt(cdSupExt);

      if (idSupv != 0) {
        Employee employeeSup = getPersistentObject(Employee.class, idSupv);
        incmgDtl.setEmployeeByIdIncomingSup(employeeSup);
      }

      if (unit != null) {
        incmgDtl.setNbrIncmgUnit(unit.getNbrUnit());
      }

      int idPerson = entryStruct.getUlIdPerson();
      int idCase = entryStruct.getUlIdCase();
      int idResource = entryStruct.getUlIdResource();
      int idEvent = entryStruct.getUlIdEvent();
      Employee employee = getPersistentObject(Employee.class, idPerson);
      incmgDtl.setEmployee(employee);

      if (idCase != 0) {
        CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
        incmgDtl.setCapsCase(capsCase);
      }
      if (idResource != 0) {
        CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);
        incmgDtl.setCapsResource(capsResource);
      }
      if (idEvent != 0) {
        Event event = getPersistentObject(Event.class, idEvent);
        incmgDtl.setEvent(event);
      }

      complexIncomingDetailDAO.updateIncomingDetail(incmgDtl);
      entryStruct.setUlIdStage(incmgDtl.getIdStage());
      callOut.setUlIdStage(incmgDtl.getIdStage());
    }
    // Note that Delete case is not necessary as the main calling method will not call this method
    // when the input req func is REQ_FUNC_CD_DELETE
  }

  /**
   * This function calls the DAOs necessary to place an intake on a persons workload.
   * 
   * @param entryStruct
   * @param cReqFuncCd
   * @return cdStageClassification
   */
  private String modifyWorkLoad(CallEntrySvcStruct entryStruct, String cReqFuncCd, Date dtCaseOpened,
                                String cSysIndEventToCreate, CreateCallOutStruct callOut, String cdEventStatus,
                                int idEmployeeModifiedBy, String cdStageCurrPriority) {

    // An entry exists if the query is successful and the DAO must update STAGE_PERSON and EMPLOYEE
    int idStage = entryStruct.getUlIdStage();
    int idCase = entryStruct.getUlIdCase();
    int idSituation = entryStruct.getUlIdSituation();
    int idEvent = entryStruct.getUlIdEvent();

    String cdStagePersRole = PRIMARY_ROLE_STAGE_OPEN;
    String cdStagePersType = PERSON_TYPE_WORKER;
    // cint20dQUERYdam
    
    //-- first look for PR for stage
    StagePersonLink primaryWorker = stagePersonLinkDAO.findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(idStage,
                                                                                                             cdStagePersRole,
                                                                                                             cdStagePersType);
    
    //-- if PR not found, try HP for good measure
    if(primaryWorker == null) {
      primaryWorker = stagePersonLinkDAO.findStagePersonLinkByIdStageAndIdPersonAndTypeAndRole(idStage,
                                                                                               CodesTables.CROLEALL_HP,
                                                                                               cdStagePersType);
    }
    
    String stgPrsnLnkCReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    Date dtStagePersLink = new Date();
    if(primaryWorker != null) {
      stgPrsnLnkCReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
      dtStagePersLink = primaryWorker.getDtStagePersLink();
    }
    
    //String stgPrsnLnkCReqFuncCd = (primaryWorker == null) ? ServiceConstants.REQ_FUNC_CD_ADD
    //                                                  : ServiceConstants.REQ_FUNC_CD_UPDATE;

    // Check to see if a stage already exists for this ID STAGE.
    // It is possible that one does, if this intake has been
    // returned to the person's workload before.

    // cint21dQUERYdam
    Stage stage = stageDAO.findStageByIdStage(idStage);
    String stageCReqFuncCd;
    if (stage != null) {
      stageCReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;

      // Overwrite the region with the one in the input message. We cannot be sure if it was created correctly due to
      // the user driven nature of the partial saves and the fact that the Call decision partial save will not put
      // the region in.
      stage.setCdStageRegion(entryStruct.getSzCdStageRegion());
    } else {
      // conversion note: the following stage object is used to store stage update values
      stageCReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      stage = new Stage();
      // The date and time of the incoming call needs to be used instead of the system date.
      stage.setDtStageStart(dtCaseOpened);
    }

    // Set the date call is disposed of for a SaveAndAssign. Set it to null for all others.
    //if (!ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN.equals(cReqFuncCd)) {
      stage.setDtStageClose(null);
      stage.setIndStageClose(ServiceConstants.FND_NO);
      stage.setCdStageReasonClosed(entryStruct.getSzCdStageReasonClosed());
    //} else {
      // We do not close the stage for save and assign
    //  stage.setDtStageClose(null);
      // stage.setDtStageClose(null);
    //  stage.setIndStageClose(ServiceConstants.FND_NO);
      // If the intake is being Saved and Assigned, then the client will be sending across a closure code.
      // This code needs to be placed into the stage table.
    //  stage.setCdStageReasonClosed(entryStruct.getSzCdStageReasonClosed());
    //}

   
    // Retrieve Primary Caretaker
    Person primaryCaretaker = stagePersonLinkDAO.findStagePersonLinkPrimaryCaretaker(entryStruct.getUlIdStage());
    if (primaryCaretaker != null) {
      stage.setNmStage(primaryCaretaker.getNmPersonFull());
    }

    // Whether the stage exists or not, the Stage Id used to create the incoming detail should be used.
    stage.setIdStage(idStage);

    // The county is special in that complex logic will be required to find it.
    // This will dictate how the intake is assigned.
    stage.setCdStageCnty(entryStruct.getSzCdStageCnty());

    // This is the only data that can be changed for Stage
    // from Call Entry.

    stage.setCdStageType(entryStruct.getSzCdStageType());
    // stage.setCdStageProgram(entryStruct.getSzCdStageProgram());
    stage.setCdStageProgram(CodesTables.CPGRMS_CPS);
    String cdStage_entry = entryStruct.getSzCdStage();
    stage.setCdStage(cdStage_entry);

    if (idCase != 0) {
      //CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
      stage.setCapsCase(getPersistentObject(CapsCase.class, idCase));
    }
    
    if (idSituation != 0) {
      //Situation situation = getPersistentObject(Situation.class, idSituation);
      stage.setSituation(getPersistentObject(Situation.class, idSituation));
    }
    
    // Code changed here. An extra region code was added for one of the early SIRs performed on this code. Another
    // region code, szCdStageRegion, existed. The original code in this service was still referencing
    // szCdStageRegion, and was nulling the region on the Stage and Case tables.
    stage.setCdStageRegion(entryStruct.getSzCdStageRegion());

    // The unit is not saved in the partial save from Call Decision because
    // there is no guarantee the user will go there.
    //int idUnit = entryStruct.getUlIdUnit();
    //Unit unit = getPersistentObject(Unit.class, idUnit);
    //unit.setUnit(unit);
    stage.setUnit(getPersistentObject(Unit.class, entryStruct.getUlIdUnit()));

   
    stage.setCdStageClassification(entryStruct.getSzCdStageClassification());
    // cint12d - AUD of Stage
    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(stageCReqFuncCd)) {
      if (0 == complexStageDAO.insertStage(stage.getIdStage(), stage.getCdStageType(),
                                           stage.getCapsCase() == null ? null : stage.getCapsCase().getIdCase(),
                                           stage.getDtStageClose(), stage.getCdStageClassification(),
                                           stage.getCdStageCurrPriority(), stage.getCdStageInitialPriority(),
                                           stage.getCdStageRsnPriorityChgd(), stage.getCdStageReasonClosed(),
                                           stage.getIndStageClose(), stage.getTxtStagePriorityCmnts(),
                                           stage.getCdStageCnty(), stage.getNmStage(), stage.getCdStageRegion(),
                                           stage.getDtStageStart(),
                                           stage.getSituation() == null ? null : stage.getSituation().getIdSituation(),
                                           stage.getCdStageProgram(), stage.getCdStage(),
                                           stage.getTxtStageClosureCmnts(), stage.getUnit().getIdUnit(),
                                           stage.getCdStageScroutReason(), stage.getTxtStageSplInstrtCmnt())) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else {
      // update
      if (0 == complexStageDAO.updateStageAndIncomingDetail(stage)) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    // Create or edit the entry in STAGE_PERSON_LINK
    // ccmn80dAUDdam

    if (!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(stgPrsnLnkCReqFuncCd)) {
      StagePersonLink stgPrsnLnk = new StagePersonLink();
      
      // Do not change the date of creation for an update. There is no time associated with the creation of the
      // stage_person_link. The only concern is for the date. per Bart McCleskey, Common cell.
      stage = getPersistentObject(Stage.class, idStage);
      stgPrsnLnk.setStage(stage);
      
      if (idCase != 0) {
        //CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
        stgPrsnLnk.setCapsCase(getPersistentObject(CapsCase.class, idCase));
      }
      
      stgPrsnLnk.setDtStagePersLink(dtStagePersLink);
      
      if (entryStruct.getUlIdPerson() != 0) {
        Person person = getPersistentObject(Person.class, entryStruct.getUlIdPerson());
        stgPrsnLnk.setPerson(person);
      }
      
      stgPrsnLnk.setCdStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
      stgPrsnLnk.setCdStagePersType(PERSON_TYPE_WORKER);
      // stgPrsnLnk.setCdStagePersSearchInd(entryStruct.setSzCdS);
      
      //stgPrsnLnk.setStage(stage);
      stgPrsnLnk.setIndStagePersEmpNew(EMP_IS_OLD);
      
      stagePersonLinkDAO.saveStagePersonLink(stgPrsnLnk);
      updateTemporaryWorkload(ServiceConstants.REQ_FUNC_CD_DELETE, idStage, callOut.getUlIdStage(), entryStruct.getUlIdPerson());
    }
    if (0 == employeeDAO.updateDtEmpLastAssigned(entryStruct.getUlIdPerson(), dtStagePersLink,
                                                 idEmployeeModifiedBy)) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // Update the idCase in the stage person link table for this idStage
    // caudc1dAUDdam

    if (idCase != 0 && idStage != 0) {
      if (0 != stagePersonLinkDAO.updateStagePersonLinkIdCaseByIdStage(idCase, idStage)) {
        if (EVENT_CHANGE_PRIORITY_IND.equals(cSysIndEventToCreate)) {
          // CallPostEvent
          callPostEvent(cdEventStatus, cReqFuncCd, entryStruct, callOut, idEvent, EVENT_CHANGE_PRIORITY_IND,
                        cdStageCurrPriority, stage.getCdStageCurrPriority(), stage.getTxtStagePriorityCmnts(),
                        stage.getCdStageRsnPriorityChgd());
        }
      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

    }
    // Pass classification back out to main function so that sendToDoToSupervisor will be able to make decisions
    // based on classification.
    return stage != null ? stage.getCdStageClassification() : null;
  }

  /**
   * This function calls the DAOs necessary to place an intake on a person's workload.
   * 
   * @param entryStruct
   * @param callOut
   * @param dtCaseOpened
   * @param cReqFuncCd
   * @param cdEventStatus
   * @throws ServiceException
   */
  private void saveAndSubmitAndAssign(CallEntrySvcStruct entryStruct, CreateCallOutStruct callOut, Date dtCaseOpened,
                                      String cReqFuncCd, String cdEventStatus, String cSysIndEventToCreate,
                                      int idEmployeeModifiedBy, String cdStageCurrPriority) throws ServiceException {

    boolean bOKToCreateCaseAndSituation = true;
    int idStage = entryStruct.getUlIdStage();

    // get incoming detail
    // cint07dQUERYdam
    IncomingDetail incmgDtl = incomingDetailDAO.findIncomingDetailByIdStage(idStage);

    if (incmgDtl == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    // Check to see if a stage already exists for this ID STAGE. It is possible that one does, if this intake has been
    // returned to the person's workload before.
    // cint21dQUERYdam
    Stage stage = stageDAO.findStageByIdStage(idStage);

    // read Situation information
    // cint24dQUERYdam
    Situation situation;
    if (stage != null && stage.getSituation() != null && stage.getSituation().getIdSituation() != 0) {
      int idSituation = stage.getSituation().getIdSituation();
      situation = situationDAO.findSituation(idSituation);
      if (situation != null) {
        entryStruct.setUlIdSituation(idSituation);
      } else {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else {
      // If there is no existing Situation, a Situation will be added to the database.
      situation = new Situation();
    }

    // Retrieve from the CapsCase table if a case was referenced in the STAGE table.
    CapsCase capsCase = null;
    int idCase = 0;

    if (stage != null && stage.getCapsCase() != null && stage.getCapsCase().getIdCase() != 0) {
      idCase = stage.getCapsCase().getIdCase();
      // ccmnb1dQUERYdam
      capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
      if (capsCase == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }

    
    if (capsCase != null) {
      capsCase.setCdCaseSpecialHandling(incmgDtl.getCdIncmgSpecHandling());
      capsCase.setTxtCaseWorkerSafety(incmgDtl.getTxtIncmgWorkerSafety());
      capsCase.setTxtCaseSensitiveCmnts(incmgDtl.getTxtIncmgSensitive());
      capsCase.setIndCaseSensitive(incmgDtl.getIndIncmgSensitive());
      capsCase.setIndCaseSuspMeth(incmgDtl.getIndIncmgSuspMeth());
      capsCase.setIndCaseWorkerSafety(incmgDtl.getIndIncmgWorkerSafety());
      String cdCaseProgram = capsCase.getCdCaseProgram();
      // SMS #50402 - this ensures that updated county data is caught and saved
      String cdCaseCounty = entryStruct.getSzCdStageCnty();
      String cdCaseRegion = entryStruct.getSzCdStageRegion();
      String cdCaseSpecailHandling = incmgDtl.getCdIncmgSpecHandling();
      String indCaseWorkSafty = incmgDtl.getIndIncmgWorkerSafety();
      String txtCaseWorkerSafety = incmgDtl.getTxtIncmgWorkerSafety();
      String txtCaseSensitiveCmnts = incmgDtl.getTxtIncmgSensitive();
      String indCaseSensitive = incmgDtl.getIndIncmgSensitive();
      String indCaseArchived = capsCase.getIndCaseArchived();
      Date dtCaseClosed = capsCase.getDtCaseClosed();
      Date dtCaseOpen = dtCaseOpened;
      String nmCase = entryStruct.getSzNmStage();
      String indCaseSuspMeth = incmgDtl.getIndIncmgSuspMeth();
      String txtCaseSuspMeth = incmgDtl.getTxtIncmgSuspMeth();
      if (0 == capsCaseDAO.updateCapsCase(cdCaseProgram, cdCaseCounty, cdCaseRegion, cdCaseSpecailHandling,
                                          indCaseWorkSafty, txtCaseWorkerSafety, txtCaseSensitiveCmnts,
                                          indCaseSensitive, indCaseArchived, dtCaseClosed, dtCaseOpen, nmCase,
                                          indCaseSuspMeth, txtCaseSuspMeth, idCase)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }

    } else {

      // Generate time for case creation. This means
      // the call actually becomes an intake or a case
      // related special request.
      // The date and time of the incoming call needs to
      // be used instead of the system date.
      // capsCase.setDtCaseOpened(dtCaseOpened);
      // capsCase.setDtCaseClosed(DateHelper.NULL_JAVA_DATE);

      idCase = commonDAO.getNextval("SEQ_CAPS_CASE");
      String cdCaseProgram = entryStruct.getSzCdStageProgram();
      String cdCaseCounty = entryStruct.getSzCdStageCnty();
      String cdCaseRegion = entryStruct.getSzCdStageRegion();
      String cdCaseSpecailHandling = incmgDtl.getCdIncmgSpecHandling();
      String indCaseWorkSafty = incmgDtl.getIndIncmgWorkerSafety();
      String txtCaseWorkerSafety = incmgDtl.getTxtIncmgWorkerSafety();
      String txtCaseSensitiveCmnts = incmgDtl.getTxtIncmgSensitive();
      String indCaseSensitive = incmgDtl.getIndIncmgSensitive();
      String indCaseArchived = null;
      Date dtCaseClosed = null;
      Date dtCaseOpen = dtCaseOpened;
      String nmCase = stage.getNmStage(); // entryStruct.getSzNmStage();
      String indCaseSuspMeth = incmgDtl.getIndIncmgSuspMeth();
      String txtCaseSuspMeth = incmgDtl.getTxtIncmgSuspMeth();

      if (0 == capsCaseDAO.insertCapsCase(cdCaseProgram, cdCaseRegion, cdCaseCounty, cdCaseSpecailHandling,
                                          indCaseWorkSafty, txtCaseWorkerSafety, txtCaseSensitiveCmnts,
                                          indCaseSensitive, indCaseArchived, dtCaseClosed, dtCaseOpen, nmCase,
                                          indCaseSuspMeth, txtCaseSuspMeth, idCase)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }

    // Continue with normal creation/update of case and situation
    // if the call is an intake.
    if (bOKToCreateCaseAndSituation) {
      entryStruct.setUlIdCase(idCase);
      callOut.setUlIdCase(idCase);
      if (idCase != 0) {
        capsCase = getPersistentObject(CapsCase.class, idCase);

      }

      situation.setCapsCase(capsCase);

      // Create or modify the situation information
      // If the situation is known, then send it to the service.
      if (situation.getIdSituation() == null || situation.getIdSituation() == 0) { // ADD case
        situation.setDtSituationOpened(dtCaseOpened);
        situation.setDtSituationClosed(null);

      } else { // UPDATE
        // nothing to do since updating existing object
      }

      // add or update the Situation
      // cint13dAUDdam
      situationDAO.saveSituation(situation);

      int idSituation = situation.getIdSituation();
      entryStruct.setUlIdSituation(idSituation);
      callOut.setUlIdSituation(idSituation);
    } // end if (bOKToCreateCaseAndSituation)

    // Place the intake on the workload of the worker. This will
    // update STAGE, STAGE PERSON LINK, and other tables involved
    // with placing an intake on a workload.
    modifyWorkLoad(entryStruct, cReqFuncCd, dtCaseOpened, cSysIndEventToCreate, callOut, cdEventStatus,
                   idEmployeeModifiedBy, cdStageCurrPriority);

    
    if (bOKToCreateCaseAndSituation
        || (ServiceConstants.REQ_FUNC_CD_SAVE_AND_SUBMIT.equals(cReqFuncCd) && (!""
                                                                                   .equals(entryStruct
                                                                                                      .getSzCdNonRsdntReqType())))) {

      callPostEvent(cdEventStatus, cReqFuncCd, entryStruct, callOut,
                    incmgDtl.getEvent() == null ? 0 : incmgDtl.getEvent().getIdEvent(), null, null, null, null, null);
    }

    if (stage != null) {
      incmgDtl.setIdStage(stage.getIdStage());

    }

    // If save and assign, we need to set the incmg status to CLD (closed).
    if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN.equals(cReqFuncCd)) {
      incmgDtl.setCdIncmgStatus(INCMG_STATUS_CD_CLOSED);
    }

    // cint02dAUDdam
    int idPerson = entryStruct.getUlIdPerson();
    int idResource = entryStruct.getUlIdResource();
    int idEvent = callOut.getUlIdEvent();

    Employee employee = getPersistentObject(Employee.class, idPerson);
    incmgDtl.setEmployee(employee);

    incmgDtl.setCapsCase(capsCase);

    if (idResource != 0) {
      CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);
      incmgDtl.setCapsResource(capsResource);
    }
    if (idEvent != 0) {
      Event event = getPersistentObject(Event.class, idEvent);
      incmgDtl.setEvent(event);
    }

    complexIncomingDetailDAO.updateIncomingDetail(incmgDtl);
    entryStruct.setUlIdStage(incmgDtl.getIdStage());
  }

  /**
   * This will format the necessary fields to call the PostEvent common function. <p/> Note 1 - The parameters
   * ulIdExistingEvent and cEventToCreate are mutually exclusive. If a value for ulIdExistingEvent is passed in, then
   * cEventToCreate will be NULL, and vice versa. It is also possible for both parameters to be NULL. Note 2 - An event
   * will be created when the ulIdExistingEvent parameter is NULL. There are three different events that could be
   * created by this service - "Record Call", "New Using of stage xxx", "Priority Change of xxx-->yyy". If the
   * ulIdExistingEvent parameter is not NULL, then PostEvent will modify the currently existing "Record Call" event.
   * 
   * @param cdEventStatus
   * @param cReqFuncCd
   * @param entryStruct
   * @param callOut
   * @param idExistingEvent
   * @param cEventToCreate
   * @param szInitPriority
   * @param szCurrPriority
   * @param szComments
   * @param szRsnChanged
   * @throws ServiceException
   */
  private void callPostEvent(String cdEventStatus, String cReqFuncCd, CallEntrySvcStruct entryStruct,
                             CreateCallOutStruct callOut, int idExistingEvent, String cEventToCreate,
                             String szInitPriority, String szCurrPriority, String szComments, String szRsnChanged)
                                                                                                                  throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    ccmn01ui.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 row = new ROWCCMN01UIG00();
    ccmn01ui.setROWCCMN01UIG00(row);
    int idStage = entryStruct.getUlIdStage();
    int idPerson = entryStruct.getUlIdPerson();

    // Create an event for the new using of the stage id that
    // is passed into the service.
    if (EVENT_NEW_USING_IND.equals(cEventToCreate)) {

      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      row.setSzCdEventType(EVENT_TYPE_NEW_USING);
      // The event is associated with the new stage that
      // has been created. It will reside in the output message.
      row.setUlIdStage(callOut.getUlIdStage());
      row.setUlIdPerson(idPerson);
      row.setSzTxtEventDescr(NEW_USING_EVENT_DESC + idStage + ".");
      // row.szCdTask is null by default
      row.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
      Calendar cal = Calendar.getInstance();
      row.setDtDtEventOccurred(DateHelper.toCastorDate(cal.getTime()));

    } else if (EVENT_CHANGE_PRIORITY_IND.equals(cEventToCreate)) {

      // The last four input strings can be null, so must be tested before use
      String szPriorityEventDesc;
      if (szInitPriority != null) {
        szPriorityEventDesc = szInitPriority + PRIORITY_EVENT_DESCR_ARROW;
      } else {
        szPriorityEventDesc = PRIORITY_EVENT_DESCR_ARROW;
      }

      if (szCurrPriority != null) {
        szPriorityEventDesc += StringHelper.truncate(szCurrPriority, CD_STAGE_CURR_PRIORITY_LEN);
      }

      // This will be NULL if the stage is an APS Program type.

      if (szRsnChanged != null) {
        szPriorityEventDesc += " "
                               + StringHelper.truncate(Lookup.simpleDecodeSafe(CodesTables.CRSNPRIO, szRsnChanged),
                                                       CD_STAGE_RSN_PRIORITY_CHGD_LEN);
      }

      if (szComments != null) {
        int limit = TXT_STAGE_PRIORITY_CMNTS_LEN - szPriorityEventDesc.length() - 1;
        szPriorityEventDesc += StringHelper.truncate(szComments, limit);
      }

      row.setSzTxtEventDescr(szPriorityEventDesc);
      archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      row.setSzCdEventType(EVENT_TYPE_PRIORITY_CHANGE);
      row.setUlIdStage(idStage);
      row.setUlIdPerson(idPerson);
      row.setSzCdTask(RECORD_CALL_CD_TASK);
      row.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
      Calendar cal = Calendar.getInstance();
      row.setDtDtEventOccurred(DateHelper.toCastorDate(cal.getTime()));

    } else if (!StringHelper.isValid(cEventToCreate)) {

      // we're processing the Record Call event
      if (idExistingEvent != 0) {
        // a record call already exists
        archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
        row.setUlIdEvent(idExistingEvent);

        // call DAO (CCMN45D) to retrieve tsLastUpdate and DtEventOccurred
        Event event = eventDAO.findEventByIdEvent(idExistingEvent);
        if (event == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }

        row.setTsLastUpdate(event.getDtLastUpdate());
        row.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));

      } else {
        // we're creating a new Record Call event
        archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
        row.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
      }

      // populate common information for both ADD and UPDATE
      row.setSzCdEventType(EVENT_TYPE_CALL);
      row.setUlIdStage(idStage);
      row.setUlIdPerson(idPerson);
      row.setSzTxtEventDescr(RECORD_CALL_EVENT_DESC + idStage + ".");
      row.setSzCdTask(RECORD_CALL_CD_TASK);
      Calendar cal = Calendar.getInstance();
      row.setDtDtEventOccurred(DateHelper.toCastorDate(cal.getTime()));

      // Set status according to the requested function cd and * window mode. If assign, set the status to * approved,
      // unless we are called from the approval dialog; * then the status needs to be complete. All others should * be
      // complete as well. A save and assign that does not * come from the approval dialog means the user can * assign
      // directly to the field. * * The code to set the status has been revisited due * to a problem with duplicate
      // approval events being created. First, * we initialize the Event Status with the status of the event * prior to
      // this modification of the Intake. Then we check the * window mode. If the Intake Dialogue was called from the
      // Approval * Dialogue, then the status will be left unchanged. If the Intake * Dialogue is called from anywhere
      // else, the status will be set * to 'APRV' if the Intake is being Save&Assign'd. Otherwise, * the status will be
      // set to 'COMP'.

      row.setSzCdEventStatus(cdEventStatus);

      if (!CAPS_WIN_MODE_APPRV.equals(entryStruct.getSzSysCdWinMode())) {
        if (ServiceConstants.REQ_FUNC_CD_SAVE_AND_ASSIGN.equals(cReqFuncCd)) {
          row.setSzCdEventStatus(EVENT_STATUS_APPROVED);
        } else {
          row.setSzCdEventStatus(EVENT_STATUS_COMPLETE);
        }
      }
    } // end else if (!StringHelper.isValid(cEventToCreate))

    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);

    // if successful, copy the IdEvent returned from PostEvent into the 0utput message
    if (ccmn01uo != null) {
      callOut.setUlIdEvent(ccmn01uo.getUlIdEvent());
    }
  }

  /**
   * This function removes an intake from a person's workload. This implies deleting the STAGE_PERSON_LINK entry for
   * intakes and case related special requests. The STAGE entry needs to be deleted for I&R's and non case-related
   * special requests; they will exist if the call was previously saved to a users workload.
   * 
   * @param cReqFuncCd
   * @param idStageOut
   * @param entryStruct
   * @throws ServiceException
   */
  private void removeFromWorkload(CallEntrySvcStruct entryStruct, String cReqFuncCd, int idStageOut)
                                                                                                    throws ServiceException {

    // Delete at least 1 row from STAGE_PERSON_LINK for the primary
    // worker and any other rows for subsequent -secondary workers
    // when SavingNClosing or MarkingForDeletion an I&R Intake 11870
    // (ccmnd3dAUDdam)

    int idStage = entryStruct.getUlIdStage();
    int idCase = entryStruct.getUlIdCase();
    //STGAP00008251 When the 'IR' intake is submitted we already have a case which we are not deleting
    // so we do not want to delete the stagepersonlink record that has the Staff information
    // instead we need to update the StagePerson Role from 'PR' to 'HP'
    // and this will be done in the CloseStageCase Service. 
    
    if (!CAPS_WIN_MODE_APPRV.equals(entryStruct.getSzSysCdWinMode())) {
      if (idCase == 0) {
        stagePersonLinkDAO.deleteStagePersonLinkByIdStage(idStage, CodesTables.CROLEALL_SE);
        stagePersonLinkDAO.updateStagePersonLinkRole(idStage, CodesTables.CROLEALL_HP, CodesTables.CROLEALL_PR, CodesTables.CPRSNALL_STF);
      }
    }
 
    
    if (CodesTables.CNIRTYPE_IR.equals(entryStruct.getSzCdNonRsdntReqType())
        && !CAPS_WIN_MODE_APPRV.equals(entryStruct.getSzSysCdWinMode())) {
      if (idCase == 0) {

        // Delete from the event table by IdStage. These must be
        // deleted in order to maintain referential integrity.
        // (cint55dAUDdam)
        complexContactEventDAO.deleteContractEvent(true, idStage);

        // The following method updates the records from the Records_Check table
        // related to this stage. It sets the ID_STAGE column to NULL
        // to facilitate deletion of the records from the Stage Table.
        recordsCheckDAO.updateRecordsCheckIdStage(idStage);

        // delete the stage
        // cint12dAUDdam
        stageDAO.deleteStage(idStage);
      }

    } else {
      // The call must be a Case related special request or
      // a real intake or in approval mode. In this instance,
      // delete all Todos to the stage. This will indirectly
      // take care of the LE Notif Todo.

      // Only delete the Todos
      // (cint55dAUDdam)
      complexContactEventDAO.deleteContractEvent(false, idStage);
    }

    // Attempt to delete the call from the temporary workload.
    // This is necessary to account for the case when the user
    // opens a call and immediately SaveandCloses it.

    updateTemporaryWorkload(ServiceConstants.REQ_FUNC_CD_DELETE, idStage, idStageOut, entryStruct.getUlIdPerson());
  }

  /**
   * Finds the phone and extension and update output record
   * 
   * @param idPerson
   * @param cintso25g01
   * @return boolean if record found
   */
  private boolean findUserInformation(int idPerson, CINTS025G01 cintso25g01) {
    // cint47dQUERYdam
    Map mapPhone = personPhoneDAO.findPersonPhoneAndExtensionbyIdPersonAndTypes(BUSINESS_PHONE_TYPE, idPerson,
                                                                                ServiceConstants.FND_YES,
                                                                                ServiceConstants.FND_NO);
    if (mapPhone != null) {
      // update output record
      cintso25g01.setLNbrPhone((String) mapPhone.get("nbrPersonPhone"));
      cintso25g01.setLNbrPhoneExtension((String) mapPhone.get("nbrPersonPhoneExtension"));
      return true;
    } else {
      return false;

    }
  }

  /**
   * This function is called to place a call on the workers workload "temporarily" until the call is save, assigned,
   * submitted, or closed. At such a time, this temporary entry will be deleted. This functionality was created so that
   * a call would actually be on a worker's workload as soon as it was created. This would make the call accessible from
   * Assigned Workload if the Record Call dialog were to encounter some sort of error and had to shut down before a call
   * was saved by the user.
   * 
   * @param cReqFuncCd
   * @param idStageInput
   * @param idStageOutput
   * @param idPerson
   * @throws ServiceException
   */
  private void updateTemporaryWorkload(String cReqFuncCd, int idStageInput, int idStageOutput, int idPerson)
                                                                                                            throws ServiceException {

    // Place the call on the worker's workload "temporarily"
    // if the call is being created for the first time.
    // (cint57dAUDdam)
    TempStagePersLink tempStagePersLink = new TempStagePersLink();

    if (ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd)) {
      // If inserting into the table, use the stage id
      // that was just passed in. This is the id that is
      // being sent back to the client for display.
      tempStagePersLink.setIdTempStagePersLink(idStageOutput);
      Person person = getPersistentObject(Person.class, idPerson);
      tempStagePersLink.setPerson(person);
      tempStagePersLink.setCdTempStagePersRole(PRIMARY_ROLE_STAGE_OPEN);
      tempStagePersLink.setCdTempStagePersType(PERSON_TYPE_WORKER);
      tempStagePersLink.setCdTempStage(STAGE_CD_INTAKE);
      // If inserting into the table, use the stage id
      // that was just passed in. This is the id that is
      // being sent back to the client for display.
      tempStagePersLink.setIdTempStage(idStageOutput);

      tempStagePersLinkDAO.saveTempStagePersLink(tempStagePersLink);
    }
    // The only other time this function will be called is when
    // the stage record for the call is being created. This implies
    // that the call is being closed or is being placed on the
    // workers true workload. That being the case, this record can
    // be deleted.
    else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // Use the stage id which the client sends over for the
      // update of the intake.
      tempStagePersLink = tempStagePersLinkDAO
                                              .findTempStagePersLinkByIdStageAndCdTempStagePersRole(
                                                                                                    idStageInput,
                                                                                                    CodesTables.CROLEALL_PR);
      if (tempStagePersLink != null) {
        tempStagePersLinkDAO.deleteTempStagePersLink(tempStagePersLink);
      }
    }
  }
  
  /**
   * STGAP00015116 - Update this defect with revised solution.  
   * Update the intake information page to set the ID UNIT to be the current 
   * UNIT ID of the case manager recording the intake.  
   * This is consistent with other stages.
   * @param idPerson
   * @return
   */
  private Integer retrieveIdUnitFromEmployee(Integer idPerson) {
    
    Employee employee = employeeDAO.findEmployeeByIdPerson(idPerson);
    Unit unit = employee.getUnit();
    Integer idUnit = unit.getIdUnit();
    
    return idUnit;
  }
}
