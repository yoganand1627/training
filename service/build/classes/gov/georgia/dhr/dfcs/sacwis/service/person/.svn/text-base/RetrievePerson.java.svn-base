package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV24SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV24SO;

public interface RetrievePerson {

  static final String CHAR_CHECKED = "1";

  /**
   * This service routine houses two different DAM service calls. One for Predisplay processing "Return Latest &
   * Greatest", and another for Search functionality which will query the database by the entered effective date.
   *
   * @param cinv24si
   * @return A populated {@link CINV24SO} object.
   */
  public CINV24SO retrievePerson(CINV24SI cinv24si);

}
