package gov.georgia.dhr.dfcs.sacwis.service.intake;

import gov.georgia.dhr.dfcs.sacwis.structs.input.RelatePersonInRec;
import gov.georgia.dhr.dfcs.sacwis.structs.output.RelatePersonOutRec;

public interface SaveRelatePerson {

  public static final String IND_RELATED = "R";
  public static final String CD_ACTIVE = "A";

  /**
   * @param relatePersonInRec
   * @return
   */
  RelatePersonOutRec relatePerson(RelatePersonInRec relatePersonInRec);
}
