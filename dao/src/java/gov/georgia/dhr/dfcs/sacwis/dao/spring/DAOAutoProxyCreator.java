/**
 * Created on Feb 5, 2007 at 4:56:53 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.dao.spring;

import gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;

public class DAOAutoProxyCreator extends AbstractAutoProxyCreator {
  /** Identify as bean to proxy if the bean extends {@link gov.georgia.dhr.dfcs.sacwis.dao.impl.BaseDAOImpl}. */
  protected Object[] getAdvicesAndAdvisorsForBean(Class beanClass, String beanName, TargetSource targetSource) {
    if (BaseDAOImpl.class.isAssignableFrom(beanClass)) {
      return PROXY_WITHOUT_ADDITIONAL_INTERCEPTORS;
    }
    return DO_NOT_PROXY;
  }
}
