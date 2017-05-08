package gov.georgia.dhr.dfcs.sacwis.service.common.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.DynamicFacAgencyHomesDAO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.service.common.RetrieveFacAgencyHomesList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveFacAgencyHomesListSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveFacAgencyHomesListBean;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

/**
* 
* <pre>
* Change History:
* Date      User              Description
* --------  ----------------  --------------------------------------------------
* 10/20/09  Patrick Coogan    ECEM: Created somewhere near this date to support the
*                             Facility/Agency Homes List page of the Vendor Portal
* 11/09/09  Patrick Coogan    SMS 38977: Updated service to call the DynamicFacAgencyHomesDAO
*                             instead of previous methods in CapsResourceDAO in able to 
*                             properly support sorting.
*</pre>
*/


public class RetrieveFacAgencyHomesListImpl extends BaseServiceImpl implements RetrieveFacAgencyHomesList {

  private DynamicFacAgencyHomesDAO dynamicFacAgencyHomesDAO = null;

  public void setDynamicFacAgencyHomesDAO(DynamicFacAgencyHomesDAO dynamicFacAgencyHomesDAO) {
    this.dynamicFacAgencyHomesDAO = dynamicFacAgencyHomesDAO;
  }

  public RetrieveFacAgencyHomesListSO retrieveFacAgencyHomesList(
                                                                 RetrieveFacAgencyHomesListSI retrieveFacAgencyHomesListSI)
                                                                                                                           throws ServiceException {

    RetrieveFacAgencyHomesListSO retrieveFacAgcyHmListso = new RetrieveFacAgencyHomesListSO();
    ArchInputStruct archInputStruct = retrieveFacAgencyHomesListSI.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();

    PaginatedHibernateList<Map> facilityList = null;
    
    facilityList = dynamicFacAgencyHomesDAO.findPortalFacilityAgencyHomesList(retrieveFacAgencyHomesListSI.getIdParentRsrc(),retrieveFacAgencyHomesListSI.getRsrcList(),retrieveFacAgencyHomesListSI.getCdSortBy(),
                                                                        pageNbr, pageSize);
      
                    
    if (facilityList == null || facilityList.isEmpty()) {
      return null;
    } else {
      
      List<RetrieveFacAgencyHomesListBean> facAgcyHmList = new ArrayList<RetrieveFacAgencyHomesListBean>();
      
      for (Iterator<Map> it = facilityList.iterator(); it.hasNext();) {
        
        Map objs = it.next();
        
        RetrieveFacAgencyHomesListBean retrieveFacAgcyHmListBean = new RetrieveFacAgencyHomesListBean();  
        
        retrieveFacAgcyHmListBean.setUlIdRsrc((Integer) objs.get("idResource"));
        retrieveFacAgcyHmListBean.setNmResource((String) objs.get("nmResource"));
        retrieveFacAgcyHmListBean.setCdStatus((String)objs.get("childCdRsrcStatus") );
        retrieveFacAgcyHmListBean.setCdAddress((String)objs.get("childaddrRsrcStLn1") );
        retrieveFacAgcyHmListBean.setCdrscType((String)objs.get("childCdRsrcType") );
        retrieveFacAgcyHmListBean.setlNbrFacilPhoneNumber((String)objs.get("childNbrRsrcPhn"));
        retrieveFacAgcyHmListBean.setSzAddrCity((String)objs.get("childaddrRsrcCity") );
        retrieveFacAgcyHmListBean.setCdCounty((String)objs.get("childCdRsrcCnty") );
        retrieveFacAgcyHmListBean.setlNbrPhoneExtension((String)objs.get("childNbrRsrcPhoneExt"));
        retrieveFacAgcyHmListBean.setSzCdIncRsrcType((String)objs.get("childCdRsrcFacilType"));
      
        facAgcyHmList.add(retrieveFacAgcyHmListBean);
      }
      
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(facilityList.getBMoreDataInd());
      
      retrieveFacAgcyHmListso.setFacilityAgencyList(facAgcyHmList);
      retrieveFacAgcyHmListso.setArchOutputStruct(archOutputStruct);
      
      return retrieveFacAgcyHmListso;
    }
  }
}