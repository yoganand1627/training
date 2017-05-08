package gov.georgia.dhr.dfcs.sacwis.service.adoexchange.impl;

/** Change History:
 **  Date        User              Description
 **  --------    ----------------  -------------------------------------------------------------------------
 *   07/22/2009  hjbaptiste        STGAP00014781: Send foster home conversion closed alert to only Regional Adoption Exchange Consultants.
 *                                 Send the alert whenever the home closes for any reason        
 *
 **/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexTodoDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.FosterHomeConvPerLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.UnitEmpLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.WorkloadDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsCase;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConv;
import gov.georgia.dhr.dfcs.sacwis.db.FosterHomeConvPerLink;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Todo;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.SaveFosterHomeConversion;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionChildBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterHomeConversionSO;

public class SaveFosterHomeConversionImpl extends BaseServiceImpl implements SaveFosterHomeConversion {

  public FosterHomeConversionSO saveFosterHomeConversion(FosterHomeConversionSI fosterHomeConversionSI) {
    int idEvent = fosterHomeConversionSI.getUlIdEvent();
    int idStage = fosterHomeConversionSI.getUlIdStage();
    int idCase = fosterHomeConversionSI.getUlIdCase();
    int idPerson = fosterHomeConversionSI.getUlIdPerson();
    Date dtClosed = fosterHomeConversionSI.getDtClosed();
    String cdClosureReason = fosterHomeConversionSI.getSzCdClosureReason();
    
    String eventReqFuncCd = "";
    if (idEvent != 0) {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_UPDATE;
    } else {
      eventReqFuncCd = ServiceConstants.REQ_FUNC_CD_ADD;
    }
    fosterHomeConversionSI.setEventReqFuncCd(eventReqFuncCd);
    
    FosterHomeConv fosterHomeConv = populateFosterHomeConv(fosterHomeConversionSI);
    fosterHomeConvDAO.saveFosterHomeConvDetails(fosterHomeConv);

    if (dtClosed != null && ("".equals(cdClosureReason) || cdClosureReason == null) ) {
      throw new ServiceException(Messages.MSG_FAD_CONV_CLOSURE_RSN);
    }
    
    // If dtClosed is valid, let the Regional Adoption Exchange Consultants know about this occurrence
    if (dtClosed != null) {
      addConversionClosedAlert(idEvent, idCase, idStage, idPerson, dtClosed);
    }

    List<FosterHomeConversionChildBean> childrenToBeAdopted = fosterHomeConversionSI.getChildrenToBeAdopted();
    setFosterHomeConvPerLinks(childrenToBeAdopted, fosterHomeConv, idEvent);
    FosterHomeConversionSO fosterHomeConversionSO = populateFosterHomeConversionSO(fosterHomeConversionSI);
    
    return fosterHomeConversionSO;
  }

