package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC30SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC30SO;

public interface SaveIncomeAndResources {
  /**
   * This service will Add, Update and Delete records to the * INCOME AND RESOURCES table. (CAUD88D) After this AUD, the
   * service will use CLSC63D to check the table to see if there exists a record that has the same CD INC RSRC TYPE as
   * the current record in the Output record of CCFC30s, and has overlapping effective dates and whose ID INC RSRC does
   * equal the one passed into the DAM. If successful, this DAM will return a same type message and prevent the
   * committing of data to the databse changed by CAUD88d.
   *
   * @param ccfc30si
   * @return A populated {@link CCFC30SO} object.
   */

  public CCFC30SO saveIncomeAndResources(CCFC30SI ccfc30si);
}
