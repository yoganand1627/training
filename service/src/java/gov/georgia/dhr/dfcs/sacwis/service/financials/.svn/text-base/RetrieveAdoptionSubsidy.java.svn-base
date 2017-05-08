package gov.georgia.dhr.dfcs.sacwis.service.financials;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD39SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD39SO;

public interface RetrieveAdoptionSubsidy {

  public static final String PRIMARY_CHILD = "PC";
  public static final int TIMEVAR = -1;
  public static final String GT = "GT";
  public static final String RSRC_TYPE_PVT_AGENCY = "71";
  public static final String STATUS_NEW = "NEW";
  public static final String SUB_CARE = "SUB";
  public static final String ADOPTION = "ADO";
  public static final int LEGAL_STATUS = 0;
  public static final int STAGE_CLOSURE = 1;
  public static final String EVENT_STATUS_NEW = "NEW";
  public static final String EVENT_STATUS_COMP = "COMP";
  public static final String CLOSURE_EVENT_TYPE = "CCL";
  public static final String ADOPTION_SUBSIDY_SPECIALIST = "ADS";
  public static final String CD_LEGAL_STAT_STATUS_TYPE_1 = "NAF";
  public static final String SUB_ELIG_NARR_VIEW = "SUB_ELIG_NARR_VIEW";

  /**
   * This service will check for the skill of Adoption Subsidy Subsidy Specialist for the user, check if the stage
   * child's adoption has been consummated, and retrieve information on the placement, resource, contract, and Adoption
   * Subsidy associated with the given event and determine if the Adoption Subsidy Eligibility Document exists.
   *
   * @param cfad39si
   * @return
   */
  CFAD39SO retrieveAdoptionSubsidy(CFAD39SI cfad39si);
  
  /**
   * This service will check if the check has been in a sub stage
   *
   * @param int idChild
   * @return Integer count of sub stages 
   */
  public Integer retrieveSubStageCount(CFAD39SI cfad39si);

}
