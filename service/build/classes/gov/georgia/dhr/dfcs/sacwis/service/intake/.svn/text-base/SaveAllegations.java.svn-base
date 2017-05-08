package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.AllegListAudInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AllegListAUDOutRec;

public interface SaveAllegations {

  /**
   * AUD service for the Allegation Dialogue. This service calls DAM CINT14D for the Add/Update/Delete functions of the
   * Allegation windows.  This DAM writes to the INTAKE_ALLEGATION table.  It is called from the Intake Toolbar when an
   * interwindow message to partial save is received.
   *
   * @param allegListAudInRec
   * @return AllegListAUDOutRec
   */

  public AllegListAUDOutRec saveAllegations(AllegListAudInRec allegListAudInRec);
}
