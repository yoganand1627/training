package gov.georgia.dhr.dfcs.sacwis.web.intake;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

public interface IntakeConstants {
  public static final String PRIORITY_EVENT_CREATED = "PRIORITY_EVENT_CREATED";

  public static final String ACTIVE = "actv";

  public static final String LOCATION = "lctn";

  public static final String ACTIVE_STATUS = "A";

  public static final String ADD = "add";

  public static final String APPROVE_CALL_CD_TASK = "1040";

  public static final String APPROVE_CALL_CD_TASK_CHILD_DEATH = "1041";

  public static final String APPROVE_CALL_CD_TASK_SERIOUS_INJURY = "1042";
  
  public static final String APPROVE_CALL_CD_TASK_RESPONSE_TIME = "1043";

  public static final String APPROVE_CALL_CD_TASK_NI = "1044";
  
  public static final String APPROVE_CALL_CD_TASK_NEAR_FATALITY = "1045";

  // public static final String INT_RPT_SUBMIT_REVIEW_APPRVL = "An intake has been submitted for review and approval";
  public static final String APS_PREFIX = "A";

  public static final String ASSIGN_INTAKE = "assignIntake";

  public static final String CALLER_SORT = "01";

  public static final String CAPS_PROG_PRS = "PRS";

  public static final String CASE_RELATED_SPECREQ_PREFIX = "C";

  public static final String CATEGORY_CAS = "CAS";

  public static final String CCLASS_PREFIX_CPS = "C";

  public static final String CCLASS_PREFIX_LICENSE = "L";

  public static final String CCLASS_PREFIX_N = "N";

  public static final String CCLASS_PREFIX_FSC = "F";

  public static final String CCLASS_PREFIX_ADO = "A";
  
  public static final String CCLASS_PREFIX_PAD = "P";

  public static final String CCLASS_PREFIX_RDV = "R";

  public static final String CLASS_PREFIX_APS = "A";

  public static final String CLASS_PREFIX_CPS = "C";

  public static final String CLASS_PREFIX_LIC = "L";

  public static final String CLOSURE_CD_CASE_REL_SR = "02";

  public static final String CLOSURE_CD_INTAKE = "ACA";

  public static final String COUNTY = "county";

  public static final String DETERMINATION_DESCRIPTOR = "D";

  public static final String DETERMINATION_FACTOR_PA = "P";

  public static final String DETERMINATION_FACTOR_NEG = "N";

  public static final String DETERMINATION_FACTOR_EA = "E";

  public static final String DETERMINATION_FACTOR_SA = "S";

  public static final String DETERMINATION_FACTOR_OTH = "O";

  public static final String EVENT_CHANGE_PRIORITY_IND = "P";

  public static final String FRM_CALL_INFO = "frmCallInformation";

  public static final String FRM_CALL_LOG = "frmCallLog";

  public static final String FRM_INTAKE_ACTIONS = "frmIntakeActions";

  public static final String GENDER_SPECIFIED_BY_USER = "_genderSpecified";

  public static final String IMPACT_UNIT_STATE_OFFICE = "99";

  public static final String IMPACT_UNIT_SWI = "00";

  public static final String INDICATOR_NO = "N";

  public static final String INDICATOR_YES = "Y";

  public static final String MULTIPLE_MODIFY = "multiple";

  public static final String NAME_UNKNOWN = "Unknown";

  public static final String NARRATIVE_EXISTS = "callNarrExists";

  public static final String NEW_USING_APS = "S";

  public static final String NEW_USING_CAR = "R";

  public static final String NEW_USING_CWA = "C";

  public static final String NEW_USING_OPEN = "O";

  public static final String NON_CASE_RELATED_PREFIX = "N";

  public static final String NO_FACTORS = "no_factors";

  public static final String OTHER_SORT = "03";

  public static final String PAGE_MODE_NEW_USING = "pageModeNewUsing";

  public static final String PERP = CodesTables.CINTROLE_AP;

  public static final String PERP_OR_VIC = CodesTables.CINTROLE_VP;

  public static final String PERSON_IN_ALLEG = "personInAlleg";

  public static final String PERSON_IS_RELATED = "personIsRelated";

  public static final String PERSON_IS_REPORTER = "personIsReporter";

  public static final String PRIORITY_CHANGED = "currPriorityChanged";

  public static final String RELATED = "R";

  public static final String REPORTER = "(Reporter)";

  public static final String REPORTER_SORT = "02";

  public static final String SEARCH_CRITERIA = "_searchCriteria";

  public static final String SEARCH_INTAKE = "intake";

  public static final String SEARCH_PERFORMED = "_searchPerformed";

  public static final String SEARCH_RESULTS = "_searchResults";

  public static final String SINGLE_MODIFY = "single";

  public static final String UNKNOWN = "U";

  public static final String UNRELATED = "U";

  public static final String VICTIM = CodesTables.CINTROLE_VC;

  public static final String VIEWED = "V";

  public static final int ASSIGN_BUTTON = 2;

  public static final int CLOSE_BUTTON = 3;

  public static final int HIGH_PRIORITY_AGE = 7;

  public static final int IMPACT_REGION_MAX = 99;

  public static final int IMPACT_REGION_SWI = 515;

  public static final int LEGAL_ADULT_AGE = 18;

  public static final int MAX_OLDEST_VICTIM_PRN = 1;

  public static final int MAX_PRN_VP_VC = 1;

  public static final int MINIMUM_CPS_FACTORS = 3;

  public static final int PAGE_NUMBER_SIZE = 8;

  public static final int RETIREMENT_AGE = 65;

  public static final int SUBMIT_BUTTON = 1;

  public static final int NAME_INDEX = 0;

  public static final int ADDRESS_1_INDEX = 1;

  public static final int ADDRESS_2_INDEX = 2;

  public static final int CITY_INDEX = 3;

  public static final int STATE_INDEX = 4;

  public static final int ZIP_INDEX = 5;

  public static final int COUNTY_INDEX = 6;

  public static final int ADDRESS_TYPE_INDEX = 7;

  public static final int PHONE_INDEX = 8;

  public static final int PHONE_EXT_INDEX = 9;

  public static final int PHONE_TYPE_INDEX = 10;
}
