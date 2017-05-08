//*  JSP Name:     Age and Citizenship Conversation
//*  Created by:   Michael Ochu
//*  Date Created: 02/25/2003
//*
//*  Description:
//*
//*
//** Change History:
//**  Date      User              Description
//**  --------  ----------------  --------------------------------------------------
package gov.georgia.dhr.dfcs.sacwis.web.fce;

import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.EjbValidationException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.CaseUtility;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.AgeCitizenshipDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.AgeCitizenship;
import gov.georgia.dhr.dfcs.sacwis.service.fce.Fce;
import gov.georgia.dhr.dfcs.sacwis.service.person.Person;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AgeCitizenshipSaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AgeCitizenshipSaveSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;
import gov.georgia.dhr.dfcs.sacwis.web.core.modes.PageMode;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;
import gov.georgia.dhr.dfcs.sacwis.web.person.PersonHelper;

import java.rmi.RemoteException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.grnds.structural.web.GrndsExchangeContext;

/** Handles page flow and calls necessary logic for AgeCitizenship.jsp */
public class AgeCitizenshipConversation extends FceConversation {
  public static final String TRACE_TAG = "AgeCitizenshipConversation";

  //conversation URLS
  public static final String FCE_AGECITIZEN_DISPLAY = getUrl("displayAgeCitizenship");
  public static final String FCE_AGECITIZEN_SAVE = getUrl("saveAgeCitizenship");
  public static final String FCE_DEPRIVATION_DISPLAY = "/fce/DomicileDeprivation/displayDomicile";
  
  protected static final String CONVERSATION_URL = "/fce/AgeCitizenship/";

  private AgeCitizenship ageCitizenship;
  private Person person;
  private Fce fce;

