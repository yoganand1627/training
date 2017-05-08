package gov.georgia.dhr.dfcs.sacwis.web.workload;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.PopulationException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.RuntimeWrappedException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveAdminReview;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveAdminReview;
import gov.georgia.dhr.dfcs.sacwis.structs.document.types.RenderType;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC43SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC44SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC43SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC44SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN50DO_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.admin.StaffSearchInput;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.initialize.TaskInit;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;

import java.io.StringReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to display and save the Admin Review page. It will also launch any documents
 * found on the page.
 * 
 * @author Rodrigo DeJuana <p/>
 * 
 * <pre>
 *         &lt;p/&gt;
 *                  Change History:
 *                   Date        User      Description
 *                   --------  ----------  --------------------------------------------------
 *                   06/06/03  GRIMSHAN    SIR 16979 - Retrieve page mode from event search
 *                                         conversation if the page mode does not need to be
 *                                         changed, it will not be
 *                   07/02/03  DEMOMA      Sir 18612 - Get UlIdEvent from CaseUtility.getEvent
 *                                         in display- AdmnReview because the UlIdEvent is not
 *                                         updated when you navigate from other tabs that Case
 *                                         Summary
 *                   06/28/04  Todd Reser  SIR 22937 - Added four CPS versions of Admin Review
 *                                         Forms to Constants.  Fixed PMD Errors.
 *                   07/01/04  Todd Reser  SIR 22937 - Added if Statements to all three
 *                                         displayDocument methods.
 * </pre>
 */
public class AdmnReviewConversation extends BaseHiddenFieldStateConversation {
  private RetrieveAdminReview retrieveAdminReview;

  public void setRetrieveAdminReview(RetrieveAdminReview retrieveAdminReview) {
    this.retrieveAdminReview = retrieveAdminReview;
  }

  private SaveAdminReview saveAdminReview;

  public void setSaveAdminReview(SaveAdminReview saveAdminReview) {
    this.saveAdminReview = saveAdminReview;
  }

