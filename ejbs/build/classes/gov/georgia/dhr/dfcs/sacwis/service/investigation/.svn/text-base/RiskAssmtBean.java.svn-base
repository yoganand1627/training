package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseServiceEjb;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.DaoException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.TimestampMismatchException;
import gov.georgia.dhr.dfcs.sacwis.core.jdbchelper.JdbcHelper;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.common.EventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.InvCnclsnDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.InvCnclsnEventValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtPriorHistoryValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskAssmtValueBean;
import gov.georgia.dhr.dfcs.sacwis.dao.investigation.RiskFactorValueBean;
import gov.georgia.dhr.dfcs.sacwis.service.admin.CheckStageEventStatus;
import gov.georgia.dhr.dfcs.sacwis.service.admin.InvalidateApproval;
import gov.georgia.dhr.dfcs.sacwis.service.admin.PostEvent;
import gov.georgia.dhr.dfcs.sacwis.service.reports.RetrieveOutputLaunch;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN01UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN05UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN06UI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB59SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN01UO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB59SO;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ejb.CreateException;

import org.grnds.facility.log.GrndsTrace;

/**
 * Used to handle Risk Assessment operations
 * 
 * @author Jason Rios, October 10, 2002
 *  Change History:
 *  Date      User      Description
 *  --------  --------  --------------------------------------------------
 *  10/27/09  arege    #38365 Removed code to prevent the event status of Risk Assessment or Risk ReAssessment to change to PEND while saving
 *                     the page in approval mode (Approval mode is taken from the INV CCL event)  
 *                     Having the event status in PEND causes an error message stating that 'Risk Reassessment must be completed' 
 *                     on submitting Family Plan in ONG stage.
 */
@SuppressWarnings("serial")
public class RiskAssmtBean extends BaseServiceEjb {
  public static final String TRACE_TAG = "RiskAssmtEjb";

  private CheckStageEventStatus checkStageEventStatus = null;

  private InvalidateApproval invalidateApproval = null;

  private PostEvent postEvent = null;

  private RetrieveOutputLaunch retrieveOutputLaunch = null;

  protected void onEjbCreate() throws CreateException {
    // Initialize services on creation.
    checkStageEventStatus = getService(CheckStageEventStatus.class);
    invalidateApproval = getService(InvalidateApproval.class);
    postEvent = getService(PostEvent.class);
    retrieveOutputLaunch = getService(RetrieveOutputLaunch.class);
  }

  /**
   * Retrieve the Risk Assessment details and the data needed to build the Risk Assessment page.
   * 
   * @param searchBean
   *          The RiskAssmtValueBean containing the search parameters for the risk assessment.
   * @return returnBean The RiskAssmtValueBean containing the risk assessment details.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  public RiskAssmtValueBean queryRiskAssmt(RiskAssmtValueBean searchBean) throws ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".queryRiskAssmt");
    Connection connection = null;
    RiskAssmtValueBean returnBean = null;
    try {
      connection = getConnection();
      RiskAssmtDAO riskAssmtDao = new RiskAssmtDAO(connection);
      returnBean = riskAssmtDao.queryRiskAssmtDetails(searchBean);
      List<RiskAssmtPriorHistoryValueBean> reportBean = riskAssmtDao.queryRiskHistoryReport(searchBean);
      // returnBean.setReports(riskAssmtDao.queryRiskHistoryReport(searchBean));
      if (returnBean != null) {
        returnBean.setSzUserLoginId(searchBean.getSzUserLoginId());
        returnBean.setUlPersonId(searchBean.getUlPersonId());
        returnBean.setReports(reportBean);
        // Get the data for the Investigation Conclusion Event related to this
        // risk assessment.
        InvCnclsnEventValueBean invCnclsnEventSearchBean = new InvCnclsnEventValueBean();
        invCnclsnEventSearchBean.setCaseId(searchBean.getCaseId());
        invCnclsnEventSearchBean.setStageId(searchBean.getStageId());
        InvCnclsnDAO invCnclsnDao = new InvCnclsnDAO(connection);
        InvCnclsnEventValueBean invCnclsnEventReturnBean = invCnclsnDao
                                                                       .queryInvestigationConclusionEvent(invCnclsnEventSearchBean);
        returnBean.setInvestigationConclusionEvent(invCnclsnEventReturnBean);

        returnBean = this.checkRiskAssmtForCompletion(returnBean);

        // Call Output Launch Retrieve service to retrieve the Risk Assessment
        // Structured Narrative, if it exists. Set a "StructuredNarrExists" indicator
        // accordingly and put it in the request so the JSP will know if the narrative
        // exists or not.
        try {
          CSUB59SI csub59si = populateCSUB59SI_Retrieve(returnBean);
          CSUB59SO csub59so = retrieveOutputLaunch.retrieveOutputLaunch(csub59si);
          if (csub59so.getTsLastUpdate() != null) {
            returnBean.setHasStructuredNarr(true);
          }
        } catch (ServiceException we) {
          // If a "No Rows Returned" WtcException is thrown by the service call,
          // then the Risk Assessment Structured Narrative does not exist. If any
          // other kind of WtcException occurs, throw it to the conversation.
          if (we.getErrorCode() != Messages.MSG_NO_ROWS_RETURNED) {
            // noinspection ThrowCaughtLocally
            throw we;
          }
        } // end catch( WtcException we )
      } // end if( returnBean != null )
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "WtcException in queryRiskAssmt(): " + we.getMessage());
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return returnBean;
  }

  /**
   * Retrieve the data needed to build the Risk Assessment page.
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean to be populated with the data needed to build the RiskAssmt.jsp.
   * @return riskAssmtBean The RiskAssmtValueBean populated with the data needed to build the RiskAssmt.jsp.
   */
  public RiskAssmtValueBean queryPageData(RiskAssmtValueBean riskAssmtBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".queryPageData");
    Connection connection = null;
    RiskAssmtValueBean returnBean = null;
    try {
      connection = getConnection();
      RiskAssmtDAO dao = new RiskAssmtDAO(connection);
      returnBean = dao.queryPageData(riskAssmtBean);
      // Check each Area of the Risk Assessment for completion and set the
      // corresponding property in the Risk Assessment bean accordingly. Since
      // this is a new Risk Assessment, all the Areas will be incomplete.
      this.checkRiskAssmtForCompletion(returnBean);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return returnBean;
  }

