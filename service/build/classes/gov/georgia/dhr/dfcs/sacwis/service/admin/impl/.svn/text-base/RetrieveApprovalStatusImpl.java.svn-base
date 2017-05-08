package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import static gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants.FND_YES;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalEventLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApprovalRejectionDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ApproversDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexStageDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EventDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.StageProgDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ApprovalRejection;
import gov.georgia.dhr.dfcs.sacwis.db.Approvers;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Event;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.Stage;
import gov.georgia.dhr.dfcs.sacwis.db.StageProg;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveApprovalStatus;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN34SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AprvlStageProg;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN34SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN45DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN56DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN57DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMNI3DO_ARRAY;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * <pre>
 *   Change History:
 *   Date         User                     Description
 *   ----------   -------------------      ---------------------------------------------------------           
 *   06/22/2011   hjbaptiste               SMS112897: Looking for Historical Primary Worker (HP) instead of 
 *                                         (PR) for case manager of investigation stage when handling the 
 *                                         Special Investigation page
 * </pre>
 * 
 */

public class RetrieveApprovalStatusImpl extends BaseServiceImpl implements RetrieveApprovalStatus {

  public static final String SP_NOT_APPL = "N";// StageProg
  public static final String SP_MANUAL = "W";
  public static final String SP_AUTOMATIC = "P";
  public static final String SP_CASECLOSE = "C";
  public static final String SP_CLOSEDIND = "1";

  public static final int APRV_MODIFY = 1;
  public static final int APRV_BROWSE = 2;

  private ApprovalDAO approvalDAO = null;
  private ApprovalEventLinkDAO approvalEventLinkDAO = null;
  private ApprovalRejectionDAO approvalRejectionDAO = null;
  private ApproversDAO approversDAO = null;
  private ComplexStageDAO complexStageDAO = null;
  private EmployeeDAO employeeDAO = null;
  private EventDAO eventDAO = null;
  private StageProgDAO stageProgDAO = null;
  private TaskDAO taskDAO = null;

  public void setApprovalDAO(ApprovalDAO approvalDAO) {
    this.approvalDAO = approvalDAO;
  }

  public void setApprovalEventLinkDAO(ApprovalEventLinkDAO approvalEventLinkDAO) {
    this.approvalEventLinkDAO = approvalEventLinkDAO;
  }

  public void setApprovalRejectionDAO(ApprovalRejectionDAO approvalRejectionDAO) {
    this.approvalRejectionDAO = approvalRejectionDAO;
  }

  public void setApproversDAO(ApproversDAO approversDAO) {
    this.approversDAO = approversDAO;
  }

