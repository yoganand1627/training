package gov.georgia.dhr.dfcs.sacwis.web.fad;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.service.adoexchange.AdoExchange;
import gov.georgia.dhr.dfcs.sacwis.service.fad.NonCompliance;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionChildBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FosterHomeConversionSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.NonComplianceSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CRES03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.FosterHomeConversionSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.NonComplianceSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCINV01SOG00;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListConversation;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonListPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.resource.ResourceSearchPullBackInfo;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoDetailDB;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the conversation class used to maintain Foster Home Conversion in the system. <p/>
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   07/01/08  mchillman creation
 *   10/03/08  wjcochran Added functionality
 *   11/14/08  wjcochran Removed code related to home licensing (should have been contract code)
 *   01/29/09  wjcochran STGAP00012213: fixed logic to prevent a null event status
 *   01/30/09  wjcochran STGAP00012200: Modified removeChildFromConversion_xa to remove a child
 *                       only if a positive row index exists
 *
 *   04/15/09  cwells    STGAP00013155 setting the correct variables for in global data and pagemode so after save
 *                       to allow is dirty and checkForNew to work correctly.  
 *   06/09/09  mchillman STGAP00013453: added code set page after approval
 *
 * </pre>
 */
public class FosterHomeConversionConversation extends BaseHiddenFieldStateConversation {

  public static final String PAGE_MODE = PageMode.PAGE_MODE_ATTRIBUTE_NAME;

  public static final String EVENT_DESC = "Home Conversion";
  
  public static final String EVENT_TYPE_HCN = CodesTables.CEVNTTYP_HCN;
  
  public static final String EVENT_TYPE_HME = CodesTables.CEVNTTYP_HME;

  public static final String EVENT_STATUS_NEW = CodesTables.CEVTSTAT_NEW;
  
  public static final String EVENT_STATUS_PEND = CodesTables.CEVTSTAT_PEND;
  
  public static final String EVENT_STATUS_PROC = CodesTables.CEVTSTAT_PROC;
  
  public static final String EVENT_STATUS_APRV = CodesTables.CEVTSTAT_APRV;

  public static final String EVENT_STATUS_COMP = CodesTables.CEVTSTAT_COMP;
  
  public static final String CONV_STATUS_PEND = CodesTables.CFHCSTTS_PAP;
  
  public static final String CONV_STATUS_APRV = CodesTables.CFHCSTTS_APR;
  
  public static final String CONV_STATUS_COMP = CodesTables.CFHCSTTS_CLS;
  
  public static final String HCN_TASK_ID = "9997";
   
  public static final String SAVE_AND_SUBMIT = "btnSaveAndSubmit";

  protected static final String RESOURCE_PULLBACK_INFO = ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST;

  protected static final String PERSON_LIST_PULLBACK_INFO = PersonListPullBackInfo.REQUEST_ATTRIBUTE_NAME;

  public static final String URL_RESOURCE_SEARCH_LIST = "/resource/ResourceSearch/displaySearch";
  
  public static final String URL_PERSON_LIST = "/person/PersonList/callPersonSearch";
  
  public static final String URL_CHILD_CONV_LIST = "/fad/HomeConversion/setChildConversionList";

  private AdoExchange adoExchange;

  private NonCompliance nonCompliance;

  public void setNonCompliance(NonCompliance nonCompliance) {
    this.nonCompliance = nonCompliance;
  }
  
  public void setAdoExchange(AdoExchange adoExchange) {
    this.adoExchange = adoExchange;
  }
  
  public void displayHomeConversion_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayHomeConversion_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    FosterHomeConversionSO fosterHomeConversionDetail = (FosterHomeConversionSO)state.getAttribute("FosterHomeConversionSO", request);
    int idEvent = GlobalData.getUlIdEvent(request);

    if (fosterHomeConversionDetail == null) {
      fosterHomeConversionDetail = new FosterHomeConversionSO();
      FosterHomeConversionSI fosterHomeConversionSI = populateFosterHomeConversionSI(context, ServiceConstants.REQ_FUNC_CD_NO_ACTION);
      fosterHomeConversionSI.setUlIdEvent(idEvent);
      fosterHomeConversionDetail = adoExchange.retrieveFosterHomeConversion(fosterHomeConversionSI);
    }
    
