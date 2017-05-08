package gov.georgia.dhr.dfcs.sacwis.web.fce;


import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.MedicaidApplicationSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PrincipalsList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.MedicaidApplicationRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BaseHiddenFieldStateConversation;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;
import gov.georgia.dhr.dfcs.sacwis.web.fce.FceUtility;
import gov.georgia.dhr.dfcs.sacwis.service.fce.SaveEligibilityAlert;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.log.GrndsTrace;
import org.grnds.structural.web.GrndsExchangeContext;

/**
 * 
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 
 * </pre>
 *
 * @author Gautami Rout, March 18, 2006
 * 
 * 
 * 3/26/09   cwells            STGAP00012033 Made corrections to display the eligibility alerts correctly whenever a 
 *                             Medicaid application is save and submitted.  

 * 4/13/09   cwells            STGAP00012997 Catching error messages and displaying them cleanly.                              
 * 
 */
public class InitialMedicaidConversation extends BaseHiddenFieldStateConversation { 
  public static final String INITIAL_MEDICAID_APPLICATION_PAGE = "InitialMedicaid";
  public static final String TRACE_TAG = "InitialMedicaidConversation";
  public static final String DISPLAY_URI = "/fce/InitialMedicaid/displayInitialMedicaid";
  private static final String BUTTONATTRB = "buttonAttrb";
  private static final String SSBUTTONATTRB = "ssButtonAttrb";
  private static final String SAVEBUTTONATTRB = "saveButtonAttrb";
  private static final String SAVECONFIRMATIONBUTTONATTRB = "saveConfirmationButtonAttrb";
  public static final String INITIAL_MEDICAID_TASK_CODE = "3140";
  private static final String TRUE = "true";
  private static final String FALSE = "false";
  public static final String INITIAL_MEDICAID = "IMA";
   
  private Fce fce;
  private SaveEligibilityAlert saveEligibilityAlert = null;
    
  public void setFce(Fce fce) {
    this.fce = fce;
  }
 
  public void setSaveEligibilityAlert(SaveEligibilityAlert saveEligibilityAlert) {
    this.saveEligibilityAlert = saveEligibilityAlert;
  }
  /**
   * This method will collect the data display the Initial Medicaid page.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  
  public void displayInitialMedicaid_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayInitialMedicaid()");
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);

    try {
      clearState(context);
      FceUtility.clearFceTabState(request);
      GlobalData.setSzCdTask(null, request);
      MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI = populateMedicaidApplicationRetrieveSI(context);
      MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO =  fce.retrieveInitialMedicaid(medicaidApplicationRetrieveSI);
      state.setAttribute("MedicaidApplicationRetrieveSO", medicaidApplicationRetrieveSO, request);
      String cdEventStatus = medicaidApplicationRetrieveSO.getCdEventStatus();
      String pageMode  = pageModeSet(context,cdEventStatus);
      // hjbaptiste - Due to some converted cases having closed FCC stages, we want to display the page
      // in view only mode so the user can't modify the page of a closed stage
      if (medicaidApplicationRetrieveSO.isStageIsClosed()){
        pageMode = PageModeConstants.VIEW;
      }
      PageMode.setPageMode(pageMode, request);
      int idEvent = fce.retrieveIdEventFromEvent(GlobalData.getUlIdStage(request));
      if(idEvent == 0){
        saveInitialMedicaid_xa(context);
      }
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_NO_ROWS_RETURNED:
        setInformationalMessage(we.getErrorCode(), DISPLAY_URI, request);
        break;
      default:
        GrndsTrace.msg(TRACE_TAG, 7, "Service Failure:" + we.getMessage());
        processSevereException(context, we);
      break;
      }
    }catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "displayInitialMedicaid_xa :" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  /**
   * Populating SI object  from the context. All population from the context (including request, session, and
   * state). The method should instantiate the input object, get values out of the context, and then return the SI
   * object.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   * @return display service input object
   */
  private MedicaidApplicationRetrieveSI populateMedicaidApplicationRetrieveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateCFAD39SI_Retrieve");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    MedicaidApplicationRetrieveSI medicaidApplicationRetrieveSI = new MedicaidApplicationRetrieveSI();
    medicaidApplicationRetrieveSI.setUlIdEvent(GlobalData.getUlIdEvent(request));
    medicaidApplicationRetrieveSI.setUlIdStage(GlobalData.getUlIdStage(request));
    medicaidApplicationRetrieveSI.setUlIdCase(GlobalData.getUlIdCase(request));
    medicaidApplicationRetrieveSI.setUlIdPerson(user.getUserID());
    
