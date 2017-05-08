/**
 * Created on Feb 5, 2007 at 4:56:53 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import org.springframework.aop.TargetSource;
import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;

public class EJBAutoProxyCreator extends AbstractAutoProxyCreator {
  protected Object[] getAdvicesAndAdvisorsForBean(Class beanClass, String beanName, TargetSource targetSource) {
    if (AdvisedLocalStatelessSessionProxyFactoryBean.class.isAssignableFrom(beanClass)) {
      return PROXY_WITHOUT_ADDITIONAL_INTERCEPTORS;
    }
    return DO_NOT_PROXY;
  }
}