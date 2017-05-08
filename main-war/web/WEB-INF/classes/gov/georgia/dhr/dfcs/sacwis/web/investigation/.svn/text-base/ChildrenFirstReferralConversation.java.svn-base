package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.investigation.Investigation;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ChildrenFirstReferralSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ChildrenFirstReferralSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used to display Children First Referral Page
 * @author ashwini.rege
 *
 * Change History:
 *  Date        User              Description
 * --------    ----------------  ----------------------------------------------------------------
 *  02/08/2010   arege            STGAP00015749: Added code for the new field Release on File.
 *  03/04/2010   arege            SMS#46940: Child First Referral - Error message displays after clicking the Save button
 *  03/10/2010   arege            SMS#47646: Resolved System Error while deleting Children First Referral 
 *  03/11/2010   arege            SMS#47644: Changed the from generic error message to MSG_CFR_COMP_NOT_SAVED 
 *
 */
@SuppressWarnings("serial")
public class ChildrenFirstReferralConversation extends BaseHiddenFieldStateConversation {
  /**
   * Declare any static constants. ******************************************************************************
   */

  public static final String ON = "on";

  public static final String DISPLAY_CHILDREN_FIRST_REF = "/investigation/ChildrenFirstReferral/displayChildrenFirstReferral";

  private Investigation investigation;

  public void setInvestigation(Investigation investigation) {
    this.investigation = investigation;
  }

