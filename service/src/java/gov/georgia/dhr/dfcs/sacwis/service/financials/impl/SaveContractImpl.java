package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.core.utility.StringHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.CapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexCapsResourceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.db.CapsResource;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.Person;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceAddress;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveContract;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveVendorOutbound;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON03SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.VendorOutboundSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON03SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON02SOG00_ARRAY;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class SaveContractImpl extends BaseServiceImpl implements SaveContract {

  private CapsResourceDAO capsResourceDAO = null;

  private ComplexCapsResourceDAO complexCapsResourceDAO = null;

  private ContractDAO contractDAO = null;

  private SaveVendorOutbound saveVendorOutbound = null;

  public void setContractDAO(ContractDAO contractDAO) {
    this.contractDAO = contractDAO;
  }

  public void setCapsResourceDAO(CapsResourceDAO capsResourceDAO) {
    this.capsResourceDAO = capsResourceDAO;
  }

  public void setSaveVendorOutbound(SaveVendorOutbound saveVendorOutbound) {
    this.saveVendorOutbound = saveVendorOutbound;
  }

  public CCON03SO saveContract(CCON03SI ccon03si) throws ServiceException {
    CCON03SO output = new CCON03SO();
    Contract contract = saveOrDeleteContract(ccon03si);
    if (contract != null) {
      output.setUlIdContract(contract.getIdContract());
      output.setTsLastUpdate(contract.getDtLastUpdate());
      output.setSzCdCntrctFuncType(contract.getCdCntrctFuncType());
      output.setSzCdCntrctProcureType(contract.getCdCntrctProcureType());
      // Set the value to CPS since Program Type is always CPS
      output.setSzCdCntrctProgramType("CPS");
      output.setSzCdCntrctRegion(contract.getCdCntrctRegion());
      output.setCIndCntrctBudgLimit(contract.getIndCntrctBudgLimit());

      output
            .setUlIdCntrctManager(contract.getPersonByIdCntrctManager().getIdPerson() != null ? contract
                                                                                                        .getPersonByIdCntrctManager()
                                                                                                        .getIdPerson()
                                                                                             : 0);
      output.setUlIdResource(contract.getCapsResource().getIdResource() != null ? contract.getCapsResource()
                                                                                          .getIdResource() : 0);
      output.setSzNmResource(contract.getCapsResource().getNmResource());
      output
            .setUlIdRsrcAddress(contract.getResourceAddress().getIdRsrcAddress() != null ? contract
                                                                                                   .getResourceAddress()
                                                                                                   .getIdRsrcAddress()
                                                                                        : 0);
      output.setSzNmPersonFull(contract.getPersonByIdCntrctWkr().getNmPersonFull());

      /**
       * Code added by Srinivas for sending information to VendorOutbound Table when the resource is contracted and
       * other conditions apply which are being verified in service class
       */

      //if stmn has been removed

        Date dtRsrcUpdated = new Date();
        VendorOutboundSI vendorOutboundSI = new VendorOutboundSI();
        vendorOutboundSI.setDtRsrcUpdated(dtRsrcUpdated);
        vendorOutboundSI.setIdResource(ccon03si.getUlIdResource());
        vendorOutboundSI.setIdRsrcAddr(ccon03si.getUlIdRsrcAddress());
        vendorOutboundSI.setUserId(ccon03si.getUlIdCntrctManager());
        saveVendorOutbound.saveNewVendor(vendorOutboundSI);

      List<CapsResource> capsResourceList = capsResourceDAO.findCapsResourceAddressess(ccon03si.getUlIdResource());
      if (capsResourceList != null && !capsResourceList.isEmpty()) {
        ROWCCON02SOG00_ARRAY rowccon02sogoo_array = new ROWCCON02SOG00_ARRAY();
        for (Iterator<CapsResource> it = capsResourceList.iterator(); it.hasNext();) {
          CapsResource capsResource = it.next();
          if (capsResource.getNbrRsrcVid() != null) {
            ROWCCON02SOG00 rowclsc06do = new ROWCCON02SOG00();
            rowclsc06do.setUlIdRsrcAddress(capsResource.getIdResource() != null ? capsResource.getIdResource() : 0);
            rowclsc06do.setSzNbrRsrcAddrVid(capsResource.getNbrRsrcVid());
            rowclsc06do.setSzAddrRsrcAddrStLn1(capsResource.getAddrRsrcStLn1());
            rowccon02sogoo_array.addROWCCON02SOG00(rowclsc06do);
          }
        }
        output.setROWCCON02SOG00_ARRAY(rowccon02sogoo_array);
      }
    }
    // repeat the 'if not null' condition again here to separate the purpose this code from above
    // this is to update the column IND_RSRC_CONTRACTED in CAPS_RESOURCE table depending on resource
    // has any active contract
    if (contract != null) {
      // updateResourceIndRsrcContracted(contract.getIdContract());
      complexCapsResourceDAO.updateResourceIndRsrcContracted(contract.getIdContract());
    }
    return output;
  }

  private Contract saveOrDeleteContract(CCON03SI ccon03si) throws ServiceException {
    String cReqFuncCd = ccon03si.getArchInputStruct().getCReqFuncCd();
    Contract contract = null;
    boolean add = ServiceConstants.REQ_FUNC_CD_ADD.equals(cReqFuncCd);
    if (add || ServiceConstants.REQ_FUNC_CD_UPDATE.equals(cReqFuncCd)) {
      if (add) {
        contract = new Contract();
      } else {
        contract = getPersistentObject(Contract.class, ccon03si.getUlIdContract());
      }
      contract.setCapsResource(getPersistentObject(CapsResource.class, ccon03si.getUlIdResource()));
      contract.setCdCntrctFuncType(ccon03si.getSzCdCntrctFuncType());
      contract.setCdCntrctProgramType(ccon03si.getSzCdCntrctProgramType());
      contract.setCdCntrctProcureType(ccon03si.getSzCdCntrctProcureType());
      contract.setCdCntrctRegion(ccon03si.getSzCdCntrctRegion());
      contract.setIndCntrctBudgLimit(ccon03si.getCIndCntrctBudgLimit());
      contract.setIndCntrctdRsrc(ccon03si.getCIndCntrctedResource());
      contract.setResourceAddress(getPersistentObject(ResourceAddress.class, ccon03si.getUlIdRsrcAddress()));
      contract.setPersonByIdCntrctManager(getPersistentObject(Person.class, ccon03si.getUlIdCntrctManager()));
      contract.setPersonByIdCntrctWkr(getPersistentObject(Person.class, ccon03si.getUlIdCntrctWkr()));
      // We call saveContract() here, so it handles both add and update properly.
      contractDAO.saveContract(contract);
      return contract;
    } else if (ServiceConstants.REQ_FUNC_CD_DELETE.equals(cReqFuncCd)) {
      // do the delete
      contract = getPersistentObject(Contract.class, ccon03si.getUlIdContract());
      contractDAO.deleteContract(contract);
      return null;
    } else {
      throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
    }
  }

  public void setComplexCapsResourceDAO(ComplexCapsResourceDAO complexCapsResourceDAO) {
    this.complexCapsResourceDAO = complexCapsResourceDAO;
  }

}
