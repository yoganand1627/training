package gov.georgia.dhr.dfcs.sacwis.dao;

import gov.georgia.dhr.dfcs.sacwis.db.TodoInfo;

public interface TodoInfoDAO {
  /**
   * Retrieves a full row from todoInfo table.
   *
   * @param cdTodoInfo
   * @return TodoInfo Object populated with the returned column values.
   */
  public TodoInfo findTodoInfoByCdTodoInfo(String cdTodoInfo);
}
