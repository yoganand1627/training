//*  Name:     Call Log Conversation
//*  Created by:   Michael Ochu
//*  Date Created: 01/05/2003
//*
//*  Description:
//*  The Call Log page allows a user to search for a particular caller,
//*  collateral, principal, inregard to, or calls taken by an employee.  From
//*  this page, the user can navigate to intake call log (Call Summary) in modify mode via the
//*  New Using menu item or to Call Summary in browse mode via the caller hyperlink.
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
//**  07/13/03   JMC              SIR 18877 - Changed newUsingIntake_xa() to allow a new
//**                              using for stage classifications that started with "A"
//**                              when the user's program was APS.  Originally we only
//**                              allowed newUsing on stages classified as APS when the
//**       .set                       user's program was APS.  This meant that AFC stages
//**                              could not be newUsed by APS users.
//**                              Sir 22964 -- Added code to allow a search by I&R and I&R Type only.
//**  10/26/04  dejuanr           SIR 23188 -- Call Log was letting ppl without senstive case
//**                              access new use senstive cases.  Code was looking for a !
//**                              rather than a Y.
//** 10/29/04  ochumd             Sir 23221 -- Changed formatting helper from
//**                              initCaps to changeCase, this will allow hyphenated
//**                              name searches to return the correct results.
//** 01/07/2005 Ochumd            Sir 22965 -- Added displayEventListFromCallLog_xa
//**                              to set Globaldata Id_stage whenever a user clicks
//**                              I&R hyperlink from the search list.
//** 04/25/2005 Ochumd            Sir 23208-Intake workers receive an error message
//**                              when they try to new use an e-report intake.
//**                              This is because,an e-report is incomplete and
//**                              needs to be completed first from intake action
//**                              page before new using hence MSG_INT_E_RPT_NEW_USING.

package gov.georgia.dhr.dfcs.sacwis.web.intake;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.base.BaseValueBean;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.intake.Intake;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListInStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CallListSrchInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CallListSrchOutRec;
import gov.georgia.dhr.dfcs.sacwis.web.core.base.ValueBeanHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.pagination.TuxedoPaginationValueBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

//*  The Call Log page allows a user to search for a particular caller,
//*  collateral, principal, inregard to, or calls taken by an employee.  From
//*  this page, the user can navigate to intake call log (Call Summary) in modify mode via the
//*  New Using menu item or to Call Summary in browse mode via the caller hyperlink.
/*
 * @author
 * Michael Ochu, Dec 15, 2002
 */

public class CallLogConversation extends BaseHiddenFieldStateConversation {

  public static final String PERSON_TYPE_CALLER = "CAL";
  public static final String INCMG_STATUS_CD_OPEN = "OPN";
  public static final String STAGE_CD_PRIORITY_NONE = ArchitectureConstants.N;
  public static final String CLASS_PREFIX_APS = "APS";
  public static final String SENSITIVE_CALL = ArchitectureConstants.Y;
  public static final String CAPS_WIN_MODE_NEW_USING_OPEN = "O";
  public static final String CAPS_WIN_MODE_NEW_USING_CWA = "C";
  public static final String CAPS_WIN_MODE_NEW_USING_APS = "S";
  public static final String CAPS_WIN_MODE_NEW_USING_CAR = "R";
  public static final String SEARCH_TYPE_CALL_ID = "2222";
  public static final String SEARCH_TYPE_START_END_DATE = "3333";
  public static final String CD_REGION_STATE_WIDE = "98";
  public static final String NULL_TIME = "null";
  public static final String TRACE_TAG = "CallLogConversation";
  public static final String NO_RESULTS_FOUND = "NO_RESULTS_FOUND";
  public static final String NO_PHONETIC_RESULTS_RETURNED = "NO_PHONETIC_RESULTS_RETURNED";
  protected static final int RESULTS_PER_PAGE = 50;
  private Intake intake1;

  public void setIntake(Intake intake1) {
    this.intake1 = intake1;
  }

