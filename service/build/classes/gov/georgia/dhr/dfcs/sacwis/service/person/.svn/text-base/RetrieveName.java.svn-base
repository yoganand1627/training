package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CINV25SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CINV25SO;

public interface RetrieveName {

  /**
   * This Service calls one DAO to retrieve Name information about person off the Name Table based on ID PERSON. Make
   * sure to set the page size in the input architecture record group element SYS CARC PAGE SIZE NBR. Also, set the
   * input record field SYS IND VALID ONLY to FALSE if you want to retrieve only valid names, and TRUE otherwise.
   *
   * @param cinv25si {@link CINV25SI} object
   * @return {@link CINV25SO} object
   */
  public CINV25SO retrievePersonNameInformation(CINV25SI cinv25si);
}