  /**
   * This method will call the ccfc43s service to retreive the data to display the Admin Reveiw page. It will also
   * deteremine whcih documents will be displayed.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayAdmnReview_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayAdmnReview_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    state.removeAllAttributes(request);

    PageMode.setPageMode(GlobalData.getAppMode(request), request);
    // Sir 18612 the wrong event id is in GlobaData when you navigate from anything
    // else than Case Summary
    int eventID = 0;
    int stageID = GlobalData.getUlIdStage(request);

    CaseUtility.Event event = CaseUtility.getEvent(stageID, GlobalData.getSzCdTask(request));
    eventID = event.getIdEvent();
    GlobalData.setUlIdEvent(eventID, request);

    // SIR 16979 get the page mode from event search conversation if the page mode
    // does not need to be changed, it will not be
    String pageMode = EventSearchConversation.getEventDetailPageMode(request);
    PageMode.setPageMode(pageMode, request);
    try {
      CCFC43SI ccfc43si = populateCCFC43SI_Retrieve(context);
      // CCFC43SO ccfc43so = CCFC43SO.unmarshal(new StringReader(WtcHelper.callService("CCFC43S", ccfc43si)));
      CCFC43SO ccfc43so = retrieveAdminReview.retrieveAdminReview(ccfc43si);
      state.setAttribute("CCFC43SO", ccfc43so, request);

      // We need this in state in case teh user
      state.setAttribute("relatedStage", ccfc43so.getCCFC43SOG00().getUlIdStageRelated(), request);
      state.setAttribute("personRequestor", ccfc43so.getCCFC43SOG00().getUlIdPersonRequestor(), request);

      // Document toggle code. True means it is disabled.
      String bFindings = ArchitectureConstants.TRUE;
      String bReqParent = ArchitectureConstants.TRUE;
      String bNotif = ArchitectureConstants.TRUE;
      String bLic = ArchitectureConstants.TRUE;

      // For AFC program stages, hide licensing documents but show everything else
      if (GlobalData.getSzCdStageProgram(request).equals(AdmnReviewConversation.PROG_AFC)) {
        bFindings = ArchitectureConstants.FALSE;
        bReqParent = ArchitectureConstants.FALSE;
        bNotif = ArchitectureConstants.FALSE;
        bLic = ArchitectureConstants.TRUE;
      }
      // Show Admin Review and licensing documents for non-FA Home Decision appeals
      // on CCL or RCL program stages, but hide notifications/cover letters for parent,
      // reporter, and requester
      else if ((GlobalData.getSzCdStageProgram(request).equals(AdmnReviewConversation.PROG_CCL) || GlobalData
                                                                                                             .getSzCdStageProgram(
                                                                                                                                  request)
                                                                                                             .equals(
                                                                                                                     AdmnReviewConversation.PROG_RCL))
               && !ccfc43so.getCCFC43SOG00().getSzCdAdminRvAppealType().equals(CodesTables.CARVTYPE_020)) {
        bFindings = ArchitectureConstants.FALSE;
        bReqParent = ArchitectureConstants.TRUE;
        bNotif = ArchitectureConstants.TRUE;
        bLic = ArchitectureConstants.FALSE;
      }

      // Show Admin Review and parent/reporter notifications/cover letters for APS &
      // CPS program stages, but hide requester notifications and licensing documents
      else if (GlobalData.getSzCdStageProgram(request).equals(AdmnReviewConversation.PROG_APS)
               || GlobalData.getSzCdStageProgram(request).equals(AdmnReviewConversation.PROG_CPS)) {
        bFindings = ArchitectureConstants.FALSE;
        bReqParent = ArchitectureConstants.FALSE;
        bNotif = ArchitectureConstants.TRUE;
        bLic = ArchitectureConstants.TRUE;
      }

      // Hide notifications and cover letters to parent/requester for FA Home Decision appeals.
      String adminRvAppealType = ccfc43so.getCCFC43SOG00().getSzCdAdminRvAppealType();
      if (adminRvAppealType != null && adminRvAppealType.equals(CodesTables.CARVTYPE_020)) {
        bReqParent = ArchitectureConstants.TRUE;
      }

      // Finally, hide all reports unless event status is APPROVED.
      if (!ccfc43so.getROWCCMN01UIG00().getSzCdEventStatus().equals(STATUS_APPROVED)) {
        bFindings = ArchitectureConstants.TRUE;
        bReqParent = ArchitectureConstants.TRUE;
        bNotif = ArchitectureConstants.TRUE;
        bLic = ArchitectureConstants.TRUE;
      }

      request.setAttribute("bFindings", bFindings);
      request.setAttribute("bReqParent", bReqParent);
      request.setAttribute("bNotif", bNotif);
      request.setAttribute("bLic", bLic);
    } catch (ServiceException we) {
      // switch the response based on the Service Returned Error Code
      switch (we.getErrorCode()) {
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_NO_ROWS_RETURNED:
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }

    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method will call the ccfc44s service to save the Admin review page
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void saveAdmnReview_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveAdmnReview_xa()");
    performanceTrace.enterScope();

    try {

      CCFC44SI ccfc44si = populateCCFC44SI_Save(context);
      // CCFC44SO ccfc44so = CCFC44SO.unmarshal( new StringReader( WtcHelper.callService( "CCFC44S", ccfc44si ) ) );
      // request.setAttribute( "CCFC44SO", ccfc44so );

      // Service SO not used, so don't unmarshal or put into request attribute.
      CCFC44SO ccfc44so = saveAdminReview.saveAdminReview(ccfc44si);

      // displayAdmnReview_xa( context );

    } catch (ServiceException we) {
      // displayAdmnReview_xa( context );
      // switch the response based on the Service Returned Error Code
      int errorCode = we.getErrorCode();
      switch (errorCode) {
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, context.getRequest());
        break;
      case Messages.MSG_DUPLICATE_RECORD:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_NO_ROWS_RETURNED:
      case Messages.MSG_CMN_STAGE_CLOSED:
        /*
         * SIR# 18975. added case Messages.MSG_NO_APS_CONCL. ccfc44s.src also changed to fetch this error message
         */
      case Messages.MSG_NO_APS_CONCL:
      case Messages.MSG_NO_AFC_CONCL:
      case Messages.MSG_ARI_OVERALL_INTEG_1:
      case Messages.MSG_ARI_OVERALL_INTEG_2:
        setErrorMessage(errorCode, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
      }
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * This method call the person list page when a Notification to Parent/Prof Reporter forms is being generated.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayDocument_getPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDocument_getPerson_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCFC43SO ccfc43so = (CCFC43SO) state.getAttribute("CCFC43SO", request);

