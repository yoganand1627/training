/**
 * Created on Mar 23, 2006 at 12:51:17 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN04UI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO;

public interface UnitAccess {
  /**
   * This is a common function designed to determine whether or not a set of employees (the user + designees) has access
   * for unit modification.  This is performed by comparing the Unit Member Roles of the set of employees against that
   * of the unit's approver and checks up the unit heirarchy via the Parent Unit, if necessary.  The function receives
   * ID PERSON for the user, ID PERSON for the user's designees and either ID UNIT or CD UNIT PROGRAM, CD UNIT REGION,
   * and NBR UNIT.  It returns either TRUE or FALSE.
   *
   * @param ccmn04ui
   * @return The populated {@link gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN04UO} object, which contains a single
   *         string indicating if the passed-in id's, or their designates or supervisors have unit access.
   */
  CCMN04UO checkForPersonWithUnitAccess(CCMN04UI ccmn04ui);
}
