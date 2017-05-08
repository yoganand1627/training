package gov.georgia.dhr.dfcs.sacwis.web.core.user;

import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodeAttributes;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.LookupException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.UsernameContextHolder;
import gov.georgia.dhr.dfcs.sacwis.core.timer.PerformanceTrace;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.validation.exception.DataFormatException;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

import org.grnds.facility.log.GrndsTrace;

/**
 * <pre>
 * Change History:
 *  Date        User      Description
 *  --------  --------  --------------------------------------------------
 *  03/25/2009 bgehlot  Added the security Attribute SEC_CASE_REVIEW
 *  07/17/2009 bgehlot  STGAP00014341: MR51- Stage Reopen Changes Added the security Attribute SEC_STGAE_REOPEN
 */
@SuppressWarnings("serial")
public class UserProfile implements HttpSessionBindingListener, Serializable {

  public static final String TRACE_TAG = "UserProfile";

  public static final int MAX_NUM_ATTRIBUTES = 100;

  // Release 1 SHINES
  public static final String SEC_MNTN_SEC = "0";

  public static final String SEC_CHG_USER_CLASS = "1";

  public static final String SEC_REC_CALL = "2";

  public static final String SEC_MNTN_STAFF_GEN = "3";

  public static final String SEC_MNTN_ON_CALL = "4";

  public static final String SEC_MNTN_UNIT = "5";

  public static final String SEC_SENSITIVE_CASE_ACCESS = "6";

  public static final String SEC_UNIT_SUMMARY_ACCESS = "7";

  public static final String SEC_MNTN_PERSON = "8";

  public static final String SEC_ADMIN_REVIEW = "9";

  public static final String SEC_EMPL_REC_CHECK = "10";

  public static final String SEC_MERGE_PERSON = "11";

  public static final String SEC_MERGE_CASES = "12";

  public static final String SEC_MNTN_LOGIN = "13";

  public static final String SEC_MNTN_SEC_PROFILE = "14";

  public static final String SEC_MNTN_LEGAL_STAT = "15";

  public static final String SEC_RESTRICT_CASE_SEARCH = "16";

  public static final String SEC_RESTRICT_CASE_EVENT = "17";

  public static final String SEC_RESTRICT_PERSON_SEARCH = "18";

  public static final String SEC_RESTRICT_FINANCIAL = "19";
  
  public static final String SEC_RESTRICT_RESOURCE = "20";

  public static final String SEC_BROWSE_SEC = "21";

  public static final String SEC_RESTRICT_SEC = "22";

  public static final String SEC_ASSIGN_WORKLOAD = "23";

  public static final String SEC_PROTECTIVE_SERVICE_ALERT = "24";

  // Release 2 SHINES
  public static final String SEC_CPS_POS_CONTRACT = "25";

  public static final String SEC_FAC_CONTRACT = "26";

  public static final String SEC_BILLING = "27";

  public static final String SEC_ELIGIBILITY = "28";

  public static final String SEC_MNTN_RSRC = "29";

  public static final String SEC_MNTN_REGION_01 = "30";

  public static final String SEC_MNTN_REGION_02 = "31";

  public static final String SEC_MNTN_REGION_03 = "32";

  public static final String SEC_MNTN_REGION_04 = "33";

  public static final String SEC_MNTN_REGION_05 = "34";

  public static final String SEC_MNTN_REGION_06 = "35";

  public static final String SEC_MNTN_REGION_07 = "36";

  public static final String SEC_MNTN_REGION_08 = "37";

  public static final String SEC_MNTN_REGION_09 = "38";

  public static final String SEC_MNTN_REGION_10 = "39";

  public static final String SEC_MNTN_REGION_11 = "40";

  public static final String SEC_MNTN_REGION_12 = "41";

  public static final String SEC_MNTN_REGION_13 = "42";

  public static final String SEC_MNTN_REGION_14 = "43";

  public static final String SEC_MNTN_REGION_15 = "44";

  public static final String SEC_MNTN_REGION_16 = "45";

  public static final String SEC_MNTN_REGION_17 = "46";
  
