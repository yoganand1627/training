package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceService;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveCountyList;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON13SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON13SOG_ARRAY;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Change History
 * 
 * Date User Description -------- ---------------- -------------------------------------------------- 10/11/11 charden
 * added code to pull all counties related to a resource for a particular program code
 * 
 * 
 */

public class RetrieveCountyListImpl extends BaseServiceImpl implements RetrieveCountyList {

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ResourceServiceDAO resourceServiceDAO = null;

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public CCON13SO retrieveCounties(CCON13SI ccon13si) throws ServiceException {
    String indAllCounties = ccon13si.getIndAllCounties() == null ? ServiceConstants.FND_NO
                                                                : ccon13si.getIndAllCounties();

    if (ServiceConstants.FND_YES.equals(indAllCounties)) {
      return getProgramCodeCounties(ccon13si);
    } else {
      return getNonContractedCounties(ccon13si);
    }
  }

  private CCON13SO getNonContractedCounties(CCON13SI ccon13si) {
    CCON13SO ccon13so = new CCON13SO();
    List<Map> countyList = complexCapsResourceDAO
                                                 .findCountyResource(
                                                                     ccon13si.getUlIdContract(),
                                                                     ccon13si.getSzCdRsrcSvcService(),
                                                                     ccon13si.getUlNbrCncntyPeriod(),
                                                                     ccon13si.getUlNbrCncntyVersion(),
                                                                     ccon13si.getUlNbrCncntyLineItem(),
                                                                     ccon13si.getUlIdResource(),
                                                                     DateHelper
                                                                               .toJavaDate(ccon13si
                                                                                                   .getDtDtCncntyEffective()),
                                                                     DateHelper.toJavaDate(ccon13si.getDtDtCncntyEnd()));
    if (countyList == null || countyList.size() == 0) {
      throw new ServiceException(Messages.MSG_CON_NO_COUNTY);
    }

    ROWCCON13SOG_ARRAY rowccon13sog_array = new ROWCCON13SOG_ARRAY();
    for (Iterator<Map> it = countyList.iterator(); it.hasNext();) {
      Map row = it.next();
      ROWCCON13SOG rowccon13sog = new ROWCCON13SOG();
      rowccon13sog.setUlIdCncnty((Integer) row.get("idCncnty") != null ? (Integer) row.get("idCncnty") : 0);
      rowccon13sog.setSzCdCncntyCounty((String) row.get("cdRsrcSvcCnty"));
      rowccon13sog.setTsLastUpdate((Date) row.get("dtLastUpdate"));
      rowccon13sog_array.addROWCCON13SOG(rowccon13sog);
    }
    ccon13so.setROWCCON13SOG_ARRAY(rowccon13sog_array);

    return ccon13so;
  }

  private CCON13SO getProgramCodeCounties(CCON13SI ccon13si) {
    // setup transport object and get parameters from SI
    CCON13SO ccon13so = new CCON13SO();
    Map<String, String> filterMap = new HashMap<String, String>();
    int idResource = ccon13si.getUlIdResource();
    String cdRsrcSvcCategRsrc = ccon13si.getSzCdRsrcSvcCategRsrc();

    // get all service counties that resource offers within the program code
    List<ResourceService> resourceServiceList = resourceServiceDAO
                                                                  .findCdRsrcSvcCntyCdRsrcSvcServiceByIdResourceCdRsrcSvcCategRsrc(
                                                                                                                                   idResource,
                                                                                                                                   cdRsrcSvcCategRsrc);

    // add data to array
    ROWCCON13SOG_ARRAY rowccon13sog_array = new ROWCCON13SOG_ARRAY();
    for (ResourceService resourceService : resourceServiceList) {
      ROWCCON13SOG rowccon13sog = new ROWCCON13SOG();
      String cdCounty = resourceService.getCdRsrcSvcCnty();
      if(!filterMap.containsKey(cdCounty)){
        rowccon13sog.setSzCdCncntyCounty(resourceService.getCdRsrcSvcCnty());
        rowccon13sog_array.addROWCCON13SOG(rowccon13sog);
        filterMap.put(cdCounty, cdCounty);
      }   
    }

    // place array in out object
    ccon13so.setROWCCON13SOG_ARRAY(rowccon13sog_array);

    return ccon13so;
  }
}
