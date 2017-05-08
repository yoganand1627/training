package gov.georgia.dhr.dfcs.sacwis.web.document.cfp;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.DatabaseResultDetails;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginationResultBean;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.CannotDeleteCfpException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.DocumentTypeDB;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.ExceedQueueLimitException;
import gov.georgia.dhr.dfcs.sacwis.dao.document.cfp.StageDB;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.service.document.Cfp;

/** Handles page flow and calls necessary logic for CFP pages. */
public class CfpConversation extends BaseHiddenFieldStateConversation {
  public static final String TRACE_TAG = "CfpConversation";
  public static final String CANCEL_CFP = getUrl("cancelCfp");
  public static final String CASE_SUMMARY_STUB = getUrl("caseSummaryStub");
  public static final String CFP = getUrl("cfp");
  public static final String FORWARD_TO_CFP = getUrl("ForwardToCfp");
  public static final String QUEUE_STATUS = getUrl("queueStatus");
  public static final String SUBMIT_CFP = getUrl("submitCfp");

  public static final String URL_CASE_SUMMARY = "/workload/CaseSummary/displayCaseSummary";

  public static final String CONVERSATION_URL = "/workload/CfpConversation/";
  public static final String CFP_STAGE = "stage";
  public static final String CFP_DOCUMENT_TYPES = "documentTypes";
  public static final String CFP_OUTPUT_CODES = "outputCodes";
  public static final String QUEUE_STATUS_DATABEAN = "CfpConversation.QUEUE_STATUS_DATABEAN";

  public static final int QUEUE_STATUS_RESULTS_PER_PAGE = 20;

  public static final String CFP_BASE_FILE_LOCATION = GrndsConfiguration.getInstance().getProperty(
          ArchitectureConstants.GRNDS_DOMAIN, "cfp.base.file.location");

  protected static final Random random = new Random();

  private Cfp cfp;

  public void setCfp(Cfp cfp) {
    this.cfp = cfp;
  }

  /** Input: cfpId (request) Output: none Calls cfp.deleteCfpStatus Forwards to QueueStatus */
  public void cancelCfp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "cancelCfp_xa");

    HttpServletRequest request = context.getRequest();
    try {
      clearState(context);
      int cfpId = ContextHelper.getIntSafe(request, "cfpId");
      int userId = getUserID(request);

      cfp.deleteCfpStatus(cfpId, userId);

      GrndsTrace.msg(TRACE_TAG, 7, "canceled: " + cfpId);
    } catch (CannotDeleteCfpException e) {
      setErrorMessage(Messages.MSG_CFP_NO_CANCEL, request);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /** Input: none (request) Output: none Scaffolding to call into ForwardToCfp */
  public void caseSummaryStub_xa(GrndsExchangeContext context) {
    clearState(context);
  }

  /** Input: none (request) Output: none Scaffolding */
  public void blank_xa(GrndsExchangeContext context) {
    clearState(context);
  }

  /** Input: caseId, stageId (request) Output: none Scaffolding to call into cfp */
  public void forwardToCfp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "forwardToCfp_xa");

    HttpServletRequest request = context.getRequest();

    try {
      clearState(context);

      int caseId = ContextHelper.getIntSafe(request, "caseId");
      int stageId = ContextHelper.getIntSafe(request, "stageId");
      StageDB stageDB = cfp.getStageDB(caseId, stageId);

      GlobalData.setUlIdCase(caseId, request);
      GlobalData.setSzNmCase(stageDB.getCaseName(), request);

      GlobalData.setUlIdStage(stageId, request);
      GlobalData.setSzCdStage(stageDB.getStageCode(), request);
      GlobalData.setSzCdStageProgram(stageDB.getProgramName(), request);
      GlobalData.setSzCdStageType(stageDB.getStageType(), request);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Input: caseId, stageId [GlobalData] Output: stageDB, documentTypes (request) Calls cfp.getStageDB,
   * cfp.getDocumentOrder
   */
  public void cfp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "cfp_xa");

    HttpServletRequest request = context.getRequest();

    try {
      clearState(context);

      int caseId = GlobalData.getUlIdCase(request);
      int stageId = GlobalData.getUlIdStage(request);

      //!!! this only gets me decode(cd_stage) over what's in global data
      StageDB stageDB = cfp.getStageDB(caseId, stageId);

      DocumentTypeDB[] documentTypes = cfp.getDocumentOrder(stageDB.getProgramName(), stageDB.getStageCode(),
                                                                  stageDB.getStageType());

      request.setAttribute(CFP_STAGE, stageDB);
      request.setAttribute(CFP_DOCUMENT_TYPES, documentTypes);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Input: none Output: queuedCfpStatus, completedCfpStatus Calls cfp.getQueuedCfpStatus,
   * cfp.getCompletedCfpStatus
   */
  public void queueStatus_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "queueStatus_xa");

    HttpServletRequest request = context.getRequest();

    try {
      clearState(context);

      //!!! begin yuk: this is stuff that would go away with a ValueBeanHelper.populateDatabaseResultDetails()
      PaginationResultBean paginationResultBean = new PaginationResultBean();
      ValueBeanHelper.populateDefaultValues(request, paginationResultBean);
      DatabaseResultDetails details = paginationResultBean.getResultDetails();
      //!!! end yuk

      details.setResultsPerPage(QUEUE_STATUS_RESULTS_PER_PAGE);

      paginationResultBean = cfp.getQueueCfpStatus(getUserID(request), details);

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME, paginationResultBean);

      request.setAttribute(QUEUE_STATUS_DATABEAN, paginationResultBean.getResults());
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Input: caseId, stageId, outputCodes[] (request) Output: none Calls CaseFilePrint.submitCfp submitCfp.jsp is a
   * transitional page which opens up queueStatus.jsp and then refreshes to caseSummaryStub.jsp
   */
  public void submitCfp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "submitCfp_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    String[] outputCodesArray = request.getParameterValues("outputCode");
    request.setAttribute(CFP_OUTPUT_CODES, outputCodesArray);

    int caseId;
    int stageId;
    try {
      clearState(context);

      long number = Math.abs(random.nextLong());
      String shortFileName = Long.toString(number, 36);

      String destinationFileName = CFP_BASE_FILE_LOCATION + shortFileName + ".pdf";

      caseId = GlobalData.getUlIdCase(request);
      stageId = GlobalData.getUlIdStage(request);

      if ((outputCodesArray == null) ||
          (outputCodesArray.length == 0)) {
        setErrorMessage(Messages.MSG_CFP_SELECT_DOCS, request);

        forward(CFP, request, response);
        return;
      }
      String caseName = GlobalData.getSzNmCase(request);
      String jobName = "Case File Print for " + caseName + " (" + caseId + ")";

      try {
        CaseFilePrint.submitCfp(cfp, getUserID(request), getUserLogonID(request), jobName, destinationFileName, caseId,
                                stageId, outputCodesArray);
      } catch (ExceedQueueLimitException exceedQueueLimitException) {
        setErrorMessage(Messages.MSG_CFP_QUEUE_LIMIT, request);

        forward(CFP, request, response);
        return;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /** turns a string array into a Set */
  public static Set<String> arrayToSet(String[] array) {
    if (array == null) {
      return new HashSet<String>();
    }
    Set<String> hashSet = new HashSet<String>(array.length);
    hashSet.addAll(Arrays.asList(array));
    return hashSet;
  }

  /** Appends pageName to CONVERSATION_URL */
  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }
}