  public static final String SEC_MNTN_REGION_99 = "47";
  
  public static final String SEC_SIGN_CNTRCT = "48";

  public static final String SEC_FIN_BROWSE_INVOICE = "49";

  public static final String SEC_FIN_MODIFY_INVOICE = "50";

  public static final String SEC_FIN_MODIFY_CPS_PAY_APPVL = "51";

  public static final String SEC_FIN_BROWSE_PAY_HIST = "52";

  public static final String SEC_MTN_HOME = "53";

  public static final String SEC_MTN_ADPT_SUB = "54";

  public static final String SEC_EMERG_PLCMT = "55";

  public static final String SEC_MNT_FA_HOME_HIST = "56";

  public static final String SEC_FAD_CONTRACT = "57";

  public static final String SEC_MNTN_SVC_AUTH = "58";

  public static final String SEC_ADOPT_ASSIST_SPEC = "59";

  public static final String SEC_MODIFY_COUNTY_BUDGET_LIMIT = "60";
  
  public static final String SEC_BROWSE_COUNTY_BUDGET_LIMIT = "61";

  public static final String SEC_RESUBMIT_TCM_CLAIMS = "62";

  public static final String SEC_ADO_VIEW = "63";

  public static final String SEC_SYS_ADMIN = "64";

  public static final String SEC_SHINES_STF = "65";

  public static final String SEC_CASE_MANAGER = "66";

  public static final String SEC_DJJ_AFCARS_SPCLST = "67";

  public static final String SEC_UNIT_TEAM_LEADER = "68";

  public static final String SEC_SUPERVISOR = "69";
  
  public static final String SEC_SS_ADMIN_STAFF = "70";

  public static final String SEC_DPTY_COUNTY_DIRECTOR = "71";

  public static final String SEC_MANAGEMENT = "72";

  public static final String SEC_REGIONAL_SS_STF = "73";

  public static final String SEC_REGIONAL_ACCNTNG_STF = "74";

  public static final String SEC_REGIONAL_ACCNTNG_MGMNT_STF = "75";

  public static final String SEC_REG_FAM_INDP_STF = "76";

  public static final String SEC_REG_FAM_INDP_MGMNT_STF = "77";

  public static final String SEC_STATE_OFFICE_CONSULTANT = "78";

  public static final String SEC_STATE_OFFICE_MGMNT = "79";

  public static final String SEC_FISCAL_SVC_STATE_STF = "80";

  public static final String SEC_PROVIDER_STF = "81";

  public static final String SEC_PROVIDER_MGMNT_STF = "82";
  
  public static final String SEC_MES_PROGRAM_ASSIST = "83";
  
  public static final String SEC_RSRC_DEVELOPER = "84";

  public static final String SEC_AUTH_TO_APPROVE = "85";
  
  //STGAP00006420: Added 86 & 87 to provide certain users special 
  //access to approved Placement, Payment of care and Eligibility pages.
  
  public static final String SEC_MODIFY_APPRV_PLCMT = "86";
  
  public static final String SEC_MODIFY_END_DATED_ELLIG = "87";
  
  public static final String SEC_ASSOCIATE_ORS_SHINES = "88";

  public static final String SEC_MODIFY_STATE_CPA_CONC = "89";
  
  public static final String SEC_SAU_SEALED = "90";
  
  public static final String SEC_SAU_EXCHANGE = "91";
  
  public static final String SEC_REGIONAL_ADO_COORDINATOR = "92";
  
  // STGAP00012833 : Added this security Attribute for Case Review
  public static final String SEC_DELETE_CASE_REVIEW = "93";
  
  // STGAP00012833 : Added this security Attribute for Case Review
  public static final String SEC_CASE_REVIEW = "94";
  
  // STGAP00014341 : Added this security Attribute for Stage Reopen
  public static final String SEC_STAGE_REOPEN = "95";
  
  //ECEM: Adding new attribute for vendor staff list access in SHINES
  public static final String SEC_VENDOR_STAFF_ACCESS = "96";
  
  // please note that the current max is 100 (hardcoded above)
  
