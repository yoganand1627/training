package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.NytdHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.FormattingHelper;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexPortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.EmployeeDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalLoginAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalSecurityClassDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserSecClassLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkAuditDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YouthReportDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NytdBaseFollowUpLookupDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.NytdRandomDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.YrppLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PersonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Employee;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.PortalSecurityClass;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserSecClassLink;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserVendorLink;
import gov.georgia.dhr.dfcs.sacwis.db.YrppLink;
import gov.georgia.dhr.dfcs.sacwis.service.admin.SaveVendorStaffDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.SaveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.SaveVendorStaffDetailSO;

/**
 * 
 * <pre>
 *   Change History:
 *   Date      User      Description
 *   --------  --------  --------------------------------------------------
 *   09/17/10  hnguyen   SMS#66384 Added Change History. Removed unused imports 
 *                       and private method already implemented in NytdHelper
 *                       
*/

public class SaveVendorStaffDetailImpl extends BaseServiceImpl implements SaveVendorStaffDetail {
  ComplexPortalUserDAO complexPortalUserDAO;
  CapsResourceDAO capsResourceDAO;
  PortalLoginAuditDAO portalLoginAuditDAO;
  PortalUserDAO portalUserDAO;
  PortalUserDtlDAO portalUserDtlDAO;  
  PortalUserAuditDAO portalUserAuditDAO;
  PortalUserVendorLinkDAO portalUserVendorLinkDAO;
  PortalUserVendorLinkAuditDAO portalUserVendorLinkAuditDAO;
  PortalUserSecClassLinkDAO portalUserSecClassLinkDAO;
  PortalSecurityClassDAO portalSecurityClassDAO;
  EmployeeDAO employeeDAO;
  YrppLinkDAO yrppLinkDAO;
  PersonDAO personDAO;
  
  private static final String SAVE_PORTAL_REGISTRATION = "SAVE_PORTAL_REGISTRATION";
  private static final String SAVE_VENDOR_STAFF_DETAIL = "SAVE_VENDOR_STAFF_DETAIL";
  private static final String PASSWORD_RESET_STAFF_DETAIL = "PASSWORD_RESET_STAFF_DETAIL";
  private static final String APPROVE_VENDOR_STAFF_DETAIL = "APPROVE_VENDOR_STAFF_DETAIL";
  private static final String DISAPPROVE_VENDOR_STAFF_DETAIL = "DISAPPROVE_VENDOR_STAFF_DETAIL";
  private static final String DELETE_VENDOR_STAFF_DETAIL = "DELETE_VENDOR_STAFF_DETAIL";
  private static final String UPDATE = "UPDATE";
  private static final String INSERT = "INSERT";
  private static final String PLCMNT_PRV_ADMN = "PLCMNT_PRV_ADMN";
  private static final String PLCMNT_PRV_USER = "PLCMNT_PRV_USER";
  private static final String PORTAL_SYSTEM = "PORTAL_SYSTEM";
  private static final String SEC_VENDOR_STAFF_ACCESS = "SEC_VENDOR_STAFF_ACCESS";
  private static final String SHINES_SYSTEM = "SHINES_SYSTEM";
  //Same as in the UserProfile.java
  private final static String PLCMNT_PRV_ADMIN = "0";
  private final static String PLCMNT_PRV_USRER = "1";
  // SMS #66384: MR-067
  private final static String NYTD_USER = "2";
  
  private static final String POPULATION_TYPE_SERVED = "S";

  private static final String POPULATION_TYPE_BASELINE = "B";

  private static final String POPULATION_TYPE_FOLLOW_UP = "F";
  
