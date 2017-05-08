package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.CCFC26SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CCFC26SO;

public interface RetrieveRecordsCheck {

  /**
   * This service will retrieve all rows from the Records Check Table for a given IdRecCheckPerson(maximum page size
   * retrieved is 11 rows).
   * <p/>
   * The service will scan retreived records for rows with a CdRecCheckType of "10" (DPS Criminal History) where the
   * DtRecCheckCompleted field is "12/31/4712"(max date) for the given IdPerson. If a row matching these criteria is
   * found, a flag will be populated indicating that an incomplete DPS Criminal History Check exists for that IdPerson.
   * <p/>
   * The service will also retrieve the CdPersonEthnicGroup, DtPersonBirth, IndPersonDobApprox, CdPersonSex, and
   * NmPersonPersonFull from the Person Table for the IdRecCheckPerson, as well as the NmPersonFull for all returned
   * IdRecCheckRequestors and the logged on user IdRecCheckRequestor.
   * <p/>
   * Lastly, this service will retrieve the NmNameFirst and NmNameLast from the Name Table for the IdRecCheckPerson.
   *
   * @param ccfc26si {@link CCFC26SI} object
   * @return {@link CCFC26SO} object
   */
  public CCFC26SO retrieveRecordsCheck(CCFC26SI ccfc26si);
}
