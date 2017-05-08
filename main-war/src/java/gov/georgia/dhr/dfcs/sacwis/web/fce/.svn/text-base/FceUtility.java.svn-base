package gov.georgia.dhr.dfcs.sacwis.web.fce;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.grnds.facility.config.GrndsConfiguration;
import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.PageModeConstants;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceApplicationPageDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePageDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FcePersonDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReasonNotEligibleDB;
import gov.georgia.dhr.dfcs.sacwis.dao.fce.FceReviewPageDB;
import gov.georgia.dhr.dfcs.sacwis.service.fce.EventHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfile;
import gov.georgia.dhr.dfcs.sacwis.web.core.user.UserProfileHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.BasePrsConversation;
import gov.georgia.dhr.dfcs.sacwis.web.workload.ToDoHelper;

/**
 * <p>Title: FCE Utility </p> <p>Description: Contains some utilities for FCE</p> <p>Copyright: Copyright (c) 2002</p>
 * <p>Company: Accenture</p>
 *
 * @author Rodrigo DeJuana
 * @version 1.0
 */
public class FceUtility {
  public static final boolean ENABLE_SYSTEM_OUT =
          "true".equals(GrndsConfiguration.getInstance().getProperty(ArchitectureConstants.GRNDS_DOMAIN,
                                                                     "enable.system.out.FceUtility"));

  protected static final String FCE_TAB_STATE = "FCE_TAB_STATE";
  protected static final String CD_EVENT_STATUS = "FceUtility.CD_EVENT_STATUS";
  public static final String FCE_TAB_SET = "FceTabSet";
  public static final String APPLICATION_TAB_SET = "APP";
  public static final String REVIEW_TAB_SET = "REV";
  public static final String JANUARY = "January";
  public static final String FEBRUARY = "February";
  public static final String MARCH = "March";
  public static final String APRIL = "April";
  public static final String MAY = "May";
  public static final String JUNE = "June";
  public static final String JULY = "July";
  public static final String AUGUST = "August";
  public static final String SEPTEMBER = "September";
  public static final String OCTOBER = "October";
  public static final String NOVEMBER = "November";
  public static final String DECEMBER = "December";
  public static final String INITIAL_APP_CODE = "A";
  public static final String NOTIFICATION_OF_CHANGE_CODE = "R";
  

  // This array has an empty string for the first element to facilitate lookups w/o offsets;
  //  it is private because of the way it is indexed
  private static final String[] monthArray = {"",
                                              JANUARY,
                                              FEBRUARY,
                                              MARCH,
                                              APRIL,
                                              MAY,
                                              JUNE,
                                              JULY,
                                              AUGUST,
                                              SEPTEMBER,
                                              OCTOBER,
                                              NOVEMBER,
                                              DECEMBER};

  /** Allows me to optionally print to System.out as well as to impact-trace.log */
  public static final void trace(String traceTag,
                                 String string) {
    if (ENABLE_SYSTEM_OUT) {
      //to avoid Brad's grep
      PrintStream out = System.out;
      out.println(string);
    }
    GrndsTrace.msg(traceTag, 7, string);
  }

  /** takes a list of FceReasonNotEligibleDB and an Application code and returns a list of strings */
  public static List getPastTenseReasonsNotEligible(List reasonsNotEligible, String cdApplication) {
    List output = new ArrayList(reasonsNotEligible.size());

    Iterator iterator = reasonsNotEligible.iterator();
    while (iterator.hasNext()) {
      FceReasonNotEligibleDB fceReasonNotEligibleDB = (FceReasonNotEligibleDB)
              iterator.next();

      String reasonCode = fceReasonNotEligibleDB.getCdReasonNotEligible();
      String reason = Lookup.simpleDecodeSafe(CodesTables.CFCERNE, reasonCode);

      if (reasonCode.startsWith("A")) {
        if (INITIAL_APP_CODE.equals(cdApplication)){
          reason = "At initial application, " + reason;
        } else {
          reason = "At Notification of Change, " + reason;
        }
      } else {
        reason = "At review, " + reason;
      }
      output.add(reason);
    }
    return output;
  }

  public static String getCdEventStatus(HttpServletRequest request) {
    FceTabState fceTabState = getFceTabState(request);
    return fceTabState.getEventStatus();
  }

  public static void setCdEventStatus(FcePageDB fcePageDB,
                                      HttpServletRequest request) {
    setCdEventStatus(fcePageDB.getCdEventStatus(), request);
  }

  public static void setCdEventStatus(String cdEventStatus,
                                      HttpServletRequest request) {
    FceTabState fceTabState = getFceTabState(request);
    fceTabState.setEventStatus(cdEventStatus);
    setFceTabState(request, fceTabState);
  }

