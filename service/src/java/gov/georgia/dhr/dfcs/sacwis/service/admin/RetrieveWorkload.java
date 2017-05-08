package gov.georgia.dhr.dfcs.sacwis.service.admin;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN14SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN14SO;

public interface RetrieveWorkload {
  static final String FILTER_BY_INV_30 = "1";
  static final String FILTER_BY_SVC_60 = "2";

  /**
   * Updates the IND STAGE PERS EMP NEW field in the STAGE PERSON LINK table for a certain person and a certain STAGE
   * (for all ID_STAGEs sent to this service) then retrieve all the Assignments for that certain person.
   *
   * @param ccmn14si {@link CCMN14SI} The input object populated with the parameter values used in the various DAO
   *                 calls.
   * @return CCMN14SO The output object populated with the retrieved row/column values.
   */

  public CCMN14SO findWorkloadInformation(CCMN14SI ccmn14si);

}