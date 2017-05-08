/**
 * Created on Jun 5, 2006 at 7:23:18 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.service.spring;

import gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl;
import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;

public class ServiceAutoProxyCreator extends AbstractAutoProxyCreator {
  /** Identify as bean to proxy if the bean extends {@link gov.georgia.dhr.dfcs.sacwis.service.impl.BaseServiceImpl}. */
  protected Object[] getAdvicesAndAdvisorsForBean(Class beanClass, String beanName, TargetSource targetSource) {
    if (BaseServiceImpl.class.isAssignableFrom(beanClass)) {
      return PROXY_WITHOUT_ADDITIONAL_INTERCEPTORS;
    }
    return DO_NOT_PROXY;
  }
}