    String cdEventStatus = fosterHomeConversionDetail.getCdEventStatus();
    if (cdEventStatus == null) {
      cdEventStatus = EVENT_STATUS_NEW;
    }
    String cdConvAppStatus = fosterHomeConversionDetail.getCdConvAppStatus();
    request.setAttribute("dtClosureDate", fosterHomeConversionDetail.getDtClosed());
    String pageMode = pageModeSet(context, cdEventStatus, cdConvAppStatus);
    PageMode.setPageMode(pageMode, request);

    state.setAttribute("FosterHomeConversionSO", fosterHomeConversionDetail, request);
    request.setAttribute("dtEventLastUpdate", fosterHomeConversionDetail.getDtEventLastUpdate());
    request.setAttribute(PAGE_MODE, pageMode);

    if (EVENT_STATUS_PEND.equals(cdEventStatus) 
        && !GlobalData.isApprovalMode(request)
        && !PageModeConstants.VIEW.equals(pageMode)) {
      setInformationalMessage(Messages.MSG_CMN_INVLD_APRVL, request);
      setPopUpMessage(Messages.MSG_CMN_INVLD_APRVL_POPUP, request);
    }
    performanceTrace.exitScope();
  }

  public void saveHomeConversion_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveHomeConversion_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String saveSubmitButtonNameInRequest = SAVE_AND_SUBMIT + ".x";
    boolean bSaveSubmit = ContextHelper.getString(request, saveSubmitButtonNameInRequest) != null;

    try {

      FosterHomeConversionSI fosterHomeConversionSI = populateFosterHomeConversionSI(context, ServiceConstants.REQ_FUNC_CD_SAVE);

      if (bSaveSubmit) {
        int idEvent = fosterHomeConversionSI.getUlIdEvent();
        boolean hasNarrative = checkFHConvNarrExists(idEvent);
        
        if (!hasNarrative) {
          throw new ServiceException(Messages.MSG_FAD_CONV_NARR_REQD);
        }        
      }

      FosterHomeConversionSO homeConversionDetailSO = adoExchange.saveFosterHomeConversion(fosterHomeConversionSI);
      if (homeConversionDetailSO != null && fosterHomeConversionSI != null) {
        homeConversionDetailSO.setCdEventStatus(fosterHomeConversionSI.getEventStatus());
      }
      state.setAttribute("FosterHomeConversionSO", homeConversionDetailSO, request);
      String cdEventStatus = homeConversionDetailSO.getCdEventStatus();
      String cdConvAppStatus = homeConversionDetailSO.getCdConvAppStatus();    
      int idEvent = homeConversionDetailSO.getIdEvent();
      request.setAttribute("dtClosureDate", homeConversionDetailSO.getDtClosed());
      String pageMode = pageModeSet(context, cdEventStatus, cdConvAppStatus);
      
      if(DateHelper.isNull(homeConversionDetailSO.getDtClosed()) == false){
        pageMode = PageModeConstants.INQUIRE;
      }
     
      // STGAP00013155 Id event is used to determine the difference between add 
      // and update.  The id is being pulled from global data so it should be set there
      // The form tag checkForNew looks at the page mode to see if it is set as new
      // the page mode was never updated after the save so it is being done here 
      GlobalData.setUlIdEvent(idEvent, request);  
      PageMode.setPageMode(pageMode, request);
      request.setAttribute(PAGE_MODE, pageMode);
      

      if (bSaveSubmit) {

        ToDoDetailDB toDoDetailDB = new ToDoDetailDB(GlobalData.getUlIdEvent(request), GlobalData.getUlIdCase(request),
                                                     GlobalData.getUlIdStage(request), "9998");
        ToDoHelper.setToDoDetailDB(toDoDetailDB, request, state);
        setPresentationBranch("submit", context);
      }

    } catch (ServiceException se) {
      handleSaveError(se, context);
    } finally {
      performanceTrace.exitScope();
    }
  }

  public void getAdoAgency_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".getAdoAgency_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();
    setHomeConversionDetails(request);
    try {
      ResourceSearchPullBackInfo resourceSearchPullBackInfo = new ResourceSearchPullBackInfo();
      resourceSearchPullBackInfo.setDestinationUrl("/fad/HomeConversion/setAdoAgency");
      request.setAttribute(RESOURCE_PULLBACK_INFO, resourceSearchPullBackInfo);
      forward(URL_RESOURCE_SEARCH_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }

  }

  private static FosterHomeConversionSO setHomeConversionDetails(HttpServletRequest request) {
    BaseSessionStateManager state = getSessionStateManager(request);
    FosterHomeConversionSO fosterHomeConversionDetail = (FosterHomeConversionSO)state.getAttribute("FosterHomeConversionSO", request);

    if (fosterHomeConversionDetail == null ) {
      fosterHomeConversionDetail = new FosterHomeConversionSO();
    }
    int idEvent = GlobalData.getUlIdEvent(request);
    int idAdoAgency = ContextHelper.getIntSafe(request, "idAdoAgency");
    Date dtApplied = ContextHelper.getJavaDateSafe(request,"dtAppliedDate");
    Date dtApproved = ContextHelper.getJavaDateSafe(request, "dtApprovedDate");
    Date dtClosure = ContextHelper.getJavaDateSafe(request,"dtClosureDate");
    Date dtInquiry = ContextHelper.getJavaDateSafe(request, "dtInquiryDate");
    String szCdClosureReason = ContextHelper.getStringSafe(request, "szCdClosureReason");
    String szCdConvAppStatus = ContextHelper.getStringSafe(request,"szCdConvAppStatus");
    String txNmResource = ContextHelper.getStringSafe(request, "txNmResource");
    
    fosterHomeConversionDetail.setCdClosureReason(szCdClosureReason);
    fosterHomeConversionDetail.setCdConvAppStatus(szCdConvAppStatus);
    fosterHomeConversionDetail.setDtApplied(dtApplied);
    fosterHomeConversionDetail.setDtApproved(dtApproved);
    fosterHomeConversionDetail.setDtClosed(dtClosure);
    fosterHomeConversionDetail.setDtInquired(dtInquiry);
    fosterHomeConversionDetail.setIdAdoAgency(idAdoAgency);
    fosterHomeConversionDetail.setIdEvent(idEvent);
    fosterHomeConversionDetail.setNmResource(txNmResource);
    
    return fosterHomeConversionDetail;
    
  }
  
  public void setAdoAgency_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".setAdoAgency_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
 
    FosterHomeConversionSO fosterHomeConversionDetail = (FosterHomeConversionSO)state.getAttribute("FosterHomeConversionSO", request);
    if (fosterHomeConversionDetail == null){
      int idEvent = GlobalData.getUlIdEvent(request);
      FosterHomeConversionSI fosterHomeConversionSI = new FosterHomeConversionSI();
      fosterHomeConversionSI.setUlIdEvent(idEvent);
      fosterHomeConversionDetail = adoExchange.retrieveFosterHomeConversion(fosterHomeConversionSI);
    }

    CRES03SO cres03so = (CRES03SO) request.getAttribute(ResourceSearchPullBackInfo.RESOURCE_PULLBACK_REQUEST);
    int idAdoAgency = 0;
    String nmResource = "";

    if (cres03so != null) {
      if (cres03so.getUlIdResource() != 0) {
        idAdoAgency = cres03so.getUlIdResource();
      }
      if (cres03so.getSzNmResource() != null || ! "".equals(cres03so.getSzNmResource())) {
        nmResource = cres03so.getSzNmResource();
      }
    }
    
    request.removeAttribute(RESOURCE_PULLBACK_INFO);
    fosterHomeConversionDetail.setIdAdoAgency(idAdoAgency);
    fosterHomeConversionDetail.setNmResource(nmResource);
    state.setAttribute("formChanged", true, request);
    state.setAttribute("FosterHomeConversionSO", fosterHomeConversionDetail, request);

  }

  public void addChildToConversion_xa(GrndsExchangeContext context) { 
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".addChildToConversion_xa()");
    performanceTrace.enterScope();

    try {
      BaseSessionStateManager state = getSessionStateManager(context);
      HttpServletRequest request = context.getRequest();
      HttpServletResponse response = context.getResponse();
      FosterHomeConversionSO fosterHomeConversionDetail = setHomeConversionDetails(request);
      state.setAttribute("FosterHomeConversionSO", fosterHomeConversionDetail, request);

      PersonListPullBackInfo personListPBInfo = new PersonListPullBackInfo();
      personListPBInfo.setDestinationUrl(URL_CHILD_CONV_LIST);
      request.setAttribute(PERSON_LIST_PULLBACK_INFO, personListPBInfo);
      state.setAttribute("ACTUAL_PAGE_MODE", PageMode.getPageMode(request), request);
      state.setAttribute("hdnContinueBtn", ArchitectureConstants.TRUE, request);
      PageMode.setPageMode(PersonListConversation.PAGE_MODE_SELECT, request);
      forward(URL_PERSON_LIST, request, response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }

  }

  public void setChildConversionList_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "setPerson_xa");
    HttpServletRequest request = context.getRequest();
    HttpServletResponse response = context.getResponse();

    try {
      BaseSessionStateManager state = getSessionStateManager(request);
      FosterHomeConversionSO fosterHomeConversionDetail = (FosterHomeConversionSO)state.getAttribute("FosterHomeConversionSO", request);
      PersonListPullBackInfo personListPullBackInfo = (PersonListPullBackInfo) request.getAttribute(PERSON_LIST_PULLBACK_INFO);

      //populate SO
      if (fosterHomeConversionDetail == null){
        return;
      }
      ROWCINV01SOG00 row = personListPullBackInfo.getPersonListRow();
      if (row == null) {
        return;
      }
      request.removeAttribute(PERSON_LIST_PULLBACK_INFO);

      List<FosterHomeConversionChildBean> childrenToBeAdopted = fosterHomeConversionDetail.getChildrenToBeAdopted();
      String childGender = decodeGender(row.getCCdPersonSex());
      
      if (childrenToBeAdopted == null) {
        childrenToBeAdopted = new ArrayList<FosterHomeConversionChildBean>();
      }
      FosterHomeConversionChildBean childBean = new FosterHomeConversionChildBean();
      childBean.setChildAge(row.getLNbrPersonAge());
      childBean.setIdChild(row.getUlIdPerson());
      childBean.setChildGender(childGender);
      childBean.setChildName(row.getSzNmPersonFull());
      childrenToBeAdopted.add(childBean);
      fosterHomeConversionDetail.setChildrenToBeAdopted(childrenToBeAdopted);

      PageMode.setPageMode((String) state.getAttribute("ACTUAL_PAGE_MODE", request), request);
      state.setAttribute("ChildrenToBeAdopted", childrenToBeAdopted, request);
      state.setAttribute("formChanged", true, request);
      state.setAttribute("FosterHomeConversionSO", fosterHomeConversionDetail, request);
      forward("/fad/HomeConversion/displayHomeConversion",request,response);
    } catch (Exception e) {
      processSevereException(context, e);
    } finally {
      performanceTrace.exitScope();
    }
    
  }
  
  public void removeChildFromConversion_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".removeChildFromConversion_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
    FosterHomeConversionSO fosterHomeConversionDetail = (FosterHomeConversionSO)state.getAttribute("FosterHomeConversionSO", request);
  
    int idChild = (Integer) ContextHelper.getIntSafe(request, "actionChildId");
    int idFosterHomeConvPerLink = ContextHelper.getIntSafe(request, "actionLinkId");
    int idEvent = GlobalData.getUlIdEvent(request);
    int idHdnIndex = ContextHelper.getIntSafe(request, "hdnIndex");
    
    // if a negative number is passed,
    // simply return and do not delete anything
    if (idHdnIndex < 0) {
      return;
    }
    
    FosterHomeConversionChildBean f = new FosterHomeConversionChildBean();
    f.setIdChild(idChild);
    f.setIdFosterHomeConvPerLink(idFosterHomeConvPerLink);
    f.setIdEvent(idEvent);
    adoExchange.removeChildFromFosterHomeConversion(f);
    
    List<FosterHomeConversionChildBean> childrenToBeAdopted = fosterHomeConversionDetail.getChildrenToBeAdopted();
    childrenToBeAdopted.remove(idHdnIndex);
    fosterHomeConversionDetail.setChildrenToBeAdopted(childrenToBeAdopted);
    state.setAttribute("formChanged", true, request);
    state.setAttribute("FosterHomeConversionSO", fosterHomeConversionDetail, request);
    
  }

  public void displayPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayPersonDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(request);
 
    int idChild = (Integer) ContextHelper.getIntSafe(request, "actionChildId");
    GlobalData.setUlIdPerson(idChild, request);
    state.setAttribute("hdnContinueBtn", ArchitectureConstants.TRUE, request);
  
    
  }

  /**
   * This method will set the page mode.
   *
   * @param request
   */
  public String pageModeSet(GrndsExchangeContext context,  String cdEventStatus, String cdConvAppStatus) {
    HttpServletRequest request = context.getRequest();
    String pageMode = GlobalData.getAppMode(request);
    Date dtClosure = ContextHelper.getJavaDateSafe(request,"dtClosureDate");
    Boolean rights = hasStageAccessRights(context);
    if (EVENT_STATUS_COMP.equals(cdEventStatus)) {
      pageMode = PageModeConstants.INQUIRE;
    } else if (EVENT_STATUS_NEW.equals(cdEventStatus)) {
      pageMode = PageModeConstants.NEW;
    } else if (EVENT_STATUS_APRV.equals(cdEventStatus) && dtClosure == null) {
        if (CONV_STATUS_COMP.equals(cdConvAppStatus)) {
          pageMode = PageModeConstants.INQUIRE;          
        } else {
          pageMode = PageModeConstants.MODIFY;          
        }
    } else if (rights) {
      pageMode = PageModeConstants.MODIFY;
    }else{
      pageMode = PageModeConstants.INQUIRE;
    }
    return pageMode;
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

  private String decodeGender(String gender) {

    String genderDecode = "";
    if ("M".equals(gender)) {
      genderDecode = "Male";
    } else if ("F".equals(gender)) {
      genderDecode = "Female";
    } else {
      genderDecode = "Unknown";
    }

    return genderDecode;
  }
  
  private FosterHomeConversionSI populateFosterHomeConversionSI(GrndsExchangeContext context, String cdReqFuncCd){
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateFosterHomeConversionSI");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    FosterHomeConversionSO fosterHomeConversionDetail = (FosterHomeConversionSO)state.getAttribute("FosterHomeConversionSO", request);
    int idEvent = GlobalData.getUlIdEvent(request);
    int idResource = GlobalData.getUlIdResource(request);
    int idPerson = user.getUserID();
    int idAdoAgency = ContextHelper.getIntSafe(request, "idAdoAgency");
    Date dtApplied = ContextHelper.getJavaDateSafe(request,"dtAppliedDate");
    Date dtApproved = ContextHelper.getJavaDateSafe(request, "dtApprovedDate");
    Date dtClosure = ContextHelper.getJavaDateSafe(request,"dtClosureDate");
    Date dtInquiry = ContextHelper.getJavaDateSafe(request, "dtInquiryDate");
    Date dtEventLastUpdate = (Date) request.getAttribute("dtEventLastUpdate");
    String szCdClosureReason = ContextHelper.getStringSafe(request, "szCdClosureReason");
    String szCdConvAppStatus = ContextHelper.getStringSafe(request,"szCdConvAppStatus");
    String txNmResource = ContextHelper.getStringSafe(request, "txNmResource");
    
    List<FosterHomeConversionChildBean> childrenToBeAdopted = null;
    if(fosterHomeConversionDetail != null) {
      childrenToBeAdopted = fosterHomeConversionDetail.getChildrenToBeAdopted();
    }
    
    if (childrenToBeAdopted == null) {
      childrenToBeAdopted = new ArrayList<FosterHomeConversionChildBean>();
    }

    String saveSubmitButtonNameInRequest = SAVE_AND_SUBMIT + ".x";
    boolean bSaveSubmit = ContextHelper.getString(request, saveSubmitButtonNameInRequest) != null;

    String eventStatus = EVENT_STATUS_PROC;
    if (bSaveSubmit) {
      eventStatus = EVENT_STATUS_PEND;
      szCdConvAppStatus = CONV_STATUS_PEND;
    } else if (dtClosure != null) {
      eventStatus = EVENT_STATUS_APRV;
      szCdConvAppStatus = CONV_STATUS_COMP;
    } else if (dtApproved != null) {
      eventStatus = EVENT_STATUS_APRV;
      szCdConvAppStatus = CONV_STATUS_APRV;
    }
    FosterHomeConversionSI fosterHomeConversionSI = new FosterHomeConversionSI();
    ROWCCMN01UIG00 fosterHomeConversionEvent = new ROWCCMN01UIG00();
    fosterHomeConversionEvent.setSzCdEventStatus(eventStatus);
    fosterHomeConversionEvent.setSzCdEventType(EVENT_TYPE_HCN);
    fosterHomeConversionEvent.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    fosterHomeConversionEvent.setUlIdStage(GlobalData.getUlIdStage(request));
    fosterHomeConversionEvent.setUlIdPerson(idPerson);
    fosterHomeConversionEvent.setSzTxtEventDescr(EVENT_DESC);
    fosterHomeConversionEvent.setSzCdTask(GlobalData.getSzCdTask(request));
    fosterHomeConversionEvent.setUlIdEvent(idEvent);
    fosterHomeConversionSI.setRowCCMN01UIG00(fosterHomeConversionEvent);

    fosterHomeConversionSI.setUlIdEvent(idEvent);
    fosterHomeConversionSI.setUlIdPerson(idPerson);
    fosterHomeConversionSI.setUlIdResource(idResource);
    fosterHomeConversionSI.setUlIdStage(GlobalData.getUlIdStage(request));
    fosterHomeConversionSI.setUlIdCase(GlobalData.getUlIdCase(request));
    fosterHomeConversionSI.setUlIdAdoAgency(idAdoAgency);
    fosterHomeConversionSI.setDtApplied(dtApplied);
    fosterHomeConversionSI.setDtApproved(dtApproved);
    fosterHomeConversionSI.setDtClosed(dtClosure);
    fosterHomeConversionSI.setDtInquiry(dtInquiry);
    fosterHomeConversionSI.setDtEventLastUpdate(dtEventLastUpdate);
    fosterHomeConversionSI.setSzCdClosureReason(szCdClosureReason);
    fosterHomeConversionSI.setSzCdConvAppStatus(szCdConvAppStatus);
    fosterHomeConversionSI.setChildrenToBeAdopted(childrenToBeAdopted);
    fosterHomeConversionSI.setNmResource(txNmResource);
    fosterHomeConversionSI.setCdReqFuncCd(cdReqFuncCd);
    fosterHomeConversionSI.setEventStatus(eventStatus);
    fosterHomeConversionSI.setEventDescription(EVENT_DESC);

    performanceTrace.exitScope();
    return fosterHomeConversionSI;
  }

  private boolean checkFHConvNarrExists(int idEvent) {
    NonComplianceSO nonComplianceSO = null;
    NonComplianceSI nonComplianceSI = new NonComplianceSI();
    
    nonComplianceSI.setCdNonCompliance(CodesTables.CEVNTTBL_HCN);
    nonComplianceSI.setIdEvent(idEvent);
    nonComplianceSO = nonCompliance.checkDocExistsForNonCompliance(nonComplianceSI);
    
    Date dtFormLastDate = nonComplianceSO.getDtFormLastDate();
    return (dtFormLastDate == null) ? false : true;

  }

  /**
   * This helper method is called by the saveAdoptionAsstnc method to handle any WtcExceptions by setting the branch,
   * looking up the error message and setting it.
   *
   * @param we      The WtcException object.
   * @param context The GrndsExchangeContext object.
   */
  private void handleSaveError(ServiceException we, GrndsExchangeContext context) {
    HttpServletRequest request = context.getRequest();

    int errorCode = we.getErrorCode();
    switch (errorCode) {
      case Messages.MSG_SYS_STAGE_CLOSED:
      case Messages.MSG_SYS_MULT_INST:
      case Messages.MSG_SUB_PERIOD_OVERLAP_1:
      case Messages.MSG_SUB_PERIOD_OVERLAP_2:
      case Messages.SQL_NOT_FOUND:
      case Messages.MSG_FAD_CONV_APP_DATE:
      case Messages.MSG_FAD_CONV_NARR_REQD:
      case Messages.MSG_FAD_CONV_CLOSURE_RSN:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(errorCode, request);
        break;
      case Messages.MSG_DATABASE_SAVE_FAIL:
        this.setPresentationBranch(ArchitectureConstants.ERROR_BRANCH_NAME, context);
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, request);
        break;
      default:
        processSevereException(context, we);
        break;
    }
  }
}