  public void setPortalLoginAuditDAO(PortalLoginAuditDAO portalLoginAuditDAO) {
    this.portalLoginAuditDAO = portalLoginAuditDAO;
  }

  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }

  public void setPortalUserDtlDAO(PortalUserDtlDAO portalUserDtlDAO) {
    this.portalUserDtlDAO = portalUserDtlDAO;
  }  

  public void setPortalUserAuditDAO(PortalUserAuditDAO portalUserAuditDAO) {
    this.portalUserAuditDAO = portalUserAuditDAO;
  }

  public void setPortalUserVendorLinkAuditDAO(PortalUserVendorLinkAuditDAO portalUserVendorLinkAuditDAO) {
    this.portalUserVendorLinkAuditDAO = portalUserVendorLinkAuditDAO;
  }

  public void setComplexPortalUserDAO(ComplexPortalUserDAO complexPortalUserDAO) {
    this.complexPortalUserDAO = complexPortalUserDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setEmployeeDAO(EmployeeDAO employeeDAO) {
    this.employeeDAO = employeeDAO;
  }

  public void setPortalUserVendorLinkDAO(PortalUserVendorLinkDAO portalUserVendorLinkDAO) {
    this.portalUserVendorLinkDAO = portalUserVendorLinkDAO;
  }

  public void setPortalUserSecClassLinkDAO(PortalUserSecClassLinkDAO portalUserSecClassLinkDAO) {
    this.portalUserSecClassLinkDAO = portalUserSecClassLinkDAO;
  }

  public void setPortalSecurityClassDAO(PortalSecurityClassDAO portalSecurityClassDAO) {
    this.portalSecurityClassDAO = portalSecurityClassDAO;
  }

  public void setYrppLinkDAO(YrppLinkDAO yrppLinkDAO) {
    this.yrppLinkDAO = yrppLinkDAO;
  }
  
  public void setPersonDAO(PersonDAO personDAO) {
    this.personDAO = personDAO;
  }
  
  public SaveVendorStaffDetailSO saveVendorStaffDetail(SaveVendorStaffDetailSI saveVendorStaffDetailSI) {
    // TODO Auto-generated method stub
    SaveVendorStaffDetailSO saveVendorStaffDetailSO = new SaveVendorStaffDetailSO();
    //save Portal Registration Information as a new Portal User and Portal User
    //vendor link data
    if (saveVendorStaffDetailSI.getSavePage().equals(SAVE_PORTAL_REGISTRATION)){
      PortalUser portalUser = new PortalUser();
      PortalUserVendorLink portalUserVendorLink = null;
      //Set Basic and Common data by passing a new Portal User object
      setBasicAndCommonData(portalUser, saveVendorStaffDetailSI);
      //User Agreement
      portalUser.setIndUserAgreement(saveVendorStaffDetailSI.getIndUserAgreement());
      portalUser.setTxtOther(saveVendorStaffDetailSI.getTxtOther());
      portalUser.setCdQuestion1(saveVendorStaffDetailSI.getCdQuestion1());
      portalUser.setCdQuestion2(saveVendorStaffDetailSI.getCdQuestion2());
      portalUser.setCdQuestion3(saveVendorStaffDetailSI.getCdQuestion3());
  
      portalUser.setDtLastPasswdReset(saveVendorStaffDetailSI.getDtLastPasswdReset());
      portalUser.setNbrFailedLoginAttempts(saveVendorStaffDetailSI.getNbrFailedLoginAttempts());
      //Update the Security Answers after saving the Portal User first.
      String txtSecAns1 = saveVendorStaffDetailSI.getTxtAnswer1();
      String txtSecAns2 = saveVendorStaffDetailSI.getTxtAnswer2();
      String txtSecAns3 = saveVendorStaffDetailSI.getTxtAnswer3();
      String txtPassword = saveVendorStaffDetailSI.getTxtPassword();
      //Save the initial status as Pending
      portalUser.setCdStatus(CodesTables.CUSRSTAT_PEN);
      //Validation is already in place for Access Request Section in the Custom Validation
      //After passing the validation if the request type is Administrator and if the user
      //typed Other then Portal User Vendor Link row should not be inserted.
      Integer idResource = 0;
      try{
        idResource = Integer.parseInt(saveVendorStaffDetailSI.getIdResource());
      }catch (NumberFormatException nfe){
        idResource = 0;
      }
      //Insert into both Portal User and Portal User Vendor Link table if ID Resource is selected 
      if (idResource != 0){
        //Load Portal User Vendor Link Information
        portalUserVendorLink = new PortalUserVendorLink();
        CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
        portalUserVendorLink.setCapsResource(capsResource);
        portalUserVendorLink.setCdAccessType(saveVendorStaffDetailSI.getCdUserType());
        portalUserVendorLink.setCdStatus(CodesTables.CUSRSTAT_PEN);
        complexPortalUserDAO.savePortalUserAndPortalUserVendorLink(portalUser, portalUserVendorLink, 
                                                                   txtSecAns1, txtSecAns2, 
                                                                   txtSecAns3, txtPassword);      
      }else{
        //Insert into only Portal User table if ID Resource is not selected
        complexPortalUserDAO.savePortalUserAndPortalUserVendorLink(portalUser, 
                                                                   txtSecAns1, txtSecAns2, 
                                                                   txtSecAns3, txtPassword);      
      }
    }else if(saveVendorStaffDetailSI.getSavePage().equals(SAVE_VENDOR_STAFF_DETAIL)||
                    saveVendorStaffDetailSI.getSavePage().equals(APPROVE_VENDOR_STAFF_DETAIL)){
      /*
       * Save the portal User and Portal User Vendor Link information from the Vendor
       * Staff Detail page
       * First find the existing Portal user data for updating 
       */
      Integer idUser = saveVendorStaffDetailSI.getIdUser();
      PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(idUser);
      //Set Basic and Common data by passing a new Portal User object
      if (portalUser != null){
        setBasicAndCommonData(portalUser, saveVendorStaffDetailSI);
        //Admin Agreement
        portalUser.setIndAdminAgreement(saveVendorStaffDetailSI.getIndUserAgreement());
        //Set Security Question Information if the User Access Type is User
        if (PLCMNT_PRV_USRER.equals(saveVendorStaffDetailSI.getUserAccessType()) ||
                        NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType()) ||
                        (PLCMNT_PRV_ADMIN.equals(saveVendorStaffDetailSI.getUserAccessType()) &&
                        saveVendorStaffDetailSI.getIdUser().equals(saveVendorStaffDetailSI.getLoggedInUser()))) {
          portalUser.setCdQuestion1(saveVendorStaffDetailSI.getCdQuestion1());
          portalUser.setCdQuestion2(saveVendorStaffDetailSI.getCdQuestion2());
          portalUser.setCdQuestion3(saveVendorStaffDetailSI.getCdQuestion3());
          // Set indicator for temporary password if the User Access Type is NYTD User
          if (NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType())) {
            // Set the temporary password indicator to No
            portalUser.setIndPasswdTemp(ArchitectureConstants.N);
          }
        }
          //Save Portal User Data
          portalUserDAO.savePortalUser(portalUser);
      }
      // SMS #66384: MR-067 Save the Portal User Dtl information from the NYTD User
      if (NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType())) {
        PortalUserDtl portalUserDtl = portalUserDtlDAO.findPortalUserbyIdUser(saveVendorStaffDetailSI.getIdUser());
        // Set Basic and Common data by passing a new Portal User Dtl object
        if (portalUserDtl != null) {
          setDtlData(portalUserDtl, saveVendorStaffDetailSI);
          // Get the DOB of NYTD User
          Date nytdDOB = portalUserDtl.getPerson().getDtPersonBirth();
          // Get the Person ID of NYTD User
          Integer idPersonPortalUser = portalUserDtl.getPerson().getIdPerson();
          // Get the Reporting Period end date
          Date reportingPrEndDate = NytdHelper.getDtRptPeriodEnd();
          // Check NYTD User is currently in Survey Period
          Boolean isInSurvey = NytdHelper.isDuringSurveyPeriod(nytdDOB);
          // Get the Population category
          Person person = personDAO.findPersonByIdPerson(idPersonPortalUser);
          String cdPopulationType = NytdHelper.getPopulationType(person.getIdPerson(),nytdDOB, reportingPrEndDate);
          List<YrppLink> yrppLinkByIdUser = yrppLinkDAO.findYrppLinkByIdUser(idUser);
          if ((isInSurvey) && (POPULATION_TYPE_BASELINE.equals(cdPopulationType) ||
                          POPULATION_TYPE_FOLLOW_UP.equals(cdPopulationType))) {
            // Check NYTD Survey is complete
            Boolean isSurveyCompl = false;
            if (yrppLinkByIdUser != null) {
              for (Iterator<YrppLink> it = yrppLinkByIdUser.iterator(); it.hasNext();) {
                YrppLink yrppLink = it.next();
                int reportYear = DateHelper.getYear(reportingPrEndDate); 
                if (yrppLink.getYouthReportDtl() != null) {
                  int yrdYear = DateHelper.getYear(yrppLink.getYouthReportDtl().getDtRptPeriodEnd());                
                  if (reportYear == yrdYear) {
                    isSurveyCompl = StringHelper.toBooleanSafe(yrppLink.getIndNytdSurveyComplete());
                  }
                }
              }
            }
            // Set two flags for checking Survey Period and Survey completion
            saveVendorStaffDetailSO.setSurveyComplete(isSurveyCompl);
            saveVendorStaffDetailSO.setInSurveyPeriod(isInSurvey);
          }  
          else {
            // The User is not in the Population
            // Set two flags to FALSE
            saveVendorStaffDetailSO.setSurveyComplete(false);
            saveVendorStaffDetailSO.setInSurveyPeriod(false);
          }
        }    
      }
      //Insert or Update the Portal User Vendor Link only if the User Access Type is Admin
      if ((saveVendorStaffDetailSI.getUserAccessType().equals(PLCMNT_PRV_ADMIN)&&
               !saveVendorStaffDetailSI.getIdUser().equals(saveVendorStaffDetailSI.getLoggedInUser())) ||
                      saveVendorStaffDetailSI.getUserAccessType().equals(SEC_VENDOR_STAFF_ACCESS)){
        Integer idResource = 0;
        try{
          idResource = Integer.parseInt(saveVendorStaffDetailSI.getIdResource());
        }catch (NumberFormatException nfe){
          idResource = 0;
        }
        //Find the Portal User Vendor Link data for the idUser and idResource if the CRUD Flag is Update
        //else Insert a new row in Portal User Vendor Link
        if (idResource != 0){
          //If the CRUD Flag is Not UDPATE then we are inserting a new row for Portal User Vendor Link
          PortalUserVendorLink puvl = null;
          if (saveVendorStaffDetailSI.getCrudFlag().equals(UPDATE)){
            puvl = portalUserVendorLinkDAO.
                          findPortalUserVendorLinkByIdUserAndIdResource(idUser, idResource);
          }
          if (puvl != null){
            //Found Portal User Vendor Link object and setting the object with
            //new data such as access type, status, start date and end date
            //are updated
            setPortalUserVendorLinkData(puvl, saveVendorStaffDetailSI);
          }else{
            //No record found for the given idUser and idResource. 
            //Inserting new PortalUserVendorLink data.
            PortalUserVendorLink newPuvl = new PortalUserVendorLink();
            newPuvl.setPortalUser(portalUser);
            CapsResource capsResource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
            newPuvl.setCapsResource(capsResource);
            setPortalUserVendorLinkData(newPuvl, saveVendorStaffDetailSI);
          }
        }
      }else if (PLCMNT_PRV_USRER.equals(saveVendorStaffDetailSI.getUserAccessType()) ||
                      NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType()) ||
                      (PLCMNT_PRV_ADMIN.equals(saveVendorStaffDetailSI.getUserAccessType()) &&
                      saveVendorStaffDetailSI.getIdUser().equals(saveVendorStaffDetailSI.getLoggedInUser()))) {
        //Update the Security Answers to the Portal User Table
        String txtAns1 = saveVendorStaffDetailSI.getTxtAnswer1();
        String txtAns2 = saveVendorStaffDetailSI.getTxtAnswer2();
        String txtAns3 = saveVendorStaffDetailSI.getTxtAnswer3();
        portalUserDAO.updatePortalUserForSecurityChangesByIdUser(idUser, txtAns1, txtAns2, txtAns3);
        //Update the Password only if User typed
        String newPassword = saveVendorStaffDetailSI.getTxtPassword();
        if (newPassword!=null && newPassword.trim().length()>0){
          Date lastUpdateDt = saveVendorStaffDetailSI.getDtLastPasswdReset();
          portalUserDAO.updatePortalUserForChangePasswordByIdUser(idUser, newPassword, lastUpdateDt);
        }
      }
      //Approve the Portal Registration by updating both Portal User and Portal user Vendor Link tables
      if (saveVendorStaffDetailSI.getSavePage().equals(APPROVE_VENDOR_STAFF_DETAIL)){
        portalUserDAO.approvePortalUser(idUser);
        portalUserVendorLinkDAO.approvePortalUserVendorLink(idUser);
        //Set the Portal User Security Class Link for the User
        PortalUserSecClassLink portalUserSecClassLink = populatePortalUserSecClassLink(saveVendorStaffDetailSI);
        
        portalUserSecClassLinkDAO.savePortalUserSecClassLink(portalUserSecClassLink);
      }
    }else if(saveVendorStaffDetailSI.getSavePage().equals(PASSWORD_RESET_STAFF_DETAIL)){
      if (saveVendorStaffDetailSI != null){
        //Reset the password
        portalUserDAO.resetPassword(saveVendorStaffDetailSI.getTxtRandPassword(), 
                                    saveVendorStaffDetailSI.getIdUser());
        saveVendorStaffDetailSO.setTxtResetPassword(saveVendorStaffDetailSI.getTxtRandPassword());
      }
      
    }else if(saveVendorStaffDetailSI.getSavePage().equals(DISAPPROVE_VENDOR_STAFF_DETAIL)){
      if (saveVendorStaffDetailSI != null){
        Integer idUser = saveVendorStaffDetailSI.getIdUser();
        //Delete Portal User Vendor Link and Portal User Record
        portalUserVendorLinkDAO.deletePortalUserVendorLinkByIdUser(idUser);
        portalUserDAO.deletePortalUserByIdUser(idUser);
        //Update the Portal User ID or the Shines User ID to the deleted record in the audit
        //table which gets inserted from the delete trigger of the PortalUserVendorLink table
        if(saveVendorStaffDetailSI.getModifiedSystem().equals(PORTAL_SYSTEM)){
          portalUserVendorLinkAuditDAO.
                        updatePortalUserVendorLinkAuditWithIdUserPortalUserId
                                    (idUser, saveVendorStaffDetailSI.getLoggedInUser());
          portalUserAuditDAO.updatePortalUserAuditWithPortalUserId
                                    (idUser, saveVendorStaffDetailSI.getLoggedInUser());
        }else if (saveVendorStaffDetailSI.getModifiedSystem().equals(SHINES_SYSTEM)){
          portalUserVendorLinkAuditDAO.
                        updatePortalUserVendorLinkAuditWithIdUserShinesUserId
                                    (idUser, saveVendorStaffDetailSI.getLoggedInUser());
          portalUserAuditDAO.updatePortalUserAuditWithShinesUserId
                                    (idUser, saveVendorStaffDetailSI.getLoggedInUser());
        }        
      }
    }else if(saveVendorStaffDetailSI.getSavePage().equals(DELETE_VENDOR_STAFF_DETAIL)){
      if (saveVendorStaffDetailSI != null){
        Integer idResource = 0;
        Integer idUser = saveVendorStaffDetailSI.getIdUser();
        try{
          idResource = Integer.parseInt(saveVendorStaffDetailSI.getIdResource());
        }catch (NumberFormatException nfe){
          idResource = 0;
        } 
        //Check whether An administrator attempts to delete an active Associated 
        //Vendor record and the user has accessed the system (and therefore possibly accessed vendor data) 
        //since the association was first entered.
        //Get the Latest date the user Logged In
        Date dtLastUserLoggedIn = portalLoginAuditDAO.findLastDtUserLoggedInByIdUser(idUser);
        //Get the date first the status changed from Pending to Active for the given resource ID
        Date dtFirstRsrcSetToActive = portalUserVendorLinkAuditDAO.
                                           findFirstUpdateDateToStatusActiveByIdRsrcIdUser(idResource, idUser);
        //If Logged in date is after the resource set to Active where the user has accessed the system
        //So Deleting Vendor Association is not allowed. Instead throwing a Message asking the user
        //to set the status to In Active and End date the association.
        if (dtLastUserLoggedIn!= null && dtFirstRsrcSetToActive!= null 
                        && dtLastUserLoggedIn.after(dtFirstRsrcSetToActive)){
          throw new ServiceException(Messages.MSG_PORTAL_VENDOR_ACCESSED);
        }
        Integer idPuvl = 0;
        try{
          idPuvl = Integer.parseInt(saveVendorStaffDetailSI.getIdPuvl());
        }catch (NumberFormatException nfe){
          idPuvl = 0;
        }        
        //Delete Portal User Vendor Link and Portal User Record
        portalUserVendorLinkDAO.deletePortalUserVendorLinkByIdPuvl(idPuvl);
        //Update the Portal User ID or the Shines User ID to the deleted record in the audit
        //table which gets inserted from the delete trigger of the PortalUserVendorLink table
        if(saveVendorStaffDetailSI.getModifiedSystem().equals(PORTAL_SYSTEM)){
          portalUserVendorLinkAuditDAO.updatePortalUserVendorLinkAuditWithPortalUserId(idPuvl, saveVendorStaffDetailSI.getLoggedInUser());
        }else if (saveVendorStaffDetailSI.getModifiedSystem().equals(SHINES_SYSTEM)){
          portalUserVendorLinkAuditDAO.updatePortalUserVendorLinkAuditWithShinesUserId(idPuvl, saveVendorStaffDetailSI.getLoggedInUser());
        }
        
      }
    }
    saveVendorStaffDetailSO.setSaveFlag(true);
    return saveVendorStaffDetailSO;
  }
  /**
   * Sets the basic and common data to the portal User object
   * @param portalUser
   * @param saveVendorStaffDetailSI
   */
  private void setBasicAndCommonData (PortalUser portalUser, SaveVendorStaffDetailSI saveVendorStaffDetailSI){
    //Loading Portal User Information
    portalUser.setNmUserFirst(saveVendorStaffDetailSI.getNmUserFirst());
    portalUser.setNmUserMiddle(saveVendorStaffDetailSI.getNmUserMiddle());
    portalUser.setNmUserLast(saveVendorStaffDetailSI.getNmUserLast());    
    // SMS #66384: MR-067 Format full name to prevent GenericJDBCException
    String firstName = saveVendorStaffDetailSI.getNmUserFirst();
    String middleName = saveVendorStaffDetailSI.getNmUserMiddle();
    String lastName = saveVendorStaffDetailSI.getNmUserLast(); 
    String fullName = "";
    fullName = FormattingHelper.formatFullName(firstName, middleName, lastName);
    portalUser.setNmUserFull(fullName);
    portalUser.setTxtTitle(saveVendorStaffDetailSI.getTxtTitle());
    portalUser.setTxtUserEmail(saveVendorStaffDetailSI.getTxtUserEmail());
    // Prevents possible data deletion of non-input data if the user is NYTD User 
    if (!NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType())) {
      portalUser.setNbrUserPhone(saveVendorStaffDetailSI.getNbrUserPhone());
      portalUser.setNbrUserPhoneExtension(saveVendorStaffDetailSI.getNbrUserPhoneExtension());
    }
    portalUser.setAddrUserAddrStLn1(saveVendorStaffDetailSI.getAddrUserAddrStLn1());
    portalUser.setAddrUserAddrStLn2(saveVendorStaffDetailSI.getAddrUserAddrStLn2());
    portalUser.setAddrUserAddrCity(saveVendorStaffDetailSI.getAddrUserAddrCity());
    portalUser.setAddrUserAddrZip(saveVendorStaffDetailSI.getAddrUserAddrZip());
    portalUser.setCdUserAddrState(saveVendorStaffDetailSI.getCdUserAddrState());
    portalUser.setCdUserAddrCounty(saveVendorStaffDetailSI.getCdUserAddrCounty());
    // Prevents possible data deletion of non-input data if the user is NYTD User 
    if (!NYTD_USER.equals(saveVendorStaffDetailSI.getUserAccessType())) {
    portalUser.setCdRequestType(saveVendorStaffDetailSI.getCdRequestType());
    }
    if (!saveVendorStaffDetailSI.getSavePage().equals(SAVE_PORTAL_REGISTRATION)){
      if(saveVendorStaffDetailSI.getModifiedSystem()!= null && 
                      saveVendorStaffDetailSI.getModifiedSystem().equals(PORTAL_SYSTEM) &&
                      saveVendorStaffDetailSI.getLoggedInUser()!=null){
        PortalUser portalUserModifiedBy = portalUserDAO.findPortalUserbyIdUser(saveVendorStaffDetailSI.getLoggedInUser());
        if (portalUserModifiedBy != null){
          portalUser.setPortalUser(portalUserModifiedBy);
        }
      }else if (saveVendorStaffDetailSI.getModifiedSystem()!= null && 
                      saveVendorStaffDetailSI.getModifiedSystem().equals(SHINES_SYSTEM) &&
                      saveVendorStaffDetailSI.getLoggedInUser()!=null){
        Employee employee = employeeDAO.findEmployeeByIdPerson(saveVendorStaffDetailSI.getLoggedInUser());
        if (employee != null){
          portalUser.setEmployee(employee);
        }
      }
    }
  }

  /**
   * Sets the basic and common data to the Portal User Dtl object
   * @param portalUserDtl
   * @param saveVendorStaffDetailSI
   */
  private void setDtlData (PortalUserDtl portalUserDtl, SaveVendorStaffDetailSI saveVendorStaffDetailSI){
    //Loading Portal User Information
    portalUserDtl.setTxtUserFacebook(saveVendorStaffDetailSI.getTxtUserFB()); 
    portalUserDtl.setTxtUserMyspace(saveVendorStaffDetailSI.getTxtUserMS());
    portalUserDtl.setTxtUserTwitter(saveVendorStaffDetailSI.getTxtUserTW());
    portalUserDtl.setTxtOtherSite(saveVendorStaffDetailSI.getTxtUserOthSite());
    portalUserDtl.setTxtUserOtherSite(saveVendorStaffDetailSI.getTxtUserNameOthSite());
    portalUserDtl.setNbrUserPhoneBest(saveVendorStaffDetailSI.getTxtUserPhnBest());
    portalUserDtl.setNbrUserPhoneBestExtension(saveVendorStaffDetailSI.getTxtUserPhnBestExt());
    portalUserDtl.setCdUserPhoneBestType(saveVendorStaffDetailSI.getTxtUserPhnBestType());
    portalUserDtl.setNbrUserPhoneAlt1(saveVendorStaffDetailSI.getTxtUserPhnAlt1());
    portalUserDtl.setNbrUserPhoneAlt1Extension(saveVendorStaffDetailSI.getTxtUserPhnAlt1Ext());
    portalUserDtl.setCdUserPhoneAlt1Type(saveVendorStaffDetailSI.getTxtUserPhnAlt1Type());
    portalUserDtl.setNbrUserPhoneAlt2(saveVendorStaffDetailSI.getTxtUserPhnAlt2());
    portalUserDtl.setNbrUserPhoneAlt2Extension(saveVendorStaffDetailSI.getTxtUserPhnAlt2Ext());
    portalUserDtl.setCdUserPhoneAlt2Type(saveVendorStaffDetailSI.getTxtUserPhnAlt2Type());
    portalUserDtl.setIndContactByText(saveVendorStaffDetailSI.getTxtCntctByText());
    portalUserDtl.setTxtEmerContact(saveVendorStaffDetailSI.getTxtEmerContact());
    //Save Portal User DtlData
    portalUserDtlDAO.savePortalUserDtl(portalUserDtl);  
  }
  
  private void setPortalUserVendorLinkData(PortalUserVendorLink puvl,SaveVendorStaffDetailSI saveVendorStaffDetailSI){
    puvl.setCdAccessType(saveVendorStaffDetailSI.getCdUserType());
    puvl.setCdStatus(saveVendorStaffDetailSI.getCdStatus());
    puvl.setDtStart(saveVendorStaffDetailSI.getDtStart());
    puvl.setDtEnd(saveVendorStaffDetailSI.getDtEnd());
    portalUserVendorLinkDAO.savePortalUserVendorLink(puvl);    
  }
  
  private PortalUserSecClassLink populatePortalUserSecClassLink(SaveVendorStaffDetailSI saveVendorStaffDetailSI){
    PortalUserSecClassLink portalUserSecClassLink = new PortalUserSecClassLink();
    PortalSecurityClass portalSecurityClass = null;
    if (saveVendorStaffDetailSI.getCdRequestType().equals(CodesTables.CUSRTYP_PAD)){
      portalSecurityClass = portalSecurityClassDAO.
                                                  findPortalSecurityClassByClassName(PLCMNT_PRV_ADMN);
    }else{
      portalSecurityClass = portalSecurityClassDAO.
                                                  findPortalSecurityClassByClassName(PLCMNT_PRV_USER);
      
    }
    portalUserSecClassLink.setPortalSecurityClass(portalSecurityClass);
    PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(saveVendorStaffDetailSI.getIdUser());
    portalUserSecClassLink.setPortalUser(portalUser);
    if(saveVendorStaffDetailSI.getModifiedSystem().equals(PORTAL_SYSTEM)){
      PortalUser portalUserModifiedBy = portalUserDAO.findPortalUserbyIdUser(saveVendorStaffDetailSI.getLoggedInUser());
      portalUserSecClassLink.setPortalUserModifiedBy(portalUserModifiedBy);
    }else if (saveVendorStaffDetailSI.getModifiedSystem().equals(SHINES_SYSTEM)){
      Employee employee = employeeDAO.findEmployeeByIdPerson(saveVendorStaffDetailSI.getLoggedInUser());
      portalUserSecClassLink.setEmployee(employee);
    }
    return portalUserSecClassLink;
  }

}
