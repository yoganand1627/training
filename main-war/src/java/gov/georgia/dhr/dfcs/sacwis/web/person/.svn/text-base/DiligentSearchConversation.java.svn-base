package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DiligentSearchInfoRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DiligentSearchInfoRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.decorator.IncludeTag;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;

import java.text.ParseException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

public class DiligentSearchConversation extends BaseHiddenFieldStateConversation {

  private Person person;

  public static final String TRACE_TAG = "DiligentSearchConversation";

  public static final String DISPLAY_LIST_PAGE = "/person/DiligentSearch/displayDiligentSearchList";

  public static final String DISPLAY_DETAIL_PAGE = "/person/DiligentSearch/displayDiligentSearchInfo";

  public static final String SAVE = "save";

  public static final String PAGE_MODE_KEY = TRACE_TAG + ".PAGE_MODE_KEY";

  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;

  public static final String URL_PERSON_LIST = "/person/PersonList/displayPersonList";

  public void setPerson(Person person) {
    this.person = person;
  }

  /**
   * Display diligent search list page
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void displayDiligentSearchList_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayDiligentSearchList_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      // clear state
      state.removeAllAttributes(request);
      // get page mode from request
      String pageMode = PageMode.getPageMode(request);
      if (request.getAttribute("PageMode") != null) {
        pageMode = (String) request.getAttribute("PageMode");
        PageMode.setPageMode(pageMode, request);
      }
      // check if user has rights to modify this page
      Boolean rights = hasStageAccessRights(context);
      if (!pageMode.equals(PageModeConstants.NEW_USING)) {
        if (rights) {
          PageMode.setPageMode(PageModeConstants.EDIT, request);
        } else {
          PageMode.setPageMode(PageModeConstants.VIEW, request);
        }
      }
      String includingDisplayCommand = (String) state.getAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY,
                                                                   request);
      state.setAttribute(IncludeTag.INCLUDING_PAGE_DISPLAY_COMMAND_KEY, includingDisplayCommand, request);

      DiligentSearchInfoRetrieveSI dsiretsi = populateDiligentSearchInfoRetrieveSI(context);
      DiligentSearchInfoRetrieveSO dsiretso = (DiligentSearchInfoRetrieveSO) state
                                                                                  .getAttribute(
                                                                                                "DiligentSearchInfoRetrieveSO",
                                                                                                request);
      if (pageMode.equals(PageModeConstants.NEW_USING)) {
        dsiretsi.setPageMode("NEW_USING");
      }
      dsiretso = person.retrieveDiligentSearchInformation(dsiretsi);
      // get person search name and set in global data
      if (dsiretso != null) {
        String nmPersonSearch = dsiretso.getNamePersonSearch();
        GlobalData.setSzNmPersonFull(nmPersonSearch, request);
      }
      // get person detail name
      String nmPerson = ContextHelper.getStringSafe(request, "hdnPersonNm");
      if (nmPerson != null) {
        dsiretso.setPersonNameForPullback(nmPerson);
      }
      state.setAttribute("DiligentSearchInfoRetrieveSO", dsiretso, request);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Copy Diligent Info
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void copyDiligentInfo_xa(GrndsExchangeContext context) {

    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "copyDiligentInfo_xa");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    String pageMode = PageMode.getPageMode(request);
    String mode = PageModeConstants.MODIFY;

    if (pageMode.equals(mode)) {
      PageMode.setPageMode(PageModeConstants.NEW_USING, request);
      pageMode = PageMode.getPageMode(request);
    }
    request.setAttribute("PageMode", pageMode);
    // state.setAttribute("PageMode",pageMode,request);
    request = context.getRequest();
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Populate retrieve information for diligent list and info page
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  private DiligentSearchInfoRetrieveSI populateDiligentSearchInfoRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateMedRetSI_Retrieve");
    performanceTrace.enterScope();

    // Get the request object from context to make input data available to
    // this method
    HttpServletRequest request = context.getRequest();
    DiligentSearchInfoRetrieveSI dsiretsi = new DiligentSearchInfoRetrieveSI();
    int ulIdStage = GlobalData.getUlIdStage(request);
    int ulIdCase = GlobalData.getUlIdCase(request);
    int ulIdPersonSearch = GlobalData.getUlIdPerson(request);
    String nmPerson = GlobalData.getSzNmPersonFull(request);
    dsiretsi.setUlIdPersonSearch(ulIdPersonSearch);
    dsiretsi.setUlIdCase(ulIdCase);
    dsiretsi.setUlIdStage(ulIdStage);
    dsiretsi.setNmPerson(nmPerson);
    // set data in state
    request.setAttribute("DiligentSearchInfoRetrieveSI", dsiretsi);
    if (ulIdPersonSearch != 0) {
      dsiretsi.setUlIdPersonSearch(ulIdPersonSearch);
      request.setAttribute("DiligentSearchInfoRetrieveSI", dsiretsi);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return dsiretsi;
  }

  /**
   * Display existing diligent info.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  public void displayDiligentSearchInfo_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "displayDiligentSearchInfo_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO = (DiligentSearchInfoRetrieveSO) state
                                                                                                      .getAttribute(
                                                                                                                    "DiligentSearchInfoRetrieveSO",
                                                                                                                    request);
      DiligentSearchInfoRetrieveSI diligentSearchInfoRetrieveSI = populateDiligentSearchInfoRetrieveSI(context);
      diligentSearchInfoRetrieveSI.setUlIdPersonSearch(GlobalData.getUlIdPerson(request));
      int IdDiligentSearch = 0;
      int idPerson = 0;
      String pageMode = PageMode.getPageMode(request);
      if (pageMode.equals(PageModeConstants.NEW_USING)) {
        String rbDiligentSearch = ContextHelper.getStringSafe(request, "rbDiligentList");
        IdDiligentSearch = Integer.parseInt(rbDiligentSearch);
        diligentSearchInfoRetrieveSI.setPageMode("NEW_USING");
      } else {
        // get IdDiligentSearch from request
        IdDiligentSearch = ContextHelper.getIntSafe(request, "hdnIdDiligentSearch");
      }
      diligentSearchInfoRetrieveSI.setUlIdDiligentSearch(IdDiligentSearch);
      // retrieve diligent search information.
      diligentSearchInfoRetrieveSO = person.retrieveDiligentSearchInformation(diligentSearchInfoRetrieveSI);
      if (pageMode.equals(PageModeConstants.NEW_USING)) {
        IdDiligentSearch = 0;
        diligentSearchInfoRetrieveSO.setUlIdDiligentSearch(IdDiligentSearch);
      }
      idPerson = diligentSearchInfoRetrieveSO.getUlIdPersonDetail();
      //GlobalData.setUlIdPerson(idPerson, request);
      state.setAttribute("DiligentSearchInfoRetrieveSO", diligentSearchInfoRetrieveSO, request);

      // set the id needs and outcomes ,event id and stage id in state
      state.setAttribute("IdDiligentSearch", IdDiligentSearch, request);

    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    // Log the performance trace info
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return;
  }

  /**
   * Save diligent info into diligent search table.
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */

