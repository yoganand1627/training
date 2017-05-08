package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC14SO;

public interface SavePersonMerge {

  /**
   * This service will update functional tables, event tables and the Person Merge Split table for either a Split or a
   * Merge.  If the service performs a split, only the Person Merge/Split, the Category and Person tables are updated to
   * reflect the split.  If the function is Merge, various functional tables, the Stage Person Link, and the Event
   * Person Link tables are updated to replace the Id Person of the Merge Forward for all open stages.  In addition the
   * Category and Person (status fields) are updated to reflect the merge.
   *
   * @param ccfc14si {@link CCFC14SI} object
   * @return CCFC14SO
   */
  CCFC14SO savePersonMerge(CCFC14SI ccfc14si);

}
