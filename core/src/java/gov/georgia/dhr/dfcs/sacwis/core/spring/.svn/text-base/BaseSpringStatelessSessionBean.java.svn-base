/**
 * Created on Jun 21, 2006 at 10:39:03 PM by Michael K. Werle
 */
package gov.georgia.dhr.dfcs.sacwis.core.spring;

import javax.ejb.CreateException;
import javax.ejb.SessionContext;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.ejb.support.AbstractStatelessSessionBean;

public abstract class BaseSpringStatelessSessionBean extends AbstractStatelessSessionBean
        implements SlsbFacade, SpringConstants {

  /**
   * Override default BeanFactoryLocator implementation
   *
   * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
   */
  @Override
  public void setSessionContext(SessionContext sessionContext) {
    super.setSessionContext(sessionContext);
    setBeanFactoryLocator(SJSASContextSingletonBeanFactoryLocator.getInstance(SERVICE_CONTEXT_SELECTOR));
    setBeanFactoryLocatorKey(SERVICE_BEAN_FACTORY);
  }

  public void initialize() {
    // Nothing is required; all we need to do is to force the container to call create().
  }

  /**
   * This is overriddent so we can correctly add the cause to the create exception.
   *
   * @throws CreateException
   */
  public void ejbCreate() throws CreateException {
    try {
      super.ejbCreate();
    } catch (Throwable t) {
      if (t instanceof CreateException) {
        throw (CreateException) t;
      }
      CreateException createException = new CreateException("Failed to create " + getClass().getName() + ".");
      createException.initCause(t);
      throw createException;
    }
  }

  @SuppressWarnings({"unchecked"})
  protected <T extends Object> T getService(Class<T> aClass) {
    BeanFactory beanFactory = getBeanFactory();
    String simpleName = aClass.getSimpleName();
    String beanName = Character.toLowerCase(simpleName.charAt(0)) + simpleName.substring(1);
    return (T) beanFactory.getBean(beanName);
  }
}