  public void saveDiligentSearchInfo_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveDiligentSearchInfo_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO = (DiligentSearchInfoRetrieveSO) state
                                                                                                      .getAttribute(
                                                                                                                    "DiligentSearchInfoRetrieveSO",
                                                                                                                    request);

      DiligentSearchInfoSaveSI diligentSearchInfoSaveSI = populateDiligentSearchInfoSaveSI(context);
      person.saveDiligentSearchInformation(diligentSearchInfoSaveSI);
      request.setAttribute("DiligentSearchInfoSaveSI", diligentSearchInfoSaveSI);
      request.setAttribute("DiligentSearchInfoRetrieveSO", diligentSearchInfoRetrieveSO);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      // This catch clause will include the correct trace tag in the GRNDS trace.
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return;
  }

  /**
   * Populate entered data for save diligent info
   * 
   * @param context
   *          Contains the session, state, and request objects to get data from jsps
   */
  private DiligentSearchInfoSaveSI populateDiligentSearchInfoSaveSI(GrndsExchangeContext context)
                                                                                                 throws ServiceException,
                                                                                                 ParseException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateDiligentSearchInfoSaveSI_AU");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO = (DiligentSearchInfoRetrieveSO) state
                                                                                                    .getAttribute(
                                                                                                                  "DiligentSearchInfoRetrieveSO",
                                                                                                                  request);
    DiligentSearchInfoList dsiBean = new DiligentSearchInfoList();
    // String endDate = ContextHelper.getStringSafe(request, "tsDtLastUpdate");
    if (request.getParameter("cbIncludDilSrch") != null && !"".equals(request.getParameter("cbIncludDilSrch"))) {
      dsiBean.setIndIncludeDilSrch(ContextHelper.getStringSafe(request, "cbIncludDilSrch"));
    }
    if (request.getParameter("cbCaretakerPriorRemoval") != null
        && !"".equals(request.getParameter("cbCaretakerPriorRemoval"))) {
      dsiBean.setIndCaretakerPriorRemoval(ContextHelper.getStringSafe(request, "cbCaretakerPriorRemoval"));
    }
    if (request.getParameter("txtCaretakerCmnts") != null && !"".equals(request.getParameter("txtCaretakerCmnts"))) {
      dsiBean.setTxtRemCmnts(ContextHelper.getStringSafe(request, "txtCaretakerCmnts"));
    }
    if (request.getParameter("selReferralType") != null && !"".equals(request.getParameter("selReferralType"))) {
      dsiBean.setSelReferralType(ContextHelper.getStringSafe(request, "selReferralType"));
    }
    if (request.getParameter("txtOtherDesc") != null && !"".equals(request.getParameter("txtOtherDesc"))) {
      dsiBean.setTxtOtherDesc(ContextHelper.getStringSafe(request, "txtOtherDesc"));
    }
    if (request.getParameter("txtReferrsNm") != null && !"".equals(request.getParameter("txtReferrsNm"))) {
      dsiBean.setTxtReferrsNm(ContextHelper.getStringSafe(request, "txtReferrsNm"));
    }
    if (request.getParameter("rbSuccContacted") != null && !"".equals(request.getParameter("rbSuccContacted"))) {
      dsiBean.setIndSuccContacted(ContextHelper.getStringSafe(request, "rbSuccContacted"));
    }
    if (request.getParameter("txtNotContactedCmnts") != null
        && !"".equals(request.getParameter("txtNotContactedCmnts"))) {
      dsiBean.setTxtNotContactedCmnts(ContextHelper.getStringSafe(request, "txtNotContactedCmnts"));
    }
    if (request.getParameter("selCurrOutcomeContact") != null
        && !"".equals(request.getParameter("selCurrOutcomeContact"))) {
      dsiBean.setSelCurrOutcomeContact(ContextHelper.getStringSafe(request, "selCurrOutcomeContact"));
    }
    if (request.getParameter("rbVisitationRsrc") != null && !"".equals(request.getParameter("rbVisitationRsrc"))) {
      dsiBean.setIndVisitationRsrc(ContextHelper.getStringSafe(request, "rbVisitationRsrc"));
    }
    if (request.getParameter("rbPlcmtRsrc") != null && !"".equals(request.getParameter("rbPlcmtRsrc"))) {
      dsiBean.setIndPlcmtRsrc(ContextHelper.getStringSafe(request, "rbPlcmtRsrc"));
    }
    if (request.getParameter("txtPlcmtRsrcCmnts") != null && !"".equals(request.getParameter("txtPlcmtRsrcCmnts"))) {
      dsiBean.setTxtPlcmtRsrcCmnts(ContextHelper.getStringSafe(request, "txtPlcmtRsrcCmnts"));
    }
    if (request.getParameter("dtRelCareSubDisc") != null && !"".equals(request.getParameter("dtRelCareSubDisc"))) {
      dsiBean.setDtRelCareSubDisc(DateHelper.toJavaDate(ContextHelper.getStringSafe(request, "dtRelCareSubDisc")));
    }
    if (request.getParameter("txtComments") != null && !"".equals(request.getParameter("txtComments"))) {
      dsiBean.setTxtCmnts(ContextHelper.getStringSafe(context, "txtComments"));
    }
    DiligentSearchInfoList diligentSearchList = diligentSearchInfoRetrieveSO.getDsiBean();
    if(diligentSearchList!=null)
    {
      dsiBean.setDtLastUpdate(diligentSearchList.getDtLastUpdate());
    }  
    String idPersonDetail = null;
    int idPerson = 0;
    idPersonDetail = diligentSearchInfoRetrieveSO.getPersonIdForPullback();
    if ((idPersonDetail != null) && (!"".equals(idPersonDetail))) {
      idPerson = Integer.parseInt(idPersonDetail);
    } else {
      idPerson = diligentSearchInfoRetrieveSO.getUlIdPersonDetail();
    }

    int idPersonSearch = diligentSearchInfoRetrieveSO.getUlIdPersonSearch();
    // set id person in global data

    //GlobalData.setUlIdPerson(idPersonSearch, request); // comment out since it set the 443 to global; set it 
    int idDiligentSearchInfo = 0;
    idDiligentSearchInfo = diligentSearchInfoRetrieveSO.getUlIdDiligentSearch();
    DiligentSearchInfoSaveSI diligentSearchInfoSaveSI = new DiligentSearchInfoSaveSI();
    //diligentSearchInfoSaveSI.setUlIdPersonSearch(idPersonSearch); // set the global data to save si here (438)
    diligentSearchInfoSaveSI.setUlIdPersonSearch(GlobalData.getUlIdPerson(request));
    diligentSearchInfoSaveSI.setIdCase(GlobalData.getUlIdCase(request));
    diligentSearchInfoSaveSI.setIdstage(GlobalData.getUlIdStage(request));
    diligentSearchInfoSaveSI.setUlIdPersonDetail(idPerson);
    dsiBean.setIdDiligentSearchInfo(idDiligentSearchInfo);
    state.setAttribute("DiligentSearchInfoRetrieveSO", diligentSearchInfoRetrieveSO, request);
    diligentSearchInfoSaveSI.setDsiBean(dsiBean);
    performanceTrace.exitScope();
    return diligentSearchInfoSaveSI;
  }

  /**
   * Initialize request to call PersonList Pullback
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void retrievePerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "retrievePerson_xa");

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO = (DiligentSearchInfoRetrieveSO) state
                                                                                                      .getAttribute(
                                                                                                                    "diligentSearchInfoRetrieveSO",
                                                                                                                    request);
      if (diligentSearchInfoRetrieveSO == null) {
        diligentSearchInfoRetrieveSO = new DiligentSearchInfoRetrieveSO();
      }
      diligentSearchInfoRetrieveSO
                                  .setPersonIdForPullback(ContextHelper
                                                                       .getStringSafe(request, "hdnPersonIdForPullback"));
      diligentSearchInfoRetrieveSO.setUlIdPersonSearch(ContextHelper.getIntSafe(request, "hdnPersonIdSearch"));
      DiligentSearchInfoRetrieveSI dsiretsi = populateDiligentSearchInfoRetrieveSI(context);
      diligentSearchInfoRetrieveSO.setPersonNameForPullback(dsiretsi.getNmPerson());
      diligentSearchInfoRetrieveSO.setUlIdPersonSearch(dsiretsi.getulIdPersonSearch());
      state.setAttribute("DiligentSearchInfoRetrieveSO", diligentSearchInfoRetrieveSO, request);
      PersonListPullBackInfo personListPullBackInfo = new PersonListPullBackInfo();
      // populatePerson(request, diligentSearchInfoRetrieveSO);
      personListPullBackInfo.setDestinationUrl("/person/DiligentSearch/setPerson");
      request.setAttribute(PERSON_LIST_PULLBACK_INFO, personListPullBackInfo);
      state.setAttribute("ACTUAL_PAGE_MODE", PageMode.getPageMode(request), request);
      PageMode.setPageMode("S", request);
      forward(URL_PERSON_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Final method in the pullback process.
   * 
   * @param context
   *          The GrndsExchangeContext object.
   */
  public void setPerson_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setPerson_xa");
    HttpServletRequest request = context.getRequest();

    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO = (DiligentSearchInfoRetrieveSO) state
                                                                                                      .getAttribute(
                                                                                                                    "DiligentSearchInfoRetrieveSO",
                                                                                                                    request);
      GlobalData.setUlIdPerson(diligentSearchInfoRetrieveSO.getUlIdPersonSearch(), request);
      GlobalData.setSzNmPersonFull(diligentSearchInfoRetrieveSO.getPersonNameForPullback(), request);
      DiligentSearchInfoRetrieveSI dsiretsi = populateDiligentSearchInfoRetrieveSI(context);
      dsiretsi.setUlIdPersonSearch(diligentSearchInfoRetrieveSO.getUlIdPersonSearch());
      populatePerson(request, diligentSearchInfoRetrieveSO);
      if (diligentSearchInfoRetrieveSO.getPersonIdForPullback() != null) {
        String detailId = diligentSearchInfoRetrieveSO.getPersonIdForPullback();
        int personDetailId = Integer.parseInt(detailId);
        dsiretsi.setUlIdPersonDetail(personDetailId);
      }
      PageMode.setPageMode(PageModeConstants.NEW, request);
      dsiretsi.setPageMode("NEW");
      diligentSearchInfoRetrieveSO = person.retrieveDiligentSearchInformation(dsiretsi);
      request.setAttribute("DiligentSearchInfoRetrieveSO", diligentSearchInfoRetrieveSO);
    } catch (ServiceException we) {
      handleException(we, context);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
  }

  /**
   * Populates personId and personFullName in DiligentSearchInfoRetrieveSO when DiligentSearchInfo is returned to from
   * PersonList
   * 
   * @param request
   *          HttpServletRequest
   * @param DiligentSearchInfoRetrieveSO
   *          DiligentSearchInfoRetrieveSO
   */
  protected static void populatePerson(HttpServletRequest request,
                                       DiligentSearchInfoRetrieveSO diligentSearchInfoRetrieveSO) {
    PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request
                                                                                    .getAttribute(PERSON_LIST_PULLBACK_INFO);
    if (personListPullBackInfo == null) {
      return;
    }
    ROWCINV01SOG00 row = personListPullBackInfo.getPersonListRow();

    if (row == null) {
      return;
    }
    request.removeAttribute(PERSON_LIST_PULLBACK_INFO);
    diligentSearchInfoRetrieveSO.setPersonIdForPullback(String.valueOf(row.getUlIdPerson()));
    diligentSearchInfoRetrieveSO.setPersonNameForPullback(String.valueOf(row.getSzNmPersonFull()));
  }

  /*
   * determines whether the user has access rights to modify the stage
   */
  private boolean hasStageAccessRights(GrndsExchangeContext context) {
    int ulIdStage = GlobalData.getUlIdStage(context.getRequest());
    int userID = UserProfileHelper.getUserProfile(context).getUserID();
    return CaseUtility.hasStageAccess(userID, ulIdStage);
  }

  protected void handleException(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();
    
    switch (we.getErrorCode()) {
    case Messages.MSG_DILSEARCH_COPY:
    case Messages.MSG_CMN_TMSTAMP_MISMATCH:
    case Messages.MSG_SYS_EVENT_STS_MSMTCH:
    case Messages.MSG_SYS_STAGE_CLOSED:
    case Messages.MSG_SYS_MULT_INST:
    case Messages.MSG_CMN_NO_PRIMARY_ROW:
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
}
