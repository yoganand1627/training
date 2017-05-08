package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EligibilitySummaryDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceEligibilityDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EligibilitySummary;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSupRefOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveCsupOutboundNcpsSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveCsupOutboundNcpsSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.errorlist.ErrorList;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.validation.ServerSideValidationUtility;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * <p>Title: EligibilitySummaryConversation</p>
 * <p>Copyright: Copyright (c) 2004</p>
 * <p>Company: DFPS</p>
 * @author Matt
 *
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 08/20/04  Todd Reser        Added flowerbox, fixed Javadocs
 * 12/09/09  mxpatel           SMS #37425: Modified code not to default the Actual Eligibility when creating a new Eligibility Summary 
 *                             event in the ADO or PAD stages.
 * 01/17/11  hjbaptiste        SMS#81144: Update the Eligibility table to indicate Reimbursability has not been created                            
 * </pre>
 */

/** Handles page flow and calls necessary logic for EligibilitySummary.jsp */
public class EligibilitySummaryConversation
        extends BaseHiddenFieldStateConversation {
  protected static final String ERROR_CODES = "EligibilitySummaryConversation.errorCodes";

  protected static final String IGNORE_MESSAGES = "EligibilitySummaryConversation.ignoreMessages";
  public static final String YES = ArchitectureConstants.Y;
  public static final String NO = ArchitectureConstants.N;
  //conversation URLS
  public static final String FCE_SUMMARY_DISPLAY = getUrl("displayEligibilitySummary");
  public static final String FCE_SUMMARY_SAVE = getUrl("saveEligibilitySummary");

  protected static final String CONVERSATION_URL = "/fce/EligibilitySummary/";
  protected static final String REDISPLAY_BRANCH = "redisplay";

  protected static final String BRANCH_EVENT_LIST = "EventList";

  private EligibilitySummary eligibilitySummaryBean;
  private Fce fceBean;
  
  protected class ChildSupportReferralToSTARS{
    private boolean referralProcessed = false;
    private List<CSupRefOutboundSI> listCSupRefOutboundSI = null;
    
    public List<CSupRefOutboundSI> getListCSupRefOutboundSI() {
      return listCSupRefOutboundSI;
    }
    public void setListCSupRefOutboundSI(List<CSupRefOutboundSI> listCSupRefOutboundSI) {
      this.listCSupRefOutboundSI = listCSupRefOutboundSI;
    }
    public boolean isReferralProcessed() {
      return referralProcessed;
    }
    public void setReferralProcessed(boolean referralProcessed) {
      this.referralProcessed = referralProcessed;
    }
  };


  public void setEligibilitySummary(EligibilitySummary eligibilitySummary) {
    this.eligibilitySummaryBean = eligibilitySummary;
  }

  public void setFce(Fce fce) {
    this.fceBean = fce;
  }

  
  /**
   * This method is the main display function for Eligibility Summary
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayEligibilitySummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayEligibilitySummary_xa");

    HttpServletRequest request = context.getRequest();

    try {
      clearState(context);

      //If user is trying to create a new Eligibility Summary w/o
      //the proper security, send back to event list with an error list message.
      int eventId = GlobalData.getUlIdEvent(request);
      if (eventId == 0) {
        UserProfile user = getUserProfile(request);
        if ((user.hasRight(UserProfile.SEC_BILLING) == false) &&
            (user.hasRight(UserProfile.SEC_ELIGIBILITY) == false)) {
          int[] errors = new int[] {Messages.MSG_NO_ADD_ELIG_SUMM};
          try {
            ErrorList.setErrors(errors, request);
          } catch (Exception t) {
            throw new RuntimeWrappedException(t);
          }
          setPresentationBranch(BRANCH_EVENT_LIST, context);
          return;
        }
      } else {

        //Now that NEW events are deletable, need to check and make sure
        // event still exists before trying to display, or page will blow up.

        List eventList = CaseUtility.getEvents(new int[] {GlobalData.getUlIdEvent(request)});
        if (eventList.size() == 0) {
          setErrorMessage("Eligibility Summary has been deleted or no longer exists.", request);
          setPresentationBranch(BRANCH_EVENT_LIST, context);
          return;
        }
      }

      EligibilitySummaryDB eligibilitySummaryDB = eligibilitySummaryBean.read(GlobalData.getUlIdStage(request),
                                                                          GlobalData.getUlIdCase(request), 
                                                                          eventId, getUserID(request));

      if ("".equals(eligibilitySummaryDB.getCdEligActual())) {
       eligibilitySummaryDB.setCdEligActual("");
        if (eligibilitySummaryDB.getIndEligible()) {
          eligibilitySummaryDB.setCdEligActual(FceConstants.TITLE_IV_E);
        }
      }
      //Default value of Selected to value of Actual
      //STGAP00004642: The Selected Eligibility is defaulted to blank.
      /*if ("".equals(eligibilitySummaryDB.getCdEligSelected())) {
        eligibilitySummaryDB.setCdEligSelected(eligibilitySummaryDB.getCdEligActual());
      }*/

      // STGAP00010990 - Adding logic to set the szCdTask attribute if
      // it is passed along in the request
      // When coming from the worksheet, SzCdTask isn't set.
      // If this is called from a PAD or ADO stage, the task code
      // should be in the request. If it isn't, then try to get it
      // from GlobalData.
      String szCdTask = (String) request.getAttribute("taskCD");
      if (szCdTask == null || "".equals(szCdTask)) {
        szCdTask = GlobalData.getSzCdTask(request);
      }
      // Get the stage so we can do further testing
      String szCdStage = GlobalData.getSzCdStage(request);
      // if the task code is not null (i.e. it is in the request) 
      // then we should check what stage we're in 
      // to set the task code correctly.
      if (! (szCdTask == null || "".equals(szCdTask)) ) {
        // If szCdStage is not null, check to see the value
        // else we assume FCC stage
        if ( !(szCdStage == null) ) {
          if ("ADO".equals(szCdStage)) {
            GlobalData.setSzCdTask(EventHelper.ELIG_DETERM_ADO, request);
          } else if ("PAD".equals(szCdStage)) {
            GlobalData.setSzCdTask(EventHelper.ELIG_DETERM_PAD, request);
          } else {
            // If not ADO or PAD, then this is an FCC stage
            GlobalData.setSzCdTask(EventHelper.FCE_ELIGIBILITY_TASK_CODE, request);            
          }
        } else {
          GlobalData.setSzCdTask(EventHelper.FCE_ELIGIBILITY_TASK_CODE, request);
        }
      } else {
        // If the task code is null (i.e. not in the request or GlobalData)
        // then it is assumed we've gotten here from the worksheet and SzCdTask
        // must be set for the FCC stage.
        GlobalData.setSzCdTask(EventHelper.FCE_ELIGIBILITY_TASK_CODE, request);
      }

      GlobalData.setUlIdEvent((int) eligibilitySummaryDB.getIdEligibilityEvent(), request);

      String eventStatus = eligibilitySummaryDB.getCdEventStatus();

      if (CodesTables.CEVTSTAT_NEW.equals(eventStatus)) {
        if (eligibilitySummaryDB.getIndNoActivePlacement()) {
          setInformationalMessage(Messages.MSG_CHILD_NO_PLACEMENT, request);
        }
        if (eligibilitySummaryDB.getIndNonPrsPaidPlacement()) {
          setInformationalMessage(Messages.MSG_CHILD_NON_PRS_PAID_SUGGEST_MAO, request);
        }
        // Prefill the checkbox from previous eligibility information,
        // and if NEW status, inform user.
        if (eligibilitySummaryDB.getIndChildSupportOrdered()) {
          setInformationalMessage(Messages.MSG_SUB_COURT_ORDERED, request);
        }
      }

      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      
      // This does not get set correctly when originally read
      if ( "PAD".equals(szCdStage) || "ADO".equals(szCdStage)) {
        eligibilitySummaryDB.setIdStage(GlobalData.getUlIdStage(request));
        eligibilitySummaryDB.setIdCase(GlobalData.getUlIdCase(request));
        eligibilitySummaryDB.setIdLastUpdatePerson(getUserID(request));
        eligibilitySummaryDB.setFceEligibility(new FceEligibilityDB());
      }

      request.setAttribute("EligibilitySummaryDB", eligibilitySummaryDB);

      if ((pageMode.equals(PageModeConstants.NEW)) ||
          (pageMode.equals(PageModeConstants.NEW_USING))) {
        pageMode = PageModeConstants.EDIT;
      }
      
      PageMode.setPageMode(pageMode, request);
    } catch (Exception e) {
      if (e instanceof EjbValidationException) {
        EjbValidationException ejbValidationException = (EjbValidationException) e;
        int errorCode = ejbValidationException.getErrorCode();
        if (errorCode == Messages.MSG_OPEN_SUMMARY_EVENT) {
          int[] errors = new int[] {errorCode};
          try {
            ErrorList.setErrors(errors, request);
          } catch (Exception t) {
            throw new RuntimeWrappedException(t);
          }
          setPresentationBranch(BRANCH_EVENT_LIST, context);
          return;
        }
      }
      processException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method is the main delete function for Eligibility Summary
   *
   * @param context The GrndsExchangeContext object.
   */
  public void deleteEligibilitySummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayEligibilitySummary_xa");

    HttpServletRequest request = context.getRequest();

    try {
      clearState(context);

      //SIR 19352 - Now that NEW events are deletable, need to check and make sure
      // event still exists before trying to display, or page will blow up.

      List eventList = CaseUtility.getEvents(new int[] {GlobalData.getUlIdEvent(request)});
      if (eventList.size() == 0) {
        // No need for error message, since they're trying to delete anyway.
        // setErrorMessage("Eligibility Summary has been deleted or no longer exists.", request);
        return;
      }

      EligibilitySummaryDB eligibilitySummaryDB = readFromRequest(request);

      eligibilitySummaryDB.setIdLastUpdatePerson(getUserID(request));

      eligibilitySummaryBean.delete(eligibilitySummaryDB);

    } catch (Exception e) {
      if (e instanceof EjbValidationException) {
        EjbValidationException ejbValidationException = (EjbValidationException) e;
        int errorCode = ejbValidationException.getErrorCode();
        if (errorCode == Messages.MSG_NO_DEL_ELIG_SUMM) {
          setErrorMessage(errorCode, request);
          setPresentationBranch(REDISPLAY_BRANCH, context);
          return;
        }
      }
      processException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is the main save function for Eligibility Summary
   *
   * @param context The GrndsExchangeContext object.
   */
  public void saveEligibilitySummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveEligibilitySummary_xa");

    HttpServletRequest request = context.getRequest();

    try {
      request.setAttribute("cSupRefOutboundErrors", null);
      String pageMode = PageMode.getPageMode(request);
      clearState(context);
      PageMode.setPageMode(pageMode, request);

      //SIR 19352 - Now that NEW events are deletable, need to check and make sure
      // event still exists before trying to save, or page will blow up.
      List eventList = CaseUtility.getEvents(new int[] {GlobalData.getUlIdEvent(request)});
      if (eventList.size() == 0) {
        setErrorMessage("Eligibility Summary has been deleted or no longer exists.", request);
        return;
      }

      EligibilitySummaryDB eligibilitySummaryDB = readFromRequest(request);
      eligibilitySummaryDB.setIdLastUpdatePerson(getUserID(request));

      if (eligibilitySummaryDB.getIdStage() == 0) {
        eligibilitySummaryDB.setIdStage(GlobalData.getUlIdStage(request));
      }
      
      String[] ignoreMessages = request.getParameterValues("ignoreMessage");
      Set ignoreMessagesSet = stringArrayToIntegerSet(ignoreMessages);
      request.setAttribute(IGNORE_MESSAGES, ignoreMessagesSet);

      // Added processing for STARS CS Referral ... KA
      ChildSupportReferralToSTARS childSupportReferralToSTARS = processChildSupportReferralToSTARS(request, eligibilitySummaryDB);
      boolean referralProcessed = childSupportReferralToSTARS.isReferralProcessed();
      if(!referralProcessed) {
        eligibilitySummaryDB.setIndEligCsupSend(Boolean.FALSE);
        eligibilitySummaryDB.setDtEligCsupReferral(null);
      }
      // Either ways if there was a CSup referral or not, and the errors occured or not we will
      // continue to save the Eligibility summary scren
      eligibilitySummaryBean.save(eligibilitySummaryDB, ignoreMessagesSet);
      
      
      //if there is clean save of the Eligibility summary scren create the referral
      if(referralProcessed) {
        List<CSupRefOutboundSI> listCSupRefOutboundSI = childSupportReferralToSTARS.getListCSupRefOutboundSI();
        if(listCSupRefOutboundSI != null && listCSupRefOutboundSI.size() > 0) {
          Iterator iter =  listCSupRefOutboundSI.iterator();
          while(iter.hasNext()) {
            CSupRefOutboundSI cSupRefOutbound = (CSupRefOutboundSI) iter.next();
            cSupRefOutbound.setEligibilityType(eligibilitySummaryDB.getCdEligSelected());
            eligibilitySummaryBean.saveChildSupReferralOutbound(cSupRefOutbound);
          }
        }
      }

      // Read is performed because BLOC/SSI may have changed since the page
      // last loaded (without affecting the event timestamp)
      eligibilitySummaryDB = eligibilitySummaryBean.read(GlobalData.getUlIdStage(request), GlobalData.getUlIdCase(request), 
                                                         GlobalData.getUlIdEvent(request), getUserID(request));

      String selectedEligibility = eligibilitySummaryDB.getCdEligSelected();
      String cdBlocChild = eligibilitySummaryDB.getCdBlocChildObject();
      double amtSsi = eligibilitySummaryDB.getAmtSsi();

      if ((FceConstants.TITLE_IV_E.equals(selectedEligibility)) &&
                      (cdBlocChild != null) &&
                      (cdBlocChild.equals(CodesTables.CBILPLOC_010) == false) &&
                      (amtSsi > 0)) {
        setInformationalMessage(Messages.MSG_BLOC_GREATER_THAN1_SSI, request);
        setPresentationBranch(REDISPLAY_BRANCH, context);
      }
      else if(!referralProcessed) {
        setPresentationBranch(REDISPLAY_BRANCH, context);
      }

      //if save succeeds, want to reset the ignoreMessages
      request.removeAttribute(IGNORE_MESSAGES);
    } catch (Exception e) {
      this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
      processException(context, e);
    }

    performanceTrace.exitScope();
  }

   
  /**
   * This is a comprehensive method that processes the STARS CS Referral. 
   * The Ncps are found for the Child in question.  For each NCP an ACP is created and also registered with CRS and an ID obtained. <BR>
   * Crs Id information for Ncp and the Child along with the other details as well as ACP is gathered and information is collected into input object CSupRefOutboundSI.<BR>
   * All this information put together is then added in a row in the CSupRefOutboundTable from where the interface partner/GTA will process the row.  
   * 
   * @param request
   * @param eligibilitySummaryDB
   * @return false if the referral was not processed.  The errors will be added as "cSupRefOutboundErrors" in the request object.
   */
  private ChildSupportReferralToSTARS processChildSupportReferralToSTARS(HttpServletRequest request, EligibilitySummaryDB eligibilitySummaryDB) {
    ChildSupportReferralToSTARS childSupportReferralToSTARS = new ChildSupportReferralToSTARS();
    
    // Is the Child being referred for Child Support to STARS. If yes, then the request is processed
    String status = eligibilitySummaryDB.getCdEventStatus();
    String savedResponse = ContextHelper.getString(request, "hdnPrevEligCSupSend");
    if((ArchitectureConstants.FALSE.equalsIgnoreCase(savedResponse)) && eligibilitySummaryDB.getIndEligCsupSend()
                    && !EventHelper.APPROVED_EVENT.equals(status)) {

      // Prepare the SI for retrieving the NCPs. This will also include creation of ACP
      // and getting its Crs ID for each NCP. 
      RetrieveCsupOutboundNcpsSI retrieveCsupOutboundNcpsSI = new RetrieveCsupOutboundNcpsSI();
      retrieveCsupOutboundNcpsSI.setIdInitiator(String.valueOf(UserProfileHelper.getUserProfile(request).getUserID()));
      retrieveCsupOutboundNcpsSI.setShinesLogonID(UserProfileHelper.getUserProfile(request).getUserLogonID());  
      RetrieveCsupOutboundNcpsSO retrieveCsupOutboundNcpsSO = fceBean.retrieveCsupOutboundNcps(eligibilitySummaryDB, retrieveCsupOutboundNcpsSI);

      String errors = StringHelper.EMPTY_STRING;

      // Check if there were any errors in retrieving the input data (including CRS registration process)
      // If yes then we want to pop up the message and then proceed with saving of the Summary Screen
      String displayMsg = "Child Support Referral could not be processed for the following reasons: ";
      if(retrieveCsupOutboundNcpsSO.hasErrors()) {
        errors = retrieveCsupOutboundNcpsSO.getErrors().toString();
        StringTokenizer msgs = new StringTokenizer(errors, RetrieveCsupOutboundNcpsSO.getErrorMsgsDelimeter());
        while(msgs.hasMoreElements()) {
          displayMsg += "" + msgs.nextToken();
        }
        request.setAttribute("cSupRefOutboundErrors", displayMsg);
        // Set actual exception messages for trace
        trace(retrieveCsupOutboundNcpsSO.getExceptionMsgs());

        // Because the process failed we want to set the radio button back to no and proceed further
        // with the saving of the screen.
        childSupportReferralToSTARS.setReferralProcessed(false);
      }
      // If no errors then set the NCPs for that child from the SO object
      else {
        List ncpList = retrieveCsupOutboundNcpsSO.getNcpsList();
        if(ncpList != null && ncpList.size() > 0) {
          childSupportReferralToSTARS.setReferralProcessed(true);
        } else {
          request.setAttribute("cSupRefOutboundErrors", displayMsg + MessageLookup.getMessageByNumber(Messages.MSG_FCE_CSUPREF_INDPRPAR));
          // Set actual exception messages for trace
          trace(retrieveCsupOutboundNcpsSO.getExceptionMsgs());
          childSupportReferralToSTARS.setReferralProcessed(false);
        }
        childSupportReferralToSTARS.setListCSupRefOutboundSI(ncpList);
       
      }
    } else {
      //set to true since the prevouis entry was true and no errors were encountered 
      childSupportReferralToSTARS.setReferralProcessed(true);
    }
    
    return childSupportReferralToSTARS;
  }
  

  protected void processException(GrndsExchangeContext context, Exception e) {
    if (e instanceof RuntimeWrappedException) {
      Throwable cause = e.getCause();
      if (cause instanceof ServiceException) {
        ServiceException wtcException = (ServiceException) cause;
        int errorCode = wtcException.getErrorCode();
        if (errorCode != 0) {
          addErrorCode(errorCode, context);
          return;
        }
      }
    }
    if (e instanceof EjbValidationException) {
      EjbValidationException ejbValidationException = (EjbValidationException) e;

      int errorCode = ejbValidationException.getErrorCode();
      if (errorCode != 0) {
        addErrorCode(errorCode, context);
        return;
      }
    }
    processSevereException(context, e);
  }

  protected void addErrorCode(int errorCode, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    //!!! I can't make up my mind how I want to do this
    Set<Integer> set = getErrorCodes(request);
    set.add(errorCode);
    switch (errorCode) {
      case Messages.MSG_SUB_AFFECT_PYMT:
      case Messages.MSG_SUB_GAP_EXISTS_1:
      case Messages.MSG_SUB_GAP_EXISTS_2:
      case Messages.MSG_SUB_GAP_EXISTS_3:
        //data wasn't saved; refresh what was on the page
        ServerSideValidationUtility.setBRefreshWidgetsFromRequest(request, true);
        setInformationalMessage(errorCode, request);
        setPresentationBranch(REDISPLAY_BRANCH, context);
        break;

      default:
        setErrorMessage(errorCode, request);
        break;
    }
  }

  @SuppressWarnings({"unchecked"})
  public static Set<Integer> getErrorCodes(HttpServletRequest request) {
    Set<Integer> set = (Set<Integer>) request.getAttribute(ERROR_CODES);
    if (set == null) {
      set = new HashSet<Integer>();
      request.setAttribute(ERROR_CODES, set);
    }
    return set;
  }

  public static Set getIgnoreMessages(HttpServletRequest request) {
    Set ignoreMessages = (Set) request.getAttribute(IGNORE_MESSAGES);
    if (ignoreMessages == null) {
      return new HashSet();
    }
    return ignoreMessages;
  }

  protected static Set stringArrayToIntegerSet(String[] array) {
    if (array == null) {
      return new HashSet();
    }
    Set<Integer> set = new HashSet<Integer>();
    for (int i = 0; i < array.length; i++) {
      Integer integer = Integer.valueOf(array[i]);
      set.add(integer);
    }
    return set;
  }

  /**
   * Scaffolding
   *
   * @param context The GrndsExchangeContext object.
   */
  public void blank_xa(GrndsExchangeContext context) {
    doNothing(context, TRACE_TAG, "blank_xa");
  }

  /**
   * Allows me to optionally print to System.out as well as to impact-trace.log
   *
   * @param string String
   */
  protected static final void trace(String string) {
    FceUtility.trace(TRACE_TAG, string);
  }

  /**
   * Appends pageName to CONVERSATION_URL
   *
   * @param pageName String
   * @return String
   */
  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }

  public static EligibilitySummaryDB readFromRequest(HttpServletRequest request) {
    EligibilitySummaryDB eligibilitySummaryDB = new EligibilitySummaryDB();
    populateWithRequest(eligibilitySummaryDB, request);
    return eligibilitySummaryDB;
  }

  public static void populateWithRequest(EligibilitySummaryDB eligibilitySummaryDB, HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(EligibilitySummaryDB.AMT_SSI)) {
      eligibilitySummaryDB.setAmtSsi(ContextHelper.getDoubleSafe(request, EligibilitySummaryDB.AMT_SSI));
    }
    if (map.containsKey(EligibilitySummaryDB.AMT_SSI_MONEY)) {
      eligibilitySummaryDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, EligibilitySummaryDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_APPLICATION)) {
      eligibilitySummaryDB.setCdApplication(ContextHelper.getStringSafe(request, EligibilitySummaryDB.CD_APPLICATION));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_BLOC_CHILD)) {
      eligibilitySummaryDB.setCdBlocChild(ContextHelper.getStringSafe(request, EligibilitySummaryDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_ACTUAL)) {
      eligibilitySummaryDB.setCdEligActual(ContextHelper.getStringSafe(request, EligibilitySummaryDB.CD_ELIG_ACTUAL));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST1)) {
      eligibilitySummaryDB.setCdEligCsupQuest1(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST1));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST2)) {
      eligibilitySummaryDB.setCdEligCsupQuest2(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST2));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST3)) {
      eligibilitySummaryDB.setCdEligCsupQuest3(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST3));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST4)) {
      eligibilitySummaryDB.setCdEligCsupQuest4(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST4));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST5)) {
      eligibilitySummaryDB.setCdEligCsupQuest5(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST5));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST6)) {
      eligibilitySummaryDB.setCdEligCsupQuest6(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST6));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_CSUP_QUEST7)) {
      eligibilitySummaryDB.setCdEligCsupQuest7(ContextHelper.getStringSafe(request,
                                                                           EligibilitySummaryDB.CD_ELIG_CSUP_QUEST7));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_MED_ELIG_GROUP)) {
      eligibilitySummaryDB.setCdEligMedEligGroup(ContextHelper.getStringSafe(request,
                                                                             EligibilitySummaryDB.CD_ELIG_MED_ELIG_GROUP));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_ELIG_SELECTED)) {
      eligibilitySummaryDB.setCdEligSelected(ContextHelper.getStringSafe(request,
                                                                         EligibilitySummaryDB.CD_ELIG_SELECTED));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_FCE_ELIG_REASON)) {
      eligibilitySummaryDB.setCdFceEligReason(ContextHelper.getStringSafe(request,
                                                                         EligibilitySummaryDB.CD_FCE_ELIG_REASON));
    }
    if (map.containsKey(EligibilitySummaryDB.CD_EVENT_STATUS)) {
      eligibilitySummaryDB.setCdEventStatus(ContextHelper.getStringSafe(request, EligibilitySummaryDB.CD_EVENT_STATUS));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_CSUP_REFERRAL_STRING)) {
      eligibilitySummaryDB.setDtEligCsupReferralString(ContextHelper.getStringSafe(request,
                                                                                   EligibilitySummaryDB.DT_ELIG_CSUP_REFERRAL_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_CSUP_REFERRAL_TIME)) {
      eligibilitySummaryDB.setDtEligCsupReferralTime(ContextHelper.getLongSafe(request,
                                                                               EligibilitySummaryDB.DT_ELIG_CSUP_REFERRAL_TIME));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_END_STRING)) {
      eligibilitySummaryDB.setDtEligEndString(ContextHelper.getStringSafe(request,
                                                                          EligibilitySummaryDB.DT_ELIG_END_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_END_TIME)) {
      eligibilitySummaryDB.setDtEligEndTime(ContextHelper.getLongSafe(request, EligibilitySummaryDB.DT_ELIG_END_TIME));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_REVIEW_STRING)) {
      eligibilitySummaryDB.setDtEligReviewString(ContextHelper.getStringSafe(request,
                                                                             EligibilitySummaryDB.DT_ELIG_REVIEW_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_REVIEW_TIME)) {
      eligibilitySummaryDB.setDtEligReviewTime(ContextHelper.getLongSafe(request,
                                                                         EligibilitySummaryDB.DT_ELIG_REVIEW_TIME));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_START_STRING)) {
      eligibilitySummaryDB.setDtEligStartString(ContextHelper.getStringSafe(request,
                                                                            EligibilitySummaryDB.DT_ELIG_START_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_ELIG_START_TIME)) {
      eligibilitySummaryDB.setDtEligStartTime(ContextHelper.getLongSafe(request,
                                                                        EligibilitySummaryDB.DT_ELIG_START_TIME));
    }
    if (map.containsKey(EligibilitySummaryDB.ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      eligibilitySummaryDB.setEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                        EligibilitySummaryDB.ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      eligibilitySummaryDB.setEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                    EligibilitySummaryDB.ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(EligibilitySummaryDB.ELIGIBILITY_ID_CASE)) {
      eligibilitySummaryDB.setEligibilityIdCase(ContextHelper.getLongSafe(request,
                                                                          EligibilitySummaryDB.ELIGIBILITY_ID_CASE));
    }
    if (map.containsKey(EligibilitySummaryDB.ELIGIBILITY_ID_PERSON)) {
      eligibilitySummaryDB.setEligibilityIdPerson(ContextHelper.getLongSafe(request,
                                                                            EligibilitySummaryDB.ELIGIBILITY_ID_PERSON));
    }
    if (map.containsKey(EligibilitySummaryDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      eligibilitySummaryDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                           EligibilitySummaryDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      eligibilitySummaryDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                       EligibilitySummaryDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_CASE)) {
      eligibilitySummaryDB.setIdCase(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_CASE));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_ELIG_EVENT)) {
      eligibilitySummaryDB.setIdEligEvent(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_ELIG_EVENT));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_ELIGIBILITY_EVENT)) {
      eligibilitySummaryDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request,
                                                                           EligibilitySummaryDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_FCE_APPLICATION)) {
      eligibilitySummaryDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                         EligibilitySummaryDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_FCE_ELIGIBILITY)) {
      eligibilitySummaryDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                         EligibilitySummaryDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_FCE_PERSON)) {
      eligibilitySummaryDB.setIdFcePerson(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_FCE_PERSON));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_FCE_REVIEW)) {
      eligibilitySummaryDB.setIdFceReview(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_LAST_UPDATE_PERSON)) {
      eligibilitySummaryDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                           EligibilitySummaryDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_PERSON)) {
      eligibilitySummaryDB.setIdPerson(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_PERSON));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_PERSON_UPDATE)) {
      eligibilitySummaryDB.setIdPersonUpdate(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_PERSON_UPDATE));
    }
    if (map.containsKey(EligibilitySummaryDB.ID_STAGE)) {
      eligibilitySummaryDB.setIdStage(ContextHelper.getLongSafe(request, EligibilitySummaryDB.ID_STAGE));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_CHILD_SUPPORT_ORDERED)) {
      eligibilitySummaryDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                                  EligibilitySummaryDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_ELIG_CSUP_SEND)) {
      eligibilitySummaryDB.setIndEligCsupSend(ContextHelper.getBooleanSafe(request,
                                                                           EligibilitySummaryDB.IND_ELIG_CSUP_SEND));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_ELIG_WRITE_HISTORY)) {
      eligibilitySummaryDB.setIndEligWriteHistory(ContextHelper.getBooleanSafe(request,
                                                                               EligibilitySummaryDB.IND_ELIG_WRITE_HISTORY));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_ELIGIBLE)) {
      eligibilitySummaryDB.setIndEligible(ContextHelper.getBooleanSafe(request, EligibilitySummaryDB.IND_ELIGIBLE));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_REVIEW_CREATED)) {
      eligibilitySummaryDB.setIndReviewCreated(ContextHelper.getBooleanSafe(request, EligibilitySummaryDB.IND_REVIEW_CREATED));
    }
    if (map.containsKey(EligibilitySummaryDB.TXT_CHILD_SUPP_REF_COMMENT)) {
      eligibilitySummaryDB.setTxtChildSuppRefComment(ContextHelper.getStringSafe(request,
                                                                         EligibilitySummaryDB.TXT_CHILD_SUPP_REF_COMMENT));
    }
    if (map.containsKey(EligibilitySummaryDB.TXT_ELIG_COMMENT)) {
      eligibilitySummaryDB.setTxtEligComment(ContextHelper.getStringSafe(request,
                                                                         EligibilitySummaryDB.TXT_ELIG_COMMENT));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_NON_PRS_PAID_PLACEMENT)) {
      eligibilitySummaryDB.setIndNonPrsPaidPlacement(ContextHelper.getBooleanSafe(request,
                                                                                  EligibilitySummaryDB.IND_NON_PRS_PAID_PLACEMENT));
    }
    if (map.containsKey(EligibilitySummaryDB.IND_NO_ACTIVE_PLACEMENT)) {
      eligibilitySummaryDB.setIndNoActivePlacement(ContextHelper.getBooleanSafe(request,
                                                                                EligibilitySummaryDB.IND_NO_ACTIVE_PLACEMENT));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_CHILD_BIRTH_STRING)) {
      eligibilitySummaryDB.setDtChildBirthString(ContextHelper.getStringSafe(request,
                                                                             EligibilitySummaryDB.DT_CHILD_BIRTH_STRING));
    }
    if (map.containsKey(EligibilitySummaryDB.DT_CHILD_BIRTH_TIME)) {
      eligibilitySummaryDB.setDtChildBirthTime(ContextHelper.getLongSafe(request,
                                                                         EligibilitySummaryDB.DT_CHILD_BIRTH_TIME));
    }
  }

  /**
   * Stage Access Rights
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

}
