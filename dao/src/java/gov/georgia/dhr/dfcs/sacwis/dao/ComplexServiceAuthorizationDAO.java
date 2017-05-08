package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;

public interface ComplexServiceAuthorizationDAO {
  /**
   * Calls CommonDAO and creates a new primary key followed by 'insert' operation using the method
   * ServiceAuthorizationDAO.insertServiceAuthorization().
   * 
   * @param idPrimaryClient
   * @param dtLastUpdate
   * @param cdSvcAuthCounty
   * @param idResource
   * @param idContract
   * @param cdSvcAuthCategory
   * @param cdSvcAuthRegion
   * @param cdSvcAuthService
   * @param indSvcAuthComplete
   * @param txtSvcAuthComments
   * @param txtSvcAuthSecProvdr
   * @param dtSvcAuthEff
   * @param indDntdCmmtySvc
   * @return int The idSvcAuth (newly created)
   */
  int insertServiceAuthorization(int idResource, int idContract, String cdSvcAuthCategory, String cdSvcAuthCounty,
                                 String cdSvcAuthService, String txtSvcAuthComments, String txtSvcAuthSecProvdr,
                                 Date dtLastUpdate, int idPrimaryClient, Date dtSvcAuthEff, String cIndWaiverReqd,
                                 Date dtRefSent, String cdPayCnty, int idWaiver, String cdPupTyp, String cdErlyCaseTyp,
                                 String cdPupOtcme);
}