  public void setComplexStageDAO(ComplexStageDAO complexStageDAO) {
    this.complexStageDAO = complexStageDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEventDAO(EventDAO eventDAO) {
    this.eventDAO = eventDAO;
  }

  public void setStageProgDAO(StageProgDAO stageProgDAO) {
    this.stageProgDAO = stageProgDAO;
  }

  public void setTaskDAO(TaskDAO taskDAO) {
    this.taskDAO = taskDAO;
  }

  private final Set<String> closeTasks = new HashSet<String>(Arrays.asList(new String[] { "2330", "4110", "3270", "8770",
                                                                                         "2335", "9260","2070","7010"}));

  private final Set<String> taskMap = new HashSet<String>(Arrays.asList(new String[] {"3020", "9020", "3520", "5040",
                                                                                      "2100", "2310", "8530", "7100",
                                                                                      "5640", "6075", "4190", "3290",
                                                                                      "3310", "3510"}));

  private final Set<String> spclInvTasks = new HashSet<String>(Arrays.asList(new String[] { "2265", "2270"}));
  /** Description: Retrieve Approval Status */
  //
  public CCMN34SO retrieveApprovalStatus(CCMN34SI ccmn34si) throws ServiceException {

    CCMN34SO ccmn34so = new CCMN34SO();
    AprvlStageProg aprvlStageProg = new AprvlStageProg();
    ROWCCMN57DO_ARRAY rowccmn57do_array = new ROWCCMN57DO_ARRAY();
    ccmn34so.setAprvlStageProg(aprvlStageProg);
    ccmn34so.setROWCCMN57DO_ARRAY(rowccmn57do_array);

    int idTodo = ccmn34si.getLdIdTodo();
    int idEvent = ccmn34si.getUlIdEvent();

    Integer scenario = (idTodo > 0) ? APRV_MODIFY : APRV_BROWSE;
    Integer idApproval;
    if (scenario == APRV_MODIFY) {
      // rc = CallCCMN54D(ccmn34si, ccmn34so);
      Approvers approvers = approversDAO.findApproversByIdTodo(idTodo);
      if (approvers == null) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
      idApproval = approvers.getApproval().getIdApproval();
    } else {
      // scenario == APRV_BROWSE
      // rc = Ccmn05u.CallCCMN55D(ccmn34si, ccmn34sos);
      idApproval = approvalEventLinkDAO.findApprovalEventLinkByIdEvent(idEvent);
      if (idApproval == null) {
        idApproval = idEvent;
      }
    }

    if (idApproval == null || idApproval == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ccmn34so.setUlIdApproval(idApproval != null ? idApproval : 0);

    // CallCCMN56D
    ccmn34so.setROWCCMN56DO_ARRAY(retrieveROWCCMN56DO_ARRAY(idApproval, scenario));

    if (scenario == APRV_MODIFY) {
      // rc = CallCCMN57D(ccmn34si, ccmn34so, pServiceStatus);
      List<Map> listApEvLk = approvalEventLinkDAO.findRelatedFunctionalEventsForGivenApproval(idApproval);
      if (listApEvLk == null || listApEvLk.isEmpty() || listApEvLk.size() == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }

      for (Iterator<Map> itm = listApEvLk.iterator(); itm.hasNext();) {
        Map m = itm.next();
        ROWCCMN57DO rowccmn57do = new ROWCCMN57DO();
        int idEvent1 = (Integer) m.get("idEvent");
        rowccmn57do.setUlIdEvent(idEvent1);
        rowccmn57do.setSzCdTask((String) m.get("cdTask"));
        rowccmn57do_array.addROWCCMN57DO(rowccmn57do);
      }
      ccmn34so.setROWCCMN57DO_ARRAY(rowccmn57do_array); // reset
      if (rowccmn57do_array.getROWCCMN57DOCount() == 1) {
        // rc = CallCCMN82D(ccmn34si, ccmn34so, pServiceStatus);
        Task task = taskDAO.findTaskByCdTask(ccmn34so.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask());
        if (task == null) {
          throw new ServiceException(Messages.SQL_NOT_FOUND);
        }
        ccmn34so.setSzCdTaskTopWindow(task.getCdTaskTopWindow());
      }
    }

    // Default is not what we expect so an error will not be returned here.
    // rc = CallCCMN58D(ccmn34si, ccmn34so, pServiceStatus);
    Map apvl = approvalDAO.findApprovalInfoForHeader(idApproval);
    if (apvl == null || apvl.isEmpty()) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ccmn34so.setSzTxtApprovalTopic((String) apvl.get("txtApprovalTopic"));

    if (scenario == APRV_MODIFY) {
      doAprvModify(idApproval, ccmn34so);
    }

    // rc = CallCCMNI3D(ccmn34si, ccmn34so, pServiceStatus);
    int idCase1 = ccmn34si.getUlIdCase();
    if (idCase1 == 0) {
      idCase1 = ccmn34so.getUlIdCase();
    }
    int idStage1 = ccmn34si.getUlIdStage();
    if (idStage1 == 0) {
      idStage1 = ccmn34so.getUlIdStage();
    }
    
    /*
    List<Map> listAr = approvalRejectionDAO.findApprovalRejectionByIdCaseIdStageAndIdApproval(idCase1, idStage1, idApproval);
    if (listAr == null) { // not enough since MODIFY2 passed this but actually listAr is empty
      //    if (listAr == null || listAr.isEmpty() || listAr.size() == 0) { 
      throw new ServiceException();
    }

    ROWCCMNI3DO_ARRAY rowccmn13do_array = new ROWCCMNI3DO_ARRAY();
    for (Iterator<Map> itar = listAr.iterator(); itar.hasNext();) {
      Map m = itar.next();
      ROWCCMNI3DO rowccmn13do = new ROWCCMNI3DO();
      rowccmn13do.setSzNMRejector((String) m.get("nmPersonFull"));
      rowccmn13do.setSzTxtApproversComments((String) m.get("txtApproversCmnts"));
      int idApprovalRejection = (Integer) m.get("idApprovalRejection");
      rowccmn13do.setUlIdApprovalRejection(idApprovalRejection);
      rowccmn13do.setDtDtRejection(DateHelper.toCastorDate((Date) m.get("dtRejection")));
      int idPerson = (Integer) m.get("idPerson");
      rowccmn13do.setUlIdRejector(idPerson);
      rowccmn13do.setUlIdApproval((Integer) m.get("idApproval"));
      rowccmn13do_array.addROWCCMNI3DO(rowccmn13do);
    }
    rowccmn13do_array.setUlRowQty(listAr.size());
    ccmn34so.setROWCCMNI3DO_ARRAY(rowccmn13do_array);
    */
    
    List<ApprovalRejection> rejections = approvalRejectionDAO.findApprovalRejectionByIdEvent(idEvent);
    
    ROWCCMNI3DO_ARRAY rowccmn13do_array = new ROWCCMNI3DO_ARRAY();
    int rowQty = 0;
    if(rejections != null && !rejections.isEmpty()) {
      rowQty = rejections.size();
      for(ApprovalRejection rejection : rejections) {
        ROWCCMNI3DO rowccmn13do = new ROWCCMNI3DO();
        Person rejector = rejection.getPerson();
        rowccmn13do.setSzNMRejector(rejector.getNmPersonFull());
        rowccmn13do.setSzTxtApproversComments(rejection.getTxtApproversCmnts());
        rowccmn13do.setUlIdApprovalRejection(rejection.getIdApprovalRejection());
        rowccmn13do.setDtDtRejection(DateHelper.toCastorDate(rejection.getDtRejection()));
        rowccmn13do.setUlIdRejector(rejector.getIdPerson());
        rowccmn13do.setUlIdApproval(rejection.getApproval().getIdApproval());
        rowccmn13do_array.addROWCCMNI3DO(rowccmn13do);
      }
    }
    rowccmn13do_array.setUlRowQty(rowQty);
    ccmn34so.setROWCCMNI3DO_ARRAY(rowccmn13do_array);

    aprvlStageProg.setCWCDCdStageProgressMode(SP_NOT_APPL);

    /*
    * Determine whether or not Stage Progression applies based upon related
    * events cd_tasks and declared local conclusion tasks array
    */

    boolean bSprog = false;
    for (int iCount1 = 0; iCount1 < ccmn34so.getROWCCMN57DO_ARRAY().getROWCCMN57DOCount() && (!bSprog); iCount1++) {
      if (closeTasks.contains(ccmn34so.getROWCCMN57DO_ARRAY().getROWCCMN57DO(iCount1).getSzCdTask())) {
        bSprog = true;
      }
    }

    if (bSprog) {
      //rc = Ccmn02u.CallCCMNB8D(ccmn34si, ccmn34so, pServiceStatus);
      List<StageProg> listsp = stageProgDAO.findStageProgByCdStageProgStageCdStageProgProgramCdStageProgRsnClose(
              ccmn34so.getSzCdStage(),
              ccmn34so.getAprvlStageProg().getSzCdStageProgram(),
              ccmn34so.getAprvlStageProg().getSzCdStageReasonClosed());

      if (listsp != null && listsp.size() > 0) {
        if (listsp.size() == 1) {
          StageProg sp = listsp.get(0);
          ccmn34so.getAprvlStageProg().setSzCdStageOpen(sp.getCdStageProgOpen());
          // If the stage is Intake and the stage to open is Foster Care Child or
          // the stage to open is Diversion, we need to to do a manual stage progression
          if (CodesTables.CSTAGES_DIV.equals(sp.getCdStageProgOpen()) || 
                          (CodesTables.CSTAGES_INT.equals(ccmn34so.getSzCdStage()) && 
                                          CodesTables.CSTAGES_SUB.equals(sp.getCdStageProgOpen()))){
            ccmn34so.getAprvlStageProg().setCWCDCdStageProgressMode(SP_MANUAL);
          }
          else if (SP_CLOSEDIND.equals(sp.getIndStageProgClose())) {
            ccmn34so.getAprvlStageProg().setCWCDCdStageProgressMode(SP_AUTOMATIC);
          } else {
            ccmn34so.getAprvlStageProg().setCWCDCdStageProgressMode(SP_CASECLOSE);
          }
        } // else size() > 1
        else {
          ccmn34so.getAprvlStageProg().setCWCDCdStageProgressMode(SP_MANUAL);
        }
      } // end if listsp != null && listsp.size() > 1
    } // end if (bProg)
    Date now = new Date();
    ccmn34so.setDtWCDDtSystemDate(DateHelper.toCastorDate(now));
    ccmn34so.setTmWCDTmSystemTime(DateHelper.toString(now, DateHelper.AM_PM_TIME_FORMAT));

    return ccmn34so;
  }

  private ROWCCMN56DO_ARRAY retrieveROWCCMN56DO_ARRAY(int idApproval, Integer scenario) {
    // Default is not what we expect so an error will not be returned  here.
    // rc = (ccmn34si, ccmn34so);
    List<Approvers> listAprvs = approversDAO.findApproversByIdApproval(idApproval);
    if (listAprvs == null || listAprvs.isEmpty() || listAprvs.size() == 0) {
      throw new ServiceException(Messages.MSG_NO_ROWS_RETURNED);
    }
    ROWCCMN56DO_ARRAY rowccmn56do_array = new ROWCCMN56DO_ARRAY();
    for (Iterator<Approvers> it = listAprvs.iterator(); it.hasNext();) {
      Approvers ap = it.next();
      ROWCCMN56DO rowccmn56do = new ROWCCMN56DO();
      rowccmn56do.setDtDtApproversDetermination(DateHelper.toCastorDate(ap.getDtApproversDetermination()));
      rowccmn56do.setTmScrTmApprovalTime(DateHelper.toString(ap.getDtApproversDetermination(),
                                                             DateHelper.AM_PM_TIME_FORMAT));
      Person person = ap.getPerson();
      rowccmn56do.setUlIdPerson(person.getIdPerson());
      rowccmn56do.setSzNmPersonFull(person.getNmPersonFull());
      String cdApproversStatus = ap.getCdApproversStatus();
      rowccmn56do.setSzCdApproversStatus(cdApproversStatus);
      rowccmn56do.setSzTxtApproversComments(ap.getTxtApproversCmnts());
      rowccmn56do.setLdIdTodo(ap.getTodo().getIdTodo());
      rowccmn56do.setUlIdApprovers(ap.getIdApprovers());
      rowccmn56do.setTsLastUpdate(ap.getDtLastUpdate());
      rowccmn56do_array.addROWCCMN56DO(rowccmn56do);

      if (scenario == APRV_MODIFY) {
        if (cdApproversStatus != null && cdApproversStatus.length() > 0) {
          if (CodesTables.CAPPDESG_REJT.equals(cdApproversStatus) ||
              CodesTables.CAPPDESG_INVD.equals(cdApproversStatus)) {
            scenario = APRV_BROWSE;
          }
        }
      }
    } //

    return rowccmn56do_array;
  }

  /*
  * helper method for processing when AprvModify status
  */
  private void doAprvModify(int idApproval, CCMN34SO ccmn34so) throws ServiceException {
    // rc = CallCCMN59D(ccmn34si, ccmn34so, dtDtStageClose2, IndStageClose, pServiceStatus);

    Date dtDtStageClose2 = null;
    String indStageClose = null;

    Event event = eventDAO.findApprovalStatus(idApproval);
    if (event == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    Stage stage = event.getStage();
    ccmn34so.setUlIdStage(stage.getIdStage() != null ? stage.getIdStage() : 0);
    ccmn34so.setUlIdCase(event.getCapsCase() != null ? event.getCapsCase().getIdCase() : 0);
    ccmn34so.setSzCdStage(stage.getCdStage());
    ccmn34so.setSzNmStage(stage.getNmStage());
    ccmn34so.getAprvlStageProg().setSzCdStageProgram(stage.getCdStageProgram());
    ccmn34so.getAprvlStageProg().setSzCdStageReasonClosed(stage.getCdStageReasonClosed());

    if (FND_YES.equals(stage.getIndStageClose())) {
      dtDtStageClose2 = stage.getDtStageClose();
      indStageClose = stage.getIndStageClose().substring(0, 1);
    }

    // rc = CallCINV51D(ccmn34si, ccmn34so, dtDtStageClose2, IndStageClose, pServiceStatus);

    String cdRole = CodesTables.CROLEALL_PR;
    String cdTask = ccmn34so.getROWCCMN57DO_ARRAY().getROWCCMN57DO(0).getSzCdTask();
    if (FND_YES.equals(indStageClose)) {
      if (cdTask != null && taskMap.contains(cdTask)) {
        if (dtDtStageClose2 != null) {
          cdRole = CodesTables.CROLEALL_HP;
        }
      }
    }

    Calendar gc = Calendar.getInstance();
    int nYear = 0;
    if (!DateHelper.isNull(DateHelper.toCastorDate(dtDtStageClose2))) {
      gc.setTime(dtDtStageClose2);
      nYear = gc.get(Calendar.YEAR);
    }
    if (FND_YES.equals(stage.getIndStageClose()) &&
        CodesTables.CSTGTYPE_INT.equals(ccmn34so.getSzCdStage()) && nYear != 0) {
      cdRole = CodesTables.CROLEALL_HP;
    }

    if (FND_YES.equals(stage.getIndStageClose()) && spclInvTasks.contains(cdTask)) {
      cdRole = CodesTables.CROLEALL_HP;
    }
    Integer idPerson = complexStageDAO.findPrimaryWorker(stage.getIdStage(), cdRole);
    if (idPerson == null || idPerson == 0) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ccmn34so.setUlIdPerson(idPerson != null ? idPerson : 0);

    // rc = CallCSEC01D(ccmn34si, ccmn34so, pServiceStatus);
    /*
    Employee emp = employeeDAO.findEmployeeByIdPersonAndIndNamePrimary(idPerson);
    if (emp == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    String nmFull = FormattingHelper.formatFullName(emp.getNmEmployeeFirst(), emp.getNmEmployeeMiddle(),
                                                    emp.getNmEmployeeLast());
    */
    
    //-- the following code is problematic if the Employee has no NAME record
    //-- with IND_NAME_PRIMARY='Y' and DT_NAME_END_DATE='12/31/4712'
    //Object[] emp = employeeDAO.findEmployeeInfoByIdPerson(idPerson);
    //if(emp == null){
    //  throw new ServiceException(Messages.SQL_NOT_FOUND);
    //}
    //String firstName = (String) emp[44];
    //String midName = (String) emp[45];
    //String lastName = (String) emp[46];
    
    //-- SIR STGAP00004790
    //-- above logic replaced with this:
    String nmFull = "";
    Employee primaryWorker = employeeDAO.findEmployeeByIdPerson(idPerson);
    if(primaryWorker != null) {
      nmFull = FormattingHelper.formatFullName(primaryWorker.getNmEmployeeFirst(),
                                               primaryWorker.getNmEmployeeMiddle(),
                                               primaryWorker.getNmEmployeeLast());
    }
    ccmn34so.setSzNmPersonFull(nmFull);

    // rc = Ccmn01u.CallCCMN45D(ccmn34si, ccmn34so, pServiceStatus);
    Event evt = eventDAO.findEventByIdEvent(idApproval);
    if (evt == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }

    ROWCCMN45DO rowccmn45do = new ROWCCMN45DO();
    rowccmn45do.setSzCdEventType(evt.getCdEventType());
    rowccmn45do.setSzTxtEventDescr(evt.getTxtEventDescr());
    rowccmn45do.setSzCdTask(evt.getCdTask());
    rowccmn45do.setSzCdEventStatus(evt.getCdEventStatus());

    rowccmn45do.setUlIdEvent(evt.getIdEvent() != null ? evt.getIdEvent() : 0);
    rowccmn45do.setUlIdStage(evt.getStage() != null ? evt.getStage().getIdStage() : 0);
    rowccmn45do.setUlIdPerson(evt.getPerson() != null ? evt.getPerson().getIdPerson() : 0);
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(evt.getDtEventOccurred()));
    rowccmn45do.setTsLastUpdate(evt.getDtLastUpdate());

    ccmn34so.setROWCCMN45DO(rowccmn45do);
  }
}