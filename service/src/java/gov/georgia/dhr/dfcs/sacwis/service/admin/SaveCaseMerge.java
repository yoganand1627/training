package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC41SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC41SO;

public interface SaveCaseMerge {

  public static final String MERGE = "M";
  public static final String VOID_MERGE = "V";
  public static final String VOID_SPLIT = "Z";
  public static final String SPLIT = "S";

  /**
   * This service will save case merges and case splits to the database with the pending flag. The actual DB updates
   * will be done in a batch process.
   *
   * @param ccfc41si
   * @return A populated {@link CCFC41SO} object.
   */
  public CCFC41SO saveCaseMerge(CCFC41SI ccfc41si);
}
