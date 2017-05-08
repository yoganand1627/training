package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.TodoInfoDAO;
import gov.georgia.dhr.dfcs.sacwis.db.TodoInfo;
import org.hibernate.Query;

public class TodoInfoDAOImpl extends BaseDAOImpl implements TodoInfoDAO {
  /**
   * Retrieves a full row from todoInfo table.
   *
   * @param cdTodoInfo
   * @return TodoInfo object
   */
  public TodoInfo findTodoInfoByCdTodoInfo(String cdTodoInfo) {
    Query query = getSession().createQuery("  from TodoInfo t " +
                                           " where t.cdTodoInfo = :cdTodoInfo ");
    query.setString("cdTodoInfo", cdTodoInfo);
    return (TodoInfo) firstResult(query);
  }
}


