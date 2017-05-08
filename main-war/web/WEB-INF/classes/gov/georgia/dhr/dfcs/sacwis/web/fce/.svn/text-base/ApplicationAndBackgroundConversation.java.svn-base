package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.ApplicationBackgroundDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.EventDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.ApplicationBackground;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.service.fce.FceInitialize;
import gov.georgia.dhr.dfcs.sacwis.structs.input.FceDataPrefillSI;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;

import java.rmi.RemoteException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/**
 * This is the Conversation class used to create or modify applications for Foster Care Eligibility.  Page auto-saves
 * when forwarding to Person Detail, Person Search, or Placement Log.
 * <pre>
 * Change History:
 * Date      User              Description
 * --------  ----------------  -------------------------------------------------
 * 01/31/05  Todd Reser        SIR 23307 - Set Person Detail Page mode to edit
 *                             or view depending on the current page's pageMode
 * </pre>
 *
 * @author Jonathan Hardy, March 10, 2003
 */
public class ApplicationAndBackgroundConversation extends FceConversation {
  public static final String TRACE_TAG = "ApplicationAndBackgroundConversation";
  public static final String APPLICATION_TYPE = "A";
  public static final String REAPPLICATION_TYPE = "R";
  public static final String DISPLAY_URI = "/fce/ApplicationAndBackground/displayAppAndBG";
  
  public static final String DISPLAY_ELIGIBLITY_DETERMINATION =
          "/fce/EligibilityDetermination/displayEligibilityDetermination";
  public static final String CD_EVENT_STATUS = "cdEventStatus";

  private ApplicationBackground applicationBackground;
  private Fce fce;
  private FceInitialize fceInitialize;
  

  public void setApplicationBackground(ApplicationBackground applicationBackground) {
    this.applicationBackground = applicationBackground;
  }

  public void setFce(Fce fce) {
    this.fce = fce;
  }
  
  public void setFceInitialize(FceInitialize fceInitialize) {
    this.fceInitialize = fceInitialize;
  }

  public ApplicationAndBackgroundConversation() {
    super(TRACE_TAG);
  }

  /**
   * Starting a new Fce Application always comes here from event list This forwards on to either
   * EligibilityDetermination or Application&Background
   */

  public void displayFceApplication_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayFceApplication_xa()");

    HttpServletRequest request = context.getRequest();
    clearState(context);
    FceUtility.setApplicationFceTabState(request);

