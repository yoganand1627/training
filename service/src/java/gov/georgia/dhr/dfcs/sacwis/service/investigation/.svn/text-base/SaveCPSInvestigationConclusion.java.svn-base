package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import java.util.Arrays;
import java.util.List;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV16SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV16SO;

public interface SaveCPSInvestigationConclusion {

  // Service constants
  public static final String NULL_STRING = "";
  public static final String CRSR_STAGE = "CRSR";
  public static final int MSG_USE_REMOVAL_SUB_CLOSURE_RSN = 25600;
  public static final String[] closureArray1 = {"64", "66", "68", "70", "65", "69"};
  public static final String[] closureArray2 = {"80", "82", "84", "86"};
  public static final List closureSubList1 = Arrays.asList(closureArray1);
  public static final List closureSubList2 = Arrays.asList(closureArray2);

  /**
   * Updates information modified on the CPS Investigation Conclusion window.
   *
   * @param cinv16si The input object populated with parameters used in the DAO calls.
   * @return
   */
  public CINV16SO saveCPSInvestigationConclusion(CINV16SI cinv16si);
}
