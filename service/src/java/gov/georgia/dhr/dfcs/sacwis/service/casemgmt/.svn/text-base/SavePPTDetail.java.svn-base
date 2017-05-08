package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB50SO;

public interface SavePPTDetail {

  public static final int FND_FAIL = 1;

  public static final String PRIMARY_CHILD = "PC";
  public static final String STATUS_NEW = "NEW";
  public static final String STATUS_PROCESS = "PROC";
  public static final String STATUS_COMPLETE = "COMP";
  public static final String PPR = "Permanency Planning Review ";
  public static final int CURRENT = 0;

  public static final int NEXT = 1;
  public static final String TODO_CODE1 = "SUB006";
  public static final String TODO_CODE2 = "SUB007";

  /**
   * This service will add, update, or delete rows in the PPT Detail table.
   *
   * @param csub50si
   * @return CSUB50SO
   */
  CSUB50SO savePPTDetail(CSUB50SI csub50si);
}
