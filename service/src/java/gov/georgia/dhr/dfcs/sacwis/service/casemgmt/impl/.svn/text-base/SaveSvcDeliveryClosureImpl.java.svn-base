package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.SaveSvcDeliveryClosure;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV21SIG02;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC14SO;

import java.util.Arrays;
import java.util.List;

/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/28/09 bgehlot    STGAP00014341: MR-51 Reopen Stage Changes
 *
 * </pre>
 */

public class SaveSvcDeliveryClosureImpl extends BaseServiceImpl implements SaveSvcDeliveryClosure {
  
  private static final List<String> NEGATIVE_INDICATORS = Arrays.asList(new String[]{ArchitectureConstants.N,
                                                                                     ArchitectureConstants.FALSE,
                                                                                     ArchitectureConstants.NO});

  private CheckStageEventStatus checkStageEventStatus = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  private StageDAO stageDAO = null;
  
  private EventDAO eventDAO = null;
  
  private AdoNewNameDAO adoNewNameDAO = null;

  public void setCheckStageEventStatus(CheckStageEventStatus checkStageEventStatus) {
    this.checkStageEventStatus = checkStageEventStatus;
  }

  public void setInvalidateApproval(InvalidateApproval invalidateApproval) {
    this.invalidateApproval = invalidateApproval;
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
  
  public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
    this.adoNewNameDAO = adoNewNameDAO;
  }
  
  public CSVC14SO saveSvcDeliveryClosure(CSVC14SI csvc14si) throws ServiceException {
    CSVC14SO output = new CSVC14SO();

    CCMN06UI ccmn06ui = new CCMN06UI();
    ccmn06ui.setArchInputStruct(csvc14si.getArchInputStruct());
    //ccmn06ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ROWCCMN01UIG00 rowCCMN01UIG00 = csvc14si.getROWCCMN01UIG00();
    ccmn06ui.setUlIdStage(rowCCMN01UIG00.getUlIdStage());
    //ccmn06ui.setSzCdTask(rowCCMN01UIG00.getSzCdTask());

    try {
      //-- this will make sure the stage exists and is not yet closed
      checkStageEventStatus.status(ccmn06ui);
    } catch (ServiceException se) {
      int errorCode = se.getErrorCode();
      switch (errorCode) {
      // Check the message for error codes, otherwise just throw
      // the error returned.
      case Messages.MSG_SYS_STAGE_CLOSED:
        throw new ServiceException(Messages.MSG_SYS_STAGE_CLOSED, se);
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH, se);
      case Messages.MSG_SYS_MULT_INST:
        throw new ServiceException(Messages.MSG_SYS_MULT_INST, se);
      default:
        throw se;
      }
    }

    if ((NEGATIVE_INDICATORS.contains(csvc14si.getArchInputStruct().getUlSysNbrReserved1()))
        && (CodesTables.CEVTSTAT_PEND.equals(csvc14si.getSzCdEventStatus()))) {
      CCMN05UI ccmn05ui = new CCMN05UI();
      ccmn05ui.setArchInputStruct(csvc14si.getArchInputStruct());
      ccmn05ui.setUlIdEvent(rowCCMN01UIG00.getUlIdEvent());
      invalidateApproval.invalidateApproval(ccmn05ui);
      //rowCCMN01UIG00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    }

    //if (rowCCMN01UIG00.getUlIdEvent() == 0) {
    //  int idEvent = findEvent(csvc14si.getROWCINV21SIG02().getUlIdStage(), rowCCMN01UIG00);
    //  csvc14si.setUlIdEvent(idEvent);
    //}

    int idEvent = callPostEvent(csvc14si.getArchInputStruct(), rowCCMN01UIG00);
    output.setUlIdEvent(idEvent);
    
    //STGAP00014341: set the indReopenStageEvent to Y if the reopen stage exists
    String cdTaskCode = getTaskCode(csvc14si.getSzCdStage());
    Event event = eventDAO.findEventByIdStageAndEventTypeAndTask(rowCCMN01UIG00.getUlIdStage(), CodesTables.CEVNTTYP_CRP, cdTaskCode);
    if(event != null){
      csvc14si.setBIndReopenStageEvent(ArchitectureConstants.Y);
    }

    updateStage(csvc14si.getROWCINV21SIG02(), csvc14si.getBIndReopenStageEvent());

    //if (CodesTables.CSTAGES_SVC.equals(csvc14si.getSzCdStage())) {
    //  saveSvcDelvDtl(csvc14si.getROWCINV21SIG02().getUlIdStage(),
    //                 DateHelper.toJavaDate(csvc14si.getDtDtSvcDelvDecision()), csvc14si.getTsLastUpdate());
    //}

    //int idEvent = csvc14si.getUlIdEvent();
    // cinv43dAUDdam
    //-- this sets the to-do completion date to current date
    //todoDAO.updateTodoByIdEvent(idEvent);

    return output;

  }
  