  public void setAgeCitizenship(AgeCitizenship ageCitizenship) {
    this.ageCitizenship = ageCitizenship;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public void setFce(Fce fce) {
    this.fce = fce;
  }

  public AgeCitizenshipConversation() {
    super(TRACE_TAG);
  }

  /**
   * <p>This method displays the Age and Citizenship page.</p> *  <blockquote><ul> </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void displayAgeCitizenship_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "displayAgeCitizenship_xa");
    HttpServletRequest request = context.getRequest();
    try {
      long idStage = GlobalData.getUlIdStage(request);
      long idEvent = GlobalData.getUlIdEvent(request);
      // Retrieve Person Citizenship and Identity data and set it into state to be displayed in JSP
      long idPrimaryChild = fce.findPrimaryChildForStage(idStage, "PC");
      PersonCitizenshipIdentityRetrieveSI personCitizenshipIdentityRetrieveSI = new PersonCitizenshipIdentityRetrieveSI();
      personCitizenshipIdentityRetrieveSI.setUlIdPerson((int) idPrimaryChild);
      PersonCitizenshipIdentitylRetrieveSO personCitizenshipIdentitylRetrieveSO = person.retrieveCitizenshipIdentity(personCitizenshipIdentityRetrieveSI);
      request.setAttribute("personCitizenshipIdentitylRetrieveSO", personCitizenshipIdentitylRetrieveSO);
      AgeCitizenshipSaveSI ageCitizenshipSaveSI = new AgeCitizenshipSaveSI();
      ageCitizenshipSaveSI.setUlIdStage(idStage);
      ageCitizenshipSaveSI.setUlIdEvent(idEvent);
      ageCitizenshipSaveSI.setPersonCitizenshipIdentityBean(personCitizenshipIdentitylRetrieveSO.getPersonCitizenshipIdentityBean());
      AgeCitizenshipSaveSO ageCitizenshipSaveSO = fce.saveCheckedAgeCitizenshipVerification(ageCitizenshipSaveSI);
      AgeCitizenshipDB ageCitizenshipDB = ageCitizenship.read(idStage, idEvent, getUserID(request));

      GlobalData.setUlIdEvent((int) ageCitizenshipDB.getIdEvent(), request);
      GlobalData.setSzNmPersonFull(GlobalData.getSzNmStage(request), request);

      request.setAttribute("AgeCitizenship", ageCitizenshipDB);
      clearState(context);
      FceUtility.setApplicationFceTabState(request);

      FceUtility.setCdEventStatus(ageCitizenshipDB, request);

      String fcePageMode = FceUtility.getFceApplicationPageMode(request, ageCitizenshipDB);
      PageMode.setPageMode(fcePageMode, request);
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * <p>This method is called when the user clicks on the Save Button.  It Calls the saveAgeCitizenship method and
   * passes the information it needs to save. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void saveAgeCitizenship_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "saveAgeCitizenship_xa");
    try {
      clearState(context);
      saveAgeCitizenship(context);
    } catch (Exception e) {
      handleException(context, e);
    }
    performanceTrace.exitScope();
  }

  /**
   * <p>This method is called when the user clicks on the Deatil Button.  It calls Person Detail page and passes it the
   * information it needs to populate. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callPersonDetail_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "callPersonDetail_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        saveAgeCitizenship(context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }

      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(context, "idPerson"), request);

      PersonHelper.setPersonDetailPageMode(request, PageModeConstants.EDIT);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p>This method is called when the user clicks on the Deatil Button.  It calls Person Citizenship Identity page
   *  and passes it the information it needs to populate. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callPersonCitizenshipIdentity_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "callPersonCitizenshipIdentity_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        saveAgeCitizenship(context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }

      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(context, "idPerson"), request);

      PersonHelper.setPersonCitizenshipIdentityPageMode(request, PageModeConstants.EDIT);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }
  /**
   * <p>This method is called when the user clicks on the Detail Button.  It calls CvsFaHome page and passes it the
   * information it needs to populate. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void callCvsFaHome_xa(GrndsExchangeContext context) {
    PerformanceTrace performanceTrace = PerformanceTrace.enterScope(TRACE_TAG, "callCvsFaHome_xa()");

    HttpServletRequest request = context.getRequest();

    try {
      String pageMode = PageMode.getPageMode(request);
      if (PageModeConstants.EDIT.equals(pageMode)) {
        saveAgeCitizenship(context);
        int eventId = GlobalData.getUlIdEvent(request);
        String cdEventStatus = CaseUtility.getSzCdEventStatus(eventId);
        FceUtility.setCdEventStatus(cdEventStatus, request);
      }

      GlobalData.setUlIdPerson(ContextHelper.getIntSafe(context, "idPerson"), request);

      PageMode.setPageMode(PageModeConstants.EDIT, request);
      // SIR 19441 - Override AppMode here
      request.setAttribute(PersonHelper.PERSON_DETAIL_PAGE_MODE, PageModeConstants.EDIT);
    } catch (Exception e) {
      handleException(context, e);
    }

    performanceTrace.exitScope();
  }

  /**
   * <p>This method is called when the user clicks on the Narrative button.  It sets ApproverMode for the request passed
   * to the document architecture, in an attempt to bypass the "demotion" from PEND to COMP inside PostEvent. </p>
   *
   * @param context The <code>GrndeExchangeContext<code> object.
   */
  public void launchEvaluativeConclusionNarrative_xa(GrndsExchangeContext context) {
    try {
      HttpServletRequest request = context.getRequest();
      GlobalData.setApprovalMode(0, 0, new int[] {GlobalData.getUlIdEvent(request)}, 0, request);
    } catch (Exception e) {
      handleException(context, e);
    }
  }

  /** Helper method which saves AgeCitizenship regardless of outgoing call */
  protected void saveAgeCitizenship(GrndsExchangeContext context) throws RemoteException, EjbValidationException {
    HttpServletRequest request = context.getRequest();
    AgeCitizenshipDB ageCitizenshipDB = readAgeCitizenship(request);
    ageCitizenship.save(ageCitizenshipDB);
    
    // Determine wether to display informational message
    if ((CodesTables.CIMGSTS_NAT.equals(ageCitizenshipDB.getFceEligibilityCdPersonCitizenship())) &&
                    (!ageCitizenshipDB.hasIndCtznshpPassport() && 
                     !ageCitizenshipDB.hasIndCtznshpNtrlztnCrtfct() &&
                     !ageCitizenshipDB.hasIndCtznshpCitizenCrtfct())){
      setInformationalMessage(Messages.MSG_VERIF_REQ_IDENT_VERIF, FCE_DEPRIVATION_DISPLAY, request);
    }
  }

  /**
   * <p>This method clears the check boxes in the Age and Citizenship page.</p> *  <blockquote><ul> /p>
   *
   * @param request
   */
  protected static AgeCitizenshipDB readAgeCitizenship(HttpServletRequest request) {
    AgeCitizenshipDB ageCitizenshipDB = new AgeCitizenshipDB();
    ageCitizenshipDB.setIndCtznshpAmerIndianCrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpAttorneyReview((Boolean) null);
    ageCitizenshipDB.setIndCtznshpBirthCrtfctFor((Boolean) null);
    ageCitizenshipDB.setIndCtznshpBirthCrtfctUs((Boolean) null);
    ageCitizenshipDB.setIndCtznshpChldFound((Boolean) null);
    ageCitizenshipDB.setIndCtznshpCitizenCrtfct((Boolean) null);
    ageCitizenshipDB.setIndCtznshpEvaluation((Boolean) null);
    ageCitizenshipDB.setIndCtznshpForDocumentation((Boolean) null);
    ageCitizenshipDB.setIndCtznshpHospitalCrtfct((Boolean) null);
    ageCitizenshipDB.setIndCtznshpNoDocumentation((Boolean) null);
    ageCitizenshipDB.setIndCtznshpNtrlztnCrtfct((Boolean) null);
    ageCitizenshipDB.setIndCtznshpPassport((Boolean) null);
    ageCitizenshipDB.setIndCtznshpResidentCard((Boolean) null);
    ageCitizenshipDB.setIndCtznshpUnaccMinorChild((Boolean) null);
    ageCitizenshipDB.setIndCtznshpUndocImmigrant((Boolean) null);
    ageCitizenshipDB.setIndCtznshpUsHsptlBrthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpUsIdCard((Boolean) null);
    ageCitizenshipDB.setIndCtznshpVitalBirthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpSaveSystem((Boolean) null);
    ageCitizenshipDB.setIndCtznshpStudentVisa((Boolean) null);
    ageCitizenshipDB.setIndCtznshpSuccessSystem((Boolean) null);
    ageCitizenshipDB.setIndCtznshpBirthAbroad((Boolean) null);
    ageCitizenshipDB.setIndCtznshpCensusBirthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpCivilServiceEmp((Boolean) null);
    ageCitizenshipDB.setIndCtznshpConfrmBirth((Boolean) null);
    ageCitizenshipDB.setIndCtznshpFinalAdoptDecree((Boolean) null);
    ageCitizenshipDB.setIndCtznshpNorthMarianaId((Boolean) null);
    ageCitizenshipDB.setIndCtznshpLeglImmiStatExp((Boolean) null);
    ageCitizenshipDB.setIndCtznshpLifeInsBrthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpLoclGovtBrthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpMedBirthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpMiltryBirthRcrd((Boolean) null);
    ageCitizenshipDB.setIndCtznshpRefugee((Boolean) null);
    ageCitizenshipDB.setIndCtznshpReligBirthRcrd((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdUsBirthCert((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdForeignCert((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdHospitalCert((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdPassport((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdBaptismCert((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdResidentCard((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdNtrlztnCert((Boolean) null);
    ageCitizenshipDB.setIndAgeJustifiedEval((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdSaveSystem((Boolean) null);
    ageCitizenshipDB.setIndAgeVrfdSuccessSystem((Boolean) null);
    ageCitizenshipDB.setIndNarrativeApproved((Boolean) null);

    populateWithRequest(ageCitizenshipDB, request);
    return ageCitizenshipDB;
  }

  /** Appends pageName to CONVERSATION_URL */
  protected static String getUrl(String pageName) {
    return CONVERSATION_URL + pageName;
  }

  public static AgeCitizenshipDB readFromRequest(HttpServletRequest request) {
    AgeCitizenshipDB ageCitizenshipDB = new AgeCitizenshipDB();
    populateWithRequest(ageCitizenshipDB, request);
    return ageCitizenshipDB;
  }

  public static void populateWithRequest(AgeCitizenshipDB ageCitizenshipDB, HttpServletRequest request) {

    Map map = request.getParameterMap();
    if (map.containsKey(AgeCitizenshipDB.ADDR_HEALTH_ADDR_CITY)) {
      ageCitizenshipDB.setAddrHealthAddrCity(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.ADDR_HEALTH_ADDR_CITY));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_HEALTH_ADDR_ST_LN1)) {
      ageCitizenshipDB.setAddrHealthAddrStLn1(ContextHelper.getStringSafe(request,
                                                                          AgeCitizenshipDB.ADDR_HEALTH_ADDR_ST_LN1));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_HEALTH_ADDR_ST_LN2)) {
      ageCitizenshipDB.setAddrHealthAddrStLn2(ContextHelper.getStringSafe(request,
                                                                          AgeCitizenshipDB.ADDR_HEALTH_ADDR_ST_LN2));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_HEALTH_ADDR_ZIP)) {
      ageCitizenshipDB.setAddrHealthAddrZip(ContextHelper.getStringSafe(request,
                                                                        AgeCitizenshipDB.ADDR_HEALTH_ADDR_ZIP));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_REMOVAL_ADDR_ZIP)) {
      ageCitizenshipDB.setAddrRemovalAddrZip(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.ADDR_REMOVAL_ADDR_ZIP));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_REMOVAL_CITY)) {
      ageCitizenshipDB.setAddrRemovalCity(ContextHelper.getStringSafe(request, AgeCitizenshipDB.ADDR_REMOVAL_CITY));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_REMOVAL_ST_LN1)) {
      ageCitizenshipDB.setAddrRemovalStLn1(ContextHelper.getStringSafe(request, AgeCitizenshipDB.ADDR_REMOVAL_ST_LN1));
    }
    if (map.containsKey(AgeCitizenshipDB.ADDR_REMOVAL_ST_LN2)) {
      ageCitizenshipDB.setAddrRemovalStLn2(ContextHelper.getStringSafe(request, AgeCitizenshipDB.ADDR_REMOVAL_ST_LN2));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_APPLICATION)) {
      ageCitizenshipDB.setCdApplication(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_APPLICATION));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_COUNTY_HOSPITAL)) {
      ageCitizenshipDB.setCdCountyHospital(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_COUNTY_HOSPITAL));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_HEALTH_ADDR_STATE)) {
      ageCitizenshipDB.setCdHealthAddrState(ContextHelper.getStringSafe(request,
                                                                        AgeCitizenshipDB.CD_HEALTH_ADDR_STATE));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_LIVING_MONTH_REMOVAL)) {
      ageCitizenshipDB.setCdLivingMonthRemoval(ContextHelper.getStringSafe(request,
                                                                           AgeCitizenshipDB.CD_LIVING_MONTH_REMOVAL));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_NOTA_MOST_RECENT)) {
      ageCitizenshipDB.setCdNotaMostRecent(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_NOTA_MOST_RECENT));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_REMOVAL_ADDR_COUNTY)) {
      ageCitizenshipDB.setCdRemovalAddrCounty(ContextHelper.getStringSafe(request,
                                                                          AgeCitizenshipDB.CD_REMOVAL_ADDR_COUNTY));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_REMOVAL_ADDR_STATE)) {
      ageCitizenshipDB.setCdRemovalAddrState(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.CD_REMOVAL_ADDR_STATE));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_STATE)) {
      ageCitizenshipDB.setCdState(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_STATE));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_APPLICATION_COMPLETE_STRING)) {
      ageCitizenshipDB.setDtApplicationCompleteString(ContextHelper.getStringSafe(request,
                                                                                  AgeCitizenshipDB.DT_APPLICATION_COMPLETE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_APPLICATION_COMPLETE_TIME)) {
      ageCitizenshipDB.setDtApplicationCompleteTime(ContextHelper.getLongSafe(request,
                                                                              AgeCitizenshipDB.DT_APPLICATION_COMPLETE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HEALTH_BEGIN_DATE_STRING)) {
      ageCitizenshipDB.setDtHealthBeginDateString(ContextHelper.getStringSafe(request,
                                                                              AgeCitizenshipDB.DT_HEALTH_BEGIN_DATE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HEALTH_BEGIN_DATE_TIME)) {
      ageCitizenshipDB.setDtHealthBeginDateTime(ContextHelper.getLongSafe(request,
                                                                          AgeCitizenshipDB.DT_HEALTH_BEGIN_DATE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HEALTH_END_DATE_STRING)) {
      ageCitizenshipDB.setDtHealthEndDateString(ContextHelper.getStringSafe(request,
                                                                            AgeCitizenshipDB.DT_HEALTH_END_DATE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HEALTH_END_DATE_TIME)) {
      ageCitizenshipDB.setDtHealthEndDateTime(ContextHelper.getLongSafe(request,
                                                                        AgeCitizenshipDB.DT_HEALTH_END_DATE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HOSPITAL_ADMISSION_STRING)) {
      ageCitizenshipDB.setDtHospitalAdmissionString(ContextHelper.getStringSafe(request,
                                                                                AgeCitizenshipDB.DT_HOSPITAL_ADMISSION_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HOSPITAL_ADMISSION_TIME)) {
      ageCitizenshipDB.setDtHospitalAdmissionTime(ContextHelper.getLongSafe(request,
                                                                            AgeCitizenshipDB.DT_HOSPITAL_ADMISSION_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HOSPITAL_DISCHARGE_STRING)) {
      ageCitizenshipDB.setDtHospitalDischargeString(ContextHelper.getStringSafe(request,
                                                                                AgeCitizenshipDB.DT_HOSPITAL_DISCHARGE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_HOSPITAL_DISCHARGE_TIME)) {
      ageCitizenshipDB.setDtHospitalDischargeTime(ContextHelper.getLongSafe(request,
                                                                            AgeCitizenshipDB.DT_HOSPITAL_DISCHARGE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING)) {
      ageCitizenshipDB.setFceApplicationDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                       AgeCitizenshipDB.FCE_APPLICATION_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME)) {
      ageCitizenshipDB.setFceApplicationDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                   AgeCitizenshipDB.FCE_APPLICATION_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_NOTIFIED_WORKER_STRING)) {
      ageCitizenshipDB.setDtNotifiedWorkerString(ContextHelper.getStringSafe(request,
                                                                             AgeCitizenshipDB.DT_NOTIFIED_WORKER_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_NOTIFIED_WORKER_TIME)) {
      ageCitizenshipDB.setDtNotifiedWorkerTime(ContextHelper.getLongSafe(request,
                                                                         AgeCitizenshipDB.DT_NOTIFIED_WORKER_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_PROOF_AGE_SENT_ES_STRING)) {
      ageCitizenshipDB.setDtProofAgeSentEsString(ContextHelper.getStringSafe(request,
                                                                             AgeCitizenshipDB.DT_PROOF_AGE_SENT_ES_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_PROOF_AGE_SENT_ES_TIME)) {
      ageCitizenshipDB.setDtProofAgeSentEsTime(ContextHelper.getLongSafe(request,
                                                                         AgeCitizenshipDB.DT_PROOF_AGE_SENT_ES_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING)) {
      ageCitizenshipDB.setDtProofCitizenshipSentEsString(ContextHelper.getStringSafe(request,
                                                                                     AgeCitizenshipDB.DT_PROOF_CITIZENSHIP_SENT_ES_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME)) {
      ageCitizenshipDB.setDtProofCitizenshipSentEsTime(ContextHelper.getLongSafe(request,
                                                                                 AgeCitizenshipDB.DT_PROOF_CITIZENSHIP_SENT_ES_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_CASE)) {
      ageCitizenshipDB.setIdCase(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_CASE));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_EVENT)) {
      ageCitizenshipDB.setIdEvent(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_EVENT));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_FCE_APPLICATION)) {
      ageCitizenshipDB.setIdFceApplication(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_FCE_APPLICATION));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_FCE_ELIGIBILITY)) {
      ageCitizenshipDB.setIdFceEligibility(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_FCE_ELIGIBILITY));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_LAST_UPDATE_PERSON)) {
      ageCitizenshipDB.setIdLastUpdatePerson(ContextHelper.getLongSafe(request,
                                                                       AgeCitizenshipDB.ID_LAST_UPDATE_PERSON));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_MNGNG_CVS_PERSON)) {
      ageCitizenshipDB.setIdMngngCvsPerson(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_MNGNG_CVS_PERSON));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_OTHER_RELATIVE_PERSON)) {
      ageCitizenshipDB.setIdOtherRelativePerson(ContextHelper.getLongSafe(request,
                                                                          AgeCitizenshipDB.ID_OTHER_RELATIVE_PERSON));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_PERSON)) {
      ageCitizenshipDB.setIdPerson(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_PERSON));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_STAGE)) {
      ageCitizenshipDB.setIdStage(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_STAGE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_JUSTIFIED_EVAL)) {
      ageCitizenshipDB.setIndAgeJustifiedEval(ContextHelper.getBooleanSafe(request,
                                                                           AgeCitizenshipDB.IND_AGE_JUSTIFIED_EVAL));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_BAPTISM_CERT)) {
      ageCitizenshipDB.setIndAgeVrfdBaptismCert(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_AGE_VRFD_BAPTISM_CERT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_FOREIGN_CERT)) {
      ageCitizenshipDB.setIndAgeVrfdForeignCert(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_AGE_VRFD_FOREIGN_CERT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_HOSPITAL_CERT)) {
      ageCitizenshipDB.setIndAgeVrfdHospitalCert(ContextHelper.getBooleanSafe(request,
                                                                              AgeCitizenshipDB.IND_AGE_VRFD_HOSPITAL_CERT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_NTRLZTN_CERT)) {
      ageCitizenshipDB.setIndAgeVrfdNtrlztnCert(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_AGE_VRFD_NTRLZTN_CERT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_PASSPORT)) {
      ageCitizenshipDB.setIndAgeVrfdPassport(ContextHelper.getBooleanSafe(request,
                                                                          AgeCitizenshipDB.IND_AGE_VRFD_PASSPORT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_RESIDENT_CARD)) {
      ageCitizenshipDB.setIndAgeVrfdResidentCard(ContextHelper.getBooleanSafe(request,
                                                                              AgeCitizenshipDB.IND_AGE_VRFD_RESIDENT_CARD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_US_BIRTH_CERT)) {
      ageCitizenshipDB.setIndAgeVrfdUsBirthCert(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_AGE_VRFD_US_BIRTH_CERT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_SUCCESS_SYSTEM)) {
      ageCitizenshipDB.setIndAgeVrfdSuccessSystem(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_AGE_VRFD_SUCCESS_SYSTEM));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_AGE_VRFD_SAVE_SYSTEM)) {
      ageCitizenshipDB.setIndAgeVrfdSaveSystem(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_AGE_VRFD_SAVE_SYSTEM));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CHILD_SUPPORT_ORDER)) {
      ageCitizenshipDB.setIndChildSupportOrder(ContextHelper.getBooleanSafe(request,
                                                                            AgeCitizenshipDB.IND_CHILD_SUPPORT_ORDER));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_EVALUATION_CONCLUSION)) {
      ageCitizenshipDB.setIndEvaluationConclusion(ContextHelper.getBooleanSafe(request,
                                                                               AgeCitizenshipDB.IND_EVALUATION_CONCLUSION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_HOSPITAL)) {
      ageCitizenshipDB.setIndHospital(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_HOSPITAL));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_INCOME_ASSISTANCE)) {
      ageCitizenshipDB.setIndIncomeAssistance(ContextHelper.getBooleanSafe(request,
                                                                           AgeCitizenshipDB.IND_INCOME_ASSISTANCE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_LEGAL_DOCS_SENT_ES)) {
      ageCitizenshipDB.setIndLegalDocsSentEs(ContextHelper.getBooleanSafe(request,
                                                                          AgeCitizenshipDB.IND_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_LIVING_RELATIVE_SIX_MONTH)) {
      ageCitizenshipDB.setIndLivingRelativeSixMonth(ContextHelper.getBooleanSafe(request,
                                                                                 AgeCitizenshipDB.IND_LIVING_RELATIVE_SIX_MONTH));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_MANAGING_CVS)) {
      ageCitizenshipDB.setIndManagingCvs(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_MANAGING_CVS));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_MINOR_PARENT)) {
      ageCitizenshipDB.setIndMinorParent(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_MINOR_PARENT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_NOTIFIED_DHS_WORKER)) {
      ageCitizenshipDB.setIndNotifiedDhsWorker(ContextHelper.getBooleanSafe(request,
                                                                            AgeCitizenshipDB.IND_NOTIFIED_DHS_WORKER));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_OTHER_HEALTH_INSURANCE)) {
      ageCitizenshipDB.setIndOtherHealthInsurance(ContextHelper.getBooleanSafe(request,
                                                                               AgeCitizenshipDB.IND_OTHER_HEALTH_INSURANCE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_PROOF_AGE_SENT_ES)) {
      ageCitizenshipDB.setIndProofAgeSentEs(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_PROOF_CITIZENSHIP_SENT_ES)) {
      ageCitizenshipDB.setIndProofCitizenshipSentEs(ContextHelper.getBooleanSafe(request,
                                                                                 AgeCitizenshipDB.IND_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_COURT_MONTH)) {
      ageCitizenshipDB.setNbrCourtMonth(ContextHelper.getLongSafe(request, AgeCitizenshipDB.NBR_COURT_MONTH));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_COURT_YEAR)) {
      ageCitizenshipDB.setNbrCourtYear(ContextHelper.getLongSafe(request, AgeCitizenshipDB.NBR_COURT_YEAR));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_HEALTH_GROUP)) {
      ageCitizenshipDB.setNbrHealthGroup(ContextHelper.getStringSafe(request, AgeCitizenshipDB.NBR_HEALTH_GROUP));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_HEALTH_POLICY)) {
      ageCitizenshipDB.setNbrHealthPolicy(ContextHelper.getStringSafe(request, AgeCitizenshipDB.NBR_HEALTH_POLICY));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_LIVING_AT_HOME)) {
      ageCitizenshipDB.setNbrLivingAtHome(ContextHelper.getLongSafe(request, AgeCitizenshipDB.NBR_LIVING_AT_HOME));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_NOTIFIED_DHS_WRKR_PHN)) {
      ageCitizenshipDB.setNbrNotifiedDhsWrkrPhn(ContextHelper.getStringSafe(request,
                                                                            AgeCitizenshipDB.NBR_NOTIFIED_DHS_WRKR_PHN));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_HEALTH_COMPANY)) {
      ageCitizenshipDB.setNmHealthCompany(ContextHelper.getStringSafe(request, AgeCitizenshipDB.NM_HEALTH_COMPANY));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_HEALTH_EMPLOYEE_NM)) {
      ageCitizenshipDB.setNmHealthEmployeeNm(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.NM_HEALTH_EMPLOYEE_NM));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_HEALTH_EMPLOYER_NM)) {
      ageCitizenshipDB.setNmHealthEmployerNm(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.NM_HEALTH_EMPLOYER_NM));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_HEALTH_POLICY_HLDR_NM)) {
      ageCitizenshipDB.setNmHealthPolicyHldrNm(ContextHelper.getStringSafe(request,
                                                                           AgeCitizenshipDB.NM_HEALTH_POLICY_HLDR_NM));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_HOSPITAL)) {
      ageCitizenshipDB.setNmHospital(ContextHelper.getStringSafe(request, AgeCitizenshipDB.NM_HOSPITAL));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_HOSPITAL_CITY)) {
      ageCitizenshipDB.setNmHospitalCity(ContextHelper.getStringSafe(request, AgeCitizenshipDB.NM_HOSPITAL_CITY));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_MOTHER_MAIDEN)) {
      ageCitizenshipDB.setNmMotherMaiden(ContextHelper.getStringSafe(request, AgeCitizenshipDB.NM_MOTHER_MAIDEN));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_NOTIFIED_DHS_WRKR_FIRST)) {
      ageCitizenshipDB.setNmNotifiedDhsWrkrFirst(ContextHelper.getStringSafe(request,
                                                                             AgeCitizenshipDB.NM_NOTIFIED_DHS_WRKR_FIRST));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_NOTIFIED_DHS_WRKR_LAST)) {
      ageCitizenshipDB.setNmNotifiedDhsWrkrLast(ContextHelper.getStringSafe(request,
                                                                            AgeCitizenshipDB.NM_NOTIFIED_DHS_WRKR_LAST));
    }
    if (map.containsKey(AgeCitizenshipDB.NM_NOTIFIED_DHS_WRKR_MIDDLE)) {
      ageCitizenshipDB.setNmNotifiedDhsWrkrMiddle(ContextHelper.getStringSafe(request,
                                                                              AgeCitizenshipDB.NM_NOTIFIED_DHS_WRKR_MIDDLE));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_INCOME_DTRMNTN_COMMENTS)) {
      ageCitizenshipDB.setTxtIncomeDtrmntnComments(ContextHelper.getStringSafe(request,
                                                                               AgeCitizenshipDB.TXT_INCOME_DTRMNTN_COMMENTS));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_LEGAL_DOCS_SENT_ES)) {
      ageCitizenshipDB.setTxtLegalDocsSentEs(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.TXT_LEGAL_DOCS_SENT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_MEETS_DD_OR_NOT_COMMENTS)) {
      ageCitizenshipDB.setTxtMeetsDdOrNotComments(ContextHelper.getStringSafe(request,
                                                                              AgeCitizenshipDB.TXT_MEETS_DD_OR_NOT_COMMENTS));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_NO_INCOME_EXPLANATION)) {
      ageCitizenshipDB.setTxtNoIncomeExplanation(ContextHelper.getStringSafe(request,
                                                                             AgeCitizenshipDB.TXT_NO_INCOME_EXPLANATION));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_PROOF_AGE_SENT_ES)) {
      ageCitizenshipDB.setTxtProofAgeSentEs(ContextHelper.getStringSafe(request,
                                                                        AgeCitizenshipDB.TXT_PROOF_AGE_SENT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_PROOF_CITIZENSHIP_SENT_ES)) {
      ageCitizenshipDB.setTxtProofCitizenshipSentEs(ContextHelper.getStringSafe(request,
                                                                                AgeCitizenshipDB.TXT_PROOF_CITIZENSHIP_SENT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_COUNTABLE_INCOME)) {
      ageCitizenshipDB.setAmtCountableIncome(ContextHelper.getDoubleSafe(request,
                                                                         AgeCitizenshipDB.AMT_COUNTABLE_INCOME));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_COUNTABLE_INCOME_MONEY)) {
      ageCitizenshipDB.setAmtCountableIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                AgeCitizenshipDB.AMT_COUNTABLE_INCOME_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_GROSS_EARNED_CRTFD_GRP)) {
      ageCitizenshipDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                             AgeCitizenshipDB.AMT_GROSS_EARNED_CRTFD_GRP));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY)) {
      ageCitizenshipDB.setAmtGrossEarnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    AgeCitizenshipDB.AMT_GROSS_EARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_GROSS_UNEARNED_CRTFD_GRP)) {
      ageCitizenshipDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getDoubleSafe(request,
                                                                               AgeCitizenshipDB.AMT_GROSS_UNEARNED_CRTFD_GRP));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY)) {
      ageCitizenshipDB.setAmtGrossUnearnedCrtfdGrp(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      AgeCitizenshipDB.AMT_GROSS_UNEARNED_CRTFD_GRP_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_INCOME_LIMIT)) {
      ageCitizenshipDB.setAmtIncomeLimit(ContextHelper.getDoubleSafe(request, AgeCitizenshipDB.AMT_INCOME_LIMIT));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_INCOME_LIMIT_MONEY)) {
      ageCitizenshipDB.setAmtIncomeLimit(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                            AgeCitizenshipDB.AMT_INCOME_LIMIT_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_PWE_INCOME)) {
      ageCitizenshipDB.setAmtPweIncome(ContextHelper.getDoubleSafe(request, AgeCitizenshipDB.AMT_PWE_INCOME));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_PWE_INCOME_MONEY)) {
      ageCitizenshipDB.setAmtPweIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                          AgeCitizenshipDB.AMT_PWE_INCOME_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_SSI)) {
      ageCitizenshipDB.setAmtSsi(ContextHelper.getDoubleSafe(request, AgeCitizenshipDB.AMT_SSI));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_SSI_MONEY)) {
      ageCitizenshipDB.setAmtSsi(ContextHelper.getMoneyAsDoubleSafe(request, AgeCitizenshipDB.AMT_SSI_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_ALIMONY)) {
      ageCitizenshipDB.setAmtStepparentAlimony(ContextHelper.getDoubleSafe(request,
                                                                           AgeCitizenshipDB.AMT_STEPPARENT_ALIMONY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_ALIMONY_MONEY)) {
      ageCitizenshipDB.setAmtStepparentAlimony(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                  AgeCitizenshipDB.AMT_STEPPARENT_ALIMONY_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_ALLOWANCE)) {
      ageCitizenshipDB.setAmtStepparentAllowance(ContextHelper.getDoubleSafe(request,
                                                                             AgeCitizenshipDB.AMT_STEPPARENT_ALLOWANCE));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_ALLOWANCE_MONEY)) {
      ageCitizenshipDB.setAmtStepparentAllowance(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                    AgeCitizenshipDB.AMT_STEPPARENT_ALLOWANCE_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_APPLIED_INCOME)) {
      ageCitizenshipDB.setAmtStepparentAppliedIncome(ContextHelper.getDoubleSafe(request,
                                                                                 AgeCitizenshipDB.AMT_STEPPARENT_APPLIED_INCOME));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY)) {
      ageCitizenshipDB.setAmtStepparentAppliedIncome(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        AgeCitizenshipDB.AMT_STEPPARENT_APPLIED_INCOME_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_CNTBL_UNEARNED)) {
      ageCitizenshipDB.setAmtStepparentCntblUnearned(ContextHelper.getDoubleSafe(request,
                                                                                 AgeCitizenshipDB.AMT_STEPPARENT_CNTBL_UNEARNED));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY)) {
      ageCitizenshipDB.setAmtStepparentCntblUnearned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                        AgeCitizenshipDB.AMT_STEPPARENT_CNTBL_UNEARNED_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_GROSS_EARNED)) {
      ageCitizenshipDB.setAmtStepparentGrossEarned(ContextHelper.getDoubleSafe(request,
                                                                               AgeCitizenshipDB.AMT_STEPPARENT_GROSS_EARNED));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_GROSS_EARNED_MONEY)) {
      ageCitizenshipDB.setAmtStepparentGrossEarned(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      AgeCitizenshipDB.AMT_STEPPARENT_GROSS_EARNED_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_OUTSIDE_PMNT)) {
      ageCitizenshipDB.setAmtStepparentOutsidePmnt(ContextHelper.getDoubleSafe(request,
                                                                               AgeCitizenshipDB.AMT_STEPPARENT_OUTSIDE_PMNT));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY)) {
      ageCitizenshipDB.setAmtStepparentOutsidePmnt(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                      AgeCitizenshipDB.AMT_STEPPARENT_OUTSIDE_PMNT_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_TOTAL_CNTBL)) {
      ageCitizenshipDB.setAmtStepparentTotalCntbl(ContextHelper.getDoubleSafe(request,
                                                                              AgeCitizenshipDB.AMT_STEPPARENT_TOTAL_CNTBL));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY)) {
      ageCitizenshipDB.setAmtStepparentTotalCntbl(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                     AgeCitizenshipDB.AMT_STEPPARENT_TOTAL_CNTBL_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_WORK_DEDUCT)) {
      ageCitizenshipDB.setAmtStepparentWorkDeduct(ContextHelper.getDoubleSafe(request,
                                                                              AgeCitizenshipDB.AMT_STEPPARENT_WORK_DEDUCT));
    }
    if (map.containsKey(AgeCitizenshipDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY)) {
      ageCitizenshipDB.setAmtStepparentWorkDeduct(ContextHelper.getMoneyAsDoubleSafe(request,
                                                                                     AgeCitizenshipDB.AMT_STEPPARENT_WORK_DEDUCT_MONEY));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_BLOC_CHILD)) {
      ageCitizenshipDB.setCdBlocChild(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_BLOC_CHILD));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_ELIGIBILITY_ACTUAL)) {
      ageCitizenshipDB.setCdEligibilityActual(ContextHelper.getStringSafe(request,
                                                                          AgeCitizenshipDB.CD_ELIGIBILITY_ACTUAL));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_ELIGIBILITY_SELECTED)) {
      ageCitizenshipDB.setCdEligibilitySelected(ContextHelper.getStringSafe(request,
                                                                            AgeCitizenshipDB.CD_ELIGIBILITY_SELECTED));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_MEDICAID_ELIGIBILITY_TYPE)) {
      ageCitizenshipDB.setCdMedicaidEligibilityType(ContextHelper.getStringSafe(request,
                                                                                AgeCitizenshipDB.CD_MEDICAID_ELIGIBILITY_TYPE));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP)) {
      ageCitizenshipDB.setFceEligibilityCdPersonCitizenship(ContextHelper.getStringSafe(request,
                                                                                        AgeCitizenshipDB.FCE_ELIGIBILITY_CD_PERSON_CITIZENSHIP));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_PWE_IRREGULAR_UNDER100)) {
      ageCitizenshipDB.setCdPweIrregularUnder100(ContextHelper.getStringSafe(request,
                                                                             AgeCitizenshipDB.CD_PWE_IRREGULAR_UNDER100));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_PWE_STEADY_UNDER100)) {
      ageCitizenshipDB.setCdPweSteadyUnder100(ContextHelper.getStringSafe(request,
                                                                          AgeCitizenshipDB.CD_PWE_STEADY_UNDER100));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_ELIGIBILITY_END_STRING)) {
      ageCitizenshipDB.setDtEligibilityEndString(ContextHelper.getStringSafe(request,
                                                                             AgeCitizenshipDB.DT_ELIGIBILITY_END_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_ELIGIBILITY_END_TIME)) {
      ageCitizenshipDB.setDtEligibilityEndTime(ContextHelper.getLongSafe(request,
                                                                         AgeCitizenshipDB.DT_ELIGIBILITY_END_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_ELIG_DTRMNTN_START_STRING)) {
      ageCitizenshipDB.setDtEligDtrmntnStartString(ContextHelper.getStringSafe(request,
                                                                               AgeCitizenshipDB.DT_ELIG_DTRMNTN_START_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_ELIG_DTRMNTN_START_TIME)) {
      ageCitizenshipDB.setDtEligDtrmntnStartTime(ContextHelper.getLongSafe(request,
                                                                           AgeCitizenshipDB.DT_ELIG_DTRMNTN_START_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING)) {
      ageCitizenshipDB.setFceEligibilityDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                       AgeCitizenshipDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME)) {
      ageCitizenshipDB.setFceEligibilityDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                                   AgeCitizenshipDB.FCE_ELIGIBILITY_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_REMOVAL_CHILD_ORDERED_STRING)) {
      ageCitizenshipDB.setDtRemovalChildOrderedString(ContextHelper.getStringSafe(request,
                                                                                  AgeCitizenshipDB.DT_REMOVAL_CHILD_ORDERED_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_REMOVAL_CHILD_ORDERED_TIME)) {
      ageCitizenshipDB.setDtRemovalChildOrderedTime(ContextHelper.getLongSafe(request,
                                                                              AgeCitizenshipDB.DT_REMOVAL_CHILD_ORDERED_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_REVIEW_DATE_STRING)) {
      ageCitizenshipDB.setDtReviewDateString(ContextHelper.getStringSafe(request,
                                                                         AgeCitizenshipDB.DT_REVIEW_DATE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_REVIEW_DATE_TIME)) {
      ageCitizenshipDB.setDtReviewDateTime(ContextHelper.getLongSafe(request, AgeCitizenshipDB.DT_REVIEW_DATE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING)) {
      ageCitizenshipDB.setDtRsnblEffortPreventRemString(ContextHelper.getStringSafe(request,
                                                                                    AgeCitizenshipDB.DT_RSNBL_EFFORT_PREVENT_REM_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME)) {
      ageCitizenshipDB.setDtRsnblEffortPreventRemTime(ContextHelper.getLongSafe(request,
                                                                                AgeCitizenshipDB.DT_RSNBL_EFFORT_PREVENT_REM_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_ELIGIBILITY_EVENT)) {
      ageCitizenshipDB.setIdEligibilityEvent(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_ELIGIBILITY_EVENT));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_FCE_PERSON)) {
      ageCitizenshipDB.setIdFcePerson(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_FCE_PERSON));
    }
    if (map.containsKey(AgeCitizenshipDB.ID_FCE_REVIEW)) {
      ageCitizenshipDB.setIdFceReview(ContextHelper.getLongSafe(request, AgeCitizenshipDB.ID_FCE_REVIEW));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_ALTRNT_CUSTODY)) {
      ageCitizenshipDB.setIndAbsentAltrntCustody(ContextHelper.getBooleanSafe(request,
                                                                              AgeCitizenshipDB.IND_ABSENT_ALTRNT_CUSTODY));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_DEPORTED)) {
      ageCitizenshipDB.setIndAbsentDeported(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_ABSENT_DEPORTED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_DESERTED)) {
      ageCitizenshipDB.setIndAbsentDeserted(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_ABSENT_DESERTED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_DIED)) {
      ageCitizenshipDB.setIndAbsentDied(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_ABSENT_DIED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_DIVORCED)) {
      ageCitizenshipDB.setIndAbsentDivorced(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_ABSENT_DIVORCED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_FATHER)) {
      ageCitizenshipDB.setIndAbsentFather(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_ABSENT_FATHER));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_HOSPITALIZED)) {
      ageCitizenshipDB.setIndAbsentHospitalized(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_ABSENT_HOSPITALIZED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_INCARCERATED)) {
      ageCitizenshipDB.setIndAbsentIncarcerated(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_ABSENT_INCARCERATED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_MILITARY_WORK)) {
      ageCitizenshipDB.setIndAbsentMilitaryWork(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_ABSENT_MILITARY_WORK));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_MOTHER)) {
      ageCitizenshipDB.setIndAbsentMother(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_ABSENT_MOTHER));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_SEPARATED)) {
      ageCitizenshipDB.setIndAbsentSeparated(ContextHelper.getBooleanSafe(request,
                                                                          AgeCitizenshipDB.IND_ABSENT_SEPARATED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ABSENT_WORK_RELATED)) {
      ageCitizenshipDB.setIndAbsentWorkRelated(ContextHelper.getBooleanSafe(request,
                                                                            AgeCitizenshipDB.IND_ABSENT_WORK_RELATED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CHILD_LIVING_PRNT6_MNTHS)) {
      ageCitizenshipDB.setIndChildLivingPrnt6Mnths(ContextHelper.getBooleanSafe(request,
                                                                                AgeCitizenshipDB.IND_CHILD_LIVING_PRNT6_MNTHS));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CHILD_QUALIFIED_CITIZEN)) {
      ageCitizenshipDB.setIndChildQualifiedCitizen(ContextHelper.getBooleanSafe(request,
                                                                                AgeCitizenshipDB.IND_CHILD_QUALIFIED_CITIZEN));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CHILD_SUPPORT_ORDERED)) {
      ageCitizenshipDB.setIndChildSupportOrdered(ContextHelper.getBooleanSafe(request,
                                                                              AgeCitizenshipDB.IND_CHILD_SUPPORT_ORDERED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CHILD_UNDER18)) {
      ageCitizenshipDB.setIndChildUnder18(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_CHILD_UNDER18));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_AMER_INDIAN_CRD)) {
      ageCitizenshipDB.setIndCtznshpAmerIndianCrd(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_CTZNSHP_AMER_INDIAN_CRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_ATTORNEY_REVIEW)) {
      ageCitizenshipDB.setIndCtznshpAttorneyReview(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_CTZNSHP_ATTORNEY_REVIEW));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_BIRTH_ABROAD)) {
      ageCitizenshipDB.setIndCtznshpBirthAbroad(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_CTZNSHP_BIRTH_ABROAD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR)) {
      ageCitizenshipDB.setIndCtznshpBirthCrtfctFor(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_CTZNSHP_BIRTH_CRTFCT_FOR));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_BIRTH_CRTFCT_US)) {
      ageCitizenshipDB.setIndCtznshpBirthCrtfctUs(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_BIRTH_CRTFCT_US));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpCensusBirthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CENSUS_BIRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CHLD_FOUND)) {
      ageCitizenshipDB.setIndCtznshpChldFound(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CHLD_FOUND));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CITIZEN_CRTFCT)) {
      ageCitizenshipDB.setIndCtznshpCitizenCrtfct(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CITIZEN_CRTFCT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CIVIL_SERVICE_EMP)) {
      ageCitizenshipDB.setIndCtznshpCivilServiceEmp(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CIVIL_SERVICE_EMP));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CONFRM_BIRTH)) {
      ageCitizenshipDB.setIndCtznshpConfrmBirth(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CONFRM_BIRTH));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_EVALUATION)) {
      ageCitizenshipDB.setIndCtznshpEvaluation(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_EVALUATION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_FINAL_ADOPT_DECREE)) {
      ageCitizenshipDB.setIndCtznshpFinalAdoptDecree(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_FINAL_ADOPT_DECREE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_FOR_DOCUMENTATION)) {
      ageCitizenshipDB.setIndCtznshpForDocumentation(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_FOR_DOCUMENTATION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_HOSPITAL_CRTFCT)) {
      ageCitizenshipDB.setIndCtznshpHospitalCrtfct(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_HOSPITAL_CRTFCT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP)) {
      ageCitizenshipDB.setIndCtznshpLeglImmiStatExp(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_LEGL_IMMI_STAT_EXP));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpLifeInsBrthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_LIFE_INS_BRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpLoclGovtBrthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_LOCL_GOV_BRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_MED_BIRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpMedBirthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_MED_BIRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpMiltryBirthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_MILTRY_BIRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_NO_DOCUMENTATION)) {
      ageCitizenshipDB.setIndCtznshpNoDocumentation(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_NO_DOCUMENTATION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_NORTH_MARIANA_ID)) {
      ageCitizenshipDB.setIndCtznshpNorthMarianaId(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_NORTH_MARIANA_ID));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_NTRLZTN_CRTFCT)) {
      ageCitizenshipDB.setIndCtznshpNtrlztnCrtfct(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_NTRLZTN_CRTFCT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_PASSPORT)) {
      ageCitizenshipDB.setIndCtznshpPassport(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_PASSPORT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_REFUGEE)) {
      ageCitizenshipDB.setIndCtznshpRefugee(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_REFUGEE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_RELIG_BIRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpReligBirthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_RELIG_BIRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_RESIDENT_CARD)) {
      ageCitizenshipDB.setIndCtznshpResidentCard(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_RESIDENT_CARD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_UNACC_MINOR_CHILD)) {
      ageCitizenshipDB.setIndCtznshpUnaccMinorChild(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_UNACC_MINOR_CHILD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_UNDOC_IMMIGRANT)) {
      ageCitizenshipDB.setIndCtznshpUndocImmigrant(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_UNDOC_IMMIGRANT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpUsHsptlBrthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_US_HSPTL_BRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_US_ID_CARD)) {
      ageCitizenshipDB.setIndCtznshpUsIdCard(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_US_ID_CARD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_VITAL_BIRTH_RCRD)) {
      ageCitizenshipDB.setIndCtznshpVitalBirthRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_VITAL_BIRTH_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_DRIVER_LIC_OR_ID)) {
      ageCitizenshipDB.setIndCtznshpDriverLicOrId(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_DRIVER_LIC_OR_ID));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CERT_IND_BLOOD)) {
      ageCitizenshipDB.setIndCtznshpCertIndBlood(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CERT_IND_BLOOD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_DOC_IMMIG_NAT_ACT)) {
      ageCitizenshipDB.setIndCtznshpDocImmigNatAct(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_DOC_IMMIG_NAT_ACT));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_ID_PHOTO)) {
      ageCitizenshipDB.setIndCtznshpSchoolIdPhoto(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_ID_PHOTO));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_MILITARY_DEPDNT_ID)) {
      ageCitizenshipDB.setIndCtznshpMilitaryDepdntId(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_MILITARY_DEPDNT_ID));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_REC)) {
      ageCitizenshipDB.setIndCtznshpSchoolRec(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_SCHOOL_REC));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CLINIC_DOC_HOS_DOC)) {
      ageCitizenshipDB.setIndCtznshpClinicDocHosDoc(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CLINIC_DOC_HOS_DOC));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_DAYCARE_NURSE_RCRD)) {
      ageCitizenshipDB.setIndCtznshpDaycareNurseRcrd(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_DAYCARE_NURSE_RCRD));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_AFFIDAVIT_SIGNED)) {
      ageCitizenshipDB.setIndCtznshpAffidavitSigned(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_AFFIDAVIT_SIGNED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_CERT_REPORT_BIRTH)) {
      ageCitizenshipDB.setIndCtznshpCertReportBirth(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_CERT_REPORT_BIRTH));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_SAVE_SYSTEM)) {
      ageCitizenshipDB.setIndCtznshpSaveSystem(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_SAVE_SYSTEM));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_STUDENT_VISA)) {
      ageCitizenshipDB.setIndCtznshpStudentVisa(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_STUDENT_VISA));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CTZNSHP_SUCCESS_SYSTEM)) {
      ageCitizenshipDB.setIndCtznshpSuccessSystem(ContextHelper.getBooleanSafe(request,AgeCitizenshipDB.IND_CTZNSHP_SUCCESS_SYSTEM));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ELIGIBILITY_COURT_MONTH)) {
      ageCitizenshipDB.setIndEligibilityCourtMonth(ContextHelper.getBooleanSafe(request,
                                                                                AgeCitizenshipDB.IND_ELIGIBILITY_COURT_MONTH));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_ELIGIBLE)) {
      ageCitizenshipDB.setIndEligible(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_ELIGIBLE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_EQUITY)) {
      ageCitizenshipDB.setIndEquity(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_EQUITY));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_FATHER_PWE)) {
      ageCitizenshipDB.setIndFatherPwe(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_FATHER_PWE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_HOME_INCOME_AFDC_ELGBLTY)) {
      ageCitizenshipDB.setIndHomeIncomeAfdcElgblty(ContextHelper.getBooleanSafe(request,
                                                                                AgeCitizenshipDB.IND_HOME_INCOME_AFDC_ELGBLTY));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_MEETS_DP_OR_NOT_ES)) {
      ageCitizenshipDB.setIndMeetsDpOrNotEs(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_MEETS_DP_OR_NOT_ES));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_MEETS_DP_OR_NOT_SYSTEM)) {
      ageCitizenshipDB.setIndMeetsDpOrNotSystem(ContextHelper.getBooleanSafe(request,
                                                                             AgeCitizenshipDB.IND_MEETS_DP_OR_NOT_SYSTEM));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_MOTHER_PWE)) {
      ageCitizenshipDB.setIndMotherPwe(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_MOTHER_PWE));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_NARRATIVE_APPROVED)) {
      ageCitizenshipDB.setIndNarrativeApproved(ContextHelper.getBooleanSafe(request,
                                                                            AgeCitizenshipDB.IND_NARRATIVE_APPROVED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_OTHER_VERIFICATION)) {
      ageCitizenshipDB.setIndOtherVerification(ContextHelper.getBooleanSafe(request,
                                                                            AgeCitizenshipDB.IND_OTHER_VERIFICATION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_PARENTAL_DEPRIVATION)) {
      ageCitizenshipDB.setIndParentalDeprivation(ContextHelper.getBooleanSafe(request,
                                                                              AgeCitizenshipDB.IND_PARENTAL_DEPRIVATION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_PARENT_DISABLED)) {
      ageCitizenshipDB.setIndParentDisabled(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_PARENT_DISABLED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_PRS_MANAGING_CVS)) {
      ageCitizenshipDB.setIndPrsManagingCvs(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_PRS_MANAGING_CVS));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_REMOVAL_CHILD_ORDERED)) {
      ageCitizenshipDB.setIndRemovalChildOrdered(ContextHelper.getBooleanSafe(request,
                                                                              AgeCitizenshipDB.IND_REMOVAL_CHILD_ORDERED));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_RSDI_VERIFICATION)) {
      ageCitizenshipDB.setIndRsdiVerification(ContextHelper.getBooleanSafe(request,
                                                                           AgeCitizenshipDB.IND_RSDI_VERIFICATION));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_RSNBL_EFFORT_PRVT_REMOVAL)) {
      ageCitizenshipDB.setIndRsnblEffortPrvtRemoval(ContextHelper.getBooleanSafe(request,
                                                                                 AgeCitizenshipDB.IND_RSNBL_EFFORT_PRVT_REMOVAL));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_SSI_VERIFICATION)) {
      ageCitizenshipDB.setIndSsiVerification(ContextHelper.getBooleanSafe(request,
                                                                          AgeCitizenshipDB.IND_SSI_VERIFICATION));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_CERTIFIED_GROUP)) {
      ageCitizenshipDB.setNbrCertifiedGroup(ContextHelper.getLongSafe(request, AgeCitizenshipDB.NBR_CERTIFIED_GROUP));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_PARENTS_HOME)) {
      ageCitizenshipDB.setNbrParentsHome(ContextHelper.getLongSafe(request, AgeCitizenshipDB.NBR_PARENTS_HOME));
    }
    if (map.containsKey(AgeCitizenshipDB.TXT_DETERMINATION_COMMENTS)) {
      ageCitizenshipDB.setTxtDeterminationComments(ContextHelper.getStringSafe(request,
                                                                               AgeCitizenshipDB.TXT_DETERMINATION_COMMENTS));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_REL_INT)) {
      ageCitizenshipDB.setCdRelInt(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_REL_INT));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_BIRTH_STRING)) {
      ageCitizenshipDB.setDtBirthString(ContextHelper.getStringSafe(request, AgeCitizenshipDB.DT_BIRTH_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.DT_BIRTH_TIME)) {
      ageCitizenshipDB.setDtBirthTime(ContextHelper.getLongSafe(request, AgeCitizenshipDB.DT_BIRTH_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_PERSON_DT_LAST_UPDATE_STRING)) {
      ageCitizenshipDB.setFcePersonDtLastUpdateString(ContextHelper.getStringSafe(request,
                                                                                  AgeCitizenshipDB.FCE_PERSON_DT_LAST_UPDATE_STRING));
    }
    if (map.containsKey(AgeCitizenshipDB.FCE_PERSON_DT_LAST_UPDATE_TIME)) {
      ageCitizenshipDB.setFcePersonDtLastUpdateTime(ContextHelper.getLongSafe(request,
                                                                              AgeCitizenshipDB.FCE_PERSON_DT_LAST_UPDATE_TIME));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_CERTIFIED_GROUP)) {
      ageCitizenshipDB.setIndCertifiedGroup(ContextHelper.getBooleanSafe(request,
                                                                         AgeCitizenshipDB.IND_CERTIFIED_GROUP));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_DOB_APPROX)) {
      ageCitizenshipDB.setIndDobApprox(ContextHelper.getBooleanSafe(request, AgeCitizenshipDB.IND_DOB_APPROX));
    }
    if (map.containsKey(AgeCitizenshipDB.IND_PERSON_HM_REMOVAL)) {
      ageCitizenshipDB.setIndPersonHmRemoval(ContextHelper.getBooleanSafe(request,
                                                                          AgeCitizenshipDB.IND_PERSON_HM_REMOVAL));
    }
    if (map.containsKey(AgeCitizenshipDB.NBR_AGE)) {
      ageCitizenshipDB.setNbrAge(ContextHelper.getLongSafe(request, AgeCitizenshipDB.NBR_AGE));
    }
    if (map.containsKey(AgeCitizenshipDB.CD_EVENT_STATUS)) {
      ageCitizenshipDB.setCdEventStatus(ContextHelper.getStringSafe(request, AgeCitizenshipDB.CD_EVENT_STATUS));
    }
  }
}
