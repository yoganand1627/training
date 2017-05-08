/**
 * Created on Feb 24, 2006 at 6:18:48 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.person;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.person.RaceEthnicityBean;
import gov.georgia.dhr.dfcs.sacwis.web.core.cbhelper.CheckboxHelper;
import gov.georgia.dhr.dfcs.sacwis.web.core.state.BaseSessionStateManager;
import gov.georgia.dhr.dfcs.sacwis.web.core.web.ContextHelper;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class RaceEthnicityHelper {
  /** Used as a request parameter to note if a bean is in the request. Value = race_ethnicity_in_request. */
  public static final String IN_REQUEST = "race_ethnicity_in_request";
  /** Used as a request parameter to note if a bean is in the state. Value = race_ethnicity_in_state. */
  public static final String IN_STATE = "race_ethnicity_in_state";
  /** The name by which the bean is put into the request. Value = request_name. */
  public static final String REQUEST_NAME = "request_name";
  /** Name of the radio button field that holds the ethnicity value on the jsp Value = rbEthnicity. */
  public static final String ETHNICITY_RB_NAME = "rbEthnicity";
  /**
   * Name of the hidden field that holds the ethnicity value from before the radio button was submitted. Value =
   * hdnOldEthnicity.
   */
  public static final String OLD_ETHNICITY_NAME = "hdnOldEthnicity";
  /** Name of the checkbox field that holds the race values on the jsp. Value = cbxRace. */
  public static final String RACE_CB_NAME = "cbxRace";
  /** The value for AH (American Indian and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_AMERIND_HISPANIC = CodesTables.CETHNIC_AH;
  /** The value for AI (American Indian and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_AMERIND_NON_HISPANIC = CodesTables.CETHNIC_AI;
  /** The value for AI (American Indian and Unable to Determine ) from the CETHNIC codes table */
  public static final String GROUP_AMERIND_UTD = CodesTables.CETHNIC_AU;
  /** The value for AS (Asian and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_ASIAN_HISPANIC = CodesTables.CETHNIC_AS;
  /** The value for AT (Asian and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_ASIAN_NON_HISPANIC = CodesTables.CETHNIC_AT;
  /** The value for AT (Asian and Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_ASIAN_UTD = CodesTables.CETHNIC_AN;
  /** The value for BH (Black and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_BLACK_HISPANIC = CodesTables.CETHNIC_BH;
  /** The value for BL (Black and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_BLACK_NON_HISPANIC = CodesTables.CETHNIC_BL;
  /** The value for BV (Black and Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_BLACK_UTD = CodesTables.CETHNIC_BU;
  /** The value for BV (Black and White and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_BLACK_WHITE_HISPANIC = CodesTables.CETHNIC_BV;
  /** The value for BW (Black and White and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_BLACK_WHITE_NON_HISPANIC = CodesTables.CETHNIC_BW;
  /** The value for BW (Black and White and Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_BLACK_WHITE_UTD = CodesTables.CETHNIC_BN;
  /** The value for HH (Hawaiian and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_HAWAIIAN_HISPANIC = CodesTables.CETHNIC_HH;
  /** The value for HI (Hawaiian and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_HAWAIIAN_NON_HISPANIC = CodesTables.CETHNIC_HI;
  /** The value for HI (Hawaiian and Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_HAWAIIAN_UTD = CodesTables.CETHNIC_HU;
  /** The value for HW (White and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_WHITE_HISPANIC = CodesTables.CETHNIC_HW;
  /** The value for WH (White and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_WHITE_NON_HISPANIC = CodesTables.CETHNIC_WH;
  /** The value for MH (Multiple and Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_WHITE_UTD = CodesTables.CETHNIC_WU;
  /** The value for MH (Multiple and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_MULTIPLE_HISPANIC = CodesTables.CETHNIC_MH;
  /** The value for MN (Multiple and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_MULTIPLE_NON_HISPANIC = CodesTables.CETHNIC_MN;
  /** The value for MN (Multiple and Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_MULTIPLE_UTD = CodesTables.CETHNIC_MU;
  /** The value for UN (Unable to Determine) from the CETHNIC codes table */
  public static final String GROUP_UNABLE_TO_DETERMINE = CodesTables.CETHNIC_UN;
  /** The value for UN (Unable to Determine and Hispanic) from the CETHNIC codes table */
  public static final String GROUP_UNABLE_HISPANIC = CodesTables.CETHNIC_UH;
  /** The value for UN (Unable to Determine and Not Hispanic) from the CETHNIC codes table */
  public static final String GROUP_UNABLE_NON_HISPANIC = CodesTables.CETHNIC_UI;
  /** The value for AA (American Indian) from the CRACE codes table */
  public static final String RACE_AMERIND = CodesTables.CRACE_AA;
  /** The value for AN (Asian) from the CRACE codes table */
  public static final String RACE_ASIAN = CodesTables.CRACE_AN;
  /** The value for BK (Black) from the CRACE codes table */
  public static final String RACE_BLACK = CodesTables.CRACE_BK;
  /** The value for HP (Hawaiian/Pacific Islander) from the CRACE codes table */
  public static final String RACE_HAWAIIAN = CodesTables.CRACE_HP;
  /** The value for UD (Unable to Determine) from the CRACE codes table */
  public static final String RACE_UNABLE_TO_DETERMINE = CodesTables.CRACE_UD;
  /** The value for WT (White) from the CRACE codes table */
  public static final String RACE_WHITE = CodesTables.CRACE_WT;
  /** The value for HS (Hispanic) from the CINDETHN codes table */
  public static final String ETHNICITY_HISPANIC = CodesTables.CINDETHN_HS;
  /** The value for NH (Not Hispanic) from the CINDETHN codes table */
  public static final String ETHNICITY_NON_HISPANIC = CodesTables.CINDETHN_NH;
  /** The value for UT (Unable to determine) from the CINDETHN codes table */
  public static final String ETHNICITY_UNABLE_TO_DETERMINE = CodesTables.CINDETHN_UT;

  /**
   * This pulls the race, ethnicity, and old ethnicity information out of the request. It is how to create a
   * RaceEthnicityBean correctly populated from the information contained in a form that includes the
   * RaceEthnicitySub.jsp.
   *
   * @param request
   */
  public static RaceEthnicityBean createRaceEthnicityBean(HttpServletRequest request) {
    RaceEthnicityBean raceEthnicityBean = new RaceEthnicityBean();
    setRaces(raceEthnicityBean, request);
    setEthnicity(raceEthnicityBean, request);
    setOldEthnicity(raceEthnicityBean, request);
    return raceEthnicityBean;
  }

  /** @param request  */
  public static void setRaces(RaceEthnicityBean raceEthnicityBean, HttpServletRequest request) {
    raceEthnicityBean.setRaces(new RaceEthnicityBean.Races(CheckboxHelper.getCheckedIndicators(request, RACE_CB_NAME)));
  }

  /** @param request  */
  public static void setEthnicity(RaceEthnicityBean raceEthnicityBean, HttpServletRequest request) {
    raceEthnicityBean.setEthnicity(ContextHelper.getStringSafe(request, ETHNICITY_RB_NAME));
  }

  /** @param request  */
  public static void setOldEthnicity(RaceEthnicityBean raceEthnicityBean, HttpServletRequest request) {
    raceEthnicityBean.setOldEthnicity(ContextHelper.getStringSafe(request, OLD_ETHNICITY_NAME));
  }

  /**
   * This gets the RaceEthnicity Group Indicator (the code from table CETHNIC, stored in szCdPersonEthnicGroup) from the
   * race indicators (Codes table CRACE, accessed via getRaces() ), and the ethnicity indicators ( codes table CINDETHN,
   * accessed via getEthnicity() ).
   * <p/>
   * SIR 17430: this method cannot use the races array, because it is a list of the change in races, not the total list
   * of races. This method must use the complete race list, so that it determines the correct race group every time, not
   * just when the races are changed. to do this, it has to get the complete list of checked races from the request.
   *
   * @return
   */
  public static String getRaceEthnicityGroup(RaceEthnicityBean raceEthnicityBean, HttpServletRequest request) {
    String[] raceArray = CheckboxHelper.getCheckedValues(request, RACE_CB_NAME);
    List totalRaces = Arrays.asList(raceArray);
    int numRaces = totalRaces.size();

    // JMC SIR 19738 - The fix for 19105 was not entirely complete. We do not want
    // the ethnicityGroup to DEFAULT to Unable to Determine, but if the user selects
    // "Unable to Determine"  for both Race and Eth, we do want to save "UN" to the database.  The fix for 19105
    // meant that UN was never getting sent to the database at all.  Also, the previous logic
    // was setting group = GROUP_UNABLE_TO_DETERMINE if "Unable to Determine" was checked in
    // the race section.  This was incorrect - group should only be saved as "Unable to Determine"
    // if the user actually checks "Unable to Determine" in both sections.
    String ethnicity = raceEthnicityBean.getEthnicity();
    String group;
    if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity) && totalRaces.contains(RACE_UNABLE_TO_DETERMINE)) {
      group = GROUP_UNABLE_TO_DETERMINE;
    } else {
      boolean isHisp = ETHNICITY_HISPANIC.equals(ethnicity);
      if (numRaces > 2) {
        // SIR 22869 If there are more than 2 races and UTD (Eth) is selected, put
        // Group Multiple UTD, other wise if they are hispanic put
        // Group Multiple Hispanic, if not put group Multiple Non Hisp
        if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
          group = GROUP_MULTIPLE_UTD;
        } else {
          group = (isHisp) ? GROUP_MULTIPLE_HISPANIC :
                  GROUP_MULTIPLE_NON_HISPANIC;
        }

      } // end if multiple races
      else if (numRaces == 2) {
        // SIR 22869 If there are exactly 2 races that are black and white and UTD (Eth) is selected, put
        // Group B/W UTD, other wise if they are hispanic put
        // Group B/W Hispanic, if not put Group B/W Non Hisp
        // If there are exctly 2 races and at least one is not black or white and
        // UTD (Eth) is selected put Group Multiple UTD, other wise if they are hispanic put
        // Group Multiple Hispanic, if not put group Multiple Non Hisp
        if (totalRaces.contains(RACE_BLACK) && totalRaces.contains(RACE_WHITE)) {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_BLACK_WHITE_UTD;
          } else {
            group = (isHisp) ? GROUP_BLACK_WHITE_HISPANIC :
                    GROUP_BLACK_WHITE_NON_HISPANIC;
          }
        } // end if black and white
        else {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_MULTIPLE_UTD;
          } else {
            group = (isHisp) ? GROUP_MULTIPLE_HISPANIC :
                    GROUP_MULTIPLE_NON_HISPANIC;
          }
        } // end else not black and white
      } // end else 2 races
      else {
        // SIR 22869 For the rest of these, if the Ethnicity is UTD, then set it
        // to group Race and UTD, otherwise if they are hispanic
        // set it to group Race and Hispanic.  If they are not
        // hispanic set it to Race and Not hispanic.
        if (totalRaces.contains(RACE_AMERIND)) {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_AMERIND_UTD;
          } else {
            group = (isHisp) ? GROUP_AMERIND_HISPANIC :
                    GROUP_AMERIND_NON_HISPANIC;
          }
        } else if (totalRaces.contains(RACE_ASIAN)) {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_ASIAN_UTD;
          } else {
            group = (isHisp) ? GROUP_ASIAN_HISPANIC :
                    GROUP_ASIAN_NON_HISPANIC;
          }
        } else if (totalRaces.contains(RACE_BLACK)) {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_BLACK_UTD;
          } else {
            group = (isHisp) ? GROUP_BLACK_HISPANIC :
                    GROUP_BLACK_NON_HISPANIC;
          }
        } else if (totalRaces.contains(RACE_HAWAIIAN)) {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_HAWAIIAN_UTD;
          } else {
            group = (isHisp) ? GROUP_HAWAIIAN_HISPANIC :
                    GROUP_HAWAIIAN_NON_HISPANIC;
          }
        } else if (totalRaces.contains(RACE_WHITE)) {
          if (ETHNICITY_UNABLE_TO_DETERMINE.equals(ethnicity)) {
            group = GROUP_WHITE_UTD;
          } else {
            group = (isHisp) ? GROUP_WHITE_HISPANIC :
                    GROUP_WHITE_NON_HISPANIC;
          }
        }
        // SIR 22869 Since Unable to Determine with Unable to determine was
        // caught at the top of this if clause, if the race is UTD
        // and the Eth is Hispanic, set it to Group UTD with Hispanic
        // otherwise set it to Group UTD with Non Hispanic
        else if (totalRaces.contains(RACE_UNABLE_TO_DETERMINE)) {
          group = (isHisp) ? GROUP_UNABLE_HISPANIC :
                  GROUP_UNABLE_NON_HISPANIC;
        }
        // SIR 22869 If the person has no Race this means they have no ETH
        // and the group should be blank.
        else {
          group = "";
        }
      } // end else 1 race
    } // end else

    return group;
  }

  /**
   * @param request
   * @return
   */
  public static boolean isEthnicityChecked(HttpServletRequest request) {
    String raceVal = request.getParameter(ETHNICITY_RB_NAME);
    if (StringHelper.isValid(raceVal)) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * @param request
   * @return
   */
  public static boolean isRaceChecked(HttpServletRequest request) {
    boolean isChecked = false;
    try {
      Collection race = Lookup.getCategoryCodesCollection(CodesTables.CRACE);
      int numRaces = race.size();
      for (int i = 0; i < numRaces; i++) {
        String checked = request.getParameter(RACE_CB_NAME + (i + 1));
        if (checked != null) {
          return true;
        }
      }
    }
    catch (Exception e) {
      isChecked = false;
    }
    return isChecked;
  }

  /** @param request  */
  public static void addToRequest(RaceEthnicityBean raceEthnicityBean, HttpServletRequest request) {
    request.setAttribute(REQUEST_NAME, raceEthnicityBean);
    request.setAttribute(IN_REQUEST, IN_REQUEST);
  }

  /**
   * @param request
   * @return
   */
  public static RaceEthnicityBean getFromRequest(HttpServletRequest request) {
    return request.getAttribute(REQUEST_NAME) != null ?
           (RaceEthnicityBean) request.getAttribute(REQUEST_NAME) :
           createRaceEthnicityBean(request);
  }

  public static void addToState(RaceEthnicityBean raceEthnicityBean, HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    sessionState.setAttribute(REQUEST_NAME, raceEthnicityBean, request);
    sessionState.setAttribute(IN_STATE, IN_STATE, request);
  }

  public static RaceEthnicityBean getFromState(HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    return sessionState.getAttribute(REQUEST_NAME, request) != null ?
           (RaceEthnicityBean) sessionState.getAttribute(REQUEST_NAME, request) :
           createRaceEthnicityBean(request);
  }

  public static boolean isInRequest(HttpServletRequest request) {
    return StringHelper.isValid((String) request.getAttribute(IN_REQUEST)) ||
           StringHelper.isValid(request.getParameter(IN_REQUEST));
  }

  public static boolean isInState(HttpServletRequest request) {
    BaseSessionStateManager sessionState =
            (BaseSessionStateManager) request.getAttribute(BaseSessionStateManager.STATE_MANAGER_KEY);
    return StringHelper.isValid((String) sessionState.getAttribute(IN_STATE, request));
  }
}
