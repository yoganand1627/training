package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD40SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD40SO;

public interface SaveAdoptionSubsidy {

  public static final String TYPE_DENIAL = "DEN";
  public static final String TYPE_ADD = "ADD";
  public static final String TYPE_TRANSFER = "TRA";
  public static final String NULL_STRING1 = "";
  public static final String EVENT_STATUS_COMP = "COMP";
  public static final String STATUS_COMPLETE = "COMP";
  public static final String EVENT_STATUS_PROC = "PROC";

  public static final int FAD037 = 0;
  public static final int FAD038 = 1;
  // ??? FAD039 was not represented in the original code
  public static final int FAD040 = 2;
  public static final int FAD041 = 3;
  public static final int FAD042 = 4;

  /**
   * Write to the Adoption Subsidy table and handle record overlap and audits, write to the Medicaid Update Table, and
   * handle events and ToDos.
   *
   * @param cfad40si
   * @return
   */
  CFAD40SO saveAdoptionSubsidy(CFAD40SI cfad40si);
  
  /**
   * Sets the Amount and indicator for displaying following error message 
   * Non-Recurring <type> Adoption Assistance Agreement for <amount> currently exists. 
   *
   * @param cfad40si
   * @return
   */
  CFAD40SO checkForActiveNonRecAdoSubsidy(CFAD40SI cfad40si);

}
