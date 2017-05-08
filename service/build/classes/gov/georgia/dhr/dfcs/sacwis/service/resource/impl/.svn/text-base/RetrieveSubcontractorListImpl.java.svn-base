package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.Lookup;
import gov.georgia.dhr.dfcs.sacwis.core.pagination.PaginatedHibernateList;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.RsrcLinkDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RsrcLink;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.RetrieveSubcontractorList;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ArchInputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON15SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ArchOutputStruct;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON15SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON15SOG01_ARRAY;

/** 
* Change History:
* Date         User              Description
* --------     ----------------  -------------------------------------------------
* 04/03/2009   arege             STGAP00012937 Added code for Pagination for Service Site/SubContractor List
*                                on the Resource Detail Page.
*                              
* 
*/
public class RetrieveSubcontractorListImpl extends BaseServiceImpl implements RetrieveSubcontractorList {

  private RsrcLinkDAO rsrcLinkDAO = null;
  private ResourceServiceDAO resourceServiceDAO = null;

  public void setRsrcLinkDAO(RsrcLinkDAO rsrcLinkDAO) {
    this.rsrcLinkDAO = rsrcLinkDAO;
  }

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public CCON15SO findSubcontractorResources(CCON15SI ccon15si) throws ServiceException {
    CCON15SO ccon15so = new CCON15SO();
    
    ArchInputStruct archInputStruct = ccon15si.getArchInputStruct();
    int pageNbr = archInputStruct.getUsPageNbr();
    int pageSize = archInputStruct.getUlPageSizeNbr();
    
    // Calling DAO  CLSS18D
    ROWCCON15SOG00_ARRAY rowccon15sog00_array = new ROWCCON15SOG00_ARRAY();
    //STGAP00012937 Called the method that returns PaginatedHibernateList and added code for pagination
    PaginatedHibernateList<RsrcLink> listRsrcLink =
            rsrcLinkDAO.findRsrcLinkSubcontractorsByIdRsrcLinkParent(ccon15si.getUIdRsrcLinkParent(), pageNbr, pageSize);
    if (listRsrcLink != null) {
      for (Iterator<RsrcLink> it = listRsrcLink.iterator(); it.hasNext();) {
        RsrcLink rsrcLink = it.next();
        ROWCCON15SOG00 rowccon15sog00 = new ROWCCON15SOG00();
        rowccon15sog00.setSzCdRsrcLinkService(rsrcLink.getCdRsrcLinkService());
        rowccon15sog00.setSzNmResource(rsrcLink.getCapsResourceByIdRsrcLinkChild().getNmResource());
        rowccon15sog00.setTsLastUpdate(rsrcLink.getDtLastUpdate());
        rowccon15sog00.setUIdRsrcLink(rsrcLink.getIdRsrcLink() != null ? rsrcLink.getIdRsrcLink() : 0);
        rowccon15sog00.setUIdRsrcLinkChild(rsrcLink.getCapsResourceByIdRsrcLinkChild().getIdResource() != null ?
                                           rsrcLink.getCapsResourceByIdRsrcLinkChild().getIdResource() : 0);
        rowccon15sog00_array.addROWCCON15SOG00(rowccon15sog00);
      }
      ccon15so.setROWCCON15SOG00_ARRAY(rowccon15sog00_array);
     //STGAP00012937 Added code for Pagination
      ArchOutputStruct archOutputStruct = new ArchOutputStruct();
      archOutputStruct.setBMoreDataInd(listRsrcLink.getBMoreDataInd());
      ccon15so.setArchOutputStruct(archOutputStruct);
    }
    if (ArchitectureConstants.Y.equals(ccon15si.getBSysIndSbcntrPredisplay())) {
      ROWCCON15SOG01_ARRAY rowccon15sog01_array = new ROWCCON15SOG01_ARRAY();
      // Calling DAO CLSS14D
      List<String> listResourceService =
              resourceServiceDAO.findDistinctCdRsrcSvcServiceByIdResource(ccon15si.getUIdRsrcLinkParent());
      if (listResourceService != null) {
        for (Iterator<String> it = listResourceService.iterator(); it.hasNext();) {
          ROWCCON15SOG01 rowccon15sog01 = new ROWCCON15SOG01();
          String resourceService = it.next();
          //the assumption is that by default the service type will be "G" - general
          //however if the service code returned is a valid "Financial" service code
          //then service type will "F" - financial
          String resourceServiceType = "G";
          rowccon15sog01.setSzCdRsrcSvcService(resourceService);
          //check if service code is financial service code
          if(Lookup.isValidCode(CodesTables.CSVCCODE, resourceService)){
            resourceServiceType = "F";
          }
          rowccon15sog01.setSzCdRsrcSvcServiceType(resourceServiceType);
          rowccon15sog01_array.addROWCCON15SOG01(rowccon15sog01);
        }
      }
      ccon15so.setROWCCON15SOG01_ARRAY(rowccon15sog01_array);
    }
    return ccon15so;
  }
}
