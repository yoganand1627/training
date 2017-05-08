package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CSUB29SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CSUB29SO;

public interface RetrievePPT {
  
  public static final String TEAM_MEET_REVIEW_NARRATIVE = "TEAM_MEET_REVIEW_NARRATIVE";

  /**
   * This service retrieves Ppt object using idEvent (through Event object retrieval)
   *
   * @param csub29si
   * @return A populated {@link CSUB29SO} object.
   */
  public CSUB29SO retrievePPT(CSUB29SI csub29si);
}
