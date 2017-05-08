package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN10SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN10SO;

public interface SaveOnCallDetail {
  /**
   * This service is called from the MDL SAVE CLICK callback.
   * <p/>
   * If the checks on the window side pass,then this service  is called.
   * <p/>
   * If the Mode in which ccmn21w.win was called is NEW_USING, (that is, szSysCdWinMode == WINDOW_MODE_NEW_USING) that
   * means that the New PB was pressed on the On-Call List window (20w), and all four DAOs: DynamicOnCallDAO (query),
   * ComplexOnCallDAO (add), TodoDAO (add), and EmpOnCallLinkDAO (add) will need to be called from this service.
   * <p/>
   * If the Mode in which ccmn21w.win was called is MODIFY, (that is, szSysCdWinMode == WINDOW_MODE_MODIFY) that means
   * that the Detail PB was pressed on the On-Call List window (20w), and only two DAOs will need to be called from this
   * service: TodoDAO (add) and EmpOnCallLinkDAO (AUD).
   * <p/>
   * The TodoDAO DAO (add) will be used for each add, update, or delete of an employee (EmpOnCallLinkDAO). The TodoDAO
   * (add) will send a To-Do (Alert) notifying each employee that they have been added/changed/deleted from the shift or
   * block in question.
   * <p/>
   * This service will determine which DAOs that it needs to call based on the following:
   * <p/>
   * if (szSysCdWinMode == WINDOW_MODE_NEW_USING) { the DynamicOnCallDAO  is called then over-lap checking is done if
   * there is no over-lap then the ADD section of the ComplexOnCallDAO  is called then the ADD section of the TodoDAO is
   * called. then the ADD section of the EmpOnCallLinkDAO  is called. } else     szSysCdWinMode == WINDOW_MODE_MODIFY *
   * if (szCdScrDataAction == REQ_FUNC_CD_ADD) first the ADD section of the TodoDAO  is called, then the
   * EmpOnCallLinkDAO  is called to ADD the employee to the shift/block; else if (szCdScrDataAction ==
   * REQ_FUNC_CD_UPDATE) first the ADD section of the TodoDAO  is called, then the EmpOnCallLinkDAO  is called to UPDATE
   * the employee to the shift/block; else if (szCdScrDataAction == REQ_FUNC_CD_DELETE) first the ADD section of the
   * TodoDAO  is called, then the EmpOnCallLinkDAO  is called to DELETE the employee to the shift/block;
   * <p/>
   * This service calls five DAOs: DynamicOnCallDAO, ComplexOnCallDAO, ComplexOnCallCountyDAO TodoDAO and
   * EmpOnCallLinkDAO To ADD an on-call shift or block: It receives the 7 variables required to create an On-Call Shift
   * or Block. Before the proposed shift/block may be added, the following check must be made (these steps are done in
   * the callDynamicOnCallDAO private method): 1. Call DynamicOnCallDAO to retrieve all shifts/blocks for the
   * county/program pair. 2. Check the proposed shift/block to be added against those retrieved in step 1, looking for
   * overlaps. As soon as an overlap is found, break out of the for loop and return a message to the user stating that
   * the proposed shift/block cannot be added as it would create an overlap with the existing schedule. 3. If an overlap
   * is not found, then call ComplexOnCallDAO to ADD the proposed shift/block.
   * <p/>
   * To ADD a to-do (alert): 1. Call TodoDAO to ADD a To-Do (Alert) for each IdPerson sent from the ccmn21w window. The
   * to-do will contain the information that they have been added/updated/deleted from the on-call shift/block (also
   * listing the details of the shift/block).
   * <p/>
   * 2. Call EmpOnCallLinkDAO to add/update/delete all employees assigned to the selected shift/block.
   *
   * @param ccmn10si The input object populated with method parameters.
   * @return CCMN10SO The output object populated with row/column values retrieved by the queries.
   */
  public CCMN10SO saveOnCallDetailInformation(CCMN10SI ccmn10si);

}
