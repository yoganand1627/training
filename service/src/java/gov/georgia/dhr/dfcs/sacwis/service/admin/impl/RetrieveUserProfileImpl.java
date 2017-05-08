package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmpTempAssignDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.EmpTempAssign;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveUserProfile;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01S1_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCARC01SO_ARRAY;

public class RetrieveUserProfileImpl extends BaseServiceImpl implements RetrieveUserProfile {

  private static final char LT_ZERO = '0';

  private static final char LT_ONE = '1';

  // SMS #116335: ECEM 5.0 Updated hardcoded to the constant variable
  private static final int TXT_SECURITY_CLASS_PROFIL_LEN = ArchitectureConstants.MAX_NUM_ATTRIBUTES;

  private EmployeeDAO employeeDAO = null;

  private EmpSecClassLinkDAO empSecClassLinkDAO = null;

  private EmpTempAssignDAO empTempAssignDAO = null;

  private PortalUserDAO portalUserDAO = null;

  private PortalUserSecClassLinkDAO portalUserSecClassLinkDAO = null;
  
  private PortalUserVendorLinkDAO portalUserVendorLinkDAO = null;

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setEmpSecClassLinkDAO(EmpSecClassLinkDAO empSecClassLinkDAO) {
    this.empSecClassLinkDAO = empSecClassLinkDAO;
  }