  /**
   * 
   * @param fosterHomeConversionSI
   * @return
   * @throws ServiceException
   */
  private FosterHomeConv populateFosterHomeConv(FosterHomeConversionSI fosterHomeConversionSI) throws ServiceException {
    
    FosterHomeConv fosterHomeConv = null;
    Event convEvent = null;

    int idEvent = fosterHomeConversionSI.getUlIdEvent();
    
    if (idEvent > 0) {
      fosterHomeConv = fosterHomeConvDAO.findFosterHomeConvDetailsByIdEvent(idEvent);
      convEvent = eventDAO.findEventByIdEvent(idEvent);
      fosterHomeConversionSI.setDtEventLastUpdate(convEvent.getDtLastUpdate());
    }
    if (fosterHomeConv == null) {
      fosterHomeConv = new FosterHomeConv();
    }

    Date dtApplied = fosterHomeConversionSI.getDtApplied();
    Date dtInquiry = fosterHomeConversionSI.getDtInquiry();

    if (dtInquiry.getTime() > dtApplied.getTime()) {
      throw new ServiceException(Messages.MSG_FAD_CONV_APP_DATE);
    }

    int idAdoAgency = fosterHomeConversionSI.getUlIdAdoAgency();
    int idResource = fosterHomeConversionSI.getUlIdResource();
    
    Date dtApproved = fosterHomeConversionSI.getDtApproved();
    Date dtClosed = fosterHomeConversionSI.getDtClosed();

    String cdClosureReason = fosterHomeConversionSI.getSzCdClosureReason();
    String cdConvAppStatus = fosterHomeConversionSI.getSzCdConvAppStatus();
    String eventReqFuncCd = fosterHomeConversionSI.getEventReqFuncCd();

    CCMN01UO ccmn01uo = callPostEvent(fosterHomeConversionSI, eventReqFuncCd);
    if (ccmn01uo != null) {
      idEvent = ccmn01uo.getUlIdEvent();
      fosterHomeConversionSI.setUlIdEvent(idEvent);
    }
    Event event = getPersistentObject(Event.class, idEvent);

    if (idEvent != 0) {
      fosterHomeConversionSI.setDtEventLastUpdate(event.getDtLastUpdate());      
    }

    CapsResource capsResource = getPersistentObject(CapsResource.class, idResource);
    CapsResource adoAgency = null;
    if (idAdoAgency > 0) {
      adoAgency = getPersistentObject(CapsResource.class, idAdoAgency);
    }

    fosterHomeConv.setCapsResourceByIdAdoAgency(adoAgency);
    fosterHomeConv.setCapsResourceByIdResource(capsResource);
    fosterHomeConv.setCdClosureReason(cdClosureReason);
    fosterHomeConv.setCdConvAppStatus(cdConvAppStatus);
    fosterHomeConv.setDtApplied(dtApplied);
    fosterHomeConv.setDtApproval(dtApproved);
    fosterHomeConv.setDtClosure(dtClosed);
    fosterHomeConv.setDtInquiry(dtInquiry);
    fosterHomeConv.setEvent(event);
    fosterHomeConv.setIdEvent(idEvent);
    return fosterHomeConv;
  }

  /**
   * 
   * @param fosterHomeConversionSI
   * @return
   */
  private FosterHomeConversionSO populateFosterHomeConversionSO(FosterHomeConversionSI fosterHomeConversionSI) {
    int idEvent = fosterHomeConversionSI.getUlIdEvent();
    int idAdoAgency = fosterHomeConversionSI.getUlIdAdoAgency();
    Date dtApplied = fosterHomeConversionSI.getDtApplied();
    Date dtApproved = fosterHomeConversionSI.getDtApproved();
    Date dtClosed = fosterHomeConversionSI.getDtClosed();
    Date dtInquiry = fosterHomeConversionSI.getDtInquiry();

    String cdClosureReason = fosterHomeConversionSI.getSzCdClosureReason();
    String cdConvAppStatus = fosterHomeConversionSI.getSzCdConvAppStatus();
    String cdReqFuncCd = fosterHomeConversionSI.getCdReqFuncCd();
    String nmResource = fosterHomeConversionSI.getNmResource();
    List<FosterHomeConversionChildBean> childrenToBeAdopted = fosterHomeConversionSI.getChildrenToBeAdopted();
   
    FosterHomeConversionSO fosterHomeConversionSO = new FosterHomeConversionSO();
    fosterHomeConversionSO.setCdClosureReason(cdClosureReason);
    fosterHomeConversionSO.setCdConvAppStatus(cdConvAppStatus);
    fosterHomeConversionSO.setCdReqFuncCd(cdReqFuncCd);
    fosterHomeConversionSO.setDtApplied(dtApplied);
    fosterHomeConversionSO.setDtApproved(dtApproved);
    fosterHomeConversionSO.setDtClosed(dtClosed);
    fosterHomeConversionSO.setDtInquired(dtInquiry);
    fosterHomeConversionSO.setIdEvent(idEvent);
    fosterHomeConversionSO.setIdAdoAgency(idAdoAgency);
    fosterHomeConversionSO.setNmResource(nmResource);
    fosterHomeConversionSO.setChildrenToBeAdopted(childrenToBeAdopted);
   
    return fosterHomeConversionSO;
  }

  /**
   * 
   * @param childrenToBeAdopted
   * @param fosterHomeConv
   * @param idEvent
   */
  private void setFosterHomeConvPerLinks(List<FosterHomeConversionChildBean> childrenToBeAdopted, FosterHomeConv fosterHomeConv, int idEvent){
    if (childrenToBeAdopted != null) {
      for (FosterHomeConversionChildBean child : childrenToBeAdopted) {
        int idChild = child.getIdChild();
        FosterHomeConvPerLink dataCheckLink = fosterHomeConvPerLinkDAO.findFosterComeConvPerLinkByIdPersonIdEvent(idChild, idEvent);
        if (dataCheckLink == null) {
          FosterHomeConvPerLink f = new FosterHomeConvPerLink();
          f.setIdPerson(idChild);
          f.setFosterHomeConv(fosterHomeConv);
          fosterHomeConvPerLinkDAO.saveFosterHomeConvPerLinkReturnId(f);
        }
      }      
    }
  }
  