    performanceTrace.exitScope();
    return medicaidApplicationRetrieveSI;
  }
  /**
   * Called when user clicks the Detail button for the child is pressed or a Principal List hyperlink is clicked.
   * Auto-saves the page's information before navigating to the Person Detail page.
   */
  public void forwardPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "forwardPersonDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    
    try {
      FceUtility.clearFceTabState(request);
      GlobalData.setSzCdTask(null, request);
      // SIR 18177: only save if pageMode is EDIT.
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        saveInitialMedicaid_xa(context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }
      
      //  Event List should have already provided stage code and program code.
      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnPersonDetailId"), request);
      
      // SIR 23307 - Set Person Detail Page mode to edit or view depending on
      // the current page's pageMode
      PersonHelper.setPersonDetailPageMode(request, pageMode);
      
    }catch (ServiceException we) {
      processSevereException(context, we);
    } catch (Exception e) {
      processSevereException(context, e);
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
  }
  
  /**
   * This method will save the data in the main section.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public MedicaidApplicationSaveSI saveInitialMedicaid_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveInitialMedicaid_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    
    MedicaidApplicationSaveSI medicaidApplicationSaveSI = new MedicaidApplicationSaveSI();
    try {      
      boolean savePressed = ContextHelper.getString(request, "btnSaveFinal.x") != null;
      state.setAttribute(SAVEBUTTONATTRB, savePressed, request);
      saveInitialMedicaid(context, medicaidApplicationSaveSI);
    }catch (ServiceException we) {
      //STGAP00012997 catching error messages thrown by the save 
      // method.  To display errors cleanly. 
      switch (we.getErrorCode()) {
      case Messages.MSG_FCE_NO_MEDICNUM_INIT_MA:
        setErrorMessage(Messages.MSG_FCE_NO_MEDICNUM_INIT_MA, DISPLAY_URI, context.getRequest());
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, DISPLAY_URI, context.getRequest());
        break;
      case Messages.MSG_CRS_ID_NOT_FND:
        setErrorMessage(Messages.MSG_CRS_ID_NOT_FND, DISPLAY_URI, context.getRequest());
        break;
      case Messages.MSG_CRS_ID_NOT_A_NUMBER:
        setErrorMessage(Messages.MSG_CRS_ID_NOT_A_NUMBER, DISPLAY_URI, context.getRequest());
        break;
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
    
    performanceTrace.getTotalTime();
    performanceTrace.exitScope();
    return medicaidApplicationSaveSI;
  }
  
  public void saveInitialMedicaid(GrndsExchangeContext context, MedicaidApplicationSaveSI medicaidApplicationSaveSI) throws ServiceException {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".saveInitialMedicaid()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    int idEvent; 
    medicaidApplicationSaveSI = populateMedicaidApplicationSaveSI(context);
    medicaidApplicationSaveSI = populateSaveBeanLists(medicaidApplicationSaveSI, context);
    try {
      idEvent = fce.saveInitialMedicaid(medicaidApplicationSaveSI);
      GlobalData.setUlIdEvent(idEvent, request);
      
    } catch (ServiceException we) {
        throw we;
    }    
    performanceTrace.exitScope();

  }
  
  
  
  private MedicaidApplicationSaveSI populateMedicaidApplicationSaveSI(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "populateMedicaidApplicationSaveSO");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();    
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    MedicaidApplicationRetrieveSO medicaidApplicationRetrieveSO = (MedicaidApplicationRetrieveSO) state.getAttribute("MedicaidApplicationRetrieveSO", request);
    boolean saveAndSubmitPressed = Boolean.parseBoolean(state.getAttribute(SSBUTTONATTRB, request) != null ? 
                                   state.getAttribute(SSBUTTONATTRB, request).toString() :
                                   (String)null);
    boolean savePressed = Boolean.parseBoolean(state.getAttribute(SAVEBUTTONATTRB, request) != null ? 
                          state.getAttribute(SAVEBUTTONATTRB, request).toString() :
                          (String)null);
    boolean saveConfirmationPressed = Boolean.parseBoolean(state.getAttribute(SAVECONFIRMATIONBUTTONATTRB, request) != null ? 
                          state.getAttribute(SAVECONFIRMATIONBUTTONATTRB, request).toString() :
                          (String)null);
    
    boolean signNowPressed = Boolean.parseBoolean(state.getAttribute(BUTTONATTRB, request) != null ? 
                                                                                                    state.getAttribute(BUTTONATTRB, request).toString() :
                                                                                                    (String)null);

    
    int idEvent = fce.retrieveIdEventFromEvent(GlobalData.getUlIdStage(request));
    MedicaidApplicationSaveSI medicaidApplicationSaveSI = new MedicaidApplicationSaveSI();    
    String cdEventStatus = "";
    String cdTask = "";
    Date dtLastUpdate = null;
    Date dtEventOccurred = null;
    try {
      if (idEvent > 0) {
        List eventList = fce.retrieveEventByIdEvent(idEvent);
        if(!eventList.isEmpty() || eventList != null){
          cdEventStatus = (String)eventList.get(0);
          cdTask = (String)eventList.get(1);
          dtLastUpdate = (Date)eventList.get(2);
          dtEventOccurred = (Date)eventList.get(3);
        }
        medicaidApplicationSaveSI.setCdEventStatus(cdEventStatus);
        medicaidApplicationSaveSI.setCdTask(cdTask);
        medicaidApplicationSaveSI.setDtEventLastUpdate(dtLastUpdate);
        medicaidApplicationSaveSI.setDtEventOccurred(dtEventOccurred);
        if (saveAndSubmitPressed) {
          medicaidApplicationSaveSI.setCdEventStatus(CodesTables.CEVTSTAT_PEND);
          medicaidApplicationSaveSI.setIntFlag(true);
        }else if(savePressed || signNowPressed){
          medicaidApplicationSaveSI.setCdEventStatus(CodesTables.CEVTSTAT_PROC);
          medicaidApplicationSaveSI.setCdTask(GlobalData.getSzCdTask(request));
        }else if(saveConfirmationPressed){
          medicaidApplicationSaveSI.setCdEventStatus(CodesTables.CEVTSTAT_APRV);
        }
        
      } else {
        medicaidApplicationSaveSI.setCdEventStatus(CodesTables.CEVTSTAT_NEW);
        medicaidApplicationSaveSI.setCdTask(GlobalData.getSzCdTask(request));
        medicaidApplicationSaveSI.setDtEventOccurred(new Date());
        medicaidApplicationSaveSI.setDtEventLastUpdate(new Date());
      }
     
      medicaidApplicationSaveSI.setEventId(idEvent);
      String indChildCoverage = ContextHelper.getStringSafe(request, "indChildCoverage");
      String indCaseManagerApply = ContextHelper.getStringSafe(request, "indCaseManagerApply");
      String indChildPregnancy = ContextHelper.getStringSafe(request, "indChildPregnent");
      String indChild = ContextHelper.getStringSafe(request, "indChild");
      String indMedicalAssistChild = ContextHelper.getStringSafe(request, "indMedicalAssistChild");
      String indParent = ContextHelper.getStringSafe(request, "indParent");
      String indChildSupportOrder = ContextHelper.getStringSafe(request, "indChildSupportOrder");
      medicaidApplicationSaveSI.setIndChildCoverage(toCharIndicator(indChildCoverage));
      medicaidApplicationSaveSI.setNmCompany(ContextHelper.getStringSafe(request, "nmCompany"));
      medicaidApplicationSaveSI.setCdType(ContextHelper.getStringSafe(request, "cdType"));
      medicaidApplicationSaveSI.setNbrPolicy(ContextHelper.getStringSafe(request, "nbrPolicy"));
      medicaidApplicationSaveSI.setNbrGroup(ContextHelper.getStringSafe(request, "nbrGroup"));
      medicaidApplicationSaveSI.setAddrStreetLn1(ContextHelper.getStringSafe(request, "addrStLn1"));
      medicaidApplicationSaveSI.setAddrStreetLn2(ContextHelper.getStringSafe(request, "addrStLn2"));
      medicaidApplicationSaveSI.setAddrCity(ContextHelper.getStringSafe(request, "addrCity"));
      medicaidApplicationSaveSI.setAddrState(ContextHelper.getStringSafe(request, "addrState"));
      String addrZip = ContextHelper.getStringSafe(request, "addrZip") + ContextHelper.getStringSafe(request, "addrZipSuff");
      medicaidApplicationSaveSI.setAddrZip(addrZip);
      medicaidApplicationSaveSI.setNbrPhone(FormattingHelper.decodeFormattedPhoneString(ContextHelper.getStringSafe(request, "nbrPhone")));
      medicaidApplicationSaveSI.setNmPolicyHolder(ContextHelper.getStringSafe(request, "nmPolicyHolder"));
      medicaidApplicationSaveSI.setDtBegin(ContextHelper.getJavaDateSafe(request, "dtBegin"));
      medicaidApplicationSaveSI.setDtEnd(ContextHelper.getJavaDateSafe(request, "dtEnd"));
      medicaidApplicationSaveSI.setNmEmployer(ContextHelper.getStringSafe(request, "nmEmployer"));
      medicaidApplicationSaveSI.setNmEmployeeName(ContextHelper.getStringSafe(request, "nmEmployeeName"));
      medicaidApplicationSaveSI.setIndCaseManagerApply(toCharIndicator(indCaseManagerApply));
      medicaidApplicationSaveSI.setIndChildPregnancy(toCharIndicator(indChildPregnancy));
      medicaidApplicationSaveSI.setIndHealthInsuranceCard(toCharIndicator(indChild));
      medicaidApplicationSaveSI.setIndMedicalAsstChild(toCharIndicator(indMedicalAssistChild));
      medicaidApplicationSaveSI.setDtEstDeliveryDate(ContextHelper.getJavaDateSafe(request, "dtEstDeliveryDate"));
      medicaidApplicationSaveSI.setDtProcessed(ContextHelper.getJavaDateSafe(request, "dtProcessed"));
      medicaidApplicationSaveSI.setTxtComments(ContextHelper.getStringSafe(request, "txtComments"));
      medicaidApplicationSaveSI.setTxtMonths(ContextHelper.getStringSafe(request, "txtMonths"));
      medicaidApplicationSaveSI.setIndParent(toCharIndicator(indParent));
      medicaidApplicationSaveSI.setIndChildSupportOrder(toCharIndicator(indChildSupportOrder));
     
      medicaidApplicationSaveSI.setCaseId(GlobalData.getUlIdCase(request));
      medicaidApplicationSaveSI.setStageId(GlobalData.getUlIdStage(request));
      medicaidApplicationSaveSI.setNmStage(GlobalData.getSzNmStage(request));
      medicaidApplicationSaveSI.setIdPerson(ContextHelper.getIntSafe(request, "hdnPersonDetailId"));
      
      medicaidApplicationSaveSI.setUserId(user.getUserID());

      medicaidApplicationSaveSI.setSave(savePressed);
      medicaidApplicationSaveSI.setSigned(signNowPressed);
      medicaidApplicationSaveSI.setSaveAndSubmit(saveAndSubmitPressed);
      Date dtRemoval1 = ContextHelper.getJavaDateSafe(context, "hdnDtRemoval");
      medicaidApplicationSaveSI.setDtRemoval(dtRemoval1);
      Date dtCmSigned = ContextHelper.getJavaDateSafe(request, "dtCmSigned");
      if (signNowPressed && dtCmSigned == null){
        dtCmSigned = new Date();
      }
      medicaidApplicationSaveSI.setDtCmSigned(dtCmSigned);
      
      medicaidApplicationSaveSI.setCdAdoptionType(ContextHelper.getStringSafe(request,"cdAdoptionType"));
      medicaidApplicationSaveSI.setCdIcamaAsstType(ContextHelper.getStringSafe(request,"cdIcamaAsstType"));
      medicaidApplicationSaveSI.setCdIcamaState(ContextHelper.getStringSafe(request,"cdIcamaState"));
      medicaidApplicationSaveSI.setIndIcamaIcpc(ContextHelper.getStringSafe(request,"indIcamaIcpc"));
      medicaidApplicationSaveSI.setTxtIcamaComments(ContextHelper.getStringSafe(request,"txtIcamaComments"));
           
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
    return medicaidApplicationSaveSI;
  }
  
  /** @return medicaidApplicationSaveSI*/
  private MedicaidApplicationSaveSI populateSaveBeanLists(MedicaidApplicationSaveSI medicaidApplicationSaveSI,
                                                          GrndsExchangeContext context){
    HttpServletRequest request = context.getRequest();
    List<PrincipalsList> principals = new ArrayList<PrincipalsList>();
    // Loop through principal list inputs.
    for (int i = 0; ; i++) {
      String indParentString = "indParent_" + i + "_changed";
      // Break when we can't find the next input.
      if (!request.getParameterMap().containsKey(indParentString)) {
        break;
      }
      PrincipalsList principal = new PrincipalsList();
      principal.setIndParent(CheckboxHelper.getCheckboxValue(request, "indParent_" + i));
      principal.setIdPerson(ContextHelper.getIntSafe(request, "principalPersonId_" + i));
      principal.setDtLastUpdateTime(ContextHelper.getLongSafe(request, "principalLastUpdate_" + i));
      principals.add(principal);
    }
    medicaidApplicationSaveSI.setPrincipalsBeanList(principals);

    return medicaidApplicationSaveSI;
  }
  
  /**
   * This method will save the data in the confirmation section.
   *
   * @param context Contains the session, state, and request objects to get data from jsps
   */
  public void saveConfirmationInitialMedicaid_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveConfirmationInitialMedicaid_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();    
    BaseSessionStateManager state = getSessionStateManager(context);
    
    try {
      boolean saveConfirmationPressed = ContextHelper.getString(request, "btnSaveConfirmation.x") != null;
      state.setAttribute(SAVECONFIRMATIONBUTTONATTRB, saveConfirmationPressed, request);
      MedicaidApplicationSaveSI medicaidApplicationSaveSI = new MedicaidApplicationSaveSI();
      saveInitialMedicaid(context, medicaidApplicationSaveSI);
      String cdEventStatus = medicaidApplicationSaveSI.getCdEventStatus();
      String pageMode  = pageModeSet(context, cdEventStatus);
      PageMode.setPageMode(pageMode, request);
      
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();;
  }
  
  public void saveAndSubmitApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAndSubmitApplication_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    UserProfile user = UserProfileHelper.getUserProfile(request);
    
    try {
      boolean saveAndSubmitPressed = ContextHelper.getString(request, "btnSubmitApplicationFinal.x") != null;
      state.setAttribute(SSBUTTONATTRB, saveAndSubmitPressed, request);
      MedicaidApplicationSaveSI medicaidApplicationSaveSI = new MedicaidApplicationSaveSI();
      int idStage = GlobalData.getUlIdStage(request);
      int idPerson = fce.retrieveMesProgramAssistant(idStage, UserProfile.SEC_MES_PROGRAM_ASSIST);
      if(idPerson ==0){
        setErrorMessage(Messages.MSG_FCE_MES_PROG_ASST_NOT_FND, DISPLAY_URI, context.getRequest());
      }else{
        saveInitialMedicaid(context, medicaidApplicationSaveSI);
        fce.eligibilityRouting(idStage, user.getUserID(), idPerson, INITIAL_MEDICAID);
        String cdEventStatus = medicaidApplicationSaveSI.getCdEventStatus();
        String pageMode  = pageModeSet(context,cdEventStatus);         
        PageMode.setPageMode(pageMode, request);
      }
    } catch (ServiceException we) {
      switch (we.getErrorCode()) {
      case Messages.MSG_FCE_NO_MEDICNUM_INIT_MA:
        setErrorMessage(Messages.MSG_FCE_NO_MEDICNUM_INIT_MA, DISPLAY_URI, context.getRequest());
        break;
      case Messages.MSG_CMN_TMSTAMP_MISMATCH:
        setErrorMessage(Messages.MSG_CMN_TMSTAMP_MISMATCH, DISPLAY_URI, context.getRequest());
        break;
      case Messages.MSG_CRS_ID_NOT_FND:
        setErrorMessage(Messages.MSG_CRS_ID_NOT_FND, DISPLAY_URI, context.getRequest());
        break;
      case Messages.MSG_CRS_ID_NOT_A_NUMBER:
        setErrorMessage(Messages.MSG_CRS_ID_NOT_A_NUMBER, DISPLAY_URI, context.getRequest());
        break;
      }
    }catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    } 
    performanceTrace.exitScope();
  }


  /**
   * This method will set the page mode.
   *
   * @param request
   */
  public String pageModeSet(GrndsExchangeContext context,  String cdEventStatus) {
    HttpServletRequest request = context.getRequest();
    UserProfile user = UserProfileHelper.getUserProfile(request);
    String pageMode = GlobalData.getAppMode(request);
    if (CodesTables.CEVTSTAT_APRV.equals(cdEventStatus)) {
      pageMode = PageModeConstants.VIEW;
    } else if ((user.hasRight(UserProfile.SEC_ELIGIBILITY) == false) &&
                    (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))) {
      pageMode = PageModeConstants.VIEW;
    } else if ((user.hasRight(UserProfile.SEC_ELIGIBILITY) == true) &&
                    (CodesTables.CEVTSTAT_PEND.equals(cdEventStatus))) {
      pageMode = PageModeConstants.EDIT;
    } else if (user.hasRight(UserProfile.SEC_SAU_EXCHANGE) &&
                    (CodesTables.CEVTSTAT_PROC.equals(cdEventStatus) || 
                     CodesTables.CEVTSTAT_NEW.equals(cdEventStatus)) ) {
      pageMode = PageModeConstants.EDIT;
    }else{
      pageMode = PageModeConstants.EDIT;
    }
    if (!hasStageAccessRights(context)) {
      pageMode = PageModeConstants.VIEW;      
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

  public void signNowApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, ".signNow_xa()");
    performanceTrace.enterScope();
    
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    try {
      
      boolean signNowPressed = ContextHelper.getString(request, "btnSignNow.x") != null;
      state.setAttribute(BUTTONATTRB, signNowPressed, request);
      MedicaidApplicationSaveSI medicaidApplicationSaveSI = new MedicaidApplicationSaveSI();
      saveInitialMedicaid(context, medicaidApplicationSaveSI);
      
    } catch (Exception e) {
      GrndsTrace.msg(TRACE_TAG, 7, "Failure:" + e.getMessage());
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }
  
  private static String toCharIndicator(String value) {
    if (TRUE.equals(value)) {
      return "Y";
    }else if(FALSE.equals(value)){
      return "N";
    }else{
      return null;
    }
  }
 }
