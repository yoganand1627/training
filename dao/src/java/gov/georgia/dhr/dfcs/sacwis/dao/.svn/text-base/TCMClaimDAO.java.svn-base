package gov.georgia.dhr.dfcs.sacwis.dao;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.db.TcmClaimInbound;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaimOutbound;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;

/*Change History:
Date        User      Description
----------  --------  --------------------------------------------------
                          
08/04/03    mxpatel    STGAP00009781: calling a method saveTCMClaimPersonMerge(int idPersMergeForward, int idPersMergeClosed)to update the TcmClaim Table after merging two people.                               
07/09/2009  arege      STGAP00014326: Added method findTcmClaimByidPersonidEventidStage  
*/
public interface TCMClaimDAO {
  /**
   * Retrieves all TCM_CLAIM entries for the associated ID_PERSON with a DT_SERVICE falling between
   * the from and to dates given.
   * 
   * @param idPerson
   * @param from
   * @param to
   * @return
   */
  List<TcmClaim> findTcmClaim(int idPerson, Date from, Date to);
  
  /**
   * Calls the Hibernate API method Session#saveOrUpdate to insert or update a TCM_CLAIM record
   * based on the persistent state of the TcmClaim object given.
   * 
   * @param tcmClaim
   */
  void saveTCMClaim(TcmClaim tcmClaim);
  
  /**
   * Calls the Hibernate API method Session#saveOrUpdate to insert or update a TCM_CLAIM record
   * based on the persistent state of the TcmClaim object given.
   * 
   * @param tcmClaim
   */
  int saveTCMClaimInterface(int idTcmClaim, Date dtLastUpdate, String cdDenial, String nbrTcn, Date dtPay, String nbrRa);

  /**
   * Calls the Hibernate API method Session#saveOrUpdate to insert or update a TCM_CLAIM_INBOUND record
   * based on the persistent state of the TcmClaim object given.
   * 
   * @param tcmClaimInbound
   */
  int saveTCMClaimInbound(int idTcmClaimOut, String cdDenial, String nbrTcn, Date dtPay, String nbrRa, String cdStatus);
  
  /**
   * Interface method used to find data for the Inbound web Service for TCM
   * 
   * @param context
   *          Accepts the id as the input Returns the row for the id in the database
   */
  public TcmClaimOutbound findTcmClaimByTransactionId(int id);
  
  //mxpatel
   int saveTCMClaimPersonMerge(int idPersMergeForward, int idPersMergeClosed);
   public int updateTcmClaimStatus(int idTcmClaim, String cdNewStatus);
   
   //STGAP00014326   MR-024
   /**
    * Find TCMClaim record for given idPerson, idEvent and idStage
    * 
    * @param idPerson
    * @param idEvent
    * @param idStage
    * @return
    */
   public TcmClaim findTcmClaimByidPersonidEventidStage(int idPerson,int idEvent, int idStage); 
   
   
}