  /*
  private void saveSvcDelvDtl(int idStage, Date dtSvcDelvDecision, Date dtLastUpdate) {

    // csvc22dAUDdam
    SvcDelvDtl svcDelvDtl = new SvcDelvDtl();
    svcDelvDtl.setIdStage(idStage);
    svcDelvDtl.setDtSvcDelvDecision(dtSvcDelvDecision);
    svcDelvDtl.setDtLastUpdate(dtLastUpdate);
    svcDelvDtlDAO.saveSvcDelvDtl(svcDelvDtl);
  }
  */

  private void updateStage(ROWCINV21SIG02 rowCINV21SIG02, String indReopenStage) {
    int idStage = rowCINV21SIG02.getUlIdStage(); 
    
    //STGAP00014341: If the stage is reopened then User can enter the date close and hence that date should be saved
    if(ArchitectureConstants.Y.equals(indReopenStage)){
      AdoNewName adoNewName = adoNewNameDAO.findAdoNewNameByIdStage(idStage);
      if(adoNewName == null){
        adoNewName = new AdoNewName();
      }
      Stage stage = getPersistentObject(Stage.class, idStage);
      adoNewName.setStage(stage);
      adoNewName.setDtStageCloseTemp(DateHelper.toJavaDate(rowCINV21SIG02.getDtDtStageClose()));
      adoNewNameDAO.saveOrUpdateAdoNewName(adoNewName);
    }
    
    if(idStage > 0) {
      Stage stage = getPersistentObject(Stage.class, idStage);
      stage.setCdStageReasonClosed(rowCINV21SIG02.getSzCdStageReasonClosed());
      stage.setTxtStageClosureCmnts(rowCINV21SIG02.getSzTxtStageClosureCmnts());
      stageDAO.saveStage(stage);
    }
    
    /*
    int idUnit = rowCINV21SIG02.getUlIdUnit();
    
    String indStageClose = rowCINV21SIG02.getBIndStageClose();
    String nmStage = rowCINV21SIG02.getSzNmStage();
    String cdStage = rowCINV21SIG02.getSzCdStage();
    String cdStageClassification = rowCINV21SIG02.getSzCdStageClassification();
    String cdStageCnty = rowCINV21SIG02.getSzCdStageCnty();
    String cdStageCurrPriority = rowCINV21SIG02.getSzCdStageCurrPriority();

    String cdStageInitialPriority = rowCINV21SIG02.getSzCdStageInitialPriority();
    String cdStageProgram = rowCINV21SIG02.getSzCdStageProgram();
    String cdStageReasonClosed = rowCINV21SIG02.getSzCdStageReasonClosed();

    Date dtStageClose = DateHelper.toJavaDate(rowCINV21SIG02.getDtDtStageClose());
    Date dtStageStart = DateHelper.toJavaDate(rowCINV21SIG02.getDtDtStageStart());
    int idCase = rowCINV21SIG02.getUlIdCase();
    int idSituation = rowCINV21SIG02.getUlIdSituation();
    String cdClientAdvised = rowCINV21SIG02.getSzCdClientAdvised();

    String indEcs = rowCINV21SIG02.getBIndEcs();
    String indEcsVer = rowCINV21SIG02.getBIndEcsVer();
    String txtStageClosureCmnts = rowCINV21SIG02.getSzTxtStageClosureCmnts();

    String txtStagePriorityCmnts = rowCINV21SIG02.getSzTxtStagePriorityCmnts();
    String cdStageRegion = rowCINV21SIG02.getSzCdStageRegion();
    String cdStageRsnPriorityChgd = rowCINV21SIG02.getSzCdStageRsnPriorityChgd();

    String cdStageType = rowCINV21SIG02.getSzCdStageType();
    Date dtLastUpdate = rowCINV21SIG02.getTsLastUpdate();

    // csvc18dAUDdam
    Stage stage = new Stage();

    if (idStage != 0) {
      stage = (Stage) getPersistentObject(Stage.class, idStage);
    }
    
    stage.setCdStageInitialPriority(cdStageInitialPriority);
    stage.setCdStageProgram(cdStageProgram);
    stage.setCdStageReasonClosed(cdStageReasonClosed);
    stage.setDtStageClose(dtStageClose);
    stage.setDtStageStart(dtStageStart);

    Situation situation = new Situation();

    if (idSituation != 0) {
      situation = (Situation) getPersistentObject(Situation.class, idSituation);
    }
    
    stage.setSituation(situation);
    stage.setCdClientAdvised(cdClientAdvised);
    stage.setIndEcs(indEcs);
    stage.setIndEcsVer(indEcsVer);
    stage.setTxtStageClosureCmnts(txtStageClosureCmnts);
    stage.setTxtStagePriorityCmnts(txtStagePriorityCmnts);
    stage.setCdStageRegion(cdStageRegion);
    stage.setCdStageRsnPriorityChgd(cdStageRsnPriorityChgd);
    stage.setCdStageType(cdStageType);
    stage.setDtLastUpdate(dtLastUpdate);

    CapsCase capsCase = new CapsCase();

    if (idCase != 0) {
      capsCase = (CapsCase) getPersistentObject(CapsCase.class, idCase);
    }
   
    stage.setCapsCase(capsCase);

    Unit unit = new Unit();

    if (idUnit != 0) {
      unit = (Unit) getPersistentObject(Unit.class, idUnit);
    }
    
    stage.setUnit(unit);
    stage.setIndStageClose(indStageClose);
    stage.setNmStage(nmStage);
    stage.setCdStage(cdStage);
    stage.setCdStageClassification(cdStageClassification);
    stage.setCdStageCnty(cdStageCnty);
    stage.setCdStageCurrPriority(cdStageCurrPriority);

    stageDAO.saveStage(stage);
    */
  }

