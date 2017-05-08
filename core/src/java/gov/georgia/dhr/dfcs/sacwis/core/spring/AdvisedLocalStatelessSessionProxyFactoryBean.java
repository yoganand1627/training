/**
 * Created on Jun 27, 2006 at 5:20:36 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;
import java.util.List;

import javax.ejb.EJBLocalObject;
import javax.naming.NamingException;

import com.jamonapi.Monitor;
import com.jamonapi.MonitorFactory;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.BeanClassLoaderAware;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.ejb.access.LocalStatelessSessionProxyFactoryBean;

public class AdvisedLocalStatelessSessionProxyFactoryBean extends LocalStatelessSessionProxyFactoryBean
        implements FactoryBean, BeanClassLoaderAware {

  /**
   * A list of advice used to modify the EJB calls.
   */
  private List<Advice> advice;

  public void setAdvice(List<Advice> advice) {
    this.advice = advice;
  }

  /**
   * Override the creation of the session bean instances in order to proxy with the advice list.
   *
   * @return
   * @throws NamingException
   * @throws InvocationTargetException
   */
  @Override
  protected EJBLocalObject newSessionBeanInstance() throws NamingException, InvocationTargetException {
    EJBLocalObject ejbLocalObject = super.newSessionBeanInstance();
    ProxyFactory proxyFactory = new ProxyFactory(ejbLocalObject);
    for (Iterator<Advice> it = advice.iterator(); it.hasNext();) {
      proxyFactory.addAdvice(it.next());
    }
    return (EJBLocalObject) proxyFactory.getProxy();
  }

  /**
   * Monitor each EJB call.
   *
   * @param invocation
   * @return
   * @throws Throwable
   */
  @Override
  @SuppressWarnings({"ProhibitedExceptionThrown", "ProhibitedExceptionDeclared"})
  public Object invoke(MethodInvocation invocation) throws Throwable {
    // The following string is a good balance between clarity and speed; it does not differentiate between overloaded
    //   methods because doing so would require too much reflection.
    Monitor monitor = MonitorFactory.start(getBusinessInterface().toString() + "#" + invocation.getMethod().getName());
    try {
      return super.invoke(invocation);
    } finally {
      monitor.stop();
    }
  }
}
