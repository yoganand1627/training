package gov.georgia.dhr.dfcs.sacwis.web.investigation;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.MessageLookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CastorArrayHelper;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.Assessment;
import gov.georgia.dhr.dfcs.sacwis.service.assessment.SaveServicesAndReferrals;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV54SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV55SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCINV55SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV54SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV54SOG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

/********************************************************************************
 **  SrvcRfrrlsCheklistConversation.java
 ********************************************************************************/

/**
 * The Services and Referrals is a checklist of client needs. It is provided by workers to their clients.  It is a
 * requirement to complete prior to saving and submitting an investigation.  This window is accessible from the
 * Navigationa Metaphor,Event List, Case to Do List and Staff To Do List.  This window performs its own retrievals from
 * the database using service CINV54S.src and saves data using service CINV55S.src
 *
 * @author Merle A. Demo, Dec 4, 2002
 *         <p/>
 *         <pre>
 *                 Change History:
 *                  Date        User      Description
 *                  ----------  --------  --------------------------------------------------
 *                  05/10/2003    KRD     SIR 17233 - Code changes applied to support
 *                                        "Approver Mode" providing supervisors the ability to
 *                                        modify data without invalidating the pending
 *                                        approval.  Required changes to
 *                                        populateCINV55SI_AUD().
 *                  06/06/03  GRIMSHAN    SIR 16979 - Retrieve page mode from event search
 *                                        conversation if the page mode does not need to be
 *                                        changed, it will not be
 *                  07/01/03    Demo      Sir 18612 - added call to save service it was ridden
 *                                        in alot of used code.
 *                  07/14/03  GRIMSHAN    SIR 18808 - The invalidate approval messaging was
 *                                        removed as this page does not invalidate any pending
 *                                        approval.
 *                  07/21/03  CASDORJM    SIR 18911 - Changed what message displays when no
 *                                        initial contact has been recorded.  The message used
 *                                        to state "An initial contact must be recorded before
 *                                        concluding the investigation." which was confusing the
 *                                        user.  The new message states ... "An initial contact
 *                                        must be recorded before completing the checklist."
 *                  06/28/04  RIOSJA      SIR 16114 - Services and Referrals Checklist will now
 *                                        be available in all family stages (FPR, FRE and FSU),
 *                                        as well as CPS INV stages. Three new task codes were
 *                                        added--one for each family stage. The task code will
 *                                        be passed to the save service. Also, a new Services
 *                                        and Referrals Checklist in the FRE stage will pre-fill
 *                                        with the values from the Services and Referrals
 *                                        Checklist in the immediately preceding FSU stage.
 *                 </pre>
 */
public class SrvcsRfrrlsChecklistConversation extends BaseHiddenFieldStateConversation {

  private Assessment assessment;

  public void setAssessment(Assessment assessment) {
    this.assessment = assessment;
  }

  private SaveServicesAndReferrals saveServicesAndReferrals;

  public void setSaveServicesAndReferrals(SaveServicesAndReferrals saveServicesAndReferrals) {
    this.saveServicesAndReferrals = saveServicesAndReferrals;
  }

  /**
   * Activity methods displaySrvcsRfrrlsChecklist_xa calls service cinv45s. This service returns data from the event,
   * cps_checklist and cps_checklist_item tables.  It uses the event id and stage id for existing records and a null
   * event id for new records
   *
   * @param context container for request, session and state
   */
  public void displaySrvcsRfrrlsChecklist_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displaySrvcsRfrrlsChecklist_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    state.removeAllAttributes(request);

