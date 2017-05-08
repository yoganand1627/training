package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractCountyDAO;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveContractCounties;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.ContractCountiesSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.ContractCountiesSO;

import java.util.Date;
import java.util.List;

public class RetrieveContractCountiesImpl extends BaseServiceImpl implements RetrieveContractCounties {
  
  private ContractCountyDAO contractCountyDAO;

  public void setContractCountyDAO(ContractCountyDAO contractCountyDAO) {
    this.contractCountyDAO = contractCountyDAO;
  }

  public ContractCountiesSO retrieveContractCounties(ContractCountiesSI si) {
    ContractCountiesSO so = new ContractCountiesSO();
    
    int idContract = si.getIdContract();
    if(idContract > 0) {
      Date dtEffective = si.getDtEffective();
      
      List<Object[]> countyServices = null;
      if(DateHelper.isNull(dtEffective)) {
        countyServices = contractCountyDAO.findDistinctCountyServiceByIdContract(idContract);
      } else {
        countyServices = contractCountyDAO.findEffectiveCountyServiceByIdContract(idContract, dtEffective);
      }
      if(countyServices != null && !countyServices.isEmpty()) {
        for(Object[] countyService : countyServices) {
          String county = (String) countyService[0];
          String serviceCode = (String) countyService[1];
          so.addServiceCode(county, serviceCode);
        }
      }
    }
    
    return so;
  }

}
