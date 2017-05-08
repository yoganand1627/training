package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;

public class ComplexContractPeriodDAOImpl extends BaseDAOImpl implements ComplexContractPeriodDAO {
  private ContractCountyDAO contractCountyDAO = null;
  private ContractServiceDAO contractServiceDAO = null;
  private ContractVersionDAO contractVersionDAO = null;
  private ContractPeriodDAO contractPeriodDAO = null;

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public int deleteContractPeriod(int idContract, int nbrCnverPeriod, int nbrCnverVersion, Date dtLastUpdate) {
    int nbrRowsDeleted = contractCountyDAO.deleteContractCounty(idContract, nbrCnverPeriod);
    nbrRowsDeleted += contractServiceDAO.deleteContractService(idContract, nbrCnverPeriod);
    nbrRowsDeleted += contractVersionDAO.deleteContractVersion(idContract, nbrCnverPeriod, nbrCnverVersion, dtLastUpdate);
    nbrRowsDeleted += contractPeriodDAO.deleteContractPeriod(idContract, nbrCnverPeriod, dtLastUpdate);
    return nbrRowsDeleted;
  }
}
