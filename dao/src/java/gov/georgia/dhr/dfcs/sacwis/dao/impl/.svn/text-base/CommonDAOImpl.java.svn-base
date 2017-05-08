/**
 * Created on Feb 20, 2006 at 1:26:27 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import gov.georgia.dhr.dfcs.sacwis.dao.CommonDAO;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;

public class CommonDAOImpl extends BaseDAOImpl implements CommonDAO {
  public long countRowsByIdEvent(long idEvent, String tableName) {
    SQLQuery query = getSession().createSQLQuery("SELECT count(*) as countOfRows " +
                                                 "  FROM " + tableName + " " +
                                                 " WHERE ID_EVENT = :idEvent");

    query.setLong("idEvent", idEvent);
    return (Integer) query.addScalar("countOfRows", Hibernate.INTEGER).uniqueResult();
  }

  public Date findDtLastUpdate(String tableName, int idEvent) {
    SQLQuery query = getSession().createSQLQuery("SELECT DT_LAST_UPDATE " +
                                                 "  FROM " + tableName +
                                                 " WHERE ID_EVENT = :idEvent");
    query.addScalar("DT_LAST_UPDATE", Hibernate.TIMESTAMP);
    query.setInteger("idEvent", idEvent);
    return (Date) firstResult(query);
  }
  
  public int deleteRecordByEvent(String tableName, int idEvent, Date timestamp) {
    SQLQuery query = getSession().createSQLQuery("DELETE " +
                                                 "  FROM " + tableName +
                                                 " WHERE ID_EVENT = :idEvent " +
                                                 " AND DT_LAST_UPDATE = :timestamp");
    query.setInteger("idEvent", idEvent);
    query.setTimestamp("timestamp", timestamp);
    return query.executeUpdate();
  }  

  public int getNextval(String sequenceName) {
    SQLQuery query = getSession().createSQLQuery("SELECT " + sequenceName + ".NEXTVAL AS PK_VALUE FROM DUAL");
    return (Integer) query.addScalar("PK_VALUE", Hibernate.INTEGER).uniqueResult();
  }

  @SuppressWarnings({"unchecked"})
  public <T extends Object> T getPersistentObject(Class<T> clazz, Serializable id) {
    return (T) getSession().load(clazz, id);
  }
}
