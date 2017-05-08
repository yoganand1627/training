package gov.georgia.dhr.dfcs.sacwis.service.financials.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.dao.PolicyWaiverDAO;
import gov.georgia.dhr.dfcs.sacwis.db.PolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.service.financials.RetrieveSvcAuthPolicyWaiver;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PolicyWaiverRetrieveSO;

public class RetrieveSvcAuthPolicyWaiverImpl extends BaseServiceImpl implements RetrieveSvcAuthPolicyWaiver {

  private PolicyWaiverDAO policyWaiverDAO = null;

  public void setPolicyWaiverDAO(PolicyWaiverDAO policyWaiverDAO) {
    this.policyWaiverDAO = policyWaiverDAO;
  }

  public PolicyWaiverRetrieveSO retrieveSvcAuthPolicyWaiver(int idEvent) throws ServiceException {

    PolicyWaiver policyWaiver = policyWaiverDAO.findPolicyWaiverByIdEvent(idEvent);
    PolicyWaiverRetrieveSO policyWaiverBean = new PolicyWaiverRetrieveSO();
    policyWaiverBean.setCdWvrEntCd(policyWaiver.getCdWvrEntCd());
    policyWaiverBean.setCdWvrUasCd(policyWaiver.getCdWvrUasCd());
    if (policyWaiver.getCdWvrSvcDesc() != null) {
      policyWaiverBean.setCdWvrSvcDesc(policyWaiver.getCdWvrSvcDesc());
    }

    return policyWaiverBean;
  }
}
