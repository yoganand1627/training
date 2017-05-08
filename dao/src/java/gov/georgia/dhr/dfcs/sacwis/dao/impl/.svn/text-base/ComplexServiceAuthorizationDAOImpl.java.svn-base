package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ComplexServiceAuthorizationDAO;
import gov.georgia.dhr.dfcs.sacwis.dao.ServiceAuthorizationDAO;

public class ComplexServiceAuthorizationDAOImpl extends BaseDAOImpl implements ComplexServiceAuthorizationDAO {
  private ServiceAuthorizationDAO serviceAuthorizationDAO = null;

  private CommonDAO commonDAO = null;

  public void setServiceAuthorizationDAO(ServiceAuthorizationDAO serviceAuthorizationDAO) {
    this.serviceAuthorizationDAO = serviceAuthorizationDAO;
  }

  public void setCommonDAO(CommonDAO commonDAO) {
    this.commonDAO = commonDAO;
  }

  public int insertServiceAuthorization(int idResource, int idContract, 
                                        String cdSvcAuthCategory, String cdSvcAuthCounty,
                                        String cdSvcAuthService, String txtSvcAuthComments, String txtSvcAuthSecProvdr,
                                        Date dtLastUpdate, int idPrimaryClient, Date dtSvcAuthEff,
                                         String cIndWaiverReqd, Date dtRefSent,
                                        String cdPayCnty, int idWaiver, String cdPupTyp, String cdErlyCaseTyp,
                                        String cdPupOtcme) {
    // generating new idSvcAuth to be passes into the 'insert' operation below
    int idSvcAuth = commonDAO.getNextval("SEQ_SERVICE_AUTHORIZATION");
    serviceAuthorizationDAO.insertServiceAuthorization(idSvcAuth, idPrimaryClient, dtLastUpdate, cdSvcAuthCounty,
                                                       idResource, idContract, cdSvcAuthCategory,
                                                       cdSvcAuthService,  txtSvcAuthComments,
                                                       txtSvcAuthSecProvdr, dtSvcAuthEff, 
                                                       cIndWaiverReqd, dtRefSent, cdPayCnty, idWaiver, cdPupTyp,
                                                       cdErlyCaseTyp, cdPupOtcme);
    return idSvcAuth;
  }
}
