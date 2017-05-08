package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC23SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC23SO;

public interface PersonMergeValidation {

  /**
   * This runs a series of DAMs to verify that the 2 Person's entered in the Person Merge Split can be merged.  The
   * service will return the Full Name of the Id Person Entered on the window along with any validation errors found.
   * The errors will be passed to the client via an error list.
   *
   * @param ccfc23si
   * @return
   */
  CCFC23SO personMergeValidation(CCFC23SI ccfc23si);

}
