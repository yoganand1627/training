package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractCounty;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.service.financials.ContractValidation;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCON20SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCON20SO;

public class ContractValidationImpl extends BaseServiceImpl implements ContractValidation {

  private ContractCountyDAO contractCountyDAO = null;

  private ContractPeriodDAO contractPeriodDAO = null;

  public static final int NUM_PERIOD = 1;

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public CCON20SO contractValidation(CCON20SI ccon20si) throws ServiceException {
    CCON20SO ccon20so = new CCON20SO();

    // Calling csec10d
    ContractCounty contractCounty = contractCountyDAO
                                                     .findContractCountyWithinDateRangeSvAuth(
                                                                                              ccon20si
                                                                                                      .getUlIdResource(),
                                                                                              ccon20si
                                                                                                      .getSzCdSvcAuthCounty(),
                                                                                              ccon20si
                                                                                                      .getSzCdSvcAuthService(),
                                                                                              DateHelper
                                                                                                        .toJavaDate(ccon20si
                                                                                                                            .getDtDtSvcAuthEff()));
    if (contractCounty == null) {
      throw new ServiceException(Messages.MSG_CON_NO_ACTIVE_CONTRACT);
    }
    Integer idContract = null;
    idContract = contractCounty.getContract().getIdContract();
    ccon20so.setUlIdContract(idContract != null ? idContract : 0);
    Integer nbrCncntyPeriod = contractCounty.getNbrCncntyPeriod();
    ccon20so.setUlNbrCncntyPeriod(nbrCncntyPeriod != null ? nbrCncntyPeriod : 0);
    Integer nbrCncntyVersion = contractCounty.getNbrCncntyVersion();
    ccon20so.setUlNbrCncntyVersion(nbrCncntyVersion != null ? nbrCncntyVersion : 0);

    // Calling csec11d
    ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodAndContract(ccon20so.getUlIdContract(),
                                                                                    ccon20so.getUlNbrCncntyPeriod());

    if (contractPeriod == null) {
      throw new ServiceException(Messages.MSG_CON_NO_ACTIVE_CONTRACT);
    }
    Contract contract = contractPeriod.getContract();
    Integer idCntrctManager = contract.getPersonByIdCntrctManager().getIdPerson();
    ccon20so.setUlIdCntrctManager(idCntrctManager != null ? idCntrctManager : 0);
    idContract = contract.getIdContract();
    ccon20so.setUlIdContract(idContract != null ? idContract : 0);
    ccon20so.setCIndCnperRenewal(contractPeriod.getIndCnperRenewal());
    ccon20so.setDtDtCnperStart(DateHelper.toCastorDate(contractPeriod.getDtCnperStart()));
    ccon20so.setDtDtCnperClosure(DateHelper.toCastorDate(contractPeriod.getDtCnperClosure()));
    ccon20so.setSzCdCntrctRegion(contract.getCdCntrctRegion());
    ccon20so.setSzCdCnperStatus(contractPeriod.getCdCnperStatus());
    ccon20so.setCIndCntrctBudgLimit(contract.getIndCntrctBudgLimit());
    if (NUM_PERIOD != contractPeriod.getId().getNbrCnperPeriod()) {
      // Calling csec12d
      ContractPeriod contractPeriod2 = contractPeriodDAO
                                                        .findContractPeriodWithIdContractAndNbrCnperPeriod(
                                                                                                           ccon20so
                                                                                                                   .getUlIdContract(),
                                                                                                           NUM_PERIOD);
      if (contractPeriod2 != null) {
        ccon20so.setDtDtCnperStart(DateHelper.toCastorDate(contractPeriod2.getDtCnperStart()));
      }
    }

    return ccon20so;
  }

}
