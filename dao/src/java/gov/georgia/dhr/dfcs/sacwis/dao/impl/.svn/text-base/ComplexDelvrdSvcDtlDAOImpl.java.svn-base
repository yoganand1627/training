package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.ComplexDelvrdSvcDtlDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.DelvrdSvcDtlDAO;

public class ComplexDelvrdSvcDtlDAOImpl extends BaseDAOImpl implements ComplexDelvrdSvcDtlDAO {
  private DelvrdSvcDtlDAO delvrdSvcDtlDAO;

  public void setDelvrdSvcDtlDAO(DelvrdSvcDtlDAO delvrdSvcDtlDAO) {
    this.delvrdSvcDtlDAO = delvrdSvcDtlDAO;
  }
  
  public int updateDelvrdSvcDtl(int idSvcDtlRevrsalOrig) {
    int numRowsAffected = delvrdSvcDtlDAO.updateDelvrdSvcDtlCdSvcDtlInvoDisptn(idSvcDtlRevrsalOrig);
    numRowsAffected += delvrdSvcDtlDAO.updateDelvrdSvcDtlIdSvcDtlRevrsalOrig(idSvcDtlRevrsalOrig);
    return numRowsAffected;
  }
}
