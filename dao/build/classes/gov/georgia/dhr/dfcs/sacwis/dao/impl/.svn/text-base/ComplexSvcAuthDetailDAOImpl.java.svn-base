package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexSvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.SvcAuthDetailDAO;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;

public class ComplexSvcAuthDetailDAOImpl extends BaseDAOImpl implements ComplexSvcAuthDetailDAO {
  CommonDAO commonDAO;

  SvcAuthDetailDAO svcAuthDetailDAO;

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public void setSvcAuthDetailDAO(SvcAuthDetailDAO svcAuthDetailDAO) {
    this.svcAuthDetailDAO = svcAuthDetailDAO;
  }

  public void saveSvcAuthDetail(SvcAuthDetail svcAuthDetail) {
    if (svcAuthDetail.getIdSvcAuthDtl() == 0) {
      int idSvcAuthDtl = commonDAO.getNextval("SEQ_SVC_AUTH_DETAIL");
      svcAuthDetail.setIdSvcAuthDtl(idSvcAuthDtl);
    }
    int idSvcAuthDtl = svcAuthDetailDAO.saveSvcAuthDetail(svcAuthDetail);
    if(idSvcAuthDtl==0){
      throw new ServiceException(Messages.MSG_CMN_TMSTAMP_MISMATCH);
    }
  }

}
