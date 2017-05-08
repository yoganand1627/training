package gov.georgia.dhr.dfcs.sacwis.service.reports.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthCauseCbxDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ChldDthNrFltySeriInjDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventPersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.OutputLaunchEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StagePersonLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.VisitationTypeDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.ChldDthCauseCbx;
import gov.georgia.dhr.dfcs.sacwis.db.ChldDthNrFltySeriInj;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.EventPersonLink;
import gov.georgia.dhr.dfcs.sacwis.db.OutputLaunchEventLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.db.VisitationType;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.reports.SaveOutputLaunch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CDNFSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB60SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VisitTypeCbxRecord_Array;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CDNFSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB60SO;
import java.util.Date;
import java.util.Iterator;
import java.util.List;


/**
 * 
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  03/13/09    arege     STGAP00012811 - Modified code so that the 
 *                        Primary child id is set in the rowccmn01uig01
 *                        and Case Worker id is set in the rowccmn01uig00 
 *                        field. This will further create the correct Event_Person_Link
 *                        in PostEventImpl service.   
 *  02/20/2010  arege     CAPTA changes: CD/NF/SI Report launch
 *  03/15/2010  arege     SMS#47654 CAPTA - CDNFSI Form - User Navigated to Person List Page when copying CNS events in INT, INV or ONG stages
 *                        Fixed event description for copied events.
 *  03/23/2010  arege     SMS#48528 Added code to allow users to delete CD/NF/SI events when in PROC or COMP status
 *  03/25/2010  arege     SMS#48851 Save should allow the user to stay on the page and launch the form.
 *  03/30/2010  arege     Fixed copying of COMP CNS events 
 *  05/24/2010  arege     SMS#54782 Added radio buttons to capture report type.
 *  06/14/2010  arege     SMS#54782: Update event description to reflect the report type selected on the page.
 *  10/05/2011  pnguyen   MR-094: Visitation Type
 * </pre>
 * 
 */

public class SaveOutputLaunchImpl extends BaseServiceImpl implements SaveOutputLaunch {

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;
  
  public static final String PERM_ROUNDTABLE_EVENT_TYPE =  CodesTables.CEVNTTYP_PER;
  
  public static final String SAFETY_ROUNDTABLE_EVENT_TYPE =  CodesTables.CEVNTTYP_SRT;
  
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  
  private ApproversDAO approversDAO = null;
  
  private ChldDthCauseCbxDAO chldDthCauseCbxDAO = null;
  
  private ChldDthNrFltySeriInjDAO chldDthNrFltySeriInjDAO = null;

  private ComplexStageDAO complexStageDAO = null;

  private CheckStageEventStatus checkStageEventStatus = null;

  private InvalidateApproval invalidateApproval = null;
  
  private EventPersonLinkDAO eventPersonLinkDAO = null;
  
  private PersonDAO personDAO = null;

  private PostEvent postEvent = null;
  
  private StageDAO stageDAO = null;
  
  private StagePersonLinkDAO stagePersonLinkDAO = null;

  private TodoDAO todoDAO = null;

  private OutputLaunchEventLinkDAO outputLaunchEventLinkDAO = null;  
  
  private VisitationTypeDAO visitationTypeDAO=null;
  
  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setChldDthCauseCbxDAO(ChldDthCauseCbxDAO chldDthCauseCbxDAO) {
    this.chldDthCauseCbxDAO = chldDthCauseCbxDAO;
  }
  
  public void setChldDthNrFltySeriInjDAO(ChldDthNrFltySeriInjDAO chldDthNrFltySeriInjDAO) {
    this.chldDthNrFltySeriInjDAO = chldDthNrFltySeriInjDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
  }
 
  
  public void setEventPersonLinkDAO(EventPersonLinkDAO eventPersonLinkDAO) {
    this.eventPersonLinkDAO = eventPersonLinkDAO;
  }

  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
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

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public void setOutputLaunchEventLinkDAO(OutputLaunchEventLinkDAO outputLaunchEventLinkDAO) {
    this.outputLaunchEventLinkDAO = outputLaunchEventLinkDAO;
  }