    try {
      // SIR 16979 set page mode in the conversation based on app mode.
      PageMode.setPageMode(GlobalData.getAppMode(request), request);

      // Load fields need for service CINV54
      CINV54SI cinv54si = populateCINV54SI_Retrieve(context);
      //String outputXml = WtcHelper.callService("CINV54S", cinv54si);
      //  CINV54SO cinv54so = CINV54SO.unmarshal(new StringReader(outputXml));
      CINV54SO cinv54so = assessment.retrieveServicesReferralsChecklist(cinv54si);
      ROWCINV54SOG00 checklist = cinv54so.getROWCINV54SOG00();

      // RIOSJA, SIR 16114 - If we are in an FRE stage and this is a new
      // Services and Referrals Checklist, we will pre-fill the Checklist with
      // the values from the Services and Referrals Checklist from the FSU stage
      // that directly preceded this stage. If this has been done, reset the
      // id's and timestamps, and post a message to the user informing them that
      // the data has been imported and they must save the page.
      if (request.getAttribute("bSvcsReferralsImportedFromFSU") != null) {
        cinv54so.getROWCINV54SOG00().setUlIdEvent(0);
        cinv54so.getROWCINV54SOG00().setUlIdStage(0);
        cinv54so.getROWCINV54SOG00().setUlIdCpsChecklist(0);
        cinv54so.getROWCINV54SOG00().setTsLastUpdate(null);
        setInformationalMessage(Messages.MSG_SVC_REFERRAL_IMPORTED_FSU, request);
        setPopUpMessage(Messages.MSG_SVC_REFERRAL_IMPORTED_FSU, request);
      }

      // SIR 16979 get the page mode from event search conversation if the page mode
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      PageMode.setPageMode(pageMode, request);

      // Load the array to be used with Checkbox Helper
      ROWCINV54SOG01_ARRAY rowArray = cinv54so.getROWCINV54SOG01_ARRAY();
      List checkedValues = CastorArrayHelper.getStringVector(rowArray, "szCdSvcReferred");

      checklist.setUlIdStage(GlobalData.getUlIdStage(request));
      checklist.setUlIdCase(GlobalData.getUlIdCase(request));
      state.setAttribute("CINV54SO", cinv54so, request);
      state.setAttribute("checkedValues", checkedValues, request);
      state.setAttribute("ROWCINV54SOG00", checklist, request);
      state.setAttribute("ROWCINV54SOG01_ARRAY", rowArray, request);
    }
    catch (ServiceException we) {
      handleError54(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * *  saveSrvcsRfrrlsChecklist_xa calls service cinv55. The save calls service CINV55SI  This service can insert or
   * update the event and cps_checklist tables.  Also it can delete or add rows to the cps_checklist_item table.
   *
   * @param context container for request, session and state
   */
  public void saveSrvcsRfrrlsChecklist_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveResourceList_xa()");
    performanceTrace.enterScope();

    GrndsTrace.enterScope(TRACE_TAG + ".saveSrvcsRfrrlsChecklist");

    try {
      CINV55SI cinv55si = populateCINV55SI_AUD(context);
      //Sir 18612  call to save made here.
      // Replaced by next line : WtcHelper.callService("CINV55S", cinv55si);
//      assessment.saveServicesAndReferralsInformation( cinv55si );
      saveServicesAndReferrals.saveServicesAndReferralsInformation(cinv55si);
    }
    catch (ServiceException we) {
      handleError55(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * method populateCINV54SI_Retrieve sets fields for service cinv45.
   *
   * @param context container for request, session and state
   * @return CINV54SI object
   */
  private CINV54SI populateCINV54SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV54SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CINV54SI cinv54si = new CINV54SI();
    ArchInputStruct input = new ArchInputStruct();
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);

    // RIOSJA, SIR 16114 - Services and Referrals Checklist will now be available
    // in all family stages (FPR, FRE and FSU), as well as CPS INV stages. Three
    // new task codes were added--one for each family stage; so we need to use
    // the correct task codes based upon the current stage.
    String taskCode = INV_CHECKLIST_TASK_CODE;
    if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FPR_CHECKLIST_TASK_CODE;
    } else if (CodesTables.CSTAGES_FRE.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FRE_CHECKLIST_TASK_CODE;
    } else if (CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FSU_CHECKLIST_TASK_CODE;
    }

    //HD 5/20/2003 -- Use case utility to retrieve event info, then put the
    //event id into GlobalData for later use
    int idEvent = CaseUtility.getEvent(GlobalData.getUlIdStage(request),
                                       taskCode).getIdEvent();
    GlobalData.setUlIdEvent(idEvent, request);

    // By default, we will use the values in GlobalData for retrieving the
    // Services and Referrals Checklist data.
    cinv54si.setUlIdEvent(GlobalData.getUlIdEvent(request));
    cinv54si.setUlIdStage(GlobalData.getUlIdStage(request));
    /* RIOSJA, SIR 16114 */
    cinv54si.setSzCdStage(GlobalData.getSzCdStage(request));

    // RIOSJA, SIR 16114 - If we are in an FRE stage and this is a new Services
    // and Referrals Checklist, we want to pre-fill the Checklist with the
    // values from the Services and Referrals Checklist from the FSU stage that
    // directly preceded this FRE stage. This is how we will find the FSU stage:
    // 1.) The FSU stage will be the immediately prior stage if the worker
    //     manually progressed the case from FSU to FRE; in this situation,
    //     we'll just get the FRE stage's prior stage.
    // 2.) If the FRE stage was created when the worker closed the last SUB
    //     stage's placement with "child returned home", however, the FRE
    //     stage's immediately prior stage will be the SUB stage; in this
    //     situation, we'll get the FRE stage's prior stage, which will be the
    //     SUB stage; then we'll get the SUB stage's prior stage, which will be
    //     the stage during which the child was removed from the home; then
    //     we'll find the FSU stage that was created from that stage. Since the
    //     SUB and FSU stages are created at the same time, we know that this
    //     will be the correct FSU stage.
    if (idEvent == 0 &&
        CodesTables.CSTAGES_FRE.equals(GlobalData.getSzCdStage(request))) {
      int importFromThisFSUStageId = 0;

      // Get the stage that preceded this FRE stage.
      CaseUtility.Stage priorStage =
              CaseUtility.getPriorStage(GlobalData.getUlIdStage(request));

      // If the prior stage is an FSU stage (see situation 1 above), import the
      // Services and Referrals Checklist data from that stage; otherwise, find
      // the FSU stage using the situation 2 described above.
      if (priorStage.getCdStage() != null &&
          CodesTables.CSTAGES_FSU.equals(priorStage.getCdStage())) {
        importFromThisFSUStageId = priorStage.getIdStage();
      } else {
        // Get the stage prior to the FRE stage's prior stage.
        CaseUtility.Stage priorPriorStage =
                CaseUtility.getPriorStage(priorStage.getIdStage());

        // Get the FSU stage that was created from that prior stage.
        CaseUtility.Stage fsuStage =
                CaseUtility.getStageByTypeAndPriorStage(priorPriorStage.getIdStage(),
                                                        CodesTables.CSTAGES_FSU);

        // If an FSU stage was found, import the Services and Referrals
        // Checklist data from that stage
        if (fsuStage.getCdStage() != null &&
            CodesTables.CSTAGES_FSU.equals(fsuStage.getCdStage())) {
          importFromThisFSUStageId = fsuStage.getIdStage();
        }
      }

      // If the prior FSU stage was found, query the event info for its Services
      // and Referrals Checklist, and pass that info to the retrieve service.
      if (importFromThisFSUStageId > 0) {
        idEvent = CaseUtility.getEvent(importFromThisFSUStageId,
                                       FSU_CHECKLIST_TASK_CODE).getIdEvent();
        if (idEvent > 0) {
          cinv54si.setUlIdEvent(idEvent);
          cinv54si.setUlIdStage(priorStage.getIdStage());
          cinv54si.setSzCdStage(priorStage.getCdStage());
          request.setAttribute("bSvcsReferralsImportedFromFSU", true);
        }
      }
    }

    cinv54si.setArchInputStruct(input);
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv54si;
  }

  /**
   * method populateCINV55SI_AUD sets the fields for service cinv55.
   *
   * @param context container for request, session and state
   * @return CINV55SI object
   * @throws Exception
   */
  private CINV55SI populateCINV55SI_AUD(GrndsExchangeContext context)
          throws Exception {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCINV55SI_AUD()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    CINV55SI cinv55si = new CINV55SI();
    ArchInputStruct input = new ArchInputStruct();

    UserProfile userProfile1 = UserProfileHelper.getUserProfile(context);

    // ROWCINV55SIG00 is for manipulating table cps_checklist_item
    ROWCINV55SIG00_ARRAY rowcinv55sig00_array = new ROWCINV55SIG00_ARRAY();
    // ROWCINV55SIG01 is for manipulating table cps_checklist
    ROWCINV55SIG01 rowcinv55sig01 = new ROWCINV55SIG01();

    //begin: populate the input array from the checkboxes and the output object
    ROWCINV54SOG01_ARRAY rowcinv54sog01Array =
            (ROWCINV54SOG01_ARRAY) state.getAttribute("ROWCINV54SOG01_ARRAY", request);

    if (rowcinv54sog01Array != null) {
      // RIOSJA, SIR 16114 - For a new Services and Referrals Checklist in the
      // FRE stage, we will pre-fill the Checklist with values from the Services
      // and Referrals Checklist in the FSU that immediately preceded the FRE
      // stage. To save the data to the database, we must use "getCheckedValues"
      // to get the list of the services that have been checked. We cannot use
      // "getChangedValues" because that method will not "grab" the services
      // that pre-filled the page and they will not be saved to the database.
      if (GlobalData.getUlIdEvent(request) == 0) {
        String[] checkedValues =
                CheckboxHelper.getCheckedValues(request,
                                                "cbxCIndSvcRefChklstNoRef");
        for (int i = 0; i < checkedValues.length; i++) {
          ROWCINV55SIG00 rowcinv55sig00 = new ROWCINV55SIG00();
          rowcinv55sig00.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
          rowcinv55sig00.setSzCdSvcReferred(checkedValues[i]);
          rowcinv55sig00_array.addROWCINV55SIG00(rowcinv55sig00);
        }
      } else {
        Collection changedValues =
                CheckboxHelper.getChangedValues(request,
                                                "cbxCIndSvcRefChklstNoRef",
                                                rowcinv54sog01Array,
                                                ROWCINV54SOG01.class,
                                                "szCdSvcReferred");
        for (Iterator i = changedValues.iterator(); i.hasNext();) {
          CheckboxHelper.ObjectActionCodePair pair =
                  (CheckboxHelper.ObjectActionCodePair) i.next();

          ROWCINV54SOG01 row = (ROWCINV54SOG01) pair.getObject();
          String action = pair.getActionCode();

          ROWCINV55SIG00 rowcinv55sig00 = new ROWCINV55SIG00();
          rowcinv55sig00.setSzCdScrDataAction(action);
          rowcinv55sig00.setTsLastUpdate(row.getTsLastUpdate());
          rowcinv55sig00.setSzCdSvcReferred(row.getSzCdSvcReferred());
          rowcinv55sig00.setUlIdChklstItem(row.getUlIdChklstItem());
          rowcinv55sig00.setUlIdCpsChecklist(row.getUlIdCpsChecklist());
          rowcinv55sig00_array.addROWCINV55SIG00(rowcinv55sig00);
        }
      }
    }
    //end: populate the input array from the checkboxes and the output object

    if (GlobalData.getUlIdEvent(request) == 0) {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
      rowcinv55sig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_ADD);
    } else {
      input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowcinv55sig01.setSzCdScrDataAction(ServiceConstants.REQ_FUNC_CD_UPDATE);
      rowcinv55sig01.setUlIdCpsChecklist(ContextHelper.getIntSafe(request, "txtUlIdCpsChecklist"));
      rowcinv55sig01.setTsLastUpdate(ContextHelper.getJavaDateSafe(request, "tsLastUpdate"));
    }

    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(rowcinv55sig00_array.getROWCINV55SIG00Count());
    // SIR 17233 - set the flag indicating approver mode
    input.setUlSysNbrReserved1(GlobalData.getApprovalFlag(request));

    String noRef = CheckboxHelper.getCheckboxValue(request, "cbxIndSvcRefChklstNoRef");
    rowcinv55sig01.setCIndSvcRefChklstNoRef(noRef);
    rowcinv55sig01.setUlIdEvent(GlobalData.getUlIdEvent(request));
    rowcinv55sig01.setUlIdCase(GlobalData.getUlIdCase(request));
    rowcinv55sig01.setUlIdStage(GlobalData.getUlIdStage(request));
    rowcinv55sig01.setDtDtFirstReferral(ContextHelper.getCastorDateSafe(context, "dtDtFirstReferral"));

    // RIOSJA, SIR 16114 - Services and Referrals Checklist will now be available
    // in all family stages (FPR, FRE and FSU), as well as CPS INV stages. Three
    // new task codes were added--one for each family stage; so we need to use
    // the correct task codes based upon the current stage.
    String taskCode = INV_CHECKLIST_TASK_CODE;
    if (CodesTables.CSTAGES_FPR.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FPR_CHECKLIST_TASK_CODE;
    } else if (CodesTables.CSTAGES_FRE.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FRE_CHECKLIST_TASK_CODE;
    } else if (CodesTables.CSTAGES_FSU.equals(GlobalData.getSzCdStage(request))) {
      taskCode = FSU_CHECKLIST_TASK_CODE;
    }
    rowcinv55sig01.setSzCdTask(taskCode);

    //Caps saves rbCdFamilyResponse as a null when noRef is a "Y"
    if ("N".equals(noRef)) {
      rowcinv55sig01.setSzCdFamilyResponse(ContextHelper.getString(request, "rbCdFamilyResponse"));
    }

    rowcinv55sig01.setSzTxtChklstComments(ContextHelper.getStringSafe(request, "txtChklstComments"));

    cinv55si.setArchInputStruct(input);
    cinv55si.setROWCINV55SIG01(rowcinv55sig01);
    cinv55si.setROWCINV55SIG00_ARRAY(rowcinv55sig00_array);
    cinv55si.setUlIdPerson(userProfile1.getUserID());
    cinv55si.setUlRowQty(ulRowQty);

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return cinv55si;
  }

