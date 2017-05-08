package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV26SO;

public interface SaveName {

  /**
   * This Service calls a DAM to update Name information about a person on the Name Table and a DAM to update NM PERSON
   * FULL on the Person Table.
   *
   * @param cinv26si {@link CINV26SI} object
   * @return {@link CINV26SO} object
   */
  public CINV26SO updateNameInformation(CINV26SI cinv26si);
}