  public void setVisitationTypeDAO(VisitationTypeDAO visitationTypeDAO) {
    this.visitationTypeDAO = visitationTypeDAO;
  }

  public CSUB60SO saveOutputLaunch(CSUB60SI csub60si) throws ServiceException {

    CSUB60SO csub60so = new CSUB60SO();

    ROWCCMN01UIG00 rowccmn01uig00 = csub60si.getROWCCMN01UIG00();
    int idEvent = rowccmn01uig00.getUlIdEvent();
    int idStage = rowccmn01uig00.getUlIdStage();
    int oldIdEvent = 0;
    int idVictim = 0;
    String isCopied = ArchitectureConstants.FALSE;    
    Integer idPerson = rowccmn01uig00.getUlIdPerson();
    String cdTask = rowccmn01uig00.getSzCdTask();
    String cdEventType = rowccmn01uig00.getSzCdEventType();
    String eventStatus = csub60si.getSzCdEventStatus();
    String cdStage = csub60si.getSzCdStage();
    ROWCCMN01UIG01 rowccmn01uig01 = null;
    if (rowccmn01uig00.getROWCCMN01UIG01_ARRAY() != null) {
      rowccmn01uig01 = rowccmn01uig00.getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0);
    } else {
      rowccmn01uig01 = new ROWCCMN01UIG01();
    }

    String sysNbrReserved1 = csub60si.getArchInputStruct().getUlSysNbrReserved1();
    String reqFuncCd = csub60si.getArchInputStruct().getCReqFuncCd();
    
