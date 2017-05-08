package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN19SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN19SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;
import gov.georgia.dhr.dfcs.sacwis.structs.input.TodoAlertSaveSI;

public interface SaveTodo {
  /**
   * This service will Add/Update to the TODO table, Add to the Approval, Approval Event Link table, Event table, and
   * Approvers table if the ReqFuncCd is "APPROVAL"
   *
   * @param ccmn19si The input object containing row/column values to be saved.
   * @return {@link CCMN19SO} Output object populated during the save process.
   */
  public CCMN19SO saveTodoInformation(CCMN19SI ccmn19si);
  
  /**
   * This service creates an alert.
   * 
   * @param cinv05si
   */
  public CINV05SO saveTodoAlert(TodoAlertSaveSI tosoalertsavesi);
}
