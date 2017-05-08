package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV50SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV50SO;

public interface SavePersonSearchIndicator {
  /**
   * This Service will Update the Person Search Indicator on STAGE PERSON LINK for a given ID PERSON.
   * <p/>
   * SACWIS - The Person Search Indicator is now updated when a search is performed from Person Search rather than set
   * when a user navigates from Person List.  DAM was modified to use IdStage and IdPerson rather than
   * IdStagePersonLink.
   *
   * @param cinv50si {@link CINV50SI} object
   * @return {@link CINV50SO} object
   */
  public CINV50SO updatePersonSearchIndicator(CINV50SI cinv50si);
}
