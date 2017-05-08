package gov.georgia.dhr.dfcs.sacwis.service.admin.impl;

import java.util.Enumeration;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.message.Messages;
import gov.georgia.dhr.dfcs.sacwis.core.utility.DateHelper;
import gov.georgia.dhr.dfcs.sacwis.dao.TodoDAO;
import gov.georgia.dhr.dfcs.sacwis.service.admin.DeleteTodo;
import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN97SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN97SO;

public class DeleteTodoImpl extends BaseServiceImpl implements DeleteTodo {

  private TodoDAO todoDAO = null;

  public void setTodoDAO(TodoDAO todoDAO) {
    this.todoDAO = todoDAO;
  }

  public CCMN97SO deleteTodo(CCMN97SI ccmn97si) throws ServiceException {
    CCMN97SO ccmn97so = new CCMN97SO();
    for (Enumeration rowLdIdTodoEnum = ccmn97si.getLdIdTodo_ARRAY().enumerateLdIdTodo();
         rowLdIdTodoEnum.hasMoreElements();) {
      int idTodo = (Integer) rowLdIdTodoEnum.nextElement();
      int rowsUpdated = todoDAO.deleteTodoByIdTodoAndDtLastUpdate(idTodo, DateHelper.MAX_JAVA_DATE);
      if (rowsUpdated == 0) {
        throw new ServiceException(Messages.SQL_NOT_FOUND);
      }
    }
    return ccmn97so;
  }
}
