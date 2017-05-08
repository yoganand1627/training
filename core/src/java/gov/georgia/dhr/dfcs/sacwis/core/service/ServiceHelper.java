/**
 * Created on Jun 30, 2005 at 3:32:13 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.service;

import gov.georgia.dhr.dfcs.sacwis.core.exception.ServiceException;
import gov.georgia.dhr.dfcs.sacwis.core.xml.XmlValueBean;

/*
* Date        User      Description
* --------    --------  --------------------------------------------------
* 07/24/2005  werlem    SIR 23728 - MPS Phase II Enhancement to add Contact List and Detail to MPS.
 */

/**
 * This class is designed to allow calling both services and service EJBs (stateless session beans) to be called
 * interchangeably, depending on whether they are being called from IMPACT or MPS.  This reduces subclassing.  However,
 * consequently, there is one version of this class in the main IMPACT tree and another in the MPS tree.
 */
public class ServiceHelper {
  public static String callService(String serviceName, XmlValueBean inputBean) throws ServiceException {
    throw new UnsupportedOperationException("ServiceHelper.callService() requires weblogic.");
  }

  public static XmlValueBean callService(String serviceName, XmlValueBean inputBean, Class outputClassType)
          throws ServiceException {
    throw new UnsupportedOperationException("ServiceHelper.callService() requires weblogic.");
  }
}
