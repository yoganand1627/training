package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.AdoNewNameDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageReopenDAO;
import gov.georgia.dhr.dfcs.sacwis.db.AdoNewName;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageReopen;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveClosureEvent;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB67SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB67SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCSUB67SOG01;

import java.util.Map;

 /**
 * <pre>
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  10/28/08  vdevarak  STGAP00010749 - Added code to retrieve name fields 
 *                      from the ADO_NEW_NAME table
 *  07/25/09 bgehlot    STGAP00014341: MR-51 Reopen Stage Changes
 *
 * </pre>
 */
public class RetrieveClosureEventImpl extends BaseServiceImpl implements RetrieveClosureEvent {

  private StageDAO stageDAO = null;

  private EventDAO eventDAO = null;
  
  private AdoNewNameDAO adoNewNameDAO = null;
  
  private StageReopenDAO stageReopenDAO = null;

  public void setAdoNewNameDAO(AdoNewNameDAO adoNewNameDAO) {
    this.adoNewNameDAO = adoNewNameDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }
  
  public void setStageReopenDAO(StageReopenDAO stageReopenDAO) {
    this.stageReopenDAO = stageReopenDAO;
  }

  public CSUB67SO retrieveClosureEvent(CSUB67SI csub67si) {
    CSUB67SO csub67so = new CSUB67SO();
    Stage stage = stageDAO.findStageByIdStage(csub67si.getUlIdStage());
    if (stage != null) {
      ROWCSUB67SOG01 rowcsub67sog01 = new ROWCSUB67SOG01();
      rowcsub67sog01.setSzCdStage(stage.getCdStage());
      rowcsub67sog01.setUlIdStage(stage.getIdStage());
      rowcsub67sog01.setUlIdCase(stage.getCapsCase() != null ? stage.getCapsCase().getIdCase() : 0);
      rowcsub67sog01.setSzCdStageType(stage.getCdStageType());
      rowcsub67sog01.setSzCdStageProgram(stage.getCdStageProgram());
      rowcsub67sog01.setSzNmStage(stage.getNmStage());
      rowcsub67sog01.setTsLastUpdate(stage.getDtLastUpdate());
      rowcsub67sog01.setSzCdStageReasonClosed(stage.getCdStageReasonClosed());

      if (stage.getTxtStageClosureCmnts() != null) {
        rowcsub67sog01.setSzTxtStageClosureCmnts(stage.getTxtStageClosureCmnts());
      } else {
        rowcsub67sog01.setSzTxtStageClosureCmnts(StringHelper.EMPTY_STRING);
      }

      rowcsub67sog01.setDtDtStageClose(DateHelper.toCastorDate(stage.getDtStageClose()));
      csub67so.setROWCSUB67SOG01(rowcsub67sog01);
      
      //STGAP00014341: Check to see if a reopen stage event exists then set the indicator to Y to show the
      //Date as modifiable
      String cdTaskCode = getTaskCode(rowcsub67sog01.getSzCdStage());
      
      Event event = eventDAO.findEventByIdStageAndEventTypeAndTaskIdEventDesc(csub67si.getUlIdStage(), CodesTables.CEVNTTYP_CRP, cdTaskCode);
      if(event != null){
        csub67so.setBIndReopenStageEvent(ArchitectureConstants.Y);
        AdoNewName adoNewName = adoNewNameDAO.findAdoNewNameByIdStage(csub67si.getUlIdStage());
        if(adoNewName != null){
          rowcsub67sog01.setDtDtStageClose(DateHelper.toCastorDate(adoNewName.getDtStageCloseTemp()));
        }
        StageReopen stageReopen = stageReopenDAO.findStageReopenByIdEvent(event.getIdEvent());
        if(stageReopen != null){
          csub67so.setSzCdStageReasonClosedFromReopen(stageReopen.getCdStageReasonClosed());
          csub67so.setSzTxtStageClosureCmntsFromReopen(stageReopen.getTxtStageClosureCmnts());
          csub67so.setDtDtStageCloseFromReopen(DateHelper.toCastorDate(stageReopen.getDtStageClose()));
        }
      }else{
        csub67so.setBIndReopenStageEvent(ArchitectureConstants.N);
      }
    }
    
    //STGAP00010749: Get name fields
    Map newNameMap = adoNewNameDAO.findNameByStage(csub67si.getUlIdStage());
    if(newNameMap!=null){
      csub67so.setTxtNmFirst((String)newNameMap.get("nmPersonFirst"));
      csub67so.setTxtNmLast((String)newNameMap.get("nmPersonLast"));
      csub67so.setTxtNmMiddle((String)newNameMap.get("nmPersonMiddle"));
    }
    
    // Call CheckStageEventStatus
    Event event = eventDAO.findEventByIdEvent(csub67si.getUlIdEvent());
    if (event != null) {
      ROWCSUB67SOG00 rowcsub67sog00 = new ROWCSUB67SOG00();
      rowcsub67sog00.setSzCdTask(event.getCdTask());
      rowcsub67sog00.setTsLastUpdate(event.getDtLastUpdate());
      rowcsub67sog00.setSzCdEventStatus(event.getCdEventStatus());
      rowcsub67sog00.setSzCdEventType(event.getCdEventType());
      rowcsub67sog00.setDtDtEventOccurred(DateHelper.toCastorDate(event.getDtEventOccurred()));
      rowcsub67sog00.setUlIdEvent(event.getIdEvent());
      rowcsub67sog00.setUlIdStage(event.getStage() != null ? event.getStage().getIdStage() : 0);
      rowcsub67sog00.setUlIdPerson(event.getPerson() != null ? event.getPerson().getIdPerson() : 0);
      rowcsub67sog00.setSzTxtEventDescr(event.getTxtEventDescr());
      csub67so.setROWCSUB67SOG00(rowcsub67sog00);
    }
    return csub67so;
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
