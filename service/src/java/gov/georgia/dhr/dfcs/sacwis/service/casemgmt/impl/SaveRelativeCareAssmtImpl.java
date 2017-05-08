package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsCaseDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RelativeCareAssmtPersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.db.RelativeCareAssmtPerson;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.Unit;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveRelativeCareAssmt;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentBean;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelativeCareAssessmentPersonInfo;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveRelativeCareAssmtImpl extends BaseServiceImpl implements SaveRelativeCareAssmt {

  private PostEvent postEvent = null;

  private RelativeCareAssmtDAO relativeCareAssmtDAO = null;

  private RelativeCareAssmtPersonDAO relativeCareAssmtPersonDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  public static final String EVENT_STATUS_PEND = "PEND";
  public static final String EVENT_STATUS_PROC = "PROC";

  private TodoDAO todoDAO;

  private WorkloadDAO workloadDAO = null;

  private CapsCaseDAO capsCaseDAO = null;
  
  private EventDAO eventDAO = null;
  
  private InvalidateApproval invalidateApproval = null;

  private UnitDAO unitDAO = null;

  public void setUnitDAO(UnitDAO unitDAO) {
    this.unitDAO = unitDAO;
  }

  public void setCapsCaseDAO(CapsCaseDAO capsCaseDAO) {
    this.capsCaseDAO = capsCaseDAO;
  }
  
  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setRelativeCareAssmtDAO(RelativeCareAssmtDAO rcaDAO) {
    this.relativeCareAssmtDAO = rcaDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }
  
  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
  
  public void setRelativeCareAssmtPersonDAO(RelativeCareAssmtPersonDAO rcaPersonDAO) {
    this.relativeCareAssmtPersonDAO = rcaPersonDAO;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public int saveRelativeCareAssmt(RelativeCareAssessmentBean saveSI) {

    CCMN01UO ccmn01uo = new CCMN01UO();
    int idEvent = saveSI.getIdEvent();
    String cdStage = saveSI.getCdStage();
    int idStage = saveSI.getIdStage();
    int idCase = saveSI.getIdCase();
    String eventReqFuncCd = "";
     // set add or update mode

    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
      createAlert(idStage,idCase, CodesTables.CROLEALL_PR, saveSI.getDtInitiated(),
                  "Review status of Relative Care Assessment for " + Lookup.simpleDecodeSafe(CodesTables.CTXTOGA,cdStage), 15, 0);
      createAlert(idStage,idCase, CodesTables.CROLEALL_PR, saveSI.getDtInitiated(), "Relative Care Assessment for "
                                                                                + Lookup.simpleDecodeSafe(CodesTables.CTXTOGA,cdStage) + " is now overdue", 30, 0);
      String assmtResults = saveSI.getCdAssessmentResults();
      String willingToAccept = saveSI.getCdWillingToAcceptChild();
      if (CodesTables.CASMTRES_APP.equals(assmtResults) && (!"".equals(willingToAccept))) {
        String choiceOfSup = saveSI.getCdInitialChoiceOfSupport();
        if (CodesTables.CINITSUP_ERR.equals(choiceOfSup) || CodesTables.CINITSUP_RCS.equals(choiceOfSup)
            || "ERCS".equals(choiceOfSup) || "SG".equals(choiceOfSup) || CodesTables.CINITSUP_ESG.equals(choiceOfSup)) {
          // create Alert
          
          CapsCase capsCase = capsCaseDAO.findCapsCaseByIdCase(idCase);
          String county = capsCase.getCdCaseCounty();
          Unit unit = unitDAO.findUnitByCdCountyAndCdUnitSpecialization(county, "RD");
          if (unit != null) {
            createAlert(idStage,idCase, null, new Date(), "A new relative caregiver has been approved " + Lookup.simpleDecodeSafe(CodesTables.CTXTOGA,cdStage)
                                                   + ".  Follow up required.", 0, unit.getPerson().getIdPerson());
          }
        }
      }
    }

    // make sure stage is not closed
    checkStageEventStatus(eventReqFuncCd, idStage, cdStage);
 
    ROWCCMN01UIG00 rcaEvent = new ROWCCMN01UIG00();
    ROWCCMN45DO rowEvent = saveSI.getRowccmn45do();
    rcaEvent.setSzCdEventStatus(rowEvent.getSzCdEventStatus());
    rcaEvent.setSzCdEventType(rowEvent.getSzCdEventType());
    rcaEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    rcaEvent.setUlIdStage(rowEvent.getUlIdStage());
    rcaEvent.setUlIdPerson(rowEvent.getUlIdPerson());
    rcaEvent.setSzTxtEventDescr(rowEvent.getSzTxtEventDescr());
    rcaEvent.setSzCdTask(rowEvent.getSzCdTask());
    rcaEvent.setUlIdEvent(rowEvent.getUlIdEvent());
    rcaEvent.setTsLastUpdate(rowEvent.getTsLastUpdate());
    
  //Per STGAP00010758 
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
    if (event != null && CodesTables.CEVTSTAT_PEND.equals(event.getCdEventStatus())) {
      // Calling the InvalidateApproval common function, CCMN05U, to set
      // all of an investigation's
      // events back to PROC and invalidate the conclusion approval todo.
      // Set the input object for the Invalidate function
      CCMN05UI ccmn05ui = new CCMN05UI();
      ArchInputStruct input = new ArchInputStruct();
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      input.setUlSysNbrReserved1(ArchitectureConstants.N);
      ccmn05ui.setUlIdEvent(idEvent);
      ccmn05ui.setArchInputStruct(input);
      ccmn05ui.setUlIdEvent(idEvent);
      invalidateApproval.invalidateApproval(ccmn05ui);
      
    }


   if (!ServiceConstants.REQ_FUNC_CD_DELETE.equals(saveSI.getCdReqFuncCd())) {
      ccmn01uo = callPostEvent(eventReqFuncCd, rcaEvent);

      // reset idEvent - this way if it's an Add, it gets set to something besides 0 here.
      idEvent = ccmn01uo.getUlIdEvent();
    }
    saveSI.setIdEvent(idEvent);
    RelativeCareAssmt rca = new RelativeCareAssmt();
     event = (Event) this.getPersistentObject(Event.class, saveSI.getIdEvent());
    rca.setEvent(event);
    rca.setIdRcaEvent(saveSI.getIdEvent());
    if (saveSI.getIdResource() != 0) {
      CapsResource resource = (CapsResource) this.getPersistentObject(CapsResource.class, saveSI.getIdResource());
      rca.setCapsResourceByIdResource(resource);
    }
    rca.setCdAssessorType(saveSI.getCdPersonPerformingAssessment());
    rca.setCdAssmtResults(saveSI.getCdAssessmentResults());
    rca.setCdAssmtType(saveSI.getCdAssessmentType());
    rca.setCdCaregiverType(saveSI.getCdCaregiverType());
    rca.setCdCounty(saveSI.getCdCounty());
    rca.setCdSupport(saveSI.getCdInitialChoiceOfSupport());
    rca.setCdState(saveSI.getCdState());
    rca.setDtActual(saveSI.getActualHomeVisitDate());
    rca.setDtAgreeSigned(saveSI.getDtPlacementAgreementSigned());
    rca.setDtComplete(saveSI.getDtAssessmentComplete());
    rca.setDtDecision(saveSI.getDtDecisionDate());
    rca.setDtDiscussion(saveSI.getDtDiscussionDate());
    rca.setDtDue(saveSI.getDueDate());
    rca.setDtLastUpdate(saveSI.getDtLastUpdate());
    rca.setDtRdRefrral(saveSI.getDtReferredToRD());
    rca.setDtReceived(saveSI.getDtAssessmentReceived());
    rca.setDtReferral(saveSI.getDtInitiated());
    rca.setDtSched(saveSI.getScheduleAssessmentDate());
    rca.setIndAccept(saveSI.getIndWillingToAcceptChild());
    rca.setIndDiscussion(saveSI.getIndSupportOptions());
    rca.setTxtComments(saveSI.getTxtComments());
    rca.setTxtNonRelatives(saveSI.getTxtNonRelatives());
    relativeCareAssmtDAO.saveOrUpdateRelativeCareAssmt(rca);
    List<RelativeCareAssessmentPersonInfo> list = saveSI.getPersonInfoList();
    if (list != null && list.size() > 0) {
      Iterator<RelativeCareAssessmentPersonInfo> iterator = list.iterator();
      while (iterator.hasNext()) {
        RelativeCareAssessmentPersonInfo pInfo = iterator.next();
        pInfo.setUlIdRcaEvent(idEvent);
        RelativeCareAssmtPerson rcaPerson = new RelativeCareAssmtPerson();
        rcaPerson.setCdPersonType(pInfo.getCdPersonType());
        rcaPerson.setDtLastUpdate(pInfo.getDtLastUpdate());
        Event eventRca = (Event) this.getPersistentObject(Event.class, pInfo.getUlIdRcaEvent());
        rcaPerson.setEventByIdRcaEvent(eventRca);
        rcaPerson.setIdRcaPerson(pInfo.getUlIdRcaPerson());
        Person person = (Person) this.getPersistentObject(Person.class, pInfo.getUlIdPerson());
        rcaPerson.setPersonByIdPerson(person);
        relativeCareAssmtPersonDAO.saveOrUpdateRelativeCareAssmtPerson(rcaPerson);
      }
    }

    return idEvent;
  }

  private void checkStageEventStatus(String reqFuncCd, int idStage, String cdStage) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdStage);
    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();
    ccmn06ui_archInputStruct.setCReqFuncCd(reqFuncCd);
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);
    // checkStageEventStatus will throw a ServiceException with Messages.MSG_SYS_EVENT_STS_MSMTCH
    // if the stage is closed or other issue is found
    checkStageEventStatus.status(ccmn06ui);
  }

 private CCMN01UO callPostEvent(String cReqFuncCd, ROWCCMN01UIG00 rowccmn01uig00) throws ServiceException {

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    
    return postEvent.postEvent(ccmn01ui);
 } 
  
 
  private void createAlert(int idStage, int idCase, String cdWkldStagePersRole, Date dtTodoDue, String desc, int dayToAdd,
                           int idPersonIn) {
    Todo todo = new Todo();
    int idPerson = idPersonIn;
    if (cdWkldStagePersRole != null) {
      idPerson = workloadDAO.findIdWkldPersonByIdStageAndCdWkldStagePersRole(idStage, cdWkldStagePersRole);
    }
    CapsCase capsCase;
    Date dateCreated = new Date();
    capsCase = getPersistentObject(CapsCase.class, idCase);
    Date todoDueDate = DateHelper.addToDate(dtTodoDue, 0, 0, dayToAdd);
    todo.setTxtTodoDesc(desc);
    todo.setCdTodoType(CodesTables.CTODOTYP_A);
    todo.setCapsCase(capsCase);
    todo.setStage(getPersistentObject(Stage.class, idStage));
    todo.setDtTodoDue(todoDueDate);
    todo.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idPerson));
    todo.setDtTodoCreated(dateCreated);
    todoDAO.saveTodo(todo);
  }
}
