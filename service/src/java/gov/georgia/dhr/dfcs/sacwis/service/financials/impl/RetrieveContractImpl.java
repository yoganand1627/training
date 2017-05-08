package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceAddressDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveContract;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON02SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY;

import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RetrieveContractImpl extends BaseServiceImpl implements RetrieveContract {

  private ContractDAO contractDAO = null;

  private ResourceAddressDAO resourceAddressDAO = null;

  public void setResourceAddressDAO(ResourceAddressDAO resourceAddressDAO) {
    this.resourceAddressDAO = resourceAddressDAO;
  }

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  /** Description: Retrieve a contract */

  public CCON02SO findContract(CCON02SI ccon02si) throws ServiceException {
    CCON02SO ccon02so = new CCON02SO();
    ROWCCON02SOG00_ARRAY rowccon02sog00_array = new ROWCCON02SOG00_ARRAY();
    int idContract = ccon02si.getUlIdContract();
    // cses03d
    Map mapContrct = contractDAO.findContractAndMore(idContract);
    if (mapContrct != null && mapContrct.size() > 0) {
      Integer idResource = (Integer) mapContrct.get("idResource");
      ccon02so.setTsLastUpdate((Timestamp) mapContrct.get("dtLastUpdate"));
      ccon02so.setSzCdCntrctFuncType((String) mapContrct.get("cdCntrctFuncType"));
      ccon02so.setSzCdCntrctProcureType((String) mapContrct.get("cdCntrctProcureType"));
      ccon02so.setSzCdCntrctProgramType((String) mapContrct.get("cdCntrctProgramType"));
      ccon02so.setSzCdCntrctRegion((String) mapContrct.get("cdCntrctRegion"));
      ccon02so.setCIndCntrctBudgLimit((String) mapContrct.get("indCntrctBudgLimit"));
      ccon02so.setCIndCntrctedResource((String) mapContrct.get("indCntrctdRsrc"));
      ccon02so
              .setUlIdCntrctManager((Integer) mapContrct.get("idCntrctManager") != null ? (Integer) mapContrct
                                                                                                              .get("idCntrctManager")
                                                                                       : 0);
      ccon02so.setUlIdResource((Integer) mapContrct.get("idResource") != null ? (Integer) mapContrct.get("idResource")
                                                                             : 0);
      ccon02so.setSzNmResource((String) mapContrct.get("nmResource"));
      ccon02so
              .setUlIdRsrcAddress((Integer) mapContrct.get("idRsrcAddress") != null ? (Integer) mapContrct
                                                                                                          .get("idRsrcAddress")
                                                                                   : 0);
      ccon02so.setSzNmPersonFull((String) mapContrct.get("nmPersonFull"));

      List<ResourceAddress> listRes = resourceAddressDAO.findResourceAddressByIdResource(idResource);
      if (listRes != null && listRes.size() > 0) {
        ResourceAddress rAddress = null;
        for (Iterator<ResourceAddress> it = listRes.iterator(); it.hasNext();) {
          rAddress = it.next();
          if (rAddress.getIdRsrcAddress() == ccon02so.getUlIdRsrcAddress()) {
            ROWCCON02SOG00 rowccon02sog00 = new ROWCCON02SOG00();
            rowccon02sog00.setUlIdRsrcAddress(rAddress.getIdRsrcAddress());
            rowccon02sog00.setSzNbrRsrcAddrVid(rAddress.getNbrRsrcAddrVid());
            rowccon02sog00.setSzAddrRsrcAddrStLn1(rAddress.getAddrRsrcAddrStLn1());
            rowccon02sog00_array.addROWCCON02SOG00(rowccon02sog00);
            rowccon02sog00.setSzNbrRsrcAddrVid(rAddress.getNbrRsrcAddrVid());
          }
        }
      } else { // findCapsResourceAddressess failed
        throw new ServiceException(Messages.MSG_DATABASE_RETRIEVE_FAIL);
      }
    }
    ccon02so.setROWCCON02SOG00_ARRAY(rowccon02sog00_array);
    return ccon02so;
  }
}