  /**
   * Error handlers for service CINV54.
   *
   * @param context container for request, session and state
   * @param we      WtcException server return error
   */

  private void handleError54(ServiceException we, GrndsExchangeContext context) {
    switch (we.getErrorCode()) {
      case Messages.MSG_INV_NOT_BEGUN:
        // JMC - SIR 18911 - Changed message according to SIR.
        String errorMessage = MessageLookup.getMessageByNumber(Messages.MSG_INV_NOT_BEGUN_CHKLST);
        displayMessagePage(errorMessage, context);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  /**
   * Error handlers for service CINV55SO.
   *
   * @param context container for request, session and state
   * @param we      WtcException
   */
  private void handleError55(ServiceException we, GrndsExchangeContext context) {
    switch (we.getErrorCode()) {
      case Messages.MSG_DUPLICATE_RECORD:
        String errorMessage1 = MessageLookup.getMessageByNumber(Messages.MSG_DUPLICATE_RECORD);
        setErrorMessage(errorMessage1, SERVICES_REFERRALS_PAGE, context.getRequest());
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        String errorMessage2 = MessageLookup.getMessageByNumber(Messages.MSG_CMN_TMSTAMP_MISMATCH);
        setErrorMessage(errorMessage2, SERVICES_REFERRALS_PAGE, context.getRequest());
        break;
      case Messages.MSG_SYS_STAGE_CLOSED:
        String errorMessage3 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_STAGE_CLOSED);
        setErrorMessage(errorMessage3, SERVICES_REFERRALS_PAGE, context.getRequest());
        break;
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
        String errorMessage4 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_EVENT_STS_MSMTCH);
        setErrorMessage(errorMessage4, SERVICES_REFERRALS_PAGE, context.getRequest());
        break;
      case Messages.MSG_SYS_MULT_INST:
        String errorMessage5 = MessageLookup.getMessageByNumber(Messages.MSG_SYS_MULT_INST);
        setErrorMessage(errorMessage5, SERVICES_REFERRALS_PAGE, context.getRequest());
        break;
      case Messages.MSG_INV_NOT_BEGUN_CHKLST:
        String errorMessage6 = MessageLookup.getMessageByNumber(Messages.MSG_INV_NOT_BEGUN_CHKLST);
        setErrorMessage(errorMessage6, SERVICES_REFERRALS_PAGE, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  // static constantsUsPageNbr
  public static final String EVENT_STATUS_PENDING = "PEND";
  public static final int usPageNbr = 1;
  public static final int ulRowQty = 1;
  public static final int ulPageSizeNbr = 50;  /* RIOSJA, SIR 16114 */
  public static final String TRACE_TAG = "SrvcsRfrrlsChecklistConversation";
  public static final String SERVICES_REFERRALS_PAGE =
          "/investigation/SrvcsRfrrlsChecklist/displaySrvcsRfrrlsChecklist";
  public static final String EVENT_LIST_PAGE = "event";
  public static final String TRUE = "Y";
  public static final String FALSE = "N";
  public static final String FPR_CHECKLIST_TASK_CODE = "2306";
  public static final String FRE_CHECKLIST_TASK_CODE = "2307";
  public static final String FSU_CHECKLIST_TASK_CODE = "2308";
  public static final String INV_CHECKLIST_TASK_CODE = "2309";
}