  /**
   * 
   * @param fosterHomeConversionSI
   * @param cReqFuncCd
   * @return
   */
  private CCMN01UO callPostEvent(FosterHomeConversionSI fosterHomeConversionSI, String cReqFuncCd) { 
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    ROWCCMN01UIG01_ARRAY rowccmn01uig01_array = new ROWCCMN01UIG01_ARRAY();

    int idEvent = fosterHomeConversionSI.getUlIdEvent();
    int idStage = fosterHomeConversionSI.getUlIdStage();
    int idPerson = fosterHomeConversionSI.getUlIdPerson();
    Date dtApplied = fosterHomeConversionSI.getDtApplied();
    Date dtClosed = fosterHomeConversionSI.getDtClosed();
    String eventStatus = fosterHomeConversionSI.getEventStatus();
    String txtDescription = fosterHomeConversionSI.getEventDescription();

    if (idEvent != 0) {
      rowccmn01uig00.setUlIdEvent(idEvent);
      rowccmn01uig00.setTsLastUpdate(fosterHomeConversionSI.getDtEventLastUpdate());
    }
    
    if (idEvent == 0) {
      txtDescription = "Home Conversion";
    } else if (CodesTables.CEVTSTAT_PROC.equals(eventStatus)) {
      txtDescription = "Home Conversion Starting " + FormattingHelper.formatDate(dtApplied);
    } else if (CodesTables.CEVTSTAT_PEND.equals(eventStatus)) {
      txtDescription = "Home Conversion Starting " + FormattingHelper.formatDate(dtApplied);
    } else if (CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
        if (dtClosed != null) {
          txtDescription = "Home Conversion Starting " + FormattingHelper.formatDate(dtApplied) + " Ended " + FormattingHelper.formatDate(dtClosed);
        } else {
          txtDescription = "Home Conversion Starting " + FormattingHelper.formatDate(dtApplied);          
        }
      // Status actually stays at APRV
      //eventStatus = CodesTables.CEVTSTAT_COMP;
    }

    rowccmn01uig00.setSzCdEventStatus(eventStatus);
    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_HCN);
    rowccmn01uig00.setSzTxtEventDescr(txtDescription);
    rowccmn01uig00.setSzCdTask(HCN_TASK_ID);
    rowccmn01uig00.setUlIdPerson(idPerson);
    rowccmn01uig00.setUlIdStage(idStage);
    
