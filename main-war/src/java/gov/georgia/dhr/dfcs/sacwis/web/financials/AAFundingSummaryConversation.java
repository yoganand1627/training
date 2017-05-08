package gov.georgia.dhr.dfcs.sacwis.web.financials;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.service.financials.Financials;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AAFundingSummaryRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AAFundingSummarySO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.text.ParseException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>Title: AAFundingSummaryConversation</p> <p>Description: This is the Conversation class used to add,
 * save and submit an Adoption Assistance Funding Eligibility for a particular child.</p> 
 * <p>Copyright: Copyright (c) 2011</p> <p>Company: GADHS</p>
 * <p/>
 * <p/>
 * <pre>
 * Change History:
 * Date        User                  Description
 * ----------  ------------------    --------------------------------------------------------------------
 * 11/17/2011  hjbaptiste            STGAP00017683:Fixed Sibling of Applicable Child not saving in populateAAFundingSummarySO()
 * </pre>
 *
 * @author Herve Jean-Baptiste, August 31, 2011
 */

public class AAFundingSummaryConversation extends BaseHiddenFieldStateConversation {

  public static final String TRACE_TAG = "AAFundingSummaryConversation";
  public static final String VALIDATE_BUTTON = "btnValidate";
  public static final String SAVE_BUTTON = "btnSave";
  public static final String ADO_STAGE = CodesTables.CSTAGES_ADO;
  public static final String PAD_STAGE = CodesTables.CSTAGES_PAD;
  public static final String EVENT_STATUS_APPROVED = CodesTables.CEVTSTAT_APRV;
  public static final String ADO_AA_FUNDING_TASK = "9118";
  public static final String PAD_AA_FUNDING_TASK = "9103";
  
  public static final String GENERAL_FAILURE = "General Failure: ";
  
  private Financials financials = null;
  
  public void setFinancials(Financials financials) {
    this.financials = financials;
  }


  /**
   * This method retrieves the data needed to display the AAFunding Summary page and calls handleError methods.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayAAFundingSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAAFundingSummary_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);
    try {
      state.removeAllAttributes(request);
      boolean bAdd = ContextHelper.getString(request, "Add.x") != null;
      int idStage = GlobalData.getUlIdStage(request);
      int idCase = GlobalData.getUlIdCase(request);
      String cdTask = GlobalData.getSzCdTask(request);
      String cdStage = GlobalData.getSzCdStage(request);
      if (ADO_STAGE.equals(cdStage)) {
        cdTask = ADO_AA_FUNDING_TASK;
      } else {
        cdTask = PAD_AA_FUNDING_TASK;
      }
      
      int idUser = user.getUserID();
      int idAAFundingEvent = 0;
      if (!bAdd) {
        idAAFundingEvent = GlobalData.getUlIdEvent(request);
      }
      AAFundingSummaryRetrieveSI aAFundingSummaryRetrieveSI = new AAFundingSummaryRetrieveSI();
      aAFundingSummaryRetrieveSI.setAddButtonPressed(bAdd);
      aAFundingSummaryRetrieveSI.setIdAaFundingEvent(idAAFundingEvent);
      aAFundingSummaryRetrieveSI.setIdCase(idCase);
      aAFundingSummaryRetrieveSI.setIdStage(idStage);
      aAFundingSummaryRetrieveSI.setIdUser(idUser);
      aAFundingSummaryRetrieveSI.setCdStage(cdStage);
      aAFundingSummaryRetrieveSI.setCdTask(cdTask);
      
      AAFundingSummarySO aAFundingSummarySO = financials.retrieveAAFundingSummary(aAFundingSummaryRetrieveSI);
      // If the Add button was clicked, we need to put the idEvent into GlobalData
      if (bAdd) {
        idAAFundingEvent = aAFundingSummarySO.getIdAaFundingEvent();
        GlobalData.setUlIdEvent(idAAFundingEvent, request);
      }
      
      // Set the SO object into state to be used to populate the page
      state.setAttribute("aAFundingSummarySO", aAFundingSummarySO, request);
      
      // Set Pagemode
      //String pageMode = EventSearchConversation.getEventDetailPageMode(request, idAAFundingEvent, idStage, cdTask);
      if ((user.hasRight(UserProfile.SEC_ELIGIBILITY) == true)) {
        PageMode.setPageMode(PageModeConstants.MODIFY, request);
      } else {
        PageMode.setPageMode(PageModeConstants.INQUIRE, request);
      }
      if (EVENT_STATUS_APPROVED.equals(aAFundingSummarySO.getCdEventStatus())) {
        PageMode.setPageMode(PageModeConstants.INQUIRE, request);
      }
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }
  
  
  /**
   * This method is the main call for saving an AA Funding Summary. It will make a call to the private
   * helper method passing it the appropriate action of Save
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveAAFundingSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAAFundingSummary_xa()");
    performanceTrace.enterScope();
    
    try {
      saveDetail(context, SAVE_BUTTON);
    }
    catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  private void saveDetail(GrndsExchangeContext context, String action) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveDetail()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(context);

    try {
      AAFundingSummarySO aAFundingSummarySO = (AAFundingSummarySO) state.getAttribute("aAFundingSummarySO", request);
      if (SAVE_BUTTON.equals(action)) {
        aAFundingSummarySO.setSaveButtonPressed(true);
        aAFundingSummarySO.setValidateButtonPressed(false);
        aAFundingSummarySO.setAddButtonPressed(false);
      } else if (VALIDATE_BUTTON.equals(action)){
        aAFundingSummarySO.setValidateButtonPressed(true);
        aAFundingSummarySO.setSaveButtonPressed(false);
        aAFundingSummarySO.setAddButtonPressed(false);
      }
      
      // Populate the SO object with values from the page
      populateAAFundingSummarySO(context, aAFundingSummarySO);
      financials.saveAAFundingSummary(aAFundingSummarySO);

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  /**
   * This method is called when the user clicks the Validate button on the AA Funding Summary page. 
   * This method calls the save function, and then the AA Funding Summary List page page is displayed.
   * 
   * @param context - the GrndsExchangeContext object
   * @return void
   */
  public void validateAAFundingSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, ".validateAAFundingSummary_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
        
