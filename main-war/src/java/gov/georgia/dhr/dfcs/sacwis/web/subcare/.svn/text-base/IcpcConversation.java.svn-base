
package gov.georgia.dhr.dfcs.sacwis.web.subcare;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.BasePrsException;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.service.casemgmt.CaseMgmt;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IcpcDetailRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.IcpcDetailSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCMN01UIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IcpcDetailSaveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.workload.EventSearchConversation;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.ValidationException;
import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This Conversation class is used for ICPC Detail Page
 * @author ashwini.rege
 *
 * Change History:
 *  Date        User              Description
 * --------    ----------------  ----------------------------------------------------------------
 * 01/23/2012	arege		STGAP00017827: MR-085 Initial Creation
 * 01/27/2012	arege		STGAP00017827: MR-085 Changes
 * 02/06/2012   arege           STGAP00017827: MR-085 Added comments and cleaned up the code , correctly set the dtCompleted, iveDeterm and aaFunding fields
 * 02/09/2012   arege           STGAP00017827: Removed unnecessary code as per peer review modified the logic for saving checkboxes.
 * 02/10/2012   arege           STGAP00017827: Added private method handleException() to handle exceptions.
 * 02/17/2012   arege           STGAP00017917: Changed the method to set Eligibility, so that the IVE determination displays correctly even in COMP status.
 * 02/28/2012   arege           STGAP00017947: Changed the way the primary person, spouse and resource name options display on the page.
 * 02/29/2012   arege           STGAP00017956 and STGAP00017948: Added new action method addIcpcDetail_xa so that the page is redisplayed after change of primary person, spouse or resource
 * 03/07/2012   arege           STGAP00017977: Save checkboxes corresponding to the selected radio button only
 * 03/08/2012   arege           STGAP00017977: Save Date of Termination only if one of the termination reason is selected and comments if Other(specify) radio button is selected
 */


/**
 * Display method for ICPC Detail page
 * 
 * @param contextContains the session, state, and request objects to get data from jsps
 */
public class IcpcConversation extends BaseHiddenFieldStateConversation {
  @SuppressWarnings( { "unchecked" })
  private CaseMgmt caseMgmt;

  public void setCaseMgmt(CaseMgmt caseMgmt) {
    this.caseMgmt = caseMgmt;
  }
  