  /**
   * Saves the risk assessment data to the database.
   * 
   * @param riskAssmtBeanFromState
   *          The RiskAssmtValueBean containing the data when the page first loaded.
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean containing the updated data to be saved to the database.
   * @return eventId The event id of the risk assessment.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  public Integer saveRiskAssmt(RiskAssmtValueBean riskAssmtBeanFromState, RiskAssmtValueBean riskAssmtBeanFromRequest)
                                                                                                                      throws TimestampMismatchException,
                                                                                                                      ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".saveRiskAssmt");
    Connection connection = null;
    int riskAssmtEventId = 0;
    try {
      connection = getConnection();
      RiskAssmtDAO dao = new RiskAssmtDAO(connection);

      // Call CheckStageEventStatus common function to determine whether or not
      // the save processing can continue.
      CCMN06UI ccmn06ui = populateCCMN06UI_CheckStageEventStatus(riskAssmtBeanFromRequest);
      checkStageEventStatus.status(ccmn06ui);

      // Check the Risk Assessment for completion.
      riskAssmtBeanFromRequest = this.checkRiskAssmtForCompletion(riskAssmtBeanFromRequest);

      // Determine whether or not the Risk Finding has changed.
      boolean riskFindingHasChanged = false;
      if ((riskAssmtBeanFromState.getFinding() == null && riskAssmtBeanFromRequest.getFinding() != null)
          || (riskAssmtBeanFromState.getFinding() != null && riskAssmtBeanFromRequest.getFinding() == null)
          || (riskAssmtBeanFromState.getFinding() != null && riskAssmtBeanFromRequest.getFinding() != null && !riskAssmtBeanFromRequest
                                                                                                                                       .getFinding()
                                                                                                                                       .equals(
                                                                                                                                               riskAssmtBeanFromState
                                                                                                                                                                     .getFinding()))) {
        riskFindingHasChanged = true;
      }

      // Save the Risk Assessment details to the database. InvalidateApproval will change
      // the Risk Assessment event status to COMP, by default. If a supervisor
      // accessed the Risk Assessment in approval mode and made the 'Risk Finding'
      // null, however, the Risk Assessment is no longer complete and the event
      // status should be changed to PROC. In this case, PostEvent will be
      // called below to make the update.
      riskAssmtEventId = saveRiskAssmt_Save(riskAssmtBeanFromState,
                                                                            riskAssmtBeanFromRequest);

      // If the Investigation Conclusion Event is in PEND status, and the user
      // did not access the Risk Assessment in approval mode or they changed the
      // Risk Finding, InvalidateApproval was called in the
      // saveRiskAssmt_Save method (above). InvalidateApproval will have
      // changed the Risk Assessment event status to COMP. If the user set the
      // Risk Finding to null, however, the Risk Assessment is incomplete, and
      // the Risk Assessment event status should be PROC. Query the Risk
      // Assessment event details to get the new Timestamp, then call PostEvent
      // to set the Risk Assessment event status to PROC.
      if (riskAssmtBeanFromState.getInvestigationConclusionEvent() != null
          && CodesTables.CEVTSTAT_PEND
                                      .equals(riskAssmtBeanFromState.getInvestigationConclusionEvent().getEventStatus())
          && (!riskAssmtBeanFromRequest.isApprovalMode() || riskFindingHasChanged)) {
        if (!riskAssmtBeanFromRequest.isComplete()) {
          EventValueBean updatedRiskAssmtEvent = dao.queryEvent(riskAssmtBeanFromRequest.getEventId());
          riskAssmtBeanFromRequest.setEventDateLastUpdate(updatedRiskAssmtEvent.getDateLastUpdate());
          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent_RiskAssmt(riskAssmtBeanFromRequest);
          postEvent.postEvent(ccmn01ui);
        } // end if( !riskAssmtBeanFromRequest.isComplete() )
      } // end if( riskAssmtBeanFromState.getInvestigationConclusionEvent() != null &&...

      // If the Risk Finding changed, set 'Recommended Action' and the 'Risk
      // Assessment N/A' checkbox to null on the Investigation Conclusion for
      // this stage because the 'Recommended Action' is partially determined by
      // the Risk Finding. Also set the Investigation Conclusion event (CCL)
      // to PROC status since 'Recommended Action' is now null.
      if (riskFindingHasChanged) {
        dao.resetInvestigationConclusion(riskAssmtBeanFromRequest);
      }
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException saving risk assessment");
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (SQLException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } catch (DaoException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return riskAssmtEventId;
  }

  /**
   * Saves the risk assessment details to the database in a separate transaction so that if a PENDing Investigation
   * Conclusion approval event is invalidated, the changes to the Risk Assessment event will be committed and the new
   * Timestamp will become available.
   * 
   * @param riskAssmtBeanFromState
   *          The RiskAssmtValueBean containing the data when the page first loaded.
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean containing the updated data to be saved to the database.
   * @return eventId The event id of the risk assessment.
   * @throws TimestampMismatchException
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  private int saveRiskAssmt_Save(RiskAssmtValueBean riskAssmtBeanFromState,
                                     RiskAssmtValueBean riskAssmtBeanFromRequest) throws TimestampMismatchException,
                                                                                 ServiceException {
    GrndsTrace.enterScope(TRACE_TAG + ".saveRiskAssmtSeparateXA");
    Connection connection = null;
    int riskAssmtEventId = 0;
    try {
      connection = getConnection();
      // Determine whether or not the Risk Finding has changed.
      boolean riskFindingHasChanged = false;
      if ((riskAssmtBeanFromState.getFinding() == null && riskAssmtBeanFromRequest.getFinding() != null)
          || (riskAssmtBeanFromState.getFinding() != null && riskAssmtBeanFromRequest.getFinding() == null)
          || (riskAssmtBeanFromState.getFinding() != null && riskAssmtBeanFromRequest.getFinding() != null && !riskAssmtBeanFromRequest
                                                                                                                                       .getFinding()
                                                                                                                                       .equals(
                                                                                                                                               riskAssmtBeanFromState
                                                                                                                                                                     .getFinding()))) {
        riskFindingHasChanged = true;
      }

      // If the Investigation Conclusion event is in PEND status, and the user
      // did not access the Risk Assessment in approval mode or they changed the
      // Risk Finding, call InvalidateApproval to invalidate the pending
      // approval. Also call PostEvent to set the Investigation Conclusion event
      // back to COMP status.
      boolean invalidateApprovalWasCalled = false;
      InvCnclsnEventValueBean cnclsnEventValueBean = riskAssmtBeanFromState.getInvestigationConclusionEvent();
      if (cnclsnEventValueBean != null && CodesTables.CEVTSTAT_PEND.equals(cnclsnEventValueBean.getEventStatus())
          && (!riskAssmtBeanFromRequest.isApprovalMode() || riskFindingHasChanged)) {
        invalidateApprovalWasCalled = true;
        riskAssmtBeanFromRequest.setInvestigationConclusionEvent(cnclsnEventValueBean);
        CCMN05UI ccmn05ui = populateCCMN05UI_InvalidateApproval(riskAssmtBeanFromRequest);
        invalidateApproval.invalidateApproval(ccmn05ui);
        CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent_InvCnclsn(riskAssmtBeanFromRequest);
        postEvent.postEvent(ccmn01ui);
      }

      // If the Risk Assessment already exists, call the "update" method to
      // save any changes to the database. Then, if InvalidateApproval was not
      // called (above), call PostEvent to update the status of the Risk
      // Assessment event. If InvalidateApproval was called (above), PostEvent
      // will be called in the parent method (saveRiskAssmt). It will not be
      // called in this method because InvalidateApproval will have updated the
      // Risk Assessment event causing the Timestamp to change. Calling
      // PostEvent afterward would cause a TimestampMismatch.
      // ----------
      // If the Risk Assessment does not already exist, first call PostEvent in
      // the new event, then call the "add" method to save the new Risk Assessment 
      // details to the database using the new event id. 
      // For RA created on Family Plan ADD or COPY, only event is created and with status NEW
      // However, status is not set in riskAssmtBeanFromRequest/State (hence has null value)
      if (riskAssmtBeanFromRequest.getEventId() > 0) {
        if (StringHelper.isValid(riskAssmtBeanFromRequest.getEventStatus())
            && !CodesTables.CEVTSTAT_NEW.equals(riskAssmtBeanFromRequest.getEventStatus())) {
          this.updateRiskAssmt(riskAssmtBeanFromState, riskAssmtBeanFromRequest, connection);
          if (!invalidateApprovalWasCalled) {
            CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent_RiskAssmt(riskAssmtBeanFromRequest);
            postEvent.postEvent(ccmn01ui);
          }
        } else { // event created on Family Plan ADD/COPY, no RA yet created, need to add
          CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent_RiskAssmt(riskAssmtBeanFromRequest);
          postEvent.postEvent(ccmn01ui);
          this.addRiskAssmt(riskAssmtBeanFromRequest, connection);
        }
        riskAssmtEventId = riskAssmtBeanFromRequest.getEventId();
      } else {
        riskAssmtEventId = postRiskAssmtEvent_Save(riskAssmtBeanFromRequest);
        riskAssmtBeanFromRequest.setEventId(riskAssmtEventId); 
        this.addRiskAssmt(riskAssmtBeanFromRequest, connection);
      }
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException saving risk assessment");
      throw tme;
    } catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception calling service with WtcHelper: " + we.getMessage());
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return riskAssmtEventId;
  }

  /**
   * Save the new Risk Assessment details to the database.
   * 
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean object containing the risk assessment details to be saved to the database.
   */
  private void addRiskAssmt(RiskAssmtValueBean riskAssmtBeanFromRequest, Connection connection) {
    GrndsTrace.enterScope(TRACE_TAG + ".addRiskAssmt");
    String previousAreaCode = null;
    String previousCategoryCode = null;
    int newRiskAssmtEventId;
    int newRiskAreaId = 0;
    int newRiskCategoryId = 0;
    try {
      RiskAssmtDAO dao = new RiskAssmtDAO(connection);

      // Save the new Risk Assessment details to the database
      dao.addRiskAssmtDetails(riskAssmtBeanFromRequest);
      // dao.addPriorHistoryDetails(riskAssmtBeanFromRequest);
      dao.addInvActionsDetails(riskAssmtBeanFromRequest);
      dao.addAssessmentOfFmlyStr(riskAssmtBeanFromRequest);

      Iterator iterReports = riskAssmtBeanFromRequest.getReports().iterator();
      while (iterReports.hasNext()) {
        // Save the history report to the database only if the history id had data in it

        RiskAssmtPriorHistoryValueBean reportBean = (RiskAssmtPriorHistoryValueBean) iterReports.next();
        if (reportBean.getRiskHistoryReportId() == 0) {
          reportBean.setEventId(riskAssmtBeanFromRequest.getEventId());
          dao.addPriorHistoryDetails(reportBean);
        }
      }
      newRiskAssmtEventId = riskAssmtBeanFromRequest.getEventId();
      Iterator iter = riskAssmtBeanFromRequest.getFactors().iterator();
      while (iter.hasNext()) {
        RiskFactorValueBean formFactorBean = (RiskFactorValueBean) iter.next();

        // Each time the Area code changes, we must save the new Area information
        // to the database.
        if (previousAreaCode == null || !previousAreaCode.equals(formFactorBean.getAreaCode())) {
          newRiskAreaId = dao.addAreaDetails(newRiskAssmtEventId, formFactorBean);
          previousAreaCode = formFactorBean.getAreaCode();
        }

        // Each time the Category code changes, we must save the new Category
        // information to the database.
        if (previousCategoryCode == null || !previousCategoryCode.equals(formFactorBean.getCategoryCode())) {
          newRiskCategoryId = dao.addCategoryDetails(newRiskAssmtEventId, newRiskAreaId, formFactorBean);
          previousCategoryCode = formFactorBean.getCategoryCode();
        }

        // Each iteration through the Factor beans, we must save the new
        // Factor information to the database.
        dao.addFactorDetails(newRiskAssmtEventId, newRiskAreaId, newRiskCategoryId, formFactorBean);
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
  }

  /**
   * Save the updated Risk Assessment details to the database.
   * 
   * @param riskAssmtBeanFromState
   *          The RiskAssmtValueBean object containing the risk assessment details when the page first loaded.
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean object containing the risk assessment details to be saved to the database.
   * @throws TimestampMismatchException
   */
  private void updateRiskAssmt(RiskAssmtValueBean riskAssmtBeanFromState, RiskAssmtValueBean riskAssmtBeanFromRequest,
                               Connection connection) throws TimestampMismatchException {
    GrndsTrace.enterScope(TRACE_TAG + ".updateRiskAssmt");
    Iterator stateBeanFactorsIter;
    Iterator formBeanFactorsIter;
    RiskFactorValueBean stateFactorBean;
    RiskFactorValueBean formFactorBean;
    // RiskFactorValueBean previousStateFactorBean = null;
    // RiskFactorValueBean previousFormFactorBean = null;
    String previousAreaCode = null;
    String previousCategoryCode = null;
    try {
      RiskAssmtDAO dao = new RiskAssmtDAO(connection);
      dao.updateRiskAssmtDetails(riskAssmtBeanFromRequest);
      // dao.updateHistoryReport(riskAssmtBeanFromRequest);
      dao.updateInvActionDetails(riskAssmtBeanFromRequest);
      dao.updateAssessmentOfFmlyStr(riskAssmtBeanFromRequest);
      Iterator iter = riskAssmtBeanFromRequest.getReports().iterator();
      while (iter.hasNext()) {
        // Save the task to the database only if the history id has data in it

        RiskAssmtPriorHistoryValueBean reportBean = (RiskAssmtPriorHistoryValueBean) iter.next();
        if (reportBean.getRiskHistoryReportId() > 0) {
          dao.updateHistoryReport(reportBean);
        } else {
          dao.addPriorHistoryDetails(reportBean);
        }
      }
      // Iterate through the state Risk Assessment's Factor beans and the form
      // Risk Assessment's Factor beans at the same time. Compare the responses
      // in the two beans. If the responses are different, save the new response
      // to the database.
      stateBeanFactorsIter = riskAssmtBeanFromState.getFactors().iterator();
      formBeanFactorsIter = riskAssmtBeanFromRequest.getFactors().iterator();
      while (stateBeanFactorsIter.hasNext() && formBeanFactorsIter.hasNext()) {
        stateFactorBean = (RiskFactorValueBean) stateBeanFactorsIter.next();
        formFactorBean = (RiskFactorValueBean) formBeanFactorsIter.next();

        // Each time the Area code changes, we must check the Area's Overall Scale
        // of Concern to see if it has changed.
        if (previousAreaCode == null || !previousAreaCode.equals(stateFactorBean.getAreaCode())) {
          // Compare the Area's Overall Scale of Concern from the form Factor bean
          // to the original value in the state Factor bean. If they are different,
          // then write the new one to the database. (Once an Overall Scale of
          // Concern is selected, the field will never again become null. That
          // condition does not need to be checked in this IF statement.)
          if ((stateFactorBean.getAreaScaleOfConcern() == null && formFactorBean.getAreaScaleOfConcern() != null)
              || (stateFactorBean.getAreaScaleOfConcern() != null && formFactorBean.getAreaScaleOfConcern() != null && !stateFactorBean
                                                                                                                                       .getAreaScaleOfConcern()
                                                                                                                                       .equals(
                                                                                                                                               formFactorBean
                                                                                                                                                             .getAreaScaleOfConcern()))
              || ((stateFactorBean.getCategoryJustificationOfFindings() == null && formFactorBean
                                                                                                 .getCategoryJustificationOfFindings() != null) || (stateFactorBean
                                                                                                                                                                   .getAreaScaleOfConcern() != null
                                                                                                                                                    && formFactorBean
                                                                                                                                                                     .getCategoryJustificationOfFindings() != null && !stateFactorBean
                                                                                                                                                                                                                                      .getCategoryJustificationOfFindings()
                                                                                                                                                                                                                                      .equals(
                                                                                                                                                                                                                                              formFactorBean
                                                                                                                                                                                                                                                            .getCategoryJustificationOfFindings())))) {
            dao.updateAreaDetails(formFactorBean);
          }

          // Save the current Area code for reference in the next iteration
          previousAreaCode = stateFactorBean.getAreaCode();
        }

        // Each time the Category code changes, we must check the Category's Overall
        // Scale of Concern to see if it has changed.
        if (previousCategoryCode == null || !previousCategoryCode.equals(stateFactorBean.getCategoryCode())) {
          // Compare the Category's Overall Scale of Concern from the form Factor
          // bean to the original value in the state Factor bean. If they are
          // different, then write the new one to the database. (Once an Overall
          // Scale of Concern is selected, the field will never again become null.
          // That condition does not need to be checked in this IF statement.)
          if ((stateFactorBean.getCategoryScaleOfConcern() == null && formFactorBean.getCategoryScaleOfConcern() != null)
              || (stateFactorBean.getCategoryScaleOfConcern() != null
                  && formFactorBean.getCategoryScaleOfConcern() != null && !stateFactorBean
                                                                                           .getCategoryScaleOfConcern()
                                                                                           .equals(
                                                                                                   formFactorBean
                                                                                                                 .getCategoryScaleOfConcern()))) {
            dao.updateCategoryDetails(formFactorBean);
          }

          // Save the current Category code for reference in the next iteration
          previousCategoryCode = stateFactorBean.getCategoryCode();
        }

        // Compare the current Factor response from the form Factor bean to the
        // original Factor response from the state bean. If they are different,
        // then write the new one to the database. (Once a Response is selected,
        // the field will never again become null. That condition does not need
        // to be checked in this IF statement.)
        if ((stateFactorBean.getFactorResponse() == null && formFactorBean.getFactorResponse() != null)
            || (stateFactorBean.getFactorResponse() != null && formFactorBean.getFactorResponse() != null && !stateFactorBean
                                                                                                                             .getFactorResponse()
                                                                                                                             .equals(
                                                                                                                                     formFactorBean
                                                                                                                                                   .getFactorResponse()))) {
          dao.updateFactorDetails(formFactorBean);
        }

        // Save the current Factor beans for use during the next iteration
        // previousStateFactorBean = stateFactorBean;
        // previousFormFactorBean = formFactorBean;
      }
    } catch (TimestampMismatchException tme) {
      GrndsTrace.msg(TRACE_TAG, 7, "TimestampMismatchException updating risk assessment: " + tme.getMessage());
      getSessionContext().setRollbackOnly();
      throw tme;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      getSessionContext().setRollbackOnly();
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
  }

  /**
   * Check the Risk Assessment to see if it was created using IRA or IMPACT.
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean containing the risk assessment search parameters.
   * @return riskAssmtBean The RiskAssmtValueBean populated with the information on whether or not the risk assessment
   *         was created using IRA or IMPACT.
   */
  public RiskAssmtValueBean checkIfRiskAssmtCreatedUsingIRA(RiskAssmtValueBean riskAssmtBean) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkIfRiskAssmtCreatedUsingIRA");
    Connection connection = null;
    try {
      connection = getConnection();
      RiskAssmtDAO riskAssmtDao = new RiskAssmtDAO(connection);
      riskAssmtBean = riskAssmtDao.queryCreatedUsingIRAData(riskAssmtBean);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return riskAssmtBean;
  }

  /**
   * Check the Risk Assessment to see if it is complete.
   * 
   * @param riskAssmtBeanToCheck
   *          The RiskAssmtValueBean containing the risk assessment detail to be checked for completion.
   * @return riskAssmtBeanToCheck The RiskAssmtValueBean passed to the method, but the "completion check" properties are
   *         set based upon the completion status of the risk assessment.
   */
  public RiskAssmtValueBean checkRiskAssmtForCompletion(RiskAssmtValueBean riskAssmtBeanToCheck) {
    GrndsTrace.enterScope(TRACE_TAG + ".checkRiskAssmtForCompletion");
    RiskFactorValueBean currentFactorBean;
    String areaCodeBeingChecked = null;
    Boolean currentAreaIsComplete = Boolean.TRUE;
    Map<String, Boolean> currentAreaHashtable = new HashMap<String, Boolean>();
    boolean riskAssmtIsComplete = true;
    boolean riskAssmtPriorHistoryIsComplete = true;
    boolean riskAssmtInvActions = true;
    boolean riskAssmtFmlyStr = true;
    try {
      // Iterate through the factor beans in the order they appear in the array.
      // The factors were grouped by Area and Category when retrieved from the
      // database, so just iterate through the list and check the properties of
      // the factor beans until the Area changes. Then start over for each new
      // Area.
      Iterator iter = riskAssmtBeanToCheck.getFactors().iterator();
      while (iter.hasNext()) {
        currentFactorBean = (RiskFactorValueBean) iter.next();

        // Initialize the current Area variable if this is the first iteration.
        if (areaCodeBeingChecked == null) {
          areaCodeBeingChecked = currentFactorBean.getAreaCode();
        }

        // If the Area of the current factor bean is the same as the Area that we
        // are currently checking for completion, then check that the Area Scale
        // of Concern, Category Scale of Concern, and Factor each have a response.
        // If any of these properties is null or empty, then the Area is incomplete.
        // Also, the overall Risk Assessment is incomplete.
        if (currentFactorBean.getAreaCode().equals(areaCodeBeingChecked)) {
          if (currentFactorBean.getAreaScaleOfConcern() == null || "".equals(currentFactorBean.getAreaScaleOfConcern())
              || currentFactorBean.getCategoryScaleOfConcern() == null
              || "".equals(currentFactorBean.getCategoryScaleOfConcern())
              || currentFactorBean.getFactorResponse() == null || "".equals(currentFactorBean.getFactorResponse())) {
            currentAreaIsComplete = Boolean.FALSE;
            riskAssmtIsComplete = false;

            // If the Risk Finding is "Risk Assesssment N/A" (Code "04"), then
            // the Risk Assessment is still considered complete.
            // if (riskAssmtBeanToCheck.getFinding() != null
            // && riskAssmtBeanToCheck.getFinding().equals(CodesTables.CCRSKFND_04)) {
            // currentAreaIsComplete = Boolean.TRUE;
            // riskAssmtIsComplete = true;
            // }
          }

          // If this is the very last factor bean to be checked, then we are
          // finished. Add the completion check information to the hashtable.
          // THE WHILE LOOP WILL END NOW.
          if (!iter.hasNext()) {
            currentAreaHashtable.put(areaCodeBeingChecked, currentAreaIsComplete);
          }
        }
        // Since the Area of the current factor bean is different from the Area
        // that we are currently checking, then we are finished checking the Area.
        // Add the completion check information to the hashtable, and reset
        // the completion check variables. Then check the current factor bean
        // for completion and set the "is complete" variable accordingly for the
        // new Area.
        else {
          currentAreaHashtable.put(areaCodeBeingChecked, currentAreaIsComplete);
          currentAreaIsComplete = Boolean.TRUE;
          areaCodeBeingChecked = currentFactorBean.getAreaCode();
          if (currentFactorBean.getAreaScaleOfConcern() == null || "".equals(currentFactorBean.getAreaScaleOfConcern())
              || currentFactorBean.getCategoryScaleOfConcern() == null
              || "".equals(currentFactorBean.getCategoryScaleOfConcern())
              || currentFactorBean.getFactorResponse() == null || "".equals(currentFactorBean.getFactorResponse())) {
            currentAreaIsComplete = Boolean.FALSE;
            riskAssmtIsComplete = false;

            // If the Risk Finding is "Risk Assesssment N/A" (Code "04"), then
            // the Risk Assessment is still considered complete.
            // if (riskAssmtBeanToCheck.getFinding() != null
            // && riskAssmtBeanToCheck.getFinding().equals(CodesTables.CCRSKFND_04)) {
            // currentAreaIsComplete = Boolean.TRUE;
            // riskAssmtIsComplete = true;
            // }
          }
        }
      }// end while loop

      // check for history report and screening
      Iterator iterReports = riskAssmtBeanToCheck.getReports().iterator();
      while (iterReports.hasNext()) {
        RiskAssmtPriorHistoryValueBean reportBean = (RiskAssmtPriorHistoryValueBean) iterReports.next();
        if ((reportBean.getDateOfReport() == null) || (reportBean.getDateOfClosure() == null)
            || (reportBean.getFindingHistoryReport() == null || "".equals(reportBean.getFindingHistoryReport()))) {
          riskAssmtPriorHistoryIsComplete = false;
        }
      }

      // check for investigation action section completion
      if (riskAssmtBeanToCheck.getIndParentsGuide() == null || "".equals(riskAssmtBeanToCheck.getIndParentsGuide())
          || riskAssmtBeanToCheck.getIndParentsNotified() == null
          || "".equals(riskAssmtBeanToCheck.getIndParentsNotified())
          || riskAssmtBeanToCheck.getIndHIPPAPolicyExp() == null
          || "".equals(riskAssmtBeanToCheck.getIndHIPPAPolicyExp())
          || riskAssmtBeanToCheck.getIndHIPPAPolicySigned() == null
          || "".equals(riskAssmtBeanToCheck.getIndHIPPAPolicySigned())) {
        riskAssmtInvActions = false;
      }
      // check for assessment of family strength completion
      if (riskAssmtBeanToCheck.getIndchildVulnerability() == null
          || "".equals(riskAssmtBeanToCheck.getIndchildVulnerability())
          || riskAssmtBeanToCheck.getIndChildFragilityProtection() == null
          || "".equals(riskAssmtBeanToCheck.getIndChildFragilityProtection())
          || riskAssmtBeanToCheck.getIndChildBehaviour() == null
          || "".equals(riskAssmtBeanToCheck.getIndChildBehaviour())
          || riskAssmtBeanToCheck.getIndCaregiverCapability() == null
          || "".equals(riskAssmtBeanToCheck.getIndCaregiverCapability())
          || riskAssmtBeanToCheck.getIndKnowledgeSkills() == null
          || "".equals(riskAssmtBeanToCheck.getIndKnowledgeSkills()) || riskAssmtBeanToCheck.getIndControl() == null
          || "".equals(riskAssmtBeanToCheck.getIndControl()) || riskAssmtBeanToCheck.getIndFunctioning() == null
          || "".equals(riskAssmtBeanToCheck.getIndFunctioning()) || riskAssmtBeanToCheck.getIndQualityOfCare() == null
          || "".equals(riskAssmtBeanToCheck.getIndQualityOfCare()) || riskAssmtBeanToCheck.getIndPhysicalCare() == null
          || "".equals(riskAssmtBeanToCheck.getIndPhysicalCare()) || riskAssmtBeanToCheck.getIndEmotionalCare() == null
          || "".equals(riskAssmtBeanToCheck.getIndEmotionalCare())
          || riskAssmtBeanToCheck.getIndMaltreatmentPattern() == null
          || "".equals(riskAssmtBeanToCheck.getIndMaltreatmentPattern())
          || riskAssmtBeanToCheck.getIndCurrentSeverity() == null
          || "".equals(riskAssmtBeanToCheck.getIndCurrentSeverity()) || riskAssmtBeanToCheck.getIndChronicity() == null
          || "".equals(riskAssmtBeanToCheck.getIndChronicity()) || riskAssmtBeanToCheck.getIndTrend() == null
          || "".equals(riskAssmtBeanToCheck.getIndTrend()) || riskAssmtBeanToCheck.getIndHomeEnv() == null
          || "".equals(riskAssmtBeanToCheck.getIndHomeEnv()) || riskAssmtBeanToCheck.getIndStressors() == null
          || "".equals(riskAssmtBeanToCheck.getIndStressors())
          || riskAssmtBeanToCheck.getIndDangerousExposure() == null
          || "".equals(riskAssmtBeanToCheck.getIndDangerousExposure())
          || riskAssmtBeanToCheck.getIndSocialEnv() == null || "".equals(riskAssmtBeanToCheck.getIndSocialEnv())
          || riskAssmtBeanToCheck.getIndSocialClimate() == null
          || "".equals(riskAssmtBeanToCheck.getIndSocialClimate())
          || riskAssmtBeanToCheck.getIndSocialViolence() == null
          || "".equals(riskAssmtBeanToCheck.getIndSocialViolence())
          || riskAssmtBeanToCheck.getIndResponseToIntervention() == null
          || "".equals(riskAssmtBeanToCheck.getIndResponseToIntervention())
          || riskAssmtBeanToCheck.getIndAttitude() == null || "".equals(riskAssmtBeanToCheck.getIndAttitude())
          || riskAssmtBeanToCheck.getIndDeception() == null || "".equals(riskAssmtBeanToCheck.getIndDeception())
          || riskAssmtBeanToCheck.getCommentsAssessmentOfFmlyStr() == null
          || "".equals(riskAssmtBeanToCheck.getCommentsAssessmentOfFmlyStr())) {
        riskAssmtFmlyStr = false;
      }

      riskAssmtBeanToCheck.setAreaCompletionStatus(currentAreaHashtable);
      riskAssmtBeanToCheck.setComplete(riskAssmtIsComplete);
      riskAssmtBeanToCheck.setPriorHistoryComplete(riskAssmtPriorHistoryIsComplete);
      riskAssmtBeanToCheck.setInvActionsComplete(riskAssmtInvActions);
      riskAssmtBeanToCheck.setAssessmentOfFmlyStrComplete(riskAssmtFmlyStr);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      GrndsTrace.exitScope();
    }
    return riskAssmtBeanToCheck;
  }

  /**
   * Calls PostEvent to insert a new Risk Assessment event. The new risk assessment event id
   * is returned.
   * 
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean containing the new risk assessment details.
   * @return newRiskAssmtEventId The risk assessment event id.
   * @throws gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException
   * 
   */
  private int postRiskAssmtEvent_Save(RiskAssmtValueBean riskAssmtBeanFromRequest) throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "postRiskAssmtEventSeparateXA");
    performanceTrace.enterScope();

    int newRiskAssmtEventId;
    try {
      CCMN01UI ccmn01ui = populateCCMN01UI_PostEvent_RiskAssmt(riskAssmtBeanFromRequest);
      CCMN01UO ccmn01uo = postEvent.postEvent(ccmn01ui);
      newRiskAssmtEventId = ccmn01uo.getUlIdEvent();
    } catch (ServiceException we) {
      throw we;
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    }
    performanceTrace.exitScope();
    return newRiskAssmtEventId;
  }

  /**
   * Helper method called by displayRiskAssmtStructuredNarr_xa activity method to populate the input object for the
   * Output Launch Retrieval service (CSUB59S).
   * 
   * @param riskAssmtBean
   *          The RiskAssmtValueBean object containing the risk assessment details.
   * @return csub59si The populated CSUB59SI object.
   */
  private CSUB59SI populateCSUB59SI_Retrieve(RiskAssmtValueBean riskAssmtBean) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB59SI_Retrieve()");
    performanceTrace.enterScope();

    CSUB59SI csub59si = new CSUB59SI();
    ArchInputStruct input = new ArchInputStruct();

    csub59si.setUlIdStage(riskAssmtBean.getStageId());
    csub59si.setUlIdEvent(riskAssmtBean.getEventId());
    csub59si.setSzCdTask(RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE);

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_SEARCH);
    input.setSzUserId(riskAssmtBean.getSzUserLoginId());