  private static final Map<String, String> SEC_ATTR_REGIONS;

  static {
    String secAttrPrefix = "SEC_MNTN_REGION_";
    Map<String, String> secAttrRegions = new TreeMap<String, String>();
    String errorMsg = "UserProfile failed to initialize region security attributes.";
    try {
      Field[] fields = UserProfile.class.getFields();
      for (Field f : fields) {
        String name = f.getName();
        int mod = f.getModifiers();
        if (Modifier.isFinal(mod) && Modifier.isStatic(mod) && Modifier.isPublic(mod) &&
            name.startsWith(secAttrPrefix)) {
          String value = (String) f.get(null);
          secAttrRegions.put(value, name.substring(secAttrPrefix.length()));
        }
      }
    } catch (Exception e) {
      throw new IllegalStateException(errorMsg, e);
    }
    if (secAttrRegions.isEmpty()) {
      throw new IllegalStateException(errorMsg);
    }
    SEC_ATTR_REGIONS = Collections.unmodifiableMap(secAttrRegions);
  }

  // instance variables
  private String userLogonID;

  private int userID;

  private String userFullName;

  private String userRegion;

  private int userOfficeID;

  private String userOfficeCity;

  private String userUnit;

  private String userClass;

  private String userProgram;

  private String userCounty;

  private int[] rights;

  private List<TempAssignment> tempAssignments;

  private boolean bSuperAccess;

  /**
   * This method takes the castor object CARC01SO and call the appropriate get/set methods for the UserProfile class.
   *
   * @param carc01so Contains the user profile from tuxedo
   */
  public void setProfile(CARC01SO carc01so) {
    // Enable Performance Tracing
    PerformanceTrace performanceTrace = new PerformanceTrace("UserProfile", "setProfile");

    performanceTrace.enterScope();
    performanceTrace.getTotalTime();

    // Set methods for main profile information
    this.setUserLogonID(carc01so.getSzIdEmployeeLogon());
    this.setUserID(carc01so.getUlIdPerson());
    this.setUserFullName(carc01so.getSzNmPersonFull());
    this.setUserRegion(carc01so.getSzCdUnitRegion());
    this.setUserOfficeID(carc01so.getUlIdOffice());
    this.setUserOfficeCity(carc01so.getSzAddrMailCodeCity());
    this.setUserUnit(carc01so.getSzNbrUnit());
    this.setUserProgram(carc01so.getSzCdUnitProgram());
    this.setUserClass(carc01so.getSzCdEmployeeClass());
    this.setRights(carc01so.getSzTxtSecurityClassProfil());
    this.setUserCounty(carc01so.getSzCdUnitCounty());

    // Populate temporary assignments
    ROWCARC01SO_ARRAY rowcarc01soArray = carc01so.getROWCARC01SO_ARRAY();
    Enumeration tempAssignEnum = rowcarc01soArray.enumerateROWCARC01SO();
    List<TempAssignment> assignments = new ArrayList<TempAssignment>();

    while (tempAssignEnum.hasMoreElements()) {
      ROWCARC01SO rowcarc01so = (ROWCARC01SO) tempAssignEnum.nextElement();
      TempAssignment tempAssignment = new TempAssignment();
      tempAssignment.setTempDesignatorID(String.valueOf(rowcarc01so.getUlIdPerson()));
      tempAssignment.setTempFunction(rowcarc01so.getSzCdEmployeeClass());
      tempAssignment.setTempSecurityClass(rowcarc01so.getSzNmSecurityClass());
      assignments.add(tempAssignment);
    }
    this.setTempAssignments(assignments);
    performanceTrace.exitScope();
  }

  /**
   * This method sets the userID parameter
   *
   * @param userID Contains userID (12322313123132)
   */
  public void setUserID(int userID) {
    this.userID = userID;
  }

  /**
   * This method returns the userID
   *
   * @return The userID for the user
   */
  public int getUserID() {
    return this.userID;
  }

  /**
   * This method sets the userLogonID parameter
   *
   * @param userLogonID Contains the logon id (robertsw)
   */
  public void setUserLogonID(String userLogonID) {
    this.userLogonID = userLogonID;
  }

