package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import java.util.Date;
import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ServiceConstants;
import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.SaveContractService;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ROWCCON10SIG00;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON10SO;

public class SaveContractServiceImpl extends BaseServiceImpl implements SaveContractService {

  private ContractServiceDAO contractServiceDAO = null;

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public CCON10SO saveContractService(CCON10SI ccon10si) throws ServiceException {
    CCON10SO output = new CCON10SO();

    for (Enumeration rowccon10sigooEnum = ccon10si.getROWCCON10SIG00_ARRAY().enumerateROWCCON10SIG00();
         rowccon10sigooEnum.hasMoreElements();) {
      ROWCCON10SIG00 rowccon10sigoo = (ROWCCON10SIG00) rowccon10sigooEnum.nextElement();
      if (!ServiceConstants.REQ_FUNC_CD_UPDATE.equals(rowccon10sigoo.getSzCdScrDataAction())) {
        throw new ServiceException(Messages.ARC_ERR_BAD_FUNC_CD);
      }
      int idCntrctWkr = ccon10si.getUlIdCntrctWkr();
      double amtCnsvcEquip = rowccon10sigoo.getUlAmtCnsvcEquip();
      double amtCnsvcFrgBenft = rowccon10sigoo.getUlAmtCnsvcFrgBenft();
      double amtCnsvcOther = rowccon10sigoo.getUlAmtCnsvcOther();
      double amtCnsvcSalary = rowccon10sigoo.getUlAmtCnsvcSalary();
      double amtCnsvcSupply = rowccon10sigoo.getUlAmtCnsvcSupply();
      double amtCnsvcTravel = rowccon10sigoo.getUlAmtCnsvcTravel();
      double amtCnsvcUnitRate = rowccon10sigoo.getUlAmtCnsvcUnitRate();
      int idCnsvc = rowccon10sigoo.getUlIdCnsvc();
      Date lastUpdate = rowccon10sigoo.getTsLastUpdate();
      // Calling caud06d.pc
      if (0 == contractServiceDAO.updateContractService(idCntrctWkr, amtCnsvcEquip, amtCnsvcFrgBenft, amtCnsvcOther,
                                                        amtCnsvcSalary, amtCnsvcSupply, amtCnsvcTravel,
                                                        amtCnsvcUnitRate, idCnsvc, lastUpdate)) {
        throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
      }
    }
    return output;
  }
}
