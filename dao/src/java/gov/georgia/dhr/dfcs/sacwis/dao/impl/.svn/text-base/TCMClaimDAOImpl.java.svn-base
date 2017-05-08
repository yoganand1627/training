package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.TCMClaimDAO;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaim;
import gov.georgia.dhr.dfcs.sacwis.db.TcmClaimOutbound;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;

/**
 * <pre>
 * Change History:
 * Date        User      Description
 * ----------  --------  --------------------------------------------------
 * 08/04/03    mxpatel   STGAP00009781: created a method saveTCMClaimPersonMerge(int idPersMergeForward, int idPersMergeClosed)to update the TcmClaim Table after merging two people. 
 * 03/26/09    Van Vo    MR-026 STGAP00013024: add updateTcmClaimStatus to update claim status
 * 07/09/09    arege     STGAP00014326: Added new method findTcmClaimByidPersonidEventidStage
 * </pre>                                                    
*/

public class TCMClaimDAOImpl extends BaseDAOImpl implements TCMClaimDAO {
  
  @SuppressWarnings("unchecked")
  public List<TcmClaim> findTcmClaim(int idPerson, Date from, Date to) {
    Query query = getSession().createQuery(" from TcmClaim t " +
                                           "where t.personByIdPerson.idPerson = :idPerson " +
                                           "  and t.dtService >= :fromDate " +
                                           "  and t.dtService < :toDate");
    query.setInteger("idPerson", idPerson);
    query.setTimestamp("fromDate", from);
    query.setTimestamp("toDate", to);
    return (List<TcmClaim>) query.list();
  }

  public void saveTCMClaim(TcmClaim tcmClaim) {
    getSession().saveOrUpdate(tcmClaim);
  }
  
  public int saveTCMClaimInterface(int idTcmClaim, Date dtLastUpdate, String cdDenial, String nbrTcn, Date dtPay, String nbrRa) {
    Query query = getSession().createQuery(
            "update TcmClaim" 
            + "    set dtLastUpdate = :dtLastUpdate,"
            + "        cdDenial = :cdDenial,"
            + "        nbrTcn = :nbrTcn,"
            + "        nbrRa = :nbrRa,"
            + "        dtPay = :dtPay,"
            + "        dtStatus = sysdate"
            + "  where idTcmClaim = :idTcmClaim");
    
    query.setDate("dtLastUpdate", dtLastUpdate);
    query.setString("cdDenial", cdDenial);
    query.setString("nbrTcn", nbrTcn);
    query.setString("nbrRa", nbrRa);
    query.setDate("dtPay", dtPay);
    query.setInteger("idTcmClaim", idTcmClaim);
    
    return query.executeUpdate();
  }
  
  //mxpatel wrote this method
   public int saveTCMClaimPersonMerge(int idPersMergeForward, int idPersMergeClosed) {
    Query query = getSession().createQuery(
            "update TcmClaim" 
            + "    set personByIdPerson = :idPersMergeForward"
            
           
            + "  where personByIdPerson = :idPersMergeClosed");
    
    query.setInteger("idPersMergeForward", idPersMergeForward);
     query.setInteger("idPersMergeClosed", idPersMergeClosed);
    
    return query.executeUpdate();
  }
  
  public int saveTCMClaimInbound(int idTcmClaimOut, String cdDenial, String nbrTcn, Date dtPay, String nbrRa, String cdStatus) {
    SQLQuery query = getSession().createSQLQuery("INSERT INTO TCM_CLAIM_INBOUND " 
                                                 + "(ID_TCM_CLAIM_INBOUND, "
                                                 + "ID_TCM_CLAIM_OUTBOUND, "
                                                 + "TCM_CLAIM_STATUS, "
                                                 + "EOB_CODES, " 
                                                 + "DT_PAYMENT, " 
                                                 + "NBR_TCN, " 
                                                 + "NBR_RA) " 
                                                 + "VALUES " 
                                                 + "(SEQ_TCM_CLAIM_INBOUND.NEXTVAL, "
                                                 + ":idTcmClaimOut, "
                                                 + ":cdStatus, "
                                                 + ":cdDenial, " 
                                                 + ":dtPay, " 
                                                 + ":nbrTcn, " 
                                                 + ":nbrRa)"); 
                                                 
    
    query.setString("cdDenial", cdDenial);
    query.setString("nbrTcn", nbrTcn);
    query.setString("cdStatus", cdStatus);
    query.setString("nbrRa", nbrRa);
    query.setDate("dtPay", dtPay);
    query.setInteger("idTcmClaimOut", idTcmClaimOut);
    
    return query.executeUpdate();
  }

  /**
   * Method used to find data for the Inbound web Service for TCM
   * 
   * @param context
   * Accepts the id as the input
   * Returns the the id in the database
   */
  public TcmClaimOutbound findTcmClaimByTransactionId(int id) {

    Query query = getSession().createQuery(" from TcmClaimOutbound tcmOut where tcmOut.idTcmClaimOutbound = :id");
    query.setInteger("id", id);
    return (TcmClaimOutbound) firstResult(query);

  }
  /**
   * Primary purpose: for Medicaid Billing Unit personnel to set a Denied/Rejected claim to be Non Re-billable
   */
  public int updateTcmClaimStatus(int idTcmClaim, String cdNewStatus) {
    Query query = getSession().createQuery("update TcmClaim" +
    		" set cdStatus = :cdNewStatus" +
    		" where idTcmClaim = :idTcmClaim");
    query.setString("cdNewStatus", cdNewStatus);
    query.setInteger("idTcmClaim", idTcmClaim);
    return query.executeUpdate();
  }
  
  @SuppressWarnings("unchecked")
  public TcmClaim findTcmClaimByidPersonidEventidStage(int idPerson,int idEvent, int idStage) {
    Query query = getSession().createQuery(" from TcmClaim t " +
                                           "where t.personByIdPerson.idPerson = :idPerson " +
                                           "  and t.event.idEvent = :idEvent " +
                                           "  and t.stage.idStage = :idStage");
    query.setInteger("idPerson", idPerson);
    query.setInteger("idEvent", idEvent);
    query.setInteger("idStage", idStage);
    return (TcmClaim) query.uniqueResult();
  }

}
