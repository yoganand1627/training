package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.util.Date;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.dao.RemovalCharChildDAO;
import gov.georgia.dhr.dfcs.sacwis.db.RemovalCharChild;
import org.hibernate.Query;

/*Change History:
Date        User              Description
--------    ----------------  --------------------------------------------------
11/05/08    mxpatel           STGAP00009009:  replaced the hibernate queries with
                              SQL queries in saveRemovalCharChild method.
12/04/10    htvo              SMS#81140 MR-074 AFCARS 1: add r.indCharChildCurrent = 'N' to 
                              findRemovalCharChildByIdRemovalEvent because the Child Characteristics section on 
                              Custody is now display only. Values in this table are child's current characteristics or those
                              current at the time the stage closed. This table is updated with changes from Person Characteristics  
                              eveytime up until the stage the removal event was created in closed. After stage close, this table is 
                              locked down.                      
*/

public class RemovalCharChildDAOImpl extends BaseDAOImpl implements RemovalCharChildDAO {
  @SuppressWarnings({"unchecked"})
  public List<RemovalCharChild> findRemovalCharChildByIdRemovalEvent(int idRemovalEvent) {
    Query query = getSession().createQuery(" from     RemovalCharChild r" +
                                           " where    r.event.idEvent = :idRemovalEvent" +
                                           " and      r.indCharChildCurrent = 'Y'" +
                                           " order by id.cdRemovChildChar");
    query.setInteger("idRemovalEvent", idRemovalEvent);
    return (List<RemovalCharChild>) query.list();
  }

  public void saveRemovalCharChild(RemovalCharChild removalCharChild) {
   // getSession().saveOrUpdate(removalCharChild); //mxpatel added this for defect #9009
    //mxpated replaced the HQL query with SQL query for defect #9009
    Query query = getSession().createSQLQuery(
                                              "insert into  REMOVAL_CHAR_CHILD"
                                                              + " (ID_CASE, ID_REMOVAL_EVENT, CD_REMOV_CHILD_CHAR, IND_CHAR_CHILD_CURRENT, DT_LAST_UPDATE) "
                                                              + " values (:idCase,:idRemovalEvent,:cdRemovalChildChar,:indCharChildCurrent, SYSDATE)");
    
    query.setInteger("idCase", removalCharChild.getCapsCase().getIdCase());
    query.setInteger("idRemovalEvent", removalCharChild.getId().getIdRemovalEvent());
    query.setString("indCharChildCurrent", removalCharChild.getIndCharChildCurrent());
    query.setString("cdRemovalChildChar", removalCharChild.getId().getCdRemovChildChar());
    query.executeUpdate();
  }

  public int updateRemovalCharChild(String indCharChildCurrent, Date dtLastUpdate,
                                    int idEvent, String cdRemovChildChar) {

    Query query = getSession().createQuery("update RemovalCharChild" +
                                           "    set indCharChildCurrent = :indCharChildCurrent" +
                                           "  where dtLastUpdate = :dtLastUpdate" +
                                           "    and id.idRemovalEvent = :idEvent" +
                                           "    and id.cdRemovChildChar = :cdRemovChildChar");
    query.setString("indCharChildCurrent", indCharChildCurrent);
    query.setTimestamp("dtLastUpdate", dtLastUpdate);
    query.setInteger("idEvent", idEvent);
    query.setString("cdRemovChildChar", cdRemovChildChar);

    return query.executeUpdate();
  }
}
