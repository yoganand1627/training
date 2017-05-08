package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

/**
 * Service consisting of method to retrieve and return home approval date using either the contract ID or the resource ID
 *
 * @author Corey Harden, 28 July 2008
 */

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ContractPeriodDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ResourceHistoryDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Contract;
import gov.georgia.dhr.dfcs.sacwis.db.ContractPeriod;
import gov.georgia.dhr.dfcs.sacwis.db.ResourceHistory;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.DtLicBeginSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.DtLicBeginSO;

import java.util.Iterator;
import java.util.List;


public class RetrieveCnperStartImpl extends BaseServiceImpl
                                                           implements
                                                           gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveCnperStart {

  private ResourceHistoryDAO resourceHistoryDAO = null;
  
  private ContractDAO contractDAO = null;
  
  private ContractPeriodDAO contractPeriodDAO = null;

  public void setResourceHistoryDAO(ResourceHistoryDAO resourceHistoryDAO) throws ServiceException {
    this.resourceHistoryDAO = resourceHistoryDAO;
  }
  
  public void setContractDAO(ContractDAO contractDAO) throws ServiceException {
    this.contractDAO = contractDAO;
  }
  
  public void setContractPeriodDAO(ContractPeriodDAO contractPeriodDAO) throws ServiceException {
    this.contractPeriodDAO = contractPeriodDAO;
  }

  public DtLicBeginSO retrieveDtCnperStart(DtLicBeginSI dtLicBeginSI) {

    DtLicBeginSO dtLicBeginSO = new DtLicBeginSO();
    List<ResourceHistory> rsrcHistory = null;
    Iterator<ResourceHistory> it = rsrcHistory.iterator();
    ResourceHistory resourceHistoryRow = new ResourceHistory();
    int firstPeriod = 1;
    while (it.hasNext()) {
      if(dtLicBeginSI.getNmbrPeriod() == 1){
      resourceHistoryRow = it.next();
      if (null != resourceHistoryRow.getDtLicBegin()) {
        dtLicBeginSO.setdtDtCnperStart(resourceHistoryRow.getDtLicBegin());
        break;
      }else{
        ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodWithIdContractAndNbrCnperPeriod(dtLicBeginSI.getIdContract(), firstPeriod);
        dtLicBeginSO.setdtDtCnperStart(contractPeriod.getDtCnperStart());
        break;
      }
    }
      else if(dtLicBeginSI.getNmbrPeriod() == 0){
        ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodWithIdContractAndNbrCnperPeriod(dtLicBeginSI.getIdContract(), firstPeriod);
        dtLicBeginSO.setdtDtCnperStart(contractPeriod.getDtCnperStart());
        break;
      }else{
        ContractPeriod contractPeriod = contractPeriodDAO.findContractPeriodWithIdContractAndNbrCnperPeriod(dtLicBeginSI.getIdContract(), dtLicBeginSI.getNmbrPeriod());
        dtLicBeginSO.setdtDtCnperStart(contractPeriod.getDtCnperStart());
        break;
      }
    }

    return (dtLicBeginSO);
  }
}