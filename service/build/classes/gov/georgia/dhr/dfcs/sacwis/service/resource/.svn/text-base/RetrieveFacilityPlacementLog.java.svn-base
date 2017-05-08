package gov.georgia.dhr.dfcs.sacwis.service.resource;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CFAD31SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CFAD31SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PlacementLogSO;
/*
 * Change History:
 * Date         User              Description
 * --------     ----------------  --------------------------------------------------
 * 09/12/2011   charden           STGAP00017058 - modified return type of retrieveLog(CFAD31SI cfad31si)
 *
 */
public interface RetrieveFacilityPlacementLog {
  // Sorting constants.
  public static final String SORT_O = "O";
  public static final String SORT_P = "P";
  public static final String SORT_E = "E";
  public static final String SORT_C = "C";
  public static final String SORT_R = "R";

  /**
   * Description:   If an Id Resource is not passed into the service, the service will call a DM using IdStage to
   * retrieve the IdResource.  IdResource will then be usd to call another DAM to retreive the data to be displayed on
   * the Facility Placement Log window.
   *
   * @param cfad31si
   * @return {@link PlacementLogSO}
   */
  PlacementLogSO retrieveLog(CFAD31SI cfad31si);
}
