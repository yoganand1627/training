package gov.georgia.dhr.dfcs.sacwis.service.resource.impl;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.resource.CheckHomeNameAddressExists;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD08SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG01_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCFAD08SIG04;

import java.util.Iterator;

public class CheckHomeNameAddressExistsImpl extends BaseServiceImpl implements CheckHomeNameAddressExists {

  private CapsResourceDAO capsResourceDAO = null;
  private ResourceAddressDAO resourceAddressDAO = null;
  
  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public Boolean checkHomeNameAddressExists(CFAD08SI cfad08si) {

    Boolean doesAddressOrNameExist = false;
    ROWCFAD08SIG01_ARRAY addressArray = cfad08si.getROWCFAD08SIG01_ARRAY();
    ROWCFAD08SIG04 demographics = cfad08si.getROWCFAD08SIG04();
    // Get the home name from the demographics, check CAPS_RESOURCE to see if name exists
    String strHomeName = demographics.getSzNmRshsResource();
    
    Integer idResource = capsResourceDAO.findIdResourceByNmResource(strHomeName);
    if (idResource != null && idResource > 0) {
      doesAddressOrNameExist = true;
    }
    
    /* If home name does not exist, then check the address to see
     * if the address exists in the RESOURCE_ADDRESS table
     */
    if (addressArray != null && !doesAddressOrNameExist) {
      Iterator<ROWCFAD08SIG01> it = addressArray.iterateROWCFAD08SIG01();
      while (it.hasNext()) {
        ROWCFAD08SIG01 address = it.next();
        String strAddress1 = address.getSzAddrRsrcAddrStLn1();
        String strAddress2 = address.getSzAddrRsrcAddrStLn2();
        String strCity = address.getSzAddrRsrcAddrCity();
        String strState = address.getSzCdFacilityState();
        String strZipCode = address.getSzAddrRsrcAddrZip();
        String addressType = address.getSzCdRsrcAddrType();


        ResourceAddress resourceAddress = null;
        if("".equals(strAddress2)){
          resourceAddress = resourceAddressDAO.findRsrcAddressByAddress(strAddress1, strCity, strState, strZipCode, addressType);
        }else{
          resourceAddress = resourceAddressDAO.findRsrcAddressByAddressStrAddress2(strAddress1, strAddress2, strCity, strState, strZipCode, addressType);
        }
        if (resourceAddress != null) {
          doesAddressOrNameExist = true;
          break;
        }
      }
    }

    return doesAddressOrNameExist;
  }
}
