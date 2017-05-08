package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.RemovalReasonDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalReason;
import net.sf.cglib.transform.impl.InterceptFieldCallback;

import org.hibernate.Query;


/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
10/05/08    mxpatel           STGAP00009009:  replaced the hibernate queries with
                              SQL queries in deleteRemovalReason and saveRemovalReason methods.
*/
public class RemovalReasonDAOImpl extends BaseDAOImpl implements RemovalReasonDAO {
  @SuppressWarnings({"unchecked"})
  public List<RemovalReason> findListOfRemovalReasonByIdEvent(int idEvent) {
    Query query = getSession().createQuery("     from RemovalReason r" +
                                           "    where r.id.idRemovalEvent = :idEvent" +
                                           " order by r.id.cdRemovalReason");

    query.setInteger("idEvent", idEvent);
    return (List<RemovalReason>) query.list();
  }

 
  public void saveRemovalReason(RemovalReason removalReason) {
    //mxpatel replace the hibernate query with the SQL query for defect #9009
    Query query = getSession().createSQLQuery(
                                "insert into  removal_reason"
                                                + " (ID_CASE, ID_REMOVAL_EVENT, CD_REMOVAL_REASON, DT_LAST_UPDATE) "
                                                + " values (:idCase,:idRemovalEvent,:cdRemovalReason, SYSDATE)");
    //getSession().saveOrUpdate(removalReason);
    query.setInteger("idCase", removalReason.getIdCase());
    query.setInteger("idRemovalEvent", removalReason.getId().getIdRemovalEvent());
    query.setString("cdRemovalReason", removalReason.getId().getCdRemovalReason());
    query.executeUpdate();
  }

  
  
  public int updateRemovalReason(int idEvent, String cdRemovalReason,
                                 Date dtLastUpdate) {

    Query query = getSession().createQuery("update RemovalReason" +
                                           "    set id.idRemovalEvent = :idEvent," +
                                           "        id.cdRemovalReason = :cdRemovalReason" +
                                           "  where dtLastUpdate = :dtLastUpdate" +
                                           "    and id.idRemovalEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    query.setString("cdRemovalReason", cdRemovalReason);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);

    return query.executeUpdate();
  }


 // public void deleteRemovalReason(RemovalReason removalReason) {
  public void deleteRemovalReason(int idCase, int idRemovalEvent, String cdRemovalReason) {
    // mxpatel replace the hibernate query with the SQL query for defect #9009
    Query query = getSession().createSQLQuery(
                                              " delete from removal_reason"
                                                              + " where ID_REMOVAL_EVENT = :idRemovalEvent"
                                                              + " and CD_REMOVAL_REASON = :cdRemovalReason"
                                                              + " and ID_CASE = :idCase");
    query.setInteger("idCase", idCase);
    query.setInteger("idRemovalEvent", idRemovalEvent);
    query.setString("cdRemovalReason", cdRemovalReason);
    query.executeUpdate();
    // getSession().delete(removalReason); //mxpatel commented this out for defect #9009
  }
}
