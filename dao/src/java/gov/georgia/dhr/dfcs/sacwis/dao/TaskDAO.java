/**
 * Created on Mar 25, 2006 at 3:31:48 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.Task;

public interface TaskDAO {
  /**
   * Retrieves a complete single row from the Task table.
   * <p/>
   *
   * @param cdTask
   * @return
   */
  @SuppressWarnings({"unchecked"})
  Task findTaskByCdTask(String cdTask);
}