  public static String getFceApplicationPageMode(HttpServletRequest request,
                                                 FceApplicationPageDB fceApplicationPageDB) {

    String pageMode = GlobalData.getAppMode(request);

    boolean hasPageModeEditOverride =
            ToDoHelper.hasPageModeEditOverride(request,
                                               EventHelper.FCE_APPLICATION_TASK_CODE,
                                               (int) fceApplicationPageDB.getIdStage(),
                                               (int) fceApplicationPageDB.getIdEvent());

    if (hasPageModeEditOverride) {
      pageMode = PageModeConstants.EDIT;
    }

    String eventStatus = fceApplicationPageDB.getCdEventStatus();

    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    if (CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
      pageMode = PageModeConstants.VIEW;
    } else if ((userProfile.hasRight(UserProfile.SEC_ELIGIBILITY) == false) &&
               (CodesTables.CEVTSTAT_PEND.equals(eventStatus) ||
                CodesTables.CEVTSTAT_COMP.equals(eventStatus))) {
      pageMode = PageModeConstants.VIEW;
    }

    return pageMode;
  }

  public static String getFceReviewPageMode(HttpServletRequest request,
                                            FceReviewPageDB fceReviewPageDB) {

    String pageMode = GlobalData.getAppMode(request);

    boolean hasPageModeEditOverride =
            ToDoHelper.hasPageModeEditOverride(request,
                                               EventHelper.FCE_REVIEW_TASK_CODE,
                                               (int) fceReviewPageDB.getIdStage(),
                                               (int) fceReviewPageDB.getIdEvent());

    if (hasPageModeEditOverride) {
      pageMode = PageModeConstants.EDIT;
    }

    String eventStatus = fceReviewPageDB.getCdEventStatus();

    UserProfile userProfile = UserProfileHelper.getUserProfile(request);

    if (CodesTables.CEVTSTAT_APRV.equals(eventStatus)) {
      pageMode = PageModeConstants.VIEW;
    }else if ((userProfile.hasRight(UserProfile.SEC_ELIGIBILITY) == false) &&
               (CodesTables.CEVTSTAT_PEND.equals(eventStatus) ||
                 CodesTables.CEVTSTAT_COMP.equals(eventStatus))) {
      pageMode = PageModeConstants.VIEW;
    }

    return pageMode;
  }

  public static boolean isEligibilitySpecialist(HttpServletRequest request) {
    UserProfile userProfile = BasePrsConversation.getUserProfile(request);
    return isEligibilitySpecialist(userProfile);
  }

  public static boolean isEligibilitySpecialist(UserProfile userProfile) {
    return userProfile.hasRight(UserProfile.SEC_ELIGIBILITY);
  }

  public static boolean isBillingSpecialist(HttpServletRequest request) {
    UserProfile userProfile = BasePrsConversation.getUserProfile(request);
    return isBillingSpecialist(userProfile);
  }

  public static boolean isBillingSpecialist(UserProfile userProfile) {
    return userProfile.hasRight(UserProfile.SEC_BILLING);
  }

  public static List getOptionsFromPrinciples(List personListIn) {
    List optionList = new ArrayList();
    if (personListIn == null) {
      return optionList;
    }
    Iterator personListIt = personListIn.listIterator();

    while (personListIt.hasNext()) {
      FcePersonDB fcePersonDB = (FcePersonDB) personListIt.next();
      Option person = new Option(fcePersonDB.getIdPersonString(), fcePersonDB.getNmPersonFull());
      optionList.add(person);
    }

    return optionList;
  }

  public static FceTabState getFceTabState(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);

    FceTabState fceTabState = (FceTabState)
            state.getContextParameter(FCE_TAB_STATE, request);

    if (fceTabState != null) {
      return fceTabState;
    }

    fceTabState = new FceTabState();
    setFceTabState(request, fceTabState);
    return fceTabState;
  }

  public static void clearFceTabState(HttpServletRequest request) {
    setFceTabState(request, null);
  }

  public static void setApplicationFceTabState(HttpServletRequest request) {
    FceTabState fceTabState = new FceTabState();
    fceTabState.setTabSet(APPLICATION_TAB_SET);
    fceTabState.setShowChecklist(false);

    setFceTabState(request, fceTabState);
  }

  public static void setReviewFceTabState(HttpServletRequest request,
                                          boolean showChecklist) {
    FceTabState fceTabState = new FceTabState();
    fceTabState.setTabSet(REVIEW_TAB_SET);
    fceTabState.setShowChecklist(showChecklist);

    setFceTabState(request, fceTabState);
  }

  protected static void setFceTabState(HttpServletRequest request,
                                       FceTabState fceTabState) {
    BaseSessionStateManager state = GlobalData.getState(request);
    state.setContextParameter(FCE_TAB_STATE,
                              fceTabState,
                              request);
  }

  public static List getMonthsOptions() {
    List CMONTH = new ArrayList();
    // start at 1 because months are 1-based
    for (int i = 1; i < monthArray.length; i++) {
      Option month = new Option(String.valueOf(i), monthArray[i]);
      CMONTH.add(month);
    }
    return CMONTH;
  }

  public static String getMonthString(int nbrMonth) {
    return monthArray[nbrMonth];
  }

  public static String getMonthString(long nbrMonth) {
    return monthArray[(int) nbrMonth];
  }
  
  public static boolean isMesProgramAssistant(HttpServletRequest request) {
    UserProfile userProfile = BasePrsConversation.getUserProfile(request);
    return isMesProgramAssistant(userProfile);
  }

  public static boolean isMesProgramAssistant(UserProfile userProfile) {
    return userProfile.hasRight(UserProfile.SEC_MES_PROGRAM_ASSIST);
  }
}
