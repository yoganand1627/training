package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ExamDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ExamDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import javax.servlet.http.HttpServletRequest;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * ExamDetailConversation
 * 
 * @author Nandita Hegde , Mar 19,2006
 * @version 1.0
 * 
 * <pre>
 *                     Change History:
 *                     Date      User              Description
 *                     --------  ----------------  --------------------------------------------------
 *                     
 * </pre>
 */
@SuppressWarnings("serial")
public class ExamDetailConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "ExamDetailConversation";

  public static final String EXAM_DETAIL_PAGEMODE_KEY = "";

  private Person person = null;

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * display method for the Examination Detail page
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayExamDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayExamDetail_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    try {
      ExamDetailRetrieveSI examDetailRetrieveSI = populateExamDetailRetrieveSI(context);
      ExamDetailRetrieveSO examDetailRetrieveSO = person.retrieveExamDetail(examDetailRetrieveSI);
      state.setAttribute("ExamDetailRetrieveSO", examDetailRetrieveSO, request);
      state.setAttribute("EXAM_DETAIL_PAGEMODE_KEY", PageModeConstants.NEW, request);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Add new Examination details
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void addExamDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "addExamDetail_xa");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String examCat = ContextHelper.getStringSafe(request, "hdnExamCat");

    state.setAttribute("ExamDetailRetrieveSO", null, request);
    state.setAttribute("EXAM_CATEGORY", examCat, request);
    state.setAttribute("EXAM_DETAIL_PAGEMODE_KEY", PageModeConstants.NEW, request);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This method will populate ExamDetailRetrieveSI.
   * 
   * @param context
   */

  private ExamDetailRetrieveSI populateExamDetailRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateExamDetailRetrieveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    int idExamDetail = ContextHelper.getIntSafe(request, "hdnExamId");

    ExamDetailRetrieveSI examDetailRetrieveSI = new ExamDetailRetrieveSI();
    examDetailRetrieveSI.setIdPerson(GlobalData.getUlIdPerson(request));
    examDetailRetrieveSI.setIdExamDetail(idExamDetail);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return examDetailRetrieveSI;
  }

  /**
   * Save Examination Detail
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void saveExamDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveExamDetail_xa");
    performanceTrace.enterScope();

    ExamDetailSaveSI examDetail = populateExamDetailSaveSI(context);
    person.saveExamDetail(examDetail);

    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * This helper method is called by the save to populate the input object for the examination detail save service.
   * 
   * @param context
   *          GrndeExchangeContext
   * @return
   * @throws
   * 
   */

  public ExamDetailSaveSI populateExamDetailSaveSI(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateExamDetailSaveSI");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    String examCat = (String) state.getAttribute("EXAM_CATEGORY", request);
    String examDetailPageMode = (String) state.getAttribute("EXAM_DETAIL_PAGEMODE_KEY", request);
    ExamDetailRetrieveSO examDetailRetrieveSO = (ExamDetailRetrieveSO) state.getAttribute("ExamDetailRetrieveSO",
                                                                                          request);
    int idPerson = GlobalData.getUlIdPerson(request);
    ExamDetailSaveSI examDetail = new ExamDetailSaveSI();
    boolean isAddExamDetail = PageModeConstants.NEW.equals(examDetailPageMode);

    try {
      // Update existing exam detail - checking on either idExam or page mode key would be enough
      if (examDetailRetrieveSO != null && examDetailRetrieveSO.getIdExamDetail() > 0 && !isAddExamDetail) {
        examDetail.setDtDetailsLastUpdate(examDetailRetrieveSO.getDtDetailsLastUpdate());
        examDetail.setIndGED(examDetailRetrieveSO.getIndGed());
        examDetail.setIdPerson(examDetailRetrieveSO.getIdPerson());
        examDetail.setIdExamDetail(examDetailRetrieveSO.getIdExamDetail());
      }
      // New exam detail
      else {
        examDetail.setIdPerson(idPerson);
        if (GED_EXAM.equals(examCat)) {
          examDetail.setIndGED(ArchitectureConstants.Y);
        } else if (HS_EXAM.equals(examCat)) {
          examDetail.setIndGED(ArchitectureConstants.N);
        } else {
          // should throw error since parent page (Youth Detail) is supposed to set definite value for its hidden field
        }
      }
      // common data population for both new and update operation
      examDetail.setCdExamType(ContextHelper.getStringSafe(request, "cdExamType"));
      examDetail.setIndFirstAtmpt(CheckboxHelper.getCheckboxValue(request, "cbxFirstAtmpt"));
      examDetail.setIndPassed(CheckboxHelper.getCheckboxValue(request, "cbxPassed"));
      examDetail.setNbrScore(ContextHelper.getIntSafe(request, "txtScore"));
      examDetail.setDtExam(ContextHelper.getJavaDateSafe(request, "dtExam"));

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return examDetail;
  }

  protected void handleError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    switch (we.getErrorCode()) {
    case Messages.SQL_NOT_FOUND:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_MULT_INST:
      setErrorMessage(we.getErrorCode(), request);
      break;
    default:
      if (we.getErrorCode() != 0) {
        setErrorMessage(we.getErrorCode(), request);
      } else {
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      }
      break;
    }
  }

  public static final String GED_EXAM = "GED";

  public static final String HS_EXAM = "HS";

}