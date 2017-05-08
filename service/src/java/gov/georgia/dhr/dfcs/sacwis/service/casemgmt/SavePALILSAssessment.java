package gov.georgia.dhr.dfcs.sacwis.service.casemgmt;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC02SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC02SO;

public interface SavePALILSAssessment {
  /** This should probably be added to codes_tables in the long-run. */
  static final String INDEPENDENT_LIVING_SKILLS = "ILS";

  /** This should probably be added to codes_tables in the long-run. */
  static final String ILS_ASSESSMENT_RESULTS = "Recording ILS Assessment Results";

  /**
   * This service will update all columns for an Id Stage from the PAL table.  It will also update all the columns for
   * an Id Event form the EVENT table.  It can add or modify a PAL row.  It can add or modify the Event row.  It will
   * also create a link between the event and the primary child for the PAL stage.  It will call DAMs CAUD49D - PAL AUD
   * and CINV51D - RTRV PRIMARY EMPL.  It also calls common function CCMN01U - POST EVENT.
   * <p/>
   * Whenever the data for PAL ILS Assessment is saved, the associated TODO, if any, will be taken off the Staff TODO
   * List.  This is necessary because in the PAL Dialog when a TODO is completed for the ILS or RUT windows the event
   * status remains PROC until the stage is completed through the PAL Summary window.  Thus, simply completing a TODO
   * would not have removed it from the TODO List.  The CINV43D dam updates the date TODO completed and removes the TODO
   * from the TODO list whenever the window data is saved.
   *
   * @param ccfc02si {@link CCFC02SI} object
   * @return {@link CCFC02SO} object
   */
  public CCFC02SO savePalIlsAssessment(CCFC02SI ccfc02si);
}
