package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN97SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN97SO;

public interface DeleteTodo {
  /**
   * Uses todoDAO to delete Todo objects
   *
   * @param ccmn97si
   * @return
   */
  CCMN97SO deleteTodo(CCMN97SI ccmn97si);
}
