package gov.georgia.dhr.dfcs.sacwis.service.security;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC13SO;

public interface SaveSecurityClass {
  /**
   * Inserts a SecurityClass object.
   *
   * @param carc13si
   * @return
   */
  CARC13SO saveSecurityClass(CARC13SI carc13si);
}