  /**
   * This method returns the userLogonID
   *
   * @return The userLogonID for the user
   */
  public String getUserLogonID() {
    return this.userLogonID;
  }

  /**
   * This method sets the userFullName parameter
   *
   * @param userFullName contains the name of the user (Roberts, Stephen W.)
   */
  public void setUserFullName(String userFullName) {
    this.userFullName = userFullName;
  }

  /**
   * This method returns the userFullName
   *
   * @return The userFullName for the user
   */
  public String getUserFullName() {
    return this.userFullName;
  }

  /**
   * This method sets the userFullName parameter
   *
   * @param userRegion contains the name of the user (Roberts, Stephen W.)
   */
  public void setUserRegion(String userRegion) {
    this.userRegion = userRegion;
  }

  /**
   * This method returns the userRegion
   *
   * @return The userRegion for the user
   */
  public String getUserRegion() {
    return this.userRegion;
  }

  /**
   * This method sets the userOfficeID parameter
   *
   * @param userOfficeID contains the office ID of the user (ex. 989899898673839393)
   */
  public void setUserOfficeID(int userOfficeID) {
    this.userOfficeID = userOfficeID;
  }

  /**
   * This method returns the userOfficeID
   *
   * @return The userOfficeID for the user
   */
  public int getUserOfficeID() {
    return this.userOfficeID;
  }

  /**
   * This method sets the userOfficeCity parameter
   *
   * @param userOfficeCity contains the city of the user (ex. Austin)
   */
  public void setUserOfficeCity(String userOfficeCity) {
    this.userOfficeCity = userOfficeCity;
  }

  /**
   * This method returns the userOfficeCity
   *
   * @return The userOfficeCity for the user
   */
  public String getUserOfficeCity() {
    return this.userOfficeCity;
  }

  /**
   * This method sets the userUnit parameter
   *
   * @param userUnit contains the unit of the user (ex. 22)
   */
  public void setUserUnit(String userUnit) {
    this.userUnit = userUnit;
  }

  /**
   * This method returns the userUnit
   *
   * @return The userUnit for the user
   */
  public String getUserUnit() {
    return this.userUnit;
  }

  /**
   * This method sets the userCounty parameter
   *
   * @param userProgram contains the program of the worker (ex. CPS)
   */
  public void setUserProgram(String userProgram) {
    this.userProgram = userProgram;
  }

  /**
   * This method returns the userProgram
   *
   * @return The userProgram for the user
   */
  public String getUserProgram() {
    return this.userProgram;
  }

  /**
   * This method sets the userCounty parameter
   *
   * @param userCounty contains the Georgia counties (ex. Cobb)
   */
  public void setUserCounty(String userCounty) {
    this.userCounty = userCounty;
  }

  /**
   * This method returns the userCounty
   *
   * @return The userCounty for the user
   */
  public String getUserCounty() {
    return this.userCounty;
  }

  /**
   * This method sets the userClass parameter
   *
   * @param userClass contains the type of user (ex. Intake Worker)
   */
  public void setUserClass(String userClass) {
    this.userClass = userClass;
  }

  /**
   * This method returns the userClass
   *
   * @return The userClass for the user
   */
  public String getUserClass() {
    return this.userClass;
  }

