package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveContractService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON11SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON11SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG00_ARRAY;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON11SOG01_ARRAY;

public class RetrieveContractServiceImpl extends BaseServiceImpl implements RetrieveContractService {

  private ContractServiceDAO contractServiceDAO = null;

  private ResourceServiceDAO resourceServiceDAO = null;

  public void setResourceServiceDAO(ResourceServiceDAO resourceServiceDAO) {
    this.resourceServiceDAO = resourceServiceDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public CCON11SO findContractService(CCON11SI ccon11si) throws ServiceException {
    CCON11SO ccon11so = new CCON11SO();
    Integer nbrCnsvcLineItem = contractServiceDAO.findMaxCnsvcLineItemByIdContract(ccon11si.getUlIdContract());
    ccon11so.setUlNbrCnsvcLineItem(nbrCnsvcLineItem != null ? nbrCnsvcLineItem : 0);

    List<String> cdRsrcServices = resourceServiceDAO.findServiceCodeListByResourceAndType(ccon11si.getUlIdResource(), "F");
    if (cdRsrcServices == null || cdRsrcServices.size() == 0) {
      throw new ServiceException(Messages.MSG_CON_NO_SVC_CODE);
    }
    ROWCCON11SOG01_ARRAY rowccon11sogo1_array = new ROWCCON11SOG01_ARRAY();
    for (Iterator<String> it = cdRsrcServices.iterator(); it.hasNext();) {
      String cdRsrcService = it.next();
      ROWCCON11SOG01 rowccon11sogo1 = new ROWCCON11SOG01();
      rowccon11sogo1.setSzCdRsrcSvcService(cdRsrcService);
      rowccon11sogo1_array.addROWCCON11SOG01(rowccon11sogo1);
    }
    ccon11so.setROWCCON11SOG01_ARRAY(rowccon11sogo1_array);

    List<ContractService> services = contractServiceDAO
                                                       .findConSvcByIdConAndNbrCnsvcPeriodAndNbrCnsvcVersion(
                                                                                                             ccon11si
                                                                                                                     .getUlNbrCnperPeriod(),
                                                                                                             ccon11si
                                                                                                                     .getUlNbrCnverVersion(),
                                                                                                             ccon11si
                                                                                                                     .getUlIdContract());
    if (services != null) {
      ROWCCON11SOG00_ARRAY rowccon11sog00_array = new ROWCCON11SOG00_ARRAY();
      for (Iterator<ContractService> it = services.iterator(); it.hasNext();) {

        ContractService contractService = it.next();
        ROWCCON11SOG00 rowccon11sog00 = new ROWCCON11SOG00();
        rowccon11sog00.setCIndCnsvcNewRow(contractService.getIndCnsvcNewRow());
        rowccon11sog00.setSzCdCnsvcPaymentType(contractService.getCdCnsvcPaymentType());
        rowccon11sog00.setSzCdCnsvcService(contractService.getCdCnsvcService());
        rowccon11sog00.setSzNbrCnsvcUnitType(contractService.getCdCnsvcUnitType());
        rowccon11sog00.setTsLastUpdate(contractService.getDtLastUpdate());
        Double amtCnsvcAdminAllUsed = contractService.getAmtCnsvcAdminAllUsed();
        if (amtCnsvcAdminAllUsed != null) {
          rowccon11sog00.setUlAmtCnsvcAdminAllUsed(amtCnsvcAdminAllUsed);
        }
        Double amtCnsvcEquip = contractService.getAmtCnsvcEquip();
        if (amtCnsvcEquip != null) {
          rowccon11sog00.setUlAmtCnsvcEquip(amtCnsvcEquip);
        }
        rowccon11sog00
                      .setUlAmtCnsvcEquipUsed(contractService.getAmtCnsvcEquipUsed() != null ? contractService
                                                                                                              .getAmtCnsvcEquipUsed()
                                                                                            : 0);
        rowccon11sog00
                      .setUlAmtCnsvcFrgBenft(contractService.getAmtCnsvcFrgBenft() != null ? contractService
                                                                                                            .getAmtCnsvcFrgBenft()
                                                                                          : 0);
        rowccon11sog00
                      .setUlAmtCnsvcFrgBenftUsed(contractService.getAmtCnsvcFrgBenftUsed() != null ? contractService
                                                                                                                    .getAmtCnsvcFrgBenftUsed()
                                                                                                  : 0);
        rowccon11sog00
                      .setUlAmtCnsvcOffItemUsed(contractService.getAmtCnsvcOffItemUsed() != null ? contractService
                                                                                                                  .getAmtCnsvcOffItemUsed()
                                                                                                : 0);
        rowccon11sog00
                      .setUlAmtCnsvcOther(contractService.getAmtCnsvcOther() != null ? contractService
                                                                                                      .getAmtCnsvcOther()
                                                                                    : 0);
        rowccon11sog00
                      .setUlAmtCnsvcOtherUsed(contractService.getAmtCnsvcOtherUsed() != null ? contractService
                                                                                                              .getAmtCnsvcOtherUsed()
                                                                                            : 0);
        rowccon11sog00
                      .setUlAmtCnsvcSalary(contractService.getAmtCnsvcSalary() != null ? contractService
                                                                                                        .getAmtCnsvcSalary()
                                                                                      : 0);
        rowccon11sog00
                      .setUlAmtCnsvcSalaryUsed(contractService.getAmtCnsvcSalaryUsed() != null ? contractService
                                                                                                                .getAmtCnsvcSalaryUsed()
                                                                                              : 0);
        rowccon11sog00
                      .setUlAmtCnsvcSupply(contractService.getAmtCnsvcSupply() != null ? contractService
                                                                                                        .getAmtCnsvcSupply()
                                                                                      : 0);
        rowccon11sog00
                      .setUlAmtCnsvcSupplyUsed(contractService.getAmtCnsvcSupplyUsed() != null ? contractService
                                                                                                                .getAmtCnsvcSupplyUsed()
                                                                                              : 0);
        rowccon11sog00
                      .setUlAmtCnsvcTravel(contractService.getAmtCnsvcTravel() != null ? contractService
                                                                                                        .getAmtCnsvcTravel()
                                                                                      : 0);
        rowccon11sog00
                      .setUlAmtCnsvcTravelUsed(contractService.getAmtCnsvcTravelUsed() != null ? contractService
                                                                                                                .getAmtCnsvcTravelUsed()
                                                                                              : 0);
        rowccon11sog00
                      .setUlAmtCnsvcUnitRate(contractService.getAmtCnsvcUnitRate() != null ? contractService
                                                                                                            .getAmtCnsvcUnitRate()
                                                                                          : 0);
        rowccon11sog00
                      .setUlAmtCnsvcUnitRateUsed(contractService.getAmtCnsvcUnitRateUsed() != null ? contractService
                                                                                                                    .getAmtCnsvcUnitRateUsed()
                                                                                                  : 0);
        rowccon11sog00.setUlIdCnsvc(contractService.getIdCnsvc() != null ? contractService.getIdCnsvc() : 0);
        rowccon11sog00
                      .setUlNbrCnsvcFedMatch(contractService.getNbrCnsvcFedMatch() != null ? contractService
                                                                                                            .getNbrCnsvcFedMatch()
                                                                                          : 0);
        rowccon11sog00
                      .setUlNbrCnsvcLineItem(contractService.getNbrCnsvcLineItem() != null ? contractService
                                                                                                            .getNbrCnsvcLineItem()
                                                                                          : 0);
        rowccon11sog00
                      .setUlNbrCnsvcLocalMatch(contractService.getNbrCnsvcLocalMatch() != null ? contractService
                                                                                                                .getNbrCnsvcLocalMatch()
                                                                                              : 0);
        rowccon11sog00.setUlNbrCnsvcUnitRate(contractService.getNbrCnsvcUnitRate());
        rowccon11sog00_array.addROWCCON11SOG00(rowccon11sog00);
      }
      ccon11so.setROWCCON11SOG00_ARRAY(rowccon11sog00_array);
    }
    return ccon11so;
  }
}
