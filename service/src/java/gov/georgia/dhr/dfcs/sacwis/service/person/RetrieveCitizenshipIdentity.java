package gov.georgia.dhr.dfcs.sacwis.service.person;

import gov.georgia.dhr.dfcs.sacwis.structs.input.PersonCitizenshipIdentityRetrieveSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.PersonCitizenshipIdentitylRetrieveSO;

public interface RetrieveCitizenshipIdentity {
  /**
   * This service retrieves all information for the person citizenship and identity.
   * 
   * @param PersonCitizenshipIdentityRetrieveSI
   * @return A populated {@link PersonCitizenshipIdentityRetrieveSO} object.
   */
  public PersonCitizenshipIdentitylRetrieveSO retrieveCitizenshipIdentity(
                                                                   PersonCitizenshipIdentityRetrieveSI personCitizenshipIdentityRetrieveSI);
}
