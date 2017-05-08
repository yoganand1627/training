package gov.georgia.dhr.dfcs.sacwis.web.core.user;

// GRNDS Classes

import org.grnds.facility.log.GrndsTrace;

import gov.georgia.dhr.dfcs.sacwis.core.exception.InformationalPrsException;

/**
 * <p>Title: </p> <p>Description: </p> <p>Copyright: Copyright (c) 2002</p> <p>Company: </p>
 *
 * @author unascribed
 * @version 1.0
 */

public class SettableUserProfile extends UserProfile {
  public static String TRACE_TAG = "SettableUserProfile";

  public SettableUserProfile() {
    super();
  }

  public SettableUserProfile(UserProfile profile) {
    this();
    this.setRights(profile.getRights());
    this.setTempAssignments(profile.getTempAssignments());
    this.setUserClass(profile.getUserClass());
    this.setUserFullName(profile.getUserFullName());
    this.setUserID(profile.getUserID());
    this.setUserLogonID(profile.getUserLogonID());
    this.setUserOfficeCity(profile.getUserOfficeCity());
    this.setUserOfficeID(profile.getUserOfficeID());
    this.setUserProgram(profile.getUserProgram());
    this.setUserRegion(profile.getUserRegion());
    this.setUserUnit(profile.getUserUnit());
  }

  public void grantRight(String securityAttribute)
          throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".grantRight");
    try {
      if (securityAttribute == null) {
        securityAttribute = "";
      }
      int secAtt = Integer.parseInt(securityAttribute);
      grantRight(secAtt);
      GrndsTrace.exitScope();
    }
    catch (NumberFormatException nfe) {
      throw new InformationalPrsException(TRACE_TAG + ".grantRight(): " +
                                          "Invalid security attribute number: " +
                                          securityAttribute, nfe, 7);
    }
  }

  public void grantRight(int securityAttribute)
          throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".grantRight");
    this.setRight(securityAttribute, true);
    GrndsTrace.exitScope();
  }

  public void revokeRight(String securityAttribute)
          throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".revokeRight");
    try {
      if (securityAttribute == null) {
        securityAttribute = "";
      }
      int secAtt = Integer.parseInt(securityAttribute);
      revokeRight(secAtt);
      GrndsTrace.exitScope();
    }
    catch (NumberFormatException nfe) {
      throw new InformationalPrsException(TRACE_TAG + ".revokeRight(): " +
                                          "Invalid security attribute number: " +
                                          securityAttribute, nfe, 7);
    }

  }

  public void revokeRight(int securityAttribute)
          throws InformationalPrsException {
    GrndsTrace.enterScope(TRACE_TAG + ".revokeRight");
    this.setRight(securityAttribute, false);
    GrndsTrace.exitScope();
  }

}