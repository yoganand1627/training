/**
 * 
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.utility.Option;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUser;
import gov.georgia.dhr.dfcs.sacwis.db.PortalUserDtl;
import gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveVendorStaffDetail;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffDetailSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffDetailSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffLinkDetailBean;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * @author sriram.subramaniam
 *
 */
public class RetrieveVendorStaffDetailImpl extends BaseServiceImpl implements RetrieveVendorStaffDetail {
  private final static String PORTAL_REGISTRATION = "PORTAL_REGISTRATION";
  
  private final static String PORTAL_STAFF_LIST = "portalActive";
  
  private final static String PORTAL_PENDING_STAFF_LIST = "portalPending";
  //Note: the following are only used in SHINES
  private static final String SHINES_STAFF_LIST = "shinesActive";
  
  private static final String SHINES_PENDING_STAFF_LIST = "shinesPending";
  
  private static final String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";
  //Same as in the UserProfile.java
  private final static String PLCMNT_PRV_ADMIN = "0";
  private final static String PLCMNT_PRV_USRER = "1";
  private final static String NYTD_USER = "2";
  PortalUserDAO portalUserDAO;
  PortalUserVendorLinkDAO portalUserVendorLinkDAO;
  // SMS #66384: MR-067 Added additional DAO for NYTD User Information section
  PortalUserDtlDAO portalUserDtlDAO;

  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }

  public void setPortalUserVendorLinkDAO(PortalUserVendorLinkDAO portalUserVendorLinkDAO) {
    this.portalUserVendorLinkDAO = portalUserVendorLinkDAO;
  }

  public void setPortalUserDtlDAO(PortalUserDtlDAO portalUserDtlDAO) {
	this.portalUserDtlDAO = portalUserDtlDAO;
  }
 
  /* (non-Javadoc)
   * @see gov.georgia.dhr.dfcs.sacwis.service.admin.RetrieveVendorStaffDetail#retrieveCaseFileManagement(gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffDetailSI)
   */
  public RetrieveVendorStaffDetailSO retrieveVendorStaffDetail(RetrieveVendorStaffDetailSI retrieveVendorStaffDetailSI) {
    RetrieveVendorStaffDetailSO retrieveVendorStaffDetailSO = new RetrieveVendorStaffDetailSO();
    
    if(retrieveVendorStaffDetailSI.getRetrieveFlag() != null && 
                    (retrieveVendorStaffDetailSI.getRetrieveFlag().equals(PORTAL_STAFF_LIST) ||
                     retrieveVendorStaffDetailSI.getRetrieveFlag().equals(PORTAL_PENDING_STAFF_LIST) ||
                     retrieveVendorStaffDetailSI.getRetrieveFlag().equals(SHINES_PENDING_ADMIN_LIST) ||
                     retrieveVendorStaffDetailSI.getRetrieveFlag().equals(SHINES_PENDING_STAFF_LIST) ||
                     retrieveVendorStaffDetailSI.getRetrieveFlag().equals(SHINES_STAFF_LIST))){
      
      Integer idUser = retrieveVendorStaffDetailSI.getIdUser()!=null?retrieveVendorStaffDetailSI.getIdUser():0;
      PortalUser portalUser = portalUserDAO.findPortalUserbyIdUser(idUser);
      if (portalUser != null){
        retrieveVendorStaffDetailSO.setIdUser(idUser);
        retrieveVendorStaffDetailSO.setScreenName(retrieveVendorStaffDetailSI.getRetrieveFlag());
        retrieveVendorStaffDetailSO.setNmUserFirst(portalUser.getNmUserFirst()!=null?portalUser.getNmUserFirst():"");
        retrieveVendorStaffDetailSO.setNmUserLast(portalUser.getNmUserLast()!=null?portalUser.getNmUserLast():"");
        retrieveVendorStaffDetailSO.setNmUserMiddle(portalUser.getNmUserMiddle()!=null?portalUser.getNmUserMiddle():"");
        retrieveVendorStaffDetailSO.setTxtTitle(portalUser.getTxtTitle()!=null?portalUser.getTxtTitle():"");
        retrieveVendorStaffDetailSO.setTxtUserEmail(portalUser.getTxtUserEmail()!=null?portalUser.getTxtUserEmail():"");
        retrieveVendorStaffDetailSO.setNbrUserPhone(portalUser.getNbrUserPhone()!=null?portalUser.getNbrUserPhone():"");
        retrieveVendorStaffDetailSO.setNbrUserPhoneExtension(portalUser.getNbrUserPhoneExtension()!=null?portalUser.getNbrUserPhoneExtension():"");
        retrieveVendorStaffDetailSO.setAddrUserAddrStLn1(portalUser.getAddrUserAddrStLn1()!=null?portalUser.getAddrUserAddrStLn1():"");
        retrieveVendorStaffDetailSO.setAddrUserAddrStLn2(portalUser.getAddrUserAddrStLn2()!=null?portalUser.getAddrUserAddrStLn2():""); 
        retrieveVendorStaffDetailSO.setAddrUserAddrCity(portalUser.getAddrUserAddrCity()!=null?portalUser.getAddrUserAddrCity():"");
        retrieveVendorStaffDetailSO.setCdUserAddrState(portalUser.getCdUserAddrState()!=null?portalUser.getCdUserAddrState():"");
        retrieveVendorStaffDetailSO.setCdUserAddrCounty(portalUser.getCdUserAddrCounty()!=null?portalUser.getCdUserAddrCounty():"");
        retrieveVendorStaffDetailSO.setAddrUserAddrZip(portalUser.getAddrUserAddrZip()!=null?portalUser.getAddrUserAddrZip():"");
        retrieveVendorStaffDetailSO.setCdRequestType(portalUser.getCdRequestType()!=null?portalUser.getCdRequestType():"");
        retrieveVendorStaffDetailSO.setTxtOther(portalUser.getTxtOther()!=null?portalUser.getTxtOther():"");
        //Retrieve Security Question and Answers
        retrieveVendorStaffDetailSO.setCdQuestion1(portalUser.getCdQuestion1()!=null?portalUser.getCdQuestion1():"");
        retrieveVendorStaffDetailSO.setCdQuestion2(portalUser.getCdQuestion2()!=null?portalUser.getCdQuestion2():"");
        retrieveVendorStaffDetailSO.setCdQuestion3(portalUser.getCdQuestion3()!=null?portalUser.getCdQuestion3():"");
        Object[] portalUserForSecurity = portalUserDAO.findValidateLoginInfoByTxtEmail(portalUser.getTxtUserEmail()!=null?portalUser.getTxtUserEmail():"");
        if (portalUserForSecurity != null){
          //Adding Answers to the SO Object
          retrieveVendorStaffDetailSO.setTxtAnswer1((String)portalUserForSecurity[7]!=null?(String)portalUserForSecurity[7]:"");
          retrieveVendorStaffDetailSO.setTxtAnswer2((String)portalUserForSecurity[8]!=null?(String)portalUserForSecurity[8]:"");
          retrieveVendorStaffDetailSO.setTxtAnswer3((String)portalUserForSecurity[9]!=null?(String)portalUserForSecurity[9]:"");            
        }
        List<Object[]> resourcesListofIdUser = portalUserVendorLinkDAO.findResourceListForGivenUser(idUser);
        List<RetrieveVendorStaffLinkDetailBean> resourceList = new ArrayList<RetrieveVendorStaffLinkDetailBean>();
        Map<Integer,RetrieveVendorStaffLinkDetailBean> resourceMap = new HashMap<Integer,RetrieveVendorStaffLinkDetailBean>();
        for (Iterator<Object[]> it = resourcesListofIdUser.iterator(); it.hasNext();) {
          Object[] resource = it.next();
          RetrieveVendorStaffLinkDetailBean retrieveVendorStaffLinkDetailBean = new RetrieveVendorStaffLinkDetailBean();
          retrieveVendorStaffLinkDetailBean.setIdPortalUserVendorLink(resource[0]!=null ? (Integer) resource[0] : 0);
          retrieveVendorStaffLinkDetailBean.setIdResource(resource[1]!=null ? (Integer) resource[1] : 0);
          retrieveVendorStaffLinkDetailBean.setNmResource(StringHelper.getSafeString(String.valueOf(resource[2]!=null ? 
                                                                                             (String) resource[2] : "")));
          retrieveVendorStaffLinkDetailBean.setCdAccessType(StringHelper.getSafeString(String.valueOf(resource[3]!=null ? 
                                                                                             (String) resource[3] : "")));
          retrieveVendorStaffLinkDetailBean.setCdStatus(StringHelper.getSafeString(String.valueOf(resource[4]!=null ? 
                                                                                             (String) resource[4] : "")));
          retrieveVendorStaffLinkDetailBean.setDtStart(resource[5]!=null ?(Date) resource[5] : null);
          retrieveVendorStaffLinkDetailBean.setDtEnd(resource[6]!=null ?(Date) resource[6] : null); 
          resourceList.add(retrieveVendorStaffLinkDetailBean);
          resourceMap.put(retrieveVendorStaffLinkDetailBean.getIdPortalUserVendorLink(), retrieveVendorStaffLinkDetailBean);
        }
        retrieveVendorStaffDetailSO.setResourceListforUser(resourceList);
        retrieveVendorStaffDetailSO.setResourceMap(resourceMap);
      }
    }
    List<Object[]> resourceListFromDB = null;
    if(retrieveVendorStaffDetailSI.getRetrieveFlag() != null && 
                    retrieveVendorStaffDetailSI.getRetrieveFlag().equals(PORTAL_REGISTRATION)){
      retrieveVendorStaffDetailSO.setScreenName(PORTAL_REGISTRATION);
      // Get the Distinct All Resources from the Portal User Vendor link as this is shown in the registration
      // page.
      resourceListFromDB = portalUserVendorLinkDAO.findActiveResourceListForVendorPortal();

    }else {
      Integer idLoggedInUser = retrieveVendorStaffDetailSI.getIdLoggedInUser()!=null?retrieveVendorStaffDetailSI.getIdLoggedInUser():0;
      // Get the Distinct Resource from the Portal User Vendor link for given logged in user ID
      resourceListFromDB = portalUserVendorLinkDAO.findActiveResourceListForVendorPortal(idLoggedInUser);
    }
    List<Option> resourceList = new ArrayList<Option>();
    Map<Integer, String> activeRsrcListMap = new HashMap<Integer, String>();
    if (resourceListFromDB != null){
      for (Iterator<Object[]> it = resourceListFromDB.iterator(); it.hasNext();) {
        Object[] resource = it.next();
        String idResourceStr = StringHelper.getSafeString(String.valueOf(resource[0]!=null ? (Integer) resource[0] : 0));
        String nmResource = StringHelper.getSafeString(String.valueOf(resource[1]!=null ? (String) resource[1] : ""));
        resourceList.add(new Option(String.valueOf(idResourceStr+","+nmResource), idResourceStr+" - "+nmResource));
        activeRsrcListMap.put(resource[0]!=null ? (Integer) resource[0] : 0, String.valueOf(resource[1]!=null ? (String) resource[1] : ""));
      }
    }
    // MR-067 - if user is NYTD youth, retrieve additional data for this type of user only
    if (retrieveVendorStaffDetailSO != null && NYTD_USER.equals(retrieveVendorStaffDetailSI.getUserAccessType())) {
      PortalUserDtl portalUserDtl = portalUserDtlDAO.findPortalUserbyIdUser(retrieveVendorStaffDetailSO.getIdUser());
      if (portalUserDtl != null) {
        retrieveVendorStaffDetailSO.setTxtUserFB(portalUserDtl.getTxtUserFacebook() != null ? portalUserDtl.getTxtUserFacebook() : "");
        retrieveVendorStaffDetailSO.setTxtUserMS(portalUserDtl.getTxtUserMyspace() != null ?  portalUserDtl.getTxtUserMyspace() : "");
        retrieveVendorStaffDetailSO.setTxtUserTW(portalUserDtl.getTxtUserTwitter() != null ?  portalUserDtl.getTxtUserTwitter() : "");
        retrieveVendorStaffDetailSO.setTxtUserOthSite(portalUserDtl.getTxtOtherSite() != null ? portalUserDtl.getTxtOtherSite() : "");
        retrieveVendorStaffDetailSO.setTxtUserNameOthSite(portalUserDtl.getTxtUserOtherSite() != null ? portalUserDtl.getTxtUserOtherSite(): "");
        retrieveVendorStaffDetailSO.setTxtUserPhnBest(portalUserDtl.getNbrUserPhoneBest() != null ? portalUserDtl.getNbrUserPhoneBest() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnBestExt(portalUserDtl.getNbrUserPhoneBestExtension() != null ? portalUserDtl.getNbrUserPhoneBestExtension() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnBestType(portalUserDtl.getCdUserPhoneBestType() != null ? portalUserDtl.getCdUserPhoneBestType() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnAlt1(portalUserDtl.getNbrUserPhoneAlt1() != null ? portalUserDtl.getNbrUserPhoneAlt1() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnAlt1Ext(portalUserDtl.getNbrUserPhoneAlt1Extension() != null ? portalUserDtl.getNbrUserPhoneAlt1Extension() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnAlt1Type(portalUserDtl.getCdUserPhoneAlt1Type() != null ? portalUserDtl.getCdUserPhoneAlt1Type() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnAlt2(portalUserDtl.getNbrUserPhoneAlt2() != null ? portalUserDtl.getNbrUserPhoneAlt2() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnAlt2Ext(portalUserDtl.getNbrUserPhoneAlt2Extension() != null ? portalUserDtl.getNbrUserPhoneAlt2Extension() : "");
        retrieveVendorStaffDetailSO.setTxtUserPhnAlt2Type(portalUserDtl.getCdUserPhoneAlt2Type() != null ? portalUserDtl.getCdUserPhoneAlt2Type() : "");
        retrieveVendorStaffDetailSO.setTxtCntctByText(portalUserDtl.getIndContactByText() != null ? portalUserDtl.getIndContactByText() : "");       
        retrieveVendorStaffDetailSO.setTxtEmerContact(portalUserDtl.getTxtEmerContact() != null ? portalUserDtl.getTxtEmerContact() : "");      
      }      
    }     
    // End SMS# 66384: MR-067

    retrieveVendorStaffDetailSO.setResourceList(resourceList);
    retrieveVendorStaffDetailSO.setActiveRsrcListMap(activeRsrcListMap);
    return retrieveVendorStaffDetailSO;
  }

}