  /**
   * This method returns the rights
   *
   * @return The rights for the user
   */
  public int[] getRights() {
    return this.rights;
  }

  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   *
   * @param securityAttribute The right to check for on the user
   * @return boolean Whether or not the user has the right
   */
  public boolean hasRight(String securityAttribute) {
    try {
      int secAtt = Integer.parseInt(securityAttribute);
      return hasRight(secAtt);
    } catch (NullPointerException npe) {
      return false;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   *
   * @param securityAttribute The right to check for on the user
   * @return boolean Whether or not the user has the right
   */
  public boolean hasRight(int securityAttribute) {
    int[] userRights = this.getRights();
    if (userRights[securityAttribute] == 1) {
      return true;
    } else {
      return false;
    }
  }

  /**
   * This method assigns the SysSupervisorAccess from ccmn14s retrieved in Login conversation to the user
   *
   * @param bAccess
   */
  public void setSysSupervisorAccess(boolean bAccess) {
    this.bSuperAccess = bAccess;
  }

  /** This method retrieves the SysSupervisorAccess */
  public boolean getSysSupervisorAccess() {
    return this.bSuperAccess;
  }

  /**
   * This method allows a developer to assign rights to a user. This can only occur once, when the user is first
   * created.
   *
   * @param rights A set of rights for the user.
   */
  public void setRights(String rights) {
    // A.Corley - increased hardcoded size to 100 to match the length of the
    // TXT_SECURITY_CLASS_PROFIL column on the SECURITY_CLASS table
    int[] userRights = new int[MAX_NUM_ATTRIBUTES];
    char[] rightsArray = rights.toCharArray();

    for (int x = 0; x < rightsArray.length; x++) {
      // userRights[x]= Integer.parseInt(rightsArray[x]);
      if (rightsArray[x] == '1') {
        userRights[x] = 1;
      } else {
        userRights[x] = 0;
      }
    }

    this.rights = userRights;
  }

  protected void setRights(int[] rights) {
    GrndsTrace.enterScope(TRACE_TAG + ".setRights");
    this.rights = new int[rights.length];
    System.arraycopy(rights, 0, this.rights, 0, rights.length);
    GrndsTrace.exitScope();
  }

  // mdm made public because there was already one way to set a right,
  // but it was inconvenient and I needed it to make testing easier
  public void setRight(String securityAttribute, boolean value) throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".setRight");
    try {
      if (securityAttribute == null) {
        securityAttribute = "";
      }
      int secAtt = Integer.parseInt(securityAttribute);
      setRight(secAtt, value);
      GrndsTrace.exitScope();
    } catch (NumberFormatException nfe) {
      throw new InformationalPrsException(TRACE_TAG + ".setRight(): Invalid security attribute number: "
                                          + securityAttribute, nfe, 7);
    }
  }

  protected void setRight(int securityAttribute, boolean value) throws InformationalPrsException {
    try {
      GrndsTrace.enterScope(TRACE_TAG + ".setRight");
      this.rights[securityAttribute] = (value) ? 1 : 0;
      GrndsTrace.exitScope();
    } catch (ArrayIndexOutOfBoundsException oob) {
      throw new InformationalPrsException(TRACE_TAG + ".setRight(): Invalid security attribute number: "
                                          + securityAttribute, oob, 7);
    }
  }

  /**
   * This method allows a developer to set the temporary assignment for a user
   *
   * @param c A collection of Temp Assignment objects
   */
  public void setTempAssignments(Collection<TempAssignment> c) {
    this.tempAssignments = new ArrayList<TempAssignment>(c);
  }

  /**
   * This method returns a vector containing the temporary assignmetns
   *
   * @return Vector Vector containing rights
   */
  public List getTempAssignments() {
    return this.tempAssignments;
  }

  /**
   * This method allows a developer to add a temp assignment
   *
   * @param ta A TempAssignment object
   */
  public void addTempAssignment(TempAssignment ta) {
    this.tempAssignments.add(ta);
  }

  /**
   * This method allows a developer to set the temporary assignment for a user
   *
   * @param ta A collection of Temp Assignment objects
   */
  public void removeTempAssignment(TempAssignment ta) {
    this.tempAssignments.remove(ta);
  }

  /**
   * This method allows a developer to get the number of temporary assignments for a user
   *
   * @return int Integer indicating number of temporary assignments
   */
  public int getTempAssignQty() {
    if (this.tempAssignments == null) {
      return 0;
    } else {
      return this.tempAssignments.size();
    }
  }

