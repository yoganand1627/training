package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV01SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV01SO;

public interface RetrievePersonList {
  static final int MAX_AGE = 999;
  static final String RISK_ASSMNT_TASK = "2290";
  static final String FLR_EVENT_DESC_INIT_TDMHMR = "Initial Generation of TDMHMR Facility Letter to Reporter";
  static final String FLR_EVENT_DESC_INIT_MHMR = "Initial Generation of MHMR Facility Letter to Reporter";
  static final int TDMHMR_BLOB_STRUCT_INDEX = 0;
  static final int MHMR_BLOB_STRUCT_INDEX = 1;
  static final String PERSON_CHAR_ONE = "1";
  static final String PERSON_CHAR_TWO = "2";
  static final String ALLEGED_PERPS_ONLY = "Z";
  static final String IRA = "Intranet Risk Assessment";

  /**
   * Calls StagePersonLink and Event DAO objects to retrieve Person list.
   *
   * @param cinv01si {@link CINV01SI}
   * @return {@link CINV01SO}
   */
  CINV01SO retrievePersonList(CINV01SI cinv01si);
}