    //STGAP00011998: Primary child id should be set in rowccmn01uig01.setUlIdPerson so that 
    //the Primary child is saved in the Event_Person_Link, this will display correct persons
    // on the Child Life History check list page. 
    Integer idPrimaryChild;
    String cdStagePersType = CodesTables.CROLEALL_PC;
    idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,cdStagePersType);
    
    if (idPrimaryChild == null){
      idPrimaryChild = 0;
    }
    
    // checkStageEventStatus
    callCheckStageEventStatus(idEvent, idStage, cdTask);

    // Event Status New was added as part of the if statement
    // in order to make sure that the primary child information
    // is updated for a dummy event.
    if (((CodesTables.CEVTSTAT_NEW.equals(eventStatus)) || (0 == idEvent)) && (CodesTables.CSTAGES_SUB.equals(cdStage))) {

      // retrieve the ID PERSON for a given role, for a given stage. It's used
      // to find the primary worker for a given stage.
      // cinv51dQUERYdam
      // This complexDAOmethod returns idPerson of Primary or Secondary worker if the parameters are either PR or SE
      // else returns the cdStagePersRole passed, in this case it will return id of Primary Child (PC)
      idPerson = complexStageDAO.findPrimaryWorker(idStage, CodesTables.CROLEALL_PC);
 
      if (idPerson == null || 0 == idPerson) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      //The following line sets idPerson of the Primary Child in rowccmn01uig01
      rowccmn01uig01.setUlIdPerson(idPerson != null ? idPerson : 0);
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
      csub60si.setROWCCMN01UIG00(rowccmn01uig00);
    }
    
    if (ArchitectureConstants.N.equals(sysNbrReserved1)) {
      if (csub60si.getSzCdEventStatus().equals(CodesTables.CAPPDESG_PEND)) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ArchInputStruct ccmn05ui_archInputStruct = new ArchInputStruct();
        ccmn05ui_archInputStruct.setCReqFuncCd(reqFuncCd);
        ccmn05ui.setArchInputStruct(ccmn05ui_archInputStruct);
        ccmn05ui.getArchInputStruct().setUlSysNbrReserved1(ArchitectureConstants.N);
        ccmn05ui.setUlIdEvent(idEvent);
        invalidateApproval.invalidateApproval(ccmn05ui);

      }
    }

    // PostEvent
    rowccmn01uig00.setUlIdPerson(idPerson);
    rowccmn01uig01.setUlIdPerson(idPrimaryChild);
    //If the stage is FAD set idPerson (caseworker) to rowccmn01uig01 as we don't have PC in FAD stage.
    //This will ensure that the Person column is not blank (not sure if it can be blank )but 
    // displays name of worker on the Re-evaluation List page and MonthlyAssessment for Adoption list page
    if(CodesTables.CSTAGES_FAD.equals(cdStage)){
      rowccmn01uig01.setUlIdPerson(idPerson != null ? idPerson : 0);
    }
    
    if(ArchitectureConstants.TRUE.equals(csub60si.getCIndCopied()) && (PERM_ROUNDTABLE_EVENT_TYPE.equals(rowccmn01uig00.getSzCdEventType()) ||SAFETY_ROUNDTABLE_EVENT_TYPE.equals(rowccmn01uig00.getSzCdEventType())) ){
     Event event = getPersistentObject(Event.class, idEvent);    	
     String eventDescription = event.getTxtEventDescr();
     
    	
    	// STGAP00017539 event description should be changed to display marked as complete
    	// by looking if the previous description had updated appended to it at any time
    	eventDescription = eventDescription.replaceAll("has been created", "has been marked complete");
    	rowccmn01uig00.setSzTxtEventDescr(eventDescription);

    }
    
    
    
     
      csub60so.setUlIdEvent(callPostEvent(rowccmn01uig00, eventStatus, idVictim , StringHelper.EMPTY_STRING));

    // Set Calculated Retention date to maximum date
    if (0 != idEvent) {

      // cinv43d
      todoDAO.updateTodoByIdEvent(idEvent);

    }

    if (idEvent != 0) {

      OutputLaunchEventLink outputLaunchEventLink = outputLaunchEventLinkDAO.findOutputLaunchEventLink(idEvent);
      if (outputLaunchEventLink != null) {
        outputLaunchEventLink = getPersistentObject(OutputLaunchEventLink.class, idEvent);
      } else {
        outputLaunchEventLink = new OutputLaunchEventLink();
      }

      Event event = getPersistentObject(Event.class, idEvent);
      outputLaunchEventLink.setEvent(event);

      outputLaunchEventLink.setDtLastUpdate(csub60si.getTsSysTsLastUpdate2());
      outputLaunchEventLink.setIndCurrent(csub60si.getCIndCurrent());
      outputLaunchEventLinkDAO.saveOutputLaunchEventLink(outputLaunchEventLink);

    }
     
    // MR-094 Visitation Type
    // Need to delete prior to save so there will not be duplicates, should check for sequence(record id) running out of
    // numbers
    if ("VIS".equalsIgnoreCase(cdEventType)) {
      visitationTypeDAO.deleteVisitation(idEvent);
      if (csub60so.getUlIdEvent() != 0) {
        VisitTypeCbxRecord_Array vtArray = csub60si.getVisitTypeCbxRecord_Array();
        if (vtArray != null && vtArray.getVisitTypeCbxRecordCount() > 0) {
          for (VisitTypeCbxRecord cbx : vtArray.getVisitTypeCbxRecord()) {
            VisitationType vt = new VisitationType();
            Event event = getPersistentObject(Event.class, csub60so.getUlIdEvent());
            vt.setEvent(event);
            vt.setDtLastUpdate(rowccmn01uig00.getTsLastUpdate());
            vt.setCdVisitationType(cbx.getSzCdVisitTypeCbx());
            visitationTypeDAO.saveVisitationType(new VisitationType(cbx.getSzCdVisitTypeCbx(), event));
          }
        }
      }
    }
    return csub60so;
  }

  
 
  
  public CDNFSaveSO saveOutputLaunch(CDNFSaveSI cdnfSaveSI) throws ServiceException {
    CDNFSaveSO cdnfSaveSO = new CDNFSaveSO();
    CSUB60SI csub60si = cdnfSaveSI.getCsub60si();
    CSUB60SO csub60so = new CSUB60SO();

    ROWCCMN01UIG00 rowccmn01uig00 = csub60si.getROWCCMN01UIG00();
    int idEvent = rowccmn01uig00.getUlIdEvent();
    int idStage = rowccmn01uig00.getUlIdStage();
    String cdEventType = rowccmn01uig00.getSzCdEventType();

    int oldIdEvent = 0;
    Integer idPerson = rowccmn01uig00.getUlIdPerson();
    String cdTask = rowccmn01uig00.getSzCdTask();
    String eventStatus = csub60si.getSzCdEventStatus();
    String cdStage = csub60si.getSzCdStage();
    ROWCCMN01UIG01 rowccmn01uig01 = null;
    if (rowccmn01uig00.getROWCCMN01UIG01_ARRAY() != null) {
      rowccmn01uig01 = rowccmn01uig00.getROWCCMN01UIG01_ARRAY().getROWCCMN01UIG01(0);
    } else {
      rowccmn01uig01 = new ROWCCMN01UIG01();
    }

    String sysNbrReserved1 = csub60si.getArchInputStruct().getUlSysNbrReserved1();
    String reqFuncCd = csub60si.getArchInputStruct().getCReqFuncCd();

    ChldDthNrFltySeriInj chldDthNrFltySeriInj = new ChldDthNrFltySeriInj();
    if (idEvent != 0) {
      chldDthNrFltySeriInj = (ChldDthNrFltySeriInj) getPersistentObject(ChldDthNrFltySeriInj.class, idEvent);
      Event event = (Event) getPersistentObject(Event.class, idEvent);
      chldDthNrFltySeriInj.setEvent(event);
      rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    }

    if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cdnfSaveSI.getCdReqFuncCd())) {
      EventPersonLink epl = eventPersonLinkDAO
                                              .findEventPersonLinkByIdEventAndIdPerson(idEvent, cdnfSaveSI.getIdChild());
      if (epl != null) {
        eventPersonLinkDAO.deleteEventPersonLink(idEvent, cdnfSaveSI.getIdChild(), epl.getDtLastUpdate());
      }

      OutputLaunchEventLink outputLaunchEventLink = outputLaunchEventLinkDAO.findOutputLaunchEventLink(idEvent);
      if (outputLaunchEventLink != null) {
        outputLaunchEventLinkDAO.deleteOutputLaunchEventLink(idEvent);
      }
      
      int formDeleted = chldDthNrFltySeriInjDAO.deleteCNSForm(idEvent);
      chldDthCauseCbxDAO.deleteChldDthCauseCbxByIdEvent(idEvent);
      chldDthNrFltySeriInjDAO.deleteCNS(idEvent);
      if (CodesTables.CEVTSTAT_PEND.equals(eventStatus)) {
        todoDAO.deleteTodoByIdEvent(idEvent);
        Integer idApproval = approvalEventLinkDAO.findActiveIdApprovalByIdEvent(idEvent);
        if (idApproval != null) {
          List<Approvers> approversList = approversDAO.findApproversByIdApproval(idApproval);
          if (approversList == null || approversList.isEmpty()) {
            // -- throw exception?
            throw new ServiceException(Messages.SQL_NOT_FOUND);
          }
          for (Iterator<Approvers> it = approversList.iterator(); it.hasNext();) {
            Approvers approvers = it.next();
            Todo todo = approvers.getTodo();
            if (todo != null && todo.getIdTodo() > 0) {
              todoDAO.deleteTodo(todo);
            }
            approversDAO.updateIdTodoByIdApprovers(approvers.getIdApprovers(), 0);
          }
        }
      }
      callPostCNSDeleteEvent(rowccmn01uig00, eventStatus, cdnfSaveSI.getIdChild(), cdnfSaveSI.getCdReqFuncCd());
    }else{

    // checkStageEventStatus
    callCheckStageEventStatus(idEvent, idStage, cdTask);

    Integer idVictim = cdnfSaveSI.getIdChild();
    // Event Status New was added as part of the if statement
    // in order to make sure that the primary child information
    // is updated for a dummy event.
    if (((CodesTables.CEVTSTAT_NEW.equals(eventStatus)) || (0 == idEvent)) ) {     
      if (CodesTables.CSTAGES_SUB.equals(cdnfSaveSI.getCsub60si().getSzCdStage())
          || CodesTables.CSTAGES_PFC.equals(cdnfSaveSI.getCsub60si().getSzCdStage())
          || CodesTables.CSTAGES_ADO.equals(cdnfSaveSI.getCsub60si().getSzCdStage())) {
        String cdStagePersType = CodesTables.CROLEALL_PC;
        idVictim = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage, cdStagePersType);
      } else {
        idVictim = cdnfSaveSI.getIdChild();
      }

      ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      // The following line sets idPerson of the Primary Child in rowccmn01uig01
      rowccmn01uig01.setUlIdPerson(idVictim != null ? idVictim : 0);
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
      rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
      csub60si.setROWCCMN01UIG00(rowccmn01uig00);
    }

    if (ArchitectureConstants.N.equals(sysNbrReserved1)) {
      if (csub60si.getSzCdEventStatus().equals(CodesTables.CAPPDESG_PEND)
          && !ArchitectureConstants.TRUE.equals(cdnfSaveSI.getIsCopied())) {
        CCMN05UI ccmn05ui = new CCMN05UI();
        ArchInputStruct ccmn05ui_archInputStruct = new ArchInputStruct();
        ccmn05ui_archInputStruct.setCReqFuncCd(reqFuncCd);
        ccmn05ui.setArchInputStruct(ccmn05ui_archInputStruct);
        ccmn05ui.getArchInputStruct().setUlSysNbrReserved1(ArchitectureConstants.N);
        ccmn05ui.setUlIdEvent(idEvent);
        invalidateApproval.invalidateApproval(ccmn05ui);
      }
    }

    // PostEvent
    rowccmn01uig00.setUlIdPerson(idPerson);    
    
    // idVictim is the person selected in INT, INV or ONG stages , for whom you need to create Child Death/Near Fatalty/Serious Injury
    String nameVictim = "";
    if (CodesTables.CEVNTTYP_CNS.equals(cdEventType)) {
      if (idVictim != null && idVictim > 0) { //idPrimary child == null means it is either INT, INV or ONG stage         
          Person person = personDAO.findPersonByIdPerson(idVictim);
          if (person != null) {
            nameVictim = person.getNmPersonFull();
          }
        }
      }

    if (rowccmn01uig00.getSzTxtEventDescr() == null
        && CodesTables.CEVNTTYP_CNS.equals(cdEventType) && idEvent == 0) {
      String CNSEventDescr = StringHelper.EMPTY_STRING;
      CNSEventDescr = " for " + nameVictim;
      String isCopied = ArchitectureConstants.FALSE;
      isCopied = cdnfSaveSI.getIsCopied();
      oldIdEvent = cdnfSaveSI.getOldIdEvent();
      if (ArchitectureConstants.TRUE.equals(isCopied)) {
        CNSEventDescr = CNSEventDescr + " updated from Event " + oldIdEvent;
      }
      rowccmn01uig00.setSzTxtEventDescr(CNSEventDescr);
    }
    
    //SMS#54782: Update event description to reflect the report type selected on the page.
    String reportDescription = Lookup.simpleDecodeSafe(CodesTables.CDREPTYP, cdnfSaveSI.getReportType()) + " Report";
    if (rowccmn01uig00.getSzTxtEventDescr() != null && CodesTables.CEVNTTYP_CNS.equals(cdEventType)) {
    String  eventDescription = reportDescription + rowccmn01uig00.getSzTxtEventDescr().substring(rowccmn01uig00.getSzTxtEventDescr().indexOf(" for"));
    rowccmn01uig00.setSzTxtEventDescr(eventDescription);
    }
  
    csub60so.setUlIdEvent(callPostEvent(rowccmn01uig00, eventStatus, idVictim , cdnfSaveSI.getIsCopied()));

    // Set Calculated Retention date to maximum date
    if (0 != idEvent) {

      // cinv43d
      todoDAO.updateTodoByIdEvent(idEvent);

    }

    Event event1 = getPersistentObject(Event.class, csub60so.getUlIdEvent());
    CapsCase capsCase = getPersistentObject(CapsCase.class, cdnfSaveSI.getIdCase());
    chldDthNrFltySeriInj.setEvent(event1);
    chldDthNrFltySeriInj.setCapsCase((capsCase));


    if (idVictim != null && idVictim > 0 ) {
      chldDthNrFltySeriInj.setIdChild(idVictim);    
    } else if (cdnfSaveSI.getIdChild() > 0 ){
      chldDthNrFltySeriInj.setIdChild(cdnfSaveSI.getIdChild());
    }
    chldDthNrFltySeriInj.setCommentsCauseDeath(cdnfSaveSI.getTxtCommentsCauseDeath());
    chldDthNrFltySeriInj.setCommentsDeathPreventable(cdnfSaveSI.getTxtCommentsDeathPrev());
    chldDthNrFltySeriInj.setCountyOfDeath(cdnfSaveSI.getCountyOfDeath());
    chldDthNrFltySeriInj.setAutopsyCompleted(cdnfSaveSI.getAutopsyCompleted());
    chldDthNrFltySeriInj.setCommentsAutopsy(cdnfSaveSI.getTxtCommentsAutopsy());
    chldDthNrFltySeriInj.setDeathPreventable(cdnfSaveSI.getDeathPrev());
    chldDthNrFltySeriInj.setReportSubmittedWithin24hrs(cdnfSaveSI.getReportSubmittedWith24Hrs());
    chldDthNrFltySeriInj.setCommentsReportSubmitted(cdnfSaveSI.getTxtCommentsRepSub());
    //SMS#54782
    if(cdnfSaveSI.getReportType() != null){
    chldDthNrFltySeriInj.setReportType(cdnfSaveSI.getReportType());
    }
    chldDthNrFltySeriInjDAO.saveChldDthNrFltySeriInj(chldDthNrFltySeriInj);

    cdnfSaveSO.setIdEvent(csub60so.getUlIdEvent());

    List<String> addList = cdnfSaveSI.getCausesToAdd();
    List<String> deleteList = cdnfSaveSI.getCausesToDelete();

    if (addList != null && !addList.isEmpty()) {
      addCausesOfDeath(addList, csub60so.getUlIdEvent());
    }

    if (deleteList != null && !deleteList.isEmpty()) {
      deleteCausesOfDeath(deleteList, csub60so.getUlIdEvent());
    }

    if (idEvent != 0) {

      OutputLaunchEventLink outputLaunchEventLink = outputLaunchEventLinkDAO.findOutputLaunchEventLink(idEvent);
      if (outputLaunchEventLink != null) {
        outputLaunchEventLink = getPersistentObject(OutputLaunchEventLink.class, idEvent);
      } else {
        outputLaunchEventLink = new OutputLaunchEventLink();
      }

      Event event = getPersistentObject(Event.class, idEvent);
      outputLaunchEventLink.setEvent(event);

      outputLaunchEventLink.setDtLastUpdate(csub60si.getTsSysTsLastUpdate2());
      outputLaunchEventLink.setIndCurrent(csub60si.getCIndCurrent());
      outputLaunchEventLinkDAO.saveOutputLaunchEventLink(outputLaunchEventLink);
    }
    
    cdnfSaveSO.setCdEventStatus(event1.getCdEventStatus());
    cdnfSaveSO.setCsub60so(csub60so);
    }
    return cdnfSaveSO;
  }
  
  private CCMN01UO callPostCNSDeleteEvent(ROWCCMN01UIG00 csub60_rowccmn01uig00, String csub60_eventStatus, int idVictim, String cdReqFuncCd) {
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
    int idEvent = csub60_rowccmn01uig00.getUlIdEvent();  
    int idStage = csub60_rowccmn01uig00.getUlIdStage();
    Integer idPerson = csub60_rowccmn01uig00.getUlIdPerson();
    String cdTask = csub60_rowccmn01uig00.getSzCdTask();
    Date dtEventOccurred = DateHelper.toJavaDate(csub60_rowccmn01uig00.getDtDtEventOccurred());
    Date dtTsLastUpdate = csub60_rowccmn01uig00.getTsLastUpdate();
    String cdEventType = csub60_rowccmn01uig00.getSzCdEventType();
    String txtEventDescr = csub60_rowccmn01uig00.getSzTxtEventDescr();
    String eventStatus = csub60_rowccmn01uig00.getSzCdEventStatus();
    
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (idVictim != 0) {
      rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idVictim);
      rowccmn01uig01.setSzCdScrDataAction(cdReqFuncCd);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }
    rowccmn01uig00.setUlIdEvent(idEvent);
    rowccmn01uig00.setTsLastUpdate(csub60_rowccmn01uig00.getTsLastUpdate());
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setUlIdPerson(idPerson);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    rowccmn01uig00.setTsLastUpdate(dtTsLastUpdate);
    rowccmn01uig00.setSzCdTask(cdTask);
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(cdEventType);
    rowccmn01uig00.setSzTxtEventDescr(txtEventDescr);  
  
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);
    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cdReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    return postEvent.postEvent(ccmn01ui);
  }
  
  private int callPostEvent(ROWCCMN01UIG00 csub60_rowccmn01uig00, String csub60_eventStatus, int idVictim, String isCopied)
                                                                                                               throws ServiceException {

    int idEvent = csub60_rowccmn01uig00.getUlIdEvent();
    int idStage = csub60_rowccmn01uig00.getUlIdStage();
    
    Integer idPerson = csub60_rowccmn01uig00.getUlIdPerson();
    String cdTask = csub60_rowccmn01uig00.getSzCdTask();
    Date dtEventOccurred = DateHelper.toJavaDate(csub60_rowccmn01uig00.getDtDtEventOccurred());
    Date dtTsLastUpdate = csub60_rowccmn01uig00.getTsLastUpdate();
    String cdEventType = csub60_rowccmn01uig00.getSzCdEventType();
    String txtEventDescr = csub60_rowccmn01uig00.getSzTxtEventDescr();
    String eventStatus = csub60_rowccmn01uig00.getSzCdEventStatus();
    //STGAP00011998 : Primary child id should be set in rowccmn01uig01.setUlIdPerson so that 
    //the Primary child is saved in the Event_Person_Link, this will display correct persons
    // on the Child Life History check list page. 
    Integer idPrimaryChild;
    String cdStagePersType = CodesTables.CROLEALL_PC;
    idPrimaryChild = stagePersonLinkDAO.findIdPersonByIdStageAndCdStagePersRole(idStage,cdStagePersType);
    
    Stage stage = stageDAO.findStageByIdStage(idStage);
    String cdStage = StringHelper.EMPTY_STRING;
    if (stage != null){
    cdStage = stage.getCdStage();
    }
    
    CCMN01UI ccmn01ui = new CCMN01UI();
    ccmn01ui.setROWCCMN01UIG00(new ROWCCMN01UIG00());

    ROWCCMN01UIG00 rowccmn01uig00 = ccmn01ui.getROWCCMN01UIG00();

    rowccmn01uig00.setUlIdStage(idStage);
    rowccmn01uig00.setUlIdPerson(idPerson);
    rowccmn01uig00.setUlIdEvent(idEvent);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtEventOccurred));
    rowccmn01uig00.setTsLastUpdate(dtTsLastUpdate);
    rowccmn01uig00.setSzCdTask(cdTask);
    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(cdEventType);
    rowccmn01uig00.setSzTxtEventDescr(txtEventDescr);
    ArchInputStruct ccmn01ui_archInputStruct = new ArchInputStruct();

    if (0 == idEvent) {
      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {

      ccmn01ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    }
    ccmn01ui.setArchInputStruct(ccmn01ui_archInputStruct);

    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = null;
    if (!EVENT_STATUS_COMP.equals(csub60_eventStatus)) {
      rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01();
      //Added idPrimaryChild to rowccmn01uig01 in order to display the name of the 
      // Primary child in Person column on the ChildLife History CheckList , Visitation Plan List
      //Child Life History List 
      rowccmn01uig01.setUlIdPerson(idPrimaryChild != null ? idPrimaryChild : 0);
      
      if (CodesTables.CEVNTTYP_CNS.equals(cdEventType) ) { 
      rowccmn01uig01.setUlIdPerson(idVictim);
      }
      // If the stage is FAD set idPerson (caseworker) to rowccmn01uig01 as we don't have PC in FAD stage.
      if(CodesTables.CSTAGES_FAD.equals(cdStage)){
        rowccmn01uig01.setUlIdPerson(idPerson != null ? idPerson : 0);
      }
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    
    //Added following code so that an EventPersonLink is created when coping an CNS event that is in COMP status.
    if(EVENT_STATUS_COMP.equals(csub60_eventStatus) && CodesTables.CEVNTTYP_CNS.equals(cdEventType) && ArchitectureConstants.TRUE.equals(isCopied)){
      rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();
      ROWCCMN01UIG01 rowccmn01uig01 = new ROWCCMN01UIG01(); 
      rowccmn01uig01.setUlIdPerson(idVictim);
      rowccmn01uig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }
    
    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    // rc = Ccmn01u.PostEvent(pCCMN01UInputRec, pCCMN01UOutputRec, pServiceStatus);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    return ccmn01uo.getUlIdEvent();
  }

  private void callCheckStageEventStatus(int idEvent, int idStage, String cdTask) throws ServiceException {
    CCMN06UI ccmn06ui = new CCMN06UI();

    ArchInputStruct ccmn06ui_archInputStruct = new ArchInputStruct();

    if (0 != idEvent) {
      ccmn06ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    } else {

      ccmn06ui_archInputStruct.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    }
    ccmn06ui.setArchInputStruct(ccmn06ui_archInputStruct);

    ccmn06ui.setUlIdStage(idStage);
    ccmn06ui.setSzCdTask(cdTask);
    checkStageEventStatus.status(ccmn06ui);
  }
  
  /**
   * This private method iterates through the add list to insert new rows to
   * CHLD_DTH_CAUSE_CBX for Cause of Death newly clicked
   *
   * @param idEvent
   * @param addList
   * @return 
   * @throws ServiceException
   */
  private void addCausesOfDeath (List<String> addList, int idEvent) throws ServiceException{

    for (Iterator <String> it = addList.iterator(); it.hasNext();) {
    
      String cdCauseDeath = it.next();      
      ChldDthNrFltySeriInj chldDthNrFltySeriInj = getPersistentObject(ChldDthNrFltySeriInj.class, idEvent);
      
      ChldDthCauseCbx chldDthCauseCbx = new ChldDthCauseCbx();
      chldDthCauseCbx.setCdCauseDeath(cdCauseDeath);
      chldDthCauseCbx.setChldDthNrFtlySeriInj(chldDthNrFltySeriInj);
      
      chldDthCauseCbxDAO.saveOrUpdateCausesOfDeath(chldDthCauseCbx); 
    }
  }
  
  private void deleteCausesOfDeath (List<String> deleletList, int idEvent) throws ServiceException{

    for (Iterator <String> it = deleletList.iterator(); it.hasNext();) {
    
      String cdCauseDeath = it.next();
      chldDthCauseCbxDAO.deleteCauseOfDeath(cdCauseDeath , idEvent); 
    }
  }



}
