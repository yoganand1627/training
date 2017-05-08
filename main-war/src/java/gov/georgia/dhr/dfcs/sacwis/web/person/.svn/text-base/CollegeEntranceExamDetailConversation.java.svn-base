package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.person.RetrieveCollegeEntranceExam;
import gov.georgia.dhr.dfcs.sacwis.service.person.SaveCollegeEntranceExam;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CollegeEntranceExamRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CollegeEntranceExamSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CollegeEntranceExamRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class CollegeEntranceExamDetailConversation extends BaseHiddenFieldStateConversation {
  public static final String CEED_INFORMATION = "casemgmt/CollegeEntranceExam/CollegeEntranceExamDetailConversation";

  public static final String COLLEGE_ENTRANCE_EXAM_INFORMATION = "person/CollegeEntranceExam/CollegeEntranceExamConversation";

  public static final String SAVE_ON_COLLEGE_ENTRANCE_EXAM = "btnSave";

  public static final String DT_ACT_TAKEN = "dtActTestTaken";

  public static final String NBR_ACT_ENGLISH = "nbrActEnglishScore";

  public static final String NBR_ACT_MATH = "nbrActMathScore";

  public static final String NBR_ACT_READING = "nbrActReadingScore";

  public static final String NBR_ACT_SCIENCE = "nbrActScienceScore";

  public static final String NBR_ACT_WRITING = "nbrActWritingScore";

  public static final String NBR_ACT_TOTAL = "nbrActTotalScore";

  public static final String DT_SAT_TAKEN = "dtSatTestTaken";

  public static final String NBR_SAT_MATH = "nbrSatMathScore";

  public static final String NBR_SAT_VERBAL = "nbrSatVerbalScore";

  public static final String NBR_SAT_WRITING = "nbrSatWritingScore";

  public static final String NBR_SAT_TOTAL = "nbrSatTotalScore";

  public static final String EXAM_TYPE_SAT = "SAT";

  public static final String EXAM_TYPE_ACT = "ACT";

  public static final String ID_COLLEGE_EXAM = "hdnIdCollegeExam";

  public static final String ID_PERSON = "hdnPersonId";

  private SaveCollegeEntranceExam saveCollegeEntranceExam;

  private RetrieveCollegeEntranceExam retrieveCollegeEntranceExam;

  public void setSaveCollegeEntranceExam(SaveCollegeEntranceExam saveCollegeEntranceExam) {
    this.saveCollegeEntranceExam = saveCollegeEntranceExam;
  }

  public void setRetrieveCollegeEntranceExam(RetrieveCollegeEntranceExam retrieveCollegeEntranceExam) {
    this.retrieveCollegeEntranceExam = retrieveCollegeEntranceExam;
  }

  public void displayCollegeEntranceExam_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayCollegeEntranceExam_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    int idCollegeExam = (ContextHelper.getIntSafe(request, "hdnCeExamId"));
    CollegeEntranceExamRetrieveSI retrieveSI = new CollegeEntranceExamRetrieveSI();   
    String pageMode = PageMode.getPageMode(request);
    state.removeAllAttributes(request);
    try {
      retrieveSI.setIdCollegeExam(idCollegeExam);
      CollegeEntranceExamRetrieveSO retrieveSO = new CollegeEntranceExamRetrieveSO();
      retrieveSO = retrieveCollegeEntranceExam.retrieveCollegeEntranceExamDetail(retrieveSI);
      state.setAttribute("RETRIEVESO", retrieveSO, request);
      PageMode.setPageMode(pageMode, request);
      
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public void addCollegeEntranceExam_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addCollegeEntranceExam_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      PageMode.setPageMode(PageModeConstants.NEW, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /*
   * The save method saves the information entered by the user and changes the event status from NEW to PROC.
   */
  public void saveCollegeEntranceExam_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveCollegeEntranceExam_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      CollegeEntranceExamSaveSI collegeExamSave = this.populateCollegeEntranceExam_Save(context);
      CollegeEntranceExamSaveSI saveCEExam = saveCollegeEntranceExam.saveCollegeEntranceExam(collegeExamSave);

      // Set the PageMode to MODIFY in case in was ADD before the save.
      PageMode.setPageMode(PageModeConstants.MODIFY, request);

    } catch (ServiceException wtc) {
      handleError(wtc, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private CollegeEntranceExamSaveSI populateCollegeEntranceExam_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCollegeEntranceExam_Save()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    CollegeEntranceExamSaveSI saveCEExam = new CollegeEntranceExamSaveSI();

    if (ContextHelper.getIntSafe(request, ID_COLLEGE_EXAM) != 0) {
      saveCEExam.setIdCollegeExam(ContextHelper.getIntSafe(request, ID_COLLEGE_EXAM));
    }

    saveCEExam.setIdPerson(ContextHelper.getIntSafe(request, ID_PERSON));

    if (!"".equals(request.getParameter(DT_ACT_TAKEN))) {
      saveCEExam.setCdExamType(EXAM_TYPE_ACT);
      saveCEExam.setDtTestTaken(ContextHelper.getJavaDateSafe(request, DT_ACT_TAKEN));
      saveCEExam.setNbrEnglishScore(ContextHelper.getIntSafe(request, NBR_ACT_ENGLISH));
      saveCEExam.setNbrMathScore(ContextHelper.getIntSafe(request, NBR_ACT_MATH));
      saveCEExam.setNbrReadingScore(ContextHelper.getIntSafe(request, NBR_ACT_READING));
      saveCEExam.setNbrScienceScore(ContextHelper.getIntSafe(request, NBR_ACT_SCIENCE));
      saveCEExam.setNbrWritingScore(ContextHelper.getIntSafe(request, NBR_ACT_WRITING));
      saveCEExam.setNbrTotalScore(ContextHelper.getIntSafe(request, NBR_ACT_TOTAL));
    } else if (!"".equals(request.getParameter(DT_SAT_TAKEN))) {
      saveCEExam.setDtTestTaken(ContextHelper.getJavaDateSafe(request, DT_SAT_TAKEN));
      saveCEExam.setCdExamType(EXAM_TYPE_SAT);
      saveCEExam.setNbrMathScore(ContextHelper.getIntSafe(request, NBR_SAT_MATH));
      saveCEExam.setNbrVerbalScore(ContextHelper.getIntSafe(request, NBR_SAT_VERBAL));
      saveCEExam.setNbrWritingScore(ContextHelper.getIntSafe(request, NBR_SAT_WRITING));
      saveCEExam.setNbrTotalScore(ContextHelper.getIntSafe(request, NBR_SAT_TOTAL));
    }
    return saveCEExam;
  }

  private void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    String errorMessage = null;
    switch (we.getErrorCode()) {
    case Messages.MSG_CMN_OVERLAP_ADD:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_OVERLAP_ADD);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_CMN_ON_CALL_TOO_MANY:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_ON_CALL_TOO_MANY);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_SYS_STAGE_CLOSED:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_SAVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_SAVE_FAIL);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_SYS_MULT_INST:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    case Messages.MSG_DATABASE_RETRIEVE_FAIL:
      errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      setErrorMessage(errorMessage, COLLEGE_ENTRANCE_EXAM_INFORMATION, request);
      break;
    default:
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
      break;
    }
  }
}