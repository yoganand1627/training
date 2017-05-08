/**
 * Created on Jan 23, 2007 at 1:54:02 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.web.ws;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RetrieveStaffTodoWI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RetrieveStaffTodoWO;

public interface RetrieveStaffTodoWS {
  RetrieveStaffTodoWO getStaffTodoIds(RetrieveStaffTodoWI retrieveStaffTodoWI);
}
