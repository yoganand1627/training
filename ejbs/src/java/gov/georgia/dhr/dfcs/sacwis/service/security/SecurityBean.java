/**
 * Created on Jun 28, 2006 at 12:56:56 AM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.security;

import javax.ejb.CreateException;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.spring.BaseSpringStatelessSessionBean;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC12SI;
import gov.georgia.dhr.dfcs.sacwis.structs.input.CARC13SI;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC12SO;
import gov.georgia.dhr.dfcs.sacwis.structs.output.CARC13SO;
import org.springframework.beans.factory.BeanFactory;

public class SecurityBean extends BaseSpringStatelessSessionBean implements Security {
  private RetrieveSecurityClass retrieveSecurityClass;
  private SaveSecurityClass saveSecurityClass;

  public CARC12SO retrieveSecurityClass(CARC12SI carc12si) {
    return retrieveSecurityClass.retrieveSecurityClass(carc12si);
  }

  public CARC13SO saveSecurityClass(CARC13SI carc13si) throws ServiceException {
    return saveSecurityClass.saveSecurityClass(carc13si);
  }

  protected void onEjbCreate() throws CreateException {
    BeanFactory beanFactory = getBeanFactory();
    retrieveSecurityClass = getService(RetrieveSecurityClass.class);
    saveSecurityClass = getService(SaveSecurityClass.class);
  }
}
