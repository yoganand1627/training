package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveVendorStaffListSI;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveVendorStaffList;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveVendorStaffListBean;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.PortalUserVendorLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Date;

/**
* 
* <pre>
* Change History:
* Date      User              Description
* --------  ----------------  --------------------------------------------------
* 10/20/09  Patrick Coogan    ECEM: Created somewhere near this date to support the
*                             Vendor Staff List page of the Vendor Portal
* 11/09/09  Patrick Coogan    Implemented additional functionality for pages within
*                             SHINES, including pending admins view.
*</pre>
*/


public class RetrieveVendorStaffListImpl extends BaseServiceImpl implements RetrieveVendorStaffList {

  private PortalUserVendorLinkDAO portalUserVendorLinkDAO = null;
  private PortalUserDAO portalUserDAO = null;

  public void setPortalUserVendorLinkDAO(PortalUserVendorLinkDAO portalUserVendorLinkDAO) {
    this.portalUserVendorLinkDAO = portalUserVendorLinkDAO;
  }
  
  public void setPortalUserDAO(PortalUserDAO portalUserDAO) {
    this.portalUserDAO = portalUserDAO;
  }
  
  private static final String PORTAL_STAFF_LIST = "portalActive";
  private static final String PORTAL_PENDING_STAFF_LIST = "portalPending";
  //Note: the following are only used in SHINES
  private static final String SHINES_STAFF_LIST = "shinesActive";
  private static final String SHINES_PENDING_STAFF_LIST = "shinesPending";
  private static final String SHINES_PENDING_ADMIN_LIST = "shinesPendingAdmin";

  public RetrieveVendorStaffListSO retrieveVendorList(RetrieveVendorStaffListSI retrieveVendorStaffListSI)
                                                                                                          throws ServiceException {

    RetrieveVendorStaffListSO retrieveVendorStaffListSO = new RetrieveVendorStaffListSO();
    ArchInputStruct archInputStruct = retrieveVendorStaffListSI.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    List<Integer> idRsrcList = new ArrayList<Integer>();
    List<String> types = new ArrayList<String>();
    List<String> statuses = new ArrayList<String>();
    
    //When we call this from SHINES, we will be loading SI with just the currently 
    //selected resource from GlobalData.  Using the same list object, even for single resource
    //helps to maximize code reuse.
    
    idRsrcList = retrieveVendorStaffListSI.getAdminList();
    int idUser = retrieveVendorStaffListSI.getIdUser();
    
    //SearchType will match one of the constants above as set by the activity method
    //in the calling conversation.
    String searchType = retrieveVendorStaffListSI.getCdSearchType();
    
    if (idRsrcList.isEmpty()){
      idRsrcList.add(Integer.valueOf(0));
    }
    
    //The parameters to pass to the PortalUserVendorLink query will be different by view
    //Get all active and inactive for assigned resources
    if (PORTAL_STAFF_LIST.equals(searchType)){
      
      statuses.add(CodesTables.CUSRSTAT_ACT);
      statuses.add(CodesTables.CUSRSTAT_INA);
      types.add(CodesTables.CUSRTYP_PAD);
      types.add(CodesTables.CUSRTYP_PUS);
      
    } 
    
    //Show only pending for portal users
    if (PORTAL_PENDING_STAFF_LIST.equals(searchType)) {
      
      idUser = 0;
      statuses.add(CodesTables.CUSRSTAT_PEN);
      types.add(CodesTables.CUSRTYP_PUS);
      
    }
    
    //Show all active and inactive
    if (SHINES_STAFF_LIST.equals(searchType)){
      
      idUser = 0;
      statuses.add(CodesTables.CUSRSTAT_ACT);
      statuses.add(CodesTables.CUSRSTAT_INA);
      types.add(CodesTables.CUSRTYP_PAD);
      types.add(CodesTables.CUSRTYP_PUS);
      
    }
    
    //Show pending for both users and admins
    if (SHINES_PENDING_STAFF_LIST.equals(searchType)) {
      
      idUser = 0;
      statuses.add(CodesTables.CUSRSTAT_PEN);
      types.add(CodesTables.CUSRTYP_PUS);
      types.add(CodesTables.CUSRTYP_PAD);
      
    }
    
    List<RetrieveVendorStaffListBean> vendorStaffList = new ArrayList<RetrieveVendorStaffListBean>();

    PaginatedHibernateList<Map> staffList = null;
    
    //Unless we are calling for the pending admin page, we will alays be bringing back data
    //from rows actually on Portal User Vendor Link table.
    if (SHINES_PENDING_STAFF_LIST.equals(searchType)||SHINES_STAFF_LIST.equals(searchType)||PORTAL_PENDING_STAFF_LIST.equals(searchType)||PORTAL_STAFF_LIST.equals(searchType)) {
    
    staffList = portalUserVendorLinkDAO.findPortalVendorStaffList(idRsrcList, statuses, types, idUser, pageNbr, pageSize);

    } else if(SHINES_PENDING_ADMIN_LIST.equals(searchType)) {
      //When the pending admin list, we need to look at Portal User for pending
      //registrations and only outer join resource data for the registration if present
      staffList = portalUserDAO.findPendingPortalAdmins(pageNbr, pageSize); 
      
    }
     
    for (Iterator<Map> it = staffList.iterator(); it.hasNext();) {

      Map objs = it.next();

      RetrieveVendorStaffListBean retrieveVendorListBean = new RetrieveVendorStaffListBean();

      retrieveVendorListBean.setSzStaffName((String) objs.get("nmUserFull"));
      retrieveVendorListBean.setUlIdUser((Integer) objs.get("idUser"));
      retrieveVendorListBean.setCdUserType((String) objs.get("cdAccessType"));
      
      if (SHINES_PENDING_STAFF_LIST.equals(searchType)||SHINES_STAFF_LIST.equals(searchType)||PORTAL_PENDING_STAFF_LIST.equals(searchType)||PORTAL_STAFF_LIST.equals(searchType)) {
      retrieveVendorListBean.setSzNmResource((String) objs.get("nmResource")); 
      } else {
        //Handle that name may be from resource or from other text typed
        if (objs.get("nmResource1")!=null && !("".equals((String) objs.get("nmResource1")))){
          retrieveVendorListBean.setSzNmResource((String) objs.get("nmResource1"));
        } else {
          retrieveVendorListBean.setSzNmResource((String) objs.get("nmResource2"));
        }
      }
      retrieveVendorListBean.setUlIdResource((Integer) objs.get("idResource"));
      retrieveVendorListBean.setDtEnd((Date) objs.get("dtEnd"));
      retrieveVendorListBean.setDtStart((Date) objs.get("dtStart"));
      retrieveVendorListBean.setCdStatus((String) objs.get("cdStatus"));  
      retrieveVendorListBean.setSzStaffEmail((String) objs.get("addrRsrcEmail"));
      retrieveVendorListBean.setNbrStaffPhone((String) objs.get("nbrRsrcContactPhn"));
      vendorStaffList.add(retrieveVendorListBean);
    }

    ArchOutputStruct archOutputStruct = new ArchOutputStruct();
    archOutputStruct.setBMoreDataInd(staffList.getBMoreDataInd());

    retrieveVendorStaffListSO.setVendorStaffList(vendorStaffList);
    retrieveVendorStaffListSO.setArchOutputStruct(archOutputStruct);

    return retrieveVendorStaffListSO;
  }

}
