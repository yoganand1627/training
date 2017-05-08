package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentitySaveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitySaveSO;

public interface SaveCitizenshipIdentity {

  /**
   * This service saves all information for the person citizenship and identity.
   * 
   * @param PersonCitizenshipIdentitySaveSI
   * @return A populated {@link PersonCitizenshipIdentitySaveSI} object.
   */
  public PersonCitizenshipIdentitySaveSO saveCitizenshipIdentity(PersonCitizenshipIdentitySaveSI personCitizenshipIdentitySaveSI);

}
