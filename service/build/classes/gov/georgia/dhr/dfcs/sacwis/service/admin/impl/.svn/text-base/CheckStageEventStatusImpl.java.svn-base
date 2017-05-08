package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN06UO;

public class CheckStageEventStatusImpl extends BaseServiceImpl implements CheckStageEventStatus {

  public static final int NEW_NBR_EVENT_STAT = 0;

  public static final int PROC_NBR_EVENT_STAT = 1;

  public static final int COMP_NBR_EVENT_STAT = 2;

  public static final int PEND_NBR_EVENT_STAT = 3;

  public static final int APRV_NBR_EVENT_STAT = 4;

  public static final String NEW_EVENT_STATUS = "NEW";

  public static final String PROCESS_EVENT_STATUS = "PROC";

  public static final String COMPLETE_EVENT_STATUS = "COMP";

  public static final String PENDING_EVENT_STATUS = "PEND";

  public static final String APPROVE_EVENT_STATUS = "APRV";
  
  public static final String CONTACTS_ARI = "3810";
  public static final String CONTACTS_ARF = "3910";
  public static final String CONTACTS_INT = "1010";
  public static final String CONTACTS_INV = "2180";
  public static final String CONTACTS_FPR = "7020";
  public static final String CONTACTS_DIV = "1510";
  public static final String CONTACTS_FSU = "4120";
  public static final String CONTACTS_FAD = "8060";
  public static final String CONTACTS_PAD = "9010";
  public static final String CONTACTS_ADO = "8520";
  public static final String CONTACTS_SUB = "3010";
  public static final String CONTACTS_PFC = "6530";
  
  public static final String ALLEGATION = "2170";
  public static final String INV_CONCLUSION = "2330";
  

  public static final Set<String> LEGAL_STATUS_AND_SERVICE_AUTHORIZATION_TASKS = new HashSet<String>(
          Arrays
                  .asList(new String[] {
                  "3020",
                  "9020",
                  "3520",
                  "5040",
                  "2100",
                  "2310",
                  "8530",
                  "7100",
                  "5640",
                  "6075",
                  "4190",
                  "3290",
                  "3310",
                  "3510",
                  "4370",
                  "5870",
                  "7230",
                  "2375",
                  "3050",
                  "8560",
                  "2385",
                  "3060",
                  "9060",
                  "8570",
                  "7240",
                  "5880",
                  "4380",
                  "9050",
                  "9530",
                  "9531",
                  "8085"}));
  
  private static final Set<String> CONTACTS_TASK_CODES = new HashSet<String>() {
    {
      add(CONTACTS_ARI);
      add(CONTACTS_ARF);
      add(CONTACTS_INT);
      add(CONTACTS_INV);
      add(CONTACTS_FPR);
      add(CONTACTS_DIV);
      add(CONTACTS_FSU);
      add(CONTACTS_FAD);
      add(CONTACTS_PAD);
      add(CONTACTS_ADO);
      add(CONTACTS_SUB);
      add(CONTACTS_PFC);
    }
  };
  
  private static final Set<String> ALLEGATION_TASK_CODES = new HashSet<String>() {
    {
      add(ALLEGATION);
    }
  };
  
  private static final Set<String> INV_CONCLUSION_TASK_CODES = new HashSet<String>() {
    {
      add(INV_CONCLUSION);
    }
  };
  
  private static final Set<String> CD_NF_SI_TASK_CODES = new HashSet<String>() {
    {
      add("6110"); // -- Child Death/Near Fatality / Serious Injury task code in INT
      add("6220"); // -- Child Death/Near Fatality / Serious Injury task code in INV
      add("6330"); // -- Child Death/Near Fatality / Serious Injury task code in FPR
      add("6440"); // -- Child Death/Near Fatality / Serious Injury task code in SUB
      add("6550"); // -- Child Death/Near Fatality / Serious Injury task code in ADO
      add("6660"); // -- Child Death/Near Fatality / Serious Injury task code in PFC    
    }
  };
  
  private EventDAO eventDAO = null;

  private StageDAO stageDAO = null;