  private int callPostEvent(ArchInputStruct archInputStruct, ROWCCMN01UIG00 rowCCMN01UIG00) throws ServiceException {
    /*--------------------------------------------------------
    CCMN01UI ccmn01uix = new CCMN01UI();

    ccmn01uix.setArchInputStruct(archInputStruct);
    ROWCCMN01UIG00 ccmn01ui_rowcsub68sig00 = new ROWCCMN01UIG00();
    ccmn01ui_rowcsub68sig00.setSzCdTask(rowcsub68sig00.getSzCdTask());
    ccmn01ui_rowcsub68sig00.setTsLastUpdate(rowcsub68sig00.getTsLastUpdate());
    ccmn01ui_rowcsub68sig00.setSzCdEventType(rowcsub68sig00.getSzCdEventType());
    //if (rowcsub68sig00.getUlIdEvent() > 0) {
      ccmn01ui_rowcsub68sig00.setDtDtEventOccurred(rowcsub68sig00.getDtDtEventOccurred());
    //} else {
    //  ccmn01ui_rowcsub68sig00.setDtDtEventOccurred(DateHelper.toCastorDate(dtSystemDate));
    //}
    ccmn01ui_rowcsub68sig00.setUlIdEvent(rowcsub68sig00.getUlIdEvent());
    ccmn01ui_rowcsub68sig00.setUlIdStage(rowcsub68sig00.getUlIdStage());
    ccmn01ui_rowcsub68sig00.setUlIdPerson(rowcsub68sig00.getUlIdPerson());
    ccmn01ui_rowcsub68sig00.setSzTxtEventDescr(rowcsub68sig00.getSzTxtEventDescr());
    ccmn01ui_rowcsub68sig00.setSzCdEventStatus(cdEventStatus);
    ccmn01uix.setROWCCMN01UIG00(ccmn01ui_rowcsub68sig00);
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01uix);
    rowcsub68sig00.setUlIdEvent(ccmn01uo.getUlIdEvent());
    //-------------------------------------------------------- */
    
    CCMN01UI ccmn01ui = new CCMN01UI();
    //Date curDate = null;

    ccmn01ui.setArchInputStruct(archInputStruct);
    //ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn01ui.setROWCCMN01UIG00(rowCCMN01UIG00);
    //ROWCCMN01UIG00 rowICCMN01UIG00 = ccmn01ui.getROWCCMN01UIG00();
    //if (0 != rowICCMN01UIG00.getUlIdEvent()) {
    //  ccmn01ui.getArchInputStruct().setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    //  curDate = new Date();
    //  rowICCMN01UIG00.setDtDtEventOccurred(DateHelper.toCastorDate(curDate));
    //}
    CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
    return ccmn01uo.getUlIdEvent();
  }
  
  /*
  private int findEvent(int idStage, ROWCCMN01UIG00 rowCCMN01UIG00) throws ServiceException {

    int idEvent = 0;
    String cdEventType = CodesTables.CEVNTTYP_STG;
    // csvc36dQUERYdam
    Event event = eventDAO.findEventByStageAndType(idStage, cdEventType);

    if (event == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    idEvent = event.getIdEvent();    
    rowCCMN01UIG00.setUlIdEvent(idEvent);
    rowCCMN01UIG00.setTsLastUpdate(event.getDtLastUpdate());
    return idEvent;

  }
  */
  /**
   * STGAP00014341:This helper method takes in the Stage code to determines the Task Code and returns it. Called by
   * displayStageReopen_xa.
   * 
   * @param testCdStage
   *          String
   * @return taskCode
   */
  private String getTaskCode(String testCdStage) {
    String taskCode = StringHelper.EMPTY_STRING;
    //Set the task code depending on the current stage
    if (StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_SUB)){
      taskCode = SUB_TASK_CODE;
    } else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_FSU)){
      taskCode = FSU_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_ADO)){
      taskCode = ADO_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_PAD)){
      taskCode = PAD_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_DIV)){
      taskCode = DIV_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_FPR)){
      taskCode = FPR_TASK_CODE;
    }else if(StringHelper.checkForEquality(testCdStage,CodesTables.CSTAGES_PFC)){
      taskCode = PFC_TASK_CODE;
    }
    return taskCode;
  }

}
