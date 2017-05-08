package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV45SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV45SO;

public interface SaveOverallRoleandDisposition {

  /**
   * This is the Overall Roles and Disposition Service. It is run when all the allegations in a given stage have been
   * assigned a disposition but no overall disposition has yet been assigned. This service calculates each person's
   * overall role and the stage's overall disposition. Overall roles are saved in STAGE_PERSON_LINK; overall disposition
   * is saved to the appropriate Investigation Conclusion table, based on Program.
   *
   * @param cinv45si {@link CINV45SI}
   * @return {@link CINV45SO}
   */
  CINV45SO saveRoleDisp(CINV45SI cinv45si);
}
