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
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
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
 *  08/17/2010 htvo		Added NYTD user security attribute. This is the user that is also a person (client) in SHINES.
 */
@SuppressWarnings("serial")
public class UserProfile implements HttpSessionBindingListener, Serializable {

  public static final String TRACE_TAG = "UserProfile";

  public static final int MAX_NUM_ATTRIBUTES = 200;

  // Release 1 SHINES
  public static final String PLCMNT_PRV_ADMIN = "0";

  public static final String PLCMNT_PRV_USRER = "1";
  
  public static final String NYTD_USER = "2"; // Hai

    // please note that the current max is 100 (hardcoded above)
  
 // private static final Map<String, String> SEC_ATTR_REGIONS;

  /*static {
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
  }*/

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

  private Map<Integer, String> rsrcMap;

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
    
    // Populate temporary assignments
    ROWCARC01S1_ARRAY rowcarc01s1Array = carc01so.getROWCARC01S1_ARRAY();
    Enumeration<ROWCARC01S1> rsrcArryEnum = rowcarc01s1Array.enumerateROWCARC01S1();
    Map<Integer, String> rsrcMap = new HashMap<Integer, String>();
    while (rsrcArryEnum.hasMoreElements()) {
      ROWCARC01S1 rowcarc01s1 = (ROWCARC01S1) rsrcArryEnum.nextElement();
      rsrcMap.put(new Integer(rowcarc01s1.getUlIdResource()), rowcarc01s1.getSzCdAccessType());
    }
    this.setRsrcMap(rsrcMap);
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

    /*Set<String> keys = SEC_ATTR_REGIONS.keySet();
    for (String key : keys) {
      if (this.hasRight(key)) {
        userRegions.add(SEC_ATTR_REGIONS.get(key));
      }
    }*/

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
  /**
   * Get the Resource Map
   * @return
   */
  public Map<Integer, String> getRsrcMap() {
    return rsrcMap;
  }
  /**
   * Set the Resource Map
   * @param rsrcMap
   */
  public void setRsrcMap(Map<Integer, String> rsrcMap) {
    this.rsrcMap = rsrcMap;
  }
  
  
}