  public void setEmpTempAssignDAO(EmpTempAssignDAO empTempAssignDAO) {
    this.empTempAssignDAO = empTempAssignDAO;
  }

  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }

  public void setPortalUserSecClassLinkDAO(PortalUserSecClassLinkDAO portalUserSecClassLinkDAO) {
    this.portalUserSecClassLinkDAO = portalUserSecClassLinkDAO;
  }

  public void setPortalUserVendorLinkDAO(PortalUserVendorLinkDAO portalUserVendorLinkDAO) {
    this.portalUserVendorLinkDAO = portalUserVendorLinkDAO;
  }

  public CARC01SO retrieveUserProfile(CARC01SI carc01si) throws ServiceException {
    String szIdEmployeeLogon = carc01si.getSzIdEmployeeLogon();
    // Retrieve basic information about the user.
    // carc01d
    CARC01SO carc01so = new CARC01SO();

    // This will construct a single user security class profile from the list of security classes assigned to the
    // user. Along with compiling the user's security classes, it will also merge the combined user's profile with the
    // security classes of staff for which the user is assigned as a designee. It will also be used to retrieve
    // the current users profile
    // Adding if logic to check to get the Portal User Profile Information
    List<Map> empSecClassLink = null;
    if (null == carc01si.getBIndLoginPersonType()
        || (carc01si.getBIndLoginPersonType() != null && (carc01si.getBIndLoginPersonType().equals("S") 
                        || carc01si.getBIndLoginPersonType().trim().length() == 0))) {
      // Get Shines User and Profile Information
      carc01so = getUserInformation(szIdEmployeeLogon);
      empSecClassLink = getUserProfileInformation(carc01so.getUlIdPerson());
      // Updates the EMPLOYEE table with the date that an employee last logged into CAPS.
      // caude5d
      if (employeeDAO.updateEmployeeDtLastLogon(szIdEmployeeLogon, new Date()) == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    } else if (carc01si.getBIndLoginPersonType() != null && carc01si.getBIndLoginPersonType().equals("P")) {
      // Get Portal User and Profile Information
      carc01so = getPortalUserInformation(szIdEmployeeLogon);
      empSecClassLink = getPortalUserProfileInformation(carc01so.getUlIdPerson());
    }
    // TODO
    // MIGHT NEED THIS LINE FOR R2 IF WE NEED CASE MANAGERS TO BE ABLE TO SEE ONCALLEMPLOYEEDETAIL PAGE IN VIEW MODE
    // carc01so.setCdSecurityClassName((String) empSecClassLink.get((empSecClassLink.size() -
    // 1)).get("cdSecurityClassName"));

    // Use a fast trick to create the the all-zeros profile
    char[] txtSecClassProf = new char[TXT_SECURITY_CLASS_PROFIL_LEN];
    Arrays.fill(txtSecClassProf, LT_ZERO);

    // Consolidate an employee's multiple profile (loop #1)
    mergeSecurityAttributes(empSecClassLink, txtSecClassProf);

    // Retrieve any current temporary assignments held by the current user.
    // Retrive the IDs of the current user's temporary assignments.
    // The retrieveTempAssignments updates txtSecClassProf with information from the temporary assignments.
    // carc06d
    carc01so.setROWCARC01SO_ARRAY(retrieveTempAssignments(carc01so.getUlIdPerson(), txtSecClassProf));

    // Set the generated profile into the output.
    carc01so.setSzTxtSecurityClassProfil(new String(txtSecClassProf));


    return carc01so;
  }

  private CARC01SO getUserInformation(String szIdEmployeeLogon) {
    CARC01SO carc01so = new CARC01SO();
    // Retrieves a current user's Security Profile based on their logon id.
    // carc01d
    Map employeeMap = employeeDAO.findEmployeeLogonDetailByIdEmployeeLogon(szIdEmployeeLogon);
    if (employeeMap == null) {
      throw new ServiceException(Messages.MSG_CMN_NOT_CAPS_USER);
    }
    carc01so.setSzIdEmployeeLogon((String) employeeMap.get("idEmployeeLogon"));
    carc01so.setUlIdPerson((Integer) employeeMap.get("idPerson") != null ? (Integer) employeeMap.get("idPerson") : 0);
    carc01so.setSzNmPersonFull((String) employeeMap.get("nmPersonFull"));
    carc01so.setSzCdUnitRegion((String) employeeMap.get("cdUnitRegion"));
    carc01so.setSzAddrMailCodeCity((String) employeeMap.get("addrMailCodeCity"));
    carc01so.setUlIdOffice((Integer) employeeMap.get("idOffice") != null ? (Integer) employeeMap.get("idOffice") : 0);
    carc01so.setSzNbrUnit((String) employeeMap.get("nbrUnit"));
    carc01so.setSzCdUnitProgram((String) employeeMap.get("cdUnitProgram"));
    carc01so.setSzCdEmployeeClass((String) employeeMap.get("cdEmployeeClass"));
    carc01so.setSzCdUnitCounty((String) employeeMap.get("cdCounty"));
    return carc01so;
  }

  private ROWCARC01SO_ARRAY retrieveTempAssignments(int idPerson, char[] txtSecClassProf) {
    List<EmpTempAssign> empTempAssign = empTempAssignDAO.findIdsTempAssignment(idPerson);
    ROWCARC01SO_ARRAY rowcarc01so_array = new ROWCARC01SO_ARRAY();
    // No temp assignments is not an error.
    if (empTempAssign == null) {
      return rowcarc01so_array;
    }
    for (Iterator<EmpTempAssign> itInfo = empTempAssign.iterator(); itInfo.hasNext();) {
      EmpTempAssign empTempAssignInfo = itInfo.next();
      ROWCARC01SO rowcarc01so = new ROWCARC01SO();
      int idTempAssignInfo = empTempAssignInfo.getPersonByIdPersonEmp().getIdPerson();
      rowcarc01so.setUlIdPerson(idTempAssignInfo);
      rowcarc01so.setDtTempAssignExpir(DateHelper.toCastorDate(empTempAssignInfo.getDtAssignExpiration()));
      rowcarc01so_array.addROWCARC01SO(rowcarc01so);
      // If any assignees were found, call the same DAM again, once for every assignee
      // and construct the user's profile string accordingly
      // clscb4d
      List<Map> empSecClassLink = empSecClassLinkDAO
                                                    .findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idTempAssignInfo);
      if (empSecClassLink != null && !empSecClassLink.isEmpty()) {
        // Loop #2 consolidate assignee profiles
        mergeSecurityAttributes(empSecClassLink, txtSecClassProf);
      }
    }
    return rowcarc01so_array;
  }

  private List<Map> getUserProfileInformation(int idPerson) {
    // Call to retrieve all of the logged in user's security and profiles
    // clscb4d
    List<Map> empSecClassLink = empSecClassLinkDAO
                                                  .findEmpSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    if (empSecClassLink.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_NOT_CAPS_USER);
    }
    return empSecClassLink;
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

  private CARC01SO getPortalUserInformation(String szIdEmployeeLogon) {
    CARC01SO carc01so = new CARC01SO();
    // Retrieves a current user's Security Profile based on their logon id.
    // carc01d
    PortalUser portalUser = portalUserDAO.findPortalUserbyLoginEmailId(szIdEmployeeLogon);

    if (portalUser == null) {
      throw new ServiceException(Messages.MSG_CMN_NOT_CAPS_USER);
    }
    
    carc01so.setSzIdEmployeeLogon((String) portalUser.getTxtUserEmail());
    carc01so.setUlIdPerson((Integer) portalUser.getIdUser() != null ? (Integer) portalUser.getIdUser() : 0);
    ROWCARC01S1_ARRAY rowcarc01s1_array = retrieveResourceRoles(carc01so.getUlIdPerson());
    carc01so.setSzNmPersonFull((String) portalUser.getNmUserFull());
    carc01so.setROWCARC01S1_ARRAY(rowcarc01s1_array);
    return carc01so;
  }

  private List<Map> getPortalUserProfileInformation(int idPerson) {
    // Call to retrieve all of the logged in user's security and profiles
    // clscb4d
    List<Map> portalUserSecClassLink = portalUserSecClassLinkDAO
                                                                .findPortalUserSecClassLinkCdSecurityClassNameAndTxtSecurityClassProfil(idPerson);
    if (portalUserSecClassLink.isEmpty()) {
      throw new ServiceException(Messages.MSG_CMN_NOT_CAPS_USER);
    }
    return portalUserSecClassLink;
  }
  
  private ROWCARC01S1_ARRAY retrieveResourceRoles(int idUser) {
    ROWCARC01S1_ARRAY rowcarc01s1_array = new ROWCARC01S1_ARRAY();
    List<PortalUserVendorLink> portalUsrVndrLnkList = portalUserVendorLinkDAO.findPortalUserVendorLinkbyIdUser(idUser);
    if (portalUsrVndrLnkList != null) {
      for (int i=0; i < portalUsrVndrLnkList.size(); i++){
        PortalUserVendorLink portalUserVendorLink = portalUsrVndrLnkList.get(i);
        if (portalUserVendorLink != null){
          ROWCARC01S1 rowcarc01s1 = new ROWCARC01S1();
          rowcarc01s1.setUlIdResource(portalUserVendorLink.getCapsResource().getIdResource());
          rowcarc01s1.setSzCdAccessType(portalUserVendorLink.getCdAccessType());
          rowcarc01s1_array.addROWCARC01S1(rowcarc01s1);
        }
      }
    }
    return rowcarc01s1_array;
  }
}
