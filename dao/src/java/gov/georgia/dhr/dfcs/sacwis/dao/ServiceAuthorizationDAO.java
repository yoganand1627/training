/**
 * Created on Mar 25, 2006 at 3:34:13 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.Placement;
import gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization;
import gov.georgia.dhr.dfcs.sacwis.db.SvcAuthDetail;

public interface ServiceAuthorizationDAO {
  /**
   * @param idSvcAuth
   * @return A populated {@link ServiceAuthorization} object.
   */
  ServiceAuthorization findServiceAuth(int idSvcAuth);

  /**
   * @param idSvcAuthEvent
   * @return A populated {@link ServiceAuthorization} object.
   */
  ServiceAuthorization findServiceAuthEventLink(int idSvcAuthEvent);
  
//Added for STGAP00012399 ,STGAP00012838 
  /**
   * 
   * Find ServiceAuthorization Records 
   * @param idPersonClosed
   * @return List of ServiceAuthorization objects.
   */
  public List<ServiceAuthorization> findServAuthByIdPrimaryClient(int idPersonClosed);

  /**
   * @param idSvcAuthDtl
   * @return A populated {@link SvcAuthDetail} object.
   */
  SvcAuthDetail findServiceAuthDetail(int idSvcAuthDtl);

  /**
   * Locate a Service Authorization ID based on a Contract ID, a Resource ID,
   * and the Service Detail code.
   * @param idContract
   * @param idResource
   * @param cdSvcDtl
   * @return
   */
  public int findIdServiceAuthByIdContractIdRsrcCdSvcDtl(int idContract, int idResource, String cdSvcDtl);


  
  /**
   * Locate a Service Authorization ID for a primary client
   * @param idPrimaryClient
   * @param cdSvcDtl
   * @return
   */
  public int findServiceAuthByIdPrimaryClient(int idPrimaryClient, String cdSvcDtl, double amountAdoSub);

  /**
   * Adds to the SERVICE_AUTHORIZATION table <p/> Note that, this is done in straight sql.
   * 
   * @param idSvcAuth
   * @param idPrimaryClient
   * @param dtLastUpdate
   * @param cdSvcAuthCounty
   * @param idResource
   * @param idContract
   * @param cdSvcAuthCategory
   * @param cdSvcAuthService
   * @param txtSvcAuthComments
   * @param txtSvcAuthSecProvdr
   * @param dtSvcAuthEff
   */
  int insertServiceAuthorization(int idSvcAuth, int idPrimaryClient, Date dtLastUpdate, String cdSvcAuthCounty,
                                 int idResource, int idContract, String cdSvcAuthCategory, String cdSvcAuthService,
                                 String txtSvcAuthComments, String txtSvcAuthSecProvdr, Date dtSvcAuthEff,
                                 String cIndWaiverReqd, Date dtRefSent, String cdPayCnty, int idWaiver,
                                 String cdPupTyp, String cdErlyCaseTyp, String cdPupOtcme);

  /**
   * Updates a {@link gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization} object to the database.
   * 
   * @param cdSvcAuthCounty
   * @param idResource
   * @param idContract
   * @param cdSvcAuthCategory
   * @param cdSvcAuthRegion
   * @param cdSvcAuthService
   * @param indSvcAuthComplete
   * @param indDontdComntySvc
   * @param txtSvcAuthComments
   * @param txtSvcAuthSecProvdr
   * @return Integer
   */
  int updateServiceAuthorization(String cdSvcAuthCounty, int idResource, int idContract, String cdSvcAuthCategory,
                                 String cdSvcAuthService, String txtSvcAuthComments, String txtSvcAuthSecProvdr,
                                 int idSvcAuth, Date dtLastUpdate, String cIndWaiverReqd, Date dtRefSent,
                                 String cdPayCnty, int idWaiver, String cdPupTyp, String cdErlyCaseTyp,
                                 String cdPupOtcme);
  
//Added for STGAP00012399 ,STGAP00012838 
  /**
   * Updates a Service Authorization record with idForward where idPrimaryClient is idPersonClosed
   * @param idPersonClosed
   * @param idPersonForward
   * 
   */
  int updateServiceAuthorizationWithForwardPerson(int idPersonForward, int idPersonClosed);

  /**
   * Calls COMPLEX_DELETE.DELETE_SERVICE_AUTH() in order to delete a service authorization.
   * 
   * @param idSvcAuth
   * @return The number of records deleted.
   */
  int deleteServiceAuthorization(int idSvcAuth);
  
  /**
   * Saves a {@link gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization} object to the database.
   * 
   * @param serviceAuthorization
   *          A populated {@link gov.georgia.dhr.dfcs.sacwis.db.ServiceAuthorization} object.
   */
  void saveServiceAuthorization(ServiceAuthorization serviceAuthorization);
}
