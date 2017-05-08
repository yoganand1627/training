package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV05SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV05SO;

public interface SavePersonDetail {
  /**
   * This Service calls 2 DAMS to update a number of tables.  A Row is entered or updated in the Person, relationship,
   * Stage person link, and the To Do.
   *
   * @param cinv05si {@link CINV05SI} object
   * @return CINV05SO
   */
  CINV05SO savePersonDetail(CINV05SI cinv05si);
}