    if (!DateHelper.isNull(dtApplied) && idEvent != 0) {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtApplied));
    } else {
      rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(new Date()));
    }
    
    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01 rowccmn01uig01;
    if (idPerson != 0) {
      rowccmn01uig01 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG01();
      rowccmn01uig01.setUlIdPerson(idPerson);
      rowccmn01uig01.setSzCdScrDataAction(cReqFuncCd);
      rowccmn01uig01_array.addROWCCMN01UIG01(rowccmn01uig01);
    }

    if (idEvent != 0) {
      rowccmn01uig01_array = null;
    }

    rowccmn01uig00.setROWCCMN01UIG01_ARRAY(rowccmn01uig01_array);

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct archInputStruct = new ArchInputStruct();
    archInputStruct.setCReqFuncCd(cReqFuncCd);
    ccmn01ui.setArchInputStruct(archInputStruct);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);
    
    return postEvent.postEvent(ccmn01ui);

  }

  public void addConversionClosedAlert(int idEvent, int idCase, int idStage, int idUser, Date dtPlcmtEnd) {
    CapsCase capsCase = getPersistentObject(CapsCase.class, idCase);
    // Only send the alert to the Regional Adoption Exchange Consultants
    String cdCounty = capsCase.getCdCaseCounty();
    if(cdCounty != null){
      if(cdCounty.length() == 1 ){
        cdCounty = "00" + cdCounty;
      } else if (cdCounty.length() == 2){
        cdCounty = "0" + cdCounty;
      }
    }
    String cdRegion = "0" + Lookup.simpleDecodeSafe(CodesTables.CCNTYREG, cdCounty);
    List<Integer> adoExchangeConsultants = unitEmpLinkDAO.findRegionalAdoptionExchangeConsultantByCdRegion(cdRegion);
    if (listIsValid(adoExchangeConsultants)) {
      Iterator<Integer> itrAdoExchangeConsultants = adoExchangeConsultants.iterator();
      List<Todo> todoList = new ArrayList<Todo>();
      while (itrAdoExchangeConsultants.hasNext()) {
        Integer idAssgnd = (Integer) itrAdoExchangeConsultants.next();
        if (idAssgnd != null) {
          int idAssigned = idAssgnd;
          Todo todo1 = new Todo();
          String cdTask = "";
          Date dateCreated = new Date();
          Date todoDueDate = dtPlcmtEnd;
          String todoDesc = "Foster Home Conversion has been closed";
          todo1.setEvent(getPersistentObject(Event.class, idEvent));
          todo1.setTxtTodoDesc(todoDesc);
          todo1.setCdTodoTask(cdTask);
          todo1.setCdTodoType(TODO_TYPE_ALERT);
          todo1.setDtTodoDue(todoDueDate);
          todo1.setPersonByIdTodoPersAssigned(getPersistentObject(Person.class, idAssigned));
          todo1.setPersonByIdTodoPersWorker(getPersistentObject(Person.class, idUser));
          todo1.setDtTodoCreated(dateCreated);
          todo1.setCapsCase(capsCase);
          todo1.setStage(getPersistentObject(Stage.class, idStage));
          todoList.add(todo1);
        }
      }
      complexTodoDAO.saveTodo(todoList);
    }
    
  }

  private boolean listIsValid(Collection aList) {
    return (aList != null && !aList.isEmpty());
  }

  public PostEvent getPostEvent() {
    return postEvent;
  }

  public void setPostEvent(PostEvent postEvent) {
    this.postEvent = postEvent;
  }

  public ApprovalDAO getApprovalDAO() {
    return approvalDAO;
  }

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public ApprovalEventLinkDAO getApprovalEventLinkDAO() {
    return approvalEventLinkDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public ComplexTodoDAO getComplexTodoDAO() {
    return complexTodoDAO;
  }

  public void setComplexTodoDAO(ComplexTodoDAO complexTodoDAO) {
    this.complexTodoDAO = complexTodoDAO;
  }

  public EventDAO getEventDAO() {
    return eventDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public FosterHomeConvDAO getFosterHomeConvDAO() {
    return fosterHomeConvDAO;
  }

  public void setFosterHomeConvDAO(FosterHomeConvDAO fosterHomeConvDAO) {
    this.fosterHomeConvDAO = fosterHomeConvDAO;
  }

  public FosterHomeConvPerLinkDAO getFosterHomeConvPerLinkDAO() {
    return fosterHomeConvPerLinkDAO;
  }

  public void setFosterHomeConvPerLinkDAO(FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO) {
    this.fosterHomeConvPerLinkDAO = fosterHomeConvPerLinkDAO;
  }

  public UnitEmpLinkDAO getUnitEmpLinkDAO() {
    return unitEmpLinkDAO;
  }

  public void setUnitEmpLinkDAO(UnitEmpLinkDAO unitEmpLinkDAO) {
    this.unitEmpLinkDAO = unitEmpLinkDAO;
  }

  public WorkloadDAO getWorkloadDAO() {
    return workloadDAO;
  }

  public void setWorkloadDAO(WorkloadDAO workloadDAO) {
    this.workloadDAO = workloadDAO;
  }

  public static final String EVENT_TYPE = CodesTables.CEVNTTYP_HCN;
  
  public static final String HCN_TASK_ID = "9997";
  
  public static final String TODO_TYPE_TASK = CodesTables.CTODOTYP_T;
  
  public static final String TODO_TYPE_ALERT = CodesTables.CTODOTYP_A;

  private PostEvent postEvent = null;
  
  private ApprovalDAO approvalDAO;
  
  private ApprovalEventLinkDAO approvalEventLinkDAO;
  
  private ComplexTodoDAO complexTodoDAO;

  private EventDAO eventDAO;
  
  private FosterHomeConvDAO fosterHomeConvDAO;
  
  private FosterHomeConvPerLinkDAO fosterHomeConvPerLinkDAO;
  
  private UnitEmpLinkDAO unitEmpLinkDAO;
  
  private WorkloadDAO workloadDAO;

}
