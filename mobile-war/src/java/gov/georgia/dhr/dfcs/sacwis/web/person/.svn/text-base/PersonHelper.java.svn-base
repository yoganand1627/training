package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.GlobalData;

import javax.servlet.http.HttpServletRequest;

/**
 * Helper class for Person Detail
 * <p/>
 * <pre>
 * Change History:
 * Date      User      Description
 * --------  --------  --------------------------------------------------
 * 08/20/03  GRIMSHAN  SIR 19581 put in get and set methods for
 *                     bSysIndViewPersonInfo so that if the person is a former
 *                     employee that information can be carried around
 * 08/26/03  A.Corley  SIR 19525 put in get and set methods for bindrelate
 *                     so that if the person is being related, that information
 *                     will not be lost when editing detail sections
 * 08/15/04  CORLEYAN  SIR 22935 put in get and set methods for person type so that
 *                     Records check can know if the person is a COL or PRN
 * </pre>
 *
 * @author Brad Eilers
 */
public class PersonHelper {
  public static final String PERSON_DETAIL_PAGE_MODE = "personDetailPageMode";
  public static final String PERSON_CITIZENSHIP_IDENTITY_PAGE_MODE = "personCitizenshipIdentityPageMode";
  public static final String CD_PERS_ROLE = "szCdStagePersRole";
  public static final String CD_PERS_TYPE = "szCdStagePersType";

  private PersonHelper() {
    // Makes this class implicitly final.
  }

  /**
   * Sets the page mmode for person detail into the context area of state so it won't get cleared
   *
   * @param request  current request
   * @param pageMode page mode to set into context
   */
  public static void setPersonDetailPageMode(HttpServletRequest request, String pageMode) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(pageMode)) {
      state.setContextParameter(PERSON_DETAIL_PAGE_MODE, pageMode, request);
    }
  }

  /**
   * Sets the page mmode for person citizenship identity into the context area of state so it won't get cleared
   *
   * @param request  current request
   * @param pageMode page mode to set into context
   */
  public static void setPersonCitizenshipIdentityPageMode(HttpServletRequest request, String pageMode) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(pageMode)) {
      state.setContextParameter(PERSON_CITIZENSHIP_IDENTITY_PAGE_MODE, pageMode, request);
    }
  }

  /**
   * Returns the page mode for the person detail as set in the context area of state.
   *
   * @param request current request
   * @return page mode
   */
  public static String getPersonDetailPageMode(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);

    return (String)
            state.getContextParameter(PERSON_DETAIL_PAGE_MODE, request);
  }

  /**
   * Sets the szCdStagePersRole for CVS/FA Home into the context area of state so it won't get cleared
   *
   * @param request           current request
   * @param szCdStagePersRole page mode to set into context
   */
  public static void setSzCdStagePersRole(HttpServletRequest request, String szCdStagePersRole) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(szCdStagePersRole)) {
      state.setContextParameter(CD_PERS_ROLE, szCdStagePersRole, request);
    }
  }

  /**
   * Returns the szCdStagePersRole for CVS/FA Home as set in the context area of state.
   *
   * @param request current request
   * @return szCdStagePersRole
   */
  public static String getSzCdStagePersRole(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    return (String) state.getContextParameter(CD_PERS_ROLE, request);
  }

  /**
   * Sets the "bIndActiveStatus" to determine if the person being viewed is an active employee into the context area of
   * state so it won't get cleared
   *
   * @param request          current request
   * @param bIndActiveStatus page mode to set into context
   */
  public static void setBIndActiveStatus(HttpServletRequest request, String bIndActiveStatus) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(bIndActiveStatus)) {
      state.setContextParameter("bIndActiveStatus", bIndActiveStatus, request);
    }
  }

  /**
   * Returns the "bIndActiveStatus" to determine if the person being viewed is an active employee as set in the context
   * area of state.
   *
   * @param request current request
   * @return bIndActiveStatus
   */
  public static String getBIndActiveStatus(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    return (String) state.getContextParameter("bIndActiveStatus", request);
  }

  /**
   * Sets the "bIndRelate" to determine if the we are trying to relate a person in into the context area of state so it
   * won't get cleared
   *
   * @param request    current request
   * @param bIndRelate page mode to set into context
   */
  public static void setBIndRelate(HttpServletRequest request, String bIndRelate) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(bIndRelate)) {
      state.setContextParameter("bIndRelate", bIndRelate, request);
    }
  }

  /**
   * Returns the "bIndActiveStatus" tto determine if the we are trying to relate a person in as set in the context area
   * of state.
   *
   * @param request current request
   * @return bIndActiveStatus
   */
  public static String getBIndRelate(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    return (String) state.getContextParameter("bIndRelate", request);
  }

  /**
   * Sets the "bSysIndViewPersonInfo" to determine if the person being viewed is an employee into the context area of
   * state so it won't get cleared
   *
   * @param request               current request
   * @param bSysIndViewPersonInfo page mode to set into context
   */
  public static void setBSysIndViewPersonInfo(HttpServletRequest request, String bSysIndViewPersonInfo) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(bSysIndViewPersonInfo)) {
      state.setContextParameter("bSysIndViewPersonInfo", bSysIndViewPersonInfo, request);
    }
  }

  /**
   * Returns the "bSysIndViewPersonInfo" to determine if the person being viewed is an employee as set in the context
   * area of state.
   *
   * @param request current request
   * @return bSysIndViewPersonInfo
   */
  public static String getBSysIndViewPersonInfo(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    return (String) state.getContextParameter("bSysIndViewPersonInfo", request);
  }

  /**
   * Sets the szCdStagePersType for CVS/FA Home into the context area of state so it won't get cleared
   *
   * @param request           current request
   * @param szCdStagePersType stage person type to set into context
   */
  public static void setSzCdStagePersType(HttpServletRequest request, String szCdStagePersType) {
    BaseSessionStateManager state = GlobalData.getState(request);
    if (StringHelper.isValid(szCdStagePersType)) {
      state.setContextParameter(CD_PERS_TYPE, szCdStagePersType, request);
    }
  }

  /**
   * Returns the szCdStagePersType for CVS/FA Home as set in the context area of state.
   *
   * @param request current request
   * @return szCdStagePersRole
   */
  public static String getSzCdStagePersType(HttpServletRequest request) {
    BaseSessionStateManager state = GlobalData.getState(request);
    return (String) state.getContextParameter(CD_PERS_TYPE, request);
  }
}
