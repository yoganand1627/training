package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCMN26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCMN26SO;

public interface SaveStagePersonLink {

  /**
   * Updates the IND STAGE PERS EMP NEW field in the STAGE PERSON LINK table for a certain person and a certain STAGE.
   *
   * @param ccmn26si
   */
  public CCMN26SO updateIndStagePersEmpNew(CCMN26SI ccmn26si);
}