    csub59si.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return csub59si;
  }

  /**
   * Helper method that populates the input object for the PostEvent common function for updating the Investigation
   * Conclusion Event.
   * 
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean object containing the risk assessment details.
   * @return ccmn01ui The populated CCMN01UI object.
   */
  private CCMN01UI populateCCMN01UI_PostEvent_InvCnclsn(RiskAssmtValueBean riskAssmtBeanFromRequest) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN01UI_PostEvent_InvCnclsn()");
    performanceTrace.enterScope();

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();

    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();

    InvCnclsnEventValueBean invCnclsnEvent = riskAssmtBeanFromRequest.getInvestigationConclusionEvent();
    rowccmn01uig00.setSzCdEventType(invCnclsnEvent.getEventType());
    rowccmn01uig00.setSzCdTask(invCnclsnEvent.getTaskCode());
    rowccmn01uig00.setSzTxtEventDescr(invCnclsnEvent.getEventDescription());
    rowccmn01uig00.setUlIdPerson(invCnclsnEvent.getPersonId());
    rowccmn01uig00.setUlIdStage(invCnclsnEvent.getStageId());
    rowccmn01uig00.setUlIdEvent(invCnclsnEvent.getEventId());
    rowccmn01uig00.setTsLastUpdate(invCnclsnEvent.getDateLastUpdate());
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);

    input.setSzUserId(riskAssmtBeanFromRequest.getSzUserLoginId());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccmn01ui;
  }

  /**
   * Helper method called by saveRiskAssmt_xa activity method to populate the input object for the PostEvent common
   * function for updating the Risk Assessment Event.
   * 
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean object containing the risk assessment details.
   * @return ccmn01ui The populated CCMN01UI object.
   */
  private CCMN01UI populateCCMN01UI_PostEvent_RiskAssmt(RiskAssmtValueBean riskAssmtBeanFromRequest) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN01UI_PostEvent_RiskAssmt()");
    performanceTrace.enterScope();

    CCMN01UI ccmn01ui = new CCMN01UI();
    ArchInputStruct input = new ArchInputStruct();

    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00 rowccmn01uig00 = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00();
    CaseUtility.Event riskAssmtEvent;
    String taskCode = RiskAssmtValueBean.RISK_ASSESSMENT_TASK_CODE;
    String eventDesc = RiskAssmtValueBean.RISK_ASSESSMENT_EVENT_DESC;
    // If updating Risk Assessment, use the existing values since Risk ReAssessment for Family Plan share the same
    // type with Risk Assessment but has different task code (being created in different stage) and description
    // FamilyPlanBean creates Risk ReAssessment using its own code (populating RR/A with correct task code and desc,)
    // and only
    // use RiskAssmnt to display and re-save
    if (riskAssmtBeanFromRequest.getEventId() > 0) {
      riskAssmtEvent = CaseUtility.getEvent(riskAssmtBeanFromRequest.getEventId());
      taskCode = riskAssmtEvent.getCdTask();
      eventDesc = riskAssmtEvent.getTxtEventDesc();
    }

    rowccmn01uig00.setSzCdEventType(CodesTables.CEVNTTYP_ASM);
    rowccmn01uig00.setSzCdTask(taskCode);
    rowccmn01uig00.setSzTxtEventDescr(eventDesc);
    rowccmn01uig00.setUlIdPerson(riskAssmtBeanFromRequest.getUlPersonId());
    rowccmn01uig00.setUlIdStage(riskAssmtBeanFromRequest.getStageId());
    // DT_EVENT_OCCURRED should show the most recent save date.
    rowccmn01uig00.setDtDtEventOccurred(DateHelper.getTodayCastorDate());

    input.setSzUserId(riskAssmtBeanFromRequest.getSzUserLoginId());

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    if (riskAssmtBeanFromRequest.getEventId() > 0) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowccmn01uig00.setUlIdEvent(riskAssmtBeanFromRequest.getEventId());
      rowccmn01uig00.setTsLastUpdate(riskAssmtBeanFromRequest.getEventDateLastUpdate());
    }

    // Set the event status. Event status should be PROC by default. If the
    // Risk Assessment is complete, the event status should be set to COMP. If
    // a supervisor accessed the Risk Assessment in approval mode via an Approval
    // To-Do, and the Risk Assessment is complete, the event status should
    // remain PEND. If a supervisor accessed the Risk Assessment in approval mode
    // via an Approval To-Do, and the Risk Assessment is no longer complete
    // (meaning the supervisor made the 'Risk Finding' null, which should happen
    // only on rare occassions), the event status should be set to PROC. The
    // Investigation Conclusion already will have been invalidated.
    rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    if (riskAssmtBeanFromRequest.isComplete()) {
      rowccmn01uig00.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
      //#38365 Removed code to prevent the event status to change to PEND if in approval mode. 
      //Having the event status in PEND causes an error message stating that 'Risk Reassessment must be completed' 
      //on submitting Family Plan in ONG stage. 
    }

    ccmn01ui.setArchInputStruct(input);
    ccmn01ui.setROWCCMN01UIG00(rowccmn01uig00);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccmn01ui;
  }

  /**
   * Helper method called by saveRiskAssmt_xa activity method to populate the input object for the InvalidateApproval
   * common function.
   * 
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean object containing the risk assessment details.
   * @return ccmn05ui The populated CCMN05UI object.
   */
  private CCMN05UI populateCCMN05UI_InvalidateApproval(RiskAssmtValueBean riskAssmtBeanFromRequest) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN05UI_InvalidateApproval()");
    performanceTrace.enterScope();

    CCMN05UI ccmn05ui = new CCMN05UI();
    ArchInputStruct input = new ArchInputStruct();

    gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO rowccmn45do = new gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN45DO();

    InvCnclsnEventValueBean invCnclsnEvent = riskAssmtBeanFromRequest.getInvestigationConclusionEvent();
    rowccmn45do.setDtDtEventOccurred(DateHelper.toCastorDate(invCnclsnEvent.getDateEventOccurred()));
    rowccmn45do.setSzCdEventStatus(invCnclsnEvent.getEventStatus());
    rowccmn45do.setSzCdEventType(invCnclsnEvent.getEventType());
    rowccmn45do.setSzCdTask(invCnclsnEvent.getTaskCode());
    rowccmn45do.setSzTxtEventDescr(invCnclsnEvent.getEventDescription());
    rowccmn45do.setTsLastUpdate(invCnclsnEvent.getDateLastUpdate());
    rowccmn45do.setUlIdEvent(invCnclsnEvent.getEventId());
    rowccmn45do.setUlIdPerson(invCnclsnEvent.getPersonId());
    rowccmn45do.setUlIdStage(invCnclsnEvent.getStageId());

    ccmn05ui.setUlIdEvent(invCnclsnEvent.getEventId());

    input.setSzUserId(riskAssmtBeanFromRequest.getSzUserLoginId());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn05ui.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccmn05ui;
  }

  /**
   * Helper method to populate the input object for the CheckStageEventStatus common function.
   * 
   * @param riskAssmtBeanFromRequest
   *          The RiskAssmtValueBean object containing the risk assessment details.
   * @return ccmn06ui The populated CCMN06UI object.
   */
  private CCMN06UI populateCCMN06UI_CheckStageEventStatus(RiskAssmtValueBean riskAssmtBeanFromRequest) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCCMN06UI_CheckStageEventStatus()");
    performanceTrace.enterScope();

    CCMN06UI ccmn06ui = new CCMN06UI();
    ArchInputStruct input = new ArchInputStruct();

    ccmn06ui.setUlIdStage(riskAssmtBeanFromRequest.getStageId());
    ccmn06ui.setSzCdTask(RiskAssmtValueBean.INVESTIGATION_CONCLUSION_TASK_CODE);

    input.setSzUserId(riskAssmtBeanFromRequest.getSzUserLoginId());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
    ccmn06ui.setArchInputStruct(input);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();

    return ccmn06ui;
  }

  /** Gets a JDBC Managed Connection */
  protected Connection getConnection() {
    return JdbcHelper.getConnection();
  }

  public void setRiskFactorValueBean(RiskFactorValueBean bean, String categoryCode, String areaCode, String factorCode) {
    Connection connection = null;
    try {
      connection = getConnection();
      RiskAssmtDAO riskAssmtDao = new RiskAssmtDAO(connection);
      bean.setAreaText(riskAssmtDao.queryRiskAreaText(areaCode));
      bean.setCategoryText(riskAssmtDao.queryRiskCategoryText(categoryCode));
      bean.setFactorText(riskAssmtDao.queryRiskFactorText(factorCode));
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
  }
  
  public String queryFamilyPlanPageMode(int idEventRiskReAssessment) {
    Connection connection = null;
    String pageMode;
    try {
      connection = getConnection();
      RiskAssmtDAO riskAssmtDao = new RiskAssmtDAO(connection);
      String cdEventStatus = riskAssmtDao.queryInitialFamilyPlanStatus(idEventRiskReAssessment);
      if (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
        pageMode = PageModeConstants.VIEW;
      } else {
        pageMode = PageModeConstants.EDIT;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception getting connection and calling DAO: " + e.getMessage());
      throw new RuntimeWrappedException(e);
    } finally {
      cleanup(connection);
      GrndsTrace.exitScope();
    }
    return pageMode;
  }
}