package gov.georgia.dhr.dfcs.sacwis.service.common;

import gov.georgia.dhr.dfcs.sacwis.core.lookup.CodesTables;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD32SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD32SO;

/**
 * This interface defines the methods use to retrieve data from FA_INDIV_TRAINING table
 * 
 * @author lata.p.lokhande
 *
 * <pre>
 *   Change History:
 *   Date      User        Description
 *   --------  ----------  --------------------------------------------------
 *   10/28/08  alwilliams  STGAP00010494 - Deleted unused required training hours constants. 
 *                         These constants were hard coded, The implementing class now uses
 *                         code table lookup instead of hard coded constants.
 *   
 * </pre>
 */
public interface RetrieveFAHomeMemberTraining {
  /**
   * This service will call a DAM to retrieve all FA Home Member Training rows where IdPerson equals the IdPerson passed
   * into the service.
   *
   * @param cfad32si
   * @return {@link CFAD32SO}
   */
  public static final String FA_HOME_ACTIVE_STATUS = CodesTables.CFAHMSTA_040;
  public static final String FA_HOME_STAGE = CodesTables.CSTAGES_FAD;

  public CFAD32SO retrieveFAHomeMemberTraining(CFAD32SI cfad32si);
}
