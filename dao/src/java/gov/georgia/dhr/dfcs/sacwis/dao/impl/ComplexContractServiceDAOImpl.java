package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractServiceDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractVersionDAO;

public class ComplexContractServiceDAOImpl extends BaseDAOImpl implements ComplexContractServiceDAO {
  private ContractCountyDAO contractCountyDAO = null;
  private ContractServiceDAO contractServiceDAO = null;
  private ContractVersionDAO contractVersionDAO = null;

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public void setContractServiceDAO(ContractServiceDAO contractServiceDAO) {
    this.contractServiceDAO = contractServiceDAO;
  }

  public void setContractVersionDAO(ContractVersionDAO contractVersionDAO) {
    this.contractVersionDAO = contractVersionDAO;
  }

  public void deleteContractCountyServiceAndVersion(int idContract, int nbrCnverPeriod, int nbrCnverVersion,
                                                    Date dtLastUpdate) {
    contractCountyDAO.deleteContractCounty(idContract, nbrCnverPeriod, nbrCnverVersion);
    contractServiceDAO.deleteContractService(idContract, nbrCnverPeriod, nbrCnverVersion);
    contractVersionDAO.deleteContractVersion(idContract, nbrCnverPeriod, nbrCnverVersion, dtLastUpdate);
  }
}
