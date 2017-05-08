package gov.georgia.dhr.dfcs.sacwis.dao.impl;

import gov.georgia.dhr.dfcs.sacwis.dao.TaskDAO;
import gov.georgia.dhr.dfcs.sacwis.db.Task;
import org.hibernate.Query;
import org.hibernate.Session;

public class TaskDAOImpl extends BaseDAOImpl implements TaskDAO {
  @SuppressWarnings({"unchecked"})
  public Task findTaskByCdTask(String cdTask) {

    Session session = getSession();
    Query query = session.createQuery("   from Task t " +
                                      "  where t.cdTask = :cdTask ");

    query.setString("cdTask", cdTask);
    return (Task) firstResult(query);
  }
}
