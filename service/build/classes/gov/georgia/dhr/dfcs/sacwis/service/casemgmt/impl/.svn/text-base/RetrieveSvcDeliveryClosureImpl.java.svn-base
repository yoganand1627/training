package gov.georgia.dhr.dfcs.sacwis.service.casemgmt.impl;

import java.util.Date;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageReopenDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcDelvDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopen;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.RetrieveSvcDeliveryClosure;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSVC15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSVC15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV19SOG02;

/**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  07/28/09 bgehlot    STGAP00014341: MR-51 Reopen Stage Changes
 *
 * </pre>
 */

public class RetrieveSvcDeliveryClosureImpl extends BaseServiceImpl implements RetrieveSvcDeliveryClosure {

  private StageDAO stageDAO = null;

  private EventDAO eventDAO = null;

  private SvcDelvDtlDAO svcDelvDtlDAO = null;
  
  private AdoNewNameDAO adoNewNameDAO = null;
  
  private StageReopenDAO stageReopenDAO = null;

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setSvcDelvDtlDAO(SvcDelvDtlDAO svcDelvDtlDAO) {
    this.svcDelvDtlDAO = svcDelvDtlDAO;
  }
  
  public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
    this.adoNewNameDAO = adoNewNameDAO;
  }
  
  public void setStageReopenDAO(StageReopenDAO stageReopenDAO) {
    this.stageReopenDAO = stageReopenDAO;
  }

  public CSVC15SO retrieveServDelivery(CSVC15SI csvc15si) throws ServiceException {

    CSVC15SO csvc15so = new CSVC15SO();

    callCINT40D(csvc15si, csvc15so);

    if (csvc15si.getUlIdEvent() != 0) {

      callCCMN45D(csvc15si, csvc15so);

      if (CodesTables.CSTAGES_SVC.equals(csvc15si.getSzCdStage())
          && CodesTables.CEVTSTAT_NEW.equals(csvc15so.getROWCCMN01UIG00().getSzCdEventStatus())) {

        callCSVC21D(csvc15si, csvc15so);
      }
    }
    if (CodesTables.CSTAGES_SVC.equals(csvc15si.getSzCdStage()) && (0 >= csvc15so.getDtDtSvcDelvDecision().getYear())) {

      csvc15so.setDtDtSvcDelvDecision(DateHelper.toCastorDate(new Date()));
    }
    return csvc15so;
  }

  private void callCCMN45D(CSVC15SI pInputMsg848, CSVC15SO csvc15so) throws ServiceException {

    Event event = eventDAO.findEventByIdEvent(pInputMsg848.getUlIdEvent());

    if (event == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    ROWCCMN01UIG00 rowccmn01uig00 = new ROWCCMN01UIG00();
    rowccmn01uig00.setSzCdTask(event.getCdTask());
    rowccmn01uig00.setSzCdEventStatus(event.getCdEventStatus());
    rowccmn01uig00.setSzCdEventType(event.getCdEventType());
    rowccmn01uig00.setSzTxtEventDescr(event.getTxtEventDescr());
    rowccmn01uig00.setTsLastUpdate(event.getDtLastUpdate());
    rowccmn01uig00.setUlIdEvent(event.getIdEvent() != null ? event.getIdEvent() : 0);
    rowccmn01uig00.setUlIdStage(event.getStage().getIdStage() != null ? event.getStage().getIdStage() : 0);
    rowccmn01uig00.setUlIdPerson(event.getPerson().getIdPerson() != null ? event.getPerson().getIdPerson() : 0);
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));

    csvc15so.setROWCCMN01UIG00(rowccmn01uig00);
  }

  private void callCINT40D(CSVC15SI pInputMsg849, CSVC15SO csvc15so) throws ServiceException {

    Stage stage = stageDAO.findStageByIdStage(pInputMsg849.getUlIdStage());

    if (stage == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }

    ROWCINV19SOG02 rowcinv19sog02 = new ROWCINV19SOG02();
    rowcinv19sog02.setUlIdStage(stage.getIdStage() != null ? stage.getIdStage() : 0);
    rowcinv19sog02.setUlIdUnit(stage.getUnit().getIdUnit() != null ? stage.getUnit().getIdUnit() : 0);
    rowcinv19sog02.setBIndStageClose(stage.getIndStageClose());
    rowcinv19sog02.setSzNmStage(stage.getNmStage());
    rowcinv19sog02.setSzCdStage(stage.getCdStage());
    rowcinv19sog02.setSzCdStageClassification(stage.getCdStageClassification());
    rowcinv19sog02.setSzCdStageCnty(stage.getCdStageCnty());
    rowcinv19sog02.setSzCdStageCurrPriority(stage.getCdStageCurrPriority());
    rowcinv19sog02.setSzCdStageInitialPriority(stage.getCdStageInitialPriority());
    rowcinv19sog02.setSzCdStageProgram(stage.getCdStageProgram());
    rowcinv19sog02.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());
    rowcinv19sog02.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
    rowcinv19sog02.setDtDtStageStart(DateHelper.toCastorDate(stage.getDtStageStart()));
    rowcinv19sog02.setUlIdCase(stage.getCapsCase().getIdCase() != null ? stage.getCapsCase().getIdCase() : 0);
    rowcinv19sog02.setUlIdSituation(stage.getSituation().getIdSituation() != null ? stage.getSituation()
                                                                                         .getIdSituation() : 0);
    rowcinv19sog02.setSzCdClientAdvised(stage.getCdClientAdvised());
    rowcinv19sog02.setBIndEcs(stage.getIndEcs());
    rowcinv19sog02.setBIndEcsVer(stage.getIndEcsVer());

    if (stage.getTxtStageClosureCmnts() != null) {
      rowcinv19sog02.setSzTxtStageClosureCmnts(stage.getTxtStageClosureCmnts());
    } else {
      rowcinv19sog02.setSzTxtStageClosureCmnts(StringHelper.EMPTY_STRING);
    }

    rowcinv19sog02.setSzTxtStagePriorityCmnts(stage.getTxtStagePriorityCmnts());
    rowcinv19sog02.setSzCdStageRegion(stage.getCdStageRegion());
    rowcinv19sog02.setSzCdStageRsnPriorityChgd(stage.getCdStageRsnPriorityChgd());
    rowcinv19sog02.setSzCdStageType(stage.getCdStageType());
    rowcinv19sog02.setTsLastUpdate(stage.getDtLastUpdate());
    
    //STGAP00014341: Check to see if a reopen stage event exists then set the indicator to Y to show the
    //Date as modifiable
    String cdTaskCode = getTaskCode(rowcinv19sog02.getSzCdStage());
    
    Event event = eventDAO.findEventByIdStageAndEventTypeAndTaskIdEventDesc(pInputMsg849.getUlIdStage(), CodesTables.CEVNTTYP_CRP, cdTaskCode);
    if(event != null){
      csvc15so.setBIndReopenStageEvent(ArchitectureConstants.Y);
      AdoNewName adoNewName = adoNewNameDAO.findAdoNewNameByIdStage(pInputMsg849.getUlIdStage());
      if(adoNewName != null){
        rowcinv19sog02.setDtDtStageClose(DateHelper.toCastorDate(adoNewName.getDtStageCloseTemp()));
      }
      StageReopen stageReopen = stageReopenDAO.findStageReopenByIdEvent(event.getIdEvent());
      if(stageReopen != null){
        csvc15so.setSzCdStageReasonClosedFromReopen(stageReopen.getCdStageReasonClosed());
        csvc15so.setSzTxtStageClosureCmntsFromReopen(stageReopen.getTxtStageClosureCmnts());
        csvc15so.setDtDtStageCloseFromReopen(DateHelper.toCastorDate(stageReopen.getDtStageClose()));
      }
    }else{
      csvc15so.setBIndReopenStageEvent(ArchitectureConstants.N);
    }

    csvc15so.setROWCINV19SOG02(rowcinv19sog02);
  }

  private void callCSVC21D(CSVC15SI pInputMsg850, CSVC15SO csvc15so) throws ServiceException {

    Map svcDelvDtlMap = svcDelvDtlDAO.findSvcDelvDtlByIdStage(pInputMsg850.getUlIdStage());

    if (svcDelvDtlMap == null) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    csvc15so.setDtDtSvcDelvDecision(DateHelper.toCastorDate((Date) svcDelvDtlMap.get("dtSvcDelvDecision")));
    csvc15so.setTsLastUpdate((Date) svcDelvDtlMap.get("tsLastUpdate"));
  }
  
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
