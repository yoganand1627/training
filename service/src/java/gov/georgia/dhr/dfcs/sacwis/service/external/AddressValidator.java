/**
 * Created on July 27, 2006 by George Li
 */
package gov.georgia.dhr.dfcs.sacwis.service.external;

import gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;

public interface AddressValidator {

  /**
   * This function determines the validity of a supplied address.
   *
   * @param inAddr
   * @return
   */
  AddressValidatorSO validate(AddressValidatorSI inAddr);
  
  /**
   * This function determines the validity of a supplied address if the supplied address is valid that one address will be return
   * if the supplied address is not valid it will return the a list of potential addresses  
   *
   * @param inAddressValidatorSI address to validate
   * @return
   */
  AddressValidatorListSO validateAndOrFind(AddressValidatorSI inAddressValidatorSI);
}