  public void addIcpcDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reloadICPCDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    IcpcDetailRetrieveSO icpcReload = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);

    try {    
      IcpcDetailRetrieveSI icpcDetailRetrieveSI = populate_RetrieveSI(context);
      icpcDetailRetrieveSI.setIdPrimaryPerson(ContextHelper.getIntSafe(request, "selPrimaryPerson"));
      icpcDetailRetrieveSI.setIdSpouse(ContextHelper.getIntSafe(request, "selSpouse"));
    
      // Call the Retrieve Service.
      icpcReload = caseMgmt.retrieveIcpcDetail(icpcDetailRetrieveSI);
      if (request.getParameter("formType") != null && !"".equals(request.getParameter("formType"))) {
        icpcReload.setCdFormType(ContextHelper.getStringSafe(request, "formType"));
      }
      icpcReload.setIdPrimaryPerson(ContextHelper.getIntSafe(request, "selPrimaryPerson"));
      icpcReload.setIdSpouse(ContextHelper.getIntSafe(request, "selSpouse"));
      icpcReload.setIndICWAEligible(ContextHelper.getStringSafe(request, "rbICWAEligible"));
      icpcReload.setIndCrtOrderAf(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachAF"));
   
      String indCrtOrderAf = CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachAF");
      if(StringHelper.isNotEmptyOrNull(indCrtOrderAf)){
        icpcReload.setIndCrtOrderAf(indCrtOrderAf);
      }else{
        icpcReload.setIndCrtOrderAf(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachAF_changed"));
      }
    
      icpcReload.setIndCrtOrderLcrp(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachLCRP"));
      icpcReload.setIndCrtOrderLcgr(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachLCGR"));
      icpcReload.setTxtOtherSpecify(ContextHelper.getStringSafe(request, "txtOtherTermRsn"));
      String cdTypeCare = ContextHelper.getStringSafe(request, "rbTypeOfCare");
      icpcReload.setCdTypeCare(cdTypeCare);
      String cdInitialReportReq = ContextHelper.getStringSafe(request, "rbCdInitialReportReq");
      icpcReload.setCdInitReportReq(cdInitialReportReq);// Type of Study requested
      String indFinalizedIn = ContextHelper.getStringSafe(request, "rbIndFinalizedIn");
      if(StringHelper.isNotEmptyOrNull(indFinalizedIn)){
        icpcReload.setIndFinalizedIn(indFinalizedIn);
      }else{
        icpcReload.setIndFinalizedIn(ContextHelper.getStringSafe(request, "rbIndFinalizedIn_Disabled"));  
      }
      icpcReload.setIndPlcmtStatus(ContextHelper.getStringSafe(request, "rbIndPlacementStatus"));
      icpcReload.setDtPlacedRecState(ContextHelper.getJavaDateSafe(request, "dtPlacedRecState"));
      icpcReload.setDtEffectDtChange(ContextHelper.getJavaDateSafe(request, "dtEffectDtChange"));
      icpcReload.setCdPlcmtTermRsn(ContextHelper.getStringSafe(request, "rbCdPlacementTermReason"));
      icpcReload.setDtTermination(ContextHelper.getJavaDateSafe(request, "dtDateTermination"));
      
      // Populate Required Documents checkbox values    
      List<String> reqCbxToAdd = new ArrayList<String>();
      String[] reqCbxValues = CheckboxHelper.getCheckedValues(request, "cbxReqDoc");
      //Change from array to list
      for (int i = 0; i < reqCbxValues.length; i++) {
        String cdReqDoc = reqCbxValues[i];
        reqCbxToAdd.add(cdReqDoc);
      }
      icpcReload.setSavedReqCbx(reqCbxToAdd);

      // Populate If Applicable Documents checkbox values
      List<String> aplCbxToAdd = new ArrayList<String>();
      String[] aplCbxValues = CheckboxHelper.getCheckedValues(request, "cbxAplDoc");
      for (int i = 0; i < aplCbxValues.length; i++) {
        String cdAplDoc = aplCbxValues[i];
        aplCbxToAdd.add(cdAplDoc);
      }
      icpcReload.setSavedAplCbx(aplCbxToAdd);
      state.setAttribute("ICPCDETAILRETSO", icpcReload, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  public void displayIcpcDetail_xa(GrndsExchangeContext context) {
    // Instantiate and start a new PerformanceTrace object
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".displayIcpcDetail_xa ()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    UserProfile userProfile = UserProfileHelper.getUserProfile(request);
    int idLoggedInUser = userProfile.getUserID();
    try {
      request = context.getRequest();
      BaseSessionStateManager state = getSessionStateManager(context);
      state.removeAllAttributes(request);
      IcpcDetailRetrieveSI icpcDetailRetrieveSI = populate_RetrieveSI(context);
      icpcDetailRetrieveSI.setIdPrimaryPerson(ContextHelper.getIntSafe(request, "selPrimaryPerson"));
      icpcDetailRetrieveSI.setIdSpouse(ContextHelper.getIntSafe(request, "selSpouse"));
      icpcDetailRetrieveSI.setIdLoggedInUser(idLoggedInUser);
      IcpcDetailRetrieveSO icpcDetailRetrieveSO = new IcpcDetailRetrieveSO();

      // Call the Retrieve Service.
      icpcDetailRetrieveSO = caseMgmt.retrieveIcpcDetail(icpcDetailRetrieveSI);

      // Get list of principals from the RetrieveSO object and create option list to be displayed on the page for fields
      // Primary Person, Spouse and Resource (100B)
      List<Option> principalsToDisplayList = new ArrayList<Option>();
      List<Map> principalList = icpcDetailRetrieveSO.getPrincipalsOver18List();
      if (principalList != null && !principalList.isEmpty()) {
        for (Iterator<Map> i = principalList.iterator(); i.hasNext();) {
          Map<String, Object> row = i.next();
          principalsToDisplayList
                                 .add(new Option(
                                                 String.valueOf(row.get("idPerson")),
                                                 (String) row.get("nmPersonFull")));
        }
      }
      state.setAttribute("PRNTODISPLIST", principalsToDisplayList, request);
      state.setAttribute("ICPCDETAILRETSO", icpcDetailRetrieveSO, request);

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
      handleException(e, context, "displayIcpcDetail_xa()");
    }

  }

  /**
   * This method is called to redisplay the ICPC Detail page after the ICPC Form type is selected and Continue button is
   * clicked.
   * 
   * @param context
   */
  public void reloadIcpcDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".reloadICPCDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    IcpcDetailRetrieveSO icpcReload = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);

    try {
      if (request.getParameter("formType") != null && !"".equals(request.getParameter("formType"))) {
        icpcReload.setCdFormType(ContextHelper.getStringSafe(request, "formType"));
      }
      state.setAttribute("ICPCDETAILRETSO", icpcReload, request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }

  /**
   * Populates retrieveSI object to be passed to the retrieve service.
   * 
   * @param context
   * @return
   * @throws MarshalException
   * @throws ValidationException
   * @throws DataFormatException
   */
  private IcpcDetailRetrieveSI populate_RetrieveSI(GrndsExchangeContext context) throws MarshalException,
                                                                                ValidationException,
                                                                                DataFormatException {
    HttpServletRequest request = context.getRequest();
    IcpcDetailRetrieveSI icpcDetailRetrieveSI = new IcpcDetailRetrieveSI();
    icpcDetailRetrieveSI.setUlIdCase(GlobalData.getUlIdCase(request));
    icpcDetailRetrieveSI.setUlIdStage(GlobalData.getUlIdStage(request));
    icpcDetailRetrieveSI.setUlIdChild(GlobalData.getUlIdPerson(request));
    icpcDetailRetrieveSI.setCdStage(GlobalData.getSzCdStage(request));
    icpcDetailRetrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    return icpcDetailRetrieveSI;
  }

  /**
   * This method is used to Save ICPC Detail page
   * 
   * @param context
   */
  public void saveIcpcDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveIcpcDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    IcpcDetailRetrieveSO icpcReload = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);
    String cdFormType = icpcReload.getCdFormType();
    try {
      IcpcDetailSaveSI icpcDetailSaveSI = new IcpcDetailSaveSI();
      icpcDetailSaveSI.setCdFormType(cdFormType);
      populate_SaveSI(context, icpcDetailSaveSI);
      IcpcDetailSaveSO icpcDetailSaveSO = caseMgmt.saveIcpcDetail(icpcDetailSaveSI);
      GlobalData.setUlIdEvent(icpcDetailSaveSO.getIdEvent(), request);
      GlobalData.setSzCdTask(icpcDetailSaveSO.getCdTask(), request);
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "General Failure: " + e.getMessage());
      handleException(e, context, "saveIcpcDetail_xa()");
    }
    performanceTrace.exitScope();
  }

  /**
   * This method is used to populate SaveSI object from the request which is then passed to the Save Service.
   * 
   * @param context
   * @param icpcDetailSaveSI
   */
  private void populate_SaveSI(GrndsExchangeContext context, IcpcDetailSaveSI icpcDetailSaveSI) {

    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);

    IcpcDetailRetrieveSO icpcDetailRetSO = (IcpcDetailRetrieveSO) state.getAttribute("ICPCDETAILRETSO", request);
    ROWCCMN01UIG00 event = new ROWCCMN01UIG00();

    // Get the current event status.
    String eventStatus = StringHelper.EMPTY_STRING;
    if (icpcDetailRetSO != null && icpcDetailRetSO.getRowccmn45do() != null) {
      eventStatus = icpcDetailRetSO.getRowccmn45do().getSzCdEventStatus();
    }

    boolean btnCompleteIsPressed = ContextHelper.getString(request, "btnComplete.x") != null;

    // Check if the complete button is pressed OR the current status of the event is COMP. This is checked
    // because the Save button is available even in COMP status.
    if (btnCompleteIsPressed || CodesTables.CEVTSTAT_COMP.equals(eventStatus)) {
      event.setSzCdEventStatus(CodesTables.CEVTSTAT_COMP);
      icpcDetailSaveSI.setDtCompleted(icpcDetailRetSO.getDtComplete());
    } else {
      event.setSzCdEventStatus(CodesTables.CEVTSTAT_PROC);
    }
    // Set the dtCompleted to current date when the Complete button is pressed.
    if (btnCompleteIsPressed) {
      Date dtCompleted = new Date();
      icpcDetailSaveSI.setDtCompleted(dtCompleted);
    }

    // Set the Event Object
    event.setSzCdEventType(CodesTables.CEVNTTYP_ICP);
    event.setSzCdTask(GlobalData.getSzCdTask(request));

    org.exolab.castor.types.Date dtDtEventOccured = new org.exolab.castor.types.Date();
  
    //Get dtEventOcurred from SO object and set it into SaveSI object
    if (icpcDetailRetSO != null) {
      icpcDetailSaveSI.setAaFundingDeterm(icpcDetailRetSO.getAaFundingDeterm()); 
      icpcDetailSaveSI.setIveDeterm(icpcDetailRetSO.getCdIVEDetermination()); //changed method from getIVEdeterm
      icpcDetailSaveSI.setIdChild(icpcDetailRetSO.getIdChild());
      if (icpcDetailRetSO.getRowccmn45do() != null) {
        dtDtEventOccured = icpcDetailRetSO.getRowccmn45do().getDtDtEventOccurred();       
        event.setDtDtEventOccurred(dtDtEventOccured);
      }     
    } else {
      event.setDtDtEventOccurred(DateHelper.getTodayCastorDate());
    }
    event.setUlIdEvent(GlobalData.getUlIdEvent(request));
    event.setSzTxtEventDescr("ICPC");
    event.setSzCdTask(ContextHelper.getStringSafe(request, "szCdTask"));
    event.setUlIdStage(GlobalData.getUlIdStage(request));
    icpcDetailSaveSI.setRowccmn01uig00(event);
    ContextHelper.getStringSafe(request, "formType");
    icpcDetailSaveSI.setDtEventLastUpdate(ContextHelper.getJavaDateSafe(request, "evtsLastUpdate"));
    icpcDetailSaveSI.setIdPrimaryPerson(ContextHelper.getIntSafe(request, "selPrimaryPerson"));
    icpcDetailSaveSI.setIdSpouse(ContextHelper.getIntSafe(request, "selSpouse"));
    icpcDetailSaveSI.setIdCaseWorker(user.getUserID());
    icpcDetailSaveSI.setIndICWAEligible(ContextHelper.getStringSafe(request, "rbICWAEligible"));
    String cdTermReason = ContextHelper.getStringSafe(request, "rbCdPlacementTermReason");
    icpcDetailSaveSI.setCdPlcmtTermRsn(cdTermReason);
    //STGAP00017977: Save checkboxes corresponding to the selected radio button only
    if(CodesTables.CTERMRSN_TRA.equals(cdTermReason)){
    icpcDetailSaveSI.setIndCrtOrderAf(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachAF"));
    icpcDetailSaveSI.setIndCrtOrderLcrp(ArchitectureConstants.N);
    icpcDetailSaveSI.setIndCrtOrderLcgr(ArchitectureConstants.N);
    }else if (CodesTables.CTERMRSN_TRC.equals(cdTermReason)){
    icpcDetailSaveSI.setIndCrtOrderLcrp(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachLCRP"));
    icpcDetailSaveSI.setIndCrtOrderAf(ArchitectureConstants.N);
    icpcDetailSaveSI.setIndCrtOrderLcgr(ArchitectureConstants.N);
    }else if (CodesTables.CTERMRSN_TRD.equals(cdTermReason)){
    icpcDetailSaveSI.setIndCrtOrderAf(ArchitectureConstants.N);
    icpcDetailSaveSI.setIndCrtOrderLcrp(ArchitectureConstants.N);
    icpcDetailSaveSI.setIndCrtOrderLcgr(CheckboxHelper.getCheckboxValue(request, "cbxIndCourtOrderAttachLCGR"));
    }
    else{
      icpcDetailSaveSI.setIndCrtOrderAf(ArchitectureConstants.N);
      icpcDetailSaveSI.setIndCrtOrderLcrp(ArchitectureConstants.N);
      icpcDetailSaveSI.setIndCrtOrderLcgr(ArchitectureConstants.N);
    }
    
    if(CodesTables.CTERMRSN_TRL.equals(cdTermReason)){
      icpcDetailSaveSI.setTxtOtherSpecify(ContextHelper.getStringSafe(request, "txtOtherTermRsn"));  
    }else{
      icpcDetailSaveSI.setTxtOtherSpecify(StringHelper.EMPTY_STRING); 
    }
    
    String cdTypeCare = ContextHelper.getStringSafe(request, "rbTypeOfCare");
    icpcDetailSaveSI.setCdTypeCare(cdTypeCare);
    String cdInitialReportReq = ContextHelper.getStringSafe(request, "rbCdInitialReportReq");
    icpcDetailSaveSI.setCdInitReportReq(cdInitialReportReq);// Type of Study requested
    //STGAP00017961: If Adoptive study selected get value from disabled radio button 'rbIndFinalizedIn_Disabled'
    //if the value from rbIndFinalizedIn is null i.e when rbIndFinalizedIn does not exist
      String indFinalizedIn = ContextHelper.getStringSafe(request, "rbIndFinalizedIn");
      if(StringHelper.isNotEmptyOrNull(indFinalizedIn)){
      icpcDetailSaveSI.setIndFinalizedIn(indFinalizedIn);
      }else{
        icpcDetailSaveSI.setIndFinalizedIn(ContextHelper.getStringSafe(request, "rbIndFinalizedIn_Disabled"));  
      }  
    icpcDetailSaveSI.setIndPlcmtStatus(ContextHelper.getStringSafe(request, "rbIndPlacementStatus"));
    icpcDetailSaveSI.setDtPlacedRecState(ContextHelper.getJavaDateSafe(request, "dtPlacedRecState"));
    icpcDetailSaveSI.setDtEffectDtChange(ContextHelper.getJavaDateSafe(request, "dtEffectDtChange"));
    icpcDetailSaveSI.setCdPlcmtTermRsn(ContextHelper.getStringSafe(request, "rbCdPlacementTermReason"));
    icpcDetailSaveSI.setCdTask(GlobalData.getSzCdTask(request));
    icpcDetailSaveSI.setDtEventLastUpdate(ContextHelper.getJavaDateSafe(request, "evtsLastUpdate"));
    icpcDetailSaveSI.setIdStage(GlobalData.getUlIdStage(request));
    
    if(StringHelper.isNotEmptyOrNull(cdTermReason)){
    icpcDetailSaveSI.setDtTermination(ContextHelper.getJavaDateSafe(request, "dtDateTermination"));
    }
    
    // Populate Required Documents checkbox values    
    List<String> reqCbxToAdd = new ArrayList<String>();
    String[] reqCbxValues = CheckboxHelper.getCheckedValues(request, "cbxReqDoc");
    //Change from array to list
    for (int i = 0; i < reqCbxValues.length; i++) {
      String cdReqDoc = reqCbxValues[i];
      reqCbxToAdd.add(cdReqDoc);
    }
    icpcDetailSaveSI.setReqCbxToAdd(reqCbxToAdd);

    // Populate If Applicable Documents checkbox values
    List<String> aplCbxToAdd = new ArrayList<String>();
    String[] aplCbxValues = CheckboxHelper.getCheckedValues(request, "cbxAplDoc");
    for (int i = 0; i < aplCbxValues.length; i++) {
      String cdAplDoc = aplCbxValues[i];
      aplCbxToAdd.add(cdAplDoc);
    }
    icpcDetailSaveSI.setAplCbxToAdd(aplCbxToAdd);
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
        setErrorMessage(errorCode, "/subcare/Icpc/displayIcpcDetail", request);
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