  /**
   * This method returns a boolean indicating if the user has security rights for the region code passed in.
   *
   * @return boolean Returns true if the user has access to the region SR - Added 09/12/02
   */
  public boolean hasAccessToRegion(String region) {
    boolean hasAccess = false;
    StringBuffer u = new StringBuffer();
    u.append("SEC_MNTN_REGION_");
    u.append(region);

    Field maintainRegionField;
    Class c = this.getClass();
    int regionIndex = 0;
    try {
      maintainRegionField = c.getField(u.toString());
      GrndsTrace.msg(TRACE_TAG, 7, "maintainRegionField - " + maintainRegionField.toString());
      String regionField = (String) maintainRegionField.get(this);
      regionIndex = Integer.parseInt(regionField);
    } catch (SecurityException e) {
    } catch (NoSuchFieldException nsfe) {
    } catch (IllegalAccessException e) {
    }
    if ((regionIndex != 0) && this.hasRight(regionIndex)) {
      hasAccess = true;
    }
    return hasAccess;
  }

  /**
   * Use this method to get a list of all CREGIONS code values as <code>String</code>s that this user can maintain
   * per their security rights. Note that if there is no security attribute for a particular region in CREGIONS
   * that is prefixed with the name <code>SEC_MNTN_REGION_</code> in <code>UserProfile</code>, then that region
   * cannot be returned from this method.
   *
   * @return List of code values from CREGIONS that this user can maintain
   */
  public List<String> getUserMaintainedRegions() {
    List<String> userRegions = new ArrayList<String>();

    Set<String> keys = SEC_ATTR_REGIONS.keySet();
    for (String key : keys) {
      if (this.hasRight(key)) {
        userRegions.add(SEC_ATTR_REGIONS.get(key));
      }
    }

    return userRegions;
  }

  /**
   * Use this method to get a <code>Collection</code> of <code>CodeAttributes</code> objects representing all the
   * regions from CREGIONS that this user has security permissions to maintain. If you want the user's assigned region
   * to be included in the returned object, pass <code>true</code> as the argument. Otherwise the returned collection
   * will be only the security-permitted regions, but it will return a blank (not <code>null</code>)
   * <code>Collection</code> if the user cannot maintain any regions, assuming the argument passed is
   * <code>false</code>.
   *
   * @param mustIncludeUserRegion <code>boolean</code> value indicating whether to include the user's assigned region,
   *                              regardless of if they have maintainable access to that region
   * @return Collection of code-decode values that is meant to be used directly as the options attribute of a
   *         validateSelect tag
   */
  // -- I realize this is not the most efficient process, but I wanted to preserve the codes table order
  // -- with the user's region plugged in at the right spot.
  public Collection<CodeAttributes> getUserMaintainedRegionsAsOptions(boolean mustIncludeUserRegion) {
    List<CodeAttributes> options = new ArrayList<CodeAttributes>();
    String codeCategory = CodesTables.CREGIONS;
    List<CodeAttributes> allOptions = null;
    String userRegion = "";

    try {
      allOptions = Lookup.getCategoryCollection(codeCategory);
      userRegion = FormattingHelper.convertRegionCode(this.getUserRegion());
    } catch (LookupException le) {
      // -- how to handle exceptions?
    } catch (DataFormatException dfe) {
    }

    List<String> regions = this.getUserMaintainedRegions();
    if (allOptions != null) {
      for (Iterator<CodeAttributes> it = allOptions.iterator(); it.hasNext();) {
        CodeAttributes ca = it.next();
        if (regions.contains(ca.getCode()) || (userRegion.equalsIgnoreCase(ca.getCode()) && mustIncludeUserRegion)) {
          options.add(ca);
        }
      }
    }

    if (options.isEmpty() && mustIncludeUserRegion) {
      // -- in case a LookupException was thrown, add at least user's own region
      options.add(new CodeAttributes(codeCategory, userRegion, Lookup.simpleDecodeSafe(codeCategory, userRegion)));
    }

    return options;
  }

  /**
   * Fired when the user profile is bound to a session.
   *
   * @param event Unused
   */
  public void valueBound(HttpSessionBindingEvent event) {
    UsernameContextHolder.setUsername(userLogonID);
  }

  /**
   * Fired when the userprofile unbound from a session.
   *
   * @param event Unused
   */
  public void valueUnbound(HttpSessionBindingEvent event) {
    UsernameContextHolder.clearUsername();
  }
}
