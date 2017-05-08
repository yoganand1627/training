package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.UnrelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.UnrelatePersonOutRec;

public interface SaveUnrelatePerson {

  /**
   * Unrelates a person from the Person Detail.
   *
   * @param unrelatePersonInRec
   * @return {@link UnrelatePersonOutRec} The output object populated with retrieved row/column values, if any.
   */
  public UnrelatePersonOutRec saveUnrelatedPerson(UnrelatePersonInRec unrelatePersonInRec);
}
