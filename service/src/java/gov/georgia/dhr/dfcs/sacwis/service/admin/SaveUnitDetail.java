package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN22SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN22SO;

public interface SaveUnitDetail {
  /**
   * This service is designed to save modified or new Unit Information (Unit Specialization, Parent Unit, Unit Approver)
   * and Unit Member Information (ID Person, Unit Role, In/Out status).  It updates the UNIT and UNIT EMP LINK tables.
   *
   * @param ccmn22si {@link CCMN22SI} object
   * @return {@link CCMN22SO} object
   */
  public CCMN22SO saveUnitInformation(CCMN22SI ccmn22si);
}
