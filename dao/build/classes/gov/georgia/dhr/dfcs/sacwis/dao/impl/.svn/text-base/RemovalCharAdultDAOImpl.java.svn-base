package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharAdultDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharAdult;
import org.hibernate.Query;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
11/05/08    mxpatel           STGAP00009009:  replaced the hibernate queries with
                              SQL queries in deleteRemovalCharAdult method.
*/

public class RemovalCharAdultDAOImpl extends BaseDAOImpl implements RemovalCharAdultDAO {
  @SuppressWarnings({"unchecked"})
  public List<RemovalCharAdult> findRemovalCharAdultByIdRemovalEvent(int idRemovalEvent) {
    Query query = getSession().createQuery(" from     RemovalCharAdult r" +
                                           " where    r.event.idEvent = :idRemovalEvent" +
                                           " order by id.cdRemovAdultChar");
    query.setInteger("idRemovalEvent", idRemovalEvent);
    return (List<RemovalCharAdult>) query.list();
  }

  public void saveRemovalCharAdult(RemovalCharAdult removalCharAdult) {
    getSession().saveOrUpdate(removalCharAdult);
  }

  public int updateRemovalCharAdult(int idEvent, String cdRemovAdultChar, Date dtLastUpdate) {

    Query query = getSession().createQuery("update RemovalCharAdult" +
                                           "    set id.idRemovalEvent = :idEvent," +
                                           "        id.cdRemovAdultChar = :cdRemovAdultChar" +
                                           "  where dtLastUpdate = :dtLastUpdate" +
                                           "    and id.idRemovalEvent = :idEvent");
    query.setInteger("idEvent", idEvent);
    query.setString("cdRemovAdultChar", cdRemovAdultChar);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);

    return query.executeUpdate();
  }

 // public void deleteRemovalCharAdult(RemovalCharAdult removalCharAdult) {//mxpatel commented this out for defect #9009
  public void deleteRemovalCharAdult(int idRemovalEvent, String cdRemovAdultChar) {
    // mxpatel replace the hibernate query with the SQL query for defect #9009
    Query query = getSession().createSQLQuery(
                                              " delete from REMOVAL_CHAR_ADULT"
                                                              + " where ID_REMOVAL_EVENT = :idRemovalEvent"
                                                              + " and CD_REMOV_ADULT_CHAR = :cdRemovAdultChar");
    query.setInteger("idRemovalEvent", idRemovalEvent);
    query.setString("cdRemovAdultChar", cdRemovAdultChar);
    query.executeUpdate();                                                         
    //getSession().delete(removalCharAdult); //mxpatel commented this out for defect #9009
    
  }
}
