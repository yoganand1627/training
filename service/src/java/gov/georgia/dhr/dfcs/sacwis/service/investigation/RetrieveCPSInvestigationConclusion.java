package gov.georgia.dhr.dfcs.sacwis.service.investigation;

import gov.georgia.dhr.dfcs.sacwis.core.constants.ArchitectureConstants;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV14SO;

public interface RetrieveCPSInvestigationConclusion {

  public static final String RISK_ASSMT_NARR = "RISK_ASSMT_NARR";
  public static final String INDICATOR_IMPACT = "M";
  public static final String IRA_NARRATIVE = "RISK_ASSMT_IRA_NARR";
  public static final String TXT_NARR_EXISTS = "NARRATIVE";
  public static final int NUMBER = 1;
  public static final String RISK_ASSMNT_TASK = "2290";
  public static final String IRA_ASSMT_TASK = "2295";
  public static final String FALSE = ArchitectureConstants.FALSE;
  public static final String TRUE = ArchitectureConstants.TRUE;


  /**
   * This service is used in the Predisplay callback of window CINV06W - CPS INV CONCLUSION. It retrieves all the values
   * necessary to populate window.
   *
   * @param cinv14si {@link Object}
   * @return {@link CINV14SO{ object
   */
  public CINV14SO retrieveCPSInvestigationConclusion(CINV14SI cinv14si);
}