    try {
      //This is to make the navigation (banner) happy
      GlobalData.setSzCdTask(null, request);

      int eventId = GlobalData.getUlIdEvent(request);
      if (eventId == 0) {
        return;
      }

      EventDB eventDB = fceInitialize.findEvent(eventId);
      if (eventDB.getCdEventStatus().equals(EventHelper.COMPLETE_EVENT)) {
        forward(DISPLAY_ELIGIBLITY_DETERMINATION, request, context.getResponse());
      }
    } catch (Exception e) {
      processSevereException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** Retrieves an ApplicationBackground bean and retrieves information based on the Event ID and/or Stage ID. */
  public void displayAppAndBG_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayAppAndBG_xa()");
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    clearState(context);
    try {
      //This is to make the navigation (banner) happy (!!! remove me when other one gets called)
      GlobalData.setSzCdTask(null, request);
      setInformationalMessage(Messages.MSG_FCE_APPBG_DATA_REQ, DISPLAY_URI, context.getRequest());
      FceUtility.setApplicationFceTabState(request);
      long idStage = GlobalData.getUlIdStage(request);
      long idCase = GlobalData.getUlIdCase(request);
      long idEvent = GlobalData.getUlIdEvent(request);
      
      // Do prefill action if flag is set to true
      String prefilled = (String)request.getAttribute("prefilled");
      if (ContextHelper.getStringSafe(request, "doPrefill").equals("true")){
        FceDataPrefillSI fceDataPrefillSI = new FceDataPrefillSI();
        fceDataPrefillSI.setUlIdEvent(idEvent);
        fceDataPrefillSI.setUlIdStage(idStage);
        fceDataPrefillSI.setSzCdApplication(ContextHelper.getStringSafe(request, "cdApplication"));
        fce.doFceDataPrefill(fceDataPrefillSI);
        prefilled = "true";
        request.setAttribute("prefilled", prefilled);
      }

      //Use saveBean to call EJB save method
      ApplicationBackgroundDB populateBean = applicationBackground.read(idStage,idEvent,
                                                               UserProfileHelper.getUserProfile(request).getUserID());

      // if event status is NEW then 
      if( EventHelper.NEW_EVENT.equals(populateBean.getCdEventStatus())
                      && !"true".equals(prefilled)){
        populateBean.setCdApplication(null);
      }
    
      context.getRequest().setAttribute("AppAndBGDB", populateBean);
      state.setAttribute(CD_EVENT_STATUS , populateBean.getCdEventStatus(), request);
      GlobalData.setUlIdEvent((int) populateBean.getIdEvent(), request);
      GlobalData.setUlIdPerson(0, request);
      FceUtility.setCdEventStatus(populateBean, request);

      String fcePageMode = FceUtility.getFceApplicationPageMode(request, populateBean);
      PageMode.setPageMode(fcePageMode, request);
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /** Called when the Save button is clicked on the page.  Saves the bean. */
  public void saveAppAndBG_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "saveAppAndBG_xa()");
    performanceTrace.enterScope();

    try {
      saveBean(context);
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * Called when user clicks the Detail button for the child is pressed or a Principal List hyperlink is clicked.
   * Auto-saves the page's information before navigating to the Person Detail page.
   */
  public void forwardPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "forwardPersonDetail_xa()");
    performanceTrace.enterScope();
    HttpServletRequest request = context.getRequest();

    // First save the bean info behind the scenes before navigating to person detail.
    try {
      // SIR 18177: only save if pageMode is EDIT.
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        saveBean(context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }

      //  Event List should have already provided stage code and program code.
      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(request, "hdnPersonDetailId"), request);

      // SIR 23307 - Set Person Detail Page mode to edit or view depending on
      // the current page's pageMode
      PersonHelper.setPersonDetailPageMode(request, pageMode);

    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * Called when user clicks the Add button for the Principal List.  Auto-saves the page's information before navigating
   * to the Person Search page. /person/PersonSearch/displayPersonSearch
   */
  public void forwardPersonSearch_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = new PerformanceTrace(TRACE_TAG, "forwardPersonSearch_xa()");
    performanceTrace.enterScope();

    HttpServletRequest request = context.getRequest();

    try {
      // SIR 18177: only save if pageMode is EDIT.
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        saveBean(context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }

      // Set any attributes that need to go into request for GlobalData (pullback?)
//      request.setAttribute("CALLING_PAGE", DISPLAY_URI);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /** Saves the ApplicationBackgroundDB through the ApplicationBackground EJB. */
  protected void saveBean(GrndsExchangeContext context) throws ParseException, EjbValidationException, RemoteException {
    HttpServletRequest request = context.getRequest();
    ApplicationBackgroundDB saveBean = readFromRequest(request);
    String remZip = ContextHelper.getStringSafe(context, "addrRemovalAddrZip");
    String remZipSuff = ContextHelper.getStringSafe(context, "addrRemovalAddrZipSuff");
    if (remZip.length() > 0 && !"".equals(remZipSuff)) {
      saveBean.setAddrRemovalAddrZip(remZip + "-" + remZipSuff);
    }
    String healthZip = ContextHelper.getStringSafe(context, "addrHealthAddrZip");
    String healthZipSuff = ContextHelper.getStringSafe(context, "addrHealthAddrZipSuff");
    if (healthZip.length() > 0 && !"".equals(healthZipSuff)) {
      saveBean.setAddrHealthAddrZip(healthZip + "-" + healthZipSuff);
    }

    saveBean = populateSaveBeanLists(saveBean, context);
    //Use saveBean to call EJB save method
    applicationBackground.save(saveBean);
  }

  /** @return Input parameter ApplicationBackgroundDB object, populated with principals rows from the page. */
  private ApplicationBackgroundDB populateSaveBeanLists(ApplicationBackgroundDB saveBean, GrndsExchangeContext context)
          throws ParseException {
    HttpServletRequest request = context.getRequest();
    BaseSessionStateManager state = getSessionStateManager(context);
    String cdEventStatus = (String)state.getAttribute(CD_EVENT_STATUS, request);
    List<FcePersonDB> principals = new ArrayList<FcePersonDB>();
    // Loop through principal list inputs.
    for (int i = 0; ; i++) {
      String livingInHomeString = "cbLivingInHome_" + i + "_changed";
      // Break when we can't find the next input.
      if (!request.getParameterMap().containsKey(livingInHomeString)) {
        break;
      }

      //MDM, 5/28/2003, This used to just send the changed ones;
      //unfortunately, that would complicate creating a count
      FcePersonDB principal = new FcePersonDB();
      principal.setIndPersonHmRemoval(CheckboxHelper.getCheckboxValue(request, "cbLivingInHome_" + i));
      if("A".equals(ContextHelper.getStringSafe(request, ApplicationBackgroundDB.CD_APPLICATION))){        
        principal.setIndCertifiedGroup(CheckboxHelper.getCheckboxValue(request, "cbMemCertGrp_" + i));
      }else if("R".equals(ContextHelper.getStringSafe(request, ApplicationBackgroundDB.CD_APPLICATION)) && (EventHelper.NEW_EVENT.equals(cdEventStatus) || EventHelper.PROCESS_EVENT.equals(cdEventStatus))){
        principal.setIndNoc("true");
      }else if("R".equals(ContextHelper.getStringSafe(request, ApplicationBackgroundDB.CD_APPLICATION)) && (EventHelper.PENDING_EVENT.equals(cdEventStatus) || EventHelper.COMPLETE_EVENT.equals(cdEventStatus))){
        principal.setIndCertifiedGroup(CheckboxHelper.getCheckboxValue(request, "cbMemCertGrp_" + i));
        principal.setIndNoc("true");
      }
      principal.setDtLastUpdateTime(ContextHelper.getLongSafe(request, "principalLastUpdate_" + i));
      principal.setIdFcePerson(ContextHelper.getLongSafe(request, "principalFcePersonId_" + i));
      principal.setIdFceEligibility(saveBean.getIdFceEligibility());
      principals.add(principal);
    }

    saveBean.setPrinciples(principals);
    return saveBean;
  }

  public static ApplicationBackgroundDB readFromRequest(HttpServletRequest request) {
    ApplicationBackgroundDB applicationBackgroundDB = new ApplicationBackgroundDB();
    populateWithRequest(applicationBackgroundDB, request);
    return applicationBackgroundDB;
  }

  public static void populateWithRequest(ApplicationBackgroundDB applicationBackgroundDB, HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(ApplicationBackgroundDB.ADDR_HEALTH_ADDR_CITY)) {
      applicationBackgroundDB.setAddrHealthAddrCity(ContextHelper.getStringSafe(request,
                                                                                ApplicationBackgroundDB.ADDR_HEALTH_ADDR_CITY));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_HEALTH_ADDR_ST_LN1)) {
      applicationBackgroundDB.setAddrHealthAddrStLn1(ContextHelper.getStringSafe(request,
                                                                                 ApplicationBackgroundDB.ADDR_HEALTH_ADDR_ST_LN1));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_HEALTH_ADDR_ST_LN2)) {
      applicationBackgroundDB.setAddrHealthAddrStLn2(ContextHelper.getStringSafe(request,
                                                                                 ApplicationBackgroundDB.ADDR_HEALTH_ADDR_ST_LN2));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_HEALTH_ADDR_ZIP)) {
      applicationBackgroundDB.setAddrHealthAddrZip(ContextHelper.getStringSafe(request,
                                                                               ApplicationBackgroundDB.ADDR_HEALTH_ADDR_ZIP));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_REMOVAL_ADDR_ZIP)) {
      applicationBackgroundDB.setAddrRemovalAddrZip(ContextHelper.getStringSafe(request,
                                                                                ApplicationBackgroundDB.ADDR_REMOVAL_ADDR_ZIP));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_REMOVAL_CITY)) {
      applicationBackgroundDB.setAddrRemovalCity(ContextHelper.getStringSafe(request,
                                                                             ApplicationBackgroundDB.ADDR_REMOVAL_CITY));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_REMOVAL_ST_LN1)) {
      applicationBackgroundDB.setAddrRemovalStLn1(ContextHelper.getStringSafe(request,
                                                                              ApplicationBackgroundDB.ADDR_REMOVAL_ST_LN1));
    }
    if (map.containsKey(ApplicationBackgroundDB.ADDR_REMOVAL_ST_LN2)) {
      applicationBackgroundDB.setAddrRemovalStLn2(ContextHelper.getStringSafe(request,
                                                                              ApplicationBackgroundDB.ADDR_REMOVAL_ST_LN2));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_APPLICATION)) {
      applicationBackgroundDB.setCdApplication(ContextHelper.getStringSafe(request,
                                                                           ApplicationBackgroundDB.CD_APPLICATION));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_COUNTY_HOSPITAL)) {
      applicationBackgroundDB.setCdCountyHospital(ContextHelper.getStringSafe(request,
                                                                              ApplicationBackgroundDB.CD_COUNTY_HOSPITAL));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_HEALTH_ADDR_STATE)) {
      applicationBackgroundDB.setCdHealthAddrState(ContextHelper.getStringSafe(request,
                                                                               ApplicationBackgroundDB.CD_HEALTH_ADDR_STATE));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_LIVING_MONTH_REMOVAL)) {
      applicationBackgroundDB.setCdLivingMonthRemoval(ContextHelper.getStringSafe(request,
                                                                                  ApplicationBackgroundDB.CD_LIVING_MONTH_REMOVAL));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_NOTA_MOST_RECENT)) {
      applicationBackgroundDB.setCdNotaMostRecent(ContextHelper.getStringSafe(request,
                                                                              ApplicationBackgroundDB.CD_NOTA_MOST_RECENT));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_REMOVAL_ADDR_COUNTY)) {
      applicationBackgroundDB.setCdRemovalAddrCounty(ContextHelper.getStringSafe(request,
                                                                                 ApplicationBackgroundDB.CD_REMOVAL_ADDR_COUNTY));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_REMOVAL_ADDR_STATE)) {
      applicationBackgroundDB.setCdRemovalAddrState(ContextHelper.getStringSafe(request,
                                                                                ApplicationBackgroundDB.CD_REMOVAL_ADDR_STATE));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_STATE)) {
      applicationBackgroundDB.setCdState(ContextHelper.getStringSafe(request, ApplicationBackgroundDB.CD_STATE));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_APPLICATION_COMPLETE_STRING)) {
      applicationBackgroundDB.setDtApplicationCompleteString(ContextHelper.getStringSafe(request,
                                                                                         ApplicationBackgroundDB.DT_APPLICATION_COMPLETE_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_APPLICATION_COMPLETE_TIME)) {
      applicationBackgroundDB.setDtApplicationCompleteTime(ContextHelper.getLongSafe(request,
                                                                                     ApplicationBackgroundDB.DT_APPLICATION_COMPLETE_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HEALTH_BEGIN_DATE_STRING)) {
      applicationBackgroundDB.setDtHealthBeginDateString(ContextHelper.getStringSafe(request,
                                                                                     ApplicationBackgroundDB.DT_HEALTH_BEGIN_DATE_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HEALTH_BEGIN_DATE_TIME)) {
      applicationBackgroundDB.setDtHealthBeginDateTime(ContextHelper.getLongSafe(request,
                                                                                 ApplicationBackgroundDB.DT_HEALTH_BEGIN_DATE_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HEALTH_END_DATE_STRING)) {
      applicationBackgroundDB.setDtHealthEndDateString(ContextHelper.getStringSafe(request,
                                                                                   ApplicationBackgroundDB.DT_HEALTH_END_DATE_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HEALTH_END_DATE_TIME)) {
      applicationBackgroundDB.setDtHealthEndDateTime(ContextHelper.getLongSafe(request,
                                                                               ApplicationBackgroundDB.DT_HEALTH_END_DATE_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HOSPITAL_ADMISSION_STRING)) {
      applicationBackgroundDB.setDtHospitalAdmissionString(ContextHelper.getStringSafe(request,
                                                                                       ApplicationBackgroundDB.DT_HOSPITAL_ADMISSION_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HOSPITAL_ADMISSION_TIME)) {
      applicationBackgroundDB.setDtHospitalAdmissionTime(ContextHelper.getLongSafe(request,
                                                                                   ApplicationBackgroundDB.DT_HOSPITAL_ADMISSION_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HOSPITAL_DISCHARGE_STRING)) {
      applicationBackgroundDB.setDtHospitalDischargeString(ContextHelper.getStringSafe(request,
                                                                                       ApplicationBackgroundDB.DT_HOSPITAL_DISCHARGE_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_HOSPITAL_DISCHARGE_TIME)) {
      applicationBackgroundDB.setDtHospitalDischargeTime(ContextHelper.getLongSafe(request,
                                                                                   ApplicationBackgroundDB.DT_HOSPITAL_DISCHARGE_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING)) {
      applicationBackgroundDB.setFceApplicationDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                              ApplicationBackgroundDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME)) {
      applicationBackgroundDB.setFceApplicationDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                          ApplicationBackgroundDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_NOTIFIED_WORKER_STRING)) {
      applicationBackgroundDB.setDtNotifiedWorkerString(ContextHelper.getStringSafe(request,
                                                                                    ApplicationBackgroundDB.DT_NOTIFIED_WORKER_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_NOTIFIED_WORKER_TIME)) {
      applicationBackgroundDB.setDtNotifiedWorkerTime(ContextHelper.getLongSafe(request,
                                                                                ApplicationBackgroundDB.DT_NOTIFIED_WORKER_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_PROOF_AGE_SENT_ES_STRING)) {
      applicationBackgroundDB.setDtProofAgeSentEsString(ContextHelper.getStringSafe(request,
                                                                                    ApplicationBackgroundDB.DT_PROOF_AGE_SENT_ES_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_PROOF_AGE_SENT_ES_TIME)) {
      applicationBackgroundDB.setDtProofAgeSentEsTime(ContextHelper.getLongSafe(request,
                                                                                ApplicationBackgroundDB.DT_PROOF_AGE_SENT_ES_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING)) {
      applicationBackgroundDB.setDtProofCitizenshipSentEsString(ContextHelper.getStringSafe(request,
                                                                                            ApplicationBackgroundDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME)) {
      applicationBackgroundDB.setDtProofCitizenshipSentEsTime(ContextHelper.getLongSafe(request,
                                                                                        ApplicationBackgroundDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_CASE)) {
      applicationBackgroundDB.setIdCase(ContextHelper.getLongSafe(request, ApplicationBackgroundDB.ID_CASE));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_EVENT)) {
      applicationBackgroundDB.setIdEvent(ContextHelper.getLongSafe(request, ApplicationBackgroundDB.ID_EVENT));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_FCE_APPLICATION)) {
      applicationBackgroundDB.setIdFceApplication(ContextHelper.getLongSafe(request,
                                                                            ApplicationBackgroundDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_FCE_ELIGIBILITY)) {
      applicationBackgroundDB.setIdFceEligibility(ContextHelper.getLongSafe(request,
                                                                            ApplicationBackgroundDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_LAST_UPDATE_PERSON)) {
      applicationBackgroundDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                              ApplicationBackgroundDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_MNGNG_CVS_PERSON)) {
      applicationBackgroundDB.setIdMngngCvsPerson(ContextHelper.getLongSafe(request,
                                                                            ApplicationBackgroundDB.ID_MNGNG_CVS_PERSON));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_OTHER_RELATIVE_PERSON)) {
      applicationBackgroundDB.setIdOtherRelativePerson(ContextHelper.getLongSafe(request,
                                                                                 ApplicationBackgroundDB.ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_PERSON)) {
      applicationBackgroundDB.setIdPerson(ContextHelper.getLongSafe(request, ApplicationBackgroundDB.ID_PERSON));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_STAGE)) {
      applicationBackgroundDB.setIdStage(GlobalData.getUlIdStage(
              request));//ContextHelper.getLongSafe(request, ApplicationBackgroundDB.ID_STAGE)
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_JUSTIFIED_EVAL)) {
      applicationBackgroundDB.setIndAgeJustifiedEval(ContextHelper.getBooleanSafe(request,
                                                                                  ApplicationBackgroundDB.IND_AGE_JUSTIFIED_EVAL));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_BAPTISM_CERT)) {
      applicationBackgroundDB.setIndAgeVrfdBaptismCert(ContextHelper.getBooleanSafe(request,
                                                                                    ApplicationBackgroundDB.IND_AGE_VRFD_BAPTISM_CERT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_FOREIGN_CERT)) {
      applicationBackgroundDB.setIndAgeVrfdForeignCert(ContextHelper.getBooleanSafe(request,
                                                                                    ApplicationBackgroundDB.IND_AGE_VRFD_FOREIGN_CERT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_HOSPITAL_CERT)) {
      applicationBackgroundDB.setIndAgeVrfdHospitalCert(ContextHelper.getBooleanSafe(request,
                                                                                     ApplicationBackgroundDB.IND_AGE_VRFD_HOSPITAL_CERT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_NTRLZTN_CERT)) {
      applicationBackgroundDB.setIndAgeVrfdNtrlztnCert(ContextHelper.getBooleanSafe(request,
                                                                                    ApplicationBackgroundDB.IND_AGE_VRFD_NTRLZTN_CERT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_PASSPORT)) {
      applicationBackgroundDB.setIndAgeVrfdPassport(ContextHelper.getBooleanSafe(request,
                                                                                 ApplicationBackgroundDB.IND_AGE_VRFD_PASSPORT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_RESIDENT_CARD)) {
      applicationBackgroundDB.setIndAgeVrfdResidentCard(ContextHelper.getBooleanSafe(request,
                                                                                     ApplicationBackgroundDB.IND_AGE_VRFD_RESIDENT_CARD));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_AGE_VRFD_US_BIRTH_CERT)) {
      applicationBackgroundDB.setIndAgeVrfdUsBirthCert(ContextHelper.getBooleanSafe(request,
                                                                                    ApplicationBackgroundDB.IND_AGE_VRFD_US_BIRTH_CERT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_CHILD_SUPPORT_ORDER)) {
      applicationBackgroundDB.setIndChildSupportOrder(ContextHelper.getBooleanSafe(request,
                                                                                   ApplicationBackgroundDB.IND_CHILD_SUPPORT_ORDER));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_EVALUATION_CONCLUSION)) {
      applicationBackgroundDB.setIndEvaluationConclusion(ContextHelper.getBooleanSafe(request,
                                                                                      ApplicationBackgroundDB.IND_EVALUATION_CONCLUSION));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_HOSPITAL)) {
      applicationBackgroundDB.setIndHospital(ContextHelper.getBooleanSafe(request,
                                                                          ApplicationBackgroundDB.IND_HOSPITAL));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_INCOME_ASSISTANCE)) {
      applicationBackgroundDB.setIndIncomeAssistance(ContextHelper.getBooleanSafe(request,
                                                                                  ApplicationBackgroundDB.IND_INCOME_ASSISTANCE));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_LEGAL_DOCS_SENT_ES)) {
      applicationBackgroundDB.setIndLegalDocsSentEs(ContextHelper.getBooleanSafe(request,
                                                                                 ApplicationBackgroundDB.IND_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_LIVING_RELATIVE_SIX_MONTH)) {
      applicationBackgroundDB.setIndLivingRelativeSixMonth(ContextHelper.getBooleanSafe(request,
                                                                                        ApplicationBackgroundDB.IND_LIVING_RELATIVE_SIX_MONTH));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_MANAGING_CVS)) {
      applicationBackgroundDB.setIndManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                             ApplicationBackgroundDB.IND_MANAGING_CVS));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_MINOR_PARENT)) {
      applicationBackgroundDB.setIndMinorParent(ContextHelper.getBooleanSafe(request,
                                                                             ApplicationBackgroundDB.IND_MINOR_PARENT));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_NOTIFIED_DHS_WORKER)) {
      applicationBackgroundDB.setIndNotifiedDhsWorker(ContextHelper.getBooleanSafe(request,
                                                                                   ApplicationBackgroundDB.IND_NOTIFIED_DHS_WORKER));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_OTHER_HEALTH_INSURANCE)) {
      applicationBackgroundDB.setIndOtherHealthInsurance(ContextHelper.getBooleanSafe(request,
                                                                                      ApplicationBackgroundDB.IND_OTHER_HEALTH_INSURANCE));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_PROOF_AGE_SENT_ES)) {
      applicationBackgroundDB.setIndProofAgeSentEs(ContextHelper.getBooleanSafe(request,
                                                                                ApplicationBackgroundDB.IND_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_PROOF_CITIZENSHIP_SENT_ES)) {
      applicationBackgroundDB.setIndProofCitizenshipSentEs(ContextHelper.getBooleanSafe(request,
                                                                                        ApplicationBackgroundDB.IND_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_COURT_MONTH)) {
      applicationBackgroundDB.setNbrCourtMonth(ContextHelper.getLongSafe(request,
                                                                         ApplicationBackgroundDB.NBR_COURT_MONTH));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_COURT_YEAR)) {
      applicationBackgroundDB.setNbrCourtYear(ContextHelper.getLongSafe(request,
                                                                        ApplicationBackgroundDB.NBR_COURT_YEAR));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_HEALTH_GROUP)) {
      applicationBackgroundDB.setNbrHealthGroup(ContextHelper.getStringSafe(request,
                                                                            ApplicationBackgroundDB.NBR_HEALTH_GROUP));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_HEALTH_POLICY)) {
      applicationBackgroundDB.setNbrHealthPolicy(ContextHelper.getStringSafe(request,
                                                                             ApplicationBackgroundDB.NBR_HEALTH_POLICY));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_LIVING_AT_HOME)) {
      applicationBackgroundDB.setNbrLivingAtHome(ContextHelper.getLongSafe(request,
                                                                           ApplicationBackgroundDB.NBR_LIVING_AT_HOME));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_NOTIFIED_DHS_WRKR_PHN)) {
      applicationBackgroundDB.setNbrNotifiedDhsWrkrPhn(ContextHelper.getStringSafe(request,
                                                                                   ApplicationBackgroundDB.NBR_NOTIFIED_DHS_WRKR_PHN));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_HEALTH_COMPANY)) {
      applicationBackgroundDB.setNmHealthCompany(ContextHelper.getStringSafe(request,
                                                                             ApplicationBackgroundDB.NM_HEALTH_COMPANY));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_HEALTH_EMPLOYEE_NM)) {
      applicationBackgroundDB.setNmHealthEmployeeNm(ContextHelper.getStringSafe(request,
                                                                                ApplicationBackgroundDB.NM_HEALTH_EMPLOYEE_NM));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_HEALTH_EMPLOYER_NM)) {
      applicationBackgroundDB.setNmHealthEmployerNm(ContextHelper.getStringSafe(request,
                                                                                ApplicationBackgroundDB.NM_HEALTH_EMPLOYER_NM));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_HEALTH_POLICY_HLDR_NM)) {
      applicationBackgroundDB.setNmHealthPolicyHldrNm(ContextHelper.getStringSafe(request,
                                                                                  ApplicationBackgroundDB.NM_HEALTH_POLICY_HLDR_NM));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_HOSPITAL)) {
      applicationBackgroundDB.setNmHospital(ContextHelper.getStringSafe(request, ApplicationBackgroundDB.NM_HOSPITAL));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_HOSPITAL_CITY)) {
      applicationBackgroundDB.setNmHospitalCity(ContextHelper.getStringSafe(request,
                                                                            ApplicationBackgroundDB.NM_HOSPITAL_CITY));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_MOTHER_MAIDEN)) {
      applicationBackgroundDB.setNmMotherMaiden(ContextHelper.getStringSafe(request,
                                                                            ApplicationBackgroundDB.NM_MOTHER_MAIDEN));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_NOTIFIED_DHS_WRKR_FIRST)) {
      applicationBackgroundDB.setNmNotifiedDhsWrkrFirst(ContextHelper.getStringSafe(request,
                                                                                    ApplicationBackgroundDB.NM_NOTIFIED_DHS_WRKR_FIRST));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_NOTIFIED_DHS_WRKR_LAST)) {
      applicationBackgroundDB.setNmNotifiedDhsWrkrLast(ContextHelper.getStringSafe(request,
                                                                                   ApplicationBackgroundDB.NM_NOTIFIED_DHS_WRKR_LAST));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_NOTIFIED_DHS_WRKR_MIDDLE)) {
      applicationBackgroundDB.setNmNotifiedDhsWrkrMiddle(ContextHelper.getStringSafe(request,
                                                                                     ApplicationBackgroundDB.NM_NOTIFIED_DHS_WRKR_MIDDLE));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_EMPLOYEE_COMMENTS)) {
      applicationBackgroundDB.setTxtEmployeeComments(ContextHelper.getStringSafe(request,
                                                                              ApplicationBackgroundDB.TXT_EMPLOYEE_COMMENTS));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_INCOME_DTRMNTN_COMMENTS)) {
      applicationBackgroundDB.setTxtIncomeDtrmntnComments(ContextHelper.getStringSafe(request,
                                                                                      ApplicationBackgroundDB.TXT_INCOME_DTRMNTN_COMMENTS));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_LEGAL_DOCS_SENT_ES)) {
      applicationBackgroundDB.setTxtLegalDocsSentEs(ContextHelper.getStringSafe(request,
                                                                                ApplicationBackgroundDB.TXT_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_MEETS_DD_OR_NOT_COMMENTS)) {
      applicationBackgroundDB.setTxtMeetsDdOrNotComments(ContextHelper.getStringSafe(request,
                                                                                     ApplicationBackgroundDB.TXT_MEETS_DD_OR_NOT_COMMENTS));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_NO_INCOME_EXPLANATION)) {
      applicationBackgroundDB.setTxtNoIncomeExplanation(ContextHelper.getStringSafe(request,
                                                                                    ApplicationBackgroundDB.TXT_NO_INCOME_EXPLANATION));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_PROOF_AGE_SENT_ES)) {
      applicationBackgroundDB.setTxtProofAgeSentEs(ContextHelper.getStringSafe(request,
                                                                               ApplicationBackgroundDB.TXT_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_PRIOR_REMOVAL_MONTHS)) {
      applicationBackgroundDB.setTxtPriorRemovalMonths(ContextHelper.getStringSafe(request,
                                                                                   ApplicationBackgroundDB.TXT_PRIOR_REMOVAL_MONTHS));
    }
    if (map.containsKey(ApplicationBackgroundDB.TXT_PROOF_CITIZENSHIP_SENT_ES)) {
      applicationBackgroundDB.setTxtProofCitizenshipSentEs(ContextHelper.getStringSafe(request,
                                                                                       ApplicationBackgroundDB.TXT_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_REL_INT)) {
      applicationBackgroundDB.setCdRelInt(ContextHelper.getStringSafe(request, ApplicationBackgroundDB.CD_REL_INT));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_BIRTH_STRING)) {
      applicationBackgroundDB.setDtBirthString(ContextHelper.getStringSafe(request,
                                                                           ApplicationBackgroundDB.DT_BIRTH_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.DT_BIRTH_TIME)) {
      applicationBackgroundDB.setDtBirthTime(ContextHelper.getLongSafe(request, ApplicationBackgroundDB.DT_BIRTH_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.FCE_PERSON_DT_LAST_UPDATE_STRING)) {
      applicationBackgroundDB.setFcePersonDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                         ApplicationBackgroundDB.FCE_PERSON_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(ApplicationBackgroundDB.FCE_PERSON_DT_LAST_UPDATE_TIME)) {
      applicationBackgroundDB.setFcePersonDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                     ApplicationBackgroundDB.FCE_PERSON_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(ApplicationBackgroundDB.ID_FCE_PERSON)) {
      applicationBackgroundDB.setIdFcePerson(ContextHelper.getLongSafe(request, ApplicationBackgroundDB.ID_FCE_PERSON));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_CERTIFIED_GROUP)) {
      applicationBackgroundDB.setIndCertifiedGroup(ContextHelper.getBooleanSafe(request,
                                                                                ApplicationBackgroundDB.IND_CERTIFIED_GROUP));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_DOB_APPROX)) {
      applicationBackgroundDB.setIndDobApprox(ContextHelper.getBooleanSafe(request,
                                                                           ApplicationBackgroundDB.IND_DOB_APPROX));
    }
    if (map.containsKey(ApplicationBackgroundDB.IND_PERSON_HM_REMOVAL)) {
      applicationBackgroundDB.setIndPersonHmRemoval(ContextHelper.getBooleanSafe(request,
                                                                                 ApplicationBackgroundDB.IND_PERSON_HM_REMOVAL));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_AGE)) {
      applicationBackgroundDB.setNbrAge(ContextHelper.getLongSafe(request, ApplicationBackgroundDB.NBR_AGE));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_EMPLOYEE_PERSON_FULL)) {
      applicationBackgroundDB.setNmEmployeePersonFull(ContextHelper.getStringSafe(request,
                                                                                  ApplicationBackgroundDB.NM_EMPLOYEE_PERSON_FULL));
    }
    if (map.containsKey(ApplicationBackgroundDB.NM_PERSON_FULL)) {
      applicationBackgroundDB.setNmPersonFull(ContextHelper.getStringSafe(request,
                                                                          ApplicationBackgroundDB.NM_PERSON_FULL));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_EMPLOYEE_PERSON_PHONE)) {
      applicationBackgroundDB.setNbrEmployeePersonPhone(ContextHelper.getStringSafe(request,
                                                                                    ApplicationBackgroundDB.NBR_EMPLOYEE_PERSON_PHONE));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_SOCIAL_SECURITY)) {
      applicationBackgroundDB.setNbrSocialSecurity(ContextHelper.getStringSafe(request,
                                                                               ApplicationBackgroundDB.NBR_SOCIAL_SECURITY));
    }
    if (map.containsKey(ApplicationBackgroundDB.NBR_MEDICAID)) {
      applicationBackgroundDB.setNbrMedicaid(ContextHelper.getStringSafe(request,
                                                                         ApplicationBackgroundDB.NBR_MEDICAID));
    }
    if (map.containsKey(ApplicationBackgroundDB.CD_EVENT_STATUS)) {
      applicationBackgroundDB.setCdEventStatus(ContextHelper.getStringSafe(request,
                                                                           ApplicationBackgroundDB.CD_EVENT_STATUS));
    }
  }
}
