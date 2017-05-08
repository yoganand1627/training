package gov.georgia.dhr.dfcs.sacwis.web.workload;

import java.io.StringReader;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.wtc.WtcHelper;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB63SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB64SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB64SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB64SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB63SO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

/**
 * This is the Conversation class changes the stage type only for FRE and FPR. The Change Stage Type conversation allows
 * users to change the Stage Type of the current Stage that the user is working in.
 *
 * @author Merle A Demo, Jan 22,2003
 */
public class ChngStgTypConversation extends BaseHiddenFieldStateConversation {
  /**
   * method to get information to fill Change Stage type Screen calls csub63.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void displayChngStgTyp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayChngStgTyp_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      //handle todo overrides, NEW/APRV events, and other wacky cases
      String pageMode = EventSearchConversation.getEventDetailPageMode(request);
      state.removeAllAttributes(request);
      PageMode.setPageMode(pageMode, request);

      // Load fields need for service CCMN85S
      CSUB63SI ccmn63si = populateCSUB63SI_Retrieve(context);

      String outputXml = WtcHelper.callService("CSUB63S", ccmn63si);
      CSUB63SO csub63so = CSUB63SO.unmarshal(new StringReader(outputXml));
      state.setAttribute(STAGETYPE_INFO, csub63so, request);
    }
    catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      processSevereException(context, we);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Another save method for the ChngStgTyp.jsp calls csub64s
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveChngStgTyp_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".save_xa()");
    performanceTrace.enterScope();

    try {
      HttpServletRequest request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);

      CSUB64SI csub64si = populateCSUB64SI_Update(context);
      WtcHelper.callService("CSUB64S", csub64si);

      // SIR 18335 - Put the new 'stage type' into GlobalData in case it is
      // needed by subsequent pages.
      String newStageType = ContextHelper.getString(request, "selCdStageType");
      GlobalData.setSzCdStageType(newStageType, request);

      state.removeAllAttributes(request);
      //the user will be taken to Case_Summary from here.
    }
    catch (ServiceException we) {
      GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
      handleErrorCSUB64(we, context);
    }
    catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * PopulateCSUB63SI object from context, It return the name of the case and people in a case.
   *
   * @param context Contains the session, state, and request objects
   * @return CSUB63SI object
   */
  private CSUB63SI populateCSUB63SI_Retrieve(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB63SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    CSUB63SI csub63si = new CSUB63SI();
    ArchInputStruct input = new ArchInputStruct();

    input.setCReqFuncCd(" ");
    input.setBPerfInd(yes);
    input.setBDataAcsInd(yes);
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);

    csub63si.setArchInputStruct(input);
    csub63si.setUlIdStage(GlobalData.getUlIdStage(request));
    csub63si.setUlIdEvent(GlobalData.getUlIdEvent(request));

    performanceTrace.exitScope();
    return csub63si;
  }

  /**
   * PopulateCSUB64SI save object from context.
   *
   * @param context Contains the session, state, and request objects
   * @return CSUB64SI object
   */
  private CSUB64SI populateCSUB64SI_Update(GrndsExchangeContext context)
          throws LookupException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCSUB63SI_Retrieve");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    BaseSessionStateManager state = getSessionStateManager(context);
    CSUB63SO csub63so = (CSUB63SO) state.getAttribute(STAGETYPE_INFO, request);

    CSUB64SI csub64si = new CSUB64SI();
    UserProfile user = UserProfileHelper.getUserProfile(context);
    ArchInputStruct input = new ArchInputStruct();
    input.setSzUserId(user.getUserLogonID());
    CSUB64SIG00 csub64sig00 = new CSUB64SIG00();
    CSUB64SIG01 csub64sig01 = new CSUB64SIG01();

    //Make string for event text
    String txtEventDescr = csub63so.getCSUB63SOG00().getSzCdStage()
                           + UNDER_SCORE
                           + csub63so.getCSUB63SOG00().getSzCdStageType()
                           + ARROW
                           + csub63so.getCSUB63SOG00().getSzCdStage()
                           + UNDER_SCORE
                           + ContextHelper.getString(request, "selCdStageType") + SPACE
                           + Lookup.simpleDecodeSafe(CodesTables.CSTAGES, csub63so.getCSUB63SOG00().getSzCdStage()) +
                           SPACE
                           + Lookup.simpleDecodeSafe(CodesTables.CSTGTCHG, csub63so.getCSUB63SOG00().getSzCdStageType())
                           + TXTEVENT
                           + Lookup.simpleDecodeSafe(CodesTables.CSTGTCHG, ContextHelper.getString(request,
                                                                                                   "selCdStageType"));

    input.setCReqFuncCd(ServiceConstants.REQ_FUNC_CD_ADD);
    input.setBPerfInd(yes);
    input.setBDataAcsInd(yes);
    input.setUsPageNbr(usPageNbr);
    input.setUlPageSizeNbr(ulPageSizeNbr);
    input.setSzUserId(GlobalData.getUlIdPersonAsString(request));

    csub64si.setArchInputStruct(input);
    csub64sig00.setUlIdStage(GlobalData.getUlIdStage(request));
    csub64sig00.setSzCdStageType(ContextHelper.getString(request, "selCdStageType"));
    csub64sig00.setTsLastUpdate(csub63so.getCSUB63SOG00().getTsLastUpdate());

    csub64sig01.setUlIdEvent(GlobalData.getUlIdEvent(request));
    csub64sig01.setTsLastUpdate(csub63so.getCSUB63SOG01().getTsLastUpdate());
    csub64sig01.setUlIdStage(GlobalData.getUlIdStage(request));
    csub64sig01.setSzCdEventType(CDEVENTTYPE);
    csub64sig01.setUlIdPerson(UserProfileHelper.getUserProfile(request).getUserID());
    csub64sig01.setSzCdTask(GlobalData.getSzCdTask(request));
    csub64sig01.setSzTxtEventDescr(txtEventDescr);
    csub64sig01.setDtDtEventOccurred(DateHelper.toCastorDateSafe(" "));
    csub64sig01.setSzCdEventStatus(CDEVENTSTATUS);

    csub64si.setCSUB64SIG00(csub64sig00);
    csub64si.setCSUB64SIG01(csub64sig01);

    performanceTrace.exitScope();
    return csub64si;
  }

  /**
   * PopulateCSUB64SI save object from context.
   *
   * @param context Contains GrndsExchangeContext
   * @param we      Contains WtcException
   */
  private void handleErrorCSUB64(ServiceException we,
                                 GrndsExchangeContext context) {
    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_SYS_EVENT_STS_MSMTCH:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.SQL_NOT_FOUND:
        this.setPresentationBranch(ERROR, context);
        setErrorMessage(errorCode, context.getRequest());
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
        break;
    }
  }

  public static final String TRACE_TAG = "ChngStgTypConversation";
  public static final String CHNG_STG_TYP_PAGE = "/workload/ChngStgTyp/displayChngStgTyp";
  public static final String ERROR = "error";
  public static final int usPageNbr = 1;
  public static final int ulPageSizeNbr = 26;
  public static final String cReqFuncCd = "U";
  public static final String yes = "Y";
  public static final String TXTEVENT = " has changed to ";
  public static final String ARROW = "=>";
  public static final String UNDER_SCORE = "_";
  public static final String SPACE = " ";
  public static final String CRSR_STAGE = "C-";
  public static final String CDEVENTTYPE = "STG";
  public static final String CDEVENTSTATUS = "NEW";
  public static final String STAGETYPE_INFO = "CSUB63SO";
}
