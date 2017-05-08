package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.service.common.CheckIfUserHasRight;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CheckIfUserHasRightImpl extends BaseServiceImpl implements CheckIfUserHasRight{
	
  private static final char LT_ZERO = '0';
  private static final char LT_ONE = '1';
  // SMS #116335: ECEM 5.0 Updated hardcoded to the constant variable
  private static final int TXT_SECURITY_CLASS_PROFIL_LEN = ArchitectureConstants.MAX_NUM_ATTRIBUTES;
  private EmpSecClassLinkDAO empSecClassLinkDAO = null;
  private EmpTempAssignDAO empTempAssignDAO = null;
  
   public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }
 //anyone with this attribute or anyone who is a designee of someone with this attribute should be allowed to be selected for approval.  

  public boolean determineIfUserHasRight(int idPerson, String securityAttribute) {
    boolean userHasRight = false;
    int[] rights;

    List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);

    // Use a fast trick to create the the all-zeros profile
    char[] txtSecClassProf = new char[TXT_SECURITY_CLASS_PROFIL_LEN];
    Arrays.fill(txtSecClassProf, LT_ZERO);

    // Consolidate an employee's multiple profile (loop #1)
    mergeSecurityAttributes(securityProfileList, txtSecClassProf);

    // Retrieve any current temporary assignments held by the current user.
    // Retrive the IDs of the current user's temporary assignments.
    // The retrieveTempAssignments updates txtSecClassProf with information from the temporary assignments.
    // carc06d
    retrieveTempAssignments(idPerson, txtSecClassProf);
    rights = setRights(String.valueOf(txtSecClassProf));
    // check for attribute that would indicate if the Person has Passed in Attribute
    userHasRight = hasRight(securityAttribute, rights);
    return userHasRight;
  }
  /**
   * This method returns user's security attributes
   * @param idPerson
   * @param securityAttribute
   * @return array of 0s and 1s, each position is an security attribute - 
   * 0 means user does not have that security attribute 
   * 1 means user is granted that clearance 
   */
  public int[] retrieveUserRights(int idPerson) {
    int[] rights;

    List<Map> securityProfileList = retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);

    // Use a fast trick to create the the all-zeros profile
    char[] txtSecClassProf = new char[TXT_SECURITY_CLASS_PROFIL_LEN];
    Arrays.fill(txtSecClassProf, LT_ZERO);

    // Consolidate an employee's multiple profile (loop #1)
    mergeSecurityAttributes(securityProfileList, txtSecClassProf);

    // Retrieve any current temporary assignments held by the current user.
    // Retrieve the IDs of the current user's temporary assignments.
    // The retrieveTempAssignments updates txtSecClassProf with information from the temporary assignments.
    // carc06d
    retrieveTempAssignments(idPerson, txtSecClassProf);
    rights = setRights(String.valueOf(txtSecClassProf));
    return rights;
  }
  
  public List<Map> retrieveEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(int idPerson){
    List<Map> securityMap = empSecClassLinkDAO.findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    return securityMap;
  }
  
  @SuppressWarnings({"unchecked"})
  private List<EmpTempAssign> retrieveTempAssignments(int idPerson, char[] txtSecClassProf) {
    List<EmpTempAssign> empTempAssign = empTempAssignDAO.findIdsTempAssignment(idPerson);
    // No temp assignments is not an error.
    if (empTempAssign == null) {
      return new ArrayList();
    }
    for (Iterator<EmpTempAssign> itInfo = empTempAssign.iterator(); itInfo.hasNext();) {
      EmpTempAssign empTempAssignInfo = itInfo.next();
      int idTempAssignInfo = empTempAssignInfo.getPersonByIdPersonEmp().getIdPerson();
      // If any assignees were found, call the same DAO again, once for every assignee
      // and construct the user's profile string accordingly
      // clscb4d
      List<Map> empSecClassLink = empSecClassLinkDAO
                                                    .findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idTempAssignInfo);
      if (empSecClassLink != null && !empSecClassLink.isEmpty()) {
        // Loop #2 consolidate assignee profiles
        mergeSecurityAttributes(empSecClassLink, txtSecClassProf);
      }
    }
    return empTempAssign;
  }
  
  private void mergeSecurityAttributes(List<Map> empSecClassLink, char[] txtSecClassProf) {
    for (Iterator<Map> it = empSecClassLink.iterator(); it.hasNext();) {
      Map empSecClassLinkMap = it.next();
      String txtSecurityClassProfil = (String) empSecClassLinkMap.get("txtSecurityClassProfil");
      // for each character in the profile string
      for (int j = 0; j < txtSecurityClassProfil.length() && j < txtSecClassProf.length; j++) {
        if (LT_ONE == txtSecurityClassProfil.charAt(j)) {
          txtSecClassProf[j] = LT_ONE;
        }
      }
    }
  }
  
  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   * 
   * @param securityAttribute
   *          The right to check for on the user
   * @param userRights
   *          The array of attributes that makes a person's profile
   * @return boolean Whether or not the user has the right
   */
  public boolean hasRight(String securityAttribute, int[] rights) {
    try {
      int secAtt = Integer.parseInt(securityAttribute);
      return hasRight(secAtt, rights);
    } catch (NullPointerException npe) {
      return false;
    } catch (NumberFormatException nfe) {
      return false;
    }
  }

  /**
   * This method returns a boolean value indicating whether or not the user has the right that was passed in.
   * 
   * @param securityAttribute
   *          The right to check for on the user
   * @param userRights 
   *          The array of attributes that makes a person's profile        
   * @return boolean Whether or not the user has the right
   */
  public boolean hasRight(int securityAttribute, int[] userRights) {
    if (userRights[securityAttribute] == 1) {
      return true;
    } else {
      return false;
    }
  }
  
  /**
   * This method allows a developer to assign rights to a user. This can only occur once, when the user is first
   * created.
   * 
   * @param rights
   *          A set of rights for the user.
   */
  public int[] setRights(String rights) {
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

    return userRights;
  }

}
