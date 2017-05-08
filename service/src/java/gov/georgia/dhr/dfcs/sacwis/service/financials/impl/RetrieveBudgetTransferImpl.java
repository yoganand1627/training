package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Iterator;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.db.ContractService;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveBudgetTransfer;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON09SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON09SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ROWCCON09SOG00_ARRAY;

public class RetrieveBudgetTransferImpl extends BaseServiceImpl implements RetrieveBudgetTransfer {

  private ContractServiceDAO contractServiceDAO = null;

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public CCON09SO retrieveBudgetTransfer(CCON09SI ccon09si) throws ServiceException {
    CCON09SO ccon09so = new CCON09SO();

    List<ContractService> contractServiceList =
            contractServiceDAO.findContractServiceAll(ccon09si.getUlNbrCnverPeriod(),
                                                      ccon09si.getUlNbrCnverVersion(),
                                                      ccon09si.getUlIdContract());
    if (contractServiceList == null) {
      throw new ServiceException(Messages.SQL_NOT_FOUND);
    }
    ROWCCON09SOG00_ARRAY rowccon09sog00_array = new ROWCCON09SOG00_ARRAY();
    for (Iterator<ContractService> it = contractServiceList.iterator(); it.hasNext();) {
      ContractService contractService = it.next();
      ROWCCON09SOG00 rowccon09sog00 = new ROWCCON09SOG00();
      rowccon09sog00.setTsLastUpdate(contractService.getDtLastUpdate());
      rowccon09sog00.setUlIdCnsvc(contractService.getIdCnsvc() != null ? contractService.getIdCnsvc() : 0);
      rowccon09sog00.setUlNbrCnsvcLineItem(
              contractService.getNbrCnsvcLineItem() != null ? contractService.getNbrCnsvcLineItem() : 0);
      rowccon09sog00.setUlAmtCnsvcAdminAllUsed(contractService.getAmtCnsvcAdminAllUsed());
      rowccon09sog00.setUlAmtCnsvcEquip(contractService.getAmtCnsvcEquip());
      rowccon09sog00.setUlAmtCnsvcEquipUsed(contractService.getAmtCnsvcEquipUsed());
      rowccon09sog00.setUlAmtCnsvcFrgBenft(contractService.getAmtCnsvcFrgBenft());
      rowccon09sog00.setUlAmtCnsvcFrgBenftUsed(contractService.getAmtCnsvcFrgBenftUsed());
      rowccon09sog00.setUlAmtCnsvcSalary(contractService.getAmtCnsvcSalary());
      rowccon09sog00.setUlAmtCnsvcSalaryUsed(contractService.getAmtCnsvcSalaryUsed());
      rowccon09sog00.setUlAmtCnsvcSupply(contractService.getAmtCnsvcSupply());
      rowccon09sog00.setUlAmtCnsvcSupplyUsed(contractService.getAmtCnsvcSupplyUsed());
      rowccon09sog00.setUlAmtCnsvcTravel(contractService.getAmtCnsvcTravel());
      rowccon09sog00.setUlAmtCnsvcTravelUsed(contractService.getAmtCnsvcTravelUsed());
      rowccon09sog00.setUlAmtCnsvcOther(contractService.getAmtCnsvcOther());
      rowccon09sog00.setUlAmtCnsvcOtherUsed(contractService.getAmtCnsvcOtherUsed());
      rowccon09sog00.setUlAmtCnsvcUnitRate(contractService.getAmtCnsvcUnitRate());
      rowccon09sog00.setUlAmtCnsvcUnitRateUsed(contractService.getAmtCnsvcUnitRateUsed());
      rowccon09sog00.setSzCdCnsvcService(contractService.getCdCnsvcService());
      rowccon09sog00.setSzCdCnsvcPaymentType(contractService.getCdCnsvcPaymentType());
      rowccon09sog00_array.addROWCCON09SOG00(rowccon09sog00);
    }
    ccon09so.setROWCCON09SOG00_ARRAY(rowccon09sog00_array);
    return ccon09so;
  }
}