    try {
      saveDetail(context, VALIDATE_BUTTON);
    } catch (ServiceException we) {
      handleError(we, context);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();

  }

  /**
   * Populates the AAFundingSummarySO with the key/value pair objects in the request
   * 
   * @param context
   * @param aAFundingSummarySO
   * @throws ParseException
   */
  private void populateAAFundingSummarySO(GrndsExchangeContext context, AAFundingSummarySO aAFundingSummarySO) throws ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateAAFundingSummarySO()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    
    try {
      aAFundingSummarySO.setIduser(user.getUserID());
      // Populate SO object with key/value pair objects in the request
      aAFundingSummarySO.setDtEventLastUpdate(ContextHelper.getJavaDateSafe(request, "hdnTsLastUpdate"));
      aAFundingSummarySO.setIdEligibilityEvent(ContextHelper.getIntSafe(request, "hdnIdEligibilityEvent"));
      aAFundingSummarySO.setCdEligActual(ContextHelper.getStringSafe(request, "hdnCdEligActual"));
      aAFundingSummarySO.setCdAaFundingType(ContextHelper.getStringSafe(request, "hdnCdAaFundingType"));
      aAFundingSummarySO.setNbrFfy(ContextHelper.getIntSafe(request, "hdnNbrFfy"));
      aAFundingSummarySO.setNbrChildAge(ContextHelper.getIntSafe(request, "hdnNbrChildAge"));
      aAFundingSummarySO.setDtChildDob(ContextHelper.getJavaDateSafe(request, "hdnDtChildDob"));
      aAFundingSummarySO.setNbrChildMthsInFoster(ContextHelper.getIntSafe(request, "hdnNbrChildMthsInFoster"));
      aAFundingSummarySO.setNmAcSiblingFullName(ContextHelper.getStringSafe(request, "hdnNmAcSiblingFullName"));
      aAFundingSummarySO.setIdApplicableSibling(ContextHelper.getIntSafe(request, "hdnIdApplicableSibling"));
      aAFundingSummarySO.setDtAcSiblingDob(ContextHelper.getJavaDateSafe(request, "hdnDtAcSiblingDob"));
      aAFundingSummarySO.setNbrAcSiblingMthsInFoster(ContextHelper.getIntSafe(request, "hdnNbrAcSiblingMthsInFoster"));
      aAFundingSummarySO.setIndNonRecurringReq(CheckboxHelper.getCheckboxValue(request, "cbxBIndNonRecurringReq"));
      aAFundingSummarySO.setIndAcAgeMet(ContextHelper.getStringSafe(request, "rbIndAcAgeMet"));
      aAFundingSummarySO.setIndAcTimeInFosterMet(ContextHelper.getStringSafe(request, "rbIndAcTimeInFosterMet"));     
      aAFundingSummarySO.setIndAcSiblingMet(ContextHelper.getStringSafe(request, "rbIndAcSiblingMet"));
      aAFundingSummarySO.setIndAcTprCtwVsMet(ContextHelper.getStringSafe(request, "rbIndAcTprCtwVsMet"));
      aAFundingSummarySO.setIndAcSsiEligMet(ContextHelper.getStringSafe(request, "rbIndAcSsiEligMet"));
      aAFundingSummarySO.setIndAcChildOfMinorMet(ContextHelper.getStringSafe(request, "rbIndAcChildOfMinorMet"));
      aAFundingSummarySO.setIndAcIvePriorAdoptMet(ContextHelper.getStringSafe(request, "rbIndAcIvePriorAdoptMet"));
      aAFundingSummarySO.setIndNacAfdcMet(ContextHelper.getStringSafe(request, "rbIndNacAfdcMet"));
      aAFundingSummarySO.setIndNacSsiEligMet(ContextHelper.getStringSafe(request, "rbIndNacSsiEligMet"));
      aAFundingSummarySO.setIndNacChildOfMinorMet(ContextHelper.getStringSafe(request, "rbIndNacChildOfMinorMet"));
      aAFundingSummarySO.setIndNacIvePriorAdoptMet(ContextHelper.getStringSafe(request, "rbIndNacIvePriorAdoptMet"));
      aAFundingSummarySO.setTxtComments(ContextHelper.getStringSafe(request, "txtComments"));
      

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, GENERAL_FAILURE + e.getMessage());
      processSevereException(context, e);
    }
    
    performanceTrace.exitScope();
  }
  
  private void handleError(ServiceException we, GrndsExchangeContext context) {

    int errorCode = we.getErrorCode();
    
    if (Messages.MSG_CMN_TMSTAMP_MISMATCH == errorCode || Messages.MSG_SYS_EVENT_STS_MSMTCH == errorCode ||
                    Messages.MSG_SYS_STAGE_CLOSED == errorCode || Messages.MSG_DATABASE_SAVE_FAIL == errorCode){
      setErrorMessage(errorCode, context.getRequest());
    } else {
      processSevereException(context, we);
    }          
  }
    

}