  /**
   * Display method for the Children 1st Referral page
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayChildrenFirstReferral_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayChildrenFirstReferral_xa ()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    try {
      request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      state.removeAllAttributes(request);
      ChildrenFirstReferralRetrieveSI childrenFirstReferralRetrieveSI = populate_RetrieveSI(context);
      ChildrenFirstReferralRetrieveSO childrenFirstReferralRetrieveSO = new ChildrenFirstReferralRetrieveSO();

      // Call the Retrieve Service.
      childrenFirstReferralRetrieveSO = investigation.retrieveChildrenFirstReferral(childrenFirstReferralRetrieveSI);
    
      state.setAttribute("ChildrenFirstReferralRetrieveSO", childrenFirstReferralRetrieveSO, request);

      // Set Page Mode
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
      boolean hasStageAccess = CaseUtility.hasStageAccess(userProfile.getUserID(), ulIdStage);
      if (!hasStageAccess) {
        pageMode = PageModeConstants.VIEW;
      }

      PageMode.setPageMode(pageMode, request);
    } catch (Exception e) {
      e.printStackTrace();
      GrndsTrace.msg(TRACE_TAG, 7, "Exception in conversation" + e.getMessage());
      handleException(e, context, "displayChildrenFirstReferral_xa()");
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Save Children 1st Referral
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void saveChildrenFirstReferral_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveChildrenFirstReferral_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    try {
      ChildrenFirstReferralSaveSI childrenFirstReferralSaveSI = new ChildrenFirstReferralSaveSI();
      populate_SaveSI(context, childrenFirstReferralSaveSI);
      ChildrenFirstReferralSaveSO childrenFirstReferralSaveSO = investigation
                                                                             .saveChildrenFirstReferral(childrenFirstReferralSaveSI);
      GlobalData.setUlIdEvent(childrenFirstReferralSaveSO.getIdEvent(), request);
      GlobalData.setSzCdTask(childrenFirstReferralSaveSO.getCdTask(), request);
    } catch (ServiceException we) {
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CFR_COMP_NOT_SAVED:
        setErrorMessage(errorCode, request);
        break;
      // otherwise, we don't know what to do -- handle it as a severe exception
      default:
        processSevereException(context, we);
      }
    }  catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "saveChildrenFirstReferral_xa()");
    }
    performanceTrace.exitScope();
  }

  /**
   * Delete Children 1st Referral
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void deleteChildrenFirstReferral_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".deleteChildrenFirstReferral_xa()");
    performanceTrace.enterScope();

    try {
      ChildrenFirstReferralSaveSI cfrDeleteSI = new ChildrenFirstReferralSaveSI();
      this.populate_SaveSI(context, cfrDeleteSI);

      cfrDeleteSI.setCdReqFuncCd(ServiceConstants.REQ_FUNC_CD_DELETE);
      ChildrenFirstReferralSaveSO childrenFirstReferralSaveSO = investigation.saveChildrenFirstReferral(cfrDeleteSI);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "deleteChildrenFirstReferral_xa()");
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  private ChildrenFirstReferralRetrieveSI populate_RetrieveSI(GrndsExchangeContext context) throws MarshalException,
                                                                                           ValidationException,
                                                                                           DataFormatException {
    HttpServletRequest request = context.getRequest();
    ChildrenFirstReferralRetrieveSI childrenFirstReferralRetrieveSI = new ChildrenFirstReferralRetrieveSI();
    childrenFirstReferralRetrieveSI.setUlIdCase(GlobalData.getUlIdCase(request));
    childrenFirstReferralRetrieveSI.setUlIdStage(GlobalData.getUlIdStage(request));
    childrenFirstReferralRetrieveSI.setUlIdChild(GlobalData.getUlIdPerson(request));
    childrenFirstReferralRetrieveSI.setCdStage(GlobalData.getSzCdStage(request));
    childrenFirstReferralRetrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));

    return childrenFirstReferralRetrieveSI;
  }

  private void populate_SaveSI(GrndsExchangeContext context, ChildrenFirstReferralSaveSI childrenFirstReferralSaveSI) {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    ChildrenFirstReferralRetrieveSO childFirstRefRetSO = (ChildrenFirstReferralRetrieveSO) state
                                                                                                .getAttribute(
                                                                                                              "ChildrenFirstReferralRetrieveSO",
                                                                                                              request);
    ROWCCMN01UIG00 event = new ROWCCMN01UIG00();

    // Get the current event status.
    String eventStatus = StringHelper.EMPTY_STRING;
    if (childFirstRefRetSO != null && childFirstRefRetSO.getRowccmn45do() != null) {
      eventStatus = childFirstRefRetSO.getRowccmn45do().getSzCdEventStatus();
    }

    // Check if the complete check box is checked OR the current status of the event is COMP. This is checked
    // because the Save button is available even in COMP status.
    if (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "cbxReferComp"))
        || CodesTables.CEVTSTAT_COMP.equals(eventStatus)) {
      event.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
    } else {
      event.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    }

    // Set the Event Object
    event.setSzCdEventType(CodesTables.CEVNTTYP_CFR);
    event.setSzCdTask(GlobalData.getSzCdTask(request));

    org.exolab.castor.types.Date dtDtEventOccured = new org.exolab.castor.types.Date();
   //SMS#47646
    Integer idChildReferred = null;
    if (childFirstRefRetSO != null && childFirstRefRetSO.getRowccmn45do() != null) {
      dtDtEventOccured = childFirstRefRetSO.getRowccmn45do().getDtDtEventOccurred();
      idChildReferred = childFirstRefRetSO.getIdChildReferred();
    }
    if (DateHelper.isNull(dtDtEventOccured)) {
      event.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    } else {
      event.setDtDtEventOccurred(dtDtEventOccured);
    }    
    if (idChildReferred != null) {
      childrenFirstReferralSaveSI.setIdChildReferred(idChildReferred);
    } else {
      childrenFirstReferralSaveSI.setIdChildReferred(GlobalData.getUlIdPerson(request));
    }    
    event.setUlIdEvent(GlobalData.getUlIdEvent(request));
    event.setSzTxtEventDescr("Children First Referral");
    event.setSzCdTask(ContextHelper.getStringSafe(request, "szCdTask"));
    event.setUlIdStage(GlobalData.getUlIdStage(request));
    childrenFirstReferralSaveSI.setROWCCMN01UIG00(event);

    childrenFirstReferralSaveSI.setDtDtGeneration(ContextHelper.getJavaDateSafe(request, "szDtReferGene"));
    childrenFirstReferralSaveSI.setDtDtReferralSent(ContextHelper.getJavaDateSafe(request, "szDtReferSent"));
    String indParentalRelease = ContextHelper.getStringSafe(request, "rbRelSigned");
    childrenFirstReferralSaveSI.setIndParentalRelease(indParentalRelease);

    // Check if the complete check box is checked OR the current status of the event is COMP. This is checked
    // because the Save button is always available even in COMP status.
    if (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "cbxReferComp"))
        || CodesTables.CEVTSTAT_COMP.equals(eventStatus)) {
      childrenFirstReferralSaveSI.setIndComplete(ArchitectureConstants.Y);
    } else {
      childrenFirstReferralSaveSI.setIndComplete(ArchitectureConstants.N);
    }
    childrenFirstReferralSaveSI.setDtDtAcknowledge(ContextHelper.getJavaDateSafe(request, "szDtAckRefRecd"));
    childrenFirstReferralSaveSI.setDtPhySummary(ContextHelper.getJavaDateSafe(request, "szDtPhyHelSumRecd"));
    String indFurtherAssmt = ContextHelper.getStringSafe(request, "rbPhyFollowUp");
    childrenFirstReferralSaveSI.setIndFurtherAssmt(indFurtherAssmt);
    childrenFirstReferralSaveSI.setDtIFSP(ContextHelper.getJavaDateSafe(request, "szDtFamSrvTrtPlan"));
    childrenFirstReferralSaveSI.setTxtComments(ContextHelper.getStringSafe(request, "szCommts"));
    childrenFirstReferralSaveSI.setRelOnFile(ContextHelper.getStringSafe(request, "rbRelOnFile"));
    childrenFirstReferralSaveSI.setIdStage(GlobalData.getUlIdStage(request));
    childrenFirstReferralSaveSI.setIdEvent(GlobalData.getUlIdEvent(request));
    childrenFirstReferralSaveSI.setIdCase(GlobalData.getUlIdCase(request));
    childrenFirstReferralSaveSI.setCdTask(GlobalData.getSzCdTask(request));
    childrenFirstReferralSaveSI.setIdCaseWorker(user.getUserID());
    childrenFirstReferralSaveSI.setDtEventLastUpdate(ContextHelper.getJavaDateSafe(request, "evtsLastUpdate"));
    childrenFirstReferralSaveSI.setDtEventOccurred(ContextHelper.getJavaDateSafe(request, "dtDtEventOccurred"));
  }

  private void handleException(Exception e, GrndsExchangeContext context, String methodName) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "handleError");
    performanceTrace.enterScope();

    String stackTrace = BasePrsException.getStackTrace(e);
    HttpServletRequest request = context.getRequest();
    if (e instanceof ServiceException) {
      ServiceException we = (ServiceException) e;

      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "ServiceException " + we.getClass() + " " + we.getMessage());
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        setPresentationBranch("error", context);
        setErrorMessage(errorCode, DISPLAY_CHILDREN_FIRST_REF, request);
        break;

      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } else {
      GrndsTrace.msg(TRACE_TAG + "." + methodName, 7, "General Exception " + e.getClass() + " " + e.getMessage()
                                                      + stackTrace);
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
}
