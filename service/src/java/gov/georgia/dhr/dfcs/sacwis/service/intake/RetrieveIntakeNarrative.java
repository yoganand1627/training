package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.IntNarrBlobInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.IntNarrBlobOutRec;

public interface RetrieveIntakeNarrative {

  /**
   * INT NARR BLOB RTRV
   *
   * @param intNarrBlobInRec
   * @return A populated {@link IntNarrBlobOutRec} object.
   */
  public IntNarrBlobOutRec findIntakeNarrative(IntNarrBlobInRec intNarrBlobInRec);
}
