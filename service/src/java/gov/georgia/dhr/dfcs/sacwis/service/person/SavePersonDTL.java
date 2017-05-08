package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC38SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC38SO;

public interface SavePersonDTL {
  /**
   * Either insert or update all columns for an Id Person in the Person Dtl table, or delete a Person Dtl table row
   * depending on the ccfc38i reqFuncCd value.
   *
   * @param ccfc38si
   * @return a populated {@link CCFC38SO}
   */
  public CCFC38SO updatePersonDTL(CCFC38SI ccfc38si);

}