    state.setAttribute("ulIdStage", GlobalData.getUlIdStageAsString(request), request);
    GlobalData.setUlIdStage(ccfc43so.getCCFC43SOG00().getUlIdStageRelated(), request);

    String docName = ContextHelper.getStringSafe(request, "docType");
    String destUrl = StringHelper.EMPTY_STRING;

    // SIR 22937 - Had to add _CPS versions to the if Statements.
    if (docName.equals(ADMIN_REV_PARENT_ENG) || docName.equals(ADMIN_REV_PARENT_ENG_CPS)) {
      destUrl = "/workload/AdmnReview/displayDocument_setPerson";
    }
    if (docName.equals(ADMIN_REV_PARENT_SPA) || docName.equals(ADMIN_REV_PARENT_SPA_CPS)) {
      destUrl = "/workload/AdmnReview/displayDocument_setPerson_SP";
    }

    PersonListPullBackInfo personListPBInfo = new PersonListPullBackInfo();
    personListPBInfo.setDestinationUrl(destUrl);
    PageMode.setPageMode(PageModeConstants.PersonList.PRINC_ONLY, request);
    request.setAttribute(PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME, personListPBInfo);

    performanceTrace.exitScope();
  }

  /**
   * This method will set all the attributes the Notification to Parent/Prof Reported English will need to generate.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayDocument_setPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDocument_setPerson_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    GlobalData.setUlIdStage(Integer.parseInt((String) state.getAttribute("ulIdStage", request)), request);
    // state.removeAttribute( "ulIdStage", request );

    String pPerson = "";
    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) context
                                                                                    .getRequest()
                                                                                    .getAttribute(
                                                                                                  PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);

    if (personListPullBackInfo != null) {
      ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
      pPerson = String.valueOf(rowcinv01sog00.getUlIdPerson());
    }

    if (pPerson.length() == 0) {
      String errorMessage = "Please choose a person first.";
      setErrorMessage(errorMessage, DISPLAY_URI, context.getRequest());
    } else {
      request.setAttribute("pPerson", pPerson);
    }
    request.setAttribute("pStage", GlobalData.getUlIdStageAsString(request));
    request.setAttribute("checkStage", "0");
    request.setAttribute("postInSameWindow", ArchitectureConstants.FALSE);
    // Sir 22937 Had to add if for CPS versions.
    if (GlobalData.getSzCdStageProgram(request).equals(AdmnReviewConversation.PROG_CPS)) {
      request.setAttribute("docType", ADMIN_REV_PARENT_ENG_CPS);
    } else {
      request.setAttribute("docType", ADMIN_REV_PARENT_ENG);
    }
    request.setAttribute("checkForNewMode", ArchitectureConstants.TRUE);
    request.setAttribute("renderFormat", RenderType.HTML_WITH_SHELL.toString());
    request.setAttribute("docExists", ArchitectureConstants.FALSE);
    request.setAttribute("modeOfPage", "edit");

    performanceTrace.exitScope();
  }

  /**
   * This method will set all the attributes the Notification to Parent/Prof Reported Spanish will need to generate.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  public void displayDocument_setPerson_SP_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayDocument_setPerson_SP_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    GlobalData.setUlIdStage(Integer.parseInt((String) state.getAttribute("ulIdStage", request)), request);
    // state.removeAttribute( "ulIdStage", request );

    String pPerson = "";
    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) context
                                                                                    .getRequest()
                                                                                    .getAttribute(
                                                                                                  PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME);

    if (personListPullBackInfo != null) {
      ROWCINV01SOG00 rowcinv01sog00 = personListPullBackInfo.getPersonListRow();
      pPerson = String.valueOf(rowcinv01sog00.getUlIdPerson());
    }

    if (pPerson.length() == 0) {
      String errorMessage = "Please choose a person first.";
      setErrorMessage(errorMessage, DISPLAY_URI, context.getRequest());
    } else {
      request.setAttribute("pPerson", pPerson);
    }
    request.setAttribute("pStage", GlobalData.getUlIdStageAsString(request));
    request.setAttribute("checkStage", "0");
    request.setAttribute("postInSameWindow", ArchitectureConstants.FALSE);
    // Sir 22937 Had to add if for CPS versions.
    if (GlobalData.getSzCdStageProgram(request).equals(AdmnReviewConversation.PROG_CPS)) {
      request.setAttribute("docType", ADMIN_REV_PARENT_SPA_CPS);
    } else {
      request.setAttribute("docType", ADMIN_REV_PARENT_SPA);
    }
    request.setAttribute("checkForNewMode", ArchitectureConstants.TRUE);
    request.setAttribute("renderFormat", RenderType.HTML_WITH_SHELL.toString());
    request.setAttribute("docExists", ArchitectureConstants.FALSE);
    request.setAttribute("modeOfPage", "edit");

    performanceTrace.exitScope();
  }

  /**
   * This method will populate the ccfc43si object.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  private CCFC43SI populateCCFC43SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC43SI_Retrieve()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CCFC43SI ccfc43si = new CCFC43SI();

    int eventID = GlobalData.getUlIdEvent(request);

    request.setAttribute("AdminReviewEventID", String.valueOf(eventID));
    ccfc43si.setUlIdEvent(eventID);
    ccfc43si.setUlIdStage(GlobalData.getUlIdStage(request));

    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());
    ccfc43si.setArchInputStruct(input);

    performanceTrace.exitScope();
    return ccfc43si;
  }

  /**
   * This method will populate the ccfc44si object.
   * 
   * @param context
   *                Contains the session, state, and request objects to get data from jsps
   */
  private CCFC44SI populateCCFC44SI_Save(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".populateCCFC44SI_Save()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCFC43SO ccfc43so = (CCFC43SO) state.getAttribute("CCFC43SO", request);
    CCFC43SOG00 OutARIDetail = ccfc43so.getCCFC43SOG00();
    gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCMN01UIG00 OutEventStatus = ccfc43so.getROWCCMN01UIG00();

    ArchInputStruct input = new ArchInputStruct();
    CCFC44SI ccfc44si = new CCFC44SI();
    CCFC44SIG00 InARIDetail = new CCFC44SIG00();
    ROWCCMN01UIG00 InEventStatus = new ROWCCMN01UIG00();

    input.setSzUserId(UserProfileHelper.getUserProfile(context).getUserLogonID());
    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_UPDATE);

    // Copy the event status outputput object into the input object.
    try {
      InEventStatus = ROWCCMN01UIG00.unmarshal(new StringReader(OutEventStatus.toString()));
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Exception unmarshalling ROWCCMN01UIG00:" + OutEventStatus);
      GrndsTrace.msg(TRACE_TAG, 7, "Unmarshalling Failure:" + e.getMessage());
    }

    String status = ContextHelper.getStringSafe(request, "selSzCdAdminRvStatus");
    String eventStatus = (status.equals(STATUS_COMPLETE)) ? STATUS_COMPLETE : STATUS_PROCESS;

    boolean bSaveAndClose = ContextHelper.getString(request, "btnSaveAndClose.x") != null;
    eventStatus = (bSaveAndClose) ? STATUS_APPROVED : eventStatus;

    InEventStatus.setSzCdEventStatus(eventStatus);
    
    if (bSaveAndClose || ("Y".equals(CheckboxHelper.getCheckboxValue(request, "cb2lvlAdmRv2ndStageComp")) && !("Y".equals(OutARIDetail.getBInd2lvlAdmRvComp())))) {
      InEventStatus.setUlIdPerson(UserProfileHelper.getUserProfile(context).getUserID());
    }

    InARIDetail.setSzCdAdminRvAppealType(ContextHelper.getStringSafe(request, "selSzCdAdminRvAppealType"));
    InARIDetail.setSzCdAdminRvStatus(status);
    InARIDetail.setSzCdAdminRvAuth(ContextHelper.getStringSafe(request, "selSzCdAdminRvAuth"));
    InARIDetail.setDtDtAdminRvReqAppeal(ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvReqAppeal"));
    InARIDetail.setSzCdAdminRvReqBy(ContextHelper.getStringSafe(request, "selSzCdAdminRvReqBy"));
    InARIDetail.setDtDtAdminRvAppealReview(ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvAppealReview"));
    InARIDetail.setSzScrNmReviewReqBy(ContextHelper.getStringSafe(request, "txtSzScrNmReviewReqBy"));
    InARIDetail.setDtDtAdminRvDue(ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvDue"));

    InARIDetail.setSztxtAppealResult(ContextHelper.getStringSafe(request, "txtSzAdminRvAppealResult"));
    InARIDetail.setDtDtAdminRvAppealNotif(ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvAppealNotif"));

    InARIDetail.setCIndAdminRvEmgcyRel(CheckboxHelper.getCheckboxValue(request, "cbxCIndAdminRvEmgcyRel"));
    InARIDetail.setDtDtAdminRvEmgcyRel(ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvEmgcyRel"));
    InARIDetail.setDtDtAdminRvHearing(ContextHelper.getCastorDateSafe(request, "txtDtDtAdminRvHearing"));
    
    // CAPTA 1st Level
    InARIDetail.setDtDt1lvlAdminRvReqAppeal(ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvReqAppeal"));
    InARIDetail.setDtDt1lvlAdminRvAppealReview(ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvAppealReview"));
    InARIDetail.setDtDt1lvlAdminRvDue(ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvDue"));
    InARIDetail.setDtDt1lvlDeterminationLtr(ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlDeterminationLtr"));
    InARIDetail.setBInd1lvlLglRepresentation(request.getParameter("rbInd1lvlLglRepresentation"));
    InARIDetail.setBInd1lvlSaagNotification(request.getParameter("rbInd1lvlSAAGNotification"));
    
    InARIDetail.setSzCd1lvlAdminRvDisp(request.getParameter("rbInd1lvlDisp"));
    InARIDetail.setSzCd1lvlAdminRsDisg(ContextHelper.getStringSafe(request, "selSzCd1lvlRsDisg"));
    InARIDetail.setSzTxt1lvlAdminRevResults(ContextHelper.getStringSafe(request, "txtSz1lvlAdminRvAppealResult"));
    InARIDetail.setDtDt1lvlAdminRvPersonNotif(ContextHelper.getCastorDateSafe(request, "txtDtDt1lvlAdminRvPersonNoti"));
    InARIDetail.setSzTxt1lvlAdminRevResAppDen(ContextHelper.getStringSafe(request, "szTxt1lvlAdminRevResAppDen"));
    InARIDetail.setDtDt1lvlAdminRvDuePrev((ccfc43so != null) ? ccfc43so.getCCFC43SOG00().getDtDt1lvlAdminRvDue() : null);
    
    // CAPTA 2nd Level
    String sel1lvlARIStage = ContextHelper.getStringSafe(request, "sel1lvlARIStage");
    if(sel1lvlARIStage.length() > 0) {
      try {
        int idStage = Integer.parseInt(sel1lvlARIStage);
        if(idStage > 0) {
          InARIDetail.setUlAdmRev2lvlPriorStage(idStage);
        }
      } catch (NumberFormatException e) {
        // just catch and move one
      }
    }
    
    InARIDetail.setBInd1lvlAdmRv21lvlStag(CheckboxHelper.getCheckboxValue(request, "cb1lvlAdmRv21lvlStage"));
    InARIDetail.setSzTxt2lvlAdminRevOff(ContextHelper.getStringSafe(request, "txtSz2lvlAdminRvOff"));
    InARIDetail.setDtDt2lvlAdmRvDecLtr(ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlDecisionLtr"));
    InARIDetail.setDtDt2lvlAdminRvReqAppeal(ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvReqAppeal"));
    InARIDetail.setSzCd2lvlAdminRvType(request.getParameter("rbInd2lvlRevType"));
    InARIDetail.setDtDt2lvlAdminRvReqIntrv(ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminSchRevIntrv"));
    InARIDetail.setDtDt2lvlAdminRvAppealReview(ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvAppealReview"));
    InARIDetail.setDtDt2lvlAdminRvDue(ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvDue"));
    InARIDetail.setBInd2lvlLglRepresentation(request.getParameter("rbInd2lvlLglRepresentation"));
    InARIDetail.setBInd2lvlSaagNotification(request.getParameter("rbInd2lvlSAAGNotification"));
    
    InARIDetail.setSzCd2lvlAdminRvDisp(request.getParameter("rbInd2lvlDisp"));
    InARIDetail.setSzCd2lvlAdminRsDisg(ContextHelper.getStringSafe(request, "selSzCd2lvlRsDisg"));
    InARIDetail.setSzTxt2lvlAdminRevResults(ContextHelper.getStringSafe(request, "txtSz2lvlAdminRvAppealResult"));
    InARIDetail.setDtDt2lvlAdminRvPersonNotif(ContextHelper.getCastorDateSafe(request, "txtDtDt2lvlAdminRvPersonNoti"));
    InARIDetail.setSzTxt2lvlAdminRevResAppDen(ContextHelper.getStringSafe(request, "szTxt2lvlAdminRevResAppDen"));
    InARIDetail.setBInd2lvlAdmRvComp(CheckboxHelper.getCheckboxValue(request, "cb2lvlAdmRv2ndStageComp"));
    InARIDetail.setBInd2lvlAdmRvCompPrev((ccfc43so != null) ? ccfc43so.getCCFC43SOG00().getBInd2lvlAdmRvComp() : null);
    InARIDetail.setDtDt2lvlAdminRvDuePrev((ccfc43so != null) ? ccfc43so.getCCFC43SOG00().getDtDt2lvlAdminRvDue() : null);
    
    int commisDes = ContextHelper.getIntSafe(context, "hdnUlIdCommisDes");
    if(commisDes > 0) {
      InARIDetail.setUlIdCommisDes(ContextHelper.getIntSafe(context, "hdnUlIdCommisDes"));
    }
    InARIDetail.setDtDt3lvlAdmRvDecLtr(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlDecisionLtr"));
    InARIDetail.setDtDt3lvlAdminRvAppealReview(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvAppealReview"));
    InARIDetail.setDtDt3lvlAdminRvDue(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvDue"));
    InARIDetail.setSzCd3lvlAdminRvDisp(request.getParameter("rbInd3lvlDisp"));
    InARIDetail.setSzCd3lvlAdminRvFnDec(request.getParameter("rbInd3lvlFinDec"));
    InARIDetail.setSzCd3lvlAdminRsDisg(ContextHelper.getStringSafe(request, "selSzCd3lvlRsDisg"));
    InARIDetail.setSzTxt3lvlAdminRevResults(ContextHelper.getStringSafe(request, "txtSz3lvlAdminRvAppealResult"));
    InARIDetail.setDtDt3lvlAdminRvPersonNotif(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvPersonNoti"));
    InARIDetail.setSzTxt3lvlAdminRevResAppDen(ContextHelper.getStringSafe(request, "szTxt3lvlAdminRevResAppDen"));
      

    InARIDetail.setTsLastUpdate(OutARIDetail.getTsLastUpdate());
    InARIDetail.setUlIdEvent(OutARIDetail.getUlIdEvent());
    InARIDetail.setUlIdPersonRequestor(OutARIDetail.getUlIdPersonRequestor());
    InARIDetail.setUlIdStage(OutARIDetail.getUlIdStage());
    InARIDetail.setUlIdStageRelated(OutARIDetail.getUlIdStageRelated());

    // start R1 additions
    // start R1 additions
    String activeStat = null;
    activeStat = request.getParameter("rbIndLglRepresentation");
    InARIDetail.setBIndLglRepresentation(activeStat);

    activeStat = request.getParameter("rbIndSAAGNotification");
    InARIDetail.setBIndSaagNotification(activeStat);

    InARIDetail.setDtDtDeterminationLtr(ContextHelper.getCastorDateSafe(request, "txtDtDtDeterminationLtr"));
    InARIDetail.setSztxtRsnApprvDeny(ContextHelper.getStringSafe(request, "txtSzTxtRsnApprvDeny"));
    
    
    InARIDetail.setSzCdAdminRvIndLevel(ContextHelper.getStringSafe(request, "rbIndAdminLevel")); 
    // end of R1 additions
    // end of R1 additions

    ccfc44si.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    ccfc44si.setArchInputStruct(input);
    ccfc44si.setROWCCMN01UIG00(InEventStatus);
    ccfc44si.setCCFC44SIG00(InARIDetail);

    performanceTrace.exitScope();
    return ccfc44si;
  }
  
  public void displayStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayStaffSearch_xa()");
    performanceTrace.enterScope();

    BaseSessionStateManager state = getSessionStateManager(context);
    HttpServletRequest request = context.getRequest();

    CCFC43SO ccfc43so = (CCFC43SO) state.getAttribute( "CCFC43SO", request );
    if(ccfc43so != null) {
      ccfc43so.getCCFC43SOG00().setDtDt3lvlAdmRvDecLtr(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlDecisionLtr"));
      ccfc43so.getCCFC43SOG00().setDtDt3lvlAdminRvDue(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvDue"));
      ccfc43so.getCCFC43SOG00().setDtDt3lvlAdminRvAppealReview(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvAppealReview"));
      ccfc43so.getCCFC43SOG00().setSzCd3lvlAdminRvDisp(request.getParameter("rbInd3lvlDisp"));
      ccfc43so.getCCFC43SOG00().setSzCd3lvlAdminRvFnDec(request.getParameter("rbInd3lvlFinDec"));
      ccfc43so.getCCFC43SOG00().setSzCd3lvlAdminRsDisg(ContextHelper.getStringSafe(request, "selSzCd3lvlRsDisg"));
      ccfc43so.getCCFC43SOG00().setSzTxt3lvlAdminRevResults(ContextHelper.getStringSafe(request, "txtSz3lvlAdminRvAppealResult"));
      ccfc43so.getCCFC43SOG00().setDtDt3lvlAdminRvPersonNotif(ContextHelper.getCastorDateSafe(request, "txtDtDt3lvlAdminRvPersonNoti"));
      ccfc43so.getCCFC43SOG00().setSzTxt3lvlAdminRevResAppDen(ContextHelper.getStringSafe(request, "szTxt3lvlAdminRevResAppDen"));
      state.setAttribute("CCFC43SO", ccfc43so, request);
    }

    
    StaffSearchInput staffSearchInput = new StaffSearchInput();
    staffSearchInput.setSourcePage(StaffSearchInput.TODO);
    staffSearchInput.setDestinationUrl(RETURN_FROM_STAFF_SEARCH_URI);
    request.setAttribute(StaffSearchInput.PULL_BACK_KEY, staffSearchInput);

    try {
      forward(StaffSearchInput.STAFF_SEARCH_URL, request, context.getResponse());
    } catch (ServletException e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure navigating to Staff Search:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  
  /**
   * This method is called by the Grnds controller when returning from Staff Search to AdmReviewl. It is <i>only</i>
   * used for this purpose and should not be callled except through the Staff Search pullback.
   * 
   * @param context
   *          The <tt>GrndsExchangeContext</tt> object
   */
  public void returnFromStaffSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".returnFromStaffSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    ROWCCMN50DO_ARRAY rowccmn50do_array = (ROWCCMN50DO_ARRAY) request.getAttribute(StaffSearchInput.STAFF_PULL_BACK);
    // get the first row out of the array if it exists and there is exactly one (if there are more or less than one,
    // something really weird happened)
    ROWCCMN50DO rowccmn50do = rowccmn50do_array != null && rowccmn50do_array.getROWCCMN50DOCount() == 1 ? rowccmn50do_array
                                                                                                                           .getROWCCMN50DO(0)
                                                                                                       : null;

    if (rowccmn50do != null) {
      CCFC43SO ccfc43so = (CCFC43SO) state.getAttribute( "CCFC43SO", request );
      if(ccfc43so != null) {
        ccfc43so.getCCFC43SOG00().setSzTxt3lvlAdminRevCommDes(rowccmn50do.getSzNmPersonFull());
        state.setAttribute("CCFC43SO", ccfc43so, request);
        request.setAttribute("hdnUlIdCommisDes", new Integer(rowccmn50do.getUlIdPerson()));
      }
      
      PageMode.setPageMode(PageModeConstants.EDIT, request);
    } else {
      throw new RuntimeWrappedException(new PopulationException("ROWCCMN50DO_ARRAY not found in request."));
    }

    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  public static final String TRACE_TAG = "AdmnReviewConversation";

  public static final String ADMIN_REVW_FINDINGS = "ccf09o00";

  public static final String ADMIN_REV_REQSTR_ENG = "ccf11o00";

  public static final String ADMIN_REV_REQSTR_SPA = "ccf13o00";

  public static final String ADMIN_REV_PARENT_ENG = "ccf10o00";

  public static final String ADMIN_REV_PARENT_SPA = "ccf14o00";

  // SIR 22937 - Added four CPS versions of Admin Review Forms
  public static final String ADMIN_REV_REQSTR_ENG_CPS = "ccf21o00";

  public static final String ADMIN_REV_REQSTR_SPA_CPS = "ccf23o00";

  public static final String ADMIN_REV_PARENT_ENG_CPS = "ccf20o00";

  public static final String ADMIN_REV_PARENT_SPA_CPS = "ccf24o00";

  public static final String NOTIF_TO_REQUESTER = "ccf15o00";

  public static final String NOTIF_TO_REQUESTER_SPA = "ccf16o00";

  public static final String ADM_REV_LIC_AN_UPHLD_ENG = "clf01o00";

  public static final String ADM_REV_LIC_AN_OVRTRND_ENG = "clf02o00";

  public static final String RLS_HRNG_LIC_AN_UPHLD_ENG = "clf03o00";

  public static final String RLS_HRNG_LIC_AN_OVRTRND_ENG = "clf04o00";

  public static final String ADMIN_REV_NARR = "ADMINREV.DOT";

  public static final String ADMIN_REVIEW_NARR_TABLE = "ADMIN_REVIEW_NARR";

  public static final String PROG_CPS = "CPS";

  public static final String PROG_APS = "APS";

  public static final String PROG_AFC = "AFC";

  public static final String PROG_RCL = "RCL";

  public static final String PROG_CCL = "CCL";

  public static final String STAGE_INV = "INV";

  public static final String STAGE_FAD = "FAD";

  public static final String ADMIN_REVIEW_ARF = "ARF";

  public static final String ADMIN_REVIEW_ARI = "ARI";

  public static final String STATUS_NEW = "NEW";

  public static final String STATUS_PROCESS = "PROC";

  public static final String STATUS_COMPLETE = "COMP";

  public static final String STATUS_PENDING = "PEND";

  public static final String STATUS_APPROVED = "APRV";

  public static final String DISPLAY_URI = "/workload/AdmnReview/displayAdmnReview";
  
  public static final String RETURN_FROM_STAFF_SEARCH_URI = "/workload/AdmnReview/returnFromStaffSearch";
}