  private TaskDAO taskDAO = null;

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageDAO(StageDAO stageDAO) {
    this.stageDAO = stageDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  public CCMN06UO status(CCMN06UI ccmn06ui) throws ServiceException {

    CCMN06UO ccmn06uo = new CCMN06UO();

    int sLowestStatus = APRV_NBR_EVENT_STAT;
    int sTempStatus = APRV_NBR_EVENT_STAT;

    // (BEGIN): Full row retrieval from Stage table
    // rc = cint21dQUERYdam(sqlca, pCINT21DInputRec, pCINT21DOutputRec);
    Stage stage = stageDAO.findStageByIdStage(ccmn06ui.getUlIdStage());

    if (stage == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

   //  STGAP00013826 - Contacts can now be added to closed stages as well now.  
    
    // If the number of rows returned exactly equals the page size, set the more
    // data indicator
    if ("Y".equals(stage.getIndStageClose())) {
      if (!LEGAL_STATUS_AND_SERVICE_AUTHORIZATION_TASKS.contains(ccmn06ui.getSzCdTask()) && !CONTACTS_TASK_CODES.contains(ccmn06ui.getSzCdTask())
                    &&  !CD_NF_SI_TASK_CODES.contains(ccmn06ui.getSzCdTask()) && !INV_CONCLUSION_TASK_CODES.contains(ccmn06ui.getSzCdTask()) && !ALLEGATION_TASK_CODES.contains(ccmn06ui.getSzCdTask()) ) {   //Added CDNFSI task codes so that a CNS event can be modified even if stage is closed
        throw new ServiceException(Messages.MSG_SYS_STAGE_CLOSED);
      }

    }
    if (ccmn06ui.getSzCdTask() != null) {
      Task task = taskDAO.findTaskByCdTask(ccmn06ui.getSzCdTask());

      if (task != null) {
        if (ServiceConstants.REQ_FUNC_CD_ADD.equals(ccmn06ui.getArchInputStruct().getCReqFuncCd())) {
          List<Event> eventList = eventDAO.findEventWithIdStageAndCdTask(ccmn06ui.getUlIdStage(),
                                                                         ccmn06ui.getSzCdTask());

          if (!eventList.isEmpty()) {
            if (!"1".equals(task.getIndTaskMultipleInstance())) {
              throw new ServiceException(Messages.MSG_SYS_MULT_INST);
            }

            if (!StringHelper.isValid(task.getCdTaskEventStatus())) {
              for (Iterator<Event> it = eventList.iterator(); it.hasNext();) {
                Event eventInfo = it.next();
                if (NEW_EVENT_STATUS.equals(eventInfo.getCdEventStatus())) {
                  sTempStatus = NEW_NBR_EVENT_STAT;
                } else if (PROCESS_EVENT_STATUS.equals(eventInfo.getCdEventStatus())) {
                  sTempStatus = PROC_NBR_EVENT_STAT;
                } else if (COMPLETE_EVENT_STATUS.equals(eventInfo.getCdEventStatus())) {
                  sTempStatus = COMP_NBR_EVENT_STAT;
                } else if (PENDING_EVENT_STATUS.equals(eventInfo.getCdEventStatus())) {
                  sTempStatus = PEND_NBR_EVENT_STAT;
                } else if (APPROVE_EVENT_STATUS.equals(eventInfo.getCdEventStatus())) {
                  sTempStatus = APRV_NBR_EVENT_STAT;
                }
              }

              if (sTempStatus < sLowestStatus) {
                sLowestStatus = sTempStatus;
              }

              // Re-set sTempStatus to zero.
              sTempStatus = NEW_NBR_EVENT_STAT;
              if (NEW_EVENT_STATUS.equals(task.getCdTaskEventStatus())) {
                sTempStatus = NEW_NBR_EVENT_STAT;
              } else if (PROCESS_EVENT_STATUS.equals(task.getCdTaskEventStatus())) {
                sTempStatus = PROC_NBR_EVENT_STAT;
              } else if (COMPLETE_EVENT_STATUS.equals(task.getCdTaskEventStatus())) {
                sTempStatus = COMP_NBR_EVENT_STAT;
              } else if (PENDING_EVENT_STATUS.equals(task.getCdTaskEventStatus())) {
                sTempStatus = PEND_NBR_EVENT_STAT;
              } else if (APPROVE_EVENT_STATUS.equals(task.getCdTaskEventStatus())) {
                sTempStatus = APRV_NBR_EVENT_STAT;
              }
              if (sLowestStatus < sTempStatus) {
                throw new ServiceException(Messages.MSG_SYS_EVENT_STS_MSMTCH);
              }
            }
          }
        }
      }
    }

    return ccmn06uo;
  }
}
