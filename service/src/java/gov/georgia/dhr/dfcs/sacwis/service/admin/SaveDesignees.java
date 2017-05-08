package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC17SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC17SO;

/**
 * SaveDesignees interface
 * <p/>
 * <p/>
 * 
 * 
 * Change History: 
 *   Date        User              Description 
 *   ----------  ----------------  -------------------------------------------------- 
 *   07/31/08    alwilliams        STGAP00008071 - Changed maximum assignees (MAX_ASSIGNEES) 
 *                                 to 10 and added maximum designees (MAX_DESIGNEES)
 *                                 
 */

public interface SaveDesignees {

  //STGAP00008071 - Change maximum assignees to 10 and add maximum designees
  public static final int MAX_ASSIGNEES = 10;
  public static final int MAX_DESIGNEES = 5;
  

  /**
   * This service performs a full row update of the EMP TEMP ASSIGN table.
   * <p/>
   * A person may have 5 (per the detail design document) of designees, but a person may only have 10 assignees (i.e., be the
   * designee of 10 people). To ensure this restriction, it is necessary to check the number of assignees a person 
   * has before they can be added as a designee.
   *
   * @param carc17si {@link CARC17SI}
   * @return A poplated {@link CARC17SO} object.
   */
  public CARC17SO saveDesigneeAssignments(CARC17SI carc17si);
}
