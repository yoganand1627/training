package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN86SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN86SO;

public interface SaveCaseName {
  /**
   * Saves New Name to NM_CASE of CAPS CASE table and to NM STAGE all stages of the STAGE table (except subcare)if
   * current stage is not Subcare. If the current stage is Subcare, save the new name only to the Subcare stage.
   *
   * @param ccmn86si The input object populated with method parameters.
   * @return ouput object CCMN86SO populated with retrieved row/column values, if any.
   */
  public CCMN86SO saveCaseNameInformation(CCMN86SI ccmn86si);
}
