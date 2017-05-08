package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
//import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_CON_NO_VID_EXISTS;
import static gov.georgia.dhr.dfcs.sacwis.core.message.Messages.MSG_CON_RESOURCE_INVALID;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveResource;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON04SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON04SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY;

public class RetrieveResourceImpl extends BaseServiceImpl implements RetrieveResource {

  private CapsResourceDAO capsResourceDAO = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }
  
  public CCON04SO findResource(CCON04SI ccon04si) throws ServiceException {

    CCON04SO ccon04so = new CCON04SO();
    int idResource = ccon04si.getUlIdResource();
    CapsResource resource = capsResourceDAO.findCapsResourceByIdResourceOnly(idResource);
    // If no resource is returned or if the resource ID is 0, then throw an exception 
    if (resource == null || resource.getIdResource() == 0) {
      throw new ServiceException(MSG_CON_RESOURCE_INVALID);
    } else {
      
      idResource = resource.getIdResource();
      ROWCCON02SOG00_ARRAY rowccon02sog00_array = new ROWCCON02SOG00_ARRAY();
      List<ResourceAddress> listRes = resourceAddressDAO.findResourceAddressByIdResource(idResource);
      if (listRes != null && listRes.size() > 0) {
        ResourceAddress rAddress = null;
        for (Iterator<ResourceAddress> it = listRes.iterator(); it.hasNext();) {
          rAddress = it.next();
          ROWCCON02SOG00 rowccon02sog00 = new ROWCCON02SOG00();
          rowccon02sog00.setUlIdRsrcAddress(rAddress.getIdRsrcAddress());
          rowccon02sog00.setSzNbrRsrcAddrVid(rAddress.getNbrRsrcAddrVid());
          rowccon02sog00.setSzAddrRsrcAddrStLn1(rAddress.getAddrRsrcAddrStLn1());
          rowccon02sog00.setSzNbrRsrcAddrVid(rAddress.getNbrRsrcAddrVid());
          rowccon02sog00_array.addROWCCON02SOG00(rowccon02sog00);
        }
      } else { // findCapsResourceAddressess failed
        throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      }

      ccon04so.setROWCCON02SOG00_ARRAY(rowccon02sog00_array);
      //RMP added for defect STGAP00003293: Resource Name not displayed when validating
      ccon04so.setSzNmResource(resource.getNmResource());
    }
    return ccon04so;

  }
}
