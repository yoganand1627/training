/**
 * Created on Jun 28, 2006 at 12:56:56 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.external;

import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.AddressValidatorSI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorListSO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.AddressValidatorSO;

import javax.ejb.CreateException;

import org.springframework.beans.factory.BeanFactory;

public class ExternalBean extends BaseSpringStatelessSessionBean implements External {
  private AddressValidator addressValidator;

  public AddressValidatorSO validate(AddressValidatorSI addressValidatorSI) {
    return addressValidator.validate(addressValidatorSI);
  }
  
  public AddressValidatorListSO validateAndOrFind(AddressValidatorSI inAddressValidatorSI) {
    return addressValidator.validateAndOrFind(inAddressValidatorSI);
  }

  protected void onEjbCreate() throws CreateException {
    BeanFactory beanFactory = getBeanFactory();
    addressValidator = getService(AddressValidator.class);
  }
}
