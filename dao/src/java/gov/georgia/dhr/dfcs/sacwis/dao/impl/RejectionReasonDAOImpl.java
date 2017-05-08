package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.RejectionReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RejectionReason;
import org.hibernate.Query;

public class RejectionReasonDAOImpl extends BaseDAOImpl implements RejectionReasonDAO {
  @SuppressWarnings({"unchecked"})
  public List<RejectionReason> findRejectionReasonByIdRejItemCdRejRsnRejected(int idRejectedItemId,
                                                                              String cdRejRsnRejItemId) {
    Query query = getSession().createQuery("  from RejectionReason r" +
                                           "  where r.idRejectedItemId = :idRejectedItemId" +
                                           "    and r.cdRejRsnRejItemId = :cdRejRsnRejItemId" +
                                           "  order by r.cdRejRsn");

    query.setInteger("idRejectedItemId", idRejectedItemId);
    query.setString("cdRejRsnRejItemId", cdRejRsnRejItemId);
    return (List<RejectionReason>) query.list();
  }
  
  public void saveUpdateRejectionReason(RejectionReason rejectionReason){
    getSession().saveOrUpdate(rejectionReason);
  }
}