  /**
   * This method is called by the GRNDS controller when a user searches for a caller etc.
   *
   * @param context The GrndsExchangeContext object.
   */
  public void displayCallLog_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, ".displayCallLog_xa()");

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    // JMC - 050603 - The follow try catch block will autoSave the Call Information page and
    // Intake Actions page if the user makes changes to the page then clicks the Call Log Tab.
    try {
      if (StringHelper.isValid(ContextHelper.getStringSafe(request, "hdnSaveIntakeActions")) &&
          (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "hdnIsIntakeActionsDirty")))) {
        IntakeActionsConversation.saveIntakeActions(context, intake1);
      } else if (StringHelper.isValid(ContextHelper.getStringSafe(request, "hdnSaveCallInformation")) &&
                 (ArchitectureConstants.TRUE.equals(ContextHelper.getStringSafe(request, "hdnIsCallInfoDirty")))) {
        CallInformationConversation.saveCallInformation(context, intake1);
      }
    }
    catch (ServiceException we) {
      setErrorMessage(we.getErrorCode(), request);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    // End - JMC - 050603
    // Clear the state. This will clear PageMode, because PageMode is stored in state.
    state.removeAllAttributes(request);
    PageMode.setPageMode(PageModeConstants.EDIT, request);

    performanceTrace.exitScope();
  }

  /**
   * Searches the database for data that match the specified search criteria.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void searchCallLog_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, ".searchCallLog_x()");

    HttpServletRequest request = context.getRequest();

    try {
      TuxedoPaginationValueBean pagination = new TuxedoPaginationValueBean();
      ValueBeanHelper.populateDefaultValues(context, pagination);
      pagination.getResultDetails().setResultsPerPage(RESULTS_PER_PAGE);
      int pageNumber = pagination.getResultDetails().getRequestedPage();
      int pageSize = pagination.getResultDetails().getResultsPerPage();

      CallListSrchInRec callListSrchInRec = populateCallListSrchInRec(context,
                                                                      pageNumber,
                                                                      pageSize);

      CallListSrchOutRec callListSrchOutRec = intake1.retrieveCallLog(callListSrchInRec);

      request.setAttribute("CallListSrchOutRec", callListSrchOutRec);

      pagination.setPaginationInformation(callListSrchOutRec.getArchOutputStruct(),
                                          callListSrchOutRec.getCallListStruct_ARRAY().getCallListStructCount());
      
      storePaginationBeanToRequest(context, pagination);

      request.setAttribute(BaseValueBean.REQUEST_ATTRIBUTE_NAME,
                           pagination);
      request.setAttribute(NO_RESULTS_FOUND, ArchitectureConstants.FALSE);
      request.setAttribute(NO_PHONETIC_RESULTS_RETURNED, ArchitectureConstants.FALSE);
    }
    catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + we.getMessage());
      switch (we.getErrorCode()) {
        case Messages.MSG_PHONETIC_SEARCH_PROCESS_FAILED:
          request.setAttribute(NO_PHONETIC_RESULTS_RETURNED, ArchitectureConstants.TRUE);
          break;
        case Messages.MSG_CMN_SEARCH_NOT_FOUND:
          request.setAttribute(NO_RESULTS_FOUND, ArchitectureConstants.TRUE);
          break;
        case Messages.ARC_UTL_YEAR_TOO_SMALL:
          setErrorMessage(Messages.ARC_UTL_YEAR_TOO_SMALL, context.getRequest());
          break;
        default:
          processSevereException(context, we);
          return;
      }
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Called by the searchCallLog_xa activity method to populate the input object for the CallLog search service.
   *
   * @param context The GrndeExchangeContext object.
   */
  private CallListSrchInRec populateCallListSrchInRec(GrndsExchangeContext context,
                                                      int pageNumber,
                                                      int pageSize) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "populateCallListSrchInRec()");

    HttpServletRequest request = context.getRequest();
    ArchInputStruct input = new ArchInputStruct();

    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    //Allocate the structures
    CallListInStruct callListInStruct = new CallListInStruct();
    CallListSrchInRec callListSrchInRec = new CallListSrchInRec();
    //Set the values for the ArchInputStruct
    input.setBPerfInd(ArchitectureConstants.Y);
    input.setBDataAcsInd(ArchitectureConstants.Y);
    input.setUsPageNbr(pageNumber);
    input.setUlPageSizeNbr(pageSize);
    input.setSzUserId(userProfile.getUserLogonID());
    callListSrchInRec.setArchInputStruct(input);
    if (ContextHelper.getIntSafe(context, "txtUlidStage") != 0) {
      callListInStruct.setUlIdStage(ContextHelper.getIntSafe(context, "txtUlidStage"));
    } else {
      //SIR 23221 -- Changed formatting helper from initCaps to changeCase.
      callListInStruct.setNmIncomingCallerFirst(FormattingHelper.changeCase(ContextHelper.getStringSafe(context,
                                                                                                        "txtFirstName")));
      callListInStruct.setNmIncomingCallerMiddle(FormattingHelper.changeCase(ContextHelper.getStringSafe(context,
                                                                                                         "txtMiddleInt")));
      callListInStruct.setNmIncomingCallerLast(FormattingHelper.changeCase(ContextHelper.getStringSafe(context,
                                                                                                       "txtLastName")));

      String selszCdStagePersType =
              ContextHelper.getStringSafe(context, "selszCdStagePersType");
      /*
       if (("".equals(selszCdStagePersType)) &&
       ("".equals(ContextHelper.getStringSafe(context, "txtFirstName")) == false)) {
       selszCdStagePersType = PERSON_TYPE_CALLER;
       }
       */
      callListInStruct.setSzCdStagePersType(selszCdStagePersType);
      request.setAttribute("selszCdStagePersType", selszCdStagePersType);
      callListInStruct.setSzCdStageClassification(ContextHelper.getStringSafe(context, "selszCdStageClassification"));
      callListInStruct.setSzAddrIncomingCallerCity(FormattingHelper.initCaps(ContextHelper.getStringSafe(context,
                                                                                                         "txtIncomingCallerCity")));
      callListInStruct.setSzCdIncomingCallerCounty(ContextHelper.getStringSafe(context, "selszCdIncomingCounty"));
      /*
       ** Only if the region is not state wide (98) do we pass it
       ** as a search parameter.  The reason being
       ** that if we were to pass it to the service as a search parameter,
       ** nothing would be returned since 98 is never written to the
       ** database.
       */
      String selszCdStageRegion = ContextHelper.getStringSafe(context, "selszCdStageRegion");
      if (!selszCdStageRegion.equals(CD_REGION_STATE_WIDE)) {
        callListInStruct.setSzCdStageRegion(ContextHelper.getStringSafe(context, "selszCdStageRegion"));
      } /* end if */ else {
        callListInStruct.setSzCdStageRegion(null);
      } /* end else */

      callListInStruct.setSzScrDtRangeFrom(ContextHelper.getCastorDateSafe(context, "dtrangeFrom"));
      callListInStruct.setSzScrDtRangeTo(ContextHelper.getCastorDateSafe(context, "dtrangeTo"));

      String szScrTimeFrom = ContextHelper.getTimeSafe(context, "szScrTimeFrom");
      String szScrTmTimeTo = ContextHelper.getTimeSafe(context, "szScrTmTimeTo");
      if (!"".equals(szScrTimeFrom)) {
        callListInStruct.setSzScrTimeFrom(szScrTimeFrom);
      }
      if (!"".equals(szScrTmTimeTo)) {
        callListInStruct.setSzScrTmTimeTo(szScrTmTimeTo);
      }
      callListInStruct.setSzCdStageCurrPriority(ContextHelper.getStringSafe(context, "selCdStageCurrPriority"));
      callListInStruct.setSzNbrUnit(ContextHelper.getStringSafe(context, "txtNbrUnit"));
      callListInStruct.setSzCdIncomingDisposition(ContextHelper.getStringSafe(context, "selszCdIncomingDisposition"));
      callListInStruct.setSzCdStageNonIncType(ContextHelper.getStringSafe(context, "selszCdStageNonIncType"));

    }
    callListSrchInRec.setCallListInStruct(callListInStruct);

    performanceTrace.exitScope();
    return callListSrchInRec;
  }

  /**
   * - JMC: Renamed Method and Added Comments 040903 - This method will be called when the user selects an INTAKE stage
   * from the Call Log and clicks the New Using button.  It will determine if the user can create a new intake using the
   * selected row and then pass the proper information/pageMode to the intake actions conversation.
   *
   * @param context The GrndeExchangeContext object.
   */
  public void newUsingIntake_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, ".newUsingIntake_xa()" + new Date());

    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    boolean bNewUsingIsOk = false;
    String cNewUsingMode = "";
    String userProgram;

    try {
      int userId = userProfile.getUserID();
      userProgram = userProfile.getUserProgram();

      if (!"".equals(ContextHelper.getStringSafe(context, "stageClassification"))) {
        if (userId == (ContextHelper.getIntSafe(context, "personId")) &&
            (ContextHelper.getStringSafe(context, "incomingStatus").equals(INCMG_STATUS_CD_OPEN))) {
          bNewUsingIsOk = true;
          cNewUsingMode = PageModeConstants.Intake.NEW_USING_OPEN;
        } else if (ContextHelper.getStringSafe(context, "incomingPriority").equals(STAGE_CD_PRIORITY_NONE)) {
          bNewUsingIsOk = true;
          cNewUsingMode = PageModeConstants.Intake.NEW_USING_CWA;
        }
        // JMC - SIR 18877 - This check should only make sure that the stage classification STARTS WITH
        // the APS prefix "A" instead of checking to make sure the classification was APS.  Commented out
        // line and replaced line below with correct logic.
        //else if (ContextHelper.getStringSafe(context, "stageClassification").equals(CodesTables.CPGRMS_APS) &&
        else if (ContextHelper.getStringSafe(context, "stageClassification").startsWith(
                IntakeConstants.CLASS_PREFIX_APS) &&
                                                  CodesTables.CPGRMS_APS.equals(userProgram)) {
          bNewUsingIsOk = true;
          cNewUsingMode = PageModeConstants.Intake.NEW_USING_APS;
        } else if (ArchitectureConstants.Y.equals(ContextHelper.getStringSafe(context, "indicatorSensitive"))) {
          bNewUsingIsOk = true;
          cNewUsingMode = PageModeConstants.Intake.NEW_USING_CAR;
        }/* end else */
      } //  end if (NULL != ...ClassificationData
      else //Sir 23208-Intake workers receive an error message when they try to
      // new use an e-report intake. This is because,an e-report is incomplete
      //and needs to be completed first from intake action page before new using.
      {
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME,
                                   context);
        setErrorMessage(Messages.MSG_INT_E_RPT_NEW_USING, request);
        return;
      }

      /*
      ** Check if the call is marked sensitive.  If so, verify if the worker
      ** who is trying to do the new using is either the same worker who took
      ** the original call, or if the worker is in the supervisory chain of the
      ** worker who took the original call, or finally, if that worker has
      ** sensitivity rights.
      */

      if (true == bNewUsingIsOk &&
          SENSITIVE_CALL.equals(ContextHelper.getStringSafe(context, "indicatorSensitive")))  // SIR 23188
      {
        if (!userProfile.hasRight(UserProfile.SEC_SENSITIVE_CASE_ACCESS) &&
            !CaseUtility.hasStageAccess(userProfile.getUserID(), ContextHelper.getIntSafe(context, "stageId"))) {
          bNewUsingIsOk = false;
          GrndsTrace.msg(TRACE_TAG, 12, "BNEWUSING is  \n" + bNewUsingIsOk);
        } /* end if */
      } /* end if */

      // JMC 040703 - Modified what Call Log is sending to Intake.  Also added a presentation branch.
      if (bNewUsingIsOk) {
        GlobalData.setUlIdStage(ContextHelper.getIntSafe(context, "stageId"), request);
        GlobalData.setAppMode(PageModeConstants.EDIT, request);
        PageMode.setPageMode(cNewUsingMode, request);
        request.setAttribute(GRNDS_QNAME_ATTRIBUTE, null);
      } else {
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME,
                                   context);

        setErrorMessage(Messages.MSG_INT_NO_ACCESS_NEW_USING, request);
      }
      // End JMC 040703
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p>This method is called when the user clicks on the Caller Name Hyperlink.  It calls intakeAction and passes it
   * the information it needs to populate. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callIntakeActionsSummary_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "callIntakeActionsSummary_xa()" + new Date());

    HttpServletRequest request = context.getRequest();
    if (ContextHelper.getIntSafe(context, "stageId") != 0) {
      GlobalData.setUlIdStage(ContextHelper.getIntSafe(context, "stageId"), request);
    }
    GlobalData.setAppMode(PageModeConstants.VIEW, request);
    request.removeAttribute(BasePrsConversation.GRNDS_QNAME_ATTRIBUTE);

    performanceTrace.exitScope();
  }

  /**
   * <p>This method is called when the user clicks on the I&R Hyperlink.  It calls event list and passes it the
   * information it needs to populate. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void displayEventListFromCallLog_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace =
            PerformanceTrace.enterScope(TRACE_TAG, "displayEventListFromCallLog_xa()" + new Date());

    HttpServletRequest request = context.getRequest();
    int inputIdstage = (ContextHelper.getIntSafe(context, "stageId"));
    if (inputIdstage != 0) {
      GlobalData.setUlIdStage(inputIdstage, request);
    }
    GlobalData.setAppMode(PageModeConstants.VIEW, request);
    request.removeAttribute(BasePrsConversation.GRNDS_QNAME_ATTRIBUTE);
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  
}
